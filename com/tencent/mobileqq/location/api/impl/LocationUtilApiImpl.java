package com.tencent.mobileqq.location.api.impl;

import com.tencent.mobileqq.location.api.ILocationUtilApi;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.MapUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationUtilApiImpl implements ILocationUtilApi {
    static IPatchRedirector $redirector_;

    public LocationUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.location.api.ILocationUtilApi
    public LatLng getCenterLatLng(Collection<com.tencent.mobileqq.location.data.a> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LatLng) iPatchRedirector.redirect((short) 5, (Object) this, (Object) collection);
        }
        return MapUtils.c(collection);
    }

    @Override // com.tencent.mobileqq.location.api.ILocationUtilApi
    public String getClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return LocationHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.location.api.ILocationUtilApi
    public double getDistance(LatLng latLng, LatLng latLng2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) this, (Object) latLng, (Object) latLng2)).doubleValue();
        }
        return MapUtils.f(latLng, latLng2);
    }

    @Override // com.tencent.mobileqq.location.api.ILocationUtilApi
    public String getDurationText(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
        }
        return MapUtils.g(d16);
    }
}
