package com.tencent.mobileqq.app.automator.step;

import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ActiveAccount extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public ActiveAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            QLog.e("IAutomator", 1, "initFaceSettingCache error, app is null");
            return;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("avatar_broadcast_thread_register_switch", false);
        ThreadManager.getSubThreadHandler().post(new Runnable(qQAppInterface, isSwitchOn) { // from class: com.tencent.mobileqq.app.automator.step.ActiveAccount.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f195320d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f195321e;

            {
                this.f195320d = qQAppInterface;
                this.f195321e = isSwitchOn;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ActiveAccount.this, qQAppInterface, Boolean.valueOf(isSwitchOn));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                this.f195320d.initFaceSettingCache();
                if (this.f195321e) {
                    this.f195320d.registerHeadBroadcastReceiver();
                }
            }
        });
        if (!isSwitchOn) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                qQAppInterface.registerHeadBroadcastReceiver();
            } else {
                ThreadManager.getUIHandler().post(new Runnable(qQAppInterface) { // from class: com.tencent.mobileqq.app.automator.step.ActiveAccount.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f195322d;

                    {
                        this.f195322d = qQAppInterface;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActiveAccount.this, (Object) qQAppInterface);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f195322d.registerHeadBroadcastReceiver();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IAutomator", 2, "onInitState: " + ((Automator) this.mAutomator).E.getAccount());
        }
        ((Automator) this.mAutomator).f195305d = System.currentTimeMillis();
        ((Automator) this.mAutomator).C.put("startService", Long.valueOf(SystemClock.uptimeMillis() - com.tencent.mobileqq.startup.a.f289671l));
        T t16 = this.mAutomator;
        ((Automator) t16).f195307f = ((Automator) t16).E.getApp().getSharedPreferences("acc_info" + ((Automator) this.mAutomator).E.getAccount(), 0);
        T t17 = this.mAutomator;
        QQAppInterface qQAppInterface = ((Automator) t17).E;
        try {
            qQAppInterface.addManager(true, ((Automator) t17).f195307f.getLong("PREF_PLUGIN_DELAY_TIME", -1L));
            z16 = false;
        } catch (Throwable unused) {
            qQAppInterface.addManager(true);
            try {
                ((Automator) this.mAutomator).f195307f.edit().putLong("PREF_PLUGIN_DELAY_TIME", 0L).apply();
            } catch (Throwable unused2) {
            }
            z16 = true;
        }
        b(qQAppInterface);
        ((IUniformDownloadMgr) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).onActiveAccount();
        ey3.a.f().j();
        OpenApiManager.getInstance().onRuntimeActive(qQAppInterface);
        if (com.tencent.mobileqq.troop.troopnotification.utils.h.c(qQAppInterface.getCurrentAccountUin())) {
            if (QLog.isColorLevel()) {
                QLog.d("IAutomator", 2, "addSystemMsgSeq:0");
            }
            qQAppInterface.getMsgCache().O("last_group_seq", 0L);
            qQAppInterface.getMsgCache().O("last_group_suspicious_seq", 0L);
            com.tencent.mobileqq.troop.troopnotification.utils.h.e(qQAppInterface.getCurrentAccountUin(), false);
            qQAppInterface.getMsgCache().O("last_friend_seq_47", 0L);
        }
        if (com.tencent.biz.anonymous.a.f78361j != null) {
            com.tencent.biz.anonymous.a.h().c();
        }
        String str = BusinessHandlerFactory.WEREWOLVES_HANDLER;
        if (qQAppInterface.getBusinessHandler(str) instanceof WerewolvesHandler) {
            ((WerewolvesHandler) qQAppInterface.getBusinessHandler(str)).clear();
        }
        String str2 = AppConstants.SDCARD_PATH;
        File file = new File(str2);
        if (!FileUtils.fileExists(str2)) {
            file.mkdirs();
        }
        CleanCache.t(str2);
        QLog.d("IAutomator", 2, "pluginManageDelayTime=", Long.valueOf(((Automator) this.mAutomator).f195307f.getLong("PREF_PLUGIN_DELAY_TIME", -1L)), " hasCrashInAddManager=", Boolean.valueOf(z16));
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}
