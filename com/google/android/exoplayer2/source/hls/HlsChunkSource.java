package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
class HlsChunkSource {
    private final DataSource encryptionDataSource;
    private byte[] encryptionIv;
    private String encryptionIvString;
    private byte[] encryptionKey;
    private Uri encryptionKeyUri;
    private HlsMasterPlaylist.HlsUrl expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private long liveEdgeTimeUs = -9223372036854775807L;
    private final DataSource mediaDataSource;
    private final List<Format> muxedCaptionFormats;
    private final HlsPlaylistTracker playlistTracker;
    private byte[] scratchSpace;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;
    private final HlsMasterPlaylist.HlsUrl[] variants;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class EncryptionKeyChunk extends DataChunk {

        /* renamed from: iv, reason: collision with root package name */
        public final String f32948iv;
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i3, Object obj, byte[] bArr, String str) {
            super(dataSource, dataSpec, 3, format, i3, obj, bArr);
            this.f32948iv = str;
        }

        @Override // com.google.android.exoplayer2.source.chunk.DataChunk
        protected void consume(byte[] bArr, int i3) throws IOException {
            this.result = Arrays.copyOf(bArr, i3);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public HlsMasterPlaylist.HlsUrl playlist;

        public HlsChunkHolder() {
            clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlist = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.selectedIndex = indexOf(trackGroup.getFormat(0));
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long j3, long j16, long j17) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (!isBlacklisted(this.selectedIndex, elapsedRealtime)) {
                return;
            }
            for (int i3 = this.length - 1; i3 >= 0; i3--) {
                if (!isBlacklisted(i3, elapsedRealtime)) {
                    this.selectedIndex = i3;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, HlsDataSourceFactory hlsDataSourceFactory, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> list) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.variants = hlsUrlArr;
        this.timestampAdjusterProvider = timestampAdjusterProvider;
        this.muxedCaptionFormats = list;
        Format[] formatArr = new Format[hlsUrlArr.length];
        int[] iArr = new int[hlsUrlArr.length];
        for (int i3 = 0; i3 < hlsUrlArr.length; i3++) {
            formatArr[i3] = hlsUrlArr[i3].format;
            iArr[i3] = i3;
        }
        this.mediaDataSource = hlsDataSourceFactory.createDataSource(1);
        this.encryptionDataSource = hlsDataSourceFactory.createDataSource(3);
        TrackGroup trackGroup = new TrackGroup(formatArr);
        this.trackGroup = trackGroup;
        this.trackSelection = new InitializationTrackSelection(trackGroup, iArr);
    }

    private void clearEncryptionData() {
        this.encryptionKeyUri = null;
        this.encryptionKey = null;
        this.encryptionIvString = null;
        this.encryptionIv = null;
    }

    private EncryptionKeyChunk newEncryptionKeyChunk(Uri uri, String str, int i3, int i16, Object obj) {
        return new EncryptionKeyChunk(this.encryptionDataSource, new DataSpec(uri, 0L, -1L, null, 1), this.variants[i3].format, i16, obj, this.scratchSpace, str);
    }

    private long resolveTimeToLiveEdgeUs(long j3) {
        boolean z16;
        long j16 = this.liveEdgeTimeUs;
        if (j16 != -9223372036854775807L) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return -9223372036854775807L;
        }
        return j16 - j3;
    }

    private void setEncryptionData(Uri uri, String str, byte[] bArr) {
        String str2;
        int i3;
        if (Util.toLowerInvariant(str).startsWith(RelationNTPushServiceImpl.PRE_HEX_STRING)) {
            str2 = str.substring(2);
        } else {
            str2 = str;
        }
        byte[] byteArray = new BigInteger(str2, 16).toByteArray();
        byte[] bArr2 = new byte[16];
        if (byteArray.length > 16) {
            i3 = byteArray.length - 16;
        } else {
            i3 = 0;
        }
        System.arraycopy(byteArray, i3, bArr2, (16 - byteArray.length) + i3, byteArray.length - i3);
        this.encryptionKeyUri = uri;
        this.encryptionKey = bArr;
        this.encryptionIvString = str;
        this.encryptionIv = bArr2;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist) {
        long endTimeUs;
        if (hlsMediaPlaylist.hasEndTag) {
            endTimeUs = -9223372036854775807L;
        } else {
            endTimeUs = hlsMediaPlaylist.getEndTimeUs();
        }
        this.liveEdgeTimeUs = endTimeUs;
    }

