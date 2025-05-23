package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

/* loaded from: classes10.dex */
public class GuideBindPhoneActivity extends IphoneTitleBarActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected PermissionPageUtil f183868a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f183869b0;

    /* renamed from: c0, reason: collision with root package name */
    protected int f183870c0;

    public GuideBindPhoneActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183869b0 = -1;
            this.f183870c0 = 0;
        }
    }

    public void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (PermissionChecker.h().g()) {
            setResult(-1);
            finish();
        }
    }

    public void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true)) {
            ContactBindedActivity.U2(this.app, -1, 2, null);
            setResult(-1);
            finish();
        }
    }

    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (VersionUtils.isM() && PermissionChecker.d(QQPermissionConstants.Permission.WRITE_CONTACTS)) {
            String stringExtra = getIntent().getStringExtra("key_contact_name");
            String stringExtra2 = getIntent().getStringExtra("key_contact_phone");
            IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && iPhoneContactService.addContactAndUpload(stringExtra, stringExtra2)) {
                QQToast.makeText(getApplicationContext(), 2, HardCodeUtil.qqStr(R.string.n6v), 0).show();
            }
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 9999) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
            }
            int i17 = this.f183870c0;
            if (i17 != 2 && i17 != 1) {
                if (i17 == 5) {
                    I2();
                    return;
                } else if (i17 == 6) {
                    G2();
                    return;
                } else {
                    G2();
                    return;
                }
            }
            H2();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            setResult(0);
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f183869b0 = getIntent().getIntExtra("kSrouce", -1);
        this.f183870c0 = getIntent().getIntExtra("fromKeyForContactBind", 0);
        if (getIntent().getBooleanExtra("key_runtime_req_permission", false)) {
            PermissionChecker.e(this, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuideBindPhoneActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("GuideBindPhoneActivity", 2, "have read phone contact permission");
                    }
                    GuideBindPhoneActivity.this.finish();
                }
            }, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuideBindPhoneActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (QLog.isColorLevel()) {
                        QLog.i("GuideBindPhoneActivity", 2, "do not have read phone contact permission");
                    }
                }
            });
        }
        setContentView(R.layout.f168021p7);
        PhoneContactUtils.b(this.app, getResources(), (ImageView) findViewById(R.id.f164890b83));
        View findViewById = findViewById(R.id.e2a);
        if (findViewById != null && "1000".equals(ThemeUtil.curThemeId)) {
            findViewById.setBackgroundResource(R.drawable.f160540jm);
        } else if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.bg_texture);
        }
        setTitle(null, getString(R.string.csy));
        setLeftViewName(R.string.f170549u3);
        this.f183868a0 = new PermissionPageUtil(this, getPackageName());
        findViewById(R.id.f164889b82).setOnClickListener(this);
        ReportController.o(this.app, "dc00898", "", "", "0X8009F1B", "0X8009F1B", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.i("GuideBindPhoneActivity", 2, String.format("init [%s, %s]", Integer.valueOf(this.f183869b0), Integer.valueOf(this.f183870c0)));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f164889b82) {
            if (QLog.isColorLevel()) {
                QLog.i("GuideBindPhoneActivity", 2, "jump permission page");
            }
            if (VersionUtils.isM()) {
                int i3 = this.f183870c0;
                if (i3 == 2 || i3 == 1) {
                    ((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).markOrClearUserSettingFlag(true);
                }
                try {
                    this.f183868a0.d();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    this.f183868a0.h();
                }
            } else {
                this.f183868a0.h();
            }
            ReportController.o(this.app, "dc00898", "", "", "0X8009F1C", "0X8009F1C", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
