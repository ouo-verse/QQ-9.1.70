package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.lbssearch.object.deserializer.TransitResultLatLngBoundsDeserializer;
import com.tencent.lbssearch.object.deserializer.TransitResultSegmentDeserializer;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class TransitResultObject extends RoutePlanningObject {
    static IPatchRedirector $redirector_;
    public Result result;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Destination extends JsonComposer {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public String f118553id;
        public String title;

        public Destination() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Exit extends JsonComposer {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public String f118554id;
        public String title;

        public Exit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class GetOnOrOff extends JsonComposer {
        static IPatchRedirector $redirector_;
        public Exit exit;

        /* renamed from: id, reason: collision with root package name */
        public String f118555id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String title;

        public GetOnOrOff() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @JsonType(deserializer = TransitResultLatLngBoundsDeserializer.class)
    /* loaded from: classes7.dex */
    public static final class LatLngBounds extends JsonComposer {
        static IPatchRedirector $redirector_;
        public LatLng northeast;
        public LatLng southwest;

        public LatLngBounds() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Line extends JsonComposer {
        static IPatchRedirector $redirector_;
        public Destination destination;
        public float distance;
        public float duration;
        public GetOnOrOff getoff;
        public GetOnOrOff geton;

        /* renamed from: id, reason: collision with root package name */
        public String f118556id;

        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public double price;
        public int running_status;
        public int station_count;
        public List<Station> stations;
        public String title;
        public String vehicle;

        public Line() {
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
        public LatLngBounds bounds;
        public float distance;
        public long duration;
        public long duration_1m;
        public List<Segment> steps;

        public Route() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @JsonType(deserializer = TransitResultSegmentDeserializer.class)
    /* loaded from: classes7.dex */
    public static abstract class Segment extends JsonComposer {
        static IPatchRedirector $redirector_;
        public String mode;

        public Segment() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Station extends JsonComposer {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public String f118557id;

        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String title;

        public Station() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Transit extends Segment {
        static IPatchRedirector $redirector_;
        public List<Line> lines;

        public Transit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class Walking extends Segment {
        static IPatchRedirector $redirector_;
        public String accessorial_desc;
        public String direction;
        public float distance;
        public float duration;

        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public List<RoutePlanningObject.Step> steps;

        public Walking() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TransitResultObject() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
