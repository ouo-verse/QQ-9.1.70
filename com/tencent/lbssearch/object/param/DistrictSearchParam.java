package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class DistrictSearchParam extends DistrictParam {
    static IPatchRedirector $redirector_ = null;
    private static final String KEYWORD = "keyword";
    private String keyword;

    public DistrictSearchParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RequestParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.keyword)) {
            buildParameters.add(KEYWORD, this.keyword);
        }
        return buildParameters;
    }

    @Override // com.tencent.lbssearch.object.param.DistrictParam, com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.keyword)) {
            return false;
        }
        return true;
    }

    public DistrictSearchParam keyword(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DistrictSearchParam) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        this.keyword = str;
        return this;
    }

    public DistrictSearchParam(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.keyword = str;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }
}
