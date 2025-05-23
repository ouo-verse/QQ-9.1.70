package com.tencent.mobileqq.app;

import android.app.Notification;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AppStatusCallbackSingleton {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "qqBaseActivity.AppStatusCallbackSingleton";
    private static IAppStatusCallback sAppStatusCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static AppStatusCallbackSingleton sInstance;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39098);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                sInstance = new AppStatusCallbackSingleton();
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface IAppStatusCallback {
        String getKeyOfLeftViewText();

        String getKeyOfSelfSetLeftViewText();

        boolean isDebugVersion();

        boolean isTalkBackOn();

        Notification makeFakeNotificationForProcessKeepAlive(boolean z16);
    }

    AppStatusCallbackSingleton() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            initCallback();
        }
    }

    public static AppStatusCallbackSingleton getInstance() {
        return Holder.sInstance;
    }

    private void initCallback() {
        ArrayList<IAppStatusCallback> arrayList = QBaseActivityInjectUtil.sInjectAppStatusCallbackList;
        if (arrayList != null && arrayList.size() > 0) {
            QLog.i(TAG, 1, "initInjectVariable \u4e4b\u540e\uff0csInjectAppStatusCallbackList: " + QBaseActivityInjectUtil.sInjectAppStatusCallbackList.get(0).toString());
            sAppStatusCallback = QBaseActivityInjectUtil.sInjectAppStatusCallbackList.get(0);
        }
    }

    public IAppStatusCallback getCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IAppStatusCallback) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return sAppStatusCallback;
    }
}
