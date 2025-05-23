package com.tencent.oskplayer.cache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.DataSink;
import com.tencent.oskplayer.datasource.DataSource;
import com.tencent.oskplayer.datasource.DataSpec;
import com.tencent.oskplayer.datasource.FileDataSource;
import com.tencent.oskplayer.datasource.HttpDataSource;
import com.tencent.oskplayer.datasource.TeeDataSource;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class CacheDataSource implements DataSource {
    private static final String TAG = "CacheDataSource";
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private DataSource currentDataSource;
    private boolean dataSourceReadStart;
    private final EventListener eventListener;
    private String extraLogTag;
    private int flags;
    private boolean ignoreCache;
    private final boolean ignoreCacheOnError;
    private String key;
    private CacheSpan lockedSpan;
    private long openCost;
    private int priority;
    private long readPosition;
    private long totalCachedBytesRead;
    private long totalLength;
    private int totalUpstreamBytesRead;
    private long totalUpstreamReadCost;
    private final DataSource upstreamDataSource;
    private Uri uri;
    private String uuid;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface EventListener {
        void downloadSizeAndDuration(String str, int i3, long j3, long j16, long j17);

        void onCachedAttrRead(long j3);

        void onCachedBytesRead(long j3, long j16);

        void onHttpUpstreamServerCost(String str, long j3, long j16, long j17);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, boolean z16, boolean z17) {
        this(cache, dataSource, z16, z17, Long.MAX_VALUE);
    }

    private void closeCurrentSource() throws IOException {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
            this.currentDataSource = null;
        } finally {
            CacheSpan cacheSpan = this.lockedSpan;
            if (cacheSpan != null) {
                this.cache.releaseHoleSpan(cacheSpan);
                this.lockedSpan = null;
            }
        }
    }

    private void handleBeforeThrow(IOException iOException) {
        PlayerUtils.log(3, getLogTag(), "handleBeforeThrow " + iOException + ",ignoreCacheOnError=" + this.ignoreCacheOnError + ",currentDataSource=" + this.currentDataSource);
        if (this.ignoreCacheOnError && this.currentDataSource == this.cacheReadDataSource) {
            PlayerUtils.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.currentDataSource + ",exception=" + iOException);
            this.ignoreCache = true;
        }
    }

    private void notifyBytesRead() {
        EventListener eventListener = this.eventListener;
        if (eventListener != null) {
            if (this.priority == 90) {
                eventListener.downloadSizeAndDuration(this.uuid, this.totalUpstreamBytesRead, this.totalUpstreamReadCost, this.totalLength, this.totalCachedBytesRead);
            }
            this.totalUpstreamBytesRead = 0;
            this.totalUpstreamReadCost = 0L;
            if (this.currentDataSource == this.cacheReadDataSource && this.totalCachedBytesRead > 0) {
                this.eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
                this.totalCachedBytesRead = 0L;
            }
        }
    }

    private long openNextSource() throws IOException {
        CacheSpan startReadWriteNonBlocking;
        long j3;
        DataSpec dataSpec;
        File file;
        try {
            if (this.ignoreCache) {
                startReadWriteNonBlocking = null;
            } else if (this.blockOnCache) {
                startReadWriteNonBlocking = this.cache.startReadWrite(this.key, this.readPosition);
            } else {
                startReadWriteNonBlocking = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
            }
            if (startReadWriteNonBlocking == null) {
                this.currentDataSource = this.upstreamDataSource;
                Uri uri = this.uri;
                long j16 = this.readPosition;
                dataSpec = new DataSpec(uri, j16, j16, this.bytesRemaining, this.key, this.flags, this.uuid, this.priority);
            } else if (startReadWriteNonBlocking.isCached) {
                Uri fromFile = Uri.fromFile(startReadWriteNonBlocking.file);
                long j17 = this.readPosition;
                long j18 = j17 - startReadWriteNonBlocking.position;
                long j19 = this.bytesRemaining;
                if (j19 == -1) {
                    this.bytesRemaining = startReadWriteNonBlocking.totalLength - j17;
                } else if (j19 > startReadWriteNonBlocking.totalLength - j17) {
                    PlayerUtils.log(5, getLogTag(), "fix bytesRemaining. max=" + (startReadWriteNonBlocking.totalLength - this.readPosition) + " current=" + this.bytesRemaining);
                    this.bytesRemaining = startReadWriteNonBlocking.totalLength - this.readPosition;
                }
                DataSpec dataSpec2 = new DataSpec(fromFile, this.readPosition, j18, Math.min(startReadWriteNonBlocking.length - j18, this.bytesRemaining), this.key, this.flags, this.uuid, this.priority);
                this.currentDataSource = this.cacheReadDataSource;
                if (this.eventListener != null && (file = startReadWriteNonBlocking.file) != null && file.lastModified() < 628358400) {
                    this.eventListener.onCachedAttrRead(startReadWriteNonBlocking.file.lastModified());
                }
                dataSpec = dataSpec2;
            } else {
                this.lockedSpan = startReadWriteNonBlocking;
                if (startReadWriteNonBlocking.isOpenEnded()) {
                    j3 = this.bytesRemaining;
                } else {
                    long j26 = this.bytesRemaining;
                    if (j26 != -1) {
                        j3 = Math.min(startReadWriteNonBlocking.length, j26);
                    } else {
                        j3 = startReadWriteNonBlocking.length;
                    }
                }
                long j27 = j3;
                Uri uri2 = this.uri;
                long j28 = this.readPosition;
                dataSpec = new DataSpec(uri2, j28, j28, j27, this.key, this.flags, this.uuid, this.priority);
                DataSource dataSource = this.cacheWriteDataSource;
                if (dataSource == null) {
                    dataSource = this.upstreamDataSource;
                }
                this.currentDataSource = dataSource;
            }
            long open = this.currentDataSource.open(dataSpec);
            DataSource dataSource2 = this.currentDataSource;
            if ((dataSource2 instanceof HttpDataSource) && dataSource2.getTotalLength() != -1 && dataSpec.position >= this.currentDataSource.getTotalLength() - 1) {
                PlayerUtils.log(6, getLogTag(), "read position out of bound");
            }
            if (this.bytesRemaining == -1 && this.currentDataSource.getTotalLength() != -1) {
                this.bytesRemaining = this.currentDataSource.getTotalLength() - this.readPosition;
                PlayerUtils.log(4, getLogTag(), "init bytesRemaining " + this.bytesRemaining + ", readPosition=" + this.readPosition + ",totalLength=" + this.currentDataSource.getTotalLength());
            }
            this.bytesRemaining = Math.max(0L, Math.min(this.bytesRemaining, getTotalLength()));
            this.dataSourceReadStart = false;
            return open;
        } catch (InterruptedException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long available() {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return 0L;
        }
        return dataSource.available();
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void close() throws IOException {
        try {
            closeCurrentSource();
        } catch (IOException e16) {
            if (this.currentDataSource instanceof FileDataSource) {
                PlayerUtils.log(6, getLogTag(), "close cache error " + e16.toString());
            } else {
                PlayerUtils.log(6, getLogTag(), "close error " + e16.toString());
            }
            handleBeforeThrow(e16);
            throw e16;
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public FileType getFileType() {
        Cache cache;
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return FileType.UNKNOWN;
        }
        if (dataSource == this.cacheReadDataSource && (cache = this.cache) != null) {
            return cache.getContentType(this.key);
        }
        return dataSource.getFileType();
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public String getLogTag() {
        return this.extraLogTag + TAG;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long getTotalLength() {
        Cache cache;
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return -1L;
        }
        if (dataSource == this.cacheReadDataSource && (cache = this.cache) != null) {
            return cache.getTotalLength(this.key);
        }
        return dataSource.getTotalLength();
    }

    public DataSource getUpstreamDataSource() {
        return this.upstreamDataSource;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        try {
            this.uri = dataSpec.uri;
            this.flags = dataSpec.flags;
            this.uuid = dataSpec.uuid;
            this.key = dataSpec.key;
            this.readPosition = dataSpec.position;
            this.bytesRemaining = dataSpec.length;
            this.priority = dataSpec.priority;
            long currentTimeMillis = System.currentTimeMillis();
            long openNextSource = openNextSource();
            this.totalLength = getTotalLength();
            this.openCost = System.currentTimeMillis() - currentTimeMillis;
            return openNextSource;
        } catch (IOException e16) {
            if (this.currentDataSource instanceof FileDataSource) {
                PlayerUtils.log(6, getLogTag(), "open cache error " + e16.toString());
            } else {
                PlayerUtils.log(6, getLogTag(), "open error " + e16.toString());
            }
            handleBeforeThrow(e16);
            if (this.ignoreCache) {
                try {
                    closeCurrentSource();
                } catch (Exception e17) {
                    PlayerUtils.log(5, getLogTag(), "failed on closeCurrentSource, shouldn't be a problem", e17);
                }
                PlayerUtils.log(6, getLogTag(), "open cache error try reopen without cache");
                long currentTimeMillis2 = System.currentTimeMillis();
                long openNextSource2 = openNextSource();
                this.totalLength = getTotalLength();
                this.openCost = System.currentTimeMillis() - currentTimeMillis2;
                return openNextSource2;
            }
            throw e16;
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        EventListener eventListener;
        try {
            if (!this.dataSourceReadStart && (this.currentDataSource instanceof FileDataSource) && PlayerConfig.g().isDebugVersion()) {
                PlayerUtils.log(4, getLogTag(), "read from cache " + ((FileDataSource) this.currentDataSource).getUri() + " filesize=" + ((FileDataSource) this.currentDataSource).available());
            }
            long currentTimeMillis = System.currentTimeMillis();
            int read = this.currentDataSource.read(bArr, i3, i16);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (!this.dataSourceReadStart) {
                if (this.currentDataSource != this.cacheReadDataSource && PlayerConfig.g().getVideoReporter() != null && this.priority == 90 && URLUtil.isNetworkUrl(this.uri.toString()) && (eventListener = this.eventListener) != null) {
                    String str = this.uuid;
                    long j3 = this.openCost;
                    eventListener.onHttpUpstreamServerCost(str, j3, j3, currentTimeMillis2);
                }
                this.dataSourceReadStart = true;
            }
            if (read >= 0) {
                if (this.currentDataSource == this.cacheReadDataSource) {
                    this.totalCachedBytesRead += read;
                } else {
                    this.totalUpstreamBytesRead += read;
                    this.totalUpstreamReadCost += currentTimeMillis2;
                }
                long j16 = read;
                this.readPosition += j16;
                long j17 = this.bytesRemaining;
                if (j17 != -1) {
                    this.bytesRemaining = j17 - j16;
                    return read;
                }
                return read;
            }
            notifyBytesRead();
            closeCurrentSource();
            long j18 = this.bytesRemaining;
            if (j18 > 0 && j18 != -1) {
                openNextSource();
                return read(bArr, i3, i16);
            }
            return read;
        } catch (IOException e16) {
            if (this.currentDataSource instanceof FileDataSource) {
                PlayerUtils.log(6, getLogTag(), "read cache error " + e16.toString());
            } else {
                PlayerUtils.log(6, getLogTag(), "read error " + e16.toString());
            }
            handleBeforeThrow(e16);
            throw e16;
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void setLogTag(String str) {
        this.extraLogTag = str;
    }

    public CacheDataSource(Cache cache, DataSource dataSource, boolean z16, boolean z17, long j3) {
        this(cache, dataSource, new FileDataSource(), new CacheDataSink(cache, j3), z16, z17, null);
    }

    public CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, boolean z16, boolean z17, EventListener eventListener) {
        this.openCost = 0L;
        this.extraLogTag = "";
        this.cache = cache;
        this.cacheReadDataSource = dataSource2;
        this.blockOnCache = z16;
        this.ignoreCacheOnError = z17;
        this.upstreamDataSource = dataSource;
        if (dataSink != null) {
            this.cacheWriteDataSource = new TeeDataSource(dataSource, dataSink);
        } else {
            this.cacheWriteDataSource = null;
        }
        this.eventListener = eventListener;
    }
}
