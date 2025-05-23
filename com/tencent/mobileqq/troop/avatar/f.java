package com.tencent.mobileqq.troop.avatar;

import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends i {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.i
    public void d(Class<? extends Thread> cls, ArrayList<TroopClipPic> arrayList, HashMap<String, String> hashMap, List<String> list, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cls, arrayList, hashMap, list, bVar);
            return;
        }
        TroopUploadingThread troopUploadingThread = this.f294557a;
        if (troopUploadingThread == null || troopUploadingThread.getState() == Thread.State.TERMINATED) {
            this.f294557a = (TroopUploadingThread) h.b(cls);
        }
        TroopUploadingThread troopUploadingThread2 = this.f294557a;
        if (troopUploadingThread2 == null) {
            return;
        }
        troopUploadingThread2.r(arrayList, hashMap, list, this);
        this.f294557a.s(bVar);
        if (!this.f294557a.isAlive()) {
            this.f294557a.start();
        }
    }
}
