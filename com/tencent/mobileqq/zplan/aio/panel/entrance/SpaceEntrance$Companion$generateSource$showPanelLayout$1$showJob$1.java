package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.mobileqq.zplan.utils.CoroutineUtilKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1", f = "SpaceEntrance.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<View> $behindViews;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1(List<? extends View> list, Continuation<? super SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1> continuation) {
        super(2, continuation);
        this.$behindViews = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List list, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setAlpha(floatValue);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1(this.$behindViews, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(369L);
            final List<View> list = this.$behindViews;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zplan.aio.panel.entrance.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1.b(list, valueAnimator);
                }
            });
            Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(1f, 0f).setDurat\u2026  }\n                    }");
            this.label = 1;
            if (CoroutineUtilKt.a(duration, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpaceEntrance$Companion$generateSource$showPanelLayout$1$showJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
