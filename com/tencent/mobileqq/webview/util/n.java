package com.tencent.mobileqq.webview.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class n {
    static IPatchRedirector $redirector_;

    public static void a(String str, Object... objArr) {
        Class<?> cls;
        StringBuilder sb5 = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            sb5.append(cls);
            sb5.append(",");
        }
        if (QLog.isColorLevel()) {
            QLog.i("InjectUtil", 2, String.format("[%s] initQAutoInject result:%s", str, sb5));
        }
    }
}
