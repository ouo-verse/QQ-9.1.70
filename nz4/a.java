package nz4;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f421640a = f();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f421641b = h();

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f421642c = g();

    /* renamed from: d, reason: collision with root package name */
    public static final long f421643d = b();

    /* compiled from: P */
    /* renamed from: nz4.a$a, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public static class C10874a implements PrivilegedExceptionAction<Unsafe> {
        public static Unsafe a() {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }

        @Override // java.security.PrivilegedExceptionAction
        public final /* bridge */ /* synthetic */ Unsafe run() {
            return a();
        }
    }

    static {
        Field field;
        try {
            field = Buffer.class.getDeclaredField("address");
            field.setAccessible(true);
        } catch (Throwable unused) {
            field = null;
        }
        c(field);
    }

    public static byte a(byte[] bArr, long j3) {
        return f421640a.getByte(bArr, j3);
    }

    public static int b() {
        if (f421642c) {
            return f421640a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    public static void c(Field field) {
        Unsafe unsafe;
        if (field != null && (unsafe = f421640a) != null) {
            unsafe.objectFieldOffset(field);
        }
    }

    public static void d(byte[] bArr, long j3, byte b16) {
        f421640a.putByte(bArr, j3, b16);
    }

    public static long e(byte[] bArr, long j3) {
        return f421640a.getLong(bArr, j3);
    }

    public static Unsafe f() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C10874a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        Unsafe unsafe = f421640a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("arrayBaseOffset", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h() {
        Unsafe unsafe = f421640a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", cls2);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
