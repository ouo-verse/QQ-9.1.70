package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommThirdShareInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommThirdVideoInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextGroupContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextTencentDocsContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdPlatform;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneRequestEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl1.a;
import qj1.l;
import qj1.q;
import qj1.r;
import qj1.t;
import qj1.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u0005\u001a\u00020\u0004Jj\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00020\u00122\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020!R\u0014\u0010$\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool;", "", "Lqj1/l;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "raw", "", "Lqj1/r;", tl.h.F, "g", "Lqj1/q;", "e", "Lqj1/t;", "f", "Lqj1/u;", "i", "TImage", "TVideo", "Lkotlin/Function1;", "imageConverter", "videoConverter", "images", "videos", "", "mediaNum", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "src", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "j", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProImage;", "k", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVideo;", "l", "Lqj1/l;", "EMPTY_MEDIA_DISPLAYABLE", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedMixedMediaDataCompatTool {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedMixedMediaDataCompatTool f221103a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final l EMPTY_MEDIA_DISPLAYABLE;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\b\"\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$a;", "Lqj1/l;", "", "toString", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "raw", "<init>", "(Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static abstract class a implements l {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object raw;

        public a(@NotNull Object raw) {
            Intrinsics.checkNotNullParameter(raw, "raw");
            this.raw = raw;
        }

        @Override // qj1.l
        @NotNull
        /* renamed from: a, reason: from getter */
        public Object getRaw() {
            return this.raw;
        }

        @NotNull
        public String toString() {
            return "MixedMediaData[ index: " + getDisplayIndex() + ", picUrl: " + getPicUrl() + ", width = " + getWidth() + ", height = " + getHeight() + ", type = " + getType() + " ]";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((l) t16).getDisplayIndex()), Integer.valueOf(((l) t17).getDisplayIndex()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$d", "Lqj1/q;", "", "a", "Ljava/lang/String;", "getThumbUrl", "()Ljava/lang/String;", "thumbUrl", "b", "getTitle", "title", "c", "abstract", "d", "getRedirectUrl", "redirectUrl", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements q {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String thumbUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String abstract;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String redirectUrl;

        d(GProCommThirdShareInfo gProCommThirdShareInfo) {
            String str = gProCommThirdShareInfo.imageUrl;
            Intrinsics.checkNotNullExpressionValue(str, "sharedInfo.imageUrl");
            this.thumbUrl = str;
            String str2 = gProCommThirdShareInfo.title;
            Intrinsics.checkNotNullExpressionValue(str2, "sharedInfo.title");
            this.title = str2;
            String str3 = gProCommThirdShareInfo.stringAbstract;
            Intrinsics.checkNotNullExpressionValue(str3, "sharedInfo.stringAbstract");
            this.abstract = str3;
            String str4 = gProCommThirdShareInfo.redirectUrl;
            Intrinsics.checkNotNullExpressionValue(str4, "sharedInfo.redirectUrl");
            this.redirectUrl = str4;
        }

        @Override // qj1.q
        @NotNull
        /* renamed from: a, reason: from getter */
        public String getAbstract() {
            return this.abstract;
        }

        @Override // qj1.q
        @NotNull
        public String getRedirectUrl() {
            return this.redirectUrl;
        }

        @Override // qj1.q
        @NotNull
        public String getThumbUrl() {
            return this.thumbUrl;
        }

        @Override // qj1.q
        @NotNull
        public String getTitle() {
            return this.title;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0018\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0003\u0010\fR\u001a\u0010\u001b\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\fR\u001a\u0010\u001e\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\u00a8\u0006\u001f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$e", "Lqj1/t;", "", "a", "I", "getUrlType", "()I", "urlType", "", "b", "Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/String;", "coverUrl", "", "c", "J", "getDuration", "()J", "duration", "d", "getJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "e", "platformIconUrl", "f", "getPlatformName", "platformName", "g", "getTitle", "title", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements t {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int urlType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String coverUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String jumpUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String platformIconUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String platformName;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        e(GProStRichTextContent gProStRichTextContent, GProCommThirdVideoInfo gProCommThirdVideoInfo, GProThirdPlatform gProThirdPlatform) {
            String str;
            String str2;
            this.urlType = gProStRichTextContent.urlContent.type;
            String str3 = gProCommThirdVideoInfo.cover;
            Intrinsics.checkNotNullExpressionValue(str3, "videoInfo.cover");
            this.coverUrl = str3;
            this.duration = gProCommThirdVideoInfo.duration;
            if (gProStRichTextContent.urlContent.type == 7) {
                str = gProCommThirdVideoInfo.jumpUrl;
                str2 = "videoInfo.jumpUrl";
            } else {
                str = gProCommThirdVideoInfo.pcJumpUrl;
                str2 = "videoInfo.pcJumpUrl";
            }
            Intrinsics.checkNotNullExpressionValue(str, str2);
            this.jumpUrl = str;
            String str4 = gProThirdPlatform.icon;
            Intrinsics.checkNotNullExpressionValue(str4, "platformInfo.icon");
            this.platformIconUrl = str4;
            String str5 = gProThirdPlatform.name;
            Intrinsics.checkNotNullExpressionValue(str5, "platformInfo.name");
            this.platformName = str5;
            String str6 = gProStRichTextContent.urlContent.displayText;
            Intrinsics.checkNotNullExpressionValue(str6, "richText.urlContent.displayText");
            this.title = str6;
        }

        @Override // qj1.t
        @NotNull
        /* renamed from: a, reason: from getter */
        public String getPlatformIconUrl() {
            return this.platformIconUrl;
        }

        @Override // qj1.t
        @NotNull
        public String getCoverUrl() {
            return this.coverUrl;
        }

        @Override // qj1.t
        public long getDuration() {
            return this.duration;
        }

        @Override // qj1.t
        @NotNull
        public String getJumpUrl() {
            return this.jumpUrl;
        }

        @Override // qj1.t
        @NotNull
        public String getPlatformName() {
            return this.platformName;
        }

        @Override // qj1.t
        public int getUrlType() {
            return this.urlType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$f", "", "", "a", "Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/String;", "coverUrl", "b", "getTitle", "title", "c", "getIcon", "icon", "d", "getPlatformName", "platformName", "e", "getPermission", QCircleDaTongConstant.ElementParamValue.PERMISSION, "f", "getUrl", "url", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String coverUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String icon;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String platformName;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String permission;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        f(GProStRichTextTencentDocsContent gProStRichTextTencentDocsContent, GProStRichTextURLContent gProStRichTextURLContent) {
            String str = gProStRichTextTencentDocsContent.url;
            Intrinsics.checkNotNullExpressionValue(str, "tencentDoc.url");
            this.coverUrl = str;
            String str2 = gProStRichTextTencentDocsContent.title;
            Intrinsics.checkNotNullExpressionValue(str2, "tencentDoc.title");
            this.title = str2;
            String str3 = gProStRichTextTencentDocsContent.icon;
            Intrinsics.checkNotNullExpressionValue(str3, "tencentDoc.icon");
            this.icon = str3;
            String str4 = gProStRichTextTencentDocsContent.platformName;
            Intrinsics.checkNotNullExpressionValue(str4, "tencentDoc.platformName");
            this.platformName = str4;
            String str5 = gProStRichTextTencentDocsContent.permission;
            Intrinsics.checkNotNullExpressionValue(str5, "tencentDoc.permission");
            this.permission = str5;
            String str6 = gProStRichTextURLContent.url;
            Intrinsics.checkNotNullExpressionValue(str6, "urlContent.url");
            this.url = str6;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$g", "Lqj1/r;", "", "a", "Ljava/lang/String;", QZoneRequestEncoder.KEY_COVER_REQ, "()Ljava/lang/String;", "cover", "", "b", "J", "getDuration", "()J", "duration", "c", "getIcon", "icon", "d", "getPlatformName", "platformName", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g implements r {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String cover;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final long duration;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String icon;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String platformName;

        g(GProStRichTextURLContent gProStRichTextURLContent) {
            String str = gProStRichTextURLContent.thirdVideoInfo.cover;
            Intrinsics.checkNotNullExpressionValue(str, "urlContent.thirdVideoInfo.cover");
            this.cover = str;
            this.duration = gProStRichTextURLContent.thirdVideoInfo.duration;
            String str2 = gProStRichTextURLContent.thirdPlatform.icon;
            Intrinsics.checkNotNullExpressionValue(str2, "urlContent.thirdPlatform.icon");
            this.icon = str2;
            String str3 = gProStRichTextURLContent.thirdPlatform.name;
            Intrinsics.checkNotNullExpressionValue(str3, "urlContent.thirdPlatform.name");
            this.platformName = str3;
        }

        @Override // qj1.r
        @NotNull
        public String getCover() {
            return this.cover;
        }

        @Override // qj1.r
        public long getDuration() {
            return this.duration;
        }

        @Override // qj1.r
        @NotNull
        public String getIcon() {
            return this.icon;
        }

        @Override // qj1.r
        @NotNull
        public String getPlatformName() {
            return this.platformName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$h", "Lqj1/u;", "", "getGroupName", "()Ljava/lang/String;", "groupName", "getGroupAvatar", "groupAvatar", "getGroupJoinAuth", "groupJoinAuth", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h implements u {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GProStRichTextGroupContent f221127a;

        h(GProStRichTextGroupContent gProStRichTextGroupContent) {
            this.f221127a = gProStRichTextGroupContent;
        }

        @Override // qj1.u
        @NotNull
        public String getGroupAvatar() {
            String str = this.f221127a.groupAvatar;
            Intrinsics.checkNotNullExpressionValue(str, "groupContent.groupAvatar");
            return str;
        }

        @Override // qj1.u
        @NotNull
        public String getGroupJoinAuth() {
            String str = this.f221127a.groupJoinAuth;
            Intrinsics.checkNotNullExpressionValue(str, "groupContent.groupJoinAuth");
            return str;
        }

        @Override // qj1.u
        @NotNull
        public String getGroupName() {
            String str = this.f221127a.groupName;
            Intrinsics.checkNotNullExpressionValue(str, "groupContent.groupName");
            return str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\n\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$i", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$a;", "", "getThumbUrl", "()Ljava/lang/String;", "thumbUrl", "getPicUrl", "picUrl", "", "getDisplayIndex", "()I", "displayIndex", "getWidth", "width", "getHeight", "height", "getType", "type", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class i extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GProStVideo f221128b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(GProStVideo gProStVideo) {
            super(gProStVideo);
            this.f221128b = gProStVideo;
        }

        @Override // qj1.l
        public int getDisplayIndex() {
            return this.f221128b.displayIndex;
        }

        @Override // qj1.l
        public int getHeight() {
            return this.f221128b.height;
        }

        @Override // qj1.l
        @NotNull
        public String getPicUrl() {
            GProStImage gProStImage = this.f221128b.cover;
            Intrinsics.checkNotNullExpressionValue(gProStImage, "src.cover");
            return pl1.a.g(gProStImage);
        }

        @Override // qj1.l
        @Nullable
        public String getThumbUrl() {
            GProStImage gProStImage = this.f221128b.cover;
            Intrinsics.checkNotNullExpressionValue(gProStImage, "src.cover");
            return pl1.a.g(gProStImage);
        }

        @Override // qj1.l
        public int getType() {
            return 2;
        }

        @Override // qj1.l
        public int getWidth() {
            return this.f221128b.width;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\n\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$j", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$a;", "", "getThumbUrl", "()Ljava/lang/String;", "thumbUrl", "getPicUrl", "picUrl", "", "getDisplayIndex", "()I", "displayIndex", "getWidth", "width", "getHeight", "height", "getType", "type", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class j extends a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGProVideo f221129b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(IGProVideo iGProVideo) {
            super(iGProVideo);
            this.f221129b = iGProVideo;
        }

        @Override // qj1.l
        public int getDisplayIndex() {
            return this.f221129b.getDisplayIndex();
        }

        @Override // qj1.l
        public int getHeight() {
            return this.f221129b.getHeight();
        }

        @Override // qj1.l
        @NotNull
        public String getPicUrl() {
            IGProImage cover = this.f221129b.getCover();
            Intrinsics.checkNotNullExpressionValue(cover, "src.cover");
            return com.tencent.mobileqq.guild.discoveryv2.util.e.d(cover);
        }

        @Override // qj1.l
        @Nullable
        public String getThumbUrl() {
            IGProImage cover = this.f221129b.getCover();
            Intrinsics.checkNotNullExpressionValue(cover, "src.cover");
            return com.tencent.mobileqq.guild.discoveryv2.util.e.d(cover);
        }

        @Override // qj1.l
        public int getType() {
            return 2;
        }

        @Override // qj1.l
        public int getWidth() {
            return this.f221129b.getWidth();
        }
    }

    static {
        FeedMixedMediaDataCompatTool feedMixedMediaDataCompatTool = new FeedMixedMediaDataCompatTool();
        f221103a = feedMixedMediaDataCompatTool;
        EMPTY_MEDIA_DISPLAYABLE = feedMixedMediaDataCompatTool.a();
    }

    FeedMixedMediaDataCompatTool() {
    }

    private final l a() {
        return new b(new Object());
    }

    public static /* synthetic */ List c(FeedMixedMediaDataCompatTool feedMixedMediaDataCompatTool, Function1 function1, Function1 function12, List list, List list2, int i3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            i3 = -1;
        }
        return feedMixedMediaDataCompatTool.b(function1, function12, list, list2, i3);
    }

    @NotNull
    public final <TImage, TVideo> List<l> b(@NotNull Function1<? super TImage, ? extends l> imageConverter, @NotNull Function1<? super TVideo, ? extends l> videoConverter, @Nullable List<? extends TImage> images, @Nullable List<? extends TVideo> videos, int mediaNum) {
        Intrinsics.checkNotNullParameter(imageConverter, "imageConverter");
        Intrinsics.checkNotNullParameter(videoConverter, "videoConverter");
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            Iterator<T> it = images.iterator();
            while (it.hasNext()) {
                arrayList.add(imageConverter.invoke((Object) it.next()));
            }
        }
        if (videos != null) {
            Iterator<T> it5 = videos.iterator();
            while (it5.hasNext()) {
                arrayList.add(videoConverter.invoke((Object) it5.next()));
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new c());
        }
        int size = mediaNum - arrayList.size();
        if (mediaNum > 0 && size > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(EMPTY_MEDIA_DISPLAYABLE);
            }
        }
        return arrayList;
    }

    @NotNull
    public final l d(@NotNull final GProStImage src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return new a() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool$newGProStImageMediaDataReader$1

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy picSize;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(GProStImage.this);
                Lazy lazy;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool$newGProStImageMediaDataReader$1$picSize$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Pair<? extends Integer, ? extends Integer> invoke() {
                        return a.f(GProStImage.this);
                    }
                });
                this.picSize = lazy;
            }

            private final Pair<Integer, Integer> b() {
                return (Pair) this.picSize.getValue();
            }

            @Override // qj1.l
            public int getDisplayIndex() {
                return GProStImage.this.displayIndex;
            }

            @Override // qj1.l
            public int getHeight() {
                return b().getSecond().intValue();
            }

            @Override // qj1.l
            @NotNull
            public String getPicUrl() {
                return a.d(GProStImage.this);
            }

            @Override // qj1.l
            @NotNull
            public String getThumbUrl() {
                return a.g(GProStImage.this);
            }

            @Override // qj1.l
            public int getType() {
                if (GProStImage.this.isGif) {
                    return 3;
                }
                return 1;
            }

            @Override // qj1.l
            public int getWidth() {
                return b().getFirst().intValue();
            }
        };
    }

    @NotNull
    public final List<q> e(@NotNull GProStFeed raw) {
        boolean z16;
        GProStRichTextURLContent gProStRichTextURLContent;
        GProCommThirdShareInfo gProCommThirdShareInfo;
        Intrinsics.checkNotNullParameter(raw, "raw");
        ArrayList<GProStRichTextContent> arrayList = raw.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "raw.contents.contents");
        ArrayList arrayList2 = new ArrayList();
        for (GProStRichTextContent gProStRichTextContent : arrayList) {
            if (gProStRichTextContent.type == 3 && gProStRichTextContent.urlContent.type == 6) {
                z16 = true;
            } else {
                z16 = false;
            }
            d dVar = null;
            if (!z16) {
                gProStRichTextContent = null;
            }
            if (gProStRichTextContent != null && (gProStRichTextURLContent = gProStRichTextContent.urlContent) != null && (gProCommThirdShareInfo = gProStRichTextURLContent.thirdShareInfo) != null) {
                dVar = new d(gProCommThirdShareInfo);
            }
            if (dVar != null) {
                arrayList2.add(dVar);
            }
        }
        return arrayList2;
    }

    @NotNull
    public final List<t> f(@NotNull GProStFeed raw) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(raw, "raw");
        ArrayList<GProStRichTextContent> arrayList = raw.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "raw.contents.contents");
        ArrayList arrayList2 = new ArrayList();
        for (GProStRichTextContent gProStRichTextContent : arrayList) {
            if (gProStRichTextContent.type == 3 && ((i3 = gProStRichTextContent.urlContent.type) == 7 || i3 == 9 || i3 == 8)) {
                z16 = true;
            } else {
                z16 = false;
            }
            e eVar = null;
            if (!z16) {
                gProStRichTextContent = null;
            }
            if (gProStRichTextContent != null) {
                GProStRichTextURLContent gProStRichTextURLContent = gProStRichTextContent.urlContent;
                eVar = new e(gProStRichTextContent, gProStRichTextURLContent.thirdVideoInfo, gProStRichTextURLContent.thirdPlatform);
            }
            if (eVar != null) {
                arrayList2.add(eVar);
            }
        }
        return arrayList2;
    }

    @NotNull
    public final List<Object> g(@NotNull GProStFeed raw) {
        boolean z16;
        GProStRichTextURLContent gProStRichTextURLContent;
        Intrinsics.checkNotNullParameter(raw, "raw");
        ArrayList<GProStRichTextContent> arrayList = raw.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "raw.contents.contents");
        ArrayList arrayList2 = new ArrayList();
        for (GProStRichTextContent gProStRichTextContent : arrayList) {
            if (gProStRichTextContent.type == 3 && gProStRichTextContent.urlContent.type == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            f fVar = null;
            if (!z16) {
                gProStRichTextContent = null;
            }
            if (gProStRichTextContent != null && (gProStRichTextURLContent = gProStRichTextContent.urlContent) != null) {
                fVar = new f(gProStRichTextURLContent.getTencentDocsContent(), gProStRichTextURLContent);
            }
            if (fVar != null) {
                arrayList2.add(fVar);
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
    
        if (r1.urlContent.type == 1) goto L11;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<r> h(@NotNull GProStFeed raw) {
        boolean z16;
        GProStRichTextURLContent gProStRichTextURLContent;
        Intrinsics.checkNotNullParameter(raw, "raw");
        ArrayList<GProStRichTextContent> arrayList = raw.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "raw.contents.contents");
        ArrayList arrayList2 = new ArrayList();
        for (GProStRichTextContent gProStRichTextContent : arrayList) {
            if (gProStRichTextContent.type == 3) {
                z16 = true;
            }
            z16 = false;
            g gVar = null;
            if (!z16) {
                gProStRichTextContent = null;
            }
            if (gProStRichTextContent != null && (gProStRichTextURLContent = gProStRichTextContent.urlContent) != null) {
                gVar = new g(gProStRichTextURLContent);
            }
            if (gVar != null) {
                arrayList2.add(gVar);
            }
        }
        return arrayList2;
    }

    @NotNull
    public final List<u> i(@NotNull GProStFeed raw) {
        boolean z16;
        GProStRichTextGroupContent gProStRichTextGroupContent;
        Intrinsics.checkNotNullParameter(raw, "raw");
        ArrayList<GProStRichTextContent> arrayList = raw.contents.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "raw.contents.contents");
        ArrayList arrayList2 = new ArrayList();
        for (GProStRichTextContent gProStRichTextContent : arrayList) {
            if (gProStRichTextContent.type == 9) {
                z16 = true;
            } else {
                z16 = false;
            }
            h hVar = null;
            if (!z16) {
                gProStRichTextContent = null;
            }
            if (gProStRichTextContent != null && (gProStRichTextGroupContent = gProStRichTextContent.groupContent) != null) {
                hVar = new h(gProStRichTextGroupContent);
            }
            if (hVar != null) {
                arrayList2.add(hVar);
            }
        }
        return arrayList2;
    }

    @NotNull
    public final l j(@NotNull GProStVideo src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return new i(src);
    }

    @NotNull
    public final l k(@NotNull IGProImage src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return new FeedMixedMediaDataCompatTool$newIGProImageMediaDataReader$1(src);
    }

    @NotNull
    public final l l(@NotNull IGProVideo src) {
        Intrinsics.checkNotNullParameter(src, "src");
        return new j(src);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/pic/data/FeedMixedMediaDataCompatTool$a;", "", "getPicUrl", "()Ljava/lang/String;", "picUrl", "", "getDisplayIndex", "()I", "displayIndex", "getWidth", "width", "getHeight", "height", "getType", "type", "", "a", "()Ljava/lang/Object;", "raw", "getThumbUrl", "thumbUrl", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends a {
        b(Object obj) {
            super(obj);
        }

        @Override // qj1.l
        public int getDisplayIndex() {
            return -1;
        }

        @Override // qj1.l
        public int getHeight() {
            return 0;
        }

        @Override // qj1.l
        @NotNull
        public String getPicUrl() {
            return " ";
        }

        @Override // qj1.l
        @Nullable
        public String getThumbUrl() {
            return " ";
        }

        @Override // qj1.l
        public int getType() {
            return 1;
        }

        @Override // qj1.l
        public int getWidth() {
            return 0;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool.a, qj1.l
        @NotNull
        /* renamed from: a */
        public Object getRaw() {
            return this;
        }
    }
}
