package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.section.f;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.AbsGuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0014J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/m;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "data", "", "position", "", "", "payload", "r", "", "attached", "onAttachedChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f;", "components", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m extends com.tencent.mobileqq.guild.feed.topic.adapter.section.b<vn1.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.section.f components = new com.tencent.mobileqq.guild.feed.feedsquare.section.f(new b());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016R\u001a\u0010\u0015\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/adapter/section/m$b", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/f$b;", "", "dataSize", "d", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getRecycledViewPool", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "", "i", "v", "", "elementId", "c", tl.h.F, "a", "I", "g", "()I", "maxRow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements f.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int maxRow = 1;

        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public Object a() {
            return f.b.a.b(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void c(@Nullable View v3, @NotNull String elementId) {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            if (v3 == null) {
                return;
            }
            VideoReport.setEventType(v3, EventAgingType.REALTIME);
            if1.a.b(v3, "em_sgrp_forum_full_screen", ((vn1.b) ((Section) m.this).mData).hashCode() + "#" + v3.hashCode(), null, ExposurePolicy.REPORT_NONE, null, null, null, null, 244, null);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public int d(int dataSize) {
            return 3;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @NotNull
        public AbsGuildFeedMediaSizeUtils e() {
            return f.b.a.a(this);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void f(@NotNull RoundCornerLayout roundCornerLayout, int i3, int i16) {
            f.b.a.c(this, roundCornerLayout, i3, i16);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        /* renamed from: g, reason: from getter */
        public int getMaxRow() {
            return this.maxRow;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        @Nullable
        public RecyclerView.RecycledViewPool getRecycledViewPool() {
            return null;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void h(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            m.this.s();
            xn1.e eVar = xn1.e.f448187a;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            Object mData = ((Section) m.this).mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            eVar.k(context, (vn1.b) mData);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.f.b
        public void i(int pos, @NotNull View view) {
            GuildFeedPublishInfo guildFeedPublishInfo;
            Intrinsics.checkNotNullParameter(view, "view");
            xn1.e eVar = xn1.e.f448187a;
            Object mData = ((Section) m.this).mData;
            Intrinsics.checkNotNullExpressionValue(mData, "mData");
            vn1.b bVar = (vn1.b) mData;
            GuildTaskProgressState taskProgressState = ((vn1.b) ((Section) m.this).mData).getTaskProgressState();
            if (taskProgressState != null) {
                guildFeedPublishInfo = com.tencent.mobileqq.guild.feed.feedsquare.data.g.a(taskProgressState, ((vn1.b) ((Section) m.this).mData).d().w());
            } else {
                guildFeedPublishInfo = null;
            }
            eVar.l(view, bVar, pos, guildFeedPublishInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s() {
        Object obj;
        qj1.h d16;
        vn1.b bVar = (vn1.b) this.mData;
        GProStFeed gProStFeed = null;
        if (bVar != null && (d16 = bVar.d()) != null) {
            obj = d16.a();
        } else {
            obj = null;
        }
        if (obj instanceof GProStFeed) {
            gProStFeed = (GProStFeed) obj;
        }
        if (gProStFeed != null && gProStFeed.externalCommentList.isEmpty()) {
            QLog.d("TopicFeedMultiImageSection", 4, "[printCommentLog] externalCommentList.isEmpty");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.e();
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        super.onAttachedChanged(attached);
        if (attached) {
            this.components.f();
        } else {
            this.components.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.components.i(rootView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull vn1.b data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.components.g(data.d(), position, payload);
    }
}
