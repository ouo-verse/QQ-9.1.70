package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* loaded from: classes2.dex */
public final class HlsMediaPeriod implements MediaPeriod, HlsSampleStreamWrapper.Callback, HlsPlaylistTracker.PlaylistEventListener {
    private final Allocator allocator;
    private final boolean allowChunklessPreparation;
    private MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private final HlsExtractorFactory extractorFactory;
    private final int minLoadableRetryCount;
    private int pendingPrepareCount;
    private final HlsPlaylistTracker playlistTracker;
    private TrackGroupArray trackGroups;
    private final IdentityHashMap<SampleStream, Integer> streamWrapperIndices = new IdentityHashMap<>();
    private final TimestampAdjusterProvider timestampAdjusterProvider = new TimestampAdjusterProvider();
    private final Handler continueLoadingHandler = new Handler();
    private HlsSampleStreamWrapper[] sampleStreamWrappers = new HlsSampleStreamWrapper[0];
    private HlsSampleStreamWrapper[] enabledSampleStreamWrappers = new HlsSampleStreamWrapper[0];

    public HlsMediaPeriod(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, HlsDataSourceFactory hlsDataSourceFactory, int i3, MediaSourceEventListener.EventDispatcher eventDispatcher, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, boolean z16) {
        this.extractorFactory = hlsExtractorFactory;
        this.playlistTracker = hlsPlaylistTracker;
        this.dataSourceFactory = hlsDataSourceFactory;
        this.minLoadableRetryCount = i3;
        this.eventDispatcher = eventDispatcher;
        this.allocator = allocator;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.allowChunklessPreparation = z16;
    }

