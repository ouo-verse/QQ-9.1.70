package com.tencent.ttpic.device;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.tencent.ttpic.baseutils.device.DeviceAttrs;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import org.light.device.LightDeviceUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DeviceUtils {
    public static final long HIGH_END_CPU_COUNT = 8;
    public static final long HIGH_END_MEMORY_SIZE = 256;
    public static final long HIGH_END_SCREEN_SIZE = 1900800;
    public static final int MIN_STORAGE_SIZE = 52428800;
    private static final String TAG = "DeviceUtils";
    public static final long VERY_LOW_END_CPU_COUNT = 2;
    public static final long VERY_LOW_END_MEMORY_SIZE = 64;
    public static final long VERY_LOW_END_SCREEN_SIZE = 388800;
    public static Handler handler;
    private static DeviceInstance.SOC_CLASS socClassCache;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class MEMORY_CLASS {
        public static final int IN_B = 0;
        public static final int IN_KB = 1;
        public static final int IN_MB = 2;
    }

    public static String getDeviceLevelClass(Context context) {
        return getDeviceSocClass(context).desc;
    }

    public static DeviceInstance.SOC_CLASS getDeviceSocClass(Context context) {
        DeviceInstance.SOC_CLASS soc_class;
        DeviceInstance.SOC_CLASS soc_class2 = socClassCache;
        if (soc_class2 != null) {
            return soc_class2;
        }
        if (isVeryHighEndDevice(context)) {
            soc_class = DeviceInstance.SOC_CLASS.V_HIGH;
        } else if (isHighEndDevice(context)) {
            soc_class = DeviceInstance.SOC_CLASS.HIGH;
        } else if (isMiddleEndDevice(context)) {
            soc_class = DeviceInstance.SOC_CLASS.NORMAL;
        } else if (isLowEndDevice(context)) {
            soc_class = DeviceInstance.SOC_CLASS.LOW;
        } else if (isVeryLowEndDevice(context)) {
            soc_class = DeviceInstance.SOC_CLASS.V_LOW;
        } else {
            soc_class = DeviceInstance.SOC_CLASS.NULL;
        }
        socClassCache = soc_class;
        return soc_class;
    }

    public static int getScreenHeight(Context context) {
        return LightDeviceUtils.getScreenHeight(context);
    }

    public static int getScreenWidth(Context context) {
        return LightDeviceUtils.getScreenWidth(context);
    }

    public static long getTotalRamMemory(Context context) {
        return LightDeviceUtils.getTotalRamMemory(context);
    }

    public static boolean hasDeviceHigh(Context context) {
        if (getDeviceSocClass(context).score >= DeviceInstance.SOC_CLASS.HIGH.score) {
            return true;
        }
        return false;
    }

    public static boolean hasDeviceLow(Context context) {
        if (getDeviceSocClass(context).score >= DeviceInstance.SOC_CLASS.LOW.score) {
            return true;
        }
        return false;
    }

    public static boolean hasDeviceNormal(Context context) {
        if (getDeviceSocClass(context).score >= DeviceInstance.SOC_CLASS.NORMAL.score) {
            return true;
        }
        return false;
    }

    public static boolean hasDeviceVHigh(Context context) {
        if (getDeviceSocClass(context).score >= DeviceInstance.SOC_CLASS.V_HIGH.score) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d1, code lost:
    
        if (r2 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r1 == com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS.HIGH) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isHighEndDevice(Context context) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str = TAG;
        LogUtils.i(str, "[isHighEndDevice] + BEGIN");
        DeviceInstance.SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.i(str, "[isHighEndDevice] socClass = " + deviceSocClass);
        boolean z19 = true;
        if (deviceSocClass == DeviceInstance.SOC_CLASS.NULL) {
            int screenWidth = LightDeviceUtils.getScreenWidth(context);
            int screenHeight = LightDeviceUtils.getScreenHeight(context);
            if (screenWidth * screenHeight >= HIGH_END_SCREEN_SIZE) {
                z16 = true;
            } else {
                z16 = false;
            }
            LogUtils.d(str, "[isHighEndDevice] isHighDisplay = " + z16 + ", widthPixels = " + screenWidth + ", heightPixels = " + screenHeight);
            long heapMaxSizeInMb = LightDeviceUtils.getHeapMaxSizeInMb(context);
            if (heapMaxSizeInMb >= 256) {
                z17 = true;
            } else {
                z17 = false;
            }
            LogUtils.d(str, "[isHighEndDevice] isHighMemory = " + z17 + ", deviceHeapSize(Mb) = " + heapMaxSizeInMb);
            int numCores = LightDeviceUtils.getNumCores();
            if (numCores >= 8) {
                z18 = true;
            } else {
                z18 = false;
            }
            LogUtils.d(str, "[isHighEndDevice] isHighCpuCount = " + z18 + ", cpuCount = " + numCores);
            if (z16) {
                if (z17) {
                }
            }
            z19 = false;
        }
        LogUtils.i(str, "[isHighEndDevice] + END, isHighEndDevice = " + z19);
        return z19;
    }

    private static boolean isLowEndDevice(Context context) {
        boolean z16;
        String str = TAG;
        LogUtils.i(str, "[isLowEndDevice] + BEGIN");
        DeviceInstance.SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.i(str, "[isLowEndDevice] socClass = " + deviceSocClass);
        if (deviceSocClass != DeviceInstance.SOC_CLASS.NULL && deviceSocClass == DeviceInstance.SOC_CLASS.LOW) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtils.i(str, "[isLowEndDevice] + END, isLowEndDevice = " + z16);
        return z16;
    }

    private static boolean isMiddleEndDevice(Context context) {
        String str = TAG;
        LogUtils.i(str, "[isMiddleEndDevice] + BEGIN");
        DeviceInstance.SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.i(str, "[isMiddleEndDevice] socClass = " + deviceSocClass);
        boolean z16 = true;
        if (deviceSocClass == DeviceInstance.SOC_CLASS.NULL ? isVeryHighEndDevice(context) || isHighEndDevice(context) || isLowEndDevice(context) || isVeryLowEndDevice(context) : deviceSocClass != DeviceInstance.SOC_CLASS.NORMAL) {
            z16 = false;
        }
        LogUtils.i(str, "[isMiddleEndDevice] + END, isMiddleEndDevice = " + z16);
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        if (r0.contains("SDM855") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r0 == com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS.V_HIGH) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isVeryHighEndDevice(Context context) {
        String str = TAG;
        LogUtils.i(str, "[isVeryHighDevice] + BEGIN");
        DeviceInstance.SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.i(str, "[isVeryHighDevice] socClass = " + deviceSocClass);
        boolean z16 = false;
        if (deviceSocClass == DeviceInstance.SOC_CLASS.NULL) {
            String cpuNameOnce = LightDeviceUtils.getCpuNameOnce();
            String str2 = Build.HARDWARE;
            if (!str2.contains("kirin970")) {
                if (!str2.contains("kirin980")) {
                    if (!cpuNameOnce.contains("MSM8998")) {
                        if (!cpuNameOnce.contains("SDM845")) {
                            if (!cpuNameOnce.contains("SDM850")) {
                            }
                        }
                    }
                }
            }
            z16 = true;
        }
        LogUtils.i(str, "[isVeryHighDevice] + END, iVeryHighDevice = " + z16);
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d1, code lost:
    
        if (r2 == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r1 == com.tencent.ttpic.baseutils.device.DeviceInstance.SOC_CLASS.V_LOW) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0037, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isVeryLowEndDevice(Context context) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str = TAG;
        LogUtils.i(str, "[isVeryLowEndDevice] + BEGIN");
        DeviceInstance.SOC_CLASS deviceSocClass = DeviceInstance.getInstance().getDeviceSocClass(DeviceAttrs.getInstance().str_deviceSocInfo);
        LogUtils.i(str, "[isVeryLowEndDevice] socClass = " + deviceSocClass);
        boolean z19 = true;
        if (deviceSocClass == DeviceInstance.SOC_CLASS.NULL) {
            int screenWidth = LightDeviceUtils.getScreenWidth(context);
            int screenHeight = LightDeviceUtils.getScreenHeight(context);
            if (screenWidth * screenHeight <= VERY_LOW_END_SCREEN_SIZE) {
                z16 = true;
            } else {
                z16 = false;
            }
            LogUtils.d(str, "[isLowEndDevice] isLowEndDisplay = " + z16 + ", widthPixels = " + screenWidth + ", heightPixels = " + screenHeight);
            long heapMaxSizeInMb = LightDeviceUtils.getHeapMaxSizeInMb(context);
            if (heapMaxSizeInMb <= 64) {
                z17 = true;
            } else {
                z17 = false;
            }
            LogUtils.d(str, "[isLowEndDevice] isLowMemory = " + z17 + ", deviceHeapSize(Mb) = " + heapMaxSizeInMb);
            int numCores = LightDeviceUtils.getNumCores();
            if (numCores <= 2) {
                z18 = true;
            } else {
                z18 = false;
            }
            LogUtils.d(str, "[isLowEndDevice] isLowCpuCount = " + z18 + ", cpuCount = " + numCores);
            if (!z16) {
                if (!z17) {
                }
            }
        }
        LogUtils.i(str, "[isVeryLowEndDevice] + END, isVeryLowDevice = " + z19);
        return z19;
    }
}
