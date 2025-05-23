package com.google.protobuf;

import com.google.protobuf.ad;
import com.google.protobuf.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class bs {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f35743a = B();

    /* renamed from: b, reason: collision with root package name */
    private static final cb<?, ?> f35744b = D(false);

    /* renamed from: c, reason: collision with root package name */
    private static final cb<?, ?> f35745c = D(true);

    /* renamed from: d, reason: collision with root package name */
    private static final cb<?, ?> f35746d = new ce();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB A(int i3, List<Integer> list, ad.e eVar, UB ub5, cb<UT, UB> cbVar) {
        if (eVar == null) {
            return ub5;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                int intValue = list.get(i17).intValue();
                if (eVar.isInRange(intValue)) {
                    if (i17 != i16) {
                        list.set(i16, Integer.valueOf(intValue));
                    }
                    i16++;
                } else {
                    ub5 = (UB) M(i3, intValue, ub5, cbVar);
                }
            }
            if (i16 != size) {
                list.subList(i16, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.isInRange(intValue2)) {
                    ub5 = (UB) M(i3, intValue2, ub5, cbVar);
                    it.remove();
                }
            }
        }
        return ub5;
    }

    private static Class<?> B() {
        try {
            boolean z16 = GeneratedMessageV3.alwaysUseFieldBuilders;
            return GeneratedMessageV3.class;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object C(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + N(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return ch.F(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th5) {
            throw new RuntimeException(th5);
        }
    }

    private static cb<?, ?> D(boolean z16) {
        try {
            Class<?> E = E();
            if (E == null) {
                return null;
            }
            return (cb) E.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z16));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> E() {
        return cf.class;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends z.c<FT>> void F(u<FT> uVar, T t16, T t17) {
        z<FT> c16 = uVar.c(t17);
        if (!c16.A()) {
            uVar.d(t16).H(c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void G(an anVar, T t16, T t17, long j3) {
        ch.U(t16, j3, anVar.a(ch.E(t16, j3), ch.E(t17, j3)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void H(cb<UT, UB> cbVar, T t16, T t17) {
        cbVar.p(t16, cbVar.k(cbVar.g(t16), cbVar.g(t17)));
    }

    public static cb<?, ?> I() {
        return f35744b;
    }

    public static cb<?, ?> J() {
        return f35745c;
    }

    public static void K(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f35743a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean L(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB M(int i3, int i16, UB ub5, cb<UT, UB> cbVar) {
        if (ub5 == null) {
            ub5 = cbVar.n();
        }
        cbVar.e(ub5, i3, i16);
        return ub5;
    }

    static String N(String str, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if ('a' <= charAt && charAt <= 'z') {
                if (z16) {
                    sb5.append((char) (charAt - ' '));
                } else {
                    sb5.append(charAt);
                }
            } else if ('A' <= charAt && charAt <= 'Z') {
                if (i3 == 0 && !z16) {
                    sb5.append((char) (charAt + TokenParser.SP));
                } else {
                    sb5.append(charAt);
                }
            } else {
                if ('0' <= charAt && charAt <= '9') {
                    sb5.append(charAt);
                }
                z16 = true;
            }
            z16 = false;
        }
        return sb5.toString();
    }

    public static cb<?, ?> O() {
        return f35746d;
    }

    public static void P(int i3, List<Boolean> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.x(i3, list, z16);
        }
    }

    public static void Q(int i3, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.p(i3, list);
        }
    }

    public static void R(int i3, List<Double> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.N(i3, list, z16);
        }
    }

    public static void S(int i3, List<Integer> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.Q(i3, list, z16);
        }
    }

    public static void T(int i3, List<Integer> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.A(i3, list, z16);
        }
    }

    public static void U(int i3, List<Long> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.L(i3, list, z16);
        }
    }

    public static void V(int i3, List<Float> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.s(i3, list, z16);
        }
    }

    public static void W(int i3, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.k(i3, list);
        }
    }

    public static void X(int i3, List<?> list, Writer writer, bq bqVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.r(i3, list, bqVar);
        }
    }

    public static void Y(int i3, List<Integer> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.l(i3, list, z16);
        }
    }

    public static void Z(int i3, List<Long> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.z(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i3, List<?> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(size);
        }
        return size * CodedOutputStream.e(i3, true);
    }

    public static void a0(int i3, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.u(i3, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i3, List<?> list, Writer writer, bq bqVar) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.C(i3, list, bqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i3, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X = size * CodedOutputStream.X(i3);
        for (int i16 = 0; i16 < list.size(); i16++) {
            X += CodedOutputStream.i(list.get(i16));
        }
        return X;
    }

    public static void c0(int i3, List<Integer> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.G(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i3, List<Integer> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e16 = e(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(e16);
        }
        return e16 + (size * CodedOutputStream.X(i3));
    }

    public static void d0(int i3, List<Long> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.R(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ac) {
            ac acVar = (ac) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.m(acVar.getInt(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.m(list.get(i16).intValue());
                i16++;
            }
        }
        return i3;
    }

    public static void e0(int i3, List<Integer> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.M(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i3, List<?> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(size * 4);
        }
        return size * CodedOutputStream.n(i3, 0);
    }

    public static void f0(int i3, List<Long> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.D(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static void g0(int i3, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.O(i3, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i3, List<?> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(size * 8);
        }
        return size * CodedOutputStream.p(i3, 0L);
    }

    public static void h0(int i3, List<Integer> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.t(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static void i0(int i3, List<Long> list, Writer writer, boolean z16) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.o(i3, list, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i3, List<au> list, bq bqVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            i16 += CodedOutputStream.u(i3, list.get(i17), bqVar);
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i3, List<Integer> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l3 = l(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(l3);
        }
        return l3 + (size * CodedOutputStream.X(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List<Integer> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ac) {
            ac acVar = (ac) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.y(acVar.getInt(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.y(list.get(i16).intValue());
                i16++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i3, List<Long> list, boolean z16) {
        if (list.size() == 0) {
            return 0;
        }
        int n3 = n(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(n3);
        }
        return n3 + (list.size() * CodedOutputStream.X(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List<Long> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.A(ajVar.q(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.A(list.get(i16).longValue());
                i16++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i3, Object obj, bq bqVar) {
        if (obj instanceof af) {
            return CodedOutputStream.C(i3, (af) obj);
        }
        return CodedOutputStream.H(i3, (au) obj, bqVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i3, List<?> list, bq bqVar) {
        int J;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int X = CodedOutputStream.X(i3) * size;
        for (int i16 = 0; i16 < size; i16++) {
            Object obj = list.get(i16);
            if (obj instanceof af) {
                J = CodedOutputStream.D((af) obj);
            } else {
                J = CodedOutputStream.J((au) obj, bqVar);
            }
            X += J;
        }
        return X;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i3, List<Integer> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r16 = r(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(r16);
        }
        return r16 + (size * CodedOutputStream.X(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List<Integer> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ac) {
            ac acVar = (ac) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.S(acVar.getInt(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.S(list.get(i16).intValue());
                i16++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i3, List<Long> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t16 = t(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(t16);
        }
        return t16 + (size * CodedOutputStream.X(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List<Long> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.U(ajVar.q(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.U(list.get(i16).longValue());
                i16++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i3, List<?> list) {
        int W;
        int W2;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        int X = CodedOutputStream.X(i3) * size;
        if (list instanceof ah) {
            ah ahVar = (ah) list;
            while (i16 < size) {
                Object c16 = ahVar.c(i16);
                if (c16 instanceof ByteString) {
                    W2 = CodedOutputStream.i((ByteString) c16);
                } else {
                    W2 = CodedOutputStream.W((String) c16);
                }
                X += W2;
                i16++;
            }
        } else {
            while (i16 < size) {
                Object obj = list.get(i16);
                if (obj instanceof ByteString) {
                    W = CodedOutputStream.i((ByteString) obj);
                } else {
                    W = CodedOutputStream.W((String) obj);
                }
                X += W;
                i16++;
            }
        }
        return X;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i3, List<Integer> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w3 = w(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(w3);
        }
        return w3 + (size * CodedOutputStream.X(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List<Integer> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof ac) {
            ac acVar = (ac) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.Z(acVar.getInt(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.Z(list.get(i16).intValue());
                i16++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i3, List<Long> list, boolean z16) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y16 = y(list);
        if (z16) {
            return CodedOutputStream.X(i3) + CodedOutputStream.E(y16);
        }
        return y16 + (size * CodedOutputStream.X(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List<Long> list) {
        int i3;
        int size = list.size();
        int i16 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof aj) {
            aj ajVar = (aj) list;
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.b0(ajVar.q(i16));
                i16++;
            }
        } else {
            i3 = 0;
            while (i16 < size) {
                i3 += CodedOutputStream.b0(list.get(i16).longValue());
                i16++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB z(int i3, List<Integer> list, ad.d<?> dVar, UB ub5, cb<UT, UB> cbVar) {
        if (dVar == null) {
            return ub5;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i16 = 0;
            for (int i17 = 0; i17 < size; i17++) {
                int intValue = list.get(i17).intValue();
                if (dVar.findValueByNumber(intValue) != null) {
                    if (i17 != i16) {
                        list.set(i16, Integer.valueOf(intValue));
                    }
                    i16++;
                } else {
                    ub5 = (UB) M(i3, intValue, ub5, cbVar);
                }
            }
            if (i16 != size) {
                list.subList(i16, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (dVar.findValueByNumber(intValue2) == null) {
                    ub5 = (UB) M(i3, intValue2, ub5, cbVar);
                    it.remove();
                }
            }
        }
        return ub5;
    }
}
