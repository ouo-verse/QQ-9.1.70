package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class TranslateParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String LOCATIONS = "locations";
    private static final String TYPES = "type";
    private List<LatLng> latLngs;
    private CoordType type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CoordType {
        private static final /* synthetic */ CoordType[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final CoordType BAIDU;
        public static final CoordType GPS;
        public static final CoordType MAPBAR;
        public static final CoordType NONE;
        public static final CoordType SOGOU;
        public static final CoordType SOGOUMERCATOR;
        public static final CoordType STANDARD;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60079);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CoordType coordType = new CoordType("NONE", 0);
            NONE = coordType;
            CoordType coordType2 = new CoordType("GPS", 1);
            GPS = coordType2;
            CoordType coordType3 = new CoordType("SOGOU", 2);
            SOGOU = coordType3;
            CoordType coordType4 = new CoordType("BAIDU", 3);
            BAIDU = coordType4;
            CoordType coordType5 = new CoordType("MAPBAR", 4);
            MAPBAR = coordType5;
            CoordType coordType6 = new CoordType("STANDARD", 5);
            STANDARD = coordType6;
            CoordType coordType7 = new CoordType("SOGOUMERCATOR", 6);
            SOGOUMERCATOR = coordType7;
            $VALUES = new CoordType[]{coordType, coordType2, coordType3, coordType4, coordType5, coordType6, coordType7};
        }

        CoordType(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static CoordType valueOf(String str) {
            return (CoordType) Enum.valueOf(CoordType.class, str);
        }

        public static CoordType[] values() {
            return (CoordType[]) $VALUES.clone();
        }
    }

    public TranslateParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.type = CoordType.STANDARD;
        }
    }

    public TranslateParam addLocation(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TranslateParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
        }
        if (this.latLngs == null) {
            this.latLngs = new ArrayList();
        }
        this.latLngs.add(latLng);
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RequestParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        List<LatLng> list = this.latLngs;
        if (list != null && list.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.latLngs.size(); i3++) {
                String str = "";
                if (i3 != 0) {
                    str = ";";
                }
                sb5.append(str + this.latLngs.get(i3).latitude + "," + this.latLngs.get(i3).longitude);
            }
            requestParams.add(LOCATIONS, sb5.toString());
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(this.type.ordinal());
        requestParams.add("type", sb6.toString());
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.latLngs != null) {
            return true;
        }
        return false;
    }

    public TranslateParam coordType(CoordType coordType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TranslateParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) coordType);
        }
        this.type = coordType;
        return this;
    }

    public TranslateParam coord_type(CoordTypeEnum coordTypeEnum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TranslateParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) coordTypeEnum);
        }
        coordType(coordTypeEnum.coordType);
        return this;
    }

    public TranslateParam locations(LatLng... latLngArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TranslateParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) latLngArr);
        }
        if (this.latLngs == null) {
            this.latLngs = new ArrayList();
        }
        for (LatLng latLng : latLngArr) {
            this.latLngs.add(latLng);
        }
        return this;
    }
}
