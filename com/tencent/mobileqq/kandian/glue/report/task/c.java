package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f239979a = "kandianreport.TaskException";

    public static void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", str);
            jSONObject.put("version", TaskManager.f239890j + "");
            jSONObject.put("so_version", KandianReportSoLoader.n() + "");
            jSONObject.put("phone", DeviceInfoMonitor.getModel());
            jSONObject.put("sys_version", ah.t());
            jSONObject.put(AppConstants.Preferences.QQ_VERSION, ah.P());
            jSONObject.put("appid", AppSetting.f() + "");
            QLog.d(f239979a, 1, "reportException: " + jSONObject.toString());
            PublicAccountReportUtils.l(null, "", "0X8009831", "0X8009831", 0, 0, "", "", "", jSONObject.toString(), false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void b(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", str2);
            jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, str);
            jSONObject.put("so_version", KandianReportSoLoader.n() + "");
            jSONObject.put("phone", DeviceInfoMonitor.getModel());
            jSONObject.put("sys_version", ah.t());
            jSONObject.put(AppConstants.Preferences.QQ_VERSION, ah.P());
            jSONObject.put("version", TaskManager.f239890j + "");
            jSONObject.put("appid", AppSetting.f() + "");
            PublicAccountReportUtils.l(null, "", "0X8009830", "0X8009830", 0, 0, "", "", "", jSONObject.toString(), false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void c(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", str);
            jSONObject.put("so_version", KandianReportSoLoader.n() + "");
            jSONObject.put("phone", DeviceInfoMonitor.getModel());
            jSONObject.put("sys_version", ah.t());
            jSONObject.put(AppConstants.Preferences.QQ_VERSION, ah.P());
            jSONObject.put("version", TaskManager.f239890j + "");
            jSONObject.put("appid", AppSetting.f() + "");
            PublicAccountReportUtils.l(null, "", "0X800982E", "0X800982E", 0, 0, "", "", "", jSONObject.toString(), false);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
