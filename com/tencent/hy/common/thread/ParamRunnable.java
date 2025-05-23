package com.tencent.hy.common.thread;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes7.dex */
public abstract class ParamRunnable<T> implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<T> f114710d;

    public ParamRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f114710d = new LinkedList<>();
        }
    }

    public abstract void a(T t16);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public void run() {
        LinkedList linkedList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f114710d) {
            linkedList = (LinkedList) this.f114710d.clone();
            this.f114710d.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }
}
