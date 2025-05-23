package com.tencent.mobileqq.pluginsdk;

import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PluginManagerClient {
    static IPatchRedirector $redirector_;
    RemotePluginManager mRemote;

    public PluginManagerClient(RemotePluginManager remotePluginManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) remotePluginManager);
        } else {
            this.mRemote = remotePluginManager;
        }
    }

    public void cancelInstall(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            try {
                this.mRemote.cancelInstall(str);
            } catch (RemoteException unused) {
            }
        }
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mRemote = null;
        }
    }

    public void installPlugin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            PluginManageHandler.getPluginIOHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.pluginsdk.PluginManagerClient.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$pluginId;

                {
                    this.val$pluginId = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PluginManagerClient.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            PluginManagerClient.this.mRemote.installPlugin(this.val$pluginId, null);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public boolean isPluginInstalled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        try {
            return this.mRemote.isPlugininstalled(str);
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean isReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        try {
            return this.mRemote.isReady();
        } catch (RemoteException unused) {
            return false;
        }
    }

    public PluginBaseInfo queryPlugin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PluginBaseInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        try {
            return this.mRemote.queryPlugin(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public void setListener(RemotePluginManager.Stub stub) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) stub);
        } else {
            try {
                this.mRemote.setListener(stub);
            } catch (RemoteException unused) {
            }
        }
    }

    public boolean useful() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        RemotePluginManager remotePluginManager = this.mRemote;
        boolean z16 = false;
        if (remotePluginManager != null) {
            try {
                IBinder asBinder = remotePluginManager.asBinder();
                if (asBinder != null && asBinder.isBinderAlive()) {
                    if (asBinder.pingBinder()) {
                        z16 = true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, " useful: " + z16);
        }
        return z16;
    }

    public void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            PluginManageHandler.getPluginIOHandler().post(new Runnable(str, onPluginInstallListener) { // from class: com.tencent.mobileqq.pluginsdk.PluginManagerClient.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ OnPluginInstallListener val$listener;
                final /* synthetic */ String val$pluginId;

                {
                    this.val$pluginId = str;
                    this.val$listener = onPluginInstallListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PluginManagerClient.this, str, onPluginInstallListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            PluginManagerClient.this.mRemote.installPlugin(this.val$pluginId, this.val$listener);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) onPluginInstallListener);
        }
    }
}
