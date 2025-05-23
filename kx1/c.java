package kx1;

import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f413363a;

    public static void a(View view, String str, String str2, String str3, String str4) {
        VideoReport.setPageId(view, "pg_sgrp_private_aio");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("pgid", "pg_sgrp_private_aio");
        hashMap.put("touin", str4);
        f413363a = hashMap;
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.setElementId(view, "em_sgrp_robot_channel_source_tail");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QCircleDaTongConstant.ElementParamKey.SGRP_CHANNEL_NAME, str2);
        hashMap2.put("sgrp_channel_id", str);
        hashMap2.put("sgrp_robot_name", "");
        hashMap2.put("sgrp_robot_id", str3);
        VideoReport.setElementParams(view, hashMap2);
        hashMap2.put("pgid", "pg_sgrp_private_aio");
        hashMap2.put("eid", "em_sgrp_robot_channel_source_tail");
        VideoReport.reportEvent("clck", view, hashMap2);
        VideoReport.reportEvent("imp", view, hashMap2);
        VideoReport.reportEvent("imp_end", view, hashMap2);
    }
}
