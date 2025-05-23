package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes7.dex */
public class SearchIDParam implements ParamObject {
    static IPatchRedirector $redirector_;
    private String searchIds;

    public SearchIDParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String buildIds(String... strArr) {
        String str = "";
        if (strArr != null) {
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (i3 == 0) {
                    str = str + strArr[i3];
                } else {
                    str = str + "," + strArr[i3];
                }
            }
        }
        return str;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RequestParams) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        RequestParams requestParams = new RequestParams();
        requestParams.add("id", this.searchIds);
        return requestParams;
    }

    @Override // com.tencent.lbssearch.object.param.ParamObject
    public boolean checkParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (TextUtils.isEmpty(this.searchIds)) {
            return false;
        }
        return true;
    }

    public SearchIDParam searchIds(String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SearchIDParam) iPatchRedirector.redirect((short) 2, (Object) this, (Object) strArr);
        }
        this.searchIds = buildIds(strArr);
        return this;
    }
}
