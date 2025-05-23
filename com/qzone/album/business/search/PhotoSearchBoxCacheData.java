package com.qzone.album.business.search;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class PhotoSearchBoxCacheData implements SmartParcelable {

    @NeedParcel
    public int status = 1;

    @NeedParcel
    public ArrayList<Integer> types = null;

    @NeedParcel
    public Map<Integer, PhotoSearchBoxItemCacheData> items = null;

    public String toString() {
        return "(status, " + this.status + ")\n(types, " + this.types + ")\n(items, " + this.items + ")\n";
    }
}
