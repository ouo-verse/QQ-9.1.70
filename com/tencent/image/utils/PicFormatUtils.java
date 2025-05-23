package com.tencent.image.utils;

import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.io.FileInputStream;
import java.io.IOException;
import org.jf.dexlib2.analysis.RegisterType;

/* loaded from: classes7.dex */
public class PicFormatUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "URLDrawable.PicFormatUtils";
    private static final char[] digits;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};
        }
    }

    public PicFormatUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                try {
                    byte b16 = bArr[i3];
                    int i16 = i3 * 2;
                    char[] cArr2 = digits;
                    cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                    cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
                } catch (Exception e16) {
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d("HexUtil", 2, " === bytes2HexStr error === " + e16.toString());
                    }
                }
            }
            return new String(cArr);
        }
        return null;
    }

    public static String getTypeByStream(FileInputStream fileInputStream) {
        byte[] bArr = new byte[8];
        try {
            fileInputStream.read(bArr, 0, 8);
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        String upperCase = bytes2HexStr(bArr).toUpperCase();
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_JPG)) {
            return "jpg";
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_PNG)) {
            return "png";
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_GIF)) {
            return "gif";
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_TIF)) {
            return HippyImageInfo.IMAGE_TYPE_TIF;
        }
        if (upperCase.contains(HippyImageInfo.IMAGE_FLAG_BMP)) {
            return "bmp";
        }
        if (upperCase.contains("0A")) {
            return "pcx";
        }
        if (!upperCase.contains("4D4D") && !upperCase.contains("4949")) {
            if (upperCase.contains("464F524D")) {
                return "iff";
            }
            if (upperCase.contains("52494646")) {
                return "ani";
            }
            if (upperCase.contains("0000020000")) {
                return "tga";
            }
            if (upperCase.contains("0000100000")) {
                return "rle";
            }
            if (upperCase.contains("0000010001002020")) {
                return "ico";
            }
            if (upperCase.contains("0000020001002020")) {
                return "cur";
            }
            return upperCase;
        }
        return "tiff";
    }

    public static boolean isJPEGImage(String str) {
        boolean z16 = false;
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(str);
                    try {
                        z16 = "jpg".equals(getTypeByStream(fileInputStream2));
                        fileInputStream2.close();
                        fileInputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        fileInputStream = fileInputStream2;
                        URLDrawable.depImp.mLog.e(TAG, 2, "isJPEGImage", e);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return z16;
                    } catch (Throwable th5) {
                        th = th5;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (IOException unused2) {
        }
        return z16;
    }
}
