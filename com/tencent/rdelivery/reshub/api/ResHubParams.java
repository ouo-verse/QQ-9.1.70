package com.tencent.rdelivery.reshub.api;

import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u00a1\u0001\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e\u0012\b\b\u0002\u0010&\u001a\u00020\u0004\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010/\u001a\u00020\u0007\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\r\u0010\u0013R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u0010\u0010\u000bR#\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b\u0018\u0010%R\u0017\u0010(\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b\u0015\u0010%R\u0017\u0010)\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u0019\u0010-\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010.\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b+\u0010*\u001a\u0004\b\u001f\u0010,R\u0017\u0010/\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\u00a8\u00062"}, d2 = {"Lcom/tencent/rdelivery/reshub/api/s;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "appVersion", "b", "f", Constants.SP_DEVICE_ID, "c", "Z", DomainData.DOMAIN_NAME, "()Z", "isRdmTest", "d", "i", "localPresetPath", "e", "completeCallbackOnMainThread", "k", "progressCallbackOnMainThread", "g", "configStoreSuffix", "", tl.h.F, "Ljava/util/Map;", "l", "()Ljava/util/Map;", "variantMap", "I", "()I", "configUpdateStrategy", "j", "configUpdateInterval", "multiProcessMode", "Ljava/lang/Boolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/Boolean;", "is64Bit", "enableRecordLastRequestTime", "enableLazyLoadInnerConfig", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Ljava/util/Map;IIZLjava/lang/Boolean;Ljava/lang/Boolean;Z)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.rdelivery.reshub.api.s, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ResHubParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appVersion;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String deviceId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRdmTest;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String localPresetPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean completeCallbackOnMainThread;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean progressCallbackOnMainThread;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String configStoreSuffix;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, String> variantMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int configUpdateStrategy;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int configUpdateInterval;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean multiProcessMode;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean is64Bit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean enableRecordLastRequestTime;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean enableLazyLoadInnerConfig;

    @JvmOverloads
    public ResHubParams(@NotNull String str, @NotNull String str2, boolean z16, @NotNull String str3, boolean z17, boolean z18, @NotNull String str4, @NotNull Map<String, String> map, int i3, int i16, boolean z19, @Nullable Boolean bool) {
        this(str, str2, z16, str3, z17, z18, str4, map, i3, i16, z19, bool, null, false, 12288, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCompleteCallbackOnMainThread() {
        return this.completeCallbackOnMainThread;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getConfigStoreSuffix() {
        return this.configStoreSuffix;
    }

    /* renamed from: d, reason: from getter */
    public final int getConfigUpdateInterval() {
        return this.configUpdateInterval;
    }

    /* renamed from: e, reason: from getter */
    public final int getConfigUpdateStrategy() {
        return this.configUpdateStrategy;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ResHubParams) {
                ResHubParams resHubParams = (ResHubParams) other;
                if (!Intrinsics.areEqual(this.appVersion, resHubParams.appVersion) || !Intrinsics.areEqual(this.deviceId, resHubParams.deviceId) || this.isRdmTest != resHubParams.isRdmTest || !Intrinsics.areEqual(this.localPresetPath, resHubParams.localPresetPath) || this.completeCallbackOnMainThread != resHubParams.completeCallbackOnMainThread || this.progressCallbackOnMainThread != resHubParams.progressCallbackOnMainThread || !Intrinsics.areEqual(this.configStoreSuffix, resHubParams.configStoreSuffix) || !Intrinsics.areEqual(this.variantMap, resHubParams.variantMap) || this.configUpdateStrategy != resHubParams.configUpdateStrategy || this.configUpdateInterval != resHubParams.configUpdateInterval || this.multiProcessMode != resHubParams.multiProcessMode || !Intrinsics.areEqual(this.is64Bit, resHubParams.is64Bit) || !Intrinsics.areEqual(this.enableRecordLastRequestTime, resHubParams.enableRecordLastRequestTime) || this.enableLazyLoadInnerConfig != resHubParams.enableLazyLoadInnerConfig) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getEnableLazyLoadInnerConfig() {
        return this.enableLazyLoadInnerConfig;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Boolean getEnableRecordLastRequestTime() {
        return this.enableRecordLastRequestTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        String str = this.appVersion;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = i3 * 31;
        String str2 = this.deviceId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        boolean z16 = this.isRdmTest;
        int i36 = 1;
        int i37 = z16;
        if (z16 != 0) {
            i37 = 1;
        }
        int i38 = (i29 + i37) * 31;
        String str3 = this.localPresetPath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (i38 + i17) * 31;
        boolean z17 = this.completeCallbackOnMainThread;
        int i46 = z17;
        if (z17 != 0) {
            i46 = 1;
        }
        int i47 = (i39 + i46) * 31;
        boolean z18 = this.progressCallbackOnMainThread;
        int i48 = z18;
        if (z18 != 0) {
            i48 = 1;
        }
        int i49 = (i47 + i48) * 31;
        String str4 = this.configStoreSuffix;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i56 = (i49 + i18) * 31;
        Map<String, String> map = this.variantMap;
        if (map != null) {
            i19 = map.hashCode();
        } else {
            i19 = 0;
        }
        int i57 = (((((i56 + i19) * 31) + this.configUpdateStrategy) * 31) + this.configUpdateInterval) * 31;
        boolean z19 = this.multiProcessMode;
        int i58 = z19;
        if (z19 != 0) {
            i58 = 1;
        }
        int i59 = (i57 + i58) * 31;
        Boolean bool = this.is64Bit;
        if (bool != null) {
            i26 = bool.hashCode();
        } else {
            i26 = 0;
        }
        int i65 = (i59 + i26) * 31;
        Boolean bool2 = this.enableRecordLastRequestTime;
        if (bool2 != null) {
            i27 = bool2.hashCode();
        }
        int i66 = (i65 + i27) * 31;
        boolean z26 = this.enableLazyLoadInnerConfig;
        if (!z26) {
            i36 = z26 ? 1 : 0;
        }
        return i66 + i36;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getLocalPresetPath() {
        return this.localPresetPath;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getMultiProcessMode() {
        return this.multiProcessMode;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getProgressCallbackOnMainThread() {
        return this.progressCallbackOnMainThread;
    }

    @NotNull
    public final Map<String, String> l() {
        return this.variantMap;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final Boolean getIs64Bit() {
        return this.is64Bit;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsRdmTest() {
        return this.isRdmTest;
    }

    @NotNull
    public String toString() {
        return "ResHubParams(appVersion=" + this.appVersion + ", deviceId=" + this.deviceId + ", isRdmTest=" + this.isRdmTest + ", localPresetPath=" + this.localPresetPath + ", completeCallbackOnMainThread=" + this.completeCallbackOnMainThread + ", progressCallbackOnMainThread=" + this.progressCallbackOnMainThread + ", configStoreSuffix=" + this.configStoreSuffix + ", variantMap=" + this.variantMap + ", configUpdateStrategy=" + this.configUpdateStrategy + ", configUpdateInterval=" + this.configUpdateInterval + ", multiProcessMode=" + this.multiProcessMode + ", is64Bit=" + this.is64Bit + ", enableRecordLastRequestTime=" + this.enableRecordLastRequestTime + ", enableLazyLoadInnerConfig=" + this.enableLazyLoadInnerConfig + ")";
    }

    @JvmOverloads
    public ResHubParams(@NotNull String appVersion, @NotNull String deviceId, boolean z16, @NotNull String localPresetPath, boolean z17, boolean z18, @NotNull String configStoreSuffix, @NotNull Map<String, String> variantMap, int i3, int i16, boolean z19, @Nullable Boolean bool, @Nullable Boolean bool2, boolean z26) {
        Intrinsics.checkParameterIsNotNull(appVersion, "appVersion");
        Intrinsics.checkParameterIsNotNull(deviceId, "deviceId");
        Intrinsics.checkParameterIsNotNull(localPresetPath, "localPresetPath");
        Intrinsics.checkParameterIsNotNull(configStoreSuffix, "configStoreSuffix");
        Intrinsics.checkParameterIsNotNull(variantMap, "variantMap");
        this.appVersion = appVersion;
        this.deviceId = deviceId;
        this.isRdmTest = z16;
        this.localPresetPath = localPresetPath;
        this.completeCallbackOnMainThread = z17;
        this.progressCallbackOnMainThread = z18;
        this.configStoreSuffix = configStoreSuffix;
        this.variantMap = variantMap;
        this.configUpdateStrategy = i3;
        this.configUpdateInterval = i16;
        this.multiProcessMode = z19;
        this.is64Bit = bool;
        this.enableRecordLastRequestTime = bool2;
        this.enableLazyLoadInnerConfig = z26;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ResHubParams(String str, String str2, boolean z16, String str3, boolean z17, boolean z18, String str4, Map map, int i3, int i16, boolean z19, Boolean bool, Boolean bool2, boolean z26, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, r6, r7, r8, r9, r10, r11, (i17 & 256) != 0 ? t.a() : i3, (i17 & 512) != 0 ? 10800 : i16, (i17 & 1024) != 0 ? false : z19, (i17 & 2048) != 0 ? null : bool, (i17 & 4096) != 0 ? null : bool2, (i17 & 8192) != 0 ? false : z26);
        Map map2;
        Map emptyMap;
        boolean z27 = (i17 & 4) != 0 ? false : z16;
        String str5 = (i17 & 8) != 0 ? "res_hub" : str3;
        boolean z28 = (i17 & 16) != 0 ? true : z17;
        boolean z29 = (i17 & 32) != 0 ? false : z18;
        String str6 = (i17 & 64) != 0 ? "store" : str4;
        if ((i17 & 128) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
    }
}
