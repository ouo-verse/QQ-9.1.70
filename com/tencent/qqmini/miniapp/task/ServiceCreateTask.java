package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandRemoteService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandWebviewService;
import com.tencent.qqmini.miniapp.core.service.AppV8JsService;
import com.tencent.qqmini.miniapp.util.V8Utils;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DebugInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import com.tencent.smtt.sdk.JsVirtualMachine;
import com.tencent.smtt.sdk.QbSdk;

/* compiled from: P */
@ClassTag(tag = ServiceCreateTask.TAG)
/* loaded from: classes23.dex */
public class ServiceCreateTask extends AsyncTask {
    public static final String SERVICE_TYPE_V8 = "v8";
    public static final String SERVICE_TYPE_WEBVIEW = "webview";
    public static final String SERVICE_TYPE_X5 = "x5";
    public static final String TAG = "ServiceCreateTask";
    BaseRuntime appBrandRuntime;
    private AbsAppBrandService customJsService;
    private long endTimestamp;
    JsVirtualMachine jsVirtualMachine;
    private long startTimestamp;

    public ServiceCreateTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
        this.startTimestamp = 0L;
        this.endTimestamp = 0L;
    }

    private static boolean canDebug(BaseRuntime baseRuntime) {
        MiniAppInfo miniAppInfo;
        DebugInfo debugInfo;
        if (baseRuntime == null || (miniAppInfo = baseRuntime.getMiniAppInfo()) == null || (debugInfo = miniAppInfo.debugInfo) == null || TextUtils.isEmpty(debugInfo.wsUrl) || TextUtils.isEmpty(miniAppInfo.debugInfo.roomId)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createWebviewService() {
        try {
            QMLog.i(TAG, "AppBrandWebviewService create start");
            onServiceCreateSucc(new AppBrandWebviewService(this.appBrandRuntime, null));
        } catch (Throwable th5) {
            QMLog.e(TAG, "AppBrandWebviewService execute exception!", th5);
            onTaskFailed();
        }
    }

    private boolean onV8ServiceCreateTaskSuc() {
        try {
            QMLog.i(TAG, "AppV8JsService create start");
            onServiceCreateSucc(new AppV8JsService(this.appBrandRuntime));
            reportServiceType(650, "v8");
            return true;
        } catch (Exception e16) {
            QMLog.i(TAG, "run service by v8 failed", e16);
            MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 151, "0", "", "", "", Log.getStackTraceString(e16));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportServiceType(final int i3, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.task.ServiceCreateTask.3
            @Override // java.lang.Runnable
            public void run() {
                MiniReportManager.reportEventType(ReportConst.miniAppConfigForPreload(), i3, "0", str, null, null, null);
            }
        });
    }

    private void tbsServiceCreate() {
        int tbsVersion = QbSdk.getTbsVersion(getContext());
        int tmpDirTbsVersion = QbSdk.getTmpDirTbsVersion(getContext());
        if (tbsVersion <= 0 && tmpDirTbsVersion <= 0) {
            QMLog.i(TAG, "createWebviewService create start");
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqmini.miniapp.task.ServiceCreateTask.2
                @Override // java.lang.Runnable
                public void run() {
                    ServiceCreateTask.this.createWebviewService();
                    ServiceCreateTask.this.reportServiceType(650, "webview");
                }
            });
            return;
        }
        try {
            QMLog.i(TAG, "AppBrandService create start");
            final AppBrandService appBrandService = new AppBrandService(this.appBrandRuntime, null);
            appBrandService.initFramework(getContext(), new StateMachine.OnStateChangeListener() { // from class: com.tencent.qqmini.miniapp.task.ServiceCreateTask.1
                @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener
                public void onStateChanged() {
                    StateMachine.State state;
                    AppBrandService appBrandService2 = appBrandService;
                    if (appBrandService2 != null) {
                        state = appBrandService2.getCurrState();
                    } else {
                        state = null;
                    }
                    if (state == null) {
                        return;
                    }
                    AppBrandService appBrandService3 = appBrandService;
                    if (state == appBrandService3.stateInitFailed) {
                        QMLog.e(ServiceCreateTask.TAG, "init AppBrandService error! change to AppBrandWebviewService.");
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.qqmini.miniapp.task.ServiceCreateTask.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ServiceCreateTask.this.createWebviewService();
                            }
                        });
                    } else if (state == appBrandService3.stateInited) {
                        ServiceCreateTask.this.onServiceCreateSucc(appBrandService3);
                    }
                }
            });
            reportServiceType(650, SERVICE_TYPE_X5);
        } catch (Throwable th5) {
            QMLog.e(TAG, "ServiceCreateTask JsCore execute exception!", th5);
        }
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        MiniAppInfo miniAppInfo;
        BaseAppBrandRuntime baseAppBrandRuntime;
        QMLog.i(TAG, "ServiceCreateTask executeAsync");
        BaseRuntime baseRuntime = this.appBrandRuntime;
        if (baseRuntime != null) {
            miniAppInfo = baseRuntime.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        MiniReportManager.reportEventType(miniAppInfo, 100, "0");
        this.startTimestamp = System.currentTimeMillis();
        RuntimeCreateTask runtimeCreateTask = (RuntimeCreateTask) getRuntimeLoader().getTask(RuntimeCreateTask.class);
        if (runtimeCreateTask != null) {
            baseAppBrandRuntime = runtimeCreateTask.getAppBrandRuntime();
        } else {
            baseAppBrandRuntime = null;
        }
        this.appBrandRuntime = baseAppBrandRuntime;
        boolean checkEnableV8 = V8Utils.checkEnableV8();
        if (canDebug(this.appBrandRuntime)) {
            QMLog.i(TAG, "AppBrandRemoteService create start");
            onServiceCreateSucc(new AppBrandRemoteService(this.appBrandRuntime, null));
        } else {
            if (checkEnableV8 && onV8ServiceCreateTaskSuc()) {
                return;
            }
            tbsServiceCreate();
        }
    }

    public long getCreateTime() {
        return this.endTimestamp - this.startTimestamp;
    }

    public AbsAppBrandService getJsService() {
        return this.customJsService;
    }

    public boolean isTbsFallback(Context context) {
        if (this.jsVirtualMachine == null) {
            this.jsVirtualMachine = new JsVirtualMachine(context);
        }
        return this.jsVirtualMachine.isFallback();
    }

    protected synchronized void onServiceCreateSucc(AbsAppBrandService absAppBrandService) {
        QMLog.i(TAG, "onServiceCreateSucc service:" + absAppBrandService);
        if (this.customJsService == null && absAppBrandService != null) {
            this.customJsService = absAppBrandService;
            this.endTimestamp = System.currentTimeMillis();
            onTaskSucceed();
        }
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        MiniAppInfo miniAppInfo;
        super.onTaskSucceed();
        BaseRuntime baseRuntime = this.appBrandRuntime;
        if (baseRuntime != null) {
            miniAppInfo = baseRuntime.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        MiniReportManager.reportEventType(miniAppInfo, 101, "0");
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void reset() {
        super.reset();
        this.customJsService = null;
    }
}
