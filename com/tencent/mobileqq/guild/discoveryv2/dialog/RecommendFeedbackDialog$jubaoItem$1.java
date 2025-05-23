package com.tencent.mobileqq.guild.discoveryv2.dialog;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.util.DeleteRecommendData;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "actionSheet", "Lcom/tencent/widget/ActionSheet;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class RecommendFeedbackDialog$jubaoItem$1 extends Lambda implements Function2<View, ActionSheet, Unit> {
    final /* synthetic */ RecommendAbsFeedData $data;
    final /* synthetic */ String $jubaoStr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFeedbackDialog$jubaoItem$1(String str, RecommendAbsFeedData recommendAbsFeedData) {
        super(2);
        this.$jubaoStr = str;
        this.$data = recommendAbsFeedData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final RecommendAbsFeedData data, ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuildFeed(view.getContext(), String.valueOf(data.getRecommendItem().getPoster().getTinyId()), data.getRecommendItem().getIdd(), String.valueOf(data.getRecommendItem().getGuildInfo().getGuildId()), String.valueOf(data.getRecommendItem().getGuildInfo().getChannelId()), new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.dialog.RecommendFeedbackDialog$jubaoItem$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                SimpleEventBus.getInstance().dispatchEvent(new DeleteRecommendData(RecommendAbsFeedData.this));
            }
        });
        actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, ActionSheet actionSheet) {
        invoke2(view, actionSheet);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View view, @NotNull final ActionSheet actionSheet) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_content_feedback_reason", this.$jubaoStr));
        bt.d(view, "em_sgrp_content_feedback_reason_btn", mapOf, null, null, null, 56, null);
        final RecommendAbsFeedData recommendAbsFeedData = this.$data;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RecommendFeedbackDialog$jubaoItem$1.b(RecommendAbsFeedData.this, actionSheet, view2);
            }
        });
    }
}
