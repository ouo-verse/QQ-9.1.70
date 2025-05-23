package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h extends g implements View.OnClickListener, FileBrowserModelBase.d {
    protected boolean X;
    protected long Y;
    private boolean Z;

    public h(FileBrowserModelBase fileBrowserModelBase, Activity activity) {
        super(fileBrowserModelBase, activity);
        this.X = false;
        this.Y = 0L;
        this.Z = false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.g, com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter, com.tencent.mobileqq.filemanager.fileviewer.presenter.FileBrowserPresenterBase
    public void K() {
        super.K();
        this.G.m0(false);
        if (this.f208460e.G0(this) && QLog.isColorLevel()) {
            QLog.d("PreviewVideoSimpleFilePresenter", 2, "requestWhitelist \u672c\u5730\u4fe1\u606f\u4e3a\u7a7a!!!!");
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.d
    public void b() {
        if (this.X) {
            return;
        }
        this.X = true;
        this.G.m0(true);
        if (QLog.isDevelopLevel()) {
            QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
        }
        this.f208460e.E0(4);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.d
    public void n() {
        this.f208461f.getString(R.string.beu);
        this.Z = true;
        n0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.presenter.g, com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter
    public void n0() {
        this.G.i0(this.Z);
        if (FileUtils.fileExistsAndNotEmpty(this.f208460e.N())) {
            super.n0();
        } else if (this.Z) {
            this.G.Z(this.f208461f.getString(R.string.beu), this);
            this.G.i0(this.Z);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.d
    public void o() {
        com.tencent.mobileqq.filemanager.util.d.e(R.string.hl9);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (System.currentTimeMillis() - this.Y < 500) {
            if (QLog.isColorLevel()) {
                QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
            }
        } else {
            this.Y = System.currentTimeMillis();
            if (this.f208460e.n0()) {
                QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.qqStr(R.string.pcx), 0).show(this.f208460e.e0());
            } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                com.tencent.mobileqq.filemanager.util.d.e(R.string.b_o);
            } else {
                this.f208460e.F0(this);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.d
    public void s(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("PreviewVideoSimpleFilePresenter", 2, "clickPlay url = " + str + ", cookie = " + str2);
        }
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, this.f208460e.z());
            intent.putExtra("url", str);
            intent.putExtra("cookie", str2);
            intent.putExtra("public_fragment_window_feature", 1);
            PublicFragmentActivity.b.a(this.f208461f, intent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
        }
        this.f208460e.E0(3);
    }
}
