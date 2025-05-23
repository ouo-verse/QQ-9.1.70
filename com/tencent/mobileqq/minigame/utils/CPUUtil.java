package com.tencent.mobileqq.minigame.utils;

import android.os.Build;
import android.os.SystemProperties;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* loaded from: classes33.dex */
public class CPUUtil {
    public static volatile boolean sARMv7Compatible = false;
    public static volatile boolean sIsX86Emulator = false;

    static {
        String str;
        if (DeviceInfoMonitor.getModel().contains("Android SDK built for x86")) {
            sIsX86Emulator = true;
        }
        String property = System.getProperty("os.arch");
        String str2 = SystemProperties.get(TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI);
        String str3 = Build.CPU_ABI;
        if ((str3.contains(ResourceAttributes.HostArchValues.X86) || Build.CPU_ABI2.contains(ResourceAttributes.HostArchValues.X86) || ((property != null && property.contains(ResourceAttributes.HostArchValues.X86)) || (str2 != null && str2.contains(ResourceAttributes.HostArchValues.X86)))) && (str = SystemProperties.get("ro.dalvik.vm.native.bridge")) != null && !str.equals("0") && SystemProperties.getInt("ro.enable.native.bridge.exec", 0) != 0) {
            sIsX86Emulator = true;
        }
        String str4 = Build.CPU_ABI2;
        if (sIsX86Emulator) {
            return;
        }
        if (checkCPUABIStringV7(str3).booleanValue() || checkCPUABIStringV7(str4).booleanValue()) {
            sARMv7Compatible = true;
        }
    }

    private static Boolean checkCPUABIStringV7(String str) {
        return Boolean.valueOf(str.equalsIgnoreCase("armeabi-v7a") || str.equalsIgnoreCase("arm64-v8a"));
    }
}
