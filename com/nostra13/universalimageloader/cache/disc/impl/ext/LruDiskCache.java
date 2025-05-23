package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected DiskLruCache cache;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j3) throws IOException {
        this(file, null, fileNameGenerator, j3, 0);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j3, int i3) throws IOException {
        try {
            this.cache = DiskLruCache.open(file, 1, 1, j3, i3);
        } catch (IOException e16) {
            L.e(e16);
            if (file2 != null) {
                initCache(file2, null, j3, i3);
            }
            if (this.cache != null) {
            } else {
                throw e16;
            }
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e16) {
            L.e(e16);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
        } catch (IOException e17) {
            L.e(e17);
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public void close() {
        try {
            this.cache.close();
        } catch (IOException e16) {
            L.e(e16);
        }
        this.cache = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File get(String str) {
        Throwable th5;
        DiskLruCache.Snapshot snapshot;
        File file = null;
        try {
            snapshot = this.cache.get(getKey(str));
            if (snapshot != null) {
                try {
                    try {
                        file = snapshot.getFile(0);
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (snapshot != null) {
                            snapshot.close();
                        }
                        throw th5;
                    }
                } catch (IOException e16) {
                    e = e16;
                    L.e(e);
                    if (snapshot != null) {
                        snapshot.close();
                    }
                    return null;
                }
            }
            if (snapshot != null) {
                snapshot.close();
            }
            return file;
        } catch (IOException e17) {
            e = e17;
            snapshot = null;
        } catch (Throwable th7) {
            th5 = th7;
            snapshot = null;
            if (snapshot != null) {
            }
            throw th5;
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cache.getDirectory();
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e16) {
            L.e(e16);
            return false;
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) throws IOException {
        DiskLruCache.Editor edit = this.cache.edit(getKey(str));
        if (edit == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            IoUtils.closeSilently(bufferedOutputStream);
            if (copyStream) {
                edit.commit();
            } else {
                edit.abort();
            }
            return copyStream;
        } catch (Throwable th5) {
            IoUtils.closeSilently(bufferedOutputStream);
            edit.abort();
            throw th5;
        }
    }

    public void setBufferSize(int i3) {
        this.bufferSize = i3;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i3) {
        this.compressQuality = i3;
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j3, int i3) throws IOException {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j3 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator != null) {
            long j16 = j3 == 0 ? Long.MAX_VALUE : j3;
            i3 = i3 == 0 ? Integer.MAX_VALUE : i3;
            this.reserveCacheDir = file2;
            this.fileNameGenerator = fileNameGenerator;
            initCache(file, file2, j16, i3);
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) throws IOException {
        DiskLruCache.Editor edit = this.cache.edit(getKey(str));
        if (edit == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                edit.commit();
            } else {
                edit.abort();
            }
            return compress;
        } finally {
            IoUtils.closeSilently(bufferedOutputStream);
        }
    }
}
