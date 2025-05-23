package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.ad;
import com.google.protobuf.ae;
import com.google.protobuf.au;
import com.google.protobuf.z.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class z<T extends c<T>> {

    /* renamed from: d, reason: collision with root package name */
    private static final z f35968d = new z(true);

    /* renamed from: a, reason: collision with root package name */
    private final bv<T, Object> f35969a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f35970b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f35971c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35972a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f35973b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f35973b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35973b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35973b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35973b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35973b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35973b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35973b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35973b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35973b[WireFormat.FieldType.f35631GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35973b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35973b[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35973b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35973b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35973b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35973b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35973b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35973b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35973b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f35972a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f35972a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f35972a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f35972a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f35972a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f35972a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f35972a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f35972a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f35972a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b<T extends c<T>> {

        /* renamed from: a, reason: collision with root package name */
        private bv<T, Object> f35974a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f35975b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f35976c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f35977d;

        /* synthetic */ b(a aVar) {
            this();
        }

        private void d() {
            if (!this.f35976c) {
                this.f35974a = z.j(this.f35974a, true);
                this.f35976c = true;
            }
        }

        private void k(Map.Entry<T, Object> entry) {
            T key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof ae) {
                value = ((ae) value).g();
            }
            if (key.isRepeated()) {
                Object f16 = f(key);
                if (f16 == null) {
                    f16 = new ArrayList();
                }
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    ((List) f16).add(z.l(it.next()));
                }
                this.f35974a.put(key, f16);
                return;
            }
            if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                Object f17 = f(key);
                if (f17 == null) {
                    this.f35974a.put(key, z.l(value));
                    return;
                } else if (f17 instanceof au.a) {
                    key.a((au.a) f17, (au) value);
                    return;
                } else {
                    this.f35974a.put(key, key.a(((au) f17).toBuilder(), (au) value).build());
                    return;
                }
            }
            this.f35974a.put(key, z.l(value));
        }

        private static Object l(Object obj) {
            if (obj instanceof au.a) {
                return ((au.a) obj).build();
            }
            return obj;
        }

        private static <T extends c<T>> Object m(T t16, Object obj) {
            if (obj == null) {
                return obj;
            }
            if (t16.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                if (t16.isRepeated()) {
                    if (obj instanceof List) {
                        List list = (List) obj;
                        for (int i3 = 0; i3 < list.size(); i3++) {
                            Object obj2 = list.get(i3);
                            Object l3 = l(obj2);
                            if (l3 != obj2) {
                                if (list == obj) {
                                    list = new ArrayList(list);
                                }
                                list.set(i3, l3);
                            }
                        }
                        return list;
                    }
                    throw new IllegalStateException("Repeated field should contains a List but actually contains type: " + obj.getClass());
                }
                return l(obj);
            }
            return obj;
        }

        private static <T extends c<T>> void n(bv<T, Object> bvVar) {
            for (int i3 = 0; i3 < bvVar.m(); i3++) {
                o(bvVar.l(i3));
            }
            Iterator<Map.Entry<T, Object>> it = bvVar.o().iterator();
            while (it.hasNext()) {
                o(it.next());
            }
        }

        private static <T extends c<T>> void o(Map.Entry<T, Object> entry) {
            entry.setValue(m(entry.getKey(), entry.getValue()));
        }

        private static void r(WireFormat.FieldType fieldType, Object obj) {
            if (!z.E(fieldType, obj)) {
                if (fieldType.getJavaType() == WireFormat.JavaType.MESSAGE && (obj instanceof au.a)) {
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }

        public void a(T t16, Object obj) {
            boolean z16;
            List list;
            d();
            if (t16.isRepeated()) {
                if (!this.f35977d && !(obj instanceof au.a)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                this.f35977d = z16;
                r(t16.getLiteType(), obj);
                Object f16 = f(t16);
                if (f16 == null) {
                    list = new ArrayList();
                    this.f35974a.put(t16, list);
                } else {
                    list = (List) f16;
                }
                list.add(obj);
                return;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }

        public z<T> b() {
            if (this.f35974a.isEmpty()) {
                return z.q();
            }
            this.f35976c = false;
            bv<T, Object> bvVar = this.f35974a;
            if (this.f35977d) {
                bvVar = z.j(bvVar, false);
                n(bvVar);
            }
            z<T> zVar = new z<>(bvVar, null);
            ((z) zVar).f35971c = this.f35975b;
            return zVar;
        }

        public void c(T t16) {
            d();
            this.f35974a.remove(t16);
            if (this.f35974a.isEmpty()) {
                this.f35975b = false;
            }
        }

        public Map<T, Object> e() {
            if (this.f35975b) {
                bv j3 = z.j(this.f35974a, false);
                if (this.f35974a.q()) {
                    j3.r();
                } else {
                    n(j3);
                }
                return j3;
            }
            if (this.f35974a.q()) {
                return this.f35974a;
            }
            return Collections.unmodifiableMap(this.f35974a);
        }

        public Object f(T t16) {
            return m(t16, g(t16));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object g(T t16) {
            Object obj = this.f35974a.get(t16);
            if (obj instanceof ae) {
                return ((ae) obj).g();
            }
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Object h(T t16, int i3) {
            if (t16.isRepeated()) {
                Object g16 = g(t16);
                if (g16 != null) {
                    return ((List) g16).get(i3);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public boolean i(T t16) {
            if (!t16.isRepeated()) {
                if (this.f35974a.get(t16) != null) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }

        public void j(z<T> zVar) {
            d();
            for (int i3 = 0; i3 < ((z) zVar).f35969a.m(); i3++) {
                k(((z) zVar).f35969a.l(i3));
            }
            Iterator it = ((z) zVar).f35969a.o().iterator();
            while (it.hasNext()) {
                k((Map.Entry) it.next());
            }
        }

        public void p(T t16, Object obj) {
            boolean z16;
            d();
            boolean z17 = false;
            if (t16.isRepeated()) {
                if (obj instanceof List) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll((List) obj);
                    for (Object obj2 : arrayList) {
                        r(t16.getLiteType(), obj2);
                        if (!this.f35977d && !(obj2 instanceof au.a)) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        this.f35977d = z16;
                    }
                    obj = arrayList;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            } else {
                r(t16.getLiteType(), obj);
            }
            if (obj instanceof ae) {
                this.f35975b = true;
            }
            if (this.f35977d || (obj instanceof au.a)) {
                z17 = true;
            }
            this.f35977d = z17;
            this.f35974a.put(t16, obj);
        }

        public void q(T t16, int i3, Object obj) {
            boolean z16;
            d();
            if (t16.isRepeated()) {
                if (!this.f35977d && !(obj instanceof au.a)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                this.f35977d = z16;
                Object f16 = f(t16);
                if (f16 != null) {
                    r(t16.getLiteType(), obj);
                    ((List) f16).set(i3, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        b() {
            this(bv.s(16));
        }

        b(bv<T, Object> bvVar) {
            this.f35974a = bvVar;
            this.f35976c = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c<T extends c<T>> extends Comparable<T> {
        au.a a(au.a aVar, au auVar);

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        boolean isPacked();

        boolean isRepeated();
    }

    /* synthetic */ z(bv bvVar, a aVar) {
        this(bvVar);
    }

    private static <T extends c<T>> boolean D(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((au) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof au) {
                    if (!((au) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof ae) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean E(WireFormat.FieldType fieldType, Object obj) {
        ad.a(obj);
        switch (a.f35972a[fieldType.getJavaType().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof ad.c)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof au) || (obj instanceof ae)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void I(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ae) {
            value = ((ae) value).g();
        }
        if (key.isRepeated()) {
            Object s16 = s(key);
            if (s16 == null) {
                s16 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) s16).add(l(it.next()));
            }
            this.f35969a.put(key, s16);
            return;
        }
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            Object s17 = s(key);
            if (s17 == null) {
                this.f35969a.put(key, l(value));
                return;
            } else {
                this.f35969a.put(key, key.a(((au) s17).toBuilder(), (au) value).build());
                return;
            }
        }
        this.f35969a.put(key, l(value));
    }

    public static <T extends c<T>> b<T> J() {
        return new b<>((a) null);
    }

    public static <T extends c<T>> z<T> K() {
        return new z<>();
    }

    public static Object L(k kVar, WireFormat.FieldType fieldType, boolean z16) throws IOException {
        if (z16) {
            return WireFormat.d(kVar, fieldType, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.d(kVar, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    private void N(WireFormat.FieldType fieldType, Object obj) {
        if (E(fieldType, obj)) {
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void O(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i3, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.f35631GROUP) {
            codedOutputStream.C0(i3, (au) obj);
        } else {
            codedOutputStream.a1(i3, y(fieldType, false));
            P(codedOutputStream, fieldType, obj);
        }
    }

    static void P(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f35973b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.t0(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.B0(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.J0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.e1(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.H0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.z0(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.x0(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.n0(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.E0((au) obj);
                return;
            case 10:
                codedOutputStream.M0((au) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.r0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.Z0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.r0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.o0((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.c1(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.R0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.T0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.V0(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.X0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof ad.c) {
                    codedOutputStream.v0(((ad.c) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.v0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void Q(c<?> cVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = cVar.getLiteType();
        int number = cVar.getNumber();
        if (cVar.isRepeated()) {
            List list = (List) obj;
            if (cVar.isPacked()) {
                codedOutputStream.a1(number, 2);
                Iterator it = list.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    i3 += n(liteType, it.next());
                }
                codedOutputStream.P0(i3);
                Iterator it5 = list.iterator();
                while (it5.hasNext()) {
                    P(codedOutputStream, liteType, it5.next());
                }
                return;
            }
            Iterator it6 = list.iterator();
            while (it6.hasNext()) {
                O(codedOutputStream, liteType, number, it6.next());
            }
            return;
        }
        if (obj instanceof ae) {
            O(codedOutputStream, liteType, number, ((ae) obj).g());
        } else {
            O(codedOutputStream, liteType, number, obj);
        }
    }

    private void S(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            Object value = entry.getValue();
            if (value instanceof ae) {
                value = ((ae) value).g();
            }
            codedOutputStream.N0(entry.getKey().getNumber(), (au) value);
            return;
        }
        Q(key, entry.getValue(), codedOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends c<T>> bv<T, Object> j(bv<T, Object> bvVar, boolean z16) {
        bv<T, Object> s16 = bv.s(16);
        for (int i3 = 0; i3 < bvVar.m(); i3++) {
            k(s16, bvVar.l(i3), z16);
        }
        Iterator<Map.Entry<T, Object>> it = bvVar.o().iterator();
        while (it.hasNext()) {
            k(s16, it.next(), z16);
        }
        return s16;
    }

    private static <T extends c<T>> void k(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z16) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof ae) {
            map.put(key, ((ae) value).g());
        } else if (z16 && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
        } else {
            map.put(key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object l(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(WireFormat.FieldType fieldType, int i3, Object obj) {
        int X = CodedOutputStream.X(i3);
        if (fieldType == WireFormat.FieldType.f35631GROUP) {
            X *= 2;
        }
        return X + n(fieldType, obj);
    }

    static int n(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f35973b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.A(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.b0(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.y(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.v((au) obj);
            case 10:
                if (obj instanceof ae) {
                    return CodedOutputStream.D((ae) obj);
                }
                return CodedOutputStream.I((au) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.W((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.Z(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.O(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.Q(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.S(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.U(((Long) obj).longValue());
            case 18:
                if (obj instanceof ad.c) {
                    return CodedOutputStream.m(((ad.c) obj).getNumber());
                }
                return CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int o(c<?> cVar, Object obj) {
        WireFormat.FieldType liteType = cVar.getLiteType();
        int number = cVar.getNumber();
        if (cVar.isRepeated()) {
            int i3 = 0;
            if (cVar.isPacked()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i3 += n(liteType, it.next());
                }
                return CodedOutputStream.X(number) + i3 + CodedOutputStream.M(i3);
            }
            Iterator it5 = ((List) obj).iterator();
            while (it5.hasNext()) {
                i3 += m(liteType, number, it5.next());
            }
            return i3;
        }
        return m(liteType, number, obj);
    }

    public static <T extends c<T>> z<T> q() {
        return f35968d;
    }

    private int u(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
            if (value instanceof ae) {
                return CodedOutputStream.B(entry.getKey().getNumber(), (ae) value);
            }
            return CodedOutputStream.F(entry.getKey().getNumber(), (au) value);
        }
        return o(key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(WireFormat.FieldType fieldType, boolean z16) {
        if (z16) {
            return 2;
        }
        return fieldType.getWireType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f35969a.isEmpty();
    }

    public boolean B() {
        return this.f35970b;
    }

    public boolean C() {
        for (int i3 = 0; i3 < this.f35969a.m(); i3++) {
            if (!D(this.f35969a.l(i3))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f35969a.o().iterator();
        while (it.hasNext()) {
            if (!D(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> F() {
        if (this.f35971c) {
            return new ae.c(this.f35969a.entrySet().iterator());
        }
        return this.f35969a.entrySet().iterator();
    }

    public void G() {
        if (this.f35970b) {
            return;
        }
        this.f35969a.r();
        this.f35970b = true;
    }

    public void H(z<T> zVar) {
        for (int i3 = 0; i3 < zVar.f35969a.m(); i3++) {
            I(zVar.f35969a.l(i3));
        }
        Iterator<Map.Entry<T, Object>> it = zVar.f35969a.o().iterator();
        while (it.hasNext()) {
            I(it.next());
        }
    }

    public void M(T t16, Object obj) {
        if (t16.isRepeated()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    N(t16.getLiteType(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            N(t16.getLiteType(), obj);
        }
        if (obj instanceof ae) {
            this.f35971c = true;
        }
        this.f35969a.put(t16, obj);
    }

    public void R(CodedOutputStream codedOutputStream) throws IOException {
        for (int i3 = 0; i3 < this.f35969a.m(); i3++) {
            S(this.f35969a.l(i3), codedOutputStream);
        }
        Iterator<Map.Entry<T, Object>> it = this.f35969a.o().iterator();
        while (it.hasNext()) {
            S(it.next(), codedOutputStream);
        }
    }

    public void T(CodedOutputStream codedOutputStream) throws IOException {
        for (int i3 = 0; i3 < this.f35969a.m(); i3++) {
            Map.Entry<T, Object> l3 = this.f35969a.l(i3);
            Q(l3.getKey(), l3.getValue(), codedOutputStream);
        }
        for (Map.Entry<T, Object> entry : this.f35969a.o()) {
            Q(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        return this.f35969a.equals(((z) obj).f35969a);
    }

    public void f(T t16, Object obj) {
        List list;
        if (t16.isRepeated()) {
            N(t16.getLiteType(), obj);
            Object s16 = s(t16);
            if (s16 == null) {
                list = new ArrayList();
                this.f35969a.put(t16, list);
            } else {
                list = (List) s16;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void g() {
        this.f35969a.clear();
        this.f35971c = false;
    }

    public void h(T t16) {
        this.f35969a.remove(t16);
        if (this.f35969a.isEmpty()) {
            this.f35971c = false;
        }
    }

    public int hashCode() {
        return this.f35969a.hashCode();
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public z<T> clone() {
        z<T> K = K();
        for (int i3 = 0; i3 < this.f35969a.m(); i3++) {
            Map.Entry<T, Object> l3 = this.f35969a.l(i3);
            K.M(l3.getKey(), l3.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f35969a.o()) {
            K.M(entry.getKey(), entry.getValue());
        }
        K.f35971c = this.f35971c;
        return K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> p() {
        if (this.f35971c) {
            return new ae.c(this.f35969a.j().iterator());
        }
        return this.f35969a.j().iterator();
    }

    public Map<T, Object> r() {
        if (this.f35971c) {
            bv j3 = j(this.f35969a, false);
            if (this.f35969a.q()) {
                j3.r();
            }
            return j3;
        }
        if (this.f35969a.q()) {
            return this.f35969a;
        }
        return Collections.unmodifiableMap(this.f35969a);
    }

    public Object s(T t16) {
        Object obj = this.f35969a.get(t16);
        if (obj instanceof ae) {
            return ((ae) obj).g();
        }
        return obj;
    }

    public int t() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f35969a.m(); i16++) {
            i3 += u(this.f35969a.l(i16));
        }
        Iterator<Map.Entry<T, Object>> it = this.f35969a.o().iterator();
        while (it.hasNext()) {
            i3 += u(it.next());
        }
        return i3;
    }

    public Object v(T t16, int i3) {
        if (t16.isRepeated()) {
            Object s16 = s(t16);
            if (s16 != null) {
                return ((List) s16).get(i3);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int w(T t16) {
        if (t16.isRepeated()) {
            Object s16 = s(t16);
            if (s16 == null) {
                return 0;
            }
            return ((List) s16).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int x() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f35969a.m(); i16++) {
            Map.Entry<T, Object> l3 = this.f35969a.l(i16);
            i3 += o(l3.getKey(), l3.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f35969a.o()) {
            i3 += o(entry.getKey(), entry.getValue());
        }
        return i3;
    }

    public boolean z(T t16) {
        if (!t16.isRepeated()) {
            if (this.f35969a.get(t16) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    z() {
        this.f35969a = bv.s(16);
    }

    z(boolean z16) {
        this(bv.s(0));
        G();
    }

    z(bv<T, Object> bvVar) {
        this.f35969a = bvVar;
        G();
    }
}
