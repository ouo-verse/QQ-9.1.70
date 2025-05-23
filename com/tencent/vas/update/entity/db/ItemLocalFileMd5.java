package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ItemLocalFileMd5 {
    public String mItemId;
    public long mLastFileModified;
    public String mOriginMd5;

    public static String convertItemLocalFileMd5ToJson(ItemLocalFileMd5 itemLocalFileMd5) {
        if (itemLocalFileMd5 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("itemId", itemLocalFileMd5.mItemId);
            jSONObject.put("lastModified", itemLocalFileMd5.mLastFileModified);
            jSONObject.put("originMd5", itemLocalFileMd5.mOriginMd5);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static ItemLocalFileMd5 parseJsonToItemLocalFileMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ItemLocalFileMd5 itemLocalFileMd5 = new ItemLocalFileMd5();
        try {
            JSONObject jSONObject = new JSONObject(str);
            itemLocalFileMd5.mItemId = jSONObject.optString("itemId");
            itemLocalFileMd5.mLastFileModified = jSONObject.optLong("lastModified");
            itemLocalFileMd5.mOriginMd5 = jSONObject.optString("originMd5");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return itemLocalFileMd5;
    }

    @NonNull
    public String toString() {
        return " itemId = " + this.mItemId + " , lastModified = " + this.mLastFileModified + " , originMd5 = " + this.mOriginMd5;
    }
}
