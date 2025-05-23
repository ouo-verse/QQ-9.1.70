package com.tenpay.sdk.net.core.encrypt;

import android.content.Context;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.QFuncApi;
import com.tenpay.ndk.DesDecUtil;
import com.tenpay.ndk.DesEncUtil;
import com.tenpay.ndk.QWssl;
import com.tenpay.ndk.QwsslSoLoader;
import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import com.tenpay.sdk.net.core.exception.EcdhDecryptException;
import com.tenpay.sdk.net.core.exception.EcdhEncryptException;
import com.tenpay.sdk.net.core.exception.EcdhException;
import com.tenpay.sdk.net.core.exception.EcdhTlsRetryException;
import com.tenpay.sdk.net.gateway.data.TransInfoOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000bJ(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u000bJ4\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J@\u0010\"\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\u00142\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J \u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004J \u0010(\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils;", "", "()V", "KEY_ECDH_EXPIRE_TIME", "", "KEY_ECDH_EXPIRE_TIME_BYTES", "KEY_ECDH_PUBLIC", "KEY_ECDH_PUBLIC_BYTES", "KEY_ECDH_SECRET", "KEY_ECDH_SECRET_BYTES", "RET_ECDH_ENCRYT_CHANGE", "", "RET_ECDH_KEYSHARE_SUCC", "RET_ECDH_KEY_OVERTIME", "RET_FAIL", "RET_SUCCEED", "TAG", "checkByteArray", "", "data", "", "desDecrypt", "Lcom/tenpay/sdk/net/core/encrypt/DecryptResult;", "context", "Landroid/content/Context;", "encryptData", "keyIndex", "desEncrypt", "Lcom/tenpay/sdk/net/core/encrypt/DesEncryptResult;", "plain", "uin", "ecdhDecrypt", "secretKey", "publicKey", "ecdhDecryptBytes", "Lcom/tenpay/sdk/net/core/encrypt/DecryptBytesResult;", "tansInfoOutput", "Lcom/tenpay/sdk/net/gateway/data/TransInfoOutput;", "ecdhEncrypt", "Lcom/tenpay/sdk/net/core/encrypt/EcdhEncryptResult;", "ecdhEncryptBytes", "Lcom/tenpay/sdk/net/core/encrypt/EcdhEncryptBytesResult;", "EncryptType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayEncryptUtils {

    @NotNull
    public static final PayEncryptUtils INSTANCE = new PayEncryptUtils();

    @NotNull
    private static final String KEY_ECDH_EXPIRE_TIME = "qwallet_ecdh_expire_time_";

    @NotNull
    private static final String KEY_ECDH_EXPIRE_TIME_BYTES = "qwallet_ecdh_expire_time_bytes_";

    @NotNull
    private static final String KEY_ECDH_PUBLIC = "qwallet_ecdh_public_";

    @NotNull
    private static final String KEY_ECDH_PUBLIC_BYTES = "qwallet_ecdh_public_bytes_";

    @NotNull
    private static final String KEY_ECDH_SECRET = "qwallet_ecdh_secret_";

    @NotNull
    private static final String KEY_ECDH_SECRET_BYTES = "qwallet_ecdh_secret_bytes_";
    private static final int RET_ECDH_ENCRYT_CHANGE = 3;
    private static final int RET_ECDH_KEYSHARE_SUCC = 1;
    private static final int RET_ECDH_KEY_OVERTIME = 2;
    public static final int RET_FAIL = -1;
    public static final int RET_SUCCEED = 0;

    @NotNull
    private static final String TAG = "QWalletHttp-PayEncryptUtils";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/sdk/net/core/encrypt/PayEncryptUtils$EncryptType;", "", "(Ljava/lang/String;I)V", "TYPE_DES", "TYPE_ECDH_AES", "TYPE_PLAINTEXT", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EncryptType {
        TYPE_DES,
        TYPE_ECDH_AES,
        TYPE_PLAINTEXT
    }

    static {
        QwsslSoLoader.loadSo();
    }

    PayEncryptUtils() {
    }

    private final boolean checkByteArray(byte[] data) {
        boolean z16;
        if (data == null) {
            return false;
        }
        if (data.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(!z16)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0039  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DecryptResult desDecrypt(@NotNull Context context, @NotNull String encryptData, int keyIndex) {
        boolean z16;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(encryptData, "encryptData");
        QLog.i(TAG, 1, "start DES decrypt");
        DesDecUtil desDecUtil = new DesDecUtil(context);
        long currentTimeMillis = System.currentTimeMillis();
        desDecUtil.decryptDes(keyIndex, encryptData);
        String decRes = desDecUtil.getDecRes();
        int i3 = 0;
        if (decRes != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(decRes, "{", false, 2, null);
            if (startsWith$default) {
                z16 = true;
                if (!z16) {
                    return new DecryptResult(EncryptType.TYPE_DES, 0, decRes, System.currentTimeMillis() - currentTimeMillis);
                }
                QLog.i(TAG, 1, "try DES decrypt again");
                long currentTimeMillis2 = System.currentTimeMillis();
                boolean decryptDes = desDecUtil.decryptDes(0, encryptData);
                EncryptType encryptType = EncryptType.TYPE_DES;
                if (!decryptDes) {
                    i3 = -1;
                }
                return new DecryptResult(encryptType, i3, desDecUtil.getDecRes(), System.currentTimeMillis() - currentTimeMillis2);
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    @NotNull
    public final DesEncryptResult desEncrypt(@NotNull Context context, @NotNull String plain, @Nullable String uin, int keyIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(plain, "plain");
        QLog.i(TAG, 1, "start DES encrypt");
        DesEncUtil desEncUtil = new DesEncUtil(context);
        long currentTimeMillis = System.currentTimeMillis();
        desEncUtil.encryptDes(keyIndex, plain);
        return new DesEncryptResult(desEncUtil.getDesEncResult(), QFuncApi.getMsgNo(uin), new EncryptResult.EncryptStatisticInfo("TYPE_DES", -1L, System.currentTimeMillis() - currentTimeMillis));
    }

    @NotNull
    public final synchronized DecryptResult ecdhDecrypt(@NotNull Context context, @NotNull String encryptData, @Nullable String secretKey, @Nullable String publicKey, @Nullable String uin) {
        QWssl.DecInfo qwDecryptBL;
        long currentTimeMillis;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(encryptData, "encryptData");
        QLog.i(TAG, 1, "start ECDH-AES decrypt");
        try {
            QWssl qWssl = new QWssl(context);
            long currentTimeMillis2 = System.currentTimeMillis();
            byte[] base64Decode = qWssl.base64Decode(encryptData);
            if (base64Decode != null) {
                qwDecryptBL = qWssl.qwDecryptBL(base64Decode, base64Decode.length, secretKey);
                Intrinsics.checkNotNullExpressionValue(qwDecryptBL, "qWssl.qwDecryptBL(base64\u2026odedData.size, secretKey)");
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                int i3 = qwDecryptBL.tlsCode;
                if (i3 != -1) {
                    if (i3 != 1) {
                        if (i3 != 2 && i3 != 3) {
                        }
                    } else {
                        if (secretKey != null) {
                            g.q(KEY_ECDH_SECRET + uin, secretKey);
                        }
                        if (publicKey != null) {
                            g.q(KEY_ECDH_PUBLIC + uin, publicKey);
                        }
                        g.n(KEY_ECDH_EXPIRE_TIME + uin, qwDecryptBL.expireTime);
                    }
                }
                g.s(KEY_ECDH_SECRET + uin);
                g.s(KEY_ECDH_PUBLIC + uin);
                g.s(KEY_ECDH_EXPIRE_TIME + uin);
                throw new EcdhException("rsp ecdh fail: " + qwDecryptBL, null, 2, null);
            }
            QLog.w(TAG, 1, "ecdh decrypt fail, base64 decode error, " + encryptData);
            throw new Exception("ecdh decrypt fail: base64 decode error.");
        } catch (Exception e16) {
            throw new EcdhDecryptException("ecdh decrypt occur error.", e16);
        }
        return new DecryptResult(EncryptType.TYPE_ECDH_AES, qwDecryptBL.tlsCode, qwDecryptBL.decText, currentTimeMillis);
    }

    @NotNull
    public final synchronized DecryptBytesResult ecdhDecryptBytes(@NotNull Context context, @Nullable byte[] encryptData, @Nullable byte[] secretKey, @Nullable byte[] publicKey, @Nullable TransInfoOutput tansInfoOutput, @Nullable String uin) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        byte[] aes256EcmDecryptBytes;
        long currentTimeMillis;
        byte[] tag;
        byte[] iv5;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            QWssl qWssl = new QWssl(context);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (tansInfoOutput != null && (iv5 = tansInfoOutput.getIv()) != null) {
                num = Integer.valueOf(iv5.length);
            } else {
                num = null;
            }
            if (secretKey != null) {
                num2 = Integer.valueOf(secretKey.length);
            } else {
                num2 = null;
            }
            if (encryptData != null) {
                num3 = Integer.valueOf(encryptData.length);
            } else {
                num3 = null;
            }
            if (tansInfoOutput != null && (tag = tansInfoOutput.getTag()) != null) {
                num4 = Integer.valueOf(tag.length);
            } else {
                num4 = null;
            }
            QLog.i(TAG, 1, "aes256EcmDecryptBytes: [" + num + "][" + num2 + "][" + num3 + "][" + num4 + "]");
            if (tansInfoOutput != null && checkByteArray(tansInfoOutput.getIv()) && checkByteArray(secretKey) && checkByteArray(encryptData) && checkByteArray(tansInfoOutput.getTag())) {
                aes256EcmDecryptBytes = qWssl.aes256EcmDecryptBytes(tansInfoOutput.getIv(), secretKey, encryptData, tansInfoOutput.getTag());
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                if (aes256EcmDecryptBytes != null) {
                    int tlsCode = tansInfoOutput.getTlsCode();
                    if (tlsCode != 0) {
                        if (tlsCode == 2) {
                            g.s(KEY_ECDH_SECRET_BYTES + uin);
                            g.s(KEY_ECDH_PUBLIC_BYTES + uin);
                            g.s(KEY_ECDH_EXPIRE_TIME_BYTES + uin);
                            throw new EcdhTlsRetryException("rsp tlsCode means retry: " + tansInfoOutput, null, 2, null);
                        }
                    } else {
                        if (secretKey != null) {
                            g.m(KEY_ECDH_SECRET_BYTES + uin, secretKey);
                        }
                        if (publicKey != null) {
                            g.m(KEY_ECDH_PUBLIC_BYTES + uin, publicKey);
                        }
                        g.n(KEY_ECDH_EXPIRE_TIME_BYTES + uin, (int) ((System.currentTimeMillis() / 1000) + tansInfoOutput.getCacheSeconds()));
                    }
                } else {
                    QLog.w(TAG, 1, "ecdh decrypt fail, decryptInfo is null, " + secretKey);
                    throw new Exception("ecdh decrypt fail: decryptInfo is null.");
                }
            } else {
                throw new Exception("ecdh decrypt fail: any data is null.");
            }
        } catch (Exception e16) {
            throw new EcdhDecryptException("ecdh decrypt occur error.", e16);
        }
        return new DecryptBytesResult(EncryptType.TYPE_ECDH_AES, tansInfoOutput.getTlsCode(), aes256EcmDecryptBytes, currentTimeMillis);
    }

    @NotNull
    public final synchronized EcdhEncryptResult ecdhEncrypt(@NotNull Context context, @NotNull String plain, @Nullable String uin) throws EcdhException {
        String i3;
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        long j3;
        String msgNo;
        String substring;
        long currentTimeMillis;
        QWssl.EncInfo aes256EcmEncrypt;
        boolean z19;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(plain, "plain");
        QLog.i(TAG, 1, "start ECDH-AES encrypt");
        String i16 = g.i(KEY_ECDH_SECRET + uin);
        i3 = g.i(KEY_ECDH_PUBLIC + uin);
        z16 = false;
        if (g.f(KEY_ECDH_EXPIRE_TIME + uin, 0, 2, null) - (System.currentTimeMillis() / 1000) <= 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        try {
            QWssl qWssl = new QWssl(context);
            if (i16.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if (i3.length() == 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19 && !z17) {
                    j3 = -1;
                    z16 = true;
                    str = i16;
                    msgNo = QFuncApi.getMsgNo(uin);
                    Intrinsics.checkNotNullExpressionValue(msgNo, "msgNo");
                    substring = msgNo.substring(msgNo.length() - 16);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    currentTimeMillis = System.currentTimeMillis();
                    aes256EcmEncrypt = qWssl.aes256EcmEncrypt(substring, str, plain);
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            QWssl.KeyInfo ecdh = qWssl.ecdh();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
            str = ecdh.calcSecret;
            Intrinsics.checkNotNullExpressionValue(str, "keyInfo.calcSecret");
            String str2 = ecdh.pubKey;
            Intrinsics.checkNotNullExpressionValue(str2, "keyInfo.pubKey");
            j3 = currentTimeMillis3;
            i3 = str2;
            msgNo = QFuncApi.getMsgNo(uin);
            Intrinsics.checkNotNullExpressionValue(msgNo, "msgNo");
            substring = msgNo.substring(msgNo.length() - 16);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            currentTimeMillis = System.currentTimeMillis();
            aes256EcmEncrypt = qWssl.aes256EcmEncrypt(substring, str, plain);
        } catch (Exception e16) {
            throw new EcdhEncryptException("ecdhEncrypt occur error.", e16);
        }
        return new EcdhEncryptResult(aes256EcmEncrypt.encText, aes256EcmEncrypt.tagText, i3, str, msgNo, substring, 1, uin, z16, new EncryptResult.EncryptStatisticInfo("TYPE_ECDH_AES", j3, System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f4 A[Catch: Exception -> 0x019e, all -> 0x01a8, TryCatch #0 {Exception -> 0x019e, blocks: (B:9:0x0077, B:11:0x0082, B:16:0x00b0, B:20:0x00e2, B:22:0x00e8, B:27:0x00f4, B:29:0x00fd, B:31:0x0101, B:33:0x010a, B:35:0x010e, B:36:0x0113, B:38:0x0139, B:42:0x0156, B:43:0x0167, B:46:0x0168, B:48:0x016d, B:49:0x0174, B:50:0x019d, B:53:0x0093, B:55:0x00a2, B:57:0x00a8), top: B:8:0x0077, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016d A[Catch: Exception -> 0x019e, all -> 0x01a8, TryCatch #0 {Exception -> 0x019e, blocks: (B:9:0x0077, B:11:0x0082, B:16:0x00b0, B:20:0x00e2, B:22:0x00e8, B:27:0x00f4, B:29:0x00fd, B:31:0x0101, B:33:0x010a, B:35:0x010e, B:36:0x0113, B:38:0x0139, B:42:0x0156, B:43:0x0167, B:46:0x0168, B:48:0x016d, B:49:0x0174, B:50:0x019d, B:53:0x0093, B:55:0x00a2, B:57:0x00a8), top: B:8:0x0077, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized EcdhEncryptBytesResult ecdhEncryptBytes(@NotNull Context context, @NotNull byte[] plain, @Nullable String uin) throws EcdhException {
        boolean z16;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        long j3;
        boolean z17;
        String msgNo;
        byte[] bytes;
        boolean z18;
        Integer num;
        boolean z19;
        QWssl.EncInfo aes256EcmEncryptBytes;
        Integer num2;
        long currentTimeMillis;
        byte[] bArr4;
        byte[] bArr5;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(plain, "plain");
        QLog.i(TAG, 1, "start ECDH-AES encrypt");
        byte[] d16 = g.d(KEY_ECDH_SECRET_BYTES + uin);
        byte[] d17 = g.d(KEY_ECDH_PUBLIC_BYTES + uin);
        Integer num3 = null;
        if (g.f(KEY_ECDH_EXPIRE_TIME_BYTES + uin, 0, 2, null) - (System.currentTimeMillis() / 1000) < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            QWssl qWssl = new QWssl(context);
            if (checkByteArray(d16) && checkByteArray(d17) && !z16) {
                bArr3 = d16;
                bArr2 = d17;
                j3 = -1;
                z17 = true;
                msgNo = QFuncApi.getMsgNo(uin);
                Intrinsics.checkNotNullExpressionValue(msgNo, "msgNo");
                String substring = msgNo.substring(msgNo.length() - 16);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                bytes = substring.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                long currentTimeMillis2 = System.currentTimeMillis();
                if (bytes.length != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18 && checkByteArray(bArr3)) {
                    if (plain.length != 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        aes256EcmEncryptBytes = qWssl.aes256EcmEncryptBytes(bytes, bArr3, plain);
                        if (aes256EcmEncryptBytes != null && (bArr5 = aes256EcmEncryptBytes.encBytes) != null) {
                            num2 = Integer.valueOf(bArr5.length);
                        } else {
                            num2 = null;
                        }
                        if (aes256EcmEncryptBytes != null && (bArr4 = aes256EcmEncryptBytes.tagBytes) != null) {
                            num3 = Integer.valueOf(bArr4.length);
                        }
                        QLog.i(TAG, 1, "ECDH-AES encrypt result: " + num2 + " " + num3);
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                        if (aes256EcmEncryptBytes != null) {
                        } else {
                            QLog.w(TAG, 1, "ecdh encrypt fail, encryptInfo is null");
                            throw new Exception("ecdh encrypt fail: encryptInfo is null.");
                        }
                    }
                }
                int length = bytes.length;
                if (bArr3 == null) {
                    num = Integer.valueOf(bArr3.length);
                } else {
                    num = null;
                }
                throw new EcdhEncryptException("ecdhEncrypt encrypt error: " + length + " " + num + " " + plain.length, null, 2, null);
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            QWssl.KeyInfo ecdhBytes = qWssl.ecdhBytes();
            long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
            if (ecdhBytes != null) {
                bArr = ecdhBytes.calcSecretBytes;
            } else {
                bArr = null;
            }
            if (ecdhBytes != null) {
                bArr2 = ecdhBytes.pubKeyBytes;
            } else {
                bArr2 = null;
            }
            bArr3 = bArr;
            j3 = currentTimeMillis4;
            z17 = false;
            msgNo = QFuncApi.getMsgNo(uin);
            Intrinsics.checkNotNullExpressionValue(msgNo, "msgNo");
            String substring2 = msgNo.substring(msgNo.length() - 16);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            bytes = substring2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            long currentTimeMillis22 = System.currentTimeMillis();
            if (bytes.length != 0) {
            }
            if (!z18) {
                if (plain.length != 0) {
                }
                if (z19) {
                }
            }
            int length2 = bytes.length;
            if (bArr3 == null) {
            }
            throw new EcdhEncryptException("ecdhEncrypt encrypt error: " + length2 + " " + num + " " + plain.length, null, 2, null);
        } catch (Exception e16) {
            throw new EcdhEncryptException("ecdhEncrypt occur error.", e16);
        }
        return new EcdhEncryptBytesResult(aes256EcmEncryptBytes.encBytes, aes256EcmEncryptBytes.tagBytes, bArr2, bArr3, msgNo, bytes, 1, uin, z17, new EncryptResult.EncryptStatisticInfo("TYPE_ECDH_AES", j3, currentTimeMillis));
    }
}
