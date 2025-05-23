package com.tencent.qqmini.miniapp.task;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.qqmini.miniapp.core.BaseAppBrandRuntime;
import com.tencent.qqmini.miniapp.core.fsm.StateMachine;
import com.tencent.qqmini.miniapp.core.service.AbsAppBrandService;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.sdk.action.AppStateEvent;
import com.tencent.qqmini.sdk.annotation.ClassTag;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MtaReportSt;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.AsyncTask;
import java.util.Properties;

/* compiled from: P */
@ClassTag(tag = ServiceInitTask.TAG)
/* loaded from: classes23.dex */
public class ServiceInitTask extends AsyncTask {
    public static final String TAG = "ServiceInitTask";
    protected BaseAppBrandRuntime appBrandRuntime;
    protected AbsAppBrandService customJsService;

    public ServiceInitTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        super(context, baseRuntimeLoader);
    }

    @Override // com.tencent.qqmini.sdk.task.AsyncTask
    public void executeAsync() {
        MiniAppInfo miniAppInfo;
        BaseAppBrandRuntime baseAppBrandRuntime;
        final long j3;
        BaseAppBrandRuntime baseAppBrandRuntime2 = this.appBrandRuntime;
        final AbsAppBrandService absAppBrandService = null;
        if (baseAppBrandRuntime2 != null) {
            miniAppInfo = baseAppBrandRuntime2.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        MiniReportManager.reportEventType(miniAppInfo, 14, "0");
        RuntimeCreateTask runtimeCreateTask = (RuntimeCreateTask) getRuntimeLoader().getTask(RuntimeCreateTask.class);
        if (runtimeCreateTask != null) {
            baseAppBrandRuntime = runtimeCreateTask.getAppBrandRuntime();
        } else {
            baseAppBrandRuntime = null;
        }
        this.appBrandRuntime = baseAppBrandRuntime;
        ServiceCreateTask serviceCreateTask = (ServiceCreateTask) getRuntimeLoader().getTask(ServiceCreateTask.class);
        BaselibLoader.BaselibContent baselibContent = ((BaselibLoadAsyncTask) getRuntimeLoader().getTask(BaselibLoadAsyncTask.class)).getBaselibContent();
        if (serviceCreateTask != null) {
            absAppBrandService = serviceCreateTask.getJsService();
        }
        if (serviceCreateTask != null) {
            j3 = serviceCreateTask.getCreateTime();
        } else {
            j3 = 0;
        }
        if (absAppBrandService != null) {
            BaseAppBrandRuntime baseAppBrandRuntime3 = this.appBrandRuntime;
            if (baseAppBrandRuntime3 != null) {
                absAppBrandService.setAppBrandEventInterface(baseAppBrandRuntime3.getEventListener());
            }
            absAppBrandService.addStateChangeListener(new StateMachine.OnStateChangeListener() { // from class: com.tencent.qqmini.miniapp.task.ServiceInitTask.1
                long jsServiceInitStartTimestamp;

                @Override // com.tencent.qqmini.miniapp.core.fsm.StateMachine.OnStateChangeListener
                public void onStateChanged() {
                    StateMachine.State state;
                    AbsAppBrandService absAppBrandService2 = absAppBrandService;
                    if (absAppBrandService2 != null) {
                        state = absAppBrandService2.getCurrState();
                    } else {
                        state = null;
                    }
                    if (state != null && state == absAppBrandService.stateWaJsLoading) {
                        this.jsServiceInitStartTimestamp = SystemClock.uptimeMillis();
                    }
                    if (state != null) {
                        AbsAppBrandService absAppBrandService3 = absAppBrandService;
                        if (state == absAppBrandService3.stateWaJsLoadSucc) {
                            ServiceInitTask.this.onServiceInitSucc(absAppBrandService3, j3, SystemClock.uptimeMillis() - this.jsServiceInitStartTimestamp);
                        }
                    }
                }
            });
            absAppBrandService.initBaseJs(baselibContent);
            return;
        }
        onTaskFailed();
    }

    public AbsAppBrandService getJsService() {
        return this.customJsService;
    }

    protected synchronized void onServiceInitSucc(AbsAppBrandService absAppBrandService, long j3, long j16) {
        if (this.customJsService == null && absAppBrandService != null) {
            this.customJsService = absAppBrandService;
            onTaskSucceed();
            Properties properties = new Properties();
            if (absAppBrandService instanceof AppBrandService) {
                properties.put("service_type", ServiceCreateTask.SERVICE_TYPE_X5);
            } else {
                properties.put("service_type", "unexpected");
            }
            properties.put("service_init_timecost", Long.valueOf(j3));
            properties.put("service_exec_timecost", Long.valueOf(j16));
            properties.put("reserved", "1");
            Log.d(TAG, absAppBrandService + ",serviceInit:" + j3 + ",serviceExec:" + j16);
            this.appBrandRuntime.performAction(AppStateEvent.obtain(50, new MtaReportSt("miniapp_service_init", properties)));
        }
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void onTaskSucceed() {
        MiniAppInfo miniAppInfo;
        super.onTaskSucceed();
        BaseAppBrandRuntime baseAppBrandRuntime = this.appBrandRuntime;
        if (baseAppBrandRuntime != null) {
            miniAppInfo = baseAppBrandRuntime.getMiniAppInfo();
        } else {
            miniAppInfo = null;
        }
        MiniReportManager.reportEventType(miniAppInfo, 15, "0");
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask
    public void reset() {
        super.reset();
        this.customJsService = null;
    }
}
