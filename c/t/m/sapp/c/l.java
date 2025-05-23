package c.t.m.sapp.c;

import android.util.Base64;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f30177a = {84, 101, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 99, 101, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 76, PublicAccountH5AbilityPluginImpl.OPENIMG, 99, 97, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 105, PublicAccountH5AbilityPluginImpl.OPENIMG, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, 49};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f30178b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f30179c = new byte[0];

    public static String a(String str) {
        try {
            return new String(a(Base64.decode(str.getBytes(), 2)), "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str, String str2) {
        return a(str, str2, 1);
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] a(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return a(bArr, i3 + 16, i16 - 16, bArr2, bArr2, 2);
    }

    public static byte[] a(byte[] bArr, int i3, int i16, byte[] bArr2, byte[] bArr3, int i17) {
        if (i17 != 1 && i17 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0 && i3 >= 0 && i16 > 0) {
            try {
                Cipher a16 = a(bArr2, bArr3, i17);
                return a16 == null ? f30179c : a16.doFinal(bArr, i3, i16);
            } catch (Throwable unused) {
                return f30179c;
            }
        }
        return f30179c;
    }

    public static Cipher a(byte[] bArr, byte[] bArr2, int i3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i3, secretKeySpec, new IvParameterSpec(bArr2));
        return cipher;
    }

    public static Cipher a(String str, int i3) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i3, secretKeySpec, new IvParameterSpec(f30177a));
        return cipher;
    }

    public static String a(String str, String str2, int i3) {
        byte[] decode;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (str != null && str.length() != 0) {
            try {
                if (i3 == 1) {
                    decode = str.getBytes();
                } else {
                    decode = i3 == 2 ? Base64.decode(str.getBytes(), 2) : null;
                }
                if (decode != null && decode.length != 0) {
                    byte[] a16 = a(decode, str2, i3);
                    if (i3 == 1) {
                        return Base64.encodeToString(a16, 2);
                    }
                    if (i3 == 2) {
                        return new String(a16);
                    }
                    return null;
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static byte[] a(byte[] bArr, String str, int i3) {
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0) {
            try {
                Cipher a16 = a(str, i3);
                if (a16 == null) {
                    return f30178b;
                }
                return a16.doFinal(bArr);
            } catch (Throwable unused) {
                return f30178b;
            }
        }
        return f30178b;
    }

    public static String a(String str, String str2) {
        return a(str, str2, 2);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, str, 2);
    }
}
