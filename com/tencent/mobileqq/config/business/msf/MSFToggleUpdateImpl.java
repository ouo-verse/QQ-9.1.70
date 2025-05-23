package com.tencent.mobileqq.config.business.msf;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class MSFToggleUpdateImpl implements com.tencent.mobileqq.qqfeatureswitch.c {
    /* JADX INFO: Access modifiers changed from: private */
    public String d(AppRuntime appRuntime) {
        try {
            JSONObject jSONObject = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).getJSONObject("Android_MSF_toggle", "");
            QLog.d("MSFToggleUpdateImpl", 1, MobileQQ.processName + " [updateToggleData]:" + jSONObject);
            if (jSONObject == null) {
                return "";
            }
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e("MSFToggleUpdateImpl", 1, MobileQQ.processName + " updateToggleData throw exception,", e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.c
    public void a() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("MSFToggleUpdateImpl", 1, "[onFeatureUpdate], is not main process: " + MobileQQ.sProcessId);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.business.msf.MSFToggleUpdateImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("MSFToggleUpdateImpl", 1, "onFeatureUpdate");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    String d16 = MSFToggleUpdateImpl.this.d(peekAppRuntime);
                    if (!TextUtils.isEmpty(d16)) {
                        MSFToggleUpdateImpl.this.c(peekAppRuntime, d16);
                    }
                }
            }
        }, 16, null, true);
    }

    public void c(AppRuntime appRuntime, String str) {
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), BuiltInServlet.class);
        newIntent.putExtra("action", 2217);
        newIntent.putExtra(BaseConstants.ATTRIBUTE_KEY_MSF_TOGGLE, str);
        newIntent.setWithouLogin(true);
        appRuntime.startServlet(newIntent);
    }
}
