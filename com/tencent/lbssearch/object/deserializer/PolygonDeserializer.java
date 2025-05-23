package com.tencent.lbssearch.object.deserializer;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class PolygonDeserializer implements JsonParser.Deserializer<List<List<LatLng>>> {
    static IPatchRedirector $redirector_;
    private PolylineDeserializer mPolylineDeserializer;

    public PolygonDeserializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mPolylineDeserializer = new PolylineDeserializer();
        }
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<List<LatLng>> deserialize(Object obj, String str, Object obj2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, obj, str, obj2);
        }
        ArrayList arrayList = null;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            if (jSONArray.length() > 0) {
                arrayList = new ArrayList(jSONArray.length());
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    List<LatLng> deserialize = this.mPolylineDeserializer.deserialize(obj, str, jSONArray.get(i3));
                    if (deserialize != null && deserialize.size() > 0) {
                        arrayList.add(deserialize);
                    }
                }
            }
        }
        return arrayList;
    }
}
