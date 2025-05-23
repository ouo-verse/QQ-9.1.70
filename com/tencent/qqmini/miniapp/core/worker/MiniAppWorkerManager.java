package com.tencent.qqmini.miniapp.core.worker;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.action.WorkerAction;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppWorkerManager {
    public static final int MODE_JSCORE = 1;
    public static final int MODE_WEBVIEW = 0;
    public static final String OBJ_WEIXINWORKER = "WeixinWorker";
    public static final String TAG = "minisdk-worker";
    private static volatile MiniAppWorker mWorker;
    private IMiniAppContext mMiniAppContext;
    private String mWAWorkerJsStr;
    private String mWorkerRunnableStr;
    private ArrayList<String> messagePendingList = new ArrayList<>();
    private int workerVmMode;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface ReturnCode {
        public static final int CREATE_WORKER_SUC = 1;
        public static final int TBS_NOT_READY = -2;
        public static final int UNKOWN_ERROR = 0;
        public static final int WORKER_NOT_EXIST = -1;
    }

    public MiniAppWorkerManager(IMiniAppContext iMiniAppContext) {
        this.mMiniAppContext = iMiniAppContext;
        BaselibLoader.BaselibContent baselibContent = ((BaseRuntimeImpl.BaselibProvider) iMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
        if (baselibContent != null) {
            this.mWAWorkerJsStr = baselibContent.waWorkerStr;
        }
    }

    private void handlePendingMsgList() {
        synchronized (this) {
            if (mWorker != null && mWorker.isJSContextValid()) {
                mWorker.postMessageListToWorker(this.messagePendingList);
            }
            QMLog.e(TAG, "[handlePendingMsgList] failed : worker null/jsctx failed !");
        }
    }

    public MiniAppWorker createRelWorker() throws Exception {
        MiniAppWorker miniAppWorker;
        QMLog.i(TAG, "[createWorker]");
        synchronized (this) {
            if (mWorker != null && !mWorker.isTerminated()) {
                throw new Exception("Worker already created and running!");
            }
            mWorker = new MiniAppWorker(this.mMiniAppContext, this);
            miniAppWorker = mWorker;
        }
        return miniAppWorker;
    }

    public int createWorker(String str) {
        BaselibLoader.BaselibContent baselibContent;
        QMLog.i(TAG, "[handleCreateWorker]");
        setWorkerVmMode(WorkerAction.obtain(this.mMiniAppContext).getWorkerMode());
        if (TextUtils.isEmpty(this.mWAWorkerJsStr) && (baselibContent = ((BaseRuntimeImpl.BaselibProvider) this.mMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent()) != null) {
            this.mWAWorkerJsStr = baselibContent.waWorkerStr;
        }
        if (TextUtils.isEmpty(this.mWAWorkerJsStr)) {
            QMLog.e(TAG, "[handleCreateWorker] error : waWorker.js is missing");
            return 0;
        }
        if (this.mMiniAppContext.getMiniAppInfo() != null && this.mMiniAppContext.getMiniAppInfo().apkgInfo != null) {
            if (TextUtils.isEmpty(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getWorkerPath(null, str))) {
                QMLog.e(TAG, "[handleCreateWorker] error : 001 executed js file " + str + " is missing");
                return -1;
            }
            String workerJsContent = ((ApkgInfo) this.mMiniAppContext.getMiniAppInfo().apkgInfo).getWorkerJsContent(null, str);
            if (TextUtils.isEmpty(workerJsContent)) {
                QMLog.e(TAG, "[handleCreateWorker] error : 002 executed js file " + str + " is missing");
                return -1;
            }
            this.mWorkerRunnableStr = workerJsContent;
            try {
                createRelWorker().initJSContext();
                return 1;
            } catch (Exception e16) {
                QMLog.e(TAG, "[handleCreateWorker] failed : ", e16);
                return 0;
            }
        }
        QMLog.e(TAG, "[handleCreateWorker] error : apkgInfo is missing");
        return 0;
    }

    public int getWorkerVmMode() {
        return this.workerVmMode;
    }

    public void handlePostMsgToWorker(String str) {
        synchronized (this) {
            if (mWorker != null && mWorker.isJSContextValid()) {
                mWorker.postMessageToWorker(str);
            }
            if (this.messagePendingList == null) {
                this.messagePendingList = new ArrayList<>();
            }
            QMLog.i(TAG, "[handlePostMsgToWorker] messagePendingList.add:" + str);
            this.messagePendingList.add(str);
        }
    }

    public boolean isJsCoreMode() {
        if (this.workerVmMode == 1) {
            return true;
        }
        return false;
    }

    public void onWorkerJSContextInitFinished() {
        QMLog.i(TAG, "[onWorkerJSContextInitFinished]");
        synchronized (this) {
            if (mWorker == null) {
                QMLog.e(TAG, "[onWorkerJSContextInitFinished] failed : worker null!");
                return;
            }
            if (!mWorker.loadExecutedAppConfig()) {
                return;
            }
            if (!mWorker.loadWorkerJs(this.mWAWorkerJsStr)) {
                return;
            }
            if (!mWorker.loadWorkerJs(this.mWorkerRunnableStr)) {
                return;
            }
            mWorker.ctxValid();
            handlePendingMsgList();
        }
    }

    public void setWorkerVmMode(int i3) {
        this.workerVmMode = i3;
    }

    public void stopWorker() {
        synchronized (this) {
            if (mWorker == null) {
                return;
            }
            mWorker.clearUp();
            mWorker = null;
        }
    }
}
