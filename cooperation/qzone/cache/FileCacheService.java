package cooperation.qzone.cache;

import android.text.TextUtils;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FileCacheService {
    public static final String HeaderFileSuffix = ".headers";
    private static final int STORAGE_CHECK_INTERVAL = 5;
    public static final String VERSION_FILE = "OldVersion.version";
    private int mExternalCapacity;
    private int mInternalCapacity;
    private final String mName;
    private AtomicInteger mStorageCounter = new AtomicInteger(0);
    private StorageHandler mStorageHandler;
    private int version;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface StorageHandler {
        void onCheckAndCleanStorage();

        void onLowStorage(FileCacheService fileCacheService, boolean z16);
    }

    public FileCacheService(String str, int i3, int i16, int i17) {
        this.version = 0;
        if (!TextUtils.isEmpty(str)) {
            this.mName = str;
            this.version = i3;
            this.mExternalCapacity = i16;
            this.mInternalCapacity = i17;
            return;
        }
        throw new NullPointerException("file cache: name can NOT be empty!");
    }

    private File createFile(String str) {
        String path = getPath(str);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = new File(path);
        if (isFileValid(file)) {
            FileUtils.delete(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e16) {
            QLog.e(CacheManager.TAG, 1, "", e16);
        }
        return file;
    }

    private void ensureStorage() {
        StorageHandler storageHandler;
        if (this.mStorageCounter.getAndIncrement() < 5) {
            return;
        }
        this.mStorageCounter.set(0);
        String dir = getDir();
        if (TextUtils.isEmpty(dir)) {
            return;
        }
        File file = new File(dir);
        while (!file.exists()) {
            file = file.getParentFile();
        }
        if (FileStorageHandler.isStorageSizeLow(file.getAbsolutePath()) && (storageHandler = this.mStorageHandler) != null) {
            storageHandler.onLowStorage(this, !CacheManager.isInternal(dir));
        }
    }

    public static boolean isFileValid(File file) {
        if (file != null && file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

    public void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(CacheManager.TAG, 2, "FileCacheService deleteFile fileName:" + str);
        }
        String path = getPath(str);
        FileUtils.delete(path);
        FileUtils.delete(path + HeaderFileSuffix);
    }

    public int getCapacity(boolean z16) {
        if (z16) {
            return this.mExternalCapacity;
        }
        return this.mInternalCapacity;
    }

    public String getDir() {
        return CacheManager.getCacheDir(this.mName, this.version);
    }

    public File getFile(String str) {
        return getFile(str, false);
    }

    public String getPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String dir = getDir();
        if (TextUtils.isEmpty(dir)) {
            return "";
        }
        return dir + File.separator + str;
    }

    public void setStorageHandler(StorageHandler storageHandler) {
        this.mStorageHandler = storageHandler;
    }

    public void updateLruFile(String str, boolean z16) {
        File file = new File(str);
        if (file.exists() && !file.setLastModified(System.currentTimeMillis()) && QLog.isDevelopLevel()) {
            QLog.w("FileCacheService", 2, "\u66f4\u65b0\u7f13\u5b58\u6587\u4ef6\u7684lru\u6587\u4ef6\u65f6\u95f4\u5931\u8d25. path=" + str);
        }
        ensureStorage();
    }

    public File getFile(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String path = getPath(str);
        File file = path == null ? null : new File(path);
        if (isFileValid(file)) {
            updateLruFile(path, false);
        } else if (z16) {
            file = createFile(str);
            if (isFileValid(file)) {
                updateLruFile(file.getAbsolutePath(), true);
            }
        }
        if (isFileValid(file)) {
            return file;
        }
        return null;
    }
}
