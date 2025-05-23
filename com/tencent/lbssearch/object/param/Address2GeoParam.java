package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class Address2GeoParam implements ParamObject {
    static IPatchRedirector $redirector_ = null;
    private static final String ADDRESS = "address";
    private static final String REGION = "region";
    private String address;
    private String region;

    public Address2GeoParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public Address2GeoParam address(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Address2GeoParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.address = str;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RequestParams) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.address)) {
            requestParams.add("address", this.address);
        }
        if (!TextUtils.isEmpty(this.region)) {
            requestParams.add("region", this.region);
        }
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.address)) {
            return false;
        }
        return true;
    }

    public Address2GeoParam region(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Address2GeoParam) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        this.region = str;
        return this;
    }

    public Address2GeoParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.address = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
