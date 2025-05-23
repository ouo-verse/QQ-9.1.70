package com.tencent.mobileqq.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SettingUncommUsedContactsActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    FormSwitchItem f177052a0;

    /* renamed from: b0, reason: collision with root package name */
    FormSwitchItem f177053b0;

    /* renamed from: c0, reason: collision with root package name */
    final String f177054c0;

    /* renamed from: d0, reason: collision with root package name */
    com.tencent.mobileqq.app.ar f177055d0;

    /* renamed from: e0, reason: collision with root package name */
    CompoundButton.OnCheckedChangeListener f177056e0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingUncommUsedContactsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onGetBothDongtaiPermissions(boolean z16, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            } else if (z16) {
                SettingUncommUsedContactsActivity settingUncommUsedContactsActivity = SettingUncommUsedContactsActivity.this;
                settingUncommUsedContactsActivity.H2(settingUncommUsedContactsActivity.f177052a0.getSwitch(), z17);
                SettingUncommUsedContactsActivity settingUncommUsedContactsActivity2 = SettingUncommUsedContactsActivity.this;
                settingUncommUsedContactsActivity2.H2(settingUncommUsedContactsActivity2.f177053b0.getSwitch(), z18);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetNotAllowedSeeMyDongtai(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (!z16) {
                SettingUncommUsedContactsActivity.this.notifyUser(R.string.hhc, 1);
                SettingUncommUsedContactsActivity settingUncommUsedContactsActivity = SettingUncommUsedContactsActivity.this;
                settingUncommUsedContactsActivity.H2(settingUncommUsedContactsActivity.f177052a0.getSwitch(), z17);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onSetShieldHisDongtai(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (!z16) {
                SettingUncommUsedContactsActivity.this.notifyUser(R.string.hhc, 1);
                SettingUncommUsedContactsActivity settingUncommUsedContactsActivity = SettingUncommUsedContactsActivity.this;
                settingUncommUsedContactsActivity.H2(settingUncommUsedContactsActivity.f177053b0.getSwitch(), z17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements CompoundButton.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingUncommUsedContactsActivity.this);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
            } else if ((compoundButton == SettingUncommUsedContactsActivity.this.f177052a0.getSwitch() || compoundButton == SettingUncommUsedContactsActivity.this.f177053b0.getSwitch()) && !NetworkUtil.isNetSupport(SettingUncommUsedContactsActivity.this.getActivity())) {
                SettingUncommUsedContactsActivity.this.notifyUser(R.string.cjn, 0);
                SettingUncommUsedContactsActivity.this.H2(compoundButton, !z16);
            } else if (compoundButton == SettingUncommUsedContactsActivity.this.f177052a0.getSwitch()) {
                SettingUncommUsedContactsActivity.this.app.setNotAllowedSeeMyDongtai(z16, true);
            } else if (compoundButton == SettingUncommUsedContactsActivity.this.f177053b0.getSwitch()) {
                SettingUncommUsedContactsActivity.this.app.setShieldHisDongtai(z16, true);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    public SettingUncommUsedContactsActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177054c0 = "SettingUnommUsedContacts";
        this.f177055d0 = new a();
        this.f177056e0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H2(CompoundButton compoundButton, boolean z16) {
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z16);
        compoundButton.setOnCheckedChangeListener(this.f177056e0);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        initUI();
        addObserver(this.f177055d0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.doOnDestroy();
            removeObserver(this.f177055d0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
            ((FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getDongtaiPermission(this.app.getCurrentAccountUin(), 3);
        }
    }

    void initUI() {
        setContentViewB(R.layout.b2r);
        setTitle(R.string.hia);
        this.leftView.setText(R.string.button_back);
        this.rightViewText.setVisibility(8);
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById(R.id.f166372f51);
        this.f177052a0 = formSwitchItem;
        formSwitchItem.setOnCheckedChangeListener(this.f177056e0);
        H2(this.f177052a0.getSwitch(), this.app.getNotAllowedSeeMyDongtai(false));
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) findViewById(R.id.is8);
        this.f177053b0 = formSwitchItem2;
        formSwitchItem2.setOnCheckedChangeListener(this.f177056e0);
        H2(this.f177053b0.getSwitch(), this.app.getShieldHisDongtai(false));
        if (AppSetting.f99565y) {
            this.centerView.setContentDescription(getString(R.string.hia));
            this.f177052a0.setContentDescription(getString(R.string.ck_));
            this.f177052a0.setFocusable(true);
            this.f177053b0.setContentDescription(getString(R.string.hjx));
            this.f177053b0.setFocusable(true);
        }
    }

    void notifyUser(int i3, int i16) {
        new QQToastNotifier(this).notifyUser(i3, getTitleBarHeight(), 0, i16);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
