package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_guiding;
import NS_MOBILE_FEEDS.s_picdata;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFunctionGuide implements SmartParcelable {
    public static final String REPORT_DIVISION = "_";
    public static final String reportKeyButton = "report_click_button";
    public static final String reportKeyDropdown = "report_drop_down_menu";
    public static final String reportKeyDropdownMenuCLoseFeeds = "report_drop_down_menu_close_feeds";
    public static final String reportKeyDropdownMenuNeverShow = "report_drop_down_menu_never_show";

    @NeedParcel
    public int guiding_type;

    @NeedParcel
    public PictureItem pic;

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String summary = "";

    @NeedParcel
    public String button_title = "";

    @NeedParcel
    public String action_url = "";

    @NeedParcel
    public Map<String, String> extendInfo = null;

    public static CellFunctionGuide create(l lVar) {
        if (lVar == null || lVar.f50343b0 == null) {
            return null;
        }
        CellFunctionGuide cellFunctionGuide = new CellFunctionGuide();
        cell_guiding cell_guidingVar = lVar.f50343b0;
        cellFunctionGuide.title = cell_guidingVar.title;
        cellFunctionGuide.summary = cell_guidingVar.summary;
        cellFunctionGuide.button_title = cell_guidingVar.button_title;
        cellFunctionGuide.action_url = cell_guidingVar.action_url;
        cellFunctionGuide.guiding_type = cell_guidingVar.guiding_type;
        cellFunctionGuide.extendInfo = cell_guidingVar.extendInfo;
        s_picdata s_picdataVar = cell_guidingVar.picdata;
        if (s_picdataVar != null) {
            cellFunctionGuide.pic = com.qzone.proxy.feedcomponent.util.e.m(s_picdataVar);
        }
        return cellFunctionGuide;
    }
}
