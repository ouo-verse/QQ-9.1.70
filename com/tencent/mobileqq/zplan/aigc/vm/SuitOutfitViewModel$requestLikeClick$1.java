package com.tencent.mobileqq.zplan.aigc.vm;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.zplan.aigc.data.LikeData;
import com.tencent.mobileqq.zplan.servlet.j;
import com.tencent.qphone.base.util.QLog;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel$requestLikeClick$1", f = "SuitOutfitViewModel.kt", i = {}, l = {250, 253}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class SuitOutfitViewModel$requestLikeClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedID;
    int label;
    final /* synthetic */ SuitOutfitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitOutfitViewModel$requestLikeClick$1(SuitOutfitViewModel suitOutfitViewModel, String str, Continuation<? super SuitOutfitViewModel$requestLikeClick$1> continuation) {
        super(2, continuation);
        this.this$0 = suitOutfitViewModel;
        this.$feedID = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitOutfitViewModel$requestLikeClick$1(this.this$0, this.$feedID, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutableLiveData2 = this.this$0._likeData;
                if (mutableLiveData2.getValue() != 0) {
                    mutableLiveData3 = this.this$0._likeData;
                    T value = mutableLiveData3.getValue();
                    Intrinsics.checkNotNull(value);
                    if (((LikeData) value).getIsLike()) {
                        j jVar = j.f335411a;
                        String str = this.$feedID;
                        this.label = 1;
                        obj = jVar.h(str, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        long longValue = ((Number) obj).longValue();
                        mutableLiveData4 = this.this$0._likeData;
                        mutableLiveData4.postValue(new LikeData(false, longValue));
                    }
                }
                j jVar2 = j.f335411a;
                String str2 = this.$feedID;
                this.label = 2;
                obj = jVar2.e(str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                long longValue2 = ((Number) obj).longValue();
                mutableLiveData5 = this.this$0._likeData;
                mutableLiveData5.postValue(new LikeData(true, longValue2));
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                long longValue3 = ((Number) obj).longValue();
                mutableLiveData4 = this.this$0._likeData;
                mutableLiveData4.postValue(new LikeData(false, longValue3));
            } else if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                long longValue22 = ((Number) obj).longValue();
                mutableLiveData5 = this.this$0._likeData;
                mutableLiveData5.postValue(new LikeData(true, longValue22));
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        } catch (Exception e16) {
            QLog.e("SuitOutfitViewModel", 1, e16.toString());
            mutableLiveData = this.this$0._likeData;
            mutableLiveData.postValue(new LikeData(false, 0L));
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitOutfitViewModel$requestLikeClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
