package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class Geo2AddressParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String GET_POI = "get_poi";
    private static final String LOCATION = "location";
    private static final String POI_OPTIONS = "poi_options";
    private boolean isGetPoi;
    private LatLng latLng;
    private PoiOptions poiOptions;

    /* loaded from: classes7.dex */
    public static class PoiOptions {
        static IPatchRedirector $redirector_ = null;
        public static final String ADDRESS_FORMAT_DEFAULT = "";
        public static final String ADDRESS_FORMAT_SHORT = "short";
        public static final int POLICY_DEFAULT = 1;
        public static final int POLICY_O2O = 2;
        public static final int POLICY_SHARE = 5;
        public static final int POLICY_SOCIAL = 4;
        public static final int POLICY_TRIP = 3;
        private String addressFormat;
        private String[] categorys;
        private int pageIndex;
        private int pageSize;
        private int policy;
        private int radius;

        public PoiOptions() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public PoiOptions setAddressFormat(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PoiOptions) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.addressFormat = str;
            return this;
        }

        public PoiOptions setCategorys(String... strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (PoiOptions) iPatchRedirector.redirect((short) 7, (Object) this, (Object) strArr);
            }
            this.categorys = strArr;
            return this;
        }

        public PoiOptions setPageIndex(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (PoiOptions) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.pageIndex = i3;
            return this;
        }

        public PoiOptions setPageSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PoiOptions) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.pageSize = i3;
            return this;
        }

        public PoiOptions setPolicy(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (PoiOptions) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.policy = i3;
            return this;
        }

        public PoiOptions setRadius(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PoiOptions) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.radius = i3;
            return this;
        }

        public String toString() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(this.addressFormat)) {
                sb5.append(";address_format=");
                sb5.append(this.addressFormat);
            }
            int i16 = this.radius;
            if (i16 > 0 && i16 <= 5000) {
                sb5.append(";radius=");
                sb5.append(this.radius);
            }
            int i17 = this.pageIndex;
            if (i17 > 0 && i17 <= 20 && (i3 = this.pageSize) > 0 && i3 <= 20) {
                sb5.append(";page_index=");
                sb5.append(this.pageIndex);
                sb5.append(";page_size=");
                sb5.append(this.pageSize);
            }
            if (this.policy > 0) {
                sb5.append(";policy=");
                sb5.append(this.policy);
            }
            String[] strArr = this.categorys;
            if (strArr != null && strArr.length > 0) {
                StringBuilder sb6 = new StringBuilder();
                for (String str : this.categorys) {
                    sb6.append(str);
                    sb6.append(",");
                }
                int lastIndexOf = sb6.lastIndexOf(",");
                sb6.delete(lastIndexOf, lastIndexOf + 1);
                sb5.append(";category=");
                sb5.append(sb6.toString());
            }
            if (sb5.indexOf(";") == 0) {
                sb5.delete(0, 1);
            }
            return sb5.toString();
        }
    }

    public Geo2AddressParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.isGetPoi = false;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RequestParams) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        if (this.latLng != null) {
            requestParams.add("location", this.latLng.latitude + "," + this.latLng.longitude);
        }
        if (this.isGetPoi) {
            str = "1";
        } else {
            str = "0";
        }
        requestParams.add(GET_POI, str);
        PoiOptions poiOptions = this.poiOptions;
        if (poiOptions != null) {
            requestParams.add(POI_OPTIONS, poiOptions.toString());
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.latLng == null) {
            return false;
        }
        return true;
    }

    public Geo2AddressParam coord_type(CoordTypeEnum coordTypeEnum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Geo2AddressParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) coordTypeEnum);
        }
        return this;
    }

    public Geo2AddressParam getPoi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Geo2AddressParam) iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
        this.isGetPoi = z16;
        return this;
    }

    public Geo2AddressParam get_poi(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Geo2AddressParam) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        this.isGetPoi = z16;
        return this;
    }

    public Geo2AddressParam location(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Geo2AddressParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) latLng);
        }
        this.latLng = latLng;
        return this;
    }

    public Geo2AddressParam setPoiOptions(PoiOptions poiOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Geo2AddressParam) iPatchRedirector.redirect((short) 7, (Object) this, (Object) poiOptions);
        }
        this.poiOptions = poiOptions;
        return this;
    }

    public Geo2AddressParam(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
        } else {
            this.isGetPoi = false;
            this.latLng = latLng;
        }
    }
}
