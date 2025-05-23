package com.tencent.mobileqq.zplan.aio.panel.entrance.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import com.tencent.mobileqq.zplan.utils.CoroutineUtilKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.view.SpaceEntranceBackground$setPressed$1", f = "SpaceEntranceBackground.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SpaceEntranceBackground$setPressed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $oldJob;
    final /* synthetic */ boolean $pressed;
    int label;
    final /* synthetic */ SpaceEntranceBackground this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceEntranceBackground$setPressed$1(Job job, boolean z16, SpaceEntranceBackground spaceEntranceBackground, Continuation<? super SpaceEntranceBackground$setPressed$1> continuation) {
        super(2, continuation);
        this.$oldJob = job;
        this.$pressed = z16;
        this.this$0 = spaceEntranceBackground;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceEntranceBackground$setPressed$1(this.$oldJob, this.$pressed, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.$oldJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            boolean z16 = this.$pressed;
            float f16 = z16 ? 0.9f : 1.0f;
            long j3 = z16 ? 328L : 82L;
            AnimatorSet animatorSet = new AnimatorSet();
            SpaceEntranceBackground spaceEntranceBackground = this.this$0;
            animatorSet.playTogether(ObjectAnimator.ofFloat(spaceEntranceBackground, (Property<SpaceEntranceBackground, Float>) View.SCALE_X, spaceEntranceBackground.getScaleX(), f16).setDuration(j3), ObjectAnimator.ofFloat(spaceEntranceBackground, (Property<SpaceEntranceBackground, Float>) View.SCALE_Y, spaceEntranceBackground.getScaleY(), f16).setDuration(j3));
            this.label = 1;
            if (CoroutineUtilKt.a(animatorSet, this) == coroutine_suspended) {
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
        return ((SpaceEntranceBackground$setPressed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
