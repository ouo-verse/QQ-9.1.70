package com.tencent.mobileqq.guild.feed.search.sections;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.extension.s;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001c\u0010\u001dJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/SearchGuildLongFeedTextOnlyComponents;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "", "highLightWord", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "bean", "", "c", "", "a", "I", "getExactWidth", "()I", "exactWidth", "Landroid/view/View;", "b", "Landroid/view/View;", "containerView", "Landroid/widget/TextView;", "Lkotlin/Lazy;", "e", "()Landroid/widget/TextView;", "titleView", "d", "contentTxtView", "<init>", "(ILandroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SearchGuildLongFeedTextOnlyComponents {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int exactWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View containerView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentTxtView;

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

    public SearchGuildLongFeedTextOnlyComponents(int i3, @NotNull View containerView) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.exactWidth = i3;
        this.containerView = containerView;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$titleView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View view;
                view = SearchGuildLongFeedTextOnlyComponents.this.containerView;
                return (TextView) view.findViewById(R.id.wbj);
            }
        });
        this.titleView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$contentTxtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                View view;
                view = SearchGuildLongFeedTextOnlyComponents.this.containerView;
                TextView textView = new TextView(view.getContext());
                textView.setTextSize(16.0f);
                textView.setMaxLines(2);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setLineSpacing(cw.c(26.0f), 0.0f);
                textView.setTextColor(textView.getContext().getColor(R.color.qui_common_text_primary));
                s.a(textView, 300, 0);
                return textView;
            }
        });
        this.contentTxtView = lazy2;
    }

    private final TextView d() {
        return (TextView) this.contentTxtView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView e() {
        Object value = this.titleView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-titleView>(...)");
        return (TextView) value;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x009f, code lost:
    
        r12 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r12, new com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents.b());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(@NotNull GProStFeed stFeed, @Nullable final List<String> highLightWord, @Nullable GuildFeedBaseInitBean bean) {
        ViewGroup viewGroup;
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        d().setTextColor(this.containerView.getContext().getColorStateList(R.color.qui_common_text_primary));
        TextView e16 = e();
        FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
        ArrayList<GProStRichTextContent> arrayList = stFeed.title.contents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "stFeed.title.contents");
        e16.setText((CharSequence) FeedRichTextContentParser.s(feedRichTextContentParser, arrayList, null, new IParseRichTextConfig<Object>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$bindData$1

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
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$bindData$1$linkColor$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Integer invoke() {
                        TextView e17;
                        e17 = SearchGuildLongFeedTextOnlyComponents.this.e();
                        return Integer.valueOf(e17.getResources().getColor(R.color.qui_common_text_primary));
                    }
                });
                this.linkColor = lazy;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$bindData$1$linkDrawable$2
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
            public boolean a(@NotNull Object obj) {
                return IParseRichTextConfig.a.s(this, obj);
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
                return IParseRichTextConfig.a.u(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return IParseRichTextConfig.a.j(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                List<String> list = highLightWord;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                return new ArrayList(list);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public String getTraceID() {
                return IParseRichTextConfig.a.i(this);
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
            @Nullable
            public Drawable m(@NotNull Object obj) {
                return IParseRichTextConfig.a.g(this, obj);
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
            public int p() {
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
                TextView e17;
                e17 = SearchGuildLongFeedTextOnlyComponents.this.e();
                return e17.getResources().getColor(R.color.qui_common_text_link);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return true;
            }
        }, null, null, 13, null).getFirst());
        ArrayList<GProStRichTextContent> contents = stFeed.contents.contents;
        String str = stFeed.channelInfo.sign.joinGuildSig;
        Intrinsics.checkNotNullExpressionValue(str, "stFeed.channelInfo.sign.joinGuildSig");
        JumpGuildParam.JoinInfoParam d16 = feedRichTextContentParser.d(bean, str);
        String valueOf = String.valueOf(stFeed.channelInfo.sign.channelId);
        String valueOf2 = String.valueOf(stFeed.channelInfo.sign.guildId);
        IParseRichTextConfig<GProStRichTextContent> iParseRichTextConfig = new IParseRichTextConfig<GProStRichTextContent>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$bindData$text$1

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
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$bindData$text$1$linkColor$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Integer invoke() {
                        TextView e17;
                        e17 = SearchGuildLongFeedTextOnlyComponents.this.e();
                        return Integer.valueOf(e17.getResources().getColor(R.color.qui_common_text_primary));
                    }
                });
                this.linkColor = lazy;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.search.sections.SearchGuildLongFeedTextOnlyComponents$bindData$text$1$linkDrawable$2
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
                return IParseRichTextConfig.a.u(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean g() {
                return IParseRichTextConfig.a.j(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @NotNull
            public Collection<String> getHighlightWords() {
                List<String> list = highLightWord;
                if (list == null) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                return new ArrayList(list);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            public String getTraceID() {
                return IParseRichTextConfig.a.i(this);
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
                return IParseRichTextConfig.a.p(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int p() {
                return 15;
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
                TextView e17;
                e17 = SearchGuildLongFeedTextOnlyComponents.this.e();
                return e17.getResources().getColor(R.color.qui_common_text_link);
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

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                if (t16.urlContent.type != 1) {
                    return true;
                }
                return false;
            }
        };
        Intrinsics.checkNotNullExpressionValue(contents, "contents");
        SpannableStringBuilder first = feedRichTextContentParser.r(contents, d16, iParseRichTextConfig, valueOf, valueOf2).getFirst();
        View d17 = d();
        int paddingLeft = (this.exactWidth - d17.getPaddingLeft()) - d17.getPaddingRight();
        if (!TextUtils.isEmpty(first)) {
            com.tencent.mobileqq.guild.quicksearch.adapter.h hVar = com.tencent.mobileqq.guild.quicksearch.adapter.h.f231570a;
            TextView d18 = d();
            if (highLightWord == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            hVar.f(d18, first, emptyList, paddingLeft);
        } else {
            d().setText(this.containerView.getResources().getString(R.string.f144650pc));
        }
        if (d().getParent() == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.topMargin = ViewUtils.dip2px(4.0f);
            d17.setLayoutParams(marginLayoutParams);
            View view = this.containerView;
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.addView(d17);
            }
        }
    }
}
