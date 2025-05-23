package com.tencent.luggage.wxa.rf;

import android.os.Bundle;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends k0 {
    private static final int CTRL_INDEX = 355;
    private static final String NAME = "onHCEMessage";

    /* renamed from: a, reason: collision with root package name */
    public static final a f139618a = new a();

    public static synchronized void a(com.tencent.luggage.wxa.xd.d dVar, int i3, Bundle bundle) {
        synchronized (a.class) {
            w.d("MicroMsg.EventOnHCEMessageReceived", "alvinluo EventOnHCEMessageReceived dispatch appId: %s, eventType: %d", dVar.getAppId(), Integer.valueOf(i3));
            if (i3 == 31) {
                if (bundle != null) {
                    String string = bundle.getString("key_apdu_command");
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageType", 1);
                    hashMap.put("data", string);
                    f139618a.setContext(dVar).setData(hashMap).dispatch();
                }
            } else if (i3 == 41 && bundle != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("messageType", 2);
                hashMap2.put("reason", Integer.valueOf(bundle.getInt("key_on_deactivated_reason")));
                f139618a.setContext(dVar).setData(hashMap2).dispatch();
            }
        }
    }
}
