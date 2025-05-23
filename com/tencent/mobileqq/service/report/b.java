package com.tencent.mobileqq.service.report;

import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.QZonePushReporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    @NonNull
    private static Map<String, Object> a(Activity activity, boolean z16, boolean z17) {
        HashMap hashMap = new HashMap();
        hashMap.put("reddot_type", h(z16));
        hashMap.put("reddot_content", g(z16));
        if (i(activity) && z16) {
            hashMap.put("page", "2");
        } else {
            hashMap.put("page", "1");
        }
        if (QZoneApiProxy.needShowQzoneFrame(activity, MobileQQ.sMobileQQ.peekAppRuntime())) {
            hashMap.put(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "2");
        } else {
            hashMap.put(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "1");
        }
        if (!z17 && TextUtils.isEmpty(h(z16))) {
            hashMap.put(ProfileCardDtReportUtil.IS_REDDOT, "0");
        } else {
            hashMap.put(ProfileCardDtReportUtil.IS_REDDOT, "1");
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QZonePushReporter.EVENT_VALUE, JSONUtil.mapTojsonString(hashMap).toString());
        hashMap2.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_reddot");
        hashMap2.put(QZonePushReporter.EVENT_CODE_TYPE3, "");
        return hashMap2;
    }

    private static String b(List<Integer> list) {
        StringBuilder sb5 = new StringBuilder();
        if (!bl.b(list)) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append(list.get(i3));
                if (i3 < list.size() - 1) {
                    sb5.append("#");
                }
            }
        }
        return sb5.toString();
    }

    public static void c(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneDTRedDotReporter", 1, "customReport  params error ");
            return;
        }
        Map<String, Object> a16 = new a().a();
        if (map != null) {
            a16.putAll(map);
        }
        VideoReport.reportEvent(str, a16);
    }

    public static void d(Activity activity, boolean z16) {
        Map<String, Object> a16 = a(activity, z16, false);
        a16.put(QZonePushReporter.EVENT_CODE_TYPE2, "click");
        j("click report", a16);
        c("ev_qz_reddot_click", a16);
    }

    public static void e(Activity activity, boolean z16) {
        if (TextUtils.isEmpty(h(z16))) {
            return;
        }
        Map<String, Object> a16 = a(activity, z16, true);
        a16.put(QZonePushReporter.EVENT_CODE_TYPE2, QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE);
        j("exposure report", a16);
        c("ev_qz_reddot_exposure", a16);
    }

    public static void f(mobile_count_rsp_new mobile_count_rsp_newVar) {
        if (mobile_count_rsp_newVar == null || mobile_count_rsp_newVar.stMapCountInfo == null || TextUtils.isEmpty(g(true))) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("reddot_content", g(true));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(QZonePushReporter.EVENT_VALUE, JSONUtil.mapTojsonString(hashMap).toString());
        hashMap2.put(QZonePushReporter.EVENT_CODE_TYPE1, "ev_qz_reddot");
        hashMap2.put(QZonePushReporter.EVENT_CODE_TYPE2, "pull");
        c("ev_qz_reddot_pull", hashMap2);
    }

    private static String g(boolean z16) {
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.QZONE_MANAGER);
        if (qZoneManagerImp == null) {
            return "";
        }
        List<Integer> i3 = com.tencent.mobileqq.service.qzone.c.i(qZoneManagerImp);
        int j3 = com.tencent.mobileqq.service.qzone.c.j(qZoneManagerImp, z16);
        StringBuilder sb5 = new StringBuilder();
        String b16 = b(i3);
        String h16 = h(z16);
        h16.hashCode();
        char c16 = '\uffff';
        switch (h16.hashCode()) {
            case 49:
                if (h16.equals("1")) {
                    c16 = 0;
                    break;
                }
                break;
            case 50:
                if (h16.equals("2")) {
                    c16 = 1;
                    break;
                }
                break;
            case 51:
                if (h16.equals("3")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                sb5.append(j3);
                break;
            case 1:
                sb5.append(b16);
                break;
            case 2:
                sb5.append(b16);
                sb5.append("#");
                sb5.append(j3);
                break;
        }
        return sb5.toString();
    }

    private static String h(boolean z16) {
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getManager(QQManagerFactory.QZONE_MANAGER);
        if (qZoneManagerImp == null) {
            return "";
        }
        List<Integer> i3 = com.tencent.mobileqq.service.qzone.c.i(qZoneManagerImp);
        int j3 = com.tencent.mobileqq.service.qzone.c.j(qZoneManagerImp, z16);
        if (!bl.b(i3) && j3 > 0) {
            return "3";
        }
        if (!bl.b(i3)) {
            return "2";
        }
        if (j3 <= 0) {
            return "";
        }
        return "1";
    }

    public static boolean i(Activity activity) {
        if (activity == null || !(activity instanceof SplashActivity)) {
            return false;
        }
        SplashActivity splashActivity = (SplashActivity) activity;
        if (splashActivity.getCurrentTab() != com.tencent.mobileqq.activity.home.impl.a.f183041d && splashActivity.getCurrentTab() != com.tencent.mobileqq.activity.home.impl.a.f183045h) {
            return false;
        }
        return true;
    }

    private static void j(String str, Map<String, Object> map) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append(" \uff1a\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            sb5.append(key);
            sb5.append(":");
            sb5.append(value);
            sb5.append("\n");
        }
        QLog.i("QZoneDTRedDotReporter", 2, sb5.toString());
    }
}
