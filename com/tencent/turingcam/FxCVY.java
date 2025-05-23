package com.tencent.turingcam;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import org.apache.commons.fileupload.MultipartStream;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class FxCVY {
    private static int a(int i3, int i16, int i17, int i18, int i19, int[] iArr) {
        return ((i3 ^ i16) + (iArr[(i18 & 3) ^ i19] ^ i17)) ^ (((i17 >>> 5) ^ (i16 << 2)) + ((i16 >>> 3) ^ (i17 << 4)));
    }

    public static final String b(String str) {
        try {
            byte[] a16 = a(str);
            byte[] bytes = "DFG#$%^#%(&*M<><".getBytes("UTF-8");
            if (a16.length != 0) {
                int[] a17 = a(a16, false);
                if (bytes.length != 16) {
                    byte[] bArr = new byte[16];
                    if (bytes.length < 16) {
                        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                    } else {
                        System.arraycopy(bytes, 0, bArr, 0, 16);
                    }
                    bytes = bArr;
                }
                int[] a18 = a(bytes, false);
                int length = a17.length - 1;
                if (length >= 1) {
                    int i3 = a17[0];
                    for (int i16 = ((52 / (length + 1)) + 6) * (-1640531527); i16 != 0; i16 += 1640531527) {
                        int i17 = (i16 >>> 2) & 3;
                        int i18 = i3;
                        int i19 = length;
                        while (i19 > 0) {
                            i18 = a17[i19] - a(i16, i18, a17[i19 - 1], i19, i17, a18);
                            a17[i19] = i18;
                            i19--;
                        }
                        i3 = a17[0] - a(i16, i18, a17[length], i19, i17, a18);
                        a17[0] = i3;
                    }
                }
                int length2 = a17.length << 2;
                int i26 = a17[a17.length - 1];
                int i27 = length2 - 4;
                if (i26 >= i27 - 3 && i26 <= i27) {
                    byte[] bArr2 = new byte[i26];
                    for (int i28 = 0; i28 < i26; i28++) {
                        bArr2[i28] = (byte) (a17[i28 >>> 2] >>> ((i28 & 3) << 3));
                    }
                    a16 = bArr2;
                } else {
                    a16 = null;
                }
            }
            if (a16 == null) {
                return null;
            }
            return new String(a16);
        } catch (Exception unused) {
            return null;
        }
    }

    private static int[] a(byte[] bArr, boolean z16) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
        if (z16) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            int i16 = i3 >>> 2;
            iArr[i16] = iArr[i16] | ((bArr[i3] & 255) << ((i3 & 3) << 3));
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0079, code lost:
    
        if (r3 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r2.write(r3 | ((r6 & 3) << 6));
        r3 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final byte[] a(String str) {
        int i3;
        byte b16;
        int i16;
        byte b17;
        int i17;
        byte b18;
        byte[] bArr = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, 17, RegisterType.REFERENCE, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, MultipartStream.DASH, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i18 = 0;
        while (i18 < length) {
            while (true) {
                i3 = i18 + 1;
                b16 = bArr[bytes[i18]];
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
                b17 = bArr[bytes[i3]];
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
                b18 = bArr[b19];
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
                byte b27 = bArr[b26];
                if (i19 >= length || b27 != -1) {
                    break;
                }
                i17 = i19;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
