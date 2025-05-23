package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mobileqq.pluginsdk.RemotePluginManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes16.dex */
public class PluginManagerHelper {
    static IPatchRedirector $redirector_;
    private static RemotePluginManager.Stub mStub;
    private static PluginManagerClient sClient;
    private static List<WeakReference<OnPluginManagerLoadedListener>> sListener;
    private static ServiceConnection sSc;

    /* loaded from: classes16.dex */
    public interface OnPluginManagerLoadedListener {
        void onPluginManagerLoaded(PluginManagerClient pluginManagerClient);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sListener = Collections.synchronizedList(new ArrayList());
        mStub = new RemotePluginManager.Stub() { // from class: com.tencent.mobileqq.pluginsdk.PluginManagerHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public void cancelInstall(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public void installPlugin(String str, OnPluginInstallListener onPluginInstallListener) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) onPluginInstallListener);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public boolean isPlugininstalled(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
                }
                return false;
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public boolean isReady() throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                }
                return false;
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public PluginBaseInfo queryPlugin(String str) throws RemoteException {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (PluginBaseInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                }
                return null;
            }

            @Override // com.tencent.mobileqq.pluginsdk.RemotePluginManager
            public void setListener(RemotePluginManager remotePluginManager) throws RemoteException {
                OnPluginManagerLoadedListener onPluginManagerLoadedListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this, (Object) remotePluginManager);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "PluginManageHelper setListener");
                }
                if (remotePluginManager != null) {
                    Iterator it = new ArrayList(PluginManagerHelper.sListener).iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference != null && (onPluginManagerLoadedListener = (OnPluginManagerLoadedListener) weakReference.get()) != null) {
                            onPluginManagerLoadedListener.onPluginManagerLoaded(PluginManagerHelper.sClient);
                        }
                    }
                }
                PluginManagerHelper.clear();
            }
        };
        sSc = new ServiceConnection() { // from class: com.tencent.mobileqq.pluginsdk.PluginManagerHelper.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                OnPluginManagerLoadedListener onPluginManagerLoadedListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "onServiceConnected " + PluginManagerHelper.sListener.size());
                }
                if (iBinder != null && iBinder.isBinderAlive() && iBinder.pingBinder()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "binder alive");
                    }
                    PluginManagerClient unused = PluginManagerHelper.sClient = new PluginManagerClient(RemotePluginManager.Stub.asInterface(iBinder));
                    PluginManagerHelper.sClient.setListener(PluginManagerHelper.mStub);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "binder not alive");
                }
                Iterator it = new ArrayList(PluginManagerHelper.sListener).iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && (onPluginManagerLoadedListener = (OnPluginManagerLoadedListener) weakReference.get()) != null) {
                        onPluginManagerLoadedListener.onPluginManagerLoaded(null);
                    }
                }
                PluginManagerHelper.clear();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                OnPluginManagerLoadedListener onPluginManagerLoadedListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                    return;
                }
                QLog.i("plugin_tag", 1, "onServiceDisconnected" + componentName);
                Iterator it = new ArrayList(PluginManagerHelper.sListener).iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference != null && (onPluginManagerLoadedListener = (OnPluginManagerLoadedListener) weakReference.get()) != null) {
                        onPluginManagerLoadedListener.onPluginManagerLoaded(null);
                    }
                }
                PluginManagerHelper.clear();
                if (PluginManagerHelper.sClient != null) {
                    PluginManagerHelper.sClient.destory();
                    PluginManagerClient unused = PluginManagerHelper.sClient = null;
                }
            }
        };
    }

    public PluginManagerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clear() {
        sListener.clear();
    }

    public static void destory(Context context) {
        PluginRemoteProcessor.get().cancel(sSc);
    }

    public static void getPluginInterface(Context context, OnPluginManagerLoadedListener onPluginManagerLoadedListener) {
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginManagerHelper.getPluginInterface");
        }
        PluginManagerClient pluginManagerClient = sClient;
        if (pluginManagerClient != null && pluginManagerClient.useful()) {
            onPluginManagerLoadedListener.onPluginManagerLoaded(sClient);
        } else {
            sListener.add(new WeakReference<>(onPluginManagerLoadedListener));
            PluginRemoteProcessor.get().process(context, sSc, 1);
        }
    }

    public static PluginManagerClient getPluginInterface(Context context) {
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(QIPCServerModulePlugin.MODULE_NAME, QIPCServerModulePlugin.ACTION_GET_MANAGE_CLIENT, null);
        if (callServer.isSuccess()) {
            return new PluginManagerClient(RemotePluginManager.Stub.asInterface(((BinderParcelable) callServer.data.getParcelable(QIPCServerModulePlugin.RESULT_CLIENT_BINDER)).mBinder));
        }
        return new PluginManagerClient(null);
    }
}
