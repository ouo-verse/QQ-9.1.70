package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes16.dex */
public class PluginInterfaceHelper {
    static IPatchRedirector $redirector_;
    private static PluginInterface sInterface;
    private static WeakReference<OnPluginInterfaceLoadedListener> sListener;
    private static ServiceConnection sSc;

    /* loaded from: classes16.dex */
    public interface OnPluginInterfaceLoadedListener {
        void onPluginInterfaceLoaded(PluginInterface pluginInterface);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sSc = new ServiceConnection() { // from class: com.tencent.mobileqq.pluginsdk.PluginInterfaceHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                private void clear() {
                    if (PluginInterfaceHelper.sListener != null) {
                        PluginInterfaceHelper.sListener.clear();
                        WeakReference unused = PluginInterfaceHelper.sListener = null;
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "onServiceConnected");
                    }
                    if (PluginInterfaceHelper.sListener == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("plugin_tag", 2, "return WeakReference<OnPluginInterfaceReadyListener> is null");
                        }
                        clear();
                        return;
                    }
                    OnPluginInterfaceLoadedListener onPluginInterfaceLoadedListener = (OnPluginInterfaceLoadedListener) PluginInterfaceHelper.sListener.get();
                    if (iBinder != null && iBinder.isBinderAlive() && iBinder.pingBinder()) {
                        if (QLog.isColorLevel()) {
                            QLog.i("plugin_tag", 2, "binder alive");
                        }
                        if (PluginInterfaceHelper.sInterface == null) {
                            PluginInterface unused = PluginInterfaceHelper.sInterface = new PluginInterface();
                        }
                        PluginInterfaceHelper.sInterface.setBinder(iBinder);
                        if (onPluginInterfaceLoadedListener != null) {
                            onPluginInterfaceLoadedListener.onPluginInterfaceLoaded(PluginInterfaceHelper.sInterface);
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("plugin_tag", 2, "binder not alive");
                        }
                        if (onPluginInterfaceLoadedListener != null) {
                            onPluginInterfaceLoadedListener.onPluginInterfaceLoaded(PluginInterfaceHelper.sInterface);
                        }
                    }
                    clear();
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("plugin_tag", 2, "onServiceDisconnected");
                    }
                    PluginInterface pluginInterface = PluginInterfaceHelper.sInterface;
                    if (pluginInterface != null) {
                        pluginInterface.destory();
                    }
                    PluginInterface unused = PluginInterfaceHelper.sInterface = null;
                }
            };
        }
    }

    public PluginInterfaceHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void destory(Context context) {
        PluginRemoteProcessor.get().cancel(sSc);
    }

    public static void getPluginInterface(Context context, OnPluginInterfaceLoadedListener onPluginInterfaceLoadedListener) {
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginInterfaceHelper.getPluginInterface");
        }
        PluginInterface pluginInterface = sInterface;
        if (pluginInterface != null && pluginInterface.isValid()) {
            if (onPluginInterfaceLoadedListener != null) {
                onPluginInterfaceLoadedListener.onPluginInterfaceLoaded(pluginInterface);
            }
        } else {
            sListener = new WeakReference<>(onPluginInterfaceLoadedListener);
            PluginRemoteProcessor.get().process(context, sSc, 0);
        }
    }
}
