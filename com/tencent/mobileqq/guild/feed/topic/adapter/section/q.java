package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.section.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.topic.PageData;
import com.tencent.mobileqq.guild.feed.video.widget.GuildFeedListVideoItemWidgetView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/q;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", "getViewStubLayoutId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "data", "", "position", "", "", "payload", "r", "", NodeProps.VISIBLE, "onVisibleChanged", "attached", "onAttachedChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k;", "components", "Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/feed/video/widget/GuildFeedListVideoItemWidgetView;", "mPlayView", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class q extends b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.k components = new com.tencent.mobileqq.guild.feed.feedsquare.section.k(new a());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/q$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/k$b;", "", "c", "Landroid/view/View;", "v", "", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements k.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        @Nullable
        public GuildFeedBaseInitBean a() {
            xn1.e eVar = xn1.e.f448187a;
            Object mData = ((Section) q.this).mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            return eVar.a((vn1.b) mData);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        public void b(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            VideoReport.setEventType(v3, EventAgingType.REALTIME);
            if1.a.b(v3, "em_sgrp_forum_full_screen", ((vn1.b) ((Section) q.this).mData).hashCode() + "#" + v3.hashCode(), null, ExposurePolicy.REPORT_NONE, null, null, null, null, 244, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.k.b
        public int c() {
            PageData pageData = ((vn1.b) ((Section) q.this).mData).getExt().getPageData();
            PageData.Companion companion = PageData.INSTANCE;
            if (Intrinsics.areEqual(pageData, companion.a())) {
                return 3;
            }
            if (Intrinsics.areEqual(pageData, companion.b())) {
                return 1;
            }
            return 2;
        }
    }

    private final GuildFeedListVideoItemWidgetView q() {
        return this.components.a();
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
            q().a();
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        q().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.components.d(rootView);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        yj1.e videoMgr;
        yj1.e videoMgr2;
        super.onVisibleChanged(visible);
        if (visible) {
            com.tencent.mobileqq.guild.feed.topic.c cVar = (com.tencent.mobileqq.guild.feed.topic.c) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.topic.c.class);
            if (cVar != null && (videoMgr2 = cVar.getVideoMgr()) != null) {
                int i3 = this.mPosition;
                View mRootView = this.mRootView;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                videoMgr2.a(i3, mRootView, q());
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.feed.topic.c cVar2 = (com.tencent.mobileqq.guild.feed.topic.c) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.topic.c.class);
        if (cVar2 != null && (videoMgr = cVar2.getVideoMgr()) != null) {
            videoMgr.e(this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object a16 = data.d().a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed");
        ij1.g gVar = new ij1.g((GProStFeed) a16);
        gVar.z(((vn1.b) this.mData).getTaskProgressState());
        this.components.c(gVar, position, payload);
    }
}
