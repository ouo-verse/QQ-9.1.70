package com.tenpay.payment.qrcodehb;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.ndk.CertUtil;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u001a\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/payment/qrcodehb/QrCodeHbUtils;", "", "()V", "TAG", "", "reportFace2Face", "", "isGuide", "", "opNameSuffix", "signQrCode", "inMap", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class QrCodeHbUtils {

    @NotNull
    public static final QrCodeHbUtils INSTANCE = new QrCodeHbUtils();

    @NotNull
    private static final String TAG = "QrCodeHbUtils";

    QrCodeHbUtils() {
    }

    public final void reportFace2Face(boolean isGuide, @NotNull String opNameSuffix) {
        String str;
        Intrinsics.checkNotNullParameter(opNameSuffix, "opNameSuffix");
        if (isGuide) {
            str = ".index";
        } else {
            str = ".detail";
        }
        com.tencent.mobileqq.qwallet.c.f(("face2face" + str) + opNameSuffix, null, null, null, null, 30, null);
    }

    public final boolean signQrCode(@NotNull Map<String, String> inMap) {
        Intrinsics.checkNotNullParameter(inMap, "inMap");
        try {
            String certId = CertUtil.getCid(BaseApplication.context, com.tencent.mobileqq.base.a.c());
            if (TextUtils.isEmpty(certId)) {
                return false;
            }
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            String deviceId = o.c();
            String d16 = com.tencent.mobileqq.base.b.d();
            String valueOf2 = String.valueOf(new Random().nextInt());
            String certSign = CertUtil.getInstance(BaseApplication.context).genUserSigNoEncode(certId, valueOf + deviceId + d16 + valueOf2);
            if (TextUtils.isEmpty(certSign)) {
                return false;
            }
            inMap.put("curr_ts", valueOf);
            Intrinsics.checkNotNullExpressionValue(deviceId, "deviceId");
            inMap.put("device_id", deviceId);
            inMap.put("guid", d16);
            inMap.put("random_str", valueOf2);
            Intrinsics.checkNotNullExpressionValue(certId, "certId");
            inMap.put("qr_cert_cn", certId);
            Intrinsics.checkNotNullExpressionValue(certSign, "certSign");
            inMap.put("qr_cert_sign", certSign);
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            return false;
        }
    }
}
