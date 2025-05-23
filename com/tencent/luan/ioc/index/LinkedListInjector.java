package com.tencent.luan.ioc.index;

import com.tencent.luan.core.SingleLinkedListNode;
import com.tencent.luan.ioc.Injector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LinkedListInjector implements Injector {
    static IPatchRedirector $redirector_;
    private SingleLinkedListNode<Object> headNode;
    private SingleLinkedListNode<Object> tailNode;

    public LinkedListInjector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object popNextValue() {
        Object value = this.headNode.getValue();
        SingleLinkedListNode<Object> next = this.headNode.next();
        this.headNode = next;
        if (next == null) {
            this.tailNode = null;
        }
        return value;
    }

    public void addLast(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
            return;
        }
        SingleLinkedListNode<Object> singleLinkedListNode = new SingleLinkedListNode<>(obj);
        SingleLinkedListNode<Object> singleLinkedListNode2 = this.tailNode;
        if (singleLinkedListNode2 == null) {
            this.headNode = singleLinkedListNode;
        } else {
            singleLinkedListNode2.setNext(singleLinkedListNode);
        }
        this.tailNode = singleLinkedListNode;
    }

    @Override // com.tencent.luan.ioc.Injector
    public Object getOrCreateObject(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? popNextValue() : iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
    }

    public void setHead(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
            return;
        }
        SingleLinkedListNode<Object> singleLinkedListNode = new SingleLinkedListNode<>(obj);
        SingleLinkedListNode<Object> singleLinkedListNode2 = this.headNode;
        if (singleLinkedListNode2 == null) {
            this.headNode = singleLinkedListNode;
            this.tailNode = singleLinkedListNode;
        } else {
            singleLinkedListNode.setNext(singleLinkedListNode2);
            this.headNode = singleLinkedListNode;
        }
    }

    @Override // com.tencent.luan.ioc.Injector
    public Object getOrCreateObject(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? popNextValue() : iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
    }
}
