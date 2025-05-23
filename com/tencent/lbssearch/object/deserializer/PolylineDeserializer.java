package com.tencent.lbssearch.object.deserializer;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PolylineDeserializer implements JsonParser.Deserializer<List<LatLng>> {
    static IPatchRedirector $redirector_;

    public PolylineDeserializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static List<LatLng> calcCoord(List<Double> list) {
        if (list != null) {
            if (list.size() >= 2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(LatLng.newBuilderThrowException().setLatitude(list.get(0).doubleValue()).setLongitude(list.get(1).doubleValue()).build());
                for (int i3 = 2; i3 < list.size(); i3 += 2) {
                    double doubleValue = ((LatLng) arrayList.get((i3 / 2) - 1)).longitude + (list.get(i3 + 1).doubleValue() / 1000000.0d);
                    arrayList.add(LatLng.newBuilderThrowException().setLatitude((float) (Math.round((((LatLng) arrayList.get(r2)).latitude + (list.get(i3).doubleValue() / 1000000.0d)) * 1000000.0d) / 1000000.0d)).setLongitude((float) (Math.round(doubleValue * 1000000.0d) / 1000000.0d)).build());
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }

    private static List<LatLng> normalCoord(List<Double> list) {
        if (list != null && list.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3 += 2) {
                arrayList.add(new LatLng((float) (Math.round(list.get(i3 + 1).doubleValue() * 1000000.0d) / 1000000.0d), (float) (Math.round(list.get(i3).doubleValue() * 1000000.0d) / 1000000.0d)));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<LatLng> deserialize(Object obj, String str, Object obj2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, obj, str, obj2);
        }
        if (obj2 == null || !(obj2 instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) obj2;
        if (jSONArray.length() <= 0) {
            return null;
        }
        int i3 = 0;
        if (jSONArray.get(0) instanceof JSONObject) {
            ArrayList arrayList = new ArrayList();
            while (i3 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(new LatLng(jSONObject.optDouble(QCircleSchemeAttr.Polymerize.LAT), jSONObject.optDouble("lng")));
                i3++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        while (i3 < jSONArray.length()) {
            arrayList2.add(Double.valueOf(jSONArray.optDouble(i3)));
            i3++;
        }
        try {
            return calcCoord(arrayList2);
        } catch (Exception unused) {
            return normalCoord(arrayList2);
        }
    }
}
