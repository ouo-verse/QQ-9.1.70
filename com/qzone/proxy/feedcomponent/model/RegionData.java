package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.stRegionData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RegionData implements SmartParcelable {
    public static final String KEY_BG_IMG_URL = "bgImgUrl";
    public static final String KEY_TYPE = "type";
    public static final String KEY_URL = "url";

    @NeedParcel
    public Point leftTopP = null;

    @NeedParcel
    public Point rightBottomP = null;

    @NeedParcel
    public int actionType = 0;

    @NeedParcel
    public String actionUrl = "";

    @NeedParcel
    public int urlShowType = 0;

    @NeedParcel
    public String backgroundImg = "";

    public static RegionData create(stRegionData stregiondata) {
        RegionData regionData = new RegionData();
        regionData.leftTopP = Point.create(stregiondata.leftTopP);
        regionData.rightBottomP = Point.create(stregiondata.rightBottomP);
        regionData.actionType = stregiondata.actionType;
        regionData.actionUrl = stregiondata.actionUrl;
        regionData.urlShowType = stregiondata.urlShowType;
        regionData.backgroundImg = stregiondata.backgroundImg;
        return regionData;
    }

    public Map<String, Object> parseClickParamMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("url", this.actionUrl);
        hashMap.put("type", Integer.valueOf(this.urlShowType));
        hashMap.put(KEY_BG_IMG_URL, this.backgroundImg);
        return hashMap;
    }

    public boolean checkHit(int i3, int i16, float f16, float f17) {
        int i17 = (int) ((f16 / i16) * 1000.0f);
        int i18 = (int) ((f17 / i3) * 1000.0f);
        Point point = this.leftTopP;
        if (i17 >= point.f50265x) {
            Point point2 = this.rightBottomP;
            if (i17 <= point2.f50265x && i18 >= point.f50266y && i18 <= point2.f50266y) {
                return true;
            }
        }
        return false;
    }
}
