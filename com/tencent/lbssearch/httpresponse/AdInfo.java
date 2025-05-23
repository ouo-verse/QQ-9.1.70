package com.tencent.lbssearch.httpresponse;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AdInfo extends JsonComposer {
    static IPatchRedirector $redirector_;
    public String adcode;
    public String city;
    public String city_code;
    public String district;

    @Json(deserializer = LatLngDeserializer.class, name = "location")
    public LatLng latLng;
    public String name;
    public String nation;
    public String nation_code;
    public String phone_area_code;
    public String province;

    public AdInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
