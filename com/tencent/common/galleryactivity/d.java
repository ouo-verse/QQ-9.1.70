package com.tencent.common.galleryactivity;

import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class d extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    e f99867d;

    /* renamed from: e, reason: collision with root package name */
    private g f99868e;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private g b(int i3) {
        e eVar = this.f99867d;
        if (eVar != null && i3 == eVar.getSelectedIndex()) {
            return this.f99868e;
        }
        return null;
    }

    public void I0(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        g b16 = b(i3);
        if (b16 != null) {
            b16.start(i16);
        }
    }

    public e a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f99867d;
    }

    public abstract void c(View view, int i3);

    public void d(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
        } else {
            this.f99867d = eVar;
        }
    }

    public void e(g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) gVar);
        } else {
            this.f99868e = gVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        e eVar = this.f99867d;
        if (eVar == null) {
            return 0;
        }
        return eVar.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        e eVar = this.f99867d;
        if (eVar == null) {
            return null;
        }
        return eVar.getItem(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this, i3)).longValue();
        }
        return i3;
    }

    public void k2(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        g b16 = b(i3);
        if (b16 != null) {
            b16.stop();
        }
    }

    public void q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        g b16 = b(i3);
        if (b16 != null && b16.isShow()) {
            b16.start(i16);
        }
    }
}
