package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g extends SimpleFilePresenter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ReportController.o(null, "dc00898", "", "", "0X800A689", "0X800A689", 0, 0, QFileUtils.G(g.this.f208460e.V()) + "", "", "", "");
            g.this.f208460e.z0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public g(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
    }

    private boolean y0() {
        if (!FileManagerUtil.canPreview(this.f208461f.getBaseContext(), this.f208460e.L(), this.f208460e.Q()) && !((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(this.f208460e.N(), this.f208460e.L(), this.f208460e.Q())) {
            return false;
        }
        return true;
    }

    private boolean z0() {
        if (y0() && !this.f208460e.u0()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        if (QLog.isColorLevel()) {
            QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = preview simple");
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
        n0();
        this.G.m0(true ^ this.f208460e.d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
    public void n0() {
        boolean z16;
        if (this.f208460e.R() != 16 && !this.f208460e.q0()) {
            if (FileUtils.fileExistsAndNotEmpty(this.f208460e.N())) {
                super.n0();
                return;
            }
            if (NetworkUtil.isNetSupport(BaseApplication.getContext()) && z0()) {
                Bundle bundle = this.D;
                if (bundle != null) {
                    z16 = bundle.getBoolean("hide_online_preview_button");
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.G.i0(false);
                } else {
                    this.G.Z(this.f208461f.getString(R.string.beu), new a());
                }
            }
        }
    }
}
