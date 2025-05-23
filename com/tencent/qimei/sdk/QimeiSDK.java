package com.tencent.qimei.sdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ai.e;
import com.tencent.qimei.u.a;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QimeiSDK {
    static IPatchRedirector $redirector_ = null;
    public static final int CMD_CAMERA_ONCE = 202;
    public static final int CMD_CAMERA_START = 200;
    public static final int CMD_CAMERA_STOP = 201;
    public static final String TAG = "QmSDK";

    public QimeiSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static IQimeiSDK getInstance(String str) {
        e eVar;
        synchronized (e.class) {
            Map<String, e> map = e.f343020j;
            eVar = map.get(str);
            if (eVar == null) {
                eVar = new e(str);
                map.put(str, eVar);
                a.b(str);
            }
        }
        return eVar;
    }

    public static void setMainAppKey(String str) {
        a.b(str);
    }

    public static void setSoFullPath(String str) {
        a.c(str);
    }
}
