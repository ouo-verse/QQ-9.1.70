package com.tencent.tmassistantbase.network;

import javax.net.ssl.SSLContext;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    public static SSLContext a() {
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, null, null);
        return sSLContext;
    }
}
