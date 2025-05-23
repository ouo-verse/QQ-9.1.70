package com.qzone.album.business.facescan;

import com.qzone.album.data.model.UinNickInfoCacheData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FaceShowInfoCacheData implements SmartParcelable {

    @NeedParcel
    public int status = 0;

    @NeedParcel
    public UinNickInfoCacheData pic_host = null;

    @NeedParcel
    public ArrayList<String> groupids = null;

    public String toString() {
        return "(status, " + this.status + ")\n(pic_host, " + this.pic_host + ")\n(groupids, " + this.groupids + ")\n";
    }
}
