package com.tencent.mobileqq.minigame.splash;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SplashMiniGameUtil {
    public static final String TAG = "SplashMiniGameUtil";

    private static void addConfig(int i3, SplashMiniGameData splashMiniGameData) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0).edit();
        edit.putString(Integer.toString(i3), splashMiniGameData.appId);
        edit.putInt("enable_" + splashMiniGameData.appId, splashMiniGameData.enable);
        edit.putInt("guide_" + splashMiniGameData.appId, splashMiniGameData.guide);
        edit.putString("video_url_" + splashMiniGameData.appId, splashMiniGameData.videoUrl);
        edit.putInt("video_duration_" + splashMiniGameData.appId, splashMiniGameData.videoDuration);
        edit.putInt("video_mute_" + splashMiniGameData.appId, splashMiniGameData.videoMute);
        edit.putString("pic_url_" + splashMiniGameData.appId, splashMiniGameData.picUrl);
        edit.putString("desc_" + splashMiniGameData.appId, splashMiniGameData.desc);
        edit.putString("developer_desc_" + splashMiniGameData.appId, splashMiniGameData.developerDesc);
        edit.putString("download_url_" + splashMiniGameData.appId, splashMiniGameData.downloadUrl);
        edit.putInt("file_size_" + splashMiniGameData.appId, splashMiniGameData.fileSize);
        edit.putString("icon_url_" + splashMiniGameData.appId, splashMiniGameData.iconUrl);
        edit.putString("version_" + splashMiniGameData.appId, splashMiniGameData.version);
        edit.putString("name_" + splashMiniGameData.appId, splashMiniGameData.name);
        edit.putBoolean("isplayed_" + splashMiniGameData.appId, false);
        edit.putString("videoLocalPath_" + splashMiniGameData.appId, "");
        edit.putString("picLocalPath_" + splashMiniGameData.appId, "");
        edit.putLong("startTime_" + splashMiniGameData.appId, splashMiniGameData.startTime);
        edit.putLong("endTime_" + splashMiniGameData.appId, splashMiniGameData.endTime);
        edit.putInt("priority_" + splashMiniGameData.appId, splashMiniGameData.priority);
        if (splashMiniGameData.requestDomianList != null) {
            edit.putStringSet("request_DomainList_" + splashMiniGameData.appId, new HashSet(splashMiniGameData.requestDomianList));
        }
        if (splashMiniGameData.downloadFileDomianList != null) {
            edit.putStringSet("downloadFile_DomainList_" + splashMiniGameData.appId, new HashSet(splashMiniGameData.downloadFileDomianList));
        }
        edit.commit();
        String filePath = getFilePath(splashMiniGameData.appId);
        if (filePath != null) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(filePath);
            String str = File.separator;
            sb5.append(str);
            sb5.append("splash.mp4");
            File file = new File(sb5.toString());
            if (file.exists()) {
                file.delete();
            }
            SplashMiniGameDownloadManager.downloadRes(qQAppInterface, splashMiniGameData.appId, splashMiniGameData.videoUrl, filePath + str + "splash.mp4", 1);
            if (new File(filePath + str + "splash.zip").exists()) {
                file.delete();
            }
            SplashMiniGameDownloadManager.downloadRes(qQAppInterface, splashMiniGameData.appId, splashMiniGameData.picUrl, filePath + str + "splash.zip", 0);
        }
        preloadMiniGame(splashMiniGameData);
    }

    private static void deleteConfig(ArrayList<SplashMiniGameData> arrayList) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0).edit();
        Iterator<SplashMiniGameData> it = arrayList.iterator();
        while (it.hasNext()) {
            SplashMiniGameData next = it.next();
            edit.remove("enable_" + next.appId);
            edit.remove("guide_" + next.appId);
            edit.remove("video_url_" + next.appId);
            edit.remove("video_duration_" + next.appId);
            edit.remove("video_mute_" + next.appId);
            edit.remove("pic_url_" + next.appId);
            edit.remove("desc_" + next.appId);
            edit.remove("developer_desc_" + next.appId);
            edit.remove("download_url_" + next.appId);
            edit.remove("file_size_" + next.appId);
            edit.remove("icon_url_" + next.appId);
            edit.remove("version_" + next.appId);
            edit.remove("name_" + next.appId);
            edit.remove("isplayed_" + next.appId);
            edit.remove("videoLocalPath_" + next.appId);
            edit.remove("picLocalPath_" + next.appId);
            edit.remove("startTime_" + next.appId);
            edit.remove("endTime_" + next.appId);
            edit.remove("priority_" + next.appId);
            edit.remove("request_DomainList_" + next.appId);
            edit.remove("downloadFile_DomainList_" + next.appId);
            FileUtils.deleteDirectory(getFilePath(next.appId));
        }
        edit.commit();
    }

    public static void downloadSuccess(String str, int i3, String str2) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0).edit();
        if (i3 == 0) {
            edit.putString("picLocalPath_" + str, str2);
        } else if (i3 == 1) {
            edit.putString("videoLocalPath_" + str, str2);
        }
        edit.commit();
    }

    private static String getFilePath(String str) {
        File file = new File(SplashMiniGameStarter.PATH_SPLASH + str);
        if (file.exists()) {
            return SplashMiniGameStarter.PATH_SPLASH + str;
        }
        if (!file.mkdirs()) {
            return null;
        }
        return SplashMiniGameStarter.PATH_SPLASH + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0347, code lost:
    
        if (new java.io.File(r3 + java.io.File.separator + "splash.mp4").exists() == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x038a, code lost:
    
        if (new java.io.File(r3 + java.io.File.separator + "splash.zip").exists() == false) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void modifyConfig(int i3, SplashMiniGameData splashMiniGameData, SplashMiniGameData splashMiniGameData2) {
        boolean z16;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(Integer.toString(i3), splashMiniGameData2.appId);
        if (splashMiniGameData.enable != splashMiniGameData2.enable) {
            edit.putInt("enable_" + splashMiniGameData2.appId, splashMiniGameData2.enable);
        }
        if (splashMiniGameData.guide != splashMiniGameData2.guide) {
            edit.putInt("guide_" + splashMiniGameData2.appId, splashMiniGameData2.guide);
        }
        if (!splashMiniGameData.videoUrl.equals(splashMiniGameData2.videoUrl)) {
            edit.putString("video_url_" + splashMiniGameData2.appId, splashMiniGameData2.videoUrl);
            edit.putString("videoLocalPath_" + splashMiniGameData2.appId, "");
            if (splashMiniGameData.videoLocalPath != null) {
                File file = new File(splashMiniGameData.videoLocalPath);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        if (splashMiniGameData.videoDuration != splashMiniGameData2.videoDuration) {
            edit.putInt("video_duration_" + splashMiniGameData2.appId, splashMiniGameData2.videoDuration);
        }
        if (splashMiniGameData.videoMute != splashMiniGameData2.videoMute) {
            edit.putInt("video_mute_" + splashMiniGameData2.appId, splashMiniGameData2.videoMute);
        }
        if (!splashMiniGameData.picUrl.equals(splashMiniGameData2.picUrl)) {
            edit.putString("pic_url_" + splashMiniGameData2.appId, splashMiniGameData2.picUrl);
            edit.putString("picLocalPath_" + splashMiniGameData2.appId, "");
            if (splashMiniGameData.picLocalPath != null) {
                File file2 = new File(splashMiniGameData.picLocalPath);
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
        if (!splashMiniGameData.desc.equals(splashMiniGameData2.desc)) {
            edit.putString("desc_" + splashMiniGameData2.appId, splashMiniGameData2.desc);
        }
        if (!splashMiniGameData.developerDesc.equals(splashMiniGameData2.developerDesc)) {
            edit.putString("developer_desc_" + splashMiniGameData2.appId, splashMiniGameData2.developerDesc);
        }
        if (splashMiniGameData.downloadUrl.equals(splashMiniGameData2.downloadUrl)) {
            z16 = false;
        } else {
            edit.putString("download_url_" + splashMiniGameData2.appId, splashMiniGameData2.downloadUrl);
            z16 = true;
        }
        if (splashMiniGameData.fileSize != splashMiniGameData2.fileSize) {
            edit.putInt("file_size_" + splashMiniGameData2.appId, splashMiniGameData2.fileSize);
        }
        if (!splashMiniGameData.iconUrl.equals(splashMiniGameData2.iconUrl)) {
            edit.putString("icon_url_" + splashMiniGameData2.appId, splashMiniGameData2.iconUrl);
        }
        if (!splashMiniGameData.version.equals(splashMiniGameData2.version)) {
            edit.putString("version_" + splashMiniGameData2.appId, splashMiniGameData2.version);
        }
        if (!splashMiniGameData.name.equals(splashMiniGameData2.name)) {
            edit.putString("name_" + splashMiniGameData2.appId, splashMiniGameData2.name);
        }
        if (splashMiniGameData.startTime != splashMiniGameData2.startTime) {
            edit.putLong("startTime_" + splashMiniGameData2.appId, splashMiniGameData2.startTime);
        }
        if (splashMiniGameData.endTime != splashMiniGameData2.endTime) {
            edit.putLong("endTime_" + splashMiniGameData2.appId, splashMiniGameData2.endTime);
        }
        if (splashMiniGameData.priority != splashMiniGameData2.priority) {
            edit.putInt("priority_" + splashMiniGameData2.appId, splashMiniGameData2.priority);
        }
        if (!isListEqual(splashMiniGameData.requestDomianList, splashMiniGameData2.requestDomianList)) {
            edit.putStringSet("request_DomainList_" + splashMiniGameData2.appId, new HashSet(splashMiniGameData2.requestDomianList));
        }
        if (!isListEqual(splashMiniGameData.downloadFileDomianList, splashMiniGameData2.downloadFileDomianList)) {
            edit.putStringSet("downloadFile_DomainList_" + splashMiniGameData2.appId, new HashSet(splashMiniGameData2.downloadFileDomianList));
        }
        edit.commit();
        String string = sharedPreferences.getString("videoLocalPath_" + splashMiniGameData2.appId, "");
        String string2 = sharedPreferences.getString("picLocalPath_" + splashMiniGameData2.appId, "");
        String filePath = getFilePath(splashMiniGameData2.appId);
        if (filePath != null && !splashMiniGameData.isPlayed.booleanValue()) {
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (!TextUtils.isEmpty(string)) {
            }
            SplashMiniGameDownloadManager.downloadRes(qQAppInterface, splashMiniGameData2.appId, splashMiniGameData2.videoUrl, filePath + File.separator + "splash.mp4", 1);
            if (!TextUtils.isEmpty(string2)) {
            }
            SplashMiniGameDownloadManager.downloadRes(qQAppInterface, splashMiniGameData2.appId, splashMiniGameData2.picUrl, filePath + File.separator + "splash.zip", 0);
        }
        if (z16) {
            preloadMiniGame(splashMiniGameData2);
        }
    }

    public static void saveConfigData(String str) {
        JSONArray optJSONArray;
        if (GameWnsUtils.gameEnable()) {
            ArrayList arrayList = new ArrayList();
            try {
                optJSONArray = new JSONObject(str).optJSONArray("minigame_splash");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    SplashMiniGameData splashMiniGameData = new SplashMiniGameData();
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    splashMiniGameData.enable = jSONObject.optInt("enable", 0);
                    splashMiniGameData.guide = jSONObject.optInt("guide", 0);
                    splashMiniGameData.appId = jSONObject.optString("appid");
                    splashMiniGameData.videoUrl = jSONObject.optString("video_url");
                    splashMiniGameData.videoDuration = jSONObject.optInt("video_duration");
                    splashMiniGameData.videoMute = jSONObject.optInt("video_mute", 1);
                    splashMiniGameData.picUrl = jSONObject.optString("pic_url");
                    splashMiniGameData.desc = jSONObject.optString("desc");
                    splashMiniGameData.developerDesc = jSONObject.optString("developer_desc");
                    splashMiniGameData.downloadUrl = jSONObject.optString("download_url");
                    splashMiniGameData.fileSize = jSONObject.optInt("file_size");
                    splashMiniGameData.iconUrl = jSONObject.optString("icon_url");
                    splashMiniGameData.version = jSONObject.optString("version");
                    splashMiniGameData.name = jSONObject.optString("name");
                    splashMiniGameData.startTime = jSONObject.optLong("startTime", 0L);
                    splashMiniGameData.endTime = jSONObject.optLong("endTime", 0L);
                    splashMiniGameData.priority = jSONObject.optInt("priority", 10);
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("downloadFile_DomainList");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        splashMiniGameData.downloadFileDomianList = new ArrayList<>();
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            splashMiniGameData.downloadFileDomianList.add(optJSONArray2.optString(i16));
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("request_DomainList");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        splashMiniGameData.requestDomianList = new ArrayList<>();
                        for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                            splashMiniGameData.requestDomianList.add(optJSONArray3.optString(i17));
                        }
                    }
                    arrayList.add(splashMiniGameData);
                }
                SplashMiniGameStarter.refresh();
                if (arrayList.size() < 1) {
                    BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0).edit().clear().commit();
                    FileUtils.deleteDirectory(SplashMiniGameStarter.PATH_SPLASH);
                    return;
                }
                SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0);
                int size = arrayList.size();
                MiniGameMMKVUtils.INSTANCE.saveInt(SplashMiniGameStarter.KEY_SPLASH_DATA_SIZE, size);
                sharedPreferences.edit().putInt("size", size).commit();
                HashMap<String, SplashMiniGameData> hashMap = SplashMiniGameStarter.dataMap;
                Iterator it = arrayList.iterator();
                int i18 = 0;
                while (it.hasNext()) {
                    SplashMiniGameData splashMiniGameData2 = (SplashMiniGameData) it.next();
                    if (hashMap != null && hashMap.containsKey(splashMiniGameData2.appId)) {
                        modifyConfig(i18, hashMap.get(splashMiniGameData2.appId), splashMiniGameData2);
                    } else {
                        addConfig(i18, splashMiniGameData2);
                    }
                    i18++;
                }
                if (hashMap != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (SplashMiniGameData splashMiniGameData3 : hashMap.values()) {
                        boolean z16 = false;
                        for (int i19 = 0; i19 < arrayList.size(); i19++) {
                            SplashMiniGameData splashMiniGameData4 = (SplashMiniGameData) arrayList.get(i19);
                            if (splashMiniGameData4 != null && splashMiniGameData4.appId.equals(splashMiniGameData3.appId)) {
                                z16 = true;
                            }
                        }
                        if (!z16) {
                            arrayList2.add(splashMiniGameData3);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        deleteConfig(arrayList2);
                    }
                }
                BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0).edit().putString("appVersion", AppSetting.f99551k + "." + AppSetting.f99542b).commit();
                SplashMiniGameStarter.refresh();
                return;
            }
            BaseApplicationImpl.getApplication().getSharedPreferences(SplashMiniGameStarter.SETTING_SPLASH, 0).edit().clear().commit();
        }
    }

    private static boolean isListEqual(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == arrayList2) {
            return true;
        }
        if ((arrayList == null && arrayList2 != null && arrayList2.size() == 0) || (arrayList2 == null && arrayList != null && arrayList.size() == 0)) {
            return true;
        }
        return arrayList != null && arrayList2 != null && arrayList.size() == arrayList2.size() && arrayList.containsAll(arrayList2);
    }

    public static void preloadMiniGame(SplashMiniGameData splashMiniGameData) {
    }
}
