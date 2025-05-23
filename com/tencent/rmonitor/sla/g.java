package com.tencent.rmonitor.sla;

import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {
    public static void a(String str, String str2, String str3, String str4, String str5) {
        if (!e.b().c("RMIllegalReport_Client")) {
            Logger.f365497g.d("RMonitor_config_atta", "report fail for not sampling");
            return;
        }
        AttaEvent attaEvent = new AttaEvent("RMIllegalReport_Client");
        attaEvent.a0(str);
        attaEvent.b0(str2);
        attaEvent.g0(str3);
        attaEvent.h0(str4);
        attaEvent.l0(str5);
        AttaEventReporter.INSTANCE.a().i(attaEvent, true);
    }
}
