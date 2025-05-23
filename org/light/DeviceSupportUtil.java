package org.light;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import org.light.device.ApiHelper;
import org.light.device.DeviceInstance;
import org.light.device.GpuScopeAttrs;
import org.light.device.LightDeviceProperty;
import org.light.gles.GLCapabilities;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DeviceSupportUtil {
    private static final String[] DEVICE_ABILITY_ARRAY = {"3d.kapu", "ai.emotion", "ai.hand", "ai.3dmm", "ai", "ai.face3d", DeviceConstants.DEVICE_ABILITY_OPENCL, "ai.gan", DeviceConstants.DEVICE_ABILITY_AI_SEGMENTATION_BG_GPU, DeviceConstants.DEVICE_ABILITY_JAVASCRIPT, "ai.segment", "ai.segmentHair", "ai.body", "ai.catFace", "ai.faceStaticFeature", "ai.expression", DeviceConstants.DEVICE_SHARE_GLCONTEXT_ERROR, DeviceConstants.DEVICE_ABILITY_FILAMENT_SHADOW, DeviceConstants.DEVICE_ABILITY_FILAMENT_FXAA, DeviceConstants.DEVICE_ABILITY_FILAMENT_MSAA, DeviceConstants.DEVICE_ABILITY_FILAMENT_SSAO, DeviceConstants.DEVICE_ABILITY_FILAMENT_DITHER, DeviceConstants.DEVICE_ABILITY_FILAMENT_BLOOM, DeviceConstants.DEVICE_ABILITY_FILAMENT_VIGNETTE, DeviceConstants.DEVICE_ABILITY_FILAMENT_COLOR_GRADING, DeviceConstants.DEVICE_ABILITY_PRELOAD_HAIR_SEG, DeviceConstants.DEVICE_ABILITY_IMU_SMOOTH_ENABLE, DeviceConstants.DEVICE_ABILITY_FENCE};
    private static final String TAG = "DeviceSupportUtil";
    private static boolean inited = false;
    private static boolean soLoadSuccess = false;

    private static String[] getDeviceAbilityKeys(LightAsset lightAsset) {
        ArrayList arrayList = new ArrayList();
        if (lightAsset != null) {
            for (String str : DEVICE_ABILITY_ARRAY) {
                if (lightAsset.needRenderAbility(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() > 0) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    private static synchronized void init() {
        synchronized (DeviceSupportUtil.class) {
            if (inited) {
                return;
            }
            try {
                Context applicationContext = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
                DeviceInstance.getInstance().initSettings(applicationContext, "");
                GLCapabilities.init(true);
                if (GpuScopeAttrs.getInstance().getDeviceModel() == null && GpuScopeAttrs.getInstance().getGPuModel() == null) {
                    GpuScopeAttrs.getInstance().init(applicationContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), DeviceInstance.getInstance().getDeviceVersion(), "");
                    LightLogUtil.e(TAG, "DeviceName = " + DeviceInstance.getInstance().getDeviceName());
                    LightLogUtil.e(TAG, "SystemVersion = " + DeviceInstance.getInstance().getDeviceVersion());
                    LightLogUtil.e(TAG, "GPUInfo = " + GLCapabilities.getGPUInfo());
                }
                inited = true;
            } catch (Exception e16) {
                LightLogUtil.w(TAG, "init failed: " + e16.getMessage());
            }
        }
    }

    public static boolean isAbilitiesSupported(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            if (!inited) {
                init();
            }
            for (String str : strArr) {
                if (!isAbilityDeviceSupport(str)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static boolean isAbilityDeviceSupport(String str) {
        String str2;
        if (!inited) {
            init();
        }
        str.hashCode();
        boolean z16 = true;
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -2147478675:
                if (str.equals("ai.segment")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1926713261:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_OPENCL)) {
                    c16 = 1;
                    break;
                }
                break;
            case -1848308053:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_AI_SEGMENTATION_BG_GPU)) {
                    c16 = 2;
                    break;
                }
                break;
            case -1847539473:
                if (str.equals("ai.segmentHair")) {
                    c16 = 3;
                    break;
                }
                break;
            case -1716838530:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_DITHER)) {
                    c16 = 4;
                    break;
                }
                break;
            case -1673219638:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_FXAA)) {
                    c16 = 5;
                    break;
                }
                break;
            case -1673015906:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_MSAA)) {
                    c16 = 6;
                    break;
                }
                break;
            case -1672837146:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_SSAO)) {
                    c16 = 7;
                    break;
                }
                break;
            case -1450994539:
                if (str.equals("ai.emotion")) {
                    c16 = '\b';
                    break;
                }
                break;
            case -1419497458:
                if (str.equals("ai.gan")) {
                    c16 = '\t';
                    break;
                }
                break;
            case -1288894344:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_SHADOW)) {
                    c16 = '\n';
                    break;
                }
                break;
            case -1056294409:
                if (str.equals("ai.3dmm")) {
                    c16 = 11;
                    break;
                }
                break;
            case -1054883928:
                if (str.equals("ai.body")) {
                    c16 = '\f';
                    break;
                }
                break;
            case -1054718347:
                if (str.equals("ai.hand")) {
                    c16 = '\r';
                    break;
                }
                break;
            case -835779680:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_COLOR_GRADING)) {
                    c16 = 14;
                    break;
                }
                break;
            case -577373154:
                if (str.equals("ai.expression")) {
                    c16 = 15;
                    break;
                }
                break;
            case -334238805:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_BLOOM)) {
                    c16 = 16;
                    break;
                }
                break;
            case -280244012:
                if (str.equals(DeviceConstants.DEVICE_GLEXT_FRAMEBUFFER_FETCH)) {
                    c16 = 17;
                    break;
                }
                break;
            case -73197307:
                if (str.equals("ai.faceStaticFeature")) {
                    c16 = 18;
                    break;
                }
                break;
            case -29632972:
                if (str.equals("ai.face3d")) {
                    c16 = 19;
                    break;
                }
                break;
            case 3112:
                if (str.equals("ai")) {
                    c16 = 20;
                    break;
                }
                break;
            case 97316913:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FENCE)) {
                    c16 = 21;
                    break;
                }
                break;
            case 268339166:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_BGFX_PARTICLE)) {
                    c16 = 22;
                    break;
                }
                break;
            case 304644842:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_ACE3D_FLUSH)) {
                    c16 = 23;
                    break;
                }
                break;
            case 324797074:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_FILAMENT_VIGNETTE)) {
                    c16 = 24;
                    break;
                }
                break;
            case 425352734:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_ACE3D_BONE)) {
                    c16 = 25;
                    break;
                }
                break;
            case 728654733:
                if (str.equals("ai.catFace")) {
                    c16 = 26;
                    break;
                }
                break;
            case 926728984:
                if (str.equals("3d.kapu")) {
                    c16 = 27;
                    break;
                }
                break;
            case 1088081055:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_PRELOAD_HAIR_SEG)) {
                    c16 = 28;
                    break;
                }
                break;
            case 1155171942:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_IMU_SMOOTH_ENABLE)) {
                    c16 = 29;
                    break;
                }
                break;
            case 1266327981:
                if (str.equals(DeviceConstants.DEVICE_ABILITY_JAVASCRIPT)) {
                    c16 = 30;
                    break;
                }
                break;
            case 1946725565:
                if (str.equals(DeviceConstants.DEVICE_SHARE_GLCONTEXT_ERROR)) {
                    c16 = 31;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 3:
                z16 = true ^ isShareGLContextError();
                break;
            case 1:
            case 2:
            case '\t':
                z16 = supportOpenCL();
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case '\n':
            case 14:
            case 16:
            case 22:
            case 24:
                z16 = supportFilamentFeature(str);
                break;
            case '\b':
            case 11:
            case '\r':
            case 20:
                z16 = supportAiAbility();
                break;
            case '\f':
            case 15:
            case 18:
            case 26:
                break;
            case 17:
                z16 = supportGLExtension(str);
                break;
            case 19:
                z16 = supportAceEngine();
                break;
            case 21:
                z16 = supportFence();
                break;
            case 23:
                z16 = supportAce3dFLush();
                break;
            case 25:
                z16 = supportBone();
                break;
            case 27:
                z16 = supportKapu();
                break;
            case 28:
                z16 = isHairSegPreLoadSupportedDevice();
                break;
            case 29:
                z16 = isImuSmoothEnable();
                break;
            case 30:
                z16 = supportJavaScript();
                break;
            case 31:
                z16 = isShareGLContextError();
                break;
            default:
                LightLogUtil.w(TAG, "isAbilityDeviceSupport - key \"" + str + "\" not found");
                break;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isAbilityDeviceSupport - ");
        sb5.append(str);
        sb5.append(" ");
        if (z16) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        sb5.append(str2);
        LightLogUtil.w(TAG, sb5.toString());
        return z16;
    }

    public static boolean isDeviceSupportAsset(LightAsset lightAsset) {
        return isAbilitiesSupported(getDeviceAbilityKeys(lightAsset));
    }

    public static boolean isHairSegPreLoadSupportedDevice() {
        return GLCapabilities.isDeviceSupportHairSegPreLoad();
    }

    public static boolean isHardwareBufferAvailable() {
        if (LightDeviceProperty.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    private static boolean isImuSmoothEnable() {
        return GLCapabilities.isImuSmoothEnable();
    }

    public static boolean isMaterialDeviceSupport(String str) {
        LightLogUtil.d(TAG, "isMaterialDeviceSupport");
        return true;
    }

    public static boolean isShareGLContextError() {
        return GLCapabilities.isShareGLContextError();
    }

    public static boolean isSoLoadSuccess() {
        return soLoadSuccess;
    }

    public static void setSoLoadSuccess(boolean z16) {
        soLoadSuccess = z16;
    }

    private static boolean supportAce3dFLush() {
        if (supportAceEngine() && GLCapabilities.isDeviceSupportAce3dFlush()) {
            return true;
        }
        return false;
    }

    private static boolean supportAceEngine() {
        if (GLCapabilities.getGlesVersion().contains("3.") && GLCapabilities.isFilamentShaderCompileSucceed() && GLCapabilities.isDeviceSupportAceEngine()) {
            return true;
        }
        return false;
    }

    private static boolean supportAiAbility() {
        return GLCapabilities.isDeviceSupportAiAbility();
    }

    private static boolean supportBone() {
        if (GLCapabilities.getGlesVersion().contains("3.") && GLCapabilities.isFilamentShaderCompileSucceed() && GLCapabilities.isDeviceSupportBone()) {
            return true;
        }
        return false;
    }

    public static boolean supportFence() {
        return GLCapabilities.isDeviceSupportFence();
    }

    private static boolean supportFilamentFeature(String str) {
        if (supportAceEngine() && GLCapabilities.isDeviceSupportFilamentFeature(str)) {
            return true;
        }
        return false;
    }

    private static boolean supportGLExtension(String str) {
        if (supportAceEngine() && GLCapabilities.isDeviceSupportGLExtension(str)) {
            return true;
        }
        return false;
    }

    private static boolean supportJavaScript() {
        return ApiHelper.hasLollipop();
    }

    private static boolean supportKapu() {
        if (supportAceEngine() && GLCapabilities.isDeviceSupportKapu()) {
            return true;
        }
        return false;
    }

    private static boolean supportOpenCL() {
        if (ApiHelper.hasMarshmallow() && GLCapabilities.isDeviceSupportOpenCL()) {
            return true;
        }
        return false;
    }

    public static synchronized void init(String str) {
        synchronized (DeviceSupportUtil.class) {
            try {
                Context applicationContext = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
                DeviceInstance.getInstance().initSettings(applicationContext, str);
                GLCapabilities.init(true);
                GpuScopeAttrs.getInstance().init(applicationContext, DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), DeviceInstance.getInstance().getDeviceVersion(), str);
                LightLogUtil.e(TAG, "DeviceName = " + DeviceInstance.getInstance().getDeviceName());
                LightLogUtil.e(TAG, "SystemVersion = " + DeviceInstance.getInstance().getDeviceVersion());
                LightLogUtil.e(TAG, "GPUInfo = " + GLCapabilities.getGPUInfo());
                inited = true;
            } catch (Exception e16) {
                LightLogUtil.w(TAG, "init failed: " + e16.getMessage());
            }
        }
    }
}
