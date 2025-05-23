package com.tencent.mobileqq.pluginsdk;

import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PluginManageHandler {
    static IPatchRedirector $redirector_;
    public static Handler handler;
    private static volatile PluginManageHandler sInstance;
    RemotePluginManager mClientProxy;
    private IPluginManagerProvider mManagerProvider;
    private RemotePluginManager.Stub mPluginManager;
    private PluginManageWrapper mWrapper;

    /* loaded from: classes16.dex */
    public interface IPluginManagerProvider {
        RemotePluginManager.Stub onGetPluginManager();
    }

    /* loaded from: classes16.dex */
    public class PluginManageWrapper extends RemotePluginManager.Stub {
        static IPatchRedirector $redirector_;

        public PluginManageWrapper() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PluginManageHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public void cancelInstall(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            if (PluginManageHandler.this.mPluginManager == null) {
                PluginManageHandler.this.ensureManagerReady();
                if (PluginManageHandler.this.mPluginManager == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
                        return;
                    }
                    return;
                }
            }
            try {
                PluginManageHandler.this.mPluginManager.cancelInstall(str);
            } catch (RemoteException unused) {
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) onPluginInstallListener);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("plugin_tag", 4, "installPlugin " + PluginManageHandler.this.mPluginManager);
            }
            if (PluginManageHandler.this.mPluginManager == null) {
                PluginManageHandler.this.ensureManagerReady();
                if (PluginManageHandler.this.mPluginManager == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
                        return;
                    }
                    return;
                }
            }
            try {
                PluginManageHandler.this.mPluginManager.installPlugin(str, onPluginInstallListener);
                if (QLog.isDevelopLevel()) {
                    QLog.i("plugin_tag", 4, "installPlugin done");
                }
            } catch (RemoteException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("plugin_tag", 4, "installPlugin", e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public boolean isPlugininstalled(String str) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
            }
            if (PluginManageHandler.this.mPluginManager == null) {
                PluginManageHandler.this.ensureManagerReady();
                if (PluginManageHandler.this.mPluginManager == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
                        return false;
                    }
                    return false;
                }
            }
            return PluginManageHandler.this.mPluginManager.isPlugininstalled(str);
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public boolean isReady() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            if (PluginManageHandler.this.mPluginManager == null) {
                PluginManageHandler.this.ensureManagerReady();
                if (PluginManageHandler.this.mPluginManager == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
                    }
                    return false;
                }
            }
            try {
                return PluginManageHandler.this.mPluginManager.isReady();
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public PluginBaseInfo queryPlugin(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PluginBaseInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            if (PluginManageHandler.this.mPluginManager == null) {
                PluginManageHandler.this.ensureManagerReady();
                if (PluginManageHandler.this.mPluginManager == null) {
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "PluginManageWrapper inner null");
                    }
                    return null;
                }
            }
            try {
                return PluginManageHandler.this.mPluginManager.queryPlugin(str);
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
        public void setListener(RemotePluginManager remotePluginManager) throws RemoteException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) remotePluginManager);
                return;
            }
            PluginManageHandler.this.mClientProxy = remotePluginManager;
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "PluginManageHandler setListener");
            }
            if (PluginManageHandler.this.mPluginManager == null) {
                PluginManageHandler.this.ensureManagerReady();
            } else {
                remotePluginManager.setListener(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12986);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            handler = null;
        }
    }

    PluginManageHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureManagerReady() {
        if (this.mPluginManager != null) {
            return;
        }
        getPluginIOHandler().post(new Runnable() { // from class: com.tencent.mobileqq.pluginsdk.PluginManageHandler.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PluginManageHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (PluginManageHandler.this.mPluginManager == null) {
                    synchronized (PluginManageHandler.this) {
                        if (PluginManageHandler.this.mPluginManager == null && PluginManageHandler.this.mManagerProvider != null) {
                            PluginManageHandler pluginManageHandler = PluginManageHandler.this;
                            pluginManageHandler.mPluginManager = pluginManageHandler.mManagerProvider.onGetPluginManager();
                            PluginManageHandler.this.notifyReadyToClient();
                        }
                    }
                }
            }
        });
    }

    public static final PluginManageHandler getInstance() {
        if (sInstance == null) {
            synchronized (PluginManageHandler.class) {
                if (sInstance == null) {
                    sInstance = new PluginManageHandler();
                }
            }
        }
        return sInstance;
    }

    public static synchronized Handler getPluginIOHandler() {
        Handler handler2;
        synchronized (PluginManageHandler.class) {
            if (handler == null) {
                handler = new Handler(IPluginAdapterProxy.getProxy().getSubThreadLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyReadyToClient() {
        RemotePluginManager remotePluginManager = this.mClientProxy;
        if (remotePluginManager != null) {
            try {
                remotePluginManager.setListener(this.mWrapper);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "notifyReadyToClient ", e16);
                }
            }
        }
    }

    public IBinder getBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.mWrapper == null) {
            this.mWrapper = new PluginManageWrapper();
        }
        return this.mWrapper;
    }

    public void setPluginManagerProvider(IPluginManagerProvider iPluginManagerProvider, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, iPluginManagerProvider, Boolean.valueOf(z16));
            return;
        }
        if (this.mManagerProvider != iPluginManagerProvider) {
            this.mWrapper = null;
            this.mPluginManager = null;
            this.mManagerProvider = iPluginManagerProvider;
        }
        if (this.mManagerProvider != null && z16) {
            ensureManagerReady();
        }
    }
}
