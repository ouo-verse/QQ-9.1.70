package com.tencent.mobileqq.guild.feed.feedlist.section;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.guild.api.FeedListSectionType;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0014J0\u0010\u0014\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0006H\u0014R\u001a\u0010\u001c\u001a\u00020\u00168\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListFunctionSection;", "Lrj1/b;", "Ext", "Ltk1/a;", "Landroid/view/View;", "view", "", "B", NodeProps.ON_CLICK, "", "getViewStubLayoutId", "initContainerView", "onInitView", "Ltk1/c;", "bindData", "", "position", "", "", "payload", "u", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/String;", "feedItemElemId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class FeedListFunctionSection<Ext extends rj1.b> extends tk1.a<Ext> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String feedItemElemId;

    public FeedListFunctionSection() {
        super(FeedListSectionType.Function);
        this.feedItemElemId = "em_sgrp_forum_feed";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Map<String, Object> A() {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", String.valueOf(r().getGuildId())), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(r().getChannelId())), TuplesKt.to("sgrp_content_id", r().getFeedId()), TuplesKt.to("sgrp_feed_id", r().getFeedId()), TuplesKt.to("sgrp_rank", Integer.valueOf(getPosition())), TuplesKt.to("sgrp_section_name", ((rj1.b) s()).d()), TuplesKt.to("sgrp_forum_trace_id", kw1.a.f413327a.c(s())));
        return mapOf;
    }

    public void B(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    protected void C() {
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        if1.a.b(rootView, getFeedItemElemId(), r().hashCode() + "#" + getRootView().hashCode(), A(), null, null, null, null, null, 248, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        rj1.a.f431544a.h(q(), r(), (rj1.b) s());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView;
        super.onInitView(initContainerView);
        if (initContainerView instanceof GuildFeedSquareFeedItemView) {
            guildFeedSquareFeedItemView = (GuildFeedSquareFeedItemView) initContainerView;
        } else {
            guildFeedSquareFeedItemView = null;
        }
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView2 = guildFeedSquareFeedItemView;
        if (guildFeedSquareFeedItemView2 != null) {
            GuildFeedSquareFeedItemView.setCombinedClickListener$default(guildFeedSquareFeedItemView2, 0L, new Function1<View, Unit>(this) { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection$onInitView$1
                final /* synthetic */ FeedListFunctionSection<Ext> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    this.this$0.onClick(it);
                    String feedItemElemId = this.this$0.getFeedItemElemId();
                    Map<String, Object> A = this.this$0.A();
                    VideoReport.setElementId(it, feedItemElemId);
                    VideoReport.setElementClickPolicy(it, ClickPolicy.REPORT_NONE);
                    VideoReport.reportEvent("clck", it, A);
                }
            }, new FeedListFunctionSection$onInitView$2(this), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u */
    public void onBindData(@Nullable tk1.c<Ext> bindData, int position, @Nullable List<Object> payload) {
        super.onBindData(bindData, position, payload);
        VideoReport.setEventType(getRootView(), EventAgingType.REALTIME);
        C();
    }

    @NotNull
    /* renamed from: z, reason: from getter */
    public String getFeedItemElemId() {
        return this.feedItemElemId;
    }
}
