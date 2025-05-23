package hm0;

import com.tencent.gdtad.config.data.GdtWXMiniJumpConfig;
import com.tencent.gdtad.wxmini.GdtWXMiniData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\bA\u0010BJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u0017\u0010&\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010*\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b-\u0010\u0014R\u0017\u0010/\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b+\u0010 R\u0017\u00100\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001e\u001a\u0004\b\n\u0010 R\"\u00103\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010'\u001a\u0004\b\u001d\u0010)\"\u0004\b1\u00102R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b\"\u0010)\"\u0004\b4\u00102R\"\u00108\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010'\u001a\u0004\b%\u0010)\"\u0004\b7\u00102R\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010'\u001a\u0004\b6\u0010)\"\u0004\b:\u00102R\"\u0010@\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010=\u001a\u0004\b\u001b\u0010>\"\u0004\b9\u0010?\u00a8\u0006C"}, d2 = {"Lhm0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/gdtad/wxmini/GdtWXMiniData;", "a", "Lcom/tencent/gdtad/wxmini/GdtWXMiniData;", "gdtWXMiniData", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "b", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "gdtWXMiniJumpConfig", "c", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "originId", "d", "appId", "e", DomainData.DOMAIN_NAME, "posId", "f", "channelAppID", "g", "I", "j", "()I", "jumpTypeAMS", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "path", "i", "extData", "Z", "o", "()Z", "reportForLink", "k", "aid", "p", "traceId", "jumpTypeQQMC", "adErrorCode", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "hasAuth", "t", "jumpInside", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "jumpSuccess", "r", "v", "undertake", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig$Companion$JumpType;", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig$Companion$JumpType;", "()Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig$Companion$JumpType;", "(Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig$Companion$JumpType;)V", "finalJumpType", "<init>", "(Lcom/tencent/gdtad/wxmini/GdtWXMiniData;Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;)V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: hm0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class WXMiniSessionData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GdtWXMiniData gdtWXMiniData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GdtWXMiniJumpConfig gdtWXMiniJumpConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String originId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String posId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelAppID;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int jumpTypeAMS;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String path;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String extData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean reportForLink;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String aid;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String traceId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int jumpTypeQQMC;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int adErrorCode;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean hasAuth;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean jumpInside;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean jumpSuccess;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean undertake;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GdtWXMiniJumpConfig.Companion.JumpType finalJumpType;

    public WXMiniSessionData(@NotNull GdtWXMiniData gdtWXMiniData, @NotNull GdtWXMiniJumpConfig gdtWXMiniJumpConfig) {
        Intrinsics.checkNotNullParameter(gdtWXMiniData, "gdtWXMiniData");
        Intrinsics.checkNotNullParameter(gdtWXMiniJumpConfig, "gdtWXMiniJumpConfig");
        this.gdtWXMiniData = gdtWXMiniData;
        this.gdtWXMiniJumpConfig = gdtWXMiniJumpConfig;
        this.originId = gdtWXMiniData.getUserName();
        this.appId = gdtWXMiniData.getAppID();
        String posId = gdtWXMiniData.getPosId();
        this.posId = posId;
        this.channelAppID = gdtWXMiniData.getChannelAppID();
        this.jumpTypeAMS = gdtWXMiniData.getOpenType();
        this.path = gdtWXMiniData.getPath();
        this.extData = gdtWXMiniData.getExtData();
        this.reportForLink = gdtWXMiniData.getReportForLink();
        this.aid = gdtWXMiniData.getAid();
        this.traceId = gdtWXMiniData.getTraceId();
        this.jumpTypeQQMC = gdtWXMiniJumpConfig.f(posId);
        this.adErrorCode = gdtWXMiniData.getAdErrorCode();
        this.jumpSuccess = true;
        this.finalJumpType = GdtWXMiniJumpConfig.Companion.JumpType.OUTSIDE;
    }

    /* renamed from: a, reason: from getter */
    public final int getAdErrorCode() {
        return this.adErrorCode;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAid() {
        return this.aid;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getChannelAppID() {
        return this.channelAppID;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getExtData() {
        return this.extData;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WXMiniSessionData)) {
            return false;
        }
        WXMiniSessionData wXMiniSessionData = (WXMiniSessionData) other;
        if (Intrinsics.areEqual(this.gdtWXMiniData, wXMiniSessionData.gdtWXMiniData) && Intrinsics.areEqual(this.gdtWXMiniJumpConfig, wXMiniSessionData.gdtWXMiniJumpConfig)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final GdtWXMiniJumpConfig.Companion.JumpType getFinalJumpType() {
        return this.finalJumpType;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getHasAuth() {
        return this.hasAuth;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getJumpInside() {
        return this.jumpInside;
    }

    public int hashCode() {
        return (this.gdtWXMiniData.hashCode() * 31) + this.gdtWXMiniJumpConfig.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getJumpSuccess() {
        return this.jumpSuccess;
    }

    /* renamed from: j, reason: from getter */
    public final int getJumpTypeAMS() {
        return this.jumpTypeAMS;
    }

    /* renamed from: k, reason: from getter */
    public final int getJumpTypeQQMC() {
        return this.jumpTypeQQMC;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getOriginId() {
        return this.originId;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final String getPosId() {
        return this.posId;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getReportForLink() {
        return this.reportForLink;
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getUndertake() {
        return this.undertake;
    }

    public final void r(@NotNull GdtWXMiniJumpConfig.Companion.JumpType jumpType) {
        Intrinsics.checkNotNullParameter(jumpType, "<set-?>");
        this.finalJumpType = jumpType;
    }

    public final void s(boolean z16) {
        this.hasAuth = z16;
    }

    public final void t(boolean z16) {
        this.jumpInside = z16;
    }

    @NotNull
    public String toString() {
        return "WXMiniSessionData(gdtWXMiniData=" + this.gdtWXMiniData + ", gdtWXMiniJumpConfig=" + this.gdtWXMiniJumpConfig + ")";
    }

    public final void u(boolean z16) {
        this.jumpSuccess = z16;
    }

    public final void v(boolean z16) {
        this.undertake = z16;
    }
}
