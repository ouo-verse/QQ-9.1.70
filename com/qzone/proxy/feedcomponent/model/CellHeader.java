package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_header;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellHeader implements SmartParcelable {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_READ_HOT = 4;
    public static final int TYPE_READ_RECOM = 3;
    public static final int TYPE_READ_SUB = 5;
    public static final int TYPE_SECRET = 2;
    public static final int TYPE_TIH = 1;

    @NeedParcel
    public int tih_year;

    @NeedParcel
    public int type;

    public int getYear() {
        return this.tih_year;
    }

    public boolean isShowHeader() {
        return this.type != 0;
    }

    public String toString() {
        return "CellHeader {\ntype: " + this.type + ", tih_year: " + this.tih_year + "}";
    }

    public static CellHeader create(l lVar) {
        if (lVar == null || lVar.D == null) {
            return null;
        }
        CellHeader cellHeader = new CellHeader();
        cell_header cell_headerVar = lVar.D;
        cellHeader.type = cell_headerVar.type;
        cellHeader.tih_year = cell_headerVar.tih_year;
        return cellHeader;
    }
}
