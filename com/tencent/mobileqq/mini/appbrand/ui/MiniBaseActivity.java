package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniBaseActivity extends BaseActivity {
    private final MiniEIPCCallback mMiniEIPCCallback = new MiniEIPCCallback(this);

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class MiniEIPCCallback implements EIPCResultCallback {
        private final WeakReference<MiniBaseActivity> mBaseActivityWeakReference;

        public MiniEIPCCallback(MiniBaseActivity miniBaseActivity) {
            this.mBaseActivityWeakReference = new WeakReference<>(miniBaseActivity);
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            Bundle bundle;
            MiniBaseActivity miniBaseActivity = this.mBaseActivityWeakReference.get();
            if (miniBaseActivity == null || eIPCResult == null || (bundle = eIPCResult.data) == null || bundle.getInt(MiniChatConstants.PARAM_CMD) != 0 || eIPCResult.code != 0) {
                return;
            }
            Bundle bundle2 = eIPCResult.data;
            if (QLog.isDevelopLevel()) {
                QLog.i("MiniMsgIPCServer", 2, "doRefreshMiniBadge COUNT = " + bundle2.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT));
            }
            miniBaseActivity.doRefreshMiniBadge(bundle2);
        }
    }

    public void onProcessBackground(Bundle bundle) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_PROC_BACKGROUND, bundle, this.mMiniEIPCCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProcessForeGround(Bundle bundle) {
        if (QLog.isDevelopLevel()) {
            QLog.i("MiniMsgIPCServer", 4, "onProcessForeGround" + bundle.toString());
        }
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_PROC_FOREGROUND, bundle, this.mMiniEIPCCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRefreshMiniBadge(Bundle bundle) {
        QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_REFRESH_MINI_BADGE, bundle, this.mMiniEIPCCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doRefreshMiniBadge(Bundle bundle) {
    }
}
