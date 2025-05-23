package com.tencent.mobileqq.filebrowser.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.ae;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class n extends DocFilePresenter {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) n.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, ae.e(n.this.f205964e.getFileType()) + "", "", "", "");
                n.this.f205963d.k();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public n(com.tencent.mobileqq.filebrowser.e eVar, Activity activity) {
        super(eVar, activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) activity);
        }
    }

    private boolean t0(Context context, String str, long j3) {
        if (((IFMConfig) QRoute.api(IFMConfig.class)).getPreviewConfig(context, str, "FileMaxSize") == null || Integer.parseInt(r3) * 1048576 < j3) {
            return false;
        }
        return true;
    }

    private void u0() {
        if (this.f205964e.b() == 10014) {
            this.H.L(this.f205963d.R());
        }
        if (this.f205964e.getTroopUin() == 0) {
            this.H.L(false);
        }
    }

    private boolean v0() {
        if (this.f205963d.Z()) {
            return false;
        }
        if (!t0(this.f205966h, this.f205964e.getFileName(), this.f205964e.getFileSize()) && !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDoc(TencentDocPreviewConfigProcessor.c().a(), this.f205964e.getFilePath(), this.f205964e.getFileName(), this.f205964e.getFileSize())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter, com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter, com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase
    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.H();
        if (QLog.isColorLevel()) {
            QLog.i("DocFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
        }
        if (!TextUtils.isEmpty(this.f205963d.p()) && 16 != this.f205964e.c()) {
            this.H.B(this.f205963d.p());
        } else {
            this.H.K(false);
        }
        if (this.f205964e.c() == 16) {
            this.H.J(this.f205966h.getString(R.string.b7d));
        } else if (this.f205963d.g0()) {
            this.H.J(this.f205966h.getString(R.string.b_t));
        }
        Y();
        this.H.N(true ^ this.f205963d.V());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filebrowser.presenter.SimpleFilePresenter
    public void Y() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f205964e.c() != 16 && !this.f205963d.g0()) {
            if (FileUtils.fileExistsAndNotEmpty(this.f205964e.getFilePath())) {
                super.Y();
                return;
            }
            if (NetworkUtil.isNetSupport(this.f205966h) && v0()) {
                Bundle bundle = this.D;
                if (bundle != null) {
                    z16 = bundle.getBoolean("hide_online_preview_button");
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.H.L(false);
                    return;
                }
                this.H.F(this.f205966h.getString(R.string.beu), new a());
                u0();
            }
        }
    }
}
