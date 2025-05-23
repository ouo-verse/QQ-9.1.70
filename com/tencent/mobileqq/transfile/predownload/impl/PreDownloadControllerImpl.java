package com.tencent.mobileqq.transfile.predownload.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class PreDownloadControllerImpl implements IPreDownloadController {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PreDownload.Controller";
    private boolean enable;
    private IGuardInterface mGuardCallback;
    private PreDownloadScheduler mScheduler;

    /* loaded from: classes19.dex */
    class PreDownloadGuardCallback implements IGuardInterface {
        static IPatchRedirector $redirector_;

        PreDownloadGuardCallback() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PreDownloadControllerImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !TextUtils.isEmpty(peekAppRuntime.getAccount())) {
                PreDownloadControllerImpl.this.onAppBackground();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !TextUtils.isEmpty(peekAppRuntime.getAccount())) {
                PreDownloadControllerImpl.this.onAppForeground();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
                return;
            }
            GuardManager guardManager = GuardManager.sInstance;
            if (guardManager != null && j3 < guardManager.getTimeout() / 12000 && j3 == 1) {
                PreDownloadControllerImpl.this.onAppLiteStart(true);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    public PreDownloadControllerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.enable = true;
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public AbsPreDownloadTask cancelPreDownload(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AbsPreDownloadTask) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return this.mScheduler.cancelPreDownload(str);
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public boolean couldDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mScheduler.checkState();
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public String getPreDownloadPath(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
        }
        return this.mScheduler.getPreDownloadPath(i3, str, z16);
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void onAppBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = "onAppBackground, ";
            if (this.mScheduler == null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        PreDownloadScheduler preDownloadScheduler = this.mScheduler;
        if (preDownloadScheduler != null) {
            preDownloadScheduler.onAppBackground();
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void onAppForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = "onAppForeground, ";
            if (this.mScheduler == null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        PreDownloadScheduler preDownloadScheduler = this.mScheduler;
        if (preDownloadScheduler != null) {
            preDownloadScheduler.onAppForground();
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void onAppLiteStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            boolean z17 = false;
            objArr[0] = "onAppLiteStart, ";
            if (this.mScheduler == null) {
                z17 = true;
            }
            objArr[1] = Boolean.valueOf(z17);
            objArr[2] = " isLiteStart=";
            objArr[3] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        PreDownloadScheduler preDownloadScheduler = this.mScheduler;
        if (preDownloadScheduler != null) {
            preDownloadScheduler.onAppLiteStart(z16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime instanceof BaseQQAppInterface) {
            PreDownloadScheduler preDownloadScheduler = new PreDownloadScheduler((BaseQQAppInterface) appRuntime);
            this.mScheduler = preDownloadScheduler;
            preDownloadScheduler.setEnable(this.enable);
            if (GuardManager.sInstance != null) {
                PreDownloadGuardCallback preDownloadGuardCallback = new PreDownloadGuardCallback();
                this.mGuardCallback = preDownloadGuardCallback;
                GuardManager.sInstance.registerCallBack(preDownloadGuardCallback);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        GuardManager guardManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        PreDownloadScheduler preDownloadScheduler = this.mScheduler;
        if (preDownloadScheduler != null) {
            preDownloadScheduler.onDestroy();
        }
        IGuardInterface iGuardInterface = this.mGuardCallback;
        if (iGuardInterface != null && (guardManager = GuardManager.sInstance) != null) {
            guardManager.unregisterCallback(iGuardInterface);
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void onTaskEnd(AbsPreDownloadTask absPreDownloadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) absPreDownloadTask);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onTaskEnd: " + absPreDownloadTask);
        }
        this.mScheduler.onTaskEnd(absPreDownloadTask);
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void preDownloadSuccess(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.mScheduler.preDownloadSuccess(str, j3);
        } else {
            iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public boolean requestPreDownload(int i3, String str, String str2, int i16, String str3, String str4, int i17, int i18, boolean z16, AbsPreDownloadTask absPreDownloadTask) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), str, str2, Integer.valueOf(i16), str3, str4, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), absPreDownloadTask)).booleanValue();
        }
        return this.mScheduler.requestPreDownload(i3, str, str2, i16, str3, str4, i17, i18, z16, absPreDownloadTask);
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void startPreDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            boolean z16 = false;
            objArr[0] = "startPreDownload, ";
            if (this.mScheduler == null) {
                z16 = true;
            }
            objArr[1] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        PreDownloadScheduler preDownloadScheduler = this.mScheduler;
        if (preDownloadScheduler != null) {
            preDownloadScheduler.startPreDownload();
        }
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void preDownloadSuccess(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Long.valueOf(j3));
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        this.mScheduler.preDownloadSuccess(str, arrayList, j3);
    }

    @Override // com.tencent.mobileqq.transfile.predownload.IPreDownloadController
    public void preDownloadSuccess(String str, ArrayList<String> arrayList, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            this.mScheduler.preDownloadSuccess(str, arrayList, j3);
        } else {
            iPatchRedirector.redirect((short) 7, this, str, arrayList, Long.valueOf(j3));
        }
    }
}
