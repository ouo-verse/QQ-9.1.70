package com.tencent.mobileqq.guild.discoveryv2.dialog;

import android.view.View;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Landroid/view/View;", "actionSheet", "Lcom/tencent/widget/ActionSheet;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class RecommendFeedbackDialog$show$actionSheet$1$1 extends Lambda implements Function2<View, ActionSheet, Unit> {
    public static final RecommendFeedbackDialog$show$actionSheet$1$1 INSTANCE = new RecommendFeedbackDialog$show$actionSheet$1$1();

    RecommendFeedbackDialog$show$actionSheet$1$1() {
        super(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ActionSheet actionSheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
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
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        bt.d(view, "em_sgrp_content_feedback_close_btn", null, null, null, null, 60, null);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RecommendFeedbackDialog$show$actionSheet$1$1.b(ActionSheet.this, view2);
            }
        });
    }
}
