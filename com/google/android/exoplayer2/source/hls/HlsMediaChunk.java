package com.google.android.exoplayer2.source.hls;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class HlsMediaChunk extends MediaChunk {
    private static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    private static final AtomicInteger uidSource = new AtomicInteger();
    private int bytesLoaded;
    public final int discontinuitySequenceNumber;
    private final Extractor extractor;
    private final boolean hasGapTag;
    public final HlsMasterPlaylist.HlsUrl hlsUrl;
    private final ParsableByteArray id3Data;
    private final Id3Decoder id3Decoder;
    private boolean id3TimestampPeeked;
    private final DataSource initDataSource;
    private final DataSpec initDataSpec;
    private boolean initLoadCompleted;
    private int initSegmentBytesLoaded;
    private final boolean isEncrypted;
    private final boolean isMasterTimestampSource;
    private final boolean isPackedAudioExtractor;
    private volatile boolean loadCanceled;
    private volatile boolean loadCompleted;
    private HlsSampleStreamWrapper output;
    private final boolean reusingExtractor;
    private final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;

    public HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory, DataSource dataSource, DataSpec dataSpec, DataSpec dataSpec2, HlsMasterPlaylist.HlsUrl hlsUrl, List<Format> list, int i3, Object obj, long j3, long j16, long j17, int i16, boolean z16, boolean z17, TimestampAdjuster timestampAdjuster, HlsMediaChunk hlsMediaChunk, DrmInitData drmInitData, byte[] bArr, byte[] bArr2) {
        super(buildDataSource(dataSource, bArr, bArr2), dataSpec, hlsUrl.format, i3, obj, j3, j16, j17);
        DataSpec dataSpec3;
        Extractor extractor;
        ParsableByteArray parsableByteArray;
        this.discontinuitySequenceNumber = i16;
        this.initDataSpec = dataSpec2;
        this.hlsUrl = hlsUrl;
        this.isMasterTimestampSource = z17;
        this.timestampAdjuster = timestampAdjuster;
        this.isEncrypted = this.dataSource instanceof Aes128DataSource;
        this.hasGapTag = z16;
        if (hlsMediaChunk != null) {
            boolean z18 = hlsMediaChunk.hlsUrl != hlsUrl;
            this.shouldSpliceIn = z18;
            extractor = (hlsMediaChunk.discontinuitySequenceNumber != i16 || z18) ? null : hlsMediaChunk.extractor;
            dataSpec3 = dataSpec;
        } else {
            this.shouldSpliceIn = false;
            dataSpec3 = dataSpec;
            extractor = null;
        }
        Pair<Extractor, Boolean> createExtractor = hlsExtractorFactory.createExtractor(extractor, dataSpec3.uri, this.trackFormat, list, drmInitData, timestampAdjuster);
        Extractor extractor2 = (Extractor) createExtractor.first;
        this.extractor = extractor2;
        boolean booleanValue = ((Boolean) createExtractor.second).booleanValue();
        this.isPackedAudioExtractor = booleanValue;
        boolean z19 = extractor2 == extractor;
        this.reusingExtractor = z19;
        this.initLoadCompleted = z19 && dataSpec2 != null;
        if (!booleanValue) {
            this.id3Decoder = null;
            this.id3Data = null;
        } else if (hlsMediaChunk != null && (parsableByteArray = hlsMediaChunk.id3Data) != null) {
            this.id3Decoder = hlsMediaChunk.id3Decoder;
            this.id3Data = parsableByteArray;
        } else {
            this.id3Decoder = new Id3Decoder();
            this.id3Data = new ParsableByteArray(10);
        }
        this.initDataSource = dataSource;
        this.uid = uidSource.getAndIncrement();
    }

    private static DataSource buildDataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            return new Aes128DataSource(dataSource, bArr, bArr2);
        }
        return dataSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f A[Catch: all -> 0x00a0, TryCatch #1 {all -> 0x00a0, blocks: (B:10:0x0038, B:12:0x004a, B:14:0x004e, B:16:0x005f, B:17:0x0068, B:18:0x0066, B:20:0x006d, B:28:0x008e, B:34:0x0081, B:35:0x008d, B:24:0x0074, B:26:0x0078), top: B:9:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[Catch: all -> 0x00a0, TryCatch #1 {all -> 0x00a0, blocks: (B:10:0x0038, B:12:0x004a, B:14:0x004e, B:16:0x005f, B:17:0x0068, B:18:0x0066, B:20:0x006d, B:28:0x008e, B:34:0x0081, B:35:0x008d, B:24:0x0074, B:26:0x0078), top: B:9:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[Catch: all -> 0x00a0, TRY_LEAVE, TryCatch #1 {all -> 0x00a0, blocks: (B:10:0x0038, B:12:0x004a, B:14:0x004e, B:16:0x005f, B:17:0x0068, B:18:0x0066, B:20:0x006d, B:28:0x008e, B:34:0x0081, B:35:0x008d, B:24:0x0074, B:26:0x0078), top: B:9:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadMedia() throws IOException, InterruptedException {
        DataSpec subrange;
        boolean z16;
        DefaultExtractorInput defaultExtractorInput;
        long peekId3PrivTimestamp;
        long j3;
        int i3 = 0;
        try {
            if (this.isEncrypted) {
                subrange = this.dataSpec;
                if (this.bytesLoaded != 0) {
                    z16 = true;
                    if (this.isMasterTimestampSource) {
                        this.timestampAdjuster.waitUntilInitialized();
                    } else if (this.timestampAdjuster.getFirstSampleTimestampUs() == Long.MAX_VALUE) {
                        this.timestampAdjuster.setFirstSampleTimestampUs(this.startTimeUs);
                    }
                    DataSource dataSource = this.dataSource;
                    defaultExtractorInput = new DefaultExtractorInput(dataSource, subrange.absoluteStreamPosition, dataSource.open(subrange));
                    if (this.isPackedAudioExtractor && !this.id3TimestampPeeked) {
                        peekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput);
                        this.id3TimestampPeeked = true;
                        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.output;
                        if (peekId3PrivTimestamp == -9223372036854775807L) {
                            j3 = this.timestampAdjuster.adjustTsTimestamp(peekId3PrivTimestamp);
                        } else {
                            j3 = this.startTimeUs;
                        }
                        hlsSampleStreamWrapper.setSampleOffsetUs(j3);
                    }
                    if (z16) {
                        defaultExtractorInput.skipFully(this.bytesLoaded);
                    }
                    while (i3 == 0) {
                        try {
                            if (this.loadCanceled) {
                                break;
                            } else {
                                i3 = this.extractor.read(defaultExtractorInput, null);
                            }
                        } finally {
                            this.bytesLoaded = (int) (defaultExtractorInput.getPosition() - this.dataSpec.absoluteStreamPosition);
                        }
                    }
                    return;
                }
            } else {
                subrange = this.dataSpec.subrange(this.bytesLoaded);
            }
            DataSource dataSource2 = this.dataSource;
            defaultExtractorInput = new DefaultExtractorInput(dataSource2, subrange.absoluteStreamPosition, dataSource2.open(subrange));
            if (this.isPackedAudioExtractor) {
                peekId3PrivTimestamp = peekId3PrivTimestamp(defaultExtractorInput);
                this.id3TimestampPeeked = true;
                HlsSampleStreamWrapper hlsSampleStreamWrapper2 = this.output;
                if (peekId3PrivTimestamp == -9223372036854775807L) {
                }
                hlsSampleStreamWrapper2.setSampleOffsetUs(j3);
            }
            if (z16) {
            }
            while (i3 == 0) {
            }
            return;
        } finally {
            Util.closeQuietly(this.dataSource);
        }
        z16 = false;
        if (this.isMasterTimestampSource) {
        }
    }

    private void maybeLoadInitData() throws IOException, InterruptedException {
        DataSpec dataSpec;
        if (!this.initLoadCompleted && (dataSpec = this.initDataSpec) != null) {
            DataSpec subrange = dataSpec.subrange(this.initSegmentBytesLoaded);
            try {
                DataSource dataSource = this.initDataSource;
                DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(dataSource, subrange.absoluteStreamPosition, dataSource.open(subrange));
                int i3 = 0;
                while (i3 == 0) {
                    try {
                        if (this.loadCanceled) {
                            break;
                        } else {
                            i3 = this.extractor.read(defaultExtractorInput, null);
                        }
                    } finally {
                        this.initSegmentBytesLoaded = (int) (defaultExtractorInput.getPosition() - this.initDataSpec.absoluteStreamPosition);
                    }
                }
                Util.closeQuietly(this.dataSource);
                this.initLoadCompleted = true;
            } catch (Throwable th5) {
                Util.closeQuietly(this.dataSource);
                throw th5;
            }
        }
    }

    private long peekId3PrivTimestamp(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Metadata decode;
        extractorInput.resetPeekPosition();
        if (!extractorInput.peekFully(this.id3Data.data, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.id3Data.reset(10);
        if (this.id3Data.readUnsignedInt24() != Id3Decoder.ID3_TAG) {
            return -9223372036854775807L;
        }
        this.id3Data.skipBytes(3);
        int readSynchSafeInt = this.id3Data.readSynchSafeInt();
        int i3 = readSynchSafeInt + 10;
        if (i3 > this.id3Data.capacity()) {
            ParsableByteArray parsableByteArray = this.id3Data;
            byte[] bArr = parsableByteArray.data;
            parsableByteArray.reset(i3);
            System.arraycopy(bArr, 0, this.id3Data.data, 0, 10);
        }
        if (!extractorInput.peekFully(this.id3Data.data, 10, readSynchSafeInt, true) || (decode = this.id3Decoder.decode(this.id3Data.data, readSynchSafeInt)) == null) {
            return -9223372036854775807L;
        }
        int length = decode.length();
        for (int i16 = 0; i16 < length; i16++) {
            Metadata.Entry entry = decode.get(i16);
            if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                if (PRIV_TIMESTAMP_FRAME_OWNER.equals(privFrame.owner)) {
                    System.arraycopy(privFrame.privateData, 0, this.id3Data.data, 0, 8);
                    this.id3Data.reset(8);
                    return this.id3Data.readLong() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.chunk.Chunk
    public long bytesLoaded() {
        return this.bytesLoaded;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.output = hlsSampleStreamWrapper;
        hlsSampleStreamWrapper.init(this.uid, this.shouldSpliceIn, this.reusingExtractor);
        if (!this.reusingExtractor) {
            this.extractor.init(hlsSampleStreamWrapper);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public boolean isLoadCanceled() {
        return this.loadCanceled;
    }

    @Override // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
    public void load() throws IOException, InterruptedException {
        maybeLoadInitData();
        if (!this.loadCanceled) {
            if (!this.hasGapTag) {
                loadMedia();
            }
            this.loadCompleted = true;
        }
    }
}
