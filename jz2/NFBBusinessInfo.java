package jz2;

import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0019\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u001c\u0010\u0011R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u0011R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\"\u0010\u0011R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u0011R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u0011R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\n\u001a\u0004\b$\u0010\f\"\u0004\b+\u0010\u0011R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\n\u001a\u0004\b\u001e\u0010\f\"\u0004\b-\u0010\u0011\u00a8\u00061"}, d2 = {"Ljz2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "busiId", "b", "c", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "adPosId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "adId", "d", h.F, "o", "itemId", "setActId", GameCenterCommonApiImpl.KEY_ACT_ID, "f", "setBundleName", "bundleName", "g", "j", "setPageName", "pageName", "setDomain", "domain", "i", "l", "setWebVersion", "webVersion", "k", "setPgId", "pgId", "setModuleId", "moduleId", "setFromSrc", "fromSrc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: jz2.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class NFBBusinessInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String busiId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String adPosId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String adId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String itemId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String actId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String bundleName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String pageName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String domain;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String webVersion;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String pgId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String moduleId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String fromSrc;

    public NFBBusinessInfo(@NotNull String busiId, @NotNull String adPosId, @NotNull String adId, @NotNull String itemId, @NotNull String actId, @NotNull String bundleName, @NotNull String pageName, @NotNull String domain, @NotNull String webVersion, @NotNull String pgId, @NotNull String moduleId, @NotNull String fromSrc) {
        Intrinsics.checkNotNullParameter(busiId, "busiId");
        Intrinsics.checkNotNullParameter(adPosId, "adPosId");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(actId, "actId");
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(webVersion, "webVersion");
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Intrinsics.checkNotNullParameter(moduleId, "moduleId");
        Intrinsics.checkNotNullParameter(fromSrc, "fromSrc");
        this.busiId = busiId;
        this.adPosId = adPosId;
        this.adId = adId;
        this.itemId = itemId;
        this.actId = actId;
        this.bundleName = bundleName;
        this.pageName = pageName;
        this.domain = domain;
        this.webVersion = webVersion;
        this.pgId = pgId;
        this.moduleId = moduleId;
        this.fromSrc = fromSrc;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getActId() {
        return this.actId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAdPosId() {
        return this.adPosId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getBundleName() {
        return this.bundleName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getBusiId() {
        return this.busiId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NFBBusinessInfo)) {
            return false;
        }
        NFBBusinessInfo nFBBusinessInfo = (NFBBusinessInfo) other;
        if (Intrinsics.areEqual(this.busiId, nFBBusinessInfo.busiId) && Intrinsics.areEqual(this.adPosId, nFBBusinessInfo.adPosId) && Intrinsics.areEqual(this.adId, nFBBusinessInfo.adId) && Intrinsics.areEqual(this.itemId, nFBBusinessInfo.itemId) && Intrinsics.areEqual(this.actId, nFBBusinessInfo.actId) && Intrinsics.areEqual(this.bundleName, nFBBusinessInfo.bundleName) && Intrinsics.areEqual(this.pageName, nFBBusinessInfo.pageName) && Intrinsics.areEqual(this.domain, nFBBusinessInfo.domain) && Intrinsics.areEqual(this.webVersion, nFBBusinessInfo.webVersion) && Intrinsics.areEqual(this.pgId, nFBBusinessInfo.pgId) && Intrinsics.areEqual(this.moduleId, nFBBusinessInfo.moduleId) && Intrinsics.areEqual(this.fromSrc, nFBBusinessInfo.fromSrc)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getFromSrc() {
        return this.fromSrc;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.busiId.hashCode() * 31) + this.adPosId.hashCode()) * 31) + this.adId.hashCode()) * 31) + this.itemId.hashCode()) * 31) + this.actId.hashCode()) * 31) + this.bundleName.hashCode()) * 31) + this.pageName.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.webVersion.hashCode()) * 31) + this.pgId.hashCode()) * 31) + this.moduleId.hashCode()) * 31) + this.fromSrc.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getModuleId() {
        return this.moduleId;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getPageName() {
        return this.pageName;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getPgId() {
        return this.pgId;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getWebVersion() {
        return this.webVersion;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adPosId = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemId = str;
    }

    @NotNull
    public String toString() {
        return "NFBBusinessInfo(busiId=" + this.busiId + ", adPosId=" + this.adPosId + ", adId=" + this.adId + ", itemId=" + this.itemId + ", actId=" + this.actId + ", bundleName=" + this.bundleName + ", pageName=" + this.pageName + ", domain=" + this.domain + ", webVersion=" + this.webVersion + ", pgId=" + this.pgId + ", moduleId=" + this.moduleId + ", fromSrc=" + this.fromSrc + ')';
    }

    public /* synthetic */ NFBBusinessInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) == 0 ? str12 : "");
    }
}
