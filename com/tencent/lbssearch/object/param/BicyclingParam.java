package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.result.BicyclingResultObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class BicyclingParam extends RoutePlanningParam {
    static IPatchRedirector $redirector_;

    public BicyclingParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<?> getResultClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return BicyclingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return UrlConstant.ROUTE_BICYCLING_TRANSIT;
    }

    public BicyclingParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, (Object) latLng2);
    }
}
