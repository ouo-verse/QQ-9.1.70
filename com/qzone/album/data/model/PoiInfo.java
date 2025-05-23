package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.stPoi;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class PoiInfo implements SmartParcelable {

    @NeedParcel
    public String poiAddress;

    @NeedParcel
    public String poiId;

    @NeedParcel
    public String poiName;

    @NeedParcel
    public int poiType;

    @NeedParcel
    public String poiX;

    @NeedParcel
    public String poiY;

    public String toString() {
        return "(poiId, " + this.poiId + ")\n(poiX, " + this.poiX + ")\n(poiY, " + this.poiY + ")\n(poiName, " + this.poiName + ")\n(poiAddress, " + this.poiAddress + ")\n(poiType, " + this.poiType + ")";
    }

    public static PoiInfo createFromResponse(stPoi stpoi) {
        if (stpoi == null) {
            return null;
        }
        PoiInfo poiInfo = new PoiInfo();
        String str = stpoi.poi_id;
        if (str == null) {
            str = "";
        }
        poiInfo.poiId = str;
        String str2 = stpoi.poi_x;
        if (str2 == null) {
            str2 = "";
        }
        poiInfo.poiX = str2;
        String str3 = stpoi.poi_y;
        poiInfo.poiY = str3 != null ? str3 : "";
        poiInfo.poiName = stpoi.poi_name;
        poiInfo.poiAddress = stpoi.poi_address;
        poiInfo.poiType = stpoi.poi_type;
        return poiInfo;
    }
}
