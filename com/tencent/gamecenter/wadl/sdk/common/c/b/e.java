package com.tencent.gamecenter.wadl.sdk.common.c.b;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public String f107096a;

    public e(String str) {
        this.f107096a = str;
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.f107096a) || !(obj instanceof e)) {
            return false;
        }
        String str = ((e) obj).f107096a;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f107096a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f107096a, sSLSession);
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("HostnameVerifier", "[HostnameVerifier] verify result: " + verify);
        return verify;
    }
}
