package com.tencent.qqmini.sdk.launcher.core;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.engine.IJsPluginEngine;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class BaseRuntime implements IRuntime, IMiniAppContext {
    private static final String TAG = "BaseRuntime";
    protected long lastStayTime;
    protected IRuntimeLifecycleListener mLifecycleListener;
    protected RuntimeMsgObserver mRuntimeObserver;
    protected long onResumeTime;
    protected long startTime;
    protected Map<Class, Object> mManagerMap = new HashMap();
    private volatile int mLoadingAdStatus = 0;
    private volatile int mRewardedVideoAdStatus = 0;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface RuntimeMsgObserver {
        void onRuntimeMessage(int i3, Object obj);
    }

    private String getSceneSn(MiniAppInfo miniAppInfo) {
        String str;
        try {
            LaunchParam launchParam = miniAppInfo.launchParam;
            EntryModel entryModel = launchParam.entryModel;
            if (entryModel != null) {
                str = String.valueOf(entryModel.uin);
            } else {
                str = launchParam.fromMiniAppId;
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public boolean canLaunchApp() {
        return false;
    }

    public String dispatchEventToNativeView(NativeViewRequestEvent nativeViewRequestEvent) {
        return "";
    }

    public AdReportData getAdReportData() {
        LaunchParam launchParam;
        long currentTimeMillis = System.currentTimeMillis();
        AdReportData adReportData = new AdReportData();
        long j3 = this.onResumeTime;
        adReportData.lastOnResumeTime = j3;
        adReportData.stayTime = this.lastStayTime + (currentTimeMillis - j3);
        adReportData.startTime = this.startTime;
        adReportData.baseLibVersion = getBaseLibVersion();
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            adReportData.scene = launchParam.scene;
            adReportData.sceneSn = getSceneSn(miniAppInfo);
        }
        return adReportData;
    }

    @Nullable
    public CrashRtInfoHolder getCrashRtInfoHolder() {
        return null;
    }

    public long getCurrentDrawCount() {
        return 0L;
    }

    public abstract IJsPluginEngine getJsPluginEngine();

    public abstract IJsService getJsService();

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public int getLaunchAppScene() {
        return 0;
    }

    public int getLoadingAdStatus() {
        return this.mLoadingAdStatus;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public <T> T getManager(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        if (this.mManagerMap.containsKey(cls)) {
            return (T) this.mManagerMap.get(cls);
        }
        for (Class cls2 : this.mManagerMap.keySet()) {
            if (cls2 != null && cls2.getName().equals(cls.getName())) {
                return (T) this.mManagerMap.get(cls2);
            }
        }
        return null;
    }

    public abstract IPage getPage();

    public IPage getPage(int i3) {
        return getPage();
    }

    public ShareState getRecordShareState() {
        return null;
    }

    public IScreenRecord getScreenRecordMgr() {
        return null;
    }

    public abstract ShareState getShareState();

    public boolean isContainer() {
        return false;
    }

    public abstract boolean isForeground();

    public boolean isLoadingAdShowing() {
        if (this.mLoadingAdStatus == 2) {
            return true;
        }
        return false;
    }

    public boolean isRewardedVideoAdShowing() {
        if (this.mRewardedVideoAdStatus == 2) {
            return true;
        }
        return false;
    }

    public abstract void loadMiniApp(MiniAppInfo miniAppInfo);

    public void notifyRuntimeMsgObserver(int i3, Object obj) {
        RuntimeMsgObserver runtimeMsgObserver = this.mRuntimeObserver;
        if (runtimeMsgObserver != null) {
            runtimeMsgObserver.onRuntimeMessage(i3, obj);
        }
    }

    public void onGeneralNativeEvent(String str, Map<String, Object> map, int i3) {
        IJsService jsService = getJsService();
        if (jsService == null) {
            QMLog.w(TAG, "onGeneralNativeEvent jsService is null\uff0cevent is " + str);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        if (map == null) {
            map = new HashMap<>();
        }
        hashMap.put("data", map);
        jsService.evaluateSubscribeJS("onGeneralNativeEvent", new JSONObject(hashMap).toString(), i3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onLoadMiniAppInfo(MiniAppInfo miniAppInfo, boolean z16, String str);

    public void onLoadingAdStatusChanged(int i3) {
        this.mLoadingAdStatus = i3;
    }

    public void onRewardedVideoAdStatusChanged(int i3) {
        this.mRewardedVideoAdStatus = i3;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onRuntimeAttachActivity(Activity activity, ViewGroup viewGroup);

    public abstract void onRuntimeCreate();

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onRuntimeDetachActivity(Activity activity);

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onRuntimePause();

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onRuntimeResume();

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onRuntimeStart();

    @Override // com.tencent.qqmini.sdk.launcher.core.IRuntime
    public abstract void onRuntimeStop();

    public void onUpdateMiniAppInfo(MiniAppInfo miniAppInfo) {
        QMLog.i(TAG, "miniInfo: " + miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.IMiniAppContext
    public Object performAction(Action action) {
        if (action != null) {
            return action.perform(this);
        }
        return null;
    }

    public void setRuntimeLifecycleListener(IRuntimeLifecycleListener iRuntimeLifecycleListener) {
        this.mLifecycleListener = iRuntimeLifecycleListener;
    }

    public void setRuntimeMsgObserver(RuntimeMsgObserver runtimeMsgObserver) {
        this.mRuntimeObserver = runtimeMsgObserver;
    }

    public void handleFocusGain() {
    }

    public void handleFocusLoss() {
    }

    public void captureImage(ICaptureImageCallback iCaptureImageCallback) {
    }

    public void getScreenshot(GetScreenshot.Callback callback) {
    }

    public void setScreenShotState(boolean z16) {
    }
}
