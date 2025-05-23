package i2;

import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.qqlive.tvkplayer.tools.httpdns.TVKHttpDnsCryptoUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyStore;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {
    public static String a(String str, String str2) {
        byte[] a16 = a.a(str2);
        if (a16.length <= 16) {
            q.q.q.e.w.e.b("KeyStoreEncryptAndDecrypt", "Decrypt source data is invalid.", true);
            return "";
        }
        byte[] bArr = new byte[0];
        try {
            SecretKey b16 = b(str);
            byte[] copyOf = Arrays.copyOf(a16, 16);
            Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
            cipher.init(2, b16, new IvParameterSpec(copyOf));
            bArr = cipher.doFinal(a16, 16, a16.length - 16);
        } catch (RuntimeException unused) {
            q.q.q.e.w.e.c("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            q.q.q.e.w.e.b("KeyStoreEncryptAndDecrypt", "Decrypt exception", true);
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused3) {
            q.q.q.e.w.e.c("KeyStoreEncryptAndDecrypt", "unreachable UnsupportedEncodingException", true);
            return "";
        }
    }

    @TargetApi(23)
    private static SecretKey b(String str) {
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(SignUtils.KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                secretKey = (SecretKey) key;
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyPropertiesCompact.KEY_ALGORITHM_AES, SignUtils.KEYSTORE_PROVIDER_ANDROID_KEYSTORE);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(KeyPropertiesCompact.BLOCK_MODE_CBC).setEncryptionPaddings(KeyPropertiesCompact.ENCRYPTION_PADDING_PKCS7).setKeySize(256).build());
                secretKey = keyGenerator.generateKey();
            }
        } catch (RuntimeException unused) {
            q.q.q.e.w.e.c("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            q.q.q.e.w.e.b("KeyStoreEncryptAndDecrypt", "Generate key exception ", true);
        }
        return secretKey;
    }

    public static String c(String str, String str2) {
        byte[] doFinal;
        byte[] iv5;
        byte[] bArr = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance(TVKHttpDnsCryptoUtils.ENCRYPTION_TYPE_AES);
            cipher.init(1, b(str));
            doFinal = cipher.doFinal(str2.getBytes("UTF-8"));
            iv5 = cipher.getIV();
        } catch (RuntimeException unused) {
            q.q.q.e.w.e.c("KeyStoreEncryptAndDecrypt", "RuntimeException", true);
        } catch (Exception unused2) {
            q.q.q.e.w.e.b("KeyStoreEncryptAndDecrypt", "Encrypt exception", true);
        }
        if (iv5 != null && iv5.length == 16) {
            bArr = Arrays.copyOf(iv5, iv5.length + doFinal.length);
            System.arraycopy(doFinal, 0, bArr, iv5.length, doFinal.length);
            return a.b(bArr);
        }
        q.q.q.e.w.e.b("KeyStoreEncryptAndDecrypt", "IV is invalid.", true);
        return "";
    }
}
