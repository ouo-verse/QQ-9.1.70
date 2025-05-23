package com.tencent.mobileqq.guild.feed.search.sections;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0014J*\u0010\u0011\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/search/sections/d;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lpn1/a;", "Landroid/view/View;", "clickView", "", "r", "", "getViewStubLayoutId", "containerView", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "<init>", "()V", "d", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends Section<pn1.a> {
    /* JADX WARN: Multi-variable type inference failed */
    private final void r(View clickView) {
        Context context = clickView.getContext();
        QRouteApi api = QRoute.api(IGuildFeedNativeDetailApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedNativeDetailApi::class.java)");
        boolean a16 = IGuildFeedNativeDetailApi.a.a((IGuildFeedNativeDetailApi) api, ((pn1.a) this.mData).d().getFeedId(), ((pn1.a) this.mData).d().x(), ((pn1.a) this.mData).d().getFunctionList(), false, 8, null);
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
        Bundle bundle = new Bundle();
        bundle.putString("guildId", String.valueOf(((pn1.a) this.mData).d().getGuildId()));
        bundle.putString("channelId", String.valueOf(((pn1.a) this.mData).d().getChannelId()));
        bundle.putString("posterTinyId", ((pn1.a) this.mData).d().r());
        bundle.putString("feedId", ((pn1.a) this.mData).d().getFeedId());
        bundle.putInt("shareSource", 8);
        bundle.putInt("immersive_source", 15);
        bundle.putLong(WadlProxyConsts.CREATE_TIME, ((pn1.a) this.mData).d().getCreateTime());
        bundle.putString("visitorTinyId", ch.g());
        bundle.putString("inviteCode", "");
        bundle.putParcelable("joinInfoParam", new JumpGuildParam.JoinInfoParam());
        bundle.putInt("businessType", 23);
        Unit unit = Unit.INSTANCE;
        iGuildFeedLauncherApi.launchGuildFeedDetailActivity(context, bundle, !a16);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_feed_id", ((pn1.a) this.mData).d().getFeedId());
        kw1.a aVar = kw1.a.f413327a;
        Object mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        hashMap.put("search_trace_id", aVar.c(mData));
        bt.f235484a.g(clickView, "em_sgrp_search_feed", "clck", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(d this$0, View containerView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("SearchFeedFunctionSection", "click: " + ((pn1.a) this$0.mData).getType() + "-" + this$0.mData.getClass().getSimpleName() + " ");
        }
        this$0.r(containerView);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull final View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        containerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.search.sections.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.t(d.this, containerView, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable pn1.a data, int position, @Nullable List<Object> payload) {
    }
}
