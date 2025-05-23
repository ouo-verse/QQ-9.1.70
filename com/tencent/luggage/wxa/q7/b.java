package com.tencent.luggage.wxa.q7;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.luggage.wxa.q7.s;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f137877a = new b();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bf A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0102 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c2 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r10v12, types: [com.tencent.luggage.wxa.t6.e] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.tencent.luggage.wxa.ca.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.app.Application] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean a(Context context) {
        Context context2;
        Application application;
        Resources resources;
        Context context3;
        Application application2;
        Resources resources2;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.luggage.wxa.tn.w.d("Luggage.ComponentsGuard", "ensureWxaApiInstalled " + context);
        ?? r36 = 0;
        Application application3 = null;
        Application application4 = null;
        try {
            s.d dVar = s.d.f138074a;
            if (dVar.d() == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                com.tencent.luggage.wxa.tn.z.b(applicationContext);
                com.tencent.luggage.wxa.x7.f fVar = com.tencent.luggage.wxa.x7.f.f144620c;
                String a16 = fVar.a();
                int b16 = fVar.b();
                if (a16 != null && a16.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        if (1 <= b16 && b16 < 3) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            Log.i("Luggage.ComponentsGuard", "ensureWxaApiInstall(), hostAppID:" + a16 + ", hostAbi:" + b16);
                            dVar.a(new s(context, a16, b16, true));
                        }
                    }
                    Log.e("Luggage.ComponentsGuard", "ensureWxaApiInstalled(), wxaApi not initialized before, return null");
                    return false;
                }
                z16 = true;
                if (!z16) {
                }
                Log.e("Luggage.ComponentsGuard", "ensureWxaApiInstalled(), wxaApi not initialized before, return null");
                return false;
            }
            Context c16 = com.tencent.luggage.wxa.tn.z.c();
            if (c16 == null) {
                Context applicationContext2 = context.getApplicationContext();
                if (applicationContext2 != null) {
                    context = applicationContext2;
                }
                com.tencent.luggage.wxa.tn.z.b(context);
                c16 = com.tencent.luggage.wxa.tn.z.c();
            }
            if (com.tencent.luggage.wxa.tn.z.j() == null) {
                Context c17 = com.tencent.luggage.wxa.tn.z.c();
                if (c17 != null) {
                    resources2 = c17.getResources();
                } else {
                    resources2 = null;
                }
                if (resources2 != null) {
                    com.tencent.luggage.wxa.tn.z.a(com.tencent.luggage.wxa.tn.z.c().getResources());
                }
            }
            if (c16 instanceof Application) {
                application2 = (Application) c16;
            } else {
                if (c16 != null) {
                    context3 = c16.getApplicationContext();
                } else {
                    context3 = null;
                }
                if (context3 instanceof Application) {
                    application2 = (Application) context3;
                } else {
                    application2 = null;
                }
            }
            if (application2 != null) {
                com.tencent.luggage.wxa.w7.b.a(com.tencent.luggage.wxa.w7.b.f144108a, application2, null, 2, null);
            }
            if (((com.tencent.luggage.wxa.mo.e) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.mo.e.class)) == null) {
                com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.mo.e.class, new com.tencent.luggage.wxa.ok.s());
            }
            Context c18 = com.tencent.luggage.wxa.tn.z.c();
            if (c18 instanceof Application) {
                application4 = (Application) c18;
            }
            if (application4 != null) {
                com.tencent.luggage.wxa.t6.e.f140872a.a(application4);
            }
            if (com.tencent.luggage.wxa.tn.z.m()) {
                com.tencent.luggage.wxa.u6.a.f142122a.b();
            }
            com.tencent.luggage.wxa.x7.i.f144642a.a();
            return true;
        } finally {
            Context c19 = com.tencent.luggage.wxa.tn.z.c();
            if (c19 == null) {
                Context applicationContext3 = context.getApplicationContext();
                if (applicationContext3 != null) {
                    context = applicationContext3;
                }
                com.tencent.luggage.wxa.tn.z.b(context);
                c19 = com.tencent.luggage.wxa.tn.z.c();
            }
            if (com.tencent.luggage.wxa.tn.z.j() == null) {
                Context c26 = com.tencent.luggage.wxa.tn.z.c();
                if (c26 != null) {
                    resources = c26.getResources();
                } else {
                    resources = null;
                }
                if (resources != null) {
                    com.tencent.luggage.wxa.tn.z.a(com.tencent.luggage.wxa.tn.z.c().getResources());
                }
            }
            if (c19 instanceof Application) {
                application = (Application) c19;
            } else {
                if (c19 != null) {
                    context2 = c19.getApplicationContext();
                } else {
                    context2 = null;
                }
                if (context2 instanceof Application) {
                    application = (Application) context2;
                } else {
                    application = null;
                }
            }
            if (application != null) {
                com.tencent.luggage.wxa.w7.b.a(com.tencent.luggage.wxa.w7.b.f144108a, application, null, 2, null);
            }
            if (((com.tencent.luggage.wxa.mo.e) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.mo.e.class)) == null) {
                com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.mo.e.class, new com.tencent.luggage.wxa.ok.s());
            }
            Context c27 = com.tencent.luggage.wxa.tn.z.c();
            if (c27 instanceof Application) {
                r36 = (Application) c27;
            }
            if (r36 != 0) {
                com.tencent.luggage.wxa.t6.e.f140872a.a(r36);
            }
            if (com.tencent.luggage.wxa.tn.z.m()) {
                com.tencent.luggage.wxa.u6.a.f142122a.b();
            }
            com.tencent.luggage.wxa.x7.i.f144642a.a();
        }
    }
}
