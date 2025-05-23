package com.tencent.ecommerce.biz.detail.repo.shop.data;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailData$requestProductDetailData$2", f = "ECShopProductDetailData.kt", i = {0, 1}, l = {73, 74}, m = "invokeSuspend", n = {"commentAsync", "contentData"}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailData$requestProductDetailData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $method;
    final /* synthetic */ JSONObject $requestParams;
    final /* synthetic */ Ref.ObjectRef $response;
    final /* synthetic */ String $service;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECShopProductDetailData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailData$requestProductDetailData$2(ECShopProductDetailData eCShopProductDetailData, String str, String str2, JSONObject jSONObject, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailData;
        this.$service = str;
        this.$method = str2;
        this.$requestParams = jSONObject;
        this.$response = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECShopProductDetailData$requestProductDetailData$2 eCShopProductDetailData$requestProductDetailData$2 = new ECShopProductDetailData$requestProductDetailData$2(this.this$0, this.$service, this.$method, this.$requestParams, this.$response, continuation);
        eCShopProductDetailData$requestProductDetailData$2.L$0 = obj;
        return eCShopProductDetailData$requestProductDetailData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailData$requestProductDetailData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0064  */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        ECShopProductDetailInfo eCShopProductDetailInfo;
        MutableLiveData mutableLiveData;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ECShopProductDetailData$requestProductDetailData$2$contentAsync$1(this, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ECShopProductDetailData$requestProductDetailData$2$commentAsync$1(this, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    eCShopProductDetailInfo = (ECShopProductDetailInfo) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ECShopProductCommentInfo eCShopProductCommentInfo = (ECShopProductCommentInfo) obj;
                    if (eCShopProductDetailInfo != null) {
                        return Unit.INSTANCE;
                    }
                    Ref.ObjectRef objectRef = this.$response;
                    ?? jSONObject = new JSONObject(eCShopProductDetailInfo.infoData.toString());
                    if (eCShopProductCommentInfo != null) {
                        jSONObject.put("comment_data", eCShopProductCommentInfo.jsonResponse);
                    }
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = jSONObject;
                    mutableLiveData = this.this$0._productDetailData;
                    mutableLiveData.postValue(eCShopProductDetailInfo);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            async$default2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ECShopProductDetailInfo eCShopProductDetailInfo2 = (ECShopProductDetailInfo) obj;
        this.L$0 = eCShopProductDetailInfo2;
        this.label = 2;
        Object await = async$default2.await(this);
        if (await == coroutine_suspended) {
            return coroutine_suspended;
        }
        eCShopProductDetailInfo = eCShopProductDetailInfo2;
        obj = await;
        ECShopProductCommentInfo eCShopProductCommentInfo2 = (ECShopProductCommentInfo) obj;
        if (eCShopProductDetailInfo != null) {
        }
    }
}
