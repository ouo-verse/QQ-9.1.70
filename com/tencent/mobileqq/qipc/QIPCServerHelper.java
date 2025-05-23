package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import eipc.EIPCConnection;
import eipc.EIPCModuleManager;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPCServer;
import java.util.Iterator;

/* loaded from: classes16.dex */
public class QIPCServerHelper {
    static IPatchRedirector $redirector_;
    static volatile QIPCServerHelper sInstance;

    QIPCServerHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public static QIPCServerHelper getInstance() {
        if (sInstance == null) {
            synchronized (QIPCServerHelper.class) {
                if (sInstance == null) {
                    sInstance = new QIPCServerHelper();
                }
            }
        }
        return sInstance;
    }

    public void callClient(String str, String str2, String str3, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            getServer().callClient(str, 1, str2, str3, bundle, eIPCResultCallback);
        } else {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, bundle, eIPCResultCallback);
        }
    }

    public EIPCServer getServer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (EIPCServer) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return EIPCServer.getServer();
    }

    public boolean isModuleRunning(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_id", str);
        Iterator<EIPCConnection> it = getServer().getClientConnectionList().iterator();
        while (it.hasNext()) {
            try {
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            if (it.next().callModule(QIPCClientModuleCore.NAME, QIPCClientModuleCore.ACTION_IS_MODULE_RUNNING, bundle).isSuccess()) {
                return true;
            }
        }
        return false;
    }

    public boolean isProcessRunning(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && !"".equals(str)) {
            Iterator<EIPCConnection> it = getServer().getClientConnectionList().iterator();
            while (it.hasNext()) {
                try {
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (str.equals(it.next().procName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void notifyOnAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            EIPCModuleManager.excuteOnAsyncThread(new Runnable() { // from class: com.tencent.mobileqq.qipc.QIPCServerHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QIPCServerHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    EIPCServer server = QIPCServerHelper.getInstance().getServer();
                    if (server != null) {
                        server.sendMsgToRemoteModule(1, null);
                    }
                }
            });
        }
    }

    public void register(QIPCModule qIPCModule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIPCModule);
        } else {
            getServer().registerModule(qIPCModule);
        }
    }

    public EIPCResult callClient(String str, String str2, String str3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? getServer().callClient(str, 1, str2, str3, bundle) : (EIPCResult) iPatchRedirector.redirect((short) 3, this, str, str2, str3, bundle);
    }
}
