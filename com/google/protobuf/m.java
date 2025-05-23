package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import com.google.protobuf.am;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class m implements Writer {

    /* renamed from: a, reason: collision with root package name */
    private final CodedOutputStream f35902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35903a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35903a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35903a[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35903a[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35903a[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35903a[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35903a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35903a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35903a[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35903a[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35903a[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35903a[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35903a[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    m(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) ad.b(codedOutputStream, "output");
        this.f35902a = codedOutputStream2;
        codedOutputStream2.f35253a = this;
    }

    public static m T(CodedOutputStream codedOutputStream) {
        m mVar = codedOutputStream.f35253a;
        if (mVar != null) {
            return mVar;
        }
        return new m(codedOutputStream);
    }

    private <V> void U(int i3, boolean z16, V v3, am.b<Boolean, V> bVar) throws IOException {
        this.f35902a.a1(i3, 2);
        this.f35902a.c1(am.b(bVar, Boolean.valueOf(z16), v3));
        am.f(this.f35902a, bVar, Boolean.valueOf(z16), v3);
    }

    private <V> void V(int i3, am.b<Integer, V> bVar, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            iArr[i16] = it.next().intValue();
            i16++;
        }
        Arrays.sort(iArr);
        for (int i17 = 0; i17 < size; i17++) {
            int i18 = iArr[i17];
            V v3 = map.get(Integer.valueOf(i18));
            this.f35902a.a1(i3, 2);
            this.f35902a.c1(am.b(bVar, Integer.valueOf(i18), v3));
            am.f(this.f35902a, bVar, Integer.valueOf(i18), v3);
        }
    }

    private <V> void W(int i3, am.b<Long, V> bVar, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            jArr[i16] = it.next().longValue();
            i16++;
        }
        Arrays.sort(jArr);
        for (int i17 = 0; i17 < size; i17++) {
            long j3 = jArr[i17];
            V v3 = map.get(Long.valueOf(j3));
            this.f35902a.a1(i3, 2);
            this.f35902a.c1(am.b(bVar, Long.valueOf(j3), v3));
            am.f(this.f35902a, bVar, Long.valueOf(j3), v3);
        }
    }

    private <K, V> void X(int i3, am.b<K, V> bVar, Map<K, V> map) throws IOException {
        switch (a.f35903a[bVar.f35681a.ordinal()]) {
            case 1:
                V v3 = map.get(Boolean.FALSE);
                if (v3 != null) {
                    U(i3, false, v3, bVar);
                }
                V v16 = map.get(Boolean.TRUE);
                if (v16 != null) {
                    U(i3, true, v16, bVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                V(i3, bVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                W(i3, bVar, map);
                return;
            case 12:
                Y(i3, bVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + bVar.f35681a);
        }
    }

    private <V> void Y(int i3, am.b<String, V> bVar, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i16 = 0;
        while (it.hasNext()) {
            strArr[i16] = it.next();
            i16++;
        }
        Arrays.sort(strArr);
        for (int i17 = 0; i17 < size; i17++) {
            String str = strArr[i17];
            V v3 = map.get(str);
            this.f35902a.a1(i3, 2);
            this.f35902a.c1(am.b(bVar, str, v3));
            am.f(this.f35902a, bVar, str, v3);
        }
    }

    private void Z(int i3, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f35902a.Y0(i3, (String) obj);
        } else {
            this.f35902a.q0(i3, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void A(int i3, List<Integer> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.o(list.get(i18).intValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.x0(list.get(i16).intValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.w0(i3, list.get(i16).intValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void B(int i3) throws IOException {
        this.f35902a.a1(i3, 4);
    }

    @Override // com.google.protobuf.Writer
    public void C(int i3, List<?> list, bq bqVar) throws IOException {
        for (int i16 = 0; i16 < list.size(); i16++) {
            E(i3, list.get(i16), bqVar);
        }
    }

    @Override // com.google.protobuf.Writer
    public void D(int i3, List<Long> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.U(list.get(i18).longValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.X0(list.get(i16).longValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.W0(i3, list.get(i16).longValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void E(int i3, Object obj, bq bqVar) throws IOException {
        this.f35902a.L0(i3, (au) obj, bqVar);
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder F() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.protobuf.Writer
    public void G(int i3, List<Integer> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.O(list.get(i18).intValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.R0(list.get(i16).intValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.Q0(i3, list.get(i16).intValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void H(int i3, int i16) throws IOException {
        this.f35902a.U0(i3, i16);
    }

    @Override // com.google.protobuf.Writer
    public final void I(int i3, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f35902a.O0(i3, (ByteString) obj);
        } else {
            this.f35902a.N0(i3, (au) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void J(int i3, long j3) throws IOException {
        this.f35902a.y0(i3, j3);
    }

    @Override // com.google.protobuf.Writer
    public void K(int i3) throws IOException {
        this.f35902a.a1(i3, 3);
    }

    @Override // com.google.protobuf.Writer
    public void L(int i3, List<Long> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.q(list.get(i18).longValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.z0(list.get(i16).longValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.y0(i3, list.get(i16).longValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void M(int i3, List<Integer> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.S(list.get(i18).intValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.V0(list.get(i16).intValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.U0(i3, list.get(i16).intValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void N(int i3, List<Double> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.k(list.get(i18).doubleValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.t0(list.get(i16).doubleValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.s0(i3, list.get(i16).doubleValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void O(int i3, List<String> list) throws IOException {
        int i16 = 0;
        if (list instanceof ah) {
            ah ahVar = (ah) list;
            while (i16 < list.size()) {
                Z(i3, ahVar.c(i16));
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.Y0(i3, list.get(i16));
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void P(int i3, long j3) throws IOException {
        this.f35902a.S0(i3, j3);
    }

    @Override // com.google.protobuf.Writer
    public void Q(int i3, List<Integer> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.m(list.get(i18).intValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.v0(list.get(i16).intValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.u0(i3, list.get(i16).intValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void R(int i3, List<Long> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.Q(list.get(i18).longValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.T0(list.get(i16).longValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.S0(i3, list.get(i16).longValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void S(int i3, Object obj) throws IOException {
        this.f35902a.K0(i3, (au) obj);
    }

    @Override // com.google.protobuf.Writer
    public void a(int i3, String str) throws IOException {
        this.f35902a.Y0(i3, str);
    }

    @Override // com.google.protobuf.Writer
    public void b(int i3, boolean z16) throws IOException {
        this.f35902a.m0(i3, z16);
    }

    @Override // com.google.protobuf.Writer
    public void c(int i3, long j3) throws IOException {
        this.f35902a.I0(i3, j3);
    }

    @Override // com.google.protobuf.Writer
    public void d(int i3, float f16) throws IOException {
        this.f35902a.A0(i3, f16);
    }

    @Override // com.google.protobuf.Writer
    public void e(int i3, int i16) throws IOException {
        this.f35902a.G0(i3, i16);
    }

    @Override // com.google.protobuf.Writer
    public void f(int i3, int i16) throws IOException {
        this.f35902a.b1(i3, i16);
    }

    @Override // com.google.protobuf.Writer
    public void g(int i3, double d16) throws IOException {
        this.f35902a.s0(i3, d16);
    }

    @Override // com.google.protobuf.Writer
    public void h(int i3, int i16) throws IOException {
        this.f35902a.u0(i3, i16);
    }

    @Override // com.google.protobuf.Writer
    public void i(int i3, long j3) throws IOException {
        this.f35902a.d1(i3, j3);
    }

    @Override // com.google.protobuf.Writer
    public void j(int i3, int i16) throws IOException {
        this.f35902a.w0(i3, i16);
    }

    @Override // com.google.protobuf.Writer
    public void k(int i3, List<?> list) throws IOException {
        for (int i16 = 0; i16 < list.size(); i16++) {
            y(i3, list.get(i16));
        }
    }

    @Override // com.google.protobuf.Writer
    public void l(int i3, List<Integer> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.y(list.get(i18).intValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.H0(list.get(i16).intValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.G0(i3, list.get(i16).intValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void m(int i3, ByteString byteString) throws IOException {
        this.f35902a.q0(i3, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void n(int i3, long j3) throws IOException {
        this.f35902a.W0(i3, j3);
    }

    @Override // com.google.protobuf.Writer
    public void o(int i3, List<Long> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.b0(list.get(i18).longValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.e1(list.get(i16).longValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.d1(i3, list.get(i16).longValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void p(int i3, List<ByteString> list) throws IOException {
        for (int i16 = 0; i16 < list.size(); i16++) {
            this.f35902a.q0(i3, list.get(i16));
        }
    }

    @Override // com.google.protobuf.Writer
    public void q(int i3, Object obj, bq bqVar) throws IOException {
        this.f35902a.D0(i3, (au) obj, bqVar);
    }

    @Override // com.google.protobuf.Writer
    public void r(int i3, List<?> list, bq bqVar) throws IOException {
        for (int i16 = 0; i16 < list.size(); i16++) {
            q(i3, list.get(i16), bqVar);
        }
    }

    @Override // com.google.protobuf.Writer
    public void s(int i3, List<Float> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.s(list.get(i18).floatValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.B0(list.get(i16).floatValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.A0(i3, list.get(i16).floatValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void t(int i3, List<Integer> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.Z(list.get(i18).intValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.c1(list.get(i16).intValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.b1(i3, list.get(i16).intValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void u(int i3, List<?> list) throws IOException {
        for (int i16 = 0; i16 < list.size(); i16++) {
            S(i3, list.get(i16));
        }
    }

    @Override // com.google.protobuf.Writer
    public void v(int i3, int i16) throws IOException {
        this.f35902a.Q0(i3, i16);
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void w(int i3, am.b<K, V> bVar, Map<K, V> map) throws IOException {
        if (this.f35902a.g0()) {
            X(i3, bVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f35902a.a1(i3, 2);
            this.f35902a.c1(am.b(bVar, entry.getKey(), entry.getValue()));
            am.f(this.f35902a, bVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void x(int i3, List<Boolean> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.f(list.get(i18).booleanValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.n0(list.get(i16).booleanValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.m0(i3, list.get(i16).booleanValue());
            i16++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void y(int i3, Object obj) throws IOException {
        this.f35902a.C0(i3, (au) obj);
    }

    @Override // com.google.protobuf.Writer
    public void z(int i3, List<Long> list, boolean z16) throws IOException {
        int i16 = 0;
        if (z16) {
            this.f35902a.a1(i3, 2);
            int i17 = 0;
            for (int i18 = 0; i18 < list.size(); i18++) {
                i17 += CodedOutputStream.A(list.get(i18).longValue());
            }
            this.f35902a.c1(i17);
            while (i16 < list.size()) {
                this.f35902a.J0(list.get(i16).longValue());
                i16++;
            }
            return;
        }
        while (i16 < list.size()) {
            this.f35902a.I0(i3, list.get(i16).longValue());
            i16++;
        }
    }
}
