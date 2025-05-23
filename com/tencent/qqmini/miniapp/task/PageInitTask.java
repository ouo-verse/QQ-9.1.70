package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

@ClassTag(tag = PageInitTask.TAG)
/* loaded from: classes23.dex */
public class PageInitTask extends AsyncTask {
    public static final String TAG = "PageInitTask";

    public PageInitTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
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
        BaselibLoader.BaselibContent baselibContent = ((BaselibLoadAsyncTask) getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
        if (baselibContent != null && baselibContent.isBaseLibInited()) {
            try {
                ((AppBrandPageContainer) page).initBaseJs(baselibContent);
                onTaskSucceed();
                return;
            } catch (Throwable th5) {
                QMLog.e(TAG, "pageContainer init exception!", th5);
                onTaskFailed(10, "Page\u521b\u5efa\u5931\u8d25");
                return;
            }
        }
        QMLog.w(TAG, "Baselib is not inited!");
        onTaskSucceed();
    }
}
