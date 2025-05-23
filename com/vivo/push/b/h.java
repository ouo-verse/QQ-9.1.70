package com.vivo.push.b;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class h extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private String f387573a;

    /* renamed from: b, reason: collision with root package name */
    private String f387574b;

    public h() {
        super(2013);
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("MsgArriveCommand.MSG_TAG", this.f387573a);
        if (!TextUtils.isEmpty(this.f387574b)) {
            dVar.a("MsgArriveCommand.NODE_INFO", this.f387574b);
        }
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.f387573a = dVar.a("MsgArriveCommand.MSG_TAG");
        this.f387574b = dVar.a("MsgArriveCommand.NODE_INFO");
    }

    public h(String str) {
        this();
        this.f387573a = str;
    }

    public h(String str, String str2) {
        this(str);
        this.f387574b = str2;
    }
}
