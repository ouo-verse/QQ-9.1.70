package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_feeds_deco;
import NS_QMALL_COVER.FeedQzmallDeco;
import NS_QMALL_COVER.QzoneDescription;
import com.qq.taf.jce.JceStruct;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFeedSignature implements SmartParcelable {
    private static final String TAG = "CellFeedSignature";

    @NeedParcel
    public int iHeight;

    @NeedParcel
    public int iType;

    @NeedParcel
    public int iWidth;

    @NeedParcel
    public String strJumpUrl;

    @NeedParcel
    public String strUrl;

    public String toString() {
        return " strUrl = " + this.strUrl + " strJumpUrl = " + this.strJumpUrl;
    }

    public void update(l lVar) {
        cell_feeds_deco cell_feeds_decoVar;
        JceStruct u16;
        if (lVar == null || (cell_feeds_decoVar = lVar.f50367n0) == null || cell_feeds_decoVar.decoration == null || (u16 = com.qzone.adapter.feedcomponent.i.H().u(FeedQzmallDeco.class, lVar.f50367n0.decoration)) == null || !(u16 instanceof FeedQzmallDeco)) {
            return;
        }
        QzoneDescription qzoneDescription = ((FeedQzmallDeco) u16).stQzDescription;
        if (qzoneDescription != null) {
            this.strUrl = qzoneDescription.strUrl;
            this.strJumpUrl = qzoneDescription.strJumpUrl;
            this.iType = qzoneDescription.iType;
            this.iHeight = qzoneDescription.iHeight;
            this.iWidth = qzoneDescription.iWidth;
            com.qzone.proxy.feedcomponent.b.e(TAG, "CellFeedSignature update = " + toString());
            return;
        }
        com.qzone.proxy.feedcomponent.b.e(TAG, "CellDIYData update data = null");
    }

    public static CellFeedSignature create(l lVar) {
        cell_feeds_deco cell_feeds_decoVar;
        JceStruct u16;
        if (lVar != null && (cell_feeds_decoVar = lVar.f50367n0) != null && cell_feeds_decoVar.decoration != null && (u16 = com.qzone.adapter.feedcomponent.i.H().u(FeedQzmallDeco.class, lVar.f50367n0.decoration)) != null && (u16 instanceof FeedQzmallDeco)) {
            FeedQzmallDeco feedQzmallDeco = (FeedQzmallDeco) u16;
            if (feedQzmallDeco.stQzDescription != null) {
                CellFeedSignature cellFeedSignature = new CellFeedSignature();
                QzoneDescription qzoneDescription = feedQzmallDeco.stQzDescription;
                cellFeedSignature.strUrl = qzoneDescription.strUrl;
                cellFeedSignature.strJumpUrl = qzoneDescription.strJumpUrl;
                cellFeedSignature.iType = qzoneDescription.iType;
                cellFeedSignature.iHeight = qzoneDescription.iHeight;
                cellFeedSignature.iWidth = qzoneDescription.iWidth;
                com.qzone.proxy.feedcomponent.b.e(TAG, "CellFeedSignature create = " + cellFeedSignature.toString());
                return cellFeedSignature;
            }
            com.qzone.proxy.feedcomponent.b.e(TAG, "CellDIYData create data = null");
        }
        return null;
    }
}
