package com.tencent.mobileqq.qipc;

import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import eipc.EIPCThreadEngine;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class QIPCClientHelper {
    static IPatchRedirector $redirector_ = null;
    public static final int QIPC_CLIENT_ID = 1;
    public static final String TAG = "QIPCClientHelper";
    static volatile EIPCClient sClient;
    static QIPCClientHelper sInstance;
    public static EIPCThreadEngine sThreadEngine;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41975);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sClient = null;
        }
    }

    QIPCClientHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            QLog.i(TAG, 1, "QIPCClientHelper()");
        }
    }

    public static synchronized QIPCClientHelper getInstance() {
        QIPCClientHelper qIPCClientHelper;
        synchronized (QIPCClientHelper.class) {
            if (sInstance == null) {
                sInstance = new QIPCClientHelper();
            }
            qIPCClientHelper = sInstance;
        }
        return qIPCClientHelper;
    }

    public static void setupThreadEngine(EIPCThreadEngine eIPCThreadEngine) {
        sThreadEngine = eIPCThreadEngine;
    }

    public void callServer(String str, String str2, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            getClient().callServer(str, str2, bundle, eIPCResultCallback);
        } else {
            iPatchRedirector.redirect((short) 2, this, str, str2, bundle, eIPCResultCallback);
        }
    }

    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "disconnect, " + sClient);
        }
        if (sClient != null) {
            sClient.disConnect();
            sClient = null;
        }
    }

    public EIPCClient getClient() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EIPCClient) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (sClient == null) {
            synchronized (QIPCServerHelper.class) {
                if (sClient == null) {
                    sClient = new EIPCClient(MobileQQ.sMobileQQ, 1);
                    sClient.registerModule(new QIPCClientModuleCore());
                }
            }
        }
        return sClient;
    }

    public void register(QIPCModule qIPCModule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qIPCModule);
        } else {
            getClient().registerModule(qIPCModule);
        }
    }

    public EIPCResult callServer(String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? BinderMethodProxy.callServer(getClient(), str, str2, bundle) : (EIPCResult) iPatchRedirector.redirect((short) 3, this, str, str2, bundle);
    }
}
