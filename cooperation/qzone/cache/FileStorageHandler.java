package cooperation.qzone.cache;

import android.os.StatFs;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.FileCacheService;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FileStorageHandler implements FileCacheService.StorageHandler {
    private static final int COUNT_OF_HALF_INTERVAL = 6;
    private static final int MAX_WARN_INTERVAL = 1800000;
    private static final long MEGABYTES = 1048576;
    private static final int MINUTE = 60000;
    private static final float STORAGE_EXIST_PERCENTAGE_OFFSET = 0.02f;
    private static final long STORAGE_LOW_BOUNDS = 20971520;
    private static final int STORAGE_OP_INTERVAL = 2;
    private static final float STORAGE_REMAIN_PERCENTAGE = 0.1f;
    private static final float STORAGE_REMAIN_PERCENTAGE_EXTREME = 0.05f;
    private static final float STORAGE_WARNING_PERCENTAGE = 0.1f;
    private static final float remainSizeFactor = 0.8f;
    private final Collector mCollector;
    private final AtomicInteger mCounter = new AtomicInteger(0);
    private long mLastWarnTime;
    private Future mPendingFuture;
    private int mWarnCount;
    private static FilenameFilter filenameFilter = new FilenameFilter() { // from class: cooperation.qzone.cache.FileStorageHandler.2
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.endsWith(FileCacheService.VERSION_FILE);
        }
    };
    private static Comparator<File> fileTimeComparator = new Comparator<File>() { // from class: cooperation.qzone.cache.FileStorageHandler.3
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified > lastModified2) {
                return -1;
            }
            return lastModified < lastModified2 ? 1 : 0;
        }
    };

    /* compiled from: P */
    /* loaded from: classes28.dex */
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
    public int calculateUsedSize(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles(filenameFilter)) == null || listFiles.length <= 0) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < listFiles.length; i16++) {
            File file2 = listFiles[i16];
            if (file2 != null && file2.getName() != null) {
                if (listFiles[i16].isDirectory()) {
                    i3 += calculateUsedSize(listFiles[i16].getAbsolutePath());
                } else {
                    i3 = (int) (i3 + listFiles[i16].length());
                }
            }
        }
        return i3;
    }

    private long deleteFile(String str) {
        File file = new File(str);
        long j3 = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (file.isFile()) {
            long length = 0 + file.length();
            FileUtils.delete(file);
            return length;
        }
        if (!file.isDirectory()) {
            return 0L;
        }
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            j3 += deleteFile(file2.getAbsolutePath());
        }
        return j3;
    }

    public static boolean isStorageSizeLow(String str) {
        boolean z16;
        try {
            StatFs statFs = new StatFs(str);
            long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            if (availableBlocksLong < 20971520) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.w(CacheManager.TAG, 1, "low storage: totalSize=" + (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) + ", availableSize=" + availableBlocksLong + ", external=" + str);
            }
            return z16;
        } catch (Throwable th5) {
            QLog.e(CacheManager.TAG, 1, "", th5);
            return false;
        }
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

    public void checkFileAndClean(String str, int i3) {
        File[] listFiles;
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(filenameFilter)) != null && listFiles.length > 0) {
                long j3 = 0;
                for (File file2 : listFiles) {
                    j3 += file2.length();
                }
                if (j3 > i3) {
                    QLog.w(CacheManager.TAG, 1, "lrufile \u6587\u4ef6\u5bb9\u91cf\u8d85\u8fc7\u9650\u5236");
                    long j16 = i3 * 0.8f;
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (File file3 : listFiles) {
                        arrayList.add(file3);
                    }
                    Collections.sort(arrayList, fileTimeComparator);
                    try {
                        for (int size = arrayList.size() - 1; size > 0; size--) {
                            File file4 = (File) arrayList.get(size);
                            String absolutePath = file4.getAbsolutePath();
                            if (file4.exists()) {
                                j3 -= file4.length();
                                file4.delete();
                            }
                            File file5 = new File(absolutePath + FileCacheService.HeaderFileSuffix);
                            if (file5.exists()) {
                                file5.delete();
                            }
                            if (j3 < j16) {
                                return;
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(CacheManager.TAG, 1, "", th5);
        }
    }

    public void cleanOldFile(int i3, int i16, String str) {
        File[] listFiles;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(filenameFilter)) != null && listFiles.length > 0) {
                ArrayList arrayList = new ArrayList(listFiles.length);
                for (File file2 : listFiles) {
                    arrayList.add(file2);
                }
                Collections.sort(arrayList, fileTimeComparator);
                try {
                    for (int size = arrayList.size() - 1; size > 0; size--) {
                        String absolutePath = ((File) arrayList.get(size)).getAbsolutePath();
                        i3 = (int) (i3 - deleteFile(absolutePath));
                        File file3 = new File(absolutePath + FileCacheService.HeaderFileSuffix);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        if (i3 < i16) {
                            break;
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            QLog.w(CacheManager.TAG, 1, "onLowStorage time:" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable th5) {
            QLog.e(CacheManager.TAG, 1, "", th5);
        }
    }

    @Override // cooperation.qzone.cache.FileCacheService.StorageHandler
    public void onCheckAndCleanStorage() {
        synchronized (this) {
            Future future = this.mPendingFuture;
            if (future != null && !future.isDone()) {
                return;
            }
            final boolean isExternalAvailable = CacheManager.isExternalAvailable();
            this.mPendingFuture = PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: cooperation.qzone.cache.FileStorageHandler.4
                @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
                public Object run(ThreadPool.JobContext jobContext) {
                    jobContext.setMode(1);
                    Collection<FileCacheService> collect = FileStorageHandler.this.mCollector.collect();
                    if (collect != null) {
                        for (FileCacheService fileCacheService : collect) {
                            int capacity = fileCacheService.getCapacity(isExternalAvailable);
                            FileStorageHandler.this.checkFileAndClean(fileCacheService.getDir(), capacity);
                        }
                        return null;
                    }
                    return null;
                }
            });
        }
    }

    @Override // cooperation.qzone.cache.FileCacheService.StorageHandler
    public void onLowStorage(FileCacheService fileCacheService, final boolean z16) {
        if (this.mCounter.getAndIncrement() < 2) {
            return;
        }
        this.mCounter.set(0);
        synchronized (this) {
            Future future = this.mPendingFuture;
            if (future != null && !future.isDone()) {
                return;
            }
            this.mPendingFuture = PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: cooperation.qzone.cache.FileStorageHandler.1
                @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
                public Object run(ThreadPool.JobContext jobContext) {
                    jobContext.setMode(1);
                    Collection<FileCacheService> collect = FileStorageHandler.this.mCollector.collect();
                    if (collect != null) {
                        for (FileCacheService fileCacheService2 : collect) {
                            int capacity = fileCacheService2.getCapacity(z16);
                            String dir = fileCacheService2.getDir();
                            int calculateUsedSize = FileStorageHandler.this.calculateUsedSize(dir);
                            int calculateRemainSize = FileStorageHandler.this.calculateRemainSize(capacity, calculateUsedSize);
                            synchronized (FileCacheService.class) {
                                FileStorageHandler.this.cleanOldFile(calculateUsedSize, calculateRemainSize, dir);
                            }
                            QLog.w(CacheManager.TAG, 1, "onLowStorage clear cache service:" + fileCacheService2 + ": remain=" + calculateRemainSize);
                        }
                        if (FileStorageHandler.isStorageSizeLow(CacheManager.getStoreRootPath())) {
                            CacheManager.resetStorePath(false);
                            if (FileStorageHandler.isStorageSizeLow(CacheManager.getStoreRootPath())) {
                                CacheManager.resetStorePath(true);
                                FileStorageHandler.this.notifyStorageWarning();
                                return null;
                            }
                            return null;
                        }
                        return null;
                    }
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStorageWarning() {
    }
}
