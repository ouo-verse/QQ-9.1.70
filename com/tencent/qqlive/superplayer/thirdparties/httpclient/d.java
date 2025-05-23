package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface d {
    long a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    int read(byte[] bArr, int i3, int i16) throws IOException;
}
