package com.tencent.ecommerce.biz.advertise;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/advertise/ECAdAttributionRepo;", "", "Lorg/json/JSONObject;", "reportData", "Lcom/tencent/ecommerce/biz/advertise/a;", "a", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAdAttributionRepo {

    /* renamed from: b, reason: collision with root package name */
    public static final ECAdAttributionRepo f101285b = new ECAdAttributionRepo();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    ECAdAttributionRepo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r2v1, types: [org.json.JSONObject, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(JSONObject jSONObject, Continuation<? super ECAdAttributionAddResult> continuation) {
        ECAdAttributionRepo$addAdAttributionData$1 eCAdAttributionRepo$addAdAttributionData$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECAdAttributionRepo$addAdAttributionData$1) {
            eCAdAttributionRepo$addAdAttributionData$1 = (ECAdAttributionRepo$addAdAttributionData$1) continuation;
            int i16 = eCAdAttributionRepo$addAdAttributionData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCAdAttributionRepo$addAdAttributionData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCAdAttributionRepo$addAdAttributionData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCAdAttributionRepo$addAdAttributionData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? jSONObject2 = new JSONObject();
                    jSONObject2.put("body", jSONObject.toString());
                    Unit unit = Unit.INSTANCE;
                    objectRef.element = jSONObject2;
                    CoroutineDispatcher coroutineDispatcher = dispatcher;
                    ECAdAttributionRepo$addAdAttributionData$response$1 eCAdAttributionRepo$addAdAttributionData$response$1 = new ECAdAttributionRepo$addAdAttributionData$response$1(objectRef, null);
                    eCAdAttributionRepo$addAdAttributionData$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, eCAdAttributionRepo$addAdAttributionData$response$1, eCAdAttributionRepo$addAdAttributionData$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() != 0) {
                    ECAdAttributionAddResult eCAdAttributionAddResult = (ECAdAttributionAddResult) eCNetworkResponse.b();
                    return eCAdAttributionAddResult != null ? eCAdAttributionAddResult : new ECAdAttributionAddResult(0, eCNetworkResponse.getMessage(), "\u56de\u5305\u6570\u636e\u4e3a\u7a7a");
                }
                cg0.a.a("ECAdAttributionRepo", "addAdAttributionData", "addAdAttributionData error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                return new ECAdAttributionAddResult(eCNetworkResponse.getCode(), eCNetworkResponse.getMessage(), "\u540e\u53f0\u7f51\u7edc\u56de\u5305\u5931\u8d25");
            }
        }
        eCAdAttributionRepo$addAdAttributionData$1 = new ECAdAttributionRepo$addAdAttributionData$1(this, continuation);
        Object obj2 = eCAdAttributionRepo$addAdAttributionData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCAdAttributionRepo$addAdAttributionData$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() != 0) {
        }
    }
}
