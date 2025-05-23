package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Address2GeoResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public Address2GeoResult result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Address2GeoResult extends JsonComposer {
        static IPatchRedirector $redirector_;
        public AdInfo ad_info;
        public AddressComponent address_components;
        public float deviation;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public int level;
        public int reliability;
        public float similarity;

        public Address2GeoResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public Address2GeoResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
