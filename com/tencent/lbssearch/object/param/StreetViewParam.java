package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes7.dex */
public class StreetViewParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String ID = "id";
    private static final String LOCATION = "location";
    private static final String POI = "poi";
    private static final String RADIUS = "radius";

    /* renamed from: id, reason: collision with root package name */
    private String f118544id;
    private LatLng latLng;
    private String poi;
    private int radius;

    public StreetViewParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RequestParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        if (this.latLng != null) {
            requestParams.add("location", this.latLng.latitude + "," + this.latLng.longitude);
        }
        if (!TextUtils.isEmpty(this.poi)) {
            requestParams.add("poi", this.poi);
        }
        if (!TextUtils.isEmpty(this.f118544id)) {
            requestParams.add("id", this.f118544id);
        }
        int i3 = this.radius;
        if (i3 > 0) {
            requestParams.add(RADIUS, String.valueOf(i3));
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.f118544id) && this.latLng == null && TextUtils.isEmpty(this.poi)) {
            return false;
        }
        return true;
    }

    public StreetViewParam id(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StreetViewParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.f118544id = str;
        return this;
    }

    public StreetViewParam location(LatLng latLng) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (StreetViewParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) latLng);
        }
        this.latLng = latLng;
        return this;
    }

    public StreetViewParam poi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (StreetViewParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.poi = str;
        return this;
    }

    public StreetViewParam radius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (StreetViewParam) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        this.radius = i3;
        return this;
    }
}
