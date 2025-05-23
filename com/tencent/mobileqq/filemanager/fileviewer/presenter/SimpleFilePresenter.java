package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.n;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.filemanager.util.ao;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.ag;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.u;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class SimpleFilePresenter extends FileBrowserPresenterBase implements FileBrowserModelBase.f {
    public static String V = "qqmail://home?fileid=";
    public static String W = "https://mail.qq.com/cgi-bin/readtemplate?check=false&t=go_app&_wv=7&from=mqqlistbar&uin=";
    protected boolean F;
    protected SimpleFileViewer G;
    private Runnable H;
    private boolean I;
    private volatile boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private Handler S;
    private ag T;
    private LocalTbsViewManager.e U;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class InnerTeamWorkFileImportObserver extends ag {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter$InnerTeamWorkFileImportObserver$1, reason: invalid class name */
        /* loaded from: classes12.dex */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f208478d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TeamWorkFileImportInfo f208479e;

            AnonymousClass1(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
                this.f208478d = str;
                this.f208479e = teamWorkFileImportInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e() {
                SimpleFileViewer simpleFileViewer = SimpleFilePresenter.this.G;
                if (simpleFileViewer != null) {
                    simpleFileViewer.L();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, Object obj) {
                if (!(obj instanceof JSONObject)) {
                    return;
                }
                SimpleFilePresenter.this.f208461f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        SimpleFilePresenter.InnerTeamWorkFileImportObserver.AnonymousClass1.this.e();
                    }
                });
                InnerTeamWorkFileImportObserver.this.j((JSONObject) obj, teamWorkFileImportInfo, str);
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f208478d;
                String B = SimpleFilePresenter.this.f208460e.B();
                final TeamWorkFileImportInfo teamWorkFileImportInfo = this.f208479e;
                final String str2 = this.f208478d;
                TeamWorkHandlerUtils.l(str, B, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.j
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        SimpleFilePresenter.InnerTeamWorkFileImportObserver.AnonymousClass1.this.f(teamWorkFileImportInfo, str2, obj);
                    }
                });
            }
        }

        InnerTeamWorkFileImportObserver() {
        }

        private void i(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            ThreadManagerV2.excute(new AnonymousClass1(str, teamWorkFileImportInfo), 128, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
            try {
                if (jSONObject.getInt("retcode") != 0) {
                    SimpleFilePresenter.this.f208461f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.2
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.i0t, 0).show();
                        }
                    });
                    if (teamWorkFileImportInfo.b()) {
                        TeamWorkHandlerUtils.e(teamWorkFileImportInfo.f292069c0, SimpleFilePresenter.this.f208460e.B());
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
                    return;
                }
                k(jSONObject, teamWorkFileImportInfo, str);
            } catch (JSONException e16) {
                ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
                QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", e16);
                QQToast.makeText(BaseApplicationImpl.getApplication(), 1, R.string.i0t, 0).show();
            }
        }

        private void k(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) throws JSONException {
            TencentDocData tencentDocData = new TencentDocData();
            TencentDocData.obtainFromJsonObject(jSONObject, null, tencentDocData);
            Intent intent = new Intent();
            intent.putExtra("key_flag_from_plugin", true);
            intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, true);
            if (teamWorkFileImportInfo.a()) {
                intent.setClass(SimpleFilePresenter.this.f208461f, ForwardRecentActivity.class);
                Activity activity = SimpleFilePresenter.this.f208461f;
                String str2 = tencentDocData.docIcon;
                String str3 = tencentDocData.title;
                ShareMsgHelper.f(activity, 1001, 95, "web_share", "", str2, str3, tencentDocData.summary, activity.getString(R.string.f171308dy0, str3), str, "web", null, null, null, "web", null, null, null, ITeamWorkUtils.DOCS_SOURCE_ICON_URL, SimpleFilePresenter.this.f208461f.getString(R.string.hz5), "", intent, 2865, ITeamWorkUtils.DOCS_LIST_URL, -1L);
                lr2.a.j(null, "0X800A21F");
                return;
            }
            if (teamWorkFileImportInfo.b()) {
                if (!SimpleFilePresenter.this.P) {
                    long b16 = lr2.a.b(teamWorkFileImportInfo.X + "-" + teamWorkFileImportInfo.J);
                    if (b16 > 0) {
                        ReportController.o(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(b16), "");
                    }
                    ta1.l c16 = TencentDocLocalCooperationProcessor.c();
                    if (c16.c(teamWorkFileImportInfo.f292074f)) {
                        SimpleFilePresenter.this.G.p0(str, Boolean.FALSE);
                        return;
                    }
                    m(teamWorkFileImportInfo, teamWorkFileImportInfo.f292069c0, c16.b(teamWorkFileImportInfo.f292074f));
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                    tencentDocData.docUrl = str;
                    ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).sendDocCooperationShare(qQAppInterface, SimpleFilePresenter.this.f208461f, tencentDocData, teamWorkFileImportInfo);
                    return;
                }
                TeamWorkHandlerUtils.e(teamWorkFileImportInfo.f292069c0, SimpleFilePresenter.this.f208460e.B());
            }
        }

        private void l(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
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
                    SimpleFilePresenter.this.G.p0(str, Boolean.FALSE);
                }
                if (SimpleFilePresenter.this.R && z16) {
                    SimpleFilePresenter.this.Q = true;
                }
                if (!z16) {
                    m(teamWorkFileImportInfo, teamWorkFileImportInfo.f292085m0, true);
                }
                teamWorkFileImportInfo.f292085m0 = null;
                teamWorkFileImportInfo.f292083l0 = 0;
            }
        }

        private void m(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, boolean z16) {
            boolean z17;
            int i3 = teamWorkFileImportInfo.f292070d;
            if ((i3 == 1 || i3 == 0 || i3 == 3000) && teamWorkFileImportInfo.f292072e != SimpleFilePresenter.this.f208460e.B()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(teamWorkFileImportInfo.f292072e);
                SimpleFilePresenter.this.u0(arrayList, str, z16, teamWorkFileImportInfo.f292070d);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            SimpleFileViewer simpleFileViewer;
            super.a(teamWorkFileImportInfo);
            SimpleFileViewer simpleFileViewer2 = SimpleFilePresenter.this.G;
            if (simpleFileViewer2 != null) {
                simpleFileViewer2.L();
            }
            if (teamWorkFileImportInfo != null && (teamWorkFileImportInfo.a() || (teamWorkFileImportInfo.b() && teamWorkFileImportInfo.Y == 0))) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                if (teamWorkFileImportInfo.b()) {
                    ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
                }
                if (!TextUtils.isEmpty(teamWorkFileImportInfo.U)) {
                    QQToast.makeText(qQAppInterface.getApp(), 1, teamWorkFileImportInfo.U, 0).show();
                } else {
                    QQToast.makeText(qQAppInterface.getApp(), 1, R.string.i0t, 0).show();
                }
            }
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                lr2.a.j(null, "0X800ABAD");
            }
            if (teamWorkFileImportInfo != null) {
                if ((teamWorkFileImportInfo.e() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 1 && (simpleFileViewer = SimpleFilePresenter.this.G) != null) {
                    simpleFileViewer.o0(3);
                }
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void b(boolean z16) {
            super.b(z16);
            SimpleFileViewer simpleFileViewer = SimpleFilePresenter.this.G;
            if (simpleFileViewer != null) {
                simpleFileViewer.Q(z16);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void c(int i3) {
            super.c(i3);
            SimpleFileViewer simpleFileViewer = SimpleFilePresenter.this.G;
            if (simpleFileViewer != null) {
                simpleFileViewer.r0(i3);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void d(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            SimpleFileViewer simpleFileViewer;
            super.d(teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && (teamWorkFileImportInfo.a() || (teamWorkFileImportInfo.b() && teamWorkFileImportInfo.Y == 0))) {
                SimpleFilePresenter simpleFilePresenter = SimpleFilePresenter.this;
                if (simpleFilePresenter.G != null) {
                    String string = simpleFilePresenter.f208461f.getString(R.string.f6s);
                    if (teamWorkFileImportInfo.b()) {
                        if (!TencentDocLocalCooperationProcessor.c().c(teamWorkFileImportInfo.f292074f)) {
                            SimpleFilePresenter.this.G.k0(HardCodeUtil.qqStr(R.string.f187143t7));
                        }
                    } else {
                        SimpleFilePresenter.this.G.k0(string);
                    }
                    lr2.a.j(null, "0X800A21E");
                }
            }
            if (teamWorkFileImportInfo != null) {
                if ((teamWorkFileImportInfo.e() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 1 && (simpleFileViewer = SimpleFilePresenter.this.G) != null) {
                    simpleFileViewer.H(teamWorkFileImportInfo);
                    SimpleFilePresenter.this.G.o0(1);
                }
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            super.e(str, teamWorkFileImportInfo);
            l(str, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && (teamWorkFileImportInfo.a() || (teamWorkFileImportInfo.b() && teamWorkFileImportInfo.Y == 0))) {
                i(str, teamWorkFileImportInfo);
                return;
            }
            SimpleFileViewer simpleFileViewer = SimpleFilePresenter.this.G;
            if (simpleFileViewer != null) {
                simpleFileViewer.L();
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void f(String str, String str2, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            boolean z16;
            super.f(str, str2, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && str2 != null && teamWorkFileImportInfo.b()) {
                SimpleFilePresenter.this.G.p0(str, null);
                SimpleFilePresenter.this.G.o0(5);
                SimpleFilePresenter.this.r0(false, teamWorkFileImportInfo.f292070d);
            }
            if (teamWorkFileImportInfo != null && str2 != null && teamWorkFileImportInfo.e()) {
                if (teamWorkFileImportInfo.f292083l0 == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                teamWorkFileImportInfo.f292083l0 = 0;
                SimpleFilePresenter.this.G.p0(str, Boolean.valueOf(z16));
                SimpleFilePresenter.this.G.o0(5);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void g(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            super.g(teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.b()) {
                SimpleFilePresenter.this.G.o0(4);
                SimpleFilePresenter.this.r0(true, teamWorkFileImportInfo.f292070d);
            } else if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                SimpleFilePresenter.this.G.o0(5);
                lr2.a.j(null, "0X800ABA4");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f208482d;

        a(AppRuntime appRuntime) {
            this.f208482d = appRuntime;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ao.c(SimpleFilePresenter.this.f208460e, view, ao.f209337b);
            SimpleFilePresenter.this.q0(this.f208482d);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f208485d;

        c(String str) {
            this.f208485d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            dr.g(this.f208485d, BaseApplicationImpl.getApplication().getRuntime().getAccount(), SimpleFilePresenter.this.f208461f);
            KingCardProcessor.get().download.reportClickEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SimpleFilePresenter(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.F = true;
        this.H = null;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.T = new InnerTeamWorkFileImportObserver();
        this.U = new b();
        this.S = new Handler();
        SimpleFileViewer simpleFileViewer = new SimpleFileViewer(this.f208461f, fileBrowserModelBase.L());
        this.G = simpleFileViewer;
        t0(simpleFileViewer);
    }

    private void g0(int i3, boolean z16) {
        if (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface) {
            com.tencent.mobileqq.tbstool.gray.b bVar = com.tencent.mobileqq.tbstool.gray.b.f291450a;
            if (bVar.e(this.f208460e.L()).g()) {
                bVar.e(this.f208460e.L()).a(true);
                this.f208460e.q(i3);
                TeamWorkFileImportInfo c06 = this.f208460e.c0();
                c06.Q = z16;
                u.c(c06);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).a(false);
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).targetTencentDocFormKeyWords(this.f208460e.N(), this.f208460e.L(), this.f208460e.Q()) && this.K) {
            g0(13, false);
            return;
        }
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDocForLocalCooperation(this.f208460e.N(), this.f208460e.L(), this.f208460e.Q()) && this.K) {
            g0(11, TencentDocLocalCooperationProcessor.c().c(this.f208460e.L()));
            return;
        }
        if (this.f208460e.j()) {
            TeamWorkFileImportInfo c06 = this.f208460e.c0();
            u.v(c06);
            if (!this.L || this.M) {
                this.G.l0(c06);
            }
        }
    }

    private void o0() {
        this.H = new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                String E = SimpleFilePresenter.this.f208460e.E();
                if (!TextUtils.isEmpty(E) && !SimpleFilePresenter.this.I) {
                    SimpleFilePresenter.this.G.i(0);
                    SimpleFilePresenter.this.G.h(E);
                    SimpleFilePresenter.this.S.postDelayed(SimpleFilePresenter.this.H, 1000L);
                    return;
                }
                SimpleFilePresenter.this.G.i(8);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        FileManagerUtil.openWithOtherApp(this.f208461f, this.f208460e.N());
        ae.m("click_qb_app_store", String.valueOf(this.f208460e.V()), FileUtils.getExtension(this.f208460e.L()), str, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(boolean z16, int i3) {
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

    private void s0() {
        ao.d(this.f208460e, this.G.G(), ao.f209336a);
        ao.d(this.f208460e, this.G.I(), ao.f209337b);
    }

    private void w0() {
        Runnable runnable = this.H;
        if (runnable != null) {
            this.S.removeCallbacks(runnable);
            this.H = null;
        }
        SimpleFileViewer simpleFileViewer = this.G;
        if (simpleFileViewer != null) {
            simpleFileViewer.i(8);
        }
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(boolean z16) {
        com.tencent.mobileqq.filemanager.fileviewer.h hVar = this.f208463i;
        if (hVar != null) {
            hVar.g(z16);
        }
        if (this.G.P() && z16) {
            this.G.K();
            return;
        }
        if ((this.G.J() != null || this.f208460e.j()) && !z16) {
            if (!this.L || this.M) {
                this.G.l0(this.f208460e.c0());
            }
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void A() {
        super.A();
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).b(this.f208461f, 30004);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void B() {
        super.B();
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).b(this.f208461f, 30005);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void C() {
        super.C();
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).e(this.f208461f);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean G() {
        if (this.L) {
            this.f208461f.setRequestedOrientation(4);
        } else if (this.F) {
            this.f208461f.setRequestedOrientation(1);
        }
        if (!this.F && !this.L) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public boolean H() {
        if (this.F && !this.L) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        if (this.J) {
            this.J = false;
            return;
        }
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
        }
        this.G.i0(false);
        this.G.m0(false);
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.T);
        }
        this.G.Y(this.f208460e.L());
        v0(runtime);
        if (FileManagerUtil.isLocalFile(this.f208460e.N())) {
            m0();
        } else {
            k0();
        }
        this.f208460e.O0(this);
        l0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void N(int i3, int i16, Intent intent) {
        super.N(i3, i16, intent);
        if (i3 == 2864) {
            if (i16 == 0) {
                final TeamWorkFileImportInfo c06 = this.f208460e.c0();
                if (c06 != null && c06.f292069c0 != null) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TeamWorkHandlerUtils.e(c06.f292069c0, SimpleFilePresenter.this.f208460e.B());
                        }
                    }, 128, null, false);
                }
            } else if (i16 == -1) {
                lr2.a.j(null, "0X800A5A4");
                lr2.a.j(null, "0X800A5A3");
                AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
                if (runtime instanceof QQAppInterface) {
                    ITeamWorkFileImportHandler iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
                    TeamWorkFileImportInfo c07 = this.f208460e.c0();
                    if (iTeamWorkFileImportHandler != null && c07 != null) {
                        this.G.p0(iTeamWorkFileImportHandler.getUrlFromConvertedMap(c07), "open");
                        Bundle extras = intent.getExtras();
                        String string = extras.getString("uin");
                        int i17 = extras.getInt("uintype", 0);
                        if (c07.f292069c0 != null) {
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(string);
                            u0(arrayList, c07.f292069c0, TencentDocLocalCooperationProcessor.c().b(c07.f292074f), i17);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).checkDirectShareChangePolicy(i3, i16, intent, this.f208460e.c0());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void O(Configuration configuration) {
        super.O(configuration);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f208461f.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.G.S(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void P() {
        super.P();
        n0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void a(float f16) {
        J(f16);
        String E = this.f208460e.E();
        if (TextUtils.isEmpty(E)) {
            return;
        }
        this.G.i(0);
        this.G.h(E);
        if (this.H == null) {
            o0();
            this.S.post(this.H);
            this.I = false;
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void e() {
        this.G.o(false);
        I();
        n0();
        w0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void f() {
        this.G.n(true);
        this.G.o(false);
        I();
        n0();
        com.tencent.mobileqq.filemanager.fileviewer.g gVar = this.f208462h;
        if (gVar != null) {
            gVar.h2();
        }
        w0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void j() {
        this.G.n(false);
        this.G.o(true);
        J(this.f208460e.S());
        this.f208460e.U();
    }

    protected boolean j0() {
        return true;
    }

    protected void k0() {
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.f208460e.L() + "]");
        }
        if (this.f208460e.V() == 5) {
            this.G.U(R.drawable.filelook_apk);
            this.G.T(this.f208460e.s());
        } else {
            this.G.W(FileManagerUtil.getFileIconResId(this.f208460e.L()));
        }
        if (!TextUtils.isEmpty(this.f208460e.J()) && 16 != this.f208460e.R()) {
            this.G.V(this.f208460e.J());
        } else {
            this.G.h0(false);
        }
        if (this.f208460e.R() == 16) {
            this.G.f0(BaseApplication.getContext().getString(R.string.b7d));
            this.G.m0(true);
            return;
        }
        if (this.f208460e.q0()) {
            this.G.f0(BaseApplication.getContext().getString(R.string.b_t));
            this.G.m0(true);
            return;
        }
        if (this.f208460e.p()) {
            this.G.f0(BaseApplication.getContext().getString(R.string.b7d));
            this.G.m0(true);
            return;
        }
        if (this.f208460e.d()) {
            if (this.f208460e.D() != null) {
                this.f208460e.D().a();
                this.G.o(true);
                this.G.n(false);
                J(0.0f);
                return;
            }
            return;
        }
        if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(this.f208460e.N(), this.f208460e.L(), this.f208460e.Q())) {
            this.f208460e.q(7);
            u.u(this.f208460e.c0(), "SimpleFilePresenter<FileAssistant>");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.f
    public void l() {
        this.G.n(true);
        this.G.o(false);
        I();
        n0();
        w0();
    }

    protected void l0() {
        if (FileUtils.fileExistsAndNotEmpty(this.f208460e.N())) {
            this.G.j0(false);
            return;
        }
        String firstActionUrl = KingCardProcessor.get().download.getFirstActionUrl();
        if (NetworkUtil.isNetworkAvailable(this.f208461f) && !NetworkUtil.isWifiConnected(this.f208461f) && KingCardProcessor.get().download.enable && !TMSManager.e().h() && !TextUtils.isEmpty(firstActionUrl)) {
            this.G.N(new c(firstActionUrl));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m0() {
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.f208460e.L() + "] filePath[" + this.f208460e.N() + "]");
        }
        if (j0() && this.f208460e.T() == 2) {
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).i(this.f208461f, this.f208460e.N(), this.U, true);
            FilePreviewDataReporter.f209177a.f(this.f208460e.L(), this.f208460e.V(), this.f208460e.Q());
        }
        this.G.W(FileManagerUtil.getFileIconResId(this.f208460e.L()));
        this.G.V(this.f208460e.I());
        this.f208461f.getString(R.string.b7d);
        if (this.f208460e.R() == 16) {
            this.G.f0(BaseApplication.getContext().getString(R.string.b7d));
            this.G.m0(true);
        }
        n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n0() {
        if (com.tencent.mobileqq.tbstool.gray.b.f291450a.g(this.f208460e.L())) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "handleSecondActionButton new view not show it!");
        } else if (FileUtils.fileExistsAndNotEmpty(this.f208460e.N()) && QbSdk.isSuportOpenFile(FileManagerUtil.getFileSuffix(this.f208460e.L()), 2)) {
            final String string = this.f208461f.getString(R.string.cp7);
            this.G.Z(string, new View.OnClickListener() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimpleFilePresenter.this.p0(string, view);
                }
            });
            ae.m("exp_qb_appstore", String.valueOf(this.f208460e.V()), FileUtils.getExtension(this.f208460e.L()), string, false);
        }
    }

    public void q0(AppRuntime appRuntime) {
        Intent intent;
        if (PackageUtil.isAppInstalled(this.f208461f, AppConstants.QQMAIL_PACKAGE_NAME)) {
            intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(V + this.f208460e.h0()));
            intent.putExtra("big_brother_source_key", "biz_src_jc_file");
        } else {
            String str = W + appRuntime.getAccount();
            intent = new Intent(this.f208461f, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
        }
        this.f208461f.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t0(SimpleFileViewer simpleFileViewer) {
        super.S(simpleFileViewer);
        this.G = simpleFileViewer;
    }

    public void u0(List<String> list, final String str, boolean z16, int i3) {
        if (!TextUtils.isEmpty(str) && list != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3
                @Override // java.lang.Runnable
                public void run() {
                    String[] split = str.split("\\$");
                    if (split.length == 2) {
                        TeamWorkHandlerUtils.q(SimpleFilePresenter.this.f208460e.B(), split[0], split[1], 1, null);
                    }
                }
            }, 128, null, false);
        }
    }

    public void v0(AppRuntime appRuntime) {
        Bundle bundle = this.D;
        if (bundle == null || this.f208461f == null || this.G == null || bundle.getInt("file_enter_file_browser_type") != 14) {
            return;
        }
        this.G.G().setTag("DaTongControllerButtonReport");
        this.G.Z(this.f208461f.getString(R.string.f172712r7), new a(appRuntime));
        s0();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void w() {
        super.w();
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).b(this.f208461f, 30001);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void x() {
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).onDestroy(this.f208461f);
        if (BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface) {
            ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.T);
        }
        this.P = true;
        SimpleFileViewer simpleFileViewer = this.G;
        if (simpleFileViewer != null) {
            simpleFileViewer.L();
            this.G.n0();
        }
        w0();
        super.x();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void y() {
        super.y();
        this.R = true;
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f208460e.L()).b(this.f208461f, 30002);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void z() {
        ITeamWorkFileImportHandler iTeamWorkFileImportHandler;
        FileBrowserModelBase fileBrowserModelBase;
        super.z();
        if (this.N && this.K && (fileBrowserModelBase = this.f208460e) != null) {
            this.G.q0(fileBrowserModelBase.N(), this.f208460e.P(), this.U);
            FilePreviewDataReporter.f209177a.f(this.f208460e.L(), this.f208460e.V(), this.f208460e.Q());
        }
        this.N = true;
        this.R = false;
        FileBrowserModelBase fileBrowserModelBase2 = this.f208460e;
        if (fileBrowserModelBase2 != null && fileBrowserModelBase2.c0() != null) {
            TeamWorkFileImportInfo c06 = this.f208460e.c0();
            if (c06.c()) {
                if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface) && (iTeamWorkFileImportHandler = (ITeamWorkFileImportHandler) ((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER)) != null && !iTeamWorkFileImportHandler.isFileImporting(c06)) {
                    u.u(c06, "SimpleFilePresenter<FileAssistant>");
                }
            } else if (c06.e() && this.Q) {
                this.Q = false;
                u.c(c06);
            }
        }
        FileBrowserModelBase fileBrowserModelBase3 = this.f208460e;
        if (fileBrowserModelBase3 != null) {
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(fileBrowserModelBase3.L()).b(this.f208461f, 30003);
        }
    }

    /* loaded from: classes12.dex */
    class b implements LocalTbsViewManager.e {
        b() {
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void b(boolean z16) {
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = SimpleFilePresenter.this.f208462h;
            if (gVar != null) {
                gVar.b(z16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void c(boolean z16) {
            com.tencent.mobileqq.filemanager.fileviewer.h hVar;
            if (ImmersiveUtils.isSupporImmersive() == 1 && (hVar = SimpleFilePresenter.this.f208463i) != null) {
                hVar.D();
            }
            if (z16) {
                if (SimpleFilePresenter.this.f208460e.V() == 10) {
                    n.b(SimpleFilePresenter.this.f208460e.Q());
                }
                SimpleFilePresenter simpleFilePresenter = SimpleFilePresenter.this;
                simpleFilePresenter.G.a0(simpleFilePresenter.f208460e.N(), SimpleFilePresenter.this.f208460e.P(), this);
                SimpleFilePresenter.this.K = true;
                SimpleFilePresenter.this.i0();
                SimpleFilePresenter.this.F = false;
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void d(View view) {
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = SimpleFilePresenter.this.f208462h;
            if (gVar != null) {
                gVar.d(view);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public View e() {
            SimpleFilePresenter simpleFilePresenter = SimpleFilePresenter.this;
            return simpleFilePresenter.G.H(simpleFilePresenter.f208460e.c0());
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void f() {
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = SimpleFilePresenter.this.f208462h;
            if (gVar != null) {
                gVar.R1();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void g(boolean z16) {
            SimpleFilePresenter.this.x0(z16);
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public boolean h() {
            com.tencent.mobileqq.filemanager.fileviewer.g gVar = SimpleFilePresenter.this.f208462h;
            if (gVar != null) {
                return gVar.isFullScreen();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void a(String str, Drawable drawable, Drawable drawable2, View.OnClickListener onClickListener) {
        }
    }
}
