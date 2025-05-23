package com.tencent.qqmini.sdk.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ShareProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.ShareData;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ShareTransitiveFragment extends MiniBaseFragment {
    private static final int INVALID_TASK_ID = -1;
    private static final String TAG = "ShareTransitiveFragment";
    private boolean mIsAlreadyResumed;
    private int mOriginTaskId;
    private ShareData mShareData;
    private ShareProxy mShareProxy = (ShareProxy) ProxyManager.get(ShareProxy.class);

    private void finish() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private Intent getIntent() {
        if (getActivity() == null) {
            return null;
        }
        return getActivity().getIntent();
    }

    private void moveTaskToFront(int i3, boolean z16) {
        if (!z16 && i3 != -1) {
            try {
                ((ActivityManager) getActivity().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).moveTaskToFront(i3, 1);
                return;
            } catch (Exception e16) {
                QMLog.w(TAG, "Failed to moveTaskToFront", e16);
                QMLog.i(TAG, "Restart mini app");
                MiniAppLauncher.launchMiniApp(getActivity(), this.mShareData.getMiniAppId(), (LaunchParam) null, (ResultReceiver) null);
                return;
            }
        }
        QMLog.w(TAG, "Invalid task id, restart mini app");
        MiniAppLauncher.launchMiniApp(getActivity(), this.mShareData.getMiniAppId(), (LaunchParam) null, (ResultReceiver) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        QMLog.i(TAG, "onActivityResult() requestCode=" + i3 + " ,resultCode=" + i16);
        this.mShareProxy.onShareActivityResult(i3, i16, intent);
        if (i16 == -1) {
            moveTaskToFront(this.mOriginTaskId, true);
        } else if (i3 == 10104 && i16 == 0) {
            moveTaskToFront(this.mOriginTaskId, true);
        }
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        QMLog.i(TAG, "onCreate()");
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        try {
            this.mOriginTaskId = intent.getIntExtra(IPCConst.KEY_ORIGIN_TASK_ID, -1);
            this.mShareData = (ShareData) intent.getParcelableExtra(IPCConst.KEY_SHARE_DATA);
            this.mShareProxy.share(getActivity(), this.mShareData);
        } catch (Exception e16) {
            QMLog.e(TAG, "Failed to share", e16);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mIsAlreadyResumed) {
            this.mIsAlreadyResumed = true;
            return;
        }
        QMLog.i(TAG, "Finish self when second time onResume");
        moveTaskToFront(this.mOriginTaskId, true);
        finish();
    }
}
