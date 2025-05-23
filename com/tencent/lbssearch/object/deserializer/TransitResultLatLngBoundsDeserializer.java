package com.tencent.lbssearch.object.deserializer;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TransitResultLatLngBoundsDeserializer implements JsonParser.Deserializer<TransitResultObject.LatLngBounds> {
    static IPatchRedirector $redirector_;

    public TransitResultLatLngBoundsDeserializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public TransitResultObject.LatLngBounds deserialize(Object obj, String str, Object obj2) throws JSONException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TransitResultObject.LatLngBounds) iPatchRedirector.redirect((short) 2, this, obj, str, obj2);
        }
        TransitResultObject.LatLngBounds latLngBounds = new TransitResultObject.LatLngBounds();
        if (obj instanceof TransitResultObject.LatLngBounds) {
            latLngBounds = (TransitResultObject.LatLngBounds) obj;
        }
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            String[] split = str2.split(",");
            if (split.length == 4) {
                latLngBounds.northeast = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
                latLngBounds.southwest = new LatLng(Double.parseDouble(split[2]), Double.parseDouble(split[3]));
                return latLngBounds;
            }
        }
        return null;
    }
}
