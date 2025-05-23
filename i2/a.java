package i2;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import cooperation.qzone.QZoneHelper;
import java.util.Locale;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f407086a = {-115, -65, 76, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, 59, -33, 65, -114, -25, -81, 33, 17, -71, -83, -80, -30, -120, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, -47, -35, -81, 3, 28, 33, Byte.MAX_VALUE, 93, 0, 58, 90, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 81, -86, 100, -60, -6, -65, 48, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -73, 100, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -33, 48, 0, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, -96, 70, -126, -44, 105, -14, 9, RegisterType.DOUBLE_HI, 38, -93, 72, 87, -91, -68, 1, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 87, -76, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, 99, 65, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, -108, Constants.SEND_CHANNEL_LATENCY, 88, -46, -28, 4, 57, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, -2, -46, 44, 48, -5, 107, RegisterType.DOUBLE_LO, 99, 5, 62, 27, -41, 47, 50, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, 90, -6, 33, 35, 85, 56, 57, 53, 73, 42, -37, 56, -41, Byte.MAX_VALUE, 24, -21, -72, 38, -31, 36, -21, -113, -32, 97, -55, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, -74, 93, 124, 81, 99, RegisterType.DOUBLE_HI, 31, Constants.PACKET_LOSS_EFFECT_STATIS, -106, 62, -7, 75, -48, 85, 12, 11, 52, -53, RegisterType.DOUBLE_LO, -62, RegisterType.REFERENCE, 37, -17, 51, 32, -5, 87, -60, -19, -78, -15, -3, -56, 89, -74, -10, 126, 8, 79, 72, -53, 40, -11};

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = upperCase.charAt(i3);
            if (('0' > charAt || charAt > '9') && ('A' > charAt || charAt > 'F')) {
                return new byte[0];
            }
        }
        int i16 = length / 2;
        byte[] bArr = new byte[i16];
        byte[] bArr2 = new byte[2];
        int i17 = 0;
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = i17 + 1;
            bArr2[0] = (byte) upperCase.charAt(i17);
            i17 = i19 + 1;
            bArr2[1] = (byte) upperCase.charAt(i19);
            for (int i26 = 0; i26 < 2; i26++) {
                byte b16 = bArr2[i26];
                if (65 <= b16 && b16 <= 70) {
                    bArr2[i26] = (byte) (b16 - 55);
                } else {
                    bArr2[i26] = (byte) (b16 - 48);
                }
            }
            bArr[i18] = (byte) ((bArr2[0] << 4) | bArr2[1]);
        }
        return bArr;
    }

    public static String b(byte[] bArr) {
        return c(bArr, 0);
    }

    public static String c(byte[] bArr, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return null;
        }
        if (i3 <= 0 || i3 > bArr.length) {
            i3 = bArr.length;
        }
        for (int i16 = 0; i16 < i3; i16++) {
            String hexString = Integer.toHexString(bArr[i16] & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString.toUpperCase(Locale.ENGLISH));
        }
        return stringBuffer.toString();
    }
}
