package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class WalkingResultObject extends RoutePlanningObject {
    static IPatchRedirector $redirector_;
    public Result result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Result extends JsonComposer {
        static IPatchRedirector $redirector_;
        public List<Route> routes;

        public Result() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Route extends JsonComposer {
        static IPatchRedirector $redirector_;
        public String direction;
        public float distance;
        public float duration;
        public String mode;

        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public List<RoutePlanningObject.Step> steps;

        public Route() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public WalkingResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