    public void getNextChunk(HlsMediaChunk hlsMediaChunk, long j3, long j16, HlsChunkHolder hlsChunkHolder) {
        int indexOf;
        boolean z16;
        long j17;
        long j18;
        if (hlsMediaChunk == null) {
            indexOf = -1;
        } else {
            indexOf = this.trackGroup.indexOf(hlsMediaChunk.trackFormat);
        }
        DataSpec dataSpec = null;
        this.expectedPlaylistUrl = null;
        long j19 = j16 - j3;
        long resolveTimeToLiveEdgeUs = resolveTimeToLiveEdgeUs(j3);
        if (hlsMediaChunk != null && !this.independentSegments) {
            long durationUs = hlsMediaChunk.getDurationUs();
            j19 = Math.max(0L, j19 - durationUs);
            if (resolveTimeToLiveEdgeUs != -9223372036854775807L) {
                resolveTimeToLiveEdgeUs = Math.max(0L, resolveTimeToLiveEdgeUs - durationUs);
            }
        }
        this.trackSelection.updateSelectedTrack(j3, j19, resolveTimeToLiveEdgeUs);
        int selectedIndexInTrackGroup = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z17 = false;
        if (indexOf != selectedIndexInTrackGroup) {
            z16 = true;
        } else {
            z16 = false;
        }
        HlsMasterPlaylist.HlsUrl hlsUrl = this.variants[selectedIndexInTrackGroup];
        if (!this.playlistTracker.isSnapshotValid(hlsUrl)) {
            hlsChunkHolder.playlist = hlsUrl;
            this.expectedPlaylistUrl = hlsUrl;
            return;
        }
        HlsMediaPlaylist playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl);
        this.independentSegments = playlistSnapshot.hasIndependentSegmentsTag;
        updateLiveEdgeTimeUs(playlistSnapshot);
        if (hlsMediaChunk != null && !z16) {
            j18 = hlsMediaChunk.getNextChunkIndex();
        } else {
            if (hlsMediaChunk != null && !this.independentSegments) {
                j17 = hlsMediaChunk.startTimeUs;
            } else {
                j17 = j16;
            }
            if (!playlistSnapshot.hasEndTag && j17 >= playlistSnapshot.getEndTimeUs()) {
                j18 = playlistSnapshot.mediaSequence + playlistSnapshot.segments.size();
            } else {
                List<HlsMediaPlaylist.Segment> list = playlistSnapshot.segments;
                Long valueOf = Long.valueOf(j17);
                if (!this.playlistTracker.isLive() || hlsMediaChunk == null) {
                    z17 = true;
                }
                long binarySearchFloor = Util.binarySearchFloor((List<? extends Comparable<? super Long>>) list, valueOf, true, z17);
                long j26 = playlistSnapshot.mediaSequence;
                long j27 = binarySearchFloor + j26;
                if (j27 < j26 && hlsMediaChunk != null) {
                    hlsUrl = this.variants[indexOf];
                    playlistSnapshot = this.playlistTracker.getPlaylistSnapshot(hlsUrl);
                    selectedIndexInTrackGroup = indexOf;
                    j18 = hlsMediaChunk.getNextChunkIndex();
                } else {
                    j18 = j27;
                }
            }
        }
        long j28 = j18;
        HlsMasterPlaylist.HlsUrl hlsUrl2 = hlsUrl;
        int i3 = selectedIndexInTrackGroup;
        HlsMediaPlaylist hlsMediaPlaylist = playlistSnapshot;
        long j29 = hlsMediaPlaylist.mediaSequence;
        if (j28 < j29) {
            this.fatalError = new BehindLiveWindowException();
            return;
        }
        int i16 = (int) (j28 - j29);
        if (i16 >= hlsMediaPlaylist.segments.size()) {
            if (hlsMediaPlaylist.hasEndTag) {
                hlsChunkHolder.endOfStream = true;
                return;
            } else {
                hlsChunkHolder.playlist = hlsUrl2;
                this.expectedPlaylistUrl = hlsUrl2;
                return;
            }
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.segments.get(i16);
        String str = segment.fullSegmentEncryptionKeyUri;
        if (str != null) {
            Uri resolveToUri = UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, str);
            if (!resolveToUri.equals(this.encryptionKeyUri)) {
                hlsChunkHolder.chunk = newEncryptionKeyChunk(resolveToUri, segment.encryptionIV, i3, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData());
                return;
            } else if (!Util.areEqual(segment.encryptionIV, this.encryptionIvString)) {
                setEncryptionData(resolveToUri, segment.encryptionIV, this.encryptionKey);
            }
        } else {
            clearEncryptionData();
        }
        HlsMediaPlaylist.Segment segment2 = hlsMediaPlaylist.initializationSegment;
        if (segment2 != null) {
            dataSpec = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment2.url), segment2.byterangeOffset, segment2.byterangeLength, null);
        }
        long initialStartTimeUs = (hlsMediaPlaylist.startTimeUs - this.playlistTracker.getInitialStartTimeUs()) + segment.relativeStartTimeUs;
        int i17 = hlsMediaPlaylist.discontinuitySequence + segment.relativeDiscontinuitySequence;
        TimestampAdjuster adjuster = this.timestampAdjusterProvider.getAdjuster(i17);
        hlsChunkHolder.chunk = new HlsMediaChunk(this.extractorFactory, this.mediaDataSource, new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist.baseUri, segment.url), segment.byterangeOffset, segment.byterangeLength, null), dataSpec, hlsUrl2, this.muxedCaptionFormats, this.trackSelection.getSelectionReason(), this.trackSelection.getSelectionData(), initialStartTimeUs, initialStartTimeUs + segment.durationUs, j28, i17, segment.hasGapTag, this.isTimestampMaster, adjuster, hlsMediaChunk, hlsMediaPlaylist.drmInitData, this.encryptionKey, this.encryptionIv);
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public void maybeThrowError() throws IOException {
        IOException iOException = this.fatalError;
        if (iOException == null) {
            HlsMasterPlaylist.HlsUrl hlsUrl = this.expectedPlaylistUrl;
            if (hlsUrl != null) {
                this.playlistTracker.maybeThrowPlaylistRefreshError(hlsUrl);
                return;
            }
            return;
        }
        throw iOException;
    }

    public void onChunkLoadCompleted(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.scratchSpace = encryptionKeyChunk.getDataHolder();
            setEncryptionData(encryptionKeyChunk.dataSpec.uri, encryptionKeyChunk.f32948iv, encryptionKeyChunk.getResult());
        }
    }

    public boolean onChunkLoadError(Chunk chunk, boolean z16, IOException iOException) {
        if (z16) {
            TrackSelection trackSelection = this.trackSelection;
            if (ChunkedTrackBlacklistUtil.maybeBlacklistTrack(trackSelection, trackSelection.indexOf(this.trackGroup.indexOf(chunk.trackFormat)), iOException)) {
                return true;
            }
        }
        return false;
    }

    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j3) {
        int indexOf;
        int indexOf2 = this.trackGroup.indexOf(hlsUrl.format);
        if (indexOf2 != -1 && (indexOf = this.trackSelection.indexOf(indexOf2)) != -1) {
            this.trackSelection.blacklist(indexOf, j3);
        }
    }

    public void reset() {
        this.fatalError = null;
    }

    public void selectTracks(TrackSelection trackSelection) {
        this.trackSelection = trackSelection;
    }

    public void setIsTimestampMaster(boolean z16) {
        this.isTimestampMaster = z16;
    }
}
