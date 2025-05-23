package com.tencent.qqmini.miniapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.miniapp.task.ApkgLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.BaselibLoadAsyncTask;
import com.tencent.qqmini.miniapp.task.BaselibVersionCheckTask;
import com.tencent.qqmini.miniapp.task.PageCreateTask;
import com.tencent.qqmini.miniapp.task.PageInitTask;
import com.tencent.qqmini.miniapp.task.PreloadFlagTask;
import com.tencent.qqmini.miniapp.task.RuntimeCreateTask;
import com.tencent.qqmini.miniapp.task.RuntimeInitTask;
import com.tencent.qqmini.miniapp.task.ServiceCreateTask;
import com.tencent.qqmini.miniapp.task.ServiceInitTask;
import com.tencent.qqmini.miniapp.task.TbsAsyncTask;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.runtime.a;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.MiniAppInfoLoadTask;
import com.tencent.qqmini.sdk.task.TaskThreadPool;
import com.tencent.smtt.sdk.QbSdk;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class AppRuntimeLoader extends a {

    @MiniKeep
    public static final BaseRuntimeLoader.Creator<AppRuntimeLoader> CREATOR = new BaseRuntimeLoader.Creator<AppRuntimeLoader>() { // from class: com.tencent.qqmini.miniapp.AppRuntimeLoader.1
        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public boolean isEnginePrepared(Bundle bundle) {
            return true;
        }

        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public boolean support(MiniAppInfo miniAppInfo) {
            if (miniAppInfo != null && miniAppInfo.isEngineTypeMiniApp()) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public AppRuntimeLoader create(Context context, Bundle bundle) {
            return new AppRuntimeLoader(context);
        }

        @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader.Creator
        public void doPrepareEngine(Bundle bundle) {
        }
    };
    public static final String TAG = "AppRuntimeLoader";
    private ApkgLoadAsyncTask apkgLoadTask;
    private BaselibLoadAsyncTask baselibLoadTask;
    private BaselibVersionCheckTask baselibVersionCheckTask;
    private volatile boolean fromUpdate;
    private MiniAppInfoLoadTask miniAppInfoLoadTask;
    private PageCreateTask pageCreateTask;
    private PageInitTask pageInitTask;
    private PreloadFlagTask preloadFlagTask;
    public RuntimeCreateTask runtimeCreateTask;
    private RuntimeInitTask runtimeInitTask;
    public ServiceCreateTask serviceCreateTask;
    public ServiceInitTask serviceInitTask;
    private TbsAsyncTask tbsTask;

    public AppRuntimeLoader(Context context) {
        super(context);
        this.fromUpdate = false;
    }

    private void onBaselibUpdated() {
        QMLog.i(TAG, "BaselibVersionCheck baselib updated, reset runtimeloader!");
        pause();
        resetTaskAndDepends(this.baselibLoadTask);
        resetTaskAndDepends(this.serviceCreateTask);
        resetTaskAndDepends(this.pageCreateTask);
        start();
    }

    private void onMiniAppVersionUpdate() {
        QMLog.i(TAG, "onMiniAppVersionUpdate, reset apkgLoadTask & runtimeCreateTask.");
        pause();
        resetTaskAndDepends(this.apkgLoadTask);
        resetTaskAndDepends(this.runtimeCreateTask);
        BaseRuntime createRuntime = createRuntime(this.mContext);
        this.mRuntime = createRuntime;
        createRuntime.setRuntimeMsgObserver(this);
        start();
    }

    private void refreshLaunchParamIfNeeded(MiniAppInfo miniAppInfo) {
        MiniAppInfo miniAppInfo2 = this.mMiniAppInfo;
        if (miniAppInfo2 == null) {
            return;
        }
        LaunchParam launchParam = miniAppInfo2.launchParam;
        LaunchParam launchParam2 = miniAppInfo.launchParam;
        launchParam.scene = launchParam2.scene;
        launchParam.fileMaterialInfoList = launchParam2.fileMaterialInfoList;
        updateMiniAppInfo(miniAppInfo2);
    }

    private void setRuntimeBaselib() {
        if (this.mRuntime != null && this.baselibLoadTask.getBaselibContent() != null) {
            ((BaseRuntimeImpl.BaselibProvider) this.mRuntime.getManager(BaseRuntimeImpl.BaselibProvider.class)).setBaseLib(this.baselibLoadTask.getBaselibContent());
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.a, com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    protected BaseRuntime createRuntime(Context context) {
        AppBrandRuntime appBrandRuntime = new AppBrandRuntime(context);
        appBrandRuntime.setRuntimeMsgObserver(this);
        appBrandRuntime.setAppStateManager(getAppStateManager());
        return appBrandRuntime;
    }

    @Override // com.tencent.qqmini.sdk.runtime.a
    public BaseTask[] createTasks() {
        Context context = this.mContext;
        this.runtimeCreateTask = new RuntimeCreateTask(context, this);
        this.tbsTask = new TbsAsyncTask(context, this);
        this.serviceCreateTask = new ServiceCreateTask(context, this);
        this.runtimeInitTask = new RuntimeInitTask(context, this);
        this.baselibLoadTask = new BaselibLoadAsyncTask(context, this);
        this.miniAppInfoLoadTask = new MiniAppInfoLoadTask(context, this);
        this.apkgLoadTask = new ApkgLoadAsyncTask(context, this);
        this.serviceInitTask = new ServiceInitTask(context, this);
        this.preloadFlagTask = new PreloadFlagTask(context, this);
        this.pageCreateTask = new PageCreateTask(context, this);
        this.pageInitTask = new PageInitTask(context, this);
        this.baselibVersionCheckTask = new BaselibVersionCheckTask(context, this);
        this.runtimeInitTask.addDependTask(this.preloadFlagTask.addDependTask(this.serviceInitTask.addDependTask(this.serviceCreateTask.addDependTask(this.tbsTask).addDependTask(this.runtimeCreateTask)).addDependTask(this.baselibLoadTask)).addDependTask(this.pageInitTask.addDependTask(this.pageCreateTask.addDependTask(this.runtimeCreateTask)).addDependTask(this.baselibLoadTask))).addDependTask(this.apkgLoadTask.addDependTask(this.miniAppInfoLoadTask)).addDependTask(this.baselibVersionCheckTask.addDependTask(this.miniAppInfoLoadTask).addDependTask(this.baselibLoadTask));
        return new BaseTask[]{this.runtimeInitTask};
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public Pair<Integer, Integer> getTbsVersion(Context context) {
        return new Pair<>(Integer.valueOf(QbSdk.getTbsVersion(context)), Integer.valueOf(QbSdk.getTmpDirTbsVersion(context)));
    }

    @Override // com.tencent.qqmini.sdk.runtime.a
    public void onTaskDone(BaseTask baseTask) {
        MiniAppInfo miniAppInfo;
        if (baseTask == null) {
            return;
        }
        if (!baseTask.isSucceed() && (baseTask instanceof BaselibVersionCheckTask) && 12 == baseTask.retCode) {
            super.onTaskDone(baseTask);
            onBaselibUpdated();
            return;
        }
        if (!baseTask.isSucceed()) {
            notifyRuntimeEvent(12, new Object[0]);
            onRuntimeLoadResult(baseTask.retCode, baseTask.f348348msg);
            return;
        }
        if (checkAllTaskIsDone()) {
            setStatus(5);
        }
        if (baseTask == this.preloadFlagTask) {
            if (getAppStateManager().isFromPreload && this.mMiniAppInfo == null) {
                setStatus(4);
            }
            notifyRuntimeEvent(3, new Object[0]);
        } else {
            RuntimeCreateTask runtimeCreateTask = this.runtimeCreateTask;
            if (baseTask == runtimeCreateTask) {
                if (runtimeCreateTask.isSucceed()) {
                    setRuntimeBaselib();
                }
            } else if (baseTask == this.baselibLoadTask) {
                setRuntimeBaselib();
            } else {
                RuntimeInitTask runtimeInitTask = this.runtimeInitTask;
                if (baseTask == runtimeInitTask) {
                    if (runtimeInitTask.isSucceed()) {
                        notifyRuntimeEvent(4, new Object[0]);
                        onRuntimeLoadResult(0, "");
                    }
                    this.mIsRunning = false;
                } else if (baseTask == this.miniAppInfoLoadTask) {
                    QMLog.w(TAG, "fromUpdate: " + this.fromUpdate + " threadId=" + Thread.currentThread().getId());
                    if (!this.fromUpdate) {
                        this.mMiniAppInfo = this.miniAppInfoLoadTask.getMiniAppInfo();
                    } else {
                        this.fromUpdate = false;
                        MiniAppInfo miniAppInfo2 = this.miniAppInfoLoadTask.getMiniAppInfo();
                        boolean isSameVersion = MiniAppBaseInfo.isSameVersion(miniAppInfo2, this.mMiniAppInfo);
                        ApkgBaseInfo apkgBaseInfo = this.mMiniAppInfo.apkgInfo;
                        this.mMiniAppInfo = miniAppInfo2;
                        miniAppInfo2.apkgInfo = apkgBaseInfo;
                        if (isSameVersion) {
                            if (!TextUtils.isEmpty(miniAppInfo2.launchParam.entryPath)) {
                                this.mNeedReloadPage = true;
                            }
                            BaseRuntimeLoader.OnAppRuntimeLoadListener onAppRuntimeLoadListener = this.mRuntimeLoadListener;
                            if (onAppRuntimeLoadListener != null) {
                                onAppRuntimeLoadListener.onResult(0, "", this);
                            }
                        } else {
                            onMiniAppVersionUpdate();
                        }
                    }
                } else {
                    ApkgLoadAsyncTask apkgLoadAsyncTask = this.apkgLoadTask;
                    if (baseTask == apkgLoadAsyncTask && apkgLoadAsyncTask.isSucceed() && (miniAppInfo = this.mMiniAppInfo) != null) {
                        miniAppInfo.apkgInfo = this.apkgLoadTask.getApkgInfo();
                    }
                }
            }
        }
        super.onTaskDone(baseTask);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void resetAndStart(final MiniAppInfo miniAppInfo) {
        super.resetAndStart(miniAppInfo);
        TaskThreadPool taskThreadPool = getTaskThreadPool();
        if (taskThreadPool == null) {
            QMLog.e(TAG, "resetAndStart getTaskThreadPool null");
        } else {
            taskThreadPool.addExecuteTask(new Runnable() { // from class: com.tencent.qqmini.miniapp.AppRuntimeLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    QMLog.d(AppRuntimeLoader.TAG, "AppBrandRemoteService Task reset begin");
                    AppRuntimeLoader.this.pause();
                    AppRuntimeLoader appRuntimeLoader = AppRuntimeLoader.this;
                    appRuntimeLoader.resetTaskAndDepends(appRuntimeLoader.baselibLoadTask);
                    AppRuntimeLoader appRuntimeLoader2 = AppRuntimeLoader.this;
                    appRuntimeLoader2.resetTaskAndDepends(appRuntimeLoader2.serviceCreateTask);
                    AppRuntimeLoader appRuntimeLoader3 = AppRuntimeLoader.this;
                    appRuntimeLoader3.resetTaskAndDepends(appRuntimeLoader3.pageCreateTask);
                    AppRuntimeLoader.this.getRuntime().loadMiniApp(miniAppInfo);
                    QMLog.d(AppRuntimeLoader.TAG, "AppBrandRemoteService Task reset end ");
                    AppRuntimeLoader.this.start();
                }
            });
        }
    }

    @Override // com.tencent.qqmini.sdk.runtime.a, com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        super.setMiniAppInfo(miniAppInfo);
        this.miniAppInfoLoadTask.setMiniAppInfo(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader
    public void updateMiniAppInfoFromReload(MiniAppInfo miniAppInfo) {
        if (miniAppInfo.isFakeAppInfo()) {
            refreshLaunchParamIfNeeded(miniAppInfo);
            this.fromUpdate = true;
            QMLog.w(TAG, "updateMiniAppInfoFromReload  fromUpdate: " + this.fromUpdate + " threadId=" + Thread.currentThread().getId());
            this.miniAppInfoLoadTask.reset();
            this.miniAppInfoLoadTask.setStatus(2);
            this.miniAppInfoLoadTask.setMiniAppInfo(miniAppInfo);
            return;
        }
        super.updateMiniAppInfoFromReload(miniAppInfo);
    }
}
