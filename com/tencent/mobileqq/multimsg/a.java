package com.tencent.mobileqq.multimsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f251587a;

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f251587a = qQAppInterface;
        }
    }

    @Override // com.tencent.mobileqq.multimsg.c
    public void a(h hVar, HashMap<String, ArrayList<MessageRecord>> hashMap, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, hVar, hashMap, dVar);
        }
    }

    public boolean b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 != 9311 && i3 != 9313 && i3 != 9351) {
            return false;
        }
        return true;
    }
}
