package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.s_rank;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRank implements SmartParcelable {

    @NeedParcel
    public int rankCurrentWithHalfStar;

    @NeedParcel
    public int rankMax;

    public static CellRank create(l lVar) {
        if (lVar == null || lVar.S == null) {
            return null;
        }
        CellRank cellRank = new CellRank();
        s_rank s_rankVar = lVar.S.rank;
        cellRank.rankMax = s_rankVar.max;
        cellRank.rankCurrentWithHalfStar = s_rankVar.half_star_num;
        return cellRank;
    }
}
