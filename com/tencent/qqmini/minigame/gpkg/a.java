package com.tencent.qqmini.minigame.gpkg;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f346445a = "portrait";

    /* renamed from: b, reason: collision with root package name */
    public boolean f346446b = false;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f346447c = null;

    /* renamed from: d, reason: collision with root package name */
    public JSONArray f346448d = null;

    /* renamed from: e, reason: collision with root package name */
    private JSONArray f346449e = null;

    public boolean a() {
        return !"portrait".equals(this.f346445a);
    }

    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f346445a = jSONObject.optString("deviceOrientation", "portrait");
            this.f346446b = jSONObject.optBoolean("enableWebgl2Context", false);
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            this.f346449e = optJSONArray;
            if (optJSONArray == null) {
                this.f346449e = jSONObject.optJSONArray("subPackages");
            }
            this.f346447c = jSONObject.optJSONObject("networkTimeout");
            this.f346448d = jSONObject.optJSONArray("navigateToMiniProgramAppIdList");
        } catch (Exception e16) {
            QMLog.e("GameJsonConfig", "parseGameJson: failed, jsonStr=" + str + "; exception=" + e16.getMessage());
        }
    }

    public Map<String, SubPkgInfoWrapper> c(MiniAppInfo miniAppInfo) {
        HashMap hashMap = new HashMap();
        List<SubPkgInfo> list = miniAppInfo.subpkgs;
        if (list != null && !list.isEmpty()) {
            if (this.f346449e == null) {
                QMLog.i("GameJsonConfig", miniAppInfo.appId + ": game.json has no subPkg config.");
                return hashMap;
            }
            for (int i3 = 0; i3 < this.f346449e.length(); i3++) {
                JSONObject optJSONObject = this.f346449e.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("name");
                    String optString2 = optJSONObject.optString("root");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        Iterator<SubPkgInfo> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                SubPkgInfo next = it.next();
                                if (optString.equalsIgnoreCase(next.subPkgName)) {
                                    hashMap.put(optString, new SubPkgInfoWrapper(next, optString2, ApkgManager.getApkgFolderPath(miniAppInfo)));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            QMLog.i("GameJsonConfig", miniAppInfo.appId + ": subPkg size=" + hashMap.size());
            return hashMap;
        }
        QMLog.i("GameJsonConfig", miniAppInfo.appId + ": appInfo has no subPkg config.");
        return hashMap;
    }
}
