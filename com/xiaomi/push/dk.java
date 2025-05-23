package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes28.dex */
public class dk {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dk f388609b;

    /* renamed from: a, reason: collision with root package name */
    private Context f388610a;

    dk(Context context) {
        this.f388610a = context;
    }

    public static int a(int i3) {
        return Math.max(60, i3);
    }

    public static dk b(Context context) {
        if (f388609b == null) {
            synchronized (dk.class) {
                if (f388609b == null) {
                    f388609b = new dk(context);
                }
            }
        }
        return f388609b;
    }

    private void e(com.xiaomi.push.service.ah ahVar, ae aeVar, boolean z16) {
        if (ahVar.m(gk.UploadSwitch.a(), true)) {
            dn dnVar = new dn(this.f388610a);
            if (z16) {
                aeVar.j(dnVar, a(ahVar.a(gk.UploadFrequency.a(), 86400)));
            } else {
                aeVar.i(dnVar);
            }
        }
    }

    private boolean f() {
        Application application;
        try {
            Context context = this.f388610a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new ch(this.f388610a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ae b16 = ae.b(this.f388610a);
        com.xiaomi.push.service.ah d16 = com.xiaomi.push.service.ah.d(this.f388610a);
        SharedPreferences sharedPreferences = this.f388610a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j3 == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j3) < 172800000) {
            return;
        }
        e(d16, b16, false);
        if (d16.m(gk.StorageCollectionSwitch.a(), true)) {
            int a16 = a(d16.a(gk.StorageCollectionFrequency.a(), 86400));
            b16.k(new dm(this.f388610a, a16), a16, 0);
        }
        hz.j(this.f388610a);
        if (d16.m(gk.ActivityTSSwitch.a(), false)) {
            f();
        }
        e(d16, b16, true);
    }

    public void c() {
        ae.b(this.f388610a).g(new Runnable() { // from class: com.xiaomi.push.dk.1
            @Override // java.lang.Runnable
            public void run() {
                dk.this.g();
            }
        });
    }
}
