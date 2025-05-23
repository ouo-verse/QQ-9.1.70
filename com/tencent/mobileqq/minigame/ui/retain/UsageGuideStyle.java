package com.tencent.mobileqq.minigame.ui.retain;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UsageGuideStyle {
    public int mediaType = 1;
    public final List<String> guideMediasList = new ArrayList();
    public int autoSlideInterval = 3;

    public static UsageGuideStyle createFromConfigJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        UsageGuideStyle usageGuideStyle = new UsageGuideStyle();
        JSONObject optJSONObject = jSONObject.optJSONObject(QAdVrReportParams.ParamKey.MEDIA);
        if (optJSONObject != null) {
            usageGuideStyle.mediaType = optJSONObject.optInt("mediaType");
            usageGuideStyle.autoSlideInterval = optJSONObject.optInt("autoSlideInterval");
            JSONArray optJSONArray = optJSONObject.optJSONArray("guideMediaUrls");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    usageGuideStyle.guideMediasList.add(optJSONArray.optString(i3));
                }
            }
        }
        return usageGuideStyle;
    }
}
