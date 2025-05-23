package com.tencent.lbssearch.object.deserializer;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LatLngDeserializer implements JsonParser.Deserializer<LatLng> {
    static IPatchRedirector $redirector_;

    public LatLngDeserializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public LatLng deserialize(Object obj, String str, Object obj2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LatLng) iPatchRedirector.redirect((short) 2, this, obj, str, obj2);
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj2;
            return new LatLng(jSONObject.optDouble(QCircleSchemeAttr.Polymerize.LAT), jSONObject.optDouble("lng"));
        }
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            if (jSONArray.length() < 2) {
                return null;
            }
            if (jSONArray.length() > 2) {
                return new LatLng(jSONArray.getDouble(0), jSONArray.getDouble(1), jSONArray.getDouble(2));
            }
            return new LatLng(jSONArray.getDouble(0), jSONArray.getDouble(1));
        }
        if (!(obj2 instanceof JSONStringer) && !(obj2 instanceof String)) {
            return null;
        }
        String[] split = obj2.toString().split(",");
        if (split.length < 2) {
            return null;
        }
        if (split.length > 2) {
            return new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
        }
        return new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
    }
}
