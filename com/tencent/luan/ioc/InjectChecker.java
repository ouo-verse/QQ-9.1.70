package com.tencent.luan.ioc;

import com.tencent.luan.ioc.annotation.Prototype;
import com.tencent.luan.ioc.annotation.Singleton;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes7.dex */
public class InjectChecker {
    static IPatchRedirector $redirector_ = null;
    public static final int SCOPE_DEFAULT = 0;
    public static final int SCOPE_PROTOTYPE = 2;
    public static final int SCOPE_SINGLETON = 1;

    public InjectChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int checkAndGetScope(AnnotatedElement annotatedElement) {
        boolean z16;
        boolean z17;
        String name;
        if (annotatedElement.getAnnotation(Singleton.class) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (annotatedElement.getAnnotation(Prototype.class) != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && z17) {
            if (!(annotatedElement instanceof Class)) {
                if (annotatedElement instanceof Method) {
                    name = ((Method) annotatedElement).getName();
                } else {
                    name = annotatedElement.toString();
                }
            } else {
                name = ((Class) annotatedElement).getName();
            }
            throw new InjectException("one class should be annotated by only one scope annotation: " + name);
        }
        if (z16) {
            return 1;
        }
        if (!z17) {
            return 0;
        }
        return 2;
    }

    static boolean isInvalidParamType(Class<?> cls) {
        if (!cls.isPrimitive() && !cls.isArray()) {
            return false;
        }
        return true;
    }

    private static boolean isInvalidParamTypes(Class<?>[] clsArr) {
        if (clsArr.length > 1) {
            return true;
        }
        if (clsArr.length != 1) {
            return false;
        }
        return isInvalidParamType(clsArr[0]);
    }

    public static boolean isValidInjectConstructor(Constructor<?> constructor) {
        if (constructor == null || isInvalidParamTypes(constructor.getParameterTypes())) {
            return false;
        }
        return Modifier.isPublic(constructor.getModifiers());
    }

    public static boolean isValidInjectMethod(Method method) {
        if (method == null || method.getParameterTypes().length != 1 || isInvalidParamType(method.getParameterTypes()[0])) {
            return false;
        }
        int modifiers = method.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            return false;
        }
        return Modifier.isPublic(modifiers);
    }

    public static boolean isValidProvideMethod(Method method) {
        if (method == null || isInvalidParamTypes(method.getParameterTypes()) || isInvalidParamType(method.getReturnType())) {
            return false;
        }
        int modifiers = method.getModifiers();
        if (!Modifier.isStatic(modifiers) || !Modifier.isPublic(modifiers)) {
            return false;
        }
        return true;
    }
}
