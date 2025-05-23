package com.tencent.luggage.wxa.xp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import com.tencent.luggage.wxa.np.j;
import com.tencent.soter.core.model.ConstantsSoter;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends d {

    /* renamed from: h, reason: collision with root package name */
    public static final String f145341h = "soter_triggered_oom" + com.tencent.luggage.wxa.np.i.a(com.tencent.luggage.wxa.jp.a.b().getBytes(Charset.forName("UTF-8")));

    /* renamed from: i, reason: collision with root package name */
    public static final String f145342i = "soter_triggered_oom_count" + com.tencent.luggage.wxa.np.i.a(com.tencent.luggage.wxa.jp.a.b().getBytes(Charset.forName("UTF-8")));

    /* renamed from: c, reason: collision with root package name */
    public boolean f145343c;

    /* renamed from: d, reason: collision with root package name */
    public String f145344d;

    /* renamed from: e, reason: collision with root package name */
    public String f145345e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f145346f;

    /* renamed from: g, reason: collision with root package name */
    public j.b f145347g = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements j.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.np.j.b
        public void a() {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskInit", "soter: on trigger OOM, using wrapper implement", new Object[0]);
            SharedPreferences d16 = com.tencent.luggage.wxa.tp.b.c().d();
            if (d16 != null) {
                SharedPreferences.Editor edit = d16.edit();
                edit.putInt(j.f145342i, d16.getInt(j.f145342i, 0) + 1);
                edit.commit();
            }
        }

        @Override // com.tencent.luggage.wxa.np.j.b
        public boolean b() {
            SharedPreferences d16 = com.tencent.luggage.wxa.tp.b.c().d();
            if (d16 != null) {
                int i3 = d16.getInt(j.f145342i, 0);
                com.tencent.luggage.wxa.np.e.c("Soter.TaskInit", "soter: is triggered OOM: %d", Integer.valueOf(i3));
                if (i3 >= 10) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.np.j.b
        public void reset() {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskInit", "soter: SoterDelegate reset", new Object[0]);
            SharedPreferences d16 = com.tencent.luggage.wxa.tp.b.c().d();
            if (d16 != null) {
                d16.edit().putInt(j.f145342i, 0).apply();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.a(jVar.f145344d, j.this.f145346f);
            j.this.h();
        }
    }

    public j(Context context, e eVar) {
        boolean z16 = false;
        this.f145343c = false;
        this.f145344d = "";
        this.f145345e = "";
        com.tencent.luggage.wxa.np.c f16 = eVar.f();
        if (f16 != null) {
            com.tencent.luggage.wxa.np.e.a(f16);
        }
        eVar.g();
        HandlerThread b16 = eVar.b();
        if (b16 != null) {
            g.a().a(b16);
        }
        com.tencent.luggage.wxa.tp.b.c().a(context.getSharedPreferences("soter_status", 0));
        com.tencent.luggage.wxa.np.j.a(this.f145347g);
        com.tencent.luggage.wxa.jp.a.k();
        com.tencent.luggage.wxa.jp.a.d(context);
        com.tencent.luggage.wxa.jp.a.j();
        if (com.tencent.luggage.wxa.jp.a.h() && (com.tencent.luggage.wxa.jp.a.b(context) || com.tencent.luggage.wxa.jp.a.b(context, 2))) {
            z16 = true;
        }
        this.f145343c = z16;
        eVar.d();
        this.f145346f = eVar.e();
        this.f145344d = eVar.c();
        this.f145345e = eVar.a();
    }

    public final boolean a(int i3) {
        return i3 != 0;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void c(com.tencent.luggage.wxa.sp.e eVar) {
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean d() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean f() {
        if (com.tencent.luggage.wxa.tp.b.c().f()) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskInit", "soter: duplicate initialize soter", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.d(1028, "soter already have initialized"));
            return true;
        }
        if (com.tencent.luggage.wxa.np.i.a(this.f145346f)) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.d(1024, "no business scene provided"));
            return true;
        }
        if (com.tencent.luggage.wxa.np.i.b(this.f145344d).length() > 16) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24. soter will try to make it compat", new Object[0]);
            String a16 = a(this.f145344d);
            if (com.tencent.luggage.wxa.np.i.a(a16)) {
                com.tencent.luggage.wxa.np.e.e("Soter.TaskInit", "soter: saltlen compat failed!!", new Object[0]);
                a(new com.tencent.luggage.wxa.sp.d(1025, "the account salt length is too long"));
                return true;
            }
            this.f145344d = a16;
        }
        if (!com.tencent.luggage.wxa.np.i.a(this.f145345e) && this.f145345e.length() > 24) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.d(1026, "the passed ask name is too long (larger than 24)"));
            return true;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
        if (!com.tencent.luggage.wxa.np.i.a(this.f145345e)) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
            com.tencent.luggage.wxa.np.g.b().a(this.f145345e);
        }
        g.a().b(new b());
        return false;
    }

    public final void h() {
        try {
            SharedPreferences d16 = com.tencent.luggage.wxa.tp.b.c().d();
            int i3 = d16.getInt(com.tencent.luggage.wxa.np.g.b().a(), -1);
            com.tencent.luggage.wxa.np.e.a("Soter.TaskInit", "soter: ask status: %d", Integer.valueOf(i3));
            if (a(i3) && com.tencent.luggage.wxa.jp.a.f()) {
                com.tencent.luggage.wxa.np.e.c("Soter.TaskInit", "invalid ask, remove all key", new Object[0]);
                com.tencent.luggage.wxa.jp.a.i();
                for (int i16 : this.f145346f) {
                    com.tencent.luggage.wxa.jp.a.b((String) com.tencent.luggage.wxa.tp.b.c().b().get(i16, ""), false);
                }
                return;
            }
            for (int i17 : this.f145346f) {
                String str = (String) com.tencent.luggage.wxa.tp.b.c().b().get(i17, "");
                if (!com.tencent.luggage.wxa.np.i.a(str)) {
                    int i18 = d16.getInt(str, 0);
                    com.tencent.luggage.wxa.np.e.a("Soter.TaskInit", "soter: %s status: %d", str, Integer.valueOf(i18));
                    if (a(i18) && com.tencent.luggage.wxa.jp.a.d(str)) {
                        com.tencent.luggage.wxa.np.e.c("Soter.TaskInit", "remove invalid ask: %s", str);
                        com.tencent.luggage.wxa.jp.a.b(str, false);
                    }
                }
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.a("Soter.TaskInit", e16, "soter: removeAbnormalKeys failed");
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void b() {
        if (this.f145343c) {
            com.tencent.luggage.wxa.tp.b.c().b(true);
            com.tencent.luggage.wxa.tp.b.c().a(true);
            a(new com.tencent.luggage.wxa.sp.d(0));
            return;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.TaskInit", "soter: TaskInit check isNativeSupport[" + this.f145343c + "]", new Object[0]);
        a(new com.tencent.luggage.wxa.sp.d(2));
        synchronized (com.tencent.luggage.wxa.tp.b.class) {
            com.tencent.luggage.wxa.tp.b.c().b(false);
            com.tencent.luggage.wxa.tp.b.c().a(true);
        }
    }

    public final String a(String str) {
        String a16 = com.tencent.luggage.wxa.np.i.a(str.getBytes(Charset.forName("UTF-8")));
        if (!com.tencent.luggage.wxa.np.i.a(a16) && a16.length() >= 16) {
            return a16.substring(0, 16);
        }
        Log.e("Soter.TaskInit", "soter: not valid md5 implement!!");
        return null;
    }

    public void a(String str, int[] iArr) {
        for (int i3 : iArr) {
            com.tencent.luggage.wxa.tp.b.c().b().put(i3, String.format("%suid%d_%s_scene%d", ConstantsSoter.SOTER_COMMON_KEYNAME_PREFIX, Integer.valueOf(Process.myUid()), com.tencent.luggage.wxa.np.i.b(str), Integer.valueOf(i3)));
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void e() {
    }
}
