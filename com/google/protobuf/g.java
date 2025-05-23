package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.am;
import cooperation.qzone.QZoneHelper;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
abstract class g implements bn {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35851a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35851a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35851a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35851a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35851a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35851a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35851a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35851a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35851a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35851a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35851a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35851a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35851a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35851a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35851a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35851a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35851a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35851a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class b extends g {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f35852a;

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f35853b;

        /* renamed from: c, reason: collision with root package name */
        private int f35854c;

        /* renamed from: d, reason: collision with root package name */
        private final int f35855d;

        /* renamed from: e, reason: collision with root package name */
        private int f35856e;

        /* renamed from: f, reason: collision with root package name */
        private int f35857f;

        /* renamed from: g, reason: collision with root package name */
        private int f35858g;

        public b(ByteBuffer byteBuffer, boolean z16) {
            super(null);
            this.f35852a = z16;
            this.f35853b = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f35854c = arrayOffset;
            this.f35855d = arrayOffset;
            this.f35856e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        private boolean R() {
            if (this.f35854c == this.f35856e) {
                return true;
            }
            return false;
        }

        private byte S() throws IOException {
            int i3 = this.f35854c;
            if (i3 != this.f35856e) {
                byte[] bArr = this.f35853b;
                this.f35854c = i3 + 1;
                return bArr[i3];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private Object T(WireFormat.FieldType fieldType, Class<?> cls, t tVar) throws IOException {
            switch (a.f35851a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(c());
                case 2:
                    return e();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(C());
                case 5:
                    return Integer.valueOf(p());
                case 6:
                    return Long.valueOf(w());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(h());
                case 9:
                    return Long.valueOf(b());
                case 10:
                    return o(cls, tVar);
                case 11:
                    return Integer.valueOf(A());
                case 12:
                    return Long.valueOf(K());
                case 13:
                    return Integer.valueOf(r());
                case 14:
                    return Long.valueOf(Q());
                case 15:
                    return B();
                case 16:
                    return Integer.valueOf(a());
                case 17:
                    return Long.valueOf(f());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private <T> T U(bq<T> bqVar, t tVar) throws IOException {
            int i3 = this.f35858g;
            this.f35858g = WireFormat.c(WireFormat.a(this.f35857f), 4);
            try {
                T newInstance = bqVar.newInstance();
                bqVar.i(newInstance, this, tVar);
                bqVar.g(newInstance);
                if (this.f35857f == this.f35858g) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.f35858g = i3;
            }
        }

        private int V() throws IOException {
            f0(4);
            return W();
        }

        private int W() {
            int i3 = this.f35854c;
            byte[] bArr = this.f35853b;
            this.f35854c = i3 + 4;
            return ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
        }

        private long X() throws IOException {
            f0(8);
            return Y();
        }

        private long Y() {
            int i3 = this.f35854c;
            byte[] bArr = this.f35853b;
            this.f35854c = i3 + 8;
            return ((bArr[i3 + 7] & 255) << 56) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 3] & 255) << 24) | ((bArr[i3 + 4] & 255) << 32) | ((bArr[i3 + 5] & 255) << 40) | ((bArr[i3 + 6] & 255) << 48);
        }

        private <T> T Z(bq<T> bqVar, t tVar) throws IOException {
            int c06 = c0();
            f0(c06);
            int i3 = this.f35856e;
            int i16 = this.f35854c + c06;
            this.f35856e = i16;
            try {
                T newInstance = bqVar.newInstance();
                bqVar.i(newInstance, this, tVar);
                bqVar.g(newInstance);
                if (this.f35854c == i16) {
                    return newInstance;
                }
                throw InvalidProtocolBufferException.parseFailure();
            } finally {
                this.f35856e = i3;
            }
        }

        private int c0() throws IOException {
            int i3;
            int i16 = this.f35854c;
            int i17 = this.f35856e;
            if (i17 != i16) {
                byte[] bArr = this.f35853b;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f35854c = i18;
                    return b16;
                }
                if (i17 - i18 < 9) {
                    return (int) e0();
                }
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
                                                if (bArr[i27] < 0) {
                                                    throw InvalidProtocolBufferException.malformedVarint();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i19 = i27;
                }
                this.f35854c = i19;
                return i3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private long e0() throws IOException {
            long j3 = 0;
            for (int i3 = 0; i3 < 64; i3 += 7) {
                j3 |= (r3 & Byte.MAX_VALUE) << i3;
                if ((S() & 128) == 0) {
                    return j3;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void f0(int i3) throws IOException {
            if (i3 >= 0 && i3 <= this.f35856e - this.f35854c) {
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void g0(int i3) throws IOException {
            if (this.f35854c == i3) {
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void h0(int i3) throws IOException {
            if (WireFormat.b(this.f35857f) == i3) {
            } else {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void i0(int i3) throws IOException {
            f0(i3);
            this.f35854c += i3;
        }

        private void j0() throws IOException {
            int i3 = this.f35858g;
            this.f35858g = WireFormat.c(WireFormat.a(this.f35857f), 4);
            while (t() != Integer.MAX_VALUE && m()) {
            }
            if (this.f35857f == this.f35858g) {
                this.f35858g = i3;
                return;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }

        private void k0() throws IOException {
            int i3 = this.f35856e;
            int i16 = this.f35854c;
            if (i3 - i16 >= 10) {
                byte[] bArr = this.f35853b;
                int i17 = 0;
                while (i17 < 10) {
                    int i18 = i16 + 1;
                    if (bArr[i16] >= 0) {
                        this.f35854c = i18;
                        return;
                    } else {
                        i17++;
                        i16 = i18;
                    }
                }
            }
            l0();
        }

        private void l0() throws IOException {
            for (int i3 = 0; i3 < 10; i3++) {
                if (S() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void m0(int i3) throws IOException {
            f0(i3);
            if ((i3 & 3) == 0) {
            } else {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void n0(int i3) throws IOException {
            f0(i3);
            if ((i3 & 7) == 0) {
            } else {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // com.google.protobuf.bn
        public int A() throws IOException {
            h0(5);
            return V();
        }

        @Override // com.google.protobuf.bn
        public String B() throws IOException {
            return a0(true);
        }

        @Override // com.google.protobuf.bn
        public int C() throws IOException {
            h0(0);
            return c0();
        }

        @Override // com.google.protobuf.bn
        public void D(List<Boolean> list) throws IOException {
            int i3;
            boolean z16;
            int i16;
            boolean z17;
            if (list instanceof h) {
                h hVar = (h) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            if (c0() != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            hVar.m(z17);
                        }
                        g0(c06);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    hVar.m(c());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        if (c0() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        list.add(Boolean.valueOf(z16));
                    }
                    g0(c07);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Boolean.valueOf(c()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public <T> T E(bq<T> bqVar, t tVar) throws IOException {
            h0(3);
            return (T) U(bqVar, tVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.bn
        public <T> void F(List<T> list, bq<T> bqVar, t tVar) throws IOException {
            int i3;
            if (WireFormat.b(this.f35857f) == 2) {
                int i16 = this.f35857f;
                do {
                    list.add(Z(bqVar, tVar));
                    if (R()) {
                        return;
                    } else {
                        i3 = this.f35854c;
                    }
                } while (c0() == i16);
                this.f35854c = i3;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.bn
        public void G(List<Long> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof aj) {
                aj ajVar = (aj) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            ajVar.m(d0());
                        }
                        g0(c06);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    ajVar.m(f());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Long.valueOf(d0()));
                    }
                    g0(c07);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(f()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public <T> T H(Class<T> cls, t tVar) throws IOException {
            h0(3);
            return (T) U(bi.a().d(cls), tVar);
        }

        @Override // com.google.protobuf.bn
        public void I(List<Long> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof aj) {
                aj ajVar = (aj) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 1) {
                    if (b16 == 2) {
                        int c06 = c0();
                        n0(c06);
                        int i17 = this.f35854c + c06;
                        while (this.f35854c < i17) {
                            ajVar.m(Y());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    ajVar.m(w());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 1) {
                if (b17 == 2) {
                    int c07 = c0();
                    n0(c07);
                    int i18 = this.f35854c + c07;
                    while (this.f35854c < i18) {
                        list.add(Long.valueOf(Y()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(w()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public <T> T J(bq<T> bqVar, t tVar) throws IOException {
            h0(2);
            return (T) Z(bqVar, tVar);
        }

        @Override // com.google.protobuf.bn
        public long K() throws IOException {
            h0(1);
            return X();
        }

        @Override // com.google.protobuf.bn
        public void L(List<Integer> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof ac) {
                ac acVar = (ac) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 2) {
                    if (b16 != 5) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    do {
                        acVar.e(p());
                        if (R()) {
                            return;
                        } else {
                            i16 = this.f35854c;
                        }
                    } while (c0() == this.f35857f);
                    this.f35854c = i16;
                    return;
                }
                int c06 = c0();
                m0(c06);
                int i17 = this.f35854c + c06;
                while (this.f35854c < i17) {
                    acVar.e(W());
                }
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 2) {
                if (b17 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(p()));
                    if (R()) {
                        return;
                    } else {
                        i3 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i3;
                return;
            }
            int c07 = c0();
            m0(c07);
            int i18 = this.f35854c + c07;
            while (this.f35854c < i18) {
                list.add(Integer.valueOf(W()));
            }
        }

        @Override // com.google.protobuf.bn
        public void M(List<String> list) throws IOException {
            b0(list, false);
        }

        @Override // com.google.protobuf.bn
        public void N(List<Double> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof o) {
                o oVar = (o) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 1) {
                    if (b16 == 2) {
                        int c06 = c0();
                        n0(c06);
                        int i17 = this.f35854c + c06;
                        while (this.f35854c < i17) {
                            oVar.i(Double.longBitsToDouble(Y()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    oVar.i(readDouble());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 1) {
                if (b17 == 2) {
                    int c07 = c0();
                    n0(c07);
                    int i18 = this.f35854c + c07;
                    while (this.f35854c < i18) {
                        list.add(Double.valueOf(Double.longBitsToDouble(Y())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Double.valueOf(readDouble()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public void O(List<Integer> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof ac) {
                ac acVar = (ac) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            acVar.e(c0());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    acVar.e(C());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Integer.valueOf(c0()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(C()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public void P(List<Integer> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof ac) {
                ac acVar = (ac) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            acVar.e(c0());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    acVar.e(a());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Integer.valueOf(c0()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(a()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public long Q() throws IOException {
            h0(0);
            return k.c(d0());
        }

        @Override // com.google.protobuf.bn
        public int a() throws IOException {
            h0(0);
            return c0();
        }

        public String a0(boolean z16) throws IOException {
            h0(2);
            int c06 = c0();
            if (c06 == 0) {
                return "";
            }
            f0(c06);
            if (z16) {
                byte[] bArr = this.f35853b;
                int i3 = this.f35854c;
                if (!Utf8.t(bArr, i3, i3 + c06)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.f35853b, this.f35854c, c06, ad.f35640a);
            this.f35854c += c06;
            return str;
        }

        @Override // com.google.protobuf.bn
        public long b() throws IOException {
            h0(0);
            return d0();
        }

        public void b0(List<String> list, boolean z16) throws IOException {
            int i3;
            int i16;
            if (WireFormat.b(this.f35857f) == 2) {
                if ((list instanceof ah) && !z16) {
                    ah ahVar = (ah) list;
                    do {
                        ahVar.f(e());
                        if (R()) {
                            return;
                        } else {
                            i16 = this.f35854c;
                        }
                    } while (c0() == this.f35857f);
                    this.f35854c = i16;
                    return;
                }
                do {
                    list.add(a0(z16));
                    if (R()) {
                        return;
                    } else {
                        i3 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i3;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.bn
        public boolean c() throws IOException {
            h0(0);
            if (c0() == 0) {
                return false;
            }
            return true;
        }

        @Override // com.google.protobuf.bn
        public String d() throws IOException {
            return a0(false);
        }

        public long d0() throws IOException {
            long j3;
            long j16;
            long j17;
            int i3;
            int i16 = this.f35854c;
            int i17 = this.f35856e;
            if (i17 != i16) {
                byte[] bArr = this.f35853b;
                int i18 = i16 + 1;
                byte b16 = bArr[i16];
                if (b16 >= 0) {
                    this.f35854c = i18;
                    return b16;
                }
                if (i17 - i18 < 9) {
                    return e0();
                }
                int i19 = i18 + 1;
                int i26 = b16 ^ (bArr[i18] << 7);
                if (i26 < 0) {
                    i3 = i26 ^ (-128);
                } else {
                    int i27 = i19 + 1;
                    int i28 = i26 ^ (bArr[i19] << RegisterType.DOUBLE_LO);
                    if (i28 >= 0) {
                        i19 = i27;
                        j3 = i28 ^ 16256;
                    } else {
                        i19 = i27 + 1;
                        int i29 = i28 ^ (bArr[i27] << QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER);
                        if (i29 < 0) {
                            i3 = i29 ^ (-2080896);
                        } else {
                            long j18 = i29;
                            int i36 = i19 + 1;
                            long j19 = j18 ^ (bArr[i19] << 28);
                            if (j19 >= 0) {
                                j17 = 266354560;
                            } else {
                                i19 = i36 + 1;
                                long j26 = j19 ^ (bArr[i36] << 35);
                                if (j26 < 0) {
                                    j16 = -34093383808L;
                                } else {
                                    i36 = i19 + 1;
                                    j19 = j26 ^ (bArr[i19] << 42);
                                    if (j19 >= 0) {
                                        j17 = 4363953127296L;
                                    } else {
                                        i19 = i36 + 1;
                                        j26 = j19 ^ (bArr[i36] << 49);
                                        if (j26 < 0) {
                                            j16 = -558586000294016L;
                                        } else {
                                            int i37 = i19 + 1;
                                            long j27 = (j26 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                            if (j27 < 0) {
                                                i19 = i37 + 1;
                                                if (bArr[i37] < 0) {
                                                    throw InvalidProtocolBufferException.malformedVarint();
                                                }
                                            } else {
                                                i19 = i37;
                                            }
                                            j3 = j27;
                                        }
                                    }
                                }
                                j3 = j26 ^ j16;
                            }
                            j3 = j19 ^ j17;
                            i19 = i36;
                        }
                    }
                    this.f35854c = i19;
                    return j3;
                }
                j3 = i3;
                this.f35854c = i19;
                return j3;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.google.protobuf.bn
        public ByteString e() throws IOException {
            ByteString copyFrom;
            h0(2);
            int c06 = c0();
            if (c06 == 0) {
                return ByteString.EMPTY;
            }
            f0(c06);
            if (this.f35852a) {
                copyFrom = ByteString.wrap(this.f35853b, this.f35854c, c06);
            } else {
                copyFrom = ByteString.copyFrom(this.f35853b, this.f35854c, c06);
            }
            this.f35854c += c06;
            return copyFrom;
        }

        @Override // com.google.protobuf.bn
        public long f() throws IOException {
            h0(0);
            return d0();
        }

        @Override // com.google.protobuf.bn
        public int getTag() {
            return this.f35857f;
        }

        @Override // com.google.protobuf.bn
        public int h() throws IOException {
            h0(0);
            return c0();
        }

        @Override // com.google.protobuf.bn
        public void i(List<Integer> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof ac) {
                ac acVar = (ac) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            acVar.e(k.b(c0()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    acVar.e(r());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Integer.valueOf(k.b(c0())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(r()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public void j(List<Long> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof aj) {
                aj ajVar = (aj) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 1) {
                    if (b16 == 2) {
                        int c06 = c0();
                        n0(c06);
                        int i17 = this.f35854c + c06;
                        while (this.f35854c < i17) {
                            ajVar.m(Y());
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    ajVar.m(K());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 1) {
                if (b17 == 2) {
                    int c07 = c0();
                    n0(c07);
                    int i18 = this.f35854c + c07;
                    while (this.f35854c < i18) {
                        list.add(Long.valueOf(Y()));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(K()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public void k(List<Integer> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof ac) {
                ac acVar = (ac) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            acVar.e(c0());
                        }
                        g0(c06);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    acVar.e(h());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Integer.valueOf(c0()));
                    }
                    g0(c07);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(h()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public boolean m() throws IOException {
            int i3;
            if (!R() && (i3 = this.f35857f) != this.f35858g) {
                int b16 = WireFormat.b(i3);
                if (b16 != 0) {
                    if (b16 != 1) {
                        if (b16 != 2) {
                            if (b16 != 3) {
                                if (b16 == 5) {
                                    i0(4);
                                    return true;
                                }
                                throw InvalidProtocolBufferException.invalidWireType();
                            }
                            j0();
                            return true;
                        }
                        i0(c0());
                        return true;
                    }
                    i0(8);
                    return true;
                }
                k0();
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.bn
        public void n(List<String> list) throws IOException {
            b0(list, true);
        }

        @Override // com.google.protobuf.bn
        public <T> T o(Class<T> cls, t tVar) throws IOException {
            h0(2);
            return (T) Z(bi.a().d(cls), tVar);
        }

        @Override // com.google.protobuf.bn
        public int p() throws IOException {
            h0(5);
            return V();
        }

        @Override // com.google.protobuf.bn
        public void q(List<Long> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof aj) {
                aj ajVar = (aj) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            ajVar.m(k.c(d0()));
                        }
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    ajVar.m(Q());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Long.valueOf(k.c(d0())));
                    }
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(Q()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public int r() throws IOException {
            h0(0);
            return k.b(c0());
        }

        @Override // com.google.protobuf.bn
        public double readDouble() throws IOException {
            h0(1);
            return Double.longBitsToDouble(X());
        }

        @Override // com.google.protobuf.bn
        public float readFloat() throws IOException {
            h0(5);
            return Float.intBitsToFloat(V());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.bn
        public <K, V> void s(Map<K, V> map, am.b<K, V> bVar, t tVar) throws IOException {
            h0(2);
            int c06 = c0();
            f0(c06);
            int i3 = this.f35856e;
            this.f35856e = this.f35854c + c06;
            try {
                Object obj = bVar.f35682b;
                Object obj2 = bVar.f35684d;
                while (true) {
                    int t16 = t();
                    if (t16 == Integer.MAX_VALUE) {
                        map.put(obj, obj2);
                        return;
                    }
                    if (t16 != 1) {
                        if (t16 != 2) {
                            try {
                                if (!m()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                    break;
                                }
                            } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                if (!m()) {
                                    throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                }
                            }
                        } else {
                            obj2 = T(bVar.f35683c, bVar.f35684d.getClass(), tVar);
                        }
                    } else {
                        obj = T(bVar.f35681a, null, null);
                    }
                }
            } finally {
                this.f35856e = i3;
            }
        }

        @Override // com.google.protobuf.bn
        public int t() throws IOException {
            if (R()) {
                return Integer.MAX_VALUE;
            }
            int c06 = c0();
            this.f35857f = c06;
            if (c06 == this.f35858g) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.a(c06);
        }

        @Override // com.google.protobuf.bn
        public void u(List<Float> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof aa) {
                aa aaVar = (aa) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 2) {
                    if (b16 != 5) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    do {
                        aaVar.j(readFloat());
                        if (R()) {
                            return;
                        } else {
                            i16 = this.f35854c;
                        }
                    } while (c0() == this.f35857f);
                    this.f35854c = i16;
                    return;
                }
                int c06 = c0();
                m0(c06);
                int i17 = this.f35854c + c06;
                while (this.f35854c < i17) {
                    aaVar.j(Float.intBitsToFloat(W()));
                }
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 2) {
                if (b17 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (R()) {
                        return;
                    } else {
                        i3 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i3;
                return;
            }
            int c07 = c0();
            m0(c07);
            int i18 = this.f35854c + c07;
            while (this.f35854c < i18) {
                list.add(Float.valueOf(Float.intBitsToFloat(W())));
            }
        }

        @Override // com.google.protobuf.bn
        public void v(List<ByteString> list) throws IOException {
            int i3;
            if (WireFormat.b(this.f35857f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(e());
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }

        @Override // com.google.protobuf.bn
        public long w() throws IOException {
            h0(1);
            return X();
        }

        @Override // com.google.protobuf.bn
        public void x(List<Integer> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof ac) {
                ac acVar = (ac) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 2) {
                    if (b16 != 5) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    do {
                        acVar.e(A());
                        if (R()) {
                            return;
                        } else {
                            i16 = this.f35854c;
                        }
                    } while (c0() == this.f35857f);
                    this.f35854c = i16;
                    return;
                }
                int c06 = c0();
                m0(c06);
                int i17 = this.f35854c + c06;
                while (this.f35854c < i17) {
                    acVar.e(W());
                }
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 2) {
                if (b17 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(A()));
                    if (R()) {
                        return;
                    } else {
                        i3 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i3;
                return;
            }
            int c07 = c0();
            m0(c07);
            int i18 = this.f35854c + c07;
            while (this.f35854c < i18) {
                list.add(Integer.valueOf(W()));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.bn
        public <T> void y(List<T> list, bq<T> bqVar, t tVar) throws IOException {
            int i3;
            if (WireFormat.b(this.f35857f) == 3) {
                int i16 = this.f35857f;
                do {
                    list.add(U(bqVar, tVar));
                    if (R()) {
                        return;
                    } else {
                        i3 = this.f35854c;
                    }
                } while (c0() == i16);
                this.f35854c = i3;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.google.protobuf.bn
        public void z(List<Long> list) throws IOException {
            int i3;
            int i16;
            if (list instanceof aj) {
                aj ajVar = (aj) list;
                int b16 = WireFormat.b(this.f35857f);
                if (b16 != 0) {
                    if (b16 == 2) {
                        int c06 = this.f35854c + c0();
                        while (this.f35854c < c06) {
                            ajVar.m(d0());
                        }
                        g0(c06);
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    ajVar.m(b());
                    if (R()) {
                        return;
                    } else {
                        i16 = this.f35854c;
                    }
                } while (c0() == this.f35857f);
                this.f35854c = i16;
                return;
            }
            int b17 = WireFormat.b(this.f35857f);
            if (b17 != 0) {
                if (b17 == 2) {
                    int c07 = this.f35854c + c0();
                    while (this.f35854c < c07) {
                        list.add(Long.valueOf(d0()));
                    }
                    g0(c07);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Long.valueOf(b()));
                if (R()) {
                    return;
                } else {
                    i3 = this.f35854c;
                }
            } while (c0() == this.f35857f);
            this.f35854c = i3;
        }
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    public static g g(ByteBuffer byteBuffer, boolean z16) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z16);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    @Override // com.google.protobuf.bn
    public boolean l() {
        return false;
    }

    g() {
    }
}
