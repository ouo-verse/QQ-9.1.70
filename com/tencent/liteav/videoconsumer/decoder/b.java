package com.tencent.liteav.videoconsumer.decoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    int f119507b;

    /* renamed from: c, reason: collision with root package name */
    private InputStream f119508c;

    /* renamed from: d, reason: collision with root package name */
    private int f119509d;

    /* renamed from: e, reason: collision with root package name */
    private int f119510e;

    /* renamed from: f, reason: collision with root package name */
    private final OutputStream f119511f;

    /* renamed from: h, reason: collision with root package name */
    private int f119513h;

    /* renamed from: a, reason: collision with root package name */
    protected a f119506a = new a();

    /* renamed from: g, reason: collision with root package name */
    private int[] f119512g = new int[8];

    public b(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.f119508c = inputStream;
        this.f119511f = outputStream;
        this.f119509d = inputStream.read();
        this.f119510e = inputStream.read();
    }

    private int c(boolean z16) throws IOException {
        if (this.f119507b == 8) {
            f();
            if (this.f119509d == -1) {
                return -1;
            }
        }
        int i3 = this.f119509d;
        int i16 = this.f119507b;
        int i17 = (i3 >> (7 - i16)) & 1;
        this.f119507b = i16 + 1;
        if (z16 && this.f119511f != null) {
            f(i17);
        }
        return i17;
    }

    private long e(int i3) throws IOException {
        if (i3 > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j3 = 0;
        for (int i16 = 0; i16 < i3; i16++) {
            j3 = (j3 << 1) | c(true);
        }
        return j3;
    }

    private void f() throws IOException {
        this.f119509d = this.f119510e;
        this.f119510e = this.f119508c.read();
        this.f119507b = 0;
    }

    private int g() throws IOException {
        int i3 = 0;
        while (c(true) == 0) {
            i3++;
        }
        if (i3 <= 0) {
            return 0;
        }
        return (int) (((1 << i3) - 1) + e(i3));
    }

    private void h() throws IOException {
        int[] iArr = this.f119512g;
        this.f119511f.write(iArr[7] | (iArr[0] << 7) | (iArr[1] << 6) | (iArr[2] << 5) | (iArr[3] << 4) | (iArr[4] << 3) | (iArr[5] << 2) | (iArr[6] << 1));
    }

    public final boolean a(boolean z16) throws IOException {
        return c(z16) == 1;
    }

    public final void b(int i3) throws IOException {
        a(i3);
    }

    public final void d() throws IOException {
        int i3 = 0;
        while (c(true) == 0) {
            i3++;
        }
        if (i3 > 0) {
            a(i3);
        }
    }

    public final long a() throws IOException {
        long e16 = e(8);
        String.valueOf(e16);
        return e16;
    }

    public final int b() throws IOException {
        int i3 = 0;
        while (c(false) == 0) {
            i3++;
        }
        if (i3 <= 0) {
            return 0;
        }
        if (i3 > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j3 = 0;
        for (int i16 = 0; i16 < i3; i16++) {
            j3 = (j3 << 1) | c(false);
        }
        return (int) (((1 << i3) - 1) + j3);
    }

    public final void d(int i3) throws IOException {
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i17 >= 15) {
                break;
            }
            int i19 = (1 << i17) + i18;
            if (i3 < i19) {
                i16 = i17;
                break;
            } else {
                i17++;
                i18 = i19;
            }
        }
        a(0L, i16);
        f(1);
        a(i3 - i18, i16);
    }

    public final void e() throws IOException {
        f(1);
        a(0L, 8 - this.f119513h);
        for (int i3 = this.f119513h; i3 < 8; i3++) {
            this.f119512g[i3] = 0;
        }
        this.f119513h = 0;
        h();
    }

    private void f(int i3) throws IOException {
        if (this.f119513h == 8) {
            this.f119513h = 0;
            h();
        }
        int[] iArr = this.f119512g;
        int i16 = this.f119513h;
        this.f119513h = i16 + 1;
        iArr[i16] = i3;
    }

    public final void a(int i3) throws IOException {
        if (i3 > 64) {
            throw new IllegalArgumentException("Can not skip more then 64 bit");
        }
        for (int i16 = 0; i16 < i3; i16++) {
            c(true);
        }
    }

    public final void b(boolean z16) throws IOException {
        f(z16 ? 1 : 0);
    }

    private void a(long j3, int i3) throws IOException {
        for (int i16 = 0; i16 < i3; i16++) {
            f(((int) (j3 >> ((i3 - i16) - 1))) & 1);
        }
    }

    public final int c() throws IOException {
        int g16 = g();
        String.valueOf(g16);
        return g16;
    }

    public final void c(int i3) throws IOException {
        int[] iArr = new int[i3];
        int i16 = 8;
        int i17 = 8;
        for (int i18 = 0; i18 < i3; i18++) {
            if (i16 != 0) {
                int g16 = g();
                int i19 = ((g16 >> 1) + (g16 & 1)) * ((r4 << 1) - 1);
                String.valueOf(i19);
                i16 = ((i19 + i17) + 256) % 256;
            }
            if (i16 != 0) {
                i17 = i16;
            }
            iArr[i18] = i17;
        }
    }
}
