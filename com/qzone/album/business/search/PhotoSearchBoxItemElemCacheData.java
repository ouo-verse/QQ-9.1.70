package com.qzone.album.business.search;

import com.qzone.album.business.facescan.FaceShowInfoCacheData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class PhotoSearchBoxItemElemCacheData implements SmartParcelable {

    @NeedParcel
    public int type = 0;

    @NeedParcel
    public String categoryid = "";

    @NeedParcel
    public String desc = "";

    @NeedParcel
    public FaceShowInfoCacheData face_show = null;

    @NeedParcel
    public String url = "";

    public String toString() {
        return "(type, " + this.type + ")\n(categoryid, " + this.categoryid + ")\n(desc, " + this.desc + ")\n(face_show, " + this.face_show + ")\n(url, " + this.url + ")\n";
    }
}
