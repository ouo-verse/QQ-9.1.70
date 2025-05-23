package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_adv_container_attach;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellAdvContainerAttach implements SmartParcelable {

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public String actionurl;

    @NeedParcel
    public int isReport;

    @NeedParcel
    public PictureItem picinfo;

    @NeedParcel
    public String remark;

    @NeedParcel
    public String reportUrl;

    public static CellAdvContainerAttach create(l lVar) {
        if (lVar == null || lVar.X == null) {
            return null;
        }
        CellAdvContainerAttach cellAdvContainerAttach = new CellAdvContainerAttach();
        cellAdvContainerAttach.picinfo = com.qzone.proxy.feedcomponent.util.e.m(lVar.X.picinfo);
        cell_adv_container_attach cell_adv_container_attachVar = lVar.X;
        cellAdvContainerAttach.remark = cell_adv_container_attachVar.remark;
        cellAdvContainerAttach.actiontype = cell_adv_container_attachVar.actiontype;
        cellAdvContainerAttach.actionurl = cell_adv_container_attachVar.actionurl;
        cellAdvContainerAttach.isReport = cell_adv_container_attachVar.is_report;
        cellAdvContainerAttach.reportUrl = cell_adv_container_attachVar.report_url;
        return cellAdvContainerAttach;
    }
}
