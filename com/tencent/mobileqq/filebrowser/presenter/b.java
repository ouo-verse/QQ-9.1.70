package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ao;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends SimpleFilePresenter implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private final e.b K;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements e.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.filebrowser.e.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                b bVar = b.this;
                bVar.f205963d.c0(bVar.f205965f);
            }
        }

        @Override // com.tencent.mobileqq.filebrowser.e.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, ae.e(b.this.f205964e.getFileType()) + "", "", "", "");
            b.this.f205963d.a();
            b.this.H.L(false);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filebrowser.presenter.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewOnClickListenerC7522b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        ViewOnClickListenerC7522b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0032, code lost:
        
            if (r0.f205963d.f0(r0.f205965f, r0.K) != false) goto L13;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (!TextUtils.isEmpty(b.this.f205963d.m())) {
                    b bVar = b.this;
                }
                ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, ae.e(b.this.f205964e.getFileType()) + "", "", "", "");
                b.this.f205963d.a();
                b.this.H.L(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
        } else {
            this.K = new a();
            b0(new SimpleFileBrowserView(activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.C();
        int O = this.f205963d.O();
        if (O != 6 && O != 2 && O != 4 && O != 5) {
            this.C = true;
            this.H.e(this.f205966h.getString(R.string.beg) + "(" + ao.a(this.f205964e.getFileSize()) + ")", new ViewOnClickListenerC7522b());
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("AppStoreApkFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
        }
        String g16 = this.f205963d.g();
        this.H.A(R.drawable.filelook_apk);
        if (!TextUtils.isEmpty(g16)) {
            this.H.D(g16);
        } else {
            this.H.z(this.f205964e.e());
        }
        if (!TextUtils.isEmpty(this.f205963d.p()) && 16 != this.f205964e.c()) {
            this.H.B(this.f205963d.p());
        } else {
            this.H.K(false);
        }
        if (!TextUtils.isEmpty(this.f205963d.p()) && 16 != this.f205964e.c()) {
            this.H.B(this.f205963d.p());
        } else {
            this.H.K(false);
        }
        if (this.f205964e.c() == 16) {
            this.H.J(this.f205966h.getString(R.string.b7d));
        } else if (this.f205963d.g0()) {
            this.H.J(this.f205966h.getString(R.string.b_t));
        }
        this.H.N(true ^ this.f205963d.V());
        String m3 = this.f205963d.m();
        if (!TextUtils.isEmpty(m3)) {
            this.H.E(m3);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    protected void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String H = this.f205963d.H(this.f205966h);
        if (H != null) {
            this.H.F(H, this);
            ReportController.o(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
            this.f205963d.c0(this.f205965f);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
