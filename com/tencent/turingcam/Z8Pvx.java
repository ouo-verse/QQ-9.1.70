package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
public class Z8Pvx {

    /* loaded from: classes27.dex */
    public static class ShGzN extends spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f382115a;

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f382116b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12297);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
            } else {
                f382115a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                f382116b = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            }
        }
    }

    /* loaded from: classes27.dex */
    public static abstract class spXPg {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ea, code lost:
    
        if (r6 != 4) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, int i3) {
        int[] iArr;
        boolean z16;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i16 = (length * 3) / 4;
        byte[] bArr = new byte[i16];
        if ((i3 & 8) == 0) {
            iArr = ShGzN.f382115a;
        } else {
            iArr = ShGzN.f382116b;
        }
        int i17 = length + 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        while (true) {
            z16 = true;
            if (i18 >= i17) {
                break;
            }
            if (i19 == 0) {
                while (true) {
                    int i28 = i18 + 4;
                    if (i28 > i17 || (i26 = (iArr[bytes[i18] & 255] << 18) | (iArr[bytes[i18 + 1] & 255] << 12) | (iArr[bytes[i18 + 2] & 255] << 6) | iArr[bytes[i18 + 3] & 255]) < 0) {
                        break;
                    }
                    bArr[i27 + 2] = (byte) i26;
                    bArr[i27 + 1] = (byte) (i26 >> 8);
                    bArr[i27] = (byte) (i26 >> 16);
                    i27 += 3;
                    i18 = i28;
                }
                if (i18 >= i17) {
                    break;
                }
            }
            int i29 = i18 + 1;
            int i36 = iArr[bytes[i18] & 255];
            if (i19 != 0) {
                if (i19 != 1) {
                    if (i19 != 2) {
                        if (i19 != 3) {
                            if (i19 != 4) {
                                if (i19 == 5 && i36 != -1) {
                                    break;
                                }
                            } else {
                                if (i36 != -2) {
                                    if (i36 != -1) {
                                        break;
                                    }
                                }
                                i19++;
                            }
                        } else if (i36 >= 0) {
                            i26 = (i26 << 6) | i36;
                            bArr[i27 + 2] = (byte) i26;
                            bArr[i27 + 1] = (byte) (i26 >> 8);
                            bArr[i27] = (byte) (i26 >> 16);
                            i27 += 3;
                            i19 = 0;
                        } else if (i36 == -2) {
                            bArr[i27 + 1] = (byte) (i26 >> 2);
                            bArr[i27] = (byte) (i26 >> 10);
                            i27 += 2;
                            i19 = 5;
                        } else if (i36 != -1) {
                            break;
                        }
                    } else {
                        if (i36 < 0) {
                            if (i36 == -2) {
                                bArr[i27] = (byte) (i26 >> 4);
                                i19 = 4;
                                i27++;
                            } else if (i36 != -1) {
                                break;
                            }
                        }
                        i26 = (i26 << 6) | i36;
                        i19++;
                    }
                } else {
                    if (i36 < 0) {
                        if (i36 != -1) {
                            break;
                        }
                    }
                    i26 = (i26 << 6) | i36;
                    i19++;
                }
                i18 = i29;
            } else {
                if (i36 >= 0) {
                    i19++;
                    i26 = i36;
                } else if (i36 != -1) {
                    break;
                }
                i18 = i29;
            }
            if (z16) {
                if (i27 != i16) {
                    byte[] bArr2 = new byte[i27];
                    System.arraycopy(bArr, 0, bArr2, 0, i27);
                    return bArr2;
                }
                return bArr;
            }
            throw new IllegalArgumentException("bad base-64");
        }
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 == 3) {
                    int i37 = i27 + 1;
                    bArr[i27] = (byte) (i26 >> 10);
                    i27 = i37 + 1;
                    bArr[i37] = (byte) (i26 >> 2);
                }
            } else {
                bArr[i27] = (byte) (i26 >> 4);
                i27++;
            }
            if (z16) {
            }
        }
        i27 = 0;
        z16 = false;
        if (z16) {
        }
    }
}
