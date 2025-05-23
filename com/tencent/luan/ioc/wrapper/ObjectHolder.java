package com.tencent.luan.ioc.wrapper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ObjectHolder<T> {
    static IPatchRedirector $redirector_;
    public final boolean needInject;
    public final T object;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectHolder(T t16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, t16, Boolean.valueOf(z16));
        } else {
            this.object = t16;
            this.needInject = z16;
        }
    }
}
