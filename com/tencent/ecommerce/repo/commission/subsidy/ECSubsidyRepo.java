package com.tencent.ecommerce.repo.commission.subsidy;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import sj0.ECBillModel;
import sj0.ECTaxLinkModel;
import tj0.ECSubsidyExpectedProfitInfo;
import tj0.ECSubsidyIncomeInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\tJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\f\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/repo/commission/subsidy/ECSubsidyRepo;", "Lcom/tencent/ecommerce/repo/commission/subsidy/a;", "Ltj0/b;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cookie", "Lsj0/a;", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltj0/a;", "d", "token", "Lcom/tencent/ecommerce/base/network/api/d;", "Lsj0/d;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubsidyRepo implements com.tencent.ecommerce.repo.commission.subsidy.a {

    /* renamed from: a, reason: collision with root package name */
    public static final ECSubsidyRepo f105063a = new ECSubsidyRepo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/repo/commission/subsidy/ECSubsidyRepo$a", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "", "Ltj0/a;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkJsonContracts<String, ECSubsidyExpectedProfitInfo> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECSubsidyExpectedProfitInfo decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            String optString = a16.optString("cookie");
            boolean optBoolean = a16.optBoolean("is_end");
            JSONArray optJSONArray = a16.optJSONArray("orders");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.optJSONObject(i3));
                }
            }
            return new ECSubsidyExpectedProfitInfo(optString, optBoolean, arrayList);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(String params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.CHANNEL, ug0.b.f438933d.e());
            jSONObject.put("cookie", params);
            return jSONObject;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/repo/commission/subsidy/ECSubsidyRepo$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "", "Ltj0/b;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkJsonContracts<String, ECSubsidyIncomeInfo> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECSubsidyIncomeInfo decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            return new ECSubsidyIncomeInfo(a16.optLong("subsidy"), a16.optLong("paid"), a16.optLong("unpaid"), a16.optString("subtitle"));
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(String params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.CHANNEL, ug0.b.f438933d.e());
            return jSONObject;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/ecommerce/repo/commission/subsidy/ECSubsidyRepo$c", "Lcom/tencent/ecommerce/base/network/api/IECNetworkJsonContracts;", "", "Lsj0/a;", "params", "Lorg/json/JSONObject;", "b", "", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkJsonContracts<String, ECBillModel> {
        c() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECBillModel decodeResponse(byte[] rsp) {
            JSONObject a16 = com.tencent.ecommerce.base.network.api.c.a(rsp);
            String optString = a16.optString("cookie");
            boolean optBoolean = a16.optBoolean("is_end");
            JSONArray optJSONArray = a16.optJSONArray("bills");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.optJSONObject(i3));
                }
            }
            return new ECBillModel(optString, optBoolean, arrayList, null, 8, null);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkJsonContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public JSONObject encodeRequestParams(String params) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.CHANNEL, ug0.b.f438933d.e());
            jSONObject.put("cookie", params);
            return jSONObject;
        }
    }

    ECSubsidyRepo() {
    }

    @Override // com.tencent.ecommerce.repo.commission.subsidy.a
    public Object a(String str, Continuation<? super ECNetworkResponse<ECTaxLinkModel>> continuation) {
        return rj0.a.f431541a.e(str, "trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome", "/trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome/GetTaxLink", continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.commission.subsidy.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Continuation<? super ECSubsidyIncomeInfo> continuation) {
        ECSubsidyRepo$requestIncomeInfo$1 eCSubsidyRepo$requestIncomeInfo$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECSubsidyRepo$requestIncomeInfo$1) {
            eCSubsidyRepo$requestIncomeInfo$1 = (ECSubsidyRepo$requestIncomeInfo$1) continuation;
            int i16 = eCSubsidyRepo$requestIncomeInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCSubsidyRepo$requestIncomeInfo$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCSubsidyRepo$requestIncomeInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCSubsidyRepo$requestIncomeInfo$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = new b();
                    eCSubsidyRepo$requestIncomeInfo$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome", "/trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome/GetIncomeInfo", bVar, "", eCSubsidyRepo$requestIncomeInfo$1);
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
                    cg0.a.a("ECSubsidyRepo", "requestIncomeInfo", "request subsidy income info error: errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCSubsidyRepo$requestIncomeInfo$1 = new ECSubsidyRepo$requestIncomeInfo$1(this, continuation);
        Object obj2 = eCSubsidyRepo$requestIncomeInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCSubsidyRepo$requestIncomeInfo$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECSubsidyRepo", "requestIncomeInfo", "request subsidy income info error: errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.commission.subsidy.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(String str, Continuation<? super ECBillModel> continuation) {
        ECSubsidyRepo$requestPayBillList$1 eCSubsidyRepo$requestPayBillList$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECSubsidyRepo$requestPayBillList$1) {
            eCSubsidyRepo$requestPayBillList$1 = (ECSubsidyRepo$requestPayBillList$1) continuation;
            int i16 = eCSubsidyRepo$requestPayBillList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCSubsidyRepo$requestPayBillList$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCSubsidyRepo$requestPayBillList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCSubsidyRepo$requestPayBillList$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    c cVar = new c();
                    eCSubsidyRepo$requestPayBillList$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome", "/trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome/GetPaymentBills", cVar, str, eCSubsidyRepo$requestPayBillList$1);
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
                    cg0.a.a("ECSubsidyRepo", "requestPayBillList", "request subsidy pay list error: errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCSubsidyRepo$requestPayBillList$1 = new ECSubsidyRepo$requestPayBillList$1(this, continuation);
        Object obj2 = eCSubsidyRepo$requestPayBillList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCSubsidyRepo$requestPayBillList$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECSubsidyRepo", "requestPayBillList", "request subsidy pay list error: errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.tencent.ecommerce.repo.commission.subsidy.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(String str, Continuation<? super ECSubsidyExpectedProfitInfo> continuation) {
        ECSubsidyRepo$requestExpectedProfits$1 eCSubsidyRepo$requestExpectedProfits$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECSubsidyRepo$requestExpectedProfits$1) {
            eCSubsidyRepo$requestExpectedProfits$1 = (ECSubsidyRepo$requestExpectedProfits$1) continuation;
            int i16 = eCSubsidyRepo$requestExpectedProfits$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCSubsidyRepo$requestExpectedProfits$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCSubsidyRepo$requestExpectedProfits$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCSubsidyRepo$requestExpectedProfits$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = new a();
                    eCSubsidyRepo$requestExpectedProfits$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome", "/trpc.ecom.pdd_subsidy_income_server.PddSubsidyIncome/GetEstimatedOrders", aVar, str, eCSubsidyRepo$requestExpectedProfits$1);
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
                    cg0.a.a("ECSubsidyRepo", "requestExpectedProfits", "request subsidy expected profits error: errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
                }
                return eCNetworkResponse.b();
            }
        }
        eCSubsidyRepo$requestExpectedProfits$1 = new ECSubsidyRepo$requestExpectedProfits$1(this, continuation);
        Object obj2 = eCSubsidyRepo$requestExpectedProfits$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCSubsidyRepo$requestExpectedProfits$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        if (eCNetworkResponse.getCode() == 0) {
        }
        cg0.a.a("ECSubsidyRepo", "requestExpectedProfits", "request subsidy expected profits error: errCode:" + eCNetworkResponse.getCode() + ", errMsg:" + eCNetworkResponse.getMessage());
        return eCNetworkResponse.b();
    }
}
