package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ac {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<View> f184781a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<RedTouch> f184782b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<RedTouchTextView> f184783c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<TianshuRedTouch> f184784d;

    public ac() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public TianshuRedTouch a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TianshuRedTouch) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        WeakReference<TianshuRedTouch> weakReference = this.f184784d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public RedTouchTextView b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RedTouchTextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        WeakReference<RedTouchTextView> weakReference = this.f184783c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public RedTouch c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RedTouch) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        WeakReference<RedTouch> weakReference = this.f184782b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        WeakReference<View> weakReference = this.f184781a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void e(TianshuRedTouch tianshuRedTouch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tianshuRedTouch);
        } else {
            this.f184784d = new WeakReference<>(tianshuRedTouch);
        }
    }

    public void f(RedTouchTextView redTouchTextView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) redTouchTextView);
        } else {
            this.f184783c = new WeakReference<>(redTouchTextView);
        }
    }

    public void g(RedTouch redTouch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) redTouch);
        } else {
            this.f184782b = new WeakReference<>(redTouch);
        }
    }

    public void h(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            this.f184781a = new WeakReference<>(view);
        }
    }
}
