package com.qzone.album.business.search;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PhotoSearchBoxItemCacheData implements SmartParcelable {

    @NeedParcel
    public ArrayList<PhotoSearchBoxItemElemCacheData> elems = null;

    @NeedParcel
    public String desc = "";

    public String toString() {
        return "(elems, " + this.elems + ")\n(desc, " + this.desc + ")\n";
    }
}
