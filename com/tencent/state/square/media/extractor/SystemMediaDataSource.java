package com.tencent.state.square.media.extractor;

import android.media.MediaDataSource;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.download.DownloadCallback;
import com.tencent.state.square.download.DownloadsKt;
import com.tencent.state.square.download.Source;
import com.tencent.state.square.download.TaskProgress;
import com.tencent.state.square.download.TaskResponse;
import com.tencent.state.square.media.MediaSource;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.square.media.extractor.IRandomAccessSource;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\f\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\"H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/media/extractor/SystemMediaDataSource;", "Landroid/media/MediaDataSource;", "Lcom/tencent/state/square/download/DownloadCallback;", "source", "Lcom/tencent/state/square/media/MediaSource;", "(Lcom/tencent/state/square/media/MediaSource;)V", "dataSource", "Lcom/tencent/state/square/media/extractor/RandomAccessFileSource;", "expectSize", "", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "readLock", "Ljava/lang/Object;", "videoLength", "Ljava/lang/Long;", "close", "", "getDataSource", "Lcom/tencent/state/square/media/extractor/IRandomAccessSource;", "getSize", "onTaskFailed", "Lcom/tencent/state/square/download/Source;", "response", "Lcom/tencent/state/square/download/TaskResponse;", "onTaskProgress", "progress", "Lcom/tencent/state/square/download/TaskProgress;", "onTaskStart", "contentLength", "tmpFile", "Ljava/io/File;", "onTaskSuccess", "readAt", "", "position", "buffer", "", "offset", "size", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SystemMediaDataSource extends MediaDataSource implements DownloadCallback {
    private static final String TAG = "Square_SystemMediaDataSource";
    private RandomAccessFileSource dataSource;
    private long expectSize;
    private final CountDownLatch initLatch;
    private final Object readLock;
    private final MediaSource source;
    private Long videoLength;

    public SystemMediaDataSource(MediaSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.dataSource = new RandomAccessFileSource();
        this.initLatch = new CountDownLatch(1);
        this.readLock = new Object();
        this.expectSize = -1L;
        if (DownloadsKt.getCacheFile(source).exists()) {
            this.videoLength = Long.valueOf(DownloadsKt.getCacheFile(source).length());
            this.dataSource.initialize(DownloadsKt.getCacheFile(source));
        } else {
            SquareMedia.INSTANCE.getDownloader().addHighTask(source, this);
        }
    }

    private final IRandomAccessSource<?> getDataSource() {
        if (!this.dataSource.isInitialized()) {
            this.initLatch.await();
        }
        return this.dataSource;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        SquareBaseKt.getSquareLog().i(TAG, "close");
        synchronized (this.readLock) {
            getDataSource().close();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        Long l3 = this.videoLength;
        if (l3 == null) {
            this.initLatch.await();
            Long l16 = this.videoLength;
            l3 = Long.valueOf(l16 != null ? l16.longValue() : -1L);
        }
        return l3.longValue();
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskFailed(Source source, TaskResponse response) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().i(TAG, "onDownloadFailed: source=" + source + ", error=" + response.getErrorCode());
        this.videoLength = 0L;
        this.initLatch.countDown();
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskProgress(Source source, TaskResponse response, TaskProgress progress) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(progress, "progress");
        if (this.initLatch.getCount() > 0) {
            SquareBaseKt.getSquareLog().w(TAG, '(' + hashCode() + ") call onTaskStart in onTaskProgress");
            onTaskStart(response.getContentLength(), progress.getTmpFile());
        }
        synchronized (this.readLock) {
            long progress2 = progress.getProgress() - progress.getSize();
            if (progress.getProgress() == getSize()) {
                SquareBaseKt.getSquareLog().i(TAG, "on progress: position=" + progress2 + ", progress=" + progress.getProgress());
            }
            this.dataSource.write(progress2, progress.getData(), 0, progress.getSize());
            if (this.expectSize > -1 && this.dataSource.length() >= this.expectSize) {
                SquareBaseKt.getSquareLog().w(TAG, "notify all: current=" + this.dataSource.length() + ", expect=" + this.expectSize);
                this.expectSize = -1L;
                this.readLock.notifyAll();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskStart(Source source, TaskResponse response) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().i(TAG, "onDownloadStart: source=" + source + ", length=" + response.getContentLength());
        onTaskStart$default(this, response.getContentLength(), null, 2, null);
    }

    @Override // com.tencent.state.square.download.DownloadCallback
    public void onTaskSuccess(Source source, TaskResponse response) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(response, "response");
        SquareBaseKt.getSquareLog().i(TAG, "onDownloadSuccess: source=" + source + ", result=" + response.getResult());
        if (this.initLatch.getCount() > 0) {
            SquareBaseKt.getSquareLog().w(TAG, '(' + hashCode() + ") call onTaskStart in onTaskSuccess");
            this.dataSource.initialize(DownloadsKt.getCacheFile(source));
            this.videoLength = Long.valueOf(DownloadsKt.getCacheFile(source).length());
            this.initLatch.countDown();
        }
    }

    @Override // android.media.MediaDataSource
    public int readAt(long position, byte[] buffer, int offset, int size) {
        long coerceAtMost;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (position >= getSize()) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "readAt: position >= getSize()", null, 4, null);
            return -1;
        }
        IRandomAccessSource<?> dataSource = getDataSource();
        synchronized (this.readLock) {
            int read = dataSource.read(position, buffer, offset, size);
            if (read + position >= getSize()) {
                return read;
            }
            if (read < size) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(size + position, getSize());
                this.expectSize = coerceAtMost;
                SquareBaseKt.getSquareLog().i(TAG, "start wait");
                LockMethodProxy.wait(this.readLock);
                read = dataSource.read(position, buffer, offset, size);
                SquareBaseKt.getSquareLog().i(TAG, "read bytes after wait: " + read);
            }
            return read;
        }
    }

    private final void onTaskStart(long contentLength, File tmpFile) {
        IRandomAccessSource.DefaultImpls.initialize$default(this.dataSource, null, 1, null);
        if (tmpFile != null) {
            this.dataSource.copyFrom(new FileInputStream(tmpFile));
        }
        this.videoLength = Long.valueOf(contentLength);
        this.initLatch.countDown();
    }

    static /* synthetic */ void onTaskStart$default(SystemMediaDataSource systemMediaDataSource, long j3, File file, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            file = null;
        }
        systemMediaDataSource.onTaskStart(j3, file);
    }
}
