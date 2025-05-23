package com.tencent.mobileqq.auto.engine.main;

import android.text.TextUtils;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static b a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ASPluginBean k3 = com.tencent.mobileqq.auto.engine.loader.a.e(str).k();
        str.hashCode();
        if (!str.equals(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            return new b();
        }
        return b(k3);
    }

    private static b b(ASPluginBean aSPluginBean) {
        return new v91.a();
    }
}
