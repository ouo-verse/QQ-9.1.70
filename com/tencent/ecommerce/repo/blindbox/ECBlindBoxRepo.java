package com.tencent.ecommerce.repo.blindbox;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/repo/blindbox/ECBlindBoxRepo;", "Lcom/tencent/ecommerce/repo/blindbox/b;", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/base/network/api/d;", "Lcom/tencent/ecommerce/repo/blindbox/a;", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "orderIds", "b", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBlindBoxRepo implements com.tencent.ecommerce.repo.blindbox.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/repo/blindbox/ECBlindBoxRepo$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "", "Lcom/tencent/ecommerce/repo/blindbox/a;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkJsonContracts<String, ECBlindBoxLotteryResult> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECBlindBoxLotteryResult decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            return new ECBlindBoxLotteryResult(a16.optBoolean("has_result"), a16, false, 4, null);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(String params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("order_id", params);
            return jSONObject;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/repo/blindbox/ECBlindBoxRepo$c", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "Lorg/json/JSONArray;", "Lcom/tencent/ecommerce/repo/blindbox/a;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkJsonContracts<JSONArray, ECBlindBoxLotteryResult> {
        c() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECBlindBoxLotteryResult decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            return new ECBlindBoxLotteryResult(a16.optBoolean("has_result"), a16, false, 4, null);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(JSONArray params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("order_ids", params);
            return jSONObject;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/repo/blindbox/ECBlindBoxRepo$d", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "Lorg/json/JSONArray;", "Lcom/tencent/ecommerce/repo/blindbox/a;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECNetworkJsonContracts<JSONArray, ECBlindBoxLotteryResult> {
        d() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECBlindBoxLotteryResult decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            return new ECBlindBoxLotteryResult(a16.optBoolean("has_result"), a16, a16.optBoolean("should_refund"));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(JSONArray params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("order_ids", params);
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.ecommerce.repo.blindbox.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(String str, Continuation<? super ECNetworkResponse<ECBlindBoxLotteryResult>> continuation) {
        ECBlindBoxRepo$checkLottery$1 eCBlindBoxRepo$checkLottery$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECBlindBoxRepo$checkLottery$1) {
            eCBlindBoxRepo$checkLottery$1 = (ECBlindBoxRepo$checkLottery$1) continuation;
            int i16 = eCBlindBoxRepo$checkLottery$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCBlindBoxRepo$checkLottery$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCBlindBoxRepo$checkLottery$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCBlindBoxRepo$checkLottery$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECBlindBoxRepo", "checkLottery order_id: " + str);
                    b bVar = new b();
                    eCBlindBoxRepo$checkLottery$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.mystery_box_operation_svr.OperationSvr", "/trpc.ecom.mystery_box_operation_svr.OperationSvr/CheckLottery", bVar, str, eCBlindBoxRepo$checkLottery$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0 || eCNetworkResponse.b() == null) {
                    cg0.a.a("ECBlindBoxRepo", "checkLottery", "check lottery error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse;
            }
        }
        eCBlindBoxRepo$checkLottery$1 = new ECBlindBoxRepo$checkLottery$1(this, continuation);
        Object obj2 = eCBlindBoxRepo$checkLottery$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCBlindBoxRepo$checkLottery$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECBlindBoxRepo", "checkLottery", "check lottery error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.blindbox.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(List<String> list, Continuation<? super ECNetworkResponse<ECBlindBoxLotteryResult>> continuation) {
        ECBlindBoxRepo$checkYiFanLottery$1 eCBlindBoxRepo$checkYiFanLottery$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECBlindBoxRepo$checkYiFanLottery$1) {
            eCBlindBoxRepo$checkYiFanLottery$1 = (ECBlindBoxRepo$checkYiFanLottery$1) continuation;
            int i16 = eCBlindBoxRepo$checkYiFanLottery$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCBlindBoxRepo$checkYiFanLottery$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCBlindBoxRepo$checkYiFanLottery$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCBlindBoxRepo$checkYiFanLottery$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONArray jSONArray = new JSONArray();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.mo162put((String) it.next());
                    }
                    d dVar = new d();
                    eCBlindBoxRepo$checkYiFanLottery$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.mystery_box_operation_svr.OperationSvr", "/trpc.ecom.mystery_box_operation_svr.OperationSvr/CheckYifanLottery", dVar, jSONArray, eCBlindBoxRepo$checkYiFanLottery$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0 || eCNetworkResponse.b() == null) {
                    cg0.a.a("ECBlindBoxRepo", "checkYiFanLottery", "check yi fan lottery error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse;
            }
        }
        eCBlindBoxRepo$checkYiFanLottery$1 = new ECBlindBoxRepo$checkYiFanLottery$1(this, continuation);
        Object obj2 = eCBlindBoxRepo$checkYiFanLottery$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCBlindBoxRepo$checkYiFanLottery$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECBlindBoxRepo", "checkYiFanLottery", "check yi fan lottery error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.tencent.ecommerce.repo.blindbox.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(List<String> list, Continuation<? super ECNetworkResponse<ECBlindBoxLotteryResult>> continuation) {
        ECBlindBoxRepo$checkMultiLottery$1 eCBlindBoxRepo$checkMultiLottery$1;
        Object coroutine_suspended;
        int i3;
        String joinToString$default;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECBlindBoxRepo$checkMultiLottery$1) {
            eCBlindBoxRepo$checkMultiLottery$1 = (ECBlindBoxRepo$checkMultiLottery$1) continuation;
            int i16 = eCBlindBoxRepo$checkMultiLottery$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCBlindBoxRepo$checkMultiLottery$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCBlindBoxRepo$checkMultiLottery$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCBlindBoxRepo$checkMultiLottery$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("checkMultiLottery order_ids: ");
                    List<String> list2 = list;
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list2, "-", null, null, 0, null, null, 62, null);
                    sb5.append(joinToString$default);
                    cg0.a.b("ECBlindBoxRepo", sb5.toString());
                    JSONArray jSONArray = new JSONArray();
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        jSONArray.mo162put((String) it.next());
                    }
                    c cVar = new c();
                    eCBlindBoxRepo$checkMultiLottery$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.mystery_box_operation_svr.OperationSvr", "/trpc.ecom.mystery_box_operation_svr.OperationSvr/CheckMultiLottery", cVar, jSONArray, eCBlindBoxRepo$checkMultiLottery$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                if (eCNetworkResponse.getCode() == 0 || eCNetworkResponse.b() == null) {
                    cg0.a.a("ECBlindBoxRepo", "checkMultiLottery", "check lottery error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse;
            }
        }
        eCBlindBoxRepo$checkMultiLottery$1 = new ECBlindBoxRepo$checkMultiLottery$1(this, continuation);
        Object obj2 = eCBlindBoxRepo$checkMultiLottery$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCBlindBoxRepo$checkMultiLottery$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECBlindBoxRepo", "checkMultiLottery", "check lottery error, errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse;
    }
}
