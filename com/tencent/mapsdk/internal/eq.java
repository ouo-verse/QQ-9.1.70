package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class eq implements JsonParser.Deserializer<List<WeightedLatLng>> {
    private static List<WeightedLatLng> a(List<Double> list) {
        if (list.size() < 3) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WeightedLatLng(new LatLng(list.get(0).doubleValue(), list.get(1).doubleValue()), list.get(2).doubleValue()));
        for (int i3 = 3; i3 < list.size(); i3 += 3) {
            WeightedLatLng weightedLatLng = (WeightedLatLng) arrayList.get((i3 / 3) - 1);
            double doubleValue = weightedLatLng.getPoint().latitude + (list.get(i3).doubleValue() / 1000000.0d);
            double doubleValue2 = weightedLatLng.getPoint().longitude + (list.get(i3 + 1).doubleValue() / 1000000.0d);
            arrayList.add(new WeightedLatLng(new LatLng(doubleValue, doubleValue2), weightedLatLng.getIntensity() + (list.get(i3 + 2).doubleValue() / 100.0d)));
        }
        return arrayList;
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public final /* synthetic */ List<WeightedLatLng> deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 != null && (obj2 instanceof JSONArray)) {
            JSONArray jSONArray = (JSONArray) obj2;
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(Double.valueOf(jSONArray.optDouble(i3)));
                }
                return a((List<Double>) arrayList);
            }
            return null;
        }
        return null;
    }

    private static List<WeightedLatLng> a(Object obj) {
        if (obj != null && (obj instanceof JSONArray)) {
            JSONArray jSONArray = (JSONArray) obj;
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(Double.valueOf(jSONArray.optDouble(i3)));
                }
                return a((List<Double>) arrayList);
            }
        }
        return null;
    }
}
