package com.tencent.vas.update.entity.db;

import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class Preload {
    public ArrayList<PreloadItem> mItemList;
    public int mPreLoadVersion;

    public static Preload parseJsonToPreaload(JSONObject jSONObject) {
        Preload preload = new Preload();
        if (jSONObject == null) {
            return preload;
        }
        preload.mPreLoadVersion = jSONObject.optInt("plver");
        ArrayList<PreloadItem> parsePreloadItemList = PreloadItem.parsePreloadItemList(jSONObject.optJSONArray("item_list"));
        preload.mItemList = parsePreloadItemList;
        if (parsePreloadItemList == null) {
            preload.mItemList = new ArrayList<>();
        }
        return preload;
    }
}
