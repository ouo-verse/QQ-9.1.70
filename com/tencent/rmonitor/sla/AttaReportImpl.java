package com.tencent.rmonitor.sla;

import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AttaReportImpl implements f {
    private void b(int i3, int i16, long j3) {
        boolean c16 = e.b().c("RMConfigEvent");
        if (c16) {
            AttaEvent attaEvent = new AttaEvent("RMConfigEvent");
            attaEvent.T(i3);
            attaEvent.Q(i16);
            attaEvent.S((int) j3);
            attaEvent.O(1);
            AttaEventReporter.INSTANCE.a().c(attaEvent);
        }
        Logger.f365497g.i("RMonitor_atta", "reportConfigEvent, eventResult: " + i3 + ", errorCode: " + i16 + ", eventCostInMs: " + j3 + ", hitSampling: " + c16);
    }

    @Override // com.tencent.rmonitor.sla.f
    public void a(String str, int i3, int i16, long j3) {
        if ("RMConfigEvent".equals(str)) {
            b(i3, i16, j3);
        }
    }
}
