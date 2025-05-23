package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class PhoneUnityPhoneLoginActivity extends IphoneTitleBarActivity implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private FormSwitchItem f176621a0;

    /* renamed from: b0, reason: collision with root package name */
    private byte[] f176622b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.app.cx f176623c0;

    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.cx {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class DialogInterfaceOnClickListenerC7109a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC7109a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityPhoneLoginActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        public void a(int i3, String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 == 0 && PhoneUnityPhoneLoginActivity.this.f176621a0 != null) {
                PhoneUnityPhoneLoginActivity.this.f176621a0.setOnCheckedChangeListener(null);
                PhoneUnityPhoneLoginActivity.this.f176621a0.setChecked(true);
                PhoneUnityPhoneLoginActivity.this.f176621a0.setOnCheckedChangeListener(PhoneUnityPhoneLoginActivity.this);
            } else if (i3 == 39) {
                ReportController.o(PhoneUnityPhoneLoginActivity.this.app, "CliOper", "", "", "0X8005BFD", "0X8005BFD", 0, 0, "", "", "", "");
                PhoneUnityPhoneLoginActivity phoneUnityPhoneLoginActivity = PhoneUnityPhoneLoginActivity.this;
                DialogUtil.createCustomDialog(phoneUnityPhoneLoginActivity, 230, phoneUnityPhoneLoginActivity.getString(R.string.cru), PhoneUnityPhoneLoginActivity.this.getString(R.string.crt), (String) null, PhoneUnityPhoneLoginActivity.this.getString(R.string.azg), new DialogInterfaceOnClickListenerC7109a(), (DialogInterface.OnClickListener) null).show();
            } else {
                if (TextUtils.isEmpty(str)) {
                    str2 = PhoneUnityPhoneLoginActivity.this.getString(R.string.crs);
                } else {
                    str2 = str;
                }
                QQToast.makeText(PhoneUnityPhoneLoginActivity.this, str2, 0).show(PhoneUnityPhoneLoginActivity.this.getTitleBarHeight());
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        public void i(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 == 0 && PhoneUnityPhoneLoginActivity.this.f176621a0 != null) {
                PhoneUnityPhoneLoginActivity.this.f176621a0.setOnCheckedChangeListener(null);
                PhoneUnityPhoneLoginActivity.this.f176621a0.setChecked(false);
                PhoneUnityPhoneLoginActivity.this.f176621a0.setOnCheckedChangeListener(PhoneUnityPhoneLoginActivity.this);
            } else {
                if (i3 == 36) {
                    str = PhoneUnityPhoneLoginActivity.this.getString(R.string.cry);
                } else if (TextUtils.isEmpty(str)) {
                    str = PhoneUnityPhoneLoginActivity.this.getString(R.string.crx);
                }
                QQToast.makeText(PhoneUnityPhoneLoginActivity.this, str, 0).show(PhoneUnityPhoneLoginActivity.this.getTitleBarHeight());
            }
        }
    }

    public PhoneUnityPhoneLoginActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176623c0 = new a();
        }
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
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.az5);
        setTitle(getString(R.string.crw));
        setContentBackgroundResource(R.drawable.bg_texture);
        this.leftView.setText(R.string.fsn);
        FormSwitchItem formSwitchItem = (FormSwitchItem) super.findViewById(R.id.fmr);
        this.f176621a0 = formSwitchItem;
        if (formSwitchItem != null) {
            formSwitchItem.setOnCheckedChangeListener(this);
        }
        addObserver(this.f176623c0);
        Intent intent = super.getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.f176622b0 = extras.getByteArray("phone_num_login_sig");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            removeObserver(this.f176623c0);
            super.doOnDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Intent intent = new Intent();
        intent.putExtra("phone_num_login_result", this.f176621a0.isChecked());
        super.setResult(-1, intent);
        super.finish();
        return false;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        byte[] bArr;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton == this.f176621a0.getSwitch()) {
            this.f176621a0.setOnCheckedChangeListener(null);
            FormSwitchItem formSwitchItem = this.f176621a0;
            formSwitchItem.setChecked(true ^ formSwitchItem.isChecked());
            this.f176621a0.setOnCheckedChangeListener(this);
            if (!NetworkUtil.isNetSupport(this)) {
                QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
            } else {
                SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
                if (secSvcHandler != null && (bArr = this.f176622b0) != null) {
                    if (z16) {
                        secSvcHandler.D2(bArr);
                    } else {
                        secSvcHandler.W2(bArr);
                    }
                }
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
