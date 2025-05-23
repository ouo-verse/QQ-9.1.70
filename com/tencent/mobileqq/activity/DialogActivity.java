package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DialogActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: d0, reason: collision with root package name */
    public static int f175526d0;

    /* renamed from: e0, reason: collision with root package name */
    public static int f175527e0;

    /* renamed from: f0, reason: collision with root package name */
    public static int f175528f0;

    /* renamed from: g0, reason: collision with root package name */
    public static int f175529g0;

    /* renamed from: a0, reason: collision with root package name */
    private int f175530a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f175531b0;

    /* renamed from: c0, reason: collision with root package name */
    Dialog f175532c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ITransFileController iTransFileController = (ITransFileController) DialogActivity.this.app.getRuntimeService(ITransFileController.class);
            iTransFileController.getBusHelper().resumeLastRawSend();
            iTransFileController.getBusHelper().resumeLastShortVideoTransfer();
            DialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements DialogInterface.OnCancelListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                DialogActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("qqBaseActivity", 1, "checkBackgroundRestricWhilteList conform to setting.");
            dialogInterface.dismiss();
            DialogActivity.this.startActivity(new Intent("android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS", Uri.parse("package:" + DialogActivity.this.getPackageName())));
            DialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            QLog.d("qqBaseActivity", 1, "checkBackgroundRestricWhilteList cancel.");
            dialogInterface.dismiss();
            DialogActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                DialogActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
            DialogActivity dialogActivity = DialogActivity.this;
            iTeamWorkUtils.gotoTeamWorkListWebH5(dialogActivity.app, dialogActivity);
            DialogActivity.this.finish();
            ReportController.o(DialogActivity.this.app, "dc00898", "", "", "0X800906A", "0X800906A", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                DialogActivity.this.finish();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(66858);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f175526d0 = 0;
        f175527e0 = 1;
        f175528f0 = 2;
        f175529g0 = 3;
    }

    public DialogActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void H2() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, (String) null, getString(R.string.f_2), getString(R.string.cancel), getString(R.string.f_3), new d(), new e());
        this.f175532c0 = createCustomDialog;
        I2(createCustomDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(Dialog dialog) {
        QLog.d("qqBaseActivity", 1, "DialogActivity showDialog dialogType=" + this.f175531b0 + " dialog=" + dialog);
        try {
            if (QLog.isColorLevel()) {
                QLog.d(AppConstants.TAG_RAW_PHOTO, 2, "showDialog dialogType=" + this.f175531b0);
            }
            dialog.show();
            if (this.f175531b0 == f175528f0) {
                ReportController.o(null, "dc00898", "", "", "0X8009AC7", "0X8009AC7", 0, 0, "", "", "", "");
            }
        } catch (WindowManager.BadTokenException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(AppConstants.TAG_RAW_PHOTO, 2, "showDialog ", e16);
            }
            getWindow().getDecorView().post(new Runnable(dialog) { // from class: com.tencent.mobileqq.activity.DialogActivity.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Dialog f175533d;

                {
                    this.f175533d = dialog;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogActivity.this, (Object) dialog);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        DialogActivity.this.I2(this.f175533d);
                        if (DialogActivity.this.f175531b0 == DialogActivity.f175528f0) {
                            ReportController.o(null, "dc00898", "", "", "0X8009AC7", "0X8009AC7", 0, 0, "", "", "", "");
                            return;
                        }
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            });
        }
    }

    private void J2() {
        MsgNotifyPushDialog msgNotifyPushDialog = new MsgNotifyPushDialog(this);
        this.f175532c0 = msgNotifyPushDialog;
        msgNotifyPushDialog.setOnDismissListener(new f());
        I2(this.f175532c0);
    }

    private void K2() {
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this, 230).setMessage(getString(this.f175530a0)).setPositiveButton(getString(R.string.hki), new b()).setNegativeButton(getString(R.string.hkj), new a());
        negativeButton.setOnCancelListener(new c());
        I2(negativeButton);
    }

    private void L2() {
        if (getIntent() == null) {
            return;
        }
        new com.tencent.mobileqq.teamwork.bi(this, getIntent().getStringExtra("key_dialog_title"), getIntent().getStringExtra("key_dialog_content"), new g(), new h()).show();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.f175531b0 = intent.getIntExtra("key_dialog_type", f175526d0);
            this.f175530a0 = intent.getIntExtra("key_dialog_msg_id", R.string.ad6);
        }
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnPause();
        if (this.f175531b0 == f175527e0) {
            QLog.d("qqBaseActivity", 1, "DialogActivity dimissDialog dialogType=" + this.f175531b0 + " dialog=" + this.f175532c0);
            Dialog dialog = this.f175532c0;
            if (dialog != null) {
                dialog.dismiss();
                finish();
                this.f175532c0 = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnResume();
        Dialog dialog = this.f175532c0;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        int i3 = this.f175531b0;
        if (i3 == f175527e0) {
            H2();
            return;
        }
        if (i3 == f175528f0) {
            J2();
        } else if (i3 == f175529g0) {
            L2();
        } else {
            K2();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.finish();
        Dialog dialog = this.f175532c0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
        }
        overridePendingTransition(0, R.anim.dialog_exit);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
