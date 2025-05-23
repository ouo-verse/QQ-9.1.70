package com.tencent.ads;

import android.content.Context;
import android.util.Log;
import com.tencent.ads.service.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdManager {
    public static final String SDK_VERSION = "QQZoneAndroidV1.1_20161226";
    public static final boolean USE_DOWNLOADERSDK = true;

    /* renamed from: a, reason: collision with root package name */
    private static Context f61569a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f61570b = 37;

    public static Context getApplicationContext() {
        return f61569a;
    }

    public static int getChid() {
        return f61570b;
    }

    public static void init(Context context) {
        Log.i("AdManager", "init");
        f61569a = context.getApplicationContext();
        initCookie();
    }

    public static void initCookie() {
        b.a();
        Log.i("AdCookie", "initCookie");
        b.b();
    }
}
