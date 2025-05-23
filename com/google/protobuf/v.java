package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.WireFormat;
import com.google.protobuf.r;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class v extends u<Descriptors.FieldDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private static final long f35955a = k();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f35956b = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35957a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35957a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35957a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35957a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35957a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35957a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35957a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35957a[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35957a[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35957a[WireFormat.FieldType.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35957a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35957a[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35957a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35957a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35957a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35957a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35957a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35957a[WireFormat.FieldType.f35631GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35957a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    v() {
    }

    private static <T> long k() {
        return ch.J(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public int a(Map.Entry<?, ?> entry) {
        return ((Descriptors.FieldDescriptor) entry.getKey()).getNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public Object b(t tVar, au auVar, int i3) {
        return ((r) tVar).d(((ar) auVar).getDescriptorForType(), i3);
    }

    @Override // com.google.protobuf.u
    public z<Descriptors.FieldDescriptor> c(Object obj) {
        return (z) ch.E(obj, f35955a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public z<Descriptors.FieldDescriptor> d(Object obj) {
        z<Descriptors.FieldDescriptor> c16 = c(obj);
        if (c16.B()) {
            z<Descriptors.FieldDescriptor> clone = c16.clone();
            l(obj, clone);
            return clone;
        }
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public boolean e(au auVar) {
        return auVar instanceof GeneratedMessageV3.ExtendableMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void f(Object obj) {
        c(obj).G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0026. Please report as an issue. */
    @Override // com.google.protobuf.u
    public <UT, UB> UB g(bn bnVar, Object obj, t tVar, z<Descriptors.FieldDescriptor> zVar, UB ub5, cb<UT, UB> cbVar) throws IOException {
        Object valueOf;
        Object s16;
        ArrayList arrayList;
        ArrayList arrayList2;
        r.b bVar = (r.b) obj;
        int number = bVar.f35945a.getNumber();
        if (bVar.f35945a.isRepeated() && bVar.f35945a.isPacked()) {
            switch (a.f35957a[bVar.f35945a.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    bnVar.N(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    bnVar.u(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    bnVar.z(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    bnVar.G(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    bnVar.k(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    bnVar.I(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    bnVar.L(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    bnVar.D(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    bnVar.P(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    bnVar.x(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    bnVar.j(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    bnVar.i(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    bnVar.q(arrayList);
                    arrayList2 = arrayList;
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                case 14:
                    ArrayList arrayList3 = new ArrayList();
                    bnVar.O(arrayList3);
                    arrayList2 = new ArrayList();
                    Iterator<Integer> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        Descriptors.d findValueByNumber = bVar.f35945a.s().findValueByNumber(intValue);
                        if (findValueByNumber != null) {
                            arrayList2.add(findValueByNumber);
                        } else {
                            ub5 = (UB) bs.M(number, intValue, ub5, cbVar);
                        }
                    }
                    zVar.M(bVar.f35945a, arrayList2);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + bVar.f35945a.getLiteType());
            }
        } else {
            if (bVar.f35945a.getLiteType() == WireFormat.FieldType.ENUM) {
                int h16 = bnVar.h();
                valueOf = bVar.f35945a.s().findValueByNumber(h16);
                if (valueOf == null) {
                    return (UB) bs.M(number, h16, ub5, cbVar);
                }
            } else {
                switch (a.f35957a[bVar.f35945a.getLiteType().ordinal()]) {
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
                        valueOf = bnVar.H(bVar.f35946b.getClass(), tVar);
                        break;
                    case 18:
                        valueOf = bnVar.o(bVar.f35946b.getClass(), tVar);
                        break;
                    default:
                        valueOf = null;
                        break;
                }
            }
            if (bVar.f35945a.isRepeated()) {
                zVar.f(bVar.f35945a, valueOf);
            } else {
                int i3 = a.f35957a[bVar.f35945a.getLiteType().ordinal()];
                if ((i3 == 17 || i3 == 18) && (s16 = zVar.s(bVar.f35945a)) != null) {
                    valueOf = ad.j(s16, valueOf);
                }
                zVar.M(bVar.f35945a, valueOf);
            }
        }
        return ub5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void h(bn bnVar, Object obj, t tVar, z<Descriptors.FieldDescriptor> zVar) throws IOException {
        r.b bVar = (r.b) obj;
        if (t.c()) {
            zVar.M(bVar.f35945a, bnVar.o(bVar.f35946b.getClass(), tVar));
        } else {
            zVar.M(bVar.f35945a, new ae(bVar.f35946b, tVar, bnVar.e()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void i(ByteString byteString, Object obj, t tVar, z<Descriptors.FieldDescriptor> zVar) throws IOException {
        r.b bVar = (r.b) obj;
        ar buildPartial = bVar.f35946b.newBuilderForType().buildPartial();
        if (t.c()) {
            g g16 = g.g(ByteBuffer.wrap(byteString.toByteArray()), true);
            bi.a().b(buildPartial, g16, tVar);
            zVar.M(bVar.f35945a, buildPartial);
            if (g16.t() != Integer.MAX_VALUE) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
            return;
        }
        zVar.M(bVar.f35945a, new ae(bVar.f35946b, tVar, byteString));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.u
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) entry.getKey();
        if (fieldDescriptor.isRepeated()) {
            switch (a.f35957a[fieldDescriptor.getLiteType().ordinal()]) {
                case 1:
                    bs.R(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 2:
                    bs.V(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 3:
                    bs.Z(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 4:
                    bs.i0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 5:
                    bs.Y(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 6:
                    bs.U(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 7:
                    bs.T(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 8:
                    bs.P(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 9:
                    bs.h0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 10:
                    bs.c0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 11:
                    bs.d0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 12:
                    bs.e0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 13:
                    bs.f0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer, fieldDescriptor.isPacked());
                    return;
                case 14:
                    List list = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((Descriptors.d) it.next()).getNumber()));
                    }
                    bs.Y(fieldDescriptor.getNumber(), arrayList, writer, fieldDescriptor.isPacked());
                    return;
                case 15:
                    bs.Q(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    bs.g0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    bs.W(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 18:
                    bs.a0(fieldDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                default:
                    return;
            }
        }
        switch (a.f35957a[fieldDescriptor.getLiteType().ordinal()]) {
            case 1:
                writer.g(fieldDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                writer.d(fieldDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                writer.c(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                writer.i(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                writer.e(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                writer.J(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                writer.j(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                writer.b(fieldDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                writer.f(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                writer.v(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                writer.P(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                writer.H(fieldDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                writer.n(fieldDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                writer.e(fieldDescriptor.getNumber(), ((Descriptors.d) entry.getValue()).getNumber());
                return;
            case 15:
                writer.m(fieldDescriptor.getNumber(), (ByteString) entry.getValue());
                return;
            case 16:
                writer.a(fieldDescriptor.getNumber(), (String) entry.getValue());
                return;
            case 17:
                writer.y(fieldDescriptor.getNumber(), entry.getValue());
                return;
            case 18:
                writer.S(fieldDescriptor.getNumber(), entry.getValue());
                return;
            default:
                return;
        }
    }

    void l(Object obj, z<Descriptors.FieldDescriptor> zVar) {
        ch.U(obj, f35955a, zVar);
    }
}
