package com.tencent.relation.common.abtest;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static ExpEntityInfo a(String str) {
        return ABTestController.getInstance().getExpEntity(str);
    }

    public static ExpEntityInfo b(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(str);
        expEntity.reportExpExposure();
        return expEntity;
    }

    public static boolean c(String str) {
        ExpEntityInfo b16 = b(str);
        b16.reportExpExposure();
        if (b16.isExperiment()) {
            return true;
        }
        return false;
    }

    public static boolean d(String str, String str2) {
        ExpEntityInfo b16 = b(str);
        if (b16 != null && b16.isExperiment(str2)) {
            return true;
        }
        return false;
    }
}
