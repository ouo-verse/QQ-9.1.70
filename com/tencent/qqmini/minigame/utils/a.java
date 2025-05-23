package com.tencent.qqmini.minigame.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class a {
    public static String a(MiniAppInfo miniAppInfo) {
        JSONArray optJSONArray;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.extInfo)) {
            try {
                optJSONArray = new JSONObject(miniAppInfo.extInfo).optJSONArray(ThirdPartyMiniApiImpl.KEY_MAP_INFO);
            } catch (JSONException e16) {
                QMLog.e("MiniAppInfoUtils", "[readBoxCPJumpUrl] error:", e16);
            }
            if (optJSONArray == null) {
                return null;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject = (JSONObject) optJSONArray.opt(i3);
                if (jSONObject != null) {
                    String optString = jSONObject.optString("key");
                    String optString2 = jSONObject.optString("value");
                    if ("box_cp_jump_url".equals(optString)) {
                        return optString2;
                    }
                }
            }
            return null;
        }
        QMLog.e("MiniAppInfoUtils", "[readBoxCPJumpUrl] can't get extInfo");
        return null;
    }
}
