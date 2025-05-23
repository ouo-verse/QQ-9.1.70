package com.tencent.mobileqq.zplan.utils;

import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.VideoUtils;
import com.tencent.util.AbiUtil;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import org.light.utils.GsonUtils;

/* compiled from: P */
/* loaded from: classes34.dex */
public class i {
    public static vu4.e a() {
        vu4.e eVar = new vu4.e();
        try {
            t74.d dVar = t74.d.f435534a;
            String b16 = dVar.b();
            String a16 = dVar.a();
            String model = DeviceInfoMonitor.getModel();
            long b17 = t74.c.b();
            eVar.f443570a = b16;
            eVar.f443571b = String.valueOf(b17);
            eVar.f443572c = a16;
            eVar.f443573d = Build.BRAND;
            eVar.f443574e = Build.DEVICE;
            eVar.f443575f = model;
            eVar.f443576g = Build.CPU_ABI;
            eVar.f443577h = Build.MANUFACTURER;
            eVar.f443578i = String.valueOf(Build.VERSION.SDK_INT);
            eVar.f443579j = String.valueOf(Build.BOARD);
            eVar.f443580k = String.valueOf(Build.HARDWARE);
            eVar.f443581l = "";
            eVar.f443582m = t74.c.a(BaseApplicationImpl.getApplication());
            eVar.f443583n = AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication());
        } catch (Exception e16) {
            QLog.e("HareWareInfoUtil", 1, "getHardwareDetail throw e:" + e16.getMessage());
        }
        QLog.i("HareWareInfoUtil", 1, "getHardwareDetail hardWareDetail" + eVar);
        return eVar;
    }

    public static String b() {
        Object obj;
        HashMap hashMap = new HashMap();
        try {
            t74.d dVar = t74.d.f435534a;
            String b16 = dVar.b();
            String a16 = dVar.a();
            String model = DeviceInfoMonitor.getModel();
            long b17 = t74.c.b();
            hashMap.put("gpu_name", b16);
            hashMap.put("ram", String.valueOf(b17));
            hashMap.put("gles", a16);
            hashMap.put("brand", Build.BRAND);
            hashMap.put("device", Build.DEVICE);
            hashMap.put("model", model);
            hashMap.put("instruction_set", Build.CPU_ABI);
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put("os_version", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("core_name ", String.valueOf(Build.BOARD));
            hashMap.put("cpu_name ", String.valueOf(Build.HARDWARE));
            hashMap.put("udid", QQDeviceInfo.getQIMEI());
            hashMap.put("os", t74.c.a(BaseApplicationImpl.getApplication()));
            hashMap.put("is_arm64", String.valueOf(AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication())));
            hashMap.put("network", String.valueOf(com.tencent.mobileqq.zootopia.utils.m.f329564a.b()));
            hashMap.put("isSupportH265", String.valueOf(AbiUtil.isArm64Runtime(BaseApplicationImpl.getApplication())));
            hashMap.put("cpu", String.valueOf(com.tencent.mobileqq.utils.ah.n()));
            hashMap.put("freq", String.valueOf(com.tencent.mobileqq.utils.ah.l()));
            hashMap.put("freshRate", String.valueOf(c()));
            String str = "1";
            if (VideoUtils.f373236a.l()) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("supHdr", obj);
            if (!AppSetting.o(BaseApplication.getContext())) {
                str = "0";
            }
            hashMap.put("is_allow_landscape", str);
        } catch (Exception e16) {
            QLog.e("HareWareInfoUtil", 1, "getInfo throw e:" + e16.getMessage());
        }
        String obj2Json = GsonUtils.obj2Json(hashMap);
        if (obj2Json == null) {
            QLog.i("HareWareInfoUtil", 1, "obj2Json failed hardwareInfo return empty str");
            return "";
        }
        QLog.i("HareWareInfoUtil", 1, "getInfo hardwareInfo" + obj2Json);
        return obj2Json;
    }

    private static int c() {
        try {
            return ScreenUtil.getMaxRefreshRate();
        } catch (Exception e16) {
            QLog.e("HareWareInfoUtil", 1, "getMaxRefreshRateException:", e16);
            return 0;
        }
    }
}
