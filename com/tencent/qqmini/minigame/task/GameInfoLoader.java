package com.tencent.qqmini.minigame.task;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.minigame.gpkg.GpkgManager;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.ui.LoadingStatus;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.SpecialProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import com.tencent.qqmini.sdk.manager.a;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.request.GetAppInfoByIdRequest;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameInfoLoader {

    /* renamed from: a, reason: collision with root package name */
    private MiniAppInfo f346690a = null;

    /* renamed from: b, reason: collision with root package name */
    private MiniGamePkg f346691b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f346692c = null;

    /* renamed from: d, reason: collision with root package name */
    private volatile GpkgManager.Info f346693d = null;

    /* renamed from: e, reason: collision with root package name */
    private long f346694e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f346695f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f346696g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f346697h = 0;

    /* renamed from: i, reason: collision with root package name */
    private float f346698i = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqmini.minigame.task.a f346721a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f346722b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MiniAppCacheProxy f346723c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f346724d;

        a(com.tencent.qqmini.minigame.task.a aVar, String str, MiniAppCacheProxy miniAppCacheProxy, String str2) {
            this.f346721a = aVar;
            this.f346722b = str;
            this.f346723c = miniAppCacheProxy;
            this.f346724d = str2;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            if (z16) {
                long optLong = jSONObject.optLong("retCode");
                QMLog.i("GameInfoLoader", "getAppInfoById, retCode = " + optLong + ",errMsg = " + jSONObject.optString("errMsg"));
                MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                if (miniAppInfo != null) {
                    GameInfoLoader.this.L(miniAppInfo);
                    MiniReportManager.reportEventType(miniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(miniAppInfo));
                    GameInfoLoader.this.H(miniAppInfo, true, this.f346721a);
                } else {
                    SDKMiniProgramLpReportDC04239.reportPageView(GameInfoLoader.this.f346690a, MiniReportManager.getAppType(GameInfoLoader.this.f346690a), null, "load_fail", "shortcut_request_fail");
                    MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, GameInfoLoader.this.f346690a);
                    GameInfoLoader.this.G(optLong, "\u83b7\u53d6appInfo\u5931\u8d25\uff0cretCode=" + optLong + ", appInfo is null", this.f346721a);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
                byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
                GameInfoLoader gameInfoLoader = GameInfoLoader.this;
                gameInfoLoader.O(optJSONObject, bArr, this.f346722b, this.f346723c, gameInfoLoader.f346690a.appId, this.f346724d);
                return;
            }
            SDKMiniProgramLpReportDC04239.reportPageView(GameInfoLoader.this.f346690a, MiniReportManager.getAppType(GameInfoLoader.this.f346690a), null, "load_fail", "shortcut_request_fail");
            MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, GameInfoLoader.this.f346690a);
            GameInfoLoader.this.G(-13009L, "isSuc is false", this.f346721a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b implements AsyncResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqmini.minigame.task.a f346726a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppCacheProxy f346727b;

        b(com.tencent.qqmini.minigame.task.a aVar, MiniAppCacheProxy miniAppCacheProxy) {
            this.f346726a = aVar;
            this.f346727b = miniAppCacheProxy;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
        public void onReceiveResult(boolean z16, JSONObject jSONObject) {
            String str;
            String str2;
            try {
                if (z16 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    QMLog.d("GameInfoLoader", "getAppInfoByLink, retCode = " + optLong + ",errMsg = " + jSONObject.optString("errMsg"));
                    MiniAppInfo miniAppInfo = (MiniAppInfo) jSONObject.opt("mini_app_info_data");
                    String optString = jSONObject.optString("shareTicket", "");
                    if (optLong == 0 && miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId)) {
                        GameInfoLoader.this.M(miniAppInfo, optString);
                        MiniReportManager.reportEventType(miniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(miniAppInfo));
                        GameInfoLoader.this.H(miniAppInfo, true, this.f346726a);
                    } else {
                        SDKMiniProgramLpReportDC04239.reportPageView(GameInfoLoader.this.f346690a, MiniReportManager.getAppType(GameInfoLoader.this.f346690a), null, "load_fail", "shortcut_request_fail");
                        MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, GameInfoLoader.this.f346690a);
                        if (miniAppInfo == null) {
                            QMLog.e("GameInfoLoader", "getAppInfoByLink  onCmdListener appinfo==null retCode= " + optLong);
                        } else {
                            QMLog.e("GameInfoLoader", "getAppInfoByLink  onCmdListener retCode= " + optLong + " appid=" + miniAppInfo.appId);
                        }
                        GameInfoLoader gameInfoLoader = GameInfoLoader.this;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("\u83b7\u53d6appInfo\u5931\u8d25\uff0cretCode=");
                        sb5.append(optLong);
                        sb5.append(", appId:");
                        if (miniAppInfo == null) {
                            str2 = "appinfo is null";
                        } else {
                            str2 = miniAppInfo.appId;
                        }
                        sb5.append(str2);
                        gameInfoLoader.G(optLong, sb5.toString(), this.f346726a);
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_JSON);
                    byte[] bArr = (byte[]) jSONObject.opt(GetAppInfoByIdRequest.KEY_APP_INFO_DATA_PB);
                    GameInfoLoader gameInfoLoader2 = GameInfoLoader.this;
                    gameInfoLoader2.P(optJSONObject, bArr, optString, this.f346727b, gameInfoLoader2.f346690a.link, GameInfoLoader.this.f346690a.linkType);
                    return;
                }
                SDKMiniProgramLpReportDC04239.reportPageView(GameInfoLoader.this.f346690a, MiniReportManager.getAppType(GameInfoLoader.this.f346690a), null, "load_fail", "shortcut_request_fail");
                MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, GameInfoLoader.this.f346690a);
                GameInfoLoader gameInfoLoader3 = GameInfoLoader.this;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("request failed. isSuc:");
                sb6.append(z16);
                sb6.append(", ret is null:");
                if (jSONObject == null) {
                    str = "true";
                } else {
                    str = "false";
                }
                sb6.append(str);
                gameInfoLoader3.G(-13009L, sb6.toString(), this.f346726a);
            } catch (Throwable th5) {
                QMLog.e("GameInfoLoader", "", th5);
                GameInfoLoader.this.G(-13009L, "request failed. Throw error:" + th5.getMessage(), this.f346726a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void C(long j3, String str, com.tencent.qqmini.minigame.task.a aVar) {
        aVar.onGameLoadFailed(j3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void D(@NonNull MiniAppInfo miniAppInfo, boolean z16, com.tencent.qqmini.minigame.task.a aVar) {
        this.f346695f = System.currentTimeMillis() - this.f346694e;
        if (z16) {
            aVar.onAppInfoUpdateSuccess(miniAppInfo);
        }
        u(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(final long j3, final String str, final com.tencent.qqmini.minigame.task.a aVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C(j3, str, aVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.3
                @Override // java.lang.Runnable
                public void run() {
                    GameInfoLoader.this.C(j3, str, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@NonNull final MiniAppInfo miniAppInfo, final boolean z16, final com.tencent.qqmini.minigame.task.a aVar) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            D(miniAppInfo, z16, aVar);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.2
                @Override // java.lang.Runnable
                public void run() {
                    GameInfoLoader.this.D(miniAppInfo, z16, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void I(MiniGamePkg miniGamePkg, com.tencent.qqmini.minigame.task.a aVar) {
        MiniAppInfo miniAppInfo = this.f346690a;
        if (miniAppInfo != null) {
            ApkgInfo apkgInfo = new ApkgInfo(ApkgManager.getApkgFolderPath(miniAppInfo), this.f346690a);
            if (miniGamePkg != null) {
                apkgInfo.mConfigStr = miniGamePkg.mConfigStr;
            }
            MiniAppInfo miniAppInfo2 = this.f346690a;
            miniAppInfo2.apkgInfo = apkgInfo;
            aVar.onAppInfoUpdateSuccess(miniAppInfo2);
        }
        aVar.onGameInfoLoadSuccess(miniGamePkg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(final com.tencent.qqmini.minigame.task.a aVar, MiniAppInfo miniAppInfo, boolean z16) {
        StartupReportUtil.reportApkgDownload(miniAppInfo, System.currentTimeMillis() - this.f346696g, z16 ? 1 : 0, miniAppInfo.fileSize);
        final MiniGamePkg loadGamePkgFromFolderPath = MiniGamePkg.loadGamePkgFromFolderPath(com.tencent.qqmini.minigame.gpkg.c.b(miniAppInfo).getAbsolutePath(), null, miniAppInfo);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.10
            @Override // java.lang.Runnable
            public void run() {
                GameInfoLoader.this.f346691b = loadGamePkgFromFolderPath;
                GameInfoLoader.this.f346692c = null;
                GameInfoLoader.this.f346697h = System.currentTimeMillis() - GameInfoLoader.this.f346696g;
                GameInfoLoader gameInfoLoader = GameInfoLoader.this;
                gameInfoLoader.I(gameInfoLoader.f346691b, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(@NonNull MiniAppInfo miniAppInfo, @NonNull com.tencent.qqmini.minigame.task.a aVar) {
        boolean z16 = false;
        if (miniAppInfo.isFakeAppInfo()) {
            if (miniAppInfo.link != null) {
                z16 = true;
            }
            N(z16, aVar);
        } else {
            if (miniAppInfo.isShortcutFakeApp()) {
                N(false, aVar);
                return;
            }
            H(miniAppInfo, false, aVar);
            QMLog.i("GameInfoLoader", "[reloadMiniAppInfoIfNeeded] succeed:" + miniAppInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final MiniAppInfo miniAppInfo) {
        miniAppInfo.launchParam.clone(this.f346690a.launchParam);
        miniAppInfo.apkgInfo = this.f346690a.apkgInfo;
        miniAppInfo.launchParam.miniAppId = miniAppInfo.appId;
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.6
            @Override // java.lang.Runnable
            public void run() {
                SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
                if (specialProxy != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MiniAppConst.MINI_KEY_APPINFO, miniAppInfo);
                    specialProxy.sendEventToHost(1, bundle, null);
                }
            }
        });
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
            if (miniAppInfo.firstPage.pagePath.startsWith("/")) {
                FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
                firstPageInfo2.pagePath = firstPageInfo2.pagePath.substring(1);
            }
            if (miniAppInfo.firstPage.pagePath.contains(".html")) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath;
            } else if (miniAppInfo.firstPage.pagePath.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
            } else {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath + ".html";
            }
        }
        if (!TextUtils.isEmpty(this.f346690a.launchParam.extendData)) {
            miniAppInfo.extendData = this.f346690a.launchParam.extendData;
        }
        if (miniAppInfo.verType != 3) {
            miniAppInfo.launchParam.forceReload = 3;
        }
        this.f346690a = miniAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(final MiniAppInfo miniAppInfo, String str) {
        miniAppInfo.launchParam.clone(this.f346690a.launchParam);
        miniAppInfo.apkgInfo = this.f346690a.apkgInfo;
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.7
            @Override // java.lang.Runnable
            public void run() {
                SpecialProxy specialProxy = (SpecialProxy) ProxyManager.get(SpecialProxy.class);
                if (specialProxy != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(MiniAppConst.MINI_KEY_APPINFO, miniAppInfo);
                    specialProxy.sendEventToHost(1, bundle, null);
                }
            }
        });
        FirstPageInfo firstPageInfo = miniAppInfo.firstPage;
        if (firstPageInfo != null && !TextUtils.isEmpty(firstPageInfo.pagePath)) {
            if (miniAppInfo.firstPage.pagePath.startsWith("/")) {
                FirstPageInfo firstPageInfo2 = miniAppInfo.firstPage;
                firstPageInfo2.pagePath = firstPageInfo2.pagePath.substring(1);
            }
            if (miniAppInfo.firstPage.pagePath.contains(".html")) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath;
            } else if (miniAppInfo.firstPage.pagePath.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
            } else {
                miniAppInfo.launchParam.entryPath = miniAppInfo.firstPage.pagePath + ".html";
            }
        }
        LaunchParam launchParam = miniAppInfo.launchParam;
        launchParam.miniAppId = miniAppInfo.appId;
        launchParam.shareTicket = str;
        launchParam.navigateExtData = miniAppInfo.extraData;
        if (!TextUtils.isEmpty(str)) {
            miniAppInfo.launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(miniAppInfo.launchParam.reportData)) {
            miniAppInfo.launchParam.reportData = miniAppInfo.reportData;
        } else if (!TextUtils.isEmpty(miniAppInfo.reportData)) {
            miniAppInfo.launchParam.reportData = miniAppInfo.launchParam.reportData + ContainerUtils.FIELD_DELIMITER + miniAppInfo.reportData;
        }
        if (miniAppInfo.verType != 3) {
            miniAppInfo.launchParam.forceReload = 3;
        }
        this.f346690a = miniAppInfo;
    }

    private void N(boolean z16, com.tencent.qqmini.minigame.task.a aVar) {
        QMLog.i("GameInfoLoader", "[requestMiniAppInfo] isRequestByLink=" + z16);
        if (z16) {
            x(aVar);
        } else {
            w(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(JSONObject jSONObject, byte[] bArr, String str, MiniAppCacheProxy miniAppCacheProxy, String str2, String str3) {
        if (v(str)) {
            if (jSONObject != null) {
                INTERFACE$StApiAppInfo pbFromJSON = MiniAppInfo.pbFromJSON(jSONObject);
                if (pbFromJSON != null) {
                    QMLog.d("GameInfoLoader", "saveIdInfo cache.");
                    if (miniAppCacheProxy.saveIdInfo(str2, str3, pbFromJSON.get().toByteArray(), System.currentTimeMillis())) {
                        QMLog.d("GameInfoLoader", "saveIdInfo cache success.");
                        return;
                    }
                    return;
                }
                return;
            }
            if (bArr != null) {
                QMLog.d("GameInfoLoader", "saveIdInfo cache.");
                if (miniAppCacheProxy.saveIdInfo(str2, str3, bArr, System.currentTimeMillis())) {
                    QMLog.d("GameInfoLoader", "saveIdInfo cache success.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(JSONObject jSONObject, byte[] bArr, String str, MiniAppCacheProxy miniAppCacheProxy, String str2, int i3) {
        if (jSONObject != null) {
            INTERFACE$StApiAppInfo pbFromJSON = MiniAppInfo.pbFromJSON(jSONObject);
            if (pbFromJSON != null) {
                QMLog.d("GameInfoLoader", "saveLinkInfo cache.");
                if (miniAppCacheProxy.saveLinkInfo(str2, i3, str, pbFromJSON.get().toByteArray(), System.currentTimeMillis())) {
                    QMLog.d("GameInfoLoader", "saveLinkInfo cache success.");
                    return;
                }
                return;
            }
            return;
        }
        if (bArr != null) {
            QMLog.d("GameInfoLoader", "saveLinkInfo cache.");
            if (miniAppCacheProxy.saveLinkInfo(str2, i3, str, bArr, System.currentTimeMillis())) {
                QMLog.d("GameInfoLoader", "saveLinkInfo cache success.");
            }
        }
    }

    @MainThread
    private void u(final com.tencent.qqmini.minigame.task.a aVar) {
        String str;
        String str2;
        this.f346696g = System.currentTimeMillis();
        final MiniAppInfo miniAppInfo = this.f346690a;
        if (miniAppInfo != null && (str2 = miniAppInfo.appId) != null) {
            MiniGamePkg miniGamePkg = this.f346691b;
            if (miniGamePkg != null && str2.equals(miniGamePkg.appId)) {
                QMLog.i("GameInfoLoader", " loadGpkgByConfig appid " + miniAppInfo.appId + " has loaded.");
                this.f346697h = System.currentTimeMillis() - this.f346697h;
                I(this.f346691b, aVar);
                return;
            }
            String str3 = this.f346692c;
            if (str3 != null && str3.equals(miniAppInfo.appId)) {
                QMLog.i("GameInfoLoader", " loadGpkgByConfig appid " + miniAppInfo.appId + " is loading.");
                return;
            }
            QMLog.i("GameInfoLoader", " start loadGpkgByConfig appid:" + miniAppInfo.appId);
            this.f346692c = miniAppInfo.appId;
            this.f346691b = null;
            ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.8
                @Override // java.lang.Runnable
                public void run() {
                    GameInfoLoader.this.y(aVar, miniAppInfo);
                }
            });
            return;
        }
        QMLog.e("GameInfoLoader", " loadGpkgByConfig failed " + miniAppInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u914d\u7f6e\u9519\u8bef\u3002ready loadGpkgByConfig failed because app id invalid:");
        MiniAppInfo miniAppInfo2 = this.f346690a;
        if (miniAppInfo2 == null) {
            str = "appInfo is null";
        } else {
            str = miniAppInfo2.appId;
        }
        sb5.append(str);
        G(2002L, sb5.toString(), aVar);
        this.f346691b = null;
    }

    private boolean v(String str) {
        if (!TextUtils.isEmpty(str) && !"release".equals(str)) {
            return false;
        }
        return true;
    }

    private void w(com.tencent.qqmini.minigame.task.a aVar) {
        MiniAppInfo miniAppInfo = this.f346690a;
        String str = miniAppInfo.firstPath;
        String str2 = "";
        if (str == null && (str = miniAppInfo.launchParam.entryPath) == null) {
            str = "";
        }
        String str3 = miniAppInfo.launchParam.envVersion;
        if (str3 != null) {
            str2 = str3;
        }
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAppInfoById(this.f346690a.appId, str, str2, new a(aVar, str2, (MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class), str));
    }

    private void x(com.tencent.qqmini.minigame.task.a aVar) {
        z((MiniAppCacheProxy) ProxyManager.get(MiniAppCacheProxy.class), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(final com.tencent.qqmini.minigame.task.a aVar, final MiniAppInfo miniAppInfo) {
        boolean d16 = com.tencent.qqmini.minigame.gpkg.c.d(miniAppInfo);
        boolean e16 = com.tencent.qqmini.minigame.gpkg.c.e(miniAppInfo);
        QMLog.i("GameInfoLoader", "downloadGamePkgIfNeed: isDebugGame=" + d16 + ", isGamePkgAndPluginExists=" + e16);
        if (!d16 && e16) {
            J(aVar, miniAppInfo, true);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        QMLog.i("GameInfoLoader", "downloadGamePkgIfNeed: " + miniAppInfo + ", load pkg in main process");
        this.f346698i = 0.0f;
        com.tencent.qqmini.sdk.manager.a.a(miniAppInfo, false, new a.b() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.9
            @Override // com.tencent.qqmini.sdk.manager.a.b
            public void onFail(@NonNull final String str) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.9.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String str2 = " getGpkgInfoByConfig appid=" + miniAppInfo.appId + ", fail " + str;
                        QMLog.e("GameInfoLoader", str2);
                        GameInfoLoader.this.f346691b = null;
                        GameInfoLoader.this.f346692c = null;
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        GameInfoLoader.this.G(2004L, str2, aVar);
                        GameInfoLoader.this.f346691b = null;
                    }
                });
            }

            @Override // com.tencent.qqmini.sdk.manager.a.b
            public void onProgress(final float f16, long j3) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        if (f16 - GameInfoLoader.this.f346698i > 0.1f) {
                            GameInfoLoader.this.f346698i = f16;
                            str = String.format(Locale.getDefault(), "%.2f", Float.valueOf(f16 * 100.0f)) + "%";
                        } else {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            aVar.notifyRuntimeEvent(2001, new LoadingStatus.Builder().setProgress(f16).build());
                        }
                    }
                });
            }

            @Override // com.tencent.qqmini.sdk.manager.a.b
            public void onSuccess() {
                QMLog.i("GameInfoLoader", "downloadGamePkgIfNeed: success, cost=" + (System.currentTimeMillis() - currentTimeMillis));
                GameInfoLoader.this.J(aVar, miniAppInfo, false);
            }
        });
    }

    private void z(MiniAppCacheProxy miniAppCacheProxy, com.tencent.qqmini.minigame.task.a aVar) {
        ChannelProxy channelProxy = (ChannelProxy) ProxyManager.get(ChannelProxy.class);
        MiniAppInfo miniAppInfo = this.f346690a;
        channelProxy.getAppInfoByLink(miniAppInfo.link, miniAppInfo.linkType, new b(aVar, miniAppCacheProxy));
    }

    public TaskExecutionStatics A() {
        TaskExecutionStatics.Status status;
        TaskExecutionStatics.Status status2;
        ArrayList arrayList = new ArrayList();
        if (this.f346691b != null) {
            status = TaskExecutionStatics.Status.SUCCESS;
        } else {
            status = TaskExecutionStatics.Status.FAIL;
        }
        long j3 = this.f346695f;
        arrayList.add(new TaskExecutionStatics("AppInfoLoader", j3, j3, status, "", Collections.emptyList()));
        if (this.f346691b != null) {
            status2 = TaskExecutionStatics.Status.SUCCESS;
        } else {
            status2 = TaskExecutionStatics.Status.FAIL;
        }
        TaskExecutionStatics.Status status3 = status2;
        long j16 = this.f346697h;
        arrayList.add(new TaskExecutionStatics("GamePkgLoader", j16, j16, status3, "", Collections.emptyList()));
        long j17 = this.f346695f;
        long j18 = this.f346697h;
        return new TaskExecutionStatics("GameInfoLoder", j17 + j18, j18 + j17, status3, "", arrayList);
    }

    public MiniGamePkg B() {
        return this.f346691b;
    }

    public boolean E() {
        if (this.f346690a != null && this.f346691b != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public void F(@NonNull final MiniAppInfo miniAppInfo, @NonNull final com.tencent.qqmini.minigame.task.a aVar) {
        if (miniAppInfo.equals(this.f346690a) && this.f346693d != null) {
            aVar.onGameInfoLoadSuccess(this.f346691b);
            return;
        }
        this.f346690a = miniAppInfo;
        this.f346694e = System.currentTimeMillis();
        ThreadManager.runNetTask(new Runnable() { // from class: com.tencent.qqmini.minigame.task.GameInfoLoader.1
            @Override // java.lang.Runnable
            public void run() {
                GameInfoLoader.this.K(miniAppInfo, aVar);
            }
        });
    }
}
