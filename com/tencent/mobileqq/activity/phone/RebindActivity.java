package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RebindActivity extends DialogBaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f183913a0;

    /* renamed from: b0, reason: collision with root package name */
    private Button f183914b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f183915c0;

    /* renamed from: d0, reason: collision with root package name */
    private String f183916d0;

    /* renamed from: e0, reason: collision with root package name */
    String f183917e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f183918f0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f183919g0;

    /* renamed from: h0, reason: collision with root package name */
    int f183920h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f183921i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f183922j0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RebindActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onRebindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            RebindActivity.this.dismissProgressDialog();
            if (z16) {
                Intent intent = new Intent(RebindActivity.this, (Class<?>) BindVerifyActivity.class);
                intent.putExtra("kSrouce", RebindActivity.this.f183920h0);
                intent.putExtra("k_number", RebindActivity.this.f183917e0);
                intent.putExtra("kBindType", RebindActivity.this.f183918f0);
                intent.putExtra("keyReqBindMode", 1);
                intent.putExtra("k_country_code", RebindActivity.this.f183916d0);
                intent.putExtra("cmd_param_is_from_uni", RebindActivity.this.f183921i0);
                intent.putExtra("cmd_param_is_from_change_bind", RebindActivity.this.f183922j0);
                intent.addFlags(67108864);
                intent.putExtra("k_is_block", RebindActivity.this.getIntent().getBooleanExtra("k_is_block", false));
                intent.putExtra("key_is_from_qqhotspot", RebindActivity.this.getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
                intent.putExtra("key_is_from_qav_multi_call", RebindActivity.this.getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
                RebindActivity.this.startActivityForResult(intent, 1);
                return;
            }
            RebindActivity.this.showToast(R.string.h1y);
        }
    }

    public RebindActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183918f0 = 0;
        this.f183921i0 = false;
        this.f183922j0 = false;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        if (i3 == 1 && i16 != 0) {
            setResult(i16);
            finish();
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
        setContentView(R.layout.f168370u7);
        this.f183921i0 = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
        this.f183922j0 = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
        this.f183920h0 = getIntent().getIntExtra("kSrouce", -1);
        this.f183916d0 = getIntent().getStringExtra("k_country_code");
        this.f183917e0 = getIntent().getStringExtra("k_number");
        this.f183918f0 = getIntent().getIntExtra("kBindType", 0);
        setTitle(HardCodeUtil.qqStr(R.string.sti));
        this.f183913a0 = (TextView) findViewById(R.id.fma);
        String str = this.f183916d0 + " " + this.f183917e0;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-31676);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getResources().getString(R.string.f171165ct3, str, getIntent().getStringExtra(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN), this.app.getCurrentAccountUin()));
        spannableStringBuilder.setSpan(foregroundColorSpan, 4, str.length() + 4, 33);
        this.f183913a0.setText(spannableStringBuilder);
        Button button = (Button) findViewById(R.id.fm_);
        this.f183914b0 = button;
        button.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.fm9);
        this.f183915c0 = button2;
        button2.setOnClickListener(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.f183919g0;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.f183919g0 = null;
        }
        super.doOnDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else if (view == this.f183914b0) {
            if (!NetworkUtil.isNetSupport(this)) {
                showToast(R.string.cjm);
            } else {
                if (this.f183919g0 == null) {
                    a aVar = new a();
                    this.f183919g0 = aVar;
                    this.app.registObserver(aVar);
                }
                this.mPhoneContactService.sendRebindMobile(this.f183916d0, this.f183917e0, this.f183918f0, this.f183921i0, this.f183922j0);
                showProgressDialog(R.string.hex, 1000L, true);
            }
        } else if (view == this.f183915c0) {
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
