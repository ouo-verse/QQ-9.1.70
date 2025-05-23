package com.tencent.qqmusic.mediaplayer.network;

import java.net.URL;
import java.util.Map;

/* loaded from: classes23.dex */
public interface IMediaHTTPConnection {
    boolean connect(URL url, Map<String, String> map);

    void disconnect();

    String getMIMEType();

    long getSize();

    String getUri();

    int readAt(long j3, byte[] bArr, int i3, int i16);
}
