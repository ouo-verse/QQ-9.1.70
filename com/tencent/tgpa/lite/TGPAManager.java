package com.tencent.tgpa.lite;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.a.b;
import com.tencent.tgpa.lite.f.a;
import com.tencent.tgpa.lite.g.h;
import com.tencent.tgpa.lite.gradish.GradishWrapper;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes26.dex */
public class TGPAManager {
    static IPatchRedirector $redirector_;

    public TGPAManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void enableDebugMode() {
        a.a(true);
    }

    public static String getDeviceTypeSync(long j3) {
        try {
            if (!com.tencent.tgpa.lite.d.a.a().await(j3, TimeUnit.MILLISECONDS)) {
                h.b("[syncGetDeviceType]: timeout!", new Object[0]);
                return "0";
            }
            if (!b.a().f375868a.f375881h) {
                h.b("[syncGetDeviceType]: deviceIdentify is not open!", new Object[0]);
                return "0";
            }
            return String.valueOf(b.a().f375870c.f375873a);
        } catch (InterruptedException e16) {
            e16.printStackTrace();
            return "0";
        }
    }

    public static String getOAID() {
        return com.tencent.tgpa.lite.c.a.a();
    }

    public static void init(InitConfig initConfig) {
        if (!InitConfig.checkValid(initConfig)) {
            h.b("initConfig is invalid.", new Object[0]);
            return;
        }
        if (initConfig.isDebug()) {
            enableDebugMode();
        }
        setLogAble(initConfig.isLogAble());
        com.tencent.tgpa.lite.g.a.a(initConfig.getContext());
        a.b(initConfig.getTgpaid());
        a.a(initConfig.getBaseDomain());
        a.a(initConfig.getPrivacyDataCallback());
        new com.tencent.tgpa.lite.d.a(initConfig.getCallback()).start();
    }

    public static void reportUserInfo(HashMap<String, String> hashMap) {
        if (com.tencent.tgpa.lite.g.a.a() == null) {
            h.b("context is null, you should init first!", new Object[0]);
            return;
        }
        if (hashMap != null && hashMap.size() > 0) {
            if (!b.a().f375868a.f375876c) {
                h.b("report func is not open.", new Object[0]);
                return;
            } else {
                com.tencent.tgpa.lite.c.a.a(hashMap);
                return;
            }
        }
        h.b("userdata is null, ple check!", new Object[0]);
    }

    public static void setLogAble(boolean z16) {
        h.a(z16);
    }

    public static boolean tryLoadLibrary(String str) {
        boolean tryLoadLibrary = GradishWrapper.tryLoadLibrary(str);
        if (tryLoadLibrary) {
            return tryLoadLibrary;
        }
        throw new UnsatisfiedLinkError("load tgpa lib by absolute path failed!!!");
    }

    public static void init(String str, Context context) {
        init(str, context, null);
    }

    public static void init(String str, Context context, Callback callback) {
        if (context == null) {
            h.b("context is null.", new Object[0]);
            return;
        }
        com.tencent.tgpa.lite.g.a.a(context);
        a.b(str);
        new com.tencent.tgpa.lite.d.a(callback).start();
    }

    public static void init(String str, Context context, Callback callback, boolean z16, boolean z17) {
        if (z16) {
            enableDebugMode();
        }
        setLogAble(z17);
        init(str, context, callback);
    }

    public static void init(String str, String str2, Context context, Callback callback) {
        a.a(str2);
        init(str, context, callback);
    }
}
