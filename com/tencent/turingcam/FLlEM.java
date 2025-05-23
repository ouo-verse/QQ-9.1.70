package com.tencent.turingcam;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class FLlEM {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f381819a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381819a = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
        }
    }

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
    public static final byte[] a(String str) {
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
                b16 = f381819a[bytes[i18]];
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
                b17 = f381819a[bytes[i3]];
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
                b18 = f381819a[b19];
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
                byte b27 = f381819a[b26];
                if (i19 >= length || b27 != -1) {
                    break;
                }
                i17 = i19;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
