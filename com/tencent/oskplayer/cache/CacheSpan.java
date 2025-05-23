package com.tencent.oskplayer.cache;

import com.tencent.oskplayer.proxy.FileType;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CacheSpan implements Comparable<CacheSpan> {
    private static final String SUFFIX = ".v6.dat";
    private static final String SUFFIX_ESCAPED = "\\.v6\\.dat";
    private static final Pattern cacheFilePattern = Pattern.compile("^([^.]+)\\.(\\d+)\\.(\\d+)\\.(\\w+)\\.(\\d+)(\\.v6\\.dat)$");
    public final File file;
    public final FileType fileType;
    public final boolean isCached;
    public final String key;
    public final long lastAccessTimestamp;
    public final long length;
    public final long position;
    public final long totalLength;

    CacheSpan(String str, long j3, long j16, long j17, FileType fileType, boolean z16, long j18, File file) {
        this.key = str;
        this.position = j3;
        this.length = j16;
        this.totalLength = j17;
        this.fileType = fileType;
        this.isCached = z16;
        this.file = file;
        this.lastAccessTimestamp = j18;
    }

    public static CacheSpan createCacheEntry(File file) {
        Matcher matcher = cacheFilePattern.matcher(file.getName());
        if (matcher.matches()) {
            return createCacheEntry(matcher.group(1), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)), FileType.decode(matcher.group(4)), Long.parseLong(matcher.group(5)), file);
        }
        return null;
    }

    public static CacheSpan createClosedHole(String str, long j3, long j16) {
        return new CacheSpan(str, j3, j16, -1L, FileType.UNKNOWN, false, -1L, null);
    }

    public static CacheSpan createLookup(String str, long j3) {
        return new CacheSpan(str, j3, -1L, -1L, FileType.UNKNOWN, false, -1L, null);
    }

    public static CacheSpan createOpenHole(String str, long j3) {
        return new CacheSpan(str, j3, -1L, -1L, FileType.UNKNOWN, false, -1L, null);
    }

    public static File getCacheFileName(File file, String str, long j3, long j16, FileType fileType, long j17) {
        return new File(file, str + "." + j3 + "." + j16 + "." + fileType.encode() + "." + j17 + SUFFIX);
    }

    public boolean isOpenEnded() {
        if (this.length == -1) {
            return true;
        }
        return false;
    }

    public CacheSpan touch() {
        long currentTimeMillis = System.currentTimeMillis();
        File cacheFileName = getCacheFileName(this.file.getParentFile(), this.key, this.position, this.totalLength, this.fileType, currentTimeMillis);
        this.file.renameTo(cacheFileName);
        return createCacheEntry(this.key, this.position, this.totalLength, this.fileType, currentTimeMillis, cacheFileName);
    }

    @Override // java.lang.Comparable
    public int compareTo(CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        long j3 = this.position - cacheSpan.position;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }

    private static CacheSpan createCacheEntry(String str, long j3, long j16, FileType fileType, long j17, File file) {
        return new CacheSpan(str, j3, file.length(), j16, fileType, true, j17, file);
    }
}
