package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_cover;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellCover implements SmartParcelable {

    @NeedParcel
    public String coverId;

    @NeedParcel
    public int coverTimeStamp;

    @NeedParcel
    public String cover_music_h5url = "";

    @NeedParcel
    public int cover_type;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellCover {\n");
        if (!TextUtils.isEmpty(this.coverId)) {
            sb5.append("coverId: ");
            sb5.append(this.coverId);
            sb5.append(", ");
        }
        sb5.append("coverTimeStamp: ");
        sb5.append(this.coverTimeStamp);
        sb5.append("}");
        return sb5.toString();
    }

    public static CellCover create(l lVar) {
        if (lVar == null || lVar.K == null) {
            return null;
        }
        CellCover cellCover = new CellCover();
        cell_cover cell_coverVar = lVar.K;
        cellCover.coverId = cell_coverVar.cover_id;
        cellCover.coverTimeStamp = cell_coverVar.cover_ts;
        cellCover.cover_type = cell_coverVar.cover_type;
        cellCover.cover_music_h5url = cell_coverVar.cover_music_h5url;
        return cellCover;
    }
}
