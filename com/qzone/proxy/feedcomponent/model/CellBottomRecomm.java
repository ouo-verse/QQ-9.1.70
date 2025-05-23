package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.WeishiDownlowdUrl;
import NS_MOBILE_FEEDS.cell_bottom_recomm;
import NS_MOBILE_FEEDS.s_join_list;
import NS_MOBILE_FEEDS.s_picdata;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellBottomRecomm implements SmartParcelable {
    public static int TYPE_ADV = 2;
    public static int TYPE_EVENT_TAG = 3;
    public static int TYPE_MAGIC = 8;
    public static int TYPE_PHOTO = 1;
    public static int TYPE_QZONE_LIVE = 4;
    public static int TYPE_WEISHI = 6;

    @NeedParcel
    public ImageUrl buttonIconImageUrl;

    @NeedParcel
    public ImageUrl imageUrl;

    @NeedParcel
    public boolean isSupportFeedback;

    @NeedParcel
    public s_join_list joinlist;
    public String weishiText;

    @NeedParcel
    public PictureItem picinfo = null;

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String summary = "";

    @NeedParcel
    public String buttonIconUrl = "";

    @NeedParcel
    public int actiontype = 0;

    @NeedParcel
    public String actionurl = "";

    @NeedParcel
    public String AdvIconUrl = "";

    @NeedParcel
    public String summaryColor = "";

    @NeedParcel
    public String buttontext = "";

    @NeedParcel
    public int anonymity = 0;

    @NeedParcel
    public int iReportFlag = 0;

    @NeedParcel
    public int iButtonFlag = 0;

    @NeedParcel
    public String weishiDownloadUrl = "";

    @NeedParcel
    public String jsonData = "";

    @NeedParcel
    public int tail_style = 0;

    @NeedParcel
    public String iconToken = "";
    public int joinListTruncateNum = 0;

    public void preCalculate() {
        Object[] g06;
        if (this.anonymity != TYPE_EVENT_TAG || (g06 = com.qzone.adapter.feedcomponent.i.H().g0(this.joinlist)) == null) {
            return;
        }
        this.summary = (String) g06[0];
        this.joinListTruncateNum = ((Integer) g06[1]).intValue();
    }

    public static CellBottomRecomm create(l lVar) {
        if (lVar == null || lVar.f50353g0 == null) {
            return null;
        }
        CellBottomRecomm cellBottomRecomm = new CellBottomRecomm();
        s_picdata s_picdataVar = lVar.f50353g0.picinfo;
        if (s_picdataVar != null) {
            cellBottomRecomm.picinfo = com.qzone.proxy.feedcomponent.util.e.m(s_picdataVar);
        }
        cell_bottom_recomm cell_bottom_recommVar = lVar.f50353g0;
        cellBottomRecomm.title = cell_bottom_recommVar.title;
        cellBottomRecomm.summary = cell_bottom_recommVar.summary;
        String str = cell_bottom_recommVar.buttonIconUrl;
        cellBottomRecomm.buttonIconUrl = str;
        cellBottomRecomm.buttonIconImageUrl = PictureUrl.calculateImageUrl(str);
        cell_bottom_recomm cell_bottom_recommVar2 = lVar.f50353g0;
        cellBottomRecomm.actiontype = cell_bottom_recommVar2.actiontype;
        cellBottomRecomm.actionurl = cell_bottom_recommVar2.actionurl;
        String str2 = cell_bottom_recommVar2.AdvIconUrl;
        cellBottomRecomm.AdvIconUrl = str2;
        cellBottomRecomm.imageUrl = PictureUrl.calculateImageUrl(str2);
        cell_bottom_recomm cell_bottom_recommVar3 = lVar.f50353g0;
        cellBottomRecomm.summaryColor = cell_bottom_recommVar3.summaryColor;
        cellBottomRecomm.buttontext = cell_bottom_recommVar3.buttontext;
        cellBottomRecomm.anonymity = cell_bottom_recommVar3.anonymity;
        cellBottomRecomm.joinlist = cell_bottom_recommVar3.joinlist;
        cellBottomRecomm.isSupportFeedback = cell_bottom_recommVar3.isSupportFeedback;
        cellBottomRecomm.iReportFlag = cell_bottom_recommVar3.iReportFlag;
        cellBottomRecomm.iButtonFlag = cell_bottom_recommVar3.iButtonFlag;
        WeishiDownlowdUrl weishiDownlowdUrl = cell_bottom_recommVar3.downloadUrl;
        if (weishiDownlowdUrl != null) {
            cellBottomRecomm.weishiDownloadUrl = weishiDownlowdUrl.AndUrl;
            cellBottomRecomm.weishiText = com.qzone.adapter.feedcomponent.i.H().N0(cellBottomRecomm.weishiDownloadUrl);
        }
        cell_bottom_recomm cell_bottom_recommVar4 = lVar.f50353g0;
        cellBottomRecomm.jsonData = cell_bottom_recommVar4.jsonData;
        cellBottomRecomm.tail_style = cell_bottom_recommVar4.style;
        cellBottomRecomm.iconToken = cell_bottom_recommVar4.icon_token;
        return cellBottomRecomm;
    }
}
