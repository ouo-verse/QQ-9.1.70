package com.tencent.luan.ioc;

import com.tencent.luan.ioc.wrapper.DefaultObjectWrapper;
import com.tencent.luan.ioc.wrapper.GlobalSingletonObjectWrapper;
import com.tencent.luan.ioc.wrapper.ObjectWrapper;
import com.tencent.luan.ioc.wrapper.PrototypeObjectWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbstractInjectConstructor<T> implements InjectConstructor<T> {
    static IPatchRedirector $redirector_;
    private final String uniqueKey;
    private final ObjectWrapper<T> wrapper;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractInjectConstructor(Class<T> cls, int i3) {
        this(i3, cls.getName() + "#<init>");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls, i3);
    }

    private ObjectWrapper<T> getWrapperByScope(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                return new DefaultObjectWrapper(this);
            }
            return new PrototypeObjectWrapper(this);
        }
        return GlobalSingletonObjectWrapper.getInstanceByConstructor(this);
    }

    @Override // com.tencent.luan.ioc.InjectConstructor
    public boolean needInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.luan.ioc.InjectConstructor
    public String uniqueKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uniqueKey;
    }

    @Override // com.tencent.luan.ioc.InjectConstructor
    public ObjectWrapper<T> wrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ObjectWrapper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.wrapper;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractInjectConstructor(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
        } else {
            this.uniqueKey = str;
            this.wrapper = getWrapperByScope(i3);
        }
    }
}
