package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.bank.BindBankModule;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.MD5;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PassVerifyActivity extends NetBaseActivity implements View.OnClickListener {
    public static String FROM_CHECKPSW = "from_checkpsw";
    public static String KEY_IN_CUSTOM_TITLE = "key_in_custom_title";
    public static String KEY_IN_NOT_VERIFY_MODE = "key_in_not_verify_mode";
    public static String KEY_OUT_ENTER_PWD = "key_not_enter_pwd";
    public static String KEY_OUT_QPWD_TOKEN = "qpwd_token";
    public static String KEY_OUT_RETDATA = "retdata";
    public static int ResetPass_RESULT_CODE = 1003;
    public static final int WINDOW_STYLE_BIG = 1;
    public static final int WINDOW_STYLE_SMALL = 0;
    protected JSONObject mAuthObj;
    protected TextView mBackBtn;
    protected String mBusiInfo;
    protected String mBussSceneKey;
    protected String mChallengeValue;
    protected ImageButton mCloseBtn;
    protected Button mForgetPassBtn;
    protected TextView mInputNoteTxt;
    protected MyKeyboardWindow mKeyboard;
    protected EditText mNormalPasswdEdit;
    private LinearLayout mPassLayout;
    protected LinearLayout mPayAuthLayout;
    protected Button mPayConfirmBtn;
    protected View mRootLayout;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    protected TextView mSubTitle;
    protected String mSysTimeStamp;
    protected TextView mTitle;
    private LinearLayout normal_passwd_layout;
    protected String pass_six_edit;
    private TextView pay_error;
    protected boolean mIsSixPasswdUser = true;
    protected int mNavType = 0;
    protected boolean mHasNavType = false;
    private boolean mNotVerifyMode = false;
    private String mCustomTitle = null;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (PassVerifyActivity.this.mPayAuthLayout.getVisibility() == 0) {
                if (PassVerifyActivity.this.getPasswd().length() > 5) {
                    if (!PassVerifyActivity.this.mPayConfirmBtn.isEnabled()) {
                        PassVerifyActivity.this.mPayConfirmBtn.setEnabled(true);
                        PassVerifyActivity.this.mPayConfirmBtn.setClickable(true);
                        PassVerifyActivity.this.addTraceData("check.psw.enable");
                        return;
                    }
                    return;
                }
                if (PassVerifyActivity.this.mPayConfirmBtn.isEnabled()) {
                    PassVerifyActivity.this.mPayConfirmBtn.setClickable(false);
                    PassVerifyActivity.this.mPayConfirmBtn.setEnabled(false);
                    PassVerifyActivity.this.addTraceData("check.psw.disable");
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPassword() {
        if (this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.setFocusable(true);
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        this.mPayConfirmBtn.setClickable(false);
        this.mPayConfirmBtn.setEnabled(false);
    }

    private void finishWithResult() {
        Intent intent = new Intent();
        intent.putExtra(KEY_OUT_ENTER_PWD, getPasswd());
        setResult(-1, intent);
        finish();
    }

    private void playPassWordWrrorAnim(String str) {
        try {
            this.mPassLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.dwb));
            this.mSixPasswdEdit.setErrorColor(getResources().getColor(R.color.f157595u6));
            this.pay_error.setText(str);
            this.pay_error.setTextColor(getResources().getColor(R.color.f157595u6));
            this.pay_error.post(new Runnable() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    if (PassVerifyActivity.this.pay_error.getLineCount() > 1) {
                        i3 = 20000;
                    } else {
                        i3 = 1000;
                    }
                    PassVerifyActivity.this.pay_error.startAnimation(AnimationUtils.loadAnimation(PassVerifyActivity.this.getContext(), R.anim.f154873en));
                    PassVerifyActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PassVerifyActivity.this.mPassLayout.setBackgroundDrawable(PassVerifyActivity.this.getResources().getDrawable(R.drawable.dwa));
                            PassVerifyActivity.this.mSixPasswdEdit.clearErrorColor();
                            PassVerifyActivity.this.clearPassword();
                            PassVerifyActivity.this.pay_error.setText(R.string.eal);
                        }
                    }, i3);
                }
            });
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryUser() {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("reset_pwd_flag", "1");
        hashMap.put("qq_guid", com.tencent.mobileqq.base.b.d());
        hashMap.put("qq_appid", com.tencent.mobileqq.base.b.b());
        hashMap.put("qq_appname", "com.tencent.mobileqq");
        httpRequest(Cgi.URI_QUERY_USER, hashMap);
    }

    private void sdkAuth() {
        QwLog.i("sdkAuth");
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("extra_data"));
            QwLog.i("extra_data =" + jSONObject.toString());
            QwLog.i("mUin =" + this.mUin);
            QwLog.i("mBusiInfo =" + this.mBusiInfo);
            hashMap.put("uin", this.mUin);
            if (this.mHasNavType) {
                hashMap.put("nav_type", String.valueOf(this.mNavType));
            }
            int optInt = jSONObject.optInt("userid_type");
            hashMap.put("userid_type", optInt + "");
            hashMap.put("userid", jSONObject.optString("userid"));
            if (optInt == 0) {
                hashMap.put(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, jSONObject.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN));
                hashMap.put("appid", jSONObject.optString("appid"));
            }
            hashMap.put("mch_id", jSONObject.optString("mch_id"));
            hashMap.put("time_stamp", String.valueOf(jSONObject.optLong("time_stamp", 0L)));
            hashMap.put("token_scene", jSONObject.optString("token_scene"));
            hashMap.put("token_type", jSONObject.optString("token_type"));
            hashMap.put("busi_info", this.mBusiInfo);
            hashMap.put("sign", jSONObject.optString("sign"));
        } catch (Exception unused) {
        }
        httpRequest(Cgi.URI_PASS_SDK_AUTH, hashMap);
    }

    private void showSixePasswordView() {
        this.mNormalPasswdEdit.setVisibility(8);
        this.mSixPasswdEdit.setVisibility(0);
        this.mIsSixPasswdUser = true;
        this.mSixPasswdEdit.requestFocus();
        this.mPayConfirmBtn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validatePasswd() {
        if (this.mNotVerifyMode) {
            finishWithResult();
            return;
        }
        QwLog.i("validatePasswd");
        QwLog.i("mUin=" + this.mUin);
        QwLog.i("mBussSceneKey=" + this.mBussSceneKey);
        this.mChallengeValue = MD5.hexdigest(this.mUin + System.currentTimeMillis());
        QwLog.i("mChallengeValue=" + this.mChallengeValue);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("p", getPasswd());
        hashMap.put("busi_scene_key", this.mBussSceneKey);
        hashMap.put("challenge_value", this.mChallengeValue);
        if (this.mNavType == 0) {
            httpRequestWithQQPayLoading(Cgi.URI_PASS_VERIFY, hashMap, this.mKeyboard.getHeight());
        } else {
            httpRequest(Cgi.URI_PASS_VERIFY, hashMap);
        }
    }

    protected void addTraceData(String str) {
        com.tencent.mobileqq.qwallet.c.c(str, 115);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.mKeyboard.getVisibility() == 0) {
                this.mKeyboard.setVisibility(8);
                return true;
            }
            if (this.mPayAuthLayout.getVisibility() == 0) {
                addTraceData("check.psw.keyback");
                return super.doOnKeyDown(i3, keyEvent);
            }
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    protected void fillViewWithData(JSONObject jSONObject) {
        this.mAuthObj = jSONObject;
        if (jSONObject != null) {
            this.mRootLayout.setVisibility(0);
            if ("2".equals(this.mPassFlag)) {
                showSixePasswordView();
                return;
            }
            TextView textView = this.mInputNoteTxt;
            if (textView != null) {
                textView.setVisibility(8);
            }
            LinearLayout linearLayout = this.normal_passwd_layout;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            this.mSixPasswdEdit.setVisibility(8);
            this.mIsSixPasswdUser = false;
            this.mNormalPasswdEdit.requestFocus();
            this.mPayConfirmBtn.setVisibility(0);
            this.mKeyboard.setVisibility(8);
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
    }

    protected String getPasswd() {
        if (this.mIsSixPasswdUser) {
            return this.mSixPasswdEdit.getInputText();
        }
        return this.mNormalPasswdEdit.getText().toString();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initView(View view) {
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.az7);
        this.mCloseBtn = imageButton;
        imageButton.setOnClickListener(this);
        this.mPayAuthLayout = (LinearLayout) view.findViewById(R.id.a16);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        this.normal_passwd_layout = (LinearLayout) view.findViewById(R.id.faj);
        if (Utils.getScreenWidth(getContext()) < 500) {
            this.mNormalPasswdEdit.setHint(R.string.e3t);
        }
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.2
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public void onTextChange() {
                if (PassVerifyActivity.this.mSixPasswdEdit.getInputText().length() > 5) {
                    PassVerifyActivity.this.addTraceData("check.psw.go");
                    PassVerifyActivity.this.validatePasswd();
                }
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                if (PassVerifyActivity.this.mSixPasswdEdit.isFocused()) {
                    PassVerifyActivity.this.mSixPasswdEdit.post(new Runnable() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PassVerifyActivity.this.mKeyboard.setVisibility(0);
                            PassVerifyActivity passVerifyActivity = PassVerifyActivity.this;
                            passVerifyActivity.mKeyboard.setInputEditText(passVerifyActivity.mSixPasswdEdit);
                        }
                    });
                }
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent.getKeyCode() == 66) {
                    if (PassVerifyActivity.this.getPasswd().length() > 5) {
                        PassVerifyActivity.this.mPayConfirmBtn.performClick();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return z16;
            }
        });
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        if (!TextUtils.isEmpty(this.mCustomTitle)) {
            this.mInputNoteTxt.setVisibility(0);
            this.mInputNoteTxt.setText(this.mCustomTitle);
            this.mSubTitle.setVisibility(8);
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            WalletGateData.getInstance().clear();
            if (i3 != 10 && i3 == 20) {
                this.pass_six_edit = "2";
                showSixePasswordView();
                return;
            }
            return;
        }
        clearPassword();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(jSONObject.optString("retcode"))) {
            if (this.mNavType == 0) {
                playPassWordWrrorAnim(jSONObject.optString("retmsg"));
            } else {
                clearPassword();
            }
        }
        super.onBlError(str, jSONObject);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        return super.onBlHandleFakeurl(fakeInfo, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == this.mPayConfirmBtn.getId()) {
            addTraceData("check.psw.go");
            validatePasswd();
        } else if (id5 == R.id.cja) {
            addTraceData("check.psw.forgot");
            queryUser();
        } else if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.az7) {
            if (id5 != R.id.iwz && id5 != R.id.knc) {
                if (id5 == R.id.fjf) {
                    Intent intent = new Intent();
                    intent.putExtra("token_id", this.mPayTokenId);
                    intent.putExtra("forget_pass", true);
                    intent.putExtra("pass_flag", this.mPassFlag);
                    launchFragmentForResult(intent, ResetPassBridgeActivity.class, ResetPass_RESULT_CODE);
                }
            } else if (!this.mKeyboard.isShown()) {
                this.mKeyboard.setVisibility(0);
            }
        } else {
            QwLog.i("onClick id = " + id5);
            addTraceData("check.psw.close");
            finish();
            if (!this.mNotVerifyMode) {
                TenUtils.notifyToExit(getContext(), this.mProssesID);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QwLog.i("PassVerifyActivity onCreate");
        getWindow().setSoftInputMode(19);
        getWindow().addFlags(8192);
        Intent intent = getIntent();
        this.mNotVerifyMode = intent.getBooleanExtra(KEY_IN_NOT_VERIFY_MODE, false);
        this.mCustomTitle = intent.getStringExtra(KEY_IN_CUSTOM_TITLE);
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("extra_data"));
            this.mHasNavType = jSONObject.has("nav_type");
            this.mNavType = jSONObject.optInt("nav_type");
            this.mBusiInfo = jSONObject.optString("busi_info");
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate;
        int i3 = this.mNavType;
        if (i3 != 0) {
            if (i3 != 1) {
                inflate = null;
            } else {
                inflate = layoutInflater.inflate(R.layout.afe, viewGroup, false);
                this.mRootLayout = inflate.findViewById(R.id.root_layout);
                TextView textView = (TextView) inflate.findViewById(R.id.ivTitleName);
                this.mTitle = textView;
                textView.setText(R.string.eam);
                TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
                this.mBackBtn = textView2;
                textView2.setOnClickListener(this);
                TextView textView3 = (TextView) inflate.findViewById(R.id.f166931j64);
                this.mSubTitle = textView3;
                ol2.b.c(textView3);
                Button button = (Button) inflate.findViewById(R.id.cja);
                this.mForgetPassBtn = button;
                ol2.b.c(button);
                this.mForgetPassBtn.setOnClickListener(this);
                TextView textView4 = (TextView) inflate.findViewById(R.id.input_note_txt);
                this.mInputNoteTxt = textView4;
                ol2.b.c(textView4);
                Button button2 = (Button) inflate.findViewById(R.id.b7s);
                this.mPayConfirmBtn = button2;
                button2.setOnClickListener(this);
                this.mPayConfirmBtn.setEnabled(false);
                this.mPayConfirmBtn.setClickable(false);
            }
        } else {
            inflate = layoutInflater.inflate(R.layout.adt, viewGroup, false);
            View findViewById = inflate.findViewById(R.id.root_layout);
            this.mRootLayout = findViewById;
            findViewById.setVisibility(8);
            Button button3 = (Button) inflate.findViewById(R.id.fah);
            this.mPayConfirmBtn = button3;
            button3.setOnClickListener(this);
            this.mPayConfirmBtn.setEnabled(false);
            this.mPayConfirmBtn.setClickable(false);
            TextView textView5 = (TextView) inflate.findViewById(R.id.fjf);
            this.pay_error = textView5;
            textView5.setOnClickListener(this);
            this.mPassLayout = (LinearLayout) inflate.findViewById(R.id.a16);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        super.onError(str, jSONObject);
        String str2 = "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u4e00\u8bd5";
        if (jSONObject != null) {
            str2 = jSONObject.optString("retmsg", "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\u4e00\u8bd5");
        }
        QLog.e(((NetBaseActivity) this).TAG, 1, "request error " + str2);
        QQToast.makeText(getApplicationContext(), 1, str2, 0).show();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (ErrorCode.ERR_PAY_PASSWORD.equals(jSONObject.optString("retcode"))) {
            setRetCodeAndGetBundle(-6);
            return;
        }
        if (str.equals(Cgi.URI_PASS_SDK_AUTH)) {
            int optInt = jSONObject.optInt("retcode");
            String optString = jSONObject.optString("retmsg");
            Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(optInt);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("err_msg", optString);
                retCodeAndGetBundle.putString("retmsg", jSONObject2.toString());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("return_code", jSONObject.optString("return_code"));
                jSONObject3.put("return_msg", jSONObject.optString("return_msg"));
                retCodeAndGetBundle.putString(KEY_OUT_RETDATA, jSONObject3.toString());
            } catch (Exception unused) {
            }
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        QwLog.i("PassVerifyActivity onSuccess");
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URI_PASS_SDK_AUTH)) {
            QwLog.i("URI_PASS_SDK_AUTH data=" + jSONObject);
            this.mAuthObj = jSONObject;
            this.mSysTimeStamp = jSONObject.optString("sys_time_stamp");
            QwLog.i("mSysTimeStamp = " + this.mSysTimeStamp);
            this.mTimestamp = Long.parseLong(this.mSysTimeStamp) - (System.currentTimeMillis() / 1000);
            String optString = this.mAuthObj.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            String optString2 = jSONObject.optString("pwd_sdk_title");
            if (this.mSubTitle != null && TextUtils.isEmpty(this.mCustomTitle)) {
                if (!TextUtils.isEmpty(optString2)) {
                    this.mSubTitle.setVisibility(0);
                    this.mSubTitle.setText(optString2);
                } else {
                    this.mSubTitle.setVisibility(8);
                }
            }
            this.mBussSceneKey = jSONObject.optString("busi_scene_key");
            this.mPassFlag = jSONObject.optString("pass_flag");
            fillViewWithData(jSONObject);
            return;
        }
        if (str.equals(Cgi.URI_PASS_VERIFY)) {
            if ("0".equals(jSONObject.optString("retcode"))) {
                if (!this.mChallengeValue.equals(jSONObject.optString("challenge_value"))) {
                    QUIProxy.createCustomDialog(getContext(), 230, null, "\u652f\u4ed8\u5bc6\u7801\u6821\u9a8c\u8fc7\u7a0b\u53d1\u751f\u5f02\u5e38", getApplicationContext().getString(R.string.f171151ok), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.8
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            PassVerifyActivity.this.clearPassword();
                        }
                    });
                    return;
                }
                Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("return_code", jSONObject.optString("return_code"));
                    jSONObject2.put("return_msg", jSONObject.optString("return_msg"));
                    jSONObject2.put(KEY_OUT_QPWD_TOKEN, jSONObject.optString("qpwd_token"));
                } catch (Exception e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "onSuccess: ", e16);
                }
                retCodeAndGetBundle.putString("retdata", jSONObject2.toString());
                TenUtils.notifyToExit(getContext(), this.mProssesID);
                return;
            }
            return;
        }
        if (str.equals(Cgi.URI_QUERY_USER)) {
            QwLog.i("ID_QUERY_USER");
            QwLog.i("data=" + jSONObject);
            if (jSONObject.optInt("allow_reset_pwd") == 1) {
                this.mUserAttr = jSONObject.optInt("user_type");
                this.mTrueName = jSONObject.optString("purchaser_true_name");
                Intent intent = new Intent();
                intent.putExtra("forget_pass", true);
                intent.putExtra(FROM_CHECKPSW, true);
                int optInt = jSONObject.optInt("reset_type", 2);
                QwLog.i("reset_type = " + optInt);
                if (optInt == 1) {
                    IdVerifyModule.startFromForgetPwd(this, intent, 20);
                    return;
                } else {
                    BindBankModule.INSTANCE.startVerifyForResult(this, intent, 20);
                    return;
                }
            }
            String optString3 = jSONObject.optString("reset_pwd_info");
            if ("".equals(optString3)) {
                optString3 = getString(R.string.e39);
            }
            QUIProxy.createCustomDialog(getContext(), 230, null, optString3, getString(R.string.e3_), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            });
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("sdk_auth");
        JSONObject jSONObject = null;
        try {
            if (!TextUtils.isEmpty(stringExtra)) {
                jSONObject = new JSONObject(stringExtra);
            } else if (this.mNotVerifyMode) {
                jSONObject = new JSONObject();
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            finish();
        }
        if (jSONObject == null) {
            sdkAuth();
        } else {
            fillViewWithData(jSONObject);
        }
        addTraceData("check.psw.show");
        QwLog.i("is_inner: " + intent.getBooleanExtra("is_inner", false));
        if (intent.getBooleanExtra("is_inner", false)) {
            this.hasTopCallback = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void showErrorDialog(String str, JSONObject jSONObject) {
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(jSONObject.optString("retcode")) && this.mNavType != 0) {
            QUIProxy.createCustomDialog(getContext(), 230, null, jSONObject.optString("retmsg"), getString(R.string.edi), getString(R.string.e5v), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    PassVerifyActivity.this.queryUser();
                    PassVerifyActivity.this.addTraceData("psw.err.forget");
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PassVerifyActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    PassVerifyActivity.this.addTraceData("psw.err.retry");
                }
            });
        } else {
            super.showErrorDialog(str, jSONObject);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
