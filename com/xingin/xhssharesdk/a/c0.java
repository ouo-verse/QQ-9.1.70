package com.xingin.xhssharesdk.a;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class c0 {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final C10093a f389885c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f389886d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ a[] f389887e;

        /* renamed from: a, reason: collision with root package name */
        public final b f389888a;

        /* renamed from: b, reason: collision with root package name */
        public final int f389889b;

        /* JADX INFO: Fake field, exist only in values array */
        a EF0;

        /* JADX INFO: Fake field, exist only in values array */
        a EF1;

        /* JADX INFO: Fake field, exist only in values array */
        a EF2;

        /* compiled from: P */
        /* renamed from: com.xingin.xhssharesdk.a.c0$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public enum C10093a extends a {
            public C10093a() {
                super("STRING", 8, b.STRING, 2, 0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum b extends a {
            public b(b bVar) {
                super("GROUP", 9, bVar, 3, 0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum c extends a {
            public c(b bVar) {
                super("MESSAGE", 10, bVar, 2, 0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum d extends a {
            public d(b bVar) {
                super("BYTES", 11, bVar, 2, 0);
            }
        }

        static {
            a aVar = new a("DOUBLE", 0, b.DOUBLE, 1);
            a aVar2 = new a("FLOAT", 1, b.FLOAT, 5);
            b bVar = b.LONG;
            a aVar3 = new a("INT64", 2, bVar, 0);
            a aVar4 = new a("UINT64", 3, bVar, 0);
            b bVar2 = b.INT;
            a aVar5 = new a("INT32", 4, bVar2, 0);
            a aVar6 = new a("FIXED64", 5, bVar, 1);
            a aVar7 = new a("FIXED32", 6, bVar2, 5);
            a aVar8 = new a("BOOL", 7, b.BOOLEAN, 0);
            C10093a c10093a = new C10093a();
            f389885c = c10093a;
            b bVar3 = b.MESSAGE;
            b bVar4 = new b(bVar3);
            f389886d = bVar4;
            f389887e = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, c10093a, bVar4, new c(bVar3), new d(b.BYTE_STRING), new a("UINT32", 12, bVar2, 0), new a("ENUM", 13, b.ENUM, 0), new a("SFIXED32", 14, bVar2, 5), new a("SFIXED64", 15, bVar, 1), new a("SINT32", 16, bVar2, 0), new a("SINT64", 17, bVar, 0)};
        }

        public a(String str, int i3, b bVar, int i16) {
            this.f389888a = bVar;
            this.f389889b = i16;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f389887e.clone();
        }

        public /* synthetic */ a(String str, int i3, b bVar, int i16, int i17) {
            this(str, i3, bVar, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum b {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(e.f389907b),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: a, reason: collision with root package name */
        public final Object f389900a;

        b(Serializable serializable) {
            this.f389900a = serializable;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f389901a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ c[] f389902b;

        /* JADX INFO: Fake field, exist only in values array */
        c EF0;

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum a extends c {
            public a() {
                super("LOOSE", 0);
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public enum b extends c {
            public b() {
                super("STRICT", 1);
            }

            public final Object a(com.xingin.xhssharesdk.a.c cVar) {
                return cVar.i();
            }
        }

        /* compiled from: P */
        /* renamed from: com.xingin.xhssharesdk.a.c0$c$c, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public enum C10094c extends c {
            public C10094c() {
                super("LAZY", 2);
            }
        }

        static {
            a aVar = new a();
            b bVar = new b();
            f389901a = bVar;
            f389902b = new c[]{aVar, bVar, new C10094c()};
        }

        public c(int i3, String str) {
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f389902b.clone();
        }

        public /* synthetic */ c(String str, int i3) {
            this(i3, str);
        }
    }

    public static int a(int i3, int i16) {
        return (i3 << 3) | i16;
    }
}
