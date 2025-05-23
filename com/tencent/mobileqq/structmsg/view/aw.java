package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class aw extends c {
    static IPatchRedirector $redirector_;

    public aw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290322e = "vote";
        }
    }

    @Override // com.tencent.mobileqq.structmsg.view.c, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        String a16 = jVar.a("cover");
        if (a16 == null) {
            a16 = "";
        }
        this.S0 = a16;
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.view.c, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "VoteCover";
    }

    @Override // com.tencent.mobileqq.structmsg.view.c, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "vote");
        String str = this.S0;
        if (str == null) {
            str = "";
        }
        xmlSerializer.attribute(null, "cover", str);
        xmlSerializer.endTag(null, "vote");
    }
}
