package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.lbssearch.object.deserializer.RoutePlanningStepDeserializer;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TruckingResultObject extends RoutePlanningObject {
    static IPatchRedirector $redirector_;
    public Result result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class City extends JsonComposer {
        static IPatchRedirector $redirector_;
        public int adcode;
        public String city;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;

        @Json(deserializer = RoutePlanningStepDeserializer.class)
        public List<Integer> polyline_idx;
        public String province;

        public City() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Restriction extends JsonComposer {
        static IPatchRedirector $redirector_;
        public int status;

        public Restriction() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Result extends JsonComposer {
        static IPatchRedirector $redirector_;

        @Json(name = "nav_session_id")
        public String naviSessionId;
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
        public int distance;
        public int duration;
        public String mode;

        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public Restriction restriction;

        @Json(name = "route_id")
        public String routeId;

        @Json(name = "cities")
        public List<City> routeSearchCityList;
        public List<RoutePlanningObject.Step> steps;
        public List<String> tags;
        public int toll;
        public float toll_distance;

        @Json(name = "speed")
        public List<TrafficSpeed> trafficSpeeds;
        public int traffic_light_count;

        public Route() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.traffic_light_count = -1;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class TrafficSpeed extends JsonComposer {
        static IPatchRedirector $redirector_;
        public int distance;
        public int level;

        @Json(deserializer = RoutePlanningStepDeserializer.class)
        public List<Integer> polyline_idx;
        public int speed;

        public TrafficSpeed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TruckingResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
