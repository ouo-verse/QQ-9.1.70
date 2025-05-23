package com.tencent.ad.tangram.util;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdCryptoUtil {
    private static final String TAG = "AdCryptoUtil";

    @Nullable
    private static volatile Cipher decryptCipher;

    @Nullable
    private static volatile Cipher encryptCipher;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Params {
        public String cipherAlgorithm;
        public byte[] key;
        public String keyAlgorithm;

        public boolean isValid() {
            if (this.keyAlgorithm != null && this.cipherAlgorithm != null && this.key != null) {
                return true;
            }
            return false;
        }
    }

    @Nullable
    public static byte[] decrypt(@Nullable Params params, byte[] bArr) {
        try {
            return getDecryptCipher(params).doFinal(bArr);
        } catch (Throwable th5) {
            AdLog.e(TAG, "decrypt failed", th5);
            return null;
        }
    }

    @Nullable
    public static byte[] encrypt(@Nullable Params params, byte[] bArr) {
        try {
            return getEncryptCipher(params).doFinal(bArr);
        } catch (Throwable th5) {
            AdLog.e(TAG, "encrypt failed", th5);
            return null;
        }
    }

    @Nullable
    private static Cipher getDecryptCipher(@Nullable Params params) {
        if (decryptCipher != null) {
            return decryptCipher;
        }
        synchronized (AdCryptoUtil.class) {
            if (decryptCipher != null) {
                return decryptCipher;
            }
            if (params != null && params.isValid()) {
                try {
                    Cipher cipher = Cipher.getInstance(params.cipherAlgorithm);
                    cipher.init(2, new SecretKeySpec(params.key, params.keyAlgorithm));
                    decryptCipher = cipher;
                } catch (Throwable th5) {
                    AdLog.e(TAG, "fail to init cipher", th5);
                }
                return decryptCipher;
            }
            AdLog.e(TAG, "getDecryptCipher error");
            return null;
        }
    }

    @SuppressLint({"TrulyRandom"})
    @Nullable
    private static Cipher getEncryptCipher(@Nullable Params params) {
        if (encryptCipher != null) {
            return encryptCipher;
        }
        synchronized (AdCryptoUtil.class) {
            if (encryptCipher != null) {
                return encryptCipher;
            }
            if (params != null && params.isValid()) {
                try {
                    Cipher cipher = Cipher.getInstance(params.cipherAlgorithm);
                    cipher.init(1, new SecretKeySpec(params.key, params.keyAlgorithm));
                    encryptCipher = cipher;
                } catch (Throwable th5) {
                    AdLog.e(TAG, "fail to init cipher", th5);
                }
                return encryptCipher;
            }
            AdLog.e(TAG, "getEncryptCipher error");
            return null;
        }
    }
}
