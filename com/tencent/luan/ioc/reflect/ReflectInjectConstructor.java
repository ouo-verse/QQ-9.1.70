package com.tencent.luan.ioc.reflect;

import com.tencent.luan.ioc.AbstractInjectConstructor;
import com.tencent.luan.ioc.InjectChecker;
import com.tencent.luan.ioc.InjectException;
import com.tencent.luan.ioc.InjectParam;
import com.tencent.luan.ioc.Injector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Constructor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class ReflectInjectConstructor<T> extends AbstractInjectConstructor<T> {
    static IPatchRedirector $redirector_;
    private final Constructor<T> constructor;
    private final InjectParam param;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectInjectConstructor(Constructor<T> constructor, InjectParam injectParam) {
        super(constructor.getDeclaringClass(), InjectChecker.checkAndGetScope(constructor.getDeclaringClass()));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) constructor, (Object) injectParam);
            return;
        }
        constructor.setAccessible(true);
        this.constructor = constructor;
        this.param = injectParam;
    }

    @Override // com.tencent.luan.ioc.InjectConstructor
    public T newInstance(Injector injector) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) injector);
        }
        try {
            InjectParam injectParam = this.param;
            if (injectParam == null) {
                return this.constructor.newInstance(new Object[0]);
            }
            if (injectParam.name.isEmpty()) {
                return this.constructor.newInstance(injector.getOrCreateObject(this.param.type));
            }
            return this.constructor.newInstance(injector.getOrCreateObject(this.param.name));
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("failed to create ");
            sb5.append(this.constructor.getDeclaringClass().getName());
            sb5.append(" instance by inject constructor ");
            if (this.param == null) {
                str = "none param";
            } else {
                str = "param " + this.param.type.getName() + " name " + this.param.name;
            }
            sb5.append(str);
            throw new InjectException(sb5.toString(), e16);
        }
    }
}
