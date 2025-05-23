package com.xingin.xhssharesdk.a;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f389876a;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a {
        public abstract int a(CharSequence charSequence, byte[] bArr, int i3, int i16);

        public abstract int b(byte[] bArr, int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class b extends a {
        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.xingin.xhssharesdk.a.b0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int a(CharSequence charSequence, byte[] bArr, int i3, int i16) {
            int i17;
            int i18;
            int i19;
            char charAt;
            int length = charSequence.length();
            int i26 = i16 + i3;
            int i27 = 0;
            while (i27 < length && (i19 = i27 + i3) < i26 && (charAt = charSequence.charAt(i27)) < '\u0080') {
                bArr[i19] = (byte) charAt;
                i27++;
            }
            int i28 = i3 + i27;
            while (i27 < length) {
                char charAt2 = charSequence.charAt(i27);
                if (charAt2 < '\u0080' && i28 < i26) {
                    i17 = i28 + 1;
                    bArr[i28] = (byte) charAt2;
                } else {
                    if (charAt2 < '\u0800' && i28 <= i26 - 2) {
                        int i29 = i28 + 1;
                        bArr[i28] = (byte) ((charAt2 >>> 6) | 960);
                        i28 = i29 + 1;
                        bArr[i29] = (byte) ((charAt2 & '?') | 128);
                    } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && i28 <= i26 - 3) {
                        int i36 = i28 + 1;
                        bArr[i28] = (byte) ((charAt2 >>> '\f') | 480);
                        int i37 = i36 + 1;
                        bArr[i36] = (byte) (((charAt2 >>> 6) & 63) | 128);
                        i17 = i37 + 1;
                        bArr[i37] = (byte) ((charAt2 & '?') | 128);
                    } else {
                        if (i28 <= i26 - 4) {
                            int i38 = i27 + 1;
                            if (i38 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i38);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i39 = i28 + 1;
                                    bArr[i28] = (byte) ((codePoint >>> 18) | 240);
                                    int i46 = i39 + 1;
                                    bArr[i39] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i47 = i46 + 1;
                                    bArr[i46] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i28 = i47 + 1;
                                    bArr[i47] = (byte) ((codePoint & 63) | 128);
                                    i27 = i38;
                                } else {
                                    i27 = i38;
                                }
                            }
                            throw new c(i27 - 1, length);
                        }
                        if ('\ud800' <= charAt2 && charAt2 <= '\udfff' && ((i18 = i27 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i18)))) {
                            throw new c(i27, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i28);
                    }
                    i27++;
                }
                i28 = i17;
                i27++;
            }
            return i28;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x009f, code lost:
        
            if (r9 > (-12)) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x005d, code lost:
        
            if (r9 > (-12)) goto L66;
         */
        @Override // com.xingin.xhssharesdk.a.b0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int b(byte[] bArr, int i3, int i16) {
            while (i3 < i16 && bArr[i3] >= 0) {
                i3++;
            }
            if (i3 < i16) {
                while (i3 < i16) {
                    int i17 = i3 + 1;
                    byte b16 = bArr[i3];
                    if (b16 < 0) {
                        if (b16 < -32) {
                            if (i17 >= i16) {
                                return b16;
                            }
                            if (b16 >= -62) {
                                i3 = i17 + 1;
                                if (bArr[i17] > -65) {
                                }
                            }
                            return -1;
                        }
                        if (b16 < -16) {
                            if (i17 >= i16 - 1) {
                                b16 = bArr[i17 - 1];
                                int i18 = i16 - i17;
                                if (i18 != 0) {
                                    if (i18 != 1) {
                                        if (i18 == 2) {
                                            return b0.b(b16, bArr[i17], bArr[i17 + 1]);
                                        }
                                        throw new AssertionError();
                                    }
                                    return b0.a(b16, bArr[i17]);
                                }
                            } else {
                                int i19 = i17 + 1;
                                byte b17 = bArr[i17];
                                if (b17 <= -65 && ((b16 != -32 || b17 >= -96) && (b16 != -19 || b17 < -96))) {
                                    i3 = i19 + 1;
                                    if (bArr[i19] > -65) {
                                    }
                                }
                            }
                            return -1;
                        }
                        if (i17 >= i16 - 2) {
                            b16 = bArr[i17 - 1];
                            int i26 = i16 - i17;
                            if (i26 != 0) {
                                if (i26 != 1) {
                                    if (i26 == 2) {
                                        return b0.b(b16, bArr[i17], bArr[i17 + 1]);
                                    }
                                    throw new AssertionError();
                                }
                                return b0.a(b16, bArr[i17]);
                            }
                        } else {
                            int i27 = i17 + 1;
                            byte b18 = bArr[i17];
                            if (b18 <= -65) {
                                if ((((b18 + PublicAccountH5AbilityPluginImpl.OPENCAMERA) + (b16 << 28)) >> 30) == 0) {
                                    int i28 = i27 + 1;
                                    if (bArr[i27] <= -65) {
                                        i17 = i28 + 1;
                                        if (bArr[i28] > -65) {
                                        }
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    i3 = i17;
                }
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class c extends IllegalArgumentException {
        public c(int i3, int i16) {
            super("Unpaired surrogate at index " + i3 + " of " + i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class d extends a {
        @Override // com.xingin.xhssharesdk.a.b0.a
        public final int a(CharSequence charSequence, byte[] bArr, int i3, int i16) {
            char c16;
            long j3;
            long j16;
            long j17;
            long j18;
            char c17;
            int i17;
            char charAt;
            long j19 = nz4.a.f421643d + i3;
            long j26 = i16 + j19;
            int length = charSequence.length();
            if (length <= i16 && bArr.length - i16 >= i3) {
                int i18 = 0;
                while (true) {
                    c16 = '\u0080';
                    j3 = 1;
                    if (i18 >= length || (charAt = charSequence.charAt(i18)) >= '\u0080') {
                        break;
                    }
                    nz4.a.d(bArr, j19, (byte) charAt);
                    i18++;
                    j19 = 1 + j19;
                }
                if (i18 == length) {
                    j16 = nz4.a.f421643d;
                } else {
                    while (i18 < length) {
                        char charAt2 = charSequence.charAt(i18);
                        if (charAt2 < c16 && j19 < j26) {
                            long j27 = j19 + j3;
                            nz4.a.d(bArr, j19, (byte) charAt2);
                            j18 = j3;
                            j17 = j27;
                            c17 = c16;
                        } else if (charAt2 < '\u0800' && j19 <= j26 - 2) {
                            long j28 = j19 + j3;
                            nz4.a.d(bArr, j19, (byte) ((charAt2 >>> 6) | 960));
                            long j29 = j28 + j3;
                            nz4.a.d(bArr, j28, (byte) ((charAt2 & '?') | 128));
                            long j36 = j3;
                            c17 = '\u0080';
                            j17 = j29;
                            j18 = j36;
                        } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && j19 <= j26 - 3) {
                            long j37 = j19 + j3;
                            nz4.a.d(bArr, j19, (byte) ((charAt2 >>> '\f') | 480));
                            long j38 = j37 + j3;
                            nz4.a.d(bArr, j37, (byte) (((charAt2 >>> 6) & 63) | 128));
                            nz4.a.d(bArr, j38, (byte) ((charAt2 & '?') | 128));
                            j17 = j38 + 1;
                            j18 = 1;
                            c17 = '\u0080';
                        } else {
                            if (j19 <= j26 - 4) {
                                int i19 = i18 + 1;
                                if (i19 != length) {
                                    char charAt3 = charSequence.charAt(i19);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        long j39 = j19 + 1;
                                        nz4.a.d(bArr, j19, (byte) ((codePoint >>> 18) | 240));
                                        long j46 = j39 + 1;
                                        c17 = '\u0080';
                                        nz4.a.d(bArr, j39, (byte) (((codePoint >>> 12) & 63) | 128));
                                        long j47 = j46 + 1;
                                        nz4.a.d(bArr, j46, (byte) (((codePoint >>> 6) & 63) | 128));
                                        j18 = 1;
                                        j17 = j47 + 1;
                                        nz4.a.d(bArr, j47, (byte) ((codePoint & 63) | 128));
                                        i18 = i19;
                                    } else {
                                        i18 = i19;
                                    }
                                }
                                throw new c(i18 - 1, length);
                            }
                            if ('\ud800' <= charAt2 && charAt2 <= '\udfff' && ((i17 = i18 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i17)))) {
                                throw new c(i18, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j19);
                        }
                        i18++;
                        c16 = c17;
                        long j48 = j18;
                        j19 = j17;
                        j3 = j48;
                    }
                    j16 = nz4.a.f421643d;
                }
                return (int) (j19 - j16);
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i3 + i16));
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x010b, code lost:
        
            if (r2 > (-12)) goto L83;
         */
        /* JADX WARN: Code restructure failed: missing block: B:80:0x00c1, code lost:
        
            if (r2 > (-12)) goto L83;
         */
        @Override // com.xingin.xhssharesdk.a.b0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int b(byte[] bArr, int i3, int i16) {
            int i17;
            byte b16;
            if ((i3 | i16 | (bArr.length - i16)) >= 0) {
                long j3 = nz4.a.f421643d;
                long j16 = i3 + j3;
                int i18 = (int) ((j3 + i16) - j16);
                if (i18 < 16) {
                    i17 = 0;
                } else {
                    int i19 = ((int) j16) & 7;
                    int i26 = i19;
                    long j17 = j16;
                    while (true) {
                        if (i26 > 0) {
                            long j18 = j17 + 1;
                            if (nz4.a.a(bArr, j17) < 0) {
                                i17 = i19 - i26;
                                break;
                            }
                            i26--;
                            j17 = j18;
                        } else {
                            int i27 = i18 - i19;
                            while (i27 >= 8 && (nz4.a.e(bArr, j17) & (-9187201950435737472L)) == 0) {
                                j17 += 8;
                                i27 -= 8;
                            }
                            i17 = i18 - i27;
                        }
                    }
                }
                int i28 = i18 - i17;
                long j19 = j16 + i17;
                while (true) {
                    b16 = 0;
                    while (true) {
                        if (i28 <= 0) {
                            break;
                        }
                        long j26 = j19 + 1;
                        byte a16 = nz4.a.a(bArr, j19);
                        if (a16 >= 0) {
                            i28--;
                            b16 = a16;
                            j19 = j26;
                        } else {
                            b16 = a16;
                            j19 = j26;
                            break;
                        }
                    }
                    if (i28 == 0) {
                        return 0;
                    }
                    int i29 = i28 - 1;
                    if (b16 < -32) {
                        if (i29 != 0) {
                            i28 = i29 - 1;
                            if (b16 < -62) {
                                break;
                            }
                            long j27 = j19 + 1;
                            if (nz4.a.a(bArr, j19) > -65) {
                                break;
                            }
                            j19 = j27;
                        } else {
                            break;
                        }
                    } else if (b16 < -16) {
                        if (i29 < 2) {
                            if (i29 != 0) {
                                if (i29 != 1) {
                                    if (i29 == 2) {
                                        return b0.b(b16, nz4.a.a(bArr, j19), nz4.a.a(bArr, j19 + 1));
                                    }
                                    throw new AssertionError();
                                }
                                return b0.a(b16, nz4.a.a(bArr, j19));
                            }
                            a aVar = b0.f389876a;
                        } else {
                            i28 = i29 - 2;
                            long j28 = j19 + 1;
                            byte a17 = nz4.a.a(bArr, j19);
                            if (a17 > -65 || ((b16 == -32 && a17 < -96) || (b16 == -19 && a17 >= -96))) {
                                break;
                            }
                            j19 = j28 + 1;
                            if (nz4.a.a(bArr, j28) > -65) {
                                break;
                            }
                        }
                    } else if (i29 < 3) {
                        if (i29 != 0) {
                            if (i29 != 1) {
                                if (i29 == 2) {
                                    return b0.b(b16, nz4.a.a(bArr, j19), nz4.a.a(bArr, j19 + 1));
                                }
                                throw new AssertionError();
                            }
                            return b0.a(b16, nz4.a.a(bArr, j19));
                        }
                        a aVar2 = b0.f389876a;
                    } else {
                        i28 = i29 - 3;
                        long j29 = j19 + 1;
                        byte a18 = nz4.a.a(bArr, j19);
                        if (a18 > -65 || (((a18 + PublicAccountH5AbilityPluginImpl.OPENCAMERA) + (b16 << 28)) >> 30) != 0) {
                            break;
                        }
                        long j36 = j29 + 1;
                        if (nz4.a.a(bArr, j29) > -65) {
                            break;
                        }
                        j19 = j36 + 1;
                        if (nz4.a.a(bArr, j36) > -65) {
                            break;
                        }
                    }
                }
                return b16;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i16)));
        }
    }

    static {
        boolean z16;
        a bVar;
        if (nz4.a.f421642c && nz4.a.f421641b) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bVar = new d();
        } else {
            bVar = new b();
        }
        f389876a = bVar;
    }

    public static int a(int i3, int i16) {
        if (i3 <= -12 && i16 <= -65) {
            return i3 ^ (i16 << 8);
        }
        return -1;
    }

    public static int b(int i3, int i16, int i17) {
        if (i3 <= -12 && i16 <= -65 && i17 <= -65) {
            return (i3 ^ (i16 << 8)) ^ (i17 << 16);
        }
        return -1;
    }

    public static int c(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        int i16 = 0;
        while (i16 < length && charSequence.charAt(i16) < '\u0080') {
            i16++;
        }
        int i17 = length;
        while (true) {
            if (i16 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i16);
            if (charAt < '\u0800') {
                i17 += ('\u007f' - charAt) >>> 31;
                i16++;
            } else {
                int length2 = charSequence.length();
                while (i16 < length2) {
                    char charAt2 = charSequence.charAt(i16);
                    if (charAt2 < '\u0800') {
                        i3 += ('\u007f' - charAt2) >>> 31;
                    } else {
                        i3 += 2;
                        if ('\ud800' <= charAt2 && charAt2 <= '\udfff') {
                            if (Character.codePointAt(charSequence, i16) >= 65536) {
                                i16++;
                            } else {
                                throw new c(i16, length2);
                            }
                        }
                    }
                    i16++;
                }
                i17 += i3;
            }
        }
        if (i17 >= length) {
            return i17;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i17 + 4294967296L));
    }

    public static boolean d(byte[] bArr, int i3, int i16) {
        if (f389876a.b(bArr, i3, i16) == 0) {
            return true;
        }
        return false;
    }
}
