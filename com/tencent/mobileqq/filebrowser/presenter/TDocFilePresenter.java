package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.filebrowser.presenter.TDocFilePresenter;
import com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.OpenDocsPerformanceRecorder;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.ag;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.e;
import com.tencent.mobileqq.teamwork.menu.ak;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class TDocFilePresenter extends SimpleFilePresenter {
    static IPatchRedirector $redirector_;
    private final TDocFileBrowserView K;
    protected boolean L;
    private boolean M;
    private final ag N;
    private boolean P;
    private final WeakReference<Activity> Q;
    private final Runnable R;
    private final ak S;
    private final com.tencent.mobileqq.teamwork.e T;
    private final OpenDocsPerformanceRecorder U;

    /* loaded from: classes12.dex */
    class a implements ak {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TDocFilePresenter.this);
            }
        }
    }

    /* loaded from: classes12.dex */
    class b implements e.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TDocFilePresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.e.a
        @NonNull
        public String getFileName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return TDocFilePresenter.this.f205964e.getFileName();
        }

        @Override // com.tencent.mobileqq.teamwork.e.a
        @NonNull
        public String getFilePath() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return TDocFilePresenter.this.f205964e.getFilePath();
        }

        @Override // com.tencent.mobileqq.teamwork.e.a
        public long getFileSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return TDocFilePresenter.this.f205964e.getFileSize();
        }
    }

    /* loaded from: classes12.dex */
    class c implements TDocFileBrowserView.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f205992a;

        c(long j3) {
            this.f205992a = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TDocFilePresenter.this, Long.valueOf(j3));
            }
        }

        @Override // com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView.c
        public void a(ITDocFileBrowserFacade.EngineType engineType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) engineType);
                return;
            }
            QLog.d("TDocFilePresenter", 1, "tDoc_step loadSucceed");
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.R);
            long currentTimeMillis = System.currentTimeMillis() - this.f205992a;
            TDocFilePresenter.this.U.e(0, "");
            TDocFilePresenter.this.T.c("show", 1, currentTimeMillis, 0, engineType.name());
            TDocFilePresenter.this.T.c(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, 1, currentTimeMillis, 0, engineType.name());
        }

        @Override // com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView.c
        public void b(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("TDocFilePresenter", 1, "tDoc_step unsupported, code:" + i3 + " msg:" + str);
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.R);
            if (!TextUtils.isEmpty(str) && (str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_ERROR_CODE)) || str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_EMPTY_CODE)))) {
                QLog.i("TDocFilePresenter", 1, "loadFailed, Filter password error codes");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f205992a;
            TDocFilePresenter.this.U.e(i3, str);
            TDocFilePresenter.this.T.c("show", 2, currentTimeMillis, i3, "");
            TDocFilePresenter.this.A0(false);
        }

        @Override // com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView.c
        public void c(int i3, String str, ITDocFileBrowserFacade.EngineType engineType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, engineType);
                return;
            }
            QLog.i("TDocFilePresenter", 1, "tDoc_step loadFailed, code:" + i3 + " msg:" + str);
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.R);
            if (!TextUtils.isEmpty(str) && (str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_ERROR_CODE)) || str.contains(String.valueOf(ITDocFileBrowserFacade.PASS_WORD_EMPTY_CODE)))) {
                QLog.i("TDocFilePresenter", 1, "loadFailed, Filter password error codes");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.f205992a;
            TDocFilePresenter.this.U.e(i3, str);
            TDocFilePresenter.this.T.c(ITDocAttaReporterApi.REPORT_ACTION_PERFORMANCE, 2, currentTimeMillis, i3, engineType.name());
        }

        @Override // com.tencent.mobileqq.filebrowser.view.TDocFileBrowserView.c
        public void hasPassword() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            QLog.d("TDocFilePresenter", 1, "tDoc_step hasPassword");
            ThreadManager.getFileThreadHandler().removeCallbacks(TDocFilePresenter.this.R);
            TDocFilePresenter.this.U.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class d extends ag {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TDocFilePresenter.this);
            }
        }

        private void l(final String str, final TeamWorkFileImportInfo teamWorkFileImportInfo) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.t
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFilePresenter.d.this.u(str, teamWorkFileImportInfo);
                }
            }, 128, null, false);
        }

        private void m(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
            try {
                if (jSONObject.getInt("retcode") != 0) {
                    TDocFilePresenter.this.f205965f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            TDocFilePresenter.d.this.v();
                        }
                    });
                    if (teamWorkFileImportInfo.b()) {
                        TeamWorkHandlerUtils.e(teamWorkFileImportInfo.f292069c0, TDocFilePresenter.this.f205963d.getCurrentAccountUin());
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
                    return;
                }
                n(jSONObject, teamWorkFileImportInfo, str);
            } catch (JSONException e16) {
                ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
                QLog.e("TDocFilePresenter", 1, "direct share fail", e16);
                QQToast.makeText(TDocFilePresenter.this.f205966h, 1, R.string.i0t, 0).show();
            }
        }

        private void n(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) throws JSONException {
            if (teamWorkFileImportInfo.a()) {
                TDocFilePresenter tDocFilePresenter = TDocFilePresenter.this;
                tDocFilePresenter.f205963d.v(jSONObject, str, tDocFilePresenter.f205965f);
                lr2.a.j(null, "0X800A21F");
                return;
            }
            if (teamWorkFileImportInfo.b()) {
                if (!TDocFilePresenter.this.P) {
                    long b16 = lr2.a.b(teamWorkFileImportInfo.X + "-" + teamWorkFileImportInfo.J);
                    if (b16 > 0) {
                        ReportController.o(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(b16), "");
                    }
                    ta1.l c16 = TencentDocLocalCooperationProcessor.c();
                    if (!c16.c(teamWorkFileImportInfo.f292074f)) {
                        w(teamWorkFileImportInfo, teamWorkFileImportInfo.f292069c0, c16.b(teamWorkFileImportInfo.f292074f));
                        TDocFilePresenter tDocFilePresenter2 = TDocFilePresenter.this;
                        tDocFilePresenter2.f205963d.h0(jSONObject, str, teamWorkFileImportInfo, tDocFilePresenter2.f205965f);
                        return;
                    }
                    return;
                }
                TeamWorkHandlerUtils.e(teamWorkFileImportInfo.f292069c0, TDocFilePresenter.this.f205963d.getCurrentAccountUin());
            }
        }

        private void o(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            boolean z16;
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                if (teamWorkFileImportInfo.f292083l0 == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    lr2.a.j(null, "0X800ABA7");
                } else {
                    lr2.a.j(null, "0X800ABA8");
                }
                if (!z16) {
                    w(teamWorkFileImportInfo, teamWorkFileImportInfo.f292085m0, true);
                }
                teamWorkFileImportInfo.f292085m0 = null;
                teamWorkFileImportInfo.f292083l0 = 0;
            }
        }

        private boolean p(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo != null && ((teamWorkFileImportInfo.a() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 0)) {
                return true;
            }
            return false;
        }

        private boolean q(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo != null && ((teamWorkFileImportInfo.e() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 0)) {
                return true;
            }
            return false;
        }

        private boolean r(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo != null && ((teamWorkFileImportInfo.e() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 1)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s() {
            if (TDocFilePresenter.this.K != null) {
                TDocFilePresenter.this.K.d0();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(Activity activity, TeamWorkFileImportInfo teamWorkFileImportInfo, String str, Object obj) {
            if (!(obj instanceof JSONObject)) {
                return;
            }
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.v
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFilePresenter.d.this.s();
                }
            });
            m((JSONObject) obj, teamWorkFileImportInfo, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(final String str, final TeamWorkFileImportInfo teamWorkFileImportInfo) {
            final Activity activity = (Activity) TDocFilePresenter.this.Q.get();
            if (activity != null) {
                TeamWorkHandlerUtils.l(str, TDocFilePresenter.this.f205963d.getCurrentAccountUin(), new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.filebrowser.presenter.u
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        TDocFilePresenter.d.this.t(activity, teamWorkFileImportInfo, str, obj);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v() {
            QQToast.makeText(TDocFilePresenter.this.f205966h, 1, R.string.i0t, 0).show();
        }

        private void w(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, boolean z16) {
            boolean z17;
            int i3 = teamWorkFileImportInfo.f292070d;
            if ((i3 == 1 || i3 == 0 || i3 == 3000) && !teamWorkFileImportInfo.f292072e.equals(TDocFilePresenter.this.f205963d.getCurrentAccountUin())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(teamWorkFileImportInfo.f292072e);
                TDocFilePresenter.this.B0(arrayList, str, z16, teamWorkFileImportInfo.f292070d);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamWorkFileImportInfo);
                return;
            }
            super.a(teamWorkFileImportInfo);
            if (TDocFilePresenter.this.K != null) {
                TDocFilePresenter.this.K.d0();
            }
            if (q(teamWorkFileImportInfo)) {
                if (teamWorkFileImportInfo.b()) {
                    ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
                }
                if (!TextUtils.isEmpty(teamWorkFileImportInfo.U)) {
                    QQToast.makeText(TDocFilePresenter.this.f205966h, 1, teamWorkFileImportInfo.U, 0).show();
                } else {
                    QQToast.makeText(TDocFilePresenter.this.f205966h, 1, R.string.i0t, 0).show();
                }
            }
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                lr2.a.j(null, "0X800ABAD");
            }
            if (TDocFilePresenter.this.K != null) {
                r(teamWorkFileImportInfo);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void d(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) teamWorkFileImportInfo);
                return;
            }
            super.d(teamWorkFileImportInfo);
            if (p(teamWorkFileImportInfo)) {
                String string = TDocFilePresenter.this.f205966h.getString(R.string.f6s);
                if (teamWorkFileImportInfo.b()) {
                    if (!TencentDocLocalCooperationProcessor.c().c(teamWorkFileImportInfo.f292074f)) {
                        TDocFilePresenter.this.K.B0(TDocFilePresenter.this.f205966h.getString(R.string.zza));
                    }
                } else {
                    TDocFilePresenter.this.K.B0(string);
                }
                lr2.a.j(null, "0X800A21E");
            }
            r(teamWorkFileImportInfo);
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) teamWorkFileImportInfo);
                return;
            }
            super.e(str, teamWorkFileImportInfo);
            o(str, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && (teamWorkFileImportInfo.a() || (teamWorkFileImportInfo.b() && teamWorkFileImportInfo.Y == 0))) {
                l(str, teamWorkFileImportInfo);
            } else if (TDocFilePresenter.this.K != null) {
                TDocFilePresenter.this.K.d0();
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void f(String str, String str2, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, teamWorkFileImportInfo);
                return;
            }
            super.f(str, str2, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && str2 != null && teamWorkFileImportInfo.b()) {
                TDocFilePresenter.this.z0(false, teamWorkFileImportInfo.f292070d);
            }
            if (teamWorkFileImportInfo != null && str2 != null && teamWorkFileImportInfo.e()) {
                teamWorkFileImportInfo.f292083l0 = 0;
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void g(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) teamWorkFileImportInfo);
                return;
            }
            super.g(teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.b()) {
                TDocFilePresenter.this.z0(true, teamWorkFileImportInfo.f292070d);
            } else if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                lr2.a.j(null, "0X800ABA4");
            }
        }
    }

    public TDocFilePresenter(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.L = true;
        this.M = false;
        this.N = new d();
        this.P = false;
        this.R = new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.TDocFilePresenter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TDocFilePresenter.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.i("TDocFilePresenter", 1, "tDoc_step timeoutMonitor running ");
                ThreadManager.getFileThreadHandler().removeCallbacks(this);
                TDocFilePresenter.this.T.c("show", 3, 0L, 0, "");
                TDocFilePresenter.this.U.l();
                TDocFilePresenter.this.A0(false);
            }
        };
        this.S = new a();
        com.tencent.mobileqq.teamwork.e eVar2 = new com.tencent.mobileqq.teamwork.e(new b());
        this.T = eVar2;
        OpenDocsPerformanceRecorder recorder = eVar2.getRecorder();
        this.U = recorder;
        this.Q = new WeakReference<>(activity);
        TDocFileBrowserView tDocFileBrowserView = new TDocFileBrowserView(activity);
        this.K = tDocFileBrowserView;
        b0(tDocFileBrowserView);
        long currentTimeMillis = System.currentTimeMillis();
        recorder.k();
        tDocFileBrowserView.z0(recorder);
        tDocFileBrowserView.w0(new c(currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(boolean z16) {
        this.D.putBoolean("tdoc_enable", z16);
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.b1(true);
        }
    }

    private void p0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).addObserver(this.N);
        }
    }

    private void q0() {
        if (this.f205963d.O() == 2) {
            this.K.y0(true);
            Y();
            this.K.q0(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.s
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFilePresenter.this.v0();
                }
            });
            return;
        }
        M();
    }

    private String r0(String str) {
        return ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(str);
    }

    private String s0() {
        String fileId = this.f205964e.getFileId();
        if (TextUtils.isEmpty(fileId)) {
            fileId = this.f205964e.getUuid();
        }
        String filePath = this.f205964e.getFilePath();
        if (TextUtils.isEmpty(fileId) && filePath != null && new File(filePath).exists()) {
            fileId = UUID.nameUUIDFromBytes(filePath.getBytes()).toString();
        }
        if (TextUtils.isEmpty(fileId)) {
            fileId = "default_file_id";
        }
        QLog.d("TDocFilePresenter", 1, "getFileId: " + fileId + "path: " + filePath);
        return fileId;
    }

    private void t0(boolean z16) {
        com.tencent.mobileqq.filebrowser.d dVar;
        if (this.K.b0()) {
            QLog.i("TDocFilePresenter", 1, "handleCheckResourceResult pauseLoad");
            return;
        }
        if (z16) {
            QLog.i("TDocFilePresenter", 1, "tDoc_step download suc");
            this.E.n(95);
            if (ImmersiveUtils.isSupporImmersive() == 1 && (dVar = this.f205967i) != null) {
                dVar.D();
            }
            if (this.f205964e.getFileType() == 10) {
                ae.o(this.f205964e.getFileSize());
            }
            if (((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getConfig().f291513h) {
                int i3 = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getConfig().f291515m;
                QLog.i("TDocFilePresenter", 1, "tDoc_step postDelayed duration " + i3);
                ThreadManager.getFileThreadHandler().postDelayed(this.R, (long) i3);
            }
            this.f205963d.G(7);
            this.K.x0(this.f205964e.getFilePath(), s0(), this.f205963d.K());
            this.K.v0(this.S);
            this.L = false;
            this.U.c();
            return;
        }
        this.T.c("show", 2, 0L, -103, "");
        A0(false);
    }

    private void u0() {
        if (com.tencent.mobileqq.filemanager.util.q.f(this.f205964e.getFilePath())) {
            this.E.q(true);
            this.E.o(false);
            G(0.9f);
        }
        this.E.i(new View.OnClickListener() { // from class: com.tencent.mobileqq.filebrowser.presenter.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TDocFilePresenter.this.w0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0() {
        this.K.y0(false);
        G(this.f205963d.F());
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(String str) {
        String[] split = str.split("\\$");
        if (split.length == 2) {
            TeamWorkHandlerUtils.q(this.f205963d.getCurrentAccountUin(), split[0], split[1], 1, null);
        }
    }

    private void y0() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((AppInterface) peekAppRuntime).removeObserver(this.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(boolean z16, int i3) {
        String str;
        ta1.l c16 = TencentDocLocalCooperationProcessor.c();
        if (z16) {
            str = c16.f435704f;
        } else {
            str = c16.f435706i;
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str2)) {
            int i16 = 1;
            if (i3 != 1 && i3 != 3000) {
                i16 = i3 == 0 ? 0 : 3;
            }
            ReportController.o(null, "dc00898", "", "", str2, str2, i16, 0, "", "", "", "");
        }
    }

    public void B0(List<String> list, final String str, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, str, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else if (!TextUtils.isEmpty(str) && list != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.r
                @Override // java.lang.Runnable
                public final void run() {
                    TDocFilePresenter.this.x0(str);
                }
            }, 128, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void G(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            return;
        }
        super.G(f16);
        this.E.n((int) (100.0f * f16));
        if (f16 < 1.0f) {
            this.E.m(this.f205966h.getResources().getString(R.string.f187683un));
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
        u0();
        p0();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void L(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) configuration);
        } else {
            super.L(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f205963d.O() == 2) {
            ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(this.f205966h);
            QLog.i("TDocFilePresenter", 1, "tDoc_step handleLocalFile handleCheckResourceResult");
            t0(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).isAllResourceReady(r0(this.f205964e.getFilePath())));
        } else {
            A0(false);
        }
        super.X();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.e.f
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.P) {
            return;
        }
        G(0.9f);
        ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).initLocalEditSDK(this.f205966h);
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.A();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        y0();
        this.P = true;
        TDocFileBrowserView tDocFileBrowserView = this.K;
        if (tDocFileBrowserView != null) {
            tDocFileBrowserView.C0();
        }
        this.T.d();
        super.t();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.u();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.v();
        if (this.M) {
            this.K.D0(this.f205964e.getFilePath(), s0());
        }
        this.M = true;
    }
}
