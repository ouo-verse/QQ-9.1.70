package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.InjectConstructor;
import com.tencent.luan.ioc.Injector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class PrototypeObjectWrapper<T> implements ObjectWrapper<T> {
    static IPatchRedirector $redirector_;
    private final InjectConstructor<T> constructor;

    public PrototypeObjectWrapper(InjectConstructor<T> injectConstructor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) injectConstructor);
        } else {
            this.constructor = injectConstructor;
        }
    }

    @Override // com.tencent.luan.ioc.wrapper.ObjectWrapper
    public ObjectWrapper<T> combine(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ObjectWrapper) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
        }
        return this;
    }

    @Override // com.tencent.luan.ioc.wrapper.ObjectWrapper
    public ObjectHolder<T> createObjectIfAbsent(Injector injector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ObjectHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) injector);
        }
        return new ObjectHolder<>(this.constructor.newInstance(injector), this.constructor.needInject());
    }

    @Override // com.tencent.luan.ioc.wrapper.ObjectWrapper
    public boolean needCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
