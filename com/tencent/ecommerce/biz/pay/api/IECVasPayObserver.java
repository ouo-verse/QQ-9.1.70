package com.tencent.ecommerce.biz.pay.api;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECVasPayObserver;", "", "onOpenPayViewFail", "", "onOpenPayViewSuccess", "onPayError", "code", "", "onPaySuccess", "onPayViewClose", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECVasPayObserver {
    void onOpenPayViewFail();

    void onOpenPayViewSuccess();

    void onPayError(int code);

    void onPaySuccess();

    void onPayViewClose();
}
