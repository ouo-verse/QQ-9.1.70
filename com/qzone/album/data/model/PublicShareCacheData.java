package com.qzone.album.data.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.io.Serializable;

/* loaded from: classes39.dex */
public class PublicShareCacheData implements Serializable, SmartParcelable {

    @NeedParcel
    public String cover = "";

    @NeedParcel
    public String desc = "";

    @NeedParcel
    public String h5url = "";

    @NeedParcel
    public String schema = "";
}
