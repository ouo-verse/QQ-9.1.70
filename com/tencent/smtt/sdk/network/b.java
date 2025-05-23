package com.tencent.smtt.sdk.network;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: P */
/* loaded from: classes23.dex */
interface b {
    URLConnection openConnection(URL url, Proxy proxy) throws IOException;

    boolean shouldIntercept(URL url);
}
