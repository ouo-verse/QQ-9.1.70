package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.downstream.FileDataSink;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPService;
import com.tencent.qqmusic.mediaplayer.perf.Collectable;
import com.tencent.qqmusic.mediaplayer.perf.ErrorUploadCollector;
import com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector;
import com.tencent.qqmusic.mediaplayer.upstream.Loader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import org.aspectj.lang.JoinPoint;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CacheDataSource implements IDataSource, Collectable {
    private static final int CHUNK_LOAD_BUFFER_SIZE = 8192;
    private static final int DISCONTINUITY_THRESHOLD = 8192;
    static final long NO_RESET_PENDING = Long.MIN_VALUE;
    private static final int PROFILE_ending = 10;
    private static final int PROFILE_isCached = 8;
    private static final int PROFILE_lock = 5;
    private static final int PROFILE_onBufferEnd = 7;
    private static final int PROFILE_onBufferStarted = 4;
    private static final int PROFILE_onBytesTransferred = 9;
    private static final int PROFILE_onBytesTransferring = 3;
    private static final int PROFILE_onReadContinuity = 1;
    private static final int PROFILE_onReadDiscontinuity = 2;
    private static final int PROFILE_readAt = 6;
    private static final int PROFILE_total = 0;
    private static final int READ_WAIT_TIMEOUT = 30000;
    private static final String TAG = "CacheDataSource";
    private static final String[] profiles = {"total", "onReadContinuity", "onReadDiscontinuity", "onBytesTransferring", "onBufferStarted", JoinPoint.SYNCHRONIZATION_LOCK, "readAt", "onBufferEnd", "isCached", "onBytesTransferred", "ending"};

    @NonNull
    protected final IDataSource cacheSource;

    @NonNull
    private final DataRangeTracker cachedDataTracker;
    private long[] costs;
    private long currentLoadStartPosition;

    @Nullable
    private Chunk currentLoadingChunk;
    private volatile boolean isToReleaseLock;
    private volatile boolean isWaitingForFirstPiece;

    @Nullable
    private Listener listener;
    private boolean loadFinished;
    private final Loader loader;
    private LoaderListener loaderListener;
    private long nextContinuousPosition;
    private boolean opened;
    protected long pendingRestartPositionByte;
    protected long pendingStartPositionByte;
    private TimerTask pendingTask;
    private Timer restartHandler;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Listener extends TransferListener {
        void onBufferEnded();

        void onBufferStarted(long j3);

        long onStreamingError(IOException iOException);

        void onStreamingFinished();

        void onUpStreamTransfer(long j3, long j16);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class LoaderListener implements Loader.Listener {
        private long loadedPosition;

        LoaderListener() {
            this.loadedPosition = Long.MIN_VALUE;
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public synchronized void onLoadCancelled(boolean z16) {
            Logger.i(CacheDataSource.TAG, "[onLoadCancelled] enter. terminated: " + z16);
            if (!z16) {
                try {
                    if (!CacheDataSource.this.startLoadingIfNeeded()) {
                        CacheDataSource.this.cachedDataTracker.abandonLock();
                    }
                } catch (IllegalStateException e16) {
                    onLoadError(new IOException("failed to start load after cancelling", e16));
                    CacheDataSource.this.cachedDataTracker.abandonLock();
                }
            } else {
                CacheDataSource.this.cachedDataTracker.abandonLock();
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public void onLoadCompleted() {
            CacheDataSource.this.currentLoadStartPosition = Long.MIN_VALUE;
            CacheDataSource.this.currentLoadingChunk = null;
            CacheDataSource.this.loadFinished = true;
            CacheDataSource.this.cachedDataTracker.abandonLock();
            if (CacheDataSource.this.listener != null) {
                CacheDataSource.this.listener.onStreamingFinished();
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public void onLoadError(IOException iOException) {
            long j3;
            Logger.e(CacheDataSource.TAG, "[onLoadError] enter.", iOException);
            long j16 = this.loadedPosition;
            if (j16 == Long.MIN_VALUE) {
                j3 = 0;
            } else {
                j3 = j16;
            }
            CacheDataSource cacheDataSource = CacheDataSource.this;
            cacheDataSource.pendingRestartPositionByte = j16;
            if (cacheDataSource.listener == null) {
                CacheDataSource.this.currentLoadStartPosition = Long.MIN_VALUE;
                CacheDataSource.this.currentLoadingChunk = null;
                CacheDataSource.this.cachedDataTracker.abandonLock();
                return;
            }
            long onStreamingError = CacheDataSource.this.listener.onStreamingError(iOException);
            if (onStreamingError >= 0) {
                CacheDataSource.this.scheduleRestart(j3, onStreamingError);
                CacheDataSource.this.pendingRestartPositionByte = Long.MIN_VALUE;
            } else {
                CacheDataSource.this.currentLoadStartPosition = Long.MIN_VALUE;
                CacheDataSource.this.currentLoadingChunk = null;
                CacheDataSource.this.cachedDataTracker.abandonLock();
            }
        }

        @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Listener
        public void onLoadProgress(long j3, long j16) {
            this.loadedPosition = j16;
            CacheDataSource.this.cachedDataTracker.addRange(j3, j16, CacheDataSource.this.isWaitingForFirstPiece);
            Loader loader = CacheDataSource.this.loader;
            Listener listener = CacheDataSource.this.listener;
            if (listener != null && loader != null) {
                CacheDataSource.this.cachedDataTracker.setFileTotalSize(loader.getUpstreamSize(), true);
                listener.onUpStreamTransfer(j16, loader.getUpstreamSize());
            }
        }
    }

    public CacheDataSource(@NonNull final IDataSource iDataSource, @NonNull IDataSource iDataSource2, @NonNull final IDataSink iDataSink, @NonNull final Looper looper) {
        this(iDataSource2, new Loader.Factory() { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.1
            @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory
            public Loader createLoader(Loader.Listener listener) {
                return new DefaultLoader(looper, new DummyUriLoader(null), listener) { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.1.1
                    @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                    public IDataSink createCacheSink(StreamingRequest streamingRequest) {
                        return iDataSink;
                    }

                    @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                    public IDataSource createUpStream(StreamingRequest streamingRequest) {
                        return iDataSource;
                    }
                };
            }
        });
    }

    private void clearState() {
        this.loadFinished = false;
    }

    private boolean isCached(long j3, int i3) {
        long upstreamSize = this.loader.getUpstreamSize();
        if (upstreamSize > 0 && i3 + j3 > upstreamSize - 1 && (i3 = (int) ((upstreamSize - j3) - 1)) < 0) {
            j3 += i3;
            i3 = 0;
        }
        return this.cachedDataTracker.isCached(j3, i3);
    }

    private void onReadDiscontinuity(long j3, boolean z16) throws IOException {
        long max;
        long j16 = this.currentLoadStartPosition;
        if (j3 == j16) {
            return;
        }
        long j17 = j3 - j16;
        if (j17 >= 0 && j17 < 8192) {
            return;
        }
        synchronized (this.cachedDataTracker) {
            max = Math.max(j3, this.cachedDataTracker.findStart(j3));
        }
        long j18 = this.currentLoadStartPosition;
        if (j18 == max) {
            return;
        }
        long j19 = max - j18;
        if ((j19 >= 0 && j19 < 8192) || max == getSize()) {
            return;
        }
        Chunk chunk = this.currentLoadingChunk;
        if (z16 && chunk != null && chunk.contains(max)) {
            return;
        }
        restartLoading(max);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void restartLoading(long j3) {
        Logger.i(TAG, "[restartLoading] from: " + j3);
        this.pendingStartPositionByte = j3;
        this.loadFinished = false;
        if (this.loader.isLoading()) {
            this.cachedDataTracker.block();
            this.loader.cancelLoading();
        } else {
            clearState();
            startLoadingIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public synchronized void scheduleRestart(final long j3, long j16) {
        Logger.i(TAG, String.format("[scheduleRestart] position: %d, delay: %d", Long.valueOf(j3), Long.valueOf(j16)));
        if (this.restartHandler == null) {
            this.restartHandler = new BaseTimer("CacheDataSource.Restart");
        }
        TimerTask timerTask = this.pendingTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.restartHandler.purge();
        }
        TimerTask timerTask2 = new TimerTask() { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Logger.i(CacheDataSource.TAG, "[scheduleRestart] restart loading from position: " + j3);
                CacheDataSource.this.restartLoading(j3);
            }
        };
        this.pendingTask = timerTask2;
        this.restartHandler.schedule(timerTask2, j16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean startLoadingIfNeeded() throws IllegalStateException {
        Chunk chunk;
        if (this.loadFinished) {
            return false;
        }
        long j3 = this.pendingStartPositionByte;
        this.pendingStartPositionByte = Long.MIN_VALUE;
        if (!this.opened) {
            if (j3 == Long.MIN_VALUE) {
                Logger.i(TAG, "[startLoadingIfNeeded] start a fresh load");
                chunk = new Chunk(8192, 0L, -1L);
            } else {
                Logger.i(TAG, "[startLoadingIfNeeded] start a pending load: " + j3);
                chunk = new Chunk(8192, j3, -1L);
            }
        } else if (j3 != Long.MIN_VALUE) {
            Logger.i(TAG, "[startLoadingIfNeeded] restart a pending load: " + j3);
            chunk = new Chunk(8192, j3, -1L);
        } else {
            throw new IllegalStateException("pendingStartPositionByte must be set!");
        }
        this.currentLoadingChunk = chunk;
        this.currentLoadStartPosition = chunk.start;
        this.cachedDataTracker.unblock();
        this.loader.startLoading(chunk);
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(@NonNull ErrorUploadCollector errorUploadCollector) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Logger.i(TAG, "[close] enter.");
        if (!this.opened) {
            Logger.i(TAG, "[close] not opened. return");
            return;
        }
        this.cachedDataTracker.abandonLock();
        try {
            this.loader.shutdown();
        } catch (InterruptedException unused) {
        }
        this.cacheSource.close();
        Listener listener = this.listener;
        if (listener != null) {
            listener.onTransferEnd();
        }
        reportProfiling();
        this.opened = false;
        Logger.i(TAG, "[close] exit");
    }

    public synchronized boolean continueLoadIfNeeded() {
        if (!this.opened) {
            Logger.w(TAG, "[continueLoadIfNeeded] not opened!");
            return false;
        }
        long j3 = this.pendingRestartPositionByte;
        if (j3 == Long.MIN_VALUE) {
            return false;
        }
        if (this.loadFinished) {
            return false;
        }
        this.pendingRestartPositionByte = Long.MIN_VALUE;
        scheduleRestart(j3, 0L);
        Logger.i(TAG, "[continueLoadIfNeeded] schedule restart from: " + j3);
        return true;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public AudioFormat.AudioType getAudioType() throws IOException {
        return FormatDetector.getAudioFormat((IDataSource) this, false);
    }

    public long getBufferTimeout(long j3, int i3) {
        return 30000L;
    }

    @NonNull
    public Loader getLoader() {
        return this.loader;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public long getSize() throws IOException {
        Loader loader = this.loader;
        if (loader != null) {
            return loader.getUpstreamSize();
        }
        return 0L;
    }

    public void initDataSourceSize(long j3, long j16) {
        LoaderListener loaderListener = this.loaderListener;
        if (loaderListener != null) {
            loaderListener.onLoadProgress(j3, j16);
        }
    }

    public boolean isCacheFileComplete() {
        long continuousStart = this.cachedDataTracker.getContinuousStart();
        long continuousEnd = this.cachedDataTracker.getContinuousEnd();
        if (continuousEnd != -1 && continuousEnd == this.loader.getUpstreamSize() - 1 && continuousStart == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public void open() throws IOException {
        Logger.i(TAG, "[open] enter.");
        if (this.opened) {
            return;
        }
        this.nextContinuousPosition = 0L;
        this.pendingRestartPositionByte = Long.MIN_VALUE;
        this.cacheSource.open();
        this.loader.prepare();
        startLoadingIfNeeded();
        Listener listener = this.listener;
        if (listener != null) {
            listener.onTransferStart();
        }
        this.opened = true;
        Logger.i(TAG, "[open] opened = true;");
        Logger.i(TAG, "[open] exit");
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.IDataSource
    public int readAt(long j3, byte[] bArr, int i3, int i16) throws IOException {
        int i17;
        try {
            if (this.opened) {
                if (j3 >= 0) {
                    boolean isCached = isCached(j3, i16);
                    if (j3 == this.nextContinuousPosition) {
                        onReadContinuity(j3);
                    } else {
                        onReadDiscontinuity(j3, isCached);
                    }
                    Listener listener = this.listener;
                    if (listener != null) {
                        listener.onBytesTransferring(j3, i16);
                    }
                    if (isCached) {
                        i17 = this.cacheSource.readAt(j3, bArr, i3, i16);
                    } else {
                        i17 = -1;
                    }
                    if (i17 < 0) {
                        if (!this.loader.isLoading()) {
                            i17 = this.cacheSource.readAt(j3, bArr, i3, i16);
                            Logger.e(TAG, "[readAt] load not started: " + j3 + ", size: " + i16 + ", read: " + i17);
                        } else {
                            Logger.w(TAG, "[readAt] load has started, lock util data has been downloaded : " + j3 + ", size: " + i16 + ", read: " + i17);
                            Listener listener2 = this.listener;
                            if (listener2 != null) {
                                listener2.onBufferStarted(j3);
                            }
                            try {
                                this.cachedDataTracker.lock(j3, i16, getBufferTimeout(j3, i16), new DataRangeTracker.LockJudgerCallback() { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.2
                                    @Override // com.tencent.qqmusic.mediaplayer.DataRangeTracker.LockJudgerCallback
                                    public boolean isToAbandonLock() {
                                        return CacheDataSource.this.isToReleaseLock;
                                    }
                                });
                                Listener listener3 = this.listener;
                                if (listener3 != null) {
                                    listener3.onBufferEnded();
                                }
                                i17 = this.cacheSource.readAt(j3, bArr, i3, i16);
                            } catch (InterruptedException e16) {
                                throw new IOException("interrupted!", e16);
                            }
                        }
                    }
                    int i18 = i17;
                    boolean z16 = false;
                    if (i18 > 0) {
                        this.nextContinuousPosition = i18 + j3;
                    } else if (i18 < 0) {
                        Logger.e(TAG, "[readAt]: read error! read < 0\uff0c read = " + i18);
                        z16 = true;
                    } else {
                        if (i16 != 0) {
                            z16 = true;
                        }
                        Logger.e(TAG, "[readAt]: read error! read = 0, hasError = " + z16);
                    }
                    Listener listener4 = this.listener;
                    if (listener4 != null) {
                        if (z16) {
                            listener4.onBytesTransferError(j3, i16, i18);
                        } else {
                            listener4.onBytesTransferred(j3, i18);
                        }
                    }
                    return i18;
                }
                Logger.e(TAG, "[readAt] invalid position: " + j3);
                throw new IOException("invalid position: " + j3);
            }
            Logger.e(TAG, "[readAt] not opened!");
            this.cachedDataTracker.abandonLock();
            throw new IOException("[readAt] not opened!");
        } catch (Throwable th5) {
            Logger.e(TAG, "[readAt] error occurred: " + j3, th5);
            throw th5;
        }
    }

    public void releaseLock() {
        Logger.i(TAG, "[releaseLock]");
        this.isToReleaseLock = true;
    }

    public void setFileTotalSize(long j3) {
        this.cachedDataTracker.setFileTotalSize(j3, false);
    }

    public void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    public boolean waitForFirstPiece(int i3, long j3) throws InterruptedException {
        this.isWaitingForFirstPiece = true;
        boolean lock = this.cachedDataTracker.lock(0L, i3, j3, null);
        this.isWaitingForFirstPiece = false;
        return lock;
    }

    public CacheDataSource(@NonNull IDataSource iDataSource, @NonNull Loader.Factory factory) {
        this.currentLoadStartPosition = Long.MIN_VALUE;
        this.loaderListener = null;
        this.isWaitingForFirstPiece = false;
        this.costs = new long[profiles.length];
        this.isToReleaseLock = false;
        this.cacheSource = iDataSource;
        this.cachedDataTracker = new DataRangeTracker();
        this.opened = false;
        this.loadFinished = false;
        LoaderListener loaderListener = new LoaderListener();
        this.loaderListener = loaderListener;
        this.loader = factory.createLoader(loaderListener);
    }

    @Override // com.tencent.qqmusic.mediaplayer.perf.Collectable
    public void accept(@NonNull PlayerInfoCollector playerInfoCollector) {
        int i3 = 1;
        long j3 = 0;
        for (int i16 = 1; i16 < profiles.length; i16++) {
            j3 += this.costs[i16];
        }
        long[] jArr = this.costs;
        double length = (jArr[0] - j3) / jArr.length;
        int length2 = jArr.length;
        long[] jArr2 = new long[length2];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        for (int i17 = 1; i17 < length2; i17++) {
            jArr2[i17] = Math.max(jArr2[i17] - ((long) length), 0L);
        }
        while (true) {
            String[] strArr = profiles;
            if (i3 >= strArr.length) {
                return;
            }
            playerInfoCollector.putLong("CacheDataSource." + strArr[i3], jArr2[i3] / 1000000);
            i3++;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Factory {
        @NonNull
        private static Loader.Factory createDefaultLoaderFactory(final File file, @NonNull final UriLoader uriLoader) {
            return new Loader.Factory() { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.2
                @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader.Factory
                public Loader createLoader(Loader.Listener listener) {
                    return new DefaultLoader(Looper.getMainLooper(), UriLoader.this, listener) { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.2.1
                        @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                        public IDataSink createCacheSink(StreamingRequest streamingRequest) {
                            return new FileDataSink(file.getAbsolutePath());
                        }

                        @Override // com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader
                        public IDataSource createUpStream(StreamingRequest streamingRequest) {
                            return new HttpDataSource(streamingRequest.uri, streamingRequest.headers, new DefaultMediaHTTPService());
                        }
                    };
                }
            };
        }

        public static CacheDataSource createFromLoader(File file, @NonNull Loader.Factory factory) {
            return new CacheDataSource(new FileDataSource(file.getAbsolutePath()), factory);
        }

        public static CacheDataSource createFromUri(@NonNull File file, @NonNull Uri uri) {
            return createFromUriLoader(file, new DummyUriLoader(uri));
        }

        public static CacheDataSource createFromUriLoader(@NonNull UriLoader uriLoader, String str) throws DataSourceException {
            final File createTempFile;
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp", new File(str));
                        ensureFile(createTempFile);
                        return new CacheDataSource(new FileDataSource(createTempFile.getAbsolutePath()) { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.1
                            @Override // com.tencent.qqmusic.mediaplayer.upstream.FileDataSource, java.io.Closeable, java.lang.AutoCloseable
                            public void close() throws IOException {
                                try {
                                    super.close();
                                } catch (IOException unused) {
                                }
                                if (!createTempFile.delete()) {
                                    Logger.w(CacheDataSource.TAG, "failed to delete buffer file: " + createTempFile);
                                }
                            }
                        }, createDefaultLoaderFactory(createTempFile, uriLoader));
                    }
                } catch (IOException e16) {
                    throw new DataSourceException(-8, "failed to ensure buffer file!", e16);
                }
            }
            createTempFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
            ensureFile(createTempFile);
            return new CacheDataSource(new FileDataSource(createTempFile.getAbsolutePath()) { // from class: com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory.1
                @Override // com.tencent.qqmusic.mediaplayer.upstream.FileDataSource, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    try {
                        super.close();
                    } catch (IOException unused) {
                    }
                    if (!createTempFile.delete()) {
                        Logger.w(CacheDataSource.TAG, "failed to delete buffer file: " + createTempFile);
                    }
                }
            }, createDefaultLoaderFactory(createTempFile, uriLoader));
        }

        private static void ensureFile(File file) throws IOException {
            file.delete();
            if (file.createNewFile()) {
            } else {
                throw new IOException("failed to create file!");
            }
        }

        public static CacheDataSource createFromUriLoader(File file, @NonNull UriLoader uriLoader) {
            return new CacheDataSource(new FileDataSource(file.getAbsolutePath()), createDefaultLoaderFactory(file, uriLoader));
        }
    }

    private void reportProfiling() {
    }

    private void onReadContinuity(long j3) {
    }
}
