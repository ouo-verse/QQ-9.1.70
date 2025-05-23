package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_poke_like;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class CellPokeLike implements SmartParcelable {

    @NeedParcel
    public int count;

    @NeedParcel
    public ArrayList<String> emotionList;

    public String toString() {
        return "CellPokeLike{emotionList=" + this.emotionList + ", count=" + this.count + '}';
    }

    public static CellPokeLike create(l lVar) {
        if (lVar == null || lVar.f50391z0 == null) {
            return null;
        }
        CellPokeLike cellPokeLike = new CellPokeLike();
        cell_poke_like cell_poke_likeVar = lVar.f50391z0;
        cellPokeLike.emotionList = cell_poke_likeVar.emotion_id;
        cellPokeLike.count = cell_poke_likeVar.count;
        return cellPokeLike;
    }
}
