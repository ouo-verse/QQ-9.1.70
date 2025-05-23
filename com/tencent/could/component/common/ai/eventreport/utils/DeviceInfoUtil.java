package com.tencent.could.component.common.ai.eventreport.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.could.component.common.ai.eventreport.api.EventReportConfig;
import com.tencent.could.component.common.ai.eventreport.api.EventReporter;
import com.tencent.could.component.common.ai.eventreport.entry.DeviceInfoEntry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.UUID;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DeviceInfoUtil {
    static IPatchRedirector $redirector_;

    public DeviceInfoUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String createDeviceInfo() {
        DeviceInfoEntry deviceInfoEntry = new DeviceInfoEntry();
        deviceInfoEntry.setSdkVersion(EventReporter.getInstance().getEventReportConfig().getSdkVersion());
        deviceInfoEntry.setDeviceModel(Base64.encodeToString(getDeviceModel().getBytes(), 2));
        deviceInfoEntry.setOsVersion("android-" + Base64.encodeToString(String.valueOf(Build.VERSION.SDK_INT).getBytes(), 2));
        Context context = EventReporter.getInstance().getContext();
        if (context == null) {
            try {
                return deviceInfoEntry.toJsonString();
            } catch (JSONException unused) {
                Log.e("DeviceInfoUtil", "changeDeviceInfoToJson json error");
                return "";
            }
        }
        deviceInfoEntry.setPackageName(context.getPackageName());
        deviceInfoEntry.setDeviceToken(getDeviceUuid(context));
        try {
            return deviceInfoEntry.toJsonString();
        } catch (JSONException unused2) {
            Log.e("DeviceInfoUtil", "changeDeviceInfoToJson json error");
            return "";
        }
    }

    public static String getDeviceModel() {
        String string;
        String deviceModel = EventReporter.getInstance().getDeviceModel();
        if (!TextUtils.isEmpty(deviceModel)) {
            return deviceModel;
        }
        Context context = EventReporter.getInstance().getContext();
        if (context == null) {
            string = EventReportConfig.STRING_INIT;
        } else {
            string = context.getSharedPreferences("txy_comoon_share_data", 0).getString("txy_device_model", EventReportConfig.STRING_INIT);
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String model = DeviceInfoMonitor.getModel();
        EventReporter.getInstance().setDeviceModel(model);
        Context context2 = EventReporter.getInstance().getContext();
        if (context2 != null) {
            context2.getSharedPreferences("txy_comoon_share_data", 0).edit().putString("txy_device_model", model).apply();
        }
        return model;
    }

    public static String getDeviceUuid(Context context) {
        String str;
        String deviceId = EventReporter.getInstance().getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            if (context == null) {
                str = EventReportConfig.STRING_INIT;
            } else {
                String string = context.getSharedPreferences("txy_comoon_share_data", 0).getString(Constants.SP_DEVICE_ID, EventReportConfig.STRING_INIT);
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString().replace("-", "");
                    context.getSharedPreferences("txy_comoon_share_data", 0).edit().putString(Constants.SP_DEVICE_ID, string).apply();
                }
                if (!TextUtils.isEmpty(string)) {
                    deviceId = string;
                    EventReporter.getInstance().setDeviceId(deviceId);
                } else {
                    str = EventReportConfig.STRING_INIT;
                }
            }
            deviceId = str;
            EventReporter.getInstance().setDeviceId(deviceId);
        }
        return deviceId;
    }
}
