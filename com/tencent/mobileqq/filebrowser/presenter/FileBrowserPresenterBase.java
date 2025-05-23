package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintApi;
import com.tencent.mobileqq.filemanager.fileviewer.api.IPrintForQQLiteApi;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ao;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import com.tencent.util.pm.PackageUtil;
import java.io.File;

/* loaded from: classes12.dex */
public abstract class FileBrowserPresenterBase {
    static IPatchRedirector $redirector_;
    protected boolean C;
    protected Bundle D;
    protected FileBrowserViewBase E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.mobileqq.filebrowser.e f205963d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.filebrowser.c f205964e;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f205965f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f205966h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.filebrowser.d f205967i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f205968m;

    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserPresenterBase.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                FileBrowserPresenterBase.this.M();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserPresenterBase.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int n3 = FileBrowserPresenterBase.this.f205963d.n();
                if (n3 != 2 && n3 != 3) {
                    if (n3 == 1) {
                        FileBrowserPresenterBase.this.f205963d.e();
                    }
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, ae.e(FileBrowserPresenterBase.this.f205964e.getFileType()) + "", "", "", "");
                    FileBrowserPresenterBase.this.f205963d.a();
                }
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserPresenterBase.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, ae.e(FileBrowserPresenterBase.this.f205964e.getFileType()) + "", "", "", "");
                FileBrowserPresenterBase.this.f205963d.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    class d implements qb1.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FileBrowserPresenterBase.this);
            }
        }

        @Override // qb1.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                FileBrowserPresenterBase.this.f205963d.a();
            }
        }
    }

    /* loaded from: classes12.dex */
    class e implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f205973d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g f205974e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ qb1.a f205975f;

        /* loaded from: classes12.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    e eVar = e.this;
                    com.tencent.mobileqq.filemanager.fileviewer.m.j(FileBrowserPresenterBase.this.f205965f, eVar.f205973d, eVar.f205975f);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        e(FileManagerEntity fileManagerEntity, com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g gVar, qb1.a aVar) {
            this.f205973d = fileManagerEntity;
            this.f205974e = gVar;
            this.f205975f = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, FileBrowserPresenterBase.this, fileManagerEntity, gVar, aVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ((IPrintForQQLiteApi) QRoute.api(IPrintForQQLiteApi.class)).showPrintDialog(FileBrowserPresenterBase.this.f205965f, this.f205973d, this.f205974e, new a(), false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FileBrowserPresenterBase(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.f205968m = false;
        this.C = false;
        this.F = true;
        this.f205963d = eVar;
        this.f205965f = activity;
        this.f205966h = BaseApplication.getContext();
        this.f205964e = eVar.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        TbsToolEntrance.getInstance().openQQBrowser(this.f205966h, new File(this.f205964e.getFilePath()));
        ae.m("click_qb_app_store", String.valueOf(this.f205964e.getFileType()), FileUtils.getExtension(this.f205964e.getFileName()), str, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f205963d.j(this.f205965f, this.f205964e.getFilePath());
        this.f205968m = true;
        ae.m("click_qb_app_store", String.valueOf(this.f205964e.getFileType()), FileUtils.getExtension(this.f205964e.getFileName()), str, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    public FileBrowserViewBase A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (FileBrowserViewBase) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.E;
    }

    public abstract boolean B();

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        final String string;
        String string2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        this.C = false;
        this.f205968m = false;
        int O = this.f205963d.O();
        QLog.d(AppConstants.NEW_MY_COMPUTER, 1, "handleActionButton transStatus " + O + "fileModel.getFileTransType() " + this.f205963d.n());
        if (O == 6) {
            if (this.f205963d.n() == 1) {
                string2 = this.f205966h.getString(R.string.ioq);
            } else {
                this.C = true;
                string2 = this.f205966h.getString(R.string.iop);
            }
            this.E.e(string2 + "(" + ao.a(this.f205964e.getFileSize()) + ")", new b());
            this.E.q(false);
            this.E.o(true);
            return;
        }
        if (O == 2) {
            boolean g16 = com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f205964e.getFileName());
            if (g16) {
                if (PackageUtil.isPackageInstalled(BaseApplication.getContext(), TbsConfig.APP_QB)) {
                    string = this.f205966h.getString(R.string.zz5);
                } else {
                    string = this.f205966h.getString(R.string.zyz);
                }
                this.E.d(string, O, new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.presenter.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FileBrowserPresenterBase.this.I(string, view);
                    }
                });
            } else {
                string = this.f205966h.getString(R.string.f1359602v);
                this.E.e(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.presenter.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FileBrowserPresenterBase.this.J(string, view);
                    }
                });
            }
            ae.m("exp_qb_appstore", String.valueOf(this.f205964e.getFileType()), FileUtils.getExtension(this.f205964e.getFileName()), string, g16);
            this.E.o(true);
            return;
        }
        if (O == 4) {
            this.E.q(true);
            G(this.f205963d.F());
            this.E.o(false);
            return;
        }
        if (O == 5) {
            this.E.o(false);
            return;
        }
        if (this.f205964e.b() == 9501 && NetworkUtil.isWifiConnected(this.f205966h)) {
            this.f205963d.a();
        } else {
            this.C = true;
            this.E.e(this.f205966h.getString(R.string.beg) + "(" + ao.a(this.f205964e.getFileSize()) + ")", new c());
        }
        this.E.q(false);
        this.E.o(true);
    }

    public void D(FileBrowserViewBase fileBrowserViewBase, boolean z16) {
        e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, fileBrowserViewBase, Boolean.valueOf(z16));
            return;
        }
        FileManagerEntity I = this.f205963d.I();
        if (I == null || ae.h(I) || I.cloudType == 0) {
            return;
        }
        if ((com.tencent.mobileqq.filemanager.util.q.f(this.f205964e.getFilePath()) && this.f205964e.getFileType() != 4) || ((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode()) {
            return;
        }
        IPrintApi iPrintApi = (IPrintApi) QRoute.api(IPrintApi.class);
        String str = I.fileName;
        if (I.TroopUin == 0) {
            z17 = false;
        }
        if (iPrintApi.isSupportPrint(str, false, z17)) {
            com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g gVar = (com.tencent.mobileqq.filemanager.fileviewer.onlineprint.g) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("online_file_print");
            if (gVar == null) {
                return;
            } else {
                eVar = new e(I, gVar, new d());
            }
        } else {
            eVar = null;
        }
        fileBrowserViewBase.f(eVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        FileManagerEntity I = this.f205963d.I();
        if (I != null && I.nSessionId == ((IPrintApi) QRoute.api(IPrintApi.class)).getSysPrintingSessionId()) {
            ((IPrintApi) QRoute.api(IPrintApi.class)).setSysPrintingSessionId(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        FileManagerEntity I = this.f205963d.I();
        if (I != null && I.nSessionId == ((IPrintApi) QRoute.api(IPrintApi.class)).getSysPrintingSessionId()) {
            ((IPrintApi) QRoute.api(IPrintApi.class)).jumpSysPrintPage(this.f205965f, I.strFilePath);
            ((IPrintApi) QRoute.api(IPrintApi.class)).setSysPrintingSessionId(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(float f16) {
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Float.valueOf(f16));
            return;
        }
        int n3 = this.f205963d.n();
        if (n3 == 1) {
            string = this.f205966h.getString(R.string.bfl);
        } else if (n3 == 4) {
            string = this.f205966h.getString(R.string.f170979bf1);
        } else {
            string = this.f205966h.getString(R.string.bej);
        }
        this.E.m(string + "(" + com.tencent.mobileqq.filemanager.util.q.g((int) (((float) this.f205964e.getFileSize()) * f16)) + "/" + com.tencent.mobileqq.filemanager.util.q.g(this.f205964e.getFileSize()) + ")");
        this.E.n((int) (f16 * 100.0f));
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f205963d == null) {
            QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
            return;
        }
        FileBrowserViewBase fileBrowserViewBase = this.E;
        if (fileBrowserViewBase == null) {
            QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
            return;
        }
        fileBrowserViewBase.l(this.D);
        this.E.g();
        C();
        this.E.i(new a());
        if (this.f205963d.O() == 4) {
            this.E.q(true);
            this.E.o(false);
            G(this.f205963d.F());
        }
        if (!this.f205963d.V() && this.F && this.C) {
            ReportController.o(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
        }
        this.F = false;
    }

    public void K(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            FileImporter.f291396a.g(i3, i16, intent);
        }
    }

    public void L(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) configuration);
        } else {
            this.E.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        int n3 = this.f205963d.n();
        if (n3 != 2 && n3 != 4) {
            if (n3 == 1) {
                this.f205963d.f();
            }
        } else {
            this.f205963d.b();
        }
        this.E.q(false);
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileBrowserPresenterBase.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FileBrowserPresenterBase.this.C();
                }
            }
        }, 100L);
    }

    public void N(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            this.D = bundle;
        }
    }

    public void O(com.tencent.mobileqq.filebrowser.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) dVar);
        } else {
            this.f205967i = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(FileBrowserViewBase fileBrowserViewBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) fileBrowserViewBase);
        } else {
            this.E = fileBrowserViewBase;
        }
    }

    public boolean q(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity)).booleanValue();
        }
        return com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).c(activity);
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    public String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.f205964e.getFileName();
    }
}
