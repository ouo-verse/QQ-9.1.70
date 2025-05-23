package com.tencent.luggage.wxa.c0;

import android.util.Log;
import com.tencent.libra.util.ImageContentType;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.n0.v;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.lang.CharEncoding;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final int f123185b = v.b("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final a f123186a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean a(int i3, int i16, int i17, int i18, int i19);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f123187a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f123188b;

        /* renamed from: c, reason: collision with root package name */
        public final int f123189c;

        public b(int i3, boolean z16, int i16) {
            this.f123187a = i3;
            this.f123188b = z16;
            this.f123189c = i16;
        }
    }

    public g() {
        this(null);
    }

    public static int a(int i3) {
        return (i3 == 0 || i3 == 3) ? 1 : 2;
    }

    public static String b(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "ISO-8859-1" : "UTF-8" : CharEncoding.UTF_16BE : "UTF-16";
    }

    public static k c(l lVar, int i3, String str) {
        byte[] bArr = new byte[i3];
        lVar.a(bArr, 0, i3);
        return new k(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    public static j d(l lVar, int i3) {
        String str;
        if (i3 < 1) {
            return null;
        }
        int q16 = lVar.q();
        String b16 = b(q16);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        lVar.a(bArr, 0, i16);
        int b17 = b(bArr, 0, q16);
        String str2 = new String(bArr, 0, b17, b16);
        int a16 = b17 + a(q16);
        if (a16 < i16) {
            str = new String(bArr, a16, b(bArr, a16, q16) - a16, b16);
        } else {
            str = "";
        }
        return new j("TXXX", str2, str);
    }

    public static k e(l lVar, int i3) {
        String str;
        if (i3 < 1) {
            return null;
        }
        int q16 = lVar.q();
        String b16 = b(q16);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        lVar.a(bArr, 0, i16);
        int b17 = b(bArr, 0, q16);
        String str2 = new String(bArr, 0, b17, b16);
        int a16 = b17 + a(q16);
        if (a16 < i16) {
            str = new String(bArr, a16, b(bArr, a16) - a16, "ISO-8859-1");
        } else {
            str = "";
        }
        return new k("WXXX", str2, str);
    }

    public static int f(l lVar, int i3) {
        byte[] bArr = lVar.f135088a;
        int c16 = lVar.c();
        while (true) {
            int i16 = c16 + 1;
            if (i16 < i3) {
                if ((bArr[c16] & 255) == 255 && bArr[i16] == 0) {
                    System.arraycopy(bArr, c16 + 2, bArr, i16, (i3 - c16) - 2);
                    i3--;
                }
                c16 = i16;
            } else {
                return i3;
            }
        }
    }

    public g(a aVar) {
        this.f123186a = aVar;
    }

    public static j b(l lVar, int i3, String str) {
        if (i3 < 1) {
            return null;
        }
        int q16 = lVar.q();
        String b16 = b(q16);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        lVar.a(bArr, 0, i16);
        return new j(str, null, new String(bArr, 0, b(bArr, 0, q16), b16));
    }

    public com.tencent.luggage.wxa.a0.a a(byte[] bArr, int i3) {
        ArrayList arrayList = new ArrayList();
        l lVar = new l(bArr, i3);
        b a16 = a(lVar);
        if (a16 == null) {
            return null;
        }
        int c16 = lVar.c();
        int i16 = a16.f123187a == 2 ? 6 : 10;
        int i17 = a16.f123189c;
        if (a16.f123188b) {
            i17 = f(lVar, a16.f123189c);
        }
        lVar.d(c16 + i17);
        boolean z16 = false;
        if (!a(lVar, a16.f123187a, i16, false)) {
            if (a16.f123187a != 4 || !a(lVar, 4, i16, true)) {
                Log.w("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + a16.f123187a);
                return null;
            }
            z16 = true;
        }
        while (lVar.a() >= i16) {
            h a17 = a(a16.f123187a, lVar, z16, i16, this.f123186a);
            if (a17 != null) {
                arrayList.add(a17);
            }
        }
        return new com.tencent.luggage.wxa.a0.a(arrayList);
    }

    public static i c(l lVar, int i3) {
        byte[] bArr = new byte[i3];
        lVar.a(bArr, 0, i3);
        int b16 = b(bArr, 0);
        return new i(new String(bArr, 0, b16, "ISO-8859-1"), a(bArr, b16 + 1, i3));
    }

    public static f b(l lVar, int i3) {
        int q16 = lVar.q();
        String b16 = b(q16);
        int i16 = i3 - 1;
        byte[] bArr = new byte[i16];
        lVar.a(bArr, 0, i16);
        int b17 = b(bArr, 0);
        String str = new String(bArr, 0, b17, "ISO-8859-1");
        int i17 = b17 + 1;
        int b18 = b(bArr, i17, q16);
        String str2 = new String(bArr, i17, b18 - i17, b16);
        int a16 = b18 + a(q16);
        int b19 = b(bArr, a16, q16);
        return new f(str, str2, new String(bArr, a16, b19 - a16, b16), a(bArr, b19 + a(q16), i16));
    }

    public static b a(l lVar) {
        if (lVar.a() < 10) {
            Log.w("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int t16 = lVar.t();
        if (t16 != f123185b) {
            Log.w("Id3Decoder", "Unexpected first three bytes of ID3 tag header: " + t16);
            return null;
        }
        int q16 = lVar.q();
        lVar.f(1);
        int q17 = lVar.q();
        int p16 = lVar.p();
        if (q16 == 2) {
            if ((q17 & 64) != 0) {
                Log.w("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (q16 == 3) {
            if ((q17 & 64) != 0) {
                int f16 = lVar.f();
                lVar.f(f16);
                p16 -= f16 + 4;
            }
        } else {
            if (q16 != 4) {
                Log.w("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + q16);
                return null;
            }
            if ((q17 & 64) != 0) {
                int p17 = lVar.p();
                lVar.f(p17 - 4);
                p16 -= p17;
            }
            if ((q17 & 16) != 0) {
                p16 -= 10;
            }
        }
        return new b(q16, q16 < 4 && (q17 & 128) != 0, p16);
    }

    public static d b(l lVar, int i3, int i16, boolean z16, int i17, a aVar) {
        int c16 = lVar.c();
        int b16 = b(lVar.f135088a, c16);
        String str = new String(lVar.f135088a, c16, b16 - c16, "ISO-8859-1");
        lVar.e(b16 + 1);
        int q16 = lVar.q();
        boolean z17 = (q16 & 2) != 0;
        boolean z18 = (q16 & 1) != 0;
        int q17 = lVar.q();
        String[] strArr = new String[q17];
        for (int i18 = 0; i18 < q17; i18++) {
            int c17 = lVar.c();
            int b17 = b(lVar.f135088a, c17);
            strArr[i18] = new String(lVar.f135088a, c17, b17 - c17, "ISO-8859-1");
            lVar.e(b17 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i19 = c16 + i3;
        while (lVar.c() < i19) {
            h a16 = a(i16, lVar, z16, i17, aVar);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new d(str, z17, z18, strArr, hVarArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if ((r10 & 1) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0084, code lost:
    
        if ((r10 & 128) != 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(l lVar, int i3, int i16, boolean z16) {
        int t16;
        long t17;
        int i17;
        int i18;
        int c16 = lVar.c();
        while (true) {
            try {
                boolean z17 = true;
                if (lVar.a() < i16) {
                    return true;
                }
                if (i3 >= 3) {
                    t16 = lVar.f();
                    t17 = lVar.s();
                    i17 = lVar.w();
                } else {
                    t16 = lVar.t();
                    t17 = lVar.t();
                    i17 = 0;
                }
                if (t16 == 0 && t17 == 0 && i17 == 0) {
                    return true;
                }
                if (i3 == 4 && !z16) {
                    if ((8421504 & t17) != 0) {
                        return false;
                    }
                    t17 = (((t17 >> 24) & 255) << 21) | (t17 & 255) | (((t17 >> 8) & 255) << 7) | (((t17 >> 16) & 255) << 14);
                }
                if (i3 == 4) {
                    i18 = (i17 & 64) != 0 ? 1 : 0;
                } else {
                    if (i3 == 3) {
                        i18 = (i17 & 32) != 0 ? 1 : 0;
                    } else {
                        i18 = 0;
                        z17 = false;
                    }
                    if (z17) {
                        i18 += 4;
                    }
                    if (t17 < i18) {
                        return false;
                    }
                    if (lVar.a() < t17) {
                        return false;
                    }
                    lVar.f((int) t17);
                }
            } finally {
                lVar.e(c16);
            }
        }
    }

    public static int b(byte[] bArr, int i3, int i16) {
        int b16 = b(bArr, i3);
        if (i16 == 0 || i16 == 3) {
            return b16;
        }
        while (b16 < bArr.length - 1) {
            if (b16 % 2 == 0 && bArr[b16 + 1] == 0) {
                return b16;
            }
            b16 = b(bArr, b16 + 1);
        }
        return bArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x018d, code lost:
    
        if (r13 == 67) goto L131;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static h a(int i3, l lVar, boolean z16, int i16, a aVar) {
        int t16;
        String str;
        int i17;
        int i18;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        h a16;
        int q16 = lVar.q();
        int q17 = lVar.q();
        int q18 = lVar.q();
        int q19 = i3 >= 3 ? lVar.q() : 0;
        if (i3 == 4) {
            t16 = lVar.u();
            if (!z16) {
                t16 = (((t16 >> 24) & 255) << 21) | (t16 & 255) | (((t16 >> 8) & 255) << 7) | (((t16 >> 16) & 255) << 14);
            }
        } else if (i3 == 3) {
            t16 = lVar.u();
        } else {
            t16 = lVar.t();
        }
        int i19 = t16;
        int w3 = i3 >= 3 ? lVar.w() : 0;
        if (q16 == 0 && q17 == 0 && q18 == 0 && q19 == 0 && i19 == 0 && w3 == 0) {
            lVar.e(lVar.d());
            return null;
        }
        int c16 = lVar.c() + i19;
        if (c16 > lVar.d()) {
            Log.w("Id3Decoder", "Frame size exceeds remaining tag data");
            lVar.e(lVar.d());
            return null;
        }
        if (aVar != null) {
            str = "Id3Decoder";
            i17 = c16;
            i18 = w3;
            if (!aVar.a(i3, q16, q17, q18, q19)) {
                lVar.e(i17);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i17 = c16;
            i18 = w3;
        }
        if (i3 == 3) {
            int i26 = i18;
            z27 = (i26 & 128) != 0;
            z19 = (i26 & 64) != 0;
            z26 = false;
            z17 = (i26 & 32) != 0;
            z18 = z27;
        } else {
            int i27 = i18;
            if (i3 == 4) {
                z17 = (i27 & 64) != 0;
                z18 = (i27 & 8) != 0;
                z19 = (i27 & 4) != 0;
                z26 = (i27 & 2) != 0;
                if ((i27 & 1) != 0) {
                    z27 = true;
                }
            } else {
                z17 = false;
                z18 = false;
                z19 = false;
                z26 = false;
            }
            z27 = false;
        }
        if (!z18 && !z19) {
            if (z17) {
                i19--;
                lVar.f(1);
            }
            if (z27) {
                i19 -= 4;
                lVar.f(4);
            }
            if (z26) {
                i19 = f(lVar, i19);
            }
            try {
                try {
                    if (q16 == 84 && q17 == 88 && q18 == 88 && (i3 == 2 || q19 == 88)) {
                        a16 = d(lVar, i19);
                    } else if (q16 == 84) {
                        a16 = b(lVar, i19, a(i3, q16, q17, q18, q19));
                    } else if (q16 == 87 && q17 == 88 && q18 == 88 && (i3 == 2 || q19 == 88)) {
                        a16 = e(lVar, i19);
                    } else if (q16 == 87) {
                        a16 = c(lVar, i19, a(i3, q16, q17, q18, q19));
                    } else if (q16 == 80 && q17 == 82 && q18 == 73 && q19 == 86) {
                        a16 = c(lVar, i19);
                    } else if (q16 == 71 && q17 == 69 && q18 == 79 && (q19 == 66 || i3 == 2)) {
                        a16 = b(lVar, i19);
                    } else if (i3 == 2) {
                        if (q16 == 80 && q17 == 73 && q18 == 67) {
                            a16 = a(lVar, i19, i3);
                        }
                        if (q16 != 67 && q17 == 79 && q18 == 77 && (q19 == 77 || i3 == 2)) {
                            a16 = a(lVar, i19);
                        } else if (q16 != 67 && q17 == 72 && q18 == 65 && q19 == 80) {
                            a16 = a(lVar, i19, i3, z16, i16, aVar);
                        } else if (q16 != 67 && q17 == 84 && q18 == 79 && q19 == 67) {
                            a16 = b(lVar, i19, i3, z16, i16, aVar);
                        } else {
                            a16 = a(lVar, i19, a(i3, q16, q17, q18, q19));
                        }
                    } else {
                        if (q16 == 65) {
                            if (q17 == 80) {
                                if (q18 == 73) {
                                }
                            }
                        }
                        if (q16 != 67) {
                        }
                        if (q16 != 67) {
                        }
                        if (q16 != 67) {
                        }
                        a16 = a(lVar, i19, a(i3, q16, q17, q18, q19));
                    }
                    if (a16 == null) {
                        Log.w(str, "Failed to decode frame: id=" + a(i3, q16, q17, q18, q19) + ", frameSize=" + i19);
                    }
                    lVar.e(i17);
                    return a16;
                } catch (UnsupportedEncodingException unused) {
                    Log.w(str, "Unsupported character encoding");
                    lVar.e(i17);
                    return null;
                }
            } catch (Throwable th5) {
                lVar.e(i17);
                throw th5;
            }
        }
        Log.w(str, "Skipping unsupported compressed or encrypted frame");
        lVar.e(i17);
        return null;
    }

    public static int b(byte[] bArr, int i3) {
        while (i3 < bArr.length) {
            if (bArr[i3] == 0) {
                return i3;
            }
            i3++;
        }
        return bArr.length;
    }

    public static com.tencent.luggage.wxa.c0.a a(l lVar, int i3, int i16) {
        int b16;
        String str;
        int q16 = lVar.q();
        String b17 = b(q16);
        int i17 = i3 - 1;
        byte[] bArr = new byte[i17];
        lVar.a(bArr, 0, i17);
        if (i16 == 2) {
            str = ImageContentType.IMAGE_PREFIX + v.g(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals(ImageContentType.MIME_TYPE_JPG)) {
                str = "image/jpeg";
            }
            b16 = 2;
        } else {
            b16 = b(bArr, 0);
            String g16 = v.g(new String(bArr, 0, b16, "ISO-8859-1"));
            if (g16.indexOf(47) == -1) {
                str = ImageContentType.IMAGE_PREFIX + g16;
            } else {
                str = g16;
            }
        }
        int i18 = bArr[b16 + 1] & 255;
        int i19 = b16 + 2;
        int b18 = b(bArr, i19, q16);
        return new com.tencent.luggage.wxa.c0.a(str, new String(bArr, i19, b18 - i19, b17), i18, a(bArr, b18 + a(q16), i17));
    }

    public static e a(l lVar, int i3) {
        if (i3 < 4) {
            return null;
        }
        int q16 = lVar.q();
        String b16 = b(q16);
        byte[] bArr = new byte[3];
        lVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i16 = i3 - 4;
        byte[] bArr2 = new byte[i16];
        lVar.a(bArr2, 0, i16);
        int b17 = b(bArr2, 0, q16);
        String str2 = new String(bArr2, 0, b17, b16);
        int a16 = b17 + a(q16);
        return new e(str, str2, a16 < i16 ? new String(bArr2, a16, b(bArr2, a16, q16) - a16, b16) : "");
    }

    public static c a(l lVar, int i3, int i16, boolean z16, int i17, a aVar) {
        int c16 = lVar.c();
        int b16 = b(lVar.f135088a, c16);
        String str = new String(lVar.f135088a, c16, b16 - c16, "ISO-8859-1");
        lVar.e(b16 + 1);
        int f16 = lVar.f();
        int f17 = lVar.f();
        long s16 = lVar.s();
        long j3 = s16 == 4294967295L ? -1L : s16;
        long s17 = lVar.s();
        long j16 = s17 == 4294967295L ? -1L : s17;
        ArrayList arrayList = new ArrayList();
        int i18 = c16 + i3;
        while (lVar.c() < i18) {
            h a16 = a(i16, lVar, z16, i17, aVar);
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        h[] hVarArr = new h[arrayList.size()];
        arrayList.toArray(hVarArr);
        return new c(str, f16, f17, j3, j16, hVarArr);
    }

    public static com.tencent.luggage.wxa.c0.b a(l lVar, int i3, String str) {
        byte[] bArr = new byte[i3];
        lVar.a(bArr, 0, i3);
        return new com.tencent.luggage.wxa.c0.b(str, bArr);
    }

    public static String a(int i3, int i16, int i17, int i18, int i19) {
        return i3 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
    }

    public static byte[] a(byte[] bArr, int i3, int i16) {
        return i16 <= i3 ? new byte[0] : Arrays.copyOfRange(bArr, i3, i16);
    }
}
