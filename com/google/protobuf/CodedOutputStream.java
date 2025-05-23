package com.google.protobuf;

import com.google.protobuf.Utf8;
import cooperation.qzone.ShareElfFile;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class CodedOutputStream extends j {

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f35251c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f35252d = ch.H();

    /* renamed from: a, reason: collision with root package name */
    m f35253a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35254b;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th5) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th5);
        }

        OutOfSpaceException(String str, Throwable th5) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        final byte[] f35255e;

        /* renamed from: f, reason: collision with root package name */
        final int f35256f;

        /* renamed from: g, reason: collision with root package name */
        int f35257g;

        /* renamed from: h, reason: collision with root package name */
        int f35258h;

        b(int i3) {
            super();
            if (i3 >= 0) {
                byte[] bArr = new byte[Math.max(i3, 20)];
                this.f35255e = bArr;
                this.f35256f = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        final void f1(byte b16) {
            byte[] bArr = this.f35255e;
            int i3 = this.f35257g;
            this.f35257g = i3 + 1;
            bArr[i3] = b16;
            this.f35258h++;
        }

        final void g1(int i3) {
            byte[] bArr = this.f35255e;
            int i16 = this.f35257g;
            int i17 = i16 + 1;
            bArr[i16] = (byte) (i3 & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((i3 >> 8) & 255);
            int i19 = i18 + 1;
            bArr[i18] = (byte) ((i3 >> 16) & 255);
            this.f35257g = i19 + 1;
            bArr[i19] = (byte) ((i3 >> 24) & 255);
            this.f35258h += 4;
        }

        final void h1(long j3) {
            byte[] bArr = this.f35255e;
            int i3 = this.f35257g;
            int i16 = i3 + 1;
            bArr[i3] = (byte) (j3 & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) ((j3 >> 8) & 255);
            int i18 = i17 + 1;
            bArr[i17] = (byte) ((j3 >> 16) & 255);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (255 & (j3 >> 24));
            int i26 = i19 + 1;
            bArr[i19] = (byte) (((int) (j3 >> 32)) & 255);
            int i27 = i26 + 1;
            bArr[i26] = (byte) (((int) (j3 >> 40)) & 255);
            int i28 = i27 + 1;
            bArr[i27] = (byte) (((int) (j3 >> 48)) & 255);
            this.f35257g = i28 + 1;
            bArr[i28] = (byte) (((int) (j3 >> 56)) & 255);
            this.f35258h += 8;
        }

        final void i1(int i3) {
            if (i3 >= 0) {
                k1(i3);
            } else {
                l1(i3);
            }
        }

        final void j1(int i3, int i16) {
            k1(WireFormat.c(i3, i16));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int k0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void k1(int i3) {
            if (CodedOutputStream.f35252d) {
                long j3 = this.f35257g;
                while ((i3 & (-128)) != 0) {
                    byte[] bArr = this.f35255e;
                    int i16 = this.f35257g;
                    this.f35257g = i16 + 1;
                    ch.N(bArr, i16, (byte) ((i3 & 127) | 128));
                    i3 >>>= 7;
                }
                byte[] bArr2 = this.f35255e;
                int i17 = this.f35257g;
                this.f35257g = i17 + 1;
                ch.N(bArr2, i17, (byte) i3);
                this.f35258h += (int) (this.f35257g - j3);
                return;
            }
            while ((i3 & (-128)) != 0) {
                byte[] bArr3 = this.f35255e;
                int i18 = this.f35257g;
                this.f35257g = i18 + 1;
                bArr3[i18] = (byte) ((i3 & 127) | 128);
                this.f35258h++;
                i3 >>>= 7;
            }
            byte[] bArr4 = this.f35255e;
            int i19 = this.f35257g;
            this.f35257g = i19 + 1;
            bArr4[i19] = (byte) i3;
            this.f35258h++;
        }

        final void l1(long j3) {
            if (CodedOutputStream.f35252d) {
                long j16 = this.f35257g;
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.f35255e;
                    int i3 = this.f35257g;
                    this.f35257g = i3 + 1;
                    ch.N(bArr, i3, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.f35255e;
                int i16 = this.f35257g;
                this.f35257g = i16 + 1;
                ch.N(bArr2, i16, (byte) j3);
                this.f35258h += (int) (this.f35257g - j16);
                return;
            }
            while ((j3 & (-128)) != 0) {
                byte[] bArr3 = this.f35255e;
                int i17 = this.f35257g;
                this.f35257g = i17 + 1;
                bArr3[i17] = (byte) ((((int) j3) & 127) | 128);
                this.f35258h++;
                j3 >>>= 7;
            }
            byte[] bArr4 = this.f35255e;
            int i18 = this.f35257g;
            this.f35257g = i18 + 1;
            bArr4[i18] = (byte) j3;
            this.f35258h++;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class d extends b {

        /* renamed from: i, reason: collision with root package name */
        private final OutputStream f35263i;

        d(OutputStream outputStream, int i3) {
            super(i3);
            if (outputStream != null) {
                this.f35263i = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void m1() throws IOException {
            this.f35263i.write(this.f35255e, 0, this.f35257g);
            this.f35257g = 0;
        }

        private void n1(int i3) throws IOException {
            if (this.f35256f - this.f35257g < i3) {
                m1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void G0(int i3, int i16) throws IOException {
            n1(20);
            j1(i3, 0);
            i1(i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void H0(int i3) throws IOException {
            if (i3 >= 0) {
                c1(i3);
            } else {
                e1(i3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void K0(int i3, au auVar) throws IOException {
            a1(i3, 2);
            M0(auVar);
        }

        @Override // com.google.protobuf.CodedOutputStream
        void L0(int i3, au auVar, bq bqVar) throws IOException {
            a1(i3, 2);
            q1(auVar, bqVar);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void M0(au auVar) throws IOException {
            c1(auVar.getSerializedSize());
            auVar.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void N0(int i3, au auVar) throws IOException {
            a1(1, 3);
            b1(2, i3);
            K0(3, auVar);
            a1(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void O0(int i3, ByteString byteString) throws IOException {
            a1(1, 3);
            b1(2, i3);
            q0(3, byteString);
            a1(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void Y0(int i3, String str) throws IOException {
            a1(i3, 2);
            Z0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void Z0(String str) throws IOException {
            int j3;
            try {
                int length = str.length() * 3;
                int Z = CodedOutputStream.Z(length);
                int i3 = Z + length;
                int i16 = this.f35256f;
                if (i3 > i16) {
                    byte[] bArr = new byte[length];
                    int i17 = Utf8.i(str, bArr, 0, length);
                    c1(i17);
                    b(bArr, 0, i17);
                    return;
                }
                if (i3 > i16 - this.f35257g) {
                    m1();
                }
                int Z2 = CodedOutputStream.Z(str.length());
                int i18 = this.f35257g;
                try {
                    if (Z2 == Z) {
                        int i19 = i18 + Z2;
                        this.f35257g = i19;
                        int i26 = Utf8.i(str, this.f35255e, i19, this.f35256f - i19);
                        this.f35257g = i18;
                        j3 = (i26 - i18) - Z2;
                        k1(j3);
                        this.f35257g = i26;
                    } else {
                        j3 = Utf8.j(str);
                        k1(j3);
                        this.f35257g = Utf8.i(str, this.f35255e, this.f35257g, j3);
                    }
                    this.f35258h += j3;
                } catch (Utf8.UnpairedSurrogateException e16) {
                    this.f35258h -= this.f35257g - i18;
                    this.f35257g = i18;
                    throw e16;
                } catch (ArrayIndexOutOfBoundsException e17) {
                    throw new OutOfSpaceException(e17);
                }
            } catch (Utf8.UnpairedSurrogateException e18) {
                f0(str, e18);
            }
        }

        @Override // com.google.protobuf.j
        public void a(ByteBuffer byteBuffer) throws IOException {
            o1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void a1(int i3, int i16) throws IOException {
            c1(WireFormat.c(i3, i16));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.j
        public void b(byte[] bArr, int i3, int i16) throws IOException {
            p1(bArr, i3, i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b1(int i3, int i16) throws IOException {
            n1(20);
            j1(i3, 0);
            k1(i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void c1(int i3) throws IOException {
            n1(5);
            k1(i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d1(int i3, long j3) throws IOException {
            n1(20);
            j1(i3, 0);
            l1(j3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void e0() throws IOException {
            if (this.f35257g > 0) {
                m1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void e1(long j3) throws IOException {
            n1(10);
            l1(j3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void l0(byte b16) throws IOException {
            if (this.f35257g == this.f35256f) {
                m1();
            }
            f1(b16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void m0(int i3, boolean z16) throws IOException {
            n1(11);
            j1(i3, 0);
            f1(z16 ? (byte) 1 : (byte) 0);
        }

        public void o1(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i3 = this.f35256f;
            int i16 = this.f35257g;
            if (i3 - i16 >= remaining) {
                byteBuffer.get(this.f35255e, i16, remaining);
                this.f35257g += remaining;
                this.f35258h += remaining;
                return;
            }
            int i17 = i3 - i16;
            byteBuffer.get(this.f35255e, i16, i17);
            int i18 = remaining - i17;
            this.f35257g = this.f35256f;
            this.f35258h += i17;
            m1();
            while (true) {
                int i19 = this.f35256f;
                if (i18 > i19) {
                    byteBuffer.get(this.f35255e, 0, i19);
                    this.f35263i.write(this.f35255e, 0, this.f35256f);
                    int i26 = this.f35256f;
                    i18 -= i26;
                    this.f35258h += i26;
                } else {
                    byteBuffer.get(this.f35255e, 0, i18);
                    this.f35257g = i18;
                    this.f35258h += i18;
                    return;
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void p0(byte[] bArr, int i3, int i16) throws IOException {
            c1(i16);
            p1(bArr, i3, i16);
        }

        public void p1(byte[] bArr, int i3, int i16) throws IOException {
            int i17 = this.f35256f;
            int i18 = this.f35257g;
            if (i17 - i18 >= i16) {
                System.arraycopy(bArr, i3, this.f35255e, i18, i16);
                this.f35257g += i16;
                this.f35258h += i16;
                return;
            }
            int i19 = i17 - i18;
            System.arraycopy(bArr, i3, this.f35255e, i18, i19);
            int i26 = i3 + i19;
            int i27 = i16 - i19;
            this.f35257g = this.f35256f;
            this.f35258h += i19;
            m1();
            if (i27 <= this.f35256f) {
                System.arraycopy(bArr, i26, this.f35255e, 0, i27);
                this.f35257g = i27;
            } else {
                this.f35263i.write(bArr, i26, i27);
            }
            this.f35258h += i27;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void q0(int i3, ByteString byteString) throws IOException {
            a1(i3, 2);
            r0(byteString);
        }

        void q1(au auVar, bq bqVar) throws IOException {
            c1(((com.google.protobuf.b) auVar).getSerializedSize(bqVar));
            bqVar.e(auVar, this.f35253a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void r0(ByteString byteString) throws IOException {
            c1(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void w0(int i3, int i16) throws IOException {
            n1(14);
            j1(i3, 5);
            g1(i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void x0(int i3) throws IOException {
            n1(4);
            g1(i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void y0(int i3, long j3) throws IOException {
            n1(18);
            j1(i3, 1);
            h1(j3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void z0(long j3) throws IOException {
            n1(8);
            h1(j3);
        }
    }

    public static int A(long j3) {
        return b0(j3);
    }

    public static int B(int i3, af afVar) {
        return (X(1) * 2) + Y(2, i3) + C(3, afVar);
    }

    public static int C(int i3, af afVar) {
        return X(i3) + D(afVar);
    }

    public static int D(af afVar) {
        return E(afVar.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int E(int i3) {
        return Z(i3) + i3;
    }

    public static int F(int i3, au auVar) {
        return (X(1) * 2) + Y(2, i3) + G(3, auVar);
    }

    public static int G(int i3, au auVar) {
        return X(i3) + I(auVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i3, au auVar, bq bqVar) {
        return X(i3) + J(auVar, bqVar);
    }

    public static int I(au auVar) {
        return E(auVar.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(au auVar, bq bqVar) {
        return E(((com.google.protobuf.b) auVar).getSerializedSize(bqVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int K(int i3) {
        if (i3 > 4096) {
            return 4096;
        }
        return i3;
    }

    public static int L(int i3, ByteString byteString) {
        return (X(1) * 2) + Y(2, i3) + h(3, byteString);
    }

    @Deprecated
    public static int M(int i3) {
        return Z(i3);
    }

    public static int N(int i3, int i16) {
        return X(i3) + O(i16);
    }

    public static int O(int i3) {
        return 4;
    }

    public static int P(int i3, long j3) {
        return X(i3) + Q(j3);
    }

    public static int Q(long j3) {
        return 8;
    }

    public static int R(int i3, int i16) {
        return X(i3) + S(i16);
    }

    public static int S(int i3) {
        return Z(c0(i3));
    }

    public static int T(int i3, long j3) {
        return X(i3) + U(j3);
    }

    public static int U(long j3) {
        return b0(d0(j3));
    }

    public static int V(int i3, String str) {
        return X(i3) + W(str);
    }

    public static int W(String str) {
        int length;
        try {
            length = Utf8.j(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(ad.f35640a).length;
        }
        return E(length);
    }

    public static int X(int i3) {
        return Z(WireFormat.c(i3, 0));
    }

    public static int Y(int i3, int i16) {
        return X(i3) + Z(i16);
    }

    public static int Z(int i3) {
        if ((i3 & (-128)) == 0) {
            return 1;
        }
        if ((i3 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i3) == 0) {
            return 3;
        }
        if ((i3 & ShareElfFile.SectionHeader.SHF_MASKPROC) == 0) {
            return 4;
        }
        return 5;
    }

    public static int a0(int i3, long j3) {
        return X(i3) + b0(j3);
    }

    public static int b0(long j3) {
        int i3;
        if (((-128) & j3) == 0) {
            return 1;
        }
        if (j3 < 0) {
            return 10;
        }
        if (((-34359738368L) & j3) != 0) {
            j3 >>>= 28;
            i3 = 6;
        } else {
            i3 = 2;
        }
        if (((-2097152) & j3) != 0) {
            i3 += 2;
            j3 >>>= 14;
        }
        if ((j3 & (-16384)) != 0) {
            return i3 + 1;
        }
        return i3;
    }

    public static int c0(int i3) {
        return (i3 >> 31) ^ (i3 << 1);
    }

    public static long d0(long j3) {
        return (j3 >> 63) ^ (j3 << 1);
    }

    public static int e(int i3, boolean z16) {
        return X(i3) + f(z16);
    }

    public static int f(boolean z16) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return E(bArr.length);
    }

    public static int h(int i3, ByteString byteString) {
        return X(i3) + i(byteString);
    }

    public static CodedOutputStream h0(OutputStream outputStream, int i3) {
        return new d(outputStream, i3);
    }

    public static int i(ByteString byteString) {
        return E(byteString.size());
    }

    public static CodedOutputStream i0(byte[] bArr) {
        return j0(bArr, 0, bArr.length);
    }

    public static int j(int i3, double d16) {
        return X(i3) + k(d16);
    }

    public static CodedOutputStream j0(byte[] bArr, int i3, int i16) {
        return new c(bArr, i3, i16);
    }

    public static int k(double d16) {
        return 8;
    }

    public static int l(int i3, int i16) {
        return X(i3) + m(i16);
    }

    public static int m(int i3) {
        return y(i3);
    }

    public static int n(int i3, int i16) {
        return X(i3) + o(i16);
    }

    public static int o(int i3) {
        return 4;
    }

    public static int p(int i3, long j3) {
        return X(i3) + q(j3);
    }

    public static int q(long j3) {
        return 8;
    }

    public static int r(int i3, float f16) {
        return X(i3) + s(f16);
    }

    public static int s(float f16) {
        return 4;
    }

    @Deprecated
    public static int t(int i3, au auVar) {
        return (X(i3) * 2) + v(auVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int u(int i3, au auVar, bq bqVar) {
        return (X(i3) * 2) + w(auVar, bqVar);
    }

    @Deprecated
    public static int v(au auVar) {
        return auVar.getSerializedSize();
    }

    @Deprecated
    static int w(au auVar, bq bqVar) {
        return ((com.google.protobuf.b) auVar).getSerializedSize(bqVar);
    }

    public static int x(int i3, int i16) {
        return X(i3) + y(i16);
    }

    public static int y(int i3) {
        if (i3 >= 0) {
            return Z(i3);
        }
        return 10;
    }

    public static int z(int i3, long j3) {
        return X(i3) + A(j3);
    }

    public final void A0(int i3, float f16) throws IOException {
        w0(i3, Float.floatToRawIntBits(f16));
    }

    public final void B0(float f16) throws IOException {
        x0(Float.floatToRawIntBits(f16));
    }

    @Deprecated
    public final void C0(int i3, au auVar) throws IOException {
        a1(i3, 3);
        E0(auVar);
        a1(i3, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void D0(int i3, au auVar, bq bqVar) throws IOException {
        a1(i3, 3);
        F0(auVar, bqVar);
        a1(i3, 4);
    }

    @Deprecated
    public final void E0(au auVar) throws IOException {
        auVar.writeTo(this);
    }

    @Deprecated
    final void F0(au auVar, bq bqVar) throws IOException {
        bqVar.e(auVar, this.f35253a);
    }

    public abstract void G0(int i3, int i16) throws IOException;

    public abstract void H0(int i3) throws IOException;

    public final void I0(int i3, long j3) throws IOException {
        d1(i3, j3);
    }

    public final void J0(long j3) throws IOException {
        e1(j3);
    }

    public abstract void K0(int i3, au auVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void L0(int i3, au auVar, bq bqVar) throws IOException;

    public abstract void M0(au auVar) throws IOException;

    public abstract void N0(int i3, au auVar) throws IOException;

    public abstract void O0(int i3, ByteString byteString) throws IOException;

    @Deprecated
    public final void P0(int i3) throws IOException {
        c1(i3);
    }

    public final void Q0(int i3, int i16) throws IOException {
        w0(i3, i16);
    }

    public final void R0(int i3) throws IOException {
        x0(i3);
    }

    public final void S0(int i3, long j3) throws IOException {
        y0(i3, j3);
    }

    public final void T0(long j3) throws IOException {
        z0(j3);
    }

    public final void U0(int i3, int i16) throws IOException {
        b1(i3, c0(i16));
    }

    public final void V0(int i3) throws IOException {
        c1(c0(i3));
    }

    public final void W0(int i3, long j3) throws IOException {
        d1(i3, d0(j3));
    }

    public final void X0(long j3) throws IOException {
        e1(d0(j3));
    }

    public abstract void Y0(int i3, String str) throws IOException;

    public abstract void Z0(String str) throws IOException;

    public abstract void a1(int i3, int i16) throws IOException;

    @Override // com.google.protobuf.j
    public abstract void b(byte[] bArr, int i3, int i16) throws IOException;

    public abstract void b1(int i3, int i16) throws IOException;

    public abstract void c1(int i3) throws IOException;

    public final void d() {
        if (k0() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void d1(int i3, long j3) throws IOException;

    public abstract void e0() throws IOException;

    public abstract void e1(long j3) throws IOException;

    final void f0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f35251c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(ad.f35640a);
        try {
            c1(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e16) {
            throw e16;
        } catch (IndexOutOfBoundsException e17) {
            throw new OutOfSpaceException(e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g0() {
        return this.f35254b;
    }

    public abstract int k0();

    public abstract void l0(byte b16) throws IOException;

    public abstract void m0(int i3, boolean z16) throws IOException;

    public final void n0(boolean z16) throws IOException {
        l0(z16 ? (byte) 1 : (byte) 0);
    }

    public final void o0(byte[] bArr) throws IOException {
        p0(bArr, 0, bArr.length);
    }

    abstract void p0(byte[] bArr, int i3, int i16) throws IOException;

    public abstract void q0(int i3, ByteString byteString) throws IOException;

    public abstract void r0(ByteString byteString) throws IOException;

    public final void s0(int i3, double d16) throws IOException {
        y0(i3, Double.doubleToRawLongBits(d16));
    }

    public final void t0(double d16) throws IOException {
        z0(Double.doubleToRawLongBits(d16));
    }

    public final void u0(int i3, int i16) throws IOException {
        G0(i3, i16);
    }

    public final void v0(int i3) throws IOException {
        H0(i3);
    }

    public abstract void w0(int i3, int i16) throws IOException;

    public abstract void x0(int i3) throws IOException;

    public abstract void y0(int i3, long j3) throws IOException;

    public abstract void z0(long j3) throws IOException;

    CodedOutputStream() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        private final byte[] f35259e;

        /* renamed from: f, reason: collision with root package name */
        private final int f35260f;

        /* renamed from: g, reason: collision with root package name */
        private final int f35261g;

        /* renamed from: h, reason: collision with root package name */
        private int f35262h;

        c(byte[] bArr, int i3, int i16) {
            super();
            if (bArr != null) {
                int i17 = i3 + i16;
                if ((i3 | i16 | (bArr.length - i17)) >= 0) {
                    this.f35259e = bArr;
                    this.f35260f = i3;
                    this.f35262h = i3;
                    this.f35261g = i17;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i16)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void G0(int i3, int i16) throws IOException {
            a1(i3, 0);
            H0(i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void H0(int i3) throws IOException {
            if (i3 >= 0) {
                c1(i3);
            } else {
                e1(i3);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void K0(int i3, au auVar) throws IOException {
            a1(i3, 2);
            M0(auVar);
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void L0(int i3, au auVar, bq bqVar) throws IOException {
            a1(i3, 2);
            c1(((com.google.protobuf.b) auVar).getSerializedSize(bqVar));
            bqVar.e(auVar, this.f35253a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void M0(au auVar) throws IOException {
            c1(auVar.getSerializedSize());
            auVar.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void N0(int i3, au auVar) throws IOException {
            a1(1, 3);
            b1(2, i3);
            K0(3, auVar);
            a1(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void O0(int i3, ByteString byteString) throws IOException {
            a1(1, 3);
            b1(2, i3);
            q0(3, byteString);
            a1(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Y0(int i3, String str) throws IOException {
            a1(i3, 2);
            Z0(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Z0(String str) throws IOException {
            int i3 = this.f35262h;
            try {
                int Z = CodedOutputStream.Z(str.length() * 3);
                int Z2 = CodedOutputStream.Z(str.length());
                if (Z2 == Z) {
                    int i16 = i3 + Z2;
                    this.f35262h = i16;
                    int i17 = Utf8.i(str, this.f35259e, i16, k0());
                    this.f35262h = i3;
                    c1((i17 - i3) - Z2);
                    this.f35262h = i17;
                } else {
                    c1(Utf8.j(str));
                    this.f35262h = Utf8.i(str, this.f35259e, this.f35262h, k0());
                }
            } catch (Utf8.UnpairedSurrogateException e16) {
                this.f35262h = i3;
                f0(str, e16);
            } catch (IndexOutOfBoundsException e17) {
                throw new OutOfSpaceException(e17);
            }
        }

        @Override // com.google.protobuf.j
        public final void a(ByteBuffer byteBuffer) throws IOException {
            f1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void a1(int i3, int i16) throws IOException {
            c1(WireFormat.c(i3, i16));
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.j
        public final void b(byte[] bArr, int i3, int i16) throws IOException {
            g1(bArr, i3, i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b1(int i3, int i16) throws IOException {
            a1(i3, 0);
            c1(i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void c1(int i3) throws IOException {
            if (CodedOutputStream.f35252d && !e.c() && k0() >= 5) {
                if ((i3 & (-128)) == 0) {
                    byte[] bArr = this.f35259e;
                    int i16 = this.f35262h;
                    this.f35262h = i16 + 1;
                    ch.N(bArr, i16, (byte) i3);
                    return;
                }
                byte[] bArr2 = this.f35259e;
                int i17 = this.f35262h;
                this.f35262h = i17 + 1;
                ch.N(bArr2, i17, (byte) (i3 | 128));
                int i18 = i3 >>> 7;
                if ((i18 & (-128)) == 0) {
                    byte[] bArr3 = this.f35259e;
                    int i19 = this.f35262h;
                    this.f35262h = i19 + 1;
                    ch.N(bArr3, i19, (byte) i18);
                    return;
                }
                byte[] bArr4 = this.f35259e;
                int i26 = this.f35262h;
                this.f35262h = i26 + 1;
                ch.N(bArr4, i26, (byte) (i18 | 128));
                int i27 = i18 >>> 7;
                if ((i27 & (-128)) == 0) {
                    byte[] bArr5 = this.f35259e;
                    int i28 = this.f35262h;
                    this.f35262h = i28 + 1;
                    ch.N(bArr5, i28, (byte) i27);
                    return;
                }
                byte[] bArr6 = this.f35259e;
                int i29 = this.f35262h;
                this.f35262h = i29 + 1;
                ch.N(bArr6, i29, (byte) (i27 | 128));
                int i36 = i27 >>> 7;
                if ((i36 & (-128)) == 0) {
                    byte[] bArr7 = this.f35259e;
                    int i37 = this.f35262h;
                    this.f35262h = i37 + 1;
                    ch.N(bArr7, i37, (byte) i36);
                    return;
                }
                byte[] bArr8 = this.f35259e;
                int i38 = this.f35262h;
                this.f35262h = i38 + 1;
                ch.N(bArr8, i38, (byte) (i36 | 128));
                byte[] bArr9 = this.f35259e;
                int i39 = this.f35262h;
                this.f35262h = i39 + 1;
                ch.N(bArr9, i39, (byte) (i36 >>> 7));
                return;
            }
            while ((i3 & (-128)) != 0) {
                try {
                    byte[] bArr10 = this.f35259e;
                    int i46 = this.f35262h;
                    this.f35262h = i46 + 1;
                    bArr10[i46] = (byte) ((i3 & 127) | 128);
                    i3 >>>= 7;
                } catch (IndexOutOfBoundsException e16) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), 1), e16);
                }
            }
            byte[] bArr11 = this.f35259e;
            int i47 = this.f35262h;
            this.f35262h = i47 + 1;
            bArr11[i47] = (byte) i3;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d1(int i3, long j3) throws IOException {
            a1(i3, 0);
            e1(j3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void e1(long j3) throws IOException {
            if (CodedOutputStream.f35252d && k0() >= 10) {
                while ((j3 & (-128)) != 0) {
                    byte[] bArr = this.f35259e;
                    int i3 = this.f35262h;
                    this.f35262h = i3 + 1;
                    ch.N(bArr, i3, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                }
                byte[] bArr2 = this.f35259e;
                int i16 = this.f35262h;
                this.f35262h = i16 + 1;
                ch.N(bArr2, i16, (byte) j3);
                return;
            }
            while ((j3 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f35259e;
                    int i17 = this.f35262h;
                    this.f35262h = i17 + 1;
                    bArr3[i17] = (byte) ((((int) j3) & 127) | 128);
                    j3 >>>= 7;
                } catch (IndexOutOfBoundsException e16) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), 1), e16);
                }
            }
            byte[] bArr4 = this.f35259e;
            int i18 = this.f35262h;
            this.f35262h = i18 + 1;
            bArr4[i18] = (byte) j3;
        }

        public final void f1(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f35259e, this.f35262h, remaining);
                this.f35262h += remaining;
            } catch (IndexOutOfBoundsException e16) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), Integer.valueOf(remaining)), e16);
            }
        }

        public final void g1(byte[] bArr, int i3, int i16) throws IOException {
            try {
                System.arraycopy(bArr, i3, this.f35259e, this.f35262h, i16);
                this.f35262h += i16;
            } catch (IndexOutOfBoundsException e16) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), Integer.valueOf(i16)), e16);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int k0() {
            return this.f35261g - this.f35262h;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void l0(byte b16) throws IOException {
            try {
                byte[] bArr = this.f35259e;
                int i3 = this.f35262h;
                this.f35262h = i3 + 1;
                bArr[i3] = b16;
            } catch (IndexOutOfBoundsException e16) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), 1), e16);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void m0(int i3, boolean z16) throws IOException {
            a1(i3, 0);
            l0(z16 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void p0(byte[] bArr, int i3, int i16) throws IOException {
            c1(i16);
            g1(bArr, i3, i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void q0(int i3, ByteString byteString) throws IOException {
            a1(i3, 2);
            r0(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void r0(ByteString byteString) throws IOException {
            c1(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void w0(int i3, int i16) throws IOException {
            a1(i3, 5);
            x0(i16);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void x0(int i3) throws IOException {
            try {
                byte[] bArr = this.f35259e;
                int i16 = this.f35262h;
                int i17 = i16 + 1;
                bArr[i16] = (byte) (i3 & 255);
                int i18 = i17 + 1;
                bArr[i17] = (byte) ((i3 >> 8) & 255);
                int i19 = i18 + 1;
                bArr[i18] = (byte) ((i3 >> 16) & 255);
                this.f35262h = i19 + 1;
                bArr[i19] = (byte) ((i3 >> 24) & 255);
            } catch (IndexOutOfBoundsException e16) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), 1), e16);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void y0(int i3, long j3) throws IOException {
            a1(i3, 1);
            z0(j3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void z0(long j3) throws IOException {
            try {
                byte[] bArr = this.f35259e;
                int i3 = this.f35262h;
                int i16 = i3 + 1;
                bArr[i3] = (byte) (((int) j3) & 255);
                int i17 = i16 + 1;
                bArr[i16] = (byte) (((int) (j3 >> 8)) & 255);
                int i18 = i17 + 1;
                bArr[i17] = (byte) (((int) (j3 >> 16)) & 255);
                int i19 = i18 + 1;
                bArr[i18] = (byte) (((int) (j3 >> 24)) & 255);
                int i26 = i19 + 1;
                bArr[i19] = (byte) (((int) (j3 >> 32)) & 255);
                int i27 = i26 + 1;
                bArr[i26] = (byte) (((int) (j3 >> 40)) & 255);
                int i28 = i27 + 1;
                bArr[i27] = (byte) (((int) (j3 >> 48)) & 255);
                this.f35262h = i28 + 1;
                bArr[i28] = (byte) (((int) (j3 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e16) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f35262h), Integer.valueOf(this.f35261g), 1), e16);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void e0() {
        }
    }
}
