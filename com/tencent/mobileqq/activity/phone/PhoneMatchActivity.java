package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.a;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class PhoneMatchActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private Button f183907a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f183908b0;

    /* renamed from: c0, reason: collision with root package name */
    private QUIEmptyState f183909c0;

    public PhoneMatchActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void G2(View view, String str, String str2, String str3) {
        if (this.f183909c0 == null && (view instanceof LinearLayout)) {
            QUIEmptyState build = new QUIEmptyState.Builder(getActivity()).setImageType(7).setTitle(str).setBackgroundColorType(0).setDesc(str2).setButton(str3, this).build();
            this.f183909c0 = build;
            build.setVisibility(0);
            this.f183909c0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            ((LinearLayout) view).addView(this.f183909c0);
        }
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 9999) {
            if (QLog.isColorLevel()) {
                QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
            }
            if (((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true)) {
                ContactBindedActivity.U2(this.app, -1, 2, null);
                setResult(-1);
                finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168021p7);
        PhoneContactUtils.b(this.app, getResources(), (ImageView) findViewById(R.id.f164890b83));
        findViewById(R.id.f164890b83).setVisibility(8);
        View findViewById = findViewById(R.id.e2a);
        if (findViewById != null && "1000".equals(ThemeUtil.curThemeId)) {
            findViewById.setBackgroundResource(R.drawable.f160540jm);
        } else if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.bg_texture);
        }
        this.centerView.setText(HardCodeUtil.qqStr(R.string.f172282p30));
        this.f183908b0 = getIntent().getIntExtra("kSrouce", -1);
        com.tencent.mobileqq.newfriend.config.a loadNewFriendContactGuideConfig = ((INewFriendApi) QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
        if (PermissionChecker.h().g()) {
            a.C8157a c8157a = loadNewFriendContactGuideConfig.f254000d;
            str = c8157a.f254005a;
            str2 = c8157a.f254006b;
            str3 = c8157a.f254007c;
        } else {
            a.C8157a c8157a2 = loadNewFriendContactGuideConfig.f253999c;
            str = c8157a2.f254005a;
            str2 = c8157a2.f254006b;
            str3 = c8157a2.f254007c;
        }
        TextView textView = (TextView) findViewById(R.id.b85);
        textView.setText(str);
        textView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R.id.f164891b84);
        textView2.setText(str2);
        textView2.setVisibility(8);
        Button button = (Button) findViewById(R.id.f164889b82);
        this.f183907a0 = button;
        button.setOnClickListener(this);
        this.f183907a0.setText(str3);
        this.f183907a0.setVisibility(8);
        G2(findViewById, str, str2, str3);
        if (this.f183908b0 == 14) {
            setLeftViewName(R.string.f170549u3);
        } else {
            setLeftButton("", (View.OnClickListener) null);
            this.leftViewNotBack.setVisibility(8);
            setRightButton(R.string.close, this);
        }
        ReportController.o(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneMatchActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneMatchActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    PermissionChecker.h().f();
                }
            }
        }, 16, null, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnDestroy();
            PermissionChecker.h().i();
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
        if (this.f183908b0 != 14) {
            overridePendingTransition(0, R.anim.f154423k);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view.getId() == R.id.uuk) {
            if (!NetworkUtil.isNetSupport(this)) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.cjm, 0).show(getTitleBarHeight());
            } else {
                if (QLog.isColorLevel()) {
                    QLog.i("IphoneTitleBarActivity", 2, "clickMatch state: " + this.mPhoneContactService.getSelfBindState());
                }
                ReportController.o(this.app, "dc00898", "", "", "0X80095ED", "0X80095ED", 0, 0, "", "", "", "");
                PermissionChecker.e(this, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneMatchActivity.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneMatchActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.PhoneMatchActivity.2.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                IPhoneContactService iPhoneContactService = (IPhoneContactService) PhoneMatchActivity.this.app.getRuntimeService(IPhoneContactService.class, "");
                                iPhoneContactService.uploadOrUpdateContact();
                                iPhoneContactService.setNeedUploadResultTip(true);
                            }
                        }, 16, null, false);
                        if (PhoneMatchActivity.this.getIntent().getBooleanExtra("key_from_Tab", false)) {
                            ReportController.o(PhoneMatchActivity.this.app, "CliOper", "", "", "0X80053DE", "0X80053DE", 0, 0, "", "", "", "");
                        }
                        if (PhoneMatchActivity.this.getIntent().getBooleanExtra("key_from_l_w", false)) {
                            QQAppInterface qQAppInterface = PhoneMatchActivity.this.app;
                            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800650C", "0X800650C", 2, 0, qQAppInterface.getCurrentUin(), "", "", "");
                        }
                        ReportController.o(PhoneMatchActivity.this.app, "dc00898", "", "", "0X800689C", "0X800689C", 0, 0, "", "", "", "");
                        ContactBindedActivity.U2(PhoneMatchActivity.this.app, PhoneMatchActivity.this.getIntent().getIntExtra("kSrouce", 0), 2, null);
                        PhoneMatchActivity.this.finish();
                    }
                }, new DenyRunnable(this, new DenyRunnable.a(this.app)));
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

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        QUIEmptyState qUIEmptyState = this.f183909c0;
        if (qUIEmptyState == null) {
            return;
        }
        qUIEmptyState.setImageView(0, 1, false);
    }
}
