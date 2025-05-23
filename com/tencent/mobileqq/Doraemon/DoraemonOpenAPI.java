package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;

/* loaded from: classes9.dex */
public class DoraemonOpenAPI {
    static IPatchRedirector $redirector_;

    public static DoraemonAPIManager a(@NonNull Activity activity, int i3, String str, Bundle bundle) {
        String string;
        String str2;
        String str3;
        if (QLog.isColorLevel()) {
            QLog.i("DoraemonOpenAPI", 2, "createAPIManager type=" + i3 + ", appid=" + str);
        }
        String str4 = null;
        com.tencent.mobileqq.Doraemon.impl.a aVar = null;
        if (activity == null) {
            QLog.e("DoraemonOpenAPI", 1, "can not create APIManager activity == null");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("DoraemonOpenAPI", 1, "can not create APIManager appid is empty");
        }
        if (i3 != 0) {
            if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
                if (i3 == 6) {
                    aVar = new com.tencent.mobileqq.Doraemon.impl.b(activity, i3, str);
                }
            } else {
                com.tencent.mobileqq.Doraemon.impl.a aVar2 = new com.tencent.mobileqq.Doraemon.impl.a(activity, i3, str);
                if (bundle != null) {
                    str4 = bundle.getString("sdkVersion");
                    str2 = bundle.getString(PushClientConstants.TAG_PKG_NAME);
                    str3 = bundle.getString("signature");
                } else {
                    str2 = null;
                    str3 = null;
                }
                aVar2.C(str4, str2, str3);
                aVar = aVar2;
            }
        } else {
            if (bundle == null) {
                string = null;
            } else {
                string = bundle.getString("urlSummary", "");
            }
            if (TextUtils.isEmpty(string)) {
                QLog.e("DoraemonOpenAPI", 1, "can not create APIManger url is empty");
                return null;
            }
            aVar = new com.tencent.mobileqq.Doraemon.impl.webview.a(activity, i3, str, string);
        }
        if (aVar == null) {
            QLog.e("DoraemonOpenAPI", 1, "can not create APIManager type=" + i3 + ", appid=" + str);
        } else {
            aVar.n();
        }
        return aVar;
    }

    public static void b() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.Doraemon.DoraemonOpenAPI.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DefaultDoraemonAppInfoHelper h16 = DefaultDoraemonAppInfoHelper.h();
                h16.k();
                h16.c();
            }
        }, 5, null, false);
    }
}
