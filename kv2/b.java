package kv2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import pw2.x;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class b {
    public static void a(String str, boolean z16, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            if (!aVar.f413321i) {
                c(z16, aVar.f413313a, aVar.f413314b, aVar.f413315c, aVar.f413319g, aVar.f413316d, aVar.f413317e);
            }
        } else if (!aVar.f413321i) {
            iv2.a.b(aVar.f413313a, aVar.f413314b, aVar.f413315c, x.a(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP), aVar.f413319g, aVar.f413316d, aVar.f413317e);
        }
    }

    public static void b(a aVar, String str) {
        if (!TextUtils.isEmpty(str) && !aVar.f413321i) {
            iv2.a.b(aVar.f413313a, aVar.f413314b, aVar.f413315c, aVar.f413318f, aVar.f413319g, aVar.f413316d, aVar.f413317e);
        }
    }

    private static void c(boolean z16, String str, AdReport adReport, String str2, String str3, String str4, String str5) {
        if (z16) {
            iv2.a.b(str, adReport, str2, x.a(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_SUCC_XS), str3, str4, str5);
        } else {
            iv2.a.b(str, adReport, str2, x.a(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_FAIL_XS), str3, str4, str5);
        }
    }

    public static void d(boolean z16, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            QAdVrReport.l(str2, z16, str, 1);
        }
    }
}
