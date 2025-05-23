package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.widget.textView.view.b;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.y;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.pic.data.FeedMixedMediaDataCompatTool;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedUIData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeed;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPBusinessCard;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPRichTextContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProInteraction;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextCardContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.h;
import qj1.l;
import qj1.q;
import qj1.r;
import qj1.t;
import qj1.u;
import qj1.w;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010D\u001a\u00020?\u00a2\u0006\u0004\bV\u0010WJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J@\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0002H\u0016J\b\u0010%\u001a\u00020$H\u0016J\n\u0010'\u001a\u0004\u0018\u00010&H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\b\u0010/\u001a\u00020\u0013H\u0016J\b\u00100\u001a\u00020\u0013H\u0016J\u0011\u00101\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b1\u00102J\b\u00103\u001a\u00020\u0005H\u0016J\b\u00104\u001a\u00020\u0013H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u001bH\u0016J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020\u001bH\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u001bH\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\u0010\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002H\u0016R\u0017\u0010D\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR!\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010K\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010JR\u0014\u0010N\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010P\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bO\u0010MR\u0014\u0010S\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/GProRecommendFeedWrapper;", "Lqj1/h;", "", "Lqj1/l;", "c", "", "L", "u", "r", UserInfo.SEX_FEMALE, "", "getCreateTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProInteraction;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "O", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "", "hideUrlTypes", "emojiSize", "traceId", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Lcom/tencent/aio/widget/textView/view/b;", "y", "", "k", "", "param", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/data/m;", "N", "v", "Lqj1/w;", "f", "Lqj1/a;", "l", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextCardContent;", "D", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProThirdBar;", "G", "I", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "getCommentCount", "d", "getPreferStatus", "p", "()Ljava/lang/Integer;", "i", "E", "getFeedId", "w", "getChannelId", "getGuildId", "B", "getGuildName", "getGuildIcon", "K", HippyTKDListViewAdapter.X, "getFunctionList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "M", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;", "feed", "b", "Lkotlin/Lazy;", "P", "()Ljava/util/List;", "mixedMediaData", "()Ljava/lang/Object;", "raw", "getTopTimestamp", "()J", "topTimestamp", "g", "channelTopTimestamp", "getFeedType", "()I", "feedType", "j", "feedAuditStatus", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendFeed;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GProRecommendFeedWrapper implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProContentRecommendFeed feed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mixedMediaData;

    @Metadata(d1 = {"\u0000S\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0018\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0019\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001bH\u0096\u0001J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0006H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/GProRecommendFeedWrapper$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPRichTextContent;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", "Landroid/graphics/drawable/Drawable;", "v", ReportConstant.COSTREPORT_PREFIX, "", "g", "i", tl.h.F, "u", "k", "o", "d", "b", "", "r", "w", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "j", "e", "p", "getTraceID", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements IParseRichTextConfig<IGProMVPRichTextContent> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<IGProMVPRichTextContent> f221006b = IParseRichTextConfig.INSTANCE.a();

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Integer> f221007c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f221008d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f221009e;

        a(List<Integer> list, int i3, String str) {
            this.f221007c = list;
            this.f221008d = i3;
            this.f221009e = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f221006b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f221006b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f221006b.d();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean e() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public TrimSpaceType f() {
            return TrimSpaceType.None;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean g() {
            return this.f221006b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f221006b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID, reason: from getter */
        public String getF221009e() {
            return this.f221009e;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            return this.f221006b.h();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f221006b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f221006b.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f221006b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f221006b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f221006b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p, reason: from getter */
        public int getF221008d() {
            return this.f221008d;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f221006b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f221006b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f221006b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f221006b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f221006b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull IGProMVPRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return this.f221006b.m(t16);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull IGProMVPRichTextContent t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            return !this.f221007c.contains(Integer.valueOf(t16.getUrlContent().getType()));
        }
    }

    public GProRecommendFeedWrapper(@NotNull IGProContentRecommendFeed feed) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<? extends l>>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProRecommendFeedWrapper$mixedMediaData$2

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProRecommendFeedWrapper$mixedMediaData$2$1, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<IGProImage, l> {
                AnonymousClass1(Object obj) {
                    super(1, obj, FeedMixedMediaDataCompatTool.class, "newIGProImageMediaDataReader", "newIGProImageMediaDataReader(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProImage;)Lcom/tencent/mobileqq/guild/feed/displayable/IMediaDisplayable;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final l invoke(@NotNull IGProImage p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    return ((FeedMixedMediaDataCompatTool) this.receiver).k(p06);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProRecommendFeedWrapper$mixedMediaData$2$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<IGProVideo, l> {
                AnonymousClass2(Object obj) {
                    super(1, obj, FeedMixedMediaDataCompatTool.class, "newIGProVideoMediaDataReader", "newIGProVideoMediaDataReader(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVideo;)Lcom/tencent/mobileqq/guild/feed/displayable/IMediaDisplayable;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final l invoke(@NotNull IGProVideo p06) {
                    Intrinsics.checkNotNullParameter(p06, "p0");
                    return ((FeedMixedMediaDataCompatTool) this.receiver).l(p06);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends l> invoke() {
                List listOfNotNull;
                FeedMixedMediaDataCompatTool feedMixedMediaDataCompatTool = FeedMixedMediaDataCompatTool.f221103a;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(feedMixedMediaDataCompatTool);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(feedMixedMediaDataCompatTool);
                IGProImage image = GProRecommendFeedWrapper.this.getFeed().getImage();
                String url = image.getUrl();
                Intrinsics.checkNotNullExpressionValue(url, "it.url");
                if (!(url.length() > 0)) {
                    image = null;
                }
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(image);
                return feedMixedMediaDataCompatTool.b(anonymousClass1, anonymousClass2, listOfNotNull, GProRecommendFeedWrapper.this.getFeed().getVideos(), GProRecommendFeedWrapper.this.getFeed().getTotalImageCount());
            }
        });
        this.mixedMediaData = lazy;
    }

    private final List<l> P() {
        return (List) this.mixedMediaData.getValue();
    }

    @Override // qj1.b
    public boolean A() {
        return h.a.b(this);
    }

    @Override // qj1.c
    public boolean B() {
        IGProChannelInfo B = ch.B(String.valueOf(getChannelId()));
        if (B != null) {
            return B.isHiddenPostChannel();
        }
        return true;
    }

    @Override // qj1.e
    @Nullable
    public GProStRichTextCardContent D() {
        return null;
    }

    @Override // qj1.p
    public int E() {
        return 0;
    }

    @Override // qj1.n
    @NotNull
    public String F() {
        return "";
    }

    @Override // qj1.s
    @Nullable
    public GProThirdBar G() {
        return null;
    }

    @Override // qj1.e
    @NotNull
    public List<r> H() {
        return h.a.h(this);
    }

    @Override // qj1.b
    @NotNull
    public String I() {
        QRouteApi api = QRoute.api(IGuildFeedUtilsApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedUtilsApi::class.java)");
        String a16 = IGuildFeedUtilsApi.a.a((IGuildFeedUtilsApi) api, (int) this.feed.getFeedStat().getPageView(), null, y.b.f216487d, 2, null);
        return BaseApplication.context.getString(R.string.f22044695) + a16;
    }

    @Override // qj1.n
    @NotNull
    public String J() {
        IGProContentRecommendFeed iGProContentRecommendFeed = this.feed;
        Pair pair = TuplesKt.to(Long.valueOf(iGProContentRecommendFeed.getCreateTime()), Long.valueOf(iGProContentRecommendFeed.getLastModifiedTime()));
        long longValue = ((Number) pair.component1()).longValue();
        long longValue2 = ((Number) pair.component2()).longValue();
        String w3 = ax.w(Math.max(longValue, longValue2) * 1000);
        if (longValue2 > longValue) {
            String string = BaseApplication.context.getString(R.string.ztr, w3);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            BaseApplic\u2026 formattedTime)\n        }");
            return string;
        }
        Intrinsics.checkNotNullExpressionValue(w3, "{\n            formattedTime\n        }");
        return w3;
    }

    @Override // qj1.c
    public boolean K() {
        boolean z16;
        IGProChannelInfo B = ch.B(String.valueOf(getChannelId()));
        if (B != null && !B.isHiddenPostChannel()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && B.getType() == 7) {
            return true;
        }
        return false;
    }

    @Override // qj1.n
    @Nullable
    public String L() {
        return this.feed.getPoster().getNick();
    }

    @NotNull
    /* renamed from: M, reason: from getter */
    public final IGProContentRecommendFeed getFeed() {
        return this.feed;
    }

    @Override // qj1.e
    @NotNull
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public LongFeedUIData C(@NotNull Object param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return new LongFeedUIData(new SpannableStringBuilder(), new ArrayList(), null, false, 8, null);
    }

    @Override // qj1.f
    @Nullable
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public GuildFeedRichMediaData n() {
        return null;
    }

    @Override // qj1.o
    @NotNull
    public Object a() {
        return this.feed;
    }

    @Override // qj1.e
    @NotNull
    public List<q> b() {
        return h.a.i(this);
    }

    @Override // qj1.e
    @NotNull
    public List<l> c() {
        return P();
    }

    @Override // qj1.b
    public int d() {
        return (int) this.feed.getFeedStat().getShareCount();
    }

    @Override // qj1.b
    public int e() {
        return (int) this.feed.getFeedStat().getPreferCount();
    }

    @Override // qj1.e
    @NotNull
    public List<w> f() {
        ArrayList arrayList = new ArrayList();
        Iterator<IGProMVPRichTextContent> it = this.feed.getRichText().getContents().iterator();
        while (it.hasNext()) {
            IGProMVPRichTextContent content = it.next();
            if (content.getType() == 3 && content.getUrlContent().getType() == 3) {
                Intrinsics.checkNotNullExpressionValue(content, "content");
                arrayList.add(new w(content));
            }
        }
        return arrayList;
    }

    @Override // qj1.k
    public long g() {
        return 0L;
    }

    @Override // qj1.c
    public long getChannelId() {
        return this.feed.getGuildInfo().getChannelId();
    }

    @Override // qj1.b
    public int getCommentCount() {
        return (int) this.feed.getFeedStat().getTotalCommentCount();
    }

    @Override // qj1.k
    public long getCreateTime() {
        return this.feed.getCreateTime();
    }

    @Override // qj1.g
    @NotNull
    public String getFeedId() {
        String idd = this.feed.getIdd();
        Intrinsics.checkNotNullExpressionValue(idd, "feed.idd");
        return idd;
    }

    @Override // qj1.g
    public int getFeedType() {
        return this.feed.getFeedType();
    }

    @Override // qj1.j
    @Nullable
    public List<Integer> getFunctionList() {
        return this.feed.getFunctionList();
    }

    @Override // qj1.c
    @NotNull
    public String getGuildIcon() {
        String guildIcon = this.feed.getGuildInfo().getGuildIcon();
        Intrinsics.checkNotNullExpressionValue(guildIcon, "feed.guildInfo.guildIcon");
        return guildIcon;
    }

    @Override // qj1.c
    public long getGuildId() {
        return this.feed.getGuildInfo().getGuildId();
    }

    @Override // qj1.c
    @NotNull
    public String getGuildName() {
        String guildName = this.feed.getGuildInfo().getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "feed.guildInfo.guildName");
        return guildName;
    }

    @Override // qj1.n
    @NotNull
    public Triple<Long, Long, String> getPersonalMedal() {
        return h.a.d(this);
    }

    @Override // qj1.b
    public int getPreferStatus() {
        return (int) this.feed.getFeedStat().getPreferCount();
    }

    @Override // qj1.n
    @NotNull
    public Triple<Integer, Integer, String> getRoleInfo() {
        return h.a.f(this);
    }

    @Override // qj1.k
    public long getTopTimestamp() {
        return 0L;
    }

    @Override // qj1.e
    @NotNull
    public List<u> getTroopList() {
        return h.a.j(this);
    }

    @Override // qj1.e
    @NotNull
    public List<t> h() {
        return h.a.g(this);
    }

    @Override // qj1.p
    @NotNull
    public String i() {
        return "";
    }

    @Override // qj1.j
    public int j() {
        return this.feed.getAuditStatus();
    }

    @Override // qj1.e
    public boolean k() {
        return false;
    }

    @Override // qj1.e
    @NotNull
    public qj1.a l() {
        IGProMVPBusinessCard businessCard = this.feed.getBusinessCard();
        Intrinsics.checkNotNullExpressionValue(businessCard, "feed.businessCard");
        return new qj1.a(businessCard);
    }

    @Override // qj1.k
    public long m() {
        return this.feed.getLastModifiedTime();
    }

    @Override // qj1.g
    public int o() {
        return h.a.c(this);
    }

    @Override // qj1.b
    @Nullable
    public Integer p() {
        return Integer.valueOf((int) this.feed.getFeedStat().getPageView());
    }

    @Override // qj1.c
    @Nullable
    public String q() {
        return null;
    }

    @Override // qj1.n
    @NotNull
    public String r() {
        return String.valueOf(this.feed.getPoster().getTinyId());
    }

    @Override // qj1.n
    public int s() {
        return h.a.a(this);
    }

    @Override // qj1.n
    @NotNull
    public String t() {
        return h.a.e(this);
    }

    @Override // qj1.n
    @Nullable
    public String u() {
        return this.feed.getPoster().getAvatar();
    }

    @Override // qj1.e
    @NotNull
    public SpannableStringBuilder v() {
        return new SpannableStringBuilder();
    }

    @Override // qj1.g
    public boolean w() {
        return false;
    }

    @Override // qj1.j
    public boolean x() {
        return this.feed.getNeedWebview();
    }

    @Override // qj1.e
    @NotNull
    public Pair<SpannableStringBuilder, b> y(@Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull List<Integer> hideUrlTypes, int emojiSize, @Nullable String traceId) {
        Intrinsics.checkNotNullParameter(hideUrlTypes, "hideUrlTypes");
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<IGProMVPRichTextContent> contents = this.feed.getRichText().getContents();
        Intrinsics.checkNotNullExpressionValue(contents, "feed.richText.contents");
        return feedRichTextContentParser.r(contents, joinInfoParam, new a(hideUrlTypes, emojiSize, traceId), String.valueOf(this.feed.getGuildInfo().getChannelId()), String.valueOf(this.feed.getGuildInfo().getGuildId()));
    }

    @Override // qj1.k
    @NotNull
    public GProInteraction z() {
        return new GProInteraction();
    }
}
