package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.ui.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends c {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public View a(int i3, View view, ViewGroup viewGroup, b bVar, b.C8175b c8175b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), view, viewGroup, bVar, c8175b);
        }
        Context context = viewGroup.getContext();
        if (view != null && ((b.C8175b) view.getTag()).f254839a == c8175b.f254839a) {
            return view;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168535a02, (ViewGroup) null);
        inflate.setTag(c8175b);
        return inflate;
    }
}
