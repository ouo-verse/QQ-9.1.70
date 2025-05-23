package com.qzone.homepage.business.model;

import NS_QMALL_COVER.CmShowQzoneTrack;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CmActionData implements SmartParcelable, Serializable {

    @NeedParcel
    public String strPicUrl = "";

    @NeedParcel
    public int iItemType = 0;

    @NeedParcel
    public String strItemId = "";

    @NeedParcel
    public String strName = "";

    public boolean isSuperYellowStatus() {
        return this.iItemType == 14;
    }

    public String toString() {
        return "\ncurrentId = " + this.strItemId + " name = " + this.strName + " url = " + this.strPicUrl + " type = " + this.iItemType;
    }

    public static CmActionData create(CmShowQzoneTrack cmShowQzoneTrack) {
        if (cmShowQzoneTrack == null) {
            return null;
        }
        CmActionData cmActionData = new CmActionData();
        cmActionData.iItemType = cmShowQzoneTrack.iItemType;
        cmActionData.strItemId = cmShowQzoneTrack.strItemId;
        cmActionData.strName = cmShowQzoneTrack.strName;
        cmActionData.strPicUrl = cmShowQzoneTrack.strThumb;
        return cmActionData;
    }
}
