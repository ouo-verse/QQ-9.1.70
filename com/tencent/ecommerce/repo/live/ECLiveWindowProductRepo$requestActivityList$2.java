package com.tencent.ecommerce.repo.live;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.repo.live.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/ecommerce/repo/live/k$a;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.repo.live.ECLiveWindowProductRepo$requestActivityList$2", f = "ECLiveWindowProductRepo.kt", i = {}, l = {437}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
final class ECLiveWindowProductRepo$requestActivityList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super k.ActivityResponse>, Object> {
    final /* synthetic */ List $activityIdList;
    int label;
    final /* synthetic */ ECLiveWindowProductRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowProductRepo$requestActivityList$2(ECLiveWindowProductRepo eCLiveWindowProductRepo, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCLiveWindowProductRepo;
        this.$activityIdList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECLiveWindowProductRepo$requestActivityList$2(this.this$0, this.$activityIdList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super k.ActivityResponse> continuation) {
        return ((ECLiveWindowProductRepo$requestActivityList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            cg0.a.b(this.this$0.logTag, "requestActivityList: activityIdList:" + this.$activityIdList);
            JSONObject encodeParams = new di0.k(this.$activityIdList).encodeParams();
            Intrinsics.checkNotNull(encodeParams);
            com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
            this.label = 1;
            obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.qshop_active_svr.QshopActiveSvr", "/trpc.ecom.qshop_active_svr.QshopActiveSvr/GetActiveInfo", bVar, encodeParams, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        cg0.a.b(this.this$0.logTag, "requestActivityList: rsp:" + eCNetworkResponse);
        if (eCNetworkResponse.getCode() != 0) {
            cg0.a.a(this.this$0.logTag, "requestActivityList", "error, rsp:" + eCNetworkResponse);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new k.ActivityResponse(false, emptyList);
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = (JSONObject) eCNetworkResponse.b();
        JSONArray optJSONArray = jSONObject != null ? jSONObject.optJSONArray("live_active_info") : null;
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                Object obj2 = optJSONArray.get(i16);
                if (!(obj2 instanceof JSONObject)) {
                    obj2 = null;
                }
                JSONObject jSONObject2 = (JSONObject) obj2;
                if (jSONObject2 != null) {
                    Boxing.boxBoolean(arrayList.add(LiveActivity.INSTANCE.b(jSONObject2)));
                }
            }
        }
        cg0.a.b(this.this$0.logTag, "requestActivityList: rsp success. liveActivities:" + arrayList);
        return new k.ActivityResponse(true, arrayList);
    }
}
