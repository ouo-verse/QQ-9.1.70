package com.vivo.push.b;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;

/* compiled from: P */
/* loaded from: classes11.dex */
public class s extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f387600a;

    /* renamed from: b, reason: collision with root package name */
    private int f387601b;

    public s(int i3) {
        super(i3);
        this.f387600a = null;
        this.f387601b = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a(CheckForwardServlet.KEY_REQ_ID, this.f387600a);
        dVar.a("status_msg_code", this.f387601b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.f387600a = dVar.a(CheckForwardServlet.KEY_REQ_ID);
        this.f387601b = dVar.b("status_msg_code", this.f387601b);
    }

    public final String h() {
        return this.f387600a;
    }

    public final int i() {
        return this.f387601b;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }
}
