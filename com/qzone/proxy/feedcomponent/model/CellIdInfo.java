package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_id;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellIdInfo implements SmartParcelable {

    @NeedParcel
    public String cellId;

    @NeedParcel
    public String subId;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellIdInfo{\n");
        if (!TextUtils.isEmpty(this.cellId)) {
            sb5.append("cellId: ");
            sb5.append(this.cellId);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.subId)) {
            sb5.append("subId: ");
            sb5.append(this.subId);
        }
        sb5.append("\n}");
        return sb5.toString();
    }

    public static CellIdInfo create(l lVar) {
        if (lVar == null || lVar.f50344c == null) {
            return null;
        }
        CellIdInfo cellIdInfo = new CellIdInfo();
        cell_id cell_idVar = lVar.f50344c;
        cellIdInfo.cellId = cell_idVar.cellid;
        cellIdInfo.subId = cell_idVar.subid;
        return cellIdInfo;
    }
}
