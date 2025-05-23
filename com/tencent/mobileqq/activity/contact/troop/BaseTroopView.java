package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.MqqWeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseTroopView extends FrameLayout {
    static IPatchRedirector $redirector_;
    View C;
    View D;
    protected int E;

    /* renamed from: d, reason: collision with root package name */
    protected a f181328d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f181329e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f181330f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f181331h;

    /* renamed from: i, reason: collision with root package name */
    View f181332i;

    /* renamed from: m, reason: collision with root package name */
    View f181333m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        View b();

        View c();

        boolean d();

        boolean e();

        ForwardBaseOption f();

        View g();

        Activity getActivity();

        QQAppInterface getApp();

        MqqWeakReferenceHandler getHandler();

        View getRootView();

        void showToast(String str);
    }

    public BaseTroopView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f181330f = true;
        this.f181331h = false;
        this.E = 0;
    }

    public void e(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) businessObserver);
            return;
        }
        QQAppInterface qQAppInterface = this.f181329e;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(businessObserver);
        }
    }

    public Activity f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f181328d.getActivity();
    }

    public boolean g(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        return false;
    }

    protected final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return this.f181330f;
    }

    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f181331h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(Intent intent, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) aVar);
            return;
        }
        this.f181328d = aVar;
        this.f181329e = aVar.getApp();
        this.f181332i = this.f181328d.b();
        this.f181333m = this.f181328d.g();
        this.C = this.f181328d.getRootView();
        this.D = this.f181328d.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f181331h = false;
        }
    }

    public void o(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) businessObserver);
            return;
        }
        QQAppInterface qQAppInterface = this.f181329e;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(businessObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.f181330f = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.f181330f = true;
        }
    }

    public void p(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.f181328d.getHandler().sendEmptyMessageDelayed(i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i3, (ViewGroup) this, true);
            setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            s(getResources().getString(i3));
        }
    }

    protected final void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else if (!h()) {
            this.f181328d.showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) intent);
        } else {
            u(intent, 0);
        }
    }

    protected final void u(Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) intent, i3);
        } else {
            this.f181328d.getActivity().startActivityForResult(intent, i3);
        }
    }
}
