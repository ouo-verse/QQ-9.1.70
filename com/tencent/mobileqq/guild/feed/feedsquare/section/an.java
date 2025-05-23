package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.section.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J*\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010,\u001a\u0010\u0012\u0004\u0012\u00020(\u0018\u00010'j\u0004\u0018\u0001`)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/an;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Lcom/tencent/input/base/mvicompat/ex/a;", "", ExifInterface.LATITUDE_SOUTH, "T", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", "J2", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "components", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "f", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "mMessageRegistry", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedMainInitBean;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/FeedSectionBeanImplContext;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "mSectionContext", "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "mPlayView", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class an extends GuildFeedSquareFeedBaseSection implements com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k components = new k(new b());

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport mMessageRegistry = new VMMessengerProtocolSupport(this);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> mSectionContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/an$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "", "c", "Landroid/view/View;", "v", "", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements k.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        @Nullable
        public GuildFeedBaseInitBean a() {
            GProStFeed D = an.this.D();
            if (D == null) {
                return null;
            }
            return an.this.F(D);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        public void b(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            an.this.A(v3, "em_sgrp_forum_full_screen");
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        public int c() {
            wo1.c cVar = (wo1.c) SectionIOCKt.getIocInterface(an.this, wo1.c.class);
            if (cVar != null) {
                return cVar.getSortMode();
            }
            return 0;
        }
    }

    private final GuildFeedListVideoItemWidgetView R() {
        return this.components.a();
    }

    private final void S() {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        if (this.mSectionContext == null && (gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class)) != null && (context = gVar.getContext()) != null) {
            this.mSectionContext = context;
            VMMessengerProtocolSupport vMMessengerProtocolSupport = this.mMessageRegistry;
            Intrinsics.checkNotNull(context);
            vMMessengerProtocolSupport.d(context.getMessenger());
        }
    }

    private final void T() {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> bVar = this.mSectionContext;
        if (bVar != null) {
            this.mMessageRegistry.e(bVar.getMessenger());
        }
        this.mSectionContext = null;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent) {
            R().a();
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public com.tencent.mvi.base.route.k I(@NotNull MsgIntent msgIntent) {
        return a.C5857a.d(this, msgIntent);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
        return listOf;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        if (data == null) {
            return;
        }
        this.components.c(data.getBlockData(), position, payload);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> f0() {
        return a.C5857a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.b();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        if (!attached) {
            R().a();
            T();
        } else {
            S();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        T();
        R().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.d(containerView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        yj1.e a16;
        yj1.e a17;
        super.onVisibleChanged(visible);
        if (visible) {
            xj1.f fVar = (xj1.f) SectionIOCKt.getIocInterface(this, xj1.f.class);
            if (fVar != null && (a17 = fVar.a()) != null) {
                int i3 = this.mPosition;
                View mRootView = this.mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                a17.a(i3, mRootView, R());
                return;
            }
            return;
        }
        xj1.f fVar2 = (xj1.f) SectionIOCKt.getIocInterface(this, xj1.f.class);
        if (fVar2 != null && (a16 = fVar2.a()) != null) {
            a16.e(this.mPosition);
        }
    }
}
