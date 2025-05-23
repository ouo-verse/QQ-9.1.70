package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import com.tencent.mobileqq.zplan.aio.panel.entrance.view.SpaceEntranceBackground;
import com.tencent.mobileqq.zplan.utils.CoroutineUtilKt;
import fi3.bp;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1", f = "SpaceEntrancesAdapter.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ bp $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1(bp bpVar, Continuation<? super SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1> continuation) {
        super(2, continuation);
        this.$this_apply = bpVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1(this.$this_apply, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.$this_apply.f399137b, (Property<SpaceEntranceBackground, Float>) View.ALPHA, 1.0f, 0.0f).setDuration(369L);
            Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(zplanPanelSpaceE\u2026etDuration(1000 / 24 * 9)");
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
        return ((SpaceEntrancesAdapter$onBindViewHolder$1$1$1$fadeOutJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
