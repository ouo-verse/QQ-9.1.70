package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.NewIntent;

/* loaded from: classes9.dex */
public class NotifyPCActiveActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name */
    public static NotifyPCActiveActivity f176576d0;

    /* renamed from: a0, reason: collision with root package name */
    private QQCustomDialog f176577a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f176578b0;

    /* renamed from: c0, reason: collision with root package name */
    private CardObserver f176579c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPCActiveActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
                NotifyPCActiveActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CardHandler f176581d;

        b(CardHandler cardHandler) {
            this.f176581d = cardHandler;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPCActiveActivity.this, (Object) cardHandler);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            this.f176581d.m5(true);
            BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
            NotifyPCActiveActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPCActiveActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                NotifyPCActiveActivity.this.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    class d extends CardObserver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NotifyPCActiveActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetPCActiveState(boolean z16, boolean z17, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), str, str2);
                return;
            }
            if (z16) {
                SettingCloneUtil.writeValue((Context) NotifyPCActiveActivity.this.app.getApp(), str2, (String) null, AppConstants.QQSETTING_PCACTIVE_KEY, true);
                QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67231);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            f176576d0 = null;
        }
    }

    public NotifyPCActiveActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176577a0 = null;
            this.f176579c0 = new d();
        }
    }

    private void myShowDialog(int i3) {
        QQCustomDialog qQCustomDialog = this.f176577a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f176577a0.dismiss();
        }
        this.f176577a0 = null;
        if (i3 != 1) {
            if (i3 == 2) {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("Message");
                this.f176577a0 = DialogUtil.createCustomDialog(this, 230).setMessage(string).setPositiveButton(extras.getString("button"), new c());
            }
        } else {
            this.app.addObserver(this.f176579c0, true);
            CardHandler cardHandler = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
            Bundle extras2 = getIntent().getExtras();
            String string2 = extras2.getString("Message");
            String string3 = extras2.getString("lButton");
            String string4 = extras2.getString("rButton");
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230);
            this.f176577a0 = createCustomDialog;
            createCustomDialog.setContentView(R.layout.custom_dialog);
            this.f176577a0.setTitle((String) null).setMessage(string2).setPositiveButton(string4, new b(cardHandler)).setNegativeButton(string3, new a());
        }
        QQCustomDialog qQCustomDialog2 = this.f176577a0;
        if (qQCustomDialog2 != null) {
            qQCustomDialog2.setCancelable(false);
            this.f176577a0.show();
        }
    }

    private void stopUpgrade() {
        ConfigHandler configHandler = (ConfigHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
        if (configHandler != null) {
            configHandler.close();
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
        f176576d0 = this;
        this.f176578b0 = getIntent().getIntExtra("type", 0);
        String action = getIntent().getAction();
        if (QLog.isColorLevel()) {
            QLog.d("NotificationActivity", 2, "NotificationActivity action = " + action);
        }
        if (NewIntent.ACTION_PCACTIVE_TIPS.equals(action)) {
            ReportController.o(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
            this.f176578b0 = 1;
            stopUpgrade();
        } else if (NewIntent.ACTION_NOTICE_ON_PCACTIVE.equals(action)) {
            this.f176578b0 = 2;
        }
        myShowDialog(this.f176578b0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.app.removeObserver(this.f176579c0);
        super.doOnDestroy();
        if (f176576d0 != null) {
            f176576d0 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i("NotifyPCActiveActivity", 2, "Running in doOnDestroy()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnUserLeaveHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnUserLeaveHint();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQCustomDialog qQCustomDialog = this.f176577a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f176577a0.dismiss();
        }
        this.f176577a0 = null;
        super.finish();
        f176576d0 = null;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
