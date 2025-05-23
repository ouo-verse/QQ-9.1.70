package com.tenpay.sdk.net.gateway;

import com.tencent.mobileqq.base.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tenpay.sdk.net.core.encrypt.EcdhEncryptBytesResult;
import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import com.tenpay.sdk.net.core.encrypt.PayEncryptUtils;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.processor.PsKeyProcessor;
import com.tenpay.sdk.net.gateway.data.GatewayEncryptResult;
import com.tenpay.sdk.net.gateway.data.TransInfoInput;
import com.tenpay.sdk.net.gateway.data.TransInfoOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/net/gateway/GatewayEncryptController;", "", "()V", "decrypt", "", "payloadByteArray", "transInfoOutput", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "encryptResult", "Lcom/tenpay/sdk/net/gateway/data/GatewayEncryptResult;", "encrypt", "needEncrypt", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GatewayEncryptController {

    @NotNull
    public static final GatewayEncryptController INSTANCE = new GatewayEncryptController();

    GatewayEncryptController() {
    }

    @Nullable
    public final byte[] decrypt(@NotNull byte[] payloadByteArray, @Nullable TransInfoOutput transInfoOutput, @Nullable GatewayEncryptResult encryptResult) {
        EcdhEncryptBytesResult ecdhEncryptBytesResult;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(payloadByteArray, "payloadByteArray");
        if (encryptResult != null && encryptResult.isEncrypt()) {
            EncryptResult ecdhResult = encryptResult.getEcdhResult();
            byte[] bArr2 = null;
            if (ecdhResult instanceof EcdhEncryptBytesResult) {
                ecdhEncryptBytesResult = (EcdhEncryptBytesResult) ecdhResult;
            } else {
                ecdhEncryptBytesResult = null;
            }
            PayEncryptUtils payEncryptUtils = PayEncryptUtils.INSTANCE;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            if (ecdhEncryptBytesResult != null) {
                bArr = ecdhEncryptBytesResult.getSecretKey();
            } else {
                bArr = null;
            }
            if (ecdhEncryptBytesResult != null) {
                bArr2 = ecdhEncryptBytesResult.getPublicKey();
            }
            return payEncryptUtils.ecdhDecryptBytes(context, payloadByteArray, bArr, bArr2, transInfoOutput, a.c()).getDecodedPlain();
        }
        return payloadByteArray;
    }

    @NotNull
    public final GatewayEncryptResult encrypt(@NotNull byte[] payloadByteArray, boolean needEncrypt) {
        boolean z16;
        Intrinsics.checkNotNullParameter(payloadByteArray, "payloadByteArray");
        GatewayEncryptResult gatewayEncryptResult = new GatewayEncryptResult(payloadByteArray, needEncrypt, null, new TransInfoInput("plain", null, null, null, null, null, 62, null));
        if (!needEncrypt) {
            return gatewayEncryptResult;
        }
        if (payloadByteArray.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, QWalletGatewayBaseServlet.TAG, "encrypt error payloadByteArray is null", null, 4, null);
            return gatewayEncryptResult;
        }
        try {
            PayEncryptUtils payEncryptUtils = PayEncryptUtils.INSTANCE;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            EcdhEncryptBytesResult ecdhEncryptBytes = payEncryptUtils.ecdhEncryptBytes(context, payloadByteArray, a.c());
            TransInfoInput transInfoInput = new TransInfoInput("ecdh", ecdhEncryptBytes.getEcdhTag(), ecdhEncryptBytes.getMsgNo(), ecdhEncryptBytes.getPublicKey(), PsKeyProcessor.getPsKey$default(PsKeyProcessor.INSTANCE, null, 1, null), null, 32, null);
            byte[] encryptContent = ecdhEncryptBytes.getEncryptContent();
            if (encryptContent != null) {
                payloadByteArray = encryptContent;
            }
            return new GatewayEncryptResult(payloadByteArray, true, ecdhEncryptBytes, transInfoInput);
        } catch (Exception e16) {
            DLog.INSTANCE.w(QWalletGatewayBaseServlet.TAG, "encrypt error:", e16);
            return gatewayEncryptResult;
        }
    }
}
