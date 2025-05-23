package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter;
import com.tencent.mobileqq.filebrowser.view.DocFileBrowserView;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.util.FilePreviewDataReporter;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.ag;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes12.dex */
public class DocFilePresenter extends SimpleFilePresenter {
    static IPatchRedirector $redirector_;
    private final DocFileBrowserView K;
    private final ag L;
    protected boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private final LocalTbsViewManager.e T;
    private boolean U;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class InnerTeamWorkFileImportObserver extends ag {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter$InnerTeamWorkFileImportObserver$1, reason: invalid class name */
        /* loaded from: classes12.dex */
        public class AnonymousClass1 implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f205958d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TeamWorkFileImportInfo f205959e;

            AnonymousClass1(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
                this.f205958d = str;
                this.f205959e = teamWorkFileImportInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, InnerTeamWorkFileImportObserver.this, str, teamWorkFileImportInfo);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e() {
                if (DocFilePresenter.this.K != null) {
                    DocFilePresenter.this.K.c0();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, Object obj) {
                if (!(obj instanceof JSONObject)) {
                    return;
                }
                DocFilePresenter.this.f205965f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        DocFilePresenter.InnerTeamWorkFileImportObserver.AnonymousClass1.this.e();
                    }
                });
                InnerTeamWorkFileImportObserver.this.j((JSONObject) obj, teamWorkFileImportInfo, str);
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String str = this.f205958d;
                String currentAccountUin = DocFilePresenter.this.f205963d.getCurrentAccountUin();
                final TeamWorkFileImportInfo teamWorkFileImportInfo = this.f205959e;
                final String str2 = this.f205958d;
                TeamWorkHandlerUtils.l(str, currentAccountUin, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.filebrowser.presenter.c
                    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                    public final void a(Object obj) {
                        DocFilePresenter.InnerTeamWorkFileImportObserver.AnonymousClass1.this.f(teamWorkFileImportInfo, str2, obj);
                    }
                });
            }
        }

        InnerTeamWorkFileImportObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocFilePresenter.this);
            }
        }

        private void i(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            ThreadManagerV2.excute(new AnonymousClass1(str, teamWorkFileImportInfo), 128, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) {
            try {
                if (jSONObject.getInt("retcode") != 0) {
                    DocFilePresenter.this.f205965f.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.InnerTeamWorkFileImportObserver.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InnerTeamWorkFileImportObserver.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                            } else {
                                QQToast.makeText(DocFilePresenter.this.f205966h, 1, R.string.i0t, 0).show();
                            }
                        }
                    });
                    if (teamWorkFileImportInfo.b()) {
                        TeamWorkHandlerUtils.e(teamWorkFileImportInfo.f292069c0, DocFilePresenter.this.f205963d.getCurrentAccountUin());
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
                    return;
                }
                k(jSONObject, teamWorkFileImportInfo, str);
            } catch (JSONException e16) {
                ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
                QLog.e("DocFilePresenter", 1, "direct share fail", e16);
                QQToast.makeText(DocFilePresenter.this.f205966h, 1, R.string.i0t, 0).show();
            }
        }

        private void k(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str) throws JSONException {
            if (teamWorkFileImportInfo.a()) {
                DocFilePresenter docFilePresenter = DocFilePresenter.this;
                docFilePresenter.f205963d.v(jSONObject, str, docFilePresenter.f205965f);
                lr2.a.j(null, "0X800A21F");
                return;
            }
            if (teamWorkFileImportInfo.b()) {
                if (!DocFilePresenter.this.R) {
                    long b16 = lr2.a.b(teamWorkFileImportInfo.X + "-" + teamWorkFileImportInfo.J);
                    if (b16 > 0) {
                        ReportController.o(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(b16), "");
                    }
                    ta1.l c16 = TencentDocLocalCooperationProcessor.c();
                    if (c16.c(teamWorkFileImportInfo.f292074f)) {
                        DocFilePresenter.this.K.r0(str, Boolean.FALSE);
                        return;
                    }
                    p(teamWorkFileImportInfo, teamWorkFileImportInfo.f292069c0, c16.b(teamWorkFileImportInfo.f292074f));
                    DocFilePresenter docFilePresenter2 = DocFilePresenter.this;
                    docFilePresenter2.f205963d.h0(jSONObject, str, teamWorkFileImportInfo, docFilePresenter2.f205965f);
                    return;
                }
                TeamWorkHandlerUtils.e(teamWorkFileImportInfo.f292069c0, DocFilePresenter.this.f205963d.getCurrentAccountUin());
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
                    DocFilePresenter.this.K.r0(str, Boolean.FALSE);
                }
                if (DocFilePresenter.this.Q && z16) {
                    DocFilePresenter.this.U = true;
                }
                if (!z16) {
                    p(teamWorkFileImportInfo, teamWorkFileImportInfo.f292085m0, true);
                }
                teamWorkFileImportInfo.f292085m0 = null;
                teamWorkFileImportInfo.f292083l0 = 0;
            }
        }

        private boolean m(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo != null && ((teamWorkFileImportInfo.e() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 0)) {
                return true;
            }
            return false;
        }

        private boolean n(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo != null && ((teamWorkFileImportInfo.e() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 1)) {
                return true;
            }
            return false;
        }

        private boolean o(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            if (teamWorkFileImportInfo != null && ((teamWorkFileImportInfo.a() || teamWorkFileImportInfo.b()) && teamWorkFileImportInfo.Y == 0)) {
                return true;
            }
            return false;
        }

        private void p(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, boolean z16) {
            boolean z17;
            int i3 = teamWorkFileImportInfo.f292070d;
            if ((i3 == 1 || i3 == 0 || i3 == 3000) && !teamWorkFileImportInfo.f292072e.equals(DocFilePresenter.this.f205963d.getCurrentAccountUin())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(teamWorkFileImportInfo.f292072e);
                DocFilePresenter.this.r0(arrayList, str, z16, teamWorkFileImportInfo.f292070d);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) teamWorkFileImportInfo);
                return;
            }
            super.a(teamWorkFileImportInfo);
            if (DocFilePresenter.this.K != null) {
                DocFilePresenter.this.K.c0();
            }
            if (m(teamWorkFileImportInfo)) {
                if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.b()) {
                    ReportController.o(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
                }
                if (teamWorkFileImportInfo != null && !TextUtils.isEmpty(teamWorkFileImportInfo.U)) {
                    if (teamWorkFileImportInfo.T == 20010) {
                        if (DocFilePresenter.this.K != null) {
                            int i3 = teamWorkFileImportInfo.R;
                            if (i3 == 3) {
                                str = FileReaderHelper.DOC_EXT;
                            } else if (i3 == 6) {
                                str = "sheet";
                            } else if (i3 == 7) {
                                str = WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE;
                            } else if (i3 == 9) {
                                str = FileReaderHelper.PDF_EXT;
                            } else {
                                str = "";
                            }
                            DocFilePresenter.this.K.m0(str);
                        }
                    } else {
                        QQToast.makeText(DocFilePresenter.this.f205966h, 1, teamWorkFileImportInfo.U, 0).show();
                    }
                } else {
                    QQToast.makeText(DocFilePresenter.this.f205966h, 1, R.string.i0t, 0).show();
                }
            }
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                lr2.a.j(null, "0X800ABAD");
            }
            if (DocFilePresenter.this.K != null && n(teamWorkFileImportInfo)) {
                DocFilePresenter.this.K.q0(3);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
                return;
            }
            super.b(z16);
            if (DocFilePresenter.this.K != null) {
                DocFilePresenter.this.K.f0(z16);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void c(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
                return;
            }
            super.c(i3);
            if (DocFilePresenter.this.K != null) {
                DocFilePresenter.this.K.u0(i3);
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
            if (o(teamWorkFileImportInfo)) {
                String string = DocFilePresenter.this.f205966h.getString(R.string.f6s);
                if (teamWorkFileImportInfo.b()) {
                    if (!TencentDocLocalCooperationProcessor.c().c(teamWorkFileImportInfo.f292074f)) {
                        DocFilePresenter.this.K.n0(DocFilePresenter.this.f205966h.getString(R.string.zza));
                    }
                } else {
                    DocFilePresenter.this.K.n0(string);
                }
                lr2.a.j(null, "0X800A21E");
            }
            if (n(teamWorkFileImportInfo)) {
                DocFilePresenter.this.K.Z(teamWorkFileImportInfo);
                DocFilePresenter.this.K.q0(1);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) teamWorkFileImportInfo);
                return;
            }
            super.e(str, teamWorkFileImportInfo);
            l(str, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && (teamWorkFileImportInfo.a() || (teamWorkFileImportInfo.b() && teamWorkFileImportInfo.Y == 0))) {
                i(str, teamWorkFileImportInfo);
            } else if (DocFilePresenter.this.K != null) {
                DocFilePresenter.this.K.c0();
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void f(String str, String str2, TeamWorkFileImportInfo teamWorkFileImportInfo) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, str2, teamWorkFileImportInfo);
                return;
            }
            super.f(str, str2, teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && str2 != null && teamWorkFileImportInfo.b()) {
                DocFilePresenter.this.K.r0(str, null);
                DocFilePresenter.this.K.q0(5);
                DocFilePresenter.this.q0(false, teamWorkFileImportInfo.f292070d);
            }
            if (teamWorkFileImportInfo != null && str2 != null && teamWorkFileImportInfo.e()) {
                if (teamWorkFileImportInfo.f292083l0 == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                teamWorkFileImportInfo.f292083l0 = 0;
                DocFilePresenter.this.K.r0(str, Boolean.valueOf(z16));
                DocFilePresenter.this.K.q0(5);
            }
        }

        @Override // com.tencent.mobileqq.teamwork.ag
        public void g(TeamWorkFileImportInfo teamWorkFileImportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) teamWorkFileImportInfo);
                return;
            }
            super.g(teamWorkFileImportInfo);
            if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.b()) {
                DocFilePresenter.this.K.q0(4);
                DocFilePresenter.this.q0(true, teamWorkFileImportInfo.f292070d);
            } else if (teamWorkFileImportInfo != null && teamWorkFileImportInfo.e()) {
                DocFilePresenter.this.K.q0(5);
                lr2.a.j(null, "0X800ABA4");
            }
        }
    }

    /* loaded from: classes12.dex */
    class a implements LocalTbsViewManager.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DocFilePresenter.this);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void a(String str, Drawable drawable, Drawable drawable2, View.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, drawable, drawable2, onClickListener);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
                return;
            }
            com.tencent.mobileqq.filebrowser.d dVar = DocFilePresenter.this.f205967i;
            if (dVar != null) {
                dVar.b(z16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void c(boolean z16) {
            com.tencent.mobileqq.filebrowser.d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
                return;
            }
            if (ImmersiveUtils.isSupporImmersive() == 1 && (dVar = DocFilePresenter.this.f205967i) != null) {
                dVar.D();
            }
            if (z16) {
                if (DocFilePresenter.this.f205964e.getFileType() == 10) {
                    ae.o(DocFilePresenter.this.f205964e.getFileSize());
                }
                DocFilePresenter.this.K.j0(DocFilePresenter.this.f205964e.getFilePath(), DocFilePresenter.this.f205964e.getSessionId(), this);
                DocFilePresenter.this.S = true;
                DocFilePresenter.this.p0();
                DocFilePresenter docFilePresenter = DocFilePresenter.this;
                docFilePresenter.M = false;
                docFilePresenter.K.j();
                com.tencent.mobileqq.filebrowser.d dVar2 = DocFilePresenter.this.f205967i;
                if (dVar2 != null) {
                    dVar2.C0();
                }
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void d(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.mobileqq.filebrowser.d dVar = DocFilePresenter.this.f205967i;
            if (dVar != null) {
                dVar.d(view);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public View e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (View) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return DocFilePresenter.this.K.Z(DocFilePresenter.this.f205963d.K());
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            com.tencent.mobileqq.filebrowser.d dVar = DocFilePresenter.this.f205967i;
            if (dVar != null) {
                dVar.S();
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public void g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                DocFilePresenter.this.s0(z16);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.e
        public boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return DocFilePresenter.this.N;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
    }

    public DocFilePresenter(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
            return;
        }
        this.L = new InnerTeamWorkFileImportObserver();
        this.M = true;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = new a();
        this.U = false;
        DocFileBrowserView docFileBrowserView = new DocFileBrowserView(activity, this.f205964e.getFileName());
        this.K = docFileBrowserView;
        b0(docFileBrowserView);
    }

    private void o0(int i3, boolean z16) {
        com.tencent.mobileqq.tbstool.gray.b bVar = com.tencent.mobileqq.tbstool.gray.b.f291450a;
        if (bVar.e(this.f205964e.getFileName()).g()) {
            bVar.e(this.f205964e.getFileName()).a(true);
            this.f205963d.G(i3);
            TeamWorkFileImportInfo K = this.f205963d.K();
            K.Q = z16;
            com.tencent.mobileqq.teamwork.u.c(K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).a(false);
        if (this.S && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).targetTencentDocFormKeyWords(this.f205964e.getFilePath(), this.f205964e.getFileName(), this.f205964e.getFileSize())) {
            o0(13, false);
            return;
        }
        if (this.S && ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDocForLocalCooperation(this.f205964e.getFilePath(), this.f205964e.getFileName(), this.f205964e.getFileSize())) {
            o0(11, TencentDocLocalCooperationProcessor.c().c(this.f205964e.getFileName()));
        } else if (this.f205963d.o()) {
            TeamWorkFileImportInfo K = this.f205963d.K();
            com.tencent.mobileqq.teamwork.u.v(K);
            this.K.o0(K);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(boolean z16, int i3) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(boolean z16) {
        this.N = z16;
        com.tencent.mobileqq.filebrowser.d dVar = this.f205967i;
        if (dVar != null) {
            dVar.g(z16);
        }
        if (z16 && this.K.e0()) {
            this.K.b0();
        } else if (!z16) {
            if (this.K.a0() != null || this.f205963d.o()) {
                this.K.o0(this.f205963d.K());
            }
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.M;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.H();
            n0();
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void K(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.K(i3, i16, intent);
        if (i3 == 2864) {
            if (i16 == 0) {
                TeamWorkFileImportInfo K = this.f205963d.K();
                if (K != null && K.f292069c0 != null) {
                    ThreadManagerV2.excute(new Runnable(K) { // from class: com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TeamWorkFileImportInfo f205955d;

                        {
                            this.f205955d = K;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DocFilePresenter.this, (Object) K);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                TeamWorkHandlerUtils.e(this.f205955d.f292069c0, DocFilePresenter.this.f205963d.getCurrentAccountUin());
                            }
                        }
                    }, 128, null, false);
                }
            } else if (i16 == -1) {
                lr2.a.j(null, "0X800A5A4");
                lr2.a.j(null, "0X800A5A3");
                TeamWorkFileImportInfo K2 = this.f205963d.K();
                if (K2 == null) {
                    return;
                }
                this.K.r0(((ITeamWorkFileImportHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).getUrlFromConvertedMap(K2), "open");
                Bundle extras = intent.getExtras();
                String string = extras.getString("uin");
                int i17 = extras.getInt("uintype", 0);
                if (K2.f292069c0 != null) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(string);
                    r0(arrayList, K2.f292069c0, TencentDocLocalCooperationProcessor.c().b(K2.f292074f), i17);
                }
            }
        }
        ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).checkDirectShareChangePolicy(i3, i16, intent, this.f205963d.K());
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void L(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) configuration);
            return;
        }
        super.L(configuration);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f205965f.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.K.i0(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    protected void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.c().a(), this.f205964e.getFilePath(), this.f205964e.getFileName(), this.f205964e.getFileSize())) {
            this.f205963d.G(7);
            com.tencent.mobileqq.teamwork.u.u(this.f205963d.K(), "DocFilePresenter");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f205963d.O() == 2) {
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).i(this.f205965f, this.f205964e.getFilePath(), this.T, true);
            FilePreviewDataReporter.f209177a.f(this.f205964e.getFileName(), this.f205964e.getFileType(), this.f205964e.getFileSize());
        }
        super.X();
    }

    void n0() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof AppInterface) {
            ((AppInterface) waitAppRuntime).addObserver(this.L);
        }
    }

    public void r0(List<String> list, String str, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, list, str, Boolean.valueOf(z16), Integer.valueOf(i3));
        } else if (!TextUtils.isEmpty(str) && list != null) {
            ThreadManagerV2.excute(new Runnable(str) { // from class: com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f205956d;

                {
                    this.f205956d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DocFilePresenter.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String[] split = this.f205956d.split("\\$");
                    if (split.length == 2) {
                        TeamWorkHandlerUtils.q(DocFilePresenter.this.f205963d.getCurrentAccountUin(), split[0], split[1], 1, null);
                    }
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.s();
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).b(this.f205965f, 30001);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).onDestroy(this.f205965f);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof AppInterface) {
            ((AppInterface) waitAppRuntime).removeObserver(this.L);
        }
        this.R = true;
        DocFileBrowserView docFileBrowserView = this.K;
        if (docFileBrowserView != null) {
            docFileBrowserView.c0();
            this.K.p0();
        }
        super.t();
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.u();
        this.Q = true;
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).b(this.f205965f, 30002);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void v() {
        TeamWorkFileImportInfo K;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.v();
        if (this.P && this.S) {
            FilePreviewDataReporter.f209177a.f(this.f205964e.getFileName(), this.f205964e.getFileType(), this.f205964e.getFileSize());
            this.K.s0(this.f205964e.getFilePath(), this.f205964e.getSessionId(), this.T);
        }
        this.P = true;
        this.Q = false;
        com.tencent.mobileqq.filebrowser.e eVar = this.f205963d;
        if (eVar == null || (K = eVar.K()) == null) {
            return;
        }
        if (K.c()) {
            if (!((ITeamWorkFileImportHandler) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())).isFileImporting(K)) {
                com.tencent.mobileqq.teamwork.u.u(K, "DocFilePresenter");
            }
        } else if (K.e() && this.U) {
            this.U = false;
            com.tencent.mobileqq.teamwork.u.c(K);
        }
        com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).b(this.f205965f, 30003);
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.w();
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).b(this.f205965f, 30004);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.x();
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).b(this.f205965f, 30005);
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.y();
            com.tencent.mobileqq.tbstool.gray.b.f291450a.e(this.f205964e.getFileName()).e(this.f205965f);
        }
    }
}
