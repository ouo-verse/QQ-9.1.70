package com.tencent.component.network.module.cache.file;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileStorageHandler implements FileCacheService.StorageHandler {
    private static final int COUNT_OF_HALF_INTERVAL = 6;
    private static final int MAX_WARN_INTERVAL = 1800000;
    private static final int MINUTE = 60000;
    private static final float STORAGE_EXIST_PERCENTAGE_OFFSET = 0.02f;
    private static final int STORAGE_OP_INTERVAL = 2;
    private static final float STORAGE_REMAIN_PERCENTAGE = 0.1f;
    private static final float STORAGE_REMAIN_PERCENTAGE_EXTREME = 0.05f;
    private static final float STORAGE_WARNING_PERCENTAGE = 0.1f;
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());
    private final Collector mCollector;
    private final AtomicInteger mCounter = new AtomicInteger(0);
    private long mLastWarnTime;
    private Future mPendingFuture;
    private int mWarnCount;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface Collector {
        Collection<FileCacheService> collect();
    }

    public FileStorageHandler(Collector collector) {
        this.mCollector = collector;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int calculateRemainSize(int i3, int i16) {
        float f16;
        if (i3 <= 0) {
            return i3;
        }
        float f17 = i3;
        if (i16 / f17 < 0.120000005f) {
            f16 = 0.05f;
        } else {
            f16 = 0.1f;
        }
        return (int) (f17 * f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStorageWarning(Context context) {
        if (context == null) {
            return;
        }
        shouldShowWarning();
    }

    private boolean shouldShowWarning() {
        boolean z16;
        long j3 = (1.0f - (1.0f / ((this.mWarnCount / 6.0f) + 1.0f))) * 1800000.0f;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastWarnTime >= j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int i3 = this.mWarnCount;
            if (i3 < Integer.MAX_VALUE) {
                this.mWarnCount = i3 + 1;
            }
            this.mLastWarnTime = currentTimeMillis;
        }
        return z16;
    }

    @Override // com.tencent.component.network.module.cache.file.FileCacheService.StorageHandler
    public void onLowStorage(FileCacheService fileCacheService, long j3, long j16, final boolean z16) {
        if (this.mCounter.getAndIncrement() < 2) {
            return;
        }
        this.mCounter.set(0);
        QDLog.w(QDLog.TAG_DOWNLOAD, "low storage: totalSize=" + j3 + ", availableSize=" + j16 + ", external=" + z16);
        synchronized (this) {
            Future future = this.mPendingFuture;
            if (future != null && !future.isDone()) {
                return;
            }
            final Context context = fileCacheService.getContext();
            this.mPendingFuture = PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: com.tencent.component.network.module.cache.file.FileStorageHandler.1
                @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
                public Object run(ThreadPool.JobContext jobContext) {
                    float f16;
                    jobContext.setMode(1);
                    Collection<FileCacheService> collect = FileStorageHandler.this.mCollector.collect();
                    if (collect != null) {
                        int i3 = 0;
                        int i16 = 0;
                        for (FileCacheService fileCacheService2 : collect) {
                            int capacity = fileCacheService2.getCapacity(z16);
                            int size = fileCacheService2.getSize(z16);
                            int calculateRemainSize = FileStorageHandler.this.calculateRemainSize(capacity, size);
                            fileCacheService2.clear(z16, calculateRemainSize);
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(QDLog.TAG_DOWNLOAD, "clear cache service:" + fileCacheService2 + ": remain=" + calculateRemainSize);
                            }
                            i16 += size;
                            i3 += capacity;
                        }
                        if (i3 <= 0) {
                            f16 = Float.MAX_VALUE;
                        } else {
                            f16 = i16 / i3;
                        }
                        if (f16 < 0.1f) {
                            FileStorageHandler.this.notifyStorageWarning(context);
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
            });
        }
    }
}
