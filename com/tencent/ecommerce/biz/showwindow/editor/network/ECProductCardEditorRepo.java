package com.tencent.ecommerce.biz.showwindow.editor.network;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.b;
import com.tencent.ecommerce.base.network.service.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.apache.httpcore.message.TokenParser;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/network/ECProductCardEditorRepo;", "", "Lorg/json/JSONObject;", "requestParams", "a", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductCardEditorRepo {
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        ECProductCardEditorRepo$requestForProductObject$1 eCProductCardEditorRepo$requestForProductObject$1;
        Object coroutine_suspended;
        int i3;
        String str;
        String str2;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECProductCardEditorRepo$requestForProductObject$1) {
            eCProductCardEditorRepo$requestForProductObject$1 = (ECProductCardEditorRepo$requestForProductObject$1) continuation;
            int i16 = eCProductCardEditorRepo$requestForProductObject$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCProductCardEditorRepo$requestForProductObject$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCProductCardEditorRepo$requestForProductObject$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCProductCardEditorRepo$requestForProductObject$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = b.f100803a;
                    eCProductCardEditorRepo$requestForProductObject$1.L$0 = "trpc.ecom.qq_shop_detail_svr.ProductCard";
                    eCProductCardEditorRepo$requestForProductObject$1.L$1 = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailBySeller";
                    eCProductCardEditorRepo$requestForProductObject$1.label = 1;
                    obj = a.e("trpc.ecom.qq_shop_detail_svr.ProductCard", "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailBySeller", bVar, jSONObject, eCProductCardEditorRepo$requestForProductObject$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = "trpc.ecom.qq_shop_detail_svr.ProductCard";
                    str2 = "/trpc.ecom.qq_shop_detail_svr.ProductCard/GetProductDetailBySeller";
                } else if (i3 == 1) {
                    str2 = (String) eCProductCardEditorRepo$requestForProductObject$1.L$1;
                    str = (String) eCProductCardEditorRepo$requestForProductObject$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                JSONObject jSONObject2 = (JSONObject) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && jSONObject2 != null) {
                    cg0.a.b("ECProductCardEditorRepo", "[requestForProductObject] data = " + jSONObject2);
                    return jSONObject2;
                }
                cg0.a.a("ECProductCardEditorRepo", "requestForProductObject", "pre pts failure, because req error. service: " + str + TokenParser.SP + "method: " + str2);
                return null;
            }
        }
        eCProductCardEditorRepo$requestForProductObject$1 = new ECProductCardEditorRepo$requestForProductObject$1(this, continuation);
        Object obj2 = eCProductCardEditorRepo$requestForProductObject$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCProductCardEditorRepo$requestForProductObject$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        JSONObject jSONObject22 = (JSONObject) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        cg0.a.a("ECProductCardEditorRepo", "requestForProductObject", "pre pts failure, because req error. service: " + str + TokenParser.SP + "method: " + str2);
        return null;
    }
}
