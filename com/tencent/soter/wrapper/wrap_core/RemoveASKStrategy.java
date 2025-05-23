package com.tencent.soter.wrapper.wrap_core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.model.SLogger;
import com.tencent.soter.core.model.SoterCoreResult;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RemoveASKStrategy {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_EXCEPTION_COUNT = 2;
    private static final String TAG = "Soter.RemoveASKStrategy";
    private static HashMap<Class, ErrorModel> exceptionMap;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class ErrorModel {
        static IPatchRedirector $redirector_;
        int counter;
        int errCode;
        String errMsg;

        ErrorModel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public void fillResult(SoterCoreResult soterCoreResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) soterCoreResult);
                return;
            }
            this.errCode = soterCoreResult.errCode;
            this.errMsg = soterCoreResult.errMsg;
            this.counter = 1;
        }

        /* synthetic */ ErrorModel(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            exceptionMap = new HashMap<>();
        }
    }

    public RemoveASKStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean shouldRemoveAllKey(Class cls, SoterCoreResult soterCoreResult) {
        if (soterCoreResult.isSuccess()) {
            return false;
        }
        ErrorModel errorModel = exceptionMap.get(cls);
        if (errorModel == null) {
            errorModel = new ErrorModel(null);
            errorModel.fillResult(soterCoreResult);
            exceptionMap.put(cls, errorModel);
        } else if (soterCoreResult.getErrCode() == errorModel.errCode && soterCoreResult.getErrMsg().equals(errorModel.errMsg)) {
            int i3 = errorModel.counter + 1;
            errorModel.counter = i3;
            if (i3 >= 2) {
                return true;
            }
        } else {
            errorModel.fillResult(soterCoreResult);
        }
        SLogger.d(TAG, "error counter: %s", Integer.valueOf(errorModel.counter));
        return false;
    }
}
