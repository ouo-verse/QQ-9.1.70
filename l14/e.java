package l14;

import com.tencent.rmonitor.sla.AttaEvent;
import com.tencent.rmonitor.sla.AttaEventReporter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {
    public static void a(String str, String str2) {
        b("QuantileErrorEvent", str, str2);
    }

    private static void b(String str, String... strArr) {
        AttaEvent attaEvent = new AttaEvent(str);
        attaEvent.o0(strArr);
        AttaEventReporter.INSTANCE.a().i(attaEvent, true);
    }
}
