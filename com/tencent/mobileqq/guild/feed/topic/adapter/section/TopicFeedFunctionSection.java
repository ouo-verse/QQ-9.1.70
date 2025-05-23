package com.tencent.mobileqq.guild.feed.topic.adapter.section;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0014J*\u0010\u0018\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016H\u0014J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\nH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/TopicFeedFunctionSection;", "Lcom/tencent/mobileqq/guild/feed/topic/adapter/section/b;", "Lvn1/b;", "Landroid/view/View$OnClickListener;", "", "v", "", "", "", "u", "Landroid/view/View;", "view", "", "t", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "itemView", "onInitView", "p0", "", "p1", "", "p2", "w", NodeProps.ON_CLICK, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicFeedFunctionSection extends b<vn1.b> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: private */
    public final void t(View view) {
        VideoReport.setElementId(view, "em_sgrp_forum_hold_share");
        VideoReport.reportEvent("dt_clck", view, u());
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Map<String, Object> u() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", String.valueOf(((vn1.b) this.mData).d().getGuildId())), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(((vn1.b) this.mData).d().getChannelId())), TuplesKt.to("sgrp_content_id", ((vn1.b) this.mData).d().getFeedId().toString()), TuplesKt.to("sgrp_feed_id", ((vn1.b) this.mData).d().getFeedId().toString()), TuplesKt.to("sgrp_rank", Integer.valueOf(this.mPosition)), TuplesKt.to("sgrp_section_name", ((vn1.b) this.mData).getExt().getPageData().getStr()), TuplesKt.to("sgrp_forum_trace_id", ((vn1.b) this.mData).getExt().getTraceId()));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean v() {
        bn bnVar = bn.f223895a;
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        return bnVar.g((vn1.b) mData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        if1.a.b(rootView, "em_sgrp_forum_feed", ((vn1.b) this.mData).getItemId() + "#" + getRootView().hashCode(), u(), null, ClickPolicy.REPORT_NONE, null, null, null, 232, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        View rootView = getRootView();
        Map<String, Object> u16 = u();
        VideoReport.setElementId(rootView, "em_sgrp_forum_feed");
        VideoReport.setElementClickPolicy(rootView, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", rootView, u16);
        xn1.e eVar = xn1.e.f448187a;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        eVar.k(context, (vn1.b) mData);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View itemView) {
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        if (itemView instanceof GuildFeedSquareFeedItemView) {
            guildFeedSquareFeedItemView = (GuildFeedSquareFeedItemView) itemView;
        } else {
            guildFeedSquareFeedItemView = null;
        }
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView2 = guildFeedSquareFeedItemView;
        if (guildFeedSquareFeedItemView2 != null) {
            GuildFeedSquareFeedItemView.setCombinedClickListener$default(guildFeedSquareFeedItemView2, 0L, new TopicFeedFunctionSection$onInitView$1(this), new TopicFeedFunctionSection$onInitView$2(this), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable vn1.b p06, int p16, @Nullable List<Object> p26) {
        VideoReport.setEventType(getRootView(), EventAgingType.REALTIME);
        x();
    }
}
