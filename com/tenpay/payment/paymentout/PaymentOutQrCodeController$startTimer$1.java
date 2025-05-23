package com.tenpay.payment.paymentout;

import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tenpay/payment/paymentout/PaymentOutQrCodeController$startTimer$1", "Ljava/util/TimerTask;", TencentLocation.RUN_MODE, "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentOutQrCodeController$startTimer$1 extends TimerTask {
    final /* synthetic */ PaymentOutQrCodeController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PaymentOutQrCodeController$startTimer$1(PaymentOutQrCodeController paymentOutQrCodeController) {
        this.this$0 = paymentOutQrCodeController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void run$lambda$0(PaymentOutQrCodeController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showCodeView();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final PaymentOutQrCodeController paymentOutQrCodeController = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tenpay.payment.paymentout.af
            @Override // java.lang.Runnable
            public final void run() {
                PaymentOutQrCodeController$startTimer$1.run$lambda$0(PaymentOutQrCodeController.this);
            }
        });
    }
}
