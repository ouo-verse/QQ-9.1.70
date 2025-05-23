package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DialogBaseActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_ = null;
    static final int MSG_FINISH = 2;
    static final int MSG_PROGRESS = 1;
    public static final int RESULT_START_NUMBER = 2;
    public static final int RESULT_USER_CANCEL = 1;
    private View mContentView;
    protected IPhoneContactService mPhoneContactService;
    private e mUiHandler;
    QQProgressDialog progressDialog;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogBaseActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                DialogBaseActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f183862d;

        b(boolean z16) {
            this.f183862d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DialogBaseActivity.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            if (this.f183862d) {
                Intent aliasIntent = SplashActivity.getAliasIntent(BaseActivity.sTopActivity);
                aliasIntent.putExtra(AppConstants.MainTabIndex.MAIN_TAB_ID, 1);
                aliasIntent.setFlags(603979776);
                BaseActivity.sTopActivity.startActivity(aliasIntent);
                DialogBaseActivity.this.finish();
                ReportController.o(DialogBaseActivity.this.app, "dc00898", "", "", "0X8006AA6", "0X8006AA6", 0, 0, "", "", "", "");
                return;
            }
            DialogBaseActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f183864d;

        c(boolean z16) {
            this.f183864d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DialogBaseActivity.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            dialogInterface.dismiss();
            if (this.f183864d) {
                if (QLog.isColorLevel()) {
                    QLog.d("IphoneTitleBarActivity", 2, "new user guild confirm unbind");
                }
                ReportController.o(DialogBaseActivity.this.app, "dc00898", "", "", "0X8006AA5", "0X8006AA5", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DialogBaseActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            QQProgressDialog qQProgressDialog = DialogBaseActivity.this.progressDialog;
            if (qQProgressDialog != null) {
                qQProgressDialog.setOnDismissListener(null);
            }
            DialogBaseActivity.this.progressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class e extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogBaseActivity> f183867a;

        public e(DialogBaseActivity dialogBaseActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) dialogBaseActivity);
            } else {
                this.f183867a = new WeakReference<>(dialogBaseActivity);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            DialogBaseActivity dialogBaseActivity = this.f183867a.get();
            if (dialogBaseActivity == null) {
                return;
            }
            int i3 = message.what;
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 == 2) {
                    dialogBaseActivity.finish();
                    return;
                }
                throw new RuntimeException("Unknown message: " + message.what);
            }
            int i16 = message.arg1;
            if (message.arg2 != 1) {
                z16 = false;
            }
            dialogBaseActivity.doShowProgressDialog(i16, z16);
        }
    }

    public DialogBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean dismissProgressDialog() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.mUiHandler.hasMessages(1)) {
            this.mUiHandler.removeMessages(1);
            z16 = true;
        } else {
            z16 = false;
        }
        QQProgressDialog qQProgressDialog = this.progressDialog;
        if (qQProgressDialog != null) {
            qQProgressDialog.cancel();
            this.progressDialog.setOnDismissListener(null);
            this.progressDialog = null;
            return true;
        }
        return z16;
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
        this.mUiHandler = new e(this);
        this.mPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class);
        return true;
    }

    void doShowProgressDialog(int i3, boolean z16) {
        if (!isFinishing() && this.progressDialog == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
            this.progressDialog = qQProgressDialog;
            qQProgressDialog.setOnDismissListener(new d());
            this.progressDialog.setMessage(i3);
            this.progressDialog.setCancelable(z16);
            this.progressDialog.setCanceledOnTouchOutside(false);
            this.progressDialog.show();
        }
    }

    @Override // android.app.Activity
    public View findViewById(int i3) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        View view2 = this.mContentView;
        if (view2 != null) {
            view = view2.findViewById(i3);
        } else {
            view = null;
        }
        if (view == null) {
            return super.findViewById(i3);
        }
        return view;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mContentView = setContentViewB(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public String setLastActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSuperContentView(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            super.setContentView(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showConfirmFinish(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else if (!isFinishing()) {
            DialogUtil.createCustomDialog(this, 231, str, str2, new a(), null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showConfirmSkipDialog(boolean z16) {
        int i3;
        int i16;
        if (!isFinishing()) {
            ReportController.o(this.app, "dc00898", "", "", "0X8006AA4", "0X8006AA4", 0, 0, "", "", "", "");
            String string = getResources().getString(R.string.crp);
            if (z16) {
                i3 = R.string.f171876ll4;
            } else {
                i3 = R.string.f171875ll3;
            }
            String qqStr = HardCodeUtil.qqStr(i3);
            if (z16) {
                i16 = R.string.ll7;
            } else {
                i16 = R.string.ll5;
            }
            DialogUtil.createCustomDialog(this, 230, qqStr, string, HardCodeUtil.qqStr(R.string.ll6), HardCodeUtil.qqStr(i16), new b(z16), new c(z16)).show();
        }
    }

    protected void showFetalAndFinish(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else if (!isFinishing()) {
            showToast(i3);
            this.mUiHandler.sendEmptyMessageDelayed(2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showProgressDialog(int i3, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            this.mUiHandler.sendMessageDelayed(this.mUiHandler.obtainMessage(1, i3, z16 ? 1 : 0), j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            showToast(getResources().getString(i3));
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            showToast(0, str);
        } else {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showToast(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) str);
        } else {
            if (isFinishing()) {
                return;
            }
            QQToast.makeText(this, i3, str, 0).show(getTitleBarHeight());
        }
    }
}
