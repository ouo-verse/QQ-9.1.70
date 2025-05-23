package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.container.core.j;
import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.core.service.AppBrandService;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.ValueCallback;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WorkerAction implements Action<Integer> {
    public static final int ACTION_CREATE_WORKE = 1;
    public static final int ACTION_GET_WORKER_MODE = 2;
    public static final int ACTION_POST_MSG_TO_SERVICE = 5;
    public static final int ACTION_POST_MSG_TO_WORKER = 4;
    public static final int ACTION_STOP_WORKER = 3;
    private IMiniAppContext mMiniAppContext;
    private int action = -1;
    private String mWorkerName = null;
    private String mPostMsg = null;

    public static WorkerAction obtain(IMiniAppContext iMiniAppContext) {
        WorkerAction workerAction = new WorkerAction();
        workerAction.mMiniAppContext = iMiniAppContext;
        return workerAction;
    }

    public int createWorker(String str) {
        this.action = 1;
        this.mWorkerName = str;
        return ((Integer) this.mMiniAppContext.performAction(this)).intValue();
    }

    public int getWorkerMode() {
        this.action = 2;
        return ((Integer) this.mMiniAppContext.performAction(this)).intValue();
    }

    public void postMsgToService(String str) {
        this.action = 5;
        this.mPostMsg = str;
        this.mMiniAppContext.performAction(this);
    }

    public void postMsgToWorker(String str) {
        this.action = 4;
        this.mPostMsg = str;
        this.mMiniAppContext.performAction(this);
    }

    public void stopWorker() {
        this.action = 3;
        this.mMiniAppContext.performAction(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Integer perform(BaseRuntime baseRuntime) {
        if (!(baseRuntime instanceof AppBrandRuntime) && !(baseRuntime instanceof ax)) {
            return 0;
        }
        MiniAppWorkerManager miniAppWorkerManager = baseRuntime instanceof ax ? ((ax) baseRuntime).getMiniAppWorkerManager() : ((AppBrandRuntime) baseRuntime).getMiniAppWorkerManager();
        int i3 = this.action;
        if (i3 == 1) {
            return Integer.valueOf(miniAppWorkerManager.createWorker(this.mWorkerName));
        }
        if (i3 == 2) {
            return Integer.valueOf(((baseRuntime.getJsService() instanceof AppBrandService) || (baseRuntime.getJsService() instanceof j)) ? 1 : 0);
        }
        if (i3 == 3) {
            miniAppWorkerManager.stopWorker();
        }
        if (this.action == 4) {
            miniAppWorkerManager.handlePostMsgToWorker(this.mPostMsg);
        }
        if (this.action != 5) {
            return null;
        }
        IJsService jsService = baseRuntime.getJsService();
        String format = String.format("WeixinWorker.workerMsgHandler('" + ((Object) 1) + "',%s)", this.mPostMsg);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[postMessageToMain] jsScript:");
        sb5.append(format);
        QMLog.i(MiniAppWorkerManager.TAG, sb5.toString());
        ValueCallback valueCallback = new ValueCallback() { // from class: com.tencent.qqmini.miniapp.action.a
            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                QMLog.i(MiniAppWorkerManager.TAG, "[postMessageToService] over");
            }
        };
        if (jsService instanceof j) {
            ((j) jsService).e(format, "", valueCallback);
            return null;
        }
        jsService.evaluateJs(format, valueCallback);
        return null;
    }
}
