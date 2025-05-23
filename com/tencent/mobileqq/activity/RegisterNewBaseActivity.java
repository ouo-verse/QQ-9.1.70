package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import mqq.os.MqqHandler;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes9.dex */
public class RegisterNewBaseActivity extends QBaseActivity implements DialogInterface.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    public static final int FROM_ADD_ACCOUNT = 2;
    public static final int FROM_CHOOSE_LOGIN = 6;
    public static final int FROM_LOGIN_BIND_PHONE_NUM = 9;
    public static final int FROM_LOGIN_GUIDE = 3;
    public static final int FROM_LOGIN_VIEW = 1;
    public static final int FROM_NICKANDPWD = 8;
    public static final int FROM_PHOME_NUM = 7;
    public static final int FROM_UP_SMS = 4;
    public static final int FROM_VERIFY_CODE = 5;
    private static final String TAG = "RegisterNewBaseActivity";
    public String countryCode;
    protected Dialog dialog;
    public Handler handler;
    protected ViewGroup mContextView;
    public int mFrom;
    public ILoginApi mLoginApi;
    private final ec mQUIProfileTheme;
    protected View.OnClickListener onBackListeger;
    public String phoneNum;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RegisterNewBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                RegisterNewBaseActivity.this.onBackEvent();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RegisterNewBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.phoneNum = "";
        this.countryCode = "86";
        this.mFrom = -1;
        this.mQUIProfileTheme = new ec(this);
        this.handler = new Handler();
        this.onBackListeger = new a();
    }

    public void closeAllActs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        MqqHandler e16 = com.tencent.mobileqq.loginregister.z.e(getAppRuntime(), RegisterSendUpSms.class);
        if (e16 != null) {
            e16.sendEmptyMessage(107);
        }
    }

    public void closeDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.RegisterNewBaseActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RegisterNewBaseActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        Dialog dialog = RegisterNewBaseActivity.this.dialog;
                        if (dialog != null && dialog.isShowing()) {
                            RegisterNewBaseActivity.this.dialog.dismiss();
                        }
                        RegisterNewBaseActivity.this.dialog = null;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            });
        }
    }

    public void createWaitingDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        try {
            Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(this, HardCodeUtil.qqStr(i3), false);
            this.dialog = showLoadingDialog;
            if (showLoadingDialog != null) {
                showLoadingDialog.show();
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createWaitingDialog error", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = needStatusTrans();
        this.mActNeedImmersive = needActImmersive();
        super.doOnCreate(bundle);
        getWindow().addFlags(1024);
        this.mFrom = getIntent().getIntExtra(AppConstants.Key.KEY_REGISTER_FROM, -1);
        this.mLoginApi = (ILoginApi) QRoute.api(ILoginApi.class);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getMaskedPhoneNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.phoneNum.substring(0, 3));
        sb5.append("******");
        sb5.append(this.phoneNum.substring(r1.length() - 2));
        return sb5.toString();
    }

    protected String getMaskedPhoneNumWithCountryCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        String maskedPhoneNum = getMaskedPhoneNum();
        if (this.countryCode.contains(Marker.ANY_NON_NULL_MARKER)) {
            return this.countryCode + " " + maskedPhoneNum;
        }
        return Marker.ANY_NON_NULL_MARKER + this.countryCode + " " + maskedPhoneNum;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Resources) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mQUIProfileTheme.b(super.getResources());
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(@NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        if ("layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            if (systemService instanceof LayoutInflater) {
                return this.mQUIProfileTheme.a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(str);
    }

    protected boolean needActImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    protected boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        finish();
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dialogInterface, i3);
        } else {
            if (i3 != 0) {
                if (i3 == 1) {
                    dialogInterface.dismiss();
                    return;
                }
                return;
            }
            dialogInterface.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBackListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.an9);
        textView.setOnClickListener(this.onBackListeger);
        if (AppSetting.f99565y) {
            textView.setContentDescription(getResources().getString(R.string.button_back));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setBarProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            ((ProgressBar) findViewById(R.id.i6i)).setProgress(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setProgressBarVisible(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.i6i);
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        progressBar.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitleHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (TextUtils.isEmpty(this.phoneNum)) {
            QLog.e(TAG, 1, "setTitleHint error: phoneNum is empty, set phone number before calling this method!");
            return;
        }
        TextView textView = (TextView) findViewById(R.id.kes);
        String maskedPhoneNumWithCountryCode = getMaskedPhoneNumWithCountryCode();
        String string = getString(R.string.g1s, maskedPhoneNumWithCountryCode);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.qui_common_feedback_warning)), string.indexOf(maskedPhoneNumWithCountryCode), string.indexOf(maskedPhoneNumWithCountryCode) + maskedPhoneNumWithCountryCode.length(), 33);
        textView.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitleText(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.ke5);
        String string = getResources().getString(i3);
        textView.setText(string);
        if (AppSetting.f99565y) {
            textView.setContentDescription(string);
        }
    }

    public void showDialog(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        try {
            this.handler.post(new Runnable(str, str2) { // from class: com.tencent.mobileqq.activity.RegisterNewBaseActivity.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f176946d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f176947e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.activity.RegisterNewBaseActivity$1$a */
                /* loaded from: classes9.dex */
                class a implements DialogInterface.OnClickListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
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

                {
                    this.f176946d = str;
                    this.f176947e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RegisterNewBaseActivity.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(RegisterNewBaseActivity.this, 230);
                    createCustomDialog.setTitle(this.f176946d);
                    createCustomDialog.setMessage(this.f176947e);
                    createCustomDialog.setPositiveButton(R.string.f211255kb, new a());
                    createCustomDialog.show();
                }
            });
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitleText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        TextView textView = (TextView) findViewById(R.id.ke5);
        textView.setText(str);
        if (AppSetting.f99565y) {
            textView.setContentDescription(str);
        }
    }
}
