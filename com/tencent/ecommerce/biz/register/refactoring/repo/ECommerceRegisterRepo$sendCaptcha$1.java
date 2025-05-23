package com.tencent.ecommerce.biz.register.refactoring.repo;

import cg0.a;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.register.network.CaptchaErrorCode;
import com.tencent.ecommerce.biz.register.network.CaptchaStatus;
import com.tencent.ecommerce.biz.register.network.e;
import com.tencent.ecommerce.biz.register.network.f;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/repo/ECommerceRegisterRepo$sendCaptcha$1", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/register/network/e;", "Lcom/tencent/ecommerce/biz/register/network/f;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterRepo$sendCaptcha$1 implements IECNetworkCallback<e, f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f104102a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ IECRegisterSmsCallback f104103b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECommerceRegisterRepo$sendCaptcha$1(String str, IECRegisterSmsCallback iECRegisterSmsCallback) {
        this.f104102a = str;
        this.f104103b = iECRegisterSmsCallback;
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(e reqModel, final ECRemoteResponse errorResponse) {
        a.b("ECommerceRegisterRepo", "[sendCaptcha] failed code: " + errorResponse.getCode() + ", msg " + errorResponse.getMsg() + TokenParser.SP);
        int code = errorResponse.getCode();
        if (code == CaptchaErrorCode.SEND_SMS_TOO_FREQUENT.getErrorCode() || code == CaptchaErrorCode.SEND_SMS_TOO_MANY.getErrorCode()) {
            errorResponse.getMsg();
        }
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo$sendCaptcha$1$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECRegisterSmsCallback iECRegisterSmsCallback = ECommerceRegisterRepo$sendCaptcha$1.this.f104103b;
                if (iECRegisterSmsCallback != null) {
                    iECRegisterSmsCallback.onCheck(errorResponse.getCode(), errorResponse.getMsg(), 0L);
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onSuccess(e reqModel, final f respModel) {
        final String str;
        a.b("ECommerceRegisterRepo", "[sendCaptcha] succeeded, phoneNumber = " + this.f104102a + ", errorCode = " + respModel.getCaptchaErrCode() + ", timestamp = " + respModel.getTimestamp());
        if (respModel.getCaptchaErrCode() == CaptchaStatus.VERIFICATION_SUCCESS.ordinal()) {
            str = "\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001";
        } else {
            str = "\u4eba\u673a\u9a8c\u8bc1\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5";
        }
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo$sendCaptcha$1$onSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECRegisterSmsCallback iECRegisterSmsCallback = ECommerceRegisterRepo$sendCaptcha$1.this.f104103b;
                if (iECRegisterSmsCallback != null) {
                    iECRegisterSmsCallback.onCheck(respModel.getCaptchaErrCode(), str, respModel.getTimestamp());
                }
            }
        });
    }
}
