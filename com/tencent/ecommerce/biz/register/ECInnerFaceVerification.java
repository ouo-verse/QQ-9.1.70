package com.tencent.ecommerce.biz.register;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.account.api.IECFaceVerification;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import com.tencent.ecommerce.biz.register.network.ECVerifyFaceReqParam;
import com.tencent.ecommerce.biz.register.network.ECVerifyFaceResp;
import com.tencent.ecommerce.biz.register.network.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.random.RandomKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J;\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/register/ECInnerFaceVerification;", "", "", "step", "code", "", "costInMs", "", "msg", "", "b", "c", "Landroid/content/Context;", "context", "psKey", "userName", "idCardNum", "sessionId", "Lcom/tencent/ecommerce/biz/register/network/k;", "a", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECInnerFaceVerification {

    /* renamed from: a, reason: collision with root package name */
    public static final ECInnerFaceVerification f103955a = new ECInnerFaceVerification();

    ECInnerFaceVerification() {
    }

    private final void b(int step, int code, long costInMs, String msg2) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_face_identify_report", new e().b("state", String.valueOf(step)).b("cost_time", String.valueOf(costInMs)).b("result_msg", msg2).b("result_code", String.valueOf(code)).f(), false, 4, null);
    }

    private final void c(int step, long costInMs) {
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_face_identify_report", new e().b("state", String.valueOf(step)).b("cost_time", String.valueOf(costInMs)).b("result_code", "0").f(), false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Context context, String str, String str2, String str3, String str4, Continuation<? super ECVerifyFaceResp> continuation) {
        ECInnerFaceVerification$faceVerify$1 eCInnerFaceVerification$faceVerify$1;
        Object coroutine_suspended;
        int i3;
        String str5;
        String str6;
        String str7;
        long j3;
        ECInnerFaceVerification eCInnerFaceVerification;
        Context context2;
        long j16;
        IECFaceVerification.IdentificationConfig identificationConfig;
        long currentTimeMillis;
        String str8;
        String str9;
        String str10;
        long j17;
        ECInnerFaceVerification eCInnerFaceVerification2;
        IECFaceVerification.FaceVerificationResult faceVerificationResult;
        ECInnerFaceVerification eCInnerFaceVerification3;
        long j18;
        ECNetworkResponse eCNetworkResponse;
        long currentTimeMillis2;
        ECVerifyFaceResp eCVerifyFaceResp;
        String str11;
        if (continuation instanceof ECInnerFaceVerification$faceVerify$1) {
            eCInnerFaceVerification$faceVerify$1 = (ECInnerFaceVerification$faceVerify$1) continuation;
            int i16 = eCInnerFaceVerification$faceVerify$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCInnerFaceVerification$faceVerify$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCInnerFaceVerification$faceVerify$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCInnerFaceVerification$faceVerify$1.label;
                String str12 = "";
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
                    String valueOf = String.valueOf(qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
                    long abs = Math.abs(RandomKt.Random(System.currentTimeMillis()).nextLong());
                    IECFaceVerification faceVerification = qQEcommerceSdk.getGlobalInternalSdk().getFaceVerification();
                    eCInnerFaceVerification$faceVerify$1.L$0 = this;
                    eCInnerFaceVerification$faceVerify$1.L$1 = context;
                    eCInnerFaceVerification$faceVerify$1.L$2 = str2;
                    eCInnerFaceVerification$faceVerify$1.L$3 = str3;
                    eCInnerFaceVerification$faceVerify$1.L$4 = str4;
                    eCInnerFaceVerification$faceVerify$1.J$0 = currentTimeMillis3;
                    eCInnerFaceVerification$faceVerify$1.J$1 = abs;
                    eCInnerFaceVerification$faceVerify$1.label = 1;
                    Object requestForFaceVerificationConfig = faceVerification.requestForFaceVerificationConfig(str, valueOf, str3, str2, abs, eCInnerFaceVerification$faceVerify$1);
                    if (requestForFaceVerificationConfig == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str5 = str2;
                    str6 = str3;
                    str7 = str4;
                    j3 = currentTimeMillis3;
                    eCInnerFaceVerification = this;
                    context2 = context;
                    obj = requestForFaceVerificationConfig;
                    j16 = abs;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                j18 = eCInnerFaceVerification$faceVerify$1.J$0;
                                eCInnerFaceVerification3 = (ECInnerFaceVerification) eCInnerFaceVerification$faceVerify$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                eCNetworkResponse = (ECNetworkResponse) obj;
                                cg0.a.b("ECInnerFaceVerification", "[FaceVerification] verify result = " + eCNetworkResponse);
                                currentTimeMillis2 = System.currentTimeMillis() - j18;
                                if (eCNetworkResponse.getCode() != 0 && (eCVerifyFaceResp = (ECVerifyFaceResp) eCNetworkResponse.b()) != null && eCVerifyFaceResp.isResultSuccess) {
                                    eCInnerFaceVerification3.c(3, currentTimeMillis2);
                                    ECVerifyFaceResp eCVerifyFaceResp2 = (ECVerifyFaceResp) eCNetworkResponse.b();
                                    if (eCVerifyFaceResp2 != null && (str11 = eCVerifyFaceResp2.sessionId) != null) {
                                        str12 = str11;
                                    }
                                    return new ECVerifyFaceResp(true, 0, str12);
                                }
                                eCInnerFaceVerification3.b(3, eCNetworkResponse.getCode(), currentTimeMillis2, "verify result failed");
                                return new ECVerifyFaceResp(false, eCNetworkResponse.getCode(), "");
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        long j19 = eCInnerFaceVerification$faceVerify$1.J$1;
                        long j26 = eCInnerFaceVerification$faceVerify$1.J$0;
                        String str13 = (String) eCInnerFaceVerification$faceVerify$1.L$3;
                        String str14 = (String) eCInnerFaceVerification$faceVerify$1.L$2;
                        String str15 = (String) eCInnerFaceVerification$faceVerify$1.L$1;
                        ECInnerFaceVerification eCInnerFaceVerification4 = (ECInnerFaceVerification) eCInnerFaceVerification$faceVerify$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str8 = str13;
                        str9 = str14;
                        str10 = str15;
                        j17 = j26;
                        currentTimeMillis = j19;
                        eCInnerFaceVerification2 = eCInnerFaceVerification4;
                        faceVerificationResult = (IECFaceVerification.FaceVerificationResult) obj;
                        cg0.a.b("ECInnerFaceVerification", "[FaceVerification] startFaceVerification result = " + faceVerificationResult);
                        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis;
                        if (faceVerificationResult != null) {
                            eCInnerFaceVerification2.b(2, -11, currentTimeMillis4, "cancel face verification");
                            return new ECVerifyFaceResp(false, -11, "");
                        }
                        eCInnerFaceVerification2.c(2, currentTimeMillis4);
                        long currentTimeMillis5 = System.currentTimeMillis();
                        i iVar = new i();
                        ECVerifyFaceReqParam eCVerifyFaceReqParam = new ECVerifyFaceReqParam(str9, str10, faceVerificationResult.getAppId(), faceVerificationResult.getOpenId(), faceVerificationResult.getIdKey(), String.valueOf(j17), str8);
                        eCInnerFaceVerification$faceVerify$1.L$0 = eCInnerFaceVerification2;
                        eCInnerFaceVerification$faceVerify$1.L$1 = null;
                        eCInnerFaceVerification$faceVerify$1.L$2 = null;
                        eCInnerFaceVerification$faceVerify$1.L$3 = null;
                        eCInnerFaceVerification$faceVerify$1.J$0 = currentTimeMillis5;
                        eCInnerFaceVerification$faceVerify$1.label = 3;
                        obj = com.tencent.ecommerce.base.network.service.a.e("trpc.ecom.register_svr.RegisterSvr", "/trpc.ecom.register_svr.RegisterSvr/VerifyFace", iVar, eCVerifyFaceReqParam, eCInnerFaceVerification$faceVerify$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        eCInnerFaceVerification3 = eCInnerFaceVerification2;
                        j18 = currentTimeMillis5;
                        eCNetworkResponse = (ECNetworkResponse) obj;
                        cg0.a.b("ECInnerFaceVerification", "[FaceVerification] verify result = " + eCNetworkResponse);
                        currentTimeMillis2 = System.currentTimeMillis() - j18;
                        if (eCNetworkResponse.getCode() != 0) {
                        }
                        eCInnerFaceVerification3.b(3, eCNetworkResponse.getCode(), currentTimeMillis2, "verify result failed");
                        return new ECVerifyFaceResp(false, eCNetworkResponse.getCode(), "");
                    }
                    j16 = eCInnerFaceVerification$faceVerify$1.J$1;
                    j3 = eCInnerFaceVerification$faceVerify$1.J$0;
                    str7 = (String) eCInnerFaceVerification$faceVerify$1.L$4;
                    str6 = (String) eCInnerFaceVerification$faceVerify$1.L$3;
                    str5 = (String) eCInnerFaceVerification$faceVerify$1.L$2;
                    context2 = (Context) eCInnerFaceVerification$faceVerify$1.L$1;
                    eCInnerFaceVerification = (ECInnerFaceVerification) eCInnerFaceVerification$faceVerify$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                identificationConfig = (IECFaceVerification.IdentificationConfig) obj;
                cg0.a.b("ECInnerFaceVerification", "[FaceVerification] requestForFaceVerificationConfig = " + identificationConfig);
                long currentTimeMillis6 = System.currentTimeMillis() - j3;
                if (identificationConfig != null) {
                    eCInnerFaceVerification.b(1, -12, currentTimeMillis6, "requestForFaceVerificationConfig failed");
                    return new ECVerifyFaceResp(false, -12, "");
                }
                eCInnerFaceVerification.c(1, currentTimeMillis6);
                currentTimeMillis = System.currentTimeMillis();
                IECFaceVerification faceVerification2 = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getFaceVerification();
                eCInnerFaceVerification$faceVerify$1.L$0 = eCInnerFaceVerification;
                eCInnerFaceVerification$faceVerify$1.L$1 = str5;
                eCInnerFaceVerification$faceVerify$1.L$2 = str6;
                eCInnerFaceVerification$faceVerify$1.L$3 = str7;
                eCInnerFaceVerification$faceVerify$1.L$4 = null;
                eCInnerFaceVerification$faceVerify$1.J$0 = j16;
                eCInnerFaceVerification$faceVerify$1.J$1 = currentTimeMillis;
                eCInnerFaceVerification$faceVerify$1.label = 2;
                obj = faceVerification2.startFaceVerification(context2, identificationConfig, eCInnerFaceVerification$faceVerify$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str8 = str7;
                str9 = str6;
                str10 = str5;
                j17 = j16;
                eCInnerFaceVerification2 = eCInnerFaceVerification;
                faceVerificationResult = (IECFaceVerification.FaceVerificationResult) obj;
                cg0.a.b("ECInnerFaceVerification", "[FaceVerification] startFaceVerification result = " + faceVerificationResult);
                long currentTimeMillis42 = System.currentTimeMillis() - currentTimeMillis;
                if (faceVerificationResult != null) {
                }
            }
        }
        eCInnerFaceVerification$faceVerify$1 = new ECInnerFaceVerification$faceVerify$1(this, continuation);
        Object obj2 = eCInnerFaceVerification$faceVerify$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCInnerFaceVerification$faceVerify$1.label;
        String str122 = "";
        if (i3 != 0) {
        }
        identificationConfig = (IECFaceVerification.IdentificationConfig) obj2;
        cg0.a.b("ECInnerFaceVerification", "[FaceVerification] requestForFaceVerificationConfig = " + identificationConfig);
        long currentTimeMillis62 = System.currentTimeMillis() - j3;
        if (identificationConfig != null) {
        }
    }
}
