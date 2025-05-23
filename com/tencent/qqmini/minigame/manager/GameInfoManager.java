package com.tencent.qqmini.minigame.manager;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.utils.GameLog;
import com.tencent.qqmini.minigame.utils.PathUtil;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.FirstPageInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GameInfoManager {
    public static final String EVENT_APP_ENTER_BACKGROUND = "onAppEnterBackground";
    public static final String EVENT_APP_ENTER_FOREGROUND = "onAppEnterForeground";
    public static final String GAME_STOP = "onAppStop";
    private static final String TAG = "GameInfoManager";
    private GameRuntimeLoader gameRuntimeLoader;
    private LaunchOptions launchOptions;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class LaunchOptions {
        public int scene = 1001;
        public JSONObject query = new JSONObject();
        public String navigateExtData = null;
        public String shareTicket = null;
        public String fromMiniAppId = null;
        public String entryDataHash = null;

        LaunchOptions() {
        }
    }

    public GameInfoManager(GameRuntimeLoader gameRuntimeLoader) {
        this.gameRuntimeLoader = gameRuntimeLoader;
    }

    private String getFromMiniAppId() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo == null) {
            return null;
        }
        QMLog.i(TAG, "getFromMiniAppId = " + miniAppInfo.launchParam.fromMiniAppId);
        if (TextUtils.isEmpty(miniAppInfo.launchParam.fromMiniAppId)) {
            return null;
        }
        return miniAppInfo.launchParam.fromMiniAppId;
    }

    public String getAppName() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null) {
            QMLog.i(TAG, "getAppId() = " + miniAppInfo.appId);
            return miniAppInfo.name;
        }
        QMLog.e(TAG, "getAppId() error");
        return null;
    }

    public String getEntryDataHash() {
        EntryModel entryModel;
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null && (entryModel = miniAppInfo.launchParam.entryModel) != null) {
            return entryModel.getEntryHash();
        }
        return null;
    }

    public String getExtendData() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo == null) {
            return null;
        }
        QMLog.i(TAG, "getExtendData = " + miniAppInfo.extendData);
        if (TextUtils.isEmpty(miniAppInfo.extendData)) {
            return null;
        }
        return miniAppInfo.extendData;
    }

    public LaunchOptions getLaunchOptions() {
        LaunchOptions launchOptions = this.launchOptions;
        if (launchOptions == null) {
            return new LaunchOptions();
        }
        return launchOptions;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.gameRuntimeLoader.getMiniAppInfo();
    }

    public MiniGamePkg getMiniGamePkg() {
        return this.gameRuntimeLoader.getMiniGamePkg();
    }

    public String getNavigateExtData() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo == null || miniAppInfo.launchParam == null) {
            return null;
        }
        QMLog.i(TAG, "getNavigateExtData = " + miniAppInfo.launchParam.navigateExtData);
        if (TextUtils.isEmpty(miniAppInfo.launchParam.navigateExtData)) {
            return null;
        }
        return miniAppInfo.launchParam.navigateExtData;
    }

    public JSONObject getOnShowParam() {
        JSONObject jSONObject = new JSONObject();
        JSONObject queryPath = getQueryPath();
        if (queryPath == null) {
            queryPath = new JSONObject();
        }
        int scene = getScene();
        String shareTicket = getShareTicket();
        String fromMiniAppId = getFromMiniAppId();
        String navigateExtData = getNavigateExtData();
        String entryDataHash = getEntryDataHash();
        try {
            new JSONObject();
            jSONObject.put("query", queryPath);
            jSONObject.put("entryDataHash", entryDataHash);
        } catch (Exception e16) {
            GameLog.getInstance().e(TAG, "onForeground exception put query string :" + e16);
        }
        try {
            jSONObject.put("scene", AppBrandUtil.getWikiScene(scene));
        } catch (Exception e17) {
            GameLog.getInstance().e(TAG, "onForeground exception put scene string :" + e17);
        }
        try {
            jSONObject.put("shareTicket", shareTicket);
        } catch (Exception e18) {
            GameLog.getInstance().e(TAG, "onForeground exception put shareTicket string :" + e18);
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appId", fromMiniAppId);
            jSONObject2.put(WadlProxyConsts.EXTRA_DATA, navigateExtData);
            jSONObject.put("referrerInfo", jSONObject2);
        } catch (Exception e19) {
            GameLog.getInstance().e(TAG, "onForeground exception put referrerInfo string :" + e19);
        }
        return jSONObject;
    }

    public JSONObject getQueryPath() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null && miniAppInfo.firstPage != null) {
            QMLog.i(TAG, "getQueryPath = " + miniAppInfo.firstPage.pagePath);
            if ("miniGamePath".equals(miniAppInfo.firstPage.pagePath)) {
                return new JSONObject();
            }
            return PathUtil.getJSONQueryString(miniAppInfo.firstPage.pagePath);
        }
        return new JSONObject();
    }

    public int getScene() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null && miniAppInfo.launchParam != null) {
            QMLog.i(TAG, "getScene = " + miniAppInfo.launchParam.scene);
            return miniAppInfo.launchParam.scene;
        }
        return 1001;
    }

    public String getShareTicket() {
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo == null || miniAppInfo.launchParam == null) {
            return null;
        }
        QMLog.i(TAG, "getShareTicket = " + miniAppInfo.launchParam.shareTicket);
        if (TextUtils.isEmpty(miniAppInfo.launchParam.shareTicket)) {
            return null;
        }
        return miniAppInfo.launchParam.shareTicket;
    }

    public void resetQuery() {
        FirstPageInfo firstPageInfo;
        MiniAppInfo miniAppInfo = getMiniAppInfo();
        if (miniAppInfo != null && (firstPageInfo = miniAppInfo.firstPage) != null) {
            firstPageInfo.setPagePath(null);
        }
    }

    public void setLaunchOptions() {
        LaunchOptions launchOptions = new LaunchOptions();
        this.launchOptions = launchOptions;
        launchOptions.scene = getScene();
        this.launchOptions.query = getQueryPath();
        this.launchOptions.shareTicket = getShareTicket();
        this.launchOptions.navigateExtData = getNavigateExtData();
        this.launchOptions.fromMiniAppId = getFromMiniAppId();
        this.launchOptions.entryDataHash = getEntryDataHash();
    }
}
