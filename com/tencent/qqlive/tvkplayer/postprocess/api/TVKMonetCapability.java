package com.tencent.qqlive.tvkplayer.postprocess.api;

import android.app.ActivityManager;
import android.os.Build;
import android.provider.Settings;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKVcSystemInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKMonetCapability {
    private static final int GL_VERSION_3_1 = 196609;
    private static final String TAG = "TVKMonetCapability";
    private static Boolean sIsColorManagementSupportedByDevice;
    private static Boolean sIsSuperResolutionSupportedBySystemVersion;

    public static int getTVMSRCapabilityCodeLegacy() {
        try {
            Class<?> cls = Class.forName("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKVideoProcessorCapability");
            return ((Integer) cls.getMethod("getTVMSRCapabilityCodeLegacy", new Class[0]).invoke(cls, new Object[0])).intValue();
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "reflect getTVMSRCapabilityCode failed:" + th5.toString());
            return 2001;
        }
    }

    public static int getTVMSuperResolutionSupportType() {
        try {
            Class<?> cls = Class.forName("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKVideoProcessorCapability");
            return ((Integer) cls.getMethod("queryTVMSuperResolutionSupportTypeMask", new Class[0]).invoke(cls, new Object[0])).intValue();
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "reflect queryTVMSuperResolutionSupportTypeMask failed:" + th5.toString());
            return 0;
        }
    }

    public static boolean isColorManagementSupported() {
        boolean z16 = false;
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_color_management) {
            TVKLogUtil.i(TAG, "[isColorManagementSupported] color manager disabled by config.");
            return false;
        }
        if (!TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.color_management_whitelist)) {
            TVKLogUtil.i(TAG, "[isColorManagementSupported] device is not in whitelist.");
            return false;
        }
        Boolean bool = sIsColorManagementSupportedByDevice;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (TVKVcSystemInfo.getManufacturer().contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            try {
                int i3 = Settings.Global.getInt(TVKCommParams.getApplicationContext().getContentResolver(), "colour_gamut_mode_value", -1);
                TVKLogUtil.i(TAG, "[isColorManagementSupported] vivo device color mode: " + i3);
                if (i3 == 0) {
                    z16 = true;
                }
                sIsColorManagementSupportedByDevice = Boolean.valueOf(z16);
            } catch (Exception e16) {
                TVKLogUtil.e(TAG, "[isColorManagementSupported] system call exception encountered: " + e16);
                return false;
            }
        } else {
            sIsColorManagementSupportedByDevice = Boolean.FALSE;
        }
        TVKLogUtil.i(TAG, "[isColorManagementSupported] is supported? " + sIsColorManagementSupportedByDevice);
        return sIsColorManagementSupportedByDevice.booleanValue();
    }

    public static boolean isGaussianBlurVideoOverlayEffectSupported() {
        if (!TVKMediaPlayerConfig.PlayerConfig.enable_gaussianblur_effect) {
            TVKLogUtil.i(TAG, "[isGaussianBlurVideoOverlayEffectSupported] gaussian blur effect disabled by config.");
            return false;
        }
        if (Build.VERSION.SDK_INT < 27) {
            TVKLogUtil.i(TAG, "[isGaussianBlurVideoOverlayEffectSupported] api level unsatisfied.");
            return false;
        }
        boolean isModelInList = TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.gaussianblur_effect_blacklist);
        TVKLogUtil.i(TAG, "[isGaussianBlurVideoOverlayEffectSupported] is device in blacklist? " + isModelInList);
        return !isModelInList;
    }

    public static boolean isSuperResolutionSupported() {
        if (!isSuperResolutionSupportedBySystemVersion()) {
            TVKLogUtil.i(TAG, "[isSuperResolutionSupported] system version does not support super resolution.");
            return false;
        }
        if (TVKUtils.isModelInList(TVKMediaPlayerConfig.PlayerConfig.super_resolution_black_list)) {
            TVKLogUtil.i(TAG, "[isSuperResolutionSupported] device model is empty or in blacklist.");
            return false;
        }
        String str = TVKMediaPlayerConfig.PlayerConfig.super_resolution_chip_white_list;
        String cpuChipName = TVKVcSystemInfo.getCpuChipName();
        boolean isStringInArrayCaseInsensitive = TVKUtils.isStringInArrayCaseInsensitive(cpuChipName, TVKUtils.splitStringToArray(str, ","));
        TVKLogUtil.i(TAG, "[isSuperResolutionSupported] is chip " + cpuChipName + " in white list " + str + " ? " + isStringInArrayCaseInsensitive);
        return isStringInArrayCaseInsensitive;
    }

    private static boolean isSuperResolutionSupportedBySystemVersion() {
        Boolean bool = sIsSuperResolutionSupportedBySystemVersion;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z16 = false;
        try {
            int i3 = ((ActivityManager) TVKCommParams.getApplicationContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo().reqGlEsVersion;
            int i16 = Build.VERSION.SDK_INT;
            if (i3 >= GL_VERSION_3_1 && i16 >= 24) {
                z16 = true;
            }
            sIsSuperResolutionSupportedBySystemVersion = Boolean.valueOf(z16);
            TVKLogUtil.i(TAG, "[isSuperResolutionSupportedBySystemVersion] GL version: " + Integer.toHexString(i3) + ", API level: " + i16 + ", is supported? " + sIsSuperResolutionSupportedBySystemVersion);
            return sIsSuperResolutionSupportedBySystemVersion.booleanValue();
        } catch (Exception e16) {
            TVKLogUtil.e(TAG, "[isSuperResolutionSupportedBySystemVersion] system call exception encountered: " + e16);
            return false;
        }
    }

    public static boolean isTVMSuperResolutionSupportedForVideoSize(int i3, int i16) {
        if (queryTVMSRCapabilityCodeByVideoSize(i3, i16) == 0) {
            return true;
        }
        return false;
    }

    public static int queryTVMSRCapabilityCodeByVideoSize(int i3, int i16) {
        int i17;
        try {
            Class<?> cls = Class.forName("com.tencent.qqlive.tvkplayer.postprocess.monet.TVKVideoProcessorCapability");
            Class<?> cls2 = Integer.TYPE;
            i17 = ((Integer) cls.getMethod("queryTVMSRCapabilityCodeByVideoSize", cls2, cls2).invoke(cls, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        } catch (Throwable th5) {
            TVKLogUtil.e(TAG, "reflect queryTVMSRCapabilityCodeByVideoSize failed:" + th5.toString());
            i17 = 2001;
        }
        TVKLogUtil.i(TAG, "queryTVMSRCapabilityCodeByVideoSize ret:" + i17 + ", size:" + i3 + HippyTKDListViewAdapter.X + i16);
        return i17;
    }
}
