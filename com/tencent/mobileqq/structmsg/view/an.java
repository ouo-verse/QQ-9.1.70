package com.tencent.mobileqq.structmsg.view;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class an extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    private int R0;

    public an() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.R0 = 0;
            this.f290322e = "progress";
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        ProgressBar progressBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        if (view != null && (view instanceof ProgressBar)) {
            progressBar = (ProgressBar) view;
        } else {
            progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
            progressBar.setId(com.tencent.mobileqq.R.id.j4o);
            progressBar.setMax(100);
            progressBar.setProgressDrawable(context.getResources().getDrawable(com.tencent.mobileqq.R.drawable.f160116am));
        }
        progressBar.setTag(this);
        progressBar.setProgress(this.R0);
        if (this.R0 == progressBar.getMax()) {
            progressBar.setVisibility(8);
        }
        return progressBar;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar)).booleanValue();
        }
        try {
            this.R0 = Integer.valueOf(com.tencent.mobileqq.structmsg.i.h(jVar)).intValue();
            return true;
        } catch (NumberFormatException unused) {
            this.R0 = 0;
            return true;
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "Progress";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
        } else {
            super.i(objectInput);
            this.R0 = objectInput.readInt();
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "progress");
        xmlSerializer.text(String.valueOf(this.R0));
        xmlSerializer.endTag(null, "progress");
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectOutput);
        } else {
            super.l(objectOutput);
            objectOutput.writeInt(this.R0);
        }
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.R0;
    }

    public void n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.R0 = i3;
        }
    }
}
