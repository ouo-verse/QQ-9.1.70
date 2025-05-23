package com.google.zxing.common;

import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private int f35989b = 0;

    /* renamed from: a, reason: collision with root package name */
    private int[] f35988a = new int[1];

    private void d(int i3) {
        if (i3 > (this.f35988a.length << 5)) {
            int[] h16 = h(i3);
            int[] iArr = this.f35988a;
            System.arraycopy(iArr, 0, h16, 0, iArr.length);
            this.f35988a = h16;
        }
    }

    private static int[] h(int i3) {
        return new int[(i3 + 31) >> 5];
    }

    public void a(boolean z16) {
        d(this.f35989b + 1);
        if (z16) {
            int[] iArr = this.f35988a;
            int i3 = this.f35989b;
            int i16 = i3 >> 5;
            iArr[i16] = (1 << (i3 & 31)) | iArr[i16];
        }
        this.f35989b++;
    }

    public void b(a aVar) {
        int i3 = aVar.f35989b;
        d(this.f35989b + i3);
        for (int i16 = 0; i16 < i3; i16++) {
            a(aVar.e(i16));
        }
    }

    public void c(int i3, int i16) {
        if (i16 >= 0 && i16 <= 32) {
            d(this.f35989b + i16);
            while (i16 > 0) {
                boolean z16 = true;
                if (((i3 >> (i16 - 1)) & 1) != 1) {
                    z16 = false;
                }
                a(z16);
                i16--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public boolean e(int i3) {
        if (((1 << (i3 & 31)) & this.f35988a[i3 >> 5]) != 0) {
            return true;
        }
        return false;
    }

    public int f() {
        return this.f35989b;
    }

    public int g() {
        return (this.f35989b + 7) >> 3;
    }

    public void i(int i3, byte[] bArr, int i16, int i17) {
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = 0;
            for (int i26 = 0; i26 < 8; i26++) {
                if (e(i3)) {
                    i19 |= 1 << (7 - i26);
                }
                i3++;
            }
            bArr[i16 + i18] = (byte) i19;
        }
    }

    public void j(a aVar) {
        if (this.f35988a.length == aVar.f35988a.length) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.f35988a;
                if (i3 < iArr.length) {
                    iArr[i3] = iArr[i3] ^ aVar.f35988a[i3];
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    public String toString() {
        char c16;
        StringBuilder sb5 = new StringBuilder(this.f35989b);
        for (int i3 = 0; i3 < this.f35989b; i3++) {
            if ((i3 & 7) == 0) {
                sb5.append(TokenParser.SP);
            }
            if (e(i3)) {
                c16 = 'X';
            } else {
                c16 = '.';
            }
            sb5.append(c16);
        }
        return sb5.toString();
    }
}
