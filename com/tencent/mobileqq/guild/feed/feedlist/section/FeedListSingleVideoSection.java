package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J0\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016R\u001a\u0010\u001c\u001a\u00020\u00188\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListSingleVideoSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "", "getViewStubLayoutId", "Landroid/view/View;", "initContainerView", "", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "depends", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "D", "Lkotlin/Lazy;", "B", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "components", "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "()Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "mPlayView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListSingleVideoSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final k.b depends;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/feedlist/section/FeedListSingleVideoSection$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "", "c", "Landroid/view/View;", "v", "", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements k.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedListSingleVideoSection<Ext> f218590a;

        a(FeedListSingleVideoSection<Ext> feedListSingleVideoSection) {
            this.f218590a = feedListSingleVideoSection;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        @NotNull
        public GuildFeedBaseInitBean a() {
            return rj1.a.f431544a.a(FeedListSingleVideoSection.A(this.f218590a));
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        public void b(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            VideoReport.setEventType(v3, EventAgingType.REALTIME);
            if1.a.b(v3, "em_sgrp_forum_full_screen", this.f218590a.r().hashCode() + "#" + v3.hashCode(), null, ExposurePolicy.REPORT_NONE, null, null, null, null, 244, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        public int c() {
            return 0;
        }
    }

    public FeedListSingleVideoSection() {
        super(FeedListSectionType.SingleVideo);
        Lazy lazy;
        this.depends = new a(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.guild.feed.feedsquare.section.k>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListSingleVideoSection$components$2
            final /* synthetic */ FeedListSingleVideoSection<Ext> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.feed.feedsquare.section.k invoke() {
                return new com.tencent.mobileqq.guild.feed.feedsquare.section.k(this.this$0.getDepends());
            }
        });
        this.components = lazy;
    }

    public static final /* synthetic */ rj1.b A(FeedListSingleVideoSection feedListSingleVideoSection) {
        return (rj1.b) feedListSingleVideoSection.s();
    }

    private final com.tencent.mobileqq.guild.feed.feedsquare.section.k B() {
        return (com.tencent.mobileqq.guild.feed.feedsquare.section.k) this.components.getValue();
    }

    private final GuildFeedListVideoItemWidgetView D() {
        return B().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: C, reason: from getter */
    public k.b getDepends() {
        return this.depends;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return B().b();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        if (!attached) {
            D().a();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        D().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        com.tencent.mobileqq.guild.feed.feedsquare.section.k B = B();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        B.d(rootView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        yj1.e videoMgr;
        yj1.e videoMgr2;
        super.onVisibleChanged(visible);
        if (visible) {
            com.tencent.mobileqq.guild.feed.topic.c cVar = (com.tencent.mobileqq.guild.feed.topic.c) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.topic.c.class);
            if (cVar != null && (videoMgr2 = cVar.getVideoMgr()) != null) {
                int position = getPosition();
                View rootView = getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                videoMgr2.a(position, rootView, D());
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.feed.topic.c cVar2 = (com.tencent.mobileqq.guild.feed.topic.c) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.topic.c.class);
        if (cVar2 != null && (videoMgr = cVar2.getVideoMgr()) != null) {
            videoMgr.e(getPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        Object a16 = r().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        ij1.g gVar = new ij1.g((GProStFeed) a16);
        gVar.z(((rj1.b) s()).c());
        B().c(gVar, position, payload);
    }
}
