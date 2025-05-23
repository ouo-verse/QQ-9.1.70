package com.tenpay.payment;

import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.base.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ndk.CertUtil;
import com.tenpay.sdk.util.QrcodePaySetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/payment/PaymentUtils;", "", "()V", "MAX_BRIGHTNESS", "", "isQrCodeOpen", "", "saveQrcodeLastPayType", "", "last", "", "setScreenBrightness", "fragment", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "changeToMax", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentUtils {

    @NotNull
    public static final PaymentUtils INSTANCE = new PaymentUtils();
    private static final float MAX_BRIGHTNESS = 204.0f;

    PaymentUtils() {
    }

    public final boolean isQrCodeOpen() {
        boolean z16;
        String string = QrcodePaySetting.getString("qrcode_pay_cid", "");
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return CertUtil.getInstance(BaseApplication.context).isCertExist(string);
    }

    public final void saveQrcodeLastPayType(@Nullable String last) {
        QrcodePaySetting.prepare(BaseApplication.context, a.c());
        QrcodePaySetting.putString("qrcode_last_pay", last);
        QrcodePaySetting.commit();
        QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "saveQrcodeLastPay: " + last);
    }

    public final void setScreenBrightness(@NotNull QWalletBaseFragment fragment, boolean changeToMax) {
        float f16;
        WindowManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (changeToMax) {
            f16 = MAX_BRIGHTNESS;
        } else {
            f16 = -1.0f;
        }
        try {
            QLog.i(QWalletPaymentExtKt.getPaymentTag(this), 1, "setScreenBrightness: " + f16);
            Window window = fragment.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.screenBrightness = Math.min(f16, 255.0f) / 255.0f;
            }
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "setBrightness", e16);
        }
    }
}
