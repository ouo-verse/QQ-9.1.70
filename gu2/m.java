package gu2;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class m implements hv2.a {
    @Override // hv2.a
    public void a(@Nullable Object obj, @Nullable String str, @Nullable Object obj2) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementParam(obj, str, obj2);
        }
    }

    @Override // hv2.a
    public void b(String str, Map<String, ?> map) {
        HashMap hashMap;
        QLog.d("QAdVRServiceProvider", 1, "vrReportEvent, eventId=" + str + ";params=" + map);
        if (map != null) {
            hashMap = new HashMap(map);
        } else {
            hashMap = new HashMap();
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
        VideoReport.reportEvent(str, hashMap);
    }

    @Override // hv2.a
    public Map<String, Object> c(View view) {
        return VideoReport.paramsForView("", view);
    }

    @Override // hv2.a
    public void d(Object obj, int i3) {
        if (obj == null) {
            return;
        }
        if (i3 == 0) {
            VideoReport.setElementReportPolicy(obj, ReportPolicy.REPORT_POLICY_NONE);
        } else if (i3 == 3) {
            VideoReport.setElementReportPolicy(obj, ReportPolicy.REPORT_POLICY_ALL);
        }
    }

    @Override // hv2.a
    public void e(@Nullable Object obj, @Nullable String str, @Nullable Map<String, ?> map) {
        HashMap hashMap;
        if (obj != null && !TextUtils.isEmpty(str)) {
            VideoReport.setElementId(obj, str);
            if (map != null) {
                hashMap = new HashMap(map);
            } else {
                hashMap = new HashMap();
            }
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
            VideoReport.setElementParams(obj, hashMap);
        }
    }

    @Override // hv2.a
    public Map<String, Object> f() {
        return VideoReport.getPublicParamInterface().getPublicParams();
    }

    @Override // hv2.a
    public void setLogicParent(View view, View view2) {
        VideoReport.setLogicParent(view, view2);
    }

    @Override // hv2.a
    public void setPageParams(Object obj, @Nullable Map<String, ?> map) {
        if (obj != null && !y.i(map)) {
            HashMap hashMap = new HashMap(map);
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0N9K8652HOG8");
            VideoReport.setPageParams(obj, new PageParams(hashMap));
        }
    }
}
