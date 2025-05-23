package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import wf2.NetworkResult;
import xf2.a;
import xf2.b;
import zf2.PromotionPanelItem;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository.PromotionRepositoryImpl$fetchPromotionList$2", f = "PromotionRepositoryImpl.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class PromotionRepositoryImpl$fetchPromotionList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $hasLoadLocalData;
    final /* synthetic */ ArrayList<PromotionPanelItem> $localDatas;
    int label;
    final /* synthetic */ PromotionRepositoryImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionRepositoryImpl$fetchPromotionList$2(PromotionRepositoryImpl promotionRepositoryImpl, ArrayList<PromotionPanelItem> arrayList, Ref.BooleanRef booleanRef, Continuation<? super PromotionRepositoryImpl$fetchPromotionList$2> continuation) {
        super(2, continuation);
        this.this$0 = promotionRepositoryImpl;
        this.$localDatas = arrayList;
        this.$hasLoadLocalData = booleanRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PromotionRepositoryImpl$fetchPromotionList$2(this.this$0, this.$localDatas, this.$hasLoadLocalData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        b bVar;
        MutableLiveData mutableLiveData;
        a aVar;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            bVar = this.this$0.remoteDataSource;
            this.label = 1;
            obj = bVar.b(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NetworkResult networkResult = (NetworkResult) obj;
        if (networkResult.getIsSucceed()) {
            List<PromotionPanelItem> a16 = networkResult.a();
            if (!com.tencent.mobileqq.qqecommerce.biz.messagecenter.utils.b.a(a16, this.$localDatas)) {
                mutableLiveData = this.this$0._promotionItems;
                mutableLiveData.postValue(a16);
                QLog.d("ECMsgCenter|PromotionRepositoryImpl", 2, "fetchPromotionList return remote datas. size = " + a16.size());
                aVar = this.this$0.localDataSource;
                aVar.b(a16);
            } else {
                QLog.d("ECMsgCenter|PromotionRepositoryImpl", 2, "fetchPromotionList remote datas skipped.");
                return Unit.INSTANCE;
            }
        } else if (!this.$hasLoadLocalData.element) {
            QLog.e("ECMsgCenter|PromotionRepositoryImpl", 1, "fetchPromotionList both sources failed.");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PromotionRepositoryImpl$fetchPromotionList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
