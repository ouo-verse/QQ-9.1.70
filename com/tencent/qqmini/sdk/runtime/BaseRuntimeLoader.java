package com.tencent.qqmini.sdk.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.IMiniLifecycle;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniProgramReportHelper;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter;
import com.tencent.qqmini.sdk.task.BaseTask;
import cooperation.qzone.util.WiFiDash;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public abstract class BaseRuntimeLoader implements IMiniLifecycle, Handler.Callback, BaseRuntime.RuntimeMsgObserver {
    public static final String TAG = "BaseRuntimeLoader";
    protected boolean hasTaskFailed;
    private boolean isSucceed;
    private Map<String, BaseTask> mActivatedTasks;
    private final AppStateManager mAppStateManager;
    protected Context mContext;
    private final AppRuntimeEventCenter mEventCenter;
    protected boolean mIsRunning;
    protected MiniAppInfo mMiniAppInfo;
    protected boolean mNeedReloadPage;
    protected BaseRuntime mRuntime;
    protected OnAppRuntimeLoadListener mRuntimeLoadListener;
    protected boolean runtimeLoadCompleted;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Creator<T> {
        T create(Context context, Bundle bundle);

        void doPrepareEngine(Bundle bundle);

        boolean isEnginePrepared(Bundle bundle);

        boolean support(MiniAppInfo miniAppInfo);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnAppRuntimeLoadListener {
        void onResult(int i3, String str, BaseRuntimeLoader baseRuntimeLoader);
    }

    public BaseRuntimeLoader(Context context) {
        AppRuntimeEventCenter appRuntimeEventCenter = new AppRuntimeEventCenter();
        this.mEventCenter = appRuntimeEventCenter;
        AppStateManager appStateManager = new AppStateManager(this);
        this.mAppStateManager = appStateManager;
        this.mIsRunning = false;
        this.mNeedReloadPage = false;
        this.runtimeLoadCompleted = false;
        this.isSucceed = false;
        this.hasTaskFailed = false;
        this.mContext = context;
        this.mActivatedTasks = new HashMap();
        appRuntimeEventCenter.addObserver(appStateManager);
        BaseRuntime createRuntime = createRuntime(this.mContext);
        this.mRuntime = createRuntime;
        if (createRuntime != null) {
            createRuntime.setRuntimeMsgObserver(this);
        }
    }

    public void addRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver) {
        this.mEventCenter.addObserver(runtimeStateObserver);
    }

    public void addTask(BaseTask baseTask) {
        if (baseTask == null) {
            return;
        }
        String canonicalName = baseTask.getClass().getCanonicalName();
        if (this.mActivatedTasks.containsKey(canonicalName)) {
            return;
        }
        this.mActivatedTasks.put(canonicalName, baseTask);
    }

    protected abstract BaseRuntime createRuntime(Context context);

    public void destroy() {
        pause();
        this.mRuntimeLoadListener = null;
        this.mEventCenter.deleteObservers();
        BaseRuntime baseRuntime = this.mRuntime;
        if (baseRuntime != null) {
            baseRuntime.onRuntimeDestroy();
        }
    }

    public boolean dismissLoadingAfterLoaded() {
        return false;
    }

    public AppStateManager getAppStateManager() {
        return this.mAppStateManager;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.mMiniAppInfo;
    }

    public MiniAppInfo getMiniAppInfoForReport() {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo == null) {
            return MiniProgramReportHelper.miniAppConfigForPreload();
        }
        return miniAppInfo;
    }

    public BaseRuntime getRuntime() {
        return this.mRuntime;
    }

    public int getStatus() {
        return 1;
    }

    public BaseTask getTask(Class cls) {
        return this.mActivatedTasks.get(cls.getCanonicalName());
    }

    public Pair<Integer, Integer> getTbsVersion(Context context) {
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        QMLog.d(TAG, "handleMessage " + message.what);
        return false;
    }

    public boolean isLoadSucceed() {
        if (this.runtimeLoadCompleted && this.isSucceed) {
            return true;
        }
        return false;
    }

    public boolean isPause() {
        return !this.mIsRunning;
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markHasTaskFailed(boolean z16) {
        this.hasTaskFailed = z16;
    }

    public boolean needReloadPage() {
        return this.mNeedReloadPage;
    }

    public void notifyRuntimeEvent(int i3, Object... objArr) {
        AppRuntimeEventCenter.MiniAppStateMessage obtainMessage = AppRuntimeEventCenter.MiniAppStateMessage.obtainMessage(i3, this);
        if (objArr != null && objArr.length > 0) {
            obtainMessage.obj = objArr[0];
        }
        this.mEventCenter.notifyChange(obtainMessage);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onAttachActivity(Activity activity, Bundle bundle, ViewGroup viewGroup) {
        QMLog.e(TAG, " [MiniLifecycle] onAttachActivity isLoadSucceed=" + isLoadSucceed());
        try {
            this.mRuntime.onRuntimeAttachActivity(activity, viewGroup);
        } catch (Exception e16) {
            QMLog.e(TAG, "onAttachActivity fail msg = " + e16.getMessage());
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onDetachActivity(Activity activity) {
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null && miniAppInfo.isInternalApp()) {
            onDetachActivity(activity, false);
        } else {
            onDetachActivity(activity, true);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniPause() {
        QMLog.e(TAG, " [MiniLifecycle] onMiniPause isLoadSucceed=" + isLoadSucceed());
        this.mRuntime.onRuntimePause();
        notifyRuntimeEvent(24, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniResume() {
        QMLog.e(TAG, " [MiniLifecycle] onMiniResume isLoadSucceed=" + isLoadSucceed());
        this.mRuntime.onRuntimeResume();
        notifyRuntimeEvent(21, new Object[0]);
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStart() {
        QMLog.e(TAG, " [MiniLifecycle] onMiniStart");
        this.mRuntime.onRuntimeStart();
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    public void onMiniStop() {
        QMLog.e(TAG, " [MiniLifecycle] onMiniStop isLoadSucceed=" + isLoadSucceed());
        this.mRuntime.onRuntimeStop();
        notifyRuntimeEvent(22, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRuntimeLoadResult(int i3, String str) {
        boolean z16 = true;
        this.runtimeLoadCompleted = true;
        if (i3 != 0) {
            z16 = false;
        }
        this.isSucceed = z16;
        OnAppRuntimeLoadListener onAppRuntimeLoadListener = this.mRuntimeLoadListener;
        if (onAppRuntimeLoadListener != null) {
            onAppRuntimeLoadListener.onResult(i3, str, this);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.BaseRuntime.RuntimeMsgObserver
    public void onRuntimeMessage(int i3, Object obj) {
        notifyRuntimeEvent(i3, obj);
    }

    public void pause() {
        this.mIsRunning = false;
    }

    public void removeRuntimeStateObserver(AppRuntimeEventCenter.RuntimeStateObserver runtimeStateObserver) {
        this.mEventCenter.deleteObserver(runtimeStateObserver);
    }

    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        MiniAppInfo miniAppInfo2;
        if (miniAppInfo == null) {
            return;
        }
        if (miniAppInfo.apkgInfo == null && (miniAppInfo2 = this.mMiniAppInfo) != null) {
            miniAppInfo.apkgInfo = miniAppInfo2.apkgInfo;
        }
        this.mMiniAppInfo = miniAppInfo;
    }

    public void setRuntime(BaseRuntime baseRuntime) {
        this.mRuntime = baseRuntime;
    }

    public void setRuntimeLoadListener(OnAppRuntimeLoadListener onAppRuntimeLoadListener) {
        this.mRuntimeLoadListener = onAppRuntimeLoadListener;
    }

    public void start() {
        if (this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        this.runtimeLoadCompleted = false;
        this.isSucceed = false;
        this.mNeedReloadPage = false;
        notifyRuntimeEvent(2, new Object[0]);
    }

    public void startLoadMiniAppContent(boolean z16) {
        this.mRuntime.onLoadMiniAppInfo(this.mMiniAppInfo, z16, null);
    }

    public void startUpdateMiniAppInfo() {
        BaseRuntime baseRuntime = this.mRuntime;
        if (baseRuntime == null) {
            return;
        }
        baseRuntime.onUpdateMiniAppInfo(this.mMiniAppInfo);
    }

    public String toSimpleString() {
        return "RuntimeLoader(" + getClass().getSimpleName() + ")@" + hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{Runtime:");
        BaseRuntime baseRuntime = this.mRuntime;
        String str2 = WiFiDash.NOT_AVALIBLE;
        if (baseRuntime != null) {
            str = this.mRuntime.getClass().getSimpleName() + "@" + this.mRuntime.hashCode();
        } else {
            str = WiFiDash.NOT_AVALIBLE;
        }
        sb5.append(str);
        sb5.append(" AppInfo=");
        MiniAppInfo miniAppInfo = this.mMiniAppInfo;
        if (miniAppInfo != null) {
            str2 = miniAppInfo.toSimpleString();
        }
        sb5.append(str2);
        sb5.append("}");
        return sb5.toString();
    }

    public void updateMiniAppInfo(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        miniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
        this.mMiniAppInfo = miniAppInfo;
        startUpdateMiniAppInfo();
    }

    public void updateMiniAppInfoFromReload(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        this.mNeedReloadPage = false;
        miniAppInfo.apkgInfo = this.mMiniAppInfo.apkgInfo;
        this.mMiniAppInfo = miniAppInfo;
        startLoadMiniAppContent(true);
    }

    public void updateMiniGameInfo(MiniAppInfo miniAppInfo) {
        this.mMiniAppInfo = miniAppInfo;
    }

    public void onDetachActivity(Activity activity, boolean z16) {
        QMLog.e(TAG, " [MiniLifecycle] onDetachActivity needDestroy=" + z16 + " isLoadSucceed=" + isLoadSucceed());
        this.mRuntime.onRuntimeDetachActivity(activity);
        notifyRuntimeEvent(62, new Object[0]);
        if (z16) {
            AppRuntimeLoaderManager.g().removeRuntimeLoader(this);
            destroy();
        }
    }

    public void resume() {
    }

    @Override // com.tencent.qqmini.sdk.launcher.IMiniLifecycle
    @Deprecated
    public void onIntentUpdate(Intent intent) {
    }

    public void resetAndStart(MiniAppInfo miniAppInfo) {
    }
}
