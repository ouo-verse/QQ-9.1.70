package com.tencent.mobileqq.structmsg.view;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ao extends com.tencent.mobileqq.structmsg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name */
    String f290596g1;

    public ao() {
        this(null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f290596g1;
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.f290596g1 = jVar.a("bgColor");
        return super.d(jVar);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "Remark";
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
        } else {
            super.i(objectInput);
            this.f290596g1 = objectInput.readUTF();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xmlSerializer);
            return;
        }
        super.k(xmlSerializer);
        if (!TextUtils.isEmpty(this.f290596g1)) {
            xmlSerializer.attribute(null, "url", this.f290596g1);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.f290596g1;
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return Color.rgb(128, 128, 128);
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return 24;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.structmsg.b
    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return R.id.f167056ka4;
    }

    public ao(String str) {
        super(str, "remark");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }
}
