package com.tencent.mobileqq.activity.activateFriend.biz;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends CardObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<WeakReference<a>> f177965d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void onResult(boolean z16);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f177965d = new ArrayList<>();
        }
    }

    public synchronized void a(WeakReference<a> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference);
        } else {
            this.f177965d.add(weakReference);
        }
    }

    @Override // com.tencent.mobileqq.app.CardObserver
    protected void onSetAllowActivateFriend(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        synchronized (this) {
            Iterator<WeakReference<a>> it = this.f177965d.iterator();
            while (it.hasNext()) {
                a aVar = it.next().get();
                if (aVar != null) {
                    aVar.onResult(z17);
                }
                it.remove();
            }
        }
    }
}
