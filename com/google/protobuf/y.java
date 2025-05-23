package com.google.protobuf;

import com.google.protobuf.ad;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes2.dex */
final class y implements Comparable<y> {
    private final boolean C;
    private final boolean D;
    private final bf E;
    private final Field F;
    private final Class<?> G;
    private final Object H;
    private final ad.e I;

    /* renamed from: d, reason: collision with root package name */
    private final Field f35961d;

    /* renamed from: e, reason: collision with root package name */
    private final FieldType f35962e;

    /* renamed from: f, reason: collision with root package name */
    private final Class<?> f35963f;

    /* renamed from: h, reason: collision with root package name */
    private final int f35964h;

    /* renamed from: i, reason: collision with root package name */
    private final Field f35965i;

    /* renamed from: m, reason: collision with root package name */
    private final int f35966m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35967a;

        static {
            int[] iArr = new int[FieldType.values().length];
            f35967a = iArr;
            try {
                iArr[FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35967a[FieldType.f35416GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35967a[FieldType.MESSAGE_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35967a[FieldType.GROUP_LIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    y(Field field, int i3, FieldType fieldType, Class<?> cls, Field field2, int i16, boolean z16, boolean z17, bf bfVar, Class<?> cls2, Object obj, ad.e eVar, Field field3) {
        this.f35961d = field;
        this.f35962e = fieldType;
        this.f35963f = cls;
        this.f35964h = i3;
        this.f35965i = field2;
        this.f35966m = i16;
        this.C = z16;
        this.D = z17;
        this.E = bfVar;
        this.G = cls2;
        this.H = obj;
        this.I = eVar;
        this.F = field3;
    }

    private static void c(int i3) {
        if (i3 > 0) {
            return;
        }
        throw new IllegalArgumentException("fieldNumber must be positive: " + i3);
    }

    public static y e(Field field, int i3, FieldType fieldType, boolean z16) {
        c(i3);
        ad.b(field, "field");
        ad.b(fieldType, "fieldType");
        if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
            return new y(field, i3, fieldType, null, null, 0, false, z16, null, null, null, null, null);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static y f(Field field, int i3, FieldType fieldType, ad.e eVar) {
        c(i3);
        ad.b(field, "field");
        return new y(field, i3, fieldType, null, null, 0, false, false, null, null, null, eVar, null);
    }

    public static y g(Field field, int i3, Object obj, ad.e eVar) {
        ad.b(obj, "mapDefaultEntry");
        c(i3);
        ad.b(field, "field");
        return new y(field, i3, FieldType.MAP, null, null, 0, false, true, null, null, obj, eVar, null);
    }

    public static y h(int i3, FieldType fieldType, bf bfVar, Class<?> cls, boolean z16, ad.e eVar) {
        c(i3);
        ad.b(fieldType, "fieldType");
        ad.b(bfVar, "oneof");
        ad.b(cls, "oneofStoredType");
        if (fieldType.isScalar()) {
            return new y(null, i3, fieldType, null, null, 0, false, z16, bfVar, cls, null, eVar, null);
        }
        throw new IllegalArgumentException("Oneof is only supported for scalar fields. Field " + i3 + " is of type " + fieldType);
    }

    public static y i(Field field, int i3, FieldType fieldType, Field field2) {
        c(i3);
        ad.b(field, "field");
        ad.b(fieldType, "fieldType");
        if (fieldType != FieldType.MESSAGE_LIST && fieldType != FieldType.GROUP_LIST) {
            return new y(field, i3, fieldType, null, null, 0, false, false, null, null, null, null, field2);
        }
        throw new IllegalStateException("Shouldn't be called for repeated message fields.");
    }

    public static y j(Field field, int i3, FieldType fieldType, ad.e eVar, Field field2) {
        c(i3);
        ad.b(field, "field");
        return new y(field, i3, fieldType, null, null, 0, false, false, null, null, null, eVar, field2);
    }

    public static y k(Field field, int i3, FieldType fieldType, Field field2, int i16, boolean z16, ad.e eVar) {
        c(i3);
        ad.b(field, "field");
        ad.b(fieldType, "fieldType");
        ad.b(field2, "presenceField");
        if (field2 != null && !y(i16)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i16);
        }
        return new y(field, i3, fieldType, null, field2, i16, false, z16, null, null, null, eVar, null);
    }

    public static y l(Field field, int i3, FieldType fieldType, Field field2, int i16, boolean z16, ad.e eVar) {
        c(i3);
        ad.b(field, "field");
        ad.b(fieldType, "fieldType");
        ad.b(field2, "presenceField");
        if (field2 != null && !y(i16)) {
            throw new IllegalArgumentException("presenceMask must have exactly one bit set: " + i16);
        }
        return new y(field, i3, fieldType, null, field2, i16, true, z16, null, null, null, eVar, null);
    }

    public static y m(Field field, int i3, FieldType fieldType, Class<?> cls) {
        c(i3);
        ad.b(field, "field");
        ad.b(fieldType, "fieldType");
        ad.b(cls, "messageClass");
        return new y(field, i3, fieldType, cls, null, 0, false, false, null, null, null, null, null);
    }

    private static boolean y(int i3) {
        if (i3 != 0 && (i3 & (i3 - 1)) == 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(y yVar) {
        return this.f35964h - yVar.f35964h;
    }

    public Field n() {
        return this.F;
    }

    public ad.e o() {
        return this.I;
    }

    public Field p() {
        return this.f35961d;
    }

    public int q() {
        return this.f35964h;
    }

    public Object r() {
        return this.H;
    }

    public Class<?> s() {
        int i3 = a.f35967a[this.f35962e.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                return null;
            }
            return this.f35963f;
        }
        Field field = this.f35961d;
        if (field != null) {
            return field.getType();
        }
        return this.G;
    }

    public bf t() {
        return this.E;
    }

    public Field u() {
        return this.f35965i;
    }

    public int v() {
        return this.f35966m;
    }

    public FieldType w() {
        return this.f35962e;
    }

    public boolean x() {
        return this.D;
    }

    public boolean z() {
        return this.C;
    }
}
