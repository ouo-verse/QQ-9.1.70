package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: P */
/* loaded from: classes2.dex */
final class ch {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f35818a = Logger.getLogger(ch.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final Unsafe f35819b = G();

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f35820c = com.google.protobuf.e.b();

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f35821d = o(Long.TYPE);

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f35822e = o(Integer.TYPE);

    /* renamed from: f, reason: collision with root package name */
    private static final e f35823f = D();

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f35824g = W();

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f35825h = V();

    /* renamed from: i, reason: collision with root package name */
    static final long f35826i;

    /* renamed from: j, reason: collision with root package name */
    private static final long f35827j;

    /* renamed from: k, reason: collision with root package name */
    private static final long f35828k;

    /* renamed from: l, reason: collision with root package name */
    private static final long f35829l;

    /* renamed from: m, reason: collision with root package name */
    private static final long f35830m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f35831n;

    /* renamed from: o, reason: collision with root package name */
    private static final long f35832o;

    /* renamed from: p, reason: collision with root package name */
    private static final long f35833p;

    /* renamed from: q, reason: collision with root package name */
    private static final long f35834q;

    /* renamed from: r, reason: collision with root package name */
    private static final long f35835r;

    /* renamed from: s, reason: collision with root package name */
    private static final long f35836s;

    /* renamed from: t, reason: collision with root package name */
    private static final long f35837t;

    /* renamed from: u, reason: collision with root package name */
    private static final long f35838u;

    /* renamed from: v, reason: collision with root package name */
    private static final long f35839v;

    /* renamed from: w, reason: collision with root package name */
    private static final int f35840w;

    /* renamed from: x, reason: collision with root package name */
    static final boolean f35841x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        @Override // java.security.PrivilegedExceptionAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() throws Exception {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b extends e {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.ch.e
        public void c(long j3, byte[] bArr, long j16, long j17) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.ch.e
        public boolean d(Object obj, long j3) {
            return ch.f35841x ? ch.s(obj, j3) : ch.t(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public byte e(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.ch.e
        public byte f(Object obj, long j3) {
            return ch.f35841x ? ch.w(obj, j3) : ch.x(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public double g(Object obj, long j3) {
            return Double.longBitsToDouble(k(obj, j3));
        }

        @Override // com.google.protobuf.ch.e
        public float h(Object obj, long j3) {
            return Float.intBitsToFloat(i(obj, j3));
        }

        @Override // com.google.protobuf.ch.e
        public long j(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.ch.e
        public Object m(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.ch.e
        public void o(Object obj, long j3, boolean z16) {
            if (ch.f35841x) {
                ch.L(obj, j3, z16);
            } else {
                ch.M(obj, j3, z16);
            }
        }

        @Override // com.google.protobuf.ch.e
        public void p(Object obj, long j3, byte b16) {
            if (ch.f35841x) {
                ch.O(obj, j3, b16);
            } else {
                ch.P(obj, j3, b16);
            }
        }

        @Override // com.google.protobuf.ch.e
        public void q(Object obj, long j3, double d16) {
            t(obj, j3, Double.doubleToLongBits(d16));
        }

        @Override // com.google.protobuf.ch.e
        public void r(Object obj, long j3, float f16) {
            s(obj, j3, Float.floatToIntBits(f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c extends e {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.ch.e
        public void c(long j3, byte[] bArr, long j16, long j17) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.ch.e
        public boolean d(Object obj, long j3) {
            return ch.f35841x ? ch.s(obj, j3) : ch.t(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public byte e(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.ch.e
        public byte f(Object obj, long j3) {
            return ch.f35841x ? ch.w(obj, j3) : ch.x(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public double g(Object obj, long j3) {
            return Double.longBitsToDouble(k(obj, j3));
        }

        @Override // com.google.protobuf.ch.e
        public float h(Object obj, long j3) {
            return Float.intBitsToFloat(i(obj, j3));
        }

        @Override // com.google.protobuf.ch.e
        public long j(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.ch.e
        public Object m(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // com.google.protobuf.ch.e
        public void o(Object obj, long j3, boolean z16) {
            if (ch.f35841x) {
                ch.L(obj, j3, z16);
            } else {
                ch.M(obj, j3, z16);
            }
        }

        @Override // com.google.protobuf.ch.e
        public void p(Object obj, long j3, byte b16) {
            if (ch.f35841x) {
                ch.O(obj, j3, b16);
            } else {
                ch.P(obj, j3, b16);
            }
        }

        @Override // com.google.protobuf.ch.e
        public void q(Object obj, long j3, double d16) {
            t(obj, j3, Double.doubleToLongBits(d16));
        }

        @Override // com.google.protobuf.ch.e
        public void r(Object obj, long j3, float f16) {
            s(obj, j3, Float.floatToIntBits(f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d extends e {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.protobuf.ch.e
        public void c(long j3, byte[] bArr, long j16, long j17) {
            this.f35842a.copyMemory((Object) null, j3, bArr, ch.f35826i + j16, j17);
        }

        @Override // com.google.protobuf.ch.e
        public boolean d(Object obj, long j3) {
            return this.f35842a.getBoolean(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public byte e(long j3) {
            return this.f35842a.getByte(j3);
        }

        @Override // com.google.protobuf.ch.e
        public byte f(Object obj, long j3) {
            return this.f35842a.getByte(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public double g(Object obj, long j3) {
            return this.f35842a.getDouble(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public float h(Object obj, long j3) {
            return this.f35842a.getFloat(obj, j3);
        }

        @Override // com.google.protobuf.ch.e
        public long j(long j3) {
            return this.f35842a.getLong(j3);
        }

        @Override // com.google.protobuf.ch.e
        public Object m(Field field) {
            return l(this.f35842a.staticFieldBase(field), this.f35842a.staticFieldOffset(field));
        }

        @Override // com.google.protobuf.ch.e
        public void o(Object obj, long j3, boolean z16) {
            this.f35842a.putBoolean(obj, j3, z16);
        }

        @Override // com.google.protobuf.ch.e
        public void p(Object obj, long j3, byte b16) {
            this.f35842a.putByte(obj, j3, b16);
        }

        @Override // com.google.protobuf.ch.e
        public void q(Object obj, long j3, double d16) {
            this.f35842a.putDouble(obj, j3, d16);
        }

        @Override // com.google.protobuf.ch.e
        public void r(Object obj, long j3, float f16) {
            this.f35842a.putFloat(obj, j3, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f35842a;

        e(Unsafe unsafe) {
            this.f35842a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f35842a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f35842a.arrayIndexScale(cls);
        }

        public abstract void c(long j3, byte[] bArr, long j16, long j17);

        public abstract boolean d(Object obj, long j3);

        public abstract byte e(long j3);

        public abstract byte f(Object obj, long j3);

        public abstract double g(Object obj, long j3);

        public abstract float h(Object obj, long j3);

        public final int i(Object obj, long j3) {
            return this.f35842a.getInt(obj, j3);
        }

        public abstract long j(long j3);

        public final long k(Object obj, long j3) {
            return this.f35842a.getLong(obj, j3);
        }

        public final Object l(Object obj, long j3) {
            return this.f35842a.getObject(obj, j3);
        }

        public abstract Object m(Field field);

        public final long n(Field field) {
            return this.f35842a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j3, boolean z16);

        public abstract void p(Object obj, long j3, byte b16);

        public abstract void q(Object obj, long j3, double d16);

        public abstract void r(Object obj, long j3, float f16);

        public final void s(Object obj, long j3, int i3) {
            this.f35842a.putInt(obj, j3, i3);
        }

        public final void t(Object obj, long j3, long j16) {
            this.f35842a.putLong(obj, j3, j16);
        }

        public final void u(Object obj, long j3, Object obj2) {
            this.f35842a.putObject(obj, j3, obj2);
        }
    }

    static {
        boolean z16;
        long k3 = k(byte[].class);
        f35826i = k3;
        f35827j = k(boolean[].class);
        f35828k = l(boolean[].class);
        f35829l = k(int[].class);
        f35830m = l(int[].class);
        f35831n = k(long[].class);
        f35832o = l(long[].class);
        f35833p = k(float[].class);
        f35834q = l(float[].class);
        f35835r = k(double[].class);
        f35836s = l(double[].class);
        f35837t = k(Object[].class);
        f35838u = l(Object[].class);
        f35839v = q(m());
        f35840w = (int) (k3 & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z16 = true;
        } else {
            z16 = false;
        }
        f35841x = z16;
    }

    ch() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(Object obj, long j3) {
        return f35823f.i(obj, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long B(long j3) {
        return f35823f.j(j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long C(Object obj, long j3) {
        return f35823f.k(obj, j3);
    }

    private static e D() {
        Unsafe unsafe = f35819b;
        if (unsafe == null) {
            return null;
        }
        if (com.google.protobuf.e.c()) {
            if (f35821d) {
                return new c(unsafe);
            }
            if (!f35822e) {
                return null;
            }
            return new b(unsafe);
        }
        return new d(unsafe);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object E(Object obj, long j3) {
        return f35823f.l(obj, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object F(Field field) {
        return f35823f.m(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe G() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean H() {
        return f35825h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean I() {
        return f35824g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long J(Field field) {
        return f35823f.n(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void K(Object obj, long j3, boolean z16) {
        f35823f.o(obj, j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(Object obj, long j3, boolean z16) {
        O(obj, j3, z16 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(Object obj, long j3, boolean z16) {
        P(obj, j3, z16 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(byte[] bArr, long j3, byte b16) {
        f35823f.p(bArr, f35826i + j3, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Object obj, long j3, byte b16) {
        long j16 = (-4) & j3;
        int A = A(obj, j16);
        int i3 = ((~((int) j3)) & 3) << 3;
        S(obj, j16, ((255 & b16) << i3) | (A & (~(255 << i3))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j3, byte b16) {
        long j16 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        S(obj, j16, ((255 & b16) << i3) | (A(obj, j16) & (~(255 << i3))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Q(Object obj, long j3, double d16) {
        f35823f.q(obj, j3, d16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void R(Object obj, long j3, float f16) {
        f35823f.r(obj, j3, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void S(Object obj, long j3, int i3) {
        f35823f.s(obj, j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void T(Object obj, long j3, long j16) {
        f35823f.t(obj, j3, j16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void U(Object obj, long j3, Object obj2) {
        f35823f.u(obj, j3, obj2);
    }

    private static boolean V() {
        Unsafe unsafe = f35819b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (com.google.protobuf.e.c()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th5) {
            f35818a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th5);
            return false;
        }
    }

    private static boolean W() {
        Unsafe unsafe = f35819b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (m() == null) {
                return false;
            }
            if (com.google.protobuf.e.c()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th5) {
            f35818a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long i(ByteBuffer byteBuffer) {
        return f35823f.k(byteBuffer, f35839v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T j(Class<T> cls) {
        try {
            return (T) f35819b.allocateInstance(cls);
        } catch (InstantiationException e16) {
            throw new IllegalStateException(e16);
        }
    }

    private static int k(Class<?> cls) {
        if (f35825h) {
            return f35823f.a(cls);
        }
        return -1;
    }

    private static int l(Class<?> cls) {
        if (f35825h) {
            return f35823f.b(cls);
        }
        return -1;
    }

    private static Field m() {
        Field p16;
        if (com.google.protobuf.e.c() && (p16 = p(Buffer.class, "effectiveDirectAddress")) != null) {
            return p16;
        }
        Field p17 = p(Buffer.class, "address");
        if (p17 == null || p17.getType() != Long.TYPE) {
            return null;
        }
        return p17;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(long j3, byte[] bArr, long j16, long j17) {
        f35823f.c(j3, bArr, j16, j17);
    }

    private static boolean o(Class<?> cls) {
        if (!com.google.protobuf.e.c()) {
            return false;
        }
        try {
            Class<?> cls2 = f35820c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field p(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long q(Field field) {
        e eVar;
        if (field != null && (eVar = f35823f) != null) {
            return eVar.n(field);
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(Object obj, long j3) {
        return f35823f.d(obj, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(Object obj, long j3) {
        if (w(obj, j3) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(Object obj, long j3) {
        if (x(obj, j3) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte u(long j3) {
        return f35823f.e(j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte v(byte[] bArr, long j3) {
        return f35823f.f(bArr, f35826i + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte w(Object obj, long j3) {
        return (byte) ((A(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte x(Object obj, long j3) {
        return (byte) ((A(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double y(Object obj, long j3) {
        return f35823f.g(obj, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float z(Object obj, long j3) {
        return f35823f.h(obj, j3);
    }
}
