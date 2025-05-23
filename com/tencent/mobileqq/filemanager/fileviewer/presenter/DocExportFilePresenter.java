package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

/* loaded from: classes12.dex */
public class DocExportFilePresenter extends FileBrowserPresenterBase implements FileBrowserModelBase.f {
    private SpannableString F;
    protected boolean G;
    protected SimpleFileViewer H;
    private LocalTbsViewManager.e I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements ah.f {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.f
        public void onClick(View view) {
            DocExportFilePresenter docExportFilePresenter = DocExportFilePresenter.this;
            FileManagerUtil.openWithOtherApp(docExportFilePresenter.f208461f, docExportFilePresenter.f208460e.N());
        }
    }

    public DocExportFilePresenter(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.G = true;
        this.I = new LocalTbsViewManager.e() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3
            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void b(boolean z16) {
                com.tencent.mobileqq.filemanager.fileviewer.g gVar = DocExportFilePresenter.this.f208462h;
                if (gVar != null) {
                    gVar.b(z16);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void c(boolean z16) {
                com.tencent.mobileqq.filemanager.fileviewer.h hVar;
                if (ImmersiveUtils.isSupporImmersive() == 1 && (hVar = DocExportFilePresenter.this.f208463i) != null) {
                    hVar.D();
                }
                if (z16) {
                    com.tencent.mobileqq.tbstool.gray.b.f291450a.e(DocExportFilePresenter.this.f208460e.L()).a(false);
                    DocExportFilePresenter docExportFilePresenter = DocExportFilePresenter.this;
                    docExportFilePresenter.H.a0(docExportFilePresenter.f208460e.N(), DocExportFilePresenter.this.f208460e.P(), this);
                    DocExportFilePresenter docExportFilePresenter2 = DocExportFilePresenter.this;
                    docExportFilePresenter2.G = false;
                    QQToast.makeText(docExportFilePresenter2.f208461f, 2, R.string.iok, 1).show();
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.tencent.mobileqq.filemanager.fileviewer.g gVar = DocExportFilePresenter.this.f208462h;
                            if (gVar != null) {
                                gVar.R1();
                                ReportController.o(null, "dc00898", "", "", "0X800A3B7", "0X800A3B7", 0, 0, "", "", "", "");
                            }
                        }
                    }, 800L);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void d(View view) {
                com.tencent.mobileqq.filemanager.fileviewer.g gVar = DocExportFilePresenter.this.f208462h;
                if (gVar != null) {
                    gVar.d(view);
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public View e() {
                return null;
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void f() {
                com.tencent.mobileqq.filemanager.fileviewer.g gVar = DocExportFilePresenter.this.f208462h;
                if (gVar != null) {
                    gVar.R1();
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void g(boolean z16) {
                com.tencent.mobileqq.filemanager.fileviewer.h hVar = DocExportFilePresenter.this.f208463i;
                if (hVar != null) {
                    hVar.g(z16);
                }
                if (DocExportFilePresenter.this.H.P() && z16) {
                    DocExportFilePresenter.this.H.K();
                } else if (DocExportFilePresenter.this.H.J() != null && !z16) {
                    DocExportFilePresenter docExportFilePresenter = DocExportFilePresenter.this;
                    docExportFilePresenter.H.l0(docExportFilePresenter.f208460e.c0());
                }
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public boolean h() {
                com.tencent.mobileqq.filemanager.fileviewer.g gVar = DocExportFilePresenter.this.f208462h;
                if (gVar != null) {
                    return gVar.isFullScreen();
                }
                return false;
            }

            @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
            public void a(String str, Drawable drawable, Drawable drawable2, View.OnClickListener onClickListener) {
            }
        };
        SimpleFileViewer simpleFileViewer = new SimpleFileViewer(this.f208461f, fileBrowserModelBase.L());
        this.H = simpleFileViewer;
        S(simpleFileViewer);
    }

    private String V() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            return ((QQAppInterface) runtime).getCurrentUin();
        }
        return runtime.getAccount();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean G() {
        if (this.G) {
            this.f208461f.setRequestedOrientation(1);
        }
        return !this.G;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean H() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void J(float f16) {
        SimpleFileViewer simpleFileViewer = this.H;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(HardCodeUtil.qqStr(R.string.f171892lp3));
        int i3 = (int) f16;
        sb5.append(i3);
        sb5.append("%");
        simpleFileViewer.l(sb5.toString());
        this.H.m(i3);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
        }
        this.H.Y(this.f208460e.L());
        if (FileManagerUtil.isLocalFile(this.f208460e.N())) {
            X();
        } else {
            W();
        }
        this.f208460e.O0(this);
        View a16 = this.H.a();
        if (a16 != null) {
            View findViewById = a16.findViewById(R.id.jv7);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = a16.findViewById(R.id.c_m);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewById3 = a16.findViewById(R.id.c_c);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void O(Configuration configuration) {
        super.O(configuration);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f208461f.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.H.S(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    protected void W() {
        if (QLog.isColorLevel()) {
            QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.f208460e.L() + "]");
        }
        int V = this.f208460e.V();
        if (V == 5) {
            this.H.U(R.drawable.e98);
            this.H.T(this.f208460e.s());
        } else {
            this.H.W(FileManagerUtil.getFileIconResId(this.f208460e.L()));
        }
        if (!TextUtils.isEmpty(this.f208460e.J()) && 16 != this.f208460e.R()) {
            this.H.V(this.f208460e.J());
        } else {
            this.H.h0(false);
        }
        if (V == 1) {
            this.H.f0(BaseApplication.getContext().getString(R.string.be9));
        } else if (V == 2) {
            this.H.f0(BaseApplication.getContext().getString(R.string.bec));
        } else {
            this.H.f0(BaseApplication.getContext().getString(R.string.be_));
        }
        if (this.f208460e.R() == 16) {
            this.H.f0(BaseApplication.getContext().getString(R.string.b7d));
            return;
        }
        if (this.f208460e.q0()) {
            this.H.f0(BaseApplication.getContext().getString(R.string.b_t));
            return;
        }
        if (this.f208460e.p()) {
            this.H.f0(BaseApplication.getContext().getString(R.string.b7d));
            return;
        }
        if (this.f208460e.d() && this.f208460e.D() != null) {
            this.f208460e.D().a();
            this.H.o(true);
            this.H.n(false);
            J(0.0f);
        }
    }

    protected void X() {
        final View findViewById;
        if (QLog.isColorLevel()) {
            QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.f208460e.L() + "] filePath[" + this.f208460e.N() + "]");
        }
        View a16 = this.H.a();
        if (a16 != null && a16.getParent() != null && a16.getParent().getParent() != null && ea.p0(this.f208461f, V()) && a16.getParent() != null && a16.getParent().getParent() != null && (findViewById = ((ViewGroup) a16.getParent().getParent()).findViewById(R.id.ima)) != null) {
            findViewById.setVisibility(0);
            ea.T2(this.f208461f, V(), false);
            new MqqHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    findViewById.setVisibility(8);
                }
            }, 5000L);
        }
        if (this.f208460e.T() == 2) {
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).i(this.f208461f, this.f208460e.N(), this.I, true);
            FilePreviewDataReporter.f209177a.f(this.f208460e.L(), this.f208460e.V(), this.f208460e.Q());
        }
        this.H.W(FileManagerUtil.getFileIconResId(this.f208460e.L()));
        this.H.V(this.f208460e.I());
        this.f208461f.getString(R.string.b7d);
        if (this.f208460e.R() == 16) {
            this.H.f0(BaseApplication.getContext().getString(R.string.b7d));
            this.H.m0(true);
            return;
        }
        if (QbSdk.isSuportOpenFile(FileManagerUtil.getFileSuffix(this.f208460e.L()), 2)) {
            SpannableString clickableTips = FileManagerUtil.getClickableTips(BaseApplication.getContext().getString(R.string.bes), BaseApplication.getContext().getString(R.string.cp7), new a());
            this.F = clickableTips;
            this.H.e0(clickableTips);
        } else {
            this.H.f0(BaseApplication.getContext().getString(R.string.ber));
        }
        this.H.m0(true);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void a(float f16) {
        J(f16);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        this.H.o(false);
        I();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        this.H.n(true);
        this.H.o(false);
        I();
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.h2();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void j() {
        this.H.n(false);
        this.H.o(true);
        J(this.f208460e.S());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void l() {
        this.H.n(true);
        this.H.o(false);
        I();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void x() {
        SimpleFileViewer simpleFileViewer = this.H;
        if (simpleFileViewer != null) {
            simpleFileViewer.L();
        }
        super.x();
    }
}
