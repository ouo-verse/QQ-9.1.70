package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends com.tencent.mobileqq.activity.contacts.base.a {
    static IPatchRedirector $redirector_;
    protected ImageView C;
    protected XListView D;
    protected InterfaceC7159b E;
    private StudyModeChangeListener F;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f181771e;

    /* renamed from: f, reason: collision with root package name */
    protected FrameLayout f181772f;

    /* renamed from: h, reason: collision with root package name */
    protected FrameLayout f181773h;

    /* renamed from: i, reason: collision with root package name */
    protected AlphaClickableRelativeLayout f181774i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f181775m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements StudyModeChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                b.this.m(b.this.p());
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.contacts.topentry.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7159b {
        void a();
    }

    public b(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.F = new a();
        if (activity instanceof SplashActivity) {
            this.f181771e = ((SplashActivity) activity).app;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CTEntryController", 2, "CTEntryController create");
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void g(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            return;
        }
        super.g(view);
        this.f181772f = (FrameLayout) view.findViewById(R.id.ixi);
        this.f181773h = (FrameLayout) view.findViewById(R.id.f71213nj);
        this.f181774i = (AlphaClickableRelativeLayout) view.findViewById(R.id.f166766i32);
        this.f181775m = (TextView) view.findViewById(R.id.i38);
        this.D = (XListView) view.findViewById(R.id.f166197eo1);
        this.C = (ImageView) view.findViewById(R.id.i3);
        this.D.setSelector(new ColorDrawable(0));
        this.D.setNeedCheckSpringback(false);
        this.D.setCacheColorHint(0);
        this.D.setDivider(null);
        this.D.setOverScrollMode(2);
        this.D.mForContacts = true;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.i();
            StudyModeManager.H(this.F);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.j();
            StudyModeManager.U(this.F);
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }
    }

    public void n(boolean z16) {
        throw null;
    }

    public void o(InterfaceC7159b interfaceC7159b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC7159b);
        } else {
            this.E = interfaceC7159b;
        }
    }

    protected boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        boolean t16 = StudyModeManager.t();
        if (QLog.isColorLevel()) {
            QLog.d("CTEntryController", 2, String.format("shouldShowRecommendEntry, isStudyMode: %s", Boolean.valueOf(t16)));
        }
        return !t16;
    }
}
