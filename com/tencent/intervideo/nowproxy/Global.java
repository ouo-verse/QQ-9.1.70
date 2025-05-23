package com.tencent.intervideo.nowproxy;

import android.content.Context;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.NowLoginInfo;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class Global {
    static IPatchRedirector $redirector_;
    public static boolean isQueenFreeFlow;
    public static String sAppid;
    protected static Global sGlobal;
    public static InitData sInitData;
    public static LoginData sLoginData;
    public static NowLoginInfo sNowLoginInfo;
    public static IShadow sShadowImpl;
    protected Context mApplicationContext;
    ArrayList<NowPluginObserver> mObservers;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9923);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sGlobal = new Global();
        }
    }

    protected Global() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mObservers = new ArrayList<>();
        }
    }

    public static synchronized void addNowPluginObserver(NowPluginObserver nowPluginObserver) {
        synchronized (Global.class) {
            sGlobal.mObservers.add(nowPluginObserver);
        }
    }

    public static Context getApplicationContext() {
        return sGlobal.mApplicationContext;
    }

    public static synchronized ArrayList<NowPluginObserver> getPluginObservers() {
        ArrayList<NowPluginObserver> arrayList;
        synchronized (Global.class) {
            arrayList = sGlobal.mObservers;
        }
        return arrayList;
    }

    public static synchronized void removeNowPluginObserver(NowPluginObserver nowPluginObserver) {
        synchronized (Global.class) {
            sGlobal.mObservers.remove(nowPluginObserver);
        }
    }

    public static void setApplicationContext(Context context) {
        sGlobal.mApplicationContext = context;
    }
}
