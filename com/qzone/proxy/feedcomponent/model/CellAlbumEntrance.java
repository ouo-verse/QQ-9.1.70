package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_album_entrance;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellAlbumEntrance implements SmartParcelable {
    private static final String STR_COOKIE_APPID = "cookie_appid";
    private static final String TAG = "CellAlbumEntrance";

    @NeedParcel
    public String guideIcon = "";

    @NeedParcel
    public String guideTitle = "";

    @NeedParcel
    public String guideButton = "";

    @NeedParcel
    public String guideUrl = "";

    @NeedParcel
    public int button_actiontype = -1;

    @NeedParcel
    public int iAttr = 0;

    @NeedParcel
    public String buttonColor = "";

    @NeedParcel
    public String guideButtonOri = "";

    @NeedParcel
    public String appId = "";

    @NeedParcel
    public Map<String, String> busi_param = null;
    public boolean isPending = false;

    public static CellAlbumEntrance create(l lVar) {
        if (lVar != null && lVar.f50371p0 != null) {
            CellAlbumEntrance cellAlbumEntrance = new CellAlbumEntrance();
            cell_album_entrance cell_album_entranceVar = lVar.f50371p0;
            cellAlbumEntrance.guideIcon = cell_album_entranceVar.guide_icon;
            cellAlbumEntrance.guideTitle = cell_album_entranceVar.guide_title;
            String str = cell_album_entranceVar.button_title;
            cellAlbumEntrance.guideButton = str;
            cellAlbumEntrance.guideUrl = cell_album_entranceVar.guide_url;
            cellAlbumEntrance.button_actiontype = cell_album_entranceVar.button_actiontype;
            cellAlbumEntrance.iAttr = cell_album_entranceVar.iAttr;
            cellAlbumEntrance.buttonColor = cell_album_entranceVar.strButtonColor;
            cellAlbumEntrance.guideButtonOri = str;
            Map<String, String> map = cell_album_entranceVar.busi_param;
            cellAlbumEntrance.busi_param = map;
            if (map != null) {
                cellAlbumEntrance.appId = map.get(STR_COOKIE_APPID);
            }
            return cellAlbumEntrance;
        }
        com.qzone.proxy.feedcomponent.b.i(TAG, "create, jceData is null ");
        return null;
    }
}
