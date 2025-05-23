package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
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
public class ZipFilePresenter extends FileBrowserPresenterBase implements FileBrowserModelBase.g, FileBrowserModelBase.f, FileBrowserModelBase.e {
    private List<f> F;
    private boolean G;
    protected com.tencent.mobileqq.filemanager.fileviewer.viewer.j H;
    private boolean I;
    private boolean J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ZipFilePresenter zipFilePresenter = ZipFilePresenter.this;
            FileManagerUtil.openWithOtherApp(zipFilePresenter.f208461f, zipFilePresenter.f208460e.N());
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
            ZipFilePresenter zipFilePresenter = ZipFilePresenter.this;
            FileManagerUtil.openWithOtherApp(zipFilePresenter.f208461f, zipFilePresenter.f208460e.N());
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
            ZipFilePresenter.this.J = true;
            ZipFilePresenter.this.H.E(true);
            ZipFilePresenter.this.H.A(false);
            ZipFilePresenter.this.b0();
            ZipFilePresenter.this.f208460e.v0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ZipFilePresenter.this.f208460e.D() != null) {
                ZipFilePresenter.this.f208460e.D().a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ZipFilePresenter.this.f208460e.D() != null) {
                ZipFilePresenter.this.f208460e.D().a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes12.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public boolean f208516a;

        /* renamed from: b, reason: collision with root package name */
        public long f208517b;

        /* renamed from: c, reason: collision with root package name */
        public String f208518c;

        /* renamed from: d, reason: collision with root package name */
        public long f208519d;
    }

    public ZipFilePresenter(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.I = false;
        this.J = false;
        this.F = new ArrayList();
        com.tencent.mobileqq.filemanager.fileviewer.viewer.j jVar = new com.tencent.mobileqq.filemanager.fileviewer.viewer.j(activity);
        this.H = jVar;
        S(jVar);
    }

    private void Z() {
        int T = this.f208460e.T();
        if (T == 4) {
            this.H.o(true);
            this.H.B(false);
            return;
        }
        if (T == 2) {
            this.H.B(false);
            return;
        }
        if (T == 6) {
            this.H.q(true, HardCodeUtil.qqStr(R.string.f172938vo3) + "(" + ao.a(this.f208460e.Q()) + ")", new d());
            return;
        }
        this.H.q(true, HardCodeUtil.qqStr(R.string.f172935vo0) + "(" + ao.a(this.f208460e.Q()) + ")", new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                if (ZipFilePresenter.this.J) {
                    ZipFilePresenter.this.c(-1000L);
                }
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(long j3) {
        this.H.E(false);
        this.H.A(true);
        a0();
        if (q.f(this.f208460e.N())) {
            this.H.e(HardCodeUtil.qqStr(R.string.bey), new a());
            this.H.n(true);
        } else if (j3 != -1000) {
            if (j3 != -7003 && j3 != -6101) {
                this.H.C(false);
                return;
            }
            this.f208460e.L0(16);
            this.H.v(this.f208461f.getString(R.string.b7d));
            this.H.C(false);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean G() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean H() {
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
        }
        boolean equals = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        this.G = equals;
        this.H.w(equals);
        this.H.z(this.f208460e.L());
        this.H.x(this.f208460e.I());
        this.H.t(HardCodeUtil.qqStr(R.string.vnz) + this.F.size() + HardCodeUtil.qqStr(R.string.f172939vo4) + q.g(this.f208460e.Q()));
        this.f208460e.P0(this);
        this.f208460e.O0(this);
        if (!NetworkUtil.isNetworkAvailable(this.f208461f)) {
            c0(-1000L);
        } else if (!this.I) {
            this.f208460e.v0();
            this.I = true;
            this.H.E(true);
            this.J = true;
            b0();
        }
        if (!q.f(this.f208460e.N()) && this.f208460e.d() && this.f208460e.D() != null) {
            J(this.f208460e.S());
            this.H.o(true);
            this.H.B(false);
            this.H.n(false);
            this.f208460e.D().a();
        }
        this.f208460e.N0(this);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    protected void P() {
        int U = this.f208460e.U();
        if (U != 2 && U != 3) {
            if (U == 1) {
                if (this.f208460e.g0() != null) {
                    this.f208460e.g0().f();
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
            }
        } else if (this.f208460e.D() != null) {
            this.f208460e.D().b();
        }
        this.H.o(false);
        Z();
        I();
        a0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void a(float f16) {
        this.H.B(false);
        this.H.o(true);
        J(f16);
    }

    protected void a0() {
        if (FileUtils.fileExistsAndNotEmpty(this.f208460e.N())) {
            if (QbSdk.isSuportOpenFile(FileManagerUtil.getFileSuffix(this.f208460e.L()), 2)) {
                this.H.u(this.f208461f.getString(R.string.cp7), new b());
            }
        } else {
            this.H.u(this.f208461f.getString(R.string.beu), new c());
        }
        if (this.f208460e.T() == 4) {
            this.H.C(false);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.g
    public void c(final long j3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                ZipFilePresenter.this.J = false;
                ZipFilePresenter.this.c0(j3);
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        P();
        I();
        a0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        this.H.p();
        this.H.o(false);
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.h2();
        }
        I();
        a0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.g
    public void g(List<f> list, String str, String str2, String str3, String str4, boolean z16, String str5, short s16) {
        if (!this.J) {
            return;
        }
        if (list != null && list.size() > 0) {
            this.F = list;
            this.H.r(list, this.f208460e.N(), this.f208460e.P(), this.f208460e.f0(), str2, str3, str4, str, z16, str5, s16);
            this.H.t(HardCodeUtil.qqStr(R.string.f172936vo1) + this.F.size() + HardCodeUtil.qqStr(R.string.f172937vo2) + q.g(this.f208460e.Q()));
            Z();
        } else {
            QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
            c0(-1000L);
        }
        this.J = false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.g
    public void i(String str, String str2) {
        this.H.y(str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void j() {
        this.H.B(false);
        this.H.n(false);
        this.H.o(true);
        J(this.f208460e.S());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.e
    public void k(String str, String str2) {
        this.H.s(str, str2);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void l() {
        this.H.B(true);
        this.H.o(false);
        Z();
        I();
        a0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void y() {
        super.y();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void z() {
        if (this.I) {
            this.H.s("", "");
        }
    }
}
