package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationChannel;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteResultCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class PluginInterface {
    static IPatchRedirector $redirector_;
    PluginCommunicationChannel mClient;

    public PluginInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mClient = null;
        }
    }

    public String getNickName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            if (!isValid()) {
                PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                return null;
            }
            return this.mClient.getNickName();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
            return null;
        }
    }

    public String getSKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            if (!isValid()) {
                PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                return null;
            }
            return this.mClient.getSKey();
        } catch (RemoteException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
            return null;
        }
    }

    public String getSid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        try {
            if (!isValid()) {
                PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                return null;
            }
            return this.mClient.getSid();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
            return null;
        }
    }

    public long getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        try {
            if (!isValid()) {
                PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                return 0L;
            }
            return this.mClient.getUin();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
            return 0L;
        }
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        PluginCommunicationChannel pluginCommunicationChannel = this.mClient;
        if (pluginCommunicationChannel != null) {
            IBinder asBinder = pluginCommunicationChannel.asBinder();
            if (asBinder.isBinderAlive() && asBinder.pingBinder()) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBinder(IBinder iBinder) {
        PluginCommunicationChannel pluginCommunicationChannel;
        if (iBinder != null && iBinder.isBinderAlive() && iBinder.pingBinder()) {
            pluginCommunicationChannel = PluginCommunicationChannel.Stub.asInterface(iBinder);
        } else {
            pluginCommunicationChannel = null;
        }
        this.mClient = pluginCommunicationChannel;
        try {
            iBinder.linkToDeath(new IBinder.DeathRecipient(iBinder) { // from class: com.tencent.mobileqq.pluginsdk.PluginInterface.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IBinder val$binder;

                {
                    this.val$binder = iBinder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) PluginInterface.this, (Object) iBinder);
                    }
                }

                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                        this.val$binder.unlinkToDeath(this, 0);
                    }
                }
            }, 0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
        }
    }

    public Bundle transfer(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bundle) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) bundle);
        }
        try {
            if (!isValid()) {
                PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                return null;
            }
            if (bundle != null) {
                bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            }
            return this.mClient.transfer(str, bundle);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
            return null;
        }
    }

    public void transferAsync(String str, Bundle bundle, RemoteResultCallback remoteResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, bundle, remoteResultCallback);
            return;
        }
        try {
            if (!isValid()) {
                PluginInterfaceHelper.getPluginInterface(MobileQQ.sMobileQQ, null);
                return;
            }
            if (bundle != null) {
                bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
            }
            this.mClient.transferAsync(str, bundle, remoteResultCallback);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("plugin_tag", 2, e16, new Object[0]);
            }
        }
    }
}
