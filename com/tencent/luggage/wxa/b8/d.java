package com.tencent.luggage.wxa.b8;

import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final d f121916a = new d();

    @Override // com.tencent.luggage.wxa.b8.j
    public void a(a action, int i3, String manufactureName, String deviceName, boolean z16) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(manufactureName, "manufactureName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        w.d("MicroMsg.CastContracts", "handleReport, action: " + action + ", deviceCount: " + i3 + ", manufactureName: " + manufactureName + ", deviceName: " + deviceName + ", connectSuccess: " + z16);
    }
}
