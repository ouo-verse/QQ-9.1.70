package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.dh;
import com.tencent.luggage.wxa.hn.od;
import com.tencent.luggage.wxa.hn.q4;
import com.tencent.luggage.wxa.hn.u1;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class y {

    /* renamed from: c, reason: collision with root package name */
    public static final u1 f129450c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.k f129451d;

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f129452e;

    /* renamed from: f, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f129453f;

    /* renamed from: g, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f129454g;

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f129455h;

    /* renamed from: i, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f129456i;

    /* renamed from: j, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.e5.j f129457j;

    /* renamed from: k, reason: collision with root package name */
    public static List f129458k;

    /* renamed from: l, reason: collision with root package name */
    public static LinkedList f129459l;

    /* renamed from: m, reason: collision with root package name */
    public static LinkedList f129460m;

    /* renamed from: n, reason: collision with root package name */
    public static int f129461n;

    /* renamed from: o, reason: collision with root package name */
    public static MutableStateFlow f129462o;

    /* renamed from: p, reason: collision with root package name */
    public static MutableStateFlow f129463p;

    /* renamed from: q, reason: collision with root package name */
    public static byte[] f129464q;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f129449b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(y.class, "DynamicAttrInfo", "getDynamicAttrInfo()Lcom/tencent/mm/protocal/protobuf/DynamicAttrInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(y.class, "GlobalAttrInfo", "getGlobalAttrInfo()Lcom/tencent/mm/protocal/protobuf/GlobalAttrInfo;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(y.class, "HostPassThroughInfo", "getHostPassThroughInfo()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(y.class, "forceDisableSkyline", "getForceDisableSkyline()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(y.class, "useSkyline", "getUseSkyline()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(y.class, "reportMemoryInfo", "getReportMemoryInfo()Z", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final y f129448a = new y();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f129465a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f129466b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f129467c;

        public a(String str, String str2, List list) {
            this.f129465a = str;
            this.f129466b = str2;
            this.f129467c = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i3;
            boolean z16;
            LinkedList linkedList;
            LinkedList linkedList2;
            LinkedList linkedList3;
            int i16;
            boolean z17;
            int i17;
            byte[] bArr;
            u1 u1Var;
            try {
                dh a16 = f.a(this.f129465a, this.f129466b, this.f129467c);
                if (a16 == null) {
                    return;
                }
                y yVar = y.f129448a;
                yVar.a(a16.f127522k);
                u1 u1Var2 = a16.f127516e;
                if (u1Var2 != null) {
                    yVar.a(u1Var2);
                }
                q4 q4Var = a16.f127517f;
                if (q4Var != null) {
                    yVar.a(q4Var);
                }
                yVar.a(a16.f127521j);
                if (!yVar.e() && (u1Var = a16.f127516e) != null) {
                    i3 = u1Var.f128784f;
                } else {
                    i3 = 0;
                }
                yVar.b(i3);
                u1 u1Var3 = a16.f127516e;
                boolean z18 = true;
                if (u1Var3 != null && u1Var3.f128785g == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                yVar.a(z16);
                od odVar = a16.f127518g;
                Integer num = null;
                if (odVar != null) {
                    linkedList = odVar.f128371d;
                } else {
                    linkedList = null;
                }
                yVar.a((List) linkedList);
                od odVar2 = a16.f127518g;
                if (odVar2 != null) {
                    linkedList2 = odVar2.f128372e;
                } else {
                    linkedList2 = null;
                }
                yVar.b(linkedList2);
                od odVar3 = a16.f127518g;
                if (odVar3 != null) {
                    linkedList3 = odVar3.f128373f;
                } else {
                    linkedList3 = null;
                }
                yVar.a(linkedList3);
                MutableStateFlow d16 = yVar.d();
                u1 u1Var4 = a16.f127516e;
                if (u1Var4 != null) {
                    i16 = u1Var4.f128790l;
                } else {
                    i16 = 1;
                }
                if (i16 != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                d16.setValue(Boolean.valueOf(z17));
                MutableStateFlow c16 = yVar.c();
                u1 u1Var5 = a16.f127516e;
                if (u1Var5 != null) {
                    i17 = u1Var5.f128791m;
                } else {
                    i17 = 0;
                }
                if (i17 == 0) {
                    z18 = false;
                }
                c16.setValue(Boolean.valueOf(z18));
                com.tencent.luggage.wxa.fn.c cVar = a16.f127523l;
                if (cVar != null) {
                    bArr = cVar.c();
                } else {
                    bArr = null;
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                yVar.a(bArr);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getWxaRuntimeHostAttrSync: useSkyline:");
                sb5.append(yVar.i());
                sb5.append(" reportMemoryInfo:");
                sb5.append(yVar.h());
                sb5.append(TokenParser.SP);
                sb5.append(yVar.f().f128497e);
                sb5.append(" close type=");
                sb5.append(yVar.b().f128782d);
                sb5.append("recommendList size: ");
                List g16 = yVar.g();
                if (g16 != null) {
                    num = Integer.valueOf(g16.size());
                }
                sb5.append(num);
                com.tencent.luggage.wxa.tn.w.a("WxaRuntimeHostAttr", sb5.toString());
                new h().c();
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("WxaRuntimeHostAttr", "obtainWxaRuntimeHostAttr() async update failed " + e16);
            }
        }
    }

    static {
        u1 u1Var = new u1();
        u1Var.f128782d = 0;
        u1Var.f128783e = false;
        f129450c = u1Var;
        com.tencent.luggage.wxa.e5.k kVar = new com.tencent.luggage.wxa.e5.k("Luggage.WxaRuntimeHostAttr");
        f129451d = kVar;
        f129452e = new com.tencent.luggage.wxa.e5.j(kVar, new u1());
        f129453f = new com.tencent.luggage.wxa.e5.j(kVar, new q4());
        f129454g = new com.tencent.luggage.wxa.e5.j(kVar, "");
        Boolean bool = Boolean.FALSE;
        f129455h = new com.tencent.luggage.wxa.e5.j(kVar, bool);
        f129456i = new com.tencent.luggage.wxa.e5.j((com.tencent.luggage.wxa.e5.d) kVar, (Object) 0);
        f129457j = new com.tencent.luggage.wxa.e5.j(kVar, bool);
        f129462o = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        f129463p = StateFlowKt.MutableStateFlow(bool);
        f129464q = new byte[0];
    }

    public final u1 a() {
        return f129450c;
    }

    public final u1 b() {
        return (u1) f129452e.a(this, f129449b[0]);
    }

    public final MutableStateFlow c() {
        return f129463p;
    }

    public final MutableStateFlow d() {
        return f129462o;
    }

    public final boolean e() {
        return ((Boolean) f129455h.a(this, f129449b[3])).booleanValue();
    }

    public final q4 f() {
        return (q4) f129453f.a(this, f129449b[1]);
    }

    public final List g() {
        return f129458k;
    }

    public final boolean h() {
        return ((Boolean) f129457j.a(this, f129449b[5])).booleanValue();
    }

    public final int i() {
        return ((Number) f129456i.a(this, f129449b[4])).intValue();
    }

    public final void a(u1 u1Var) {
        Intrinsics.checkNotNullParameter(u1Var, "<set-?>");
        f129452e.a(this, f129449b[0], u1Var);
    }

    public final void b(int i3) {
        f129456i.a(this, f129449b[4], Integer.valueOf(i3));
    }

    public final void a(q4 q4Var) {
        Intrinsics.checkNotNullParameter(q4Var, "<set-?>");
        f129453f.a(this, f129449b[1], q4Var);
    }

    public final void b(LinkedList linkedList) {
        f129459l = linkedList;
    }

    public final void a(String str) {
        f129454g.a(this, f129449b[2], str);
    }

    public final void a(boolean z16) {
        f129457j.a(this, f129449b[5], Boolean.valueOf(z16));
    }

    public final void a(List list) {
        f129458k = list;
    }

    public final void a(LinkedList linkedList) {
        f129460m = linkedList;
    }

    public final void a(int i3) {
        f129461n = i3;
    }

    public final void a(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        f129464q = bArr;
    }

    public static final void a(String str, String hostAppId, List list) {
        Intrinsics.checkNotNullParameter(hostAppId, "hostAppId");
        com.tencent.luggage.wxa.zp.h.f146825d.b(new a(str, hostAppId, list), "refreshWxaRuntimeHostAttr");
    }
}
