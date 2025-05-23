package com.tencent.halley.downloader.g;

import java.net.URL;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    public static String a(URL url, String str, boolean z16) {
        if (z16) {
            str = "[" + str + "]";
        }
        return url.toString().replace(url.getHost(), str + "/" + url.getHost());
    }
}
