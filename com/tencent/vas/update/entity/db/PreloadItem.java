package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PreloadItem {
    private static final String TAG = "PreloadItem";
    public int mFlag;
    public String mItemId;

    public static JSONObject convertToJson(PreloadItem preloadItem) {
        if (preloadItem == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("item_id", preloadItem.mItemId);
            jSONObject.put("flag", preloadItem.mFlag);
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return jSONObject;
        }
    }

    public static PreloadItem parseJsonToItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PreloadItem preloadItem = new PreloadItem();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("item_id")) {
                preloadItem.mItemId = jSONObject.optString("item_id");
            } else {
                preloadItem.mItemId = CommonUtil.sComposeItemId(jSONObject.optLong("bid"), jSONObject.optString("scid"));
            }
            preloadItem.mFlag = jSONObject.optInt("flag");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return preloadItem;
    }

    public static ArrayList<PreloadItem> parsePreloadItemList(JSONArray jSONArray) {
        PreloadItem parseJsonToItem;
        if (jSONArray == null) {
            return null;
        }
        try {
            ArrayList<PreloadItem> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && (parseJsonToItem = parseJsonToItem(optJSONObject.toString())) != null) {
                    arrayList.add(parseJsonToItem);
                }
            }
            return arrayList;
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "parsePreloadItemList exception", th5);
            return null;
        }
    }
}
