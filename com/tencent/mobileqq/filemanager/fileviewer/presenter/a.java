package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ao;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a extends SimpleFilePresenter implements View.OnClickListener {
    private QFileAppStorePromoteManager.e X;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.presenter.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    class ViewOnClickListenerC7576a implements View.OnClickListener {
        ViewOnClickListenerC7576a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
        
            if (r0.o(r2.f208461f, r1, r2.X) == false) goto L7;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFileAppStorePromoteManager A0 = a.this.A0();
            String w3 = a.this.f208460e.w();
            if (!TextUtils.isEmpty(w3) && A0 != null) {
                a aVar = a.this;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, QFileUtils.G(a.this.f208460e.V()) + "", "", "", "");
            cc1.a D = a.this.f208460e.D();
            if (D != null) {
                D.a();
                a.this.G.i0(false);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, QFileUtils.G(a.this.f208460e.V()) + "", "", "", "");
            cc1.a D = a.this.f208460e.D();
            if (D != null) {
                D.a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements QFileAppStorePromoteManager.e {
        c() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.e
        public void a() {
            QFileAppStorePromoteManager A0 = a.this.A0();
            if (A0 == null) {
                return;
            }
            String r16 = a.this.f208460e.r();
            if (A0.c()) {
                if (!TextUtils.isEmpty(r16)) {
                    QFileAppStorePromoteManager.p(r16, 1);
                    return;
                } else {
                    QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
                    return;
                }
            }
            A0.n(a.this.f208461f, r16);
        }

        @Override // com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.e
        public void b() {
            ReportController.o(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, QFileUtils.G(a.this.f208460e.V()) + "", "", "", "");
            cc1.a D = a.this.f208460e.D();
            if (D != null) {
                D.a();
                a.this.G.i0(false);
            }
        }
    }

    public a(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.X = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QFileAppStorePromoteManager A0() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return ((QQAppInterface) runtime).getFileManagerEngine().J();
        }
        return null;
    }

    private void C0() {
        this.C = true;
        this.G.e(HardCodeUtil.qqStr(R.string.mhq) + ao.a(this.f208460e.Q()) + ")", new b());
        this.G.o(false);
        this.G.n(true);
    }

    protected void B0() {
        int T;
        QFileAppStorePromoteManager A0 = A0();
        if (A0 != null && this.f208460e.h() && A0.d() && !TextUtils.isEmpty(this.f208460e.r()) && (T = this.f208460e.T()) != 6 && T != 2 && T != 4 && T != 5) {
            this.G.Z(A0.h(this.f208461f), this);
            ReportController.o(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void I() {
        super.I();
        int T = this.f208460e.T();
        if (T != 6 && T != 2 && T != 4 && T != 5) {
            if (A0() == null) {
                C0();
                return;
            }
            this.C = true;
            this.G.e(HardCodeUtil.qqStr(R.string.mhq) + ao.a(this.f208460e.Q()) + ")", new ViewOnClickListenerC7576a());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("ApkForAppStoreFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
        }
        String K = this.f208460e.K();
        this.G.U(R.drawable.filelook_apk);
        if (!TextUtils.isEmpty(K)) {
            this.G.X(K);
        } else {
            this.G.T(this.f208460e.s());
        }
        if (!TextUtils.isEmpty(this.f208460e.J()) && 16 != this.f208460e.R()) {
            this.G.V(this.f208460e.J());
        } else {
            this.G.h0(false);
        }
        if (!TextUtils.isEmpty(this.f208460e.J()) && 16 != this.f208460e.R()) {
            this.G.V(this.f208460e.J());
        } else {
            this.G.h0(false);
        }
        if (this.f208460e.R() == 16) {
            this.G.f0(this.f208461f.getString(R.string.b7d));
        } else if (this.f208460e.q0()) {
            this.G.f0(this.f208461f.getString(R.string.b_t));
        }
        this.G.m0(true ^ this.f208460e.d());
        String w3 = this.f208460e.w();
        if (!TextUtils.isEmpty(w3)) {
            this.G.Y(w3);
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.f208460e.N())) {
            B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
    public void n0() {
        int T;
        QFileAppStorePromoteManager A0 = A0();
        if (A0 != null && this.f208460e.h() && A0.d() && !TextUtils.isEmpty(this.f208460e.r()) && (T = this.f208460e.T()) != 6 && T != 2 && T != 4 && T != 5) {
            this.G.Z(A0.h(this.f208461f), this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QFileAppStorePromoteManager A0 = A0();
        if (A0 != null) {
            ReportController.o(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
            String r16 = this.f208460e.r();
            if (A0.c()) {
                if (!TextUtils.isEmpty(r16)) {
                    QFileAppStorePromoteManager.p(r16, 1);
                } else {
                    QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
                }
            } else {
                A0.n(this.f208461f, r16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
    protected void k0() {
    }
}
