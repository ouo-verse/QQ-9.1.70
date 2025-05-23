package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class DistrictParam implements ParamObject {
    static IPatchRedirector $redirector_;
    private int maxOffset;
    private int polygon;

    public DistrictParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.maxOffset = -1;
        }
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RequestParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        requestParams.put("get_polygon", this.polygon);
        int i3 = this.maxOffset;
        if (i3 != -1) {
            requestParams.put("max_offset", i3);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public DistrictParam maxOffset(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DistrictParam) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        this.maxOffset = i3;
        return this;
    }

    public DistrictParam polygon(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DistrictParam) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        this.polygon = i3;
        return this;
    }
}
