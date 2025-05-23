package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectMethod;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.Injector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes7.dex */
class ReflectInjectMethod implements InjectMethod {
    static IPatchRedirector $redirector_;
    private final Method method;
    private final InjectParam param;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectInjectMethod(Method method, InjectParam injectParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) method, (Object) injectParam);
            return;
        }
        method.setAccessible(true);
        this.method = method;
        this.param = injectParam;
    }

    @Override // com.tencent.luan.ioc.InjectMethod
    public void invoke(Object obj, Injector injector) {
        Object orCreateObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj, (Object) injector);
            return;
        }
        if (this.param.name.isEmpty()) {
            orCreateObject = injector.getOrCreateObject(this.param.type);
        } else {
            orCreateObject = injector.getOrCreateObject(this.param.name);
        }
        try {
            this.method.invoke(obj, orCreateObject);
        } catch (Exception e16) {
            throw new InjectException("failed to invoke inject method " + this.method.getDeclaringClass().getName() + "#" + this.method.getName(), e16);
        }
    }
}
