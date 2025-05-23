package com.tenpay.payment.qrcodehb;

import com.tencent.qphone.base.util.QLog;
import com.tenpay.ndk.DesDecUtil;
import com.tenpay.ndk.DesEncUtil;
import com.tenpay.payment.QWalletPaymentExtKt;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbManager;", "", "()V", "QRCODE_HB_AES_CALKEY", "", "TOKEN_SURFIX", "aesDecrypt", "cipher", "aesEncrypt", "plain", "desDecrypt", "desEncrypt", "readQrCodeHbToken", "saveQrCodeHbToken", "", QrCodeHbFragment.KEY_IN_QR_TOKEN, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QrCodeHbManager {

    @NotNull
    public static final QrCodeHbManager INSTANCE = new QrCodeHbManager();

    @NotNull
    private static String TOKEN_SURFIX = IQWalletHelper.CONFIG_SURFIX;

    @NotNull
    private static String QRCODE_HB_AES_CALKEY = "tenpayguid";

    QrCodeHbManager() {
    }

    private final String aesDecrypt(String cipher) {
        try {
            String calcKey = QWalletHelperDelegate.hexdigest(com.tencent.mobileqq.base.a.c() + QRCODE_HB_AES_CALKEY + QWalletHelperDelegate.getQWDevId());
            Intrinsics.checkNotNullExpressionValue(calcKey, "calcKey");
            String substring = calcKey.substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = calcKey.substring(calcKey.length() - 16);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String desDecrypt = QWalletHelperDelegate.desDecrypt(cipher, substring, substring2);
            QLog.i(IQWalletHelper.TAG_WALLET_REDPACK, 1, "readQRTokenConfig aesDecrypt: " + calcKey + ", " + desDecrypt);
            return desDecrypt;
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "readQRTokenConfig aesDecrypt fail", e16);
            return null;
        }
    }

    private final String aesEncrypt(String plain) {
        try {
            String calcKey = QWalletHelperDelegate.hexdigest(com.tencent.mobileqq.base.a.c() + QRCODE_HB_AES_CALKEY + QWalletHelperDelegate.getQWDevId());
            Intrinsics.checkNotNullExpressionValue(calcKey, "calcKey");
            String substring = calcKey.substring(0, 16);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = calcKey.substring(calcKey.length() - 16);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            String desEncrypt = QWalletHelperDelegate.desEncrypt(plain, substring, substring2);
            QLog.i(IQWalletHelper.TAG_WALLET_REDPACK, 1, "saveQRTokenConfig aesEncrypt: " + calcKey + ", " + plain);
            return desEncrypt;
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "saveQRTokenConfig aesEncrypt fail", e16);
            return null;
        }
    }

    private final String desDecrypt(String cipher) {
        try {
            DesDecUtil desDecUtil = new DesDecUtil(MobileQQ.sMobileQQ);
            desDecUtil.decryptDes(0, cipher);
            String decRes = desDecUtil.getDecRes();
            QLog.i(IQWalletHelper.TAG_WALLET_REDPACK, 1, "readQRTokenConfig desDecrypt result = " + decRes);
            return decRes;
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "readQRTokenConfig desDecrypt fail", e16);
            return null;
        }
    }

    private final String desEncrypt(String plain) {
        try {
            DesEncUtil desEncUtil = new DesEncUtil(MobileQQ.sMobileQQ);
            desEncUtil.encryptDes(0, plain);
            String desEncResult = desEncUtil.getDesEncResult();
            QLog.i(IQWalletHelper.TAG_WALLET_REDPACK, 1, "saveQRTokenConfig desEncrypt result = " + desEncResult);
            return desEncResult;
        } catch (Exception e16) {
            QLog.e(QWalletPaymentExtKt.getPaymentTag(this), 1, "saveQRTokenConfig desEncrypt fail", e16);
            return null;
        }
    }

    @Nullable
    public final String readQrCodeHbToken() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean endsWith$default;
        String i3 = com.tencent.mobileqq.qwallet.utils.g.i("qrcode_hb_qrtoken_" + com.tencent.mobileqq.base.a.c());
        if (i3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "readQrCodeHbToken empty");
            return null;
        }
        String desDecrypt = desDecrypt(i3);
        if (desDecrypt != null && desDecrypt.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            desDecrypt = aesDecrypt(i3);
        }
        if (desDecrypt != null && desDecrypt.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!z18) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(desDecrypt, TOKEN_SURFIX, false, 2, null);
            if (endsWith$default) {
                String substring = desDecrypt.substring(0, desDecrypt.length() - TOKEN_SURFIX.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                return substring;
            }
        }
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "readQrCodeHbToken fail: " + desDecrypt);
        return null;
    }

    public final void saveQrCodeHbToken(@Nullable String qrToken) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (qrToken != null && qrToken.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "saveQrCodeHbToken: " + qrToken);
        String str = qrToken + TOKEN_SURFIX;
        String desEncrypt = desEncrypt(str);
        if (desEncrypt != null && desEncrypt.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            desEncrypt = aesEncrypt(str);
        }
        if (desEncrypt == null || desEncrypt.length() == 0) {
            z18 = true;
        }
        if (!z18) {
            com.tencent.mobileqq.qwallet.utils.g.q("qrcode_hb_qrtoken_" + com.tencent.mobileqq.base.a.c(), desEncrypt);
            return;
        }
        QLog.w(QWalletPaymentExtKt.getPaymentTag(this), 1, "saveQrCodeHbToken fail");
    }
}
