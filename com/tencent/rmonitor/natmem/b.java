package com.tencent.rmonitor.natmem;

import com.tencent.rmonitor.sla.AttaEvent;
import com.tencent.rmonitor.sla.AttaEventReporter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    private static void a(String str, String... strArr) {
        AttaEvent attaEvent = new AttaEvent(str);
        attaEvent.o0(strArr);
        AttaEventReporter.INSTANCE.a().i(attaEvent, true);
    }

    public static void b(int i3) {
        a("NatMemSigJmpEvent", String.valueOf(i3));
    }

    public static void c(String str) {
        a("NatMemFailEvent", str);
    }

    public static void d() {
        a("NatMemSuccEvent", new String[0]);
    }
}
