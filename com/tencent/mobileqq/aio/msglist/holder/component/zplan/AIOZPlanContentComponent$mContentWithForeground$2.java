package com.tencent.mobileqq.aio.msglist.holder.component.zplan;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.zplan.AIOZPlanContentComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
final class AIOZPlanContentComponent$mContentWithForeground$2 extends Lambda implements Function0<ConstraintLayout> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AIOZPlanContentComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOZPlanContentComponent$mContentWithForeground$2(Context context, AIOZPlanContentComponent aIOZPlanContentComponent) {
        super(0);
        this.$context = context;
        this.this$0 = aIOZPlanContentComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AIOZPlanContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new ZPlanItemClickIntent(AIOZPlanContentComponent.u2(this$0)));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ConstraintLayout invoke() {
        AIOZPlanContentComponent.ZPlanSelectableLinearLayout x26;
        View Y1;
        View Y12;
        ConstraintLayout constraintLayout = new ConstraintLayout(this.$context);
        final AIOZPlanContentComponent aIOZPlanContentComponent = this.this$0;
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        x26 = aIOZPlanContentComponent.x2();
        constraintLayout.addView(x26);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.matchConstraintPercentWidth = 1.0f;
        layoutParams.matchConstraintPercentHeight = 1.0f;
        Y1 = aIOZPlanContentComponent.Y1();
        constraintLayout.addView(Y1, layoutParams);
        Y12 = aIOZPlanContentComponent.Y1();
        Y12.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.zplan.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOZPlanContentComponent$mContentWithForeground$2.b(AIOZPlanContentComponent.this, view);
            }
        });
        return constraintLayout;
    }
}
