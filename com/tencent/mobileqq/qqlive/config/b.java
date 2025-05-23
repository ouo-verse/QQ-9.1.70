package com.tencent.mobileqq.qqlive.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"Jc\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\u001dR\u0017\u0010\n\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b \u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/config/b;", "", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "appId", com.heytap.mcssdk.a.a.f36102l, "loginExtData", "loginAuthAppId", "", "clientType", "pullMsgClientType", "openSdkAppId", "trtcSdkAppId", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", "b", "c", "d", "g", "e", "f", "I", "()I", "i", h.F, "j", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String businessName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String loginExtData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String loginAuthAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int clientType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int pullMsgClientType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String openSdkAppId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String trtcSdkAppId;

    public b(@NotNull String businessName, @NotNull String appId, @NotNull String appKey, @NotNull String loginExtData, @NotNull String loginAuthAppId, int i3, int i16, @NotNull String openSdkAppId, @NotNull String trtcSdkAppId) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(loginExtData, "loginExtData");
        Intrinsics.checkNotNullParameter(loginAuthAppId, "loginAuthAppId");
        Intrinsics.checkNotNullParameter(openSdkAppId, "openSdkAppId");
        Intrinsics.checkNotNullParameter(trtcSdkAppId, "trtcSdkAppId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, businessName, appId, appKey, loginExtData, loginAuthAppId, Integer.valueOf(i3), Integer.valueOf(i16), openSdkAppId, trtcSdkAppId);
            return;
        }
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

    public static /* synthetic */ b b(b bVar, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, int i17, Object obj) {
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        int i18;
        int i19;
        String str13;
        String str14;
        if ((i17 & 1) != 0) {
            str8 = bVar.businessName;
        } else {
            str8 = str;
        }
        if ((i17 & 2) != 0) {
            str9 = bVar.appId;
        } else {
            str9 = str2;
        }
        if ((i17 & 4) != 0) {
            str10 = bVar.appKey;
        } else {
            str10 = str3;
        }
        if ((i17 & 8) != 0) {
            str11 = bVar.loginExtData;
        } else {
            str11 = str4;
        }
        if ((i17 & 16) != 0) {
            str12 = bVar.loginAuthAppId;
        } else {
            str12 = str5;
        }
        if ((i17 & 32) != 0) {
            i18 = bVar.clientType;
        } else {
            i18 = i3;
        }
        if ((i17 & 64) != 0) {
            i19 = bVar.pullMsgClientType;
        } else {
            i19 = i16;
        }
        if ((i17 & 128) != 0) {
            str13 = bVar.openSdkAppId;
        } else {
            str13 = str6;
        }
        if ((i17 & 256) != 0) {
            str14 = bVar.trtcSdkAppId;
        } else {
            str14 = str7;
        }
        return bVar.a(str8, str9, str10, str11, str12, i18, i19, str13, str14);
    }

    @NotNull
    public final b a(@NotNull String businessName, @NotNull String appId, @NotNull String appKey, @NotNull String loginExtData, @NotNull String loginAuthAppId, int clientType, int pullMsgClientType, @NotNull String openSdkAppId, @NotNull String trtcSdkAppId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (b) iPatchRedirector.redirect((short) 20, this, businessName, appId, appKey, loginExtData, loginAuthAppId, Integer.valueOf(clientType), Integer.valueOf(pullMsgClientType), openSdkAppId, trtcSdkAppId);
        }
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(loginExtData, "loginExtData");
        Intrinsics.checkNotNullParameter(loginAuthAppId, "loginAuthAppId");
        Intrinsics.checkNotNullParameter(openSdkAppId, "openSdkAppId");
        Intrinsics.checkNotNullParameter(trtcSdkAppId, "trtcSdkAppId");
        return new b(businessName, appId, appKey, loginExtData, loginAuthAppId, clientType, pullMsgClientType, openSdkAppId, trtcSdkAppId);
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.appKey;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.clientType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.businessName, bVar.businessName) && Intrinsics.areEqual(this.appId, bVar.appId) && Intrinsics.areEqual(this.appKey, bVar.appKey) && Intrinsics.areEqual(this.loginExtData, bVar.loginExtData) && Intrinsics.areEqual(this.loginAuthAppId, bVar.loginAuthAppId) && this.clientType == bVar.clientType && this.pullMsgClientType == bVar.pullMsgClientType && Intrinsics.areEqual(this.openSdkAppId, bVar.openSdkAppId) && Intrinsics.areEqual(this.trtcSdkAppId, bVar.trtcSdkAppId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.loginAuthAppId;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.loginExtData;
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.openSdkAppId;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return (((((((((((((((this.businessName.hashCode() * 31) + this.appId.hashCode()) * 31) + this.appKey.hashCode()) * 31) + this.loginExtData.hashCode()) * 31) + this.loginAuthAppId.hashCode()) * 31) + this.clientType) * 31) + this.pullMsgClientType) * 31) + this.openSdkAppId.hashCode()) * 31) + this.trtcSdkAppId.hashCode();
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.pullMsgClientType;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.trtcSdkAppId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "LiveConfig(businessName=" + this.businessName + ", appId=" + this.appId + ", appKey=" + this.appKey + ", loginExtData=" + this.loginExtData + ", loginAuthAppId=" + this.loginAuthAppId + ", clientType=" + this.clientType + ", pullMsgClientType=" + this.pullMsgClientType + ", openSdkAppId=" + this.openSdkAppId + ", trtcSdkAppId=" + this.trtcSdkAppId + ")";
    }
}
