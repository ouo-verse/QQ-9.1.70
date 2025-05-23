package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.cache.CacheDataSink;
import com.tencent.oskplayer.proxy.FileType;
import com.tencent.oskplayer.util.Assertions;
import com.tencent.oskplayer.util.PlayerUtils;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TeeDataSource implements DataSource {
    private static final String TAG = "TeeDataSource";
    private final DataSink dataSink;
    private String extraLogTag = "";
    private boolean ignoreCacheSink;
    private boolean isCacheSinkOpen;
    private final DataSource upstream;

    public TeeDataSource(DataSource dataSource, DataSink dataSink) {
        this.upstream = (DataSource) Assertions.checkNotNull(dataSource);
        this.dataSink = (DataSink) Assertions.checkNotNull(dataSink);
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long available() {
        return this.upstream.available();
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void close() throws IOException {
        try {
            this.upstream.close();
            try {
                if (this.isCacheSinkOpen) {
                    this.dataSink.close();
                }
            } catch (CacheDataSink.CacheDataSinkException e16) {
                PlayerUtils.log(5, getLogTag(), "error close datasink " + e16.toString(), e16);
            }
        } catch (Throwable th5) {
            try {
                if (this.isCacheSinkOpen) {
                    this.dataSink.close();
                }
            } catch (CacheDataSink.CacheDataSinkException e17) {
                PlayerUtils.log(5, getLogTag(), "error close datasink " + e17.toString(), e17);
            }
            throw th5;
        }
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public FileType getFileType() {
        return this.upstream.getFileType();
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public String getLogTag() {
        return this.extraLogTag + TAG;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long getTotalLength() {
        return this.upstream.getTotalLength();
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        long j3;
        long j16;
        long j17;
        boolean z16;
        DataSpec dataSpec2 = dataSpec;
        long open = this.upstream.open(dataSpec2);
        FileType fileType = FileType.UNKNOWN;
        DataSource dataSource = this.upstream;
        if (dataSource instanceof HttpDataSource) {
            j3 = ((HttpDataSource) dataSource).getTotalLength();
            fileType = FileType.getFileType(((HttpDataSource) this.upstream).getResponseHeaders().get("Content-Type").get(0));
        } else {
            j3 = -1;
        }
        if (dataSpec2.length == -1 && open != -1) {
            j16 = j3;
            j17 = open;
            z16 = false;
            dataSpec2 = new DataSpec(dataSpec2.uri, dataSpec2.absoluteStreamPosition, dataSpec2.position, open, dataSpec2.key, dataSpec2.flags, dataSpec2.uuid, dataSpec2.priority);
        } else {
            j16 = j3;
            j17 = open;
            z16 = false;
        }
        this.ignoreCacheSink = z16;
        long j18 = j16;
        if (j18 != -1) {
            try {
                this.dataSink.open(dataSpec2, j18, fileType);
                this.isCacheSinkOpen = true;
            } catch (CacheDataSink.CacheDataSinkException e16) {
                this.ignoreCacheSink = true;
                PlayerUtils.log(5, getLogTag(), "error open datasink " + e16.toString(), e16);
            }
        } else {
            this.ignoreCacheSink = true;
        }
        return j17;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int read = this.upstream.read(bArr, i3, i16);
        if (read > 0) {
            if (this.ignoreCacheSink) {
                return read;
            }
            try {
                if (this.isCacheSinkOpen) {
                    this.dataSink.write(bArr, i3, read);
                }
            } catch (CacheDataSink.CacheDataSinkException e16) {
                this.ignoreCacheSink = true;
                PlayerUtils.log(5, getLogTag(), "error write datasink " + e16.toString(), e16);
            }
        }
        return read;
    }

    @Override // com.tencent.oskplayer.datasource.DataSource
    public void setLogTag(String str) {
        this.extraLogTag = str;
    }
}
