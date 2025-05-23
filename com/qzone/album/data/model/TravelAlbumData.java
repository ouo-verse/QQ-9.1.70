package com.qzone.album.data.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TravelAlbumData implements SmartParcelable {

    @NeedParcel
    public PhotoPoiArea albumPoi;

    @NeedParcel
    public String attach_info;

    @NeedParcel
    public Map<Integer, String> busi_param = new HashMap();

    @NeedParcel
    public String startDescription = "";

    @NeedParcel
    public String endDescription = "";

    @NeedParcel
    public ArrayList<PhotoPoiArea> photoPoiAreaList = new ArrayList<>();

    @NeedParcel
    public long startShootTime = 0;

    public String toString() {
        return "(attach_info, " + this.attach_info + ")\n(busi_param, " + this.busi_param + ")\n++(albumPoi, " + this.albumPoi + ")++\n(startDescription, " + this.startDescription + ")\n(endDescription, " + this.endDescription + ")\n++(photoPoiAreaList, " + this.photoPoiAreaList + ")++\n(startShootTime, " + this.startShootTime + ")";
    }
}
