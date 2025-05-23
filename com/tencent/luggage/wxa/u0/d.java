package com.tencent.luggage.wxa.u0;

import com.tencent.ilinklive.interfaces.IlinkLiveJniInterface;
import com.tencent.luggage.wxa.v0.a;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static c f142017a;

    /* renamed from: b, reason: collision with root package name */
    public static final d f142018b = new d();

    public final c a(String str) {
        long aa5 = IlinkLiveJniInterface.f116242a.aa(str);
        c cVar = new c(aa5);
        f142017a = cVar;
        a.a(aa5, cVar);
        c cVar2 = f142017a;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilinkliveInterfaceManager");
        }
        return cVar2;
    }

    public final void a(a.InterfaceC6811a interfaceC6811a) {
        c cVar = f142017a;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilinkliveInterfaceManager");
        }
        cVar.b().a(interfaceC6811a);
    }

    public final void a(c cVar) {
        IlinkLiveJniInterface.f116242a.ab(cVar.a());
        a.a(cVar.a());
    }
}
