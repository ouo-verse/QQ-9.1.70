package c3;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f30250a;

    static {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            f30250a = (Unsafe) declaredField.get(null);
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }

    public int a(Class<?> cls) {
        return f30250a.arrayBaseOffset(cls);
    }

    public int b(Class<?> cls) {
        return f30250a.arrayIndexScale(cls);
    }

    public long c(Field field) {
        return f30250a.objectFieldOffset(field);
    }
}
