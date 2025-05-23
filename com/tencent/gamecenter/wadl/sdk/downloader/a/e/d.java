package com.tencent.gamecenter.wadl.sdk.downloader.a.e;

import com.tencent.gamecenter.wadl.sdk.common.c.b.h;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends a {

    /* renamed from: u, reason: collision with root package name */
    public static String f107303u = "CommReq";

    public d(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, Map<String, String> map, b bVar, boolean z16, boolean z17, com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar2, int i3, String str) {
        super(aVar, map, bVar, z16, z17, bVar2, i3, str);
        com.tencent.gamecenter.wadl.sdk.common.e.b.c(f107303u, "+++++++++Create CommReq+++++++++++++++");
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.e.a
    HttpURLConnection a(URL url) {
        boolean a16 = a(this.f107287g);
        URLConnection openConnection = url.openConnection();
        if (a16) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setSSLSocketFactory(new h(this.f107287g));
            httpsURLConnection.setHostnameVerifier(new com.tencent.gamecenter.wadl.sdk.common.c.b.e(this.f107287g));
            return httpsURLConnection;
        }
        return (HttpURLConnection) openConnection;
    }
}
