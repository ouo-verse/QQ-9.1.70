package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.proxy.FileType;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DataSource {
    long available();

    void close() throws IOException;

    FileType getFileType();

    String getLogTag();

    long getTotalLength();

    long open(DataSpec dataSpec) throws IOException;

    int read(byte[] bArr, int i3, int i16) throws IOException;

    void setLogTag(String str);
}
