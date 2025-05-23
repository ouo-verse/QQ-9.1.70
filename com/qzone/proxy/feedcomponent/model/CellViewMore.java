package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_view_more;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellViewMore implements SmartParcelable {

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public String guide_content = "";

    @NeedParcel
    public HashMap<Integer, String> busi_param = null;

    @NeedParcel
    public String jump_url = "";

    public static CellViewMore create(l lVar) {
        if (lVar == null || lVar.f50345c0 == null) {
            return null;
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        CellViewMore cellViewMore = new CellViewMore();
        cell_view_more cell_view_moreVar = lVar.f50345c0;
        cellViewMore.guide_content = cell_view_moreVar.guide_content;
        hashMap.putAll(cell_view_moreVar.busi_param);
        cellViewMore.busi_param = hashMap;
        cell_view_more cell_view_moreVar2 = lVar.f50345c0;
        cellViewMore.actiontype = cell_view_moreVar2.actiontype;
        cellViewMore.jump_url = cell_view_moreVar2.jump_url;
        return cellViewMore;
    }
}
