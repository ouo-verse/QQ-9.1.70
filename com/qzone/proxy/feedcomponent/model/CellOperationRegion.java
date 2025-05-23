package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_operation_region;
import NS_MOBILE_FEEDS.stRegionData;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellOperationRegion implements SmartParcelable {
    private static final String TAG = "CellOperationRegion";

    @NeedParcel
    public List<RegionData> regions;

    @NeedParcel
    public int interactiveType = 0;

    @NeedParcel
    public int gestureRadius = 0;

    @NeedParcel
    public int gestureStartTime = 0;

    @NeedParcel
    public int gestureLineColor = -1;

    public static CellOperationRegion create(l lVar) {
        if (lVar.f50381u0 == null) {
            return null;
        }
        CellOperationRegion cellOperationRegion = new CellOperationRegion();
        ArrayList<stRegionData> arrayList = lVar.f50381u0.vcRegion;
        cellOperationRegion.regions = new ArrayList(arrayList != null ? arrayList.size() : 0);
        Iterator<stRegionData> it = lVar.f50381u0.vcRegion.iterator();
        while (it.hasNext()) {
            cellOperationRegion.regions.add(RegionData.create(it.next()));
        }
        cell_operation_region cell_operation_regionVar = lVar.f50381u0;
        cellOperationRegion.interactiveType = cell_operation_regionVar.interactiveType;
        cellOperationRegion.gestureRadius = cell_operation_regionVar.gestureRadius;
        cellOperationRegion.gestureStartTime = cell_operation_regionVar.gestureStartTime;
        cellOperationRegion.gestureLineColor = -1;
        String str = cell_operation_regionVar.gestureLineColor;
        Log.i(TAG, "create: color param " + str);
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            try {
                cellOperationRegion.gestureLineColor = Color.parseColor(str);
            } catch (Exception e16) {
                Log.w(TAG, "create: wrong color param ", e16);
            }
        }
        return cellOperationRegion;
    }
}
