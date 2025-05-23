package com.tencent.qqmini.miniapp.core.worker;

import android.webkit.JavascriptInterface;
import com.tencent.qqmini.miniapp.action.WorkerAction;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniWorkerInterface {
    private IMiniAppContext mMiniAppContext;

    public MiniWorkerInterface(IMiniAppContext iMiniAppContext) {
        this.mMiniAppContext = iMiniAppContext;
    }

    @JavascriptInterface
    public int create(String str) {
        QMLog.i(MiniAppWorkerManager.TAG, "WORKER|create --> " + str);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            return WorkerAction.obtain(iMiniAppContext).createWorker(str);
        }
        return 0;
    }

    @JavascriptInterface
    public void postMsgToAppService(String str) {
        QMLog.i(MiniAppWorkerManager.TAG, "WORKER|postMsgToMain --> data = " + str);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            WorkerAction.obtain(iMiniAppContext).postMsgToService(str);
        }
    }

    @JavascriptInterface
    public void postMsgToWorker(int i3, String str) {
        QMLog.i(MiniAppWorkerManager.TAG, "WORKER|postMsgToWorker --> obj = " + i3 + "data = " + str);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            WorkerAction.obtain(iMiniAppContext).postMsgToWorker(str);
        }
    }

    @JavascriptInterface
    public void terminate(int i3) {
        QMLog.i(MiniAppWorkerManager.TAG, "WORKER|stopWorker code = " + i3);
        IMiniAppContext iMiniAppContext = this.mMiniAppContext;
        if (iMiniAppContext != null) {
            WorkerAction.obtain(iMiniAppContext).stopWorker();
        }
    }
}
