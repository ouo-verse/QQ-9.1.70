package com.huawei.hms.hatool;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static m f37174b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f37175c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f37176a;

    m() {
    }

    public static m a() {
        if (f37174b == null) {
            b();
        }
        return f37174b;
    }

    private static synchronized void b() {
        synchronized (m.class) {
            if (f37174b == null) {
                f37174b = new m();
            }
        }
    }

    public void a(Context context) {
        synchronized (f37175c) {
            if (this.f37176a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f37176a = context;
            s.c().b().a(this.f37176a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f37176a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
        } else {
            s.c().b().i(e1.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
        }
    }
}
