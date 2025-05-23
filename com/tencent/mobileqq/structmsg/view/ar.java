package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
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
public class ar extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public String R0;
    public String S0;
    public String T0;
    public int U0;
    public int V0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f290606a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f290607b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f290608c;

        /* renamed from: d, reason: collision with root package name */
        TextView f290609d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ar.this);
                return;
            }
            this.f290606a = null;
            this.f290607b = null;
            this.f290608c = null;
            this.f290609d = null;
        }
    }

    public ar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.R0 = null;
        this.S0 = null;
        this.T0 = null;
        this.U0 = 0;
        this.V0 = 0;
        this.f290322e = "textButton";
        q(32);
        r(32);
    }

    private LinearLayout m(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setId(R.id.kbm);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, context, view, bundle);
        }
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            a aVar2 = new a();
            aVar2.f290606a = m(context);
            aVar2.f290607b = new ImageView(context);
            aVar2.f290608c = new ImageView(context);
            aVar2.f290609d = new TextView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            aVar2.f290606a.addView(aVar2.f290607b, layoutParams);
            aVar2.f290606a.addView(aVar2.f290609d, layoutParams);
            aVar2.f290606a.addView(aVar2.f290608c, layoutParams);
            aVar2.f290606a.setTag(aVar2);
            view = aVar2.f290606a;
            aVar = aVar2;
        }
        aVar.f290609d.setTag(this);
        aVar.f290609d.setTextColor(n());
        aVar.f290609d.requestLayout();
        aVar.f290609d.setTypeface(Typeface.DEFAULT, p());
        aVar.f290609d.setTextSize(o() / 2);
        if (!TextUtils.isEmpty(this.R0)) {
            aVar.f290609d.setText(this.R0);
        }
        try {
            if (!TextUtils.isEmpty(this.S0)) {
                String str = this.S0;
                int i3 = this.U0;
                URLDrawable drawable = URLDrawable.getDrawable(str, i3, i3, (Drawable) null, (Drawable) null);
                drawable.setAutoDownload(true);
                aVar.f290607b.setImageDrawable(drawable);
            }
            if (!TextUtils.isEmpty(this.T0)) {
                String str2 = this.T0;
                int i16 = this.V0;
                URLDrawable drawable2 = URLDrawable.getDrawable(str2, i16, i16, (Drawable) null, (Drawable) null);
                drawable2.setAutoDownload(true);
                aVar.f290607b.setImageDrawable(drawable2);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, " URLDrawable.exception illegal url : " + e16.getMessage());
            }
        }
        String str3 = this.f290329i;
        if (str3 != null && !str3.equals("")) {
            view.setClickable(true);
            view.setOnClickListener(this);
        }
        return view;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.f290327h = jVar.a("url");
        this.S0 = jVar.a("leftImage");
        this.T0 = jVar.a("rightImage");
        this.R0 = com.tencent.mobileqq.service.message.s.c(jVar.a("text"), false);
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "TextButton";
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.R0 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        this.S0 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        this.T0 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        this.f290327h = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, this.f290322e);
        if (!TextUtils.isEmpty(this.R0)) {
            xmlSerializer.attribute(null, "text", this.R0);
        }
        if (!TextUtils.isEmpty(this.S0)) {
            xmlSerializer.attribute(null, "leftImage", this.S0);
        }
        if (!TextUtils.isEmpty(this.T0)) {
            xmlSerializer.attribute(null, "rightImage", this.T0);
        }
        if (!TextUtils.isEmpty(this.f290327h)) {
            xmlSerializer.attribute(null, "url", this.f290327h);
        }
        xmlSerializer.endTag(null, this.f290322e);
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.R0;
        String str2 = "";
        if (str == null) {
            c16 = "";
        } else {
            c16 = com.tencent.mobileqq.service.message.s.c(str, false);
        }
        objectOutput.writeUTF(c16);
        String str3 = this.S0;
        if (str3 == null) {
            str3 = "";
        }
        objectOutput.writeUTF(str3);
        String str4 = this.T0;
        if (str4 == null) {
            str4 = "";
        }
        objectOutput.writeUTF(str4);
        String str5 = this.f290327h;
        if (str5 != null) {
            str2 = str5;
        }
        objectOutput.writeUTF(str2);
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return -16777216;
    }

    public int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 26;
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 0;
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.U0 = i3;
        }
    }

    public void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.V0 = i3;
        }
    }
}
