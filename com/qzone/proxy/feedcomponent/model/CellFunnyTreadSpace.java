package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_funny_tread_space;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellFunnyTreadSpace implements SmartParcelable {

    @NeedParcel
    public List<String> actions;

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public QzoneCustomTrackData ugcCustomTrack;

    public static CellFunnyTreadSpace create(l lVar) {
        if (lVar == null || lVar.f50383v0 == null) {
            return null;
        }
        CellFunnyTreadSpace cellFunnyTreadSpace = new CellFunnyTreadSpace();
        cell_funny_tread_space cell_funny_tread_spaceVar = lVar.f50383v0;
        cellFunnyTreadSpace.actions = cell_funny_tread_spaceVar.actions;
        cellFunnyTreadSpace.extendInfo = cell_funny_tread_spaceVar.extendInfo;
        return cellFunnyTreadSpace;
    }

    public static CellFunnyTreadSpace mergeWithCustomTrack(CellFunnyTreadSpace cellFunnyTreadSpace, QzoneCustomTrackData qzoneCustomTrackData) {
        if (cellFunnyTreadSpace == null) {
            return null;
        }
        cellFunnyTreadSpace.ugcCustomTrack = qzoneCustomTrackData;
        return cellFunnyTreadSpace;
    }
}
