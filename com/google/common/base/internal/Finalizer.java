package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
/* loaded from: classes2.dex */
public class Finalizer implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    private static final Logger f34690h = Logger.getLogger(Finalizer.class.getName());

    /* renamed from: i, reason: collision with root package name */
    @NullableDecl
    private static final Constructor<Thread> f34691i;

    /* renamed from: m, reason: collision with root package name */
    @NullableDecl
    private static final Field f34692m;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<Class<?>> f34693d;

    /* renamed from: e, reason: collision with root package name */
    private final PhantomReference<Object> f34694e;

    /* renamed from: f, reason: collision with root package name */
    private final ReferenceQueue<Object> f34695f;

    static {
        Field field;
        Constructor<Thread> e16 = e();
        f34691i = e16;
        if (e16 == null) {
            field = g();
        } else {
            field = null;
        }
        f34692m = field;
    }

    private boolean a(Reference<?> reference) {
        Method f16 = f();
        if (f16 == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.f34694e) {
                return false;
            }
            try {
                f16.invoke(reference, new Object[0]);
            } catch (Throwable th5) {
                f34690h.log(Level.SEVERE, "Error cleaning up after reference.", th5);
            }
            reference = this.f34695f.poll();
        } while (reference != null);
        return true;
    }

    @NullableDecl
    private static Constructor<Thread> e() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    @NullableDecl
    private Method f() {
        Class<?> cls = this.f34693d.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e16) {
            throw new AssertionError(e16);
        }
    }

    @NullableDecl
    private static Field g() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f34690h.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f34695f.remove())) {
        }
    }
}
