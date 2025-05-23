package com.tencent.qqmini.sdk.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.cache.DiskLruCache;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Storage {
    public static final int CACHE_VERSION = 1;
    public static final int MAX_SIZE = 10485760;
    private static final String TAG = "Storage";
    private String mApkname;
    private WeakReference<Context> mContextRef;
    private DiskLruCache mDiskCache;
    private LruCache<String, String> mLruCache;
    private final int mStorageSize;
    private String mUin;
    public static final Object LOCK = new Object();
    private static final ConcurrentHashMap<String, Storage> mMapList = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface StorageCallback {
        void onFailed(String str, String str2);

        void onSuccess(String str, String str2);
    }

    Storage(Context context, String str, String str2, int i3) {
        this.mStorageSize = i3;
        try {
            String cacheDir = getCacheDir(context.getCacheDir().getAbsolutePath(), str, str2);
            if (!TextUtils.isEmpty(cacheDir)) {
                this.mContextRef = new WeakReference<>(context);
                this.mUin = str;
                this.mApkname = str2;
                this.mDiskCache = DiskLruCache.open(new File(cacheDir), 1, 1, i3);
                this.mLruCache = new LruCache<String, String>(i3) { // from class: com.tencent.qqmini.sdk.cache.Storage.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.util.LruCache
                    public int sizeOf(String str3, String str4) {
                        return (str3 == null ? 0 : str3.length()) + (str4 != null ? str4.length() : 0);
                    }
                };
            } else {
                QMLog.e(TAG, "[Storage] can not create dir");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, th5.getMessage(), th5);
        }
    }

    private boolean commitCache(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if ((getCurrentSize() * 1000) + str2.length() > this.mStorageSize) {
                    QMLog.e(TAG, "exceeded the limit size");
                    return true;
                }
                DiskLruCache.Editor edit = this.mDiskCache.edit(str);
                if (edit != null) {
                    edit.set(0, str2);
                    edit.commit();
                }
                LruCache<String, String> lruCache = this.mLruCache;
                if (lruCache != null) {
                    lruCache.put(str, str2);
                    ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
                    synchronized (concurrentHashMap) {
                        this.mLruCache.trimToSize(this.mStorageSize / concurrentHashMap.keySet().size());
                    }
                }
            }
            DiskLruCache diskLruCache = this.mDiskCache;
            if (diskLruCache != null) {
                try {
                    diskLruCache.flush();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th5) {
            try {
                QMLog.e(TAG, th5.getMessage(), th5);
                DiskLruCache diskLruCache2 = this.mDiskCache;
                if (diskLruCache2 != null) {
                    try {
                        diskLruCache2.flush();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                return true;
            } finally {
                DiskLruCache diskLruCache3 = this.mDiskCache;
                if (diskLruCache3 != null) {
                    try {
                        diskLruCache3.flush();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
            }
        }
    }

    public static void destroy() {
        ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
        synchronized (concurrentHashMap) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                Storage storage = mMapList.get(it.next());
                if (storage != null) {
                    QMLog.e(TAG, "------destroy mDiskCache.closed-----");
                    storage.close();
                }
            }
            mMapList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flushCache(String str, StorageCallback storageCallback, String str2) {
        try {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if ((getCurrentSize() * 1000) + str.length() > 10485760) {
                        QMLog.e(TAG, "exceeded the limit size");
                        if (storageCallback != null) {
                            storageCallback.onFailed(str2, "exceeded the limit size");
                        }
                    }
                    DiskLruCache.Editor edit = this.mDiskCache.edit(str2);
                    if (edit != null) {
                        edit.set(0, str);
                        edit.commit();
                    }
                    LruCache<String, String> lruCache = this.mLruCache;
                    if (lruCache != null) {
                        lruCache.put(str2, str);
                        ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
                        synchronized (concurrentHashMap) {
                            this.mLruCache.trimToSize(this.mStorageSize / concurrentHashMap.keySet().size());
                        }
                    }
                }
                if (storageCallback != null) {
                    storageCallback.onSuccess(str2, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                }
                DiskLruCache diskLruCache = this.mDiskCache;
                if (diskLruCache != null) {
                    diskLruCache.flush();
                }
            } catch (Throwable th5) {
                if (storageCallback != null) {
                    try {
                        storageCallback.onFailed(str2, th5.getMessage());
                    } catch (Throwable th6) {
                        DiskLruCache diskLruCache2 = this.mDiskCache;
                        if (diskLruCache2 != null) {
                            try {
                                diskLruCache2.flush();
                            } catch (Throwable th7) {
                                th7.printStackTrace();
                            }
                        }
                        throw th6;
                    }
                }
                QMLog.e(TAG, th5.getMessage(), th5);
                DiskLruCache diskLruCache3 = this.mDiskCache;
                if (diskLruCache3 != null) {
                    diskLruCache3.flush();
                }
            }
        } catch (Throwable th8) {
            th8.printStackTrace();
        }
    }

    public static String getCacheDir(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str + "/mini");
        sb5.append("/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "default";
        }
        sb5.append(str2);
        String str4 = sb5.toString() + "/" + str3;
        File file = new File(str4);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        QMLog.i(TAG, "[Storage] getCacheDir: " + str4);
        return str4;
    }

    public static long getCurrentStorageSize(String str) {
        try {
            Storage storage = mMapList.get(getToken(String.valueOf(LoginManager.getInstance().getAccount()), str));
            if (storage == null) {
                return -1L;
            }
            return storage.getCurrentSizeBytes();
        } catch (Exception e16) {
            QMLog.e(TAG, "getCurrentStorageSize failed:", e16);
            return -1L;
        }
    }

    private static String getToken(String str, String str2) {
        return str + "_" + str2;
    }

    public static Storage open(Context context, String str, String str2) {
        return openContainerStorage(context, str, str2, 10485760);
    }

    public static Storage openContainerStorage(Context context, String str, String str2, int i3) {
        Storage storage;
        Storage storage2;
        ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
        synchronized (concurrentHashMap) {
            if (context != null) {
                String token = getToken(str, str2);
                storage = concurrentHashMap.get(token);
                if (storage == null) {
                    synchronized (LOCK) {
                        storage2 = concurrentHashMap.get(getToken(str, str2));
                        if (storage2 == null) {
                            storage2 = new Storage(context, str, str2, i3);
                            concurrentHashMap.put(token, storage2);
                        }
                    }
                    storage = storage2;
                }
            } else {
                storage = null;
            }
        }
        return storage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reCreateCache() {
        WeakReference<Context> weakReference = this.mContextRef;
        if (weakReference != null && weakReference.get() != null) {
            String cacheDir = getCacheDir(this.mContextRef.get().getCacheDir().getAbsolutePath(), this.mUin, this.mApkname);
            if (!TextUtils.isEmpty(cacheDir)) {
                this.mContextRef = new WeakReference<>(this.mContextRef.get());
                try {
                    this.mDiskCache = DiskLruCache.open(new File(cacheDir), 1, 1, this.mStorageSize);
                } catch (Throwable th5) {
                    QMLog.e(TAG, th5.getMessage(), th5);
                }
            }
        }
    }

    public boolean clearStorage() {
        LruCache<String, String> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.trimToSize(0);
        }
        DiskLruCache diskLruCache = this.mDiskCache;
        if (diskLruCache != null) {
            try {
                diskLruCache.delete();
                return true;
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
                return false;
            }
        }
        return true;
    }

    public void close() {
        if (this.mDiskCache != null) {
            try {
                QMLog.e(TAG, "------mDiskCache.closed-----");
                this.mDiskCache.close();
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
            }
            LruCache<String, String> lruCache = this.mLruCache;
            if (lruCache != null) {
                lruCache.evictAll();
            }
        }
    }

    public long getCurrentSize() {
        if (this.mDiskCache != null) {
            return (int) Math.ceil(r0.size() / 1000.0d);
        }
        return -1L;
    }

    public long getCurrentSizeBytes() {
        DiskLruCache diskLruCache = this.mDiskCache;
        if (diskLruCache != null) {
            return diskLruCache.size();
        }
        return -1L;
    }

    public int getLimitSize() {
        if (this.mDiskCache != null) {
            return (int) Math.ceil(r0.getMaxSize() / 1000);
        }
        return -1;
    }

    public Set<String> keys() {
        DiskLruCache diskLruCache = this.mDiskCache;
        if (diskLruCache != null && !diskLruCache.isClosed()) {
            return this.mDiskCache.getKeys();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x004a, code lost:
    
        if (r2 != null) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] read(String str) {
        DiskLruCache diskLruCache;
        DiskLruCache.Snapshot snapshot;
        LruCache<String, String> lruCache = this.mLruCache;
        if (lruCache == null) {
            return null;
        }
        String str2 = lruCache.get(str);
        if (TextUtils.isEmpty(str2) && (diskLruCache = this.mDiskCache) != null) {
            try {
                if (diskLruCache.isClosed()) {
                    reCreateCache();
                }
                snapshot = this.mDiskCache.get(str);
                if (snapshot != null) {
                    try {
                        str2 = snapshot.getString(0);
                        this.mLruCache.put(str, str2);
                        ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
                        synchronized (concurrentHashMap) {
                            this.mLruCache.trimToSize(this.mStorageSize / concurrentHashMap.keySet().size());
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            QMLog.e(TAG, th.getMessage(), th);
                        } catch (Throwable th6) {
                            if (snapshot != null) {
                                try {
                                    snapshot.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th6;
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                snapshot = null;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return DiskLruCacheUtil.decode(str2);
    }

    public boolean removeStorage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        LruCache<String, String> lruCache = this.mLruCache;
        if (lruCache != null) {
            lruCache.remove(str);
        }
        DiskLruCache diskLruCache = this.mDiskCache;
        if (diskLruCache != null) {
            if (diskLruCache.isClosed()) {
                reCreateCache();
            }
            try {
                this.mDiskCache.remove(str);
                return true;
            } catch (Throwable th5) {
                QMLog.e(TAG, th5.getMessage(), th5);
                return false;
            }
        }
        return true;
    }

    public void write(final String str, final String str2, final String str3, final StorageCallback storageCallback) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.cache.Storage.2
            @Override // java.lang.Runnable
            public void run() {
                StorageCallback storageCallback2;
                String encode = DiskLruCacheUtil.encode(str2, str3);
                if (encode != null && encode.length() > 1048576 && (storageCallback2 = storageCallback) != null) {
                    storageCallback2.onFailed(str, "size limit reached");
                }
                if (Storage.this.mDiskCache != null) {
                    if (Storage.this.mDiskCache.isClosed()) {
                        Storage.this.reCreateCache();
                    }
                    Storage.this.flushCache(encode, storageCallback, str);
                } else {
                    QMLog.e(Storage.TAG, "mDiskCache.isClosed(): ");
                    StorageCallback storageCallback3 = storageCallback;
                    if (storageCallback3 != null) {
                        storageCallback3.onFailed(str, "can not write");
                    }
                }
            }
        });
    }

    public boolean writeSync(String str, String str2, String str3) {
        try {
            String encode = DiskLruCacheUtil.encode(str3, str2);
            if (encode != null && encode.length() >= 1048576) {
                QMLog.e(TAG, "exceeded the limit size");
                return false;
            }
            DiskLruCache diskLruCache = this.mDiskCache;
            if (diskLruCache != null) {
                if (diskLruCache.isClosed()) {
                    reCreateCache();
                }
                if (commitCache(str, encode)) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Throwable th5) {
            QMLog.e(TAG, "data encode failed.", th5);
            return false;
        }
    }
}
