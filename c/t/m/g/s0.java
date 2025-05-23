package c.t.m.g;

import android.util.Base64;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import cooperation.qzone.QZoneHelper;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Deprecated
/* loaded from: classes.dex */
public class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f29978a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f29979b;

    static {
        a();
    }

    public static Cipher a(String str, int i3) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i3, secretKeySpec, new IvParameterSpec(f29978a));
        return cipher;
    }

    public static String b(String str, String str2) {
        return a(str, str2, 1);
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
                    byte[] a16 = a(decode, 0, decode.length, str2, i3);
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

    public static byte[] a(byte[] bArr, int i3, int i16, String str, int i17) {
        if (i17 != 1 && i17 != 2) {
            throw new IllegalArgumentException("wrong mode.");
        }
        if (bArr != null && bArr.length != 0 && i3 >= 0 && i16 != 0) {
            try {
                Cipher a16 = a(str, i17);
                if (a16 == null) {
                    return k0.f29815a;
                }
                return a16.doFinal(bArr, i3, i16);
            } catch (Throwable unused) {
                return k0.f29815a;
            }
        }
        return k0.f29815a;
    }

    public static String a(String str, String str2) {
        return a(str, str2, 2);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, 0, bArr.length, str);
    }

    public static byte[] a(byte[] bArr, int i3, int i16, String str) {
        return a(bArr, i3, i16, str, 1);
    }

    public static final synchronized void a() {
        synchronized (s0.class) {
            try {
                f29979b = new HashMap<>();
                for (String str : new String(r0.a(new byte[]{8, RegisterType.UNINIT_REF, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, Constants.SEND_CHANNEL_LATENCY, -113, -11, 70, -62, -45, -36, 8, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -121, 51, 54, -122, 72, 12, -109, -53, 78, 13, -80, -118, -43, -111, 85, -110, 87, 62, 10, 92, -46, 53, -86, -78, 75, -122, Constants.SDK_SEND_CHANNEL_DATA_TYPE, -53, 30, 123, -122, -114, 65, 78, 27, -15, 63, -58, -22, 26, -19, -87, -65, -34, -76, 3, -26, -75, 53, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, -22, -113, 102, 43, -52, 74, 39, -117, 39, -63, -116, 4, -99, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, 1, 53, -127, -75, 74, 12, -88, 77, -37, 53, 1, 89, 73, -95, -103, -33, -91, 1, -22, 66, 105, 3, 12, PublicAccountH5AbilityPluginImpl.OPENIMG, -83, 85, -57, -89, -43, -94, 99, -117, 2, -81, 67, -2, PublicAccountH5AbilityPluginImpl.OPENIMG, Byte.MIN_VALUE, -124, 79, -111, 86, -83, -106, 92, -87, 17, -85, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -15, -116, -68, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, 1, 6, 92, 40, -12, -22, 60, 31, -73, -6, 31, -28, -8, -14, -125, -63, -33, -85, -12, 7, 23, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, -110, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, -103, RegisterType.DOUBLE_HI, -101, MaskType.MASK_TYPE_EXTERNAL, 67, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 3, -85, 73, 102, 59, -61, -16, PublicAccountH5AbilityPluginImpl.OPENCAMERA, 53, 123, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, -19, -61, 63, -102, 101, -40, -118, 49, -127, RegisterType.DOUBLE_LO, -109, -30, -123, 41, -117, -14, 59, 10, -56, 78, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, -77, 55, -84, -40, -34, -69, -94, 52, 53, 94, -49, 48, -10, 82, RegisterType.REFERENCE, -7, 56, -126, -70, -94, 59, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 25, 0, -11, -26, 7, -126, 72, -93, -66, -6, 62, 124, 74, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, RegisterType.REFERENCE, 61, -57, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 67, 95, 25, -53, -25, 65, Byte.MAX_VALUE, -5, -74, 30, -99, -1, 87, -104, 54, -61, 37, 107, 12, 106, 67, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 17, -100, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, -35, -43, -62, -11, -52, -116, -97, -44, -125, 28, -67, 67, 72, -45, -84, -82, 102, -118, 80, -9, -87, 6, 30, -100, 36, -122, 6, 71, -91, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, Constants.VIRTUAL_GAMEPAD_SDK_DATA, -53, -79, -82, 76, Constants.SEND_CHANNEL_LATENCY, -101, 84, -4, 87, -15, -48, -38, -81, 10, 42, -11, 17, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -39, -119, 90, -51, 67, -87, 55, -69, 48, -92, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, -56, 4, 95, -106, -3, 23, -9, 81, -69, -58, -57, 26, -87, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 62, -87, 69, -8, -58, -77, -57, 8, -89, RegisterType.DOUBLE_HI, 77, MaskType.MASK_TYPE_EXTERNAL, -15, -110, 80, -13, 70, Constants.VIRTUAL_GAMEPAD_SDK_DATA, -41, 73, -2, -66, 43, 107, 103, 44, -81, -17, -41, -48, -91, 60, 25, -76, -109}), "UTF-8").split(";")) {
                    String[] split = str.split(",");
                    if (split.length == 2) {
                        f29979b.put(split[0], split[1]);
                    }
                }
                f29978a = f29979b.get("enc_iv").getBytes("UTF-8");
            } catch (Throwable th5) {
                c1.a("EncAesCbcUtil", "init error.", th5);
            }
        }
    }

    public static final synchronized String a(String str) {
        String str2;
        synchronized (s0.class) {
            str2 = f29979b.get(str);
            if (h1.a(str2)) {
                str2 = "";
            }
        }
        return str2;
    }
}
