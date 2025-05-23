package com.tencent.lbssearch.object.param;

import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class DistrictChildrenParam extends DistrictParam {
    static IPatchRedirector $redirector_ = null;
    private static final String ID = "id";

    /* renamed from: id, reason: collision with root package name */
    private int f118542id;

    public DistrictChildrenParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RequestParams) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RequestParams buildParameters = super.buildParameters();
        int i3 = this.f118542id;
        if (i3 > 0) {
            buildParameters.add("id", String.valueOf(i3));
        }
        return buildParameters;
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }

    public DistrictChildrenParam id(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DistrictChildrenParam) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        this.f118542id = i3;
        return this;
    }
}
