package com.tencent.comic.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BoodoHippyConfig implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int HIPPY_STATUS_CLOSE = 0;
    public static final int HIPPY_STATUS_OPEN = 1;
    public final List<String> mAllModules;
    public int mHippyStatus;
    public String mMainModuleName;
    public final List<String> mPreloadModules;
    public String mPsKeyHost;

    public BoodoHippyConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mHippyStatus = 1;
        this.mPreloadModules = new ArrayList();
        this.mAllModules = new ArrayList();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "BoodoHippyConfig{mHippyStatus=" + this.mHippyStatus + ", mMainModuleName='" + this.mMainModuleName + "', mPreloadModules=" + this.mPreloadModules + ", mAllModules=" + this.mAllModules + ", mPsKeyHost=" + this.mPsKeyHost + '}';
    }
}
