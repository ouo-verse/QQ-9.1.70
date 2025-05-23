package org.light;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.gyailib.library.GYAIDeviceQuery;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.LightConstants;
import org.light.avatar.AvatarAIInfo;
import org.light.bean.LightAIDataWrapper;
import org.light.bean.LightAgentBundleInfo;
import org.light.bean.LightDelegateAgentRequest;
import org.light.bean.LightFaceData;
import org.light.bean.LightFaceFeature;
import org.light.callback.ExternalRenderCallback;
import org.light.device.LightDeviceUtils;
import org.light.listener.OnAIDataListener;
import org.light.listener.OnClickWatermarkListener;
import org.light.listener.OnClipAssetListener;
import org.light.listener.OnDelegateAgentRequestListener;
import org.light.listener.OnLoadAssetListener;
import org.light.listener.OnScriptOutputListener;
import org.light.listener.OnTipsStatusListener;
import org.light.listener.OnWatermarkDataListener;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Config {
    public static final int ERROR_CODE_SET_MODEL_LEVEL_IS_EMPTY = 2;
    public static final int ERROR_CODE_SET_MODEL_LEVEL_NOT_EXIST = 1;
    private static final String ML_AND_MIDDLE = "middle";
    private static final String ML_AND_SMALL = "low";
    private static final String ML_HIGH = "high";
    private static final String ML_LOW = "low";
    private static final String ML_UNKNOWN = "unknown";
    private static final String ML_VERY_HIGH = "veryhigh";
    private static final String ML_VERY_LOW = "verylow";
    private static final String TAG = "Config";
    private static Context appContext = null;
    private static boolean degradeAsset = false;
    protected long nativeHandle = 0;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum ConfigKeys {
        ResourceDir("resource_dir");

        public String val;

        ConfigKeys(String str) {
            this.val = str;
        }

        public String value() {
            return this.val;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum DeviceAbilityMode {
        DEVICE_ABILITY_DEFAULT,
        DEVICE_ABILITY_FORCE_OPEN,
        DEVICE_ABILITY_FORCE_CLOSE
    }

    public static void cleanFileCacheFromRoot(String str) {
        nativeCleanFileCacheFromRoot(str);
    }

    public static String deviceLevelEnumToLevelName(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put(5, ML_VERY_HIGH);
        hashMap.put(4, "high");
        hashMap.put(3, "middle");
        hashMap.put(2, HippyImageInfo.QUALITY_LOW);
        hashMap.put(1, ML_VERY_LOW);
        if (i3 > 5) {
            i3 = 5;
        }
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return (String) hashMap.get(Integer.valueOf(i3));
        }
        return "unknown";
    }

    public static LightAgentBundleInfo getAgentBundleInfoByAgentName(String str) {
        return nativeGetAgentBundleInfoByAgentName(str);
    }

    public static boolean getAssetDegradeFlag() {
        return degradeAsset;
    }

    public static int getPhonePrefLevel() {
        try {
            if (appContext == null) {
                appContext = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
            }
            Log.i("config phoneLevel", "LEVEL : " + LightDeviceUtils.getPhonePerfLevel(appContext));
            return LightDeviceUtils.getPhonePerfLevel(appContext);
        } catch (Exception e16) {
            LightLogUtil.e(e16);
            return 3;
        }
    }

    public static String getPhonePrefLevelName() {
        return deviceLevelEnumToLevelName(getPhonePrefLevel());
    }

    public static String getResourceBundleLevelNameByAgentName(String str) {
        return getPhonePrefLevelName();
    }

    public static String getResourceBundleLevelNameByAgentNameWithCV(String str) {
        String resourceBundleLevelNameByAgentName = getResourceBundleLevelNameByAgentName(str);
        try {
            if ("BODY3D_POINT_AGENT".equals(str) || LightConstants.AgentType.QNN_HTP_BUNDLE.equals(str)) {
                LightLogUtil.e(TAG, "getResourceBundleLevelNameByAgentNameWithCV agentName:" + str);
                Log.e(TAG, "getResourceBundleLevelNameByAgentNameWithCV agentName:" + str);
                int phonePrefLevel = getPhonePrefLevel();
                if (phonePrefLevel > 5) {
                    phonePrefLevel = 5;
                }
                if (phonePrefLevel < 1) {
                    phonePrefLevel = 3;
                }
                return new GYAIDeviceQuery().getBundleNameFromLevel(6 - phonePrefLevel);
            }
            return resourceBundleLevelNameByAgentName;
        } catch (Exception e16) {
            LightLogUtil.e(TAG, "Get LightCV Bundle Level Exception:\n" + e16);
            Log.e(TAG, "Get LightCV Bundle Level Exception:\n" + e16);
            return resourceBundleLevelNameByAgentName;
        }
    }

    private native void nativeAddExternalRenderCallback(String str, ExternalRenderCallback externalRenderCallback);

    private native void nativeCleanFileCacheForKey(String str);

    public static native void nativeCleanFileCacheFromRoot(String str);

    private native void nativeClearAICachedData();

    private native void nativeFinalize();

    private native void nativeFreeCache();

    private native LightAIDataWrapper nativeGetAIData(String[] strArr, int i3);

    private native String nativeGetAbnormalFrameDetectResult();

    public static native LightAgentBundleInfo nativeGetAgentBundleInfoByAgentName(String str);

    private native String nativeGetConfigData();

    private native boolean nativeGetDisableRendererFlag();

    private native LightFaceData nativeGetFaceData();

    private native LightFaceFeature[] nativeGetFaceFeature();

    private native AvatarAIInfo nativeGetLightAvatarAIInfo();

    private native PerformanceData nativeGetPerformanceData();

    private static native String nativeGetResourceBundleLevelNameByAgentName(String str);

    private native void nativeOnPause();

    private native void nativeOnResume();

    private static native void nativeRegisterFont(FontAsset fontAsset, String str);

    private native void nativeRemoveExternalRenderCallback(String str);

    private native void nativeReplaceAIData(LightAIDataWrapper lightAIDataWrapper);

    private native void nativeSetAIDataListener(OnAIDataListener onAIDataListener);

    private native void nativeSetAbnormalFrameDetectFrequency(int i3);

    private native void nativeSetAccurateReadSample(boolean z16);

    private native void nativeSetBGMusicHidden(boolean z16);

    private native void nativeSetClipAssetListener(OnClipAssetListener onClipAssetListener);

    private native void nativeSetDefaultBeautyVersion(String str);

    private native void nativeSetDelegateAgentRequestListener(OnDelegateAgentRequestListener onDelegateAgentRequestListener);

    private native void nativeSetDelegateAgentResult(LightDelegateAgentRequest lightDelegateAgentRequest, boolean z16, String str);

    private native void nativeSetDetectShorterEdgeLength(int i3, String str);

    private static native void nativeSetDeviceAbilityMode(String str, int i3);

    private native void nativeSetDisableRendererFlag(boolean z16);

    private native void nativeSetDowngradeStrategy(String str, int i3);

    private native void nativeSetExternalFaceData(@NonNull LightFaceData lightFaceData);

    private native void nativeSetExternalRenderCallback(ExternalRenderCallback externalRenderCallback);

    private native void nativeSetHorizontalFov(float f16);

    private native void nativeSetLightAIModelPath(String str, String str2, String str3);

    private native void nativeSetLoadAssetListener(OnLoadAssetListener onLoadAssetListener);

    private native void nativeSetOnClickWatermarkListener(OnClickWatermarkListener onClickWatermarkListener);

    private native void nativeSetPreInitAgents(String[] strArr);

    private native void nativeSetPredictNextFrame(boolean z16);

    private native void nativeSetPredictNextTime(long j3);

    private native void nativeSetSyncInitFlag(boolean z16, String str);

    private native void nativeSetSyncMode(boolean z16);

    private native void nativeSetTipsStatusListener(OnTipsStatusListener onTipsStatusListener);

    private native void nativeSetWatermarkConfig(WatermarkConfig watermarkConfig);

    private native void nativeSetWatermarkDataListener(String str, OnWatermarkDataListener onWatermarkDataListener);

    public static void setAssetDowngradeFlag(boolean z16) {
        degradeAsset = z16;
    }

    private native void setConfigData(String str);

    public static void setDeviceAbilityMode(String str, DeviceAbilityMode deviceAbilityMode) {
        nativeSetDeviceAbilityMode(str, deviceAbilityMode.ordinal());
    }

    public void CleanFileCacheForKey(String str) {
        nativeCleanFileCacheForKey(str);
    }

    public void addExternalRenderCallback(String str, ExternalRenderCallback externalRenderCallback) {
        nativeAddExternalRenderCallback(str, externalRenderCallback);
    }

    public void clearAICachedData() {
        nativeClearAICachedData();
    }

    public int deviceLevelNameToLevelEnum(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(ML_VERY_HIGH, 5);
        hashMap.put("high", 4);
        hashMap.put("middle", 3);
        hashMap.put(HippyImageInfo.QUALITY_LOW, 2);
        hashMap.put(ML_VERY_LOW, 1);
        if (hashMap.containsKey(str)) {
            return ((Integer) hashMap.get(str)).intValue();
        }
        return -1;
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public void freeCache() {
        nativeFreeCache();
    }

    public LightAIDataWrapper getAIData(String[] strArr, int i3) {
        return nativeGetAIData(strArr, i3);
    }

    public String getAbnormalFrameDetectResult() {
        return nativeGetAbnormalFrameDetectResult();
    }

    public HashMap<String, String> getConfigData() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(nativeGetConfigData());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, jSONObject.getString(str));
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public boolean getDisableRendererFlag() {
        return nativeGetDisableRendererFlag();
    }

    public LightFaceData getFaceData() {
        return nativeGetFaceData();
    }

    public List<LightFaceFeature> getFaceFeature() {
        ArrayList arrayList = new ArrayList();
        LightFaceFeature[] nativeGetFaceFeature = nativeGetFaceFeature();
        if (nativeGetFaceFeature != null) {
            return Arrays.asList(nativeGetFaceFeature);
        }
        return arrayList;
    }

    public AvatarAIInfo getLightAvatarAIInfo() {
        return nativeGetLightAvatarAIInfo();
    }

    public PerformanceData getPerformanceData() {
        return nativeGetPerformanceData();
    }

    public native void nativeSetLightAIModelPathInfo(String str, LightAgentBundleInfo lightAgentBundleInfo);

    public native void nativeSetRenderSize(int i3, int i16);

    public void onPause() {
        nativeOnPause();
    }

    public void onResume() {
        nativeOnResume();
    }

    public void performFinalize() {
        if (this.nativeHandle != 0) {
            nativeFinalize();
        }
    }

    public void registerFont(String str, String str2, String str3) {
        registerFont(new FontAsset(str, str2), str3);
    }

    public void removeExternalRenderCallback(String str) {
        nativeRemoveExternalRenderCallback(str);
    }

    public void replaceAIData(LightAIDataWrapper lightAIDataWrapper) {
        nativeReplaceAIData(lightAIDataWrapper);
    }

    public void setAIDataListener(OnAIDataListener onAIDataListener) {
        nativeSetAIDataListener(onAIDataListener);
    }

    public void setAbnormalFrameDetectFrequency(int i3) {
        nativeSetAbnormalFrameDetectFrequency(i3);
    }

    public void setAccurateReadSample(boolean z16) {
        nativeSetAccurateReadSample(z16);
    }

    public void setBGMusicHidden(boolean z16) {
        nativeSetBGMusicHidden(z16);
    }

    public void setClipAssetListener(OnClipAssetListener onClipAssetListener) {
        nativeSetClipAssetListener(onClipAssetListener);
    }

    public void setConfigData(Map<String, String> map) {
        Log.d("setConfigData:", "" + map);
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis2 = System.currentTimeMillis();
        synchronized (map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        String jSONObject2 = jSONObject.toString();
        long currentTimeMillis4 = System.currentTimeMillis();
        setConfigData(jSONObject2);
        Log.d("setConfigData:", "json data:" + map);
        long currentTimeMillis5 = System.currentTimeMillis();
        Log.i("[performance]", "setConfigData cost time:" + (currentTimeMillis5 - currentTimeMillis) + "\n[performance]setConfigData new JSONObject cost time:" + (currentTimeMillis2 - currentTimeMillis) + "\n[performance]setConfigData entryset cost time:" + (currentTimeMillis3 - currentTimeMillis2) + "\n[performance]setConfigData json2string cost time:" + (currentTimeMillis4 - currentTimeMillis3) + "\n[performance]setConfigData  nativeSetConfigData cost time:" + (currentTimeMillis5 - currentTimeMillis4));
    }

    public void setDefaultBeautyVersion(String str) {
        nativeSetDefaultBeautyVersion(str);
    }

    public void setDelegateAgentRequestListener(OnDelegateAgentRequestListener onDelegateAgentRequestListener) {
        nativeSetDelegateAgentRequestListener(onDelegateAgentRequestListener);
    }

    public void setDelegateAgentResult(LightDelegateAgentRequest lightDelegateAgentRequest, boolean z16, String str) {
        nativeSetDelegateAgentResult(lightDelegateAgentRequest, z16, str);
    }

    public void setDetectShorterEdgeLength(int i3, String str) {
        nativeSetDetectShorterEdgeLength(i3, str);
    }

    public void setDisableRendererFlag(boolean z16) {
        nativeSetDisableRendererFlag(z16);
    }

    public void setDowngradeStrategy(String str, int i3) {
        nativeSetDowngradeStrategy(str, i3);
    }

    public void setExternalFaceData(LightFaceData lightFaceData) {
        if (lightFaceData != null) {
            nativeSetExternalFaceData(lightFaceData);
        }
    }

    public void setExternalRenderCallback(ExternalRenderCallback externalRenderCallback) {
        nativeSetExternalRenderCallback(externalRenderCallback);
    }

    public void setHorizontalFov(float f16) {
        nativeSetHorizontalFov(f16);
    }

    public void setLightAIModelPath(String str, LightAgentBundleInfo lightAgentBundleInfo) {
        if (lightAgentBundleInfo == null || lightAgentBundleInfo.notValid()) {
            return;
        }
        nativeSetLightAIModelPathInfo(str, lightAgentBundleInfo);
    }

    public void setLoadAssetListener(OnLoadAssetListener onLoadAssetListener) {
        nativeSetLoadAssetListener(onLoadAssetListener);
    }

    public void setOnClickWatermarkListener(OnClickWatermarkListener onClickWatermarkListener) {
        nativeSetOnClickWatermarkListener(onClickWatermarkListener);
    }

    public void setPreInitAgents(String[] strArr) {
        nativeSetPreInitAgents(strArr);
    }

    public void setPredictNextFrame(boolean z16) {
        nativeSetPredictNextFrame(z16);
    }

    public void setPredictNextTime(long j3) {
        nativeSetPredictNextTime(j3);
    }

    public void setRenderSize(int i3, int i16) {
        nativeSetRenderSize(i3, i16);
    }

    public native void setScriptOutputListener(OnScriptOutputListener onScriptOutputListener);

    public void setSyncInitFlag(boolean z16, String str) {
        nativeSetSyncInitFlag(z16, str);
    }

    public void setSyncMode(boolean z16) {
        nativeSetSyncMode(z16);
    }

    public void setTipsStatusListener(OnTipsStatusListener onTipsStatusListener) {
        nativeSetTipsStatusListener(onTipsStatusListener);
    }

    public void setWatermarkConfig(WatermarkConfig watermarkConfig) {
        nativeSetWatermarkConfig(watermarkConfig);
    }

    public void setWatermarkDataListener(String str, OnWatermarkDataListener onWatermarkDataListener) {
        nativeSetWatermarkDataListener(str, onWatermarkDataListener);
    }

    public static void registerFont(FontAsset fontAsset, String str) {
        nativeRegisterFont(fontAsset, str);
    }

    public void setLightAIModelPath(String str, String str2) {
        setLightAIModelPath(str, getResourceBundleLevelNameByAgentName(str2), str2);
    }

    public void setLightAIModelPath(String str, String str2, String str3) {
        nativeSetLightAIModelPath(str, str2, str3);
    }
}
