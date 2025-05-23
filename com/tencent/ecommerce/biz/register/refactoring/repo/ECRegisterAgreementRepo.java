package com.tencent.ecommerce.biz.register.refactoring.repo;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.b;
import com.tencent.ecommerce.base.network.service.a;
import com.tencent.ecommerce.repo.register.ECRegisterAgreementInfo;
import com.tencent.ecommerce.repo.register.ECRegisterBindFlagToastInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/repo/ECRegisterAgreementRepo;", "", "Lcom/tencent/ecommerce/repo/register/c;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/repo/register/d;", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterAgreementRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final ECRegisterAgreementRepo f104098a = new ECRegisterAgreementRepo();

    ECRegisterAgreementRepo() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Continuation<? super ECRegisterBindFlagToastInfo> continuation) {
        ECRegisterAgreementRepo$bindMcnRightsFlag$1 eCRegisterAgreementRepo$bindMcnRightsFlag$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        JSONObject jSONObject;
        if (continuation instanceof ECRegisterAgreementRepo$bindMcnRightsFlag$1) {
            eCRegisterAgreementRepo$bindMcnRightsFlag$1 = (ECRegisterAgreementRepo$bindMcnRightsFlag$1) continuation;
            int i16 = eCRegisterAgreementRepo$bindMcnRightsFlag$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRegisterAgreementRepo$bindMcnRightsFlag$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRegisterAgreementRepo$bindMcnRightsFlag$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRegisterAgreementRepo$bindMcnRightsFlag$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = b.f100803a;
                    JSONObject jSONObject2 = new JSONObject();
                    eCRegisterAgreementRepo$bindMcnRightsFlag$1.label = 1;
                    obj = a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/BindMcnRightsFlag", bVar, jSONObject2, eCRegisterAgreementRepo$bindMcnRightsFlag$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECRegisterAgreementRepo", "bindMcnRightsFlag, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/BindMcnRightsFlag, reqParams = " + new JSONObject() + ", resp = " + eCNetworkResponse);
                if (eCNetworkResponse.getCode() != 0 && (jSONObject = (JSONObject) eCNetworkResponse.b()) != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("toast");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    return new ECRegisterBindFlagToastInfo(optJSONObject.optInt("state", 0), optJSONObject.optString("msg", ""));
                }
            }
        }
        eCRegisterAgreementRepo$bindMcnRightsFlag$1 = new ECRegisterAgreementRepo$bindMcnRightsFlag$1(this, continuation);
        Object obj2 = eCRegisterAgreementRepo$bindMcnRightsFlag$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRegisterAgreementRepo$bindMcnRightsFlag$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECRegisterAgreementRepo", "bindMcnRightsFlag, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/BindMcnRightsFlag, reqParams = " + new JSONObject() + ", resp = " + eCNetworkResponse);
        return eCNetworkResponse.getCode() != 0 ? null : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(Continuation<? super ECRegisterAgreementInfo> continuation) {
        ECRegisterAgreementRepo$queryAgreement$1 eCRegisterAgreementRepo$queryAgreement$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        JSONObject jSONObject;
        if (continuation instanceof ECRegisterAgreementRepo$queryAgreement$1) {
            eCRegisterAgreementRepo$queryAgreement$1 = (ECRegisterAgreementRepo$queryAgreement$1) continuation;
            int i16 = eCRegisterAgreementRepo$queryAgreement$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCRegisterAgreementRepo$queryAgreement$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCRegisterAgreementRepo$queryAgreement$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCRegisterAgreementRepo$queryAgreement$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    b bVar = b.f100803a;
                    JSONObject jSONObject2 = new JSONObject();
                    eCRegisterAgreementRepo$queryAgreement$1.label = 1;
                    obj = a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/QueryAgreement", bVar, jSONObject2, eCRegisterAgreementRepo$queryAgreement$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECRegisterAgreementRepo", "queryAgreement, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/QueryAgreement, reqParams = " + new JSONObject() + ", resp = " + eCNetworkResponse);
                if (eCNetworkResponse.getCode() != 0 && (jSONObject = (JSONObject) eCNetworkResponse.b()) != null) {
                    return ECRegisterAgreementInfo.INSTANCE.a(jSONObject);
                }
            }
        }
        eCRegisterAgreementRepo$queryAgreement$1 = new ECRegisterAgreementRepo$queryAgreement$1(this, continuation);
        Object obj2 = eCRegisterAgreementRepo$queryAgreement$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCRegisterAgreementRepo$queryAgreement$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECRegisterAgreementRepo", "queryAgreement, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/QueryAgreement, reqParams = " + new JSONObject() + ", resp = " + eCNetworkResponse);
        return eCNetworkResponse.getCode() != 0 ? null : null;
    }
}
