package com.tencent.mobileqq.guild.discoveryv2.dialog;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.guild.discoveryv2.content.util.DeleteRecommendData;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "actionSheet", "Lcom/tencent/widget/ActionSheet;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class RecommendFeedbackDialog$configActionSheetItem$1$1 extends Lambda implements Function2<View, ActionSheet, Unit> {
    final /* synthetic */ l<?> $data;
    final /* synthetic */ String $str;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendFeedbackDialog$configActionSheetItem$1$1(String str, l<?> lVar) {
        super(2);
        this.$str = str;
        this.$data = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ActionSheet actionSheet, l lVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        QQToast.makeText(view.getContext(), 2, R.string.f145760sc, 1).show();
        actionSheet.dismiss();
        if (lVar != null) {
            SimpleEventBus.getInstance().dispatchEvent(new DeleteRecommendData(lVar));
        }
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
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_content_feedback_reason", this.$str));
        bt.d(view, "em_sgrp_content_feedback_reason_btn", mapOf, null, null, null, 56, null);
        final l<?> lVar = this.$data;
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RecommendFeedbackDialog$configActionSheetItem$1$1.b(ActionSheet.this, lVar, view2);
            }
        });
    }
}
