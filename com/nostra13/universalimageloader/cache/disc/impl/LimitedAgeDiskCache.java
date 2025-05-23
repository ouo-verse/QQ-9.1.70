package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LimitedAgeDiskCache extends BaseDiskCache {
    private final Map<File, Long> loadingDates;
    private final long maxFileAge;

    public LimitedAgeDiskCache(File file, long j3) {
        this(file, null, DefaultConfigurationFactory.createFileNameGenerator(), j3);
    }

    private void rememberUsage(String str) {
        File file = getFile(str);
        long currentTimeMillis = System.currentTimeMillis();
        file.setLastModified(currentTimeMillis);
        this.loadingDates.put(file, Long.valueOf(currentTimeMillis));
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public void clear() {
        super.clear();
        this.loadingDates.clear();
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public File get(String str) {
        boolean z16;
        File file = super.get(str);
        if (file != null && file.exists()) {
            Long l3 = this.loadingDates.get(file);
            if (l3 == null) {
                l3 = Long.valueOf(file.lastModified());
                z16 = false;
            } else {
                z16 = true;
            }
            if (System.currentTimeMillis() - l3.longValue() > this.maxFileAge) {
                file.delete();
                this.loadingDates.remove(file);
            } else if (!z16) {
                this.loadingDates.put(file, l3);
            }
        }
        return file;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        this.loadingDates.remove(getFile(str));
        return super.remove(str);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) throws IOException {
        boolean save = super.save(str, inputStream, copyListener);
        rememberUsage(str);
        return save;
    }

    public LimitedAgeDiskCache(File file, File file2, long j3) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator(), j3);
    }

    public LimitedAgeDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j3) {
        super(file, file2, fileNameGenerator);
        this.loadingDates = Collections.synchronizedMap(new HashMap());
        this.maxFileAge = j3 * 1000;
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) throws IOException {
        boolean save = super.save(str, bitmap);
        rememberUsage(str);
        return save;
    }
}
