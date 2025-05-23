package com.tencent.luan.ioc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public abstract class AbstractProvideMethod<T> extends AbstractInjectConstructor<T> implements ProvideMethod<T> {
    static IPatchRedirector $redirector_;
    private final InjectParam provideParam;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractProvideMethod(Class<?> cls, InjectParam injectParam, int i3) {
        super(i3, r0.toString());
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(cls.getName());
        sb5.append("#");
        if (injectParam.name.isEmpty()) {
            str = injectParam.type.getName();
        } else {
            str = "@" + injectParam.name;
        }
        sb5.append(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cls, injectParam, Integer.valueOf(i3));
        } else {
            this.provideParam = injectParam;
        }
    }

    @Override // com.tencent.luan.ioc.AbstractInjectConstructor, com.tencent.luan.ioc.InjectConstructor
    public boolean needInject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.luan.ioc.ProvideMethod
    public InjectParam provideParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InjectParam) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.provideParam;
    }
}
