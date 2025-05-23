package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.MethodSorter;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class TestClass {
    private final Class<?> klass;

    public TestClass(Class<?> cls) {
        this.klass = cls;
    }

    private List<Class<?>> getSuperClasses(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private boolean isShadowed(Method method, List<Method> list) {
        Iterator<Method> it = list.iterator();
        while (it.hasNext()) {
            if (isShadowed(method, it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean runsTopToBottom(Class<? extends Annotation> cls) {
        if (!cls.equals(Before.class) && !cls.equals(BeforeClass.class)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Method> getAfters() {
        return getAnnotatedMethods(AfterClass.class);
    }

    public List<Method> getAnnotatedMethods(Class<? extends Annotation> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<Class<?>> it = getSuperClasses(this.klass).iterator();
        while (it.hasNext()) {
            for (Method method : MethodSorter.getDeclaredMethods(it.next())) {
                if (method.getAnnotation(cls) != null && !isShadowed(method, arrayList)) {
                    arrayList.add(method);
                }
            }
        }
        if (runsTopToBottom(cls)) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Method> getBefores() {
        return getAnnotatedMethods(BeforeClass.class);
    }

    public Constructor<?> getConstructor() throws SecurityException, NoSuchMethodException {
        return this.klass.getConstructor(new Class[0]);
    }

    public Class<?> getJavaClass() {
        return this.klass;
    }

    public String getName() {
        return this.klass.getName();
    }

    public List<Method> getTestMethods() {
        return getAnnotatedMethods(Test.class);
    }

    private boolean isShadowed(Method method, Method method2) {
        if (!method2.getName().equals(method.getName()) || method2.getParameterTypes().length != method.getParameterTypes().length) {
            return false;
        }
        for (int i3 = 0; i3 < method2.getParameterTypes().length; i3++) {
            if (!method2.getParameterTypes()[i3].equals(method.getParameterTypes()[i3])) {
                return false;
            }
        }
        return true;
    }
}
