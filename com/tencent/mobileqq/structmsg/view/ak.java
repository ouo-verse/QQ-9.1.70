package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ak extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    String R0;
    String S0;
    String T0;

    public ak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.T0 = "";
            this.f290322e = "more";
        }
    }

    private void m(ImageView imageView, String str) {
        if ("mail".equals(str)) {
            imageView.setImageResource(R.drawable.mzz);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.f166928j55);
        if (textView != null) {
            textView.setTextColor(-1);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.bzf, (ViewGroup) null);
        }
        TextView textView = (TextView) view.findViewById(R.id.f166928j55);
        if (TextUtils.isEmpty(this.T0)) {
            this.T0 = HardCodeUtil.qqStr(R.string.twg);
        }
        textView.setText(this.T0);
        TextView textView2 = (TextView) view.findViewById(R.id.f902351x);
        ImageView imageView = (ImageView) view.findViewById(R.id.f902251w);
        if (!TextUtils.isEmpty(this.R0)) {
            textView2.setText(this.R0);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.S0)) {
            m(imageView, this.S0);
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        return view;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jVar)).booleanValue();
        }
        this.R0 = jVar.a("subText");
        this.S0 = jVar.a("iconType");
        this.T0 = com.tencent.mobileqq.service.message.s.c(com.tencent.mobileqq.structmsg.i.h(jVar), false);
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "More";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.T0 = objectInput.readUTF();
        this.R0 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        this.S0 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "title");
        if (!TextUtils.isEmpty(this.R0)) {
            xmlSerializer.attribute(null, "subText", this.R0);
        }
        if (!TextUtils.isEmpty(this.S0)) {
            xmlSerializer.attribute(null, "iconType", this.S0);
        }
        xmlSerializer.text(this.T0);
        xmlSerializer.endTag(null, "title");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.T0;
        String str2 = "";
        if (str == null) {
            c16 = "";
        } else {
            c16 = com.tencent.mobileqq.service.message.s.c(str, false);
        }
        objectOutput.writeUTF(c16);
        String str3 = this.R0;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.S0;
        if (str4 != null) {
            str2 = str4;
        }
        objectOutput.writeUTF(str2);
    }

    public ak(String str) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.T0 = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
