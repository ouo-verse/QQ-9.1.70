package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_feeds_deco;
import NS_QMALL_COVER.FacadeDIY;
import NS_QMALL_COVER.FeedQzmallDeco;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellDIYData implements SmartParcelable {
    private static final String TAG = "CellDIYData";

    @NeedParcel
    public int iEnable;

    @NeedParcel
    public String strChecksum;

    @NeedParcel
    public long uin;

    public String toString() {
        return " iEnable = " + this.iEnable + " strChecksum = " + this.strChecksum;
    }

    public static CellDIYData create(l lVar, long j3) {
        cell_feeds_deco cell_feeds_decoVar;
        FacadeDIY facadeDIY;
        if (lVar != null && (cell_feeds_decoVar = lVar.f50367n0) != null && cell_feeds_decoVar.decoration != null) {
            FeedQzmallDeco feedQzmallDeco = (FeedQzmallDeco) com.qzone.adapter.feedcomponent.i.H().u(FeedQzmallDeco.class, lVar.f50367n0.decoration);
            if (feedQzmallDeco != null && (facadeDIY = feedQzmallDeco.stFacadeDIY) != null && facadeDIY.iEnable != 0) {
                CellDIYData cellDIYData = new CellDIYData();
                FacadeDIY facadeDIY2 = feedQzmallDeco.stFacadeDIY;
                cellDIYData.iEnable = facadeDIY2.iEnable;
                cellDIYData.strChecksum = facadeDIY2.strChecksum;
                cellDIYData.uin = j3;
                com.qzone.proxy.feedcomponent.b.e(TAG, "CellDIYData create = " + cellDIYData.toString());
                return cellDIYData;
            }
            com.qzone.proxy.feedcomponent.b.e(TAG, "CellDIYData create data = null");
        }
        return null;
    }
}
