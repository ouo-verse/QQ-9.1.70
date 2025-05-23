package com.tencent.luggage.wxa.kj;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class k extends com.tencent.luggage.wxa.xd.p {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onPageReload";

    public void a(v vVar, com.tencent.luggage.wxa.xd.d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("path", vVar.A0());
        setData(hashMap).setContext(dVar, vVar.getComponentId()).dispatch();
    }
}
