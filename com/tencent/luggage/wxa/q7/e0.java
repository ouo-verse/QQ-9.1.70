package com.tencent.luggage.wxa.q7;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e0 implements com.tencent.luggage.wxaapi.s {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f137956a = new e0();

    /* renamed from: b, reason: collision with root package name */
    public static com.tencent.luggage.wxaapi.s f137957b;

    public final void a() {
        com.tencent.luggage.wxa.h6.l.f126905a.a(new p());
    }

    @Override // com.tencent.luggage.wxaapi.s
    public boolean isInFoldableAndExpandedDevice() {
        com.tencent.luggage.wxaapi.s sVar = f137957b;
        if (sVar != null) {
            return sVar.isInFoldableAndExpandedDevice();
        }
        return false;
    }

    @Override // com.tencent.luggage.wxaapi.s
    public boolean isInTabletWithNonFixedOrientation() {
        com.tencent.luggage.wxaapi.s sVar = f137957b;
        if (sVar != null) {
            return sVar.isInTabletWithNonFixedOrientation();
        }
        return false;
    }

    public final void a(com.tencent.luggage.wxaapi.s sVar) {
        f137957b = sVar;
    }
}
