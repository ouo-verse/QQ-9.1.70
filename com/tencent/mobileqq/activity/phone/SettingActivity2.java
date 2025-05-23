package com.tencent.mobileqq.activity.phone;

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
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.a;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SettingActivity2 extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f183924a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f183925b0;

    /* renamed from: c0, reason: collision with root package name */
    public com.tencent.mobileqq.phonecontact.observer.b f183926c0;

    /* renamed from: d0, reason: collision with root package name */
    public com.tencent.mobileqq.phonecontact.observer.b f183927d0;

    /* renamed from: e0, reason: collision with root package name */
    public com.tencent.mobileqq.phonecontact.observer.b f183928e0;

    /* renamed from: f0, reason: collision with root package name */
    public Button f183929f0;

    /* renamed from: g0, reason: collision with root package name */
    public Button f183930g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f183931h0;

    /* renamed from: i0, reason: collision with root package name */
    public int f183932i0;

    /* renamed from: j0, reason: collision with root package name */
    public Boolean f183933j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f183936d;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.phone.SettingActivity2$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        class DialogInterfaceOnClickListenerC7185a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            DialogInterfaceOnClickListenerC7185a() {
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

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.phone.SettingActivity2$a$b$a, reason: collision with other inner class name */
            /* loaded from: classes10.dex */
            class C7186a extends com.tencent.mobileqq.phonecontact.observer.b {
                static IPatchRedirector $redirector_;

                C7186a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                    }
                }

                @Override // com.tencent.mobileqq.phonecontact.observer.b
                protected void onDisableMobileMatch(boolean z16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, z16);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("SettingActivity2", 2, "onDisableMobileMatch suc[" + z16 + "]");
                    }
                    SettingActivity2.this.dismissProgressDialog();
                    SettingActivity2.this.app.unRegistObserver(this);
                    if (z16) {
                        SettingActivity2.this.I2();
                        SettingActivity2.this.setResult(-1);
                    } else {
                        SettingActivity2.this.showToast(1, HardCodeUtil.qqStr(R.string.tbz));
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
                SettingActivity2 settingActivity2 = SettingActivity2.this;
                int i16 = settingActivity2.f183931h0;
                if (i16 == 2) {
                    settingActivity2.report("0X8005B8A", 1);
                } else if (i16 == 6) {
                    settingActivity2.report("0X8005B8A", 2);
                } else if (i16 == 7) {
                    settingActivity2.report("0X8005B8A", 3);
                }
                dialogInterface.dismiss();
                if (!NetworkUtil.isNetSupport(SettingActivity2.this)) {
                    SettingActivity2.this.showToast(R.string.cjm);
                    return;
                }
                RespondQueryQQBindingStat selfBindInfo = SettingActivity2.this.mPhoneContactService.getSelfBindInfo();
                if (selfBindInfo != null && selfBindInfo.nationCode != null && selfBindInfo.mobileNo != null) {
                    SettingActivity2 settingActivity22 = SettingActivity2.this;
                    if (settingActivity22.f183927d0 == null) {
                        settingActivity22.f183927d0 = new C7186a();
                        SettingActivity2 settingActivity23 = SettingActivity2.this;
                        settingActivity23.app.registObserver(settingActivity23.f183927d0);
                    }
                    SettingActivity2.this.mPhoneContactService.disableMobileMatch(selfBindInfo.nationCode, selfBindInfo.mobileNo);
                    SettingActivity2.this.showProgressDialog(R.string.hex, 300L, true);
                    return;
                }
                SettingActivity2.this.setResult(0);
                SettingActivity2.this.finish();
            }
        }

        a(ActionSheet actionSheet) {
            this.f183936d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SettingActivity2.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else {
                this.f183936d.cancel();
                DialogUtil.createCustomDialog(SettingActivity2.this, 230, HardCodeUtil.qqStr(R.string.f172685tc0), HardCodeUtil.qqStr(R.string.tbx), HardCodeUtil.qqStr(R.string.tby), HardCodeUtil.qqStr(R.string.j6l), new DialogInterfaceOnClickListenerC7185a(), new b()).show();
            }
        }
    }

    public SettingActivity2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183931h0 = -1;
        this.f183932i0 = 0;
        this.f183933j0 = null;
    }

    public void G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
        } else {
            PermissionChecker.e(this, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.SettingActivity2.3
                static IPatchRedirector $redirector_;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.activity.phone.SettingActivity2$3$a */
                /* loaded from: classes10.dex */
                class a extends com.tencent.mobileqq.phonecontact.observer.b {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.phonecontact.observer.b
                    protected void onUploadContact(boolean z16, int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                            return;
                        }
                        SettingActivity2 settingActivity2 = SettingActivity2.this;
                        com.tencent.mobileqq.phonecontact.observer.b bVar = settingActivity2.f183928e0;
                        if (bVar != null) {
                            settingActivity2.app.unRegistObserver(bVar);
                            SettingActivity2.this.f183928e0 = null;
                        }
                        SettingActivity2.this.dismissProgressDialog();
                        if (z16) {
                            SettingActivity2 settingActivity22 = SettingActivity2.this;
                            com.tencent.mobileqq.phonecontact.observer.b bVar2 = settingActivity22.f183928e0;
                            if (bVar2 != null) {
                                settingActivity22.app.unRegistObserver(bVar2);
                                SettingActivity2.this.f183928e0 = null;
                            }
                            SettingActivity2.this.I2();
                            SettingActivity2.this.setResult(-1);
                        }
                    }
                }

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SettingActivity2.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    SettingActivity2 settingActivity2 = SettingActivity2.this;
                    if (settingActivity2.f183928e0 == null) {
                        settingActivity2.f183928e0 = new a();
                        SettingActivity2 settingActivity22 = SettingActivity2.this;
                        settingActivity22.app.registObserver(settingActivity22.f183928e0);
                    }
                    SettingActivity2.this.app.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.SettingActivity2.3.2
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                SettingActivity2.this.mPhoneContactService.uploadPhoneContact();
                                SettingActivity2.this.mPhoneContactService.setNeedUploadResultTip(true);
                            }
                        }
                    });
                    SettingActivity2.this.showProgressDialog(R.string.hex, 1000L, true);
                }
            }, new DenyRunnable(this, new DenyRunnable.a(this.app)));
        }
    }

    public void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.setCanceledOnTouchOutside(true);
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.f172689tc4), 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new a(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    public void I2() {
        String str;
        String str2;
        String str3;
        String str4;
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int selfBindState = this.mPhoneContactService.getSelfBindState();
        boolean g16 = PermissionChecker.h().g();
        RespondQueryQQBindingStat selfBindInfo = this.mPhoneContactService.getSelfBindInfo();
        if (1 != selfBindState && 5 != selfBindState && selfBindInfo != null) {
            str = selfBindInfo.nationCode + " " + selfBindInfo.mobileNo;
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SettingActivity2", 2, "updateUIByState state[" + selfBindState + "], number[" + str + "], hasPermission[" + this.f183933j0 + "]");
        }
        if (!TextUtils.isEmpty(str) && selfBindState > 5) {
            if (selfBindState == this.f183932i0 && (bool = this.f183933j0) != null && bool.booleanValue() == g16) {
                return;
            }
            this.f183932i0 = selfBindState;
            this.f183933j0 = Boolean.valueOf(g16);
            setTitle(HardCodeUtil.qqStr(R.string.f172688tc3));
            this.f183924a0 = (TextView) findViewById(R.id.b85);
            this.f183925b0 = (TextView) findViewById(R.id.f164891b84);
            Button button = (Button) findViewById(R.id.ens);
            this.f183929f0 = button;
            button.setOnClickListener(this);
            Button button2 = (Button) findViewById(R.id.kw7);
            this.f183930g0 = button2;
            button2.setOnClickListener(this);
            if (selfBindState != 7 && selfBindState != 6) {
                this.f183930g0.setVisibility(0);
                this.f183929f0.setVisibility(8);
                this.f183924a0.setVisibility(8);
                this.f183925b0.setVisibility(8);
            } else {
                this.f183930g0.setVisibility(8);
                this.f183929f0.setVisibility(0);
                this.f183924a0.setVisibility(0);
                this.f183925b0.setVisibility(0);
                com.tencent.mobileqq.newfriend.config.a loadNewFriendContactGuideConfig = ((INewFriendApi) QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
                if (g16) {
                    a.C8157a c8157a = loadNewFriendContactGuideConfig.f254000d;
                    str2 = c8157a.f254005a;
                    str3 = c8157a.f254006b;
                    str4 = c8157a.f254007c;
                } else {
                    a.C8157a c8157a2 = loadNewFriendContactGuideConfig.f253999c;
                    str2 = c8157a2.f254005a;
                    str3 = c8157a2.f254006b;
                    str4 = c8157a2.f254007c;
                }
                this.f183924a0.setText(str2);
                this.f183925b0.setText(str3);
                this.f183929f0.setText(str4);
            }
            ImageView imageView = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
            if (selfBindState == 7) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
            if (AppSetting.f99565y) {
                imageView.setContentDescription(getString(R.string.cs7));
            }
            imageView.setBackgroundResource(R.drawable.header_btn_more);
            imageView.setOnClickListener(this);
            return;
        }
        finish();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 9999) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
            }
            if (((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true)) {
                ContactBindedActivity.V2(this.app, 222, this.mPhoneContactService.generateRandomList());
                return;
            } else {
                I2();
                return;
            }
        }
        I2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        Intent intent = super.getIntent();
        if (intent == null) {
            super.finish();
            return true;
        }
        this.f183931h0 = intent.getIntExtra("kSrouce", -1);
        super.setContentView(R.layout.u_);
        PhoneContactUtils.b(this.app, getResources(), (ImageView) findViewById(R.id.f164890b83));
        I2();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.f183926c0;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.f183926c0 = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar2 = this.f183927d0;
        if (bVar2 != null) {
            this.app.unRegistObserver(bVar2);
            this.f183927d0 = null;
        }
        this.app.removeHandler(SettingActivity2.class);
        super.doOnDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.SettingActivity2.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SettingActivity2.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean f16 = PermissionChecker.h().f();
                if (QLog.isColorLevel()) {
                    QLog.i("SettingActivity2", 2, "doOnResume : " + f16);
                }
            }
        }, 16, null, true);
        I2();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnRightImage) {
                H2();
            } else if (id5 == R.id.ens) {
                report("0X8005B89", 0);
                G2();
            } else if (id5 == R.id.kw7) {
                PermissionChecker.e(this, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.SettingActivity2.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SettingActivity2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SettingActivity2 settingActivity2 = SettingActivity2.this;
                        if (settingActivity2.f183931h0 == 6) {
                            settingActivity2.finish();
                        } else {
                            ContactBindedActivity.V2(SettingActivity2.this.app, 222, ((IPhoneContactService) settingActivity2.app.getRuntimeService(IPhoneContactService.class, "")).generateRandomList());
                        }
                    }
                }, new DenyRunnable(this, new DenyRunnable.a(this.app)));
            } else {
                throw new RuntimeException("unknown id: " + id5);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void report(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        } else {
            ReportController.o(this.app, "CliOper", "", "", str, str, i3, 0, "", "", "", "");
        }
    }
}
