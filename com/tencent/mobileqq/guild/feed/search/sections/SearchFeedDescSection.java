package com.tencent.mobileqq.guild.feed.search.sections;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.util.RichTextExpandStrSpanUtil;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextURLContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn1.SearchDataExt;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/SearchFeedDescSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareFeedItemView;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareFeedItemView;", "feedItemView", "Landroid/widget/TextView;", "f", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "txtView", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SearchFeedDescSection extends Section<pn1.a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedSquareFeedItemView feedItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((String) t17).length()), Integer.valueOf(((String) t16).length()));
            return compareValues;
        }
    }

    public SearchFeedDescSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchFeedDescSection$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                View view;
                view = ((Section) SearchFeedDescSection.this).mRootView;
                TextView textView = new TextView(view.getContext());
                textView.setMaxLines(3);
                textView.setTextSize(18.0f);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setLineSpacing(cw.c(26.0f), 0.0f);
                return textView;
            }
        });
        this.txtView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView s() {
        return (TextView) this.txtView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.x0u};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        if (containerView instanceof GuildFeedSquareFeedItemView) {
            guildFeedSquareFeedItemView = (GuildFeedSquareFeedItemView) containerView;
        } else {
            guildFeedSquareFeedItemView = null;
        }
        this.feedItemView = guildFeedSquareFeedItemView;
        View findViewById = containerView.findViewById(R.id.x0t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026feed_item_desc_container)");
        this.container = (ViewGroup) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011b, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r1, new com.tencent.mobileqq.guild.feed.search.sections.SearchFeedDescSection.b());
     */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull final pn1.a data, int position, @Nullable List<Object> payload) {
        ArrayList<GProStRichTextContent> arrayList;
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(data, "data");
        ViewGroup viewGroup = this.container;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        TextView s16 = s();
        ViewGroup viewGroup3 = this.container;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            viewGroup3 = null;
        }
        s16.setTextColor(viewGroup3.getContext().getColorStateList(R.color.qui_common_text_primary));
        qj1.h d16 = data.d();
        Object a16 = d16.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        GProStFeed gProStFeed = (GProStFeed) a16;
        GProStRichText gProStRichText = gProStFeed.contents;
        if (gProStRichText != null) {
            arrayList = gProStRichText.contents;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            for (GProStRichTextContent gProStRichTextContent : arrayList) {
                if (gProStRichTextContent.type == 1 && Intrinsics.areEqual(gProStRichTextContent.textContent.text, "\n")) {
                    gProStRichTextContent.textContent.text = " ";
                }
            }
        }
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> contents = gProStFeed.contents.contents;
        String valueOf = String.valueOf(d16.getChannelId());
        String valueOf2 = String.valueOf(d16.getGuildId());
        IParseRichTextConfig<GProStRichTextContent> iParseRichTextConfig = new IParseRichTextConfig<GProStRichTextContent>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchFeedDescSection$onBindData$contentPair$1

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy linkColor;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy linkDrawable;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy;
                Lazy lazy2;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchFeedDescSection$onBindData$contentPair$1$linkColor$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Integer invoke() {
                        return Integer.valueOf(BaseApplication.getContext().getResources().getColor(R.color.qui_common_text_primary));
                    }
                });
                this.linkColor = lazy;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchFeedDescSection$onBindData$contentPair$1$linkDrawable$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Drawable invoke() {
                        BaseApplication context = BaseApplication.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                        Drawable w3 = GuildUIUtils.w(context, R.drawable.qui_link, Integer.valueOf(R.color.qui_common_text_primary));
                        if (w3 == null) {
                            return null;
                        }
                        int i3 = FeedRichTextContentParser.IMAGE_SPAN_BOUNDS;
                        w3.setBounds(0, 0, i3, i3);
                        return w3;
                    }
                });
                this.linkDrawable = lazy2;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return IParseRichTextConfig.a.t(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public HashMap<String, Object> c() {
                return IParseRichTextConfig.a.b(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean d() {
                return IParseRichTextConfig.a.r(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean e() {
                return IParseRichTextConfig.a.q(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public TrimSpaceType f() {
                return TrimSpaceType.LeadingSpaceAndEmptyLine;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return IParseRichTextConfig.a.j(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                List emptyList2;
                Collection<String> a17;
                SearchDataExt ext = data.getExt();
                if (ext == null || (a17 = ext.a()) == null) {
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    return emptyList2;
                }
                return a17;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: getTraceID */
            public String getF221023e() {
                Object obj;
                obj = ((Section) SearchFeedDescSection.this).mData;
                SearchDataExt ext = ((pn1.a) obj).getExt();
                if (ext != null) {
                    return ext.getTraceId();
                }
                return null;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean h() {
                return IParseRichTextConfig.a.m(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return IParseRichTextConfig.a.k(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean j() {
                return IParseRichTextConfig.a.l(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean k() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public float l() {
                return IParseRichTextConfig.a.a(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                return ((Number) this.linkColor.getValue()).intValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean o() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: p */
            public int getF221022d() {
                return IParseRichTextConfig.a.c(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int q() {
                return IParseRichTextConfig.a.d(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public Set<Integer> r() {
                return IParseRichTextConfig.a.v(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int s() {
                return IParseRichTextConfig.a.h(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int t() {
                TextView s17;
                s17 = SearchFeedDescSection.this.s();
                return s17.getResources().getColor(R.color.qui_common_text_link);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return true;
            }

            @Nullable
            public Drawable v() {
                return (Drawable) this.linkDrawable.getValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c cVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.c.f221632a;
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                return cVar.a(t16, context, v());
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                GProStRichTextURLContent gProStRichTextURLContent = t16.urlContent;
                switch (gProStRichTextURLContent.type) {
                    case 7:
                    case 8:
                    case 9:
                        String str = gProStRichTextURLContent.thirdVideoInfo.cover;
                        if (str == null || str.length() == 0) {
                            return true;
                        }
                        break;
                    case 6:
                        return false;
                    default:
                        return true;
                }
            }
        };
        Intrinsics.checkNotNullExpressionValue(contents, "contents");
        Pair s17 = FeedRichTextContentParser.s(feedRichTextContentParser, contents, null, iParseRichTextConfig, valueOf, valueOf2, 1, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) s17.getFirst());
        if (!TextUtils.isEmpty(spannableStringBuilder)) {
            ViewGroup viewGroup4 = this.container;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                viewGroup4 = null;
            }
            viewGroup4.setVisibility(0);
            if (s().getParent() == null) {
                ViewGroup viewGroup5 = this.container;
                if (viewGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                    viewGroup5 = null;
                }
                viewGroup5.addView(s());
            }
            RichTextExpandStrSpanUtil richTextExpandStrSpanUtil = RichTextExpandStrSpanUtil.f221634a;
            ViewGroup viewGroup6 = this.container;
            if (viewGroup6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            } else {
                viewGroup2 = viewGroup6;
            }
            Object parent = viewGroup2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            int h16 = (richTextExpandStrSpanUtil.h((View) parent) - s().getPaddingLeft()) - s().getPaddingRight();
            com.tencent.mobileqq.guild.quicksearch.adapter.h hVar = com.tencent.mobileqq.guild.quicksearch.adapter.h.f231570a;
            TextView s18 = s();
            SearchDataExt ext = data.getExt();
            if (ext == null || (r1 = ext.a()) == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            hVar.f(s18, spannableStringBuilder, emptyList, h16);
            s().setOnTouchListener(hVar.d());
            return;
        }
        ViewGroup viewGroup7 = this.container;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            viewGroup2 = viewGroup7;
        }
        viewGroup2.setVisibility(8);
    }
}
