package com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.component.qrcode.d;
import com.tencent.mobileqq.component.qrcode.e;
import com.tencent.mobileqq.component.qrcode.f;
import com.tencent.mobileqq.component.qrcode.g;
import com.tencent.mobileqq.component.qrcode.i;
import com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureAsyncWorkManager;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.quiprofile.GuildContextWrapper;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import x12.n;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJg\u0010&\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00042O\u0010%\u001aK\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010#\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001dJ\u000e\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureGenerator;", "", "Lx12/n;", "binding", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureGenerator$a;", "param", "", h.F, "g", "k", "", "timeNs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "", "", "Lcom/tencent/mobileqq/component/qrcode/d;", "l", "", "Lcom/tencent/mobileqq/component/qrcode/f;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "feedViewContainer", "", "o", "(Lx12/n;Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureGenerator$a;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isAllAsyncResourcesOk", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "onResult", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", CommonConstant.KEY_QR_CODE, "p", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildLongFeedPictureGenerator {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildLongFeedPictureGenerator f220341a = new GuildLongFeedPictureGenerator();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u0013\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureGenerator$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "b", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "shareUrl", "Z", "e", "()Z", "isXHS", "", "J", "()J", "maxWaitTime", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;Ljava/lang/String;ZJ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class GeneratorParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGProGuildInfo guildInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GProStFeed feedInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String shareUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isXHS;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long maxWaitTime;

        public GeneratorParam(@NotNull IGProGuildInfo guildInfo, @NotNull GProStFeed feedInfo, @NotNull String shareUrl, boolean z16, long j3) {
            Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
            Intrinsics.checkNotNullParameter(feedInfo, "feedInfo");
            Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
            this.guildInfo = guildInfo;
            this.feedInfo = feedInfo;
            this.shareUrl = shareUrl;
            this.isXHS = z16;
            this.maxWaitTime = j3;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final GProStFeed getFeedInfo() {
            return this.feedInfo;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        /* renamed from: c, reason: from getter */
        public final long getMaxWaitTime() {
            return this.maxWaitTime;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getShareUrl() {
            return this.shareUrl;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsXHS() {
            return this.isXHS;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GeneratorParam)) {
                return false;
            }
            GeneratorParam generatorParam = (GeneratorParam) other;
            if (Intrinsics.areEqual(this.guildInfo, generatorParam.guildInfo) && Intrinsics.areEqual(this.feedInfo, generatorParam.feedInfo) && Intrinsics.areEqual(this.shareUrl, generatorParam.shareUrl) && this.isXHS == generatorParam.isXHS && this.maxWaitTime == generatorParam.maxWaitTime) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.guildInfo.hashCode() * 31) + this.feedInfo.hashCode()) * 31) + this.shareUrl.hashCode()) * 31;
            boolean z16 = this.isXHS;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + androidx.fragment.app.a.a(this.maxWaitTime);
        }

        @NotNull
        public String toString() {
            return "GeneratorParam(guildInfo=" + this.guildInfo + ", feedInfo=" + this.feedInfo + ", shareUrl=" + this.shareUrl + ", isXHS=" + this.isXHS + ", maxWaitTime=" + this.maxWaitTime + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/longfeed/GuildLongFeedPictureGenerator$b", "Lcom/tencent/mobileqq/component/qrcode/a;", "", "color", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.component.qrcode.a {
        b(List<f> list) {
            super(list);
        }

        @Override // com.tencent.mobileqq.component.qrcode.a
        @NotNull
        public List<Integer> a(int color) {
            int collectionSizeOrDefault;
            List<f> b16 = b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (f fVar : b16) {
                com.tencent.mobileqq.qui.profileskin.material_color.hct.b b17 = com.tencent.mobileqq.qui.profileskin.material_color.hct.b.b(color);
                arrayList.add(Integer.valueOf(com.tencent.mobileqq.qui.profileskin.material_color.hct.b.a(b17.d(), b17.c(), b17.e()).g()));
            }
            return arrayList;
        }
    }

    GuildLongFeedPictureGenerator() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(n binding, GeneratorParam param) {
        binding.f446966e.setText(param.getFeedInfo().poster.nick);
        binding.f446967f.setText(m(param.getFeedInfo().createTimeNs));
        binding.f446971j.getPaint().setFakeBoldText(true);
        TextView textView = binding.f446971j;
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = param.getFeedInfo().title.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "param.feedInfo.title.contents");
        textView.setText((CharSequence) FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, null, null, null, 15, null).getFirst());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(n binding, GeneratorParam param) {
        binding.f446975n.setText(param.getGuildInfo().getGuildName());
        binding.f446974m.setText(cp1.c.f391536a.a(param.getGuildInfo().getUserNum(), "\u6210\u5458"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(n binding, GeneratorParam param) {
        if (param.getIsXHS()) {
            QUIColorfulQRCodeView qUIColorfulQRCodeView = binding.f446976o;
            Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView, "binding.guildQrcode");
            qUIColorfulQRCodeView.setVisibility(8);
            return;
        }
        QUIColorfulQRCodeView qUIColorfulQRCodeView2 = binding.f446976o;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView2, "binding.guildQrcode");
        qUIColorfulQRCodeView2.setVisibility(0);
        QUIColorfulQRCodeView qUIColorfulQRCodeView3 = binding.f446976o;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView3, "binding.guildQrcode");
        p(qUIColorfulQRCodeView3);
        Logger.f235387a.d().a("Guild.share.GuildLongFeedPictureGenerator", 1, "bindQRCodeView shareUrl:" + param.getShareUrl());
        binding.f446976o.f(param.getShareUrl(), new g() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.b
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                GuildLongFeedPictureGenerator.j(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3) {
        Logger.f235387a.d().a("Guild.share.GuildLongFeedPictureGenerator", 1, "bindQRCodeView result:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(n binding, GeneratorParam param) {
        int i3;
        String str;
        String str2;
        QUIColorfulQRCodeView qUIColorfulQRCodeView = binding.f446976o;
        Intrinsics.checkNotNullExpressionValue(qUIColorfulQRCodeView, "binding.guildQrcode");
        if (!param.getIsXHS()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qUIColorfulQRCodeView.setVisibility(i3);
        TextView textView = binding.f446977p;
        if (param.getIsXHS()) {
            str = "\u6253\u5f00QQ\uff0c\u641c\u7d22\u300c" + param.getGuildInfo().getGuildName() + "\u300d\u9891\u9053";
        } else {
            str = "\u957f\u6309\u4e8c\u7ef4\u7801\u67e5\u770b\u8be6\u60c5";
        }
        textView.setText(str);
        TextView textView2 = binding.f446968g;
        if (param.getIsXHS()) {
            str2 = "\u524d\u5f80\u9891\u9053\u67e5\u770b\u66f4\u591a\u5185\u5bb9";
        } else {
            str2 = "\u626b\u7801\u67e5\u770b\u5269\u4f59\u5185\u5bb9";
        }
        textView2.setText(str2);
    }

    private final Map<Integer, d> l() {
        HashMap hashMap = new HashMap();
        float b16 = com.tencent.guild.aio.util.c.b(3);
        hashMap.put(3, new d(7, 6, b16, 1.5f));
        hashMap.put(4, new d(9, 7, b16, 1.5f));
        hashMap.put(5, new d(10, 8, b16, 1.5f));
        hashMap.put(6, new d(11, 9, b16, 1.5f));
        hashMap.put(7, new d(12, 10, b16, 1.5f));
        hashMap.put(8, new d(13, 11, b16, 1.5f));
        hashMap.put(9, new d(14, 12, b16, 1.5f));
        d dVar = new d(14, 12, b16, 1.0f);
        hashMap.put(10, dVar);
        hashMap.put(11, dVar);
        hashMap.put(12, dVar);
        hashMap.put(13, dVar);
        hashMap.put(14, dVar);
        hashMap.put(15, dVar);
        hashMap.put(16, dVar);
        hashMap.put(17, dVar);
        hashMap.put(18, dVar);
        hashMap.put(19, dVar);
        hashMap.put(20, dVar);
        hashMap.put(21, dVar);
        hashMap.put(22, dVar);
        hashMap.put(23, dVar);
        hashMap.put(24, dVar);
        hashMap.put(25, dVar);
        hashMap.put(26, dVar);
        hashMap.put(27, dVar);
        hashMap.put(28, dVar);
        hashMap.put(29, dVar);
        return hashMap;
    }

    private final String m(long timeNs) {
        String format = new SimpleDateFormat("yyyy.MM.dd").format(new Date(timeNs / 1000000));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy.M\u2026ate(timeNs / 1_000_000L))");
        return format;
    }

    private final List<f> n() {
        List<f> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new f[]{new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d), new f(0.0d, 0.0d, 0.0d)});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(n nVar, GeneratorParam generatorParam, TextViewContainer textViewContainer, Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        List mutableListOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        FrameLayout root = nVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        c.b(root);
        FrameLayout root2 = nVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        c.a(root2);
        ImageView imageView = nVar.f446973l;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildLogoTop");
        ImageView imageView2 = nVar.f446972k;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.guildLogoBottom");
        ImageView imageView3 = nVar.f446978q;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.guildTopBg");
        boolean z16 = false;
        int i3 = 8;
        DefaultConstructorMarker defaultConstructorMarker = null;
        RoundImageView roundImageView = nVar.f446964c;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildAvatar");
        String avatarUrl = generatorParam.getGuildInfo().getAvatarUrl(100);
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "param.guildInfo.getAvata\u2026ldAvatarUrlType.SIZE_100)");
        RoundImageView roundImageView2 = nVar.f446965d;
        Intrinsics.checkNotNullExpressionValue(roundImageView2, "binding.guildFeedPosterAvatar");
        String str = generatorParam.getFeedInfo().poster.icon.iconUrl;
        Intrinsics.checkNotNullExpressionValue(str, "param.feedInfo.poster.icon.iconUrl");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildLongFeedPictureAsyncWorkManager.ImageRemoteResData(imageView, "https://downv6.qq.com/innovate/guild/sfeed/guild_long_feed_share_picture_guild_logo.png", "guildLogoTop", false, 8, null), new GuildLongFeedPictureAsyncWorkManager.ImageRemoteResData(imageView2, "https://downv6.qq.com/innovate/guild/sfeed/guild_long_feed_share_picture_guild_logo.png", "guildLogoBottom", false, 8, null), new GuildLongFeedPictureAsyncWorkManager.ImageRemoteResData(imageView3, "https://downv6.qq.com/innovate/guild/sfeed/guild_long_feed_share_picture_top_bg.png", "guildTopBg", z16, i3, defaultConstructorMarker), new GuildLongFeedPictureAsyncWorkManager.ImageRemoteResData(roundImageView, avatarUrl, "guildAvatar", z16, i3, defaultConstructorMarker), new GuildLongFeedPictureAsyncWorkManager.ImageRemoteResData(roundImageView2, str, "posterAvatar", z16, i3, defaultConstructorMarker));
        final long currentTimeMillis = System.currentTimeMillis();
        new GuildLongFeedPictureAsyncWorkManager(generatorParam.getMaxWaitTime(), textViewContainer, mutableListOf, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.longfeed.GuildLongFeedPictureGenerator$loadAsyncResources$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17) {
                long currentTimeMillis2 = System.currentTimeMillis();
                Logger logger = Logger.f235387a;
                long j3 = currentTimeMillis;
                logger.d().a("Guild.share.GuildLongFeedPictureGenerator", 1, "loadAsyncResources ok cost: " + (currentTimeMillis2 - j3) + " ms");
                Continuation<Boolean> continuation2 = safeContinuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(Boolean.valueOf(z17)));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public final void p(@NotNull QUIColorfulQRCodeView qrCode) {
        Intrinsics.checkNotNullParameter(qrCode, "qrCode");
        qrCode.q();
        qrCode.e(false);
        qrCode.setIsAdjustDarkLogo(false);
        qrCode.setTargetGenerateQRCodeParams(new e(3, 29, l(), ErrorCorrectionLevel.Q));
        qrCode.k(-16777216, new b(f220341a.n()));
        qrCode.g(new i(R.drawable.guild_qrcode_logo, null, null, 0));
    }

    public final void q(@NotNull Context context, @NotNull GeneratorParam param, @NotNull Function3<? super Boolean, ? super View, ? super Bitmap, Unit> onResult) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Logger.f235387a.d().a("Guild.share.GuildLongFeedPictureGenerator", 1, "startGenerate feedType:" + param.getFeedInfo().feedType + " xhs:" + param.getIsXHS());
        if (!com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(param.getFeedInfo().feedType)) {
            onResult.invoke(Boolean.FALSE, null, null);
            return;
        }
        GuildContextWrapper guildContextWrapper = new GuildContextWrapper(context, 1001);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.share.GuildLongFeedPictureGenerator startShare", null, null, null, new GuildLongFeedPictureGenerator$startGenerate$2(guildContextWrapper, param, onResult, null), 14, null);
        }
    }
}
