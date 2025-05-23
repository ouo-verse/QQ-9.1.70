package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListLongContentSection;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xj1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00118\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/b;", "Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListLongContentSection;", "Lrj1/d;", "", "K", "Landroid/view/View;", "initContainerView", "", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, UserInfo.SEX_FEMALE, "Ljava/lang/Integer;", "_linkColorCache", "com/tencent/mobileqq/guild/feed/feedlist/section/recommend/b$b", "G", "Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/b$b;", "mThemeChangedCallback", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "H", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "depends", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends FeedListLongContentSection<rj1.d> {

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Integer _linkColorCache;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final C7738b mThemeChangedCallback = new C7738b();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final GuildLongFeedContentComponents.c depends = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000O\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0001J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\nH\u0096\u0001J\t\u0010\r\u001a\u00020\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0002H\u0096\u0001J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u001d"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/b$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "Landroid/view/View;", "view", "", "elementId", "", "c", "", "k", "", "a", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "getRootView", "Lxj1/f;", "j", "", "f", "g", h.F, "i", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "b", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildLongFeedContentComponents.c {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ GuildLongFeedContentComponents.c f218607a;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/b$a$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$b;", "", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "t", "Landroid/graphics/drawable/Drawable;", "w", "i", "", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7736a extends GuildLongFeedContentComponents.b {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f218609e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C7736a(Context context, a aVar, b bVar) {
                super(context, aVar);
                this.f218609e = bVar;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return true;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean i() {
                return false;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                Integer num = this.f218609e._linkColorCache;
                if (num == null) {
                    return this.f218609e.K();
                }
                return num.intValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.b, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: w */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                Drawable l3 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.l(super.m(t16));
                if (l3 != null) {
                    return e.a(l3);
                }
                return null;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/b$a$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$d;", "", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStRichTextContent;", "t", "Landroid/graphics/drawable/Drawable;", "w", "", DomainData.DOMAIN_NAME, "()I", "linkColor", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7737b extends GuildLongFeedContentComponents.d {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f218610e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C7737b(Context context, a aVar, b bVar) {
                super(context, aVar);
                this.f218610e = bVar;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.d, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public boolean b() {
                return true;
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.d, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            public int n() {
                Integer num = this.f218610e._linkColorCache;
                if (num == null) {
                    return this.f218610e.K();
                }
                return num.intValue();
            }

            @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.d, com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig
            @Nullable
            /* renamed from: w */
            public Drawable m(@NotNull GProStRichTextContent t16) {
                Intrinsics.checkNotNullParameter(t16, "t");
                Drawable l3 = com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.d.l(super.m(t16));
                if (l3 != null) {
                    return e.a(l3);
                }
                return null;
            }
        }

        a() {
            this.f218607a = b.super.getDepends();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int a() {
            return this.f218607a.a();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new C7736a(context, this, b.this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public void c(@Nullable View view, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            this.f218607a.c(view, elementId);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float d() {
            return 20.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public IParseRichTextConfig<GProStRichTextContent> e(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new C7737b(context, this, b.this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float f() {
            return 16.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float g() {
            return 23.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public GuildFeedBaseInitBean getInitBean() {
            return this.f218607a.getInitBean();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public View getRootView() {
            return this.f218607a.getRootView();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int h() {
            return 500;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float i() {
            return 14.0f;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public f j() {
            return this.f218607a.j();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public List<String> k() {
            return this.f218607a.k();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/recommend/b$b", "Lor0/a;", "", "onThemeChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7738b implements or0.a {
        C7738b() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            b.this._linkColorCache = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int K() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        int color = new com.tencent.mobileqq.guild.quiprofile.c(context, null, 0, false, 14, null).getColor(R.color.qui_common_text_primary);
        this._linkColorCache = Integer.valueOf(color);
        return color;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListLongContentSection
    @NotNull
    /* renamed from: C, reason: from getter */
    public GuildLongFeedContentComponents.c getDepends() {
        return this.depends;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListLongContentSection, com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        QQGuildThemeManager.d(this.mThemeChangedCallback);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListLongContentSection, tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    protected void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        QQGuildThemeManager.c(this.mThemeChangedCallback);
    }
}
