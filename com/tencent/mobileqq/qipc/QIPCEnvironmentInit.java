package com.tencent.mobileqq.qipc;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.c;
import eipc.EIPCModule;
import eipc.EIPCModuleFactory;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class QIPCEnvironmentInit {
    static IPatchRedirector $redirector_;

    public QIPCEnvironmentInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static void initEnvironment() {
        if (QLog.isColorLevel()) {
            QLog.d("QIPCEnvironmentInit", 2, "initEnvironment");
        }
        IPluginAdapterProxy.setProxy(new c());
        try {
            if (TextUtils.equals(MobileQQ.processName, BaseApplicationImpl.sApplication.getApplicationContext().getPackageName())) {
                QIPCServerHelper.getInstance().getServer().setModuleFactory(new EIPCModuleFactory() { // from class: com.tencent.mobileqq.qipc.QIPCEnvironmentInit.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // eipc.EIPCModuleFactory
                    public EIPCModule onCreateModule(String str) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (EIPCModule) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                        }
                        return QIPCServerModuleFactory.onCreateModule(str);
                    }
                });
            } else {
                QIPCClientHelper.getInstance().getClient().guardServerProcList.add(MobileQQ.sMobileQQ.getPackageName());
            }
            if (BaseApplicationImpl.useQIPCStart(MobileQQ.processName)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIPCEnvironmentInit", 2, "connectMainProc");
                }
                QIPCClientHelper.getInstance().getClient().connect(null);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("QIPCEnvironmentInit", 2, "initEnvironment", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QIPCEnvironmentInit", 2, "registerNFCEventCallback");
        }
    }
}
