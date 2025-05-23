package com.hihonor.push.sdk;

import java.util.List;

/* compiled from: P */
/* renamed from: com.hihonor.push.sdk.r, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C11727r implements k0<List<HonorPushDataMsg>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HonorPushCallback f36422a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f36423b;

    public C11727r(s sVar, HonorPushCallback honorPushCallback) {
        this.f36423b = sVar;
        this.f36422a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<List<HonorPushDataMsg>> a1Var) {
        if (a1Var.e()) {
            s sVar = this.f36423b;
            HonorPushCallback honorPushCallback = this.f36422a;
            List<HonorPushDataMsg> c16 = a1Var.c();
            sVar.getClass();
            b1.a(new t(sVar, honorPushCallback, c16));
            return;
        }
        s.a(this.f36423b, this.f36422a, -1, a1Var.b().toString());
    }
}
