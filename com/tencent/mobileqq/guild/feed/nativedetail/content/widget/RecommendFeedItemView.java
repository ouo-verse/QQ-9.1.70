package com.tencent.mobileqq.guild.feed.nativedetail.content.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.widget.GuildRoundBoardImageView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.FeedRichTextContentParser;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.TrimSpaceType;
import com.tencent.mobileqq.guild.feed.util.m;
import com.tencent.mobileqq.guild.feed.util.n;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0018\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\u001d\u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/RecommendFeedItemView;", "Landroid/widget/FrameLayout;", "", PhotoCategorySummaryInfo.AVATAR_URL, "", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "g", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinParam", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/d;", "listener", "joinInfoParam", "b", "Lx12/e;", "d", "Lx12/e;", "binding", "Lwq0/l;", "Lkotlin/Lazy;", "()Lwq0/l;", "txtView", "com/tencent/mobileqq/guild/feed/nativedetail/content/widget/RecommendFeedItemView$mConfig$1", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/RecommendFeedItemView$mConfig$1;", "mConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedItemView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private x12.e binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendFeedItemView$mConfig$1 mConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1] */
    public RecommendFeedItemView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        x12.e g16 = x12.e.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                Context context2 = RecommendFeedItemView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                l d16 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.d(bVar, context2, 0.0f, 0, 0.0f, 0, 30, null);
                d16.setMaxLines(2);
                d16.setEllipsize(TextUtils.TruncateAt.END);
                return d16;
            }
        });
        this.txtView = lazy;
        this.mConfig = new IParseRichTextConfig<GProStRichTextContent>(this) { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy linkColor;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy linkDrawable;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy2;
                Lazy lazy3;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1$linkColor$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Integer invoke() {
                        return Integer.valueOf(RecommendFeedItemView.this.getContext().getResources().getColor(R.color.qui_common_text_primary));
                    }
                });
                this.linkColor = lazy2;
                lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1$linkDrawable$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Drawable invoke() {
                        Drawable drawable = ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.guild_feed_url_icon_link);
                        if (drawable != null) {
                            int i3 = FeedRichTextContentParser.IMAGE_SPAN_BOUNDS;
                            drawable.setBounds(0, 0, i3, i3);
                        } else {
                            drawable = null;
                        }
                        return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.l(drawable);
                    }
                });
                this.linkDrawable = lazy3;
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
                return IParseRichTextConfig.a.f(this);
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
                return IParseRichTextConfig.a.o(this);
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
                return IParseRichTextConfig.a.e(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return IParseRichTextConfig.a.n(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent gProStRichTextContent) {
                return IParseRichTextConfig.a.g(this, gProStRichTextContent);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent gProStRichTextContent) {
                return IParseRichTextConfig.a.s(this, gProStRichTextContent);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(d listener, GProStFeed stFeed, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(stFeed, "$stFeed");
        listener.a(stFeed);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final l d() {
        return (l) this.txtView.getValue();
    }

    private final void e(String avatarUrl) {
        GuildRoundBoardImageView guildRoundBoardImageView = this.binding.f446916e;
        guildRoundBoardImageView.setCornerRadiusAndMode(com.tencent.guild.aio.util.c.b(6), 1);
        u.l(guildRoundBoardImageView, avatarUrl, null);
        guildRoundBoardImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private final void f(GProStFeed stFeed, JumpGuildParam.JoinInfoParam joinParam) {
        Pair<SpannableStringBuilder, com.tencent.aio.widget.textView.view.b> r16;
        if (stFeed.feedType == 2) {
            FeedRichTextContentParser feedRichTextContentParser = FeedRichTextContentParser.f221393a;
            ArrayList<GProStRichTextContent> contents = stFeed.title.contents;
            String valueOf = String.valueOf(stFeed.channelInfo.sign.channelId);
            String valueOf2 = String.valueOf(stFeed.channelInfo.sign.guildId);
            RecommendFeedItemView$mConfig$1 recommendFeedItemView$mConfig$1 = this.mConfig;
            Intrinsics.checkNotNullExpressionValue(contents, "contents");
            r16 = feedRichTextContentParser.r(contents, joinParam, recommendFeedItemView$mConfig$1, valueOf, valueOf2);
        } else {
            FeedRichTextContentParser feedRichTextContentParser2 = FeedRichTextContentParser.f221393a;
            ArrayList<GProStRichTextContent> contents2 = stFeed.contents.contents;
            String valueOf3 = String.valueOf(stFeed.channelInfo.sign.channelId);
            String valueOf4 = String.valueOf(stFeed.channelInfo.sign.guildId);
            RecommendFeedItemView$mConfig$1 recommendFeedItemView$mConfig$12 = this.mConfig;
            Intrinsics.checkNotNullExpressionValue(contents2, "contents");
            r16 = feedRichTextContentParser2.r(contents2, joinParam, recommendFeedItemView$mConfig$12, valueOf3, valueOf4);
        }
        if (!TextUtils.isEmpty(r16.getFirst())) {
            d().setTextSize(16.0f);
            d().c(22.0f);
            l d16 = d();
            SpannableStringBuilder first = r16.getFirst();
            String str = stFeed.idd;
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.idd");
            d16.f(first, str);
            this.binding.f446913b.setVisibility(0);
            if (d().getView().getParent() == null) {
                this.binding.f446913b.addView(d().getView());
                return;
            }
            return;
        }
        this.binding.f446913b.setVisibility(8);
    }

    private final void g(GProStFeed stFeed) {
        n b16 = m.b(stFeed);
        if (!TextUtils.isEmpty(b16.getUrl())) {
            e(b16.getUrl());
            if (b16.getType() == 2) {
                this.binding.f446919h.setVisibility(0);
                return;
            } else {
                this.binding.f446919h.setVisibility(8);
                return;
            }
        }
        this.binding.f446918g.setVisibility(8);
    }

    public final void b(@NotNull final GProStFeed stFeed, @NotNull final d listener, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(listener, "listener");
        g(stFeed);
        f(stFeed, joinInfoParam);
        this.binding.f446920i.setText("\u6d4f\u89c8 " + stFeed.visitorInfo.viewCount);
        this.binding.f446917f.setText("\u8d5e " + stFeed.totalPrefer.preferCountWithoutLike);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecommendFeedItemView.c(d.this, stFeed, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1] */
    public RecommendFeedItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        x12.e g16 = x12.e.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$txtView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b bVar = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.f221402a;
                Context context2 = RecommendFeedItemView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                l d16 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.b.d(bVar, context2, 0.0f, 0, 0.0f, 0, 30, null);
                d16.setMaxLines(2);
                d16.setEllipsize(TextUtils.TruncateAt.END);
                return d16;
            }
        });
        this.txtView = lazy;
        this.mConfig = new IParseRichTextConfig<GProStRichTextContent>(this) { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy linkColor;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy linkDrawable;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Lazy lazy2;
                Lazy lazy3;
                lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1$linkColor$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final Integer invoke() {
                        return Integer.valueOf(RecommendFeedItemView.this.getContext().getResources().getColor(R.color.qui_common_text_primary));
                    }
                });
                this.linkColor = lazy2;
                lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.widget.RecommendFeedItemView$mConfig$1$linkDrawable$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @Nullable
                    public final Drawable invoke() {
                        Drawable drawable = ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.guild_feed_url_icon_link);
                        if (drawable != null) {
                            int i3 = FeedRichTextContentParser.IMAGE_SPAN_BOUNDS;
                            drawable.setBounds(0, 0, i3, i3);
                        } else {
                            drawable = null;
                        }
                        return com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.l(drawable);
                    }
                });
                this.linkDrawable = lazy3;
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
                return IParseRichTextConfig.a.f(this);
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
                return IParseRichTextConfig.a.o(this);
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
                return IParseRichTextConfig.a.e(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean u() {
                return IParseRichTextConfig.a.n(this);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            public Drawable m(@NotNull GProStRichTextContent gProStRichTextContent) {
                return IParseRichTextConfig.a.g(this, gProStRichTextContent);
            }

            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public boolean a(@NotNull GProStRichTextContent gProStRichTextContent) {
                return IParseRichTextConfig.a.s(this, gProStRichTextContent);
            }
        };
    }
}
