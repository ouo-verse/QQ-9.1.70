package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.vivo.push.util.aa;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f387563a;

    /* renamed from: b, reason: collision with root package name */
    private String f387564b;

    /* renamed from: c, reason: collision with root package name */
    private long f387565c;

    /* renamed from: d, reason: collision with root package name */
    private int f387566d;

    /* renamed from: e, reason: collision with root package name */
    private int f387567e;

    /* renamed from: f, reason: collision with root package name */
    private String f387568f;

    /* renamed from: g, reason: collision with root package name */
    private String f387569g;

    /* renamed from: h, reason: collision with root package name */
    private String f387570h;

    public c(int i3, String str) {
        super(i3);
        this.f387565c = -1L;
        this.f387566d = -1;
        this.f387563a = null;
        this.f387564b = str;
    }

    public final int a(Context context) {
        if (this.f387566d == -1) {
            String str = this.f387564b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.u.a("BaseAppCommand", "pkg name is null");
                str = a();
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.u.a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.f387566d = aa.b(context, str);
            if (!TextUtils.isEmpty(this.f387568f)) {
                this.f387566d = 2;
            }
        }
        return this.f387566d;
    }

    public final void b(int i3) {
        this.f387567e = i3;
    }

    public final void c(String str) {
        this.f387570h = str;
    }

    public final int d() {
        return this.f387567e;
    }

    public final void e() {
        this.f387568f = null;
    }

    public final String f() {
        return this.f387563a;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "BaseAppCommand";
    }

    public final void b(String str) {
        this.f387563a = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a(CheckForwardServlet.KEY_REQ_ID, this.f387563a);
        dVar.a("package_name", this.f387564b);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_APP_STATUS", this.f387566d);
        if (!TextUtils.isEmpty(this.f387568f)) {
            dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f387568f);
        }
        dVar.a("BaseAppCommand.EXTRA_APPID", this.f387570h);
        dVar.a("BaseAppCommand.EXTRA_APPKEY", this.f387569g);
    }

    public final void d(String str) {
        this.f387569g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.f387563a = dVar.a(CheckForwardServlet.KEY_REQ_ID);
        this.f387564b = dVar.a("package_name");
        this.f387565c = dVar.b("sdk_version", 0L);
        this.f387566d = dVar.b("PUSH_APP_STATUS", 0);
        this.f387568f = dVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f387570h = dVar.a("BaseAppCommand.EXTRA_APPID");
        this.f387569g = dVar.a("BaseAppCommand.EXTRA_APPKEY");
    }
}
