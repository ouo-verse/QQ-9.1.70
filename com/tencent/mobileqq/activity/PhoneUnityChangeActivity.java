package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* loaded from: classes9.dex */
public class PhoneUnityChangeActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    public com.tencent.mobileqq.phonecontact.observer.b f176609a0;

    /* renamed from: b0, reason: collision with root package name */
    public com.tencent.mobileqq.phonecontact.observer.b f176610b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f176611c0;

    /* renamed from: d0, reason: collision with root package name */
    public IPhoneContactService f176612d0;

    /* renamed from: e0, reason: collision with root package name */
    public QQCustomDialog f176613e0;

    /* renamed from: f0, reason: collision with root package name */
    public ActionSheet f176614f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f176615g0;

    /* renamed from: h0, reason: collision with root package name */
    public Button f176616h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: com.tencent.mobileqq.activity.PhoneUnityChangeActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        class DialogInterfaceOnClickListenerC7107a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC7107a() {
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

        /* loaded from: classes9.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: com.tencent.mobileqq.activity.PhoneUnityChangeActivity$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes9.dex */
            class C7108a extends com.tencent.mobileqq.phonecontact.observer.b {
                static IPatchRedirector $redirector_;

                C7108a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.mobileqq.phonecontact.observer.b
                public void onCancelBind(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    super.onCancelBind(z16);
                    PhoneUnityChangeActivity.this.dismissProgressDialog();
                    PhoneUnityChangeActivity.this.app.unRegistObserver(this);
                    if (z16) {
                        ((PhoneUnityManager) PhoneUnityChangeActivity.this.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER)).j(null);
                        PhoneUnityChangeActivity.this.setResult(4001);
                        PhoneUnityChangeActivity.this.finish();
                    }
                }
            }

            b() {
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
                    return;
                }
                dialogInterface.dismiss();
                if (!NetworkUtil.isNetSupport(PhoneUnityChangeActivity.this)) {
                    PhoneUnityChangeActivity.this.showToast(R.string.cjm);
                    return;
                }
                PhoneUnityChangeActivity phoneUnityChangeActivity = PhoneUnityChangeActivity.this;
                if (phoneUnityChangeActivity.f176610b0 == null) {
                    phoneUnityChangeActivity.f176610b0 = new C7108a();
                    PhoneUnityChangeActivity phoneUnityChangeActivity2 = PhoneUnityChangeActivity.this;
                    phoneUnityChangeActivity2.app.registObserver(phoneUnityChangeActivity2.f176610b0);
                }
                ((DialogBaseActivity) PhoneUnityChangeActivity.this).mPhoneContactService.unbindMobile(true, false);
                PhoneUnityChangeActivity.this.showProgressDialog(R.string.hex, 0L, true);
                ReportController.o(PhoneUnityChangeActivity.this.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
            }
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneUnityChangeActivity.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            PhoneUnityChangeActivity.this.f176614f0.cancel();
            PhoneUnityChangeActivity phoneUnityChangeActivity = PhoneUnityChangeActivity.this;
            if (phoneUnityChangeActivity.f176613e0 == null) {
                phoneUnityChangeActivity.f176613e0 = DialogUtil.createCustomDialog(phoneUnityChangeActivity, 230, HardCodeUtil.qqStr(R.string.p3q), HardCodeUtil.qqStr(R.string.p3g), HardCodeUtil.qqStr(R.string.f172285p35), HardCodeUtil.qqStr(R.string.j6l), new DialogInterfaceOnClickListenerC7107a(), new b());
            }
            QQCustomDialog qQCustomDialog = PhoneUnityChangeActivity.this.f176613e0;
            if (qQCustomDialog != null && !qQCustomDialog.isShowing() && !PhoneUnityChangeActivity.this.isFinishing()) {
                PhoneUnityChangeActivity.this.f176613e0.show();
            }
        }
    }

    public PhoneUnityChangeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f176614f0 == null) {
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            this.f176614f0 = actionSheet;
            actionSheet.setCanceledOnTouchOutside(true);
            this.f176614f0.addButton(HardCodeUtil.qqStr(R.string.p3a), 3);
            this.f176614f0.addCancelButton(R.string.cancel);
            this.f176614f0.setOnButtonClickListener(new a());
            this.f176614f0.addCancelButton(R.string.cancel);
        }
        if (!this.f176614f0.isShowing() && !isFinishing()) {
            this.f176614f0.show();
        }
    }

    public boolean L2() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        int selfBindState = iPhoneContactService.getSelfBindState();
        RespondQueryQQBindingStat selfBindInfo = iPhoneContactService.getSelfBindInfo();
        if (1 != selfBindState && 5 != selfBindState) {
            try {
                this.f176611c0 = "" + selfBindInfo.mobileNo;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("PhoneUnityChangeActivity", 2, "" + selfBindState, e16);
                }
            }
        }
        if (TextUtils.isEmpty(this.f176611c0)) {
            super.finish();
            return false;
        }
        super.setTitle(HardCodeUtil.qqStr(R.string.p3l));
        ((TextView) findViewById(R.id.k6_)).setText("\u66f4\u6362\u624b\u673a\u53f7\u7801#name#\uff0c\n\u5c06\u66f4\u65b0\u4ee5\u4e0b\u529f\u80fd\u3002".replace("#name#", PhoneUnityManager.b(this.f176611c0)));
        Button button = (Button) findViewById(R.id.afy);
        this.f176616h0 = button;
        button.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        imageView.setVisibility(0);
        if (AppSetting.f99565y) {
            imageView.setContentDescription(getString(R.string.cs8));
        }
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
            i3 = R.drawable.header_btn_more;
        } else {
            i3 = R.drawable.a65;
        }
        imageView.setImageResource(i3);
        imageView.setOnClickListener(this);
        return true;
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 1001 && i16 == -1) {
            super.setResult(i16);
            super.finish();
        } else {
            L2();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (getIntent() == null) {
            super.finish();
            return true;
        }
        super.setContentView(R.layout.f168371u8);
        this.f176612d0 = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        this.f176615g0 = getIntent().getIntExtra("kSrouce", -1);
        if (!L2()) {
            super.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.f176609a0;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.f176609a0 = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar2 = this.f176610b0;
        if (bVar2 != null) {
            this.app.unRegistObserver(bVar2);
            this.f176610b0 = null;
        }
        QQCustomDialog qQCustomDialog = this.f176613e0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f176613e0 = null;
        }
        ActionSheet actionSheet = this.f176614f0;
        if (actionSheet != null) {
            actionSheet.dismiss();
            this.f176614f0 = null;
        }
        this.app.removeHandler(PhoneUnityChangeActivity.class);
        super.doOnDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnRightImage) {
                K2();
            } else if (id5 == R.id.afy) {
                if (!NetworkUtil.isNetSupport(this)) {
                    showToast(R.string.cjm);
                } else {
                    Intent intent = new Intent(this, (Class<?>) BindNumberActivity.class);
                    intent.putExtra("kNeedUnbind", true);
                    intent.putExtra("cmd_param_is_from_uni", true);
                    intent.putExtra("cmd_param_is_from_change_bind", true);
                    int i3 = this.f176615g0;
                    if (i3 == -1) {
                        i3 = 1;
                    }
                    intent.putExtra("kSrouce", i3);
                    intent.putExtra("kFPhoneChange", true);
                    startActivityForResult(intent, 1001);
                    ReportController.o(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
                    com.tencent.mobileqq.utils.ac.y0(1);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
