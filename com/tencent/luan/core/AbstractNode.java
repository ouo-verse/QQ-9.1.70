package com.tencent.luan.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class AbstractNode<E> implements Iterable<E> {
    static IPatchRedirector $redirector_;
    protected final E element;

    public AbstractNode(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
        } else {
            this.element = e16;
        }
    }

    public E getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (E) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.element;
    }
}
