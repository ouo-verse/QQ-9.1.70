package com.tencent.mobileqq.minigame.gpkg;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.ApkgBaseInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo;
import com.tencent.mobileqq.mini.network.http.MiniOkHttpClientFactory;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.minigame.manager.GamePreConnectManager;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class MiniGamePkg extends ApkgBaseInfo {
    public static final String DEVICE_ORIENTATION_LANDSCAPE = "landscape";
    public static final String DEVICE_ORIENTATION_PORTRAIT = "portrait";
    private static final String NAME_CONFIG_JSON = "game.json";
    public static final String NAME_ENTRY_FILE = "game.js";
    public static final String NAME_OFFLINECONFIG_JSON = "offlineconfig.json";
    public static final String PLUGIN_ENTRY_FILE = "plugin.js";
    private String deviceOrientation;
    public JSONObject mGameConfigJson;
    public NetworkTimeoutInfo networkTimeoutInfo;
    private String openDataPath;
    private boolean showStatusBar;
    public HashMap<String, String> subPackRoots;

    public MiniGamePkg(String str, MiniAppConfig miniAppConfig) {
        super(str, miniAppConfig);
        this.subPackRoots = new HashMap<>();
    }

    private static HashMap<String, String> getSubPackRoots(JSONArray jSONArray) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("name");
                    String optString2 = optJSONObject.optString("root");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        hashMap.put(optString, optString2);
                    }
                }
            }
        }
        return hashMap;
    }

    public static MiniGamePkg loadGamePkgFromFolderPath(String str, String str2, MiniAppConfig miniAppConfig, boolean z16) {
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            return null;
        }
        MiniGamePkg miniGamePkg = new MiniGamePkg(str, miniAppConfig);
        miniGamePkg.init(str2);
        if (miniGamePkg.networkTimeoutInfo == null) {
            miniGamePkg.networkTimeoutInfo = new NetworkTimeoutInfo();
        }
        if (z16) {
            initOkHttp(miniGamePkg);
            GamePreConnectManager.connectHost(miniGamePkg);
        }
        return miniGamePkg;
    }

    public String getDeviceOrientation() {
        return this.deviceOrientation;
    }

    public String getOpenDataPath() {
        return this.openDataPath;
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public String getRootPath(String str) {
        HashMap<String, String> hashMap;
        if (!StringUtil.isEmpty(str) && (hashMap = this.subPackRoots) != null) {
            if (hashMap.containsKey(str)) {
                return this.subPackRoots.get(str);
            }
            if (this.subPackRoots.containsValue(str)) {
                return str;
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public String getWorkerPath(String str, String str2) {
        return null;
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public void init(String str) {
        try {
            if (str != null) {
                this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath() + "/" + str, "game.json"));
            } else {
                this.mConfigStr = FileUtils.readFileToString(new File(getApkgFolderPath(), "game.json"));
            }
            JSONObject jSONObject = new JSONObject(this.mConfigStr);
            this.mGameConfigJson = jSONObject;
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray == null) {
                optJSONArray = this.mGameConfigJson.optJSONArray("subPackages");
            }
            this.subPackRoots = getSubPackRoots(optJSONArray);
            this.networkTimeoutInfo = NetworkTimeoutInfo.parse(this.mGameConfigJson.optJSONObject("networkTimeout"));
            this.deviceOrientation = this.mGameConfigJson.optString("deviceOrientation", "portrait");
            this.openDataPath = this.mGameConfigJson.optString("openDataContext", null);
            this.showStatusBar = this.mGameConfigJson.optBoolean("showStatusBar", false);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public boolean isOrientationLandscape() {
        return "landscape".equals(this.deviceOrientation);
    }

    public boolean isShowStatusBar() {
        return this.showStatusBar;
    }

    @Override // com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
    public boolean isUrlResReady(String str) {
        return false;
    }

    private static void initOkHttp(MiniGamePkg miniGamePkg) {
        NetworkTimeoutInfo networkTimeoutInfo;
        if (miniGamePkg == null || (networkTimeoutInfo = miniGamePkg.networkTimeoutInfo) == null) {
            networkTimeoutInfo = new NetworkTimeoutInfo();
        }
        MiniOkHttpClientFactory.init(networkTimeoutInfo.request, networkTimeoutInfo.uploadFile, networkTimeoutInfo.downloadFile);
    }
}
