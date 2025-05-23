package com.tencent.mobileqq.newfriend.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class BaseNewFriendView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public a f254172d;

    /* renamed from: e, reason: collision with root package name */
    protected AppInterface f254173e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f254174f;

    /* renamed from: h, reason: collision with root package name */
    protected Intent f254175h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f254176i;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        Activity getActivity();

        AppRuntime getApp();

        void startProgress();

        void startTitleProgress();

        boolean stopProgress();

        void stopTitleProgress();
    }

    public BaseNewFriendView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f254176i = false;
        }
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            this.f254174f = true;
            this.f254172d.getActivity().finish();
        }
    }

    protected final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.f254174f;
    }

    public void c(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getForwardSelectionRequest() == i3 && i16 != 0) {
            this.f254172d.getActivity().setResult(i16, intent);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Intent intent, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) aVar);
            return;
        }
        this.f254175h = intent;
        this.f254172d = aVar;
        this.f254173e = (AppInterface) aVar.getApp();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.f254174f = false;
        if (this.f254176i) {
            this.f254172d.startTitleProgress();
        } else {
            this.f254172d.stopTitleProgress();
        }
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            k();
            this.f254174f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i3, (ViewGroup) this, true);
        }
    }

    protected final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f254176i = false;
        if (!b()) {
            this.f254172d.stopTitleProgress();
        }
    }
}
