package com.tencent.mobileqq.winkpublish.hook;

import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.mobileqq.winkpublish.report.e;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a {
    public static void a(List<String> list) {
        e eVar = new e(0L, null);
        WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
        builder.eventId("T_HOOK_CLASS_RECORD").traceId("").ext1(c(list)).desc(eVar.getMessage()).retCode(String.valueOf(eVar.transformedCode()));
        WinkPublishReportQueue.INSTANCE.report(builder.getReportData(), "QCIRCLE");
        QLog.i("zhenYan", 1, "report :" + c(list) + "report size: " + list.size());
    }

    public static void b(List<String> list) {
        QLog.d("zhenYan", 1, "report total size:" + list.size());
        if (list.size() == 0) {
            return;
        }
        if (list.size() > 1000) {
            int size = list.size() / 1000;
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i3 < size) {
                i3++;
                int i18 = (i3 * 1000) - 1;
                a(list.subList(i16, i18));
                QLog.d("zhenYan", 1, "report start:" + i16 + ",end:" + i18);
                i17 = i16;
                i16 = i18;
            }
            if (i16 != list.size() - 1) {
                a(list.subList(i16, list.size() - 1));
                QLog.d("zhenYan", 1, "report start:" + i17 + ",end:" + i16);
                return;
            }
            return;
        }
        a(list);
    }

    public static String c(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append(list.get(i3));
                if (i3 != list.size() - 1) {
                    sb5.append(",");
                }
            }
            return sb5.toString();
        }
        return "";
    }
}
