package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.upstream.Loader;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class DefaultLoader extends BaseThread implements Loader {
    private static final int MSG_LOAD_CANCELLED = 5;
    private static final int MSG_LOAD_COMPLETED = 3;
    private static final int MSG_LOAD_ERROR = 4;
    private static final int MSG_LOAD_PROGRESS = 2;
    private static final int MSG_LOAD_STARTED = 1;
    private static final int SIZE_UNSET = -1;
    private static final String TAG = "DefaultLoader";

    @Nullable
    private IDataSink cacheSink;
    private final Handler eventHandler;
    private volatile boolean shutdown;

    @Nullable
    private IDataSource upstream;
    private final UriLoader uriLoader;
    private final Chunk END_OF_QUEUE = new Chunk(0, 0, 0);
    private volatile boolean isLoading = false;
    private volatile boolean cancelled = false;
    private long upstreamSize = -1;
    private final BlockingQueue<Chunk> chunks = new LinkedBlockingQueue(1);

    public DefaultLoader(@NonNull Looper looper, @NonNull UriLoader uriLoader, @Nullable final Loader.Listener listener) {
        this.uriLoader = uriLoader;
        this.eventHandler = new Handler(looper, new Handler.Callback() { // from class: com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                Loader.Listener listener2 = listener;
                if (listener2 == null) {
                    return false;
                }
                if (message.what != 2) {
                    DefaultLoader.this.isLoading = false;
                    Logger.i(DefaultLoader.TAG, "[handleMessage] loading = false");
                    int i3 = message.what;
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return false;
                            }
                            listener.onLoadCancelled(DefaultLoader.this.shutdown);
                            return true;
                        }
                        listener.onLoadError((IOException) message.obj);
                        return true;
                    }
                    listener.onLoadCompleted();
                    return true;
                }
                listener2.onLoadProgress(message.arg1, message.arg2);
                return true;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b9, code lost:
    
        com.tencent.qqmusic.mediaplayer.util.Logger.d(com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.TAG, "[loadChunk] exit. startPosition: " + r3 + ", loadedBytes: " + r18 + ", this.cancelled: " + r23.cancelled + ", shutdown: " + r23.shutdown);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ef, code lost:
    
        return !r20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean loadChunk(@NonNull Chunk chunk) throws IOException {
        boolean z16;
        if (this.upstream != null && this.cacheSink != null) {
            long j3 = chunk.start;
            long j16 = chunk.size;
            Logger.d(TAG, "[loadChunk] enter. startPosition: " + j3 + ", chunkSize: " + j16);
            int i3 = chunk.bufferSize;
            byte[] bArr = new byte[i3];
            if (j16 == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3 = (int) Math.min(i3, j16);
            }
            long j17 = 0;
            boolean z17 = false;
            while (true) {
                long j18 = j3 + j17;
                try {
                    int readAt = this.upstream.readAt(j18, bArr, 0, i3);
                    if (readAt == -1) {
                        Logger.i(TAG, "[loadChunk] read EOF.");
                        break;
                    }
                    if (readAt == 0) {
                        Logger.d(TAG, "[loadChunk] read none.");
                        break;
                    }
                    if (readAt >= 0) {
                        try {
                            j17 += readAt;
                            this.eventHandler.removeMessages(2);
                            this.eventHandler.obtainMessage(2, (int) j3, (int) ((j18 + this.cacheSink.write(j18, bArr, 0, readAt)) - 1)).sendToTarget();
                            if (!this.cancelled && !this.shutdown) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (z17 || (!z16 && j17 >= j16)) {
                                break;
                            }
                        } catch (IOException e16) {
                            throw new IOException(new SinkWriteException(e16));
                        }
                    } else {
                        throw new IOException(new SourceReadException("read error: " + readAt, ""));
                    }
                } catch (IOException e17) {
                    throw new IOException(new SourceReadException(e17, ""));
                }
            }
        } else {
            throw new IllegalStateException("loader must be prepared first!");
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void cancelLoading() {
        Logger.i(TAG, "[cancelLoading] cancel");
        this.uriLoader.cancelLoading();
        this.cancelled = true;
    }

    public abstract IDataSink createCacheSink(StreamingRequest streamingRequest);

    public abstract IDataSource createUpStream(StreamingRequest streamingRequest);

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public long getUpstreamSize() {
        return this.upstreamSize;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public boolean isLoading() {
        if (this.uriLoader.isLoading()) {
            return true;
        }
        if (this.isLoading && !this.shutdown) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void prepare() throws IOException {
        IDataSource iDataSource = this.upstream;
        if (iDataSource != null) {
            iDataSource.close();
        }
        IDataSink iDataSink = this.cacheSink;
        if (iDataSink != null) {
            iDataSink.close();
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            if (this.shutdown) {
                break;
            }
            try {
                Chunk take = this.chunks.take();
                if (this.END_OF_QUEUE == take) {
                    Logger.i(TAG, "[run] end of queue!");
                    break;
                }
                try {
                    if (loadChunk(take)) {
                        this.eventHandler.obtainMessage(3).sendToTarget();
                    } else {
                        this.eventHandler.obtainMessage(5).sendToTarget();
                    }
                } catch (IOException e16) {
                    Logger.e(TAG, "[run] got error!", e16);
                    this.eventHandler.obtainMessage(4, e16).sendToTarget();
                }
            } catch (InterruptedException unused) {
                Logger.w(TAG, "[run] interrupted when taking chunk");
            }
        }
        Logger.i(TAG, "[run] exit. this.cancelled: " + this.cancelled + ", shutdown: " + this.shutdown);
        try {
            IDataSource iDataSource = this.upstream;
            if (iDataSource != null) {
                iDataSource.close();
            }
        } catch (IOException unused2) {
            Logger.w(TAG, "[shutdown] failed to close upstream");
        }
        try {
            IDataSink iDataSink = this.cacheSink;
            if (iDataSink != null) {
                iDataSink.close();
            }
        } catch (IOException unused3) {
            Logger.w(TAG, "[shutdown] failed to close cacheSink");
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void shutdown() throws InterruptedException {
        Logger.i(TAG, "[shutdown] enter");
        this.shutdown = true;
        this.chunks.offer(this.END_OF_QUEUE);
        cancelLoading();
        Logger.i(TAG, "[shutdown] exit");
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.Loader
    public void startLoading(@NonNull Chunk chunk) {
        Logger.i(TAG, "[startLoading] chunk: " + chunk);
        this.chunks.clear();
        if (this.chunks.offer(chunk)) {
            this.isLoading = true;
            Logger.i(TAG, "[handleMessage] loading = true");
            this.cancelled = false;
            if (getState() == Thread.State.NEW) {
                this.uriLoader.startLoading(0, TimeUnit.MILLISECONDS, new UriLoader.Callback() { // from class: com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.2
                    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
                    public void onCancelled() {
                        DefaultLoader.this.eventHandler.obtainMessage(5).sendToTarget();
                    }

                    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
                    public void onFailed(Throwable th5) {
                        DefaultLoader.this.eventHandler.obtainMessage(4, new IOException("failed to load uri", th5)).sendToTarget();
                    }

                    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader.Callback
                    public void onSucceed(StreamingRequest streamingRequest) {
                        Logger.i(DefaultLoader.TAG, "[startLoading] uriLoader.startLoading onSucceed");
                        IDataSource createUpStream = DefaultLoader.this.createUpStream(streamingRequest);
                        try {
                            createUpStream.open();
                            DefaultLoader.this.upstreamSize = createUpStream.getSize();
                        } catch (IOException e16) {
                            DefaultLoader.this.eventHandler.obtainMessage(4, e16).sendToTarget();
                        }
                        IDataSink createCacheSink = DefaultLoader.this.createCacheSink(streamingRequest);
                        try {
                            createCacheSink.open();
                        } catch (IOException e17) {
                            DefaultLoader.this.eventHandler.obtainMessage(4, e17).sendToTarget();
                        }
                        DefaultLoader.this.cacheSink = createCacheSink;
                        DefaultLoader.this.upstream = createUpStream;
                        DefaultLoader.this.start();
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalStateException("exceeds maximum of queue!");
    }
}
