package com.tencent.vas.update.entity.db;

import com.tencent.vas.update.util.CommonUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SyncItemRecord {
    public String mAppVersion;
    public String mItemId;
    public String mMD5;
    public int mType;

    public static SyncItemRecord parseJsonToItem(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        SyncItemRecord syncItemRecord = new SyncItemRecord();
        syncItemRecord.mItemId = CommonUtil.sComposeItemId(jSONObject.optInt("bid"), jSONObject.optString("scid"));
        syncItemRecord.mType = jSONObject.optInt("optype");
        syncItemRecord.mMD5 = jSONObject.optString("version");
        syncItemRecord.mAppVersion = jSONObject.optString("appVersion");
        return syncItemRecord;
    }

    public static ArrayList<SyncItemRecord> parseVcrList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<SyncItemRecord> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            SyncItemRecord parseJsonToItem = parseJsonToItem(jSONArray.optJSONObject(i3));
            if (parseJsonToItem != null) {
                arrayList.add(parseJsonToItem);
            }
        }
        return arrayList;
    }
}
