package com.tencent.mobileqq.qrscan.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.qrscan.o;
import com.tencent.mobileqq.qrscan.q;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRDataApiImpl implements IQRDataApi {
    static IPatchRedirector $redirector_;

    public QRDataApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRDataApi
    public void requestUrlDecode(AppRuntime appRuntime, String str, JSONObject jSONObject, Bundle bundle, o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, jSONObject, bundle, oVar);
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), q.class);
        newIntent.putExtra("d", str);
        newIntent.putExtra("cmd", "QRCodeSvc.decode");
        newIntent.putExtra(IQRDataApi.PARAM_BQQ, "1");
        if (jSONObject != null) {
            String[] strArr = {"md5", "fromuin", "touin", "ip", "url", "guid", "uuid", "type"};
            for (int i3 = 0; i3 < 8; i3++) {
                String str2 = strArr[i3];
                if (jSONObject.has(str2)) {
                    newIntent.putExtra(str2, jSONObject.optString(str2));
                }
            }
        }
        if (bundle != null) {
            newIntent.putExtra("extra", bundle);
        }
        newIntent.setObserver(oVar);
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRDataApi
    public void requestUrlEncode(AppRuntime appRuntime, String str, Bundle bundle, o oVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, str, bundle, oVar);
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), q.class);
        newIntent.putExtra("d", str);
        newIntent.putExtra("cmd", "QRCodeSvc.encode");
        if (bundle != null) {
            newIntent.putExtra("extra", bundle);
        }
        newIntent.setObserver(oVar);
        appRuntime.startServlet(newIntent);
    }
}
