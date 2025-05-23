package e40;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b$\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\nBW\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0004\u0012\b\b\u0002\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b!\u0010\u0015R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\n\u0010\u0013\"\u0004\b#\u0010\u0015R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u0004\b&\u0010\u0015\u00a8\u0006*"}, d2 = {"Le40/a;", "", "", "i", "", "toString", "", "hashCode", "other", "equals", "a", "Z", "b", "()Z", "k", "(Z)V", "hasInfo", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "icon", "g", "p", "title", "d", "f", "o", "subtitle", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, WadlProxyConsts.KEY_JUMP_URL, DomainData.DOMAIN_NAME, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "j", "adId", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e40.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSFeedBubbleInfo {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean hasInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String subtitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String showType;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String adId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String traceInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Le40/a$a;", "", "", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "lst", "Le40/a;", "bubbleInfo", "", "b", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "a", "", "KEY_ICON", "Ljava/lang/String;", "KEY_JUMP_URL", "KEY_SHOW_TYPE", "KEY_SUB_TITLE", "KEY_TITLE", "SHOW_TYPE_MATERIAL", "SHOW_TYPE_NEW_USER", "SHOW_TYPE_RELATION", "SHOW_TYPE_SAY_HI", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e40.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(List<TianShuAccess.AdItem> lst, QFSFeedBubbleInfo bubbleInfo) {
            boolean z16;
            List<TianShuAccess.AdItem> list = lst;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            TianShuAccess.AdItem adItem = lst.get(0);
            bubbleInfo.k(true);
            bubbleInfo.j(String.valueOf(adItem.iAdId.get()));
            String str = adItem.traceinfo.get();
            Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
            bubbleInfo.q(str);
            List<TianShuAccess.MapEntry> list2 = adItem.argList.get();
            Intrinsics.checkNotNullExpressionValue(list2, "adItem.argList.get()");
            for (TianShuAccess.MapEntry mapEntry : list2) {
                String str2 = mapEntry.key.get();
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1903312068:
                            if (str2.equals("show_type")) {
                                String str3 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str3, "it.value.get()");
                                bubbleInfo.n(str3);
                                break;
                            } else {
                                break;
                            }
                        case -254991906:
                            if (str2.equals("jump_url")) {
                                String str4 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str4, "it.value.get()");
                                bubbleInfo.m(str4);
                                break;
                            } else {
                                break;
                            }
                        case -42298471:
                            if (str2.equals("sub_title")) {
                                String str5 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str5, "it.value.get()");
                                bubbleInfo.o(str5);
                                break;
                            } else {
                                break;
                            }
                        case 3226745:
                            if (str2.equals("icon")) {
                                String str6 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str6, "it.value.get()");
                                bubbleInfo.l(str6);
                                break;
                            } else {
                                break;
                            }
                        case 110371416:
                            if (str2.equals("title")) {
                                String str7 = mapEntry.value.get();
                                Intrinsics.checkNotNullExpressionValue(str7, "it.value.get()");
                                bubbleInfo.p(str7);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }

        @NotNull
        public final QFSFeedBubbleInfo a(@NotNull TianShuAccess.GetAdsRsp getAdsRsp) {
            Intrinsics.checkNotNullParameter(getAdsRsp, "getAdsRsp");
            QFSFeedBubbleInfo qFSFeedBubbleInfo = new QFSFeedBubbleInfo(false, null, null, null, null, null, null, null, 255, null);
            List<TianShuAccess.RspEntry> mapAds = getAdsRsp.mapAds.get();
            Intrinsics.checkNotNullExpressionValue(mapAds, "mapAds");
            for (TianShuAccess.RspEntry rspEntry : mapAds) {
                if (rspEntry.key.get() == 1060) {
                    Companion companion = QFSFeedBubbleInfo.INSTANCE;
                    List<TianShuAccess.AdItem> list = rspEntry.value.lst.get();
                    Intrinsics.checkNotNullExpressionValue(list, "it.value.lst.get()");
                    companion.b(list, qFSFeedBubbleInfo);
                }
            }
            return qFSFeedBubbleInfo;
        }

        Companion() {
        }
    }

    public QFSFeedBubbleInfo() {
        this(false, null, null, null, null, null, null, null, 255, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasInfo() {
        return this.hasInfo;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getShowType() {
        return this.showType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSFeedBubbleInfo)) {
            return false;
        }
        QFSFeedBubbleInfo qFSFeedBubbleInfo = (QFSFeedBubbleInfo) other;
        if (this.hasInfo == qFSFeedBubbleInfo.hasInfo && Intrinsics.areEqual(this.icon, qFSFeedBubbleInfo.icon) && Intrinsics.areEqual(this.title, qFSFeedBubbleInfo.title) && Intrinsics.areEqual(this.subtitle, qFSFeedBubbleInfo.subtitle) && Intrinsics.areEqual(this.jumpUrl, qFSFeedBubbleInfo.jumpUrl) && Intrinsics.areEqual(this.showType, qFSFeedBubbleInfo.showType) && Intrinsics.areEqual(this.adId, qFSFeedBubbleInfo.adId) && Intrinsics.areEqual(this.traceInfo, qFSFeedBubbleInfo.traceInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public int hashCode() {
        boolean z16 = this.hasInfo;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((((((((((((r06 * 31) + this.icon.hashCode()) * 31) + this.title.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.showType.hashCode()) * 31) + this.adId.hashCode()) * 31) + this.traceInfo.hashCode();
    }

    public final boolean i() {
        if (!Intrinsics.areEqual(WadlProxyConsts.KEY_MATERIAL, this.showType) && !Intrinsics.areEqual("new_user", this.showType) && !Intrinsics.areEqual("relation", this.showType)) {
            return false;
        }
        return true;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adId = str;
    }

    public final void k(boolean z16) {
        this.hasInfo = z16;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.showType = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceInfo = str;
    }

    @NotNull
    public String toString() {
        return "QFSFeedBubbleInfo(hasInfo=" + this.hasInfo + ", icon=" + this.icon + ", title=" + this.title + ", subtitle=" + this.subtitle + ", jumpUrl=" + this.jumpUrl + ", showType=" + this.showType + ", adId=" + this.adId + ", traceInfo=" + this.traceInfo + ")";
    }

    public QFSFeedBubbleInfo(boolean z16, @NotNull String icon, @NotNull String title, @NotNull String subtitle, @NotNull String jumpUrl, @NotNull String showType, @NotNull String adId, @NotNull String traceInfo) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(showType, "showType");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        this.hasInfo = z16;
        this.icon = icon;
        this.title = title;
        this.subtitle = subtitle;
        this.jumpUrl = jumpUrl;
        this.showType = showType;
        this.adId = adId;
        this.traceInfo = traceInfo;
    }

    public /* synthetic */ QFSFeedBubbleInfo(boolean z16, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) == 0 ? str7 : "");
    }
}
