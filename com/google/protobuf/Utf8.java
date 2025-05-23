package com.google.protobuf;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import java.nio.ByteBuffer;
import org.jf.dexlib2.analysis.RegisterType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class Utf8 {

    /* renamed from: a, reason: collision with root package name */
    private static final b f35626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i3, int i16) {
            super("Unpaired surrogate at index " + i3 + " of " + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b16, byte b17, byte b18, byte b19, char[] cArr, int i3) throws InvalidProtocolBufferException {
            if (!m(b17) && (((b16 << 28) + (b17 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0 && !m(b18) && !m(b19)) {
                int r16 = ((b16 & 7) << 18) | (r(b17) << 12) | (r(b18) << 6) | r(b19);
                cArr[i3] = l(r16);
                cArr[i3 + 1] = q(r16);
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b16, char[] cArr, int i3) {
            cArr[i3] = (char) b16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b16, byte b17, byte b18, char[] cArr, int i3) throws InvalidProtocolBufferException {
            if (!m(b17) && ((b16 != -32 || b17 >= -96) && ((b16 != -19 || b17 < -96) && !m(b18)))) {
                cArr[i3] = (char) (((b16 & RegisterType.DOUBLE_HI) << 12) | (r(b17) << 6) | r(b18));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b16, byte b17, char[] cArr, int i3) throws InvalidProtocolBufferException {
            if (b16 >= -62 && !m(b17)) {
                cArr[i3] = (char) (((b16 & 31) << 6) | r(b17));
                return;
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        private static char l(int i3) {
            return (char) ((i3 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean m(byte b16) {
            if (b16 > -65) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b16) {
            if (b16 >= 0) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b16) {
            if (b16 < -16) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b16) {
            if (b16 < -32) {
                return true;
            }
            return false;
        }

        private static char q(int i3) {
            return (char) ((i3 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int r(byte b16) {
            return b16 & 63;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b {
        b() {
        }

        private static int j(ByteBuffer byteBuffer, int i3, int i16) {
            int l3 = i3 + Utf8.l(byteBuffer, i3, i16);
            while (l3 < i16) {
                int i17 = l3 + 1;
                byte b16 = byteBuffer.get(l3);
                if (b16 < 0) {
                    if (b16 < -32) {
                        if (i17 >= i16) {
                            return b16;
                        }
                        if (b16 < -62 || byteBuffer.get(i17) > -65) {
                            return -1;
                        }
                        i17++;
                    } else if (b16 < -16) {
                        if (i17 >= i16 - 1) {
                            return Utf8.p(byteBuffer, b16, i17, i16 - i17);
                        }
                        int i18 = i17 + 1;
                        byte b17 = byteBuffer.get(i17);
                        if (b17 > -65 || ((b16 == -32 && b17 < -96) || ((b16 == -19 && b17 >= -96) || byteBuffer.get(i18) > -65))) {
                            return -1;
                        }
                        l3 = i18 + 1;
                    } else {
                        if (i17 >= i16 - 2) {
                            return Utf8.p(byteBuffer, b16, i17, i16 - i17);
                        }
                        int i19 = i17 + 1;
                        byte b18 = byteBuffer.get(i17);
                        if (b18 <= -65 && (((b16 << 28) + (b18 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0) {
                            int i26 = i19 + 1;
                            if (byteBuffer.get(i19) <= -65) {
                                i17 = i26 + 1;
                                if (byteBuffer.get(i26) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                l3 = i17;
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i3, int i16) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i3, i16);
            }
            if (byteBuffer.isDirect()) {
                return d(byteBuffer, i3, i16);
            }
            return c(byteBuffer, i3, i16);
        }

        abstract String b(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException;

        final String c(ByteBuffer byteBuffer, int i3, int i16) throws InvalidProtocolBufferException {
            if ((i3 | i16 | ((byteBuffer.limit() - i3) - i16)) >= 0) {
                int i17 = i3 + i16;
                char[] cArr = new char[i16];
                int i18 = 0;
                while (i3 < i17) {
                    byte b16 = byteBuffer.get(i3);
                    if (!a.n(b16)) {
                        break;
                    }
                    i3++;
                    a.i(b16, cArr, i18);
                    i18++;
                }
                int i19 = i18;
                while (i3 < i17) {
                    int i26 = i3 + 1;
                    byte b17 = byteBuffer.get(i3);
                    if (a.n(b17)) {
                        int i27 = i19 + 1;
                        a.i(b17, cArr, i19);
                        while (i26 < i17) {
                            byte b18 = byteBuffer.get(i26);
                            if (!a.n(b18)) {
                                break;
                            }
                            i26++;
                            a.i(b18, cArr, i27);
                            i27++;
                        }
                        i3 = i26;
                        i19 = i27;
                    } else if (a.p(b17)) {
                        if (i26 < i17) {
                            a.k(b17, byteBuffer.get(i26), cArr, i19);
                            i3 = i26 + 1;
                            i19++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (a.o(b17)) {
                        if (i26 < i17 - 1) {
                            int i28 = i26 + 1;
                            a.j(b17, byteBuffer.get(i26), byteBuffer.get(i28), cArr, i19);
                            i3 = i28 + 1;
                            i19++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i26 < i17 - 2) {
                        int i29 = i26 + 1;
                        byte b19 = byteBuffer.get(i26);
                        int i36 = i29 + 1;
                        a.h(b17, b19, byteBuffer.get(i29), byteBuffer.get(i36), cArr, i19);
                        i3 = i36 + 1;
                        i19 = i19 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i19);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i3), Integer.valueOf(i16)));
        }

        abstract String d(ByteBuffer byteBuffer, int i3, int i16) throws InvalidProtocolBufferException;

        abstract int e(CharSequence charSequence, byte[] bArr, int i3, int i16);

        final boolean f(ByteBuffer byteBuffer, int i3, int i16) {
            if (h(0, byteBuffer, i3, i16) != 0) {
                return false;
            }
            return true;
        }

        final boolean g(byte[] bArr, int i3, int i16) {
            if (i(0, bArr, i3, i16) != 0) {
                return false;
            }
            return true;
        }

        final int h(int i3, ByteBuffer byteBuffer, int i16, int i17) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return i(i3, byteBuffer.array(), i16 + arrayOffset, arrayOffset + i17);
            }
            if (byteBuffer.isDirect()) {
                return l(i3, byteBuffer, i16, i17);
            }
            return k(i3, byteBuffer, i16, i17);
        }

        abstract int i(int i3, byte[] bArr, int i16, int i17);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        final int k(int i3, ByteBuffer byteBuffer, int i16, int i17) {
            byte b16;
            int i18;
            int i19;
            if (i3 != 0) {
                if (i16 >= i17) {
                    return i3;
                }
                byte b17 = (byte) i3;
                if (b17 < -32) {
                    if (b17 >= -62) {
                        i19 = i16 + 1;
                    }
                    return -1;
                }
                if (b17 < -16) {
                    byte b18 = (byte) (~(i3 >> 8));
                    if (b18 == 0) {
                        int i26 = i16 + 1;
                        byte b19 = byteBuffer.get(i16);
                        if (i26 >= i17) {
                            return Utf8.n(b17, b19);
                        }
                        i16 = i26;
                        b18 = b19;
                    }
                    if (b18 <= -65 && ((b17 != -32 || b18 >= -96) && (b17 != -19 || b18 < -96))) {
                        i19 = i16 + 1;
                    }
                    return -1;
                }
                byte b26 = (byte) (~(i3 >> 8));
                if (b26 == 0) {
                    i18 = i16 + 1;
                    b26 = byteBuffer.get(i16);
                    if (i18 >= i17) {
                        return Utf8.n(b17, b26);
                    }
                    b16 = 0;
                } else {
                    b16 = (byte) (i3 >> 16);
                    i18 = i16;
                }
                if (b16 == 0) {
                    int i27 = i18 + 1;
                    byte b27 = byteBuffer.get(i18);
                    if (i27 >= i17) {
                        return Utf8.o(b17, b26, b27);
                    }
                    b16 = b27;
                    i18 = i27;
                }
                if (b26 <= -65 && (((b17 << 28) + (b26 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0 && b16 <= -65) {
                    i16 = i18 + 1;
                }
                return -1;
                i16 = i19;
            }
            return j(byteBuffer, i16, i17);
        }

        abstract int l(int i3, ByteBuffer byteBuffer, int i16, int i17);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class c extends b {
        c() {
        }

        private static int m(byte[] bArr, int i3, int i16) {
            while (i3 < i16 && bArr[i3] >= 0) {
                i3++;
            }
            if (i3 >= i16) {
                return 0;
            }
            return n(bArr, i3, i16);
        }

        private static int n(byte[] bArr, int i3, int i16) {
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
                            return Utf8.q(bArr, i17, i16);
                        }
                        int i18 = i17 + 1;
                        byte b17 = bArr[i17];
                        if (b17 <= -65 && ((b16 != -32 || b17 >= -96) && (b16 != -19 || b17 < -96))) {
                            i3 = i18 + 1;
                            if (bArr[i18] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i17 >= i16 - 2) {
                        return Utf8.q(bArr, i17, i16);
                    }
                    int i19 = i17 + 1;
                    byte b18 = bArr[i17];
                    if (b18 <= -65 && (((b16 << 28) + (b18 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0) {
                        int i26 = i19 + 1;
                        if (bArr[i19] <= -65) {
                            i17 = i26 + 1;
                            if (bArr[i26] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                i3 = i17;
            }
            return 0;
        }

        @Override // com.google.protobuf.Utf8.b
        String b(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException {
            if ((i3 | i16 | ((bArr.length - i3) - i16)) >= 0) {
                int i17 = i3 + i16;
                char[] cArr = new char[i16];
                int i18 = 0;
                while (i3 < i17) {
                    byte b16 = bArr[i3];
                    if (!a.n(b16)) {
                        break;
                    }
                    i3++;
                    a.i(b16, cArr, i18);
                    i18++;
                }
                int i19 = i18;
                while (i3 < i17) {
                    int i26 = i3 + 1;
                    byte b17 = bArr[i3];
                    if (a.n(b17)) {
                        int i27 = i19 + 1;
                        a.i(b17, cArr, i19);
                        while (i26 < i17) {
                            byte b18 = bArr[i26];
                            if (!a.n(b18)) {
                                break;
                            }
                            i26++;
                            a.i(b18, cArr, i27);
                            i27++;
                        }
                        i3 = i26;
                        i19 = i27;
                    } else if (a.p(b17)) {
                        if (i26 < i17) {
                            a.k(b17, bArr[i26], cArr, i19);
                            i3 = i26 + 1;
                            i19++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (a.o(b17)) {
                        if (i26 < i17 - 1) {
                            int i28 = i26 + 1;
                            a.j(b17, bArr[i26], bArr[i28], cArr, i19);
                            i3 = i28 + 1;
                            i19++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i26 < i17 - 2) {
                        int i29 = i26 + 1;
                        byte b19 = bArr[i26];
                        int i36 = i29 + 1;
                        a.h(b17, b19, bArr[i29], bArr[i36], cArr, i19);
                        i3 = i36 + 1;
                        i19 = i19 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i19);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i16)));
        }

        @Override // com.google.protobuf.Utf8.b
        String d(ByteBuffer byteBuffer, int i3, int i16) throws InvalidProtocolBufferException {
            return c(byteBuffer, i3, i16);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        
            return r10 + r0;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int e(CharSequence charSequence, byte[] bArr, int i3, int i16) {
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
                            throw new UnpairedSurrogateException(i27 - 1, length);
                        }
                        if ('\ud800' <= charAt2 && charAt2 <= '\udfff' && ((i18 = i27 + 1) == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i18)))) {
                            throw new UnpairedSurrogateException(i27, length);
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

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int i(int i3, byte[] bArr, int i16, int i17) {
            byte b16;
            int i18;
            int i19;
            if (i3 != 0) {
                if (i16 >= i17) {
                    return i3;
                }
                byte b17 = (byte) i3;
                if (b17 < -32) {
                    if (b17 >= -62) {
                        i19 = i16 + 1;
                    }
                    return -1;
                }
                if (b17 < -16) {
                    byte b18 = (byte) (~(i3 >> 8));
                    if (b18 == 0) {
                        int i26 = i16 + 1;
                        byte b19 = bArr[i16];
                        if (i26 >= i17) {
                            return Utf8.n(b17, b19);
                        }
                        i16 = i26;
                        b18 = b19;
                    }
                    if (b18 <= -65 && ((b17 != -32 || b18 >= -96) && (b17 != -19 || b18 < -96))) {
                        i19 = i16 + 1;
                    }
                    return -1;
                }
                byte b26 = (byte) (~(i3 >> 8));
                if (b26 == 0) {
                    i18 = i16 + 1;
                    b26 = bArr[i16];
                    if (i18 >= i17) {
                        return Utf8.n(b17, b26);
                    }
                    b16 = 0;
                } else {
                    b16 = (byte) (i3 >> 16);
                    i18 = i16;
                }
                if (b16 == 0) {
                    int i27 = i18 + 1;
                    byte b27 = bArr[i18];
                    if (i27 >= i17) {
                        return Utf8.o(b17, b26, b27);
                    }
                    b16 = b27;
                    i18 = i27;
                }
                if (b26 <= -65 && (((b17 << 28) + (b26 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0 && b16 <= -65) {
                    i16 = i18 + 1;
                }
                return -1;
                i16 = i19;
            }
            return m(bArr, i16, i17);
        }

        @Override // com.google.protobuf.Utf8.b
        int l(int i3, ByteBuffer byteBuffer, int i16, int i17) {
            return k(i3, byteBuffer, i16, i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class d extends b {
        d() {
        }

        static boolean m() {
            if (ch.H() && ch.I()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x008e, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int n(long j3, int i3) {
            long j16;
            int p16 = p(j3, i3);
            long j17 = j3 + p16;
            int i16 = i3 - p16;
            while (true) {
                byte b16 = 0;
                while (true) {
                    if (i16 <= 0) {
                        break;
                    }
                    long j18 = j17 + 1;
                    b16 = ch.u(j17);
                    if (b16 >= 0) {
                        i16--;
                        j17 = j18;
                    } else {
                        j17 = j18;
                        break;
                    }
                }
                if (i16 == 0) {
                    return 0;
                }
                int i17 = i16 - 1;
                if (b16 < -32) {
                    if (i17 == 0) {
                        return b16;
                    }
                    i16 = i17 - 1;
                    if (b16 < -62) {
                        break;
                    }
                    j16 = 1 + j17;
                    if (ch.u(j17) > -65) {
                        break;
                    }
                } else if (b16 < -16) {
                    if (i17 < 2) {
                        return r(j17, b16, i17);
                    }
                    i16 = i17 - 2;
                    long j19 = j17 + 1;
                    byte u16 = ch.u(j17);
                    if (u16 > -65 || ((b16 == -32 && u16 < -96) || (b16 == -19 && u16 >= -96))) {
                        break;
                    }
                    j16 = 1 + j19;
                    if (ch.u(j19) > -65) {
                        break;
                    }
                } else {
                    if (i17 < 3) {
                        return r(j17, b16, i17);
                    }
                    i16 = i17 - 3;
                    long j26 = j17 + 1;
                    byte u17 = ch.u(j17);
                    if (u17 > -65 || (((b16 << 28) + (u17 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) != 0) {
                        break;
                    }
                    long j27 = j26 + 1;
                    if (ch.u(j26) > -65) {
                        break;
                    }
                    j16 = 1 + j27;
                    if (ch.u(j27) > -65) {
                        break;
                    }
                }
                j17 = j16;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x008e, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int o(byte[] bArr, long j3, int i3) {
            long j16;
            int q16 = q(bArr, j3, i3);
            int i16 = i3 - q16;
            long j17 = j3 + q16;
            while (true) {
                byte b16 = 0;
                while (true) {
                    if (i16 <= 0) {
                        break;
                    }
                    long j18 = j17 + 1;
                    b16 = ch.v(bArr, j17);
                    if (b16 >= 0) {
                        i16--;
                        j17 = j18;
                    } else {
                        j17 = j18;
                        break;
                    }
                }
                if (i16 == 0) {
                    return 0;
                }
                int i17 = i16 - 1;
                if (b16 < -32) {
                    if (i17 == 0) {
                        return b16;
                    }
                    i16 = i17 - 1;
                    if (b16 < -62) {
                        break;
                    }
                    j16 = 1 + j17;
                    if (ch.v(bArr, j17) > -65) {
                        break;
                    }
                } else if (b16 < -16) {
                    if (i17 < 2) {
                        return s(bArr, b16, j17, i17);
                    }
                    i16 = i17 - 2;
                    long j19 = j17 + 1;
                    byte v3 = ch.v(bArr, j17);
                    if (v3 > -65 || ((b16 == -32 && v3 < -96) || (b16 == -19 && v3 >= -96))) {
                        break;
                    }
                    j16 = 1 + j19;
                    if (ch.v(bArr, j19) > -65) {
                        break;
                    }
                } else {
                    if (i17 < 3) {
                        return s(bArr, b16, j17, i17);
                    }
                    i16 = i17 - 3;
                    long j26 = j17 + 1;
                    byte v16 = ch.v(bArr, j17);
                    if (v16 > -65 || (((b16 << 28) + (v16 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) != 0) {
                        break;
                    }
                    long j27 = j26 + 1;
                    if (ch.v(bArr, j26) > -65) {
                        break;
                    }
                    j16 = 1 + j27;
                    if (ch.v(bArr, j27) > -65) {
                        break;
                    }
                }
                j17 = j16;
            }
        }

        private static int p(long j3, int i3) {
            if (i3 < 16) {
                return 0;
            }
            int i16 = 8 - (((int) j3) & 7);
            int i17 = i16;
            while (i17 > 0) {
                long j16 = 1 + j3;
                if (ch.u(j3) < 0) {
                    return i16 - i17;
                }
                i17--;
                j3 = j16;
            }
            int i18 = i3 - i16;
            while (i18 >= 8 && (ch.B(j3) & (-9187201950435737472L)) == 0) {
                j3 += 8;
                i18 -= 8;
            }
            return i3 - i18;
        }

        private static int q(byte[] bArr, long j3, int i3) {
            int i16 = 0;
            if (i3 < 16) {
                return 0;
            }
            while (i16 < i3) {
                long j16 = 1 + j3;
                if (ch.v(bArr, j3) < 0) {
                    return i16;
                }
                i16++;
                j3 = j16;
            }
            return i3;
        }

        private static int r(long j3, int i3, int i16) {
            if (i16 == 0) {
                return Utf8.m(i3);
            }
            if (i16 == 1) {
                return Utf8.n(i3, ch.u(j3));
            }
            if (i16 == 2) {
                return Utf8.o(i3, ch.u(j3), ch.u(j3 + 1));
            }
            throw new AssertionError();
        }

        private static int s(byte[] bArr, int i3, long j3, int i16) {
            if (i16 == 0) {
                return Utf8.m(i3);
            }
            if (i16 == 1) {
                return Utf8.n(i3, ch.v(bArr, j3));
            }
            if (i16 == 2) {
                return Utf8.o(i3, ch.v(bArr, j3), ch.v(bArr, j3 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.Utf8.b
        String b(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException {
            if ((i3 | i16 | ((bArr.length - i3) - i16)) >= 0) {
                int i17 = i3 + i16;
                char[] cArr = new char[i16];
                int i18 = 0;
                while (i3 < i17) {
                    byte v3 = ch.v(bArr, i3);
                    if (!a.n(v3)) {
                        break;
                    }
                    i3++;
                    a.i(v3, cArr, i18);
                    i18++;
                }
                int i19 = i18;
                while (i3 < i17) {
                    int i26 = i3 + 1;
                    byte v16 = ch.v(bArr, i3);
                    if (a.n(v16)) {
                        int i27 = i19 + 1;
                        a.i(v16, cArr, i19);
                        while (i26 < i17) {
                            byte v17 = ch.v(bArr, i26);
                            if (!a.n(v17)) {
                                break;
                            }
                            i26++;
                            a.i(v17, cArr, i27);
                            i27++;
                        }
                        i3 = i26;
                        i19 = i27;
                    } else if (a.p(v16)) {
                        if (i26 < i17) {
                            a.k(v16, ch.v(bArr, i26), cArr, i19);
                            i3 = i26 + 1;
                            i19++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (a.o(v16)) {
                        if (i26 < i17 - 1) {
                            int i28 = i26 + 1;
                            a.j(v16, ch.v(bArr, i26), ch.v(bArr, i28), cArr, i19);
                            i3 = i28 + 1;
                            i19++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i26 < i17 - 2) {
                        int i29 = i26 + 1;
                        byte v18 = ch.v(bArr, i26);
                        int i36 = i29 + 1;
                        a.h(v16, v18, ch.v(bArr, i29), ch.v(bArr, i36), cArr, i19);
                        i3 = i36 + 1;
                        i19 = i19 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i19);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i16)));
        }

        @Override // com.google.protobuf.Utf8.b
        String d(ByteBuffer byteBuffer, int i3, int i16) throws InvalidProtocolBufferException {
            if ((i3 | i16 | ((byteBuffer.limit() - i3) - i16)) >= 0) {
                long i17 = ch.i(byteBuffer) + i3;
                long j3 = i16 + i17;
                char[] cArr = new char[i16];
                int i18 = 0;
                while (i17 < j3) {
                    byte u16 = ch.u(i17);
                    if (!a.n(u16)) {
                        break;
                    }
                    i17++;
                    a.i(u16, cArr, i18);
                    i18++;
                }
                while (true) {
                    int i19 = i18;
                    while (i17 < j3) {
                        long j16 = i17 + 1;
                        byte u17 = ch.u(i17);
                        if (a.n(u17)) {
                            int i26 = i19 + 1;
                            a.i(u17, cArr, i19);
                            while (j16 < j3) {
                                byte u18 = ch.u(j16);
                                if (!a.n(u18)) {
                                    break;
                                }
                                j16++;
                                a.i(u18, cArr, i26);
                                i26++;
                            }
                            i19 = i26;
                            i17 = j16;
                        } else if (a.p(u17)) {
                            if (j16 < j3) {
                                i17 = j16 + 1;
                                a.k(u17, ch.u(j16), cArr, i19);
                                i19++;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (a.o(u17)) {
                            if (j16 < j3 - 1) {
                                long j17 = j16 + 1;
                                a.j(u17, ch.u(j16), ch.u(j17), cArr, i19);
                                i19++;
                                i17 = j17 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (j16 < j3 - 2) {
                            long j18 = j16 + 1;
                            byte u19 = ch.u(j16);
                            long j19 = j18 + 1;
                            byte u26 = ch.u(j18);
                            i17 = j19 + 1;
                            a.h(u17, u19, u26, ch.u(j19), cArr, i19);
                            i18 = i19 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                    return new String(cArr, 0, i19);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i3), Integer.valueOf(i16)));
        }

        @Override // com.google.protobuf.Utf8.b
        int e(CharSequence charSequence, byte[] bArr, int i3, int i16) {
            char c16;
            long j3;
            long j16;
            long j17;
            char c17;
            int i17;
            char charAt;
            long j18 = i3;
            long j19 = i16 + j18;
            int length = charSequence.length();
            if (length <= i16 && bArr.length - i16 >= i3) {
                int i18 = 0;
                while (true) {
                    c16 = '\u0080';
                    j3 = 1;
                    if (i18 >= length || (charAt = charSequence.charAt(i18)) >= '\u0080') {
                        break;
                    }
                    ch.N(bArr, j18, (byte) charAt);
                    i18++;
                    j18 = 1 + j18;
                }
                if (i18 == length) {
                    return (int) j18;
                }
                while (i18 < length) {
                    char charAt2 = charSequence.charAt(i18);
                    if (charAt2 < c16 && j18 < j19) {
                        long j26 = j18 + j3;
                        ch.N(bArr, j18, (byte) charAt2);
                        j17 = j3;
                        j16 = j26;
                        c17 = c16;
                    } else if (charAt2 < '\u0800' && j18 <= j19 - 2) {
                        long j27 = j18 + j3;
                        ch.N(bArr, j18, (byte) ((charAt2 >>> 6) | 960));
                        long j28 = j27 + j3;
                        ch.N(bArr, j27, (byte) ((charAt2 & '?') | 128));
                        long j29 = j3;
                        c17 = '\u0080';
                        j16 = j28;
                        j17 = j29;
                    } else if ((charAt2 < '\ud800' || '\udfff' < charAt2) && j18 <= j19 - 3) {
                        long j36 = j18 + j3;
                        ch.N(bArr, j18, (byte) ((charAt2 >>> '\f') | 480));
                        long j37 = j36 + j3;
                        ch.N(bArr, j36, (byte) (((charAt2 >>> 6) & 63) | 128));
                        ch.N(bArr, j37, (byte) ((charAt2 & '?') | 128));
                        j16 = j37 + 1;
                        j17 = 1;
                        c17 = '\u0080';
                    } else {
                        if (j18 <= j19 - 4) {
                            int i19 = i18 + 1;
                            if (i19 != length) {
                                char charAt3 = charSequence.charAt(i19);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j38 = j18 + 1;
                                    ch.N(bArr, j18, (byte) ((codePoint >>> 18) | 240));
                                    long j39 = j38 + 1;
                                    c17 = '\u0080';
                                    ch.N(bArr, j38, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j46 = j39 + 1;
                                    ch.N(bArr, j39, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j17 = 1;
                                    j16 = j46 + 1;
                                    ch.N(bArr, j46, (byte) ((codePoint & 63) | 128));
                                    i18 = i19;
                                } else {
                                    i18 = i19;
                                }
                            }
                            throw new UnpairedSurrogateException(i18 - 1, length);
                        }
                        if ('\ud800' <= charAt2 && charAt2 <= '\udfff' && ((i17 = i18 + 1) == length || !Character.isSurrogatePair(charAt2, charSequence.charAt(i17)))) {
                            throw new UnpairedSurrogateException(i18, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j18);
                    }
                    i18++;
                    c16 = c17;
                    long j47 = j17;
                    j18 = j16;
                    j3 = j47;
                }
                return (int) j18;
            }
            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i3 + i16));
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
        
            if (com.google.protobuf.ch.v(r13, r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x009e, code lost:
        
            if (com.google.protobuf.ch.v(r13, r2) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int i(int i3, byte[] bArr, int i16, int i17) {
            long j3;
            byte b16 = 0;
            if ((i16 | i17 | (bArr.length - i17)) >= 0) {
                long j16 = i16;
                long j17 = i17;
                if (i3 != 0) {
                    if (j16 >= j17) {
                        return i3;
                    }
                    byte b17 = (byte) i3;
                    if (b17 < -32) {
                        if (b17 >= -62) {
                            long j18 = 1 + j16;
                            if (ch.v(bArr, j16) <= -65) {
                                j16 = j18;
                            }
                        }
                        return -1;
                    }
                    if (b17 < -16) {
                        byte b18 = (byte) (~(i3 >> 8));
                        if (b18 == 0) {
                            long j19 = j16 + 1;
                            b18 = ch.v(bArr, j16);
                            if (j19 >= j17) {
                                return Utf8.n(b17, b18);
                            }
                            j16 = j19;
                        }
                        if (b18 <= -65 && ((b17 != -32 || b18 >= -96) && (b17 != -19 || b18 < -96))) {
                            j3 = j16 + 1;
                        }
                        return -1;
                    }
                    byte b19 = (byte) (~(i3 >> 8));
                    if (b19 == 0) {
                        long j26 = j16 + 1;
                        b19 = ch.v(bArr, j16);
                        if (j26 >= j17) {
                            return Utf8.n(b17, b19);
                        }
                        j16 = j26;
                    } else {
                        b16 = (byte) (i3 >> 16);
                    }
                    if (b16 == 0) {
                        long j27 = j16 + 1;
                        b16 = ch.v(bArr, j16);
                        if (j27 >= j17) {
                            return Utf8.o(b17, b19, b16);
                        }
                        j16 = j27;
                    }
                    if (b19 <= -65 && (((b17 << 28) + (b19 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0 && b16 <= -65) {
                        j3 = j16 + 1;
                    }
                    return -1;
                    j16 = j3;
                }
                return o(bArr, j16, (int) (j17 - j16));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i16), Integer.valueOf(i17)));
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            if (com.google.protobuf.ch.u(r2) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00a8, code lost:
        
            if (com.google.protobuf.ch.u(r2) > (-65)) goto L59;
         */
        @Override // com.google.protobuf.Utf8.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int l(int i3, ByteBuffer byteBuffer, int i16, int i17) {
            long j3;
            byte b16 = 0;
            if ((i16 | i17 | (byteBuffer.limit() - i17)) >= 0) {
                long i18 = ch.i(byteBuffer) + i16;
                long j16 = (i17 - i16) + i18;
                if (i3 != 0) {
                    if (i18 >= j16) {
                        return i3;
                    }
                    byte b17 = (byte) i3;
                    if (b17 < -32) {
                        if (b17 >= -62) {
                            long j17 = 1 + i18;
                            if (ch.u(i18) <= -65) {
                                i18 = j17;
                            }
                        }
                        return -1;
                    }
                    if (b17 < -16) {
                        byte b18 = (byte) (~(i3 >> 8));
                        if (b18 == 0) {
                            long j18 = i18 + 1;
                            b18 = ch.u(i18);
                            if (j18 >= j16) {
                                return Utf8.n(b17, b18);
                            }
                            i18 = j18;
                        }
                        if (b18 <= -65 && ((b17 != -32 || b18 >= -96) && (b17 != -19 || b18 < -96))) {
                            j3 = i18 + 1;
                        }
                        return -1;
                    }
                    byte b19 = (byte) (~(i3 >> 8));
                    if (b19 == 0) {
                        long j19 = i18 + 1;
                        b19 = ch.u(i18);
                        if (j19 >= j16) {
                            return Utf8.n(b17, b19);
                        }
                        i18 = j19;
                    } else {
                        b16 = (byte) (i3 >> 16);
                    }
                    if (b16 == 0) {
                        long j26 = i18 + 1;
                        b16 = ch.u(i18);
                        if (j26 >= j16) {
                            return Utf8.o(b17, b19, b16);
                        }
                        i18 = j26;
                    }
                    if (b19 <= -65 && (((b17 << 28) + (b19 + PublicAccountH5AbilityPluginImpl.OPENCAMERA)) >> 30) == 0 && b16 <= -65) {
                        j3 = i18 + 1;
                    }
                    return -1;
                    i18 = j3;
                }
                return n(i18, (int) (j16 - i18));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i16), Integer.valueOf(i17)));
        }
    }

    static {
        b cVar;
        if (d.m() && !e.c()) {
            cVar = new d();
        } else {
            cVar = new c();
        }
        f35626a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(ByteBuffer byteBuffer, int i3, int i16) throws InvalidProtocolBufferException {
        return f35626a.a(byteBuffer, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(byte[] bArr, int i3, int i16) throws InvalidProtocolBufferException {
        return f35626a.b(bArr, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(CharSequence charSequence, byte[] bArr, int i3, int i16) {
        return f35626a.e(charSequence, bArr, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < '\u0080') {
            i3++;
        }
        int i16 = length;
        while (true) {
            if (i3 < length) {
                char charAt = charSequence.charAt(i3);
                if (charAt < '\u0800') {
                    i16 += ('\u007f' - charAt) >>> 31;
                    i3++;
                } else {
                    i16 += k(charSequence, i3);
                    break;
                }
            } else {
                break;
            }
        }
        if (i16 >= length) {
            return i16;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i16 + 4294967296L));
    }

    private static int k(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        int i16 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < '\u0800') {
                i16 += ('\u007f' - charAt) >>> 31;
            } else {
                i16 += 2;
                if ('\ud800' <= charAt && charAt <= '\udfff') {
                    if (Character.codePointAt(charSequence, i3) >= 65536) {
                        i3++;
                    } else {
                        throw new UnpairedSurrogateException(i3, length);
                    }
                }
            }
            i3++;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(ByteBuffer byteBuffer, int i3, int i16) {
        int i17 = i16 - 7;
        int i18 = i3;
        while (i18 < i17 && (byteBuffer.getLong(i18) & (-9187201950435737472L)) == 0) {
            i18 += 8;
        }
        return i18 - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i3) {
        if (i3 > -12) {
            return -1;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i3, int i16) {
        if (i3 <= -12 && i16 <= -65) {
            return i3 ^ (i16 << 8);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i3, int i16, int i17) {
        if (i3 <= -12 && i16 <= -65 && i17 <= -65) {
            return (i3 ^ (i16 << 8)) ^ (i17 << 16);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(ByteBuffer byteBuffer, int i3, int i16, int i17) {
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    return o(i3, byteBuffer.get(i16), byteBuffer.get(i16 + 1));
                }
                throw new AssertionError();
            }
            return n(i3, byteBuffer.get(i16));
        }
        return m(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(byte[] bArr, int i3, int i16) {
        byte b16 = bArr[i3 - 1];
        int i17 = i16 - i3;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    return o(b16, bArr[i3], bArr[i3 + 1]);
                }
                throw new AssertionError();
            }
            return n(b16, bArr[i3]);
        }
        return m(b16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(ByteBuffer byteBuffer) {
        return f35626a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean s(byte[] bArr) {
        return f35626a.g(bArr, 0, bArr.length);
    }

    public static boolean t(byte[] bArr, int i3, int i16) {
        return f35626a.g(bArr, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i3, ByteBuffer byteBuffer, int i16, int i17) {
        return f35626a.h(i3, byteBuffer, i16, i17);
    }

    public static int v(int i3, byte[] bArr, int i16, int i17) {
        return f35626a.i(i3, bArr, i16, i17);
    }
}
