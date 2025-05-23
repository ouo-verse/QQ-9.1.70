package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_frdlike_container;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFrdlikeContainer implements SmartParcelable {

    @NeedParcel
    public int blankActiontype = 0;

    @NeedParcel
    public String rightDesc = "";

    @NeedParcel
    public int rightDescActiontype = 0;

    public static CellFrdlikeContainer create(l lVar) {
        if (lVar == null || lVar.f50355h0 == null) {
            return null;
        }
        CellFrdlikeContainer cellFrdlikeContainer = new CellFrdlikeContainer();
        cell_frdlike_container cell_frdlike_containerVar = lVar.f50355h0;
        cellFrdlikeContainer.blankActiontype = cell_frdlike_containerVar.blank_actiontype;
        cellFrdlikeContainer.rightDesc = cell_frdlike_containerVar.right_desc;
        cellFrdlikeContainer.rightDescActiontype = cell_frdlike_containerVar.right_desc_actiontype;
        return cellFrdlikeContainer;
    }
}
