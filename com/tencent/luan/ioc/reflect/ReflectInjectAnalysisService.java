package com.tencent.luan.ioc.reflect;

import com.tencent.luan.core.LuanLog;
import com.tencent.luan.ioc.InjectAnalysisService;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.ProvideMethod;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.luan.ioc.annotation.Provide;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ReflectInjectAnalysisService implements InjectAnalysisService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ReflectInjectAnalysisSe";
    private final ClassLoader loader;
    private volatile boolean valid;

    public ReflectInjectAnalysisService(ClassLoader classLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) classLoader);
        } else {
            this.valid = true;
            this.loader = classLoader == null ? getClass().getClassLoader() : classLoader;
        }
    }

    private InjectParam getInjectParam(Class<?> cls, String str, Named named) {
        String namedValue = getNamedValue(named);
        if (namedValue.isEmpty()) {
            if (!str.isEmpty()) {
                cls = loadClass(str);
            }
        } else if (str.length() > 0) {
            LuanLog.w(TAG, "getInjectParam: annotated type " + str + " with @Named(" + namedValue + "), is Anything wrong? And this type will be ignored.");
        }
        return new InjectParam(cls, namedValue);
    }

    private static String getNamedValue(Named named) {
        String str;
        if (named != null) {
            str = named.value();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public /* bridge */ /* synthetic */ InjectConstructor getInjectConstructor(Class cls) {
        return getInjectConstructor((Class<?>) cls);
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public List<InjectMethod> getInjectMethods(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        Method[] methods = cls.getMethods();
        LinkedList linkedList = new LinkedList();
        for (Method method : methods) {
            Inject inject = (Inject) method.getAnnotation(Inject.class);
            if (inject != null) {
                if (InjectChecker.isValidInjectMethod(method)) {
                    linkedList.add(new ReflectInjectMethod(method, getInjectParam(method.getParameterTypes()[0], inject.type(), (Named) method.getAnnotation(Named.class))));
                } else {
                    throw new InjectException("inject method must be public and with one param " + method.getDeclaringClass().getName() + "#" + method.getName());
                }
            }
        }
        return Collections.unmodifiableList(linkedList);
    }

    public ClassLoader getLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ClassLoader) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.loader;
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public List<ProvideMethod<?>> getProvideMethods(Class<?> cls) {
        HashSet hashSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        LinkedList linkedList = new LinkedList();
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        int i16 = 0;
        while (i16 < length) {
            Method method = declaredMethods[i16];
            Provide provide = (Provide) method.getAnnotation(Provide.class);
            if (provide == null) {
                hashSet = hashSet2;
            } else if (InjectChecker.isValidProvideMethod(method)) {
                InjectParam injectParam = getInjectParam(method.getReturnType(), provide.type(), (Named) method.getAnnotation(Named.class));
                if (injectParam.name.isEmpty()) {
                    if (!hashSet2.add(injectParam.type)) {
                        throw new InjectException("duplicate provide method for type " + injectParam.type.getName() + " in " + cls.getName());
                    }
                } else if (!hashSet3.add(injectParam.name)) {
                    throw new InjectException("duplicate provide method for name " + injectParam.name + " in " + cls.getName());
                }
                InjectParam injectParam2 = null;
                Named named = null;
                if (method.getParameterTypes().length == 1) {
                    Annotation[] annotationArr = method.getParameterAnnotations()[i3];
                    int length2 = annotationArr.length;
                    int i17 = i3;
                    while (i17 < length2) {
                        Annotation annotation = annotationArr[i17];
                        HashSet hashSet4 = hashSet2;
                        if (annotation instanceof Named) {
                            named = (Named) annotation;
                        }
                        i17++;
                        hashSet2 = hashSet4;
                    }
                    hashSet = hashSet2;
                    i3 = 0;
                    injectParam2 = getInjectParam(method.getParameterTypes()[0], provide.inputType(), named);
                } else {
                    hashSet = hashSet2;
                }
                linkedList.add(new ReflectProvideMethod(cls, method, injectParam, injectParam2));
            } else {
                throw new InjectException("provide method must be static public and with none param " + method.getDeclaringClass().getName() + "#" + method.getName());
            }
            i16++;
            hashSet2 = hashSet;
        }
        return Collections.unmodifiableList(linkedList);
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.valid;
    }

    Class<?> loadClass(String str) {
        try {
            return this.loader.loadClass(str);
        } catch (ClassNotFoundException e16) {
            throw new InjectException("failed to load injected class " + str, e16);
        }
    }

    public void setValid(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.valid = z16;
        }
    }

    @Override // com.tencent.luan.ioc.InjectAnalysisService
    public ReflectInjectConstructor<?> getInjectConstructor(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReflectInjectConstructor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cls);
        }
        InjectParam injectParam = null;
        String str = "";
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : cls.getConstructors()) {
            Inject inject = (Inject) constructor2.getAnnotation(Inject.class);
            if (inject != null) {
                if (constructor == null) {
                    str = inject.type();
                    constructor = constructor2;
                } else {
                    throw new InjectException("there are more than one inject constructors in this type: " + cls.getName());
                }
            }
        }
        if (constructor == null) {
            try {
                constructor = cls.getConstructor(new Class[0]);
            } catch (NoSuchMethodException e16) {
                LuanLog.e(TAG, "getInjectConstructor: none injected constructor and failed to get empty constructor in " + cls.getName(), e16);
            }
        }
        if (InjectChecker.isValidInjectConstructor(constructor)) {
            Named named = (Named) constructor.getAnnotation(Named.class);
            if (constructor.getParameterTypes().length == 0) {
                if (str.length() > 0) {
                    LuanLog.w(TAG, "getInjectConstructor: inject has a type name on an empty constructor of " + cls.getName() + ", is Anything wrong? And this type will be ignored " + str);
                }
                if (named != null) {
                    LuanLog.w(TAG, "getInjectConstructor: inject has been named on an empty constructor of " + named.value() + ", is Anything wrong? And this name will be ignored");
                }
            } else {
                injectParam = getInjectParam(constructor.getParameterTypes()[0], str, named);
            }
            return new ReflectInjectConstructor<>(constructor, injectParam);
        }
        throw new InjectException("inject constructor must be public and with one or no param " + cls.getName());
    }
}
