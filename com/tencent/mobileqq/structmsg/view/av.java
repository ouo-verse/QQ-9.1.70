package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class av extends com.tencent.mobileqq.structmsg.b {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name */
    public int f290623g1;

    /* renamed from: h1, reason: collision with root package name */
    public int f290624h1;

    /* renamed from: i1, reason: collision with root package name */
    public int f290625i1;

    /* renamed from: j1, reason: collision with root package name */
    public ArrayList<a> f290626j1;

    public av() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f290623g1 = 0;
        this.f290624h1 = 0;
        this.f290625i1 = 0;
        this.f290626j1 = null;
        this.f290322e = "checklist";
        K("12");
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        LinearLayout linearLayout;
        int parseInt;
        List<a> list;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, view, bundle);
        }
        boolean z16 = true;
        if (view == null) {
            linearLayout = new LinearLayout(context);
            linearLayout.setId(R.id.k6b);
            linearLayout.setOrientation(1);
        } else {
            linearLayout = (LinearLayout) view;
        }
        if (this.f290626j1 != null) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.f162488h30);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            if (TextUtils.isEmpty(this.U0)) {
                parseInt = o();
            } else {
                parseInt = Integer.parseInt(this.U0);
            }
            int i3 = parseInt / 2;
            if (this.f290626j1.size() != linearLayout.getChildCount()) {
                z16 = false;
            }
            if (!z16 && linearLayout.getChildCount() > 0) {
                linearLayout.removeAllViews();
            }
            if (this.f290626j1.size() > 2) {
                list = this.f290626j1.subList(0, 2);
            } else {
                list = this.f290626j1;
            }
            for (int i16 = 0; i16 < list.size(); i16++) {
                a aVar = list.get(i16);
                if (aVar != null) {
                    if (z16) {
                        textView = (TextView) linearLayout.getChildAt(i16);
                    } else {
                        textView = new TextView(context);
                    }
                    textView.setSingleLine();
                    textView.setEllipsize(q());
                    textView.setGravity(16);
                    textView.setTextSize(i3);
                    textView.setCompoundDrawables(drawable, null, null, null);
                    textView.setText(" " + aVar.f290628b);
                    if (!z16) {
                        linearLayout.addView(textView);
                    }
                }
            }
        }
        linearLayout.setTag(this);
        return linearLayout;
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        String a16 = jVar.a(Element.ELEMENT_NAME_MIN);
        String a17 = jVar.a("max");
        try {
            this.f290624h1 = Integer.parseInt(a16);
            this.f290623g1 = Integer.parseInt(a17);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("StructMsg", 2, e16.getMessage());
            }
        }
        this.f290625i1 = jVar.b();
        this.f290626j1 = new ArrayList<>(this.f290625i1);
        for (int i3 = 0; i3 < this.f290625i1; i3++) {
            com.tencent.mobileqq.structmsg.j c16 = jVar.c(i3);
            if (c16 != null) {
                this.f290626j1.add(new a(c16));
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "Vote";
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.f290624h1 = objectInput.readInt();
        this.f290623g1 = objectInput.readInt();
        this.f290625i1 = objectInput.readInt();
        this.f290626j1 = new ArrayList<>(this.f290625i1);
        for (int i3 = 0; i3 < this.f290625i1; i3++) {
            this.f290626j1.add(new a(objectInput.readUTF(), objectInput.readUTF()));
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, "checklist");
        xmlSerializer.attribute(null, Element.ELEMENT_NAME_MIN, String.valueOf(this.f290624h1));
        xmlSerializer.attribute(null, "max", String.valueOf(this.f290623g1));
        ArrayList<a> arrayList = this.f290626j1;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < this.f290626j1.size(); i3++) {
                a aVar = this.f290626j1.get(i3);
                if (aVar != null) {
                    xmlSerializer.startTag(null, aVar.f290627a);
                    String str = aVar.f290628b;
                    if (str == null) {
                        str = "";
                    }
                    xmlSerializer.attribute(null, Element.ELEMENT_NAME_MIN, str);
                    xmlSerializer.endTag(null, aVar.f290627a);
                }
            }
        }
        xmlSerializer.endTag(null, "checklist");
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        objectOutput.writeInt(this.f290624h1);
        objectOutput.writeInt(this.f290623g1);
        objectOutput.writeInt(this.f290625i1);
        ArrayList<a> arrayList = this.f290626j1;
        if (arrayList != null && arrayList.size() == this.f290625i1) {
            for (int i3 = 0; i3 < this.f290625i1; i3++) {
                a aVar = this.f290626j1.get(i3);
                if (aVar != null) {
                    String str = aVar.f290627a;
                    String str2 = "";
                    if (str == null) {
                        str = "";
                    }
                    objectOutput.writeUTF(str);
                    String str3 = aVar.f290628b;
                    if (str3 != null) {
                        str2 = str3;
                    }
                    objectOutput.writeUTF(str2);
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("StructMsg", 2, "StructMsgItemVote writeExternal() mOptions is null, or size is error!");
        }
    }

    @Override // com.tencent.mobileqq.structmsg.b
    protected int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.id.kcd;
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f290627a;

        /* renamed from: b, reason: collision with root package name */
        String f290628b;

        public a(com.tencent.mobileqq.structmsg.j jVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) av.this, (Object) jVar);
                return;
            }
            if (jVar == null) {
                return;
            }
            String a16 = jVar.a("c");
            this.f290627a = a16;
            if (TextUtils.isEmpty(a16)) {
                this.f290627a = jVar.a("r");
            }
            this.f290628b = com.tencent.mobileqq.service.message.s.c(com.tencent.mobileqq.structmsg.i.h(jVar), false);
        }

        public a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, av.this, str, str2);
            } else {
                this.f290627a = str;
                this.f290628b = str2;
            }
        }
    }
}
