package com.tencent.biz.richframework.video.rfw.player.exp;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWLowDeviceStatusMonitorManager;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWLowDeviceRenderExp {
    public static int sDropFrame;
    private static volatile boolean sExpose;

    public static void addExpToQFSPlayerReport(JSONObject jSONObject) {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_render_new", true) || !QCircleVideoDeviceInfoUtils.isLowDevice()) {
            return;
        }
        String expName = getExpName();
        if (jSONObject != null && !TextUtils.isEmpty(expName)) {
            try {
                reportExpExposure();
                jSONObject.put(ICustomDataEditor.STRING_PARAM_5, expName);
                QQVideoPlaySDKManager.addSuperGlobalReportData("param_bucket1", expName);
            } catch (JSONException e16) {
                RFWLog.e("RFWLowDeviceRenderExp", RFWLog.USR, e16);
            }
        }
    }

    private static String getExpName() {
        if (!QCircleVideoDeviceInfoUtils.isLowDevice()) {
            QLog.d("RFWLowDeviceRenderExp", 1, "getExpName :is not low device");
            return "";
        }
        return ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_qfs_low_device_prender_9_0_30");
    }

    public static int getHighCpuUsageThreshold() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_low_device_prender_max_drop_frame", "20");
        try {
            return Integer.parseInt(loadAsString);
        } catch (Exception e16) {
            RFWLog.e("RFWLowDeviceRenderExp", RFWLog.USR, "[getHighCpuUsageThreshold] error: " + e16 + ",serverConfig:" + loadAsString);
            return 20;
        }
    }

    private static boolean isHighDropFrame() {
        if (sDropFrame > getHighCpuUsageThreshold()) {
            return true;
        }
        return false;
    }

    private static void reportExpExposure() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_render_new", true) && !sExpose) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_qfs_low_device_prender_9_0_30");
            RFWLog.d("RFWLowDeviceRenderExp", RFWLog.CLR, "hit low device render exp:" + shouldPreRender());
            sExpose = true;
        }
    }

    public static void reportRender(boolean z16) {
        if (!QCircleVideoDeviceInfoUtils.isLowDevice() || !"exp_qfs_low_device_prender_9_0_30_B".equals(getExpName())) {
            return;
        }
        QCircleQualityReporter.reportQualityEvent("low_device_do_render", Arrays.asList(QCircleReportHelper.newEntry("ret_code", String.valueOf(z16 ? 1 : 0))), false);
    }

    public static void setDropFrame(int i3) {
        sDropFrame = i3;
    }

    public static boolean shouldPreRender() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_render_new", true)) {
            QLog.d("RFWLowDeviceRenderExp", 1, "hitExpB switch close return false");
            return false;
        }
        if (!QCircleVideoDeviceInfoUtils.isLowDevice() || isHighDropFrame()) {
            return false;
        }
        if (RFWLowDeviceStatusMonitorManager.INSTANCE.canPrerender()) {
            return true;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_low_device_render_9075", false)) {
            QLog.d("RFWLowDeviceRenderExp", 1, "exp by can lang");
            return true;
        }
        return "exp_qfs_low_device_prender_9_0_30_B".equals(((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).getAssignment("exp_qfs_low_device_prender_9_0_30"));
    }
}
