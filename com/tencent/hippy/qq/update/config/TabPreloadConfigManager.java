package com.tencent.hippy.qq.update.config;

import android.text.TextUtils;
import com.tencent.hippy.qq.api.KuiklyTabPreloadItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class TabPreloadConfigManager {
    public static final int DEFAULT_REQ_INTERVAL_IN_SECONDS = 3600;
    private static final int DEFAULT_TAB_PRELOAD_WAIT_TIME = 1000;
    public static final int DEF_OFFLINE_RES_GAP_TIME = 30;
    public static final String KEY_AD_PRELOAD_CONFIG = "key_ad_preload_config";
    public static final String KEY_PRELOAD_MAX_COUNT = "key_preload_max_count";
    public static final String KEY_TAB_PRELOAD_CONFIG = "key_tab_preload_config";
    public static final String KEY_TAB_PRELOAD_REQ_GAP = "key_tab_preload_req_gap";
    public static final int MIN_PRELOAD_COUNT = 1;
    public static final String TAG = "TabPreloadConfigManager";
    private List<TabPreloadItem> mAdPreloadData;
    private String mCurrentUin;
    private int mPreloadDelay;
    private HashMap<String, ArrayList<TabPreloadItem>> mTabPreloadData;
    private HashMap<String, ArrayList<KuiklyTabPreloadItem>> mKuiklyPreloadData = new HashMap<>();
    private HashMap<String, ArrayList<String>> mOfflineResPreloadData = new HashMap<>();
    private int mRequestGap = 3600;
    private int mPreloadMaxCount = 1;
    private boolean mIsInitData = false;
    private int mUpdateOfflineResGap = 30;

    public TabPreloadConfigManager(String str) {
        this.mCurrentUin = str;
    }

    private List<TabPreloadItem> parseAdPreloadConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("adPreloadList");
            if (optJSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                TabPreloadItem fromJson = TabPreloadItem.fromJson(optJSONArray.optJSONObject(i3));
                if (fromJson != null) {
                    arrayList.add(fromJson);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parseAdPreloadConfig adPreloadItem: " + fromJson);
                }
            }
            return arrayList;
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "parseAdPreloadConfig e:", e16);
            return null;
        }
    }

    private HashMap<String, ArrayList<KuiklyTabPreloadItem>> parseTabKuiklyPreloadList(JSONArray jSONArray) {
        int i3;
        if (jSONArray == null) {
            return null;
        }
        try {
            HashMap<String, ArrayList<KuiklyTabPreloadItem>> hashMap = new HashMap<>();
            int i16 = 0;
            while (i16 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    JSONArray optJSONArray = jSONObject.optJSONArray("kuiklyConfigList");
                    if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
                        ArrayList<KuiklyTabPreloadItem> arrayList = new ArrayList<>();
                        int i17 = 0;
                        while (i17 < optJSONArray.length()) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i17);
                            arrayList.add(new KuiklyTabPreloadItem(optJSONObject.optString("bundleName"), KuiklyTabPreloadItem.PreloadType.INSTANCE.toType(optJSONObject.optString("type")), optJSONObject.optInt("priority"), optJSONObject.optLong("downloadTimeGapMin", 30L)));
                            i17++;
                            i16 = i16;
                        }
                        i3 = i16;
                        hashMap.put(optString, arrayList);
                        i16 = i3 + 1;
                    }
                }
                i3 = i16;
                i16 = i3 + 1;
            }
            return hashMap;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parseTabKuiklyPreloadList e:" + th5);
            return null;
        }
    }

    private HashMap<String, ArrayList<String>> parseTabOfflineResPreloadList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            int length = jSONArray.length();
            HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    JSONObject optJSONObject = jSONObject.optJSONObject("offline_pkg_conf");
                    if (!TextUtils.isEmpty(optString) && optJSONObject != null) {
                        QLog.d(TAG, 1, "parseTabOfflineResPreloadList tabName=" + optString + ",offlinePkgConf=" + optJSONObject.toString());
                        this.mUpdateOfflineResGap = optJSONObject.optInt("downloadTimeGapMin", 30);
                        JSONArray optJSONArray = optJSONObject.optJSONArray("offline_pkg_ids");
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                                String string = optJSONArray.getString(i16);
                                if (!TextUtils.isEmpty(string)) {
                                    arrayList.add(string);
                                }
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                    QLog.w(TAG, 1, "parseTabOfflineResPreloadList fail, offlinePkgConf=" + optJSONObject);
                }
            }
            return hashMap;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parseTabOfflineResPreloadList e:" + th5);
            return null;
        }
    }

    private void resetAdPreloadConfig(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(str + KEY_AD_PRELOAD_CONFIG, "").commitAsync();
    }

    public List<TabPreloadItem> getAdPreloadList() {
        return this.mAdPreloadData;
    }

    public List<TabPreloadItem> getItemsOfTab(String str, String str2, TabPreloadItem.PreloadType preloadType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(preloadType);
        return getItemsOfTab(str, str2, arrayList);
    }

    public List<KuiklyTabPreloadItem> getKuiklyItemsOfTab(String str, KuiklyTabPreloadItem.PreloadType preloadType) {
        HashMap<String, ArrayList<KuiklyTabPreloadItem>> hashMap;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (hashMap = this.mKuiklyPreloadData) != null) {
            ArrayList<KuiklyTabPreloadItem> arrayList2 = hashMap.get(str);
            if (arrayList2 == null) {
                return arrayList;
            }
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (preloadType == arrayList2.get(i3).getType()) {
                    arrayList.add(arrayList2.get(i3));
                }
            }
        }
        return arrayList;
    }

    public Map<String, ArrayList<KuiklyTabPreloadItem>> getKuiklyTabPreloadConfig() {
        return this.mKuiklyPreloadData;
    }

    public List<String> getOfflineResOfTab(String str) {
        HashMap<String, ArrayList<String>> hashMap;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (hashMap = this.mOfflineResPreloadData) != null) {
            ArrayList<String> arrayList2 = hashMap.get(str);
            if (arrayList2 == null) {
                return arrayList;
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public int getPreloadDelay() {
        return this.mPreloadDelay;
    }

    public int getPreloadMaxCount() {
        return this.mPreloadMaxCount;
    }

    public Map<String, ArrayList<TabPreloadItem>> getTabPreloadConfig() {
        return this.mTabPreloadData;
    }

    public int getUpdateOfflineResGap() {
        return this.mUpdateOfflineResGap;
    }

    public void handleAdsPreloadResponse(int i3, String str, String str2) {
        if (i3 != 1) {
            return;
        }
        List<TabPreloadItem> parseAdPreloadConfig = parseAdPreloadConfig(str);
        this.mAdPreloadData = parseAdPreloadConfig;
        if (parseAdPreloadConfig == null) {
            resetAdPreloadConfig(str2);
            return;
        }
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeString(str2 + KEY_AD_PRELOAD_CONFIG, str).commitAsync();
    }

    public void handleTabPreloadResponse(int i3, String str, String str2) {
        if (i3 == 1 && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mPreloadMaxCount = jSONObject.optInt("maxPreloadCount", 1);
                this.mRequestGap = jSONObject.optInt("reqGap", 3600);
                this.mPreloadDelay = jSONObject.optInt("preloadDelay", 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("tabBarConfigList");
                this.mTabPreloadData = parseTabPreloadList(str2, optJSONArray);
                this.mKuiklyPreloadData = parseTabKuiklyPreloadList(optJSONArray);
                this.mOfflineResPreloadData = parseTabOfflineResPreloadList(optJSONArray);
                if (this.mPreloadMaxCount < 1) {
                    this.mPreloadMaxCount = 1;
                }
                HippyPredownloadManager.getSharedPreferences().edit().putInt(str2 + KEY_TAB_PRELOAD_REQ_GAP, this.mRequestGap).putInt(str2 + KEY_PRELOAD_MAX_COUNT, this.mPreloadMaxCount).putString(str2 + KEY_TAB_PRELOAD_CONFIG, str).commit();
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "handleTabPreloadResponse e:", th5);
            }
        }
    }

    public void initData() {
        if (this.mIsInitData) {
            return;
        }
        this.mIsInitData = true;
        String string = HippyPredownloadManager.getSharedPreferences().getString(this.mCurrentUin + KEY_TAB_PRELOAD_CONFIG, null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.mRequestGap = jSONObject.optInt("reqGap", 3600);
                this.mPreloadDelay = jSONObject.optInt("preloadDelay", 1000);
                JSONArray optJSONArray = jSONObject.optJSONArray("tabBarConfigList");
                this.mTabPreloadData = parseTabPreloadList(this.mCurrentUin, optJSONArray);
                this.mKuiklyPreloadData = parseTabKuiklyPreloadList(optJSONArray);
                this.mOfflineResPreloadData = parseTabOfflineResPreloadList(optJSONArray);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "initData e:" + th5);
            }
        }
        this.mAdPreloadData = parseAdPreloadConfig(QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(this.mCurrentUin + KEY_AD_PRELOAD_CONFIG, null));
    }

    public HashMap<String, ArrayList<TabPreloadItem>> parseTabPreloadList(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            HashMap<String, ArrayList<TabPreloadItem>> hashMap = new HashMap<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("name");
                    JSONArray optJSONArray = jSONObject.optJSONArray("bundleConfigList");
                    if (!TextUtils.isEmpty(optString) && optJSONArray != null) {
                        ArrayList<TabPreloadItem> arrayList = new ArrayList<>();
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            TabPreloadItem fromJson = TabPreloadItem.fromJson(optJSONArray.optJSONObject(i16));
                            if (fromJson != null) {
                                arrayList.add(fromJson);
                            }
                        }
                        hashMap.put(optString, arrayList);
                    }
                }
            }
            return hashMap;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parseTabPreloadList e:" + th5);
            return null;
        }
    }

    public List<TabPreloadItem> getItemsOfTab(String str, String str2, List<TabPreloadItem.PreloadType> list) {
        HashMap<String, ArrayList<TabPreloadItem>> hashMap;
        ArrayList<TabPreloadItem> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (TextUtils.isEmpty(str) || (hashMap = this.mTabPreloadData) == null || list == null || (arrayList = hashMap.get(str)) == null) {
            return arrayList2;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TabPreloadItem tabPreloadItem = arrayList.get(i3);
            if (list.contains(tabPreloadItem.preloadType) && ((TextUtils.isEmpty(str2) || str2.equals(tabPreloadItem.preloadProcess)) && ((tabPreloadItem.isPreloadBase() || tabPreloadItem.isPreUpdate() || tabPreloadItem.isPreRequest() || TabPreloadManager.getInstance().isCanPreload(tabPreloadItem.bundleName)) && tabPreloadItem.checkPreloadCondition()))) {
                if (!tabPreloadItem.isPreloadBase() && (tabPreloadItem.hasRedDotCondition() || TabPreloadManager.getInstance().hasNewMessage(tabPreloadItem.bundleName))) {
                    arrayList2.add(0, arrayList.get(i3));
                } else {
                    arrayList2.add(arrayList.get(i3));
                }
            }
        }
        return arrayList2;
    }
}
