package com.tencent.mobileqq.guild.feed.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutLoaderStrategy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi;
import com.tencent.mobileqq.guild.feed.feedoption.GuildFeedOptionConfigParser;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedTroopFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.util.au;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.troopguild.api.ITroopGuildApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J|\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0017j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004`\u0018H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\u001a\u0010(\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0011H\u0016R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedConfigAPiImpl;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedConfigAPi;", "Landroid/os/Bundle;", "args", "", "getTroopFeedFragment", "Landroid/content/Context;", "context", "", "troopUin", "", "launchTroopFeedActivity", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "richContents", "", "highlightWords", "", "lightColor", "channelId", "guildId", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Landroid/text/method/MovementMethod;", "parseRichTextToSpan", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "data", "", "parseMVPFeedsText", "getLayoutPreloadInflateStrategy", "getFeedOptionConfig", "getPreferClickedAnimJsonPath", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "pathColor", "changePreferLottieColor", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;", "mvpFeedParseConfig", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "getMvpFeedParseConfig", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedConfigAPiImpl implements IGuildFeedConfigAPi {

    @NotNull
    private static final String TAG = "GuildFeedConfigAPiImpl";

    @NotNull
    private final IParseRichTextConfig<IGProMVPRichTextContent> mvpFeedParseConfig = new b();

    @Metadata(d1 = {"\u0000Q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0013H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u001aH\u0096\u0001J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001cH\u0096\u0001J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\nH\u0016R\u0014\u0010&\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedConfigAPiImpl$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "getTraceID", "", "i", "j", tl.h.F, "u", "e", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "w", "d", "o", "g", "k", "p", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IParseRichTextConfig<IGProMVPRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<IGProMVPRichTextContent> f218001b = IParseRichTextConfig.INSTANCE.a();

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f218001b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f218001b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f218001b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f218001b.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f218001b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221009e() {
            return this.f218001b.getF221009e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f218001b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f218001b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f218001b.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f218001b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            return new com.tencent.mobileqq.guild.quiprofile.c(sMobileQQ, null, 0, false, 14, null).getColor(R.color.qui_common_text_primary);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221008d() {
            return 14;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f218001b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f218001b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f218001b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: t */
        public int getF218003c() {
            return this.f218001b.getF218003c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f218001b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull IGProMVPRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f218001b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull IGProMVPRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            switch (t16.getUrlContent().getType()) {
                case 6:
                case 7:
                case 8:
                case 9:
                    return false;
                default:
                    return true;
            }
        }
    }

    @Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u000b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0010\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0012\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0015\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0016\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0017\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u0018\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0096\u0001J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u001eH\u0016J$\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020!`\"H\u0016R\u0014\u0010&\u001a\u00020\u00058\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedConfigAPiImpl$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "", "l", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "", "getTraceID", "", "g", "i", "j", tl.h.F, "u", "k", "o", "e", "d", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "", "r", "w", "", "getHighlightWords", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "c", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements IParseRichTextConfig<GProStRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProStRichTextContent> f218002b = IParseRichTextConfig.INSTANCE.a();

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f218003c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Collection<String> f218004d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ HashMap<String, Object> f218005e;

        c(int i3, Collection<String> collection, HashMap<String, Object> hashMap) {
            this.f218003c = i3;
            this.f218004d = collection;
            this.f218005e = hashMap;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f218002b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f218005e;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f218002b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return this.f218002b.e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return this.f218002b.f();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f218002b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f218004d;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221009e() {
            return this.f218002b.getF221009e();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f218002b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f218002b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return this.f218002b.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f218002b.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f218002b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f218002b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f218002b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221008d() {
            return this.f218002b.getF221008d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f218002b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f218002b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f218002b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: t, reason: from getter */
        public int getF218003c() {
            return this.f218003c;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f218002b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f218002b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProStRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return true;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    public void changePreferLottieColor(@Nullable LottieAnimationView view, int pathColor) {
        au.f223851a.i(view, pathColor);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    @NotNull
    public List<String> getFeedOptionConfig() {
        return GuildFeedOptionConfigParser.INSTANCE.a().a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    @NotNull
    public Object getLayoutPreloadInflateStrategy() {
        RFWLayoutLoaderStrategy c16 = gj1.a.a().c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance().layoutLoaderStrategy");
        return c16;
    }

    @NotNull
    public final IParseRichTextConfig<IGProMVPRichTextContent> getMvpFeedParseConfig() {
        return this.mvpFeedParseConfig;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    @NotNull
    public String getPreferClickedAnimJsonPath() {
        return "feed/feed_item/list_prefer_clicked_anim.json";
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    @NotNull
    public Object getTroopFeedFragment(@NotNull Bundle args) {
        Intrinsics.checkNotNullParameter(args, "args");
        GuildFeedTroopFragment guildFeedTroopFragment = new GuildFeedTroopFragment();
        Bundle bundle = new Bundle();
        GuildFeedTroopInitBean guildFeedTroopInitBean = new GuildFeedTroopInitBean();
        guildFeedTroopInitBean.setIsNewCreated(false);
        guildFeedTroopInitBean.hideTitle = true;
        guildFeedTroopInitBean.setChannelId(args.getString(IGuildFeedConfigAPi.PARAM_CHANNEL_ID));
        guildFeedTroopInitBean.setChannelName(args.getString(IGuildFeedConfigAPi.PARAM_CHANNEL_NAME));
        guildFeedTroopInitBean.setGuildId(args.getString(IGuildFeedConfigAPi.PARAM_GUILD_ID));
        guildFeedTroopInitBean.setGuildUrl("https://groupprohead.gtimg.cn/43096041630850631/100?t=1630888943259");
        guildFeedTroopInitBean.setIsMember(true);
        guildFeedTroopInitBean.setOpenFrom(0);
        guildFeedTroopInitBean.setShareSource(13);
        guildFeedTroopInitBean.setUserType("3");
        guildFeedTroopInitBean.setTroopUin(args.getString(IGuildFeedConfigAPi.PARAM_TROOP_UIN));
        guildFeedTroopInitBean.setBusinessType(7);
        ITroopGuildApi iTroopGuildApi = (ITroopGuildApi) QRoute.api(ITroopGuildApi.class);
        String troopUin = guildFeedTroopInitBean.getTroopUin();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        guildFeedTroopInitBean.setTroopRole(iTroopGuildApi.getTroopGuildRole(troopUin));
        bundle.putSerializable("guild_key_init_bean", guildFeedTroopInitBean);
        guildFeedTroopFragment.setArguments(bundle);
        return guildFeedTroopFragment;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    public void launchTroopFeedActivity(@NotNull Context context, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(troopUin);
        IGProChannelInfo troopFeedChannelInfo = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopFeedChannelInfo(troopGuildId);
        if (troopFeedChannelInfo != null && troopFeedChannelInfo.getChannelUin() != null) {
            GuildFeedTroopInitBean guildFeedTroopInitBean = new GuildFeedTroopInitBean();
            guildFeedTroopInitBean.setIsNewCreated(false);
            guildFeedTroopInitBean.hideTitle = true;
            guildFeedTroopInitBean.setChannelId(troopFeedChannelInfo.getChannelUin());
            guildFeedTroopInitBean.setChannelName(troopFeedChannelInfo.getChannelName());
            guildFeedTroopInitBean.setGuildId(troopGuildId);
            guildFeedTroopInitBean.setGuildUrl("https://groupprohead.gtimg.cn/43096041630850631/100?t=1630888943259");
            guildFeedTroopInitBean.setIsMember(true);
            guildFeedTroopInitBean.setOpenFrom(0);
            guildFeedTroopInitBean.setShareSource(13);
            guildFeedTroopInitBean.setUserType("3");
            guildFeedTroopInitBean.setTroopUin(troopUin);
            guildFeedTroopInitBean.setBusinessType(7);
            guildFeedTroopInitBean.setTroopRole(((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildRole(troopUin));
            Intent intent = new Intent();
            intent.setClass(context, QPublicFragmentActivity.class);
            intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedTroopInitBean);
            intent.putExtra("key_show_title", true);
            intent.addFlags(268435456);
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildFeedTroopFragment.class, null, 8, null);
            return;
        }
        QQToast.makeText(context, context.getString(R.string.f143700ms), 0).show();
        QLog.e(TAG, 1, "lauchTroopFeed failed. channeldInfo is empty! troopUin: " + troopUin + ", guildId: " + troopGuildId);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    @NotNull
    public CharSequence parseMVPFeedsText(@NotNull IGProContentRecommendFeed data) {
        Intrinsics.checkNotNullParameter(data, "data");
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<IGProMVPRichTextContent> contents = data.getRichText().getContents();
        Intrinsics.checkNotNullExpressionValue(contents, "data.richText.contents");
        return (CharSequence) FeedRichTextContentParser.s(feedRichTextContentParser, contents, null, this.mvpFeedParseConfig, String.valueOf(data.getGuildInfo().getChannelId()), String.valueOf(data.getGuildInfo().getGuildId()), 1, null).getFirst();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedConfigAPi
    @NotNull
    public Pair<SpannableStringBuilder, MovementMethod> parseRichTextToSpan(@NotNull List<GProStRichTextContent> richContents, @NotNull Collection<String> highlightWords, int lightColor, @Nullable String channelId, @Nullable String guildId, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull HashMap<String, Object> reportParams) {
        Intrinsics.checkNotNullParameter(richContents, "richContents");
        Intrinsics.checkNotNullParameter(highlightWords, "highlightWords");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        return FeedRichTextContentParser.f221393a.r(richContents, joinInfoParam, new c(lightColor, highlightWords, reportParams), channelId, guildId);
    }
}
