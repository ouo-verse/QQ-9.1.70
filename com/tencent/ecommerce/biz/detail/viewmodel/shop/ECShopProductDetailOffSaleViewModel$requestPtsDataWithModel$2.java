package com.tencent.ecommerce.biz.detail.viewmodel.shop;

import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.biz.detail.utils.d;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.ArrayList;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2", f = "ECShopProductDetailOffSaleViewModel.kt", i = {0, 1}, l = {61, 62}, m = "invokeSuspend", n = {"pageExtraAsync", ISchemeApi.KEY_PAGE_DATA}, s = {"L$0", "L$0"})
/* loaded from: classes31.dex */
public final class ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $method;
    final /* synthetic */ JSONObject $requestExtraParams;
    final /* synthetic */ JSONObject $requestParams;
    final /* synthetic */ String $service;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ECShopProductDetailOffSaleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2(ECShopProductDetailOffSaleViewModel eCShopProductDetailOffSaleViewModel, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCShopProductDetailOffSaleViewModel;
        this.$service = str;
        this.$method = str2;
        this.$requestParams = jSONObject;
        this.$requestExtraParams = jSONObject2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2 eCShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2 = new ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2(this.this$0, this.$service, this.$method, this.$requestParams, this.$requestExtraParams, continuation);
        eCShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2.L$0 = obj;
        return eCShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Deferred async$default;
        Deferred async$default2;
        JSONObject jSONObject;
        List<ECBasePtsViewData> x26;
        List<ECBasePtsViewData> e16;
        List<ECBasePtsViewData> list;
        boolean z16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2$pageAsync$1(this, null), 3, null);
            async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ECShopProductDetailOffSaleViewModel$requestPtsDataWithModel$2$pageExtraAsync$1(this, null), 3, null);
            this.L$0 = async$default2;
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    jSONObject = (JSONObject) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    x26 = this.this$0.x2(jSONObject, this.$requestParams);
                    e16 = this.this$0.j2().e((JSONObject) obj, this.$requestParams);
                    if (!x26.isEmpty() && e16.isEmpty()) {
                        this.this$0.c2().postValue(Boxing.boxInt(2));
                        d.f102466a.r(this.this$0.getShowPageCostTime(), false, 3);
                        return Unit.INSTANCE;
                    }
                    list = x26;
                    if (true ^ list.isEmpty()) {
                        this.this$0.c2().postValue(Boxing.boxInt(4));
                        this.this$0.Z1().postValue(x26);
                        d.f102466a.r(this.this$0.getShowPageCostTime(), false, 2);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    if (!e16.isEmpty()) {
                        z16 = this.this$0.isSaasRecommendRetNull;
                        if (!z16) {
                            this.this$0.z2(x26);
                            arrayList.clear();
                            arrayList.addAll(list);
                            this.this$0.c2().postValue(Boxing.boxInt(5));
                        } else {
                            this.this$0.c2().postValue(Boxing.boxInt(6));
                        }
                    } else {
                        arrayList.addAll(e16);
                        this.this$0.c2().postValue(Boxing.boxInt(7));
                    }
                    this.this$0.Z1().postValue(arrayList);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            async$default2 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        this.L$0 = jSONObject2;
        this.label = 2;
        Object await = async$default2.await(this);
        if (await == coroutine_suspended) {
            return coroutine_suspended;
        }
        jSONObject = jSONObject2;
        obj = await;
        x26 = this.this$0.x2(jSONObject, this.$requestParams);
        e16 = this.this$0.j2().e((JSONObject) obj, this.$requestParams);
        if (!x26.isEmpty()) {
        }
        list = x26;
        if (true ^ list.isEmpty()) {
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(list);
        if (!e16.isEmpty()) {
        }
        this.this$0.Z1().postValue(arrayList2);
        return Unit.INSTANCE;
    }
}
