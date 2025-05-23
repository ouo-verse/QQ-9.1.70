package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask;

/* compiled from: P */
@ClassTag(tag = BaselibVersionCheckTask.TAG)
/* loaded from: classes23.dex */
public class BaselibVersionCheckTask extends AsyncTask {
    public static final String TAG = "BaselibVersionCheckTask";
    private boolean mVersionUpdated;

    public BaselibVersionCheckTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
        this.mVersionUpdated = false;
    }

    private void checkBaseLibVersionMatch(final MiniAppInfo miniAppInfo, BaselibLoader.BaselibContent baselibContent) {
        boolean z16;
        if (baselibContent != null && miniAppInfo != null && !TextUtils.isEmpty(baselibContent.version) && !TextUtils.isEmpty(miniAppInfo.baselibMiniVersion)) {
            String str = miniAppInfo.baselibMiniVersion;
            String str2 = baselibContent.version;
            QMLog.i(TAG, "checkBaseLibVersionMatch current:" + str2 + ",need:" + str);
            if (TextUtils.isEmpty(str2)) {
                z16 = true;
            } else if (!TextUtils.isEmpty(str)) {
                z16 = BaseLibInfo.needUpdateVersion(str, str2);
            } else {
                z16 = false;
            }
            if (!z16) {
                QMLog.i(TAG, "no need to update baselib!");
                onTaskSucceed();
                return;
            } else if (this.mVersionUpdated) {
                QMLog.w(TAG, "baselib has checked before!");
                onTaskFailed();
                return;
            } else {
                this.mVersionUpdated = true;
                QMLog.w(TAG, "need update baselib!");
                AppBrandCmdProxy.g().sendCmd("cmd_update_baselib", new Bundle(), new MiniCmdCallback.Stub() { // from class: com.tencent.qqmini.miniapp.task.BaselibVersionCheckTask.1
                    @Override // com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback
                    public void onCmdResult(boolean z17, Bundle bundle) throws RemoteException {
                        if (z17) {
                            String string = StorageUtil.getPreference().getString("version", "1.74.3.00001");
                            QMLog.i(BaselibVersionCheckTask.TAG, "updateBaseLib succ. version=" + string);
                            if (miniAppInfo != null && (TextUtils.isEmpty(string) || BaseLibInfo.needUpdateVersion(miniAppInfo.baselibMiniVersion, string))) {
                                BaselibVersionCheckTask.this.onTaskFailed(13, "APP\u7248\u672c\u9700\u5347\u7ea7");
                                return;
                            } else {
                                BaselibVersionCheckTask.this.onTaskFailed(12, "\u57fa\u7840\u5e93\u7248\u672c\u66f4\u65b0");
                                return;
                            }
                        }
                        QMLog.e(BaselibVersionCheckTask.TAG, "updateBaseLib fail.");
                        BaselibVersionCheckTask.this.onTaskFailed(11, "\u57fa\u7840\u5e93\u66f4\u65b0\u5931\u8d25");
                    }
                });
                return;
            }
        }
        QMLog.e(TAG, "version is empty, escape verison check!");
        onTaskSucceed();
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        checkBaseLibVersionMatch(((MiniAppInfoLoadTask) getRuntimeLoader().getTask(MiniAppInfoLoadTask.class)).getMiniAppInfo(), ((BaselibLoadAsyncTask) getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent());
    }
}
