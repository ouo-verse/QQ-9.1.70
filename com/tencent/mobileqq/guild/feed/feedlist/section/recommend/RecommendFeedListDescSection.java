package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListDescSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.Collection;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/RecommendFeedListDescSection;", "Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListDescSection;", "Lrj1/d;", "Landroid/view/View;", "initContainerView", "", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "E", "Ljava/lang/Integer;", "_linkColorCache", "com/tencent/mobileqq/guild/feed/feedlist/section/recommend/RecommendFeedListDescSection$a", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/RecommendFeedListDescSection$a;", "mThemeChangedCallback", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "G", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "B", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$c;", "depends", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedListDescSection extends FeedListDescSection<rj1.d> {

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer _linkColorCache;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final a mThemeChangedCallback = new a();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSquareFeedDescComponents.c depends = new GuildFeedSquareFeedDescComponents.c() { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListDescSection$depends$1

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ GuildFeedSquareFeedDescComponents.c f218599a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/RecommendFeedListDescSection$depends$1$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedDescComponents$b;", "", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "t", "Landroid/graphics/drawable/Drawable;", "v", "i", "", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a extends GuildFeedSquareFeedDescComponents.b {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ RecommendFeedListDescSection f218601e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, RecommendFeedListDescSection$depends$1 recommendFeedListDescSection$depends$1, RecommendFeedListDescSection recommendFeedListDescSection) {
                super(context, recommendFeedListDescSection$depends$1);
                this.f218601e = recommendFeedListDescSection;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return true;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                Integer num;
                num = this.f218601e._linkColorCache;
                if (num != null) {
                    return num.intValue();
                }
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                int color = new com.tencent.mobileqq.guild.quiprofile.c(context, null, 0, false, 14, null).getColor(R.color.qui_common_text_primary);
                this.f218601e._linkColorCache = Integer.valueOf(color);
                return color;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: v */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                Drawable l3 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.l(super.m(t16));
                if (l3 != null) {
                    return e.a(l3);
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            GuildFeedSquareFeedDescComponents.c depends;
            depends = super/*com.tencent.mobileqq.guild.feed.feedlist.section.FeedListDescSection*/.getDepends();
            this.f218599a = depends;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new a(context, this, RecommendFeedListDescSection.this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public HashMap<String, Object> c() {
            return this.f218599a.c();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public IParseRichTextConfig<Object> d(@NotNull final Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new GuildFeedSquareFeedDescComponents.d(context, this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListDescSection$depends$1$getLegacyTitleParseConfig$1

                /* renamed from: e, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final Lazy linkColor;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    Lazy lazy;
                    lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListDescSection$depends$1$getLegacyTitleParseConfig$1$linkColor$2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Integer invoke() {
                            BaseApplication context2 = BaseApplication.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
                            return Integer.valueOf(new com.tencent.mobileqq.guild.quiprofile.c(context2, null, 0, false, 14, null).getColor(R.color.qui_common_text_primary));
                        }
                    });
                    this.linkColor = lazy;
                }

                @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.d, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public boolean b() {
                    return true;
                }

                @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.d, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                @Nullable
                public Drawable m(@NotNull Object t16) {
                    Intrinsics.checkNotNullParameter(t16, "t");
                    Drawable l3 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.l(super.m(t16));
                    if (l3 != null) {
                        return e.a(l3);
                    }
                    return null;
                }

                @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.d, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
                public int n() {
                    return ((Number) this.linkColor.getValue()).intValue();
                }
            };
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public JumpGuildParam.JoinInfoParam e(@NotNull GProStFeed stFeed) {
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            return this.f218599a.e(stFeed);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float f() {
            return 23.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @NotNull
        public Collection<String> g() {
            return this.f218599a.g();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        public float getTextSize() {
            return 16.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedDescComponents.c
        @Nullable
        public String getTraceID() {
            return this.f218599a.getTraceID();
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/RecommendFeedListDescSection$a", "Lor0/a;", "", "onThemeChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements or0.a {
        a() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            RecommendFeedListDescSection.this._linkColorCache = null;
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListDescSection
    @NotNull
    /* renamed from: B, reason: from getter */
    protected GuildFeedSquareFeedDescComponents.c getDepends() {
        return this.depends;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QQGuildThemeManager.d(this.mThemeChangedCallback);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListDescSection, tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    protected void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        QQGuildThemeManager.c(this.mThemeChangedCallback);
    }
}
