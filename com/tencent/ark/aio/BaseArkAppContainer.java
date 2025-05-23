package com.tencent.ark.aio;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.Logger;
import com.tencent.ark.aio.report.AioDataReport;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BaseArkAppContainer extends ArkViewModel implements IArkAppContainerModel {
    protected static final ArrayList<WeakReference<BaseArkAppContainer>> S_CONTAINER_LIST = new ArrayList<>();
    protected ArkAppInfo.TimeRecord mExtraTimerRecord;
    private boolean mHasDestroy;
    public boolean mIsAttachToStatusBar;
    private String mTalkBackText;
    protected WeakReference<BaseArkAppContainer> mWeakThis;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    protected static final class AppPathCallback implements ArkAppMgr.IGetAppPathByNameCallback {
        protected WeakReference<BaseArkAppContainer> mWeakWrapper;

        public AppPathCallback(WeakReference<BaseArkAppContainer> weakReference) {
            this.mWeakWrapper = weakReference;
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            String str2;
            BaseArkAppContainer baseArkAppContainer = this.mWeakWrapper.get();
            if (baseArkAppContainer == null) {
                Logger.logE("ArkApp.ArkViewModel", "onGetAppPathByName.wrapper == null");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (appPathInfo != null) {
                str2 = appPathInfo.path;
            } else {
                str2 = null;
            }
            baseArkAppContainer.handleOnGetAppPathByName();
            baseArkAppContainer.loadArkApp(str2, i3, str);
        }
    }

    public BaseArkAppContainer(ark.ApplicationCallback applicationCallback) {
        this(applicationCallback, true);
    }

    private static void createDirectory(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void doArkAppEvent(int i3) {
        Logger.logI("ArkApp.ArkViewModel", "doArkAppEvent type:" + i3);
        ArrayList<WeakReference<BaseArkAppContainer>> arrayList = S_CONTAINER_LIST;
        synchronized (arrayList) {
            Iterator<WeakReference<BaseArkAppContainer>> it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference<BaseArkAppContainer> next = it.next();
                if (next != null && next.get() != null) {
                    next.get().doOnEvent(i3);
                }
                Logger.logI("ArkApp.ArkViewModel", "doArkAppEvent.(item == null || item.get() == null)");
                it.remove();
            }
        }
    }

    public static ArrayList<WeakReference<BaseArkAppContainer>> getContainerList() {
        return S_CONTAINER_LIST;
    }

    public static WeakReference<BaseArkAppContainer> getContainerWrapperByHandle(ark.Container container) {
        synchronized (S_CONTAINER_LIST) {
            int i3 = 0;
            while (true) {
                ArrayList<WeakReference<BaseArkAppContainer>> arrayList = S_CONTAINER_LIST;
                if (i3 < arrayList.size()) {
                    WeakReference<BaseArkAppContainer> weakReference = arrayList.get(i3);
                    BaseArkAppContainer baseArkAppContainer = weakReference.get();
                    if (baseArkAppContainer != null && baseArkAppContainer.getContainer() == container) {
                        return weakReference;
                    }
                    i3++;
                } else {
                    return new WeakReference<>(null);
                }
            }
        }
    }

    public void attachFromStatusBar() {
        this.mIsAttachToStatusBar = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void destroy() {
        ArrayList<WeakReference<BaseArkAppContainer>> arrayList = S_CONTAINER_LIST;
        synchronized (arrayList) {
            arrayList.remove(this.mWeakThis);
        }
        super.destroy();
    }

    public void detachFromStatusBar() {
        this.mIsAttachToStatusBar = false;
        if (this.mHasDestroy) {
            super.doOnEvent(2);
        }
    }

    public abstract void doCloseViewEvent();

    @Override // com.tencent.ark.ArkViewModelBase
    public void doOnEvent(int i3) {
        if (i3 == 2 && this.mIsAttachToStatusBar) {
            this.mHasDestroy = true;
        } else {
            super.doOnEvent(i3);
        }
    }

    public abstract void doOpenCardViewEvent(String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void fillReportParams(Map<String, String> map) {
        super.fillReportParams(map);
        int chatType = getChatType();
        if (chatType != 0) {
            map.put("ark_aio_type", AioDataReport.convertChatTypeToReportStr(chatType));
        }
        String peerUin = getPeerUin();
        if (!TextUtils.isEmpty(peerUin)) {
            map.put("ark_aio_uin", peerUin);
        }
    }

    public ArkAppInfo.TimeRecord getExtraTimerRecord() {
        return this.mExtraTimerRecord;
    }

    public String getTalkBackText() {
        return this.mTalkBackText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBeforeGetAppPathName() {
        this.mExtraTimerRecord.beginOfGetApp = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleOnGetAppPathByName() {
        ArkAppInfo.TimeRecord timeRecord = this.mExtraTimerRecord;
        timeRecord.getAppFromLocal = false;
        timeRecord.endOfGetApp = System.currentTimeMillis();
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, float f16) {
        this.mHasDestroy = false;
        return super.init(str, str2, str3, str4, str5, str6, f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadArkApp(String str, int i3, String str2) {
        boolean z16;
        boolean z17;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == -2) {
            z17 = true;
        } else {
            z17 = false;
        }
        String cacheDirectory = ArkEnvironmentManager.getInstance().getCacheDirectory();
        String storageDirectory = ArkEnvironmentManager.getInstance().getStorageDirectory();
        String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
        createDirectory(cacheDirectory);
        createDirectory(storageDirectory);
        createDirectory(appResPath);
        if (TextUtils.isEmpty(str)) {
            Logger.logD("ArkApp.ArkViewModel", "BaseArkAppContainer.loadArkApp app=null mAppInfo.appName=" + this.mAppInfo.name + ",mAppInfo.appView=" + this.mAppInfo.view + ", appPath=" + str, new RuntimeException());
        }
        doLoadArkApp(str, cacheDirectory, storageDirectory, appResPath, z16, z17, i3, str2);
    }

    @Override // com.tencent.ark.ArkViewModelBase
    protected boolean onLoadApp(ArkViewModelBase.AppInfo appInfo) {
        handleBeforeGetAppPathName();
        ArkAppMgr arkAppMgr = ArkAppMgr.getInstance();
        ArkViewModelBase.AppInfo appInfo2 = this.mAppInfo;
        final ArkAppMgr.AppPathInfo appInfoFromCache = arkAppMgr.getAppInfoFromCache(appInfo2.name, appInfo2.bizSrc, appInfo2.appMinVersion);
        ArkAppConfigMgr arkAppConfigMgr = ArkAppConfigMgr.getInstance();
        ArkViewModelBase.AppInfo appInfo3 = this.mAppInfo;
        boolean hasUrlChecker = arkAppConfigMgr.hasUrlChecker(appInfo3.name, appInfo3.bizSrc);
        if (appInfoFromCache != null && !TextUtils.isEmpty(appInfoFromCache.path) && hasUrlChecker) {
            onLoadAppPathInfoCache(appInfoFromCache);
            ArkDispatchTask.getInstance().post(this.mAppInfo.name, new Runnable() { // from class: com.tencent.ark.aio.BaseArkAppContainer.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseArkAppContainer.this.handleOnGetAppPathByName();
                    Logger.logI("ArkApp.ArkViewModel", "getAppPathByNameFromLocal.in.wrapper: " + this);
                    BaseArkAppContainer.this.loadArkApp(appInfoFromCache.path, 0, null);
                }
            });
            return true;
        }
        if (TextUtils.isEmpty(appInfo.name)) {
            Logger.logW("ArkApp.ArkViewModel", "onLoadApp, name is empty");
            loadArkApp(null, -1, "\u6d88\u606f\u683c\u5f0f\u5f02\u5e38\uff0c\u89e3\u6790\u5931\u8d25\u3002");
            return true;
        }
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            arkViewImplement.onLoading();
        }
        ArkAppMgr.getInstance().getAppPathByName(appInfo.name, appInfo.appMinVersion, appInfo.bizSrc, new AppPathCallback(this.mWeakThis));
        return false;
    }

    public void setTalkBackText(String str) {
        this.mTalkBackText = str;
    }

    public BaseArkAppContainer(ark.ApplicationCallback applicationCallback, boolean z16) {
        super(applicationCallback, z16);
        this.mTalkBackText = "";
        this.mIsAttachToStatusBar = false;
        this.mHasDestroy = false;
        this.mExtraTimerRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
        this.mWeakThis = new WeakReference<>(this);
        ArrayList<WeakReference<BaseArkAppContainer>> arrayList = S_CONTAINER_LIST;
        synchronized (arrayList) {
            arrayList.add(this.mWeakThis);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadAppPathInfoCache(ArkAppMgr.AppPathInfo appPathInfo) {
    }
}
