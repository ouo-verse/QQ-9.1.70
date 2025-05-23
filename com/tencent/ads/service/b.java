package com.tencent.ads.service;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f61693a;

    /* renamed from: b, reason: collision with root package name */
    private static d f61694b;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f61693a == null) {
                f61693a = new b();
            }
            bVar = f61693a;
        }
        return bVar;
    }

    public static d b() {
        if (f61694b == null) {
            f61694b = new d();
        }
        return f61694b;
    }

    private static void d() {
        Log.i("AdCookie", "initCookie");
        b();
    }

    public final synchronized void c() {
        Log.i("AdCookie", "saveCookie");
        d dVar = f61694b;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    public static String a(String str) {
        Log.i("AdCookie", "getCookie start: " + str);
        d b16 = b();
        String[] split = str.split("/");
        if (split.length >= 2) {
            str = String.valueOf(split[0]) + "/" + split[1] + "/" + split[2];
        }
        List<HttpCookie> list = b16.get(URI.create(str));
        Log.i("AdCookie", "getCookie cookies.size:" + list.size());
        StringBuilder sb5 = new StringBuilder();
        for (HttpCookie httpCookie : list) {
            sb5.append(httpCookie.getName());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(httpCookie.getValue());
            sb5.append(";");
        }
        String sb6 = sb5.toString();
        Log.i("AdCookie", "getCookie end:" + sb6);
        return sb6;
    }
}
