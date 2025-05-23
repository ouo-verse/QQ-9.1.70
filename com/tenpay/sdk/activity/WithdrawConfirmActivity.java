package com.tenpay.sdk.activity;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.JSONConstant;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WithdrawConfirmActivity extends NetBaseActivity implements View.OnClickListener {
    private static final int ResetPassBridge_RESULT_CODE = 2008;
    public static int ResetPass_RESULT_CODE = 1002;
    protected String mAmount;
    protected boolean mBackKeyPressed;
    protected String mBank_name;
    protected String mBank_true_name;
    protected String mBank_type;
    protected String mBind_serial;
    protected String mCard_tail;
    protected String mChannel;
    protected String mCharge_fee;
    protected ImageButton mCloseBtn;
    protected String mDraw_desc;
    protected String mDraw_id;
    protected String mDraw_type;
    protected String mFree_type;
    protected boolean mIsSixPasswdUser;
    protected MyKeyboardWindow mKeyboard;
    protected EditText mNormalPasswdEdit;
    private LinearLayout mPassLayout;
    protected LinearLayout mPayAuthLayout;
    protected ProgressBar mProgressBar;
    protected LinearLayout mRootLayout;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    protected TextView mTitleText;
    protected String mTransaction_id;
    protected Button mWithdrawConfirmBtn;
    private LinearLayout normal_passwd_layout;
    private TextView pay_error;
    protected int process_flag = 113;
    private String mFeeRate = null;
    private int mIsPayFee = 0;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WithdrawConfirmActivity.this.mPayAuthLayout.getVisibility() == 0) {
                if (WithdrawConfirmActivity.this.getPasswd().length() > 5) {
                    if (!WithdrawConfirmActivity.this.mWithdrawConfirmBtn.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("cash.pwd.enable", Integer.valueOf(WithdrawConfirmActivity.this.process_flag));
                        WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setEnabled(true);
                        WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setClickable(true);
                        return;
                    }
                    return;
                }
                if (WithdrawConfirmActivity.this.mWithdrawConfirmBtn.isEnabled()) {
                    com.tencent.mobileqq.qwallet.c.c("cash.pwd.disable", Integer.valueOf(WithdrawConfirmActivity.this.process_flag));
                    WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setClickable(false);
                    WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setEnabled(false);
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
    public void clearPassWord() {
        if (this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mWithdrawConfirmBtn.setClickable(false);
            this.mWithdrawConfirmBtn.setEnabled(false);
        } else {
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.setFocusable(true);
            this.mNormalPasswdEdit.requestFocus();
            this.mWithdrawConfirmBtn.setClickable(false);
            this.mWithdrawConfirmBtn.setEnabled(false);
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
    }

    private void go2WithdrawSuccessActivity(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("bank_name", this.mBank_name);
        intent.putExtra("card_tail", this.mCard_tail);
        intent.putExtra("bank_true_name", this.mBank_true_name);
        intent.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.mTransaction_id);
        intent.putExtra(JSONConstant.KEY_CHARGE_FEE, this.mCharge_fee);
        intent.putExtra("amount", str);
        intent.putExtra("desc", this.mDraw_desc);
        intent.putExtra(JSONConstant.KEY_PAY_FEE_FLAG, this.mIsPayFee);
        intent.putExtra("draw_succ_desc", str2);
        intent.putExtra(WithdrawActivity.WITHDRAW_PROCESS_FLAG, this.process_flag);
        launchFragment(intent, WithdrawSuccessActivity.class);
        setResult(-1);
        finish();
    }

    private void initWithdrawInfo() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mPassFlag = intent.getStringExtra("pass_flag");
        this.mCharge_fee = intent.getStringExtra(JSONConstant.KEY_CHARGE_FEE);
        this.process_flag = intent.getIntExtra(WithdrawActivity.WITHDRAW_PROCESS_FLAG, 113);
        String stringExtra = intent.getStringExtra("withdraw_info");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.mAmount = jSONObject.optString("amount");
                this.mBank_type = jSONObject.optString("bank_type");
                this.mCard_tail = jSONObject.optString("card_tail");
                this.mBank_name = jSONObject.optString("bank_name");
                this.mBind_serial = jSONObject.optString("bind_serial");
                this.mBank_true_name = jSONObject.optString("bank_true_name");
                this.mDraw_id = jSONObject.optString(JSONConstant.KEY_DRAW_ID);
                this.mChannel = jSONObject.optString(WadlProxyConsts.CHANNEL);
                this.mDraw_type = jSONObject.optString("draw_type");
                this.mFree_type = jSONObject.optString("free_type");
                this.mDraw_desc = jSONObject.optString("desc");
                this.mFeeRate = jSONObject.optString(JSONConstant.KEY_FEE_RATE);
                this.mIsPayFee = jSONObject.optInt(JSONConstant.KEY_PAY_FEE_FLAG);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    private void playPassWordWrrorAnim(String str) {
        this.mPassLayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.dwb));
        this.mSixPasswdEdit.setErrorColor(getResources().getColor(R.color.f157595u6));
        this.pay_error.setText(str);
        this.pay_error.setTextColor(getResources().getColor(R.color.f157595u6));
        this.pay_error.post(new Runnable() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.5
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (WithdrawConfirmActivity.this.pay_error.getLineCount() > 1) {
                    i3 = 20000;
                } else {
                    i3 = 1000;
                }
                WithdrawConfirmActivity.this.pay_error.startAnimation(AnimationUtils.loadAnimation(WithdrawConfirmActivity.this.getContext(), R.anim.f154873en));
                WithdrawConfirmActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WithdrawConfirmActivity.this.mPassLayout.setBackgroundDrawable(WithdrawConfirmActivity.this.getResources().getDrawable(R.drawable.dwa));
                        WithdrawConfirmActivity.this.mSixPasswdEdit.clearErrorColor();
                        WithdrawConfirmActivity.this.clearPassWord();
                        WithdrawConfirmActivity.this.pay_error.setText(R.string.eal);
                        WithdrawConfirmActivity.this.pay_error.setTextColor(WithdrawConfirmActivity.this.getResources().getColor(R.color.f157591u2));
                    }
                }, i3);
            }
        });
    }

    private void showSixPasswordView() {
        this.normal_passwd_layout.setVisibility(8);
        this.mSixPasswdEdit.setVisibility(0);
        this.mIsSixPasswdUser = true;
        this.mSixPasswdEdit.requestFocus();
        this.mWithdrawConfirmBtn.setVisibility(8);
        this.mWithdrawConfirmBtn.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mBackKeyPressed = true;
            this.mCloseBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
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
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.je7);
        this.mTitleText = (TextView) view.findViewById(R.id.fjh);
        this.mPayAuthLayout = (LinearLayout) view.findViewById(R.id.a16);
        this.mNormalPasswdEdit = (EditText) view.findViewById(R.id.fai);
        this.normal_passwd_layout = (LinearLayout) view.findViewById(R.id.faj);
        this.mNormalPasswdEdit.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        TextView textView = (TextView) view.findViewById(R.id.fjf);
        this.pay_error = textView;
        textView.setOnClickListener(this);
        this.mPassLayout = (LinearLayout) view.findViewById(R.id.a16);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.2
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public void onTextChange() {
                if (WithdrawConfirmActivity.this.mSixPasswdEdit.getInputText().length() > 5) {
                    com.tencent.mobileqq.qwallet.c.c("cash.pwd.enable", Integer.valueOf(WithdrawConfirmActivity.this.process_flag));
                    WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setEnabled(true);
                    WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setClickable(true);
                    WithdrawConfirmActivity.this.mWithdrawConfirmBtn.performClick();
                    return;
                }
                com.tencent.mobileqq.qwallet.c.c("cash.pwd.disable", Integer.valueOf(WithdrawConfirmActivity.this.process_flag));
                WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setClickable(false);
                WithdrawConfirmActivity.this.mWithdrawConfirmBtn.setEnabled(false);
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                if (WithdrawConfirmActivity.this.mSixPasswdEdit.isFocused()) {
                    WithdrawConfirmActivity.this.mSixPasswdEdit.post(new Runnable() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WithdrawConfirmActivity.this.mKeyboard.setVisibility(0);
                            WithdrawConfirmActivity withdrawConfirmActivity = WithdrawConfirmActivity.this;
                            withdrawConfirmActivity.mKeyboard.setInputEditText(withdrawConfirmActivity.mSixPasswdEdit);
                        }
                    });
                }
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.WithdrawConfirmActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent.getKeyCode() == 66) {
                    if (WithdrawConfirmActivity.this.getPasswd().length() > 5) {
                        WithdrawConfirmActivity.this.mWithdrawConfirmBtn.performClick();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return z16;
            }
        });
        Button button = (Button) view.findViewById(R.id.fah);
        this.mWithdrawConfirmBtn = button;
        button.setOnClickListener(this);
        this.mWithdrawConfirmBtn.setEnabled(false);
        this.mWithdrawConfirmBtn.setClickable(false);
        if ("2".equals(this.mPassFlag)) {
            showSixPasswordView();
        } else {
            this.mWithdrawConfirmBtn.setVisibility(0);
            this.normal_passwd_layout.setVisibility(0);
            this.mSixPasswdEdit.setVisibility(8);
            this.mIsSixPasswdUser = false;
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mKeyboard = myKeyboardWindow;
        if (this.mIsSixPasswdUser) {
            myKeyboardWindow.setVisibility(0);
            this.mKeyboard.setInputEditText(this.mSixPasswdEdit);
        } else {
            myKeyboardWindow.setVisibility(8);
            getWindow().setSoftInputMode(19);
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        if (Utils.getScreenWidth(getContext()) < 500) {
            this.mNormalPasswdEdit.setHint(R.string.e3t);
        }
        this.mRootLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154875ep));
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1) {
            if (i3 == ResetPass_RESULT_CODE) {
                this.mPassFlag = "2";
                showSixPasswordView();
                return;
            }
            return;
        }
        if ((i3 == ResetPass_RESULT_CODE || i3 == 2008) && !this.mIsSixPasswdUser) {
            this.mNormalPasswdEdit.setText("");
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(jSONObject.optString("retcode"))) {
            playPassWordWrrorAnim(jSONObject.optString("retmsg"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.fah) {
            com.tencent.mobileqq.qwallet.c.c("cash.pwd.go", Integer.valueOf(this.process_flag));
            sendWithdrawConfirmRequest();
        } else if (id5 == R.id.az7) {
            if (this.mBackKeyPressed) {
                com.tencent.mobileqq.qwallet.c.c("cash.pwd.keyback", Integer.valueOf(this.process_flag));
            } else {
                com.tencent.mobileqq.qwallet.c.c("cash.pwd.cancel", Integer.valueOf(this.process_flag));
            }
            if (!this.mIsSixPasswdUser) {
                QWalletUtils.hideSysKeyBorad(this.mNormalPasswdEdit);
            }
            setResult(0, null);
            finish();
        } else if (id5 == R.id.fjf) {
            Intent intent = new Intent();
            intent.putExtra("token_id", this.mPayTokenId);
            intent.putExtra("forget_pass", true);
            intent.putExtra("pass_flag", this.mPassFlag);
            launchFragmentForResult(intent, ResetPassBridgeActivity.class, ResetPass_RESULT_CODE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(8192);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initWithdrawInfo();
        View inflate = layoutInflater.inflate(R.layout.adt, viewGroup, false);
        this.mRootLayout = (LinearLayout) inflate.findViewById(R.id.root_layout);
        initView(inflate);
        com.tencent.mobileqq.qwallet.c.c("cash.pwd.show", Integer.valueOf(this.process_flag));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (str.equals(Cgi.URI_QWallet_CONFIRM_WITHDRAW)) {
            this.mDraw_id = jSONObject.optString(JSONConstant.KEY_DRAW_ID);
            this.mCharge_fee = jSONObject.optString(JSONConstant.KEY_CHARGE_FEE);
            this.mTransaction_id = jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID);
            String optString = jSONObject.optString("amount");
            String optString2 = jSONObject.optString("draw_succ_desc");
            if (TextUtils.isEmpty(optString)) {
                optString = this.mAmount;
            }
            go2WithdrawSuccessActivity(optString, optString2);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void sendWithdrawConfirmRequest() {
        HashMap hashMap = new HashMap();
        hashMap.put("amount", this.mAmount);
        hashMap.put("p", getPasswd());
        hashMap.put("bank_type", this.mBank_type);
        hashMap.put("card_tail", this.mCard_tail);
        hashMap.put("bank_name", this.mBank_name);
        hashMap.put("bind_serial", this.mBind_serial);
        hashMap.put("bank_true_name", this.mBank_true_name);
        hashMap.put(JSONConstant.KEY_DRAW_ID, this.mDraw_id);
        hashMap.put(WadlProxyConsts.CHANNEL, this.mChannel);
        hashMap.put("draw_type", this.mDraw_type);
        hashMap.put("free_type", this.mFree_type);
        hashMap.put("desc", this.mDraw_desc);
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put(JSONConstant.KEY_FEE_RATE, this.mFeeRate);
        hashMap.put(JSONConstant.KEY_CHARGE_FEE, this.mCharge_fee);
        httpRequestWithQQPayLoading(Cgi.URI_QWallet_CONFIRM_WITHDRAW, hashMap, this.mKeyboard.getHeight());
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
