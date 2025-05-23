package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.view.SimpleFileBrowserView;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.QbSdk;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class SimpleFilePresenter extends FileBrowserPresenterBase implements e.f {
    static IPatchRedirector $redirector_;
    private final Handler G;
    protected SimpleFileBrowserView H;
    private Runnable I;
    private boolean J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205988d;

        a(String str) {
            this.f205988d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleFilePresenter.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IVasH5PayUtil) QRoute.api(IVasH5PayUtil.class)).openH5Page(this.f205988d, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), SimpleFilePresenter.this.f205965f);
                KingCardProcessor.get().download.reportClickEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SimpleFilePresenter(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.I = null;
        this.J = false;
        this.G = new Handler();
    }

    private void Z() {
        this.I = new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SimpleFilePresenter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String L = SimpleFilePresenter.this.f205963d.L();
                if (!TextUtils.isEmpty(L) && !SimpleFilePresenter.this.J) {
                    SimpleFilePresenter.this.H.p(true);
                    SimpleFilePresenter.this.H.k(L);
                    SimpleFilePresenter.this.G.postDelayed(SimpleFilePresenter.this.I, 1000L);
                    return;
                }
                SimpleFilePresenter.this.H.p(false);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f205963d.j(this.f205965f, this.f205964e.getFilePath());
        ae.m("click_qb_app_store", String.valueOf(this.f205964e.getFileType()), FileUtils.getExtension(this.f205964e.getFileName()), str, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void c0() {
        Runnable runnable = this.I;
        if (runnable != null) {
            this.G.removeCallbacks(runnable);
            this.I = null;
        }
        SimpleFileBrowserView simpleFileBrowserView = this.H;
        if (simpleFileBrowserView != null) {
            simpleFileBrowserView.p(false);
        }
        this.J = true;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
        }
        this.H.L(false);
        this.H.N(false);
        this.H.E(this.f205964e.getFileName());
        this.H.j();
        if (com.tencent.mobileqq.filemanager.util.q.f(this.f205964e.getFilePath())) {
            X();
        } else {
            U();
        }
        this.f205963d.P(this);
        W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            super.M();
            Y();
        }
    }

    protected void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.f205964e.getFileName() + "]");
        }
        if (this.f205964e.getFileType() == 5) {
            this.H.A(R.drawable.e98);
            this.H.z(this.f205964e.e());
        } else {
            this.H.C(ah.f0(this.f205964e.getFileName()));
        }
        if (!TextUtils.isEmpty(this.f205963d.p()) && 16 != this.f205964e.c()) {
            this.H.B(this.f205963d.p());
        } else {
            this.H.K(false);
        }
        if (this.f205964e.c() == 16) {
            this.H.J(BaseApplication.getContext().getString(R.string.b7d));
            this.H.N(true);
            return;
        }
        if (this.f205963d.g0()) {
            this.H.J(BaseApplication.getContext().getString(R.string.b_t));
            return;
        }
        if (this.f205963d.e0()) {
            this.H.J(BaseApplication.getContext().getString(R.string.b7d));
            return;
        }
        if (this.f205963d.V()) {
            this.f205963d.a();
            this.H.q(true);
            this.H.o(false);
            G(0.0f);
            return;
        }
        V();
    }

    protected void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    void W() {
        if (FileUtils.fileExistsAndNotEmpty(this.f205964e.getFilePath())) {
            this.H.M(false);
            D(this.H, false);
            return;
        }
        String firstActionUrl = KingCardProcessor.get().download.getFirstActionUrl();
        IKingCardManager kingCardManager = ((IVasService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "")).getKingCardManager();
        if (NetworkUtil.isNetworkAvailable(this.f205966h) && !NetworkUtil.isWifiConnected(this.f205966h) && KingCardProcessor.get().download.enable && !kingCardManager.isKingCard() && !TextUtils.isEmpty(firstActionUrl)) {
            this.H.w(new a(firstActionUrl));
            this.H.M(true);
            D(this.H, true);
            return;
        }
        D(this.H, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.f205964e.getFileName() + "] filePath[" + this.f205964e.getFilePath() + "] status[" + this.f205964e.c() + "]");
        }
        this.H.C(ah.f0(this.f205964e.getFileName()));
        this.H.B(this.f205963d.Q());
        if (this.f205964e.c() == 16) {
            this.H.J(BaseApplication.getContext().getString(R.string.b7d));
            this.H.N(true);
        }
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205964e.getFileName())) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "handleSecondActionButton new view not show it!");
        } else if (FileUtils.fileExistsAndNotEmpty(this.f205964e.getFilePath()) && QbSdk.isSuportOpenFile(ah.n0(this.f205964e.getFileName()), 2)) {
            final String string = this.f205966h.getString(R.string.cp7);
            this.H.F(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.presenter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimpleFilePresenter.this.a0(string, view);
                }
            });
            ae.m("exp_qb_appstore", String.valueOf(this.f205964e.getFileType()), FileUtils.getExtension(this.f205964e.getFileName()), string, false);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        G(f16);
        String L = this.f205963d.L();
        if (TextUtils.isEmpty(L)) {
            return;
        }
        this.H.p(true);
        this.H.k(L);
        if (this.I == null) {
            Z();
            this.G.post(this.I);
            this.J = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0(SimpleFileBrowserView simpleFileBrowserView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) simpleFileBrowserView);
        } else {
            super.P(simpleFileBrowserView);
            this.H = simpleFileBrowserView;
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.H.q(false);
        C();
        Y();
        c0();
        E();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.H.o(true);
        this.H.q(false);
        C();
        Y();
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.A();
        }
        c0();
        F();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.H.o(false);
        this.H.q(true);
        G(this.f205963d.F());
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.H.o(true);
        this.H.q(false);
        C();
        Y();
        c0();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            c0();
            super.t();
        }
    }
}
