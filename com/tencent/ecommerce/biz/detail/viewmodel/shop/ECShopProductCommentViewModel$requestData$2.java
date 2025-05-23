package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductCommentData;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel;
import java.util.ArrayList;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductCommentViewModel$requestData$2", f = "ECShopProductCommentViewModel.kt", i = {}, l = {92, 112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopProductCommentViewModel$requestData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isFetchBackground;
    final /* synthetic */ boolean $isRefreshFetch;
    final /* synthetic */ int $sortType;
    int label;
    final /* synthetic */ ECShopProductCommentViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductCommentViewModel$requestData$2(ECShopProductCommentViewModel eCShopProductCommentViewModel, int i3, boolean z16, boolean z17, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductCommentViewModel;
        this.$sortType = i3;
        this.$isRefreshFetch = z16;
        this.$isFetchBackground = z17;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopProductCommentViewModel$requestData$2(this.this$0, this.$sortType, this.$isRefreshFetch, this.$isFetchBackground, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductCommentViewModel$requestData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ECShopProductCommentData eCShopProductCommentData;
        ArrayList arrayList;
        ArrayList<ECBasePtsViewData> arrayList2;
        ArrayList arrayList3;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        ArrayList arrayList4;
        MutableLiveData mutableLiveData3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            eCShopProductCommentData = this.this$0.commentData;
            String str = this.this$0.spuId;
            int i16 = this.$sortType;
            boolean z16 = this.$isRefreshFetch;
            this.label = 1;
            obj = eCShopProductCommentData.b(str, i16, z16, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ECShopProductCommentData.CommentListRequestResult commentListRequestResult = (ECShopProductCommentData.CommentListRequestResult) obj;
        if (commentListRequestResult == null) {
            arrayList4 = this.this$0._adapterPtsData;
            if (arrayList4.size() == 0) {
                if (!this.$isFetchBackground) {
                    mutableLiveData3 = this.this$0._pageStatus;
                    mutableLiveData3.postValue(ECShopProductCommentViewModel.b.C1054b.f102479a);
                }
                return Unit.INSTANCE;
            }
        }
        if (commentListRequestResult != null) {
            arrayList = this.this$0._adapterPtsData;
            arrayList.addAll(commentListRequestResult.a());
            MutableLiveData<ArrayList<ECBasePtsViewData>> S1 = this.this$0.S1();
            arrayList2 = this.this$0._adapterPtsData;
            S1.postValue(arrayList2);
            if (!this.$isFetchBackground) {
                arrayList3 = this.this$0._adapterPtsData;
                if (arrayList3.size() == 0) {
                    mutableLiveData2 = this.this$0._pageStatus;
                    mutableLiveData2.postValue(ECShopProductCommentViewModel.b.a.f102478a);
                } else {
                    mutableLiveData = this.this$0._pageStatus;
                    mutableLiveData.postValue(ECShopProductCommentViewModel.b.d.f102481a);
                }
            }
            this.this$0.getIsListEnd().set(commentListRequestResult.isListEnd);
        }
        ECShopProductCommentViewModel eCShopProductCommentViewModel = this.this$0;
        int i17 = this.$sortType;
        this.label = 2;
        if (eCShopProductCommentViewModel.R1(i17, commentListRequestResult, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
