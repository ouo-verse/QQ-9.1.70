package com.tencent.luggage.wxa.ge;

import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public static void a(int i3) {
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(762L, i3, 1L, false);
    }

    public static void a(int i3, int i16) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(762);
        iDKey2.SetKey(i16);
        iDKey2.SetValue(1);
        arrayList.add(iDKey2);
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(arrayList, true);
    }
}
