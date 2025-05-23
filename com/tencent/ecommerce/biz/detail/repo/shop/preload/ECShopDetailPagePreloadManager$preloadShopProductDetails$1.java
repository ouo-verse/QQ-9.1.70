package com.tencent.ecommerce.biz.detail.repo.shop.preload;

import com.tencent.ecommerce.biz.detail.repo.shop.IECShopProductDetailRepository;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.repo.shop.preload.ECShopDetailPagePreloadManager$preloadShopProductDetails$1", f = "ECShopDetailPagePreloadManager.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECShopDetailPagePreloadManager$preloadShopProductDetails$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $method;
    final /* synthetic */ JSONObject $params;
    final /* synthetic */ String $service;
    final /* synthetic */ String $spuId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopDetailPagePreloadManager$preloadShopProductDetails$1(String str, String str2, JSONObject jSONObject, String str3, Continuation continuation) {
        super(2, continuation);
        this.$service = str;
        this.$method = str2;
        this.$params = jSONObject;
        this.$spuId = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECShopDetailPagePreloadManager$preloadShopProductDetails$1(this.$service, this.$method, this.$params, this.$spuId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopDetailPagePreloadManager$preloadShopProductDetails$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IECShopProductDetailRepository iECShopProductDetailRepository;
        CopyOnWriteArrayList copyOnWriteArrayList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECShopDetailPagePreloadManager eCShopDetailPagePreloadManager = ECShopDetailPagePreloadManager.f102383c;
            iECShopProductDetailRepository = ECShopDetailPagePreloadManager.repository;
            String str = this.$service;
            String str2 = this.$method;
            JSONObject jSONObject = this.$params;
            this.label = 1;
            if (iECShopProductDetailRepository.getShopProductDetailData(str, str2, jSONObject, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECShopDetailPagePreloadManager eCShopDetailPagePreloadManager2 = ECShopDetailPagePreloadManager.f102383c;
        copyOnWriteArrayList = ECShopDetailPagePreloadManager.detailPageIsRequestingList;
        copyOnWriteArrayList.remove(this.$spuId);
        return Unit.INSTANCE;
    }
}
