package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.AbstractProvideMethod;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.Injector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
class ReflectProvideMethod<T> extends AbstractProvideMethod<T> {
    static IPatchRedirector $redirector_;
    private final InjectParam argParam;
    private final Method method;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectProvideMethod(Class<?> cls, Method method, InjectParam injectParam, InjectParam injectParam2) {
        super(cls, injectParam, InjectChecker.checkAndGetScope(method));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cls, method, injectParam, injectParam2);
            return;
        }
        method.setAccessible(true);
        this.method = method;
        this.argParam = injectParam2;
    }

    @Override // com.tencent.luan.ioc.InjectConstructor
    public T newInstance(Injector injector) {
        Object orCreateObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) injector);
        }
        try {
            InjectParam injectParam = this.argParam;
            if (injectParam == null) {
                return (T) this.method.invoke(null, new Object[0]);
            }
            if (injectParam.name.isEmpty()) {
                orCreateObject = injector.getOrCreateObject(this.argParam.type);
            } else {
                orCreateObject = injector.getOrCreateObject(this.argParam.name);
            }
            return (T) this.method.invoke(null, orCreateObject);
        } catch (Exception e16) {
            throw new InjectException("failed to invoke provide method " + this.method.getDeclaringClass().getName() + "#" + this.method.getName(), e16);
        }
    }
}