    private void buildAndPrepareMainSampleStreamWrapper(HlsMasterPlaylist hlsMasterPlaylist, long j3) {
        ArrayList arrayList;
        boolean z16;
        boolean z17;
        ArrayList arrayList2 = new ArrayList(hlsMasterPlaylist.variants);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            HlsMasterPlaylist.HlsUrl hlsUrl = (HlsMasterPlaylist.HlsUrl) arrayList2.get(i3);
            Format format = hlsUrl.format;
            if (format.height <= 0 && Util.getCodecsOfType(format.codecs, 2) == null) {
                if (Util.getCodecsOfType(format.codecs, 1) != null) {
                    arrayList4.add(hlsUrl);
                }
            } else {
                arrayList3.add(hlsUrl);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList = arrayList3;
        } else {
            if (arrayList4.size() < arrayList2.size()) {
                arrayList2.removeAll(arrayList4);
            }
            arrayList = arrayList2;
        }
        Assertions.checkArgument(!arrayList.isEmpty());
        HlsMasterPlaylist.HlsUrl[] hlsUrlArr = (HlsMasterPlaylist.HlsUrl[]) arrayList.toArray(new HlsMasterPlaylist.HlsUrl[0]);
        String str = hlsUrlArr[0].format.codecs;
        HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(0, hlsUrlArr, hlsMasterPlaylist.muxedAudioFormat, hlsMasterPlaylist.muxedCaptionFormats, j3);
        this.sampleStreamWrappers[0] = buildSampleStreamWrapper;
        if (this.allowChunklessPreparation && str != null) {
            if (Util.getCodecsOfType(str, 2) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (Util.getCodecsOfType(str, 1) != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            ArrayList arrayList5 = new ArrayList();
            if (z16) {
                int size = arrayList.size();
                Format[] formatArr = new Format[size];
                for (int i16 = 0; i16 < size; i16++) {
                    formatArr[i16] = deriveVideoFormat(hlsUrlArr[i16].format);
                }
                arrayList5.add(new TrackGroup(formatArr));
                if (z17 && (hlsMasterPlaylist.muxedAudioFormat != null || hlsMasterPlaylist.audios.isEmpty())) {
                    arrayList5.add(new TrackGroup(deriveMuxedAudioFormat(hlsUrlArr[0].format, hlsMasterPlaylist.muxedAudioFormat, -1)));
                }
                List<Format> list = hlsMasterPlaylist.muxedCaptionFormats;
                if (list != null) {
                    for (int i17 = 0; i17 < list.size(); i17++) {
                        arrayList5.add(new TrackGroup(list.get(i17)));
                    }
                }
            } else if (z17) {
                int size2 = arrayList.size();
                Format[] formatArr2 = new Format[size2];
                for (int i18 = 0; i18 < size2; i18++) {
                    Format format2 = hlsUrlArr[i18].format;
                    formatArr2[i18] = deriveMuxedAudioFormat(format2, hlsMasterPlaylist.muxedAudioFormat, format2.bitrate);
                }
                arrayList5.add(new TrackGroup(formatArr2));
            } else {
                throw new IllegalArgumentException("Unexpected codecs attribute: " + str);
            }
            buildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new TrackGroupArray((TrackGroup[]) arrayList5.toArray(new TrackGroup[0])), 0);
            return;
        }
        buildSampleStreamWrapper.setIsTimestampMaster(true);
        buildSampleStreamWrapper.continuePreparing();
    }

    private void buildAndPrepareSampleStreamWrappers(long j3) {
        HlsMasterPlaylist masterPlaylist = this.playlistTracker.getMasterPlaylist();
        List<HlsMasterPlaylist.HlsUrl> list = masterPlaylist.audios;
        List<HlsMasterPlaylist.HlsUrl> list2 = masterPlaylist.subtitles;
        int size = list.size() + 1 + list2.size();
        this.sampleStreamWrappers = new HlsSampleStreamWrapper[size];
        this.pendingPrepareCount = size;
        buildAndPrepareMainSampleStreamWrapper(masterPlaylist, j3);
        char c16 = 0;
        int i3 = 1;
        int i16 = 0;
        while (i16 < list.size()) {
            HlsMasterPlaylist.HlsUrl hlsUrl = list.get(i16);
            HlsMasterPlaylist.HlsUrl[] hlsUrlArr = new HlsMasterPlaylist.HlsUrl[1];
            hlsUrlArr[c16] = hlsUrl;
            HlsSampleStreamWrapper buildSampleStreamWrapper = buildSampleStreamWrapper(1, hlsUrlArr, null, Collections.emptyList(), j3);
            int i17 = i3 + 1;
            this.sampleStreamWrappers[i3] = buildSampleStreamWrapper;
            Format format = hlsUrl.format;
            if (this.allowChunklessPreparation && format.codecs != null) {
                buildSampleStreamWrapper.prepareWithMasterPlaylistInfo(new TrackGroupArray(new TrackGroup(hlsUrl.format)), 0);
            } else {
                buildSampleStreamWrapper.continuePreparing();
            }
            i16++;
            i3 = i17;
            c16 = 0;
        }
        int i18 = 0;
        while (i18 < list2.size()) {
            HlsMasterPlaylist.HlsUrl hlsUrl2 = list2.get(i18);
            HlsSampleStreamWrapper buildSampleStreamWrapper2 = buildSampleStreamWrapper(3, new HlsMasterPlaylist.HlsUrl[]{hlsUrl2}, null, Collections.emptyList(), j3);
            this.sampleStreamWrappers[i3] = buildSampleStreamWrapper2;
            buildSampleStreamWrapper2.prepareWithMasterPlaylistInfo(new TrackGroupArray(new TrackGroup(hlsUrl2.format)), 0);
            i18++;
            i3++;
        }
        this.enabledSampleStreamWrappers = this.sampleStreamWrappers;
    }

    private HlsSampleStreamWrapper buildSampleStreamWrapper(int i3, HlsMasterPlaylist.HlsUrl[] hlsUrlArr, Format format, List<Format> list, long j3) {
        return new HlsSampleStreamWrapper(i3, this, new HlsChunkSource(this.extractorFactory, this.playlistTracker, hlsUrlArr, this.dataSourceFactory, this.timestampAdjusterProvider, list), this.allocator, j3, format, this.minLoadableRetryCount, this.eventDispatcher);
    }

    private void continuePreparingOrLoading() {
        if (this.trackGroups != null) {
            this.callback.onContinueLoadingRequested(this);
            return;
        }
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.continuePreparing();
        }
    }

