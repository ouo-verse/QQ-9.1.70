package com.tencent.mobileqq.squarepants;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.LinkedList;

/* loaded from: classes18.dex */
class FinishersProxy extends LinkedList<Runnable> {
    static IPatchRedirector $redirector_;
    private final LinkedList<Runnable> sFinishers;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FinishersProxy(LinkedList<Runnable> linkedList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) linkedList);
        } else {
            this.sFinishers = linkedList;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        return this.sFinishers.remove(obj);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.sFinishers.add(runnable) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable)).booleanValue();
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public Runnable poll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Runnable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.sFinishers.isEmpty()) {
            return null;
        }
        c.a("FinishersProxy", "skip finisher");
        return null;
    }
}
