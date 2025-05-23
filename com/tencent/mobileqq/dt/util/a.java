package com.tencent.mobileqq.dt.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        byte[] bArr;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] E = Utils.E(str);
            if (E != null && E.length > 0) {
                bArr = b(E, d(), 2);
            } else {
                bArr = null;
            }
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            String str3 = new String(bArr, "UTF-8");
            try {
                int indexOf = str3.indexOf(0);
                if (indexOf >= 0) {
                    return str3.substring(0, indexOf);
                }
                return str3;
            } catch (UnsupportedEncodingException e16) {
                e = e16;
                str2 = str3;
                e.printStackTrace();
                return str2;
            } catch (Throwable th5) {
                th = th5;
                str2 = str3;
                th.printStackTrace();
                return str2;
            }
        } catch (UnsupportedEncodingException e17) {
            e = e17;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static byte[] b(byte[] bArr, String str, int i3) {
        if (bArr != null && bArr.length != 0) {
            try {
                int length = bArr.length;
                if (length % 16 != 0) {
                    length += 16 - (length % 16);
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
                cipher.init(i3, new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES));
                return cipher.doFinal(bArr2);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("FEKitMainReportUtil", 1, "encryOrDecryStr error: " + e16.getMessage());
            }
        }
        return null;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Utils.e(b(str.getBytes("utf-8"), d(), 1));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return null;
    }

    private static String d() {
        return "6bW#X@~L.+X)4%$>";
    }
}
