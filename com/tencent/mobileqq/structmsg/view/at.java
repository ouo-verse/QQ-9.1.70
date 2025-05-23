package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class at extends AbsStructMsgElement {
    static IPatchRedirector $redirector_;
    public final ArrayList<AbsStructMsgElement> R0;
    private int S0;
    public int T0;
    public int U0;
    public boolean V0;

    public at() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.S0 = 0;
        int f16 = BaseAIOUtils.f(2.5f, BaseApplication.getContext().getResources());
        this.T0 = f16;
        this.U0 = f16;
        this.V0 = false;
        this.f290322e = ReportConstant.COSTREPORT_TRANS;
        this.R0 = new ArrayList<>();
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        ViewGroup linearLayout;
        LinearLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, context, view, bundle);
        }
        if (this.V0) {
            return null;
        }
        if (view != null && (view instanceof ViewGroup)) {
            linearLayout = (ViewGroup) view;
            linearLayout.removeAllViews();
        } else {
            linearLayout = new LinearLayout(context);
        }
        for (int i3 = 0; i3 < this.R0.size(); i3++) {
            AbsStructMsgElement absStructMsgElement = this.R0.get(i3);
            if (absStructMsgElement instanceof aq) {
                aq aqVar = (aq) absStructMsgElement;
                View c16 = aqVar.c(context, null, bundle);
                if (c16 instanceof TextView) {
                    int i16 = aqVar.f290605l1;
                    if (i16 == 0) {
                        i16 = 1;
                    }
                    if (this.S0 != 1) {
                        layoutParams = new LinearLayout.LayoutParams(0, -1, i16);
                    } else {
                        layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    }
                    ((TextView) c16).setGravity(aqVar.f290603j1);
                    linearLayout.addView(c16, layoutParams);
                    if (bundle.getBoolean("key_support_night_mode", false) && QQTheme.isNowThemeIsNight()) {
                        aqVar.b(c16);
                    }
                }
            }
        }
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        String[] split;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jVar)).booleanValue();
        }
        String a16 = jVar.a("mode");
        if (!TextUtils.isEmpty(a16)) {
            try {
                this.S0 = Integer.valueOf(a16).intValue();
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("StructMsgItemTr", 2, "mode must be a numeric ", e16);
                }
            }
        }
        String a17 = jVar.a("margin");
        if (!TextUtils.isEmpty(a17) && (split = a17.split(",")) != null && split.length >= 2) {
            try {
                Resources resources = BaseApplication.getContext().getResources();
                this.T0 = BaseAIOUtils.f(Float.valueOf(split[0]).floatValue(), resources);
                this.U0 = BaseAIOUtils.f(Float.valueOf(split[1]).floatValue(), resources);
            } catch (NumberFormatException e17) {
                if (QLog.isColorLevel()) {
                    QLog.w("StructMsgItemTr", 2, "h must be a numeric ", e17);
                }
                this.T0 = 0;
                this.U0 = 0;
            }
        }
        String a18 = jVar.a("hidden");
        if (a18 != null && a18.toLowerCase().equals("true")) {
            this.V0 = true;
        }
        for (int i3 = 0; i3 < jVar.b(); i3++) {
            com.tencent.mobileqq.structmsg.j c16 = jVar.c(i3);
            if (c16 != null && "td".equals(c16.f290428b)) {
                AbsStructMsgElement a19 = com.tencent.mobileqq.structmsg.h.a(c16.f290428b);
                if (a19 == null || !a19.d(c16)) {
                    return false;
                }
                m(a19);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return ReportConstant.COSTREPORT_TRANS;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        AbsStructMsgElement a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.S0 = objectInput.readInt();
        this.T0 = objectInput.readInt();
        this.U0 = objectInput.readInt();
        int readInt = objectInput.readInt();
        String readUTF = objectInput.readUTF();
        if (readUTF != null && readUTF.toLowerCase().equals("true")) {
            this.V0 = true;
        }
        for (int i3 = 0; i3 < readInt; i3++) {
            String readUTF2 = objectInput.readUTF();
            if ("td".equals(readUTF2) && (a16 = com.tencent.mobileqq.structmsg.h.a(readUTF2)) != null) {
                a16.i(objectInput);
                m(a16);
            }
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
        } else {
            xmlSerializer.startTag(null, ReportConstant.COSTREPORT_TRANS);
            xmlSerializer.endTag(null, ReportConstant.COSTREPORT_TRANS);
        }
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        objectOutput.writeInt(this.S0);
        objectOutput.writeInt(this.T0);
        objectOutput.writeInt(this.U0);
        objectOutput.writeInt(this.R0.size());
        if (this.V0) {
            str = "true";
        } else {
            str = "false";
        }
        objectOutput.writeUTF(str);
        Iterator<AbsStructMsgElement> it = this.R0.iterator();
        while (it.hasNext()) {
            it.next().l(objectOutput);
        }
    }

    void m(AbsStructMsgElement absStructMsgElement) {
        this.R0.add(absStructMsgElement);
    }
}
