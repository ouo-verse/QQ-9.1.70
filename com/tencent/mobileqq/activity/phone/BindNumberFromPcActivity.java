package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes10.dex */
public class BindNumberFromPcActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f183759a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f183760b0;

    /* renamed from: c0, reason: collision with root package name */
    Button f183761c0;

    /* renamed from: d0, reason: collision with root package name */
    private Button f183762d0;

    /* renamed from: e0, reason: collision with root package name */
    String f183763e0;

    /* renamed from: f0, reason: collision with root package name */
    String f183764f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f183765g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f183766h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f183767i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f183768j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindNumberFromPcActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onBindMobile(boolean z16, Bundle bundle) {
            Intent intent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            BindNumberFromPcActivity.this.f183761c0.setEnabled(true);
            BindNumberFromPcActivity.this.dismissProgressDialog();
            if (z16) {
                int i3 = bundle.getInt(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT);
                if (i3 != 104 && i3 != 0) {
                    if (i3 == 107) {
                        intent = new Intent(BindNumberFromPcActivity.this, (Class<?>) RebindActivity.class);
                        intent.putExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN, bundle.getString(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN));
                        intent.putExtra("k_number", BindNumberFromPcActivity.this.f183763e0);
                        intent.putExtra("k_country_code", BindNumberFromPcActivity.this.f183764f0);
                    } else {
                        if (i3 == 106) {
                            BindNumberFromPcActivity.this.setResult(-1);
                            BindNumberFromPcActivity.this.finish();
                        } else {
                            BindNumberFromPcActivity.this.showToast(getBindErrorMessage(i3));
                        }
                        intent = null;
                    }
                } else {
                    intent = new Intent(BindNumberFromPcActivity.this, (Class<?>) BindVerifyActivity.class);
                    intent.putExtra("k_number", BindNumberFromPcActivity.this.f183763e0);
                    intent.putExtra("k_country_code", BindNumberFromPcActivity.this.f183764f0);
                }
                if (intent != null && !BindNumberFromPcActivity.this.isFinishing()) {
                    intent.addFlags(536870912);
                    BindNumberFromPcActivity.this.startActivityForResult(intent, 1);
                }
            } else {
                BindNumberFromPcActivity.this.showToast(R.string.h1y);
            }
            BindNumberFromPcActivity bindNumberFromPcActivity = BindNumberFromPcActivity.this;
            bindNumberFromPcActivity.app.unRegistObserver(bindNumberFromPcActivity.f183766h0);
            BindNumberFromPcActivity.this.f183766h0 = null;
        }
    }

    public BindNumberFromPcActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void I2() {
        Intent intent = new Intent(this, (Class<?>) BindNumberActivity.class);
        intent.putExtra("key_change_number", true);
        startActivityForResult(intent, 1);
    }

    private void J2() {
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        if (this.f183766h0 == null) {
            a aVar = new a();
            this.f183766h0 = aVar;
            this.app.registObserver(aVar);
        }
        this.f183761c0.setEnabled(false);
        this.mPhoneContactService.sendBindMobile(this.f183764f0, this.f183763e0);
        showProgressDialog(R.string.hex, 1000L, true);
    }

    private void initViews() {
        setTitle(HardCodeUtil.qqStr(R.string.k1q));
        if (this.f183768j0) {
            setLeftButton(R.string.close, (View.OnClickListener) null);
        }
        this.f183759a0 = (TextView) findViewById(R.id.fme);
        int length = this.f183763e0.length();
        String str = this.f183763e0.substring(0, length - 5) + "****" + this.f183763e0.substring(length - 1);
        this.f183759a0.setText(this.f183764f0 + " " + str);
        TextView textView = (TextView) findViewById(R.id.fmd);
        this.f183760b0 = textView;
        textView.setText(getResources().getString(R.string.crr, this.f183765g0));
        Button button = (Button) findViewById(R.id.fmc);
        this.f183761c0 = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.fmb);
        this.f183762d0 = button2;
        button2.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.finish();
        if (this.f183768j0) {
            overridePendingTransition(R.anim.f154442w, R.anim.f155032h8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 1 && i16 != 0) {
            setResult(i16);
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.fmc) {
                J2();
            } else if (id5 == R.id.fmb) {
                I2();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        setContentView(R.layout.f168361tw);
        int selfBindState = this.mPhoneContactService.getSelfBindState();
        RespondQueryQQBindingStat selfBindInfo = this.mPhoneContactService.getSelfBindInfo();
        if (selfBindState == 5 && selfBindInfo != null) {
            this.f183764f0 = selfBindInfo.nationCode;
            this.f183763e0 = selfBindInfo.mobileNo;
            this.f183765g0 = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(selfBindInfo.bindingTime * 1000));
            this.f183768j0 = getIntent().getBooleanExtra("key_is_first_activity", true);
            initViews();
            return;
        }
        showConfirmFinish(HardCodeUtil.qqStr(R.string.k1p), HardCodeUtil.qqStr(R.string.k1s));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.f183766h0;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.f183766h0 = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar2 = this.f183767i0;
        if (bVar2 != null) {
            this.app.unRegistObserver(bVar2);
            this.f183767i0 = null;
        }
        super.onDestroy();
    }
}
