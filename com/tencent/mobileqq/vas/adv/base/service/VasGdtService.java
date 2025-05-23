package com.tencent.mobileqq.vas.adv.base.service;

import android.content.Context;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdUtil;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001:\u0002\r\u000bB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\u000e\u001a\u00020\tJ\b\u0010\u0010\u001a\u00020\u000fH$R$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService;", "", "Lcom/tencent/gdtad/aditem/GdtAdLoader$Session;", "gdtSession", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "loaderListenerRef", "Landroid/content/Context;", "contextRef", "", "g", "b", "Ltencent/gdt/qq_ad_get$QQAdGet;", "a", "f", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$b;", "c", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$a;", "Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$a;", "d", "()Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$a;", h.F, "(Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$a;)V", "gdtCallback", "Lkotlin/Lazy;", "e", "()Lcom/tencent/gdtad/aditem/GdtAdLoader$Listener;", "listener", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class VasGdtService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a gdtCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$a;", "", "Ltencent/gdt/qq_ad_get$QQAdGetRsp;", "rsp", "", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void a(@Nullable qq_ad_get.QQAdGetRsp rsp);
    }

    public VasGdtService() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new VasGdtService$listener$2(this));
        this.listener = lazy;
    }

    private final qq_ad_get.QQAdGet a() {
        int collectionSizeOrDefault;
        GdtParams c16 = c();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        qq_ad_get.QQAdGet.ContextInfo contextInfo = qQAdGet.context_info.get();
        if (contextInfo != null) {
            Intrinsics.checkNotNullExpressionValue(contextInfo, "get()");
            Long publicId = c16.getPublicId();
            if (publicId != null) {
                contextInfo.public_id.set(publicId.longValue());
            }
            Long articleId = c16.getArticleId();
            if (articleId != null) {
                contextInfo.article_id.set(articleId.longValue());
            }
            Integer tribeIdTag = c16.getTribeIdTag();
            if (tribeIdTag != null) {
                contextInfo.tribe_tag.set(tribeIdTag.intValue());
            }
            Integer tribeIdTag2 = c16.getTribeIdTag();
            if (tribeIdTag2 != null) {
                contextInfo.tribe_id_tag.set(tribeIdTag2.intValue());
            }
            Integer sourceFrom = c16.getSourceFrom();
            if (sourceFrom != null) {
                contextInfo.source_from.set(sourceFrom.intValue());
            }
        }
        qq_ad_get.QQAdGet.UserInfo userInfo = qQAdGet.user_info.get();
        if (userInfo != null) {
            Intrinsics.checkNotNullExpressionValue(userInfo, "get()");
            userInfo.f435899qq.set(c16.getUin());
        }
        String cookie = c16.getCookie();
        if (cookie != null) {
            qQAdGet.gdt_cookie.set(cookie);
        }
        qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
        qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo shareInfo = positionExt.share_info;
        qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo shareInfo2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
        Integer shareRate = c16.getShareRate();
        if (shareRate != null) {
            shareInfo2.share_rate.set(shareRate.intValue());
        }
        if (c16.getPublicId() != null && c16.getArticleId() != null && c16.getShareRate() != null) {
            shareInfo2.share_check.set(GdtAdUtil.getShareCheck(c16.getPublicId().longValue(), c16.getArticleId().longValue(), c16.getShareRate().intValue()));
        }
        shareInfo.set(shareInfo2);
        positionExt.deep_link_version.set(c16.getDeepLinkVersion());
        Set<String> e16 = c16.e();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : e16) {
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo.pos_id.set(str);
            positionInfo.ad_count.set(c16.getCount());
            positionInfo.pos_ext.set(positionExt);
            arrayList.add(positionInfo);
        }
        qQAdGet.position_info.get().addAll(arrayList);
        return qQAdGet;
    }

    private final GdtAdLoader.Session b() {
        GdtAdLoader.Session session = new GdtAdLoader.Session();
        session.request = a();
        return session;
    }

    private final GdtAdLoader.Listener e() {
        return (GdtAdLoader.Listener) this.listener.getValue();
    }

    private final void g(GdtAdLoader.Session gdtSession, WeakReference<GdtAdLoader.Listener> loaderListenerRef, WeakReference<Context> contextRef) {
        new GdtAdLoader(gdtSession, loaderListenerRef).load(contextRef);
    }

    @NotNull
    protected abstract GdtParams c();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: d, reason: from getter */
    public final a getGdtCallback() {
        return this.gdtCallback;
    }

    public final void f() {
        g(b(), new WeakReference<>(e()), new WeakReference<>(VasAdvSupport.INSTANCE.a().f()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@Nullable a aVar) {
        this.gdtCallback = aVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b.\u0010/J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\n\u0010\u001dR\u0019\u0010$\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010'\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0019\u0010(\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b%\u0010#R\u0019\u0010)\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b \u0010#R\u0019\u0010-\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b\u0010\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/service/VasGdtService$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "j", "()J", "uin", "", "b", "Ljava/util/Set;", "e", "()Ljava/util/Set;", "posIdList", "c", "I", "()I", "count", "d", "deepLinkVersion", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "publicId", "articleId", "g", "Ljava/lang/Integer;", "getTribeTag", "()Ljava/lang/Integer;", "tribeTag", h.F, "i", "tribeIdTag", GetAdInfoRequest.SOURCE_FROM, "shareRate", "k", "Ljava/lang/String;", "()Ljava/lang/String;", "cookie", "<init>", "(JLjava/util/Set;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.base.service.VasGdtService$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class GdtParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Set<String> posIdList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int count;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int deepLinkVersion;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Long publicId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Long articleId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer tribeTag;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer tribeIdTag;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer sourceFrom;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer shareRate;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String cookie;

        public GdtParams(long j3, @NotNull Set<String> posIdList, int i3, int i16, @Nullable Long l3, @Nullable Long l16, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str) {
            Intrinsics.checkNotNullParameter(posIdList, "posIdList");
            this.uin = j3;
            this.posIdList = posIdList;
            this.count = i3;
            this.deepLinkVersion = i16;
            this.publicId = l3;
            this.articleId = l16;
            this.tribeTag = num;
            this.tribeIdTag = num2;
            this.sourceFrom = num3;
            this.shareRate = num4;
            this.cookie = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Long getArticleId() {
            return this.articleId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getCookie() {
            return this.cookie;
        }

        /* renamed from: c, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: d, reason: from getter */
        public final int getDeepLinkVersion() {
            return this.deepLinkVersion;
        }

        @NotNull
        public final Set<String> e() {
            return this.posIdList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GdtParams)) {
                return false;
            }
            GdtParams gdtParams = (GdtParams) other;
            if (this.uin == gdtParams.uin && Intrinsics.areEqual(this.posIdList, gdtParams.posIdList) && this.count == gdtParams.count && this.deepLinkVersion == gdtParams.deepLinkVersion && Intrinsics.areEqual(this.publicId, gdtParams.publicId) && Intrinsics.areEqual(this.articleId, gdtParams.articleId) && Intrinsics.areEqual(this.tribeTag, gdtParams.tribeTag) && Intrinsics.areEqual(this.tribeIdTag, gdtParams.tribeIdTag) && Intrinsics.areEqual(this.sourceFrom, gdtParams.sourceFrom) && Intrinsics.areEqual(this.shareRate, gdtParams.shareRate) && Intrinsics.areEqual(this.cookie, gdtParams.cookie)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final Long getPublicId() {
            return this.publicId;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final Integer getShareRate() {
            return this.shareRate;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final Integer getSourceFrom() {
            return this.sourceFrom;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int a16 = ((((((androidx.fragment.app.a.a(this.uin) * 31) + this.posIdList.hashCode()) * 31) + this.count) * 31) + this.deepLinkVersion) * 31;
            Long l3 = this.publicId;
            int i3 = 0;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            Long l16 = this.articleId;
            if (l16 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = l16.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Integer num = this.tribeTag;
            if (num == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Integer num2 = this.tribeIdTag;
            if (num2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = num2.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            Integer num3 = this.sourceFrom;
            if (num3 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num3.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            Integer num4 = this.shareRate;
            if (num4 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = num4.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str = this.cookie;
            if (str != null) {
                i3 = str.hashCode();
            }
            return i27 + i3;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final Integer getTribeIdTag() {
            return this.tribeIdTag;
        }

        /* renamed from: j, reason: from getter */
        public final long getUin() {
            return this.uin;
        }

        @NotNull
        public String toString() {
            return "GdtParams(uin=" + this.uin + ", posIdList=" + this.posIdList + ", count=" + this.count + ", deepLinkVersion=" + this.deepLinkVersion + ", publicId=" + this.publicId + ", articleId=" + this.articleId + ", tribeTag=" + this.tribeTag + ", tribeIdTag=" + this.tribeIdTag + ", sourceFrom=" + this.sourceFrom + ", shareRate=" + this.shareRate + ", cookie=" + this.cookie + ')';
        }

        public /* synthetic */ GdtParams(long j3, Set set, int i3, int i16, Long l3, Long l16, Integer num, Integer num2, Integer num3, Integer num4, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, set, (i17 & 4) != 0 ? 1 : i3, (i17 & 8) != 0 ? 1 : i16, (i17 & 16) != 0 ? null : l3, (i17 & 32) != 0 ? null : l16, (i17 & 64) != 0 ? null : num, (i17 & 128) != 0 ? null : num2, (i17 & 256) != 0 ? null : num3, (i17 & 512) != 0 ? null : num4, (i17 & 1024) != 0 ? null : str);
        }
    }
}
