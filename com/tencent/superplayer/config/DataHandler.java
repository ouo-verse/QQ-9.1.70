package com.tencent.superplayer.config;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.superplayer.utils.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public class DataHandler {
    private static String TAG = "DataHandler";
    private ConfigGroupParseCallback mCallback;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface ConfigGroupParseCallback {
        void onConfigGroupParsed(CacheContent cacheContent, String str);
    }

    private void parseItems(JSONArray jSONArray) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                parseOneItem(jSONArray.getJSONObject(i3));
            } catch (JSONException e16) {
                LogUtil.e(TAG, "parseItems error, index:" + i3, e16);
            }
        }
    }

    private void parseOneItem(JSONObject jSONObject) throws JSONException {
        CacheContent cacheByOriginGroupName = ConfigManager.get().getCacheByOriginGroupName(jSONObject.getString(VipFunCallConstants.KEY_GROUP));
        String string = jSONObject.getString("key_values");
        ConfigGroupParseCallback configGroupParseCallback = this.mCallback;
        if (configGroupParseCallback != null) {
            configGroupParseCallback.onConfigGroupParsed(cacheByOriginGroupName, string);
        }
    }

    public void parseServerResult(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i3 = jSONObject.getInt("ret_code");
            String string = jSONObject.getString("ret_msg");
            if (i3 != 0) {
                LogUtil.e(TAG, "parseServerResult failed, resultCode:" + i3 + " resultMsg:" + string);
                return;
            }
            parseItems(jSONObject.getJSONObject(DownloadInfo.spKey_Config).getJSONArray("items"));
        } catch (JSONException e16) {
            LogUtil.e(TAG, "parseServerResult error", e16);
        }
    }

    public void setCallback(ConfigGroupParseCallback configGroupParseCallback) {
        this.mCallback = configGroupParseCallback;
    }
}
