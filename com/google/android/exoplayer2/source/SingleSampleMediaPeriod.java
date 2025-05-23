package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class SingleSampleMediaPeriod implements MediaPeriod, Loader.Callback<SourceLoadable> {
    private static final int INITIAL_SAMPLE_SIZE = 1024;
    private final DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private int errorCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    final Format format;
    boolean loadingFinished;
    boolean loadingSucceeded;
    private final int minLoadableRetryCount;
    byte[] sampleData;
    int sampleSize;
    private final TrackGroupArray tracks;
    final boolean treatLoadErrorsAsEndOfStream;
    private final ArrayList<SampleStreamImpl> sampleStreams = new ArrayList<>();
    final Loader loader = new Loader("Loader:SingleSampleMediaPeriod");

    /* loaded from: classes2.dex */
    private final class SampleStreamImpl implements SampleStream {
        private static final int STREAM_STATE_END_OF_STREAM = 2;
        private static final int STREAM_STATE_SEND_FORMAT = 0;
        private static final int STREAM_STATE_SEND_SAMPLE = 1;
        private boolean formatSent;
        private int streamState;

        SampleStreamImpl() {
        }

        private void sendFormat() {
            if (!this.formatSent) {
                SingleSampleMediaPeriod.this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(SingleSampleMediaPeriod.this.format.sampleMimeType), SingleSampleMediaPeriod.this.format, 0, null, 0L);
                this.formatSent = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return SingleSampleMediaPeriod.this.loadingFinished;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
            if (!singleSampleMediaPeriod.treatLoadErrorsAsEndOfStream) {
                singleSampleMediaPeriod.loader.maybeThrowError();
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
            int i3 = this.streamState;
            if (i3 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if (!z16 && i3 != 0) {
                SingleSampleMediaPeriod singleSampleMediaPeriod = SingleSampleMediaPeriod.this;
                if (singleSampleMediaPeriod.loadingFinished) {
                    if (singleSampleMediaPeriod.loadingSucceeded) {
                        decoderInputBuffer.timeUs = 0L;
                        decoderInputBuffer.addFlag(1);
                        decoderInputBuffer.ensureSpaceForWrite(SingleSampleMediaPeriod.this.sampleSize);
                        ByteBuffer byteBuffer = decoderInputBuffer.data;
                        SingleSampleMediaPeriod singleSampleMediaPeriod2 = SingleSampleMediaPeriod.this;
                        byteBuffer.put(singleSampleMediaPeriod2.sampleData, 0, singleSampleMediaPeriod2.sampleSize);
                        sendFormat();
                    } else {
                        decoderInputBuffer.addFlag(4);
                    }
                    this.streamState = 2;
                    return -4;
                }
                return -3;
            }
            formatHolder.format = SingleSampleMediaPeriod.this.format;
            this.streamState = 1;
            return -5;
        }

        public void reset() {
            if (this.streamState == 2) {
                this.streamState = 1;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j3) {
            if (j3 > 0 && this.streamState != 2) {
                this.streamState = 2;
                sendFormat();
                return 1;
            }
            return 0;
        }
    }

    public SingleSampleMediaPeriod(DataSpec dataSpec, DataSource.Factory factory, Format format, long j3, int i3, MediaSourceEventListener.EventDispatcher eventDispatcher, boolean z16) {
        this.dataSpec = dataSpec;
        this.dataSourceFactory = factory;
        this.format = format;
        this.durationUs = j3;
        this.minLoadableRetryCount = i3;
        this.eventDispatcher = eventDispatcher;
        this.treatLoadErrorsAsEndOfStream = z16;
        this.tracks = new TrackGroupArray(new TrackGroup(format));
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        if (!this.loadingFinished && !this.loader.isLoading()) {
            this.eventDispatcher.loadStarted(this.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, this.loader.startLoading(new SourceLoadable(this.dataSpec, this.dataSourceFactory.createDataSource()), this, this.minLoadableRetryCount));
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return 0L;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (!this.loadingFinished && !this.loader.isLoading()) {
            return 0L;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j3) {
        callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        return -9223372036854775807L;
    }

    public void release() {
        this.loader.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j3) {
        for (int i3 = 0; i3 < this.sampleStreams.size(); i3++) {
            this.sampleStreams.get(i3).reset();
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            SampleStream sampleStream = sampleStreamArr[i3];
            if (sampleStream != null && (trackSelectionArr[i3] == null || !zArr[i3])) {
                this.sampleStreams.remove(sampleStream);
                sampleStreamArr[i3] = null;
            }
            if (sampleStreamArr[i3] == null && trackSelectionArr[i3] != null) {
                SampleStreamImpl sampleStreamImpl = new SampleStreamImpl();
                this.sampleStreams.add(sampleStreamImpl);
                sampleStreamArr[i3] = sampleStreamImpl;
                zArr2[i3] = true;
            }
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(SourceLoadable sourceLoadable, long j3, long j16, boolean z16) {
        this.eventDispatcher.loadCanceled(sourceLoadable.dataSpec, 1, -1, null, 0, null, 0L, this.durationUs, j3, j16, sourceLoadable.sampleSize);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(SourceLoadable sourceLoadable, long j3, long j16) {
        this.eventDispatcher.loadCompleted(sourceLoadable.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, j3, j16, sourceLoadable.sampleSize);
        this.sampleSize = sourceLoadable.sampleSize;
        this.sampleData = sourceLoadable.sampleData;
        this.loadingFinished = true;
        this.loadingSucceeded = true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(SourceLoadable sourceLoadable, long j3, long j16, IOException iOException) {
        int i3 = this.errorCount + 1;
        this.errorCount = i3;
        boolean z16 = this.treatLoadErrorsAsEndOfStream && i3 >= this.minLoadableRetryCount;
        this.eventDispatcher.loadError(sourceLoadable.dataSpec, 1, -1, this.format, 0, null, 0L, this.durationUs, j3, j16, sourceLoadable.sampleSize, iOException, z16);
        if (!z16) {
            return 0;
        }
        this.loadingFinished = true;
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class SourceLoadable implements Loader.Loadable {
        private final DataSource dataSource;
        public final DataSpec dataSpec;
        private byte[] sampleData;
        private int sampleSize;

        public SourceLoadable(DataSpec dataSpec, DataSource dataSource) {
            this.dataSpec = dataSpec;
            this.dataSource = dataSource;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public boolean isLoadCanceled() {
            return false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            int i3 = 0;
            this.sampleSize = 0;
            try {
                this.dataSource.open(this.dataSpec);
                while (i3 != -1) {
                    int i16 = this.sampleSize + i3;
                    this.sampleSize = i16;
                    byte[] bArr = this.sampleData;
                    if (bArr == null) {
                        this.sampleData = new byte[1024];
                    } else if (i16 == bArr.length) {
                        this.sampleData = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    DataSource dataSource = this.dataSource;
                    byte[] bArr2 = this.sampleData;
                    int i17 = this.sampleSize;
                    i3 = dataSource.read(bArr2, i17, bArr2.length - i17);
                }
            } finally {
                Util.closeQuietly(this.dataSource);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j3, boolean z16) {
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        return j3;
    }
}
