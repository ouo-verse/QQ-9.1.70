package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_active_adv;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellActiveAdv implements SmartParcelable {

    @NeedParcel
    public String buttonText;

    @NeedParcel
    public String copy;

    @NeedParcel
    public int isReport;

    @NeedParcel
    public PictureItem picData;

    @NeedParcel
    public String reportUrl;

    @NeedParcel
    public String upCopy;

    public static CellActiveAdv create(l lVar) {
        if (lVar == null || lVar.L == null) {
            return null;
        }
        CellActiveAdv cellActiveAdv = new CellActiveAdv();
        cellActiveAdv.picData = com.qzone.proxy.feedcomponent.util.e.m(lVar.L.picdata);
        cell_active_adv cell_active_advVar = lVar.L;
        cellActiveAdv.copy = cell_active_advVar.copy;
        cellActiveAdv.buttonText = cell_active_advVar.button_text;
        cellActiveAdv.upCopy = cell_active_advVar.up_copy;
        cellActiveAdv.isReport = cell_active_advVar.is_report;
        cellActiveAdv.reportUrl = cell_active_advVar.report_url;
        return cellActiveAdv;
    }
}
