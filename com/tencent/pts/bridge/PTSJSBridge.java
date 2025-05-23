package com.tencent.pts.bridge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.pts.utils.PTSLog;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes22.dex */
public class PTSJSBridge {
    static IPatchRedirector $redirector_ = null;
    public static final String ANIMATION_JS_FILE_NAME = "Animation.js";
    public static final String BIND_DATA_JS_FILE_NAME = "BindData.js";
    private static final AtomicInteger NEXT_ID;
    private final String TAG;
    private volatile boolean hasInitBasicJSBundle;
    private int jsEnvId;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            NEXT_ID = new AtomicInteger(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PTSJSBridge(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.TAG = "PTSJSBridge";
        this.hasInitBasicJSBundle = false;
        this.jsEnvId = NEXT_ID.getAndIncrement();
        createJsEnvironment();
        initBasicJSBundle(str, str2);
    }

    private void createJsEnvironment() {
        PTSJsJniHandler.createJSEnvironment(getJsEnvID());
    }

    private void initBasicJSBundle(String str, String str2) {
        if (this.hasInitBasicJSBundle) {
            return;
        }
        PTSJsJniHandler.evaluateJavaScript(getJsEnvID(), str);
        PTSJsJniHandler.evaluateJavaScript(getJsEnvID(), str2);
        this.hasInitBasicJSBundle = true;
    }

    public void callJSEventFunction(String str, int i3, String str2, String str3, String[] strArr, String[] strArr2, float[] fArr, float[] fArr2, PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, str3, strArr, strArr2, fArr, fArr2, pTSAppInstance);
        } else {
            PTSJsJniHandler.callJSEventFunction(pTSAppInstance, str, i3, str2, str3, strArr, strArr2, fArr, fArr2, getJsEnvID());
        }
    }

    public void callJSFunction(String str, Object[] objArr, PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, objArr, pTSAppInstance);
        } else {
            PTSJsJniHandler.callJSFunction(pTSAppInstance, str, objArr, getJsEnvID());
        }
    }

    public void callOnLoadJsFunction(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSAppInstance);
        } else if (!this.hasInitBasicJSBundle) {
            PTSLog.e("PTSJSBridge", "[callOnLoadJsFunction] error, has not init basic js bundle.");
        } else {
            PTSJsJniHandler.callJSFunction(pTSAppInstance, "onLoad", (Object[]) null, getJsEnvID());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyJsEnvironment() {
        PTSJsJniHandler.destroyJSEnvironment(getJsEnvID());
    }

    public int getJsEnvID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.jsEnvId;
    }

    public void initAppJSBundle(String str, String str2, PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, pTSAppInstance);
        } else if (!this.hasInitBasicJSBundle) {
            PTSLog.e("PTSJSBridge", "[initAppJSBundle] error, has not init basic js bundle.");
        } else {
            PTSJsJniHandler.create(pTSAppInstance, str, str2, getJsEnvID());
            PTSJsJniHandler.callJSFunction(pTSAppInstance, "onLoad", (Object[]) null, getJsEnvID());
        }
    }
}
