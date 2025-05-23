package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class OverloadTipsActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private QQCustomDialog f176586a0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OverloadTipsActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                OverloadTipsActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements DialogInterface.OnKeyListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OverloadTipsActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, dialogInterface, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (i3 == 4) {
                OverloadTipsActivity.this.finish();
            }
            return false;
        }
    }

    public OverloadTipsActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176586a0 = null;
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
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.notification_activity_transparent);
        if (getIntent() != null && getIntent().getExtras() != null) {
            str = getIntent().getExtras().getString("msg");
        } else {
            str = null;
        }
        if (str == null) {
            finish();
            return false;
        }
        QQCustomDialog qQCustomDialog = this.f176586a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f176586a0.dismiss();
        }
        this.f176586a0 = null;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
        this.f176586a0 = createCustomDialog;
        createCustomDialog.setContentView(R.layout.custom_dialog);
        this.f176586a0.setTitle((String) null).setMessage(str).setPositiveButton(R.string.cpy, new a());
        this.f176586a0.setTextContentDescription(str);
        this.f176586a0.setOnKeyListener(new b());
        this.f176586a0.show();
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f176586a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f176586a0.dismiss();
        }
        this.f176586a0 = null;
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
