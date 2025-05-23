package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.result.TruckingResultObject;
import com.tencent.mapsdk.internal.hs;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public class TruckingParam extends RoutePlanningParam {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_WAT_POINTS = 30;
    private int axleCount;
    private double axleWeight;
    private EnergyType energyType;
    private String fromPOI;
    private GasEmissionStandard gasEmissionStandard;
    private GoodsType goodsType;
    private int isTrailer;
    private final Set<String> mExtraFields;
    private int multRoute;
    private int noPolyline;
    private int noStep;
    private PassType passType;
    private PlateColor plateColor;
    private Policy policy;
    private boolean trafficSpeed;
    private TrailerType trailerType;
    private double truckHeight;
    private double truckLength;
    private double truckLoad;
    private String truckNumber;
    private TruckSize truckSize;
    private double truckWeight;
    private double truckWidth;
    private List<LatLng> waypoints;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class EnergyType {
        private static final /* synthetic */ EnergyType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final EnergyType DIESEL;
        public static final EnergyType ELECTRIC;
        public static final EnergyType GASOLINE;
        public static final EnergyType GAS_ELECTRIC_HYBRID;
        public static final EnergyType UNLIMITED;
        public final int energyType;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61251);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            EnergyType energyType = new EnergyType("UNLIMITED", 0, 0);
            UNLIMITED = energyType;
            EnergyType energyType2 = new EnergyType("DIESEL", 1, 1);
            DIESEL = energyType2;
            EnergyType energyType3 = new EnergyType("GAS_ELECTRIC_HYBRID", 2, 2);
            GAS_ELECTRIC_HYBRID = energyType3;
            EnergyType energyType4 = new EnergyType("ELECTRIC", 3, 3);
            ELECTRIC = energyType4;
            EnergyType energyType5 = new EnergyType("GASOLINE", 4, 4);
            GASOLINE = energyType5;
            $VALUES = new EnergyType[]{energyType, energyType2, energyType3, energyType4, energyType5};
        }

        EnergyType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.energyType = i16;
            }
        }

        public static EnergyType valueOf(String str) {
            return (EnergyType) Enum.valueOf(EnergyType.class, str);
        }

        public static EnergyType[] values() {
            return (EnergyType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class GasEmissionStandard {
        private static final /* synthetic */ GasEmissionStandard[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final GasEmissionStandard NATIONAL_STANDARD_I;
        public static final GasEmissionStandard NATIONAL_STANDARD_II;
        public static final GasEmissionStandard NATIONAL_STANDARD_III;
        public static final GasEmissionStandard NATIONAL_STANDARD_IV;
        public static final GasEmissionStandard NATIONAL_STANDARD_V;
        public static final GasEmissionStandard NATIONAL_STANDARD_VI;
        public static final GasEmissionStandard UNLIMITED;
        public final int gasEmissionStandard;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62059);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            GasEmissionStandard gasEmissionStandard = new GasEmissionStandard("UNLIMITED", 0, 0);
            UNLIMITED = gasEmissionStandard;
            GasEmissionStandard gasEmissionStandard2 = new GasEmissionStandard("NATIONAL_STANDARD_I", 1, 1);
            NATIONAL_STANDARD_I = gasEmissionStandard2;
            GasEmissionStandard gasEmissionStandard3 = new GasEmissionStandard("NATIONAL_STANDARD_II", 2, 2);
            NATIONAL_STANDARD_II = gasEmissionStandard3;
            GasEmissionStandard gasEmissionStandard4 = new GasEmissionStandard("NATIONAL_STANDARD_III", 3, 3);
            NATIONAL_STANDARD_III = gasEmissionStandard4;
            GasEmissionStandard gasEmissionStandard5 = new GasEmissionStandard("NATIONAL_STANDARD_IV", 4, 4);
            NATIONAL_STANDARD_IV = gasEmissionStandard5;
            GasEmissionStandard gasEmissionStandard6 = new GasEmissionStandard("NATIONAL_STANDARD_V", 5, 5);
            NATIONAL_STANDARD_V = gasEmissionStandard6;
            GasEmissionStandard gasEmissionStandard7 = new GasEmissionStandard("NATIONAL_STANDARD_VI", 6, 6);
            NATIONAL_STANDARD_VI = gasEmissionStandard7;
            $VALUES = new GasEmissionStandard[]{gasEmissionStandard, gasEmissionStandard2, gasEmissionStandard3, gasEmissionStandard4, gasEmissionStandard5, gasEmissionStandard6, gasEmissionStandard7};
        }

        GasEmissionStandard(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.gasEmissionStandard = i16;
            }
        }

        public static GasEmissionStandard valueOf(String str) {
            return (GasEmissionStandard) Enum.valueOf(GasEmissionStandard.class, str);
        }

        public static GasEmissionStandard[] values() {
            return (GasEmissionStandard[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class GoodsType {
        private static final /* synthetic */ GoodsType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final GoodsType DANGEROUS;
        public static final GoodsType ORIGINAL;
        public final int goodsType;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63075);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            GoodsType goodsType = new GoodsType("ORIGINAL", 0, 0);
            ORIGINAL = goodsType;
            GoodsType goodsType2 = new GoodsType("DANGEROUS", 1, 1);
            DANGEROUS = goodsType2;
            $VALUES = new GoodsType[]{goodsType, goodsType2};
        }

        GoodsType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.goodsType = i16;
            }
        }

        public static GoodsType valueOf(String str) {
            return (GoodsType) Enum.valueOf(GoodsType.class, str);
        }

        public static GoodsType[] values() {
            return (GoodsType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class PassType {
        private static final /* synthetic */ PassType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PassType HAS_PASS;
        public static final PassType NO_PASS;
        public static final PassType RESERVE_PASS;
        public static final PassType UNLIMITED_PASS;
        public final int passType;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62777);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PassType passType = new PassType("UNLIMITED_PASS", 0, 0);
            UNLIMITED_PASS = passType;
            PassType passType2 = new PassType("HAS_PASS", 1, 1);
            HAS_PASS = passType2;
            PassType passType3 = new PassType("NO_PASS", 2, 2);
            NO_PASS = passType3;
            PassType passType4 = new PassType("RESERVE_PASS", 3, 3);
            RESERVE_PASS = passType4;
            $VALUES = new PassType[]{passType, passType2, passType3, passType4};
        }

        PassType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.passType = i16;
            }
        }

        public static PassType valueOf(String str) {
            return (PassType) Enum.valueOf(PassType.class, str);
        }

        public static PassType[] values() {
            return (PassType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class PlateColor {
        private static final /* synthetic */ PlateColor[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final PlateColor BLACK;
        public static final PlateColor BLUE;
        public static final PlateColor GREEN;
        public static final PlateColor WHITE;
        public static final PlateColor YELLOW;
        public final int plateColor;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63127);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            PlateColor plateColor = new PlateColor("BLUE", 0, 1);
            BLUE = plateColor;
            PlateColor plateColor2 = new PlateColor("YELLOW", 1, 2);
            YELLOW = plateColor2;
            PlateColor plateColor3 = new PlateColor("BLACK", 2, 3);
            BLACK = plateColor3;
            PlateColor plateColor4 = new PlateColor("WHITE", 3, 4);
            WHITE = plateColor4;
            PlateColor plateColor5 = new PlateColor("GREEN", 4, 5);
            GREEN = plateColor5;
            $VALUES = new PlateColor[]{plateColor, plateColor2, plateColor3, plateColor4, plateColor5};
        }

        PlateColor(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.plateColor = i16;
            }
        }

        public static PlateColor valueOf(String str) {
            return (PlateColor) Enum.valueOf(PlateColor.class, str);
        }

        public static PlateColor[] values() {
            return (PlateColor[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Policy {
        private static final /* synthetic */ Policy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Policy AVOID_HIGHWAY;
        public static final Policy AVOID_HIGHWAY_LESS_FEE;
        public static final Policy AVOID_JAM_HIGHWAY;
        public static final Policy AVOID_JAM_HIGHWAY_LESS_FEE;
        public static final Policy AVOID_JAM_LESS_FEE;
        public static final Policy HIGHWAY_FIRST;
        public static final Policy HIGHWAY_FIRST_AVOID_JAM;
        public static final Policy LEAST_FEE;
        public static final Policy REAL_TRAFFIC;
        public final int policyValue;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63119);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Policy policy = new Policy("REAL_TRAFFIC", 0, 1);
            REAL_TRAFFIC = policy;
            Policy policy2 = new Policy("AVOID_HIGHWAY", 1, 2);
            AVOID_HIGHWAY = policy2;
            Policy policy3 = new Policy("LEAST_FEE", 2, 3);
            LEAST_FEE = policy3;
            Policy policy4 = new Policy("AVOID_JAM_HIGHWAY", 3, 4);
            AVOID_JAM_HIGHWAY = policy4;
            Policy policy5 = new Policy("AVOID_HIGHWAY_LESS_FEE", 4, 5);
            AVOID_HIGHWAY_LESS_FEE = policy5;
            Policy policy6 = new Policy("AVOID_JAM_LESS_FEE", 5, 6);
            AVOID_JAM_LESS_FEE = policy6;
            Policy policy7 = new Policy("AVOID_JAM_HIGHWAY_LESS_FEE", 6, 7);
            AVOID_JAM_HIGHWAY_LESS_FEE = policy7;
            Policy policy8 = new Policy("HIGHWAY_FIRST", 7, 8);
            HIGHWAY_FIRST = policy8;
            Policy policy9 = new Policy("HIGHWAY_FIRST_AVOID_JAM", 8, 9);
            HIGHWAY_FIRST_AVOID_JAM = policy9;
            $VALUES = new Policy[]{policy, policy2, policy3, policy4, policy5, policy6, policy7, policy8, policy9};
        }

        Policy(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.policyValue = i16;
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
    public static final class TrailerType {
        private static final /* synthetic */ TrailerType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TrailerType FLATBED;
        public static final TrailerType FULLTRAILER;
        public static final TrailerType NONE;
        public static final TrailerType SEMITRAILER;
        public static final TrailerType VAN;
        public final int trailerType;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61087);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TrailerType trailerType = new TrailerType("NONE", 0, 0);
            NONE = trailerType;
            TrailerType trailerType2 = new TrailerType("FLATBED", 1, 1);
            FLATBED = trailerType2;
            TrailerType trailerType3 = new TrailerType("VAN", 2, 2);
            VAN = trailerType3;
            TrailerType trailerType4 = new TrailerType("SEMITRAILER", 3, 3);
            SEMITRAILER = trailerType4;
            TrailerType trailerType5 = new TrailerType("FULLTRAILER", 4, 4);
            FULLTRAILER = trailerType5;
            $VALUES = new TrailerType[]{trailerType, trailerType2, trailerType3, trailerType4, trailerType5};
        }

        TrailerType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.trailerType = i16;
            }
        }

        public static TrailerType valueOf(String str) {
            return (TrailerType) Enum.valueOf(TrailerType.class, str);
        }

        public static TrailerType[] values() {
            return (TrailerType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class TruckSize {
        private static final /* synthetic */ TruckSize[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TruckSize HEAVY;
        public static final TruckSize LIGHT;
        public static final TruckSize MIDDLE;
        public static final TruckSize TINY;
        public final int size;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63284);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TruckSize truckSize = new TruckSize("TINY", 0, 1);
            TINY = truckSize;
            TruckSize truckSize2 = new TruckSize("LIGHT", 1, 2);
            LIGHT = truckSize2;
            TruckSize truckSize3 = new TruckSize("MIDDLE", 2, 3);
            MIDDLE = truckSize3;
            TruckSize truckSize4 = new TruckSize("HEAVY", 3, 4);
            HEAVY = truckSize4;
            $VALUES = new TruckSize[]{truckSize, truckSize2, truckSize3, truckSize4};
        }

        TruckSize(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.size = i16;
            }
        }

        public static TruckSize valueOf(String str) {
            return (TruckSize) Enum.valueOf(TruckSize.class, str);
        }

        public static TruckSize[] values() {
            return (TruckSize[]) $VALUES.clone();
        }
    }

    public TruckingParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.truckSize = TruckSize.LIGHT;
        this.truckLength = 4.2d;
        this.truckHeight = 1.8d;
        this.truckWidth = 1.9d;
        this.truckWeight = 2.5d;
        this.truckLoad = 2.0d;
        this.axleWeight = 2.0d;
        this.axleCount = 2;
        this.trailerType = TrailerType.NONE;
        this.isTrailer = 0;
        this.goodsType = GoodsType.ORIGINAL;
        this.energyType = EnergyType.UNLIMITED;
        this.gasEmissionStandard = GasEmissionStandard.UNLIMITED;
        this.passType = PassType.UNLIMITED_PASS;
        this.waypoints = new ArrayList();
        this.policy = Policy.REAL_TRAFFIC;
        this.plateColor = PlateColor.BLUE;
        this.multRoute = 0;
        this.noStep = 0;
        this.noPolyline = 0;
        this.mExtraFields = new HashSet();
    }

    public TruckingParam addWayPoint(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 14, (Object) this, (Object) latLng);
        }
        if (this.waypoints.size() < 30) {
            this.waypoints.add(latLng);
        }
        return this;
    }

    public TruckingParam addWayPoints(Iterable<LatLng> iterable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 15, (Object) this, (Object) iterable);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RequestParams) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.fromPOI)) {
            buildParameters.put("from_poi", this.fromPOI);
        }
        buildParameters.put("size", this.truckSize.size);
        buildParameters.put("length", Double.valueOf(this.truckLength));
        buildParameters.put("height", Double.valueOf(this.truckHeight));
        buildParameters.put("width", Double.valueOf(this.truckWidth));
        buildParameters.put("weight", Double.valueOf(this.truckWeight));
        buildParameters.put("load", Double.valueOf(this.truckLoad));
        buildParameters.put("axle_weight", Double.valueOf(this.axleWeight));
        buildParameters.put("axle_count", this.axleCount);
        buildParameters.put("is_trailer", this.isTrailer);
        buildParameters.put("trailer_type", this.trailerType.trailerType);
        buildParameters.put("goods_type", this.goodsType.goodsType);
        buildParameters.put("energy_type", this.energyType.energyType);
        buildParameters.put("gas_emisstand", this.gasEmissionStandard.gasEmissionStandard);
        buildParameters.put("pass_type", this.passType.passType);
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
        buildParameters.put("policy", this.policy.policyValue);
        if (!TextUtils.isEmpty(this.truckNumber)) {
            buildParameters.put("plate_number", this.truckNumber);
        }
        buildParameters.put("plate_color", this.plateColor.plateColor);
        if (this.trafficSpeed) {
            buildParameters.put("get_speed", 1);
        }
        if (!this.mExtraFields.isEmpty()) {
            buildParameters.put("added_fields", hs.a(this.mExtraFields, ","));
        }
        buildParameters.put("get_mp", this.multRoute);
        buildParameters.put("no_step", this.noStep);
        buildParameters.put("no_polyline", this.noPolyline);
        return buildParameters;
    }

    public TruckingParam fromPOI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.fromPOI = str;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<TruckingResultObject> getResultClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (Class) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return TruckingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (String) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return UrlConstant.ROUTE_PLANNING_TRUCKING;
    }

    public TruckingParam setAxleCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        this.axleCount = i3;
        return this;
    }

    public TruckingParam setAxleWeight(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 11, this, Double.valueOf(d16));
        }
        this.axleWeight = d16;
        return this;
    }

    public TruckingParam setEnergyType(EnergyType energyType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 21, (Object) this, (Object) energyType);
        }
        this.energyType = energyType;
        return this;
    }

    public TruckingParam setExtraFields(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 28, (Object) this, (Object) strArr);
        }
        this.mExtraFields.addAll(Arrays.asList(strArr));
        return this;
    }

    public TruckingParam setGasEmissionStandard(GasEmissionStandard gasEmissionStandard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 22, (Object) this, (Object) gasEmissionStandard);
        }
        this.gasEmissionStandard = gasEmissionStandard;
        return this;
    }

    public TruckingParam setGoodsType(GoodsType goodsType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 20, (Object) this, (Object) goodsType);
        }
        this.goodsType = goodsType;
        return this;
    }

    public TruckingParam setMultRoute(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        this.multRoute = i3;
        return this;
    }

    public TruckingParam setNoPolyline(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
        this.noPolyline = i3;
        return this;
    }

    public TruckingParam setNoStep(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 26, (Object) this, i3);
        }
        this.noStep = i3;
        return this;
    }

    public TruckingParam setPassType(PassType passType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 23, (Object) this, (Object) passType);
        }
        this.passType = passType;
        return this;
    }

    public TruckingParam setPlateColor(PlateColor plateColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 18, (Object) this, (Object) plateColor);
        }
        this.plateColor = plateColor;
        return this;
    }

    public TruckingParam setPolicy(Policy policy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 16, (Object) this, (Object) policy);
        }
        this.policy = policy;
        return this;
    }

    public TruckingParam setTrailer(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        this.isTrailer = i3;
        return this;
    }

    public TruckingParam setTrailerType(TrailerType trailerType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 19, (Object) this, (Object) trailerType);
        }
        this.trailerType = trailerType;
        return this;
    }

    public TruckingParam setTruckHeight(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16));
        }
        this.truckHeight = d16;
        return this;
    }

    public TruckingParam setTruckLength(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 6, this, Double.valueOf(d16));
        }
        this.truckLength = d16;
        return this;
    }

    public TruckingParam setTruckLoad(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 10, this, Double.valueOf(d16));
        }
        this.truckLoad = d16;
        return this;
    }

    public TruckingParam setTruckNumber(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        this.truckNumber = str;
        return this;
    }

    public TruckingParam setTruckSize(TruckSize truckSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) truckSize);
        }
        this.truckSize = truckSize;
        return this;
    }

    public TruckingParam setTruckWeight(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 9, this, Double.valueOf(d16));
        }
        this.truckWeight = d16;
        return this;
    }

    public TruckingParam setTruckWidth(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 8, this, Double.valueOf(d16));
        }
        this.truckWidth = d16;
        return this;
    }

    public TruckingParam trafficSpeed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (TruckingParam) iPatchRedirector.redirect((short) 24, (Object) this, z16);
        }
        this.trafficSpeed = z16;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public TruckingParam toPOI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? (TruckingParam) super.toPOI(str) : (TruckingParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
    }
}
