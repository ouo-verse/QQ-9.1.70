package com.tencent.mobileqq.squarepants;

import android.os.Build;
import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes18.dex */
public class WorkProxy extends LinkedList<Runnable> {
    static IPatchRedirector $redirector_;
    private WorkProxy newSWork;
    private final Object sLock;
    private final LinkedList<Runnable> sWork;

    public WorkProxy(LinkedList<Runnable> linkedList, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) linkedList, obj);
        } else {
            this.sWork = linkedList;
            this.sLock = obj;
        }
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.sWork.clear();
        }
    }

    @Override // java.util.LinkedList
    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (Build.VERSION.SDK_INT < 31) {
            WorkProxy workProxy = new WorkProxy(new LinkedList(this.sWork), this.sLock);
            this.newSWork = workProxy;
            return workProxy;
        }
        return super.clone();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List, java.util.Deque
    public Iterator<Runnable> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Iterator) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.sWork.iterator();
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        return this.sWork.remove(obj);
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            this.newSWork = d.c();
        }
        int size = this.sWork.size();
        if (size > 0) {
            Handler b16 = d.b();
            if (b16 == null) {
                c.b("WorkProxy", "cannot get handler");
                return size;
            }
            synchronized (this.sLock) {
                WorkProxy workProxy = this.newSWork;
                if (workProxy != null && !workProxy.sWork.isEmpty()) {
                    c.b("WorkProxy", "new work was queued, skip post");
                    return size;
                }
                c.a("WorkProxy", "post sWork");
                b16.post(new Runnable() { // from class: com.tencent.mobileqq.squarepants.WorkProxy.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WorkProxy.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        c.a("WorkProxy", "do run sWork");
                        Iterator it = WorkProxy.this.sWork.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                        c.a("WorkProxy", "run sWork finished");
                    }
                });
                return 0;
            }
        }
        return size;
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.sWork.add(runnable) : ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable)).booleanValue();
    }
}
