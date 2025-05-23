package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public boolean R0;
    public int S0;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R0 = false;
        this.S0 = 0;
        this.f290322e = "hr";
        this.f290320d = 9;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            view.setBackgroundColor(Color.parseColor("#1A1A1A"));
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    @TargetApi(11)
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        if (this.R0) {
            return null;
        }
        if (view == null) {
            view = new View(context);
        }
        int i3 = this.S0;
        if (i3 == 0) {
            view.setBackgroundColor(-2170912);
        } else if (i3 == 1) {
            view.setBackgroundResource(R.drawable.apo);
            view.setLayerType(1, null);
        }
        return view;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        if (this.f290320d > 4 && (a16 = jVar.a("hidden")) != null && a16.toLowerCase().equals("true")) {
            this.R0 = true;
        }
        if (this.f290320d >= 9) {
            String a17 = jVar.a("style");
            if (!TextUtils.isEmpty(a17)) {
                try {
                    this.S0 = Integer.parseInt(a17);
                    if (QLog.isColorLevel()) {
                        QLog.i("StructMsg", 2, "type=" + this.S0);
                    }
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("StructMsg", 2, "", e16);
                        return false;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "Hr";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        String readUTF;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        if (this.f290320d > 4 && (readUTF = objectInput.readUTF()) != null && readUTF.toLowerCase().equals("true")) {
            this.R0 = true;
        }
        if (this.f290320d >= 9) {
            this.S0 = objectInput.readInt();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "hr");
        if (this.f290320d > 4) {
            if (this.R0) {
                str = "true";
            } else {
                str = "false";
            }
            xmlSerializer.attribute(null, "hidden", str);
        }
        if (this.f290320d >= 9) {
            xmlSerializer.attribute(null, "style", String.valueOf(this.S0));
        }
        xmlSerializer.endTag(null, "hr");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        if (this.R0) {
            str = "true";
        } else {
            str = "false";
        }
        objectOutput.writeUTF(str);
        objectOutput.writeInt(this.S0);
    }
}
