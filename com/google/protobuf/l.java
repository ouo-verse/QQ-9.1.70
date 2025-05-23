package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.WireFormat;
import com.google.protobuf.am;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class l implements bn {

    /* renamed from: a, reason: collision with root package name */
    private final k f35897a;

    /* renamed from: b, reason: collision with root package name */
    private int f35898b;

    /* renamed from: c, reason: collision with root package name */
    private int f35899c;

    /* renamed from: d, reason: collision with root package name */
    private int f35900d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35901a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35901a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35901a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35901a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35901a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35901a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35901a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35901a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35901a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35901a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35901a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35901a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35901a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35901a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35901a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35901a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35901a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35901a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    l(k kVar) {
        k kVar2 = (k) ad.b(kVar, "input");
        this.f35897a = kVar2;
        kVar2.f35868d = this;
    }

    private Object R(WireFormat.FieldType fieldType, Class<?> cls, t tVar) throws IOException {
        switch (a.f35901a[fieldType.ordinal()]) {
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

    private <T> T S(bq<T> bqVar, t tVar) throws IOException {
        int i3 = this.f35899c;
        this.f35899c = WireFormat.c(WireFormat.a(this.f35898b), 4);
        try {
            T newInstance = bqVar.newInstance();
            bqVar.i(newInstance, this, tVar);
            bqVar.g(newInstance);
            if (this.f35898b == this.f35899c) {
                return newInstance;
            }
            throw InvalidProtocolBufferException.parseFailure();
        } finally {
            this.f35899c = i3;
        }
    }

    private <T> T T(bq<T> bqVar, t tVar) throws IOException {
        int K = this.f35897a.K();
        k kVar = this.f35897a;
        if (kVar.f35865a < kVar.f35866b) {
            int o16 = kVar.o(K);
            T newInstance = bqVar.newInstance();
            this.f35897a.f35865a++;
            bqVar.i(newInstance, this, tVar);
            bqVar.g(newInstance);
            this.f35897a.a(0);
            r5.f35865a--;
            this.f35897a.n(o16);
            return newInstance;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    private void V(int i3) throws IOException {
        if (this.f35897a.e() == i3) {
        } else {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void W(int i3) throws IOException {
        if (WireFormat.b(this.f35898b) == i3) {
        } else {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void X(int i3) throws IOException {
        if ((i3 & 3) == 0) {
        } else {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void Y(int i3) throws IOException {
        if ((i3 & 7) == 0) {
        } else {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    public static l g(k kVar) {
        l lVar = kVar.f35868d;
        if (lVar != null) {
            return lVar;
        }
        return new l(kVar);
    }

    @Override // com.google.protobuf.bn
    public int A() throws IOException {
        W(5);
        return this.f35897a.D();
    }

    @Override // com.google.protobuf.bn
    public String B() throws IOException {
        W(2);
        return this.f35897a.I();
    }

    @Override // com.google.protobuf.bn
    public int C() throws IOException {
        W(0);
        return this.f35897a.s();
    }

    @Override // com.google.protobuf.bn
    public void D(List<Boolean> list) throws IOException {
        int J;
        int J2;
        if (list instanceof h) {
            h hVar = (h) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        hVar.m(this.f35897a.p());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                hVar.m(this.f35897a.p());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Boolean.valueOf(this.f35897a.p()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Boolean.valueOf(this.f35897a.p()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public <T> T E(bq<T> bqVar, t tVar) throws IOException {
        W(3);
        return (T) S(bqVar, tVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.bn
    public <T> void F(List<T> list, bq<T> bqVar, t tVar) throws IOException {
        int J;
        if (WireFormat.b(this.f35898b) == 2) {
            int i3 = this.f35898b;
            do {
                list.add(T(bqVar, tVar));
                if (!this.f35897a.f() && this.f35900d == 0) {
                    J = this.f35897a.J();
                } else {
                    return;
                }
            } while (J == i3);
            this.f35900d = J;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.bn
    public void G(List<Long> list) throws IOException {
        int J;
        int J2;
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        ajVar.m(this.f35897a.L());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                ajVar.m(this.f35897a.L());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Long.valueOf(this.f35897a.L()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(this.f35897a.L()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public <T> T H(Class<T> cls, t tVar) throws IOException {
        W(3);
        return (T) S(bi.a().d(cls), tVar);
    }

    @Override // com.google.protobuf.bn
    public void I(List<Long> list) throws IOException {
        int J;
        int J2;
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 1) {
                if (b16 == 2) {
                    int K = this.f35897a.K();
                    Y(K);
                    int e16 = this.f35897a.e() + K;
                    do {
                        ajVar.m(this.f35897a.u());
                    } while (this.f35897a.e() < e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                ajVar.m(this.f35897a.u());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 1) {
            if (b17 == 2) {
                int K2 = this.f35897a.K();
                Y(K2);
                int e17 = this.f35897a.e() + K2;
                do {
                    list.add(Long.valueOf(this.f35897a.u()));
                } while (this.f35897a.e() < e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(this.f35897a.u()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public <T> T J(bq<T> bqVar, t tVar) throws IOException {
        W(2);
        return (T) T(bqVar, tVar);
    }

    @Override // com.google.protobuf.bn
    public long K() throws IOException {
        W(1);
        return this.f35897a.E();
    }

    @Override // com.google.protobuf.bn
    public void L(List<Integer> list) throws IOException {
        int J;
        int J2;
        if (list instanceof ac) {
            ac acVar = (ac) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 2) {
                if (b16 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    acVar.e(this.f35897a.t());
                    if (this.f35897a.f()) {
                        return;
                    } else {
                        J2 = this.f35897a.J();
                    }
                } while (J2 == this.f35898b);
                this.f35900d = J2;
                return;
            }
            int K = this.f35897a.K();
            X(K);
            int e16 = this.f35897a.e() + K;
            do {
                acVar.e(this.f35897a.t());
            } while (this.f35897a.e() < e16);
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 2) {
            if (b17 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f35897a.t()));
                if (this.f35897a.f()) {
                    return;
                } else {
                    J = this.f35897a.J();
                }
            } while (J == this.f35898b);
            this.f35900d = J;
            return;
        }
        int K2 = this.f35897a.K();
        X(K2);
        int e17 = this.f35897a.e() + K2;
        do {
            list.add(Integer.valueOf(this.f35897a.t()));
        } while (this.f35897a.e() < e17);
    }

    @Override // com.google.protobuf.bn
    public void M(List<String> list) throws IOException {
        U(list, false);
    }

    @Override // com.google.protobuf.bn
    public void N(List<Double> list) throws IOException {
        int J;
        int J2;
        if (list instanceof o) {
            o oVar = (o) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 1) {
                if (b16 == 2) {
                    int K = this.f35897a.K();
                    Y(K);
                    int e16 = this.f35897a.e() + K;
                    do {
                        oVar.i(this.f35897a.r());
                    } while (this.f35897a.e() < e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                oVar.i(this.f35897a.r());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 1) {
            if (b17 == 2) {
                int K2 = this.f35897a.K();
                Y(K2);
                int e17 = this.f35897a.e() + K2;
                do {
                    list.add(Double.valueOf(this.f35897a.r()));
                } while (this.f35897a.e() < e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Double.valueOf(this.f35897a.r()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public void O(List<Integer> list) throws IOException {
        int J;
        int J2;
        if (list instanceof ac) {
            ac acVar = (ac) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        acVar.e(this.f35897a.s());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                acVar.e(this.f35897a.s());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Integer.valueOf(this.f35897a.s()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(this.f35897a.s()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public void P(List<Integer> list) throws IOException {
        int J;
        int J2;
        if (list instanceof ac) {
            ac acVar = (ac) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        acVar.e(this.f35897a.K());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                acVar.e(this.f35897a.K());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Integer.valueOf(this.f35897a.K()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(this.f35897a.K()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public long Q() throws IOException {
        W(0);
        return this.f35897a.G();
    }

    public void U(List<String> list, boolean z16) throws IOException {
        String d16;
        int J;
        int J2;
        if (WireFormat.b(this.f35898b) == 2) {
            if ((list instanceof ah) && !z16) {
                ah ahVar = (ah) list;
                do {
                    ahVar.f(e());
                    if (this.f35897a.f()) {
                        return;
                    } else {
                        J2 = this.f35897a.J();
                    }
                } while (J2 == this.f35898b);
                this.f35900d = J2;
                return;
            }
            do {
                if (z16) {
                    d16 = B();
                } else {
                    d16 = d();
                }
                list.add(d16);
                if (this.f35897a.f()) {
                    return;
                } else {
                    J = this.f35897a.J();
                }
            } while (J == this.f35898b);
            this.f35900d = J;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.bn
    public int a() throws IOException {
        W(0);
        return this.f35897a.K();
    }

    @Override // com.google.protobuf.bn
    public long b() throws IOException {
        W(0);
        return this.f35897a.y();
    }

    @Override // com.google.protobuf.bn
    public boolean c() throws IOException {
        W(0);
        return this.f35897a.p();
    }

    @Override // com.google.protobuf.bn
    public String d() throws IOException {
        W(2);
        return this.f35897a.H();
    }

    @Override // com.google.protobuf.bn
    public ByteString e() throws IOException {
        W(2);
        return this.f35897a.q();
    }

    @Override // com.google.protobuf.bn
    public long f() throws IOException {
        W(0);
        return this.f35897a.L();
    }

    @Override // com.google.protobuf.bn
    public int getTag() {
        return this.f35898b;
    }

    @Override // com.google.protobuf.bn
    public int h() throws IOException {
        W(0);
        return this.f35897a.x();
    }

    @Override // com.google.protobuf.bn
    public void i(List<Integer> list) throws IOException {
        int J;
        int J2;
        if (list instanceof ac) {
            ac acVar = (ac) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        acVar.e(this.f35897a.F());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                acVar.e(this.f35897a.F());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Integer.valueOf(this.f35897a.F()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(this.f35897a.F()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public void j(List<Long> list) throws IOException {
        int J;
        int J2;
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 1) {
                if (b16 == 2) {
                    int K = this.f35897a.K();
                    Y(K);
                    int e16 = this.f35897a.e() + K;
                    do {
                        ajVar.m(this.f35897a.E());
                    } while (this.f35897a.e() < e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                ajVar.m(this.f35897a.E());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 1) {
            if (b17 == 2) {
                int K2 = this.f35897a.K();
                Y(K2);
                int e17 = this.f35897a.e() + K2;
                do {
                    list.add(Long.valueOf(this.f35897a.E()));
                } while (this.f35897a.e() < e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(this.f35897a.E()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public void k(List<Integer> list) throws IOException {
        int J;
        int J2;
        if (list instanceof ac) {
            ac acVar = (ac) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        acVar.e(this.f35897a.x());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                acVar.e(this.f35897a.x());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Integer.valueOf(this.f35897a.x()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Integer.valueOf(this.f35897a.x()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public boolean l() {
        return this.f35897a.M();
    }

    @Override // com.google.protobuf.bn
    public boolean m() throws IOException {
        int i3;
        if (!this.f35897a.f() && (i3 = this.f35898b) != this.f35899c) {
            return this.f35897a.N(i3);
        }
        return false;
    }

    @Override // com.google.protobuf.bn
    public void n(List<String> list) throws IOException {
        U(list, true);
    }

    @Override // com.google.protobuf.bn
    public <T> T o(Class<T> cls, t tVar) throws IOException {
        W(2);
        return (T) T(bi.a().d(cls), tVar);
    }

    @Override // com.google.protobuf.bn
    public int p() throws IOException {
        W(5);
        return this.f35897a.t();
    }

    @Override // com.google.protobuf.bn
    public void q(List<Long> list) throws IOException {
        int J;
        int J2;
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        ajVar.m(this.f35897a.G());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                ajVar.m(this.f35897a.G());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Long.valueOf(this.f35897a.G()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(this.f35897a.G()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public int r() throws IOException {
        W(0);
        return this.f35897a.F();
    }

    @Override // com.google.protobuf.bn
    public double readDouble() throws IOException {
        W(1);
        return this.f35897a.r();
    }

    @Override // com.google.protobuf.bn
    public float readFloat() throws IOException {
        W(5);
        return this.f35897a.v();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.bn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <K, V> void s(Map<K, V> map, am.b<K, V> bVar, t tVar) throws IOException {
        W(2);
        int o16 = this.f35897a.o(this.f35897a.K());
        Object obj = bVar.f35682b;
        Object obj2 = bVar.f35684d;
        while (true) {
            try {
                int t16 = t();
                if (t16 == Integer.MAX_VALUE || this.f35897a.f()) {
                    break;
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
                        obj2 = R(bVar.f35683c, bVar.f35684d.getClass(), tVar);
                    }
                } else {
                    obj = R(bVar.f35681a, null, null);
                }
            } finally {
                this.f35897a.n(o16);
            }
        }
    }

    @Override // com.google.protobuf.bn
    public int t() throws IOException {
        int i3 = this.f35900d;
        if (i3 != 0) {
            this.f35898b = i3;
            this.f35900d = 0;
        } else {
            this.f35898b = this.f35897a.J();
        }
        int i16 = this.f35898b;
        if (i16 != 0 && i16 != this.f35899c) {
            return WireFormat.a(i16);
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.google.protobuf.bn
    public void u(List<Float> list) throws IOException {
        int J;
        int J2;
        if (list instanceof aa) {
            aa aaVar = (aa) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 2) {
                if (b16 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    aaVar.j(this.f35897a.v());
                    if (this.f35897a.f()) {
                        return;
                    } else {
                        J2 = this.f35897a.J();
                    }
                } while (J2 == this.f35898b);
                this.f35900d = J2;
                return;
            }
            int K = this.f35897a.K();
            X(K);
            int e16 = this.f35897a.e() + K;
            do {
                aaVar.j(this.f35897a.v());
            } while (this.f35897a.e() < e16);
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 2) {
            if (b17 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.f35897a.v()));
                if (this.f35897a.f()) {
                    return;
                } else {
                    J = this.f35897a.J();
                }
            } while (J == this.f35898b);
            this.f35900d = J;
            return;
        }
        int K2 = this.f35897a.K();
        X(K2);
        int e17 = this.f35897a.e() + K2;
        do {
            list.add(Float.valueOf(this.f35897a.v()));
        } while (this.f35897a.e() < e17);
    }

    @Override // com.google.protobuf.bn
    public void v(List<ByteString> list) throws IOException {
        int J;
        if (WireFormat.b(this.f35898b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(e());
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }

    @Override // com.google.protobuf.bn
    public long w() throws IOException {
        W(1);
        return this.f35897a.u();
    }

    @Override // com.google.protobuf.bn
    public void x(List<Integer> list) throws IOException {
        int J;
        int J2;
        if (list instanceof ac) {
            ac acVar = (ac) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 2) {
                if (b16 != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    acVar.e(this.f35897a.D());
                    if (this.f35897a.f()) {
                        return;
                    } else {
                        J2 = this.f35897a.J();
                    }
                } while (J2 == this.f35898b);
                this.f35900d = J2;
                return;
            }
            int K = this.f35897a.K();
            X(K);
            int e16 = this.f35897a.e() + K;
            do {
                acVar.e(this.f35897a.D());
            } while (this.f35897a.e() < e16);
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 2) {
            if (b17 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f35897a.D()));
                if (this.f35897a.f()) {
                    return;
                } else {
                    J = this.f35897a.J();
                }
            } while (J == this.f35898b);
            this.f35900d = J;
            return;
        }
        int K2 = this.f35897a.K();
        X(K2);
        int e17 = this.f35897a.e() + K2;
        do {
            list.add(Integer.valueOf(this.f35897a.D()));
        } while (this.f35897a.e() < e17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.bn
    public <T> void y(List<T> list, bq<T> bqVar, t tVar) throws IOException {
        int J;
        if (WireFormat.b(this.f35898b) == 3) {
            int i3 = this.f35898b;
            do {
                list.add(S(bqVar, tVar));
                if (!this.f35897a.f() && this.f35900d == 0) {
                    J = this.f35897a.J();
                } else {
                    return;
                }
            } while (J == i3);
            this.f35900d = J;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    @Override // com.google.protobuf.bn
    public void z(List<Long> list) throws IOException {
        int J;
        int J2;
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            int b16 = WireFormat.b(this.f35898b);
            if (b16 != 0) {
                if (b16 == 2) {
                    int e16 = this.f35897a.e() + this.f35897a.K();
                    do {
                        ajVar.m(this.f35897a.y());
                    } while (this.f35897a.e() < e16);
                    V(e16);
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                ajVar.m(this.f35897a.y());
                if (this.f35897a.f()) {
                    return;
                } else {
                    J2 = this.f35897a.J();
                }
            } while (J2 == this.f35898b);
            this.f35900d = J2;
            return;
        }
        int b17 = WireFormat.b(this.f35898b);
        if (b17 != 0) {
            if (b17 == 2) {
                int e17 = this.f35897a.e() + this.f35897a.K();
                do {
                    list.add(Long.valueOf(this.f35897a.y()));
                } while (this.f35897a.e() < e17);
                V(e17);
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(Long.valueOf(this.f35897a.y()));
            if (this.f35897a.f()) {
                return;
            } else {
                J = this.f35897a.J();
            }
        } while (J == this.f35898b);
        this.f35900d = J;
    }
}
