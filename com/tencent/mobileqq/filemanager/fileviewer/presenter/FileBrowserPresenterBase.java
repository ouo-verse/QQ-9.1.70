package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.a;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.ao;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tbstool.FileImporter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import com.tencent.util.pm.PackageUtil;
import java.io.File;

/* loaded from: classes12.dex */
public abstract class FileBrowserPresenterBase implements a.InterfaceC7579a {
    protected Bundle D;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.filemanager.fileviewer.viewer.a f208459d;

    /* renamed from: e, reason: collision with root package name */
    protected FileBrowserModelBase f208460e;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f208461f;

    /* renamed from: h, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.fileviewer.g f208462h;

    /* renamed from: i, reason: collision with root package name */
    protected com.tencent.mobileqq.filemanager.fileviewer.h f208463i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f208464m = false;
    protected boolean C = false;
    private boolean E = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FileBrowserPresenterBase.this.P();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int U = FileBrowserPresenterBase.this.f208460e.U();
            if (U != 2 && U != 3) {
                if (U == 1 && FileBrowserPresenterBase.this.f208460e.g0() != null) {
                    FileBrowserPresenterBase.this.f208460e.g0().e();
                }
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, QFileUtils.G(FileBrowserPresenterBase.this.f208460e.V()) + "", "", "", "");
                if (FileBrowserPresenterBase.this.f208460e.D() != null) {
                    FileBrowserPresenterBase.this.f208460e.D().a();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, QFileUtils.G(FileBrowserPresenterBase.this.f208460e.V()) + "", "", "", "");
            cc1.a D = FileBrowserPresenterBase.this.f208460e.D();
            if (D != null) {
                D.a();
            }
            if ("DaTongControllerButtonReport".equals(view.getTag())) {
                ao.c(FileBrowserPresenterBase.this.f208460e, view, ao.f209336a);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FileBrowserPresenterBase(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        this.f208460e = fileBrowserModelBase;
        this.f208461f = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        TbsToolEntrance.getInstance().openQQBrowser(this.f208461f, new File(this.f208460e.N()));
        ae.m("click_qb_app_store", String.valueOf(this.f208460e.V()), FileUtils.getExtension(this.f208460e.L()), str, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        FileManagerUtil.openWithOtherApp(this.f208461f, this.f208460e.N());
        this.f208464m = true;
        ae.m("click_qb_app_store", String.valueOf(this.f208460e.V()), FileUtils.getExtension(this.f208460e.L()), str, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        this.f208461f.finish();
        this.f208461f.overridePendingTransition(0, 0);
    }

    public String E() {
        return this.f208460e.L();
    }

    public com.tencent.mobileqq.filemanager.fileviewer.viewer.a F() {
        return this.f208459d;
    }

    public abstract boolean G();

    public abstract boolean H();

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        final String qqStr;
        String string;
        this.C = false;
        this.f208464m = false;
        int T = this.f208460e.T();
        if (T == 6) {
            this.f208461f.getString(R.string.iop);
            if (this.f208460e.U() == 1) {
                string = this.f208461f.getString(R.string.ioq);
            } else {
                this.C = true;
                string = this.f208461f.getString(R.string.iop);
            }
            this.f208459d.e(string + "(" + com.tencent.mobileqq.utils.ao.a(this.f208460e.Q()) + ")", new b());
            this.f208459d.o(false);
            this.f208459d.n(true);
            return;
        }
        if (T == 2) {
            boolean g16 = com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f208460e.L());
            if (g16) {
                if (PackageUtil.isPackageInstalled(BaseApplication.getContext(), TbsConfig.APP_QB)) {
                    qqStr = this.f208461f.getString(R.string.zz5);
                } else {
                    qqStr = this.f208461f.getString(R.string.zyz);
                }
                this.f208459d.d(qqStr, T, new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FileBrowserPresenterBase.this.L(qqStr, view);
                    }
                });
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.mht);
                this.f208459d.e(qqStr, new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FileBrowserPresenterBase.this.M(qqStr, view);
                    }
                });
            }
            ae.m("exp_qb_appstore", String.valueOf(this.f208460e.V()), FileUtils.getExtension(this.f208460e.L()), qqStr, g16);
            this.f208459d.n(true);
            return;
        }
        if (T == 4) {
            this.f208459d.o(true);
            J(this.f208460e.S());
            this.f208459d.n(false);
            return;
        }
        if (T == 5) {
            this.f208459d.n(false);
            return;
        }
        if (this.f208460e.O() == 9501 && NetworkUtil.isWifiConnected(this.f208461f)) {
            cc1.a D = this.f208460e.D();
            if (D != null) {
                D.a();
            }
        } else {
            this.C = true;
            this.f208459d.e(HardCodeUtil.qqStr(R.string.mhq) + com.tencent.mobileqq.utils.ao.a(this.f208460e.Q()) + ")", new c());
        }
        this.f208459d.o(false);
        this.f208459d.n(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(float f16) {
        int Q = (int) (((float) this.f208460e.Q()) * f16);
        int U = this.f208460e.U();
        if (U == 1) {
            this.f208459d.l(this.f208461f.getString(R.string.bfl) + "(" + q.g(Q) + "/" + q.g(this.f208460e.Q()) + ")");
        } else if (U == 4) {
            this.f208459d.l(this.f208461f.getString(R.string.f170979bf1) + "(" + q.g(Q) + "/" + q.g(this.f208460e.Q()) + ")");
        } else {
            this.f208459d.l(this.f208461f.getString(R.string.bej) + "(" + q.g(Q) + "/" + q.g(this.f208460e.Q()) + ")");
        }
        this.f208459d.m((int) (f16 * 100.0f));
    }

    public void K() {
        if (this.f208460e == null) {
            QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
            return;
        }
        com.tencent.mobileqq.filemanager.fileviewer.viewer.a aVar = this.f208459d;
        if (aVar == null) {
            QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
            return;
        }
        aVar.j(this.D);
        this.f208459d.f();
        I();
        this.f208459d.g(new a());
        if (this.f208460e.T() == 4) {
            this.f208459d.o(true);
            this.f208459d.n(false);
            J(this.f208460e.S());
        }
        this.f208459d.k(this);
        if (!this.f208460e.d() && this.E && this.C) {
            ReportController.o(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
        }
        this.E = false;
    }

    public void N(int i3, int i16, Intent intent) {
        FileImporter.f291396a.g(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
        int U = this.f208460e.U();
        if (U != 2 && U != 4) {
            if (U == 1 && this.f208460e.g0() != null) {
                this.f208460e.g0().f();
            }
        } else if (this.f208460e.D() != null) {
            this.f208460e.D().b();
        }
        this.f208459d.o(false);
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase.2
            @Override // java.lang.Runnable
            public void run() {
                FileBrowserPresenterBase.this.I();
            }
        }, 100L);
    }

    public void Q(Bundle bundle) {
        this.D = bundle;
    }

    public void R(com.tencent.mobileqq.filemanager.fileviewer.g gVar) {
        this.f208462h = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S(com.tencent.mobileqq.filemanager.fileviewer.viewer.a aVar) {
        this.f208459d = aVar;
    }

    public void T(com.tencent.mobileqq.filemanager.fileviewer.h hVar) {
        this.f208463i = hVar;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.a.InterfaceC7579a
    public void q() {
        D();
    }

    public void A() {
    }

    public void B() {
    }

    public void C() {
    }

    public void U() {
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public void z() {
    }

    public void O(Configuration configuration) {
    }
}
