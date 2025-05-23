package com.tencent.mobileqq.guild.feed.feedlist.section.recommend;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qj1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0014J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0014R\u001a\u0010\u0013\u001a\u00020\f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedlist/section/recommend/RecommendFeedListFunctionSection;", "Lcom/tencent/mobileqq/guild/feed/feedlist/section/FeedListFunctionSection;", "Lrj1/d;", "Landroid/view/View;", "initContainerView", "", "onInitView", "view", "B", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/String;", "feedItemElemId", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class RecommendFeedListFunctionSection extends FeedListFunctionSection<rj1.d> {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String feedItemElemId = "em_sgrp_one_forum_module";

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ rj1.d G(RecommendFeedListFunctionSection recommendFeedListFunctionSection) {
        return (rj1.d) recommendFeedListFunctionSection.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0092, code lost:
    
        r1 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r2, " \u00b7 ", null, null, 0, null, com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListFunctionSection$getReportParams$1.INSTANCE, 30, null);
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, Object> A() {
        String str;
        Map<String, Object> mapOf;
        Pair[] pairArr = new Pair[7];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("sgrp_channel_id", String.valueOf(r().getGuildId()));
        pairArr[1] = TuplesKt.to("sgrp_sub_channel_id", String.valueOf(r().getChannelId()));
        int position = getPosition();
        com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar = (com.tencent.mobileqq.guild.discoveryv2.fragment.e) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class);
        if (eVar != null) {
            i3 = eVar.d();
        }
        pairArr[2] = TuplesKt.to("sgrp_rank", Integer.valueOf(position - i3));
        pairArr[3] = TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, ((rj1.d) s()).getRecommendExt().getTraceId());
        pairArr[4] = TuplesKt.to("sgrp_forum_trace_id", ((rj1.d) s()).getRecommendExt().getTraceId());
        IGProContentRecommendGuild guildInfo = ((rj1.d) s()).getGuildInfo();
        if (guildInfo == null || (r2 = guildInfo.getTagList()) == null || str == null) {
            str = "";
        }
        pairArr[5] = TuplesKt.to("sgrp_explicit_tag", str);
        pairArr[6] = TuplesKt.to("sgrp_feed_id", r().getFeedId());
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection
    public void B(@NotNull View view) {
        rj1.c cVar;
        com.tencent.mobileqq.guild.discoveryv2.fragment.e eVar;
        com.tencent.mobileqq.guild.discoveryv2.content.recommend.d clickProcessor;
        Intrinsics.checkNotNullParameter(view, "view");
        T t16 = this.mData;
        if (t16 instanceof rj1.c) {
            cVar = (rj1.c) t16;
        } else {
            cVar = null;
        }
        if (cVar != null && (eVar = (com.tencent.mobileqq.guild.discoveryv2.fragment.e) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.discoveryv2.fragment.e.class)) != null && (clickProcessor = eVar.getClickProcessor()) != null) {
            clickProcessor.i(cVar, view, getPosition());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection
    protected void C() {
        rj1.c cVar;
        Map mapOf;
        T t16 = this.mData;
        if (t16 instanceof rj1.c) {
            cVar = (rj1.c) t16;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            return;
        }
        View rootView = getRootView();
        String str = r().hashCode() + "#" + getRootView().hashCode();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        Map<String, Object> A = A();
        IDynamicParams p16 = RecommendReportHelperKt.p(cVar, getPosition());
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        if1.a.b(rootView, "em_sgrp_one_forum_module", str, A, null, clickPolicy, endExposurePolicy, Double.valueOf(0.3d), p16, 8, null);
        View findViewById = p().findViewById(R.id.f71223nk);
        String str2 = r().hashCode() + "#" + p().hashCode();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_sub_channel_id", String.valueOf(r().getChannelId())), TuplesKt.to("sgrp_content_id", r().getFeedId()), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, ((rj1.d) s()).getRecommendExt().getTraceId()));
        IDynamicParams p17 = RecommendReportHelperKt.p(cVar, getPosition());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.recommend_feed_container)");
        if1.a.b(findViewById, "em_sgrp_one_forum_modul_feed", str2, mapOf, null, null, endExposurePolicy, Double.valueOf(0.8d), p17, 24, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        rj1.a.f431544a.e(view, r(), (rj1.b) s());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection, tk1.a, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View initContainerView) {
        super.onInitView(initContainerView);
        final View findViewById = p().findViewById(R.id.f71223nk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026recommend_feed_container)");
        final long j3 = 200;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListFunctionSection$onInitView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Context q16;
                h r16;
                EventCollector.getInstance().onViewClickedBefore(it);
                findViewById.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                rj1.a aVar = rj1.a.f431544a;
                q16 = this.q();
                r16 = this.r();
                aVar.h(q16, r16, RecommendFeedListFunctionSection.G(this));
                final View view = findViewById;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedlist.section.recommend.RecommendFeedListFunctionSection$onInitView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.feedlist.section.FeedListFunctionSection
    @NotNull
    /* renamed from: z, reason: from getter */
    public String getFeedItemElemId() {
        return this.feedItemElemId;
    }
}
