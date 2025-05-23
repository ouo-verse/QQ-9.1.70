package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.content.Context;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 &*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016R\u001a\u0010\u001e\u001a\u00020\u001a8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListLongContentSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "D", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", "getViewStubLayoutId", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents;", "Lkotlin/Lazy;", "B", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents;", "components", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListLongContentSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildLongFeedContentComponents.c depends;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy components;

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/FeedListLongContentSection$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildLongFeedContentComponents$c;", "", "", "k", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "Lxj1/f;", "j", "", "a", "Landroid/view/View;", "view", "elementId", "", "c", "getRootView", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildLongFeedContentComponents.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedListLongContentSection<Ext> f218586a;

        b(FeedListLongContentSection<Ext> feedListLongContentSection) {
            this.f218586a = feedListLongContentSection;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int a() {
            return 0;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> b(@NotNull Context context) {
            return GuildLongFeedContentComponents.c.a.b(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public void c(@Nullable View view, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float d() {
            return GuildLongFeedContentComponents.c.a.a(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public IParseRichTextConfig<GProStRichTextContent> e(@NotNull Context context) {
            return GuildLongFeedContentComponents.c.a.f(this, context);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float f() {
            return GuildLongFeedContentComponents.c.a.g(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float g() {
            return GuildLongFeedContentComponents.c.a.e(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public GuildFeedBaseInitBean getInitBean() {
            GuildFeedDetailInitBean initFeedDetailInitBeanFromFeed = GuildFeedDetailInitBean.initFeedDetailInitBeanFromFeed(this.f218586a.D());
            Intrinsics.checkNotNullExpressionValue(initFeedDetailInitBeanFromFeed, "initFeedDetailInitBeanFromFeed(getFeedData())");
            return initFeedDetailInitBeanFromFeed;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public View getRootView() {
            View mRootView = ((Section) this.f218586a).mRootView;
            Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
            return mRootView;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public int h() {
            return GuildLongFeedContentComponents.c.a.d(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        public float i() {
            return GuildLongFeedContentComponents.c.a.c(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @Nullable
        public xj1.f j() {
            return (xj1.f) SectionIOCKt.getIocInterface(this.f218586a, xj1.f.class);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents.c
        @NotNull
        public List<String> k() {
            List<String> emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public FeedListLongContentSection() {
        super(FeedListSectionType.LongFeedContent);
        Lazy lazy;
        this.depends = new b(this);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<GuildLongFeedContentComponents>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListLongContentSection$components$2
            final /* synthetic */ FeedListLongContentSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLongFeedContentComponents invoke() {
                return new GuildLongFeedContentComponents(this.this$0.getDepends());
            }
        });
        this.components = lazy;
    }

    private final GuildLongFeedContentComponents B() {
        return (GuildLongFeedContentComponents) this.components.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GProStFeed D() {
        Object obj;
        qj1.h data;
        tk1.c cVar = (tk1.c) this.mData;
        if (cVar != null && (data = cVar.getData()) != null) {
            obj = data.a();
        } else {
            obj = null;
        }
        if (!(obj instanceof GProStFeed)) {
            return null;
        }
        return (GProStFeed) obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: C, reason: from getter */
    public GuildLongFeedContentComponents.c getDepends() {
        return this.depends;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return B().z();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        B().B(attached);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        B().D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        B().F(p());
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        B().G(visible);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        Object obj;
        qj1.h data;
        super.onBindData(bindData, position, payload);
        GProStFeed gProStFeed = null;
        if (bindData != null && (data = bindData.getData()) != null) {
            obj = data.a();
        } else {
            obj = null;
        }
        if (obj instanceof GProStFeed) {
            gProStFeed = (GProStFeed) obj;
        }
        if (gProStFeed == null) {
            QLog.w("FeedListLongContentSection", 1, "[onBindData] feedInfo is null");
        } else {
            B().C(new ij1.g(gProStFeed, ""), position, payload);
        }
    }
}
