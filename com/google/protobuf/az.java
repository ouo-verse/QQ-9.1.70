package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.ae;
import com.google.protobuf.f;
import com.google.protobuf.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
final class az<T> implements bq<T> {

    /* renamed from: a, reason: collision with root package name */
    private final au f35707a;

    /* renamed from: b, reason: collision with root package name */
    private final cb<?, ?> f35708b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f35709c;

    /* renamed from: d, reason: collision with root package name */
    private final u<?> f35710d;

    az(cb<?, ?> cbVar, u<?> uVar, au auVar) {
        this.f35708b = cbVar;
        this.f35709c = uVar.e(auVar);
        this.f35710d = uVar;
        this.f35707a = auVar;
    }

    private <UT, UB> int j(cb<UT, UB> cbVar, T t16) {
        return cbVar.i(cbVar.g(t16));
    }

    private <UT, UB, ET extends z.c<ET>> void k(cb<UT, UB> cbVar, u<ET> uVar, T t16, bn bnVar, t tVar) throws IOException {
        UB f16 = cbVar.f(t16);
        z<ET> d16 = uVar.d(t16);
        do {
            try {
                if (bnVar.t() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                cbVar.o(t16, f16);
            }
        } while (m(bnVar, tVar, uVar, d16, cbVar, f16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> az<T> l(cb<?, ?> cbVar, u<?> uVar, au auVar) {
        return new az<>(cbVar, uVar, auVar);
    }

    private <UT, UB, ET extends z.c<ET>> boolean m(bn bnVar, t tVar, u<ET> uVar, z<ET> zVar, cb<UT, UB> cbVar, UB ub5) throws IOException {
        int tag = bnVar.getTag();
        if (tag != WireFormat.f35627a) {
            if (WireFormat.b(tag) == 2) {
                Object b16 = uVar.b(tVar, this.f35707a, WireFormat.a(tag));
                if (b16 != null) {
                    uVar.h(bnVar, b16, tVar, zVar);
                    return true;
                }
                return cbVar.m(ub5, bnVar);
            }
            return bnVar.m();
        }
        Object obj = null;
        int i3 = 0;
        ByteString byteString = null;
        while (bnVar.t() != Integer.MAX_VALUE) {
            int tag2 = bnVar.getTag();
            if (tag2 == WireFormat.f35629c) {
                i3 = bnVar.a();
                obj = uVar.b(tVar, this.f35707a, i3);
            } else if (tag2 == WireFormat.f35630d) {
                if (obj != null) {
                    uVar.h(bnVar, obj, tVar, zVar);
                } else {
                    byteString = bnVar.e();
                }
            } else if (!bnVar.m()) {
                break;
            }
        }
        if (bnVar.getTag() == WireFormat.f35628b) {
            if (byteString != null) {
                if (obj != null) {
                    uVar.i(byteString, obj, tVar, zVar);
                } else {
                    cbVar.d(ub5, i3, byteString);
                }
            }
            return true;
        }
        throw InvalidProtocolBufferException.invalidEndTag();
    }

    private <UT, UB> void n(cb<UT, UB> cbVar, T t16, Writer writer) throws IOException {
        cbVar.s(cbVar.g(t16), writer);
    }

    @Override // com.google.protobuf.bq
    public void a(T t16, T t17) {
        bs.H(this.f35708b, t16, t17);
        if (this.f35709c) {
            bs.F(this.f35710d, t16, t17);
        }
    }

    @Override // com.google.protobuf.bq
    public final boolean b(T t16) {
        return this.f35710d.c(t16).C();
    }

    @Override // com.google.protobuf.bq
    public int c(T t16) {
        int hashCode = this.f35708b.g(t16).hashCode();
        if (this.f35709c) {
            return (hashCode * 53) + this.f35710d.c(t16).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.protobuf.bq
    public boolean d(T t16, T t17) {
        if (!this.f35708b.g(t16).equals(this.f35708b.g(t17))) {
            return false;
        }
        if (this.f35709c) {
            return this.f35710d.c(t16).equals(this.f35710d.c(t17));
        }
        return true;
    }

    @Override // com.google.protobuf.bq
    public void e(T t16, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> F = this.f35710d.c(t16).F();
        while (F.hasNext()) {
            Map.Entry<?, Object> next = F.next();
            z.c cVar = (z.c) next.getKey();
            if (cVar.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !cVar.isRepeated() && !cVar.isPacked()) {
                if (next instanceof ae.b) {
                    writer.I(cVar.getNumber(), ((ae.b) next).a().f());
                } else {
                    writer.I(cVar.getNumber(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        n(this.f35708b, t16, writer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb A[EDGE_INSN: B:24:0x00cb->B:25:0x00cb BREAK  A[LOOP:1: B:10:0x006d->B:18:0x006d], SYNTHETIC] */
    @Override // com.google.protobuf.bq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(T t16, byte[] bArr, int i3, int i16, f.b bVar) throws IOException {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t16;
        cd cdVar = generatedMessageLite.unknownFields;
        if (cdVar == cd.e()) {
            cdVar = cd.p();
            generatedMessageLite.unknownFields = cdVar;
        }
        z<GeneratedMessageLite.d> p16 = ((GeneratedMessageLite.c) t16).p();
        GeneratedMessageLite.e eVar = null;
        while (i3 < i16) {
            int I = f.I(bArr, i3, bVar);
            int i17 = bVar.f35847a;
            if (i17 != WireFormat.f35627a) {
                if (WireFormat.b(i17) == 2) {
                    GeneratedMessageLite.e eVar2 = (GeneratedMessageLite.e) this.f35710d.b(bVar.f35850d, this.f35707a, WireFormat.a(i17));
                    if (eVar2 != null) {
                        i3 = f.p(bi.a().d(eVar2.c().getClass()), bArr, I, i16, bVar);
                        p16.M(eVar2.f35503d, bVar.f35849c);
                    } else {
                        i3 = f.G(i17, bArr, I, i16, cdVar, bVar);
                    }
                    eVar = eVar2;
                } else {
                    i3 = f.N(i17, bArr, I, i16, bVar);
                }
            } else {
                int i18 = 0;
                ByteString byteString = null;
                while (I < i16) {
                    I = f.I(bArr, I, bVar);
                    int i19 = bVar.f35847a;
                    int a16 = WireFormat.a(i19);
                    int b16 = WireFormat.b(i19);
                    if (a16 != 2) {
                        if (a16 == 3) {
                            if (eVar != null) {
                                I = f.p(bi.a().d(eVar.c().getClass()), bArr, I, i16, bVar);
                                p16.M(eVar.f35503d, bVar.f35849c);
                            } else if (b16 == 2) {
                                I = f.b(bArr, I, bVar);
                                byteString = (ByteString) bVar.f35849c;
                            }
                        }
                        if (i19 != WireFormat.f35628b) {
                            break;
                        } else {
                            I = f.N(i19, bArr, I, i16, bVar);
                        }
                    } else if (b16 == 0) {
                        I = f.I(bArr, I, bVar);
                        i18 = bVar.f35847a;
                        eVar = (GeneratedMessageLite.e) this.f35710d.b(bVar.f35850d, this.f35707a, i18);
                    } else if (i19 != WireFormat.f35628b) {
                    }
                }
                if (byteString != null) {
                    cdVar.r(WireFormat.c(i18, 2), byteString);
                }
                i3 = I;
            }
        }
        if (i3 == i16) {
        } else {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // com.google.protobuf.bq
    public void g(T t16) {
        this.f35708b.j(t16);
        this.f35710d.f(t16);
    }

    @Override // com.google.protobuf.bq
    public int h(T t16) {
        int j3 = j(this.f35708b, t16) + 0;
        if (this.f35709c) {
            return j3 + this.f35710d.c(t16).t();
        }
        return j3;
    }

    @Override // com.google.protobuf.bq
    public void i(T t16, bn bnVar, t tVar) throws IOException {
        k(this.f35708b, this.f35710d, t16, bnVar, tVar);
    }

    @Override // com.google.protobuf.bq
    public T newInstance() {
        return (T) this.f35707a.newBuilderForType().buildPartial();
    }
}
