package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.deserializer.PolygonDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class DistrictResultObject extends BaseObject {
    static IPatchRedirector $redirector_;
    public String data_version;
    public List<List<DistrictResult>> result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class DistrictResult extends JsonComposer {
        static IPatchRedirector $redirector_;
        public List<Integer> cidx;
        public String fullname;

        /* renamed from: id, reason: collision with root package name */
        public int f118545id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String name;
        public List<String> pinyin;

        @Json(deserializer = PolygonDeserializer.class, name = "polygon")
        public List<List<LatLng>> polygon;

        public DistrictResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public DistrictResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
