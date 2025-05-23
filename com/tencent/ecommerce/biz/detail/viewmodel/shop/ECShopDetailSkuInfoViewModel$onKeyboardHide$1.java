package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailSkuInfoData;
import java.util.List;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopDetailSkuInfoViewModel$onKeyboardHide$1", f = "ECShopDetailSkuInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopDetailSkuInfoViewModel$onKeyboardHide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ECShopDetailSkuInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopDetailSkuInfoViewModel$onKeyboardHide$1(ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopDetailSkuInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopDetailSkuInfoViewModel$onKeyboardHide$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopDetailSkuInfoViewModel$onKeyboardHide$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i3;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopProductDetailSkuInfoData c26 = this.this$0.c2();
            i3 = this.this$0.inputValue;
            List o16 = ECShopProductDetailSkuInfoData.o(c26, Boxing.boxInt(i3), false, 2, null);
            mutableLiveData = this.this$0._adapterPtsData;
            mutableLiveData.postValue(o16);
            ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel = this.this$0;
            eCShopDetailSkuInfoViewModel._isActiveSoldOutStatus = eCShopDetailSkuInfoViewModel.c2().c();
            mutableLiveData2 = this.this$0._isSoldOutStatus;
            mutableLiveData2.postValue(Boxing.boxBoolean(this.this$0.c2().d()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
