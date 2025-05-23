package com.huawei.hms.hatool;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    s0 f37065a;

    /* renamed from: b, reason: collision with root package name */
    s0 f37066b;

    /* renamed from: c, reason: collision with root package name */
    Context f37067c;

    /* renamed from: d, reason: collision with root package name */
    String f37068d;

    public b(Context context) {
        if (context != null) {
            this.f37067c = context.getApplicationContext();
        }
        this.f37065a = new s0();
        this.f37066b = new s0();
    }

    public b a(int i3, String str) {
        s0 s0Var;
        v.c("hmsSdk", "Builder.setCollectURL(int type,String collectURL) is execute.TYPE : " + i3);
        if (!p1.b(str)) {
            str = "";
        }
        if (i3 == 0) {
            s0Var = this.f37065a;
        } else {
            if (i3 != 1) {
                v.f("hmsSdk", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                return this;
            }
            s0Var = this.f37066b;
        }
        s0Var.b(str);
        return this;
    }

    @Deprecated
    public b b(boolean z16) {
        v.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.f37065a.j().b(z16);
        this.f37066b.j().b(z16);
        return this;
    }

    @Deprecated
    public b c(boolean z16) {
        v.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.f37065a.j().c(z16);
        this.f37066b.j().c(z16);
        return this;
    }

    public b a(String str) {
        v.c("hmsSdk", "Builder.setAppID is execute");
        this.f37068d = str;
        return this;
    }

    @Deprecated
    public b a(boolean z16) {
        v.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.f37065a.j().a(z16);
        this.f37066b.j().a(z16);
        return this;
    }

    public void a() {
        if (this.f37067c == null) {
            v.b("hmsSdk", "analyticsConf create(): context is null,create failed!");
            return;
        }
        v.c("hmsSdk", "Builder.create() is execute.");
        z0 z0Var = new z0("_hms_config_tag");
        z0Var.b(new s0(this.f37065a));
        z0Var.a(new s0(this.f37066b));
        m.a().a(this.f37067c);
        g0.a().a(this.f37067c);
        q.c().a(z0Var);
        m.a().a(this.f37068d);
    }
}
