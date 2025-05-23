package com.tencent.rdelivery.reshub.core;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.rdelivery.reshub.api.TargetType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/a;", "Lcom/tencent/rdelivery/reshub/api/a;", "", "b", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "appId", "d", com.heytap.mcssdk.a.a.f36102l, "Lcom/tencent/rdelivery/reshub/api/TargetType;", "Lcom/tencent/rdelivery/reshub/api/TargetType;", "k", "()Lcom/tencent/rdelivery/reshub/api/TargetType;", "target", "i", MosaicConstants$JsProperty.PROP_ENV, "e", "f", "businessSetName", "j", "localPresetPath", "g", "appVersion", tl.h.F, "configStoreSuffix", Constants.SP_DEVICE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/rdelivery/reshub/api/TargetType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a implements com.tencent.rdelivery.reshub.api.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appKey;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TargetType target;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String env;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String businessSetName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String localPresetPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String appVersion;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String configStoreSuffix;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String deviceId;

    public a(@NotNull String appId, @NotNull String appKey, @NotNull TargetType target, @NotNull String env, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(env, "env");
        this.appId = appId;
        this.appKey = appKey;
        this.target = target;
        this.env = env;
        this.businessSetName = str;
        this.localPresetPath = str2;
        this.appVersion = str3;
        this.configStoreSuffix = str4;
        this.deviceId = str5;
    }

    @Override // com.tencent.rdelivery.reshub.api.a
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getEnv() {
        return this.env;
    }

    @Override // com.tencent.rdelivery.reshub.api.a
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String c() {
        return this.appId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getBusinessSetName() {
        return this.businessSetName;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getConfigStoreSuffix() {
        return this.configStoreSuffix;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    @NotNull
    public final String i() {
        return this.env;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final String getLocalPresetPath() {
        return this.localPresetPath;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final TargetType getTarget() {
        return this.target;
    }
}
