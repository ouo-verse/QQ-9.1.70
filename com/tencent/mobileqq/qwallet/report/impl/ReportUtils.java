package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.c;
import com.tencent.mobileqq.qwallet.hb.aio.impl.d;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReportUtils {
    static {
        UserAction.registerTunnel(new TunnelInfo(QQBeaconReport.QWALLET_APP_KEY));
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, jSONObject.optString(str));
        }
        return hashMap;
    }

    private static final String b(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return "";
        }
        return appRuntime.getAccount();
    }

    public static void c(String str, Map<String, String> map) {
        MobileQQ mobileQQ;
        if (map != null) {
            if (!map.containsKey("A8") && (mobileQQ = MobileQQ.sMobileQQ) != null) {
                map.put("A8", b(mobileQQ.peekAppRuntime()));
            }
            if (!map.containsKey("plat")) {
                map.put("plat", "android");
            }
            if (!map.containsKey("version")) {
                map.put("version", AppSetting.f99551k);
            }
        }
        h(str, map);
    }

    public static void d(String str, JSONObject jSONObject) {
        c(str, a(jSONObject));
    }

    public static void e(String str, p pVar) {
        String str2;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            str2 = "1";
        } else if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            str2 = "2";
        } else {
            str2 = "0";
        }
        f(str, pVar, str2);
    }

    public static void f(String str, p pVar, String str2) {
        String str3;
        String str4;
        String str5;
        if (pVar == null) {
            str4 = "";
            str5 = str4;
        } else {
            try {
                int i3 = pVar.f179555d;
                if (i3 == 3000) {
                    str3 = "2";
                } else if (i3 == 1) {
                    str3 = "1";
                } else if (i3 == 10014) {
                    str3 = "11";
                } else {
                    str3 = "0";
                }
                if (i3 == 10014) {
                    str4 = pVar.f179559f;
                } else {
                    str4 = pVar.f179557e;
                }
                str5 = str3;
            } catch (Exception e16) {
                QLog.e("ReportUtils", 1, e16, new Object[0]);
                return;
            }
        }
        c.d(str4, str, QCircleDaTongConstant.ElementParamValue.WALLET, 0, 0, str5, NetConnInfoCenter.getServerTimeMillis() + "", str2, "");
    }

    public static void g(String str, String str2, String str3, String str4, String str5) {
        String str6;
        try {
            if (d.f(str2)) {
                str6 = "2";
            } else if (d.h(str2)) {
                str6 = "1";
            } else if (d.g(str2)) {
                str6 = "11";
            } else {
                str6 = "0";
            }
            String str7 = str6;
            String str8 = NetConnInfoCenter.getServerTimeMillis() + "";
            if (QLog.isColorLevel()) {
                QLog.i("ReportUtils", 2, String.format("opName: %s__d1: %s__d3: %s__d4: %s__toUin: %s", str, str7, str3, str4, str5));
            }
            c.d(str5, str, QCircleDaTongConstant.ElementParamValue.WALLET, 0, 0, str7, str8, str3, str4);
        } catch (Exception e16) {
            QLog.e("ReportUtils", 1, e16, new Object[0]);
        }
    }

    private static void h(final String str, final Map<String, String> map) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.report.impl.ReportUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ReportMethodProxy.onUserActionToTunnel(QQBeaconReport.QWALLET_APP_KEY, str, true, -1L, -1L, map, true, true);
            }
        }, 16, null, false);
    }

    public static void i(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap hashMap = new HashMap();
        hashMap.put(PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT, "Vip_pay_mywallet");
        hashMap.put("op_type", QCircleDaTongConstant.ElementParamValue.WALLET);
        hashMap.put("op_in", str2);
        hashMap.put("d1", str3);
        hashMap.put("d2", str4);
        hashMap.put("d3", str5);
        hashMap.put("d4", AppSetting.f99551k);
        hashMap.put("A8", str6);
        h(str, hashMap);
    }
}
