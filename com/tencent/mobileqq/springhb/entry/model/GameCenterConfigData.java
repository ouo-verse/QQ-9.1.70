package com.tencent.mobileqq.springhb.entry.model;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.prize.h;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GameCenterConfigData implements Serializable {
    static IPatchRedirector $redirector_;
    public String appId;
    public String bottomBkgResUrl;
    public ArrayList<String> bundleNameList;
    public String defaultUrl;
    public String fallbackWallpaperResUrl;
    public String giftAnimResUrl;
    public String goHomePageResUrl;
    public String installApkResUrl;
    public int isPreload;
    public String logoBkgResUrl;
    public ArrayList<String> offlineBidList;
    public String remainTimeResUrl;
    public String startCloudGameResUrl;
    public String startLocalResUrl;

    public GameCenterConfigData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.bundleNameList = new ArrayList<>();
            this.offlineBidList = new ArrayList<>();
        }
    }

    public static GameCenterConfigData parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GameCenterConfigData gameCenterConfigData = new GameCenterConfigData();
        gameCenterConfigData.appId = jSONObject.optString("GameAppID");
        gameCenterConfigData.defaultUrl = jSONObject.optString("DefaultURL");
        gameCenterConfigData.startLocalResUrl = jSONObject.optString("CashLaunchLocalGame");
        gameCenterConfigData.startCloudGameResUrl = jSONObject.optString("LaunchCloudGameAndDownload");
        gameCenterConfigData.installApkResUrl = jSONObject.optString("CashInstall");
        gameCenterConfigData.logoBkgResUrl = jSONObject.optString("logoBkgResUrl");
        gameCenterConfigData.bottomBkgResUrl = jSONObject.optString("HbBg");
        gameCenterConfigData.remainTimeResUrl = jSONObject.optString("ShuaPauseBubble");
        gameCenterConfigData.goHomePageResUrl = jSONObject.optString("GoGameHomePage");
        gameCenterConfigData.fallbackWallpaperResUrl = jSONObject.optString("FallbackWallpaper");
        gameCenterConfigData.giftAnimResUrl = jSONObject.optString("GiftGetAnimate");
        JSONArray optJSONArray = jSONObject.optJSONArray("BundleNames");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    gameCenterConfigData.bundleNameList.add(optString);
                }
            }
            h.u(gameCenterConfigData.bundleNameList);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("BidNames");
        if (optJSONArray2 != null) {
            for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                String optString2 = optJSONArray2.optString(i16);
                if (!TextUtils.isEmpty(optString2)) {
                    gameCenterConfigData.offlineBidList.add(optString2);
                }
            }
            h.v(gameCenterConfigData.offlineBidList);
        }
        return gameCenterConfigData;
    }
}
