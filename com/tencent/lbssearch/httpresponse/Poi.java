package com.tencent.lbssearch.httpresponse;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class Poi extends JsonComposer {
    static IPatchRedirector $redirector_;
    public float _distance;
    public AdInfo ad_info;
    public String address;
    public String category;

    /* renamed from: id, reason: collision with root package name */
    public String f118538id;

    @Json(deserializer = LatLngDeserializer.class, name = "location")
    public LatLng latLng;
    public String title;

    public Poi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
