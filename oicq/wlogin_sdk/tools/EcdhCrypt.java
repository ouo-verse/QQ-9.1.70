package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;
import oicq.wlogin_sdk.request.u;

/* compiled from: P */
/* loaded from: classes28.dex */
public class EcdhCrypt {
    private static final String BC = "BC";
    public static final String DEFAULT_PUB_KEY = "04edb8906046f5bfbe9abbc5a88b37d70a6006bfbabc1f0cd49dfb33505e63efc5d78ee4e0a4595033b93d02096dcd3190279211f7b4f6785079e19004aa0e03bc";
    public static final String DEFAULT_SHARE_KEY = "c129edba736f4909ecc4ab8e010f46a3";
    private static final String EC = "EC";
    private static final String ECDH = "ECDH";
    public static String SvrPubKey = "04EBCA94D733E399B2DB96EACDD3F69A8BB0F74224E2B44E3357812211D2E62EFBC91BB553098E25E33A799ADC7F76FEB208DA7C6522CDB0719A305180CC54A82E";
    public static final String X509Prefix = "3059301306072a8648ce3d020106082a8648ce3d030107034200";
    private static boolean initFlg = false;
    public static PrivateKey pkcs8PrivateKey = null;
    private static int sKeyVersion = 1;
    private static boolean userOpenSSLLib = true;
    public static PublicKey x509PublicKey;
    public static byte[] _c_pub_key = new byte[0];
    public static byte[] _c_pri_key = new byte[0];
    private static byte[] _g_share_key = new byte[0];

    public EcdhCrypt(Context context) {
        util.loadLibrary("wtecdh", context);
    }

    private byte[] calShareKeyByBouncycastle(byte[] bArr) {
        KeyAgreement keyAgreement;
        try {
            PublicKey constructX509PublicKey = constructX509PublicKey(X509Prefix + util.buf_to_string(bArr));
            if (Build.VERSION.SDK_INT >= 28) {
                keyAgreement = KeyAgreement.getInstance(ECDH);
            } else {
                keyAgreement = KeyAgreement.getInstance(ECDH, BC);
            }
            keyAgreement.init(pkcs8PrivateKey);
            keyAgreement.doPhase(constructX509PublicKey, true);
            byte[] bArr2 = new byte[16];
            System.arraycopy(keyAgreement.generateSecret(), 0, bArr2, 0, 16);
            return MD5.toMD5Byte(bArr2);
        } catch (ExceptionInInitializerError e16) {
            util.LOGW("create key failed ExceptionInInitializerError, " + e16.getMessage(), "");
            u.f422936m0.attr_api(2459818);
            return null;
        } catch (Throwable th5) {
            util.LOGI("calShareKeyByBouncycastle failed " + pkcs8PrivateKey.toString() + " peer public key " + util.buf_to_string(bArr), "");
            util.printThrowable(th5, "calShareKeyByBouncycastle");
            u.f422936m0.attr_api(2459818);
            return null;
        }
    }

    private byte[] calShareKeyByOpenSSL(String str, String str2, String str3) {
        util.LOGI("calShareKeyByOpenSSL publickey " + str2, "");
        if (GenECDHKeyEx(str3, str2, str) == 0) {
            return _g_share_key;
        }
        u.f422936m0.attr_api(2461268);
        return null;
    }

    private PublicKey constructX509PublicKey(String str) {
        KeyFactory keyFactory;
        util.LOGI("constructX509PublicKey publickey " + str + " at " + u.f(), "");
        if (Build.VERSION.SDK_INT >= 28) {
            keyFactory = KeyFactory.getInstance("EC");
        } else {
            keyFactory = KeyFactory.getInstance("EC", BC);
        }
        return keyFactory.generatePublic(new X509EncodedKeySpec(util.string_to_buf(str)));
    }

