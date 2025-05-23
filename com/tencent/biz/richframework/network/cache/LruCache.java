package com.tencent.biz.richframework.network.cache;

import com.jakewharton.disklrucache.DiskLruCache;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.cache.Cache;
import com.tencent.biz.richframework.network.util.Encrypt;
import com.tencent.biz.richframework.network.util.SdCardUtil;
import com.tencent.biz.richframework.network.util.StringUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class LruCache extends Cache {
    protected static long CacheSize = 15728640;
    protected static final int DISK_CACHE_INDEX = 0;
    private static final long INTERNAL_FILE_CACHE_SIZE = 15728640;
    protected static int IO_BUFFER_SIZE = 8192;
    private static final String TAG = "LruCache";
    private static String mAppCacheDir;
    private static String mPackgeName;
    protected DiskLruCache mDiskLruCache = null;
    private Object mWriteLock = new Object();
    private boolean mIsWriting = false;
    private String mCurrentCacheName = "";

    public LruCache(String str, String str2) {
        mPackgeName = str;
        mAppCacheDir = str2;
        initDiskCache();
    }

    private int getInstanceHashCode() {
        if (getInstance() == null) {
            return 0;
        }
        return getInstance().hashCode();
    }

    private synchronized void initDiskCache() {
        if (getInstance() == null || getInstance().isClosed()) {
            if (!SdCardUtil.sdCardExists()) {
                CacheSize = INTERNAL_FILE_CACHE_SIZE;
            }
            String cacheDir = getCacheDir();
            File file = new File(cacheDir);
            if (!file.exists()) {
                RFWLog.w(TAG, RFWLog.DEV, "Dir: \"" + cacheDir + "\" not exists, create dir. cache size: " + StringUtils.formatSize(CacheSize));
                file.mkdirs();
            } else {
                RFWLog.d(TAG, RFWLog.DEV, "Dir: \"" + cacheDir + "\" exists. cache size: " + StringUtils.formatSize(CacheSize));
            }
            open(file);
        }
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public boolean cacheExists(String str) {
        initDiskCache();
        boolean z16 = false;
        if (getInstance() != null) {
            try {
                String cacheName = getCacheName(str);
                synchronized (this.mDiskLruCache) {
                    DiskLruCache.Snapshot snapshot = getInstance().get(cacheName);
                    if (snapshot != null) {
                        snapshot.close();
                        z16 = true;
                    } else {
                        RFWLog.w(TAG, RFWLog.DEV, "check cache exists error: snapshot is null. Cache name: " + cacheName + ", Url: " + str);
                    }
                }
            } catch (UnsupportedEncodingException unused) {
                RFWLog.w(TAG, RFWLog.DEV, "check cache exists error: " + str);
            } catch (IOException unused2) {
                RFWLog.w(TAG, RFWLog.DEV, "check cache exists IO error: " + str);
            }
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public void clear() {
        initDiskCache();
        try {
            synchronized (this.mDiskLruCache) {
                getInstance().delete();
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public String get(String str) {
        initDiskCache();
        String str2 = "";
        if (getInstance() == null) {
            return "";
        }
        try {
            DiskLruCache.Snapshot snapshot = getInstance().get(getCacheName(str));
            if (snapshot == null) {
                return "";
            }
            String decrypt = Encrypt.decrypt(snapshot.getString(0));
            try {
                snapshot.close();
                return decrypt;
            } catch (IOException e16) {
                e = e16;
                str2 = decrypt;
                e.printStackTrace();
                return str2;
            } catch (NumberFormatException e17) {
                e = e17;
                str2 = decrypt;
                e.printStackTrace();
                return str2;
            }
        } catch (IOException e18) {
            e = e18;
        } catch (NumberFormatException e19) {
            e = e19;
        }
    }

    public String getCacheDir() {
        String sb5;
        if (SdCardUtil.sdCardExists()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(SdCardUtil.getSdCardDirectory());
            String str = File.separator;
            sb6.append(str);
            sb6.append("Android");
            sb6.append(str);
            sb6.append("data");
            sb6.append(str);
            sb6.append(mPackgeName);
            sb6.append(str);
            sb6.append("cache");
            sb6.append(str);
            sb6.append(getCacheTag());
            sb5 = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(mAppCacheDir);
            String str2 = File.separator;
            sb7.append(str2);
            sb7.append("cache");
            sb7.append(str2);
            sb7.append(getCacheTag());
            sb5 = sb7.toString();
        }
        RFWLog.d(TAG, RFWLog.DEV, "Init cache dir: " + sb5);
        return sb5;
    }

    protected abstract String getCacheTag();

    protected DiskLruCache getInstance() {
        return this.mDiskLruCache;
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public Cache.CacheInputStream getStream(String str) {
        DiskLruCache.Snapshot snapshot;
        initDiskCache();
        Cache.CacheInputStream cacheInputStream = new Cache.CacheInputStream();
        String cacheName = getCacheName(str);
        if (getInstance() != null && cacheName != null) {
            try {
                snapshot = getInstance().get(cacheName);
            } catch (IOException unused) {
                RFWLog.w(TAG, RFWLog.DEV, "Get cache error: Cache name: " + cacheName + ", Url: " + str);
                snapshot = null;
            }
            if (snapshot != null) {
                cacheInputStream.setSnapshot(snapshot);
                cacheInputStream.setInputStream(snapshot.getInputStream(0));
                if (cacheInputStream.getInputStream() == null) {
                    RFWLog.w(TAG, RFWLog.DEV, "Get cache error: InputStream is null. Cache name: " + cacheName + ", Url: " + str);
                } else {
                    RFWLog.i(TAG, RFWLog.DEV, "Get cache success: Cache name: " + cacheName + ", Url: " + str);
                }
            } else {
                RFWLog.w(TAG, RFWLog.DEV, "Get cache error: snapshot is null. Cache name: " + cacheName + ", Url: " + str + ",instance hashCode:" + getInstanceHashCode());
            }
        } else {
            RFWLog.w(TAG, RFWLog.DEV, "Get cache error: DiskCache or cacheName is null. Cache name: " + cacheName + ", Url: " + str);
        }
        return cacheInputStream;
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public void interrupt(String str) {
        synchronized (this.mWriteLock) {
            if (this.mCurrentCacheName.equals(str) && this.mIsWriting) {
                this.mIsWriting = false;
            }
        }
    }

    protected boolean open(File file) {
        RFWLog.d(TAG, RFWLog.DEV, "Open cache dir.");
        try {
            this.mDiskLruCache = DiskLruCache.open(file, 1, 1, CacheSize);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public void remove(String str) {
        initDiskCache();
        try {
            synchronized (this.mDiskLruCache) {
                getInstance().remove(getCacheName(str));
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        } catch (NullPointerException e17) {
            e17.printStackTrace();
        }
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public boolean set(String str, String str2) {
        DiskLruCache.Editor editor;
        initDiskCache();
        String cacheName = getCacheName(str);
        boolean z16 = false;
        if (getInstance() != null && cacheName != null) {
            synchronized (this.mDiskLruCache) {
                try {
                    editor = getInstance().edit(cacheName);
                } catch (IOException unused) {
                    RFWLog.w(TAG, RFWLog.DEV, "Set cache error: Exception ");
                    editor = null;
                }
                if (editor != null) {
                    RFWLog.i(TAG, RFWLog.DEV, "name: " + str + ", Cache name: " + cacheName + ", value length: " + str2.length());
                    try {
                        editor.set(0, Encrypt.encrypt(str2));
                        editor.commit();
                        z16 = true;
                    } catch (IOException unused2) {
                        RFWLog.w(TAG, RFWLog.DEV, "Commit cache error: Exception ");
                    }
                }
                this.mDiskLruCache.notifyAll();
            }
        }
        return z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.tencent.biz.richframework.network.cache.Cache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean setStream(String str, InputStream inputStream) {
        boolean z16;
        DiskLruCache.Editor editor;
        synchronized (this.mWriteLock) {
            z16 = true;
            this.mIsWriting = true;
            this.mCurrentCacheName = str;
        }
        initDiskCache();
        String cacheName = getCacheName(str);
        if (getInstance() != null && cacheName != null && inputStream != null) {
            synchronized (this.mDiskLruCache) {
                ?? r46 = 0;
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    editor = getInstance().edit(cacheName);
                } catch (IOException unused) {
                    RFWLog.w(TAG, RFWLog.DEV, "Edit diskcache cache error. Cache name: " + cacheName + ", Uri: " + str);
                    editor = null;
                }
                try {
                    if (editor != null) {
                        try {
                            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(editor.newOutputStream(0), IO_BUFFER_SIZE);
                            try {
                                byte[] bArr = new byte[IO_BUFFER_SIZE];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    if (!this.mIsWriting) {
                                        RFWLog.e(TAG, RFWLog.DEV, "Interrupt write cache.");
                                        break;
                                    }
                                    RFWLog.d(TAG, RFWLog.DEV, cacheName + " Write buff, size " + read);
                                    bufferedOutputStream2.write(bArr, 0, read);
                                }
                                bufferedOutputStream2.flush();
                                editor.commit();
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            } catch (IOException unused2) {
                                bufferedOutputStream = bufferedOutputStream2;
                                RFWLog.w(TAG, RFWLog.DEV, "Set diskcache cache error. Cache name: " + cacheName + ", Uri: " + str + ", hashCode:" + getInstanceHashCode());
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                z16 = false;
                                r46 = RFWLog.DEV;
                                RFWLog.i(TAG, r46, "Set Cache file success. Cache name: " + cacheName + ", Uri: " + str + ", hashCode:" + getInstanceHashCode());
                                this.mDiskLruCache.notifyAll();
                                if (!this.mIsWriting) {
                                }
                                synchronized (this.mWriteLock) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                r46 = bufferedOutputStream2;
                                if (r46 != 0) {
                                    try {
                                        r46.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException unused3) {
                        }
                        r46 = RFWLog.DEV;
                        RFWLog.i(TAG, r46, "Set Cache file success. Cache name: " + cacheName + ", Uri: " + str + ", hashCode:" + getInstanceHashCode());
                    } else {
                        RFWLog.w(TAG, RFWLog.DEV, "Editor is null. Cache name: " + cacheName + ", Uri: " + str);
                        z16 = false;
                    }
                    this.mDiskLruCache.notifyAll();
                } catch (Throwable th6) {
                    th = th6;
                }
            }
            if (!this.mIsWriting) {
                remove(str);
            }
        } else {
            RFWLog.w(TAG, RFWLog.DEV, "DiskCache or cacheName is null. Cache name: " + cacheName + ", Uri: " + str);
            z16 = false;
        }
        synchronized (this.mWriteLock) {
            this.mIsWriting = false;
            this.mCurrentCacheName = "";
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.network.cache.Cache
    public long size() {
        initDiskCache();
        return getInstance().size();
    }
}
