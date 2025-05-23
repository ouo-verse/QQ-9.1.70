package com.tencent.ark.open;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.Logger;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkModel extends ArkViewModel {
    private static final String TAG = "ArkApp.ArkModel";
    private String mAppPath;
    public ArkAppInfo.TimeRecord mExtraTimerRecord;
    private String mResPath;
    private final WeakReference<ArkModel> mWeakThis;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class AppPathCallback implements ArkAppMgr.IGetAppPathByNameCallback {
        protected WeakReference<ArkModel> mWeakWrapper;

        public AppPathCallback(WeakReference<ArkModel> weakReference) {
            this.mWeakWrapper = weakReference;
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            String str2;
            ArkModel arkModel = this.mWeakWrapper.get();
            if (arkModel == null) {
                Logger.logE(ArkModel.TAG, "onGetAppPathByName.wrapper == null");
                return;
            }
            if (appPathInfo != null) {
                str2 = appPathInfo.path;
            } else {
                str2 = null;
            }
            ArkAppInfo.TimeRecord timeRecord = arkModel.mExtraTimerRecord;
            timeRecord.getAppFromLocal = false;
            timeRecord.endOfGetApp = System.currentTimeMillis();
            arkModel.loadArkApp(str2, arkModel.mResPath, i3, str);
        }
    }

    public ArkModel(ark.ApplicationCallback applicationCallback, boolean z16) {
        super(applicationCallback, z16);
        this.mExtraTimerRecord = new ArkAppInfo.TimeRecord(this.mTimeRecord);
        this.mAppPath = null;
        this.mResPath = null;
        this.mWeakThis = new WeakReference<>(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadArkApp(String str, String str2, int i3, String str3) {
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
        if (TextUtils.isEmpty(str2)) {
            str2 = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
        }
        String str4 = str2;
        ArkUtil.createDir(cacheDirectory);
        ArkUtil.createDir(storageDirectory);
        ArkUtil.createDir(str4);
        if (TextUtils.isEmpty(str)) {
            ArkViewModelBase.AppInfo appInfo = this.mAppInfo;
            Logger.logE(TAG, String.format("ArkTemp.loadArkApp app=null mAppInfo.appName=%s, mAppInfo.appView=%s, appPath=%s", appInfo.name, appInfo.view, str));
        }
        doLoadArkApp(str, cacheDirectory, storageDirectory, str4, z16, z17, i3, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onFirstDrawEnd() {
        super.onFirstDrawEnd();
        ArkDispatchTask.getInstance().postToArkThread(new Runnable() { // from class: com.tencent.ark.open.ArkModel.1
            @Override // java.lang.Runnable
            public void run() {
                ArkModel.this.mExtraTimerRecord.doReport();
                ArkModel.this.mExtraTimerRecord.doExtraTimeReport();
            }
        });
    }

    @Override // com.tencent.ark.ArkViewModelBase
    protected boolean onLoadApp(ArkViewModelBase.AppInfo appInfo) {
        final String appPathFromCache;
        this.mExtraTimerRecord.beginOfGetApp = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.mAppPath)) {
            appPathFromCache = this.mAppPath;
        } else {
            ArkAppMgr arkAppMgr = ArkAppMgr.getInstance();
            ArkViewModelBase.AppInfo appInfo2 = this.mAppInfo;
            appPathFromCache = arkAppMgr.getAppPathFromCache(appInfo2.name, appInfo2.bizSrc, appInfo2.appMinVersion);
            Logger.logI(TAG, "onLoadApp:mAppInfo.name=" + this.mAppInfo.name + ",view=" + this.mAppInfo.view + ",path=" + appPathFromCache);
        }
        if (!TextUtils.isEmpty(appPathFromCache)) {
            ArkDispatchTask.getInstance().post(this.mAppInfo.name, new Runnable() { // from class: com.tencent.ark.open.ArkModel.2
                @Override // java.lang.Runnable
                public void run() {
                    ArkAppInfo.TimeRecord timeRecord = ArkModel.this.mExtraTimerRecord;
                    timeRecord.getAppFromLocal = true;
                    timeRecord.endOfGetApp = System.currentTimeMillis();
                    ArkModel arkModel = ArkModel.this;
                    arkModel.loadArkApp(appPathFromCache, arkModel.mResPath, 0, null);
                }
            });
            return true;
        }
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            arkViewImplement.onLoading();
        }
        Logger.logI(TAG, String.format("onLoadApp:mAppInfo.name=%s,appPath=%s,viewImplement=%h", this.mAppInfo.name, appPathFromCache, arkViewImplement));
        ArkAppMgr.getInstance().getAppPathByName(appInfo.name, appInfo.appMinVersion, appInfo.bizSrc, new AppPathCallback(this.mWeakThis));
        return false;
    }

    public void setAppPath(String str) {
        this.mAppPath = str;
        Logger.logE(TAG, "setAppPath:" + str);
    }

    public void setResPath(String str) {
        this.mResPath = str;
        Logger.logE(TAG, "setResPath:" + str);
    }
}
