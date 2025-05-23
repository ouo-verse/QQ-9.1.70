package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class IPluginAdapterProxy {
    static IPatchRedirector $redirector_;
    static IPluginAdapterProxy sProxy;
    public String currentUin;
    private IPluginAdapter mPluginAdapter;

    IPluginAdapterProxy(IPluginAdapter iPluginAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iPluginAdapter);
        } else {
            this.mPluginAdapter = iPluginAdapter;
        }
    }

    public static IPluginAdapterProxy getProxy() {
        return sProxy;
    }

    public static void setProxy(IPluginAdapter iPluginAdapter) {
        sProxy = new IPluginAdapterProxy(iPluginAdapter);
    }

    public Looper getSubThreadLooper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Looper) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        IPluginAdapter iPluginAdapter = this.mPluginAdapter;
        if (iPluginAdapter == null) {
            QLog.d("plugin_tag", 1, "IPluginAdapter null");
            return null;
        }
        return (Looper) iPluginAdapter.invoke(2, null);
    }

    public void initSkin(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        } else {
            this.mPluginAdapter.initSkin(context);
        }
    }

    public void initSkinEngine(Context context) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        } else {
            this.mPluginAdapter.initSkinEngine(context);
        }
    }

    public boolean isBuiltinPluginAndUpToDay(String str, PluginBaseInfo pluginBaseInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) pluginBaseInfo)).booleanValue();
        }
        return this.mPluginAdapter.isBuiltinPluginAndUpToDay(str, pluginBaseInfo);
    }

    public boolean isDefaultMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        IPluginAdapter iPluginAdapter = this.mPluginAdapter;
        if (iPluginAdapter == null) {
            QLog.d("plugin_tag", 1, "IPluginAdapter null");
            return false;
        }
        boolean booleanValue = ((Boolean) iPluginAdapter.invoke(3, null)).booleanValue();
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 1, "isDefaultMode = " + booleanValue);
        }
        return booleanValue;
    }

    public boolean isNightMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        IPluginAdapter iPluginAdapter = this.mPluginAdapter;
        if (iPluginAdapter == null) {
            QLog.d("plugin_tag", 1, "IPluginAdapter null");
            return false;
        }
        return ((Boolean) iPluginAdapter.invoke(1, null)).booleanValue();
    }

    public int isSupportImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        try {
            IPluginAdapter iPluginAdapter = this.mPluginAdapter;
            if (iPluginAdapter == null) {
                QLog.d("plugin_tag", 1, "IPluginAdapter null");
                return -1;
            }
            return ((Integer) iPluginAdapter.invoke(5, null)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public boolean isSupportMultiDex(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        IPluginAdapter iPluginAdapter = this.mPluginAdapter;
        if (iPluginAdapter == null) {
            QLog.d("plugin_tag", 1, "IPluginAdapter null");
            return false;
        }
        return ((Boolean) iPluginAdapter.invoke(4, str)).booleanValue();
    }
}
