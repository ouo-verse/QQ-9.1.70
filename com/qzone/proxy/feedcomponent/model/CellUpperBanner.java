package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_upper_banner;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellUpperBanner implements SmartParcelable {

    @NeedParcel
    public PictureItem picdata = null;

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String summary = "";

    @NeedParcel
    public String button_title = "";

    @NeedParcel
    public int actionType = 0;

    @NeedParcel
    public String action_url = "";

    @NeedParcel
    public int banner_type = 0;

    @NeedParcel
    public Map<String, String> extendInfo = null;

    public static CellUpperBanner create(l lVar) {
        if (lVar == null || lVar.f50379t0 == null) {
            return null;
        }
        CellUpperBanner cellUpperBanner = new CellUpperBanner();
        cellUpperBanner.picdata = com.qzone.proxy.feedcomponent.util.e.m(lVar.f50379t0.picdata);
        cell_upper_banner cell_upper_bannerVar = lVar.f50379t0;
        cellUpperBanner.title = cell_upper_bannerVar.title;
        cellUpperBanner.summary = cell_upper_bannerVar.summary;
        cellUpperBanner.button_title = cell_upper_bannerVar.button_title;
        cellUpperBanner.actionType = cell_upper_bannerVar.actionType;
        cellUpperBanner.action_url = cell_upper_bannerVar.action_url;
        cellUpperBanner.banner_type = cell_upper_bannerVar.banner_type;
        cellUpperBanner.extendInfo = cell_upper_bannerVar.extendInfo;
        return cellUpperBanner;
    }
}
