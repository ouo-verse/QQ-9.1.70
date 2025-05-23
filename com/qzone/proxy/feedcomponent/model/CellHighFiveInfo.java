package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_decorate;
import NS_MOBILE_FEEDS.cell_feeds_deco;
import NS_MOBILE_FEEDS.cell_summary;
import NS_MOBILE_FEEDS.s_HighFive;
import NS_QMALL_COVER.FeedQzmallDeco;
import NS_QMALL_COVER.ReturnToPraise;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellHighFiveInfo implements SmartParcelable {
    private static final String TAG = "CellHighFiveInfo";

    @NeedParcel
    public String easterEggResUrl;

    @NeedParcel
    public long highFiveCount = 0;

    @NeedParcel
    public int itemId = -1;

    @NeedParcel
    public String leftHighFiveResUrl;

    @NeedParcel
    public String originText;

    @NeedParcel
    public String rightHighFiveResUrl;

    @NeedParcel
    public String textPraise;

    public CellHighFiveInfo updateData(l lVar) {
        FeedQzmallDeco feedQzmallDeco;
        ReturnToPraise returnToPraise;
        s_HighFive s_highfive;
        if (lVar == null) {
            return this;
        }
        cell_decorate cell_decorateVar = lVar.f50347d0;
        if (cell_decorateVar != null && (s_highfive = cell_decorateVar.highFive) != null) {
            this.highFiveCount = s_highfive.iCount;
            this.easterEggResUrl = s_highfive.strResourceUrl;
        }
        cell_feeds_deco cell_feeds_decoVar = lVar.f50367n0;
        if (cell_feeds_decoVar != null && cell_feeds_decoVar.decoration != null && (feedQzmallDeco = (FeedQzmallDeco) com.qzone.adapter.feedcomponent.i.H().u(FeedQzmallDeco.class, lVar.f50367n0.decoration)) != null && (returnToPraise = feedQzmallDeco.stReturnToPraise) != null && returnToPraise.iItemId != 0) {
            this.leftHighFiveResUrl = returnToPraise.strLeftHandUrl;
            this.rightHighFiveResUrl = returnToPraise.strRightHandUrl;
            this.textPraise = returnToPraise.strText;
        }
        cell_summary cell_summaryVar = lVar.f50348e;
        if (cell_summaryVar != null && !TextUtils.isEmpty(cell_summaryVar.summary)) {
            this.originText = lVar.f50348e.summary;
        }
        if (TextUtils.isEmpty(this.leftHighFiveResUrl)) {
            this.leftHighFiveResUrl = com.qzone.personalize.business.b.n().i();
        }
        if (TextUtils.isEmpty(this.rightHighFiveResUrl)) {
            this.rightHighFiveResUrl = com.qzone.personalize.business.b.n().j();
        }
        com.qzone.proxy.feedcomponent.b.e(TAG, "updateData = " + this.leftHighFiveResUrl + " -> " + this.rightHighFiveResUrl + " egg = " + this.easterEggResUrl + " textPraise = " + this.textPraise);
        return this;
    }

    public static CellHighFiveInfo create(l lVar) {
        FeedQzmallDeco feedQzmallDeco;
        ReturnToPraise returnToPraise;
        int i3;
        s_HighFive s_highfive;
        if (lVar == null) {
            return null;
        }
        CellHighFiveInfo cellHighFiveInfo = new CellHighFiveInfo();
        cell_decorate cell_decorateVar = lVar.f50347d0;
        if (cell_decorateVar != null && (s_highfive = cell_decorateVar.highFive) != null) {
            cellHighFiveInfo.highFiveCount = s_highfive.iCount;
            cellHighFiveInfo.easterEggResUrl = s_highfive.strResourceUrl;
        }
        cell_feeds_deco cell_feeds_decoVar = lVar.f50367n0;
        if (cell_feeds_decoVar != null && cell_feeds_decoVar.decoration != null && (feedQzmallDeco = (FeedQzmallDeco) com.qzone.adapter.feedcomponent.i.H().u(FeedQzmallDeco.class, lVar.f50367n0.decoration)) != null && (returnToPraise = feedQzmallDeco.stReturnToPraise) != null && (i3 = returnToPraise.iItemId) != 0) {
            cellHighFiveInfo.leftHighFiveResUrl = returnToPraise.strLeftHandUrl;
            cellHighFiveInfo.rightHighFiveResUrl = returnToPraise.strRightHandUrl;
            cellHighFiveInfo.textPraise = returnToPraise.strText;
            cellHighFiveInfo.itemId = i3;
            com.qzone.proxy.feedcomponent.b.e(TAG, "create = " + cellHighFiveInfo.leftHighFiveResUrl + " - > " + cellHighFiveInfo.rightHighFiveResUrl + " egg = " + cellHighFiveInfo.easterEggResUrl + " textPraise = " + cellHighFiveInfo.textPraise);
        }
        cell_summary cell_summaryVar = lVar.f50348e;
        if (cell_summaryVar != null && !TextUtils.isEmpty(cell_summaryVar.summary)) {
            cellHighFiveInfo.originText = lVar.f50348e.summary;
        }
        if (TextUtils.isEmpty(cellHighFiveInfo.leftHighFiveResUrl)) {
            cellHighFiveInfo.leftHighFiveResUrl = com.qzone.personalize.business.b.n().i();
        }
        if (TextUtils.isEmpty(cellHighFiveInfo.rightHighFiveResUrl)) {
            cellHighFiveInfo.rightHighFiveResUrl = com.qzone.personalize.business.b.n().j();
        }
        return cellHighFiveInfo;
    }
}
