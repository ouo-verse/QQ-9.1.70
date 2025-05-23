package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class TroopFileDetailBrowserActivity extends FileBrowserActivity {
    protected ForwardFileInfo C0;
    protected FMObserver D0 = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void I0(long j3, boolean z16, int i3, String str) {
            if (!z16) {
                if (str != null && str.length() > 0) {
                    FileManagerUtil.dealWithErrCode(str);
                    return;
                }
                return;
            }
            TroopFileDetailBrowserActivity troopFileDetailBrowserActivity = TroopFileDetailBrowserActivity.this;
            ForwardFileInfo forwardFileInfo = troopFileDetailBrowserActivity.C0;
            if (forwardFileInfo != null && troopFileDetailBrowserActivity.app != null) {
                if (forwardFileInfo.n() != j3) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("FileBrowserActivity<FileAssistant>", 4, "difference nSessionId");
                    }
                } else if (TroopFileDetailBrowserActivity.this.app.getFileManagerDataCenter().M(j3) == null) {
                    QLog.e("FileBrowserActivity<FileAssistant>", 1, "OnTroopFileCopyToC2cDisc->,but entity is null SessionId[" + j3 + "]");
                }
            }
        }
    }

    private int n3(Context context) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            return 2;
        }
        if (NetworkUtil.isWifiConnected(context)) {
            return 0;
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity, com.tencent.mobileqq.filemanager.fileviewer.g
    public boolean N() {
        if (getIntent() != null && getIntent().getIntExtra("from_type_troop", -1) == 3) {
            return true;
        }
        return super.N();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
    protected boolean S2(Intent intent) {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.getFileManagerNotifyCenter().addObserver(this.D0);
        }
        o oVar = new o(this.app);
        if (!oVar.e(intent, this)) {
            return false;
        }
        this.C0 = (ForwardFileInfo) super.getIntent().getParcelableExtra("fileinfo");
        if (this.f208113o0 == null) {
            FileBrowserManager fileBrowserManager = new FileBrowserManager(this, this, oVar.c(this));
            this.f208113o0 = fileBrowserManager;
            fileBrowserManager.I(this.f208124z0);
        }
        if (!this.f208113o0.h(V2(), new RelativeLayout.LayoutParams(-1, -1), intent.getIntExtra("file_enter_file_browser_type", 0), intent.getBundleExtra("file_browser_extra_params"))) {
            if (QLog.isColorLevel()) {
                QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
            }
            return false;
        }
        if (oVar.d() == 1) {
            ReportController.o(this.app, "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.C0.k() + "", this.f208112n0 + "", n3(getApplicationContext()) + "", FileManagerUtil.getReportFileTypeStr(FileManagerUtil.getFileType(this.C0.f())));
        } else {
            ReportController.o(this.app, "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.C0.k() + "", this.f208112n0 + "", n3(getApplicationContext()) + "", FileManagerUtil.getReportFileTypeStr(FileManagerUtil.getFileType(this.C0.f())));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1 && i3 == 10099 && intent != null && intent.getBooleanExtra(AppConstants.Key.IS_NEED_FINISH, false)) {
            finish();
        } else {
            super.doOnActivityResult(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.app.getFileManagerNotifyCenter().deleteObserver(this.D0);
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
