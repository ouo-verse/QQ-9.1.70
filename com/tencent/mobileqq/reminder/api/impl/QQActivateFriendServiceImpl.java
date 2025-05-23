package com.tencent.mobileqq.reminder.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.reminder.api.IQQActivateFriendService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQActivateFriendServiceImpl implements IQQActivateFriendService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QQActivateFriendServiceImpl";
    private AppRuntime mApp;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQActivateFriendServiceImpl.this);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            if (eIPCResult != null) {
                if (eIPCResult.code == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.d(QQActivateFriendServiceImpl.TAG, 2, "setSwitchValueForQQNotify result:" + z16);
            }
        }
    }

    public QQActivateFriendServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQActivateFriendService
    public boolean getSwitchValue(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, z16)).booleanValue();
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            return ((ActivateFriendsManager) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).t(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSwitchValue app not QQAppInterface");
            return false;
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQActivateFriendService
    public void setSwitchValueForQQNotify(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
            boolean u16 = activateFriendsManager.u(true);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "QQReminderServlet.sendSubscribeReminder prepare open notify switch isOpened: " + u16);
            }
            if (!u16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "QQReminderServlet.sendSubscribeReminder setQQReminderSwitch");
                }
                activateFriendsManager.L(z16, z17);
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(IQQActivateFriendService.KEY_IS_OPEN, z16);
        bundle.putBoolean(IQQActivateFriendService.KEY_IS_REMOTE, z17);
        QIPCClientHelper.getInstance().callServer("QQNotifyIPCModule", IQQActivateFriendService.METHOD_ACTION_QQNOTIFY_SET_SWITCH_VALUE, bundle, new a());
    }

    @Override // com.tencent.mobileqq.reminder.api.IQQActivateFriendService
    public void setSwtichValue(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime instanceof QQAppInterface) {
            ((ActivateFriendsManager) ((QQAppInterface) appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).L(z16, z17);
        }
    }
}
