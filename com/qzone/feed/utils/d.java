package com.qzone.feed.utils;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {
    public static PolymorphicPraiseData a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            PolymorphicPraiseData polymorphicPraiseData = new PolymorphicPraiseData();
            polymorphicPraiseData.uin = jSONObject.getLong("uin");
            polymorphicPraiseData.itemId = jSONObject.getInt("itemId");
            JSONArray jSONArray = jSONObject.getJSONArray("emotions");
            ArrayList<PolymorphicPraiseEmotionData> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = new PolymorphicPraiseEmotionData();
                polymorphicPraiseEmotionData.iItemId = jSONArray.getJSONObject(i3).getInt("id");
                polymorphicPraiseEmotionData.strName = jSONArray.getJSONObject(i3).getString("name");
                polymorphicPraiseEmotionData.strItemSummary = jSONArray.getJSONObject(i3).getString("summary");
                polymorphicPraiseEmotionData.strPraisePic = jSONArray.getJSONObject(i3).getString("praisePic");
                polymorphicPraiseEmotionData.strPraiseListPic = jSONArray.getJSONObject(i3).getString("praiseListPic");
                polymorphicPraiseEmotionData.strPraiseZip = jSONArray.getJSONObject(i3).getString("praiseZip");
                polymorphicPraiseEmotionData.strPraiseImageUrl = PictureUrl.calculateImageUrl(polymorphicPraiseEmotionData.strPraisePic);
                polymorphicPraiseEmotionData.strPraiseListImageUrl = PictureUrl.calculateImageUrl(polymorphicPraiseEmotionData.strPraiseListPic);
                arrayList.add(polymorphicPraiseEmotionData);
            }
            polymorphicPraiseData.emotionDatas = arrayList;
            return polymorphicPraiseData;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
