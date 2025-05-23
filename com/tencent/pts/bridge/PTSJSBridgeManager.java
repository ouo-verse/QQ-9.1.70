package com.tencent.pts.bridge;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;

/* loaded from: classes22.dex */
public class PTSJSBridgeManager {
    static IPatchRedirector $redirector_;
    private static PTSJSBridgeManager sInstance;
    public final String TAG;
    private HashMap<Activity, PTSJSBridge> mJsBridgeMap;

    public PTSJSBridgeManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "PTSJSBridgeManager";
            this.mJsBridgeMap = new HashMap<>();
        }
    }

    public static PTSJSBridgeManager getInstance() {
        if (sInstance == null) {
            synchronized (PTSJSBridgeManager.class) {
                if (sInstance == null) {
                    sInstance = new PTSJSBridgeManager();
                }
            }
        }
        return sInstance;
    }

    public void destroyJSBridge(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        PTSJSBridge pTSJSBridge = this.mJsBridgeMap.get(activity);
        if (pTSJSBridge != null) {
            PTSLog.i("PTSJSBridgeManager", "[destroyJSBridge], destroyJSEnvironment.");
            pTSJSBridge.destroyJsEnvironment();
            this.mJsBridgeMap.remove(activity);
        }
    }

    public PTSJSBridge getJSBridge(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PTSJSBridge) iPatchRedirector.redirect((short) 2, this, activity, str, str2);
        }
        PTSJSBridge pTSJSBridge = this.mJsBridgeMap.get(activity);
        if (pTSJSBridge == null) {
            PTSJSBridge pTSJSBridge2 = new PTSJSBridge(str, str2);
            this.mJsBridgeMap.put(activity, pTSJSBridge2);
            return pTSJSBridge2;
        }
        return pTSJSBridge;
    }
}
