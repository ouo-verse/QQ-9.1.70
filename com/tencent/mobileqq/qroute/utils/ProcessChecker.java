package com.tencent.mobileqq.qroute.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.lang.annotation.Annotation;
import mqq.app.api.ProcessConstant;

/* loaded from: classes17.dex */
public class ProcessChecker {
    static IPatchRedirector $redirector_;

    public ProcessChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean check(Class<?> cls, String str, boolean z16) {
        if (!z16) {
            return true;
        }
        String[] strArr = null;
        if (cls.isAnnotationPresent(QAPI.class)) {
            Annotation annotation = cls.getAnnotation(QAPI.class);
            if (annotation instanceof QAPI) {
                strArr = ((QAPI) annotation).process();
            }
        } else if (cls.isAnnotationPresent(Service.class)) {
            Annotation annotation2 = cls.getAnnotation(Service.class);
            if (annotation2 instanceof Service) {
                strArr = ((Service) annotation2).process();
            }
        }
        if (strArr != null) {
            for (String str2 : strArr) {
                if (ProcessConstant.MULTI.equals(str2)) {
                    break;
                }
                if ("all".equals(str2)) {
                    return true;
                }
                if ("".equals(str2) && TextUtils.isEmpty(str)) {
                    return true;
                }
                if (!TextUtils.isEmpty(str) && str.equals(str2)) {
                    return true;
                }
            }
        } else if (!z16 && TextUtils.isEmpty(str)) {
            return true;
        }
        return false;
    }
}
