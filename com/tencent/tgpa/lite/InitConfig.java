package com.tencent.tgpa.lite;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tgpa.lite.g.l;

/* compiled from: P */
/* loaded from: classes26.dex */
public class InitConfig {
    static IPatchRedirector $redirector_;
    private String baseDomain;
    private Callback callback;
    private final Context context;
    private boolean isDebug;
    private boolean logAble;
    private PrivacyDataCallback privacyDataCallback;
    private final String tgpaid;

    public InitConfig(String str, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) context);
            return;
        }
        this.logAble = false;
        this.isDebug = false;
        this.callback = null;
        this.privacyDataCallback = null;
        this.context = context;
        this.tgpaid = str;
        this.baseDomain = "https://cloud.tgpa.qq.com";
    }

    public static boolean checkValid(InitConfig initConfig) {
        if (initConfig != null && !l.a(initConfig.tgpaid) && initConfig.context != null) {
            return true;
        }
        return false;
    }

    public String getBaseDomain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.baseDomain;
    }

    public Callback getCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Callback) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.callback;
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Context) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.context;
    }

    public PrivacyDataCallback getPrivacyDataCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (PrivacyDataCallback) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.privacyDataCallback;
    }

    public String getTgpaid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.tgpaid;
    }

    public boolean isDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isDebug;
    }

    public boolean isLogAble() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.logAble;
    }

    public InitConfig setBaseDomain(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InitConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        this.baseDomain = str;
        return this;
    }

    public InitConfig setCallback(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (InitConfig) iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
        }
        this.callback = callback;
        return this;
    }

    public InitConfig setDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InitConfig) iPatchRedirector.redirect((short) 4, (Object) this, z16);
        }
        this.isDebug = z16;
        return this;
    }

    public InitConfig setLogAble(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InitConfig) iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
        this.logAble = z16;
        return this;
    }

    public InitConfig setPrivacyDataCallback(PrivacyDataCallback privacyDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (InitConfig) iPatchRedirector.redirect((short) 6, (Object) this, (Object) privacyDataCallback);
        }
        this.privacyDataCallback = privacyDataCallback;
        return this;
    }
}
