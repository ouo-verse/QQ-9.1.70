package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f38471a;

    /* renamed from: b, reason: collision with root package name */
    private e f38472b;

    b() {
    }

    public static b a() {
        if (f38471a == null) {
            synchronized (b.class) {
                if (f38471a == null) {
                    f38471a = new b();
                }
            }
        }
        return f38471a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        if (i3 == 0) {
            this.f38472b = new e();
            if (com.qq.e.comm.plugin.c.a.a()) {
                com.qq.e.comm.plugin.c.a.b().initForGdtManager(GDTADManager.getInstance().getAppContext().getApplicationContext());
                this.f38472b.b(new d());
            }
            this.f38472b.b(new j());
            this.f38472b.b(new f());
            if (com.qq.e.comm.plugin.l.a.a()) {
                this.f38472b.b(new i());
            }
            this.f38472b.b(new g());
            if (com.qq.e.comm.plugin.n.a.a()) {
                this.f38472b.b(new h());
                return;
            }
            return;
        }
        if (i3 == 1) {
            e eVar = new e();
            this.f38472b = eVar;
            eVar.b(new j());
            return;
        }
        if (i3 == 2) {
            this.f38472b = new e();
            if (com.qq.e.comm.plugin.c.a.a()) {
                com.qq.e.comm.plugin.c.a.b().initForGdtManager(GDTADManager.getInstance().getAppContext().getApplicationContext());
                this.f38472b.b(new d());
            }
            if (com.qq.e.comm.plugin.j.c.a(str, "wxPreloadSplashRL", 0, 1)) {
                this.f38472b.b(new j());
            }
            this.f38472b.b(new f());
            if (com.qq.e.comm.plugin.l.a.a()) {
                this.f38472b.b(new i());
            }
            this.f38472b.b(new g());
            if (com.qq.e.comm.plugin.n.a.a()) {
                this.f38472b.b(new h());
            }
        }
    }

    public void a(JSONArray jSONArray, String str) {
        a(jSONArray, str, 0);
    }

    public void a(final JSONArray jSONArray, final String str, final int i3) {
        GDTLogger.d("SDK invoke preloadAfterAdLoaded");
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        GdtSDKThreadManager.getInstance().runOnThread(2, new Runnable() { // from class: com.qq.e.comm.plugin.base.ad.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(i3, str);
                b.this.f38472b.a(jSONArray, str);
                com.qq.e.comm.plugin.base.ad.d.a.a().a(jSONArray, str);
            }
        });
    }
}
