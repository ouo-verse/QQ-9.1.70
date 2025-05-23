package com.tencent.mobileqq.avatar.api.impl;

import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastTempApi;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarBroadcastTempApiImpl implements IQQAvatarBroadcastTempApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQAvatarBroadcastTempApiImpl";

    public QQAvatarBroadcastTempApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private QQAppInterface getApp() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastTempApi
    public boolean isBroadcastRegister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (getApp() == null) {
            QLog.e(TAG, 1, "get isBroadcastRegister error, app is null");
            return false;
        }
        return getApp().isQQHeadBroadcastRegister();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastTempApi
    public List<String> queryAvatarByUin(List<String> list) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        QQAppInterface app = getApp();
        if (app == null) {
            QLog.e(TAG, 1, "QQAppInterface is null");
            return null;
        }
        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) app.getRuntimeService(IQQAvatarDataService.class, "");
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            File file = new File(iQQAvatarDataService.getCustomFaceFilePath(1, str, 0));
            if (file.exists() && file.isFile()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(iQQAvatarDataService.getCustomFaceFilePath(1, str, 0));
            } else {
                arrayList.add("");
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastTempApi
    public void registerBroadcast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQAppInterface app = getApp();
        boolean z16 = true;
        if (app == null) {
            QLog.e(TAG, 1, "registerBroadcast error, app is null");
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("avatar_broadcast_thread_register_switch", false)) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                z16 = false;
            }
            if (z16) {
                ThreadManagerV2.excute(new Runnable(app) { // from class: com.tencent.mobileqq.avatar.api.impl.QQAvatarBroadcastTempApiImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f199930d;

                    {
                        this.f199930d = app;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQAvatarBroadcastTempApiImpl.this, (Object) app);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f199930d.registerHeadBroadcastReceiver();
                        }
                    }
                }, 240, null, false);
                return;
            } else {
                app.registerHeadBroadcastReceiver();
                return;
            }
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            app.registerHeadBroadcastReceiver();
        } else {
            ThreadManager.getUIHandler().post(new Runnable(app) { // from class: com.tencent.mobileqq.avatar.api.impl.QQAvatarBroadcastTempApiImpl.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f199931d;

                {
                    this.f199931d = app;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQAvatarBroadcastTempApiImpl.this, (Object) app);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f199931d.registerHeadBroadcastReceiver();
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastTempApi
    public void resetBroadcastRegisterState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (getApp() == null) {
            QLog.e(TAG, 1, "resetBroadcastRegisterState error, app is null");
        } else {
            getApp().resetQQHeadBroadcastRegisterState();
            QLog.i(TAG, 1, "resetBroadcastRegisterState success");
        }
    }
}
