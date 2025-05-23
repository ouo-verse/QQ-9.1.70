package com.tencent.mobileqq.cuckoo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MethodCopyOnWriteSet {
    static IPatchRedirector $redirector_;
    private volatile transient MethodCallback[] elements;

    public MethodCopyOnWriteSet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.elements = new MethodCallback[0];
        }
    }

    public synchronized boolean add(MethodCallback methodCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) methodCallback)).booleanValue();
        }
        if (indexOf(methodCallback) >= 0) {
            return false;
        }
        MethodCallback[] methodCallbackArr = new MethodCallback[this.elements.length + 1];
        System.arraycopy(this.elements, 0, methodCallbackArr, 0, this.elements.length);
        methodCallbackArr[this.elements.length] = methodCallback;
        this.elements = methodCallbackArr;
        return true;
    }

    public synchronized void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.elements = new MethodCallback[0];
        }
    }

    public MethodCallback[] getSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MethodCallback[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.elements;
    }

    public int indexOf(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, obj)).intValue();
        }
        for (int i3 = 0; i3 < this.elements.length; i3++) {
            if (obj.equals(this.elements[i3])) {
                return i3;
            }
        }
        return -1;
    }

    public synchronized boolean remove(MethodCallback methodCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) methodCallback)).booleanValue();
        }
        int indexOf = indexOf(methodCallback);
        if (indexOf == -1) {
            return false;
        }
        MethodCallback[] methodCallbackArr = new MethodCallback[this.elements.length - 1];
        System.arraycopy(this.elements, 0, methodCallbackArr, 0, indexOf);
        System.arraycopy(this.elements, indexOf + 1, methodCallbackArr, indexOf, (this.elements.length - indexOf) - 1);
        this.elements = methodCallbackArr;
        return true;
    }
}
