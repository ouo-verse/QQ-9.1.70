package com.tencent.mobileqq.profilecard.bussiness.anonymous.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfig;
import com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.api.IAnonymousService;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;
import com.tencent.mobileqq.profilesetting.a;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AnonymousServiceImpl implements IAnonymousService, IProfileConfigListener {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AnonymousServiceImpl";
    public AppRuntime mApp;
    private boolean mBusinessSwitch;
    private a mCardSettingObserver;
    private IProfileConfig mConfigHelper;
    private boolean mConfigSwitch;
    private boolean mSettingMeRedPointEnable;

    public AnonymousServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSettingMeRedPointEnable = false;
        this.mConfigSwitch = false;
        this.mBusinessSwitch = false;
        this.mCardSettingObserver = new a() { // from class: com.tencent.mobileqq.profilecard.bussiness.anonymous.api.impl.AnonymousServiceImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousServiceImpl.this);
                }
            }

            @Override // com.tencent.mobileqq.profilesetting.a
            public void onGetCardDisplaySetting(boolean z16, @Nullable String str, @Nullable Card card) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                boolean z17 = false;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), str, card);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AnonymousServiceImpl.TAG, 2, String.format("onGetCardDisplaySetting isSuccess=%s", Boolean.valueOf(z16)));
                }
                if (z16 && card != null) {
                    if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileDisplaySettingStateFromCard(42425, card, null) == 0) {
                        z17 = true;
                    }
                    AnonymousServiceImpl.this.updateBusinessSwitch(z17);
                }
                AnonymousServiceImpl anonymousServiceImpl = AnonymousServiceImpl.this;
                AppRuntime appRuntime = anonymousServiceImpl.mApp;
                if (appRuntime != null) {
                    ((AppInterface) appRuntime).removeObserver(anonymousServiceImpl.mCardSettingObserver);
                }
            }
        };
    }

    private void getBusinessSwitch(AppInterface appInterface) {
        if (appInterface != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(42425);
            if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).reqGetCardDisplaySetting(appInterface, arrayList)) {
                appInterface.addObserver(this.mCardSettingObserver);
            }
        }
    }

    private void notifySettingMeRedPointChanged() {
        AnonymousHandler anonymousHandler;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("notifySettingMeRedPointChanged mSettingMeRedPointEnable=%s", Boolean.valueOf(this.mSettingMeRedPointEnable)));
        }
        AppRuntime appRuntime = this.mApp;
        if (appRuntime != null && (anonymousHandler = (AnonymousHandler) ((AppInterface) appRuntime).getBusinessHandler(AnonymousHandler.class.getName())) != null) {
            anonymousHandler.notifyUI(5, true, Boolean.valueOf(this.mSettingMeRedPointEnable));
        }
    }

    private void updateSettingMeRedPointEnable() {
        boolean z16;
        if (this.mConfigSwitch && this.mBusinessSwitch) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 != this.mSettingMeRedPointEnable) {
            this.mSettingMeRedPointEnable = z16;
            notifySettingMeRedPointChanged();
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.anonymous.api.IAnonymousService
    public boolean getSettingMeRedPointEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mSettingMeRedPointEnable;
    }

    @Override // com.tencent.mobileqq.profilecard.base.config.IProfileConfigListener
    public void onConfigUpdate(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = appRuntime;
        IProfileConfig createProfileConfig = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).createProfileConfig((AppInterface) this.mApp);
        this.mConfigHelper = createProfileConfig;
        updateConfigSwitch(createProfileConfig.isSwitchEnable(13));
        getBusinessSwitch((AppInterface) appRuntime);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.mApp = null;
        IProfileConfig iProfileConfig = this.mConfigHelper;
        if (iProfileConfig != null) {
            iProfileConfig.destroy();
            this.mConfigHelper = null;
        }
    }

    protected void updateBusinessSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateBusinessSwitch newBusinessSwitch=%s", Boolean.valueOf(z16)));
        }
        if (z16 != this.mBusinessSwitch) {
            this.mBusinessSwitch = z16;
            updateSettingMeRedPointEnable();
        }
    }

    protected void updateConfigSwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("updateConfigSwitch newConfigSwitch=%s", Boolean.valueOf(z16)));
        }
        if (z16 != this.mConfigSwitch) {
            this.mConfigSwitch = z16;
            updateSettingMeRedPointEnable();
        }
    }
}
