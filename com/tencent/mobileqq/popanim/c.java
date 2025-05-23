package com.tencent.mobileqq.popanim;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.popanim.a;
import com.tencent.mobileqq.popanim.state.f;
import com.tencent.mobileqq.popanim.state.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements a.InterfaceC8226a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f259110a;

    /* renamed from: b, reason: collision with root package name */
    private EditText f259111b;

    /* renamed from: c, reason: collision with root package name */
    private View f259112c;

    /* renamed from: d, reason: collision with root package name */
    private int f259113d;

    /* renamed from: e, reason: collision with root package name */
    private g f259114e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f259115f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f259116g;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f259113d = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
            this.f259112c = PopOutAnimViewHolder.d().c().findViewById(R.id.f26360db);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        this.f259111b.getLocationOnScreen(new int[2]);
        if (motionEvent.getRawY() > r0[1]) {
            return true;
        }
        return false;
    }

    public void b(ViewGroup viewGroup, ViewGroup viewGroup2, QQEmoticonPanelLinearLayoutHelper qQEmoticonPanelLinearLayoutHelper, IPanelInteractionListener iPanelInteractionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, viewGroup, viewGroup2, qQEmoticonPanelLinearLayoutHelper, iPanelInteractionListener);
            return;
        }
        EmoticonMainPanel emoticonMainPanel = (EmoticonMainPanel) ((IEmosmService) QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(iPanelInteractionListener);
        if (emoticonMainPanel == null) {
            QLog.e("PopOutEmoticonGesture", 1, "init, get mainPane fail");
        } else {
            ((a) emoticonMainPanel.getEmoController().getHelperProvider().getHelper(10)).b(this);
        }
        this.f259111b = iPanelInteractionListener.getEditText();
        f fVar = new f();
        fVar.f259136a = this;
        fVar.f259138c = iPanelInteractionListener.getPopOutAnimConfig();
        fVar.f259139d = viewGroup;
        fVar.f259140e = viewGroup2;
        fVar.f259141f = this.f259111b;
        fVar.f259142g = new WeakReference<>(qQEmoticonPanelLinearLayoutHelper);
        fVar.f259143h = iPanelInteractionListener;
        this.f259114e = new g(fVar);
        if (QLog.isColorLevel()) {
            QLog.i("PopOutEmoticonGesture", 2, "init");
        }
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f259110a;
    }

    public boolean d(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getRawY() > this.f259113d - this.f259112c.getHeight()) {
            return true;
        }
        return false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.f259116g = true;
        if (this.f259115f) {
            this.f259114e.a();
        }
    }

    public boolean f(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.f259114e.c(motionEvent, this);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.f259115f = false;
        this.f259116g = false;
        this.f259110a = false;
    }

    public void h(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) emoticonInfo);
        } else {
            this.f259110a = true;
            this.f259114e.d(emoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.popanim.a.InterfaceC8226a
    public void onHide() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f259115f = true;
        if (this.f259116g) {
            this.f259114e.a();
        }
    }

    @Override // com.tencent.mobileqq.popanim.a.InterfaceC8226a
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.f259114e.a();
        }
    }
}
