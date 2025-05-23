package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.e;
import com.tencent.mobileqq.teamwork.menu.ak;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.UUID;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class TDocFilePresenter extends SimpleFilePresenter {
    private final TDocFileBrowserView X;
    protected boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f208487a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Runnable f208488b0;

    /* renamed from: c0, reason: collision with root package name */
    private final ak f208489c0;

    /* renamed from: d0, reason: collision with root package name */
    private final com.tencent.mobileqq.teamwork.e f208490d0;

    /* renamed from: e0, reason: collision with root package name */
    private final OpenDocsPerformanceRecorder f208491e0;

    /* loaded from: classes12.dex */
    class a implements ak {
        a() {
        }
    }

    /* loaded from: classes12.dex */
    class b implements e.a {
        b() {
        }

        @Override // com.tencent.mobileqq.teamwork.e.a
        @NonNull
        public String getFileName() {
            return TDocFilePresenter.this.f208460e.L();
        }

        @Override // com.tencent.mobileqq.teamwork.e.a
        @NonNull
        public String getFilePath() {
            return TDocFilePresenter.this.f208460e.N();
        }

        @Override // com.tencent.mobileqq.teamwork.e.a
        public long getFileSize() {
            return TDocFilePresenter.this.f208460e.Q();
        }
    }

    /* loaded from: classes12.dex */
    class c implements TDocFileBrowserView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f208494a;

        c(long j3) {
            this.f208494a = j3;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView.c
        public void a(ITDocFileBrowserFacade.EngineType engineType) {
            QLog.d("TDocFilePresenter", 1, "tDoc_step loadSucceed");
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.f208488b0);
            long currentTimeMillis = System.currentTimeMillis() - this.f208494a;
            TDocFilePresenter.this.f208491e0.e(0, "");
            TDocFilePresenter.this.f208490d0.c("show", 1, currentTimeMillis, 0, engineType.name());
            TDocFilePresenter.this.f208490d0.c(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, 1, currentTimeMillis, 0, engineType.name());
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView.c
        public void b(int i3, String str) {
            QLog.i("TDocFilePresenter", 1, "tDoc_step unsupported, code:" + i3 + " msg:" + str);
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.f208488b0);
            if (!TextUtils.isEmpty(str) && (str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_ERROR_CODE)) || str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_EMPTY_CODE)))) {
                QLog.i("TDocFilePresenter", 1, "loadFailed, Filter password error codes");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f208494a;
            TDocFilePresenter.this.f208491e0.e(i3, str);
            TDocFilePresenter.this.f208490d0.c("show", 2, currentTimeMillis, i3, "");
            TDocFilePresenter.this.L0(false);
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView.c
        public void c(int i3, String str, ITDocFileBrowserFacade.EngineType engineType) {
            QLog.i("TDocFilePresenter", 1, "tDoc_step loadFailed, code:" + i3 + " msg:" + str);
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.f208488b0);
            if (!TextUtils.isEmpty(str) && (str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_ERROR_CODE)) || str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_EMPTY_CODE)))) {
                QLog.i("TDocFilePresenter", 1, "loadFailed, Filter password error codes");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f208494a;
            TDocFilePresenter.this.f208491e0.e(i3, str);
            TDocFilePresenter.this.f208490d0.c(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, 2, currentTimeMillis, i3, engineType.name());
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.viewer.TDocFileBrowserView.c
        public void hasPassword() {
            QLog.d("TDocFilePresenter", 1, "tDoc_step hasPassword");
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.f208488b0);
            TDocFilePresenter.this.f208491e0.j();
        }
    }

    public TDocFilePresenter(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.Y = true;
        this.Z = false;
        this.f208487a0 = false;
        this.f208488b0 = new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.TDocFilePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("TDocFilePresenter", 1, "tDoc_step timeoutMonitor running ");
                ThreadManager.getFileThreadHandler().removeCallbacks(this);
                TDocFilePresenter.this.f208490d0.c("show", 3, 0L, 0, "");
                TDocFilePresenter.this.f208491e0.l();
                TDocFilePresenter.this.L0(false);
            }
        };
        this.f208489c0 = new a();
        com.tencent.mobileqq.teamwork.e eVar = new com.tencent.mobileqq.teamwork.e(new b());
        this.f208490d0 = eVar;
        OpenDocsPerformanceRecorder recorder = eVar.getRecorder();
        this.f208491e0 = recorder;
        TDocFileBrowserView tDocFileBrowserView = new TDocFileBrowserView(activity);
        this.X = tDocFileBrowserView;
        t0(tDocFileBrowserView);
        long currentTimeMillis = System.currentTimeMillis();
        recorder.k();
        tDocFileBrowserView.c1(recorder);
        tDocFileBrowserView.Z0(new c(currentTimeMillis));
    }

    private void E0() {
        if (this.f208460e.T() == 2) {
            this.X.b1(true);
            n0();
            this.X.U0(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.m
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFilePresenter.this.J0();
                }
            });
            return;
        }
        P();
    }

    private String F0(String str) {
        return ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(str);
    }

    private String G0() {
        String z16 = this.f208460e.z();
        if (z16 == null) {
            z16 = this.f208460e.h0();
        }
        String N = this.f208460e.N();
        if (z16 == null && N != null && new File(N).exists()) {
            z16 = UUID.nameUUIDFromBytes(N.getBytes()).toString();
        }
        if (z16 == null) {
            z16 = "default_file_id";
        }
        QLog.d("TDocFilePresenter", 1, "getFileId: " + z16 + "path: " + N);
        return z16;
    }

    private void H0(boolean z16) {
        com.tencent.mobileqq.filemanager.fileviewer.h hVar;
        if (this.X.G0()) {
            QLog.i("TDocFilePresenter", 1, "handleCheckResourceResult pauseLoad");
            return;
        }
        if (z16) {
            this.X.m(95);
            if (ImmersiveUtils.isSupporImmersive() == 1 && (hVar = this.f208463i) != null) {
                hVar.D();
            }
            if (this.f208460e.V() == 10) {
                ae.o(this.f208460e.Q());
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getConfig().f291513h) {
                int i3 = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getConfig().f291515m;
                QLog.i("TDocFilePresenter", 1, "tDoc_step postDelayed duration " + i3);
                ThreadManager.getFileThreadHandler().postDelayed(this.f208488b0, (long) i3);
            }
            this.f208460e.q(7);
            this.X.a1(this.f208460e.N(), G0(), this.f208460e.c0());
            this.X.Y0(this.f208489c0);
            this.Y = false;
            this.f208491e0.c();
            return;
        }
        this.f208490d0.c("show", 2, 0L, -103, "");
        L0(false);
    }

    private void I0() {
        if (q.f(this.f208460e.N())) {
            this.X.o(true);
            this.X.n(false);
            J(0.9f);
        }
        this.X.g(new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TDocFilePresenter.this.K0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        this.X.b1(false);
        J(this.f208460e.S());
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        E0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(boolean z16) {
        this.D.putBoolean("tdoc_enable", z16);
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.r2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void J(float f16) {
        super.J(f16);
        this.X.m((int) (100.0f * f16));
        if (f16 < 1.0f) {
            this.X.l(this.f208461f.getResources().getString(R.string.f187683un));
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        I0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void O(Configuration configuration) {
        super.O(configuration);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        if (this.f208487a0) {
            return;
        }
        J(0.9f);
        ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(MobileQQ.sMobileQQ);
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.h2();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
    protected boolean j0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
    public void m0() {
        if (this.f208460e.T() == 2) {
            ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(MobileQQ.sMobileQQ);
            QLog.i("TDocFilePresenter", 1, " handleLocalFile handleCheckResourceResult");
            H0(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isAllResourceReady(F0(this.f208460e.N())));
        } else {
            L0(false);
        }
        super.m0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void x() {
        this.f208487a0 = true;
        TDocFileBrowserView tDocFileBrowserView = this.X;
        if (tDocFileBrowserView != null) {
            tDocFileBrowserView.e1();
        }
        this.f208490d0.d();
        super.x();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void z() {
        super.z();
        if (this.Z) {
            this.X.f1(this.f208460e.N(), G0());
        }
        this.Z = true;
    }
}
