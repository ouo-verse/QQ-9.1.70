package com.tencent.mobileqq.qqlive.api.av;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import com.tencent.qqlive.common.api.AegisLogger;
import ht3.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010.J\u0018\u0010/\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010.J\u0010\u00101\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010.J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000205J\u0018\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u000bH\u0002J\u0010\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0007H\u0002J\u000e\u0010>\u001a\u0002032\u0006\u0010-\u001a\u00020.R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020%2\u0006\u0010$\u001a\u00020%@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0*X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/av/LiveMediaConfigManager;", "", "()V", "BLU_RAY_LEFT_MOST_HEIGHT", "", "BLU_RAY_LEFT_MOST_WIDTH", "CAMERA_BLU_RAY", "", "CAMERA_BLU_RAY_BITRATE", "Lkotlin/Pair;", "CAMERA_BLU_RAY_CONFIG", "Lcom/tencent/mobileqq/qqlive/api/av/LiveMediaConfig;", "CAMERA_HD", "CAMERA_HD_BITRATE", "CAMERA_HD_CONFIG", "CAMERA_UHD", "CAMERA_UHD_BITRATE", "CAMERA_UHD_CONFIG", "CAPTURE_BLU_RAY", "CAPTURE_BLU_RAY_BITRATE", "CAPTURE_BLU_RAY_CONFIG", "CAPTURE_HD", "CAPTURE_HD_BITRATE", "CAPTURE_HD_CONFIG", "CAPTURE_UHD", "CAPTURE_UHD_BITRATE", "CAPTURE_UHD_CONFIG", "FPS_15", "FPS_20", "FPS_25", "FPS_30", "KEY_BITRATE_MAX", "KEY_BITRATE_MIN", "KEY_FPS", "KEY_RESOLUTION", "TAG", "<set-?>", "", "isBackgroundCameraSupportBluRay", "()Z", "isFrontCameraSupportBluRay", "typeToMediaConfig", "", "getLiveMediaConfig", "roomType", "resLevelType", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "getLiveMediaConfigCache", "_defaultResLevelType", "getResolutionLevelTypeCache", "initCameraMediaConfig", "", "context", "Landroid/content/Context;", "initMediaConfig", "wnsKey", "default", "isCameraSupportBluRay", "cameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "parseConfig", "value", "setResolutionLevelTypeCache", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class LiveMediaConfigManager {
    private static final int BLU_RAY_LEFT_MOST_HEIGHT = 1080;
    private static final int BLU_RAY_LEFT_MOST_WIDTH = 1920;

    @NotNull
    private static final String CAMERA_BLU_RAY;

    @NotNull
    private static final Pair<Integer, Integer> CAMERA_BLU_RAY_BITRATE;

    @NotNull
    private static final LiveMediaConfig CAMERA_BLU_RAY_CONFIG;

    @NotNull
    private static final String CAMERA_HD;

    @NotNull
    private static final Pair<Integer, Integer> CAMERA_HD_BITRATE;

    @NotNull
    private static final LiveMediaConfig CAMERA_HD_CONFIG;

    @NotNull
    private static final String CAMERA_UHD;

    @NotNull
    private static final Pair<Integer, Integer> CAMERA_UHD_BITRATE;

    @NotNull
    private static final LiveMediaConfig CAMERA_UHD_CONFIG;

    @NotNull
    private static final String CAPTURE_BLU_RAY;

    @NotNull
    private static final Pair<Integer, Integer> CAPTURE_BLU_RAY_BITRATE;

    @NotNull
    private static final LiveMediaConfig CAPTURE_BLU_RAY_CONFIG;

    @NotNull
    private static final String CAPTURE_HD;

    @NotNull
    private static final Pair<Integer, Integer> CAPTURE_HD_BITRATE;

    @NotNull
    private static final LiveMediaConfig CAPTURE_HD_CONFIG;

    @NotNull
    private static final String CAPTURE_UHD;

    @NotNull
    private static final Pair<Integer, Integer> CAPTURE_UHD_BITRATE;

    @NotNull
    private static final LiveMediaConfig CAPTURE_UHD_CONFIG;
    private static final int FPS_15 = 15;
    private static final int FPS_20 = 20;
    private static final int FPS_25 = 25;
    private static final int FPS_30 = 30;

    @NotNull
    public static final LiveMediaConfigManager INSTANCE;

    @NotNull
    private static final String KEY_BITRATE_MAX = "bitrate_max";

    @NotNull
    private static final String KEY_BITRATE_MIN = "bitrate_min";

    @NotNull
    private static final String KEY_FPS = "fps";

    @NotNull
    private static final String KEY_RESOLUTION = "resolution_level";

    @NotNull
    private static final String TAG = "Open_Live|LiveMediaConfigManager";
    private static boolean isBackgroundCameraSupportBluRay;
    private static boolean isFrontCameraSupportBluRay;

    @NotNull
    private static final Map<String, LiveMediaConfig> typeToMediaConfig;

    static {
        LiveMediaConfigManager liveMediaConfigManager = new LiveMediaConfigManager();
        INSTANCE = liveMediaConfigManager;
        Pair<Integer, Integer> pair = new Pair<>(850, 1300);
        CAMERA_HD_BITRATE = pair;
        Pair<Integer, Integer> pair2 = new Pair<>(1400, 2000);
        CAMERA_UHD_BITRATE = pair2;
        Pair<Integer, Integer> pair3 = new Pair<>(2000, 3000);
        CAMERA_BLU_RAY_BITRATE = pair3;
        Pair<Integer, Integer> pair4 = new Pair<>(850, 1000);
        CAPTURE_HD_BITRATE = pair4;
        Pair<Integer, Integer> pair5 = new Pair<>(1600, 2000);
        CAPTURE_UHD_BITRATE = pair5;
        Pair<Integer, Integer> pair6 = new Pair<>(2500, 3000);
        CAPTURE_BLU_RAY_BITRATE = pair6;
        LiveMediaConfig liveMediaConfig = new LiveMediaConfig(2, 15, pair.getSecond().intValue(), pair.getFirst().intValue());
        CAMERA_HD_CONFIG = liveMediaConfig;
        LiveMediaConfig liveMediaConfig2 = new LiveMediaConfig(3, 15, pair2.getSecond().intValue(), pair2.getFirst().intValue());
        CAMERA_UHD_CONFIG = liveMediaConfig2;
        LiveMediaConfig liveMediaConfig3 = new LiveMediaConfig(4, 15, pair3.getSecond().intValue(), pair3.getFirst().intValue());
        CAMERA_BLU_RAY_CONFIG = liveMediaConfig3;
        LiveMediaConfig liveMediaConfig4 = new LiveMediaConfig(2, 20, pair4.getSecond().intValue(), pair4.getFirst().intValue());
        CAPTURE_HD_CONFIG = liveMediaConfig4;
        LiveMediaConfig liveMediaConfig5 = new LiveMediaConfig(3, 25, pair5.getSecond().intValue(), pair5.getFirst().intValue());
        CAPTURE_UHD_CONFIG = liveMediaConfig5;
        LiveMediaConfig liveMediaConfig6 = new LiveMediaConfig(4, 30, pair6.getSecond().intValue(), pair6.getFirst().intValue());
        CAPTURE_BLU_RAY_CONFIG = liveMediaConfig6;
        ResolutionLevelType resolutionLevelType = ResolutionLevelType.HD;
        String str = "0-" + resolutionLevelType;
        CAMERA_HD = str;
        ResolutionLevelType resolutionLevelType2 = ResolutionLevelType.UHD;
        String str2 = "0-" + resolutionLevelType2;
        CAMERA_UHD = str2;
        ResolutionLevelType resolutionLevelType3 = ResolutionLevelType.BluRay;
        String str3 = "0-" + resolutionLevelType3;
        CAMERA_BLU_RAY = str3;
        String str4 = "1-" + resolutionLevelType;
        CAPTURE_HD = str4;
        String str5 = "1-" + resolutionLevelType2;
        CAPTURE_UHD = str5;
        String str6 = "1-" + resolutionLevelType3;
        CAPTURE_BLU_RAY = str6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        typeToMediaConfig = linkedHashMap;
        linkedHashMap.put(str, liveMediaConfigManager.initMediaConfig("qqlive_media_config_camera_hd", liveMediaConfig));
        linkedHashMap.put(str2, liveMediaConfigManager.initMediaConfig("qqlive_media_config_camera_uhd", liveMediaConfig2));
        linkedHashMap.put(str3, liveMediaConfigManager.initMediaConfig("qqlive_media_config_camera_blu_ray", liveMediaConfig3));
        linkedHashMap.put(str4, liveMediaConfigManager.initMediaConfig("qqlive_media_config_capture_hd", liveMediaConfig4));
        linkedHashMap.put(str5, liveMediaConfigManager.initMediaConfig("qqlive_media_config_capture_uhd", liveMediaConfig5));
        linkedHashMap.put(str6, liveMediaConfigManager.initMediaConfig("qqlive_media_config_capture_blu_ray", liveMediaConfig6));
        AegisLogger.INSTANCE.i(TAG, "init", linkedHashMap.toString());
    }

    LiveMediaConfigManager() {
    }

    private final LiveMediaConfig initMediaConfig(String wnsKey, LiveMediaConfig r65) {
        boolean z16;
        try {
            String d16 = a.d(wnsKey, "");
            if (d16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return parseConfig(d16);
            }
            return r65;
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e(TAG, "initMediaConfig", "", e16);
            return r65;
        }
    }

    private final boolean isCameraSupportBluRay(CameraCharacteristics cameraCharacteristics) {
        Size[] sizeArr;
        boolean z16;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Size size = null;
        if (streamConfigurationMap != null) {
            sizeArr = streamConfigurationMap.getOutputSizes(256);
        } else {
            sizeArr = null;
        }
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        AegisLogger.INSTANCE.i(TAG, "isCameraSupportBluRay", "\u6444\u50cf\u5934\u652f\u6301\u5206\u8fa8\u7387: " + sizeArr + ", fps\u53ef\u9009\u8303\u56f4\uff1a" + rangeArr);
        if (sizeArr != null) {
            int length = sizeArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Size size2 = sizeArr[i3];
                if (size2.getWidth() >= 1920 && size2.getHeight() > 1080) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    size = size2;
                    break;
                }
                i3++;
            }
        }
        if (size != null) {
            return true;
        }
        return false;
    }

    private final LiveMediaConfig parseConfig(String value) {
        JSONObject jSONObject = new JSONObject(value);
        return new LiveMediaConfig(jSONObject.optInt(KEY_RESOLUTION), jSONObject.optInt("fps"), jSONObject.optInt(KEY_BITRATE_MAX), jSONObject.optInt(KEY_BITRATE_MIN));
    }

    @NotNull
    public final LiveMediaConfig getLiveMediaConfig(int roomType, @Nullable ResolutionLevelType resLevelType) {
        LiveMediaConfig liveMediaConfig = typeToMediaConfig.get(roomType + "-" + resLevelType);
        if (liveMediaConfig == null) {
            return new LiveMediaConfig(0, 0, 0, 0, 15, null);
        }
        return liveMediaConfig;
    }

    @NotNull
    public final LiveMediaConfig getLiveMediaConfigCache(int roomType, @Nullable ResolutionLevelType _defaultResLevelType) {
        ResolutionLevelType resolutionLevelTypeCache = getResolutionLevelTypeCache(_defaultResLevelType);
        LiveMediaConfig liveMediaConfig = typeToMediaConfig.get(roomType + "-" + resolutionLevelTypeCache);
        if (liveMediaConfig == null) {
            return new LiveMediaConfig(0, 0, 0, 0, 15, null);
        }
        return liveMediaConfig;
    }

    @NotNull
    public final ResolutionLevelType getResolutionLevelTypeCache(@Nullable ResolutionLevelType _defaultResLevelType) {
        if (_defaultResLevelType == null) {
            _defaultResLevelType = ResolutionLevelType.UHD;
        }
        try {
            String l3 = ct3.a.l("qqlive_key_room_resolution_level", _defaultResLevelType.name());
            Intrinsics.checkNotNullExpressionValue(l3, "getString(\n             \u2026defaultResLevelType.name)");
            return ResolutionLevelType.valueOf(l3);
        } catch (Exception unused) {
            return _defaultResLevelType;
        }
    }

    public final void initCameraMediaConfig(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 28) {
            AegisLogger.INSTANCE.i(TAG, "initCameraMediaConfig", "Android \u7248\u672c\u8fc7\u4f4e\uff0c\u4e0d\u5efa\u8bae\u4f7f\u75281080p\u5f00\u64ad, version=" + i3);
            isBackgroundCameraSupportBluRay = false;
            isFrontCameraSupportBluRay = false;
            return;
        }
        try {
            Object systemService = context.getApplicationContext().getSystemService("camera");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            CameraManager cameraManager = (CameraManager) systemService;
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics("1");
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cameraManager.getCameraCharacteristics(\"1\")");
            isFrontCameraSupportBluRay = isCameraSupportBluRay(cameraCharacteristics);
            CameraCharacteristics cameraCharacteristics2 = cameraManager.getCameraCharacteristics("0");
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics2, "cameraManager.getCameraCharacteristics(\"0\")");
            isBackgroundCameraSupportBluRay = isCameraSupportBluRay(cameraCharacteristics2);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e(TAG, "initCameraMediaConfig", "\u83b7\u53d6\u6444\u50cf\u5934\u53c2\u6570\u5931\u8d25:" + e16.getMessage());
        }
    }

    public final boolean isBackgroundCameraSupportBluRay() {
        return isBackgroundCameraSupportBluRay;
    }

    public final boolean isFrontCameraSupportBluRay() {
        return isFrontCameraSupportBluRay;
    }

    public final void setResolutionLevelTypeCache(@NotNull ResolutionLevelType resLevelType) {
        Intrinsics.checkNotNullParameter(resLevelType, "resLevelType");
        ct3.a.t("qqlive_key_room_resolution_level", resLevelType.name());
    }
}
