package com.tencent.mobileqq.minigame.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.mini.app.AppBrandTaskPreloadReceiver3;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SplashMiniGameStarter {
    public static final String KEY_SPLASH_DATA_SIZE = "splash_data_size";
    public static final String PATH_SPLASH = "/data/data/com.tencent.mobileqq/files/minigame/splash/";
    public static final String SETTING_SPLASH = "minigame_splash_setting";
    public static final String TAG = "SplashMiniGameStarter";
    private static String appVersionInConfig = null;
    public static SplashMiniGameData curData = null;
    public static HashMap<String, SplashMiniGameData> dataMap = null;
    public static boolean hasClickJumpBtn = false;
    public static boolean hasJumped = false;
    public static boolean hasPreloaded = false;
    public static boolean needJump = false;
    private static ArrayList<String> syncPlayList = new ArrayList<>();

    public static void clearAllConfig() {
        BaseApplicationImpl.getApplication().getSharedPreferences(SETTING_SPLASH, 0).edit().clear().commit();
    }

    private static String getFilePath(String str) {
        File file = new File(PATH_SPLASH + str);
        if (file.exists()) {
            return PATH_SPLASH + str;
        }
        if (!file.mkdirs()) {
            return null;
        }
        return PATH_SPLASH + str;
    }

    private static HashMap<String, SplashMiniGameData> loadConfig() {
        SharedPreferences sharedPreferences;
        int i3;
        if (MiniGameMMKVUtils.INSTANCE.getInt(KEY_SPLASH_DATA_SIZE) <= 0 || (i3 = (sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(SETTING_SPLASH, 0)).getInt("size", 0)) == 0) {
            return null;
        }
        HashMap<String, SplashMiniGameData> hashMap = new HashMap<>();
        for (int i16 = 0; i16 < i3; i16++) {
            String string = sharedPreferences.getString(Integer.toString(i16), "");
            if (!TextUtils.isEmpty(string)) {
                SplashMiniGameData splashMiniGameData = new SplashMiniGameData();
                splashMiniGameData.enable = sharedPreferences.getInt("enable_" + string, 0);
                splashMiniGameData.guide = sharedPreferences.getInt("guide_" + string, 0);
                splashMiniGameData.appId = string;
                splashMiniGameData.videoUrl = sharedPreferences.getString("video_url_" + string, "");
                splashMiniGameData.videoDuration = sharedPreferences.getInt("video_duration_" + string, 10);
                splashMiniGameData.videoMute = sharedPreferences.getInt("video_mute_" + string, 1);
                splashMiniGameData.picUrl = sharedPreferences.getString("pic_url_" + string, "");
                splashMiniGameData.desc = sharedPreferences.getString("desc_" + string, "");
                splashMiniGameData.developerDesc = sharedPreferences.getString("developer_desc_" + string, "");
                splashMiniGameData.downloadUrl = sharedPreferences.getString("download_url_" + string, "");
                splashMiniGameData.fileSize = sharedPreferences.getInt("file_size_" + string, 0);
                splashMiniGameData.iconUrl = sharedPreferences.getString("icon_url_" + string, "");
                splashMiniGameData.version = sharedPreferences.getString("version_" + string, "");
                splashMiniGameData.name = sharedPreferences.getString("name_" + string, "");
                splashMiniGameData.isPlayed = Boolean.valueOf(sharedPreferences.getBoolean("isplayed_" + string, false));
                splashMiniGameData.videoLocalPath = sharedPreferences.getString("videoLocalPath_" + string, "");
                splashMiniGameData.picLocalPath = sharedPreferences.getString("picLocalPath_" + string, "");
                splashMiniGameData.startTime = sharedPreferences.getLong("startTime_" + string, 0L);
                splashMiniGameData.endTime = sharedPreferences.getLong("endTime_" + string, 0L);
                splashMiniGameData.priority = sharedPreferences.getInt("priority_" + string, 10);
                Set<String> stringSet = sharedPreferences.getStringSet("request_DomainList_" + string, null);
                if (stringSet != null) {
                    splashMiniGameData.requestDomianList = new ArrayList<>(stringSet);
                }
                Set<String> stringSet2 = sharedPreferences.getStringSet("downloadFile_DomainList_" + string, null);
                if (stringSet2 != null) {
                    splashMiniGameData.downloadFileDomianList = new ArrayList<>(stringSet2);
                }
                hashMap.put(string, splashMiniGameData);
            }
        }
        appVersionInConfig = sharedPreferences.getString("appVersion", "");
        return hashMap;
    }

    public static boolean needShow() {
        HashMap<String, SplashMiniGameData> loadConfig = loadConfig();
        dataMap = loadConfig;
        if (loadConfig == null || loadConfig.size() == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        for (SplashMiniGameData splashMiniGameData : dataMap.values()) {
            if (splashMiniGameData.enable == 1 && currentTimeMillis > splashMiniGameData.startTime && currentTimeMillis < splashMiniGameData.endTime && !splashMiniGameData.isPlayed.booleanValue() && !TextUtils.isEmpty(splashMiniGameData.videoLocalPath) && !TextUtils.isEmpty(splashMiniGameData.picLocalPath) && new File(splashMiniGameData.videoLocalPath).exists() && new File(splashMiniGameData.picLocalPath).exists()) {
                SplashMiniGameData splashMiniGameData2 = curData;
                if (splashMiniGameData2 == null) {
                    curData = splashMiniGameData;
                } else if (splashMiniGameData2.priority >= splashMiniGameData.priority) {
                    syncPlayList.add(splashMiniGameData2.appId);
                    curData = splashMiniGameData;
                }
            }
        }
        SplashMiniGameData splashMiniGameData3 = curData;
        if (splashMiniGameData3 != null && splashMiniGameData3.guide == 1) {
            setNeedShowGuideInConf(false);
        }
        QLog.d(TAG, 2, "michael curData:" + curData);
        return curData != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0.guide == 1) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean needShowGuide() {
        boolean z16;
        if (hasJumped && (r0 = curData) != null) {
            z16 = true;
        }
        z16 = false;
        return !z16 ? BaseApplicationImpl.getApplication().getSharedPreferences(SETTING_SPLASH, 0).getBoolean("needshowguide", false) : z16;
    }

    public static void preloadGameProcess() {
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        Intent intent = new Intent();
        intent.setClass(baseApplicationImpl, AppBrandTaskPreloadReceiver3.class);
        intent.setAction("mini_preload__splash_game");
        baseApplicationImpl.sendBroadcast(intent);
    }

    public static void preloadMiniGame() {
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        Intent intent = new Intent();
        intent.setClass(baseApplicationImpl, AppBrandTaskPreloadReceiver3.class);
        intent.setAction("mini_preload__splash_game");
        intent.putExtra("splashData", curData);
        baseApplicationImpl.sendBroadcast(intent);
        hasPreloaded = true;
        needJump = true;
    }

    public static void preloadProcess() {
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        Intent intent = new Intent();
        intent.setClass(baseApplicationImpl, AppBrandTaskPreloadReceiver.class);
        intent.setAction(MiniSDKConst.ACTION_PRELOAD_APP);
        intent.putExtra("splashData", curData);
        baseApplicationImpl.sendBroadcast(intent);
    }

    public static void refresh() {
        dataMap = loadConfig();
    }

    public static void setNeedShow(boolean z16) {
        if (curData != null) {
            SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(SETTING_SPLASH, 0).edit();
            edit.putBoolean("isplayed_" + curData.appId, !z16);
            Iterator<String> it = syncPlayList.iterator();
            while (it.hasNext()) {
                edit.putBoolean("isplayed_" + it.next(), !z16);
            }
            edit.commit();
        }
    }

    public static void setNeedShowGuideInConf(boolean z16) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(SETTING_SPLASH, 0).edit();
        edit.putBoolean("needshowguide", z16);
        edit.apply();
    }

    public static void setHasJumped() {
        hasJumped = true;
        SplashMiniGameData splashMiniGameData = curData;
        if (splashMiniGameData == null || splashMiniGameData.guide != 1) {
            return;
        }
        setNeedShowGuideInConf(true);
    }
}
