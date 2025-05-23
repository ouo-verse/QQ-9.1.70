package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public abstract class RoutePlanningParam implements ParamObject {
    static IPatchRedirector $redirector_;
    private LatLng from;

    /* renamed from: to, reason: collision with root package name */
    private LatLng f118543to;
    private String toPOI;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class DrivingPolicy {
        private static final /* synthetic */ DrivingPolicy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DrivingPolicy LEAST_DISTANCE;
        public static final DrivingPolicy LEAST_FEE;
        public static final DrivingPolicy LEAST_TIME;
        public static final DrivingPolicy REAL_TRAFFIC;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62987);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            DrivingPolicy drivingPolicy = new DrivingPolicy(DrivingResultObject.LEAST_TIME, 0);
            LEAST_TIME = drivingPolicy;
            DrivingPolicy drivingPolicy2 = new DrivingPolicy("LEAST_FEE", 1);
            LEAST_FEE = drivingPolicy2;
            DrivingPolicy drivingPolicy3 = new DrivingPolicy(DrivingResultObject.LEAST_DISTANCE, 2);
            LEAST_DISTANCE = drivingPolicy3;
            DrivingPolicy drivingPolicy4 = new DrivingPolicy("REAL_TRAFFIC", 3);
            REAL_TRAFFIC = drivingPolicy4;
            $VALUES = new DrivingPolicy[]{drivingPolicy, drivingPolicy2, drivingPolicy3, drivingPolicy4};
        }

        DrivingPolicy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DrivingPolicy valueOf(String str) {
            return (DrivingPolicy) Enum.valueOf(DrivingPolicy.class, str);
        }

        public static DrivingPolicy[] values() {
            return (DrivingPolicy[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class TransitPolicy {
        private static final /* synthetic */ TransitPolicy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final TransitPolicy LEAST_TIME;
        public static final TransitPolicy LEAST_TRANSFER;
        public static final TransitPolicy LEAST_WALKING;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58365);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            TransitPolicy transitPolicy = new TransitPolicy(DrivingResultObject.LEAST_TIME, 0);
            LEAST_TIME = transitPolicy;
            TransitPolicy transitPolicy2 = new TransitPolicy("LEAST_TRANSFER", 1);
            LEAST_TRANSFER = transitPolicy2;
            TransitPolicy transitPolicy3 = new TransitPolicy("LEAST_WALKING", 2);
            LEAST_WALKING = transitPolicy3;
            $VALUES = new TransitPolicy[]{transitPolicy, transitPolicy2, transitPolicy3};
        }

        TransitPolicy(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static TransitPolicy valueOf(String str) {
            return (TransitPolicy) Enum.valueOf(TransitPolicy.class, str);
        }

        public static TransitPolicy[] values() {
            return (TransitPolicy[]) $VALUES.clone();
        }
    }

    public RoutePlanningParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RequestParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put("from", locationToParamsString(this.from));
        requestParams.put("to", locationToParamsString(this.f118543to));
        if (!TextUtils.isEmpty(this.toPOI)) {
            requestParams.put("to_poi", this.toPOI);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.from != null && this.f118543to != null) {
            return true;
        }
        return false;
    }

    public RoutePlanningParam from(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RoutePlanningParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) latLng);
        }
        this.from = latLng;
        return this;
    }

    public abstract <T extends BaseObject> Class<T> getResultClass();

    public abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: protected */
    public String locationToParamsString(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) latLng);
        }
        return latLng.latitude + "," + latLng.longitude;
    }

    public RoutePlanningParam to(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RoutePlanningParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) latLng);
        }
        this.f118543to = latLng;
        return this;
    }

    public RoutePlanningParam toPOI(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RoutePlanningParam) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        this.toPOI = str;
        return this;
    }

    public RoutePlanningParam(LatLng latLng, LatLng latLng2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, (Object) latLng2);
        } else {
            this.from = latLng;
            this.f118543to = latLng2;
        }
    }
}
