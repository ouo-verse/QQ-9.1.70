package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.text.EmotcationConstants;
import cooperation.qzone.QZoneHelper;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Base64Utils {
    private static char[] base64EncodeChars = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static byte[] decode(String str) {
        try {
            return decodePrivate(str);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] decodePrivate(String str) throws UnsupportedEncodingException {
        int i3;
        byte b16;
        int i16;
        byte b17;
        int i17;
        byte b18;
        int i18;
        byte b19;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i19 = 0;
        while (i19 < length) {
            while (true) {
                i3 = i19 + 1;
                b16 = base64DecodeChars[bytes[i19]];
                if (i3 >= length || b16 != -1) {
                    break;
                }
                i19 = i3;
            }
            if (b16 == -1) {
                break;
            }
            while (true) {
                i16 = i3 + 1;
                b17 = base64DecodeChars[bytes[i3]];
                if (i16 >= length || b17 != -1) {
                    break;
                }
                i3 = i16;
            }
            if (b17 == -1) {
                break;
            }
            stringBuffer.append((char) ((b16 << 2) | ((b17 & 48) >>> 4)));
            while (true) {
                i17 = i16 + 1;
                byte b26 = bytes[i16];
                if (b26 == 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                b18 = base64DecodeChars[b26];
                if (i17 >= length || b18 != -1) {
                    break;
                }
                i16 = i17;
            }
            if (b18 == -1) {
                break;
            }
            stringBuffer.append((char) (((b17 & RegisterType.DOUBLE_HI) << 4) | ((b18 & 60) >>> 2)));
            while (true) {
                i18 = i17 + 1;
                byte b27 = bytes[i17];
                if (b27 == 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                b19 = base64DecodeChars[b27];
                if (i18 >= length || b19 != -1) {
                    break;
                }
                i17 = i18;
            }
            if (b19 == -1) {
                break;
            }
            stringBuffer.append((char) (b19 | ((b18 & 3) << 6)));
            i19 = i18;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }

    public static String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            int i16 = i3 + 1;
            int i17 = bArr[i3] & 255;
            if (i16 == length) {
                stringBuffer.append(base64EncodeChars[i17 >>> 2]);
                stringBuffer.append(base64EncodeChars[(i17 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i18 = i16 + 1;
            int i19 = bArr[i16] & 255;
            if (i18 == length) {
                stringBuffer.append(base64EncodeChars[i17 >>> 2]);
                stringBuffer.append(base64EncodeChars[((i17 & 3) << 4) | ((i19 & 240) >>> 4)]);
                stringBuffer.append(base64EncodeChars[(i19 & 15) << 2]);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            int i26 = i18 + 1;
            int i27 = bArr[i18] & 255;
            stringBuffer.append(base64EncodeChars[i17 >>> 2]);
            stringBuffer.append(base64EncodeChars[((i17 & 3) << 4) | ((i19 & 240) >>> 4)]);
            stringBuffer.append(base64EncodeChars[((i19 & 15) << 2) | ((i27 & 192) >>> 6)]);
            stringBuffer.append(base64EncodeChars[i27 & 63]);
            i3 = i26;
        }
        return stringBuffer.toString();
    }
}
