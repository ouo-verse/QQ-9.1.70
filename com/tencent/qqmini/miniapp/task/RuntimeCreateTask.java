package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;

/* compiled from: P */
@ClassTag(tag = RuntimeCreateTask.TAG)
/* loaded from: classes23.dex */
public class RuntimeCreateTask extends AsyncTask {
    public static final String TAG = "RuntimeCreateTask";

    public RuntimeCreateTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        MiniAppReportManager2.reportLaunchPiecewise(200, "", getRuntimeLoader().getMiniAppInfoForReport());
        try {
            getRuntimeLoader().getRuntime().onRuntimeCreate();
            onTaskSucceed();
        } catch (Throwable th5) {
            QMLog.e(TAG, "onRuntimeCreate exception!", th5);
            onTaskFailed();
        }
    }

    public BaseAppBrandRuntime getAppBrandRuntime() {
        return (BaseAppBrandRuntime) getRuntimeLoader().getRuntime();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        super.onTaskSucceed();
        MiniAppReportManager2.reportLaunchPiecewise(201, "", getRuntimeLoader().getMiniAppInfoForReport());
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void reset() {
        super.reset();
    }
}
