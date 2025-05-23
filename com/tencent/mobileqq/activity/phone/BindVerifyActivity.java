package com.tencent.mobileqq.activity.phone;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.OnSizeChangeListener;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BindVerifyActivity extends DialogBaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Handler.Callback, TextWatcher, View.OnKeyListener, OnSizeChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private EditText f183770a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f183771b0;

    /* renamed from: c0, reason: collision with root package name */
    private Button f183772c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f183773d0;

    /* renamed from: e0, reason: collision with root package name */
    private com.tencent.mobileqq.phonecontact.observer.b f183774e0;

    /* renamed from: f0, reason: collision with root package name */
    private final Handler f183775f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f183776g0;

    /* renamed from: h0, reason: collision with root package name */
    private byte[] f183777h0;

    /* renamed from: i0, reason: collision with root package name */
    private String f183778i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f183779j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f183780k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f183781l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f183782m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f183783n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f183784o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f183785p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f183786q0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onBindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BindVerifyActivity", 2, "onBindMobile [" + z16 + ", " + bundle + "]");
            }
            BindVerifyActivity.this.dismissProgressDialog();
            if (z16) {
                int i3 = bundle.getInt(com.tencent.mobileqq.phonecontact.observer.b.KEY_RESULT);
                if (i3 != 104 && i3 != 0) {
                    if (i3 == 107) {
                        BindVerifyActivity.this.W2(bundle);
                    } else if (i3 == 106) {
                        BindVerifyActivity.this.onBindSuc();
                        if (BindVerifyActivity.this.getIntent().getBooleanExtra("k_is_block", false)) {
                            ReportController.o(BindVerifyActivity.this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 2, 0, "", "", "", "");
                        }
                    } else {
                        BindVerifyActivity.this.showToast(1, getBindErrorMessage(i3));
                    }
                } else {
                    BindVerifyActivity.this.Y2();
                }
            } else {
                BindVerifyActivity bindVerifyActivity = BindVerifyActivity.this;
                bindVerifyActivity.showToast(1, bindVerifyActivity.getString(R.string.h1y));
            }
            BindVerifyActivity bindVerifyActivity2 = BindVerifyActivity.this;
            bindVerifyActivity2.app.unRegistObserver(bindVerifyActivity2.f183774e0);
            BindVerifyActivity.this.f183774e0 = null;
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onRebindMobile(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BindVerifyActivity", 2, "onRebindMobile [" + z16 + ", " + bundle + "]");
            }
            BindVerifyActivity.this.dismissProgressDialog();
            if (z16) {
                BindVerifyActivity.this.Y2();
            } else {
                BindVerifyActivity bindVerifyActivity = BindVerifyActivity.this;
                bindVerifyActivity.showToast(1, bindVerifyActivity.getString(R.string.h1y));
            }
            BindVerifyActivity bindVerifyActivity2 = BindVerifyActivity.this;
            bindVerifyActivity2.app.unRegistObserver(bindVerifyActivity2.f183774e0);
            BindVerifyActivity.this.f183774e0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b extends com.tencent.mobileqq.phonecontact.observer.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.phonecontact.observer.b
        protected void onVerifyBindSms(boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("BindVerifyActivity", 2, "onVerifyBindSms [" + z16 + ", " + i3 + "]");
            }
            BindVerifyActivity.this.f183786q0 = false;
            BindVerifyActivity.this.f183775f0.removeMessages(4);
            BindVerifyActivity.this.dismissProgressDialog();
            if (!z16) {
                BindVerifyActivity.this.Z2("dc00898", "0X8009F19", 0);
                BindVerifyActivity bindVerifyActivity = BindVerifyActivity.this;
                bindVerifyActivity.showToast(1, bindVerifyActivity.getString(R.string.h1y));
            } else if (i3 != 0 && i3 != 106) {
                if (i3 == 213) {
                    BindVerifyActivity.this.Z2("dc00898", "0X8009F19", 0);
                    BindVerifyActivity.this.showToast(1, HardCodeUtil.qqStr(R.string.f171663k25));
                    BindVerifyActivity.this.f183770a0.setEnabled(true);
                } else {
                    BindVerifyActivity.this.Z2("dc00898", "0X8009F19", 0);
                    String qqStr = HardCodeUtil.qqStr(R.string.f171658k20);
                    if (i3 == 107) {
                        qqStr = HardCodeUtil.qqStr(R.string.f171660k22);
                    }
                    BindVerifyActivity.this.showConfirmFinish(HardCodeUtil.qqStr(R.string.k26), qqStr);
                }
            } else {
                BindVerifyActivity.this.onBindSuc();
            }
            BindVerifyActivity bindVerifyActivity2 = BindVerifyActivity.this;
            bindVerifyActivity2.app.unRegistObserver(bindVerifyActivity2.f183773d0);
            BindVerifyActivity.this.f183773d0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements DenyRunnable.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.phone.DenyRunnable.b
        public void onCancel(Context context, boolean z16) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(z16));
                return;
            }
            if (z16) {
                str = "permission_denied_by_user";
            } else {
                str = "permission_denied";
            }
            Intent intent = new Intent();
            intent.putExtra("bind_mobile", BindVerifyActivity.this.V2());
            intent.putExtra("check_permission_result", str);
            intent.putExtra("kSrouce", BindVerifyActivity.this.f183784o0);
            BindVerifyActivity.this.setResult(-1, intent);
            BindVerifyActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("BindVerifyActivity", 2, "new user guild confirm unbind");
            }
            BindVerifyActivity.this.S2();
            BindVerifyActivity.this.showProgressDialog(R.string.hex, 1000L, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
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
            BindVerifyActivity.this.setResult(0);
            BindVerifyActivity.this.finish();
        }
    }

    public BindVerifyActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f183775f0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f183780k0 = 0;
        this.f183781l0 = false;
        this.f183782m0 = false;
        this.f183783n0 = false;
        this.f183784o0 = -1;
        this.f183786q0 = false;
    }

    private void Q2() {
        if (this.f183785p0 == 1) {
            S2();
        } else if (this.f183783n0) {
            this.mPhoneContactService.sendBindMobileEncrypt(this.f183779j0, this.f183777h0, this.f183780k0, this.f183781l0, this.f183782m0);
        } else {
            this.mPhoneContactService.sendBindMobile(this.f183779j0, this.f183776g0, this.f183780k0, this.f183781l0, this.f183782m0);
        }
    }

    private void R2(String str) {
        b3();
        Z2("dc00898", "0X8009F18", 0);
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(R.string.cjm);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BindVerifyActivity", 2, "doCommit cur: " + this.f183786q0);
        }
        if (this.f183786q0) {
            return;
        }
        this.f183786q0 = true;
        if (this.f183773d0 == null) {
            b bVar = new b();
            this.f183773d0 = bVar;
            this.app.registObserver(bVar);
        }
        this.mPhoneContactService.sendVerifySmsCode(str, this.f183780k0, this.f183781l0, this.f183782m0);
        showProgressDialog(R.string.hex, 1000L, true);
        this.f183775f0.sendEmptyMessageDelayed(4, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2() {
        if (this.f183783n0) {
            this.mPhoneContactService.sendRebindMobileEncrypt(this.f183779j0, this.f183777h0, this.f183780k0, this.f183781l0, this.f183782m0);
        } else {
            this.mPhoneContactService.sendRebindMobile(this.f183779j0, this.f183776g0, this.f183780k0, this.f183781l0, this.f183782m0);
        }
    }

    private void T2(Intent intent) {
        String string;
        this.f183780k0 = intent.getIntExtra("kBindType", 0);
        this.f183776g0 = intent.getStringExtra("k_number");
        this.f183777h0 = intent.getByteArrayExtra("cmd_param_encrypt_mobile");
        this.f183778i0 = intent.getStringExtra("k_mask_number_forshow");
        this.f183779j0 = intent.getStringExtra("k_country_code");
        setLeftViewName(R.string.f170549u3);
        setTitle("");
        TextView textView = (TextView) findViewById(R.id.f166399f82);
        TextView textView2 = (TextView) findViewById(R.id.kng);
        this.f183772c0 = (Button) findViewById(R.id.send_btn);
        String V2 = V2();
        if (this.f183784o0 == 23) {
            string = getString(R.string.f174092ux, V2);
            textView.setText(R.string.f174102uy);
            textView2.setVisibility(0);
            this.f183772c0.setText(getResources().getString(R.string.f174052ut));
        } else {
            textView.setText(R.string.csr);
            string = getString(R.string.ctq, V2);
            textView2.setVisibility(8);
        }
        SpannableString spannableString = new SpannableString(string);
        int indexOf = string.indexOf(V2);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), indexOf, V2.length() + indexOf, 17);
        ((TextView) findViewById(R.id.f166397f80)).setText(spannableString);
        EditText editText = (EditText) findViewById(R.id.knb);
        this.f183770a0 = editText;
        editText.addTextChangedListener(this);
        this.f183770a0.setOnKeyListener(this);
        this.f183772c0.setOnClickListener(this);
        TextView textView3 = (TextView) findViewById(R.id.i8f);
        this.f183771b0 = textView3;
        textView3.setOnClickListener(this);
        Y2();
    }

    private void b3() {
        this.f183770a0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.BindVerifyActivity.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (!BindVerifyActivity.this.isFinishing()) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
                    BindVerifyActivity.this.f183770a0.dispatchTouchEvent(obtain);
                    obtain.recycle();
                    MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, 0.0f, 0.0f, 0);
                    BindVerifyActivity.this.f183770a0.dispatchTouchEvent(obtain2);
                    obtain2.recycle();
                    BindVerifyActivity.this.f183770a0.setSelection(BindVerifyActivity.this.U2().length());
                }
            }
        }, 300L);
    }

    public String U2() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        Editable text = this.f183770a0.getText();
        if (text == null) {
            str = "";
        } else {
            str = text.toString();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    protected String V2() {
        StringBuilder sb5;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.f183783n0) {
            sb5 = new StringBuilder();
            sb5.append(this.f183779j0);
            sb5.append(" ");
            str = this.f183778i0;
        } else {
            sb5 = new StringBuilder();
            sb5.append(this.f183779j0);
            sb5.append(" ");
            str = this.f183776g0;
        }
        sb5.append(str);
        return sb5.toString();
    }

    protected void W2(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bundle);
            return;
        }
        String string = bundle.getString(com.tencent.mobileqq.phonecontact.observer.b.KEY_UIN);
        String V2 = V2();
        String string2 = getResources().getString(R.string.f171166ct4, V2, string, this.app.getCurrentAccountUin());
        int indexOf = string2.indexOf(V2);
        SpannableString spannableString = new SpannableString(string2);
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 159, 64)), indexOf, V2.length() + indexOf, 17);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this, 230, (String) null, spannableString, getString(R.string.cancel), getString(R.string.f171151ok), new d(), new e());
        if (createCustomDialog != null && !createCustomDialog.isShowing() && !isFinishing()) {
            createCustomDialog.show();
        }
    }

    protected void Y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.f183786q0 = false;
        this.f183772c0.setEnabled(false);
        this.f183770a0.setText("");
        this.f183770a0.setHint(HardCodeUtil.qqStr(R.string.f171661k23));
        this.f183771b0.setText(HardCodeUtil.qqStr(R.string.k27));
        this.f183771b0.setEnabled(false);
        this.f183771b0.setTextColor(getResources().getColor(R.color.skin_gray2));
        this.f183775f0.removeMessages(1);
        Handler handler = this.f183775f0;
        handler.sendMessageDelayed(handler.obtainMessage(1, 60, 0), 1000L);
    }

    public void Z2(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, str, str2, Integer.valueOf(i3));
        } else {
            ReportController.o(this.app, str, "", "", str2, str2, i3, 0, "", "", "", "");
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) editable);
        } else if (editable.toString().length() > 0) {
            this.f183772c0.setEnabled(true);
        } else {
            this.f183772c0.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else {
            super.doOnActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.f183784o0 == 10) {
            ReportController.o(this.app, "dc00898", "", "", "0X8006AA8", "0X8006AA8", 0, 0, "", "", "", "");
        }
        if (getIntent().getBooleanExtra("k_is_block", false)) {
            QQAppInterface qQAppInterface = this.app;
            if (U2().length() >= 4) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X80056B6", "0X80056B6", i3, 0, "", "", "", "");
        }
        setResult(0);
        super.doOnBackPressed();
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected boolean doOnCreate(Bundle bundle) {
        BounceScrollView bounceScrollView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f183781l0 = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
        this.f183782m0 = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
        this.f183783n0 = getIntent().getBooleanExtra("cmd_param_is_encrypt", false);
        this.f183784o0 = getIntent().getIntExtra("kSrouce", -1);
        this.f183785p0 = getIntent().getIntExtra("keyReqBindMode", 0);
        getWindow().setSoftInputMode(18);
        setContentView(R.layout.f168362tx);
        if ((!Build.MANUFACTURER.equalsIgnoreCase("Letv") || !DeviceInfoMonitor.getModel().equalsIgnoreCase("X900+")) && (bounceScrollView = (BounceScrollView) findViewById(R.id.adt)) != null) {
            bounceScrollView.setOnSizeChangeListener(this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("BindVerifyActivity", 2, String.format("onCreate [%s, %s, %s]", Boolean.valueOf(this.f183781l0), Boolean.valueOf(this.f183782m0), Integer.valueOf(this.f183784o0)));
        }
        T2(getIntent());
        Z2("dc00898", "0X8009F17", 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar = this.f183773d0;
        if (bVar != null) {
            this.app.unRegistObserver(bVar);
            this.f183773d0 = null;
        }
        com.tencent.mobileqq.phonecontact.observer.b bVar2 = this.f183774e0;
        if (bVar2 != null) {
            this.app.unRegistObserver(bVar2);
            this.f183774e0 = null;
        }
        this.f183775f0.removeCallbacksAndMessages(null);
        this.f183770a0.removeTextChangedListener(this);
        this.f183770a0.setKeyListener(null);
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            super.doOnNewIntent(intent);
            T2(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnPause();
        if (QLog.isColorLevel()) {
            QLog.i("BindVerifyActivity", 2, "doOnPause");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.i("BindVerifyActivity", 2, "doOnResume");
        }
        if (U2().length() == 0) {
            b3();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.f183786q0 = false;
                        this.f183775f0.removeMessages(4);
                        dismissProgressDialog();
                        showToast(1, getString(R.string.h1y));
                        if (QLog.isColorLevel()) {
                            QLog.i("BindVerifyActivity", 2, "MSG_REQUEST_TIMEOUT");
                        }
                    }
                } else {
                    this.f183775f0.removeMessages(3);
                    BounceScrollView bounceScrollView = (BounceScrollView) findViewById(R.id.adt);
                    if (bounceScrollView != null) {
                        bounceScrollView.fullScroll(130);
                    }
                }
            } else {
                this.f183770a0.setText((String) message.obj);
            }
        } else {
            int i16 = message.arg1 - 1;
            message.arg1 = i16;
            if (i16 <= 0) {
                this.f183771b0.setEnabled(true);
                this.f183771b0.setTextColor(getResources().getColor(R.color.f157403oj));
                this.f183771b0.setText(HardCodeUtil.qqStr(R.string.f171662k24));
                this.f183770a0.setText("");
            } else {
                this.f183771b0.setEnabled(false);
                this.f183771b0.setTextColor(getResources().getColor(R.color.skin_gray2));
                this.f183771b0.setText(String.format(HardCodeUtil.qqStr(R.string.f171659k21), Integer.valueOf(i16)));
                Handler handler = this.f183775f0;
                handler.sendMessageDelayed(handler.obtainMessage(1, i16, 0), 1000L);
            }
        }
        return true;
    }

    protected void onBindSuc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (getIntent().getBooleanExtra("k_is_block", false)) {
            ReportController.o(this.app, "CliOper", "", "", "0X80053D5", "0X80053D5", 0, 0, "", "", "", "");
        }
        if (getIntent().getBooleanExtra("key_is_from_qqhotspot", false)) {
            Intent intent = new Intent();
            intent.putExtra("bind_mobile", V2());
            intent.putExtra("check_permission_result", "");
            setResult(-1, intent);
            finish();
            return;
        }
        int i3 = this.f183784o0;
        if (i3 == 10) {
            setResult(-1, null);
            finish();
        } else {
            if (i3 == 21) {
                Intent intent2 = new Intent();
                intent2.putExtra("bind_mobile", V2());
                setResult(-1, intent2);
                finish();
                return;
            }
            PermissionChecker.e(this, new Runnable() { // from class: com.tencent.mobileqq.activity.phone.BindVerifyActivity.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BindVerifyActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BindVerifyActivity.this.app.execute(new Runnable() { // from class: com.tencent.mobileqq.activity.phone.BindVerifyActivity.3.1
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
                                BindVerifyActivity.this.mPhoneContactService.uploadPhoneContact();
                                BindVerifyActivity.this.mPhoneContactService.setNeedUploadResultTip(true);
                            }
                        }
                    });
                    Intent intent3 = new Intent();
                    intent3.putExtra("bind_mobile", BindVerifyActivity.this.V2());
                    intent3.putExtra("check_permission_result", "permission_granted");
                    BindVerifyActivity.this.setResult(-1, intent3);
                    BindVerifyActivity.this.finish();
                    if (BindVerifyActivity.this.f183784o0 == 15) {
                        ReportController.o(BindVerifyActivity.this.app, "dc00898", "", "", "0X80077C7", "0X80077C7", 0, 0, "", "", "", "");
                    } else if (BindVerifyActivity.this.f183784o0 == 17) {
                        ReportController.o(BindVerifyActivity.this.app, "dc00898", "", "", "0X80077CB", "0X80077CB", 0, 0, "", "", "", "");
                    }
                }
            }, new DenyRunnable(this, new c()));
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, compoundButton, Boolean.valueOf(z16));
        } else if (z16) {
            if (U2().length() > 0) {
                this.f183772c0.setEnabled(true);
            } else {
                this.f183772c0.setEnabled(false);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                doOnBackPressed();
            } else if (id5 == R.id.i8f) {
                if (this.f183774e0 == null) {
                    a aVar = new a();
                    this.f183774e0 = aVar;
                    this.app.registObserver(aVar);
                }
                Q2();
                showProgressDialog(R.string.hex, 1000L, true);
                Z2("dc00898", "0X8009F1A", 0);
            } else if (id5 == R.id.send_btn) {
                R2(U2());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.phone.DialogBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
        }
        if (i3 == 66 && U2().length() >= 4) {
            R2(U2());
        }
        return false;
    }

    @Override // com.tencent.widget.OnSizeChangeListener
    public void onSizeChanged(int i3, int i16, int i17, int i18, boolean z16, int i19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19));
        } else if (i16 > 0 && i18 > 0 && i16 < i18 && i3 == i17) {
            this.f183775f0.sendEmptyMessageDelayed(3, 100L);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }
}
