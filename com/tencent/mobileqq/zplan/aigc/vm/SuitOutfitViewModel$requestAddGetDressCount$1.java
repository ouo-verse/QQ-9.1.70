package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
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
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$requestAddGetDressCount$1", f = "SuitOutfitViewModel.kt", i = {}, l = {267}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitOutfitViewModel$requestAddGetDressCount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedID;
    int label;
    final /* synthetic */ SuitOutfitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitViewModel$requestAddGetDressCount$1(String str, SuitOutfitViewModel suitOutfitViewModel, Continuation<? super SuitOutfitViewModel$requestAddGetDressCount$1> continuation) {
        super(2, continuation);
        this.$feedID = str;
        this.this$0 = suitOutfitViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitOutfitViewModel$requestAddGetDressCount$1(this.$feedID, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                j jVar = j.f335411a;
                String str = this.$feedID;
                this.label = 1;
                obj = jVar.b(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long longValue = ((Number) obj).longValue();
            mutableLiveData = this.this$0._dressCount;
            mutableLiveData.postValue(Boxing.boxLong(longValue));
            return Unit.INSTANCE;
        } catch (Exception e16) {
            QLog.e("SuitOutfitViewModel", 1, e16.toString());
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitViewModel$requestAddGetDressCount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
