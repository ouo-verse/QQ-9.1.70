package com.tencent.luggage.wxa.kf;

import com.tencent.luggage.wxa.uk.h;
import com.tencent.luggage.wxa.xi.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends c {
    public static final int CTRL_INDEX = 1183;
    public static final String NAME = "createLoadSubPackageTaskForWaiter";

    public static String b(String str) {
        return "AwaitTagLoadSubPackage_" + str;
    }

    @Override // com.tencent.luggage.wxa.nf.b
    public void a(com.tencent.luggage.wxa.xd.d dVar, String str) {
        super.a(dVar, str);
        h.a(dVar).i(b(str));
    }

    @Override // com.tencent.luggage.wxa.kf.c
    public void a(com.tencent.luggage.wxa.xd.d dVar, String str, a.e eVar, String str2, String str3) {
        super.a(dVar, str, eVar, str2, str3);
        h.a(dVar).a(b(str), eVar);
    }
}
