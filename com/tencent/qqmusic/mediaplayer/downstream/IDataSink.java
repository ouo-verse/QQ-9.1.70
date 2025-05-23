package com.tencent.qqmusic.mediaplayer.downstream;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IDataSink extends Closeable {
    void open() throws IOException;

    int write(long j3, byte[] bArr, int i3, int i16) throws IOException;
}
