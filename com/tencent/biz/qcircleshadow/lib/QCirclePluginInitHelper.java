package com.tencent.biz.qcircleshadow.lib;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes4.dex */
public class QCirclePluginInitHelper implements OnLoadListener {
    public static final String RE_RANK_SO = "EdgeRank";
    public static final String RE_RANK_SO_TAG = "EdgeRank";
    private static final String TAG = "QCirclePluginInitHelper";
    private static volatile QCirclePluginInitHelper sInstance;
    private boolean mRankSoLoaded;
    private String mRankSoVersion;

    public static void PreloadWink(@NonNull Context context) {
        if (context == null) {
            return;
        }
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(context);
    }

    public static QCirclePluginInitHelper getInstance() {
        if (sInstance == null) {
            synchronized (QCirclePluginInitHelper.class) {
                if (sInstance == null) {
                    sInstance = new QCirclePluginInitHelper();
                }
            }
        }
        return sInstance;
    }

    public static String getReportVersionName() {
        return ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName();
    }

    public static boolean isDownloadSDKReady() {
        return QQVideoPlaySDKManager.isDownloadSDKReady();
    }

    public static boolean isPeakAlive(Context context) {
        return ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).isPeakAlive(context);
    }

    public static boolean isSoExits() {
        return QQVideoPlaySDKManager.isSoExits();
    }

    public static boolean isVideoSDKReady() {
        return QQVideoPlaySDKManager.isSDKReady();
    }

    public static boolean needUseSystemPlayer() {
        return QQVideoPlaySDKManager.needUseSystemPlayer();
    }

    public static void preloadPeakProcess(@NonNull Context context) {
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(context);
    }

    public String getRankSoVersion() {
        return this.mRankSoVersion;
    }

    public boolean isRankSoLoaded() {
        return this.mRankSoLoaded;
    }

    public void loadSoByName(String str, OnLoadListener onLoadListener) {
        SoLoadManager.getInstance().load(str, onLoadListener);
    }

    public void loadSoBySeq(String[] strArr, OnLoadListener onLoadListener) {
        SoLoadManager.getInstance().loadSequentially(strArr, onLoadListener);
    }

    public void loadSoWithSoLoadManager() {
        if (!this.mRankSoLoaded) {
            SoLoadManager.getInstance().load("EdgeRank", this);
            QLog.d(TAG, 1, "load rerank so");
        }
    }

    @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
    public void onLoadResult(int i3, LoadExtResult loadExtResult) {
        if (i3 == 0 && loadExtResult.isSucc()) {
            this.mRankSoLoaded = true;
            this.mRankSoVersion = loadExtResult.getVer("EdgeRank");
        }
        QLog.d(TAG, 1, "load rerank so result: ", loadExtResult.toString() + " , mRankSoVersion: " + this.mRankSoVersion);
    }
}
