package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_separator;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellSeparator implements SmartParcelable {

    @NeedParcel
    public int actionType;

    @NeedParcel
    public int picHeight;

    @NeedParcel
    public int picWidth;

    @NeedParcel
    public String picUrl = "";

    @NeedParcel
    public String actionUrl = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellSeparator {\n");
        if (!TextUtils.isEmpty(this.picUrl)) {
            sb5.append("picUrl: ");
            sb5.append(this.picUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.actionUrl)) {
            sb5.append("actionUrl: ");
            sb5.append(this.actionUrl);
            sb5.append("\n");
        }
        sb5.append("actionType: ");
        sb5.append(this.actionType);
        sb5.append("\n");
        sb5.append("picWidth: ");
        sb5.append(this.picWidth);
        sb5.append("\n");
        sb5.append("picHeight: ");
        sb5.append(this.picHeight);
        sb5.append("}");
        return sb5.toString();
    }

    public static CellSeparator create(l lVar) {
        if (lVar == null || lVar.G == null) {
            return null;
        }
        CellSeparator cellSeparator = new CellSeparator();
        cell_separator cell_separatorVar = lVar.G;
        cellSeparator.picUrl = cell_separatorVar.pic_url;
        cellSeparator.actionUrl = cell_separatorVar.action_url;
        cellSeparator.actionType = cell_separatorVar.action_type;
        cellSeparator.picWidth = cell_separatorVar.pic_width;
        cellSeparator.picHeight = cell_separatorVar.pic_height;
        return cellSeparator;
    }
}
