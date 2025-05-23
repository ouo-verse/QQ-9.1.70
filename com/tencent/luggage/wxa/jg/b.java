package com.tencent.luggage.wxa.jg;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.jg.j;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.p {
    private static final int CTRL_INDEX = -1;
    private static final String NAME = "onNetworkWeakChange";

    public static void a(com.tencent.luggage.wxa.xd.d dVar, boolean z16) {
        HashMap hashMap = new HashMap();
        j.g a16 = j.a(com.tencent.luggage.wxa.tn.z.c());
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, a16.f131107a);
        hashMap.put("weakNet", Boolean.valueOf(z16));
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandOnNetworkWeakChangeEvent", "networkType = %s,weakNet = %b", a16.f131107a, Boolean.valueOf(z16));
        new b().setContext(dVar).setData(hashMap).dispatch();
    }
}
