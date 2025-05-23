package com.tencent.mobileqq.activity.newsetting.custom.item;

import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c extends d<TextView> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f183664f;

    /* renamed from: g, reason: collision with root package name */
    private int f183665g;

    /* renamed from: h, reason: collision with root package name */
    private int f183666h;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183664f = null;
        this.f183665g = -1;
        this.f183666h = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.newsetting.custom.item.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.a();
        if (this.f183664f == null) {
            this.f183664f = ((TextView) this.f183667a).getText();
        }
        j(this.f183664f);
        i(this.f183665g);
        k(this.f183666h);
    }

    public void i(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0 && i3 != -1) {
            ((TextView) t16).setMaxWidth(i3);
        }
        this.f183665g = i3;
    }

    public void j(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0) {
            ((TextView) t16).setText(charSequence);
        }
        this.f183664f = charSequence;
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0 && i3 != -1) {
            ((TextView) t16).setTextColor(i3);
        }
        this.f183666h = i3;
    }
}
