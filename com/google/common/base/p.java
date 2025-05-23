package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NullableDecl
    @GwtIncompatible
    private static final Object f34712a;

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    @GwtIncompatible
    private static final Method f34713b;

    /* renamed from: c, reason: collision with root package name */
    @NullableDecl
    @GwtIncompatible
    private static final Method f34714c;

    static {
        Method a16;
        Object b16 = b();
        f34712a = b16;
        Method method = null;
        if (b16 == null) {
            a16 = null;
        } else {
            a16 = a();
        }
        f34713b = a16;
        if (b16 != null) {
            method = d();
        }
        f34714c = method;
    }

    @NullableDecl
    @GwtIncompatible
    private static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @NullableDecl
    @GwtIncompatible
    private static Object b() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e16) {
            throw e16;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    @GwtIncompatible
    private static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e16) {
            throw e16;
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    @GwtIncompatible
    private static Method d() {
        try {
            Method c16 = c("getStackTraceDepth", Throwable.class);
            if (c16 == null) {
                return null;
            }
            c16.invoke(b(), new Throwable());
            return c16;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public static RuntimeException e(Throwable th5) {
        j(th5);
        throw new RuntimeException(th5);
    }

    @GwtIncompatible
    @Deprecated
    public static <X extends Throwable> void f(@NullableDecl Throwable th5, Class<X> cls) throws Throwable {
        if (th5 != null) {
            i(th5, cls);
        }
    }

    @GwtIncompatible
    @Deprecated
    public static void g(@NullableDecl Throwable th5) {
        if (th5 != null) {
            j(th5);
        }
    }

    @GwtIncompatible
    public static <X extends Throwable> void h(@NullableDecl Throwable th5, Class<X> cls) throws Throwable {
        f(th5, cls);
        g(th5);
    }

    @GwtIncompatible
    public static <X extends Throwable> void i(Throwable th5, Class<X> cls) throws Throwable {
        j.m(th5);
        if (!cls.isInstance(th5)) {
        } else {
            throw cls.cast(th5);
        }
    }

    public static void j(Throwable th5) {
        j.m(th5);
        if (!(th5 instanceof RuntimeException)) {
            if (!(th5 instanceof Error)) {
                return;
            } else {
                throw ((Error) th5);
            }
        }
        throw ((RuntimeException) th5);
    }
}
