package com.tencent.mobileqq.activity.newsetting.custom.item;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends d<QUIButton> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f183659f;

    /* renamed from: g, reason: collision with root package name */
    private int f183660g;

    /* renamed from: h, reason: collision with root package name */
    private int f183661h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f183662i;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183659f = null;
        this.f183660g = -1;
        this.f183661h = -1;
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
        if (this.f183659f == null) {
            this.f183659f = ((QUIButton) this.f183667a).getText();
        }
        j(this.f183659f);
        k(this.f183661h);
        Drawable drawable = this.f183662i;
        if (drawable != null) {
            i(drawable);
        }
    }

    public void i(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0) {
            ((QUIButton) t16).setBackgroundDrawable(drawable);
        }
        this.f183662i = drawable;
    }

    public void j(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) charSequence);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0) {
            ((QUIButton) t16).setText(charSequence);
        }
        this.f183659f = charSequence;
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        T t16 = this.f183667a;
        if (t16 != 0 && i3 != -1) {
            ((QUIButton) t16).setTextColor(i3);
        }
        this.f183661h = i3;
    }
}
