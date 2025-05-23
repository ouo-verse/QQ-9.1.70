package com.tencent.luggage.wxa.zq;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;
import com.tencent.luggage.wxa.wq.h;
import com.tencent.luggage.wxa.yq.q;
import com.tencent.luggage.wxa.yq.t;
import com.tencent.luggage.wxa.zq.b;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public h f146863a;

    /* renamed from: b, reason: collision with root package name */
    public int f146864b;

    /* renamed from: c, reason: collision with root package name */
    public String f146865c;

    /* renamed from: d, reason: collision with root package name */
    public String f146866d;

    /* renamed from: e, reason: collision with root package name */
    public String f146867e;

    public final void b(c cVar) {
        this.f146863a = new h();
        d dVar = new d(cVar);
        e eVar = e.kEmbed;
        dVar.c(eVar);
        if (!b()) {
            dVar.a(eVar);
            return;
        }
        if (!t.d()) {
            x0.f("EmbedUpdater", "Cancel by starting update progress failed.");
            dVar.a(eVar);
            return;
        }
        try {
            try {
                boolean e16 = e();
                t.a();
                this.f146863a = null;
                if (e16) {
                    dVar.b(eVar);
                } else {
                    dVar.a(eVar);
                }
            } catch (Exception e17) {
                x0.a("EmbedUpdater", "Embed update occur exception.", e17);
                n0.a(903L, 128L, 1L);
                this.f146863a.a(-204);
                t.a();
                this.f146863a = null;
                dVar.a(e.kEmbed);
            }
        } catch (Throwable th5) {
            t.a();
            this.f146863a = null;
            dVar.a(e.kEmbed);
            throw th5;
        }
    }

    public final void c() {
        int i3 = f().getInt("INSTALLED_EMBED_VERSION", -1);
        if (i3 == -1 || i3 != this.f146864b) {
            return;
        }
        SharedPreferences f16 = f();
        x0.f("EmbedUpdater", "Exist same embed core(" + this.f146864b + "). [lastTryTime:" + f16.getLong("INSTALLED_EMBED_VERSION_TIME", 0L) + "][lastResult:" + f16.getInt("INSTALLED_EMBED_RESULT", Integer.MIN_VALUE) + "]");
        this.f146863a.a(XWalkEnvironment.getInstalledNewstVersion(com.tencent.luggage.wxa.ar.b.b()), this.f146864b);
        this.f146863a.a(-202);
    }

    public final boolean d() {
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(com.tencent.luggage.wxa.ar.b.b());
        if (this.f146864b > installedNewstVersion) {
            return false;
        }
        x0.f("EmbedUpdater", "Cancel by embed version(" + this.f146864b + ") is older than installedVersion(" + installedNewstVersion + ")");
        f().edit().putInt("INSTALLED_EMBED_VERSION", this.f146864b).putLong("INSTALLED_EMBED_VERSION_TIME", System.currentTimeMillis()).apply();
        int i3 = this.f146864b;
        if (i3 < installedNewstVersion) {
            this.f146863a.a(installedNewstVersion, i3);
            this.f146863a.a(-201);
            return true;
        }
        return true;
    }

    public final boolean e() {
        if (d()) {
            return false;
        }
        c();
        com.tencent.luggage.wxa.yq.a h16 = h();
        if (h16 == null) {
            return false;
        }
        this.f146863a.b(h16);
        Integer b16 = q.b(h16);
        x0.a("EmbedUpdater", "Install embed core result:" + b16);
        this.f146863a.a(b16.intValue());
        if (b16.intValue() != 0) {
            f().edit().putInt("INSTALLED_EMBED_RESULT", 0).apply();
            return false;
        }
        n0.a(903L, 127L, 1L);
        XWalkEnvironment.refreshVersionInfo();
        f().edit().putInt("INSTALLED_EMBED_VERSION", this.f146864b).putInt("INSTALLED_EMBED_RESULT", 0).putLong("INSTALLED_EMBED_VERSION_TIME", System.currentTimeMillis()).apply();
        return true;
    }

    public final SharedPreferences f() {
        return y0.b(com.tencent.luggage.wxa.ar.b.b());
    }

    public final void g() {
        if (com.tencent.luggage.wxa.ar.b.c()) {
            this.f146864b = 0;
            this.f146865c = "1.0.0_from_lib";
            this.f146866d = "libxwebfullpack.so";
            this.f146867e = "1";
            return;
        }
        this.f146864b = 0;
        this.f146865c = "1.0.0_from_lib";
        this.f146866d = "libxwebfullpack.so";
        this.f146867e = "1";
    }

    public final com.tencent.luggage.wxa.yq.a h() {
        com.tencent.luggage.wxa.yq.d dVar = new com.tencent.luggage.wxa.yq.d(this.f146864b);
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(com.tencent.luggage.wxa.ar.b.b());
        boolean a16 = dVar.a(this.f146866d, this.f146867e);
        x0.d("EmbedUpdater", "Prepare update config. [type:LIB][result:" + a16 + "]");
        if (a16) {
            dVar.f146069d = false;
            dVar.f146070e = installedNewstVersion;
            dVar.f146074i = this.f146865c;
            return dVar;
        }
        n0.a(903L, 126L, 1L);
        this.f146863a.a(installedNewstVersion, this.f146864b);
        this.f146863a.a(-203);
        return null;
    }

    @Override // com.tencent.luggage.wxa.zq.a
    public void a(boolean z16, final c cVar) {
        if (!a()) {
            x0.f("EmbedUpdater", "Cancel by No need to install.");
            return;
        }
        x0.a("EmbedUpdater", "Start embed update.");
        Runnable runnable = new Runnable() { // from class: a51.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.a(cVar);
            }
        };
        if (z16) {
            com.tencent.luggage.wxa.lq.d.a(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c cVar) {
        long currentTimeMillis = System.currentTimeMillis();
        x0.a("EmbedUpdater", "Do start embed update.");
        b(cVar);
        x0.a("EmbedUpdater", "Finish embed update. cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public boolean a() {
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        com.tencent.luggage.wxa.ar.b.c();
        return availableVersion <= 0 || availableVersion < 0;
    }

    public static int a(String str) {
        return y0.b(str).getInt("INSTALLED_EMBED_VERSION", -1);
    }

    public final boolean b() {
        g();
        if (this.f146864b < 0) {
            x0.f("EmbedUpdater", "Cancel by invalid build version(" + this.f146864b + ")");
            return false;
        }
        x0.f("EmbedUpdater", "Cancel by SHOULD_EMEBED_XWEB_CORE is false.");
        return false;
    }
}
