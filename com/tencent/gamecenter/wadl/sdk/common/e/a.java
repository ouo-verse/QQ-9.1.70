package com.tencent.gamecenter.wadl.sdk.common.e;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qzone.QZoneHelper;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f107230a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    private static int a(byte[] bArr, int i3, int i16) {
        byte b16;
        do {
            b16 = f107230a[bArr[i3]];
            if (i3 >= i16) {
                break;
            }
        } while (b16 == -1);
        return b16;
    }

    private static byte[] b(String str) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i17 = 0;
        loop0: while (i17 < length) {
            int i18 = i17 + 1;
            int a16 = a(bytes, i17, length);
            if (a16 == -1) {
                break;
            }
            int i19 = i18 + 1;
            int a17 = a(bytes, i18, length);
            if (a17 == -1) {
                break;
            }
            stringBuffer.append((char) ((a16 << 2) | ((a17 & 48) >>> 4)));
            while (true) {
                i3 = i19 + 1;
                byte b18 = bytes[i19];
                if (b18 == 61) {
                    break loop0;
                }
                b16 = f107230a[b18];
                if (i3 >= length || b16 != -1) {
                    break;
                }
                i19 = i3;
            }
            if (b16 == -1) {
                break;
            }
            stringBuffer.append((char) (((a17 & 15) << 4) | ((b16 & 60) >>> 2)));
            while (true) {
                i16 = i3 + 1;
                byte b19 = bytes[i3];
                if (b19 == 61) {
                    break loop0;
                }
                b17 = f107230a[b19];
                if (i16 >= length || b17 != -1) {
                    break;
                }
                i3 = i16;
            }
            if (b17 == -1) {
                break;
            }
            stringBuffer.append((char) (b17 | ((b16 & 3) << 6)));
            i17 = i16;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return new byte[0];
        }
    }
}
