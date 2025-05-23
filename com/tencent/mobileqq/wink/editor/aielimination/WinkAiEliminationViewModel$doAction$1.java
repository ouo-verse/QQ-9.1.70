package com.tencent.mobileqq.wink.editor.aielimination;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.aielimination.model.AIEliminationDoActionType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.aielimination.WinkAiEliminationViewModel$doAction$1", f = "WinkAiEliminationViewModel.kt", i = {}, l = {com.tencent.luggage.wxa.j2.c.CTRL_INDEX}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkAiEliminationViewModel$doAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIEliminationDoActionType $action;
    int label;
    final /* synthetic */ WinkAiEliminationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAiEliminationViewModel$doAction$1(AIEliminationDoActionType aIEliminationDoActionType, WinkAiEliminationViewModel winkAiEliminationViewModel, Continuation<? super WinkAiEliminationViewModel$doAction$1> continuation) {
        super(2, continuation);
        this.$action = aIEliminationDoActionType;
        this.this$0 = winkAiEliminationViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkAiEliminationViewModel winkAiEliminationViewModel, long j3) {
        MutableLiveData mutableLiveData;
        mutableLiveData = winkAiEliminationViewModel._shareLimitLivaData;
        mutableLiveData.postValue(Long.valueOf(j3));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAiEliminationViewModel$doAction$1(this.$action, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                AIEliminateDataSource aIEliminateDataSource = AIEliminateDataSource.f318757a;
                int value = this.$action.getValue();
                String b26 = this.this$0.b2();
                this.label = 1;
                obj = aIEliminateDataSource.a(value, b26, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            final long longValue = ((Number) obj).longValue();
            if (this.$action == AIEliminationDoActionType.Share) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final WinkAiEliminationViewModel winkAiEliminationViewModel = this.this$0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.aielimination.aa
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkAiEliminationViewModel$doAction$1.b(WinkAiEliminationViewModel.this, longValue);
                    }
                });
            }
            if (this.$action == AIEliminationDoActionType.Finish) {
                mutableLiveData = this.this$0._doActionResultLivaData;
                mutableLiveData.postValue(Boxing.boxLong(longValue));
            }
        } catch (Exception unused) {
            w53.b.c("WinkAiEliminationViewModel", "requestAIElimination doAction fail");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAiEliminationViewModel$doAction$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
