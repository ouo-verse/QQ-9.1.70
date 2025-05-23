package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_corner_adv;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellCornerAdv implements SmartParcelable {

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public String actionurl;

    @NeedParcel
    public int advAppearTime;

    @NeedParcel
    public int advHoldTime;

    @NeedParcel
    public PictureItem advInfo;

    @NeedParcel
    public int feedbackAppearTime;

    @NeedParcel
    public PictureItem feedbackInfo;

    @NeedParcel
    public PictureItem gifIinfo;

    @NeedParcel
    public int hasReportExposure;

    @NeedParcel
    public int minVideoTime;

    @NeedParcel
    public boolean showCornerAdv;

    public static CellCornerAdv create(l lVar) {
        if (lVar == null || lVar.f50365m0 == null) {
            return null;
        }
        CellCornerAdv cellCornerAdv = new CellCornerAdv();
        cellCornerAdv.gifIinfo = com.qzone.proxy.feedcomponent.util.e.m(lVar.f50365m0.gif_info);
        cellCornerAdv.feedbackInfo = com.qzone.proxy.feedcomponent.util.e.m(lVar.f50365m0.feedback_info);
        cellCornerAdv.advInfo = com.qzone.proxy.feedcomponent.util.e.m(lVar.f50365m0.adv_info);
        cell_corner_adv cell_corner_advVar = lVar.f50365m0;
        cellCornerAdv.feedbackAppearTime = cell_corner_advVar.feedback_appear_time;
        cellCornerAdv.advAppearTime = cell_corner_advVar.adv_appear_time;
        cellCornerAdv.advHoldTime = cell_corner_advVar.adv_hold_time;
        cellCornerAdv.minVideoTime = cell_corner_advVar.min_video_time;
        cellCornerAdv.actiontype = cell_corner_advVar.actiontype;
        cellCornerAdv.actionurl = cell_corner_advVar.actionurl;
        cellCornerAdv.showCornerAdv = cell_corner_advVar.show_corner_adv;
        cellCornerAdv.hasReportExposure = 0;
        return cellCornerAdv;
    }
}
