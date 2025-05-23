package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_universe;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellUniverse implements SmartParcelable {

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public String jsonTemplate;

    @NeedParcel
    public Map<Integer, byte[]> requestData;

    @NeedParcel
    public String traceId;

    @NeedParcel
    public int universeType;

    public static CellUniverse create(l lVar) {
        if (lVar == null || lVar.f50389y0 == null) {
            return null;
        }
        CellUniverse cellUniverse = new CellUniverse();
        cell_universe cell_universeVar = lVar.f50389y0;
        cellUniverse.traceId = cell_universeVar.strTraceId;
        cellUniverse.jsonTemplate = cell_universeVar.strUIJson;
        cellUniverse.requestData = cell_universeVar.BgReqData;
        cellUniverse.universeType = cell_universeVar.iUniverseType;
        cellUniverse.extendInfo = cell_universeVar.extendInfo;
        return cellUniverse;
    }
}
