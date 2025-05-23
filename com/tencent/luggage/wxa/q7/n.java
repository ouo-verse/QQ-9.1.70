package com.tencent.luggage.wxa.q7;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f138019a = new n();

    public final void a(Object object, String fieldName, Object value) {
        Intrinsics.checkNotNullParameter(object, "object");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(value, "value");
        Field a16 = a(object.getClass(), fieldName);
        if ((a16.getModifiers() & 16) == 16) {
            try {
                try {
                    Field declaredField = Field.class.getDeclaredField("modifiers");
                    declaredField.setAccessible(true);
                    declaredField.setInt(a16, a16.getModifiers() & (-17));
                } catch (Exception unused) {
                    Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    declaredField2.setInt(a16, a16.getModifiers() & (-17));
                }
            } catch (Exception e16) {
                throw new Exception(e16);
            }
        }
        a16.set(object, value);
    }

    public final Field a(Class cls, String str) {
        try {
            Intrinsics.checkNotNull(cls);
            AccessibleObject accessible = Reflect.accessible(cls.getField(str));
            Intrinsics.checkNotNullExpressionValue(accessible, "{\n            Reflect.ac\u2026getField(name))\n        }");
            return (Field) accessible;
        } catch (NoSuchFieldException unused) {
            do {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("class info, name: ");
                Intrinsics.checkNotNull(cls);
                sb5.append(cls.getName());
                sb5.append(", classLoader: ");
                sb5.append(cls.getClassLoader());
                sb5.append(", classLoader parent: ");
                ClassLoader classLoader = cls.getClassLoader();
                sb5.append(classLoader != null ? classLoader.getParent() : null);
                sb5.append(", superClass:");
                sb5.append(cls.getSuperclass());
                sb5.append(", superClass classLoader:");
                Class superclass = cls.getSuperclass();
                sb5.append(superclass != null ? superclass.getClassLoader() : null);
                com.tencent.luggage.wxa.tn.w.d("Luggage.ReflectHelper", sb5.toString());
                try {
                    AccessibleObject accessible2 = Reflect.accessible(cls.getDeclaredField(str));
                    Intrinsics.checkNotNullExpressionValue(accessible2, "accessible(t.getDeclaredField(name))");
                    return (Field) accessible2;
                } catch (NoSuchFieldException unused2) {
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        throw new NoSuchFieldException();
                    }
                }
            } while (cls == null);
            throw new NoSuchFieldException();
        }
    }
}
