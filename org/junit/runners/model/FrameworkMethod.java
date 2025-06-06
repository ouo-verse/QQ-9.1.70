package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.internal.runners.model.ReflectiveCallable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FrameworkMethod extends FrameworkMember<FrameworkMethod> {
    private final Method method;

    public FrameworkMethod(Method method) {
        if (method != null) {
            this.method = method;
            return;
        }
        throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
    }

    private Class<?>[] getParameterTypes() {
        return this.method.getParameterTypes();
    }

    public boolean equals(Object obj) {
        if (!FrameworkMethod.class.isInstance(obj)) {
            return false;
        }
        return ((FrameworkMethod) obj).method.equals(this.method);
    }

    @Override // org.junit.runners.model.Annotatable
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.method.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.Annotatable
    public Annotation[] getAnnotations() {
        return this.method.getAnnotations();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getDeclaringClass() {
        return this.method.getDeclaringClass();
    }

    public Method getMethod() {
        return this.method;
    }

    @Override // org.junit.runners.model.FrameworkMember
    protected int getModifiers() {
        return this.method.getModifiers();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public String getName() {
        return this.method.getName();
    }

    public Class<?> getReturnType() {
        return this.method.getReturnType();
    }

    @Override // org.junit.runners.model.FrameworkMember
    public Class<?> getType() {
        return getReturnType();
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public Object invokeExplosively(final Object obj, final Object... objArr) throws Throwable {
        return new ReflectiveCallable() { // from class: org.junit.runners.model.FrameworkMethod.1
            @Override // org.junit.internal.runners.model.ReflectiveCallable
            protected Object runReflectiveCall() throws Throwable {
                return FrameworkMethod.this.method.invoke(obj, objArr);
            }
        }.run();
    }

    @Deprecated
    public boolean producesType(Type type) {
        if (getParameterTypes().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.method.getReturnType())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.method.toString();
    }

    public void validateNoTypeParametersOnArgs(List<Throwable> list) {
        new NoGenericTypeParametersValidator(this.method).validate(list);
    }

    public void validatePublicVoid(boolean z16, List<Throwable> list) {
        String str;
        if (isStatic() != z16) {
            if (z16) {
                str = "should";
            } else {
                str = "should not";
            }
            list.add(new Exception("Method " + this.method.getName() + "() " + str + " be static"));
        }
        if (!isPublic()) {
            list.add(new Exception("Method " + this.method.getName() + "() should be public"));
        }
        if (this.method.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.method.getName() + "() should be void"));
        }
    }

    public void validatePublicVoidNoArg(boolean z16, List<Throwable> list) {
        validatePublicVoid(z16, list);
        if (this.method.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.method.getName() + " should have no parameters"));
        }
    }

    @Override // org.junit.runners.model.FrameworkMember
    public boolean isShadowedBy(FrameworkMethod frameworkMethod) {
        if (!frameworkMethod.getName().equals(getName()) || frameworkMethod.getParameterTypes().length != getParameterTypes().length) {
            return false;
        }
        for (int i3 = 0; i3 < frameworkMethod.getParameterTypes().length; i3++) {
            if (!frameworkMethod.getParameterTypes()[i3].equals(getParameterTypes()[i3])) {
                return false;
            }
        }
        return true;
    }
}
