package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ItemLocalVerPrt {
    private static final String TAG = "VasUpdate_ItemLocalVerPrt";
    public String mItemId;
    public String mMd5;

    public static String convertItemLocalVerPrtToJson(ItemLocalVerPrt itemLocalVerPrt) {
        if (itemLocalVerPrt == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("itemId", itemLocalVerPrt.mItemId);
            jSONObject.put("md5", itemLocalVerPrt.mMd5);
        } catch (Exception e16) {
            e16.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "ItemLocal convertJson error ", e16);
        }
        return jSONObject.toString();
    }

    public static ItemLocalVerPrt parseJsonToItemLocalVerPrt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ItemLocalVerPrt itemLocalVerPrt = new ItemLocalVerPrt();
        try {
            JSONObject jSONObject = new JSONObject(str);
            itemLocalVerPrt.mItemId = jSONObject.optString("itemId");
            itemLocalVerPrt.mMd5 = jSONObject.optString("md5");
        } catch (Exception e16) {
            e16.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "ItemLocal parseJson error ", e16);
        }
        return itemLocalVerPrt;
    }
}
