package ee2;

import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.pandoraevent.PandoraEventReportHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import ee2.b;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {
    public static void a(String str, String str2, String str3) {
        String str4 = a.f396187e.get(str);
        String str5 = a.f396186d.get(str);
        QLog.d("PandoraEventReporter", 1, "PandoraEventRecord{systemApi: " + str + ", infoDesc: " + str3 + ", infoName: " + str4 + ", infoType: " + str5 + ", eventScene: " + str2 + "}");
        if (str5 != null && str4 != null) {
            if (str5.equals("C2-1") && TextUtils.isEmpty(str3) && !str4.equals("C2-1-11")) {
                return;
            }
            PandoraEventReportHelper.c(new b.a().i(str5).f(str4).g(a.f396183a.get(str4)).h(d.d(str4, str2)).e(str3).d(he2.a.d()).a(1).c("").b(), true);
        }
    }

    public static void b(fe2.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_info_type", aVar.f398368d.f396188a);
        hashMap.put("dt_info_name", aVar.f398368d.f396189b);
        hashMap.put("dt_info_reason", aVar.f398368d.f396190c);
        hashMap.put("dt_info_scene", aVar.f398368d.f396191d);
        hashMap.put("dt_info_desc", aVar.f398368d.f396192e);
        hashMap.put(DTParamKey.REPORT_KEY_INFO_COUNT, Integer.valueOf(aVar.f398367c));
        hashMap.put("dt_action_type", Integer.valueOf(aVar.f398368d.f396194g));
        hashMap.put("dt_agg_flag", aVar.f398366b);
        VideoReport.reportEvent(DTEventKey.USER_PRIVACY, hashMap);
        QLog.d("PandoraEventReporter", 1, "[PrivacyEvent] VideoReport param:" + hashMap);
    }
}
