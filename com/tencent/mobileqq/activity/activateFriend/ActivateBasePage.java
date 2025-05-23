package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;

/* loaded from: classes9.dex */
public abstract class ActivateBasePage extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static float f177777i;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f177778d;

    /* renamed from: e, reason: collision with root package name */
    View f177779e;

    /* renamed from: f, reason: collision with root package name */
    TextView f177780f;

    /* renamed from: h, reason: collision with root package name */
    ActivateFriendGrid f177781h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f177777i = 2.3648648f;
        }
    }

    public ActivateBasePage(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f177779e = null;
        this.f177778d = LayoutInflater.from(context);
        b();
        if (QQTheme.isNowThemeIsNight()) {
            a();
        }
        ActivateFriendGrid activateFriendGrid = this.f177781h;
        if (activateFriendGrid != null) {
            activateFriendGrid.setTextScrolling(false);
        }
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ActivateFriendGrid activateFriendGrid = this.f177781h;
        if (activateFriendGrid != null) {
            activateFriendGrid.i();
        }
    }

    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public ActivateBasePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f177779e = null;
            this.f177778d = LayoutInflater.from(context);
        }
    }
}
