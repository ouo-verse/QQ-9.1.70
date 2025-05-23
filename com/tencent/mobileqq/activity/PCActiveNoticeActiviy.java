package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes9.dex */
public class PCActiveNoticeActiviy extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private QQCustomDialog f176589a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f176590b0;

    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PCActiveNoticeActiviy.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            PCActiveNoticeActiviy pCActiveNoticeActiviy = PCActiveNoticeActiviy.this;
            SettingCloneUtil.writeValue((Context) pCActiveNoticeActiviy, pCActiveNoticeActiviy.f176590b0, (String) null, AppConstants.PCACTIVE_NOTICE_KEY, false);
            PCActiveNoticeActiviy.this.finish();
        }
    }

    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PCActiveNoticeActiviy.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                PCActiveNoticeActiviy pCActiveNoticeActiviy = PCActiveNoticeActiviy.this;
                SettingCloneUtil.writeValue((Context) pCActiveNoticeActiviy, pCActiveNoticeActiviy.f176590b0, (String) null, AppConstants.PCACTIVE_NOTICE_KEY, false);
                PCActiveNoticeActiviy.this.finish();
            }
            return false;
        }
    }

    public PCActiveNoticeActiviy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176589a0 = null;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
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
        super.setContentView(R.layout.notification_activity_transparent);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.f176590b0 = getIntent().getExtras().getString("uin");
        } else {
            this.f176590b0 = null;
        }
        if (TextUtils.isEmpty(this.f176590b0)) {
            finish();
            return false;
        }
        QQCustomDialog qQCustomDialog = this.f176589a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f176589a0.dismiss();
        }
        String qqStr = HardCodeUtil.qqStr(R.string.p0_);
        this.f176589a0 = null;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        this.f176589a0 = createCustomDialog;
        createCustomDialog.setContentView(R.layout.custom_dialog);
        this.f176589a0.setTitle((String) null).setMessage(getString(R.string.cqx)).setPositiveButton(R.string.cqw, new a());
        this.f176589a0.setTextContentDescription(qqStr);
        this.f176589a0.setOnKeyListener(new b());
        this.f176589a0.show();
        ReportController.o(null, "CliOper", "", "", "0X8004973", "0X8004973", 0, 0, "", "", "", "");
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f176589a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f176589a0.dismiss();
        }
        this.f176589a0 = null;
        super.finish();
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
