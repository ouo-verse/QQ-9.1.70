package d32;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\f\u00a8\u0006\""}, d2 = {"Ld32/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "b", "appId", "c", com.heytap.mcssdk.a.a.f36102l, "d", "e", "loginExtData", "loginAuthAppId", "f", "I", "()I", "clientType", "g", "pullMsgClientType", h.F, "openSdkAppId", "i", "trtcSdkAppId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: d32.b, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class LiveConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String businessName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String loginExtData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String loginAuthAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int clientType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int pullMsgClientType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String openSdkAppId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String trtcSdkAppId;

    public LiveConfig(@NotNull String businessName, @NotNull String appId, @NotNull String appKey, @NotNull String loginExtData, @NotNull String loginAuthAppId, int i3, int i16, @NotNull String openSdkAppId, @NotNull String trtcSdkAppId) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(loginExtData, "loginExtData");
        Intrinsics.checkNotNullParameter(loginAuthAppId, "loginAuthAppId");
        Intrinsics.checkNotNullParameter(openSdkAppId, "openSdkAppId");
        Intrinsics.checkNotNullParameter(trtcSdkAppId, "trtcSdkAppId");
        this.businessName = businessName;
        this.appId = appId;
        this.appKey = appKey;
        this.loginExtData = loginExtData;
        this.loginAuthAppId = loginAuthAppId;
        this.clientType = i3;
        this.pullMsgClientType = i16;
        this.openSdkAppId = openSdkAppId;
        this.trtcSdkAppId = trtcSdkAppId;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: c, reason: from getter */
    public final int getClientType() {
        return this.clientType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getLoginAuthAppId() {
        return this.loginAuthAppId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLoginExtData() {
        return this.loginExtData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveConfig)) {
            return false;
        }
        LiveConfig liveConfig = (LiveConfig) other;
        if (Intrinsics.areEqual(this.businessName, liveConfig.businessName) && Intrinsics.areEqual(this.appId, liveConfig.appId) && Intrinsics.areEqual(this.appKey, liveConfig.appKey) && Intrinsics.areEqual(this.loginExtData, liveConfig.loginExtData) && Intrinsics.areEqual(this.loginAuthAppId, liveConfig.loginAuthAppId) && this.clientType == liveConfig.clientType && this.pullMsgClientType == liveConfig.pullMsgClientType && Intrinsics.areEqual(this.openSdkAppId, liveConfig.openSdkAppId) && Intrinsics.areEqual(this.trtcSdkAppId, liveConfig.trtcSdkAppId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getOpenSdkAppId() {
        return this.openSdkAppId;
    }

    /* renamed from: g, reason: from getter */
    public final int getPullMsgClientType() {
        return this.pullMsgClientType;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTrtcSdkAppId() {
        return this.trtcSdkAppId;
    }

    public int hashCode() {
        return (((((((((((((((this.businessName.hashCode() * 31) + this.appId.hashCode()) * 31) + this.appKey.hashCode()) * 31) + this.loginExtData.hashCode()) * 31) + this.loginAuthAppId.hashCode()) * 31) + this.clientType) * 31) + this.pullMsgClientType) * 31) + this.openSdkAppId.hashCode()) * 31) + this.trtcSdkAppId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveConfig(businessName=" + this.businessName + ", appId=" + this.appId + ", appKey=" + this.appKey + ", loginExtData=" + this.loginExtData + ", loginAuthAppId=" + this.loginAuthAppId + ", clientType=" + this.clientType + ", pullMsgClientType=" + this.pullMsgClientType + ", openSdkAppId=" + this.openSdkAppId + ", trtcSdkAppId=" + this.trtcSdkAppId + ")";
    }
}
