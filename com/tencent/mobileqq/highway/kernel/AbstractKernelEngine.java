package com.tencent.mobileqq.highway.kernel;

import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.api.IConfig;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class AbstractKernelEngine extends QIPCModule {
    static IPatchRedirector $redirector_ = null;
    public static final int ERROR_CODE_CANCEL1 = 2006013;
    public static final int ERROR_CODE_CANCEL2 = 2006014;
    public static final int ERROR_CODE_COMMIT_SUC = 0;
    static final int ERROR_CODE_NO_APP_RUNTIME = -2003;
    static final int ERROR_CODE_NO_TRANS = -2001;
    static final int ERROR_CODE_WRONG_ACTION = -2002;
    static final String IPC_ACTION_CANCEL = "IPC_ACTION_CANCEL";
    static final String IPC_ACTION_NOTIFY_FAILED = "IPC_ACTION_NOTIFY_FAILED";
    static final String IPC_ACTION_NOTIFY_PROGRESS = "IPC_ACTION_NOTIFY_PROGRESS";
    static final String IPC_ACTION_NOTIFY_START = "IPC_ACTION_NOTIFY_START";
    static final String IPC_ACTION_NOTIFY_SUCCESS = "IPC_ACTION_NOTIFY_SUCCESS";
    static final String IPC_ACTION_SUBMIT = "IPC_ACTION_SUBMIT";
    static final String IPC_KEY_NOTIFY_ERROR_CODE = "IPC_KEY_NOTIFY_ERROR_CODE";
    static final String IPC_KEY_NOTIFY_PROGRESS = "IPC_KEY_NOTIFY_PROGRESS";
    static final String IPC_KEY_NOTIFY_RESP_DATA = "IPC_KEY_NOTIFY_RESP_DATA";
    static final String IPC_KEY_TRANS_ID = "IPC_KEY_TRANS_ID";
    static final String IPC_MODULE_NAME = "BDHKernelEngine";
    public static final int STATUS_CODE_PROGRESS = 2;
    public static final int STATUS_CODE_START = 1;
    public static final int STATUS_CODE_SUC = 3;
    public static final int STATUS_CODE_UPLOADING = 0;
    public static final String TAG = "BDHKernelEngine";
    protected IInject injectHelper;

    public AbstractKernelEngine(IInject iInject) {
        super("BDHKernelEngine");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iInject);
        } else {
            this.injectHelper = iInject;
        }
    }

    public abstract void cancelTransactionTask(Transaction transaction);

    public IQQNTWrapperSession getWrapperSession() {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IQQNTWrapperSession) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        IInject iInject = this.injectHelper;
        if (iInject != null) {
            appRuntime = iInject.getRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return null;
        }
        return ((IKernelService) appRuntime.getRuntimeService(IKernelService.class, "all")).getWrapperSession();
    }

    public boolean isAllUseKernel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((IConfig) QRoute.api(IConfig.class)).isAllUseKernel();
    }

    public boolean isUseKernel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
        }
        if (isAllUseKernel()) {
            return true;
        }
        return ((IConfig) QRoute.api(IConfig.class)).isUseKernel(i3);
    }

    public abstract void onDestroy();

    public abstract void resumeTransactionTask(Transaction transaction);

    public abstract void stopTransactionTask(Transaction transaction);

    public abstract int submitTransactionTask(Transaction transaction);
}
