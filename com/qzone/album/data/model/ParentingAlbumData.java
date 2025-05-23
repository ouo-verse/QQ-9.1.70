package com.qzone.album.data.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class ParentingAlbumData implements SmartParcelable, Serializable {

    @NeedParcel
    public String attach_info;

    @NeedParcel
    public Map<Integer, String> busi_param = new HashMap();

    @NeedParcel
    public ArrayList<TimeLine> timeLineList = new ArrayList<>();

    public String toString() {
        return "(attach_info, " + this.attach_info + ")\n(busi_param, " + this.busi_param + ")\n++(timeLineList, " + this.timeLineList + ")++";
    }
}
