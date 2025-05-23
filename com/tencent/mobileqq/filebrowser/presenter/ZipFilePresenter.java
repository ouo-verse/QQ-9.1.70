package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filebrowser.e;
import com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ao;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes12.dex */
public class ZipFilePresenter extends FileBrowserPresenterBase implements e.g, e.f, e.InterfaceC7518e {
    static IPatchRedirector $redirector_;
    protected com.tencent.mobileqq.filebrowser.view.i G;
    private List<e.h> H;
    private boolean I;
    private boolean J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZipFilePresenter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ZipFilePresenter zipFilePresenter = ZipFilePresenter.this;
                zipFilePresenter.f205963d.j(zipFilePresenter.f205965f, zipFilePresenter.f205964e.getFilePath());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZipFilePresenter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ZipFilePresenter zipFilePresenter = ZipFilePresenter.this;
                zipFilePresenter.f205963d.j(zipFilePresenter.f205965f, zipFilePresenter.f205964e.getFilePath());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZipFilePresenter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ZipFilePresenter.this.J = true;
                ZipFilePresenter.this.G.F(true);
                ZipFilePresenter.this.G.B(false);
                ZipFilePresenter.this.W();
                ZipFilePresenter.this.f205963d.T();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZipFilePresenter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ZipFilePresenter.this.f205963d.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZipFilePresenter.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ZipFilePresenter.this.f205963d.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ZipFilePresenter(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.I = false;
        this.J = false;
        this.H = new ArrayList();
        com.tencent.mobileqq.filebrowser.view.i iVar = new com.tencent.mobileqq.filebrowser.view.i(activity);
        this.G = iVar;
        P(iVar);
    }

    private void U() {
        int O = this.f205963d.O();
        if (O == 4) {
            this.G.q(true);
            this.G.C(false);
            return;
        }
        if (O == 2) {
            this.G.C(false);
            return;
        }
        if (O == 6) {
            this.G.r(true, this.f205966h.getString(R.string.iop) + "(" + ao.a(this.f205964e.getFileSize()) + ")", new d());
            return;
        }
        this.G.r(true, this.f205966h.getString(R.string.beg) + "(" + ao.a(this.f205964e.getFileSize()) + ")", new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZipFilePresenter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else if (ZipFilePresenter.this.J) {
                    ZipFilePresenter.this.c(-1000L);
                }
            }
        }, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(long j3) {
        this.G.F(false);
        this.G.B(true);
        V();
        if (com.tencent.mobileqq.filemanager.util.q.f(this.f205964e.getFilePath())) {
            this.G.e(this.f205966h.getString(R.string.f1359602v), new a());
            this.G.o(true);
        } else if (j3 != -1000) {
            if (j3 != -7003 && j3 != -6101) {
                this.G.D(false);
            } else {
                this.G.v(this.f205966h.getString(R.string.b7d));
                this.G.D(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void D(FileBrowserViewBase fileBrowserViewBase, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fileBrowserViewBase, Boolean.valueOf(z16));
            return;
        }
        List<e.h> list = this.H;
        if (list != null && !list.isEmpty()) {
            return;
        }
        super.D(fileBrowserViewBase, z16);
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
            QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
        }
        this.G.w(ThemeUtil.isNowThemeIsNight(null, false, null));
        this.G.A(this.f205964e.getFileName());
        this.G.y(this.f205963d.Q());
        this.G.t(this.f205966h.getString(R.string.zzv) + this.H.size() + this.f205966h.getString(R.string.zzu) + com.tencent.mobileqq.filemanager.util.q.g(this.f205964e.getFileSize()));
        this.f205963d.C(this);
        this.f205963d.P(this);
        if (!NetworkUtil.isNetworkAvailable(this.f205966h)) {
            X(-1000L);
        } else if (!this.I) {
            this.f205963d.T();
            this.I = true;
            this.G.F(true);
            this.J = true;
            W();
        }
        if (!com.tencent.mobileqq.filemanager.util.q.f(this.f205964e.getFilePath()) && this.f205963d.V()) {
            G(this.f205963d.F());
            this.G.q(true);
            this.G.C(false);
            this.G.o(false);
            this.f205963d.a();
        }
        this.f205963d.Y(this);
        D(this.G, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        int n3 = this.f205963d.n();
        if (n3 != 2 && n3 != 3) {
            if (n3 == 1) {
                this.f205963d.f();
            } else if (QLog.isColorLevel()) {
                QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
            }
        } else {
            this.f205963d.b();
        }
        this.G.q(false);
        U();
        C();
        V();
    }

    protected void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(this.f205964e.getFilePath())) {
            if (QbSdk.isSuportOpenFile(ah.n0(this.f205964e.getFileName()), 2)) {
                this.G.u(this.f205966h.getString(R.string.cp7), new b());
            }
        } else {
            this.G.u(this.f205966h.getString(R.string.beu), new c());
        }
        if (this.f205963d.O() == 4) {
            this.G.D(false);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        this.G.C(false);
        this.G.q(true);
        G(f16);
    }

    @Override // com.tencent.mobileqq.filebrowser.e.g
    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable(j3) { // from class: com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f205995d;

                {
                    this.f205995d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ZipFilePresenter.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ZipFilePresenter.this.J = false;
                        ZipFilePresenter.this.X(this.f205995d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        M();
        C();
        V();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        this.G.C(false);
        this.G.q(false);
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.A();
        }
        C();
        V();
    }

    @Override // com.tencent.mobileqq.filebrowser.e.g
    public void g(List<e.h> list, String str, String str2, String str3, String str4, boolean z16, String str5, short s16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, str, str2, str3, str4, Boolean.valueOf(z16), str5, Short.valueOf(s16));
            return;
        }
        if (!this.J) {
            return;
        }
        this.f205963d.s();
        if (list != null && list.size() > 0) {
            this.H = list;
            this.G.x(this.f205963d.s());
            this.G.t(this.f205966h.getString(R.string.zzv) + this.H.size() + this.f205966h.getString(R.string.zzu) + com.tencent.mobileqq.filemanager.util.q.g(this.f205964e.getFileSize()));
            U();
            this.G.j();
            com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
            if (dVar != null) {
                dVar.C0();
            }
        } else {
            QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
            X(-1000L);
        }
        this.J = false;
    }

    @Override // com.tencent.mobileqq.filebrowser.e.g
    public void i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        } else {
            this.G.z(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.G.C(false);
        this.G.o(false);
        this.G.q(true);
        G(this.f205963d.F());
    }

    @Override // com.tencent.mobileqq.filebrowser.e.InterfaceC7518e
    public void k(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        } else {
            this.G.s(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.e.f
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.G.C(true);
        this.G.q(false);
        U();
        C();
        V();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.u();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (this.I) {
            this.G.s("", "");
        }
    }
}
