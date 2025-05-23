package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;

@ClassTag(tag = PageCreateTask.TAG)
/* loaded from: classes23.dex */
public class PageCreateTask extends MainThreadTask {
    public static final String TAG = "PageCreateTask";
    private AppBrandPageContainer mPageContainer;

    public PageCreateTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.MainThreadTask
    public void executeInMainThread() {
        LaunchParam launchParam;
        if (getRuntimeLoader().getRuntime() == null) {
            QMLog.w(TAG, "runtime is null!");
            onTaskSucceed();
            return;
        }
        IPage page = getRuntimeLoader().getRuntime().getPage();
        if (!(page instanceof AppBrandPageContainer)) {
            QMLog.w(TAG, "PageContainer type is incorrect! page=" + page);
            onTaskSucceed();
            return;
        }
        try {
            this.mPageContainer = (AppBrandPageContainer) page;
            MiniAppInfo miniAppInfo = getRuntimeLoader().getMiniAppInfo();
            if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null && launchParam.entryModel != null) {
                this.mPageContainer.setEntryMode(getRuntimeLoader().getMiniAppInfo().launchParam.entryModel);
            }
            this.mPageContainer.init(null);
            onTaskSucceed();
        } catch (Throwable th5) {
            QMLog.e(TAG, "pageContainer init exception!", th5);
            onTaskFailed(10, "Page\u521b\u5efa\u5931\u8d25");
        }
    }

    public AppBrandPageContainer getPageContainer() {
        return this.mPageContainer;
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void reset() {
        super.reset();
        try {
            AppBrandPageContainer appBrandPageContainer = this.mPageContainer;
            if (appBrandPageContainer != null) {
                appBrandPageContainer.recyclePreLoadAppBrandPage();
                this.mPageContainer = null;
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, "PageCreateTask reset exception!", th5);
        }
    }
}
