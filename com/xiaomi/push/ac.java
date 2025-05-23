package com.xiaomi.push;

import cooperation.qzone.QZoneHelper;
import java.io.InputStream;
import java.util.Vector;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f388128a;

    /* renamed from: b, reason: collision with root package name */
    private int f388129b;

    /* renamed from: c, reason: collision with root package name */
    private int f388130c;

    /* renamed from: d, reason: collision with root package name */
    private int f388131d;

    /* renamed from: e, reason: collision with root package name */
    private final InputStream f388132e;

    /* renamed from: f, reason: collision with root package name */
    private int f388133f;

    /* renamed from: g, reason: collision with root package name */
    private int f388134g;

    /* renamed from: h, reason: collision with root package name */
    private int f388135h;

    /* renamed from: i, reason: collision with root package name */
    private int f388136i;

    /* renamed from: j, reason: collision with root package name */
    private int f388137j;

    /* renamed from: k, reason: collision with root package name */
    private int f388138k;

    ac(byte[] bArr, int i3, int i16) {
        this.f388135h = Integer.MAX_VALUE;
        this.f388137j = 64;
        this.f388138k = 67108864;
        this.f388128a = bArr;
        this.f388129b = i16 + i3;
        this.f388131d = i3;
        this.f388132e = null;
    }

    public static ac f(InputStream inputStream) {
        return new ac(inputStream);
    }

    public static ac g(byte[] bArr, int i3, int i16) {
        return new ac(bArr, i3, i16);
    }

    private boolean n(boolean z16) {
        int read;
        int i3 = this.f388131d;
        int i16 = this.f388129b;
        if (i3 >= i16) {
            int i17 = this.f388134g;
            if (i17 + i16 == this.f388135h) {
                if (!z16) {
                    return false;
                }
                throw d.a();
            }
            this.f388134g = i17 + i16;
            this.f388131d = 0;
            InputStream inputStream = this.f388132e;
            if (inputStream == null) {
                read = -1;
            } else {
                read = inputStream.read(this.f388128a);
            }
            this.f388129b = read;
            if (read != 0 && read >= -1) {
                if (read == -1) {
                    this.f388129b = 0;
                    if (!z16) {
                        return false;
                    }
                    throw d.a();
                }
                r();
                int i18 = this.f388134g + this.f388129b + this.f388130c;
                if (i18 <= this.f388138k && i18 >= 0) {
                    return true;
                }
                throw d.h();
            }
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f388129b + "\nThe InputStream implementation is buggy.");
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    private void r() {
        int i3 = this.f388129b + this.f388130c;
        this.f388129b = i3;
        int i16 = this.f388134g + i3;
        int i17 = this.f388135h;
        if (i16 > i17) {
            int i18 = i16 - i17;
            this.f388130c = i18;
            this.f388129b = i3 - i18;
            return;
        }
        this.f388130c = 0;
    }

    public byte a() {
        if (this.f388131d == this.f388129b) {
            n(true);
        }
        byte[] bArr = this.f388128a;
        int i3 = this.f388131d;
        this.f388131d = i3 + 1;
        return bArr[i3];
    }

    public int b() {
        if (t()) {
            this.f388133f = 0;
            return 0;
        }
        int x16 = x();
        this.f388133f = x16;
        if (x16 != 0) {
            return x16;
        }
        throw d.d();
    }

    public int c(int i3) {
        if (i3 >= 0) {
            int i16 = i3 + this.f388134g + this.f388131d;
            int i17 = this.f388135h;
            if (i16 <= i17) {
                this.f388135h = i16;
                r();
                return i17;
            }
            throw d.a();
        }
        throw d.b();
    }

    public long d() {
        return v();
    }

    public a e() {
        int x16 = x();
        int i3 = this.f388129b;
        int i16 = this.f388131d;
        if (x16 <= i3 - i16 && x16 > 0) {
            a c16 = a.c(this.f388128a, i16, x16);
            this.f388131d += x16;
            return c16;
        }
        return a.b(o(x16));
    }

    public String h() {
        int x16 = x();
        int i3 = this.f388129b;
        int i16 = this.f388131d;
        if (x16 <= i3 - i16 && x16 > 0) {
            String str = new String(this.f388128a, i16, x16, "UTF-8");
            this.f388131d += x16;
            return str;
        }
        return new String(o(x16), "UTF-8");
    }

    public void i() {
        int b16;
        do {
            b16 = b();
            if (b16 == 0) {
                return;
            }
        } while (m(b16));
    }

    public void j(int i3) {
        if (this.f388133f == i3) {
        } else {
            throw d.e();
        }
    }

    public void k(dp dpVar) {
        int x16 = x();
        if (this.f388136i < this.f388137j) {
            int c16 = c(x16);
            this.f388136i++;
            dpVar.b(this);
            j(0);
            this.f388136i--;
            s(c16);
            return;
        }
        throw d.g();
    }

    public boolean l() {
        if (x() != 0) {
            return true;
        }
        return false;
    }

    public boolean m(int i3) {
        int a16 = eo.a(i3);
        if (a16 != 0) {
            if (a16 != 1) {
                if (a16 != 2) {
                    if (a16 != 3) {
                        if (a16 != 4) {
                            if (a16 == 5) {
                                z();
                                return true;
                            }
                            throw d.f();
                        }
                        return false;
                    }
                    i();
                    j(eo.b(eo.c(i3), 4));
                    return true;
                }
                w(x());
                return true;
            }
            y();
            return true;
        }
        p();
        return true;
    }

    public byte[] o(int i3) {
        int read;
        if (i3 >= 0) {
            int i16 = this.f388134g;
            int i17 = this.f388131d;
            int i18 = i16 + i17 + i3;
            int i19 = this.f388135h;
            if (i18 <= i19) {
                int i26 = this.f388129b;
                if (i3 <= i26 - i17) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f388128a, i17, bArr, 0, i3);
                    this.f388131d += i3;
                    return bArr;
                }
                if (i3 < 4096) {
                    byte[] bArr2 = new byte[i3];
                    int i27 = i26 - i17;
                    System.arraycopy(this.f388128a, i17, bArr2, 0, i27);
                    this.f388131d = this.f388129b;
                    n(true);
                    while (true) {
                        int i28 = i3 - i27;
                        int i29 = this.f388129b;
                        if (i28 > i29) {
                            System.arraycopy(this.f388128a, 0, bArr2, i27, i29);
                            int i36 = this.f388129b;
                            i27 += i36;
                            this.f388131d = i36;
                            n(true);
                        } else {
                            System.arraycopy(this.f388128a, 0, bArr2, i27, i28);
                            this.f388131d = i28;
                            return bArr2;
                        }
                    }
                } else {
                    this.f388134g = i16 + i26;
                    this.f388131d = 0;
                    this.f388129b = 0;
                    int i37 = i26 - i17;
                    int i38 = i3 - i37;
                    Vector vector = new Vector();
                    while (i38 > 0) {
                        int min = Math.min(i38, 4096);
                        byte[] bArr3 = new byte[min];
                        int i39 = 0;
                        while (i39 < min) {
                            InputStream inputStream = this.f388132e;
                            if (inputStream == null) {
                                read = -1;
                            } else {
                                read = inputStream.read(bArr3, i39, min - i39);
                            }
                            if (read != -1) {
                                this.f388134g += read;
                                i39 += read;
                            } else {
                                throw d.a();
                            }
                        }
                        i38 -= min;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i3];
                    System.arraycopy(this.f388128a, i17, bArr4, 0, i37);
                    for (int i46 = 0; i46 < vector.size(); i46++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i46);
                        System.arraycopy(bArr5, 0, bArr4, i37, bArr5.length);
                        i37 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                w((i19 - i16) - i17);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }

    public int p() {
        return x();
    }

    public long q() {
        return v();
    }

    public void s(int i3) {
        this.f388135h = i3;
        r();
    }

    public boolean t() {
        if (this.f388131d != this.f388129b || n(false)) {
            return false;
        }
        return true;
    }

    public int u() {
        return x();
    }

    public long v() {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            j3 |= (r3 & Byte.MAX_VALUE) << i3;
            if ((a() & 128) == 0) {
                return j3;
            }
        }
        throw d.c();
    }

    public void w(int i3) {
        int skip;
        if (i3 >= 0) {
            int i16 = this.f388134g;
            int i17 = this.f388131d;
            int i18 = i16 + i17 + i3;
            int i19 = this.f388135h;
            if (i18 <= i19) {
                int i26 = this.f388129b;
                if (i3 <= i26 - i17) {
                    this.f388131d = i17 + i3;
                    return;
                }
                int i27 = i26 - i17;
                this.f388134g = i16 + i26;
                this.f388131d = 0;
                this.f388129b = 0;
                while (i27 < i3) {
                    InputStream inputStream = this.f388132e;
                    if (inputStream == null) {
                        skip = -1;
                    } else {
                        skip = (int) inputStream.skip(i3 - i27);
                    }
                    if (skip > 0) {
                        i27 += skip;
                        this.f388134g += skip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            w((i19 - i16) - i17);
            throw d.a();
        }
        throw d.b();
    }

    public int x() {
        int i3;
        byte a16 = a();
        if (a16 >= 0) {
            return a16;
        }
        int i16 = a16 & Byte.MAX_VALUE;
        byte a17 = a();
        if (a17 >= 0) {
            i3 = a17 << 7;
        } else {
            i16 |= (a17 & Byte.MAX_VALUE) << 7;
            byte a18 = a();
            if (a18 >= 0) {
                i3 = a18 << RegisterType.DOUBLE_LO;
            } else {
                i16 |= (a18 & Byte.MAX_VALUE) << 14;
                byte a19 = a();
                if (a19 >= 0) {
                    i3 = a19 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER;
                } else {
                    int i17 = i16 | ((a19 & Byte.MAX_VALUE) << 21);
                    byte a26 = a();
                    int i18 = i17 | (a26 << 28);
                    if (a26 < 0) {
                        for (int i19 = 0; i19 < 5; i19++) {
                            if (a() >= 0) {
                                return i18;
                            }
                        }
                        throw d.c();
                    }
                    return i18;
                }
            }
        }
        return i16 | i3;
    }

    public long y() {
        return ((a() & 255) << 8) | (a() & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    public int z() {
        return (a() & 255) | ((a() & 255) << 8) | ((a() & 255) << 16) | ((a() & 255) << 24);
    }

    ac(InputStream inputStream) {
        this.f388135h = Integer.MAX_VALUE;
        this.f388137j = 64;
        this.f388138k = 67108864;
        this.f388128a = new byte[4096];
        this.f388129b = 0;
        this.f388131d = 0;
        this.f388132e = inputStream;
    }
}
