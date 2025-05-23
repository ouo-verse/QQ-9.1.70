package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellSearch implements SmartParcelable {

    @NeedParcel
    public String tip;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellSearch {");
        if (!TextUtils.isEmpty(this.tip)) {
            sb5.append("tip: ");
            sb5.append(this.tip);
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellSearch create(l lVar) {
        if (lVar == null || lVar.F == null) {
            return null;
        }
        CellSearch cellSearch = new CellSearch();
        cellSearch.tip = lVar.F.tip;
        return cellSearch;
    }
}
