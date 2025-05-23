package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

/* loaded from: classes12.dex */
public class DocExportFilePresenter extends FileBrowserPresenterBase implements e.f {
    static IPatchRedirector $redirector_;
    private SpannableString G;
    protected boolean H;
    protected DocFileBrowserView I;
    private boolean J;
    private LocalTbsViewManager.e K;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements ah.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocExportFilePresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.f
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                DocExportFilePresenter docExportFilePresenter = DocExportFilePresenter.this;
                ah.r1(docExportFilePresenter.f205965f, docExportFilePresenter.f205964e.getFilePath());
            }
        }
    }

    public DocExportFilePresenter(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.H = true;
        this.J = false;
        this.K = new LocalTbsViewManager.e() { // from class: com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DocExportFilePresenter.this);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void a(String str, Drawable drawable, Drawable drawable2, View.OnClickListener onClickListener) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, str, drawable, drawable2, onClickListener);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void b(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 8)) {
                    iPatchRedirector2.redirect((short) 8, (Object) this, z16);
                    return;
                }
                com.tencent.mobileqq.filebrowser.d dVar = DocExportFilePresenter.this.f205967i;
                if (dVar != null) {
                    dVar.b(z16);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void c(boolean z16) {
                com.tencent.mobileqq.filebrowser.d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, z16);
                    return;
                }
                if (ImmersiveUtils.isSupporImmersive() == 1 && (dVar = DocExportFilePresenter.this.f205967i) != null) {
                    dVar.D();
                }
                if (z16) {
                    com.tencent.mobileqq.tbstool.gray.b.f291450a.e(DocExportFilePresenter.this.f205964e.getFileName()).a(false);
                    DocExportFilePresenter docExportFilePresenter = DocExportFilePresenter.this;
                    docExportFilePresenter.I.j0(docExportFilePresenter.f205964e.getFilePath(), DocExportFilePresenter.this.f205964e.getSessionId(), this);
                    DocExportFilePresenter docExportFilePresenter2 = DocExportFilePresenter.this;
                    docExportFilePresenter2.H = false;
                    QQToast.makeText(docExportFilePresenter2.f205966h, 2, R.string.iok, 1).show();
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.mobileqq.filebrowser.d dVar2 = DocExportFilePresenter.this.f205967i;
                            if (dVar2 != null) {
                                dVar2.S();
                                ReportController.o(null, "dc00898", "", "", "0X800A3B7", "0X800A3B7", 0, 0, "", "", "", "");
                            }
                        }
                    }, 800L);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void d(View view) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 9)) {
                    iPatchRedirector2.redirect((short) 9, (Object) this, (Object) view);
                    return;
                }
                com.tencent.mobileqq.filebrowser.d dVar = DocExportFilePresenter.this.f205967i;
                if (dVar != null) {
                    dVar.d(view);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public View e() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    return (View) iPatchRedirector2.redirect((short) 6, (Object) this);
                }
                return null;
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void f() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 7)) {
                    iPatchRedirector2.redirect((short) 7, (Object) this);
                    return;
                }
                com.tencent.mobileqq.filebrowser.d dVar = DocExportFilePresenter.this.f205967i;
                if (dVar != null) {
                    dVar.S();
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void g(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 3)) {
                    DocExportFilePresenter.this.J = z16;
                    com.tencent.mobileqq.filebrowser.d dVar = DocExportFilePresenter.this.f205967i;
                    if (dVar != null) {
                        dVar.g(z16);
                    }
                    if (z16 && DocExportFilePresenter.this.I.e0()) {
                        DocExportFilePresenter.this.I.b0();
                        return;
                    } else {
                        if (!z16 && DocExportFilePresenter.this.I.a0() != null) {
                            DocExportFilePresenter docExportFilePresenter = DocExportFilePresenter.this;
                            docExportFilePresenter.I.o0(docExportFilePresenter.f205963d.K());
                            return;
                        }
                        return;
                    }
                }
                iPatchRedirector2.redirect((short) 3, (Object) this, z16);
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public boolean h() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 5)) {
                    return DocExportFilePresenter.this.J;
                }
                return ((Boolean) iPatchRedirector2.redirect((short) 5, (Object) this)).booleanValue();
            }
        };
        DocFileBrowserView docFileBrowserView = new DocFileBrowserView(this.f205965f, this.f205964e.getFileName());
        this.I = docFileBrowserView;
        P(docFileBrowserView);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void G(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        DocFileBrowserView docFileBrowserView = this.I;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(U(R.string.zyg));
        int i3 = (int) f16;
        sb5.append(i3);
        sb5.append("%");
        docFileBrowserView.m(sb5.toString());
        this.I.n(i3);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
        }
        this.I.E(this.f205964e.getFileName());
        if (com.tencent.mobileqq.filemanager.util.q.f(this.f205964e.getFilePath())) {
            W();
        } else {
            V();
        }
        this.f205963d.P(this);
        X();
        D(this.I, false);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void L(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) configuration);
            return;
        }
        super.L(configuration);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f205965f.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.I.i0(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    View S() {
        View c16 = this.I.c();
        if (c16 != null && c16.getParent() != null && c16.getParent().getParent() != null) {
            return ((ViewGroup) c16.getParent().getParent()).findViewById(R.id.ima);
        }
        return null;
    }

    boolean T(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("docs_export_file_is_first_" + str, true);
    }

    String U(int i3) {
        return BaseApplication.getContext().getString(i3);
    }

    protected void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.f205964e.getFileName() + "]");
        }
        int fileType = this.f205964e.getFileType();
        if (fileType == 5) {
            this.I.A(R.drawable.e98);
            this.I.z(this.f205964e.e());
        } else {
            this.I.C(ah.f0(this.f205964e.getFileName()));
        }
        if (!TextUtils.isEmpty(this.f205963d.p()) && 16 != this.f205964e.c()) {
            this.I.B(this.f205963d.p());
        } else {
            this.I.K(false);
        }
        if (fileType == 1) {
            this.I.J(U(R.string.be9));
        } else {
            this.I.J(U(R.string.be_));
        }
        if (this.f205964e.c() == 16) {
            this.I.J(U(R.string.b7d));
            return;
        }
        if (this.f205963d.g0()) {
            this.I.J(U(R.string.b_t));
            return;
        }
        if (this.f205963d.e0()) {
            this.I.J(U(R.string.b7d));
        } else if (this.f205963d.V()) {
            this.f205963d.a();
            this.I.q(true);
            this.I.o(false);
            G(0.0f);
        }
    }

    protected void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.f205964e.getFileName() + "] filePath[" + this.f205964e.getFilePath() + "]");
        }
        a0();
        if (this.f205963d.O() == 2) {
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).i(this.f205965f, this.f205964e.getFilePath(), this.K, true);
            FilePreviewDataReporter.f209177a.f(this.f205964e.getFileName(), this.f205964e.getFileType(), this.f205964e.getFileSize());
        }
        this.I.C(ah.f0(this.f205964e.getFileName()));
        this.I.B(this.f205963d.Q());
        U(R.string.b7d);
        if (this.f205964e.c() == 16) {
            this.I.J(U(R.string.b7d));
            this.I.N(true);
            return;
        }
        if (Y(this.f205964e.getFileName())) {
            SpannableString Y = ah.Y(U(R.string.bes), U(R.string.cp7), new a());
            this.G = Y;
            this.I.I(Y);
        } else {
            this.I.J(U(R.string.ber));
        }
        this.I.N(true);
    }

    void X() {
        View c16 = this.I.c();
        if (c16 != null) {
            View findViewById = c16.findViewById(R.id.jv7);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = c16.findViewById(R.id.c_m);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewById3 = c16.findViewById(R.id.c_c);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
        }
    }

    boolean Y(String str) {
        return QbSdk.isSuportOpenFile(ah.n0(str), 2);
    }

    void Z(Context context, String str, boolean z16) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("docs_export_file_is_first_" + str, z16);
        edit.apply();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            G(f16);
        }
    }

    void a0() {
        View S;
        if (!T(this.f205966h, this.f205963d.getCurrentAccountUin()) || (S = S()) == null) {
            return;
        }
        S.setVisibility(0);
        Z(this.f205966h, this.f205963d.getCurrentAccountUin(), false);
        new MqqHandler().postDelayed(new Runnable(S) { // from class: com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f205951d;

            {
                this.f205951d = S;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocExportFilePresenter.this, (Object) S);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f205951d.setVisibility(8);
                }
            }
        }, 5000L);
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.I.q(false);
            C();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        this.I.o(true);
        this.I.q(false);
        C();
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.A();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.I.o(false);
        this.I.q(true);
        G(this.f205963d.F());
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.I.o(true);
        this.I.q(false);
        C();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        DocFileBrowserView docFileBrowserView = this.I;
        if (docFileBrowserView != null) {
            docFileBrowserView.c0();
        }
        super.t();
    }
}
