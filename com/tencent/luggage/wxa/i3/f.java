package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.ch;
import com.tencent.luggage.wxa.hn.dh;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.hn.u1;
import com.tencent.luggage.wxa.tn.w0;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f129231a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final String f129232b = "CgiWxaRuntimeHostAttrSync";

    public static final dh a(String str, String hostAppId, List list) {
        Integer num;
        e9 e9Var;
        Integer num2;
        Integer num3;
        u1 u1Var;
        u1 u1Var2;
        u1 u1Var3;
        h0 h0Var;
        h0 h0Var2;
        Intrinsics.checkNotNullParameter(hostAppId, "hostAppId");
        Integer num4 = null;
        if (w0.c(hostAppId)) {
            com.tencent.luggage.wxa.tn.w.b(f129232b, "hostAppId is null, return");
            return null;
        }
        ch chVar = new ch();
        chVar.f127435e = hostAppId;
        chVar.f127436f = com.tencent.luggage.wxa.gn.a.a();
        chVar.f127437g = com.tencent.luggage.wxa.gn.a.b();
        if (list != null) {
            chVar.f127438h = new LinkedList(list);
        }
        dh dhVar = (dh) ((com.tencent.luggage.wxa.bj.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.bj.c.class)).a("/cgi-bin/mmbiz-bin/wxaruntime/hostattrsync", str, chVar, dh.class);
        String str2 = f129232b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getWxaRuntimeHostAttrSync appId:");
        sb5.append(str);
        sb5.append(" hostAppId:");
        sb5.append(hostAppId);
        sb5.append(" brand:");
        sb5.append(chVar.f127436f);
        sb5.append(" model:");
        sb5.append(chVar.f127437g);
        sb5.append(" response:");
        if (dhVar != null && (h0Var2 = dhVar.f128743d) != null) {
            num = Integer.valueOf(h0Var2.f127731d);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(" errMsg:");
        if (dhVar != null && (h0Var = dhVar.f128743d) != null) {
            e9Var = h0Var.f127732e;
        } else {
            e9Var = null;
        }
        sb5.append(e9Var);
        sb5.append(", close_button_action_type:");
        if (dhVar != null && (u1Var3 = dhVar.f127516e) != null) {
            num2 = Integer.valueOf(u1Var3.f128782d);
        } else {
            num2 = null;
        }
        sb5.append(num2);
        sb5.append(", use_skyline:");
        if (dhVar != null && (u1Var2 = dhVar.f127516e) != null) {
            num3 = Integer.valueOf(u1Var2.f128784f);
        } else {
            num3 = null;
        }
        sb5.append(num3);
        sb5.append(" report_memory_info:");
        if (dhVar != null && (u1Var = dhVar.f127516e) != null) {
            num4 = Integer.valueOf(u1Var.f128785g);
        }
        sb5.append(num4);
        com.tencent.luggage.wxa.tn.w.d(str2, sb5.toString());
        return dhVar;
    }
}
