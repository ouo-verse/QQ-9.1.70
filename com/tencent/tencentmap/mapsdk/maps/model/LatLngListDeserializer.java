package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.tools.json.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LatLngListDeserializer implements JsonParser.Deserializer<List<LatLng>> {
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<LatLng> deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!(obj2 instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) obj2;
        if (jSONArray.length() == 0) {
            return null;
        }
        if (!(jSONArray.get(0) instanceof Double) && !(jSONArray.get(0) instanceof Integer)) {
            if (jSONArray.get(0) instanceof JSONArray) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONArray jSONArray2 = (JSONArray) jSONArray.get(i3);
                    if (jSONArray2.length() < 2) {
                        return null;
                    }
                    if (jSONArray2.length() > 2) {
                        arrayList.add(new LatLng(jSONArray2.getDouble(0), jSONArray2.getDouble(1), jSONArray2.getDouble(2)));
                    } else {
                        arrayList.add(new LatLng(jSONArray2.getDouble(0), jSONArray2.getDouble(1)));
                    }
                }
            }
        } else {
            if (jSONArray.length() < 2) {
                return null;
            }
            if (jSONArray.length() % 2 == 0) {
                for (int i16 = 0; i16 < jSONArray.length() - 1; i16 += 2) {
                    arrayList.add(new LatLng(jSONArray.getDouble(i16), jSONArray.getDouble(i16 + 1)));
                }
            } else {
                arrayList.add(new LatLng(jSONArray.getDouble(0), jSONArray.getDouble(1), jSONArray.getDouble(2)));
            }
        }
        return arrayList;
    }
}
