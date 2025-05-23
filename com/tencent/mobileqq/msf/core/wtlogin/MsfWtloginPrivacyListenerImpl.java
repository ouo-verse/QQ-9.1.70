package com.tencent.mobileqq.msf.core.wtlogin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.c;
import oicq.wlogin_sdk.listener.PrivacyListener;

/* loaded from: classes15.dex */
public class MsfWtloginPrivacyListenerImpl implements PrivacyListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "MsfWtloginPrivacyListenerImpl";
    private static volatile MsfWtloginPrivacyListenerImpl singleton;
    private String deviceModel;

    MsfWtloginPrivacyListenerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static MsfWtloginPrivacyListenerImpl getSingleton() {
        if (singleton == null) {
            synchronized (MsfWtloginPrivacyListenerImpl.class) {
                if (singleton == null) {
                    singleton = new MsfWtloginPrivacyListenerImpl();
                }
            }
        }
        return singleton;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getAndroidID(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return c.a(context);
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getBssid(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        return null;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getDeviceModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (TextUtils.isEmpty(this.deviceModel)) {
            this.deviceModel = DeviceInfoMonitor.getModel();
        }
        return this.deviceModel;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getImsi(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        return null;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getMac(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        return null;
    }

    @Override // oicq.wlogin_sdk.listener.PrivacyListener
    public String getSsid(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        return null;
    }

    public void resetDeviceModelCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.deviceModel = null;
        }
    }
}
