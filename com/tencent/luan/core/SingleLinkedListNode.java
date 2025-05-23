package com.tencent.luan.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SingleLinkedListNode<E> extends AbstractNode<E> {
    static IPatchRedirector $redirector_;
    private SingleLinkedListNode<E> next;

    public SingleLinkedListNode(E e16) {
        super(e16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
        }
    }

    public boolean hasNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.next != null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Iterator) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new Iterator<E>() { // from class: com.tencent.luan.core.SingleLinkedListNode.1
            static IPatchRedirector $redirector_;
            private SingleLinkedListNode<E> node;
            private boolean shouldReadNext;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SingleLinkedListNode.this);
                } else {
                    this.node = SingleLinkedListNode.this;
                    this.shouldReadNext = false;
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (this.shouldReadNext) {
                    this.node = ((SingleLinkedListNode) this.node).next;
                }
                if (this.node != null) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public E next() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (E) iPatchRedirector2.redirect((short) 3, (Object) this);
                }
                E e16 = this.node.element;
                this.shouldReadNext = true;
                return e16;
            }

            @Override // java.util.Iterator
            public void remove() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                throw new IllegalArgumentException("wrong call");
            }
        };
    }

    public SingleLinkedListNode<E> next() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SingleLinkedListNode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.next;
    }

    public void setNext(SingleLinkedListNode<E> singleLinkedListNode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) singleLinkedListNode);
        } else {
            this.next = singleLinkedListNode;
        }
    }
}
