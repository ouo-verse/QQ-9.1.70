package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.core.SingleLinkedListNode;
import com.tencent.luan.ioc.Injector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FixObjectWrapper<T> implements ObjectWrapper<T> {
    static IPatchRedirector $redirector_;
    private final SingleLinkedListNode<T> node;

    public FixObjectWrapper(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
        } else {
            this.node = new SingleLinkedListNode<>(t16);
        }
    }

    @Override // com.tencent.luan.ioc.wrapper.ObjectWrapper
    public ObjectWrapper<T> combine(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ObjectWrapper) iPatchRedirector.redirect((short) 3, (Object) this, (Object) t16);
        }
        if (!this.node.hasNext() && this.node.getValue() != t16) {
            this.node.setNext(new SingleLinkedListNode<>(t16));
        }
        return this;
    }

    @Override // com.tencent.luan.ioc.wrapper.ObjectWrapper
    public ObjectHolder<T> createObjectIfAbsent(Injector injector) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ObjectHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) injector);
        }
        if (!this.node.hasNext()) {
            return new ObjectHolder<>(this.node.getValue(), false);
        }
        throw new IllegalStateException("fix object wrapper has more than one object");
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
