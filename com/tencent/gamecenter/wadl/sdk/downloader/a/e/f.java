package com.tencent.gamecenter.wadl.sdk.downloader.a.e;

import android.net.Network;
import com.tencent.gamecenter.wadl.sdk.common.c.b.h;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f extends a {

    /* renamed from: u, reason: collision with root package name */
    public static String f107310u = "MobileReq";

    public f(com.tencent.gamecenter.wadl.sdk.downloader.task.k.a aVar, Map<String, String> map, b bVar, boolean z16, boolean z17, com.tencent.gamecenter.wadl.sdk.downloader.task.k.b bVar2, int i3, String str) {
        super(aVar, map, bVar, z16, z17, bVar2, i3, str);
        com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107310u, "+++++++++Create MobileReq+++++++++++++++");
    }

    @Override // com.tencent.gamecenter.wadl.sdk.downloader.a.e.a
    HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        Network b16 = com.tencent.gamecenter.wadl.sdk.downloader.manager.b.c().b();
        if (a(this.f107287g)) {
            if (b16 == null) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107310u, "getCellularNetwork is null [case 1]");
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpsURLConnection = (HttpsURLConnection) b16.openConnection(url);
                if (httpsURLConnection != null) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107310u, "getCellularNetwork SUCCESS [case 1]");
                }
            }
            if (httpsURLConnection == null) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107310u, "createHttpsURLConnection fail httpsConn is null");
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
            }
            if (httpsURLConnection != null) {
                httpsURLConnection.setSSLSocketFactory(new h(this.f107287g));
                httpsURLConnection.setHostnameVerifier(new com.tencent.gamecenter.wadl.sdk.common.c.b.e(this.f107287g));
                return httpsURLConnection;
            }
            return httpsURLConnection;
        }
        if (b16 == null) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c(f107310u, "getCellularNetwork is null [case 2]");
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) b16.openConnection(url);
            if (httpURLConnection != null) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.e(f107310u, "getCellularNetwork SUCCESS [case 2]");
            }
        }
        if (httpURLConnection == null) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.c(f107310u, "createHttpURLConnection fail httpConn is null");
            return (HttpURLConnection) url.openConnection();
        }
        return httpURLConnection;
    }
}
