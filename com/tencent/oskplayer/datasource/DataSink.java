package com.tencent.oskplayer.datasource;

import com.tencent.oskplayer.proxy.FileType;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface DataSink {
    void close() throws IOException;

    String getLogTag();

    DataSink open(DataSpec dataSpec, long j3, FileType fileType) throws IOException;

    void setLogTag(String str);

    void write(byte[] bArr, int i3, int i16) throws IOException;
}
