package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
@RoutePage(desc = "\u8bbe\u5907\u66f4\u540d\u9875\u9762", path = RouterConstants.UI_ROUTE_DEV_RENAME_ACTIVITY)
/* loaded from: classes9.dex */
public class AuthDevRenameActivity extends IphoneTitleBarActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    static IPatchRedirector $redirector_;
    private ClearableEditText mAuthDevName;
    private Handler mHandler;
    private QQProgressDialog mProDialog;
    private com.tencent.mobileqq.app.cx mSecSvcObserver;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements InputFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private int f174988d;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevRenameActivity.this);
            } else {
                this.f174988d = 32;
            }
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            int i19;
            int i26;
            int i27;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), spanned, Integer.valueOf(i17), Integer.valueOf(i18));
            }
            int i28 = 0;
            for (int i29 = i3; i29 < i16; i29++) {
                char charAt = charSequence.charAt(i29);
                if (charAt < '\u0080') {
                    i27 = 1;
                } else if (charAt < '\u0800') {
                    i27 = 2;
                } else {
                    i27 = 3;
                }
                i28 += i27;
            }
            int length = spanned.length();
            int i36 = 0;
            for (int i37 = 0; i37 < length; i37++) {
                if (i37 < i17 || i37 >= i18) {
                    char charAt2 = spanned.charAt(i37);
                    if (charAt2 < '\u0080') {
                        i26 = 1;
                    } else if (charAt2 < '\u0800') {
                        i26 = 2;
                    } else {
                        i26 = 3;
                    }
                    i36 += i26;
                }
            }
            int i38 = this.f174988d - i36;
            if (i38 <= 0) {
                return "";
            }
            if (i38 >= i28) {
                return null;
            }
            for (int i39 = i3; i39 < i16; i39++) {
                char charAt3 = charSequence.charAt(i39);
                if (charAt3 < '\u0080') {
                    i19 = 1;
                } else if (charAt3 < '\u0800') {
                    i19 = 2;
                } else {
                    i19 = 3;
                }
                i38 -= i19;
                if (i38 < 0) {
                    return charSequence.subSequence(i3, i39);
                }
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b extends com.tencent.mobileqq.app.cx {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevRenameActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.cx
        protected void g(boolean z16, int i3, byte[] bArr, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AuthDevRenameActivity.this.hideProgerssDialog();
                if (!z16) {
                    AuthDevRenameActivity authDevRenameActivity = AuthDevRenameActivity.this;
                    QQToast.makeText(authDevRenameActivity, authDevRenameActivity.getString(R.string.b06), 0).show(AuthDevRenameActivity.this.getTitleBarHeight());
                    return;
                } else {
                    AuthDevRenameActivity.this.finish();
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), bArr, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevRenameActivity.this);
            }
        }
    }

    public AuthDevRenameActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mSecSvcObserver = new b();
            this.mHandler = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgerssDialog() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevRenameActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevRenameActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AuthDevRenameActivity.this.mProDialog != null && AuthDevRenameActivity.this.mProDialog.isShowing()) {
                        AuthDevRenameActivity.this.mProDialog.dismiss();
                        AuthDevRenameActivity.this.mProDialog.cancel();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                AuthDevRenameActivity.this.mProDialog = null;
            }
        });
    }

    private void showProgressDialog() {
        this.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.AuthDevRenameActivity.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthDevRenameActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (AuthDevRenameActivity.this.mProDialog == null && !AuthDevRenameActivity.this.isFinishing()) {
                        AuthDevRenameActivity authDevRenameActivity = AuthDevRenameActivity.this;
                        AuthDevRenameActivity authDevRenameActivity2 = AuthDevRenameActivity.this;
                        authDevRenameActivity.mProDialog = new QQProgressDialog(authDevRenameActivity2, authDevRenameActivity2.getTitleBarHeight());
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (AuthDevRenameActivity.this.mProDialog != null && !AuthDevRenameActivity.this.mProDialog.isShowing()) {
                    AuthDevRenameActivity.this.mProDialog.setMessage(AuthDevRenameActivity.this.getString(R.string.b07));
                    AuthDevRenameActivity.this.mProDialog.show();
                }
            }
        });
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
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.setContentView(R.layout.atv);
        super.addObserver(this.mSecSvcObserver);
        super.setRightButton(R.string.ayp, this);
        this.leftView.setText(R.string.cancel);
        this.leftView.setOnClickListener(this);
        TextView textView = this.centerView;
        if (textView != null && (textView instanceof TextView)) {
            textView.setVisibility(8);
        }
        Intent intent = super.getIntent();
        if (intent != null) {
            str = intent.getStringExtra("target_name");
            str2 = intent.getStringExtra("target_type_info");
        } else {
            str = null;
            str2 = null;
        }
        View findViewById = super.findViewById(R.id.jp7);
        if (findViewById != null) {
            findViewById.setVisibility(0);
            TextView textView2 = (TextView) findViewById.findViewById(R.id.jq5);
            if (textView2 != null) {
                textView2.setText(R.string.f170899b05);
            }
            TextView textView3 = (TextView) findViewById.findViewById(R.id.joi);
            if (textView3 != null && !TextUtils.isEmpty(str2)) {
                textView3.setText(str2);
            }
        } else {
            super.setTitle(R.string.f170899b05);
        }
        this.mAuthDevName = (ClearableEditText) super.findViewById(R.id.f164515a12);
        if (!TextUtils.isEmpty(str)) {
            this.mAuthDevName.setHint(str);
        }
        this.mAuthDevName.setImeOptions(6);
        this.mAuthDevName.setOnEditorActionListener(this);
        this.mAuthDevName.setImeActionLabel(getString(R.string.login), 6);
        getWindow().setSoftInputMode(32);
        this.mAuthDevName.setFilters(new InputFilter[]{new a()});
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            if (view.getId() == R.id.ivTitleBtnRightText) {
                if (!NetworkUtil.isNetSupport(this)) {
                    QQToast.makeText(this, getString(R.string.b3j), 0).show(getTitleBarHeight());
                } else {
                    String obj = this.mAuthDevName.getEditableText().toString();
                    if (TextUtils.isEmpty(obj)) {
                        QQToast.makeText(this, getString(R.string.az8), 0).show(getTitleBarHeight());
                    } else {
                        Intent intent = super.getIntent();
                        if (intent != null) {
                            String stringExtra = intent.getStringExtra("target_name");
                            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.equals(stringExtra, obj)) {
                                Bundle extras = intent.getExtras();
                                extras.putString("target_name", obj);
                                extras.putString("uin", this.app.getCurrentAccountUin());
                                SecSvcHandler secSvcHandler = (SecSvcHandler) this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
                                if (secSvcHandler != null) {
                                    showProgressDialog();
                                    secSvcHandler.T2(extras);
                                }
                            }
                        }
                    }
                }
            }
            super.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        hideProgerssDialog();
        super.onDestroy();
        super.removeObserver(this.mSecSvcObserver);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 4, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
        } else if (i3 == 6) {
            onClick(this.rightViewText);
        } else {
            z16 = false;
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z16;
    }
}
