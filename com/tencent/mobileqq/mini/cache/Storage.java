package com.tencent.mobileqq.mini.cache;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.cache.DiskLruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class Storage {
    public static final int CACHE_VERSION = 1;
    private static final String TAG = "RequestHandler";
    private String mApkname;
    private WeakReference<Context> mContextRef;
    private DiskLruCache mDiskCache;
    private LruCache<String, String> mLruCache;
    private String mUin;
    private static final ConcurrentHashMap<String, Storage> mMapList = new ConcurrentHashMap<>();
    public static final Object lock = new Object();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface StorageCallback {
        void onFailed(String str, String str2);

        void onSuccess(String str, String str2);
    }

    Storage(Context context, String str, String str2) {
        try {
            String cacheDir = getCacheDir(context.getCacheDir().getAbsolutePath(), str, str2);
            if (!TextUtils.isEmpty(cacheDir)) {
                this.mContextRef = new WeakReference<>(context);
                this.mUin = str;
                this.mApkname = str2;
                this.mDiskCache = DiskLruCache.open(new File(cacheDir), 1, 1, 10485760L);
                this.mLruCache = new LruCache<String, String>(10485760) { // from class: com.tencent.mobileqq.mini.cache.Storage.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.support.v4.util.LruCache
                    public int sizeOf(String str3, String str4) {
                        return (str3 == null ? 0 : str3.length()) + (str4 != null ? str4.length() : 0);
                    }
                };
            } else {
                QLog.e(TAG, 1, "[Storage] can not create dir");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public static void destroy() {
        ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
        synchronized (concurrentHashMap) {
            Iterator<String> it = concurrentHashMap.keySet().iterator();
            while (it.hasNext()) {
                Storage storage = mMapList.get(it.next());
                if (storage != null) {
                    QLog.e("StoragePlugin", 1, "------destroy mDiskCache.closed-----");
                    storage.close();
                }
            }
            mMapList.clear();
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
        QLog.i("StoragePlugin", 1, "[Storage] getCacheDir: " + str4);
        return str4;
    }

    private static String getToken(String str, String str2) {
        return str + "_" + str2;
    }

    public static Storage open(Context context, String str, String str2) {
        Storage storage;
        Storage storage2;
        ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
        synchronized (concurrentHashMap) {
            if (context != null) {
                String token = getToken(str, str2);
                storage = concurrentHashMap.get(token);
                if (storage == null) {
                    synchronized (lock) {
                        storage2 = concurrentHashMap.get(getToken(str, str2));
                        if (storage2 == null) {
                            storage2 = new Storage(context, str, str2);
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
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String cacheDir = getCacheDir(this.mContextRef.get().getCacheDir().getAbsolutePath(), this.mUin, this.mApkname);
        if (TextUtils.isEmpty(cacheDir)) {
            return;
        }
        this.mContextRef = new WeakReference<>(this.mContextRef.get());
        try {
            this.mDiskCache = DiskLruCache.open(new File(cacheDir), 1, 1, 10485760L);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
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
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return false;
            }
        }
        return true;
    }

    public void close() {
        if (this.mDiskCache != null) {
            try {
                QLog.e("StoragePlugin", 1, "------mDiskCache.closed-----");
                this.mDiskCache.close();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
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
        if (diskLruCache == null || diskLruCache.isClosed()) {
            return null;
        }
        return this.mDiskCache.getKeys();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r2 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        if (r2 == null) goto L36;
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
                            this.mLruCache.trimToSize(10485760 / concurrentHashMap.keySet().size());
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            QLog.e(TAG, 1, th, new Object[0]);
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
        return Util.decode(str2);
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
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
                return false;
            }
        }
        return true;
    }

    public void write(final String str, final String str2, final String str3, final StorageCallback storageCallback) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.cache.Storage.2
            @Override // java.lang.Runnable
            public void run() {
                String encode = Util.encode(str2, str3);
                if (encode == null || encode.length() <= 1048576) {
                    if (Storage.this.mDiskCache != null) {
                        try {
                            try {
                                if (!TextUtils.isEmpty(encode)) {
                                    if ((Storage.this.getCurrentSize() * 1000) + encode.length() > 10485760) {
                                        QLog.e(Storage.TAG, 1, "exceeded the limit size");
                                        StorageCallback storageCallback2 = storageCallback;
                                        if (storageCallback2 != null) {
                                            storageCallback2.onFailed(str, "exceeded the limit size");
                                        }
                                        if (Storage.this.mDiskCache == null || Storage.this.mDiskCache.isClosed()) {
                                            return;
                                        }
                                        try {
                                            Storage.this.mDiskCache.flush();
                                            return;
                                        } catch (IOException e16) {
                                            e16.printStackTrace();
                                            return;
                                        }
                                    }
                                    if (Storage.this.mDiskCache.isClosed()) {
                                        Storage.this.reCreateCache();
                                    }
                                    DiskLruCache.Editor edit = Storage.this.mDiskCache.edit(str);
                                    if (edit != null) {
                                        edit.set(0, encode);
                                        edit.commit();
                                    }
                                    if (Storage.this.mLruCache != null) {
                                        Storage.this.mLruCache.put(str, encode);
                                        synchronized (Storage.mMapList) {
                                            Storage.this.mLruCache.trimToSize(10485760 / Storage.mMapList.keySet().size());
                                        }
                                    }
                                }
                                StorageCallback storageCallback3 = storageCallback;
                                if (storageCallback3 != null) {
                                    storageCallback3.onSuccess(str, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
                                }
                                if (Storage.this.mDiskCache == null || Storage.this.mDiskCache.isClosed()) {
                                    return;
                                }
                                Storage.this.mDiskCache.flush();
                                return;
                            } catch (Throwable th5) {
                                try {
                                    StorageCallback storageCallback4 = storageCallback;
                                    if (storageCallback4 != null) {
                                        storageCallback4.onFailed(str, th5.getMessage());
                                    }
                                    QLog.e(Storage.TAG, 1, th5, new Object[0]);
                                    if (Storage.this.mDiskCache == null || Storage.this.mDiskCache.isClosed()) {
                                        return;
                                    }
                                    Storage.this.mDiskCache.flush();
                                    return;
                                } catch (Throwable th6) {
                                    if (Storage.this.mDiskCache != null && !Storage.this.mDiskCache.isClosed()) {
                                        try {
                                            Storage.this.mDiskCache.flush();
                                        } catch (IOException e17) {
                                            e17.printStackTrace();
                                        }
                                    }
                                    throw th6;
                                }
                            }
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            return;
                        }
                    }
                    QLog.e("StoragePlugin", 1, "mDiskCache.isClosed(): ");
                    StorageCallback storageCallback5 = storageCallback;
                    if (storageCallback5 != null) {
                        storageCallback5.onFailed(str, "can not write");
                        return;
                    }
                    return;
                }
                StorageCallback storageCallback6 = storageCallback;
                if (storageCallback6 != null) {
                    storageCallback6.onFailed(str, "size limit reached");
                }
            }
        });
    }

    public boolean writeSync(String str, String str2, String str3) {
        if (!Thread.currentThread().getName().equals(Looper.getMainLooper().getThread().getName())) {
            try {
                String encode = Util.encode(str3, str2);
                if (encode != null && encode.length() >= 1048576) {
                    QLog.e(TAG, 1, "exceeded the limit size");
                    return false;
                }
                DiskLruCache diskLruCache = this.mDiskCache;
                if (diskLruCache != null) {
                    if (diskLruCache.isClosed()) {
                        reCreateCache();
                    }
                    try {
                        if (!TextUtils.isEmpty(encode)) {
                            if ((getCurrentSize() * 1000) + encode.length() > 10485760) {
                                QLog.e(TAG, 1, "exceeded the limit size");
                                return false;
                            }
                            DiskLruCache.Editor edit = this.mDiskCache.edit(str);
                            if (edit != null) {
                                edit.set(0, encode);
                                edit.commit();
                            }
                            LruCache<String, String> lruCache = this.mLruCache;
                            if (lruCache != null) {
                                lruCache.put(str, encode);
                                ConcurrentHashMap<String, Storage> concurrentHashMap = mMapList;
                                synchronized (concurrentHashMap) {
                                    this.mLruCache.trimToSize(10485760 / concurrentHashMap.keySet().size());
                                }
                            }
                        }
                        DiskLruCache diskLruCache2 = this.mDiskCache;
                        if (diskLruCache2 != null) {
                            try {
                                diskLruCache2.flush();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            QLog.e(TAG, 1, th5, new Object[0]);
                            DiskLruCache diskLruCache3 = this.mDiskCache;
                            if (diskLruCache3 != null) {
                                try {
                                    diskLruCache3.flush();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            return false;
                        } finally {
                            DiskLruCache diskLruCache4 = this.mDiskCache;
                            if (diskLruCache4 != null) {
                                try {
                                    diskLruCache4.flush();
                                } catch (IOException e18) {
                                    e18.printStackTrace();
                                }
                            }
                        }
                    }
                }
                return true;
            } catch (Throwable th6) {
                QLog.e(TAG, 1, "data encode failed.", th6);
                return false;
            }
        }
        throw new IllegalStateException("ill thread access");
    }
}
