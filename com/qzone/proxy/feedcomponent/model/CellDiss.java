package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_diss;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellDiss implements SmartParcelable {

    @NeedParcel
    public int dissCount = 0;

    @NeedParcel
    public boolean dissed = false;

    public static CellDiss create(l lVar) {
        if (lVar == null || lVar.f50375r0 == null) {
            return null;
        }
        CellDiss cellDiss = new CellDiss();
        cell_diss cell_dissVar = lVar.f50375r0;
        cellDiss.dissCount = cell_dissVar.num;
        cellDiss.dissed = cell_dissVar.isdissed != 0;
        return cellDiss;
    }
}
