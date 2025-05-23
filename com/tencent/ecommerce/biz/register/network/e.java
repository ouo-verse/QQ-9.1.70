package com.tencent.ecommerce.biz.register.network;

import com.tencent.ecommerce.base.network.api.IECRequest;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/register/network/e;", "Lcom/tencent/ecommerce/base/network/api/IECRequest;", "Lorg/json/JSONObject;", "encodeParams", "", "a", "Ljava/lang/String;", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "Lcom/tencent/ecommerce/repo/register/ECaptcha;", "b", "Lcom/tencent/ecommerce/repo/register/ECaptcha;", "eCaptcha", "<init>", "(Ljava/lang/String;Lcom/tencent/ecommerce/repo/register/ECaptcha;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e implements IECRequest {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String phoneNumber;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ECaptcha eCaptcha;

    public e(String str, ECaptcha eCaptcha) {
        this.phoneNumber = str;
        this.eCaptcha = eCaptcha;
    }

    @Override // com.tencent.ecommerce.base.network.api.IECRequest
    public JSONObject encodeParams() {
        try {
            return new JSONObject().put("phone_number", this.phoneNumber).put("captcha_info", this.eCaptcha.c());
        } catch (JSONException e16) {
            cg0.a.a("ECSendSmsCodeReq", "encodeParams", "[encodeData] error = " + e16);
            return new JSONObject();
        }
    }
}
