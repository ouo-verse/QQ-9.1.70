package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_guiding;
import NS_MOBILE_FEEDS.guide_button;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_user;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellGuiding implements SmartParcelable {
    public static final String REPORT_DIVISION = "_";
    public static final String reportExposure = "report_exposure";
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

    @NeedParcel
    public ArrayList<User> vecUsers = null;

    @NeedParcel
    public ArrayList<GuideButton> vecButton = null;

    @NeedParcel
    public String subSummary = "";

    @NeedParcel
    public String button_icon = "";

    @NeedParcel
    public String jsonTemplate = "";

    @NeedParcel
    public long cutLineJumpTime = 0;

    @NeedParcel
    public Map<Integer, String> busi_param = null;

    @NeedParcel
    public byte[] tianShuEntry = null;

    @NeedParcel
    public boolean isDressed = false;

    public static CellGuiding create(l lVar) {
        if (lVar == null || lVar.f50343b0 == null) {
            return null;
        }
        CellGuiding cellGuiding = new CellGuiding();
        cell_guiding cell_guidingVar = lVar.f50343b0;
        cellGuiding.title = cell_guidingVar.title;
        cellGuiding.summary = cell_guidingVar.summary;
        cellGuiding.button_title = cell_guidingVar.button_title;
        cellGuiding.action_url = cell_guidingVar.action_url;
        cellGuiding.guiding_type = cell_guidingVar.guiding_type;
        cellGuiding.extendInfo = cell_guidingVar.extendInfo;
        cellGuiding.jsonTemplate = cell_guidingVar.strJsonClient;
        cellGuiding.cutLineJumpTime = cell_guidingVar.cutLineJumpTime;
        cellGuiding.busi_param = cell_guidingVar.busi_param;
        cellGuiding.tianShuEntry = cell_guidingVar.tianshuEntry;
        s_picdata s_picdataVar = cell_guidingVar.picdata;
        if (s_picdataVar != null) {
            cellGuiding.pic = com.qzone.proxy.feedcomponent.util.e.m(s_picdataVar);
        }
        ArrayList<s_user> arrayList = lVar.f50343b0.vecUsers;
        if (arrayList != null) {
            cellGuiding.vecUsers = User.fromSUserList(arrayList);
        }
        ArrayList<guide_button> arrayList2 = lVar.f50343b0.vecButton;
        if (arrayList2 != null) {
            cellGuiding.vecButton = GuideButton.fromSGuideButtonList(arrayList2);
        }
        cell_guiding cell_guidingVar2 = lVar.f50343b0;
        cellGuiding.subSummary = cell_guidingVar2.subsummary;
        cellGuiding.button_icon = cell_guidingVar2.button_icon;
        return cellGuiding;
    }
}
