package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class i extends Observable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected TroopUploadingThread f294557a;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public ArrayList<g> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        TroopUploadingThread troopUploadingThread = this.f294557a;
        if (troopUploadingThread != null) {
            return troopUploadingThread.o();
        }
        return null;
    }

    public void b(Observer observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) observer);
        } else {
            super.deleteObserver(observer);
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        TroopUploadingThread troopUploadingThread = this.f294557a;
        if (troopUploadingThread != null) {
            troopUploadingThread.q(str);
        }
    }

    public abstract void d(Class<? extends Thread> cls, ArrayList<TroopClipPic> arrayList, HashMap<String, String> hashMap, List<String> list, b bVar);

    @Override // java.util.Observable
    public void notifyObservers(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
        } else {
            super.setChanged();
            super.notifyObservers(obj);
        }
    }
}
