package com.vivo.push;

import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandlerConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class z implements k {

    /* renamed from: a, reason: collision with root package name */
    private y f387944a = new y();

    /* renamed from: b, reason: collision with root package name */
    private y f387945b = new y();

    /* renamed from: c, reason: collision with root package name */
    private com.vivo.push.c.a f387946c;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f387947d;

    /* renamed from: e, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f387948e;

    public z(com.vivo.push.c.a aVar, com.vivo.push.restructure.b.a aVar2) {
        this.f387946c = aVar;
        this.f387948e = aVar2;
    }

    private void d(String str) {
        this.f387947d = str;
        this.f387948e.c(this.f387947d);
    }

    @Override // com.vivo.push.k
    public final String b() {
        if (!TextUtils.isEmpty(this.f387947d)) {
            return this.f387947d;
        }
        String d16 = d();
        if (TextUtils.isEmpty(d16)) {
            d16 = this.f387948e.f();
            t.c(new aa(this, d16));
        }
        this.f387947d = d16;
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(d16)));
        return d16;
    }

    @Override // com.vivo.push.k
    public final void c(String str) {
        d(str);
    }

    private int c() {
        if (!this.f387946c.d()) {
            return MessageHandlerConstants.NOTIFY_TYPE_PC_ACTIVE_NOTIFY;
        }
        if (this.f387945b.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe \u4e24\u79d2\u5185\u91cd\u590d\u8c03\u7528  ");
            return 1002;
        }
        int i3 = 1;
        try {
            String a16 = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(a16)));
            String a17 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), a16);
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(a17)));
            if (!TextUtils.isEmpty(a17)) {
                i3 = 1 ^ (Boolean.parseBoolean(g.f387703a.a(a17).b()) ? 1 : 0);
            }
        } catch (Exception e16) {
            com.vivo.push.util.u.a("SubscribeImpl", "isAppSubscribe", e16);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i3)));
        return i3;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (!this.f387946c.c() && iPushActionListener != null) {
            iPushActionListener.onStateChanged(8012);
        } else {
            m.a().b(iPushActionListener, str, str2);
        }
    }

    private String d() {
        String str = "";
        if (!this.f387946c.d()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk \u7cfb\u7edf\u4e0d\u652f\u6301\u67e5\u8be2regid  ");
            return "";
        }
        if (this.f387944a.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk \u4e24\u79d2\u5185\u91cd\u590d\u8c03\u7528  ");
            return "";
        }
        try {
            String a16 = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(a16)));
            String a17 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), a16);
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(a17)));
            if (!TextUtils.isEmpty(a17)) {
                str = g.f387703a.a(a17).b();
            }
        } catch (Exception e16) {
            com.vivo.push.util.u.a("SubscribeImpl", "getRegidByCoreSdk", e16);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(str)));
        return str;
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    @Override // com.vivo.push.k
    public final void a(String str, String str2, String str3) {
        d(str);
        this.f387948e.a(str2);
        this.f387948e.b(str3);
    }

    @Override // com.vivo.push.k
    public final void a(String str) {
        d(str);
        this.f387948e.d();
        this.f387948e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String str) {
        d(str);
        m.a().e();
        this.f387948e.h();
        this.f387948e.d();
        this.f387948e.b();
    }
}
