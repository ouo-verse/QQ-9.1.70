package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.utils.PreLoadApkgToStrHelper;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

/* compiled from: P */
@ClassTag(tag = ApkgLoadAsyncTask.TAG)
/* loaded from: classes23.dex */
public class ApkgLoadAsyncTask extends AsyncTask {
    public static final String TAG = "ApkgLoadAsyncTask";
    private boolean enableFlutter;
    private ApkgInfo mApkgInfo;
    private MiniAppInfo mMiniAppInfo;

    public ApkgLoadAsyncTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
        this.enableFlutter = false;
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        loadApkg(getRuntimeLoader().getMiniAppInfo());
    }

    public ApkgInfo getApkgInfo() {
        return this.mApkgInfo;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    public void loadApkg(final MiniAppInfo miniAppInfo) {
        MiniAppReportManager2.reportLaunchPiecewise(206, "", getRuntimeLoader().getMiniAppInfoForReport());
        QMLog.i(BaseRuntimeLoader.TAG, "ApkgLoadAsyncTask start loadApkgByConfig");
        if (miniAppInfo != null) {
            miniAppInfo.launchParam.isFlutterMode = this.enableFlutter;
        }
        if (this.enableFlutter && miniAppInfo != null && miniAppInfo.supportNativeRenderMode()) {
            QMLog.i(BaseRuntimeLoader.TAG, "ApkgLoadAsyncTask use flutter url:" + miniAppInfo.renderInfo.renderMaterialMap.get(1));
            miniAppInfo.downloadUrl = miniAppInfo.renderInfo.renderMaterialMap.get(1);
        }
        PreLoadApkgToStrHelper.getInstance().clearApkgToStrMap();
        PreLoadApkgToStrHelper.getInstance().preloadMainApkgInfoToMap(miniAppInfo);
        ApkgManager.getInstance().getApkgInfoByConfig(miniAppInfo, new ApkgManager.OnInitApkgListener() { // from class: com.tencent.qqmini.miniapp.task.ApkgLoadAsyncTask.1
            @Override // com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener
            public void onInitApkgInfo(int i3, ApkgInfo apkgInfo, String str) {
                if (i3 == 0 && apkgInfo != null) {
                    ApkgLoadAsyncTask.this.mApkgInfo = apkgInfo;
                    ApkgLoadAsyncTask.this.mMiniAppInfo = miniAppInfo;
                    ApkgLoadAsyncTask.this.onTaskSucceed();
                    return;
                }
                ApkgLoadAsyncTask.this.onTaskFailed(i3, str);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        super.onTaskSucceed();
        MiniAppReportManager2.reportLaunchPiecewise(207, "", getRuntimeLoader().getMiniAppInfoForReport());
    }

    public void setFlutterEnable(boolean z16) {
        this.enableFlutter = z16;
    }
}
