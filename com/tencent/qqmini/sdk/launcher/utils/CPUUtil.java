package com.tencent.qqmini.sdk.launcher.utils;

import android.os.Build;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* loaded from: classes23.dex */
public class CPUUtil {
    public static volatile boolean sARMv7Compatible = false;
    public static volatile boolean sIsX86Emulator = false;

    static {
        String systemProperty;
        if (DeviceInfoMonitor.getModel().contains("Android SDK built for x86")) {
            sIsX86Emulator = true;
        }
        String property = System.getProperty("os.arch");
        String systemProperty2 = OSUtils.getSystemProperty(TPFromApkLibraryLoader.RO_PRODUCT_CPU_ABI, "");
        String str = Build.CPU_ABI;
        if ((str.contains(ResourceAttributes.HostArchValues.X86) || Build.CPU_ABI2.contains(ResourceAttributes.HostArchValues.X86) || ((property != null && property.contains(ResourceAttributes.HostArchValues.X86)) || (systemProperty2 != null && systemProperty2.contains(ResourceAttributes.HostArchValues.X86)))) && (systemProperty = OSUtils.getSystemProperty("ro.dalvik.vm.native.bridge", "")) != null && !systemProperty.equals("0") && OSUtils.getSystemProperty("ro.enable.native.bridge.exec", "0").equals("0")) {
            sIsX86Emulator = true;
        }
        String str2 = Build.CPU_ABI2;
        if (!sIsX86Emulator) {
            if (checkCPUABIStringV7(str).booleanValue() || checkCPUABIStringV7(str2).booleanValue()) {
                sARMv7Compatible = true;
            }
        }
    }

    private static Boolean checkCPUABIStringV7(String str) {
        boolean z16;
        if (!str.equalsIgnoreCase("armeabi-v7a") && !str.equalsIgnoreCase("arm64-v8a")) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }
}
