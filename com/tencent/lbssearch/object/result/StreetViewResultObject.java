package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes7.dex */
public class StreetViewResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public Details detail;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Details extends JsonComposer {
        static IPatchRedirector $redirector_;
        public String description;
        public int heading;

        /* renamed from: id, reason: collision with root package name */
        public String f118550id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public int pitch;
        public int pov_exp;
        public int zoom;

        public Details() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public StreetViewResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
