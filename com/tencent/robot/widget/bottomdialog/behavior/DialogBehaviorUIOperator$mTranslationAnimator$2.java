package com.tencent.robot.widget.bottomdialog.behavior;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/animation/ValueAnimator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class DialogBehaviorUIOperator$mTranslationAnimator$2 extends Lambda implements Function0<ValueAnimator> {
    final /* synthetic */ DialogBehaviorUIOperator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogBehaviorUIOperator$mTranslationAnimator$2(DialogBehaviorUIOperator dialogBehaviorUIOperator) {
        super(0);
        this.this$0 = dialogBehaviorUIOperator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogBehaviorUIOperator this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.b(((Integer) animatedValue).intValue());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ValueAnimator invoke() {
        ValueAnimator valueAnimator = new ValueAnimator();
        final DialogBehaviorUIOperator dialogBehaviorUIOperator = this.this$0;
        valueAnimator.getInterpolator();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.robot.widget.bottomdialog.behavior.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DialogBehaviorUIOperator$mTranslationAnimator$2.b(DialogBehaviorUIOperator.this, valueAnimator2);
            }
        });
        return valueAnimator;
    }
}
