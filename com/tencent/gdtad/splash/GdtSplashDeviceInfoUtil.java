package com.tencent.gdtad.splash;

import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.DeviceInfoSetting;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtSplashDeviceInfoUtil {
    public static void b() {
        DeviceInfoSetting deviceInfoSetting = new DeviceInfoSetting();
        c(deviceInfoSetting);
        GlobalSetting.setDeviceInfoSetting(deviceInfoSetting);
        j("[initBaseDeviceInfo]", deviceInfoSetting.getDeviceInfoValue());
    }

    private static void c(DeviceInfoSetting deviceInfoSetting) {
        if (deviceInfoSetting == null) {
            QLog.e("GdtSplashDeviceInfoUtil", 1, "[initBaseDeviceInfoSetting] error, deviceInfoSetting is null");
            return;
        }
        String str = AppSetting.f99551k;
        if (!TextUtils.isEmpty(str)) {
            deviceInfoSetting.setDeviceInfoValue(502, str);
        }
    }

    public static void d() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashDeviceInfoUtil.1
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashDeviceInfoUtil.e();
            }
        }, 128, null, true);
    }

    public static void e() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            QLog.e("GdtSplashDeviceInfoUtil", 1, "[initDeviceInfoNotOnMainThread] error, on the main thread");
        }
        DeviceInfoSetting deviceInfoSetting = new DeviceInfoSetting();
        f(deviceInfoSetting);
        GlobalSetting.setDeviceInfoSetting(deviceInfoSetting);
        j("[initDeviceInfoNotOnMainThread]", deviceInfoSetting.getDeviceInfoValue());
    }

    private static void f(DeviceInfoSetting deviceInfoSetting) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            QLog.e("GdtSplashDeviceInfoUtil", 1, "[initDeviceInfoSetting] error, on the main thread");
        }
        c(deviceInfoSetting);
        i(deviceInfoSetting);
        g(deviceInfoSetting);
        h(deviceInfoSetting);
    }

    private static void g(DeviceInfoSetting deviceInfoSetting) {
        if (deviceInfoSetting == null) {
            QLog.e("GdtSplashDeviceInfoUtil", 1, "[initQIMEI36] error, deviceInfoSetting is null");
        } else if (!TextUtils.isEmpty(com.tencent.mobileqq.statistics.o.c())) {
            deviceInfoSetting.setDeviceInfoValue(701, com.tencent.mobileqq.statistics.o.c());
        }
    }

    private static void h(DeviceInfoSetting deviceInfoSetting) {
        if (deviceInfoSetting == null) {
            QLog.e("GdtSplashDeviceInfoUtil", 1, "[initScreenWidthBucket] error, deviceInfoSetting is null");
        } else {
            deviceInfoSetting.setDeviceInfoValue(128, Integer.valueOf(com.tencent.gdtad.util.o.a(BaseApplication.getContext())));
        }
    }

    private static void i(DeviceInfoSetting deviceInfoSetting) {
        String str;
        if (deviceInfoSetting == null) {
            QLog.e("GdtSplashDeviceInfoUtil", 1, "[initTAIDAndOAID] error, deviceInfoSetting is null");
            return;
        }
        ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(false);
        String str2 = null;
        if (c16 != null) {
            str = c16.getAIDTicket();
        } else {
            str = null;
        }
        if (c16 != null) {
            str2 = c16.getTAIDTicket();
        }
        if (!TextUtils.isEmpty(str)) {
            deviceInfoSetting.setDeviceInfoValue(1, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            deviceInfoSetting.setDeviceInfoValue(2, str2);
        }
    }

    private static void j(final String str, final Map<Integer, Object> map) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.splash.GdtSplashDeviceInfoUtil.2
            @Override // java.lang.Runnable
            public void run() {
                GdtSplashDeviceInfoUtil.k(str, map);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(String str, Map<Integer, Object> map) {
        if (map != null && !map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                    jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                }
                String jSONObject2 = jSONObject.toString();
                if (QLog.isColorLevel()) {
                    QLog.i("GdtSplashDeviceInfoUtil", 2, str + jSONObject2);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("GdtSplashDeviceInfoUtil", 1, "[logImpl]", th5);
                return;
            }
        }
        QLog.e("GdtSplashDeviceInfoUtil", 1, str + " error, map is empty");
    }
}
