package com.tencent.luggage.wxa.nf;

import android.text.TextUtils;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.yi.a0;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends k0 {
    private static final int CTRL_INDEX = 530;
    private static final String NAME = "onLocalServiceEvent";

    public static void a(com.tencent.luggage.wxa.xd.d dVar, a0.e eVar) {
        a(dVar, eVar, "found");
    }

    public static void b(com.tencent.luggage.wxa.xd.d dVar, a0.e eVar) {
        a(dVar, eVar, "lost");
    }

    public static void a(com.tencent.luggage.wxa.xd.d dVar, a0.e eVar, int i3) {
        a(dVar, eVar, "resolveFail", i3);
    }

    public static void b(com.tencent.luggage.wxa.xd.d dVar) {
        a(dVar, (a0.e) null, "stopScan");
    }

    public static synchronized void a(com.tencent.luggage.wxa.xd.d dVar, a0.e eVar, String str) {
        synchronized (a.class) {
            a(dVar, eVar, str, 0);
        }
    }

    public static synchronized void a(com.tencent.luggage.wxa.xd.d dVar, a0.e eVar, String str, int i3) {
        synchronized (a.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", str);
            if (TextUtils.equals(str, "found") || TextUtils.equals(str, "lost") || TextUtils.equals(str, "resolveFail")) {
                hashMap.put("serviceType", eVar.f145816c);
                hashMap.put("serviceName", eVar.f145815b);
                if (!TextUtils.equals(str, "resolveFail")) {
                    hashMap.put("ip", eVar.f145817d);
                    hashMap.put("port", Integer.valueOf(eVar.f145818e));
                    hashMap.put("attributes", eVar.f145814a);
                } else {
                    com.tencent.luggage.wxa.af.c cVar = com.tencent.luggage.wxa.af.i.N;
                    hashMap.put(o.ERRNO_TAG, Integer.valueOf(cVar.f121277a));
                    hashMap.put("errnMsg", String.format(cVar.f121278b, Integer.valueOf(i3)));
                }
            }
            new a().setData(hashMap).setContext(dVar).dispatch();
        }
    }
}
