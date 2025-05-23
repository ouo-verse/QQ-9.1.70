package com.tencent.imcore.message.msgproxy;

import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class c implements ad.c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean a(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean b(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean d(MessageRecord messageRecord, MessageRecord messageRecord2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord, (Object) messageRecord2)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public MessageRecord e(ArrayList<MessageRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean f(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean h(AppRuntime appRuntime, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appRuntime, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean i(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ad.c
    public void j(Exception exc, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) exc, (Object) list);
        }
    }

    @Override // com.tencent.imcore.message.ad.c
    public boolean k(MessageRecord messageRecord, MessageRecord messageRecord2, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 3, this, messageRecord, messageRecord2, str, str2)).booleanValue();
    }
}
