package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import android.view.View;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$2$2"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$2$2", f = "ECShopDetailSkuInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$$inlined$let$lambda$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view$inlined;
    int label;
    final /* synthetic */ ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$$inlined$let$lambda$2(Continuation continuation, ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1 eCShopDetailSkuInfoViewModel$getPtsLiteEventListener$1, View view) {
        super(2, continuation);
        this.this$0 = eCShopDetailSkuInfoViewModel$getPtsLiteEventListener$1;
        this.$view$inlined = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$$inlined$let$lambda$2(continuation, this.this$0, this.$view$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopDetailSkuInfoViewModel$getPtsLiteEventListener$1$onTapEventTriggered$$inlined$let$lambda$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List o16 = ECShopProductDetailSkuInfoData.o(this.this$0.f102476a.c2(), Boxing.boxInt(this.this$0.f102476a.c2().getBuyCount() - 1), false, 2, null);
            mutableLiveData = this.this$0.f102476a._adapterPtsData;
            mutableLiveData.postValue(o16);
            ECShopDetailSkuInfoViewModel eCShopDetailSkuInfoViewModel = this.this$0.f102476a;
            eCShopDetailSkuInfoViewModel._isActiveSoldOutStatus = eCShopDetailSkuInfoViewModel.c2().c();
            mutableLiveData2 = this.this$0.f102476a._isSoldOutStatus;
            mutableLiveData2.postValue(Boxing.boxBoolean(this.this$0.f102476a.c2().d()));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
