package com.tencent.luggage.wxa.jg;

import android.os.Build;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerMsg;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a0 implements c0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f131059b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f131060a = "deviceInfo";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public String a() {
        return this.f131060a;
    }

    @Override // com.tencent.luggage.wxa.jg.f
    public Map a(String type, com.tencent.luggage.wxa.ic.d component) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(component, "component");
        HashMap hashMap = new HashMap();
        String CPU_ABI = Build.CPU_ABI;
        Intrinsics.checkNotNullExpressionValue(CPU_ABI, "CPU_ABI");
        hashMap.put("abi", CPU_ABI);
        String[] SUPPORTED_ABIS = Build.SUPPORTED_ABIS;
        if (SUPPORTED_ABIS != null) {
            Intrinsics.checkNotNullExpressionValue(SUPPORTED_ABIS, "SUPPORTED_ABIS");
            if (!(SUPPORTED_ABIS.length == 0)) {
                String str = SUPPORTED_ABIS[0];
                Intrinsics.checkNotNullExpressionValue(str, "Build.SUPPORTED_ABIS[0]");
                hashMap.put("deviceAbi", str);
            }
        }
        com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
        com.tencent.luggage.wxa.fd.q j06 = runtime != null ? runtime.j0() : null;
        com.tencent.luggage.wxa.j4.g gVar = j06 instanceof com.tencent.luggage.wxa.j4.g ? (com.tencent.luggage.wxa.j4.g) j06 : null;
        if (gVar != null) {
            hashMap.put("benchmarkLevel", Integer.valueOf(gVar.f130829e0));
        }
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        hashMap.put("brand", BRAND);
        String g16 = com.tencent.luggage.wxa.t9.l.g();
        Intrinsics.checkNotNullExpressionValue(g16, "getModel()");
        hashMap.put("model", g16);
        hashMap.put(TVKPlayerMsg.PLAYER_CHOICE_SYSTEM, "Android " + Build.VERSION.RELEASE);
        int a16 = com.tencent.luggage.wxa.uk.m.a(component);
        String b16 = com.tencent.luggage.wxa.t9.i.b();
        if (b16 == null) {
            b16 = "unknown";
        }
        hashMap.put("memorySize", Integer.valueOf(a16));
        hashMap.put("cpuType", b16);
        return hashMap;
    }
}