    private int initShareKeyByBouncycastle() {
        KeyPairGenerator keyPairGenerator;
        KeyAgreement keyAgreement;
        try {
            String str = X509Prefix + util.buf_to_string(util.string_to_buf(SvrPubKey));
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                keyPairGenerator = KeyPairGenerator.getInstance("EC");
            } else {
                keyPairGenerator = KeyPairGenerator.getInstance("EC", BC);
            }
            keyPairGenerator.initialize(new ECGenParameterSpec("prime256v1"));
            KeyPair genKeyPair = keyPairGenerator.genKeyPair();
            PublicKey publicKey = genKeyPair.getPublic();
            byte[] encoded = publicKey.getEncoded();
            PrivateKey privateKey = genKeyPair.getPrivate();
            privateKey.getEncoded();
            PublicKey constructX509PublicKey = constructX509PublicKey(str);
            if (i3 >= 28) {
                keyAgreement = KeyAgreement.getInstance(ECDH);
            } else {
                keyAgreement = KeyAgreement.getInstance(ECDH, BC);
            }
            keyAgreement.init(privateKey);
            keyAgreement.doPhase(constructX509PublicKey, true);
            byte[] bArr = new byte[16];
            System.arraycopy(keyAgreement.generateSecret(), 0, bArr, 0, 16);
            _g_share_key = MD5.toMD5Byte(bArr);
            byte[] bArr2 = new byte[65];
            _c_pub_key = bArr2;
            System.arraycopy(encoded, 26, bArr2, 0, 65);
            x509PublicKey = publicKey;
            pkcs8PrivateKey = privateKey;
            util.LOGI("initShareKeyByBouncycastle OK", "");
            return 0;
        } catch (ExceptionInInitializerError e16) {
            util.LOGW("create key pair and shared key failed ExceptionInInitializerError, " + e16.getMessage(), "");
            u.f422936m0.attr_api(2368735);
            return -1;
        } catch (Throwable th5) {
            util.LOGI("initShareKeyByBouncycastle failed, ", "");
            util.printThrowable(th5, "initShareKeyByBouncycastle");
            u.f422936m0.attr_api(2368735);
            return -2;
        }
    }

    private int initShareKeyByOpenSSL() {
        return -1;
    }

    public native int GenECDHKeyEx(String str, String str2, String str3);

    public int GenereateKey() {
        int GenECDHKeyEx;
        try {
            synchronized (EcdhCrypt.class) {
                GenECDHKeyEx = GenECDHKeyEx(SvrPubKey, "", "");
            }
            return GenECDHKeyEx;
        } catch (RuntimeException e16) {
            util.LOGW("OpenSSL generate key failed, turn another method " + e16.getMessage(), "");
            return -2;
        } catch (UnsatisfiedLinkError e17) {
            util.LOGI("GenereateKey failed " + e17.getMessage(), "");
            return -1;
        } catch (Error e18) {
            util.LOGI("GenereateKey failed " + e18.getMessage(), "");
            return -4;
        } catch (Exception e19) {
            util.LOGI("GenereateKey failed " + e19.getMessage(), "");
            return -3;
        }
    }

    public byte[] calShareKeyMd5ByPeerPublicKey(byte[] bArr) {
        util.LOGI("userOpenSSLLib " + userOpenSSLLib + " peerRawPublicKey " + util.buf_to_string(bArr) + " at " + u.f(), "");
        if (true == userOpenSSLLib) {
            return calShareKeyByOpenSSL(util.buf_to_string(_c_pri_key), util.buf_to_string(_c_pub_key), util.buf_to_string(bArr));
        }
        return calShareKeyByBouncycastle(bArr);
    }

    public byte[] get_c_pub_key() {
        return (byte[]) _c_pub_key.clone();
    }

    public byte[] get_g_share_key() {
        return (byte[]) _g_share_key.clone();
    }

    public int get_pub_key_ver() {
        return sKeyVersion;
    }

    public int initShareKey() {
        if (true == initFlg) {
            return 0;
        }
        initFlg = true;
        if (initShareKeyByOpenSSL() == 0) {
            userOpenSSLLib = true;
            return 0;
        }
        if (initShareKeyByBouncycastle() == 0) {
            userOpenSSLLib = false;
            return 0;
        }
        return initShareKeyByDefault();
    }

    public int initShareKeyByDefault() {
        _c_pub_key = util.string_to_buf(DEFAULT_PUB_KEY);
        _g_share_key = util.string_to_buf(DEFAULT_SHARE_KEY);
        util.LOGI("initShareKeyByDefault OK", "");
        return 0;
    }

    public void setPubKey(String str, int i3) {
        try {
            util.LOGI("setPubKey " + str + " ver:" + i3, "");
            if (!TextUtils.isEmpty(str) && i3 > 0) {
                SvrPubKey = str;
                sKeyVersion = i3;
            }
        } catch (Throwable th5) {
            util.printThrowable(th5, "setPubKey");
        }
    }

    public void set_c_pri_key(byte[] bArr) {
        if (bArr != null) {
            _c_pri_key = (byte[]) bArr.clone();
        } else {
            _c_pri_key = new byte[0];
        }
    }

    public void set_c_pub_key(byte[] bArr) {
        if (bArr != null) {
            _c_pub_key = (byte[]) bArr.clone();
        } else {
            _c_pub_key = new byte[0];
        }
    }

    public void set_g_share_key(byte[] bArr) {
        if (bArr != null) {
            _g_share_key = (byte[]) bArr.clone();
        } else {
            _g_share_key = new byte[0];
        }
    }
}
