package com.tencent.biz.qqcircle.immersive.personal.publishguide;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudPubGuideSvr$AdsInfo;
import feedcloud.FeedCloudPubGuideSvr$AdsItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;", "a", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;", "b", "()Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;", "bannerStyle", "", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/a;", "Ljava/util/List;", "()Ljava/util/List;", "bannerInfos", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/BannerStyle;Ljava/util/List;)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.publishguide.g, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PublishGuideData {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final BannerStyle bannerStyle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<BannerInfo> bannerInfos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g$a;", "", "Lfeedcloud/FeedCloudPubGuideSvr$AdsInfo;", "adsInfo", "Lcom/tencent/biz/qqcircle/immersive/personal/publishguide/g;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.publishguide.g$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x00ac, code lost:
        
            if (r14 != null) goto L18;
         */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final PublishGuideData a(@Nullable FeedCloudPubGuideSvr$AdsInfo adsInfo) {
            BannerStyle a16;
            List arrayList;
            int collectionSizeOrDefault;
            if (adsInfo == null || (a16 = BannerStyle.INSTANCE.a(Integer.valueOf(adsInfo.style.get()))) != BannerStyle.SIDESLIP) {
                return null;
            }
            List<FeedCloudPubGuideSvr$AdsItem> list = adsInfo.ads_items.get();
            if (list != null) {
                List<FeedCloudPubGuideSvr$AdsItem> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (FeedCloudPubGuideSvr$AdsItem feedCloudPubGuideSvr$AdsItem : list2) {
                    String str = feedCloudPubGuideSvr$AdsItem.f398467id.get();
                    Intrinsics.checkNotNullExpressionValue(str, "it.id.get()");
                    String str2 = feedCloudPubGuideSvr$AdsItem.title.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "it.title.get()");
                    String str3 = feedCloudPubGuideSvr$AdsItem.desc.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "it.desc.get()");
                    String str4 = feedCloudPubGuideSvr$AdsItem.back_img.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "it.back_img.get()");
                    String str5 = feedCloudPubGuideSvr$AdsItem.jump_url.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "it.jump_url.get()");
                    String str6 = feedCloudPubGuideSvr$AdsItem.button_text.get();
                    Intrinsics.checkNotNullExpressionValue(str6, "it.button_text.get()");
                    String str7 = feedCloudPubGuideSvr$AdsItem.material_id.get();
                    Intrinsics.checkNotNullExpressionValue(str7, "it.material_id.get()");
                    String str8 = feedCloudPubGuideSvr$AdsItem.icon_url.get();
                    Intrinsics.checkNotNullExpressionValue(str8, "it.icon_url.get()");
                    arrayList2.add(new BannerInfo(str, str2, str3, str4, str5, str6, str7, str8));
                }
                arrayList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
            }
            arrayList = new ArrayList();
            PublishGuideData publishGuideData = new PublishGuideData(a16, arrayList);
            QLog.i("QFSPublishGuide", 1, "[PublishGuideData] " + publishGuideData);
            return publishGuideData;
        }

        Companion() {
        }
    }

    public PublishGuideData(@NotNull BannerStyle bannerStyle, @NotNull List<BannerInfo> bannerInfos) {
        Intrinsics.checkNotNullParameter(bannerStyle, "bannerStyle");
        Intrinsics.checkNotNullParameter(bannerInfos, "bannerInfos");
        this.bannerStyle = bannerStyle;
        this.bannerInfos = bannerInfos;
    }

    @NotNull
    public final List<BannerInfo> a() {
        return this.bannerInfos;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final BannerStyle getBannerStyle() {
        return this.bannerStyle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishGuideData)) {
            return false;
        }
        PublishGuideData publishGuideData = (PublishGuideData) other;
        if (this.bannerStyle == publishGuideData.bannerStyle && Intrinsics.areEqual(this.bannerInfos, publishGuideData.bannerInfos)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.bannerStyle.hashCode() * 31) + this.bannerInfos.hashCode();
    }

    @NotNull
    public String toString() {
        return "PublishGuideData(bannerStyle=" + this.bannerStyle + ", bannerInfos=" + this.bannerInfos + ")";
    }
}
