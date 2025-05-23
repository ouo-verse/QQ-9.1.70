package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
final class w extends u<GeneratedMessageLite.d> {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35958a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35958a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35958a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35958a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35958a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35958a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35958a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35958a[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35958a[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35958a[WireFormat.FieldType.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35958a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35958a[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35958a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35958a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35958a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35958a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35958a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35958a[WireFormat.FieldType.f35631GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35958a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).getNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public Object b(t tVar, au auVar, int i3) {
        return tVar.a(auVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public z<GeneratedMessageLite.d> c(Object obj) {
        return ((GeneratedMessageLite.c) obj).f35494d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public z<GeneratedMessageLite.d> d(Object obj) {
        return ((GeneratedMessageLite.c) obj).p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public boolean e(au auVar) {
        return auVar instanceof GeneratedMessageLite.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void f(Object obj) {
        c(obj).G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public <UT, UB> UB g(bn bnVar, Object obj, t tVar, z<GeneratedMessageLite.d> zVar, UB ub5, cb<UT, UB> cbVar) throws IOException {
        Object valueOf;
        Object s16;
        ArrayList arrayList;
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        int d16 = eVar.d();
        if (eVar.f35503d.isRepeated() && eVar.f35503d.isPacked()) {
            switch (a.f35958a[eVar.b().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    bnVar.N(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    bnVar.u(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    bnVar.z(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    bnVar.G(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    bnVar.k(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    bnVar.I(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    bnVar.L(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    bnVar.D(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    bnVar.P(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    bnVar.x(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    bnVar.j(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    bnVar.i(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    bnVar.q(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    bnVar.O(arrayList);
                    ub5 = (UB) bs.z(d16, arrayList, eVar.f35503d.h(), ub5, cbVar);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f35503d.getLiteType());
            }
            zVar.M(eVar.f35503d, arrayList);
        } else {
            if (eVar.b() == WireFormat.FieldType.ENUM) {
                int h16 = bnVar.h();
                if (eVar.f35503d.h().findValueByNumber(h16) == null) {
                    return (UB) bs.M(d16, h16, ub5, cbVar);
                }
                valueOf = Integer.valueOf(h16);
            } else {
                switch (a.f35958a[eVar.b().ordinal()]) {
                    case 1:
                        valueOf = Double.valueOf(bnVar.readDouble());
                        break;
                    case 2:
                        valueOf = Float.valueOf(bnVar.readFloat());
                        break;
                    case 3:
                        valueOf = Long.valueOf(bnVar.b());
                        break;
                    case 4:
                        valueOf = Long.valueOf(bnVar.f());
                        break;
                    case 5:
                        valueOf = Integer.valueOf(bnVar.h());
                        break;
                    case 6:
                        valueOf = Long.valueOf(bnVar.w());
                        break;
                    case 7:
                        valueOf = Integer.valueOf(bnVar.p());
                        break;
                    case 8:
                        valueOf = Boolean.valueOf(bnVar.c());
                        break;
                    case 9:
                        valueOf = Integer.valueOf(bnVar.a());
                        break;
                    case 10:
                        valueOf = Integer.valueOf(bnVar.A());
                        break;
                    case 11:
                        valueOf = Long.valueOf(bnVar.K());
                        break;
                    case 12:
                        valueOf = Integer.valueOf(bnVar.r());
                        break;
                    case 13:
                        valueOf = Long.valueOf(bnVar.Q());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        valueOf = bnVar.e();
                        break;
                    case 16:
                        valueOf = bnVar.d();
                        break;
                    case 17:
                        valueOf = bnVar.H(eVar.c().getClass(), tVar);
                        break;
                    case 18:
                        valueOf = bnVar.o(eVar.c().getClass(), tVar);
                        break;
                    default:
                        valueOf = null;
                        break;
                }
            }
            if (eVar.e()) {
                zVar.f(eVar.f35503d, valueOf);
            } else {
                int i3 = a.f35958a[eVar.b().ordinal()];
                if ((i3 == 17 || i3 == 18) && (s16 = zVar.s(eVar.f35503d)) != null) {
                    valueOf = ad.j(s16, valueOf);
                }
                zVar.M(eVar.f35503d, valueOf);
            }
        }
        return ub5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void h(bn bnVar, Object obj, t tVar, z<GeneratedMessageLite.d> zVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        zVar.M(eVar.f35503d, bnVar.o(eVar.c().getClass(), tVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void i(ByteString byteString, Object obj, t tVar, z<GeneratedMessageLite.d> zVar) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        au buildPartial = eVar.c().newBuilderForType().buildPartial();
        g g16 = g.g(ByteBuffer.wrap(byteString.toByteArray()), true);
        bi.a().b(buildPartial, g16, tVar);
        zVar.M(eVar.f35503d, buildPartial);
        if (g16.t() == Integer.MAX_VALUE) {
        } else {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (dVar.isRepeated()) {
            switch (a.f35958a[dVar.getLiteType().ordinal()]) {
                case 1:
                    bs.R(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 2:
                    bs.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 3:
                    bs.Z(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 4:
                    bs.i0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 5:
                    bs.Y(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 6:
                    bs.U(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 7:
                    bs.T(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 8:
                    bs.P(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 9:
                    bs.h0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 10:
                    bs.c0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 11:
                    bs.d0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 12:
                    bs.e0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 13:
                    bs.f0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 14:
                    bs.Y(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    return;
                case 15:
                    bs.Q(dVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    bs.g0(dVar.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        bs.X(dVar.getNumber(), (List) entry.getValue(), writer, bi.a().d(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        bs.b0(dVar.getNumber(), (List) entry.getValue(), writer, bi.a().d(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (a.f35958a[dVar.getLiteType().ordinal()]) {
            case 1:
                writer.g(dVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                writer.d(dVar.getNumber(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                writer.c(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                writer.i(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                writer.e(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                writer.J(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                writer.j(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                writer.b(dVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                writer.f(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                writer.v(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                writer.P(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                writer.H(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                writer.n(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                writer.e(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                writer.m(dVar.getNumber(), (ByteString) entry.getValue());
                return;
            case 16:
                writer.a(dVar.getNumber(), (String) entry.getValue());
                return;
            case 17:
                writer.q(dVar.getNumber(), entry.getValue(), bi.a().d(entry.getValue().getClass()));
                return;
            case 18:
                writer.E(dVar.getNumber(), entry.getValue(), bi.a().d(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }
}
