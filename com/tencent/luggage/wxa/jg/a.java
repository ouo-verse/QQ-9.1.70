package com.tencent.luggage.wxa.jg;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.jg.j;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.p {
    private static final int CTRL_INDEX = 153;
    private static final String NAME = "onNetworkStatusChange";

    public static void c(com.tencent.luggage.wxa.xd.d dVar) {
        boolean z16;
        HashMap hashMap = new HashMap();
        j.g a16 = j.a(com.tencent.luggage.wxa.tn.z.c());
        if (a16 != j.g.None) {
            z16 = true;
        } else {
            z16 = false;
        }
        hashMap.put("isConnected", Boolean.valueOf(z16));
        hashMap.put(DKEngine.GlobalKey.NET_WORK_TYPE, a16.f131107a);
        com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrandOnNetworkStatusChangeEvent", "networkType = %s", a16.f131107a);
        new a().setContext(dVar).setData(hashMap).dispatch();
    }
}
