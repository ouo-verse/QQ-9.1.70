package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

/* loaded from: classes9.dex */
public class AuthDevConfirmPhoneNoActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private String f174968a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f174969b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f174970c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f174971d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f174972e0;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f174973f0;

    /* renamed from: g0, reason: collision with root package name */
    private Button f174974g0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f174975h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f174976i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f174977j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f174978k0;

    /* renamed from: l0, reason: collision with root package name */
    private DevlockInfo f174979l0;

    public AuthDevConfirmPhoneNoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f174968a0 = null;
        this.f174969b0 = null;
        this.f174970c0 = null;
        this.f174971d0 = null;
        this.f174972e0 = null;
        this.f174973f0 = null;
        this.f174974g0 = null;
        this.f174975h0 = null;
        this.f174979l0 = null;
    }

    private void initUI() {
        super.setContentView(R.layout.atx);
        setTitle(R.string.azi);
        this.f174971d0 = (TextView) findViewById(R.id.jh6);
        this.f174972e0 = (TextView) findViewById(R.id.jh5);
        this.f174973f0 = (TextView) findViewById(R.id.ji9);
        this.f174974g0 = (Button) findViewById(R.id.agh);
        this.f174975h0 = (Button) findViewById(R.id.aib);
        if (QLog.isColorLevel() && (this.f174971d0 == null || this.f174972e0 == null || this.f174973f0 == null || this.f174974g0 == null || this.f174975h0 == null)) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "one or more controls is null! ");
            return;
        }
        onCreateRightView();
        setRightButton(R.string.ayt, this);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            textView.setVisibility(8);
        }
        String str = this.f174968a0;
        if (str != null) {
            this.f174971d0.setText(str);
        }
        String str2 = this.f174969b0;
        if (str2 != null) {
            this.f174972e0.setText(str2);
        }
        String str3 = this.f174970c0;
        if (str3 != null) {
            this.f174973f0.setText(str3);
        }
        String string = getString(R.string.ayq);
        String string2 = getString(R.string.azk);
        this.f174974g0.setText(string);
        this.f174974g0.setClickable(true);
        this.f174974g0.setOnClickListener(this);
        this.f174975h0.setText(string2);
        this.f174975h0.setClickable(true);
        this.f174975h0.setOnClickListener(this);
        try {
            EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 6);
        } catch (Exception unused) {
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
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        Intent intent2;
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        if (i3 != 1001) {
            if (i3 != 1002 || intent == null || (extras = intent.getExtras()) == null) {
                return;
            }
            int i17 = extras.getInt("resultState", 1);
            String string = extras.getString("resultMobileMask");
            if (i17 != 1) {
                if (i17 == 2) {
                    com.tencent.mobileqq.equipmentlock.a.b().d(com.tencent.mobileqq.equipmentlock.a.f205359g);
                } else if (i17 == 3) {
                    com.tencent.mobileqq.equipmentlock.a.b().d(com.tencent.mobileqq.equipmentlock.a.f205358f);
                    com.tencent.mobileqq.equipmentlock.a.b().c(0L);
                }
                Intent intent3 = new Intent(intent);
                intent3.putExtra("requestCode", i3);
                intent3.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, string);
                setResult(-1, intent3);
                finish();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "verify page call back resultCode = " + i16);
        }
        if (i16 == -1) {
            if (intent != null) {
                intent2 = new Intent(intent);
            } else {
                intent2 = new Intent();
            }
            intent2.putExtra("requestCode", i3);
            setResult(-1, intent2);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        finish();
        overridePendingTransition(0, R.anim.f154458a7);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.agh) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click confirm mobile phone button! ");
                }
                try {
                    EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 7);
                } catch (Exception unused) {
                }
                Intent intent = new Intent();
                intent.putExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM, this.f174979l0.Mobile);
                intent.putExtra("country_code", this.f174979l0.CountryCode);
                intent.putExtra("mobile_type", 0);
                RouteUtils.startActivityForResult(this, intent, "/base/login/authDevVerifyCode", 1001);
            } else if (id5 == R.id.aib) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "click modify mobile phone button! ");
                }
                try {
                    EquipmentLockImpl.o().C(null, this.app.getCurrentAccountUin(), 8);
                } catch (Exception unused2) {
                }
                QQAppInterface qQAppInterface = this.app;
                if (qQAppInterface != null) {
                    qQAppInterface.sendWirelessMeibaoReq(1);
                }
                if (!TextUtils.isEmpty(this.f174977j0) && this.f174977j0.equals("subaccount")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "subaccount enter webview mUin=" + this.f174976i0 + " mMainAccount=" + this.f174978k0);
                    }
                    if (TextUtils.isEmpty(this.f174976i0) && QLog.isColorLevel()) {
                        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
                    }
                    com.tencent.mobileqq.equipmentlock.b.d(this, this.f174978k0, this.f174976i0, com.tencent.mobileqq.equipmentlock.b.f205366c, 1002, null);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mainaccount enter webview mUin=" + this.f174976i0);
                    }
                    if (TextUtils.isEmpty(this.f174976i0) && QLog.isColorLevel()) {
                        QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "mUin is empty.");
                    }
                    String str = this.f174976i0;
                    com.tencent.mobileqq.equipmentlock.b.d(this, str, str, com.tencent.mobileqq.equipmentlock.b.f205366c, 1002, null);
                }
            } else if (id5 == R.id.ivTitleBtnRightText) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "onClick right cancel button! ");
                }
                finish();
                overridePendingTransition(0, R.anim.f154458a7);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        Intent intent = getIntent();
        if (intent == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            super.onCreate(bundle);
            finish();
            return;
        }
        this.f174968a0 = extras.getString("ParaTextUp");
        this.f174969b0 = extras.getString("ParaTextDown");
        this.f174970c0 = extras.getString("PhoneNO");
        this.f174976i0 = extras.getString("uin");
        this.f174977j0 = extras.getString("from_where");
        this.f174978k0 = extras.getString("mainaccount");
        this.f174979l0 = (DevlockInfo) extras.get(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO);
        if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphUp : " + this.f174968a0);
            QLog.d("Q.devlock.AuthDevConfirmPhoneNoActivity", 2, "on Create strParaGraphDown : " + this.f174969b0);
        }
        super.onCreate(bundle);
        initUI();
    }
}
