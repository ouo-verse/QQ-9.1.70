package com.tencent.mobileqq.pluginsdk;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

/* loaded from: classes16.dex */
public class QIPCServerModulePlugin extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_GET_MANAGE_CLIENT = "qipc_action_manager_client";
    public static final String MODULE_NAME = "qipc_plugin_module";
    public static final String RESULT_CLIENT_BINDER = "plugin_client_binder";
    private static volatile QIPCServerModulePlugin sPluginServer;

    public QIPCServerModulePlugin() {
        super(MODULE_NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QIPCServerModulePlugin getInstance() {
        if (sPluginServer == null) {
            synchronized (QIPCServerModulePlugin.class) {
                if (sPluginServer == null) {
                    sPluginServer = new QIPCServerModulePlugin();
                }
            }
        }
        return sPluginServer;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, str, bundle, Integer.valueOf(i3));
        }
        if (ACTION_GET_MANAGE_CLIENT.equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(RESULT_CLIENT_BINDER, new BinderParcelable(PluginManageHandler.getInstance().getBinder()));
            return EIPCResult.createSuccessResult(bundle2);
        }
        return null;
    }
}
