package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.result.WalkingResultObject;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class WalkingParam extends RoutePlanningParam {
    static IPatchRedirector $redirector_;

    public WalkingParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<WalkingResultObject> getResultClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return WalkingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return UrlConstant.ROUTE_PLANNING_WALKING;
    }

    public WalkingParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng, (Object) latLng2);
    }
}
