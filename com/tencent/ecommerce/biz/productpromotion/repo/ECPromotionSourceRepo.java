package com.tencent.ecommerce.biz.productpromotion.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.b;
import com.tencent.ecommerce.base.network.service.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;
import yj0.d;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/productpromotion/repo/ECPromotionSourceRepo;", "", "", "userId", "Lyj0/d;", "a", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPromotionSourceRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final ECPromotionSourceRepo f103947a = new ECPromotionSourceRepo();

    ECPromotionSourceRepo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(long j3, Continuation<? super d> continuation) {
        ECPromotionSourceRepo$getPromotionInfo$1 eCPromotionSourceRepo$getPromotionInfo$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECPromotionSourceRepo$getPromotionInfo$1) {
            eCPromotionSourceRepo$getPromotionInfo$1 = (ECPromotionSourceRepo$getPromotionInfo$1) continuation;
            int i16 = eCPromotionSourceRepo$getPromotionInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCPromotionSourceRepo$getPromotionInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCPromotionSourceRepo$getPromotionInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCPromotionSourceRepo$getPromotionInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("user_id", j3);
                    jSONObject2.put("scene", 1);
                    b bVar = b.f100803a;
                    eCPromotionSourceRepo$getPromotionInfo$1.L$0 = jSONObject2;
                    eCPromotionSourceRepo$getPromotionInfo$1.label = 1;
                    Object e16 = a.e("trpc.ecom.send_promotion_svr.SendPromotionSvr", "/trpc.ecom.send_promotion_svr.SendPromotionSvr/SendTaskInfoToXworld", bVar, jSONObject2, eCPromotionSourceRepo$getPromotionInfo$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCPromotionSourceRepo$getPromotionInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECPromotionSourceRepo", "getPromotionInfo service=trpc.ecom.send_promotion_svr.SendPromotionSvr, method=/trpc.ecom.send_promotion_svr.SendPromotionSvr/SendTaskInfoToXworld, params=" + jSONObject + ", response=" + eCNetworkResponse);
                if (eCNetworkResponse.getCode() != 0) {
                    d dVar = new d();
                    dVar.decodeData((JSONObject) eCNetworkResponse.b());
                    return dVar;
                }
                cg0.a.a("ECPromotionSourceRepo", "getPromotionInfo", "[getPromotionInfo] response error = " + eCNetworkResponse.getMessage());
                return null;
            }
        }
        eCPromotionSourceRepo$getPromotionInfo$1 = new ECPromotionSourceRepo$getPromotionInfo$1(this, continuation);
        Object obj2 = eCPromotionSourceRepo$getPromotionInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCPromotionSourceRepo$getPromotionInfo$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECPromotionSourceRepo", "getPromotionInfo service=trpc.ecom.send_promotion_svr.SendPromotionSvr, method=/trpc.ecom.send_promotion_svr.SendPromotionSvr/SendTaskInfoToXworld, params=" + jSONObject + ", response=" + eCNetworkResponse);
        if (eCNetworkResponse.getCode() != 0) {
        }
    }
}
