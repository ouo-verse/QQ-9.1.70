package com.tencent.mobileqq.zplan.aigc.vm;

import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.mobileqq.zplan.servlet.j;
import com.tencent.qphone.base.util.QLog;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$deleteFeed$1", f = "SuitOutfitViewModel.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitOutfitViewModel$deleteFeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Long> $callback;
    final /* synthetic */ String $feedID;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitViewModel$deleteFeed$1(String str, com.tencent.mobileqq.zootopia.api.e<Long> eVar, Continuation<? super SuitOutfitViewModel$deleteFeed$1> continuation) {
        super(2, continuation);
        this.$feedID = str;
        this.$callback = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitOutfitViewModel$deleteFeed$1(this.$feedID, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                j jVar = j.f335411a;
                String str = this.$feedID;
                this.label = 1;
                obj = jVar.d(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long longValue = ((Number) obj).longValue();
            com.tencent.mobileqq.zootopia.api.e<Long> eVar = this.$callback;
            if (eVar != null) {
                eVar.onResultSuccess(Boxing.boxLong(longValue));
            }
            return Unit.INSTANCE;
        } catch (Exception e16) {
            QLog.e("SuitOutfitViewModel", 1, "requestDeleteFeed failed.", e16);
            this.$callback.onResultFailure(SuitOutfitViewModel.Companion.DeleteFeedStatus.DELETE_FEED_ERROR.getStatus(), e16.getMessage());
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitViewModel$deleteFeed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
