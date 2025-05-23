package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class cd {

    /* renamed from: f, reason: collision with root package name */
    private static final cd f35806f = new cd(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    private int f35807a;

    /* renamed from: b, reason: collision with root package name */
    private int[] f35808b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f35809c;

    /* renamed from: d, reason: collision with root package name */
    private int f35810d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f35811e;

    cd() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i3;
        int i16 = this.f35807a;
        int[] iArr = this.f35808b;
        if (i16 == iArr.length) {
            if (i16 < 4) {
                i3 = 8;
            } else {
                i3 = i16 >> 1;
            }
            int i17 = i16 + i3;
            this.f35808b = Arrays.copyOf(iArr, i17);
            this.f35809c = Arrays.copyOf(this.f35809c, i17);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (iArr[i16] != iArr2[i16]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i3) {
        for (int i16 = 0; i16 < i3; i16++) {
            if (!objArr[i16].equals(objArr2[i16])) {
                return false;
            }
        }
        return true;
    }

    public static cd e() {
        return f35806f;
    }

    private static int h(int[] iArr, int i3) {
        int i16 = 17;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (i16 * 31) + iArr[i17];
        }
        return i16;
    }

    private static int i(Object[] objArr, int i3) {
        int i16 = 17;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (i16 * 31) + objArr[i17].hashCode();
        }
        return i16;
    }

    private cd l(k kVar) throws IOException {
        int J;
        do {
            J = kVar.J();
            if (J == 0) {
                break;
            }
        } while (k(J, kVar));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cd o(cd cdVar, cd cdVar2) {
        int i3 = cdVar.f35807a + cdVar2.f35807a;
        int[] copyOf = Arrays.copyOf(cdVar.f35808b, i3);
        System.arraycopy(cdVar2.f35808b, 0, copyOf, cdVar.f35807a, cdVar2.f35807a);
        Object[] copyOf2 = Arrays.copyOf(cdVar.f35809c, i3);
        System.arraycopy(cdVar2.f35809c, 0, copyOf2, cdVar.f35807a, cdVar2.f35807a);
        return new cd(i3, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cd p() {
        return new cd();
    }

    private static void t(int i3, Object obj, Writer writer) throws IOException {
        int a16 = WireFormat.a(i3);
        int b16 = WireFormat.b(i3);
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 != 2) {
                    if (b16 != 3) {
                        if (b16 == 5) {
                            writer.j(a16, ((Integer) obj).intValue());
                            return;
                        }
                        throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
                    }
                    if (writer.F() == Writer.FieldOrder.ASCENDING) {
                        writer.K(a16);
                        ((cd) obj).u(writer);
                        writer.B(a16);
                        return;
                    } else {
                        writer.B(a16);
                        ((cd) obj).u(writer);
                        writer.K(a16);
                        return;
                    }
                }
                writer.m(a16, (ByteString) obj);
                return;
            }
            writer.J(a16, ((Long) obj).longValue());
            return;
        }
        writer.c(a16, ((Long) obj).longValue());
    }

    void a() {
        if (this.f35811e) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof cd)) {
            return false;
        }
        cd cdVar = (cd) obj;
        int i3 = this.f35807a;
        if (i3 == cdVar.f35807a && c(this.f35808b, cdVar.f35808b, i3) && d(this.f35809c, cdVar.f35809c, this.f35807a)) {
            return true;
        }
        return false;
    }

    public int f() {
        int a06;
        int i3 = this.f35810d;
        if (i3 != -1) {
            return i3;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f35807a; i17++) {
            int i18 = this.f35808b[i17];
            int a16 = WireFormat.a(i18);
            int b16 = WireFormat.b(i18);
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 != 3) {
                            if (b16 == 5) {
                                a06 = CodedOutputStream.n(a16, ((Integer) this.f35809c[i17]).intValue());
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                            }
                        } else {
                            a06 = (CodedOutputStream.X(a16) * 2) + ((cd) this.f35809c[i17]).f();
                        }
                    } else {
                        a06 = CodedOutputStream.h(a16, (ByteString) this.f35809c[i17]);
                    }
                } else {
                    a06 = CodedOutputStream.p(a16, ((Long) this.f35809c[i17]).longValue());
                }
            } else {
                a06 = CodedOutputStream.a0(a16, ((Long) this.f35809c[i17]).longValue());
            }
            i16 += a06;
        }
        this.f35810d = i16;
        return i16;
    }

    public int g() {
        int i3 = this.f35810d;
        if (i3 != -1) {
            return i3;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f35807a; i17++) {
            i16 += CodedOutputStream.L(WireFormat.a(this.f35808b[i17]), (ByteString) this.f35809c[i17]);
        }
        this.f35810d = i16;
        return i16;
    }

    public int hashCode() {
        int i3 = this.f35807a;
        return ((((527 + i3) * 31) + h(this.f35808b, i3)) * 31) + i(this.f35809c, this.f35807a);
    }

    public void j() {
        this.f35811e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(int i3, k kVar) throws IOException {
        a();
        int a16 = WireFormat.a(i3);
        int b16 = WireFormat.b(i3);
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 != 2) {
                    if (b16 != 3) {
                        if (b16 != 4) {
                            if (b16 == 5) {
                                r(i3, Integer.valueOf(kVar.t()));
                                return true;
                            }
                            throw InvalidProtocolBufferException.invalidWireType();
                        }
                        return false;
                    }
                    cd cdVar = new cd();
                    cdVar.l(kVar);
                    kVar.a(WireFormat.c(a16, 4));
                    r(i3, cdVar);
                    return true;
                }
                r(i3, kVar.q());
                return true;
            }
            r(i3, Long.valueOf(kVar.u()));
            return true;
        }
        r(i3, Long.valueOf(kVar.y()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd m(int i3, ByteString byteString) {
        a();
        if (i3 != 0) {
            r(WireFormat.c(i3, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd n(int i3, int i16) {
        a();
        if (i3 != 0) {
            r(WireFormat.c(i3, 0), Long.valueOf(i16));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(StringBuilder sb5, int i3) {
        for (int i16 = 0; i16 < this.f35807a; i16++) {
            aw.c(sb5, i3, String.valueOf(WireFormat.a(this.f35808b[i16])), this.f35809c[i16]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i3, Object obj) {
        a();
        b();
        int[] iArr = this.f35808b;
        int i16 = this.f35807a;
        iArr[i16] = i3;
        this.f35809c[i16] = obj;
        this.f35807a = i16 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Writer writer) throws IOException {
        if (writer.F() == Writer.FieldOrder.DESCENDING) {
            for (int i3 = this.f35807a - 1; i3 >= 0; i3--) {
                writer.I(WireFormat.a(this.f35808b[i3]), this.f35809c[i3]);
            }
            return;
        }
        for (int i16 = 0; i16 < this.f35807a; i16++) {
            writer.I(WireFormat.a(this.f35808b[i16]), this.f35809c[i16]);
        }
    }

    public void u(Writer writer) throws IOException {
        if (this.f35807a == 0) {
            return;
        }
        if (writer.F() == Writer.FieldOrder.ASCENDING) {
            for (int i3 = 0; i3 < this.f35807a; i3++) {
                t(this.f35808b[i3], this.f35809c[i3], writer);
            }
            return;
        }
        for (int i16 = this.f35807a - 1; i16 >= 0; i16--) {
            t(this.f35808b[i16], this.f35809c[i16], writer);
        }
    }

    cd(int i3, int[] iArr, Object[] objArr, boolean z16) {
        this.f35810d = -1;
        this.f35807a = i3;
        this.f35808b = iArr;
        this.f35809c = objArr;
        this.f35811e = z16;
    }
}
