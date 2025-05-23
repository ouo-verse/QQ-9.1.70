package com.nostra13.universalimageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DefaultConfigurationFactory {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        DefaultThreadFactory(int i3, String str) {
            this.threadPriority = i3;
            this.namePrefix = str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            BaseThread baseThread = new BaseThread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (baseThread.isDaemon()) {
                baseThread.setDaemon(false);
            }
            baseThread.setPriority(this.threadPriority);
            return baseThread;
        }
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator fileNameGenerator, long j3, int i3) {
        File createReserveDiskCacheDir = createReserveDiskCacheDir(context);
        if (j3 > 0 || i3 > 0) {
            try {
                return new LruDiskCache(StorageUtils.getIndividualCacheDirectory(context), createReserveDiskCacheDir, fileNameGenerator, j3, i3);
            } catch (IOException e16) {
                L.e(e16);
            }
        }
        return new UnlimitedDiskCache(StorageUtils.getCacheDirectory(context), createReserveDiskCacheDir, fileNameGenerator);
    }

    public static Executor createExecutor(int i3, int i16, QueueProcessingType queueProcessingType) {
        boolean z16;
        BlockingQueue linkedBlockingQueue;
        if (queueProcessingType == QueueProcessingType.LIFO) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            linkedBlockingQueue = new LIFOLinkedBlockingDeque();
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        return new BaseThreadPoolExecutor(i3, i3, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) linkedBlockingQueue, createThreadFactory(i16, "uil-pool-"));
    }

    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static ImageDecoder createImageDecoder(boolean z16) {
        return new BaseImageDecoder(z16);
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static MemoryCache createMemoryCache(Context context, int i3) {
        if (i3 == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            int memoryClass = activityManager.getMemoryClass();
            if (hasHoneycomb() && isLargeHeap(context)) {
                memoryClass = getLargeMemoryClass(activityManager);
            }
            i3 = (memoryClass * 1048576) / 8;
        }
        return new LruMemoryCache(i3);
    }

    private static File createReserveDiskCacheDir(Context context) {
        File cacheDirectory = StorageUtils.getCacheDirectory(context, false);
        File file = new File(cacheDirectory, "uil-images");
        if (file.exists() || file.mkdir()) {
            return file;
        }
        return cacheDirectory;
    }

    public static Executor createTaskDistributor() {
        return ProxyExecutors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-"));
    }

    private static ThreadFactory createThreadFactory(int i3, String str) {
        return new DefaultThreadFactory(i3, str);
    }

    @TargetApi(11)
    private static int getLargeMemoryClass(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    private static boolean hasHoneycomb() {
        return true;
    }

    @TargetApi(11)
    private static boolean isLargeHeap(Context context) {
        if ((context.getApplicationInfo().flags & 1048576) != 0) {
            return true;
        }
        return false;
    }
}
