package com.tencent.luggage.wxa.kr;

import com.tencent.luggage.wxa.fn.c;
import cooperation.qzone.QZoneHelper;
import java.io.InputStream;
import java.util.LinkedList;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f132744a;

    /* renamed from: b, reason: collision with root package name */
    public int f132745b;

    /* renamed from: d, reason: collision with root package name */
    public int f132747d;

    /* renamed from: c, reason: collision with root package name */
    public int f132746c = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f132749f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f132750g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f132751h = Integer.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    public int f132752i = 67108864;

    /* renamed from: e, reason: collision with root package name */
    public InputStream f132748e = null;

    public a(byte[] bArr, int i3, int i16) {
        this.f132744a = bArr;
        this.f132745b = i16 + i3;
        this.f132747d = i3;
    }

    public static a a(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public LinkedList b(int i3) {
        LinkedList linkedList = new LinkedList();
        int j3 = j();
        try {
            byte[] bArr = new byte[j3];
            System.arraycopy(this.f132744a, this.f132747d, bArr, 0, j3);
            linkedList.add(bArr);
            int i16 = this.f132747d + j3;
            this.f132747d = i16;
            if (i16 == this.f132745b) {
                return linkedList;
            }
            int[] a16 = a(i16);
            int i17 = a16[0];
            while (com.tencent.luggage.wxa.jr.a.a(i17) == i3) {
                this.f132747d = a16[1];
                int j16 = j();
                byte[] bArr2 = new byte[j16];
                System.arraycopy(this.f132744a, this.f132747d, bArr2, 0, j16);
                linkedList.add(bArr2);
                int i18 = this.f132747d + j16;
                this.f132747d = i18;
                if (i18 == this.f132745b) {
                    break;
                }
                a16 = a(i18);
                i17 = a16[0];
            }
            return linkedList;
        } catch (OutOfMemoryError unused) {
            throw new OutOfMemoryError("alloc bytes:" + j3);
        }
    }

    public double c() {
        return Double.longBitsToDouble(i());
    }

    public float d() {
        return Float.intBitsToFloat(h());
    }

    public int e() {
        return j();
    }

    public long f() {
        return k();
    }

    public final byte g() {
        if (this.f132747d == this.f132745b) {
            a(true);
        }
        byte[] bArr = this.f132744a;
        int i3 = this.f132747d;
        this.f132747d = i3 + 1;
        return bArr[i3];
    }

    public int h() {
        return (g() & 255) | ((g() & 255) << 8) | ((g() & 255) << 16) | ((g() & 255) << 24);
    }

    public long i() {
        return ((g() & 255) << 8) | (g() & 255) | ((g() & 255) << 16) | ((g() & 255) << 24) | ((g() & 255) << 32) | ((g() & 255) << 40) | ((g() & 255) << 48) | ((g() & 255) << 56);
    }

    public final int j() {
        int i3;
        byte g16 = g();
        if (g16 >= 0) {
            return g16;
        }
        int i16 = g16 & Byte.MAX_VALUE;
        byte g17 = g();
        if (g17 >= 0) {
            i3 = g17 << 7;
        } else {
            i16 |= (g17 & Byte.MAX_VALUE) << 7;
            byte g18 = g();
            if (g18 >= 0) {
                i3 = g18 << RegisterType.DOUBLE_LO;
            } else {
                i16 |= (g18 & Byte.MAX_VALUE) << 14;
                byte g19 = g();
                if (g19 >= 0) {
                    i3 = g19 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER;
                } else {
                    int i17 = i16 | ((g19 & Byte.MAX_VALUE) << 21);
                    byte g26 = g();
                    int i18 = i17 | (g26 << 28);
                    if (g26 < 0) {
                        for (int i19 = 0; i19 < 5; i19++) {
                            if (g() >= 0) {
                                return i18;
                            }
                        }
                        throw b.b();
                    }
                    return i18;
                }
            }
        }
        return i16 | i3;
    }

    public long k() {
        long j3 = 0;
        for (int i3 = 0; i3 < 64; i3 += 7) {
            j3 |= (r3 & Byte.MAX_VALUE) << i3;
            if ((g() & 128) == 0) {
                return j3;
            }
        }
        throw b.b();
    }

    public String l() {
        int j3 = j();
        int i3 = this.f132745b;
        int i16 = this.f132747d;
        if (j3 < i3 - i16 && j3 > 0) {
            String str = new String(this.f132744a, i16, j3, "UTF-8");
            this.f132747d += j3;
            return str;
        }
        return new String(d(j3), "UTF-8");
    }

    public int m() {
        if (this.f132747d == this.f132745b && !a(false)) {
            this.f132749f = 0;
            return 0;
        }
        int j3 = j();
        this.f132749f = j3;
        if (j3 != 0) {
            return j3;
        }
        throw b.a();
    }

    public final void n() {
        int i3 = this.f132745b + this.f132746c;
        this.f132745b = i3;
        int i16 = this.f132750g + i3;
        int i17 = this.f132751h;
        if (i16 > i17) {
            int i18 = i16 - i17;
            this.f132746c = i18;
            this.f132745b = i3 - i18;
            return;
        }
        this.f132746c = 0;
    }

    public boolean a() {
        return j() != 0;
    }

    public final byte c(int i3) {
        return this.f132744a[i3];
    }

    public final byte[] d(int i3) {
        if (i3 >= 0) {
            int i16 = this.f132750g;
            int i17 = this.f132747d;
            int i18 = i16 + i17 + i3;
            int i19 = this.f132751h;
            if (i18 <= i19) {
                int i26 = this.f132745b;
                int i27 = i26 - i17;
                if (i3 <= i27) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(this.f132744a, i17, bArr, 0, i3);
                    this.f132747d += i3;
                    return bArr;
                }
                if (i3 < 2048) {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(this.f132744a, i17, bArr2, 0, i27);
                    this.f132747d = this.f132745b;
                    a(true);
                    while (true) {
                        int i28 = i3 - i27;
                        int i29 = this.f132745b;
                        if (i28 > i29) {
                            System.arraycopy(this.f132744a, 0, bArr2, i27, i29);
                            int i36 = this.f132745b;
                            i27 += i36;
                            this.f132747d = i36;
                            a(true);
                        } else {
                            System.arraycopy(this.f132744a, 0, bArr2, i27, i28);
                            this.f132747d = i28;
                            return bArr2;
                        }
                    }
                } else {
                    this.f132750g = i16 + i26;
                    this.f132747d = 0;
                    this.f132745b = 0;
                    int i37 = i3 - i27;
                    LinkedList linkedList = new LinkedList();
                    while (i37 > 0) {
                        int min = Math.min(i37, 2048);
                        byte[] bArr3 = new byte[min];
                        int i38 = 0;
                        while (i38 < min) {
                            InputStream inputStream = this.f132748e;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i38, min - i38);
                            if (read == -1) {
                                throw b.e();
                            }
                            this.f132750g += read;
                            i38 += read;
                        }
                        i37 -= min;
                        linkedList.add(bArr3);
                    }
                    byte[] bArr4 = new byte[i3];
                    System.arraycopy(this.f132744a, i17, bArr4, 0, i27);
                    for (int i39 = 0; i39 < linkedList.size(); i39++) {
                        byte[] bArr5 = (byte[]) linkedList.get(i39);
                        System.arraycopy(bArr5, 0, bArr4, i27, bArr5.length);
                        i27 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                e((i19 - i16) - i17);
                throw b.e();
            }
        } else {
            throw b.c();
        }
    }

    public final void e(int i3) {
        if (i3 >= 0) {
            int i16 = this.f132750g;
            int i17 = this.f132747d;
            int i18 = i16 + i17 + i3;
            int i19 = this.f132751h;
            if (i18 <= i19) {
                int i26 = this.f132745b - i17;
                if (i3 < i26) {
                    this.f132747d = i17 + i3;
                    return;
                }
                this.f132750g = i16 + i26;
                this.f132747d = 0;
                this.f132745b = 0;
                while (i26 < i3) {
                    InputStream inputStream = this.f132748e;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip(i3 - i26);
                    if (skip > 0) {
                        i26 += skip;
                        this.f132750g += skip;
                    } else {
                        throw b.e();
                    }
                }
                return;
            }
            e((i19 - i16) - i17);
            throw b.e();
        }
        throw b.c();
    }

    public final int[] a(int i3) {
        int i16;
        int i17;
        int i18;
        byte c16 = c(i3);
        int i19 = i3 + 1;
        if (c16 >= 0) {
            return new int[]{c16, i19};
        }
        int i26 = c16 & Byte.MAX_VALUE;
        byte c17 = c(i19);
        if (c17 >= 0) {
            i17 = i19 + 1;
            i18 = c17 << 7;
        } else {
            i26 |= (c17 & Byte.MAX_VALUE) << 7;
            byte c18 = c(i19);
            if (c18 >= 0) {
                i17 = i19 + 1;
                i18 = c18 << RegisterType.DOUBLE_LO;
            } else {
                i26 |= (c18 & Byte.MAX_VALUE) << 14;
                byte c19 = c(i19);
                if (c19 < 0) {
                    int i27 = i26 | ((c19 & Byte.MAX_VALUE) << 21);
                    byte c26 = c(i19);
                    i16 = i27 | (c26 << 28);
                    i17 = i19 + 1;
                    if (c26 < 0) {
                        for (int i28 = 0; i28 < 5; i28++) {
                            if (c(i17) >= 0) {
                                return new int[]{c26, i17 + 1};
                            }
                        }
                        throw b.b();
                    }
                    return new int[]{i16, i17};
                }
                i17 = i19 + 1;
                i18 = c19 << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER;
            }
        }
        i16 = i26 | i18;
        return new int[]{i16, i17};
    }

    public final boolean a(boolean z16) {
        int i3 = this.f132747d;
        int i16 = this.f132745b;
        if (i3 >= i16) {
            int i17 = this.f132750g + i16;
            if (i17 == this.f132751h) {
                if (z16) {
                    throw b.e();
                }
                return false;
            }
            this.f132750g = i17;
            this.f132747d = 0;
            InputStream inputStream = this.f132748e;
            int read = inputStream == null ? -1 : inputStream.read(this.f132744a);
            this.f132745b = read;
            if (read == -1) {
                this.f132745b = 0;
                if (z16) {
                    throw b.e();
                }
                return false;
            }
            n();
            int i18 = this.f132750g + this.f132745b + this.f132746c;
            if (i18 > this.f132752i || i18 < 0) {
                throw b.d();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public c b() {
        int j3 = j();
        int i3 = this.f132745b;
        int i16 = this.f132747d;
        if (j3 < i3 - i16 && j3 > 0) {
            c a16 = c.a(this.f132744a, i16, j3);
            this.f132747d += j3;
            return a16;
        }
        return c.a(d(j3));
    }
}
