package com.tencent.halley.common.utils;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QZoneHelper;
import java.io.UnsupportedEncodingException;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f113536a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f113536a = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
        }
    }

    private static boolean a(int i3, int i16, int i17) {
        return i3 < i16 && i17 == -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r7 == (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1.append((char) (((r6 & org.jf.dexlib2.analysis.RegisterType.DOUBLE_HI) << 4) | ((r7 & 60) >>> 2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r6 = r3 + 1;
        r3 = r10[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        if (r3 != 61) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        r3 = com.tencent.halley.common.utils.a.f113536a[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
    
        if (a(r6, r2, r3) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0090, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        if (r3 == (-1)) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
    
        r1.append((char) (r3 | ((r7 & 3) << 6)));
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
    
        return r1.toString().getBytes("iso8859-1");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bytes = str.getBytes("US-ASCII");
            int length = bytes.length;
            int i17 = 0;
            while (i17 < length) {
                while (true) {
                    i3 = i17 + 1;
                    b16 = f113536a[bytes[i17]];
                    if (!a(i3, length, b16)) {
                        break;
                    }
                    i17 = i3;
                }
                if (b16 == -1) {
                    break;
                }
                while (true) {
                    i16 = i3 + 1;
                    b17 = f113536a[bytes[i3]];
                    if (!a(i16, length, b17)) {
                        break;
                    }
                    i3 = i16;
                }
                if (b17 == -1) {
                    break;
                }
                stringBuffer.append((char) ((b16 << 2) | ((b17 & 48) >>> 4)));
                while (true) {
                    int i18 = i16 + 1;
                    byte b18 = bytes[i16];
                    if (b18 == 61) {
                        return stringBuffer.toString().getBytes("iso8859-1");
                    }
                    byte b19 = f113536a[b18];
                    if (!a(i18, length, b19)) {
                        break;
                    }
                    i16 = i18;
                }
            }
            return stringBuffer.toString().getBytes("iso8859-1");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return new byte[0];
        }
    }
}
