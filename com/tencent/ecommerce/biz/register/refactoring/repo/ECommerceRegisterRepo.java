package com.tencent.ecommerce.biz.register.refactoring.repo;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.register.network.c;
import com.tencent.ecommerce.biz.register.network.d;
import com.tencent.ecommerce.biz.register.network.e;
import com.tencent.ecommerce.biz.register.network.f;
import com.tencent.ecommerce.biz.register.network.g;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import cooperation.qzone.remote.ServiceConst;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\"\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002JC\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJA\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/repo/ECommerceRegisterRepo;", "", "", "channelNo", "userId", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterConditionCallback;", "callback", "", "b", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterStatusCallback;", "c", "a", "j", "phone", "Lcom/tencent/ecommerce/repo/register/ECaptcha;", "captcha", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterSmsCallback;", h.F, "mediaID", "g", "userName", "idCardNum", "phoneNum", "sessionId", "", "isFollow", "Lcom/tencent/ecommerce/base/network/api/d;", "Lorg/json/JSONObject;", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "psKey", "d", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "smsCode", "f", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "k", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterRepo {

    /* renamed from: a, reason: collision with root package name */
    public static final ECommerceRegisterRepo f104099a = new ECommerceRegisterRepo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/repo/ECommerceRegisterRepo$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/register/network/c;", "Lcom/tencent/ecommerce/biz/register/network/d;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkCallback<c, d> {
        a() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(c reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECommerceRegisterRepo", "checkChannelFlag", "IsRegistered failed");
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(c reqModel, d respModel) {
            Boolean channelFlag = respModel.getChannelFlag();
            boolean booleanValue = channelFlag != null ? channelFlag.booleanValue() : false;
            Boolean result = respModel.getResult();
            if (!(result != null ? result.booleanValue() : false)) {
                cg0.a.b("ECommerceRegisterRepo", "[checkChannelFlag] user is not registered");
            } else if (booleanValue) {
                cg0.a.b("ECommerceRegisterRepo", "[checkChannelFlag] channelFlag is TRUE");
            } else {
                ECommerceRegisterRepo.f104099a.j();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/repo/ECommerceRegisterRepo$b", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/register/network/g;", "Lcom/tencent/ecommerce/biz/register/network/h;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkCallback<g, com.tencent.ecommerce.biz.register.network.h> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(g reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a("ECommerceRegisterRepo", "setChannelFlag", "SetChannelRightsFlag failed" + errorResponse.getMsg());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(g reqModel, com.tencent.ecommerce.biz.register.network.h respModel) {
            cg0.a.b("ECommerceRegisterRepo", "[setChannelFlag] SetChannelRightsFlag succeeded");
        }
    }

    ECommerceRegisterRepo() {
    }

    public final void a() {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/CheckRegister", new c(), new d(), new a());
    }

    public final void b(String channelNo, String userId, IECRegisterConditionCallback callback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.window_info_svr.WindowInfoSvr", "/trpc.ecom.window_info_svr.WindowInfoSvr/GetGoodsRightCondition", new com.tencent.ecommerce.biz.register.network.a(channelNo, userId), new com.tencent.ecommerce.biz.register.network.b(), new ECommerceRegisterRepo$checkConditions$1(callback));
    }

    public final void c(IECRegisterStatusCallback callback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/CheckRegister", new c(), new d(), new ECommerceRegisterRepo$checkRegister$1(callback));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(String str, String str2, String str3, String str4, String str5, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECommerceRegisterRepo$realNameVerify$1 eCommerceRegisterRepo$realNameVerify$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof ECommerceRegisterRepo$realNameVerify$1) {
            eCommerceRegisterRepo$realNameVerify$1 = (ECommerceRegisterRepo$realNameVerify$1) continuation;
            int i16 = eCommerceRegisterRepo$realNameVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCommerceRegisterRepo$realNameVerify$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCommerceRegisterRepo$realNameVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCommerceRegisterRepo$realNameVerify$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("skey_type", 27);
                    jSONObject3.put("skey", str);
                    jSONObject3.put("domain", "kandian.qq.com");
                    Unit unit = Unit.INSTANCE;
                    jSONObject2.put("login_info", jSONObject3);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("id_card_num", str3);
                    jSONObject4.put("cer_name", str2);
                    jSONObject2.put("cert_info", jSONObject4);
                    jSONObject2.put("phone_number", str4);
                    jSONObject2.put("sms_code", str5);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCommerceRegisterRepo$realNameVerify$1.L$0 = jSONObject2;
                    eCommerceRegisterRepo$realNameVerify$1.label = 1;
                    Object e16 = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/EcomVerifyUserInfo", bVar, jSONObject2, eCommerceRegisterRepo$realNameVerify$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCommerceRegisterRepo$realNameVerify$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECommerceRegisterRepo", "realNameVerify, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/SendSmsCodeBySession, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse);
                return eCNetworkResponse;
            }
        }
        eCommerceRegisterRepo$realNameVerify$1 = new ECommerceRegisterRepo$realNameVerify$1(this, continuation);
        Object obj2 = eCommerceRegisterRepo$realNameVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCommerceRegisterRepo$realNameVerify$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECommerceRegisterRepo", "realNameVerify, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/SendSmsCodeBySession, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse2);
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(String str, String str2, String str3, String str4, boolean z16, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECommerceRegisterRepo$register$1 eCommerceRegisterRepo$register$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof ECommerceRegisterRepo$register$1) {
            eCommerceRegisterRepo$register$1 = (ECommerceRegisterRepo$register$1) continuation;
            int i16 = eCommerceRegisterRepo$register$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCommerceRegisterRepo$register$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCommerceRegisterRepo$register$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCommerceRegisterRepo$register$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
                    jSONObject2.put(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccountNickName());
                    jSONObject2.put(QCircleSchemeAttr.Detail.AVATAR_URL, qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccountHeadUrl());
                    jSONObject2.put("identity", 1);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("id_card_num", str2);
                    jSONObject3.put("cer_name", str);
                    Unit unit = Unit.INSTANCE;
                    jSONObject2.put("cert_info", jSONObject3);
                    jSONObject2.put("phone_number", str3);
                    jSONObject2.put(ServiceConst.PARA_SESSION_ID, str4);
                    jSONObject2.put("is_follow", z16);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCommerceRegisterRepo$register$1.L$0 = jSONObject2;
                    eCommerceRegisterRepo$register$1.label = 1;
                    Object e16 = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/EcomRegister", bVar, jSONObject2, eCommerceRegisterRepo$register$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCommerceRegisterRepo$register$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECommerceRegisterRepo", "register, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/EcomRegister, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse);
                return eCNetworkResponse;
            }
        }
        eCommerceRegisterRepo$register$1 = new ECommerceRegisterRepo$register$1(this, continuation);
        Object obj2 = eCommerceRegisterRepo$register$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCommerceRegisterRepo$register$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECommerceRegisterRepo", "register, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/EcomRegister, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse2);
        return eCNetworkResponse2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(String str, String str2, Continuation<? super ECNetworkResponse<JSONObject>> continuation) {
        ECommerceRegisterRepo$registerBySession$1 eCommerceRegisterRepo$registerBySession$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        if (continuation instanceof ECommerceRegisterRepo$registerBySession$1) {
            eCommerceRegisterRepo$registerBySession$1 = (ECommerceRegisterRepo$registerBySession$1) continuation;
            int i16 = eCommerceRegisterRepo$registerBySession$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCommerceRegisterRepo$registerBySession$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCommerceRegisterRepo$registerBySession$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCommerceRegisterRepo$registerBySession$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ServiceConst.PARA_SESSION_ID, str);
                    jSONObject2.put("sms_code", str2);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCommerceRegisterRepo$registerBySession$1.L$0 = jSONObject2;
                    eCommerceRegisterRepo$registerBySession$1.label = 1;
                    Object e16 = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/RegisterBySession", bVar, jSONObject2, eCommerceRegisterRepo$registerBySession$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCommerceRegisterRepo$registerBySession$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECommerceRegisterRepo", "registerBySession, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/RegisterBySession, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse);
                return eCNetworkResponse;
            }
        }
        eCommerceRegisterRepo$registerBySession$1 = new ECommerceRegisterRepo$registerBySession$1(this, continuation);
        Object obj2 = eCommerceRegisterRepo$registerBySession$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCommerceRegisterRepo$registerBySession$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        cg0.a.b("ECommerceRegisterRepo", "registerBySession, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/RegisterBySession, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse2);
        return eCNetworkResponse2;
    }

    public final void g(String mediaID) {
        ECLocalConfig.f100650f.setString("mediaId", mediaID, Boolean.TRUE);
    }

    public final void h(String phone, ECaptcha captcha, IECRegisterSmsCallback callback) {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/EcomSendCode", new e(phone, captcha), new f(), new ECommerceRegisterRepo$sendCaptcha$1(phone, callback));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object i(String str, Continuation<? super Boolean> continuation) {
        ECommerceRegisterRepo$sendSmsCodeBySession$1 eCommerceRegisterRepo$sendSmsCodeBySession$1;
        Object coroutine_suspended;
        int i3;
        JSONObject jSONObject;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECommerceRegisterRepo$sendSmsCodeBySession$1) {
            eCommerceRegisterRepo$sendSmsCodeBySession$1 = (ECommerceRegisterRepo$sendSmsCodeBySession$1) continuation;
            int i16 = eCommerceRegisterRepo$sendSmsCodeBySession$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCommerceRegisterRepo$sendSmsCodeBySession$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCommerceRegisterRepo$sendSmsCodeBySession$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCommerceRegisterRepo$sendSmsCodeBySession$1.label;
                boolean z16 = true;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ServiceConst.PARA_SESSION_ID, str);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    eCommerceRegisterRepo$sendSmsCodeBySession$1.L$0 = jSONObject2;
                    eCommerceRegisterRepo$sendSmsCodeBySession$1.label = 1;
                    Object e16 = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/SendSmsCodeBySession", bVar, jSONObject2, eCommerceRegisterRepo$sendSmsCodeBySession$1);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = e16;
                    jSONObject = jSONObject2;
                } else if (i3 == 1) {
                    jSONObject = (JSONObject) eCommerceRegisterRepo$sendSmsCodeBySession$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECommerceRegisterRepo", "sendSmsCodeBySession, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/SendSmsCodeBySession, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse);
                if (eCNetworkResponse.getCode() != 0) {
                    cg0.a.a("ECommerceRegisterRepo", "sendSmsCodeBySession", "[sendSmsCodeBySession] error = " + eCNetworkResponse.getMessage());
                    z16 = false;
                }
                return Boxing.boxBoolean(z16);
            }
        }
        eCommerceRegisterRepo$sendSmsCodeBySession$1 = new ECommerceRegisterRepo$sendSmsCodeBySession$1(this, continuation);
        Object obj2 = eCommerceRegisterRepo$sendSmsCodeBySession$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCommerceRegisterRepo$sendSmsCodeBySession$1.label;
        boolean z162 = true;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECommerceRegisterRepo", "sendSmsCodeBySession, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/SendSmsCodeBySession, reqParams = " + jSONObject + ", resp = " + eCNetworkResponse);
        if (eCNetworkResponse.getCode() != 0) {
        }
        return Boxing.boxBoolean(z162);
    }

    public final void j() {
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/SetChannelRightsFlag", new g(), new com.tencent.ecommerce.biz.register.network.h(), new b());
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(Continuation<? super Boolean> continuation) {
        ECommerceRegisterRepo$unbindPromoter$1 eCommerceRegisterRepo$unbindPromoter$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECommerceRegisterRepo$unbindPromoter$1) {
            eCommerceRegisterRepo$unbindPromoter$1 = (ECommerceRegisterRepo$unbindPromoter$1) continuation;
            int i16 = eCommerceRegisterRepo$unbindPromoter$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCommerceRegisterRepo$unbindPromoter$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCommerceRegisterRepo$unbindPromoter$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCommerceRegisterRepo$unbindPromoter$1.label;
                boolean z16 = true;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.ecommerce.base.network.api.b bVar = com.tencent.ecommerce.base.network.api.b.f100803a;
                    JSONObject jSONObject = new JSONObject();
                    eCommerceRegisterRepo$unbindPromoter$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/UntiePromoter", bVar, jSONObject, eCommerceRegisterRepo$unbindPromoter$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                cg0.a.b("ECommerceRegisterRepo", "registerBySession, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/UntiePromoter, resp = " + eCNetworkResponse);
                if (eCNetworkResponse.getCode() != 0) {
                    cg0.a.a("ECommerceRegisterRepo", "unbindPromoter", "[unbindPromoter] error = " + eCNetworkResponse.getMessage());
                    z16 = false;
                }
                return Boxing.boxBoolean(z16);
            }
        }
        eCommerceRegisterRepo$unbindPromoter$1 = new ECommerceRegisterRepo$unbindPromoter$1(this, continuation);
        Object obj2 = eCommerceRegisterRepo$unbindPromoter$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCommerceRegisterRepo$unbindPromoter$1.label;
        boolean z162 = true;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        cg0.a.b("ECommerceRegisterRepo", "registerBySession, service = trpc.ecom.register_svr.RegisterSvr, method = /trpc.ecom.register_svr.RegisterSvr/UntiePromoter, resp = " + eCNetworkResponse);
        if (eCNetworkResponse.getCode() != 0) {
        }
        return Boxing.boxBoolean(z162);
    }
}
