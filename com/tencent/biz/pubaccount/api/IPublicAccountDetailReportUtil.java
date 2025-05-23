package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountDetailReportUtil extends QRouteApi {
    public static final String EVENT_ATTENTION = "actSearchSubscribe";
    public static final String EVENT_CLASS = "pubacc_class";
    public static final String EVENT_CLICK = "actSearchNetClick";
    public static final String EVENT_ENTRANCE = "actSearchExposure";
    public static final String EVENT_PAGE = "actSearchNet";
    public static final String KEY_CURTIME = "sCurTime";
    public static final String KEY_ISDIRECTCLICK = "sDirect";
    public static final String KEY_ISFOLDER = "sFolder";
    public static final String KEY_ISOFFLINE = "sFrom";
    public static final String KEY_ITEMID = "sItem";
    public static final String KEY_ITEMLIST = "sItemlist";
    public static final String KEY_ITEMPOS = "sItemPos";
    public static final String KEY_PAGENUM = "sItemListPage";
    public static final String KEY_SEARCH = "sKey";
    public static final String KEY_SEARCHID = "sSearch";
    public static final String KEY_STARTPOS = "sItemListStart";
    public static final String KEY_SUPERVIEWID = "sPScene";
    public static final String KEY_THISVIEWID = "sScene";
    public static final String KEY_VERSION = "sVer";
    public static final int VIEW_ACCOUNTDETAIL = 4;
    public static final int VIEW_CLASSIFICATION = 3;
    public static final int VIEW_CONTACTTAB_ADD = 300;
    public static final int VIEW_CONTACTTAB_SEARCH = 200;
    public static final int VIEW_CONVERSATION = 100;
    public static final int VIEW_FOLDER = 400;
    public static final int VIEW_GROUPSEARCH = 1;
    public static final int VIEW_SEARCHCONTACTS = 2;

    void backPage();

    String buildSearchID(String str, String str2);

    void resetAttribute();

    void setAttrEntrance(int i3);

    void setAttrSearchAttention(int i3, String str, int i16, int i17, boolean z16);

    void setAttrSearchClick(int i3, String str, int i16, int i17);

    void setAttrSearchPage(String str, String str2, int i3, boolean z16, int i16, String str3);
}
