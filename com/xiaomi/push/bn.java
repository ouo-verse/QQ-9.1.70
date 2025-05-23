package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ae;
import com.xiaomi.push.bw;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bn {

    /* renamed from: k, reason: collision with root package name */
    private static volatile bn f388281k;

    /* renamed from: e, reason: collision with root package name */
    private Context f388286e;

    /* renamed from: f, reason: collision with root package name */
    private String f388287f;

    /* renamed from: g, reason: collision with root package name */
    private String f388288g;

    /* renamed from: a, reason: collision with root package name */
    private final String f388282a = "push_stat_sp";

    /* renamed from: b, reason: collision with root package name */
    private final String f388283b = s4.c.UPLOAD_TIME;

    /* renamed from: c, reason: collision with root package name */
    private final String f388284c = "delete_time";

    /* renamed from: d, reason: collision with root package name */
    private final String f388285d = "check_time";

    /* renamed from: h, reason: collision with root package name */
    private ae.a f388289h = new ae.a() { // from class: com.xiaomi.push.bn.1
        @Override // com.xiaomi.push.ae.a
        public String e() {
            return "10052";
        }

        @Override // java.lang.Runnable
        public void run() {
            jz4.c.z("exec== mUploadJob");
            bn.c(bn.this);
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private ae.a f388290i = new ae.a() { // from class: com.xiaomi.push.bn.2
        @Override // com.xiaomi.push.ae.a
        public String e() {
            return "10054";
        }

        @Override // java.lang.Runnable
        public void run() {
            jz4.c.z("exec== DbSizeControlJob");
            bw.b(bn.this.f388286e).f(new bp(bn.this.n(), new WeakReference(bn.this.f388286e)));
            bn.this.m("check_time");
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private ae.a f388291j = new ae.a() { // from class: com.xiaomi.push.bn.3
        @Override // com.xiaomi.push.ae.a
        public String e() {
            return "10053";
        }

        @Override // java.lang.Runnable
        public void run() {
            bn.c(bn.this);
        }
    };

    bn(Context context) {
        this.f388286e = context;
    }

    public static bn b(Context context) {
        if (f388281k == null) {
            synchronized (bn.class) {
                if (f388281k == null) {
                    f388281k = new bn(context);
                }
            }
        }
        return f388281k;
    }

    static /* synthetic */ as c(bn bnVar) {
        bnVar.getClass();
        return null;
    }

    private boolean k() {
        return com.xiaomi.push.service.ah.d(this.f388286e).m(gk.StatDataSwitch.a(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        SharedPreferences.Editor edit = this.f388286e.getSharedPreferences("push_stat_sp", 0).edit();
        edit.putLong(str, System.currentTimeMillis());
        Cif.a(edit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        return this.f388286e.getDatabasePath(aq.f388203a).getAbsolutePath();
    }

    public String d() {
        return this.f388287f;
    }

    public void g(bw.a aVar) {
        bw.b(this.f388286e).e(aVar);
    }

    public void h(gj gjVar) {
        if (!k() || !com.xiaomi.push.service.af.f(gjVar.e())) {
            return;
        }
        g(bt.m(this.f388286e, n(), gjVar));
    }

    public void i(String str) {
        if (!k() || TextUtils.isEmpty(str)) {
            return;
        }
        h(at.a(this.f388286e, str));
    }

    public String l() {
        return this.f388288g;
    }

    public void j(String str, String str2, Boolean bool) {
    }
}
