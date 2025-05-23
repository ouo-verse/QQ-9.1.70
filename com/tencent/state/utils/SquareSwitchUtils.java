package com.tencent.state.utils;

import com.tencent.state.SquareDebug;
import com.tencent.state.SquareRuntime;
import com.tencent.state.data.SwitchConfig;
import com.tencent.state.data.SwitchKey;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.SquareDeviceInfo;
import com.tencent.zplan.common.utils.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020)J\u0006\u0010$\u001a\u00020\u0006J+\u0010*\u001a\u0004\u0018\u0001H+\"\u0004\b\u0000\u0010+2\u0006\u0010,\u001a\u00020\u00042\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H+0.H\u0002\u00a2\u0006\u0002\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010#2\u0006\u0010,\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\nR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u001a\u0010\b\"\u0004\b\u001b\u0010\nR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u001d\u0010\b\"\u0004\b\u001e\u0010\nR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tencent/state/utils/SquareSwitchUtils;", "", "()V", "TAG", "", "disableIntimateMTK", "", "getDisableIntimateMTK", "()Ljava/lang/Boolean;", "setDisableIntimateMTK", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enableChatLandUseCache", "getEnableChatLandUseCache", "setEnableChatLandUseCache", "enableFilamentCoverRecordGuestUpload", "enableFilamentDetail", "getEnableFilamentDetail", "setEnableFilamentDetail", "enableFilamentIndex", "getEnableFilamentIndex", "setEnableFilamentIndex", "enableFilamentRecord", "getEnableFilamentRecord", "setEnableFilamentRecord", "enableIndexUseCache", "getEnableIndexUseCache", "setEnableIndexUseCache", "enableRecordGuest", "getEnableRecordGuest", "setEnableRecordGuest", "enableRecordLand", "getEnableRecordLand", "setEnableRecordLand", "filamentGroupConfig", "Lorg/json/JSONObject;", "isMp4PlayBlockDevice", "squareCommonConfig", "Lcom/tencent/state/utils/SquareCommonConfig;", "useCacheGroupConfig", "initialize", "", "loadConfig", "T", "key", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "loadRawConfig", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareSwitchUtils {
    public static final SquareSwitchUtils INSTANCE = new SquareSwitchUtils();
    private static final String TAG = "SquareSwitchUtils";
    private static Boolean disableIntimateMTK;
    private static Boolean enableChatLandUseCache;
    private static Boolean enableFilamentCoverRecordGuestUpload;
    private static Boolean enableFilamentDetail;
    private static Boolean enableFilamentIndex;
    private static Boolean enableFilamentRecord;
    private static Boolean enableIndexUseCache;
    private static Boolean enableRecordGuest;
    private static Boolean enableRecordLand;
    private static JSONObject filamentGroupConfig;
    private static Boolean isMp4PlayBlockDevice;
    private static SquareCommonConfig squareCommonConfig;
    private static JSONObject useCacheGroupConfig;

    SquareSwitchUtils() {
    }

    private final <T> T loadConfig(String key, Class<T> clazz) {
        JSONObject loadRawConfig = loadRawConfig(key);
        if (loadRawConfig == null) {
            return null;
        }
        try {
            return (T) GsonUtil.f385283b.a().fromJson(loadRawConfig.toString(), (Class) clazz);
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().d(TAG, "loadConfig fail: " + th5);
            return null;
        }
    }

    private final JSONObject loadRawConfig(String key) {
        boolean isBlank;
        String str = new String(SquareBaseKt.getSquareCommon().loadRawConfig(key, new byte[0]), Charsets.UTF_8);
        SquareBaseKt.getSquareLog().d(TAG, "loadRawConfig: " + key + ", " + str);
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!(!isBlank)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().d(TAG, "filamentGroupConfig fail: " + th5);
            return null;
        }
    }

    public final boolean disableIntimateMTK() {
        Boolean bool = disableIntimateMTK;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            SquareBaseKt.getSquareLog().i(TAG, "disableIntimateMTK: open=" + booleanValue + ", cache=true");
            return booleanValue;
        }
        SquareCommonConfig squareCommonConfig2 = squareCommonConfig;
        boolean disableIntimateMTK2 = squareCommonConfig2 != null ? squareCommonConfig2.getDisableIntimateMTK() : false;
        SquareBaseKt.getSquareLog().i(TAG, "disableIntimateMTK: open=" + disableIntimateMTK2 + ", cache=false");
        disableIntimateMTK = Boolean.valueOf(disableIntimateMTK2);
        return disableIntimateMTK2;
    }

    public final boolean enableChatLandUseCache() {
        boolean optBoolean;
        Boolean bool = enableChatLandUseCache;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            optBoolean = SquareDebug.INSTANCE.getEnableChatLandUseCache();
        } else {
            JSONObject jSONObject = useCacheGroupConfig;
            optBoolean = jSONObject != null ? jSONObject.optBoolean(SwitchConfig.Key.canChatLandUseCache, false) : false;
        }
        SquareBaseKt.getSquareLog().i(TAG, "enableChatLandUseCache: open=" + optBoolean + ", cache=false, isDebug=" + SquareBaseKt.getSquareCommon().isDebugVersion());
        enableChatLandUseCache = Boolean.valueOf(optBoolean);
        return optBoolean;
    }

    public final boolean enableFilamentCoverRecordGuestUpload() {
        return Intrinsics.areEqual(enableFilamentCoverRecordGuestUpload, Boolean.TRUE) || SquareBaseKt.getSquareCommon().isDebugVersion();
    }

    public final boolean enableFilamentDetail() {
        boolean z16 = true;
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            return true;
        }
        Boolean bool = enableFilamentDetail;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            z16 = SquareDebug.INSTANCE.getEnableFilamentDetail();
        } else {
            boolean enableZPlanFilamentBase = SquareBaseKt.getSquareCommon().enableZPlanFilamentBase();
            boolean isSwitchOn = SquareBaseKt.getSquareCommon().isSwitchOn(SwitchKey.filamentEnable, false);
            SquareBaseKt.getSquareLog().i(TAG, "enableFilamentDetail: baseSwitch=" + enableZPlanFilamentBase + ", squareSwitch=" + isSwitchOn);
            if (!enableZPlanFilamentBase || !isSwitchOn) {
                z16 = false;
            }
        }
        enableFilamentDetail = Boolean.valueOf(z16);
        return z16;
    }

    public final boolean enableFilamentIndex() {
        boolean z16;
        Boolean bool = enableFilamentIndex;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            z16 = SquareDebug.INSTANCE.getEnableFilamentIndex();
        } else {
            boolean enableZPlanFilamentBase = SquareBaseKt.getSquareCommon().enableZPlanFilamentBase();
            boolean isSwitchOn = SquareBaseKt.getSquareCommon().isSwitchOn(SwitchKey.filamentIndexEnable, false);
            SquareBaseKt.getSquareLog().i(TAG, "enableFilamentIndex: baseSwitch=" + enableZPlanFilamentBase + ", squareSwitch=" + isSwitchOn);
            z16 = enableZPlanFilamentBase && isSwitchOn;
        }
        enableFilamentIndex = Boolean.valueOf(z16);
        return z16;
    }

    public final boolean enableFilamentRecord() {
        Boolean bool = enableFilamentRecord;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(SquareBaseKt.getSquareCommon().enableZPlanFilamentBase());
        enableFilamentRecord = valueOf;
        Intrinsics.checkNotNull(valueOf);
        return valueOf.booleanValue();
    }

    public final boolean enableIndexUseCache() {
        boolean optBoolean;
        Boolean bool = enableIndexUseCache;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            optBoolean = SquareDebug.INSTANCE.getEnableIndexUseCache();
        } else {
            JSONObject jSONObject = useCacheGroupConfig;
            optBoolean = jSONObject != null ? jSONObject.optBoolean(SwitchConfig.Key.canIndexUseCache, false) : false;
        }
        SquareBaseKt.getSquareLog().i(TAG, "enableIndexUseCache: open=" + optBoolean + ", cache=false, isDebug=" + SquareBaseKt.getSquareCommon().isDebugVersion());
        enableIndexUseCache = Boolean.valueOf(optBoolean);
        return optBoolean;
    }

    public final boolean enableRecordGuest() {
        boolean optBoolean;
        JSONObject jSONObject;
        Boolean bool = enableRecordGuest;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            optBoolean = SquareDebug.INSTANCE.getEnableRecordGuest();
        } else {
            optBoolean = (!enableFilamentIndex() || (jSONObject = filamentGroupConfig) == null) ? false : jSONObject.optBoolean(SwitchConfig.Key.canRecordGuest, false);
        }
        SquareBaseKt.getSquareLog().i(TAG, "enableRecordGuest: open=" + optBoolean + ", cache=false, isDebug=" + SquareBaseKt.getSquareCommon().isDebugVersion());
        enableRecordGuest = Boolean.valueOf(optBoolean);
        return optBoolean;
    }

    public final boolean enableRecordLand() {
        boolean optBoolean;
        JSONObject jSONObject;
        Boolean bool = enableRecordLand;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (SquareBaseKt.getSquareCommon().isDebugVersion()) {
            optBoolean = SquareDebug.INSTANCE.getEnableRecordLand();
        } else {
            optBoolean = (!enableFilamentIndex() || (jSONObject = filamentGroupConfig) == null) ? false : jSONObject.optBoolean(SwitchConfig.Key.canRecordLand, false);
        }
        SquareBaseKt.getSquareLog().i(TAG, "enableRecordLand: open=" + optBoolean + ", cache=false, isDebug=" + SquareBaseKt.getSquareCommon().isDebugVersion());
        enableRecordLand = Boolean.valueOf(optBoolean);
        return optBoolean;
    }

    public final Boolean getDisableIntimateMTK() {
        return disableIntimateMTK;
    }

    public final Boolean getEnableChatLandUseCache() {
        return enableChatLandUseCache;
    }

    public final Boolean getEnableFilamentDetail() {
        return enableFilamentDetail;
    }

    public final Boolean getEnableFilamentIndex() {
        return enableFilamentIndex;
    }

    public final Boolean getEnableFilamentRecord() {
        return enableFilamentRecord;
    }

    public final Boolean getEnableIndexUseCache() {
        return enableIndexUseCache;
    }

    public final Boolean getEnableRecordGuest() {
        return enableRecordGuest;
    }

    public final Boolean getEnableRecordLand() {
        return enableRecordLand;
    }

    public final boolean isMp4PlayBlockDevice() {
        Boolean bool = isMp4PlayBlockDevice;
        if (bool != null) {
            return bool.booleanValue();
        }
        SquareDeviceInfo squareDeviceInfo = SquareBaseKt.getSquareCommon().getSquareDeviceInfo();
        SquareCommonConfig squareCommonConfig2 = squareCommonConfig;
        boolean isMatch = SquareSwitchUtilsKt.isMatch(squareCommonConfig2 != null ? squareCommonConfig2.getMp4PlayBlockDevices() : null, squareDeviceInfo);
        SquareBaseKt.getSquareLog().i(TAG, "isMp4PlayBlockDevice: open=" + isMatch + ", cache=false, uiVersion=" + squareDeviceInfo.getSystemUiVersion() + ", model=" + squareDeviceInfo.getModel());
        isMp4PlayBlockDevice = Boolean.valueOf(isMatch);
        return isMatch;
    }

    public final void setDisableIntimateMTK(Boolean bool) {
        disableIntimateMTK = bool;
    }

    public final void setEnableChatLandUseCache(Boolean bool) {
        enableChatLandUseCache = bool;
    }

    public final void setEnableFilamentDetail(Boolean bool) {
        enableFilamentDetail = bool;
    }

    public final void setEnableFilamentIndex(Boolean bool) {
        enableFilamentIndex = bool;
    }

    public final void setEnableFilamentRecord(Boolean bool) {
        enableFilamentRecord = bool;
    }

    public final void setEnableIndexUseCache(Boolean bool) {
        enableIndexUseCache = bool;
    }

    public final void setEnableRecordGuest(Boolean bool) {
        enableRecordGuest = bool;
    }

    public final void setEnableRecordLand(Boolean bool) {
        enableRecordLand = bool;
    }

    public final void initialize() {
        enableFilamentRecord = null;
        enableFilamentDetail = null;
        enableFilamentIndex = null;
        enableRecordGuest = null;
        enableRecordLand = null;
        enableIndexUseCache = null;
        enableChatLandUseCache = null;
        filamentGroupConfig = loadRawConfig(SwitchConfig.Group.filamentGroup);
        useCacheGroupConfig = loadRawConfig(SwitchConfig.Group.useCacheGroup);
        squareCommonConfig = (SquareCommonConfig) loadConfig(SwitchConfig.Group.squareCommonGroup, SquareCommonConfig.class);
        JSONObject loadRawConfig = loadRawConfig(SwitchConfig.Group.filamentCoverRecord);
        enableFilamentCoverRecordGuestUpload = loadRawConfig != null ? Boolean.valueOf(loadRawConfig.optBoolean(SwitchConfig.Key.filamentCoverRecordGuestUpload, false)) : null;
    }
}
