package com.tencent.mobileqq.olympic;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ar.o;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.IToolProcEventListener;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OlympicToolAppInterface extends BaseToolAppInterface implements IToolProcEventListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public b f255095d;

    /* renamed from: e, reason: collision with root package name */
    Map<Integer, Manager> f255096e;

    /* renamed from: f, reason: collision with root package name */
    a f255097f;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private class a implements INetInfoHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OlympicToolAppInterface.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else if (((AppInterface) OlympicToolAppInterface.this).mHwEngine != null) {
                ((AppInterface) OlympicToolAppInterface.this).mHwEngine.onNetMobile2None();
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else if (((AppInterface) OlympicToolAppInterface.this).mHwEngine != null) {
                ((AppInterface) OlympicToolAppInterface.this).mHwEngine.onNetMobile2Wifi(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (((AppInterface) OlympicToolAppInterface.this).mHwEngine != null) {
                ((AppInterface) OlympicToolAppInterface.this).mHwEngine.onNetNone2Mobile(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            } else if (((AppInterface) OlympicToolAppInterface.this).mHwEngine != null) {
                ((AppInterface) OlympicToolAppInterface.this).mHwEngine.onNetNone2Wifi(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else if (((AppInterface) OlympicToolAppInterface.this).mHwEngine != null) {
                ((AppInterface) OlympicToolAppInterface.this).mHwEngine.onNetWifi2Mobile(str);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else if (((AppInterface) OlympicToolAppInterface.this).mHwEngine != null) {
                ((AppInterface) OlympicToolAppInterface.this).mHwEngine.onNetWifi2None();
            }
        }
    }

    public OlympicToolAppInterface(BaseApplicationImpl baseApplicationImpl, String str) {
        super(baseApplicationImpl, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl, (Object) str);
        } else {
            this.f255096e = new HashMap(20);
            this.f255097f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppRuntime
    public void addManager(int i3, Manager manager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) manager);
        } else {
            if (this.f255096e.get(Integer.valueOf(i3)) != null) {
                return;
            }
            this.f255096e.put(Integer.valueOf(i3), manager);
        }
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public BaseApplication getApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseApplication) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.app;
    }

    @Override // com.tencent.common.app.AppInterface
    public int getAppid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return AppSetting.f();
    }

    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return getAccount();
    }

    @Override // mqq.app.AppRuntime
    public EntityManagerFactory getEntityManagerFactory(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (EntityManagerFactory) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.common.app.AppInterface
    public MobileQQServiceBase getMobileQQService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MobileQQServiceBase) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f255095d;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "module_olympic";
    }

    @Override // mqq.app.IToolProcEventListener
    public void onBeforeExitProc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.i("olympic.OlympicToolAppInterface", 2, "onBeforeExitProc");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("olympic.OlympicToolAppInterface", 2, "onCreate");
        }
        super.onCreate(bundle);
        this.f255095d = new b(this);
        QQAudioHelper.q((BaseApplicationImpl) this.app, getLongAccountUin());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.common.app.AppInterface, mqq.app.AppRuntime
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("olympic.OlympicToolAppInterface", 2, "onDestroy ,FaceScanModelsLoader.hasFaceModelInit = " + o.f198546c);
        }
        super.onDestroy();
        HwEngine hwEngine = this.mHwEngine;
        if (hwEngine != null) {
            hwEngine.closeEngine();
        }
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveAccountAction(String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) intent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("olympic.OlympicToolAppInterface", 2, "onReceiveAccountAction");
            return false;
        }
        return false;
    }

    @Override // mqq.app.IToolProcEventListener
    public boolean onReceiveLegalExitProcAction(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) intent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("olympic.OlympicToolAppInterface", 2, "onReceiveLegalExitProcAction");
            return false;
        }
        return false;
    }

    @Override // mqq.app.AppRuntime
    public void start(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
            return;
        }
        this.f255097f = new a();
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.f255097f);
        super.start(z16);
    }
}
