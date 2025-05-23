package cooperation.vip;

import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {
    public static void a(String str, int i3, int i16, int i17, boolean z16, boolean z17) {
        if (QZLog.isColorLevel()) {
            QZLog.i(str, 2, "reportToPf00064 actiontype = " + i3 + " subactionType = " + i16 + " reserves = " + i17 + " isNeedSample = " + z16 + " isReportNow = " + z17);
        }
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(i3, i16, i17), z16, z17);
    }

    public static void b(int i3, int i16) {
        a("VipSignature", i3, i16, 0, false, false);
    }

    public static void c(int i3) {
        a("WidgetReport", 302, 7, i3, false, false);
    }
}
