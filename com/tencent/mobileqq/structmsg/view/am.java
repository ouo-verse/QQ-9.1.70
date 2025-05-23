package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class am extends ap {
    static IPatchRedirector $redirector_;

    /* renamed from: j1, reason: collision with root package name */
    private String f290595j1;

    public am() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.f290322e = "price";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.view.ap, com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        if (view != null && (view instanceof LinearLayout)) {
            LinearLayout linearLayout = (LinearLayout) view;
            ((TextView) linearLayout.findViewById(R.id.k_a)).setText(this.X0);
            ((TextView) linearLayout.findViewById(R.id.k_c)).setText(this.f290595j1);
            return linearLayout;
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        TextView textView = new TextView(context);
        textView.setId(R.id.k_a);
        textView.setText(this.X0);
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setTextSize(14.0f);
        textView.setSingleLine();
        textView.setEllipsize(q());
        textView.setGravity(3);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.k_c);
        textView2.setText(this.f290595j1);
        textView2.setSingleLine();
        textView2.setEllipsize(q());
        textView2.setTextSize(10.0f);
        textView2.setTextColor(SupportMenu.CATEGORY_MASK);
        textView2.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(5, 0, 0, 0);
        textView2.setLayoutParams(layoutParams);
        linearLayout2.addView(textView);
        linearLayout2.addView(textView2);
        linearLayout2.setTag(this);
        return linearLayout2;
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.f290595j1 = com.tencent.mobileqq.service.message.s.c(jVar.a("unit"), false);
        this.X0 = com.tencent.mobileqq.service.message.s.c(com.tencent.mobileqq.structmsg.i.h(jVar), false);
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.view.ap, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "Price";
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
        } else {
            super.i(objectInput);
            this.f290595j1 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "price");
        if (!TextUtils.isEmpty(this.f290595j1)) {
            xmlSerializer.attribute(null, "unit", this.f290595j1);
        }
        xmlSerializer.text(this.X0);
        xmlSerializer.endTag(null, "price");
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.f290595j1;
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
    }

    public am(String str) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.X0 = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    public am(String str, String str2) {
        this(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.f290595j1 = str2;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
    }
}
