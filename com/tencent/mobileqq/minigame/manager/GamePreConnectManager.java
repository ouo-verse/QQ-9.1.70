package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes33.dex */
public class GamePreConnectManager {
    private static final String CONNECTION_KEEP_ALIVE = "keep-alive";
    private static final String DELIMITER = ",";
    private static final String HEADER_CONNECTION = "Connection";
    private static final String HOST_HTTPS_PREFIX = "https://";
    private static final String SHARED_PREFERENCES_NAME = "MiniGamePreConnect";
    private static final String TAG = "GamePreConnectManager";
    public static long lastMiniAppLaunched;
    private static final int PRE_CONNECTION_LIMIT = GameWnsUtils.getPreConnectNum();
    private static final String PRE_CONNECT_BLACK_APP_ID_LIST = GameWnsUtils.getPreConnectBlackAppIdList();
    private static volatile boolean sPreConnectDownloader = false;
    private static Set<String> connectUrlSet = new HashSet();
    private static boolean sHasSaveHostList = false;
    public static final long MINI_APP_PRECONNECTION_DURATION_MS = GameWnsUtils.getPreconnectTimeInterval() * 1000;

    public static void connectHost(MiniGamePkg miniGamePkg) {
        MiniAppInfo miniAppInfo;
        List<String> list;
        if (PRE_CONNECTION_LIMIT > 0 && miniGamePkg != null && connectHostEnable(miniGamePkg.appId)) {
            List<String> savedHost = getSavedHost(miniGamePkg.appId);
            if (savedHost != null && !savedHost.isEmpty()) {
                GameLog.getInstance().i(TAG, "connect local host");
                connectHost(savedHost);
                return;
            }
            GameLog.getInstance().i(TAG, "connect remote host");
            MiniAppConfig miniAppConfig = miniGamePkg.appConfig;
            if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || (list = miniAppInfo.requestDomainList) == null || list.size() <= 0) {
                return;
            }
            connectHost(miniGamePkg.appConfig.config.requestDomainList);
        }
    }

    private static boolean connectHostEnable(String str) {
        String[] split;
        String str2 = PRE_CONNECT_BLACK_APP_ID_LIST;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && (split = str2.split(",")) != null && split.length > 0) {
            for (String str3 : split) {
                if (str.equals(str3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String getFromSharedPreference(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return BaseApplicationImpl.getApplication().getSharedPreferences(str, 0).getString(str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getHost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            GameLog.getInstance().e(TAG, "getHost exception " + str);
            return null;
        }
    }

    private static List<String> getSavedHost(String str) {
        String fromSharedPreference = getFromSharedPreference(SHARED_PREFERENCES_NAME, str);
        if (TextUtils.isEmpty(fromSharedPreference)) {
            return null;
        }
        return Arrays.asList(fromSharedPreference.split(","));
    }

    public static boolean isMiniAppRecentlyLaunched() {
        lastMiniAppLaunched = MiniAppLauncher.getLastMiniAppUsedTime();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = lastMiniAppLaunched;
        boolean z16 = j3 != 0 && currentTimeMillis - j3 < MINI_APP_PRECONNECTION_DURATION_MS;
        QLog.d(TAG, 1, "current time = " + currentTimeMillis + "ms; lastMiniAppLaunchedTime = " + lastMiniAppLaunched + "ms; time interval = " + (currentTimeMillis - lastMiniAppLaunched) + "ms; miniAppPreconnectionDuration = " + MINI_APP_PRECONNECTION_DURATION_MS + "ms; isMiniAppRecentlyLaunched = " + z16);
        return z16;
    }

    public static void onUrlConnect(final String str, final int i3) {
        ThreadPools.getComputationThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GamePreConnectManager.2
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                if (!GamePreConnectManager.sHasSaveHostList && GamePreConnectManager.connectUrlSet.size() < GamePreConnectManager.PRE_CONNECTION_LIMIT && (i16 = i3) >= 200 && i16 <= 300) {
                    String host = GamePreConnectManager.getHost(str);
                    if (TextUtils.isEmpty(host) || !GamePreConnectManager.connectUrlSet.add(host)) {
                        return;
                    }
                    GameLog.getInstance().i(GamePreConnectManager.TAG, "insert host: " + host);
                }
            }
        });
    }

    public static void preConnectDownloaderForSDK() {
        if (sPreConnectDownloader || !GameWnsUtils.enableDownloaderPreConnect()) {
            return;
        }
        ThreadPools.getComputationThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GamePreConnectManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (GamePreConnectManager.isMiniAppRecentlyLaunched()) {
                    GamePreConnectManager.sPreConnectDownloader = true;
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(GameWnsUtils.downloaderPreConnectHost());
                    MiniappDownloadUtil.getInstance().preConnectHost(arrayList, GameWnsUtils.getPreconnectMethod());
                }
            }
        });
    }

    public static void reset() {
        ThreadPools.getComputationThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GamePreConnectManager.1
            @Override // java.lang.Runnable
            public void run() {
                GamePreConnectManager.sHasSaveHostList = false;
                GamePreConnectManager.connectUrlSet.clear();
            }
        });
    }

    public static void saveConnectHost(final String str) {
        ThreadPools.getComputationThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.GamePreConnectManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (GamePreConnectManager.sHasSaveHostList) {
                    GameLog.getInstance().e(GamePreConnectManager.TAG, "had saved, no saved needed");
                    return;
                }
                if (GamePreConnectManager.connectUrlSet.isEmpty() || TextUtils.isEmpty(str)) {
                    return;
                }
                GamePreConnectManager.saveToSharedPreference(GamePreConnectManager.SHARED_PREFERENCES_NAME, str, TextUtils.join(",", GamePreConnectManager.connectUrlSet));
                GameLog.getInstance().i(GamePreConnectManager.TAG, "save connect host " + GamePreConnectManager.connectUrlSet.size());
                GamePreConnectManager.connectUrlSet.clear();
                GamePreConnectManager.sHasSaveHostList = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveToSharedPreference(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        BaseApplicationImpl.getApplication().getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }

    private static boolean tryConnectHost(final String str) {
        try {
            GameLog.getInstance().i(TAG, "try pre-connect:" + str);
            final long currentTimeMillis = System.currentTimeMillis();
            MiniOkHttpClientFactory.getRequestClient().newCall(new Request.Builder().url(str).addHeader("Connection", CONNECTION_KEEP_ALIVE).head().build()).enqueue(new Callback() { // from class: com.tencent.mobileqq.minigame.manager.GamePreConnectManager.4
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    GameLog.getInstance().e(GamePreConnectManager.TAG, "pre-connect onFailure: " + str);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    GameLog.getInstance().i(GamePreConnectManager.TAG, "onResponse [timecost: " + (currentTimeMillis2 - currentTimeMillis) + "] [url: " + str + "] [code: " + response.code() + "]");
                }
            });
            return true;
        } catch (RuntimeException e16) {
            GameLog.getInstance().e(TAG, "tryConnectHost exception ", e16);
            return false;
        }
    }

    private static void connectHost(List<String> list) {
        int i3 = 0;
        for (String str : list) {
            if (i3 >= PRE_CONNECTION_LIMIT) {
                return;
            }
            if (tryConnectHost("https://" + str)) {
                i3++;
            }
        }
    }
}
