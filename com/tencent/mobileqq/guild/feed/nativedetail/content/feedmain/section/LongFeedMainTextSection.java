package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.LineHeightSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryFirstPagerEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.FeedConfigurationChangeEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event.PageOpenAnimationEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedParseParam;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.LongFeedVideoPlayManager;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.LongFeedUIData;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.FeedRichTextView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.LongFeedImageViewAdapter;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J\u0014\u0010\r\u001a\u00020\f2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J\u0014\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J4\u0010$\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"H\u0014J\u0010\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020\fH\u0016J\u0012\u0010*\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030,0+j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030,`-H\u0016R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u00105\u001a\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/LongFeedMainTextSection;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/e;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "feedDetail", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "J", "", "G", "", "O", "Landroid/text/SpannableStringBuilder;", "L", "", "title", "spannableText", "D", "Lcom/tencent/mobileqq/guild/feed/gallery/event/GuildFeedGalleryFirstPagerEvent;", "event", "M", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData;", "data", "position", "", "", "payloads", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/FeedDetailMainData$c$c;", "payload", "t", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, NodeProps.VISIBLE, "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "e", "Lkotlin/Lazy;", "K", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "textViewContainer", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedVideoPlayManager;", "f", "H", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedVideoPlayManager;", "longFeedVideoPlayManager", "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", tl.h.F, "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", "transitionBeanCreator", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedMainTextSection extends e implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: m, reason: collision with root package name */
    private static final int f221059m = ViewUtils.dpToPx(12.0f) - 26;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy textViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy longFeedVideoPlayManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TransitionHelper.TransitionBeanCreator transitionBeanCreator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0001J%\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\f\u001a\u00020\nH\u0096\u0001J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\nH\u0096\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0015\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0016\u001a\u00020\u0010H\u0096\u0001J\t\u0010\u0017\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0018H\u0096\u0001J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016R\u0014\u0010&\u001a\u00020\n8\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/section/LongFeedMainTextSection$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "", "l", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "c", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "", "getHighlightWords", ReportConstant.COSTREPORT_PREFIX, "", "g", "i", "u", "k", "o", "d", "b", "", "r", "w", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/TrimSpaceType;", "f", "j", "e", "p", "getTraceID", "Landroid/graphics/drawable/Drawable;", "v", tl.h.F, DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IParseRichTextConfig<GProElem> {

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ IParseRichTextConfig<GProElem> f221064b = IParseRichTextConfig.INSTANCE.a();

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f221066d;

        b(int i3) {
            this.f221066d = i3;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean b() {
            return this.f221064b.b();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public HashMap<String, Object> c() {
            return this.f221064b.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean d() {
            return this.f221064b.d();
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
            return this.f221064b.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @NotNull
        public Collection<String> getHighlightWords() {
            return this.f221064b.getHighlightWords();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: getTraceID */
        public String getF221023e() {
            String traceId;
            rl1.a aVar = (rl1.a) SectionIOCKt.getIocInterface(LongFeedMainTextSection.this, rl1.a.class);
            if (aVar == null || (traceId = aVar.getTraceId()) == null) {
                return "";
            }
            return traceId;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean h() {
            if (this.f221066d < 40) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean i() {
            return this.f221064b.i();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean j() {
            return true;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean k() {
            return this.f221064b.k();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public float l() {
            return this.f221064b.l();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int n() {
            return this.f221064b.n();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean o() {
            return this.f221064b.o();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: p */
        public int getF221022d() {
            return 20;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int q() {
            return this.f221064b.q();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        public Set<Integer> r() {
            return this.f221064b.r();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int s() {
            return this.f221064b.s();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public int t() {
            return this.f221064b.t();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        public boolean u() {
            return this.f221064b.u();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        @Nullable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Drawable m(@NotNull GProElem t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c cVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.f221632a;
            GProStRichTextURLContent gProStRichTextURLContent = t16.url.urlContent;
            Intrinsics.checkNotNullExpressionValue(gProStRichTextURLContent, "t.url.urlContent");
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.d(cVar, gProStRichTextURLContent, context, null, 4, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public boolean a(@NotNull GProElem t16) {
            Intrinsics.checkNotNullParameter(t16, "t");
            if (t16.type == 4 && t16.url.urlContent.type == 3) {
                return false;
            }
            return true;
        }
    }

    public LongFeedMainTextSection() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new LongFeedMainTextSection$textViewContainer$2(this));
        this.textViewContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LongFeedVideoPlayManager>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.LongFeedMainTextSection$longFeedVideoPlayManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final LongFeedVideoPlayManager invoke() {
                LifecycleOwner hostLifecycleOwner;
                rl1.a p16 = LongFeedMainTextSection.this.p();
                if (p16 == null || (hostLifecycleOwner = p16.getHostLifecycleOwner()) == null) {
                    return null;
                }
                return new LongFeedVideoPlayManager(hostLifecycleOwner);
            }
        });
        this.longFeedVideoPlayManager = lazy2;
        this.transitionBeanCreator = new TransitionHelper.TransitionBeanCreator() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.n
            @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
            public final TransitionBean generateTransitionBean(int i3) {
                TransitionBean Q;
                Q = LongFeedMainTextSection.Q(LongFeedMainTextSection.this, i3);
                return Q;
            }
        };
    }

    private final SpannableStringBuilder D(CharSequence title, CharSequence spannableText) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(title);
        spannableStringBuilder.append(spannableText);
        final int length = title.length();
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, length, 33);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(24, true), 0, length, 33);
        spannableStringBuilder.setSpan(new LineHeightSpan() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.q
            @Override // android.text.style.LineHeightSpan
            public final void chooseHeight(CharSequence charSequence, int i3, int i16, int i17, int i18, Paint.FontMetricsInt fontMetricsInt) {
                LongFeedMainTextSection.F(length, charSequence, i3, i16, i17, i18, fontMetricsInt);
            }
        }, length - 1, length, 33);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(int i3, CharSequence charSequence, int i16, int i17, int i18, int i19, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null && i17 == i3) {
            int i26 = fontMetricsInt.descent;
            int i27 = f221059m;
            fontMetricsInt.descent = i26 + i27;
            fontMetricsInt.bottom += i27;
        }
    }

    private final int G(qj1.h feedDetail) {
        boolean z16;
        try {
            if (!(feedDetail.a() instanceof GProStFeed)) {
                return 0;
            }
            Object a16 = feedDetail.a();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
            ArrayList<GProStRichTextContent> arrayList = ((GProStFeed) a16).contents.contents;
            Intrinsics.checkNotNullExpressionValue(arrayList, "feedDetail.raw as GProStFeed).contents.contents");
            if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
                return 0;
            }
            Iterator<T> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (((GProStRichTextContent) it.next()).type == 4) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
            return i3;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LongFeedVideoPlayManager H() {
        return (LongFeedVideoPlayManager) this.longFeedVideoPlayManager.getValue();
    }

    private final IParseRichTextConfig<GProElem> J(qj1.h feedDetail) {
        return new b(G(feedDetail));
    }

    private final TextViewContainer K() {
        return (TextViewContainer) this.textViewContainer.getValue();
    }

    private final SpannableStringBuilder L(qj1.h feedDetail) {
        boolean endsWith$default;
        SpannableStringBuilder v3 = feedDetail.v();
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) v3, '\n', false, 2, (Object) null);
        if (!endsWith$default) {
            v3.append('\n');
        }
        return v3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M(GuildFeedGalleryFirstPagerEvent event) {
        Object obj;
        Rect g16;
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h hVar;
        if (!Intrinsics.areEqual(((FeedDetailMainData) this.mData).getFeedDetail().getFeedId(), event.getFirstFeedId())) {
            return;
        }
        List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> r16 = K().r();
        Intrinsics.checkNotNullExpressionValue(r16, "textViewContainer.richTextSpans");
        Iterator<T> it = r16.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g i3 = ((com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c) obj).i();
                if (i3 instanceof com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h) {
                    hVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.data.h) i3;
                } else {
                    hVar = null;
                }
                boolean z16 = false;
                if (hVar != null && hVar.b() == event.getFirstPos()) {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c) obj;
        if (cVar != null && (g16 = cVar.g()) != null) {
            Rect rect = new Rect();
            K().getLocalVisibleRect(rect);
            if (QLog.isDevelopLevel()) {
                QLog.d("LongFeedMainTextSection", 4, "handleScrollToImage targetTop: " + g16.top + ",current visibleRectTop: " + rect.top);
            }
            vi1.h hVar2 = (vi1.h) RFWIocAbilityProvider.g().getIocInterface(vi1.h.class, getRootView(), null);
            if (hVar2 != null) {
                hVar2.V3(g16.top - rect.top);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(LongFeedMainTextSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K().o("EVENT_TYPE_CONFIGURATION_CHANGE", null);
    }

    private final void O(qj1.h feedDetail) {
        WeakReference weakReference;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        int i3;
        Integer num;
        GuildFeedPublishInfo guildFeedPublishInfo;
        LongFeedUIData longFeedUIData;
        Integer businessType;
        LifecycleOwner hostLifecycleOwner;
        rl1.a p16 = p();
        ViewGroup viewGroup = null;
        if (p16 != null && (hostLifecycleOwner = p16.getHostLifecycleOwner()) != null) {
            weakReference = new WeakReference(hostLifecycleOwner);
        } else {
            weakReference = null;
        }
        TextViewContainer K = K();
        rl1.a p17 = p();
        if (p17 != null) {
            joinInfoParam = p17.b();
        } else {
            joinInfoParam = null;
        }
        rl1.a p18 = p();
        if (p18 != null && (businessType = p18.getBusinessType()) != null) {
            i3 = businessType.intValue();
        } else {
            i3 = 0;
        }
        rl1.a p19 = p();
        if (p19 != null) {
            num = p19.a();
        } else {
            num = null;
        }
        IParseRichTextConfig<GProElem> J = J(feedDetail);
        rl1.a p26 = p();
        if (p26 != null) {
            guildFeedPublishInfo = p26.e();
        } else {
            guildFeedPublishInfo = null;
        }
        Object C = feedDetail.C(new LongFeedParseParam(K, weakReference, joinInfoParam, i3, num, J, null, guildFeedPublishInfo, 64, null));
        if (C instanceof LongFeedUIData) {
            longFeedUIData = (LongFeedUIData) C;
        } else {
            longFeedUIData = null;
        }
        if (longFeedUIData == null) {
            return;
        }
        if (!TextUtils.isEmpty(longFeedUIData.getSpannable())) {
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            K().setText(D(L(feedDetail), longFeedUIData.getSpannable()), longFeedUIData.b(), false);
            if ((K().s() instanceof FeedRichTextView) && longFeedUIData.getHasItalicText()) {
                TextView s16 = K().s();
                Intrinsics.checkNotNull(s16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.FeedRichTextView");
                ((FeedRichTextView) s16).setCheckItalicText();
                K().s().requestLayout();
            }
            com.tencent.aio.widget.textView.view.b touchMovementMethod = longFeedUIData.getTouchMovementMethod();
            if (touchMovementMethod != null) {
                K().s().setMovementMethod(touchMovementMethod);
            }
            K().s().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LongFeedMainTextSection.P(view);
                }
            });
            if (K().getParent() == null) {
                ViewGroup viewGroup3 = this.container;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                } else {
                    viewGroup = viewGroup3;
                }
                viewGroup.addView(K(), new ViewGroup.LayoutParams(-1, -2));
                return;
            }
            return;
        }
        ViewGroup viewGroup4 = this.container;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            viewGroup = viewGroup4;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransitionBean Q(LongFeedMainTextSection this$0, int i3) {
        Sequence asSequence;
        Sequence mapNotNull;
        Sequence filter;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> r16 = this$0.K().r();
        Intrinsics.checkNotNullExpressionValue(r16, "textViewContainer.richTextSpans");
        asSequence = CollectionsKt___CollectionsKt.asSequence(r16);
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(asSequence, new Function1<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.LongFeedMainTextSection$transitionBeanCreator$1$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.g invoke(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar) {
                return cVar.i();
            }
        });
        filter = SequencesKt___SequencesKt.filter(mapNotNull, new Function1<Object, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.LongFeedMainTextSection$transitionBeanCreator$lambda$1$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable Object obj2) {
                return Boolean.valueOf(obj2 instanceof LongFeedImageViewAdapter);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = filter.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((LongFeedImageViewAdapter) obj).s() == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LongFeedImageViewAdapter longFeedImageViewAdapter = (LongFeedImageViewAdapter) obj;
        if (longFeedImageViewAdapter == null) {
            return null;
        }
        return longFeedImageViewAdapter.z();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(FeedConfigurationChangeEvent.class, PageOpenAnimationEvent.class, GuildFeedGalleryFirstPagerEvent.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.v1d};
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        K().v();
        LongFeedVideoPlayManager H = H();
        if (H != null) {
            H.h();
        }
        RFWIocAbilityProvider.g().unregisterSingleIoc(K(), com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.f.class);
        RFWIocAbilityProvider.g().unregisterSingleIoc(K(), qj1.i.class);
        RFWIocAbilityProvider.g().unregisterSingleIoc(K(), TransitionHelper.TransitionBeanCreator.class);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f165166v22);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026tail_main_text_container)");
        this.container = (ViewGroup) findViewById;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof FeedConfigurationChangeEvent) {
            if (AppSetting.t(K().getContext())) {
                K().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        LongFeedMainTextSection.N(LongFeedMainTextSection.this);
                    }
                }, 10L);
                return;
            } else {
                K().o("EVENT_TYPE_CONFIGURATION_CHANGE", null);
                return;
            }
        }
        if (event instanceof PageOpenAnimationEvent) {
            K().o("EVENT_TYPE_PAGE_ANIMATION", Boolean.valueOf(((PageOpenAnimationEvent) event).getIsAnimating()));
        } else if (event instanceof GuildFeedGalleryFirstPagerEvent) {
            M((GuildFeedGalleryFirstPagerEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        LongFeedVideoPlayManager H = H();
        if (H != null) {
            H.i(visible);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    public boolean q(@NotNull FeedDetailMainData.c.C7755c payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!super.q(payload) && payload.getType() != 4) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.section.e
    protected void t(@Nullable FeedDetailMainData data, int position, @Nullable List<Object> payloads, @Nullable FeedDetailMainData.c.C7755c payload) {
        if (data == 0) {
            return;
        }
        this.mData = data;
        O(data.getFeedDetail());
    }
}
