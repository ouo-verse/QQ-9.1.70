package com.tencent.midas.comm;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.text.EmotcationConstants;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes9.dex */
public class APBase64 {
    private static final char[] base64EncodeChars = {EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if (r2 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
    
        r1.write(r2 | ((r5 & 3) << 6));
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] decode(String str) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        int i17;
        byte b18;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i18 = 0;
        while (i18 < length) {
            while (true) {
                i3 = i18 + 1;
                b16 = base64DecodeChars[bytes[i18]];
                if (i3 >= length || b16 != -1) {
                    break;
                }
                i18 = i3;
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
            byteArrayOutputStream.write((b16 << 2) | ((b17 & 48) >>> 4));
            while (true) {
                i17 = i16 + 1;
                byte b19 = bytes[i16];
                if (b19 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b18 = base64DecodeChars[b19];
                if (i17 >= length || b18 != -1) {
                    break;
                }
                i16 = i17;
            }
            if (b18 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b17 & RegisterType.DOUBLE_HI) << 4) | ((b18 & 60) >>> 2));
            while (true) {
                int i19 = i17 + 1;
                byte b26 = bytes[i17];
                if (b26 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                byte b27 = base64DecodeChars[b26];
                if (i19 >= length || b27 != -1) {
                    break;
                }
                i17 = i19;
            }
        }
        return byteArrayOutputStream.toByteArray();
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
                char[] cArr = base64EncodeChars;
                stringBuffer.append(cArr[i17 >>> 2]);
                stringBuffer.append(cArr[(i17 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i18 = i16 + 1;
            int i19 = bArr[i16] & 255;
            if (i18 == length) {
                char[] cArr2 = base64EncodeChars;
                stringBuffer.append(cArr2[i17 >>> 2]);
                stringBuffer.append(cArr2[((i17 & 3) << 4) | ((i19 & 240) >>> 4)]);
                stringBuffer.append(cArr2[(i19 & 15) << 2]);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            int i26 = i18 + 1;
            int i27 = bArr[i18] & 255;
            char[] cArr3 = base64EncodeChars;
            stringBuffer.append(cArr3[i17 >>> 2]);
            stringBuffer.append(cArr3[((i17 & 3) << 4) | ((i19 & 240) >>> 4)]);
            stringBuffer.append(cArr3[((i19 & 15) << 2) | ((i27 & 192) >>> 6)]);
            stringBuffer.append(cArr3[i27 & 63]);
            i3 = i26;
        }
        return stringBuffer.toString();
    }
}
