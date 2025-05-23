package com.tencent.mobileqq.qsec.qsecest;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.util.Arrays;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private static final char[] f276825e;

        /* renamed from: f, reason: collision with root package name */
        private static final char[] f276826f;

        /* renamed from: g, reason: collision with root package name */
        private static final byte[] f276827g;

        /* renamed from: h, reason: collision with root package name */
        static final a f276828h;

        /* renamed from: i, reason: collision with root package name */
        static final a f276829i;

        /* renamed from: j, reason: collision with root package name */
        static final a f276830j;

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f276831a;

        /* renamed from: b, reason: collision with root package name */
        private final int f276832b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f276833c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f276834d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20292);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 9)) {
                redirector.redirect((short) 9);
                return;
            }
            f276825e = "EBnuvwxCD+FGHIopqrstJKLRSTUlmyz012VWXYZaMNOPQbcdefghijk3456789A/".toCharArray();
            f276826f = new char[]{EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', util.base64_pad_url};
            byte[] bArr = {13, 10};
            f276827g = bArr;
            f276828h = new a(false, null, -1, true);
            f276829i = new a(true, null, -1, true);
            f276830j = new a(false, bArr, 76, true);
        }

        a(boolean z16, byte[] bArr, int i3, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), bArr, Integer.valueOf(i3), Boolean.valueOf(z17));
                return;
            }
            this.f276833c = z16;
            this.f276831a = bArr;
            this.f276832b = i3;
            this.f276834d = z17;
        }

        private int b(byte[] bArr, int i3, int i16, byte[] bArr2) {
            char[] cArr;
            if (this.f276833c) {
                cArr = f276826f;
            } else {
                cArr = f276825e;
            }
            int i17 = ((i16 - i3) / 3) * 3;
            int i18 = i3 + i17;
            int i19 = this.f276832b;
            if (i19 > 0 && i17 > (i19 / 4) * 3) {
                i17 = (i19 / 4) * 3;
            }
            int i26 = 0;
            while (i3 < i18) {
                int min = Math.min(i3 + i17, i18);
                int i27 = i3;
                int i28 = i26;
                while (i27 < min) {
                    int i29 = i27 + 1;
                    int i36 = i29 + 1;
                    int i37 = ((bArr[i27] & 255) << 16) | ((bArr[i29] & 255) << 8);
                    int i38 = i36 + 1;
                    int i39 = i37 | (bArr[i36] & 255);
                    int i46 = i28 + 1;
                    bArr2[i28] = (byte) cArr[(i39 >>> 18) & 63];
                    int i47 = i46 + 1;
                    bArr2[i46] = (byte) cArr[(i39 >>> 12) & 63];
                    int i48 = i47 + 1;
                    bArr2[i47] = (byte) cArr[(i39 >>> 6) & 63];
                    i28 = i48 + 1;
                    bArr2[i48] = (byte) cArr[i39 & 63];
                    i27 = i38;
                }
                int i49 = ((min - i3) / 3) * 4;
                i26 += i49;
                if (i49 == this.f276832b && min < i16) {
                    byte[] bArr3 = this.f276831a;
                    int length = bArr3.length;
                    int i56 = 0;
                    while (i56 < length) {
                        bArr2[i26] = bArr3[i56];
                        i56++;
                        i26++;
                    }
                }
                i3 = min;
            }
            if (i3 < i16) {
                int i57 = i3 + 1;
                int i58 = bArr[i3] & 255;
                int i59 = i26 + 1;
                bArr2[i26] = (byte) cArr[i58 >> 2];
                if (i57 == i16) {
                    int i65 = i59 + 1;
                    bArr2[i59] = (byte) cArr[(i58 << 4) & 63];
                    if (this.f276834d) {
                        int i66 = i65 + 1;
                        bArr2[i65] = 61;
                        int i67 = i66 + 1;
                        bArr2[i66] = 61;
                        return i67;
                    }
                    return i65;
                }
                int i68 = bArr[i57] & 255;
                int i69 = i59 + 1;
                bArr2[i59] = (byte) cArr[((i58 << 4) & 63) | (i68 >> 4)];
                int i75 = i69 + 1;
                bArr2[i69] = (byte) cArr[(i68 << 2) & 63];
                if (this.f276834d) {
                    int i76 = i75 + 1;
                    bArr2[i75] = 61;
                    return i76;
                }
                return i75;
            }
            return i26;
        }

        private final int d(int i3) {
            int i16;
            int i17;
            if (this.f276834d) {
                i17 = ((i3 + 2) / 3) * 4;
            } else {
                int i18 = i3 % 3;
                int i19 = (i3 / 3) * 4;
                if (i18 == 0) {
                    i16 = 0;
                } else {
                    i16 = i18 + 1;
                }
                i17 = i19 + i16;
            }
            int i26 = this.f276832b;
            if (i26 > 0) {
                return i17 + (((i17 - 1) / i26) * this.f276831a.length);
            }
            return i17;
        }

        public byte[] a(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
            }
            try {
                int d16 = d(bArr.length);
                byte[] bArr2 = new byte[d16];
                int b16 = b(bArr, 0, bArr.length, bArr2);
                if (b16 != d16) {
                    return Arrays.copyOf(bArr2, b16);
                }
                return bArr2;
            } catch (Throwable th5) {
                th5.printStackTrace();
                return null;
            }
        }

        public String c(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            }
            try {
                byte[] a16 = a(bArr);
                return new String(a16, 0, 0, a16.length);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static a a() {
        return a.f276828h;
    }
}
