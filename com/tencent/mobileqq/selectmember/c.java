package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c extends com.tencent.mobileqq.troop.memberlist.b {
    static IPatchRedirector $redirector_;
    public CheckBox E;
    public PhoneContact F;
    public TextView G;
    public boolean H;
    public TextView I;
    public View J;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static View a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i3) {
        View inflate = layoutInflater.inflate(i3, viewGroup, false);
        c cVar = new c();
        inflate.setTag(cVar);
        cVar.f297804i = (RelativeLayout) inflate.findViewById(R.id.icx);
        cVar.f297805m = (TextView) inflate.findViewById(R.id.k8u);
        cVar.E = (CheckBox) inflate.findViewById(R.id.axa);
        cVar.f187212f = (ImageView) inflate.findViewById(R.id.icon);
        cVar.G = (TextView) inflate.findViewById(R.id.k8l);
        cVar.I = (TextView) inflate.findViewById(R.id.k9z);
        cVar.C = (TextView) inflate.findViewById(R.id.f5e);
        cVar.J = inflate.findViewById(R.id.bll);
        return inflate;
    }

    public static void b(com.tencent.mobileqq.adapter.e eVar, c cVar, PhoneContact phoneContact) {
        cVar.f297804i.setVisibility(0);
        cVar.f297805m.setVisibility(8);
        cVar.f187211e = c(phoneContact.uin);
        if (TextUtils.isEmpty(phoneContact.uin)) {
            cVar.f187210d = "pstn" + phoneContact.mobileNo;
            cVar.f187212f.setImageResource(R.drawable.day);
            cVar.G.setVisibility(0);
            cVar.G.setText(com.tencent.mobileqq.selectmember.util.a.g(phoneContact.name));
            cVar.H = true;
            return;
        }
        if (!"0".equals(phoneContact.uin)) {
            String str = phoneContact.uin;
            cVar.f187210d = str;
            cVar.f187212f.setImageBitmap(eVar.d(str, 1, (byte) 0));
            cVar.G.setVisibility(8);
            cVar.H = false;
            return;
        }
        String str2 = phoneContact.nationCode + phoneContact.mobileCode;
        cVar.f187210d = str2;
        cVar.f187212f.setImageBitmap(eVar.d(str2, 11, (byte) 0));
        cVar.G.setVisibility(8);
        cVar.H = false;
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str) || "0".equals(str)) {
            return 11;
        }
        return 1;
    }
}
