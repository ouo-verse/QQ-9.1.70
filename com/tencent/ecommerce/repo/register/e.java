package com.tencent.ecommerce.repo.register;

import com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr.ECQshopOrderSvr$CaptchaToken;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECaptcha;", "Lcom/tencent/ecommerce/repo/proto/ecom/qshop_order_svr/ECQshopOrderSvr$CaptchaToken;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e {
    public static final ECQshopOrderSvr$CaptchaToken a(ECaptcha eCaptcha) {
        ECQshopOrderSvr$CaptchaToken eCQshopOrderSvr$CaptchaToken = new ECQshopOrderSvr$CaptchaToken();
        eCQshopOrderSvr$CaptchaToken.ticket.set(eCaptcha.getTicket());
        eCQshopOrderSvr$CaptchaToken.rand_str.set(eCaptcha.getRandStr());
        return eCQshopOrderSvr$CaptchaToken;
    }
}
