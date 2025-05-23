package com.tencent.mobileqq.webview.swift.proxy;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webviewplugin.q;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements q {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected q f314614d;

    public b(@NonNull q qVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qVar);
        } else {
            this.f314614d = qVar;
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Ad(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f314614d.Ad(z16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Hf(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f314614d.Hf(i3);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Kb(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f314614d.Kb(i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Pg(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f314614d.Pg(z16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void Sc(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f314614d.Sc(z16, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public View a3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f314614d.a3();
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.f314614d.getTitleBarHeight();
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public View getTitleBarView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (View) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f314614d.getTitleBarView();
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void jg(String str, String str2, String str3, boolean z16, int i3, int i16, View.OnClickListener onClickListener, com.tencent.mobileqq.webview.nativeapi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), onClickListener, aVar);
        } else {
            this.f314614d.jg(str, str2, str3, z16, i3, i16, onClickListener, aVar);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void sc(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) jSONObject);
        } else {
            this.f314614d.sc(jSONObject);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void setRightButton(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.f314614d.setRightButton(z16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void u5(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f314614d.u5(z16);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.q
    public void u6(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f314614d.u6(z16);
        }
    }
}
