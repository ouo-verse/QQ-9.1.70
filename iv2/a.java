package iv2;

import com.tencent.qqlive.ona.protocol.jce.AdReport;
import ew2.e;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static void a(String str, AdReport adReport, String str2, String str3, String str4, String str5, String str6) {
        if (adReport == null) {
            n.b("EffectReporter", "reportEffect, effectReport is null, return.");
            return;
        }
        e F = e.F(str, adReport, str2, str3, str4, str5, str6);
        if (F != null) {
            F.t(null);
        }
    }

    public static void b(String str, AdReport adReport, String str2, String str3, String str4, String str5, String str6) {
        a(str, adReport, str2, str3, str4, str5, str6);
    }
}
