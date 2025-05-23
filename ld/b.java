package ld;

import com.qzone.reborn.feedpro.banner.hotbanner.constant.FeedProHotBannerType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u0011\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lld/b;", "", "Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", "a", "Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", "b", "()Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;", "e", "(Lcom/qzone/reborn/feedpro/banner/hotbanner/constant/FeedProHotBannerType;)V", WadlProxyConsts.BANNER_TYPE, "", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "bannerText", "", "c", "I", "getPriority", "()I", "g", "(I)V", "priority", "getCoverAlpha", "setCoverAlpha", "coverAlpha", "", "Lld/a;", "Ljava/util/List;", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "bannerUserList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int priority;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<a> bannerUserList;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FeedProHotBannerType bannerType = FeedProHotBannerType.TYPE_UNKNOWN;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String bannerText = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int coverAlpha = 255;

    /* renamed from: a, reason: from getter */
    public final String getBannerText() {
        return this.bannerText;
    }

    /* renamed from: b, reason: from getter */
    public final FeedProHotBannerType getBannerType() {
        return this.bannerType;
    }

    public final List<a> c() {
        return this.bannerUserList;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerText = str;
    }

    public final void e(FeedProHotBannerType feedProHotBannerType) {
        Intrinsics.checkNotNullParameter(feedProHotBannerType, "<set-?>");
        this.bannerType = feedProHotBannerType;
    }

    public final void f(List<a> list) {
        this.bannerUserList = list;
    }

    public final void g(int i3) {
        this.priority = i3;
    }
}
