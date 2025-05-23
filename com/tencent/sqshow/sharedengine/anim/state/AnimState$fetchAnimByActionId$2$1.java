package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.animation.ZPlanAction;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.sharedengine.anim.state.AnimState$fetchAnimByActionId$2$1", f = "AnimState.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class AnimState$fetchAnimByActionId$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $actionId;
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ Continuation<com.tencent.filament.zplan.animation.b> $it;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ c $zplanSpanContext;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnimState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AnimState$fetchAnimByActionId$2$1(AnimState animState, EnumUserGender enumUserGender, int i3, c cVar, FilamentUrlTemplate filamentUrlTemplate, Continuation<? super com.tencent.filament.zplan.animation.b> continuation, Continuation<? super AnimState$fetchAnimByActionId$2$1> continuation2) {
        super(2, continuation2);
        this.this$0 = animState;
        this.$gender = enumUserGender;
        this.$actionId = i3;
        this.$zplanSpanContext = cVar;
        this.$urlTemplate = filamentUrlTemplate;
        this.$it = continuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnimState$fetchAnimByActionId$2$1 animState$fetchAnimByActionId$2$1 = new AnimState$fetchAnimByActionId$2$1(this.this$0, this.$gender, this.$actionId, this.$zplanSpanContext, this.$urlTemplate, this.$it, continuation);
        animState$fetchAnimByActionId$2$1.L$0 = obj;
        return animState$fetchAnimByActionId$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, null, null, new AnimState$fetchAnimByActionId$2$1$actionDeferred$1(this.this$0, this.$gender, this.$actionId, this.$zplanSpanContext, this.$urlTemplate, null), 3, null);
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final ZPlanAction zPlanAction = (ZPlanAction) obj;
        com.tencent.filament.zplan.business.api.b exeTask = this.this$0.getParams().getExeTask();
        if (exeTask != null) {
            final AnimState animState = this.this$0;
            final c cVar = this.$zplanSpanContext;
            final Continuation<com.tencent.filament.zplan.animation.b> continuation = this.$it;
            exeTask.a("trackAnimByActionId", new Function0<Unit>() { // from class: com.tencent.sqshow.sharedengine.anim.state.AnimState$fetchAnimByActionId$2$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.filament.zplan.animation.b n3;
                    n3 = AnimState.this.n(new ZPlanAction[]{zPlanAction}, cVar);
                    continuation.resumeWith(Result.m476constructorimpl(n3));
                }
            });
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimState$fetchAnimByActionId$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
