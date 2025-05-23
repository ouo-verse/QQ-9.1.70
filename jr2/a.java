package jr2;

import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static String a(String str, String str2, String str3) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(1, new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES), new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str3.getBytes()), 0);
        } catch (Throwable unused) {
            QLog.e("AesGcmHelper", 1, "encrypt failed, data:" + str3);
            return null;
        }
    }
}
