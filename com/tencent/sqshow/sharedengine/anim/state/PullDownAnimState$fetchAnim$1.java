package com.tencent.sqshow.sharedengine.anim.state;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.zplantracing.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.sqshow.sharedengine.anim.state.PullDownAnimState$fetchAnim$1", f = "PullDownAnimState.kt", i = {}, l = {37, 39}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes34.dex */
public final class PullDownAnimState$fetchAnim$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EnumUserGender $gender;
    final /* synthetic */ a $listener;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    final /* synthetic */ c $zplanSpanContext;
    Object L$0;
    int label;
    final /* synthetic */ PullDownAnimState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullDownAnimState$fetchAnim$1(EnumUserGender enumUserGender, PullDownAnimState pullDownAnimState, c cVar, FilamentUrlTemplate filamentUrlTemplate, a aVar, Continuation<? super PullDownAnimState$fetchAnim$1> continuation) {
        super(2, continuation);
        this.$gender = enumUserGender;
        this.this$0 = pullDownAnimState;
        this.$zplanSpanContext = cVar;
        this.$urlTemplate = filamentUrlTemplate;
        this.$listener = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullDownAnimState$fetchAnim$1(this.$gender, this.this$0, this.$zplanSpanContext, this.$urlTemplate, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        PullDownAnimState pullDownAnimState;
        PullDownAnimState pullDownAnimState2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            EnumUserGender enumUserGender = this.$gender;
            if (enumUserGender == EnumUserGender.GENDER_FEMALE) {
                PullDownAnimState pullDownAnimState3 = this.this$0;
                c cVar = this.$zplanSpanContext;
                int a16 = PullDownAnimState.INSTANCE.a();
                FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
                this.L$0 = pullDownAnimState3;
                this.label = 1;
                Object d16 = pullDownAnimState3.d(cVar, enumUserGender, a16, filamentUrlTemplate, this);
                if (d16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pullDownAnimState2 = pullDownAnimState3;
                obj = d16;
                pullDownAnimState2.k((com.tencent.filament.zplan.animation.b) obj);
            } else {
                PullDownAnimState pullDownAnimState4 = this.this$0;
                c cVar2 = this.$zplanSpanContext;
                int a17 = PullDownAnimState.INSTANCE.a();
                FilamentUrlTemplate filamentUrlTemplate2 = this.$urlTemplate;
                this.L$0 = pullDownAnimState4;
                this.label = 2;
                Object d17 = pullDownAnimState4.d(cVar2, enumUserGender, a17, filamentUrlTemplate2, this);
                if (d17 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pullDownAnimState = pullDownAnimState4;
                obj = d17;
                pullDownAnimState.l((com.tencent.filament.zplan.animation.b) obj);
            }
        } else if (i3 == 1) {
            pullDownAnimState2 = (PullDownAnimState) this.L$0;
            ResultKt.throwOnFailure(obj);
            pullDownAnimState2.k((com.tencent.filament.zplan.animation.b) obj);
        } else if (i3 == 2) {
            pullDownAnimState = (PullDownAnimState) this.L$0;
            ResultKt.throwOnFailure(obj);
            pullDownAnimState.l((com.tencent.filament.zplan.animation.b) obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        a aVar = this.$listener;
        if (aVar != null) {
            aVar.onResult(true);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullDownAnimState$fetchAnim$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
