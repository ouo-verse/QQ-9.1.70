package com.qq.e.comm.util;

import android.util.Base64;
import java.io.File;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GDTST {
    private static final String PUBKEYSTR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDKta2b5Vw5YkWHCAj4rJCwS227\r/35FZ29e4I6pS2B8zSq2RgBpXUuMg7oZF1Qt3x0iyg8PeyblyNeCRB6gIMehFThe\r1Y7m1FaQyaZp+CJYOTLM4/THKp9UndrEgJ/5a83vP1375YCV2lMvWARrNlBep4RN\rnESUJhQz58Gr/F39TwIDAQAB";
    private final boolean initOK;
    private PublicKey pubKey;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class Holder {
        public static final GDTST INSTANCE = new GDTST();

        Holder() {
        }
    }

    GDTST() {
        boolean z16;
        try {
            this.pubKey = initPubKey(PUBKEYSTR);
            z16 = true;
        } catch (Throwable unused) {
            z16 = false;
        }
        this.initOK = z16;
    }

    private String decode(String str) {
        if (this.pubKey != null) {
            byte[] decode = Base64.decode(str, 0);
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.pubKey);
                return new String(cipher.doFinal(decode), "UTF-8").trim();
            } catch (Throwable th5) {
                GDTLogger.e("ErrorWhileVerifySigNature", th5);
                return null;
            }
        }
        return null;
    }

    public static GDTST getToolInstance() {
        return Holder.INSTANCE;
    }

    private PublicKey initPubKey(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NullPointerException unused) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException e16) {
            GDTLogger.e(e16.getMessage());
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        }
    }

    public boolean verify(String str, String str2) {
        if (StringUtil.isEmpty(str2)) {
            return false;
        }
        if (!this.initOK) {
            return true;
        }
        String decode = decode(str);
        boolean equals = str2.equals(decode);
        GDTLogger.d("Verify Result" + equals + "src=" + str2 + " & target=" + decode);
        return equals;
    }

    public boolean verifyFile(String str, File file) {
        if (file != null && file.exists()) {
            return verify(str, Md5Util.encode(file));
        }
        return false;
    }

    public boolean verifyString(String str, String str2) {
        return verify(str, Md5Util.encode(str2));
    }
}
