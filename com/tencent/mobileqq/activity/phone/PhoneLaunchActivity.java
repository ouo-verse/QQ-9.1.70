package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class PhoneLaunchActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private Button f183897a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f183898b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f183899c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f183900d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f183901e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f183902f0;

    /* renamed from: g0, reason: collision with root package name */
    public com.tencent.mobileqq.phonecontact.observer.b f183903g0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements DenyRunnable.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhoneLaunchActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.phone.DenyRunnable.b
        public void onCancel(Context context, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
                return;
            }
            PhoneLaunchActivity.this.f183897a0.setEnabled(true);
            if (!z16 && context != null) {
                Intent intent = new Intent(context, (Class<?>) GuideBindPhoneActivity.class);
                intent.putExtra("fromKeyForContactBind", 2);
                context.startActivity(intent);
            }
        }
    }

    public PhoneLaunchActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183898b0 = false;
        this.f183899c0 = false;
        this.f183900d0 = false;
        this.f183901e0 = false;
        this.f183902f0 = false;
    }

    private void L2() {
        ac.y0(2);
        Intent intent = new Intent(this, (Class<?>) BindNumberActivity.class);
        if (getIntent().getIntExtra("kSrouce", -1) == 8) {
            intent.putExtra("kSrouce", 8);
        }
        startActivityForResult(intent, 1);
    }

    public void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            PermissionChecker.e(this, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1
                static IPatchRedirector $redirector_;

                /* renamed from: com.tencent.mobileqq.activity.phone.PhoneLaunchActivity$1$a */
                /* loaded from: classes10.dex */
                class a extends com.tencent.mobileqq.phonecontact.observer.b {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.phonecontact.observer.b
                    protected void onUploadContact(boolean z16, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                            return;
                        }
                        PhoneLaunchActivity.this.f183897a0.setEnabled(true);
                        PhoneLaunchActivity phoneLaunchActivity = PhoneLaunchActivity.this;
                        com.tencent.mobileqq.phonecontact.observer.b bVar = phoneLaunchActivity.f183903g0;
                        if (bVar != null) {
                            phoneLaunchActivity.app.unRegistObserver(bVar);
                            PhoneLaunchActivity.this.f183903g0 = null;
                        }
                        PhoneLaunchActivity.this.dismissProgressDialog();
                        if (z16) {
                            PhoneLaunchActivity phoneLaunchActivity2 = PhoneLaunchActivity.this;
                            if (!phoneLaunchActivity2.f183901e0 && !PhoneLaunchActivity.this.f183902f0) {
                                Intent intent = new Intent(phoneLaunchActivity2, (Class<?>) SettingActivity2.class);
                                if (PhoneLaunchActivity.this.f183900d0) {
                                    intent.putExtra("kSrouce", 7);
                                }
                                PhoneLaunchActivity.this.startActivityForResult(intent, 2);
                                PhoneLaunchActivity.this.setResult(-1);
                                PhoneLaunchActivity.this.finish();
                                return;
                            }
                            PhoneLaunchActivity.this.setResult(-1);
                            PhoneLaunchActivity.this.finish();
                            return;
                        }
                        PhoneLaunchActivity.this.showToast(HardCodeUtil.qqStr(R.string.p2x));
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneLaunchActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!NetworkUtil.isNetSupport(PhoneLaunchActivity.this)) {
                        PhoneLaunchActivity.this.showToast(R.string.cjm);
                        PhoneLaunchActivity.this.f183897a0.setEnabled(true);
                        return;
                    }
                    PhoneLaunchActivity phoneLaunchActivity = PhoneLaunchActivity.this;
                    if (phoneLaunchActivity.f183903g0 == null) {
                        phoneLaunchActivity.f183903g0 = new a();
                        PhoneLaunchActivity phoneLaunchActivity2 = PhoneLaunchActivity.this;
                        phoneLaunchActivity2.app.registObserver(phoneLaunchActivity2.f183903g0);
                    }
                    PhoneLaunchActivity.this.app.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneLaunchActivity.1.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                PhoneLaunchActivity.this.mPhoneContactService.uploadPhoneContact();
                            }
                        }
                    });
                    PhoneLaunchActivity.this.showProgressDialog(R.string.hex, 1000L, true);
                }
            }, new DenyRunnable(this, new a()));
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1) {
            if (i16 != 0) {
                setResult(i16, intent);
                finish();
                return;
            }
            return;
        }
        if (i16 == 2 && this.f183898b0 && this.mPhoneContactService.isBindContactOk()) {
            finish();
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        super.doOnCreate(bundle);
        boolean hasExtra = getIntent().hasExtra("needAlert");
        this.f183898b0 = getIntent().getBooleanExtra("fromStopAndMatch", false);
        this.f183899c0 = getIntent().getBooleanExtra("fromCall", false);
        this.f183900d0 = getIntent().getBooleanExtra("fromPermiPriv", false);
        this.f183901e0 = getIntent().getBooleanExtra("fromAVCallInvite", false);
        this.f183902f0 = getIntent().getBooleanExtra("returnAndFinish", false);
        if (!hasExtra && bundle == null) {
            finish();
            return false;
        }
        if (!this.f183898b0) {
            if (getIntent().getStringExtra(AppConstants.LeftViewText.LEFTVIEWTEXT) == null) {
                getIntent().putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.p2t));
            }
        } else {
            getIntent().putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.p2v));
        }
        setContentView(R.layout.f168369u6);
        setTitle(HardCodeUtil.qqStr(R.string.p2p));
        Button button = (Button) findViewById(R.id.phone_enable_btn);
        this.f183897a0 = button;
        button.setOnClickListener(this);
        if (getIntent().getBooleanExtra("k_start_number", false)) {
            L2();
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.finish();
        if (!this.f183898b0) {
            overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view == this.f183897a0) {
            int selfBindState = this.mPhoneContactService.getSelfBindState();
            if (selfBindState != 1 && selfBindState != 2 && selfBindState != 3 && selfBindState != 4) {
                if (selfBindState == 5) {
                    Intent intent = new Intent(this, (Class<?>) BindNumberFromPcActivity.class);
                    intent.putExtra("key_is_first_activity", false);
                    startActivityForResult(intent, 1);
                } else if (selfBindState == 7) {
                    this.f183897a0.setEnabled(false);
                    K2();
                } else {
                    showConfirmFinish(HardCodeUtil.qqStr(R.string.p2r), HardCodeUtil.qqStr(R.string.p2q));
                }
            } else {
                L2();
            }
            if (this.f183901e0) {
                ReportController.o(this.app, "CliOper", "", "", "0X8005D10", "0X8005D10", 0, 0, "", "", "", "");
            }
        } else {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
