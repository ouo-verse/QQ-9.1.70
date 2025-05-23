package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class TransitParam extends RoutePlanningParam {
    static IPatchRedirector $redirector_;
    private long departureTime;
    private String policy;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Policy {
        private static final /* synthetic */ Policy[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final Policy LEAST_TIME;
        public static final Policy LEAST_TRANSFER;
        public static final Policy LEAST_WALKING;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58961);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Policy policy = new Policy(DrivingResultObject.LEAST_TIME, 0);
            LEAST_TIME = policy;
            Policy policy2 = new Policy("LEAST_TRANSFER", 1);
            LEAST_TRANSFER = policy2;
            Policy policy3 = new Policy("LEAST_WALKING", 2);
            LEAST_WALKING = policy3;
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
        public static final Preference NO_SUBWAY;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61589);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Preference preference = new Preference("NO_SUBWAY", 0);
            NO_SUBWAY = preference;
            $VALUES = new Preference[]{preference};
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

    public TransitParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RequestParams) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.policy)) {
            buildParameters.put("policy", this.policy);
        }
        long j3 = this.departureTime;
        if (j3 > 0) {
            buildParameters.put("departure_time", j3);
        }
        return buildParameters;
    }

    public TransitParam departureTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TransitParam) iPatchRedirector.redirect((short) 5, (Object) this, j3);
        }
        this.departureTime = j3;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<TransitResultObject> getResultClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return TransitResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return UrlConstant.ROUTE_PLANNING_TRANSIT;
    }

    public TransitParam policy(RoutePlanningParam.TransitPolicy transitPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TransitParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) transitPolicy);
        }
        StringBuilder sb5 = new StringBuilder();
        if (transitPolicy != null) {
            sb5.append(transitPolicy.name());
        }
        this.policy = sb5.toString();
        return this;
    }

    public TransitParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, (Object) latLng2);
    }

    public TransitParam policy(Policy policy, Preference... preferenceArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TransitParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) policy, (Object) preferenceArr);
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
}
