package com.tencent.state.square.components;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/state/square/components/SquareConfigHelper$doAfterConfigUpdated$1$1"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.square.components.SquareConfigHelper$doAfterConfigUpdated$1$1", f = "SquareConfigHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes38.dex */
public final class SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $callback$inlined;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1(Continuation continuation, Function0 function0) {
        super(2, continuation);
        this.$callback$inlined = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1(completion, this.$callback$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SquareConfigHelper squareConfigHelper = SquareConfigHelper.INSTANCE;
            mutableLiveData = SquareConfigHelper.isUpdated;
            mutableLiveData.observeForever(new Observer<Boolean>() { // from class: com.tencent.state.square.components.SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(Boolean t16) {
                    MutableLiveData mutableLiveData2;
                    if (Intrinsics.areEqual(t16, Boolean.TRUE)) {
                        SquareBaseKt.getSquareLog().d("SquareConfigHelper", "doAfterConfigUpdated callback");
                        SquareConfigHelper squareConfigHelper2 = SquareConfigHelper.INSTANCE;
                        mutableLiveData2 = SquareConfigHelper.isUpdated;
                        mutableLiveData2.removeObserver(this);
                        SquareConfigHelper$doAfterConfigUpdated$$inlined$synchronized$lambda$1.this.$callback$inlined.invoke();
                    }
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
