package com.tencent.mobileqq.qqperftool.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperftool.common.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public abstract class a<E extends c> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected volatile Map<String, E> f274250a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f274250a = new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean c(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
        }
        if (e16 == null) {
            return false;
        }
        if (this.f274250a.containsKey(e16.getComponentName())) {
            return false;
        }
        this.f274250a.put(e16.getComponentName(), e16);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (str == null) {
            return false;
        }
        return this.f274250a.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized List<E> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f274250a.values());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(E e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) e16);
        } else {
            if (e16 == null) {
                return;
            }
            g(e16.getComponentName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            if (str == null) {
                return;
            }
            if (this.f274250a.containsKey(str)) {
                this.f274250a.remove(str);
            }
        }
    }
}
