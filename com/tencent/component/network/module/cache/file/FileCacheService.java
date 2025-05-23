package com.tencent.component.network.module.cache.file;

import android.content.Context;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.CacheManager;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes5.dex */
public class FileCacheService {
    private static final String DIR_NAME = "file";
    private static final long MEGABYTES = 1048576;
    private static final int STORAGE_CHECK_INTERVAL = 3;
    private static final long STORAGE_LOW_BOUNDS = 10485760;
    private static Comparator<FileEntry> sFileComparator = new Comparator<FileEntry>() { // from class: com.tencent.component.network.module.cache.file.FileCacheService.2
        @Override // java.util.Comparator
        public int compare(FileEntry fileEntry, FileEntry fileEntry2) {
            long j3 = fileEntry.lastModified;
            long j16 = fileEntry2.lastModified;
            if (j3 < j16) {
                return -1;
            }
            return j3 == j16 ? 0 : 1;
        }
    };
    private final Context mContext;
    private final FileCache<String> mExternalCache;
    private final FileCache<String> mInternalCache;
    private final String mName;
    private final boolean mPersist;
    private AtomicInteger mStorageCounter;
    private StorageHandler mStorageHandler;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class FileEntry {
        public final boolean isFile;
        public final long lastModified;
        public final String name;
        public final String path;

        public FileEntry(String str, String str2) {
            File file = new File(str, str2);
            this.path = file.getPath();
            this.name = str2;
            this.lastModified = file.lastModified();
            this.isFile = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface StorageHandler {
        void onLowStorage(FileCacheService fileCacheService, long j3, long j16, boolean z16);
    }

    public FileCacheService(Context context, String str, int i3) {
        this(context, str, i3, false);
    }

    private File createFile(String str, boolean z16) {
        String path = getPath(str, z16);
        if (path == null) {
            return null;
        }
        File file = new File(path);
        if (!isFileValid(file)) {
            FileUtils.delete(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e16) {
            QDLog.e("FileCacheService", "", e16);
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ensureCache(boolean z16) {
        String dir = getDir(z16);
        FileCache<String> cache = getCache(z16);
        if (TextUtils.isEmpty(dir)) {
            return;
        }
        String[] list = new File(dir).list();
        if (list != null && list.length != 0) {
            int length = list.length;
            FileEntry[] fileEntryArr = new FileEntry[length];
            for (int i3 = 0; i3 < length; i3++) {
                fileEntryArr[i3] = new FileEntry(dir, list[i3]);
            }
            Arrays.sort(fileEntryArr, sFileComparator);
            for (int i16 = 0; i16 < length; i16++) {
                FileEntry fileEntry = fileEntryArr[i16];
                if (fileEntry != null) {
                    if (!fileEntry.isFile) {
                        FileUtils.delete(fileEntry.path);
                    } else {
                        cache.put(fileEntry.name, fileEntry.path);
                    }
                }
            }
        }
    }

    private void ensureStorage(boolean z16) {
        if (this.mStorageCounter.getAndIncrement() < 3) {
            return;
        }
        this.mStorageCounter.set(0);
        File file = new File(getDir(z16));
        while (!file.exists()) {
            file = file.getParentFile();
        }
        StatFs statFs = new StatFs(file.getAbsolutePath());
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        long availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
        StorageHandler storageHandler = this.mStorageHandler;
        if (availableBlocks < STORAGE_LOW_BOUNDS && storageHandler != null) {
            storageHandler.onLowStorage(this, blockCount, availableBlocks, z16);
        }
    }

    private FileCache<String> getCache(boolean z16) {
        if (z16) {
            return this.mExternalCache;
        }
        return this.mInternalCache;
    }

    private String getDir(boolean z16) {
        if (z16) {
            return CacheManager.getExternalCacheDir(this.mContext, this.mName, this.mPersist);
        }
        return CacheManager.getInternalCacheDir(this.mContext, this.mName, this.mPersist);
    }

    private void init() {
        if (isMainThread()) {
            PriorityThreadPool.getDefault().submit(new ThreadPool.Job<Object>() { // from class: com.tencent.component.network.module.cache.file.FileCacheService.1
                @Override // com.tencent.component.network.utils.thread.ThreadPool.Job
                public Object run(ThreadPool.JobContext jobContext) {
                    FileCacheService.this.ensureCache(false);
                    FileCacheService.this.ensureCache(true);
                    return null;
                }
            });
        } else {
            ensureCache(false);
            ensureCache(true);
        }
    }

    private static boolean isFileValid(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    public synchronized void clear() {
        getCache(false).evictAll();
        getCache(true).evictAll();
    }

    public void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        getCache(false).remove(str);
        getCache(true).remove(str);
        String path = getPath(str, false);
        String path2 = getPath(str, true);
        FileUtils.delete(path);
        FileUtils.delete(path2);
    }

    public int getCapacity(boolean z16) {
        FileCache<String> fileCache;
        if (z16) {
            fileCache = this.mExternalCache;
        } else {
            fileCache = this.mInternalCache;
        }
        return fileCache.maxSize();
    }

    public Context getContext() {
        return this.mContext;
    }

    public File getFile(String str) {
        return getFile(str, false);
    }

    public String getPath(String str) {
        return getPath(str, CacheManager.isExternalAvailable());
    }

    public int getSize(boolean z16) {
        FileCache<String> fileCache;
        if (z16) {
            fileCache = this.mExternalCache;
        } else {
            fileCache = this.mInternalCache;
        }
        return fileCache.size();
    }

    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public boolean isPersist() {
        return this.mPersist;
    }

    public boolean putFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean isExternalAvailable = CacheManager.isExternalAvailable();
        boolean putFile = putFile(str, isExternalAvailable);
        return (putFile || !isExternalAvailable) ? putFile : putFile(str, false);
    }

    public void setStorageHandler(StorageHandler storageHandler) {
        this.mStorageHandler = storageHandler;
    }

    public String toString() {
        return "AlbumUtil#" + this.mName + "#capacity=" + getCapacity(true) + "," + getCapacity(false) + "#size=" + getSize(true) + "," + getSize(false);
    }

    public FileCacheService(Context context, String str, int i3, boolean z16) {
        this(context, str, i3, 0, z16);
    }

    public File getFile(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean isExternalAvailable = CacheManager.isExternalAvailable();
        String str2 = getCache(isExternalAvailable).get(str);
        File file = str2 == null ? null : new File(str2);
        if (!isFileValid(file) && isExternalAvailable) {
            String str3 = getCache(false).get(str);
            file = str3 == null ? null : new File(str3);
        }
        if (z16 && !isFileValid(file)) {
            File createFile = createFile(str, isExternalAvailable);
            if (!isFileValid(createFile)) {
                createFile = createFile(str, false);
            }
            file = createFile;
            if (isFileValid(file)) {
                putFile(str);
            }
        }
        if (isFileValid(file)) {
            return file;
        }
        return null;
    }

    public FileCacheService(Context context, String str, int i3, int i16, boolean z16) {
        this.mStorageCounter = new AtomicInteger(0);
        if (!TextUtils.isEmpty(str)) {
            this.mContext = context.getApplicationContext();
            this.mName = "file" + File.separator + str;
            this.mPersist = z16;
            i16 = i16 < 0 ? 0 : i16;
            this.mExternalCache = new FileCache<>(i3 <= 0 ? Integer.MAX_VALUE : i3);
            this.mInternalCache = new FileCache<>(i16);
            init();
            return;
        }
        throw new NullPointerException("file cache: name can NOT be empty!");
    }

    public String getPath(String str, boolean z16) {
        String dir;
        if (TextUtils.isEmpty(str) || (dir = getDir(z16)) == null) {
            return null;
        }
        return dir + File.separator + str;
    }

    public synchronized void clear(boolean z16) {
        getCache(z16).evictAll();
    }

    private boolean putFile(String str, boolean z16) {
        FileCache<String> cache = getCache(z16);
        String path = getPath(str, z16);
        if (path == null) {
            return false;
        }
        File file = new File(path);
        if (file.isDirectory()) {
            FileUtils.delete(file);
        }
        if (!isFileValid(file)) {
            return false;
        }
        cache.put(str, file.getAbsolutePath());
        ensureStorage(z16);
        return true;
    }

    public synchronized void clear(boolean z16, int i3) {
        getCache(z16).trimToSize(i3);
    }
}
