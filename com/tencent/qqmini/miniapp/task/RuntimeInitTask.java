package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.MainThreadTask;

/* compiled from: P */
@ClassTag(tag = "RuntimeInitTask")
/* loaded from: classes23.dex */
public class RuntimeInitTask extends MainThreadTask {
    private BaseAppBrandRuntime appBrandRuntime;

    public RuntimeInitTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.MainThreadTask
    public void executeInMainThread() {
        MiniAppReportManager2.reportLaunchPiecewise(202, "", getRuntimeLoader().getMiniAppInfoForReport());
        MiniAppInfo miniAppInfo = getRuntimeLoader().getMiniAppInfo();
        IAppBrandService appBrandService = getAppBrandService();
        BaseAppBrandRuntime baseAppBrandRuntime = (BaseAppBrandRuntime) getRuntimeLoader().getRuntime();
        this.appBrandRuntime = baseAppBrandRuntime;
        if (baseAppBrandRuntime != null && appBrandService != null && miniAppInfo != null) {
            baseAppBrandRuntime.init(appBrandService);
            this.appBrandRuntime.loadMiniApp(miniAppInfo);
            appBrandService.setApkgInfo((ApkgInfo) miniAppInfo.apkgInfo);
            onTaskSucceed();
            return;
        }
        onTaskFailed();
    }

    @Override // com.tencent.qqmini.sdk.task.MainThreadTask
    public void executeStartTime() {
        MiniAppReportManager2.reportLaunchPiecewise(222, "", getRuntimeLoader().getMiniAppInfoForReport());
    }

    public BaseAppBrandRuntime getAppBrandRuntime() {
        return this.appBrandRuntime;
    }

    protected IAppBrandService getAppBrandService() {
        ServiceInitTask serviceInitTask = (ServiceInitTask) getRuntimeLoader().getTask(ServiceInitTask.class);
        if (serviceInitTask != null) {
            return serviceInitTask.getJsService();
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        super.onTaskSucceed();
        MiniAppReportManager2.reportLaunchPiecewise(203, "", getRuntimeLoader().getMiniAppInfoForReport());
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        if (channelProxy != null) {
            channelProxy.onInitFinish();
        }
    }
}
