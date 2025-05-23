package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.mapsdk.internal.hs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes7.dex */
public class DrivingParam extends RoutePlanningParam {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_WAT_POINTS = 30;
    private int accuracy;
    private List<List<LatLng>> avoidPolygons;
    private boolean cache;
    private String carNumber;
    private CarType carType;
    private long departureTime;
    private String fromPOI;
    private Travel fromTravel;
    private int heading;
    private final Set<String> mExtraFields;
    private int multRoute;
    private int noStep;
    private String policy;
    private RoadType roadType;
    private int speed;
    private boolean trafficSpeed;
    private List<LatLng> waypoints;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CarType {
        private static final /* synthetic */ CarType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CarType DEF;
        public static final CarType NEW_ENERGY;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62910);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CarType carType = new CarType("DEF", 0);
            DEF = carType;
            CarType carType2 = new CarType("NEW_ENERGY", 1);
            NEW_ENERGY = carType2;
            $VALUES = new CarType[]{carType, carType2};
        }

        CarType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CarType valueOf(String str) {
            return (CarType) Enum.valueOf(CarType.class, str);
        }

        public static CarType[] values() {
            return (CarType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Policy {
        private static final /* synthetic */ Policy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Policy LEAST_TIME;
        public static final Policy PICKUP;
        public static final Policy TRIP;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55120);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Policy policy = new Policy(DrivingResultObject.LEAST_TIME, 0);
            LEAST_TIME = policy;
            Policy policy2 = new Policy("PICKUP", 1);
            PICKUP = policy2;
            Policy policy3 = new Policy("TRIP", 2);
            TRIP = policy3;
            $VALUES = new Policy[]{policy, policy2, policy3};
        }

        Policy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Policy valueOf(String str) {
            return (Policy) Enum.valueOf(Policy.class, str);
        }

        public static Policy[] values() {
            return (Policy[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Preference {
        private static final /* synthetic */ Preference[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Preference AVOID_HIGHWAY;
        public static final Preference HIGHROAD_FIRST;
        public static final Preference HIGHWAY_FIRST;
        public static final Preference LEAST_FEE;
        public static final Preference NAV_POINT_FIRST;
        public static final Preference REAL_TRAFFIC;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52751);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Preference preference = new Preference("REAL_TRAFFIC", 0);
            REAL_TRAFFIC = preference;
            Preference preference2 = new Preference("LEAST_FEE", 1);
            LEAST_FEE = preference2;
            Preference preference3 = new Preference("HIGHWAY_FIRST", 2);
            HIGHWAY_FIRST = preference3;
            Preference preference4 = new Preference("AVOID_HIGHWAY", 3);
            AVOID_HIGHWAY = preference4;
            Preference preference5 = new Preference("HIGHROAD_FIRST", 4);
            HIGHROAD_FIRST = preference5;
            Preference preference6 = new Preference("NAV_POINT_FIRST", 5);
            NAV_POINT_FIRST = preference6;
            $VALUES = new Preference[]{preference, preference2, preference3, preference4, preference5, preference6};
        }

        Preference(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static Preference valueOf(String str) {
            return (Preference) Enum.valueOf(Preference.class, str);
        }

        public static Preference[] values() {
            return (Preference[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class RoadType {
        private static final /* synthetic */ RoadType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final RoadType ABOVE_BRIDGE;
        public static final RoadType BELOW_BRIDGE;
        public static final RoadType DEF;
        public static final RoadType ON_MAIN_ROAD;
        public static final RoadType ON_MAIN_ROAD_BELOW_BRIDGE;
        public static final RoadType ON_SIDE_ROAD;
        public static final RoadType ON_SIDE_ROAD_BELOW_BRIDGE;
        public static final RoadType OPPOSITE_SIDE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63605);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            RoadType roadType = new RoadType("DEF", 0);
            DEF = roadType;
            RoadType roadType2 = new RoadType("ABOVE_BRIDGE", 1);
            ABOVE_BRIDGE = roadType2;
            RoadType roadType3 = new RoadType("BELOW_BRIDGE", 2);
            BELOW_BRIDGE = roadType3;
            RoadType roadType4 = new RoadType("ON_MAIN_ROAD", 3);
            ON_MAIN_ROAD = roadType4;
            RoadType roadType5 = new RoadType("ON_SIDE_ROAD", 4);
            ON_SIDE_ROAD = roadType5;
            RoadType roadType6 = new RoadType("OPPOSITE_SIDE", 5);
            OPPOSITE_SIDE = roadType6;
            RoadType roadType7 = new RoadType("ON_MAIN_ROAD_BELOW_BRIDGE", 6);
            ON_MAIN_ROAD_BELOW_BRIDGE = roadType7;
            RoadType roadType8 = new RoadType("ON_SIDE_ROAD_BELOW_BRIDGE", 7);
            ON_SIDE_ROAD_BELOW_BRIDGE = roadType8;
            $VALUES = new RoadType[]{roadType, roadType2, roadType3, roadType4, roadType5, roadType6, roadType7, roadType8};
        }

        RoadType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static RoadType valueOf(String str) {
            return (RoadType) Enum.valueOf(RoadType.class, str);
        }

        public static RoadType[] values() {
            return (RoadType[]) $VALUES.clone();
        }
    }

    /* loaded from: classes7.dex */
    public static class Travel {
        static IPatchRedirector $redirector_;
        public List<Point> points;

        /* loaded from: classes7.dex */
        public static class Point {
            static IPatchRedirector $redirector_;
            private int accuracy;
            private int directionOfCar;
            private int directionOfDevice;
            private LatLng latLng;
            private int speed;
            private int time;

            public Point(LatLng latLng) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) latLng);
                    return;
                }
                this.speed = -1;
                this.accuracy = -1;
                this.directionOfCar = -1;
                this.directionOfDevice = -1;
                this.time = 0;
                this.latLng = latLng;
            }

            public Point setAccuracy(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Point) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                this.accuracy = i3;
                return this;
            }

            public Point setDirectionOfCar(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Point) iPatchRedirector.redirect((short) 4, (Object) this, i3);
                }
                this.directionOfCar = i3;
                return this;
            }

            public Point setDirectionOfDevice(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (Point) iPatchRedirector.redirect((short) 5, (Object) this, i3);
                }
                this.directionOfDevice = i3;
                return this;
            }

            public Point setSpeed(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Point) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                this.speed = i3;
                return this;
            }

            public Point setTime(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (Point) iPatchRedirector.redirect((short) 6, (Object) this, i3);
                }
                this.time = i3;
                return this;
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return (String) iPatchRedirector.redirect((short) 7, (Object) this);
                }
                StringBuilder sb5 = new StringBuilder();
                LatLng latLng = this.latLng;
                if (latLng != null) {
                    sb5.append(latLng.latitude);
                    sb5.append(",");
                    sb5.append(this.latLng.longitude);
                    sb5.append(",");
                }
                sb5.append(this.speed);
                sb5.append(",");
                sb5.append(this.accuracy);
                sb5.append(",");
                sb5.append(this.directionOfCar);
                sb5.append(",");
                sb5.append(this.directionOfDevice);
                sb5.append(",");
                sb5.append(this.time);
                return sb5.toString();
            }
        }

        public Travel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.points = new ArrayList();
            }
        }

        public void addPoints(Point... pointArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) pointArr);
            } else if (pointArr != null) {
                this.points.addAll(Arrays.asList(pointArr));
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            int size = this.points.size();
            if (size > 50) {
                size = 50;
            }
            for (int i3 = 0; i3 < size; i3++) {
                Objects.toString(this.points.get(i3));
            }
            return super.toString();
        }
    }

    public DrivingParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.waypoints = new ArrayList();
        this.departureTime = -1L;
        this.heading = -1;
        this.speed = -1;
        this.accuracy = -1;
        this.roadType = RoadType.DEF;
        this.carType = CarType.DEF;
        this.noStep = 0;
        this.mExtraFields = new HashSet();
    }

    public DrivingParam accuracy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
        this.accuracy = i3;
        return this;
    }

    public DrivingParam addWayPoint(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 14, (Object) this, (Object) latLng);
        }
        if (this.waypoints.size() < 30) {
            this.waypoints.add(latLng);
        }
        return this;
    }

    public DrivingParam addWayPoints(Iterable<LatLng> iterable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 15, (Object) this, (Object) iterable);
        }
        if (iterable != null) {
            Iterator<LatLng> it = iterable.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                this.waypoints.add(it.next());
                i3++;
                if (i3 > 30) {
                    break;
                }
            }
        }
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (RequestParams) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.fromPOI)) {
            buildParameters.put("from_poi", this.fromPOI);
        }
        int i3 = this.heading;
        if (i3 != -1) {
            buildParameters.put("heading", i3);
        }
        int i16 = this.speed;
        if (i16 != -1) {
            buildParameters.put("speed", i16);
        }
        int i17 = this.accuracy;
        if (i17 != -1) {
            buildParameters.put("accuracy", i17);
        }
        if (this.trafficSpeed) {
            buildParameters.put("get_speed", 1);
        }
        buildParameters.put("road_type", this.roadType.ordinal());
        buildParameters.put("no_step", this.noStep);
        buildParameters.put("get_mp", this.multRoute);
        Travel travel = this.fromTravel;
        if (travel != null && travel.points.size() > 0) {
            buildParameters.put("from_track", this.fromTravel.toString());
        }
        long j3 = this.departureTime;
        if (j3 >= 0) {
            buildParameters.put("departure_time", j3);
        }
        if (this.waypoints.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            Iterator<LatLng> it = this.waypoints.iterator();
            while (it.hasNext()) {
                sb5.append(locationToParamsString(it.next()));
                sb5.append(";");
            }
            sb5.setLength(sb5.length() - 1);
            buildParameters.put("waypoints", sb5.toString());
        }
        if (!TextUtils.isEmpty(this.policy)) {
            buildParameters.put("policy", this.policy);
        }
        if (!TextUtils.isEmpty(this.carNumber)) {
            buildParameters.put("plate_number", this.carNumber);
        }
        buildParameters.put("car_type", this.carType.ordinal());
        if (!this.mExtraFields.isEmpty()) {
            buildParameters.put("added_fields", hs.a(this.mExtraFields, ","));
        }
        if (this.cache) {
            str = "1";
        } else {
            str = "0";
        }
        buildParameters.put("is_cache", str);
        if (this.avoidPolygons != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i18 = 0; i18 < this.avoidPolygons.size(); i18++) {
                List<LatLng> list = this.avoidPolygons.get(i18);
                for (int i19 = 0; i19 < list.size(); i19++) {
                    LatLng latLng = list.get(i19);
                    stringBuffer.append(latLng.latitude);
                    stringBuffer.append(',');
                    stringBuffer.append(latLng.longitude);
                    if (i19 != list.size() - 1) {
                        stringBuffer.append(';');
                    }
                }
                if (i18 != this.avoidPolygons.size() - 1) {
                    stringBuffer.append(QbAddrData.DATA_SPLITER);
                }
            }
            buildParameters.put("avoid_polygons", stringBuffer.toString());
        }
        return buildParameters;
    }

    public DrivingParam cache(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
        this.cache = z16;
        return this;
    }

    public DrivingParam departureTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 23, (Object) this, j3);
        }
        if (j3 >= 0) {
            this.departureTime = j3;
        }
        return this;
    }

    public DrivingParam fromPOI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.fromPOI = str;
        return this;
    }

    public DrivingParam fromTravel(Travel travel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) travel);
        }
        this.fromTravel = travel;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<DrivingResultObject> getResultClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Class) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return DrivingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return UrlConstant.ROUTE_PLANNING_DRIVING;
    }

    public DrivingParam heading(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        this.heading = i3;
        return this;
    }

    public DrivingParam policy(Policy policy, Preference... preferenceArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 12, (Object) this, (Object) policy, (Object) preferenceArr);
        }
        StringBuilder sb5 = new StringBuilder();
        if (policy != null) {
            sb5.append(policy.name());
        }
        if (preferenceArr != null && preferenceArr.length > 0) {
            for (Preference preference : preferenceArr) {
                sb5.append(",");
                sb5.append(preference.name());
            }
        }
        this.policy = sb5.toString();
        return this;
    }

    public DrivingParam roadType(RoadType roadType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 9, (Object) this, (Object) roadType);
        }
        this.roadType = roadType;
        return this;
    }

    public DrivingParam setAvoidPolygons(List<List<LatLng>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 19, (Object) this, (Object) list);
        }
        this.avoidPolygons = list;
        return this;
    }

    public DrivingParam setCarNumber(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        this.carNumber = str;
        return this;
    }

    public DrivingParam setCarType(CarType carType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 17, (Object) this, (Object) carType);
        }
        this.carType = carType;
        return this;
    }

    public DrivingParam setExtraFields(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 21, (Object) this, (Object) strArr);
        }
        this.mExtraFields.addAll(Arrays.asList(strArr));
        return this;
    }

    public DrivingParam setMultRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 20, (Object) this, i3);
        }
        this.multRoute = i3;
        return this;
    }

    public void setMultyPlan(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    public DrivingParam setNoStep(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 18, (Object) this, i3);
        }
        this.noStep = i3;
        return this;
    }

    public DrivingParam speed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        this.speed = i3;
        return this;
    }

    public DrivingParam trafficSpeed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
        this.trafficSpeed = z16;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public DrivingParam toPOI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (DrivingParam) super.toPOI(str) : (DrivingParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    public DrivingParam policy(RoutePlanningParam.DrivingPolicy drivingPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (DrivingParam) iPatchRedirector.redirect((short) 13, (Object) this, (Object) drivingPolicy);
        }
        StringBuilder sb5 = new StringBuilder();
        if (drivingPolicy != null) {
            sb5.append(drivingPolicy.name());
        }
        this.policy = sb5.toString();
        return this;
    }

    public DrivingParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, (Object) latLng2);
            return;
        }
        this.waypoints = new ArrayList();
        this.departureTime = -1L;
        this.heading = -1;
        this.speed = -1;
        this.accuracy = -1;
        this.roadType = RoadType.DEF;
        this.carType = CarType.DEF;
        this.noStep = 0;
        this.mExtraFields = new HashSet();
    }
}
