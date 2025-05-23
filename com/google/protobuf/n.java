package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ad;
import com.google.protobuf.bw;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class n implements at {

    /* renamed from: a, reason: collision with root package name */
    private static final n f35904a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f35905b = new HashSet(Arrays.asList("cached_size", "serialized_size", Constants.Service.CLASS));

    /* renamed from: c, reason: collision with root package name */
    private static d f35906c = new d();

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f35907d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements ad.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Descriptors.FieldDescriptor f35908a;

        a(Descriptors.FieldDescriptor fieldDescriptor) {
            this.f35908a = fieldDescriptor;
        }

        @Override // com.google.protobuf.ad.e
        public boolean isInRange(int i3) {
            if (this.f35908a.s().findValueByNumber(i3) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b implements ad.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Descriptors.FieldDescriptor f35909a;

        b(Descriptors.FieldDescriptor fieldDescriptor) {
            this.f35909a = fieldDescriptor;
        }

        @Override // com.google.protobuf.ad.e
        public boolean isInRange(int i3) {
            if (this.f35909a.s().findValueByNumber(i3) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35910a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f35911b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f35912c;

        static {
            int[] iArr = new int[Descriptors.FieldDescriptor.Type.values().length];
            f35912c = iArr;
            try {
                iArr[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.f35373GROUP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f35912c[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[JavaType.values().length];
            f35911b = iArr2;
            try {
                iArr2[JavaType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f35911b[JavaType.BYTE_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f35911b[JavaType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f35911b[JavaType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f35911b[JavaType.ENUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f35911b[JavaType.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f35911b[JavaType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f35911b[JavaType.STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f35911b[JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
            int[] iArr3 = new int[Descriptors.FileDescriptor.Syntax.values().length];
            f35910a = iArr3;
            try {
                iArr3[Descriptors.FileDescriptor.Syntax.PROTO2.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f35910a[Descriptors.FileDescriptor.Syntax.PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    n() {
    }

    private static Field e(Class<?> cls, int i3) {
        return m(cls, "bitField" + i3 + "_");
    }

    private static y f(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor, e eVar, boolean z16, ad.e eVar2) {
        bf a16 = eVar.a(cls, fieldDescriptor.p());
        FieldType q16 = q(fieldDescriptor);
        return y.h(fieldDescriptor.getNumber(), q16, a16, r(cls, fieldDescriptor, q16), z16, eVar2);
    }

    private static Field g(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        return m(cls, n(fieldDescriptor));
    }

    private static as h(Class<?> cls, Descriptors.b bVar) {
        int i3 = c.f35910a[bVar.h().t().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return j(cls, bVar);
            }
            throw new IllegalArgumentException("Unsupported syntax: " + bVar.h().t());
        }
        return i(cls, bVar);
    }

    private static bw i(Class<?> cls, Descriptors.b bVar) {
        ad.e eVar;
        List<Descriptors.FieldDescriptor> r16 = bVar.r();
        bw.a e16 = bw.e(r16.size());
        e16.c(o(cls));
        e16.f(ProtoSyntax.PROTO2);
        e16.e(bVar.u().getMessageSetWireFormat());
        a aVar = null;
        e eVar2 = new e(aVar);
        Field field = null;
        int i3 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i3 < r16.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = r16.get(i3);
            boolean javaStringCheckUtf8 = fieldDescriptor.h().q().getJavaStringCheckUtf8();
            Descriptors.FieldDescriptor.JavaType v3 = fieldDescriptor.v();
            Descriptors.FieldDescriptor.JavaType javaType = Descriptors.FieldDescriptor.JavaType.ENUM;
            if (v3 == javaType) {
                eVar = new a(fieldDescriptor);
            } else {
                eVar = aVar;
            }
            if (fieldDescriptor.p() != null) {
                e16.d(f(cls, fieldDescriptor, eVar2, javaStringCheckUtf8, eVar));
            } else {
                Field l3 = l(cls, fieldDescriptor);
                int number = fieldDescriptor.getNumber();
                FieldType q16 = q(fieldDescriptor);
                if (fieldDescriptor.A()) {
                    Descriptors.FieldDescriptor o16 = fieldDescriptor.w().o(2);
                    if (o16.v() == javaType) {
                        eVar = new b(o16);
                    }
                    e16.d(y.g(l3, number, bs.C(cls, fieldDescriptor.getName()), eVar));
                } else if (fieldDescriptor.isRepeated()) {
                    if (eVar != null) {
                        if (fieldDescriptor.isPacked()) {
                            e16.d(y.j(l3, number, q16, eVar, g(cls, fieldDescriptor)));
                        } else {
                            e16.d(y.f(l3, number, q16, eVar));
                        }
                    } else if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        e16.d(y.m(l3, number, q16, t(cls, fieldDescriptor)));
                    } else if (fieldDescriptor.isPacked()) {
                        e16.d(y.i(l3, number, q16, g(cls, fieldDescriptor)));
                    } else {
                        e16.d(y.e(l3, number, q16, javaStringCheckUtf8));
                    }
                } else {
                    if (field == null) {
                        field = e(cls, i16);
                    }
                    if (fieldDescriptor.E()) {
                        e16.d(y.l(l3, number, q16, field, i17, javaStringCheckUtf8, eVar));
                    } else {
                        e16.d(y.k(l3, number, q16, field, i17, javaStringCheckUtf8, eVar));
                    }
                }
                i3++;
                aVar = null;
            }
            i17 <<= 1;
            if (i17 == 0) {
                i16++;
                i17 = 1;
                field = null;
            }
            i3++;
            aVar = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i18 = 0; i18 < r16.size(); i18++) {
            Descriptors.FieldDescriptor fieldDescriptor2 = r16.get(i18);
            if (fieldDescriptor2.E() || (fieldDescriptor2.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE && v(fieldDescriptor2.w()))) {
                arrayList.add(Integer.valueOf(fieldDescriptor2.getNumber()));
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i19 = 0; i19 < arrayList.size(); i19++) {
            iArr[i19] = ((Integer) arrayList.get(i19)).intValue();
        }
        e16.b(iArr);
        return e16.a();
    }

    private static bw j(Class<?> cls, Descriptors.b bVar) {
        List<Descriptors.FieldDescriptor> r16 = bVar.r();
        bw.a e16 = bw.e(r16.size());
        e16.c(o(cls));
        e16.f(ProtoSyntax.PROTO3);
        e eVar = new e(null);
        for (int i3 = 0; i3 < r16.size(); i3++) {
            Descriptors.FieldDescriptor fieldDescriptor = r16.get(i3);
            if (fieldDescriptor.p() != null) {
                e16.d(f(cls, fieldDescriptor, eVar, true, null));
            } else if (fieldDescriptor.A()) {
                e16.d(y.g(l(cls, fieldDescriptor), fieldDescriptor.getNumber(), bs.C(cls, fieldDescriptor.getName()), null));
            } else if (fieldDescriptor.isRepeated() && fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                e16.d(y.m(l(cls, fieldDescriptor), fieldDescriptor.getNumber(), q(fieldDescriptor), t(cls, fieldDescriptor)));
            } else if (fieldDescriptor.isPacked()) {
                e16.d(y.i(l(cls, fieldDescriptor), fieldDescriptor.getNumber(), q(fieldDescriptor), g(cls, fieldDescriptor)));
            } else {
                e16.d(y.e(l(cls, fieldDescriptor), fieldDescriptor.getNumber(), q(fieldDescriptor), true));
            }
        }
        return e16.a();
    }

    private static Descriptors.b k(Class<?> cls) {
        return o(cls).getDescriptorForType();
    }

    private static Field l(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        return m(cls, p(fieldDescriptor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field m(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unable to find field " + str + " in message class " + cls.getName());
        }
    }

    private static String n(Descriptors.FieldDescriptor fieldDescriptor) {
        return w(fieldDescriptor.getName()) + "MemoizedSerializedSize";
    }

    private static ar o(Class<?> cls) {
        try {
            return (ar) cls.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e16) {
            throw new IllegalArgumentException("Unable to get default instance for message class " + cls.getName(), e16);
        }
    }

    static String p(Descriptors.FieldDescriptor fieldDescriptor) {
        String name;
        String str;
        if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.f35373GROUP) {
            name = fieldDescriptor.w().getName();
        } else {
            name = fieldDescriptor.getName();
        }
        if (f35905b.contains(name)) {
            str = "__";
        } else {
            str = "_";
        }
        return w(name) + str;
    }

    private static FieldType q(Descriptors.FieldDescriptor fieldDescriptor) {
        switch (c.f35912c[fieldDescriptor.y().ordinal()]) {
            case 1:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.BOOL;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.BOOL_LIST_PACKED;
                }
                return FieldType.BOOL_LIST;
            case 2:
                if (fieldDescriptor.isRepeated()) {
                    return FieldType.BYTES_LIST;
                }
                return FieldType.BYTES;
            case 3:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.DOUBLE;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.DOUBLE_LIST_PACKED;
                }
                return FieldType.DOUBLE_LIST;
            case 4:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.ENUM;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.ENUM_LIST_PACKED;
                }
                return FieldType.ENUM_LIST;
            case 5:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.FIXED32;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.FIXED32_LIST_PACKED;
                }
                return FieldType.FIXED32_LIST;
            case 6:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.FIXED64;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.FIXED64_LIST_PACKED;
                }
                return FieldType.FIXED64_LIST;
            case 7:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.FLOAT;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.FLOAT_LIST_PACKED;
                }
                return FieldType.FLOAT_LIST;
            case 8:
                if (fieldDescriptor.isRepeated()) {
                    return FieldType.GROUP_LIST;
                }
                return FieldType.f35416GROUP;
            case 9:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.INT32;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.INT32_LIST_PACKED;
                }
                return FieldType.INT32_LIST;
            case 10:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.INT64;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.INT64_LIST_PACKED;
                }
                return FieldType.INT64_LIST;
            case 11:
                if (fieldDescriptor.A()) {
                    return FieldType.MAP;
                }
                if (fieldDescriptor.isRepeated()) {
                    return FieldType.MESSAGE_LIST;
                }
                return FieldType.MESSAGE;
            case 12:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SFIXED32;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.SFIXED32_LIST_PACKED;
                }
                return FieldType.SFIXED32_LIST;
            case 13:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SFIXED64;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.SFIXED64_LIST_PACKED;
                }
                return FieldType.SFIXED64_LIST;
            case 14:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SINT32;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.SINT32_LIST_PACKED;
                }
                return FieldType.SINT32_LIST;
            case 15:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.SINT64;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.SINT64_LIST_PACKED;
                }
                return FieldType.SINT64_LIST;
            case 16:
                if (fieldDescriptor.isRepeated()) {
                    return FieldType.STRING_LIST;
                }
                return FieldType.STRING;
            case 17:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.UINT32;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.UINT32_LIST_PACKED;
                }
                return FieldType.UINT32_LIST;
            case 18:
                if (!fieldDescriptor.isRepeated()) {
                    return FieldType.UINT64;
                }
                if (fieldDescriptor.isPacked()) {
                    return FieldType.UINT64_LIST_PACKED;
                }
                return FieldType.UINT64_LIST;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fieldDescriptor.y());
        }
    }

    private static Class<?> r(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor, FieldType fieldType) {
        switch (c.f35911b[fieldType.getJavaType().ordinal()]) {
            case 1:
                return Boolean.class;
            case 2:
                return ByteString.class;
            case 3:
                return Double.class;
            case 4:
                return Float.class;
            case 5:
            case 6:
                return Integer.class;
            case 7:
                return Long.class;
            case 8:
                return String.class;
            case 9:
                return s(cls, fieldDescriptor);
            default:
                throw new IllegalArgumentException("Invalid type for oneof: " + fieldType);
        }
    }

    private static Class<?> s(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        String name;
        try {
            if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.f35373GROUP) {
                name = fieldDescriptor.w().getName();
            } else {
                name = fieldDescriptor.getName();
            }
            return cls.getDeclaredMethod(u(name), new Class[0]).getReturnType();
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    private static Class<?> t(Class<?> cls, Descriptors.FieldDescriptor fieldDescriptor) {
        String name;
        try {
            if (fieldDescriptor.y() == Descriptors.FieldDescriptor.Type.f35373GROUP) {
                name = fieldDescriptor.w().getName();
            } else {
                name = fieldDescriptor.getName();
            }
            return cls.getDeclaredMethod(u(name), Integer.TYPE).getReturnType();
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    private static String u(String str) {
        String w3 = w(str);
        return "get" + Character.toUpperCase(w3.charAt(0)) + w3.substring(1, w3.length());
    }

    private static boolean v(Descriptors.b bVar) {
        return f35906c.c(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(String str) {
        StringBuilder sb5 = new StringBuilder(str.length() + 1);
        boolean z16 = false;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '_') {
                if (Character.isDigit(charAt)) {
                    sb5.append(charAt);
                } else {
                    if (z16) {
                        sb5.append(Character.toUpperCase(charAt));
                        z16 = false;
                    } else if (i3 == 0) {
                        sb5.append(Character.toLowerCase(charAt));
                    } else {
                        sb5.append(charAt);
                    }
                }
            }
            z16 = true;
        }
        return sb5.toString();
    }

    @Override // com.google.protobuf.at
    public boolean a(Class<?> cls) {
        return GeneratedMessageV3.class.isAssignableFrom(cls);
    }

    @Override // com.google.protobuf.at
    public as b(Class<?> cls) {
        if (GeneratedMessageV3.class.isAssignableFrom(cls)) {
            return h(cls, k(cls));
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Descriptors.b, Boolean> f35913a = new ConcurrentHashMap();

        /* renamed from: b, reason: collision with root package name */
        private int f35914b = 0;

        /* renamed from: c, reason: collision with root package name */
        private final Stack<a> f35915c = new Stack<>();

        /* renamed from: d, reason: collision with root package name */
        private final Map<Descriptors.b, a> f35916d = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final Descriptors.b f35917a;

            /* renamed from: b, reason: collision with root package name */
            final int f35918b;

            /* renamed from: c, reason: collision with root package name */
            int f35919c;

            /* renamed from: d, reason: collision with root package name */
            b f35920d = null;

            a(Descriptors.b bVar, int i3) {
                this.f35917a = bVar;
                this.f35918b = i3;
                this.f35919c = i3;
            }
        }

        d() {
        }

        private void a(b bVar) {
            boolean z16;
            b bVar2;
            Iterator<Descriptors.b> it = bVar.f35921a.iterator();
            loop0: while (true) {
                if (it.hasNext()) {
                    Descriptors.b next = it.next();
                    z16 = true;
                    if (next.v()) {
                        break;
                    }
                    for (Descriptors.FieldDescriptor fieldDescriptor : next.r()) {
                        if (fieldDescriptor.E() || (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE && (bVar2 = this.f35916d.get(fieldDescriptor.w()).f35920d) != bVar && bVar2.f35922b)) {
                            break loop0;
                        }
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            bVar.f35922b = z16;
            Iterator<Descriptors.b> it5 = bVar.f35921a.iterator();
            while (it5.hasNext()) {
                this.f35913a.put(it5.next(), Boolean.valueOf(bVar.f35922b));
            }
        }

        private a b(Descriptors.b bVar) {
            a pop;
            int i3 = this.f35914b;
            this.f35914b = i3 + 1;
            a aVar = new a(bVar, i3);
            this.f35915c.push(aVar);
            this.f35916d.put(bVar, aVar);
            for (Descriptors.FieldDescriptor fieldDescriptor : bVar.r()) {
                if (fieldDescriptor.v() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    a aVar2 = this.f35916d.get(fieldDescriptor.w());
                    if (aVar2 == null) {
                        aVar.f35919c = Math.min(aVar.f35919c, b(fieldDescriptor.w()).f35919c);
                    } else if (aVar2.f35920d == null) {
                        aVar.f35919c = Math.min(aVar.f35919c, aVar2.f35919c);
                    }
                }
            }
            if (aVar.f35918b == aVar.f35919c) {
                b bVar2 = new b(null);
                do {
                    pop = this.f35915c.pop();
                    pop.f35920d = bVar2;
                    bVar2.f35921a.add(pop.f35917a);
                } while (pop != aVar);
                a(bVar2);
            }
            return aVar;
        }

        public boolean c(Descriptors.b bVar) {
            Boolean bool = this.f35913a.get(bVar);
            if (bool != null) {
                return bool.booleanValue();
            }
            synchronized (this) {
                Boolean bool2 = this.f35913a.get(bVar);
                if (bool2 != null) {
                    return bool2.booleanValue();
                }
                return b(bVar).f35920d.f35922b;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes2.dex */
        public static class b {

            /* renamed from: a, reason: collision with root package name */
            final List<Descriptors.b> f35921a;

            /* renamed from: b, reason: collision with root package name */
            boolean f35922b;

            b() {
                this.f35921a = new ArrayList();
                this.f35922b = false;
            }

            /* synthetic */ b(a aVar) {
                this();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        private bf[] f35923a;

        e() {
            this.f35923a = new bf[2];
        }

        private static bf b(Class<?> cls, Descriptors.g gVar) {
            String w3 = n.w(gVar.getName());
            return new bf(gVar.r(), n.m(cls, w3 + "Case_"), n.m(cls, w3 + "_"));
        }

        bf a(Class<?> cls, Descriptors.g gVar) {
            int r16 = gVar.r();
            bf[] bfVarArr = this.f35923a;
            if (r16 >= bfVarArr.length) {
                this.f35923a = (bf[]) Arrays.copyOf(bfVarArr, r16 * 2);
            }
            bf bfVar = this.f35923a[r16];
            if (bfVar == null) {
                bf b16 = b(cls, gVar);
                this.f35923a[r16] = b16;
                return b16;
            }
            return bfVar;
        }

        /* synthetic */ e(a aVar) {
            this();
        }
    }
}
