package com.xingin.xhssharesdk.a;

import cooperation.qzone.QZoneHelper;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f389877a;

    /* renamed from: b, reason: collision with root package name */
    public int f389878b;

    /* renamed from: c, reason: collision with root package name */
    public int f389879c;

    /* renamed from: d, reason: collision with root package name */
    public int f389880d;

    /* renamed from: e, reason: collision with root package name */
    public int f389881e;

    /* renamed from: f, reason: collision with root package name */
    public int f389882f;

    /* renamed from: g, reason: collision with root package name */
    public int f389883g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public int f389884h;

    public c(byte[] bArr, int i3, int i16, boolean z16) {
        this.f389877a = bArr;
        this.f389878b = i16 + i3;
        this.f389880d = i3;
        this.f389882f = -i3;
    }

    public final int a() {
        int i3 = this.f389880d;
        if (this.f389878b - i3 >= 4) {
            byte[] bArr = this.f389877a;
            this.f389880d = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }
        l(4);
        throw m.b();
    }

    public final void b(int i3) {
        if (this.f389881e == i3) {
        } else {
            throw new m("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final int c(int i3) {
        if (i3 >= 0) {
            int i16 = this.f389882f + this.f389880d + i3;
            int i17 = this.f389883g;
            if (i16 <= i17) {
                this.f389883g = i16;
                m();
                return i17;
            }
            throw m.b();
        }
        throw new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final long d() {
        int i3 = this.f389880d;
        if (this.f389878b - i3 >= 8) {
            byte[] bArr = this.f389877a;
            this.f389880d = i3 + 8;
            return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
        }
        l(8);
        throw m.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
    
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e() {
        int i3;
        int i16 = this.f389880d;
        int i17 = this.f389878b;
        if (i17 != i16) {
            byte[] bArr = this.f389877a;
            int i18 = i16 + 1;
            byte b16 = bArr[i16];
            if (b16 >= 0) {
                this.f389880d = i18;
                return b16;
            }
            if (i17 - i18 >= 9) {
                int i19 = i18 + 1;
                int i26 = b16 ^ (bArr[i18] << 7);
                if (i26 < 0) {
                    i3 = i26 ^ (-128);
                } else {
                    int i27 = i19 + 1;
                    int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                    if (i28 >= 0) {
                        i3 = i28 ^ 16256;
                    } else {
                        i19 = i27 + 1;
                        int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                        if (i29 < 0) {
                            i3 = i29 ^ (-2080896);
                        } else {
                            i27 = i19 + 1;
                            byte b17 = bArr[i19];
                            i3 = (i29 ^ (b17 << 28)) ^ 266354560;
                            if (b17 < 0) {
                                i19 = i27 + 1;
                                if (bArr[i27] < 0) {
                                    i27 = i19 + 1;
                                    if (bArr[i19] < 0) {
                                        i19 = i27 + 1;
                                        if (bArr[i27] < 0) {
                                            i27 = i19 + 1;
                                            if (bArr[i19] < 0) {
                                                i19 = i27 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i19 = i27;
                }
                this.f389880d = i19;
                return i3;
            }
        }
        long j3 = 0;
        for (int i36 = 0; i36 < 64; i36 += 7) {
            int i37 = this.f389880d;
            if (i37 != this.f389878b) {
                byte[] bArr2 = this.f389877a;
                this.f389880d = i37 + 1;
                j3 |= (r3 & Byte.MAX_VALUE) << i36;
                if ((bArr2[i37] & 128) == 0) {
                    return (int) j3;
                }
            } else {
                l(1);
                throw m.b();
            }
        }
        throw new m("CodedInputStream encountered a malformed varint.");
    }

    public final byte[] f(int i3) {
        if (i3 <= 0) {
            if (i3 == 0) {
                return f.f389912b;
            }
            throw new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i16 = this.f389882f;
        int i17 = this.f389880d;
        int i18 = i16 + i17 + i3;
        if (i18 <= 67108864) {
            int i19 = this.f389883g;
            if (i18 <= i19) {
                throw m.b();
            }
            j((i19 - i16) - i17);
            throw m.b();
        }
        throw new m("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b3, code lost:
    
        if (r4[r0] < 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long g() {
        long j3;
        long j16;
        long j17;
        int i3;
        int i16 = this.f389880d;
        int i17 = this.f389878b;
        long j18 = 0;
        if (i17 != i16) {
            byte[] bArr = this.f389877a;
            int i18 = i16 + 1;
            byte b16 = bArr[i16];
            if (b16 >= 0) {
                this.f389880d = i18;
                return b16;
            }
            if (i17 - i18 >= 9) {
                int i19 = i18 + 1;
                int i26 = b16 ^ (bArr[i18] << 7);
                if (i26 < 0) {
                    i3 = i26 ^ (-128);
                } else {
                    int i27 = i19 + 1;
                    int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                    if (i28 >= 0) {
                        j3 = i28 ^ 16256;
                        i19 = i27;
                    } else {
                        i19 = i27 + 1;
                        int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                        if (i29 < 0) {
                            i3 = i29 ^ (-2080896);
                        } else {
                            long j19 = i29;
                            int i36 = i19 + 1;
                            long j26 = j19 ^ (bArr[i19] << 28);
                            if (j26 >= 0) {
                                j17 = 266354560;
                            } else {
                                i19 = i36 + 1;
                                long j27 = j26 ^ (bArr[i36] << 35);
                                if (j27 < 0) {
                                    j16 = -34093383808L;
                                } else {
                                    i36 = i19 + 1;
                                    j26 = j27 ^ (bArr[i19] << 42);
                                    if (j26 >= 0) {
                                        j17 = 4363953127296L;
                                    } else {
                                        i19 = i36 + 1;
                                        j27 = j26 ^ (bArr[i36] << 49);
                                        if (j27 < 0) {
                                            j16 = -558586000294016L;
                                        } else {
                                            int i37 = i19 + 1;
                                            long j28 = (j27 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                            if (j28 < 0) {
                                                i19 = i37 + 1;
                                            } else {
                                                i19 = i37;
                                            }
                                            j3 = j28;
                                        }
                                    }
                                }
                                j3 = j16 ^ j27;
                            }
                            j3 = j26 ^ j17;
                            i19 = i36;
                        }
                    }
                    this.f389880d = i19;
                    return j3;
                }
                j3 = i3;
                this.f389880d = i19;
                return j3;
            }
        }
        for (int i38 = 0; i38 < 64; i38 += 7) {
            int i39 = this.f389880d;
            if (i39 != this.f389878b) {
                byte[] bArr2 = this.f389877a;
                this.f389880d = i39 + 1;
                j18 |= (r1 & Byte.MAX_VALUE) << i38;
                if ((bArr2[i39] & 128) == 0) {
                    return j18;
                }
            } else {
                l(1);
                throw m.b();
            }
        }
        throw new m("CodedInputStream encountered a malformed varint.");
    }

    public final boolean h(int i3) {
        int i16;
        int k3;
        int i17 = i3 & 7;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 3) {
                        if (i17 == 4) {
                            return false;
                        }
                        if (i17 == 5) {
                            j(4);
                            return true;
                        }
                        throw new m("Protocol message tag had invalid wire type.");
                    }
                    do {
                        k3 = k();
                        if (k3 == 0) {
                            break;
                        }
                    } while (h(k3));
                    if (this.f389881e == c0.a(i3 >>> 3, 4)) {
                        return true;
                    }
                    throw new m("Protocol message end-group tag did not match expected tag.");
                }
                i16 = e();
            } else {
                i16 = 8;
            }
            j(i16);
            return true;
        }
        int i18 = this.f389878b;
        int i19 = this.f389880d;
        if (i18 - i19 >= 10) {
            byte[] bArr = this.f389877a;
            int i26 = 0;
            while (i26 < 10) {
                int i27 = i19 + 1;
                if (bArr[i19] >= 0) {
                    this.f389880d = i27;
                    break;
                }
                i26++;
                i19 = i27;
            }
        }
        for (int i28 = 0; i28 < 10; i28++) {
            int i29 = this.f389880d;
            if (i29 != this.f389878b) {
                byte[] bArr2 = this.f389877a;
                this.f389880d = i29 + 1;
                if (bArr2[i29] >= 0) {
                    return true;
                }
            } else {
                l(1);
                throw m.b();
            }
        }
        throw new m("CodedInputStream encountered a malformed varint.");
    }

    public final String i() {
        byte[] f16;
        int e16 = e();
        int i3 = this.f389880d;
        int i16 = this.f389878b;
        if (e16 <= i16 - i3 && e16 > 0) {
            f16 = this.f389877a;
            this.f389880d = i3 + e16;
        } else {
            if (e16 == 0) {
                return "";
            }
            if (e16 > i16) {
                f16 = f(e16);
                i3 = 0;
            } else {
                l(e16);
                throw m.b();
            }
        }
        if (b0.d(f16, i3, i3 + e16)) {
            return new String(f16, i3, e16, f.f389911a);
        }
        throw new m("Protocol message had invalid UTF-8.");
    }

    public final void j(int i3) {
        int i16 = this.f389878b;
        int i17 = this.f389880d;
        if (i3 <= i16 - i17 && i3 >= 0) {
            this.f389880d = i17 + i3;
            return;
        }
        if (i3 >= 0) {
            int i18 = this.f389882f;
            int i19 = i18 + i17 + i3;
            int i26 = this.f389883g;
            if (i19 > i26) {
                j((i26 - i18) - i17);
                throw m.b();
            }
            this.f389880d = i16;
            l(1);
            throw m.b();
        }
        throw new m("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final int k() {
        boolean z16;
        if (this.f389880d == this.f389878b) {
            z16 = true;
            l(1);
        } else {
            z16 = false;
        }
        if (z16) {
            this.f389881e = 0;
            return 0;
        }
        int e16 = e();
        this.f389881e = e16;
        if ((e16 >>> 3) != 0) {
            return e16;
        }
        throw new m("Protocol message contained an invalid tag (zero).");
    }

    public final void l(int i3) {
        if (this.f389880d + i3 > this.f389878b) {
            return;
        }
        throw new IllegalStateException("refillBuffer() called when " + i3 + " bytes were already available in buffer");
    }

    public final void m() {
        int i3 = this.f389878b + this.f389879c;
        this.f389878b = i3;
        int i16 = this.f389882f + i3;
        int i17 = this.f389883g;
        if (i16 > i17) {
            int i18 = i16 - i17;
            this.f389879c = i18;
            this.f389878b = i3 - i18;
            return;
        }
        this.f389879c = 0;
    }
}
