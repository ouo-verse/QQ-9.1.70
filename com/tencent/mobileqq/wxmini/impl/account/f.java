package com.tencent.mobileqq.wxmini.impl.account;

/* compiled from: P */
/* loaded from: classes35.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private int f327664a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.wxmini.api.data.d f327665b;

    /* renamed from: c, reason: collision with root package name */
    private String f327666c;

    /* renamed from: d, reason: collision with root package name */
    private String f327667d;

    public com.tencent.mobileqq.wxmini.api.data.d a() {
        return this.f327665b;
    }

    public int b() {
        return this.f327664a;
    }

    public f c(com.tencent.mobileqq.wxmini.api.data.d dVar) {
        this.f327665b = dVar;
        return this;
    }

    public f d(int i3) {
        this.f327664a = i3;
        return this;
    }

    public f e(String str) {
        this.f327666c = str;
        return this;
    }

    public f f(String str) {
        this.f327667d = str;
        return this;
    }

    public String toString() {
        return "BindingResultInfo{bindResult=" + this.f327664a + ", accountInfo=" + this.f327665b + ", profileSig='" + this.f327666c + "', secureCheckUrl='" + this.f327667d + "'}";
    }
}
