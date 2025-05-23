package com.tencent.qqmini.sdk.manager;

import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.MiniAppEngineLoadTask;
import com.tencent.qqmini.sdk.task.TaskFlowEngine;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniLoadManager implements BaseTask.Callback {
    public static final String LOG_TAG = "MiniLoadManager";
    private static volatile MiniLoadManager sInstance;
    private boolean baseDownloadEngineLoaded;
    private MiniLoadListener mDownLoadListener;
    private MiniAppEngineLoadTask mMiniAppEngineLoadTask;
    private TaskFlowEngine taskFlowEngine = new TaskFlowEngine(this);

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface MiniLoadListener {
        void onEngineLoad(boolean z16, String str);

        void onGpkgLoad(boolean z16, String str);

        void onTaskProgress(BaseTask baseTask, float f16, String str);
    }

    MiniLoadManager() {
    }

    public static MiniLoadManager g() {
        if (sInstance == null) {
            synchronized (MiniLoadManager.class) {
                if (sInstance == null) {
                    sInstance = new MiniLoadManager();
                }
            }
        }
        return sInstance;
    }

    public void attachDownloadListener(MiniLoadListener miniLoadListener) {
        QMLog.i(LOG_TAG, "[MiniEng]attachDownloadListener " + miniLoadListener);
        this.mDownLoadListener = miniLoadListener;
        this.mMiniAppEngineLoadTask.setDownloadListener(miniLoadListener);
        if (this.mMiniAppEngineLoadTask.isDone()) {
            QMLog.i(LOG_TAG, "[MiniEng]attachDownloadListener after mMiniAppEngineLoadTask isDone");
            if (miniLoadListener != null) {
                boolean isSucceed = this.mMiniAppEngineLoadTask.isSucceed();
                String str = this.mMiniAppEngineLoadTask.f348348msg;
                if (str == null) {
                    str = "";
                }
                miniLoadListener.onEngineLoad(isSucceed, str);
            }
        }
    }

    public void configTask(Context context, BaseRuntimeLoader baseRuntimeLoader) {
        QMLog.i(LOG_TAG, "[MiniEng]configTask MiniAppEngineLoadTask");
        MiniAppEngineLoadTask miniAppEngineLoadTask = new MiniAppEngineLoadTask(context, baseRuntimeLoader);
        this.mMiniAppEngineLoadTask = miniAppEngineLoadTask;
        this.taskFlowEngine.initTasks(new BaseTask[]{miniAppEngineLoadTask});
    }

    public void detachDownloadListener(MiniLoadListener miniLoadListener) {
        QMLog.i(LOG_TAG, "[MiniEng]detachDownloadListener in:" + miniLoadListener + ",current:" + this.mDownLoadListener);
        if (miniLoadListener != null && miniLoadListener.equals(this.mDownLoadListener)) {
            this.mDownLoadListener = null;
            this.mMiniAppEngineLoadTask.setDownloadListener(null);
        } else {
            QMLog.w(LOG_TAG, "[MiniEng]detachDownloadListener failed");
        }
    }

    public String getBaseEnginePath() {
        InstalledEngine engine = this.mMiniAppEngineLoadTask.getEngine();
        if (engine != null && engine.isVerify) {
            return engine.engineDir + "/";
        }
        return null;
    }

    public String getEngineVersion() {
        InstalledEngine engine = this.mMiniAppEngineLoadTask.getEngine();
        if (engine != null && engine.isVerify) {
            return String.valueOf(engine.engineVersion);
        }
        return "";
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask.Callback
    public void onTaskEnd(BaseTask baseTask) {
        if (!this.taskFlowEngine.onTaskEnd(baseTask)) {
            return;
        }
        QMLog.i(LOG_TAG, "[MiniEng]" + baseTask + " done! succ:" + baseTask.isSucceed() + ", listener=" + this.mMiniAppEngineLoadTask);
        if (baseTask instanceof MiniAppEngineLoadTask) {
            if (!baseTask.isSucceed()) {
                MiniLoadListener miniLoadListener = this.mDownLoadListener;
                if (miniLoadListener != null) {
                    miniLoadListener.onEngineLoad(false, ((MiniAppEngineLoadTask) baseTask).f348348msg);
                }
                this.baseDownloadEngineLoaded = false;
            } else {
                MiniLoadListener miniLoadListener2 = this.mDownLoadListener;
                if (miniLoadListener2 != null) {
                    miniLoadListener2.onEngineLoad(true, "");
                }
                this.baseDownloadEngineLoaded = true;
            }
        }
        this.taskFlowEngine.onTaskDone(baseTask);
    }

    public void setDownloadEngineChannel(EngineChannel engineChannel) {
        this.mMiniAppEngineLoadTask.setEngineChannel(engineChannel);
        QMLog.i(LOG_TAG, "[MiniEng]setDownloadEngineChannel " + engineChannel + ", " + AppLoaderFactory.g().getProcessName());
    }

    public void startDownload(MiniLoadListener miniLoadListener) {
        this.baseDownloadEngineLoaded = false;
        this.taskFlowEngine.resetTaskAndDepends(this.mMiniAppEngineLoadTask);
        attachDownloadListener(miniLoadListener);
        QMLog.w(LOG_TAG, "[MiniEng]start does nothing, use start(MiniAppConfig) instead");
        this.taskFlowEngine.start();
    }

    @Override // com.tencent.qqmini.sdk.task.BaseTask.Callback
    public void onTaskBegin(BaseTask baseTask) {
    }
}