    private static Format deriveMuxedAudioFormat(Format format, Format format2, int i3) {
        String codecsOfType;
        int i16;
        int i17;
        String str;
        if (format2 != null) {
            codecsOfType = format2.codecs;
            i16 = format2.channelCount;
            i17 = format2.selectionFlags;
            str = format2.language;
        } else {
            codecsOfType = Util.getCodecsOfType(format.codecs, 1);
            i16 = -1;
            i17 = 0;
            str = null;
        }
        String str2 = codecsOfType;
        int i18 = i16;
        int i19 = i17;
        String mediaMimeType = MimeTypes.getMediaMimeType(str2);
        return Format.createAudioSampleFormat(format.f32936id, mediaMimeType, str2, i3, -1, i18, -1, null, null, i19, str);
    }

    private static Format deriveVideoFormat(Format format) {
        String codecsOfType = Util.getCodecsOfType(format.codecs, 2);
        return Format.createVideoSampleFormat(format.f32936id, MimeTypes.getMediaMimeType(codecsOfType), codecsOfType, format.bitrate, -1, format.width, format.height, format.frameRate, null, null);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        return this.compositeSequenceableLoader.continueLoading(j3);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j3, boolean z16) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.enabledSampleStreamWrappers) {
            hlsSampleStreamWrapper.discardBuffer(j3, z16);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.maybeThrowPrepareError();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j3) {
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.onPlaylistBlacklisted(hlsUrl, j3);
        }
        continuePreparingOrLoading();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PlaylistEventListener
    public void onPlaylistChanged() {
        continuePreparingOrLoading();
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl hlsUrl) {
        this.playlistTracker.refreshPlaylist(hlsUrl);
    }

    @Override // com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback
    public void onPrepared() {
        int i3 = this.pendingPrepareCount - 1;
        this.pendingPrepareCount = i3;
        if (i3 > 0) {
            return;
        }
        int i16 = 0;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            i16 += hlsSampleStreamWrapper.getTrackGroups().length;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i16];
        int i17 = 0;
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper2 : this.sampleStreamWrappers) {
            int i18 = hlsSampleStreamWrapper2.getTrackGroups().length;
            int i19 = 0;
            while (i19 < i18) {
                trackGroupArr[i17] = hlsSampleStreamWrapper2.getTrackGroups().get(i19);
                i19++;
                i17++;
            }
        }
        this.trackGroups = new TrackGroupArray(trackGroupArr);
        this.callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j3) {
        this.callback = callback;
        this.playlistTracker.addListener(this);
        buildAndPrepareSampleStreamWrappers(j3);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
        this.compositeSequenceableLoader.reevaluateBuffer(j3);
    }

    public void release() {
        this.playlistTracker.removeListener(this);
        this.continueLoadingHandler.removeCallbacksAndMessages(null);
        for (HlsSampleStreamWrapper hlsSampleStreamWrapper : this.sampleStreamWrappers) {
            hlsSampleStreamWrapper.release();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j3) {
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.enabledSampleStreamWrappers;
        if (hlsSampleStreamWrapperArr.length > 0) {
            boolean seekToUs = hlsSampleStreamWrapperArr[0].seekToUs(j3, false);
            int i3 = 1;
            while (true) {
                HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = this.enabledSampleStreamWrappers;
                if (i3 >= hlsSampleStreamWrapperArr2.length) {
                    break;
                }
                hlsSampleStreamWrapperArr2[i3].seekToUs(j3, seekToUs);
                i3++;
            }
            if (seekToUs) {
                this.timestampAdjusterProvider.reset();
            }
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        boolean z16;
        SampleStream sampleStream;
        int intValue;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[trackSelectionArr.length];
        int[] iArr2 = new int[trackSelectionArr.length];
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            SampleStream sampleStream2 = sampleStreamArr2[i3];
            if (sampleStream2 == null) {
                intValue = -1;
            } else {
                intValue = this.streamWrapperIndices.get(sampleStream2).intValue();
            }
            iArr[i3] = intValue;
            iArr2[i3] = -1;
            TrackSelection trackSelection = trackSelectionArr[i3];
            if (trackSelection != null) {
                TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i16 = 0;
                while (true) {
                    HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr = this.sampleStreamWrappers;
                    if (i16 >= hlsSampleStreamWrapperArr.length) {
                        break;
                    }
                    if (hlsSampleStreamWrapperArr[i16].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i3] = i16;
                        break;
                    }
                    i16++;
                }
            }
        }
        this.streamWrapperIndices.clear();
        int length = trackSelectionArr.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[trackSelectionArr.length];
        TrackSelection[] trackSelectionArr2 = new TrackSelection[trackSelectionArr.length];
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr2 = new HlsSampleStreamWrapper[this.sampleStreamWrappers.length];
        int i17 = 0;
        int i18 = 0;
        boolean z17 = false;
        while (i18 < this.sampleStreamWrappers.length) {
            for (int i19 = 0; i19 < trackSelectionArr.length; i19++) {
                TrackSelection trackSelection2 = null;
                if (iArr[i19] == i18) {
                    sampleStream = sampleStreamArr2[i19];
                } else {
                    sampleStream = null;
                }
                sampleStreamArr4[i19] = sampleStream;
                if (iArr2[i19] == i18) {
                    trackSelection2 = trackSelectionArr[i19];
                }
                trackSelectionArr2[i19] = trackSelection2;
            }
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrappers[i18];
            int i26 = i17;
            int i27 = length;
            int i28 = i18;
            TrackSelection[] trackSelectionArr3 = trackSelectionArr2;
            HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr3 = hlsSampleStreamWrapperArr2;
            boolean selectTracks = hlsSampleStreamWrapper.selectTracks(trackSelectionArr2, zArr, sampleStreamArr4, zArr2, j3, z17);
            int i29 = 0;
            boolean z18 = false;
            while (true) {
                boolean z19 = true;
                if (i29 >= trackSelectionArr.length) {
                    break;
                }
                if (iArr2[i29] == i28) {
                    if (sampleStreamArr4[i29] != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Assertions.checkState(z16);
                    sampleStreamArr3[i29] = sampleStreamArr4[i29];
                    this.streamWrapperIndices.put(sampleStreamArr4[i29], Integer.valueOf(i28));
                    z18 = true;
                } else if (iArr[i29] == i28) {
                    if (sampleStreamArr4[i29] != null) {
                        z19 = false;
                    }
                    Assertions.checkState(z19);
                }
                i29++;
            }
            if (z18) {
                hlsSampleStreamWrapperArr3[i26] = hlsSampleStreamWrapper;
                i17 = i26 + 1;
                if (i26 == 0) {
                    hlsSampleStreamWrapper.setIsTimestampMaster(true);
                    if (!selectTracks) {
                        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr4 = this.enabledSampleStreamWrappers;
                        if (hlsSampleStreamWrapperArr4.length != 0) {
                            if (hlsSampleStreamWrapper == hlsSampleStreamWrapperArr4[0]) {
                            }
                            this.timestampAdjusterProvider.reset();
                            z17 = true;
                        }
                    }
                    this.timestampAdjusterProvider.reset();
                    z17 = true;
                } else {
                    hlsSampleStreamWrapper.setIsTimestampMaster(false);
                }
            } else {
                i17 = i26;
            }
            i18 = i28 + 1;
            sampleStreamArr2 = sampleStreamArr;
            hlsSampleStreamWrapperArr2 = hlsSampleStreamWrapperArr3;
            length = i27;
            trackSelectionArr2 = trackSelectionArr3;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        HlsSampleStreamWrapper[] hlsSampleStreamWrapperArr5 = (HlsSampleStreamWrapper[]) Arrays.copyOf(hlsSampleStreamWrapperArr2, i17);
        this.enabledSampleStreamWrappers = hlsSampleStreamWrapperArr5;
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(hlsSampleStreamWrapperArr5);
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        if (this.trackGroups == null) {
            return;
        }
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        return j3;
    }
}
