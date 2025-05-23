package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.SuperFriendPayActivity;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class SuperFriendPayActivity extends NetBaseActivity implements View.OnClickListener {
    private ResultReceiver chooseFriendCallback;
    protected TextView mBackBtn;
    protected ImageButton mCloseBtn;
    protected Button mConfirmPayBtn;
    protected TextView mForgetPassBtn;
    protected MyKeyboardWindow mKeyboard;
    protected EditText mNormalPasswdEdit;
    private TextView mPayAmount;
    protected LinearLayout mPayAuthLayout;
    protected JSONObject mPayGateObj;
    protected String mPayerUin;
    protected View mRootLayout;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    private TextView mSuperFriendName;
    protected TextView mTitle;
    protected String mTokenId;
    protected TextView mTvGoodName;
    private LinearLayout passwd_layout;
    protected String mPassFlag = "2";
    private final int RESET_PSW_RESULT_CODE = 1;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.SuperFriendPayActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SuperFriendPayActivity.this.mPayAuthLayout.getVisibility() == 0) {
                if (SuperFriendPayActivity.this.getPasswd().length() > 5) {
                    if (!SuperFriendPayActivity.this.mConfirmPayBtn.isEnabled()) {
                        SuperFriendPayActivity.this.mConfirmPayBtn.setEnabled(true);
                        SuperFriendPayActivity.this.mConfirmPayBtn.setClickable(true);
                        return;
                    }
                    return;
                }
                if (SuperFriendPayActivity.this.mConfirmPayBtn.isEnabled()) {
                    SuperFriendPayActivity.this.mConfirmPayBtn.setClickable(false);
                    SuperFriendPayActivity.this.mConfirmPayBtn.setEnabled(false);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tenpay.sdk.activity.SuperFriendPayActivity$2, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$run$0(String str) {
            String str2 = SuperFriendPayActivity.this.mPayerUin;
            if (!TextUtils.isEmpty(str)) {
                str2 = str + "(" + SuperFriendPayActivity.this.mPayerUin + ")";
            }
            SuperFriendPayActivity.this.mSuperFriendName.setText(str2);
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            QWalletNickNameServer.b(null, SuperFriendPayActivity.this.mPayerUin, new Function1() { // from class: com.tenpay.sdk.activity.cv
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$run$0;
                    lambda$run$0 = SuperFriendPayActivity.AnonymousClass2.this.lambda$run$0((String) obj);
                    return lambda$run$0;
                }
            });
        }
    }

    private void clearPassword() {
        if (this.mPassFlag.equals("2")) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.setFocusable(true);
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        this.mConfirmPayBtn.setClickable(false);
        this.mConfirmPayBtn.setEnabled(false);
    }

    private void initData() {
        Intent intent = getIntent();
        this.mTokenId = intent.getStringExtra("token_id");
        this.mPayerUin = intent.getStringExtra("payer_uin");
        new BaseThread(new AnonymousClass2()).start();
        this.chooseFriendCallback = (ResultReceiver) intent.getParcelableExtra("choose_friend_callback");
        try {
            String stringExtra = intent.getStringExtra("pay_gate");
            if (stringExtra != null) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.mPayGateObj = jSONObject;
                this.mPassFlag = jSONObject.optString("pass_flag");
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void initView(View view) {
        View findViewById = view.findViewById(R.id.root_layout);
        this.mRootLayout = findViewById;
        findViewById.setVisibility(0);
        this.mPayAuthLayout = (LinearLayout) view.findViewById(R.id.a16);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitle = textView;
        textView.setText(R.string.ect);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView2;
        textView2.setOnClickListener(this);
        TextView textView3 = (TextView) view.findViewById(R.id.f165383cw2);
        this.mTvGoodName = textView3;
        textView3.setText(this.mGoodsName);
        TextView textView4 = (TextView) view.findViewById(R.id.fj7);
        this.mPayAmount = textView4;
        textView4.setText(Utils.transformToMoney(this.mTotalFee, 0));
        this.mSuperFriendName = (TextView) view.findViewById(R.id.f167058kb3);
        TextView textView5 = (TextView) view.findViewById(R.id.cja);
        this.mForgetPassBtn = textView5;
        textView5.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.b7s);
        this.mConfirmPayBtn = button;
        button.setOnClickListener(this);
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.SuperFriendPayActivity.3
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public void onTextChange() {
                if (SuperFriendPayActivity.this.mSixPasswdEdit.getInputText().length() > 5) {
                    SuperFriendPayActivity.this.mConfirmPayBtn.performClick();
                }
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.SuperFriendPayActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                if (SuperFriendPayActivity.this.mSixPasswdEdit.isFocused()) {
                    SuperFriendPayActivity.this.mHandler.post(new Runnable() { // from class: com.tenpay.sdk.activity.SuperFriendPayActivity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SuperFriendPayActivity.this.mKeyboard.setVisibility(0);
                            SuperFriendPayActivity superFriendPayActivity = SuperFriendPayActivity.this;
                            superFriendPayActivity.mKeyboard.setInputEditText(superFriendPayActivity.mSixPasswdEdit);
                        }
                    });
                }
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.SuperFriendPayActivity.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView6, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    if (SuperFriendPayActivity.this.getPasswd().length() > 5) {
                        SuperFriendPayActivity.this.mConfirmPayBtn.performClick();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView6, i3, keyEvent);
                return z16;
            }
        });
        this.passwd_layout = (LinearLayout) view.findViewById(R.id.fiq);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        if (Utils.getScreenWidth(getContext()) < 500) {
            this.mNormalPasswdEdit.setHint(R.string.e3t);
        }
        if (this.mPassFlag.equals("2")) {
            showSixPassWord();
        }
    }

    private void processReceiveData(JSONObject jSONObject) {
        try {
            jSONObject.optString("retmsg");
            putIntoPayGateObject("pay_time", jSONObject.getString("pay_time"));
            putIntoPayGateObject(CommonCode.MapKey.TRANSACTION_ID, jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
            putIntoPayGateObject("sp_billno", jSONObject.optString("sp_billno"));
            putIntoPayGateObject("pay_flag", jSONObject.optString("pay_flag"));
            putIntoPayGateObject("bargainor_id", jSONObject.optString("bargainor_id"));
            putIntoPayGateObject("sub_mch_id", jSONObject.optString("sub_mch_id"));
            putIntoPayGateObject("business_id", jSONObject.optString("business_id"));
            putIntoPayGateObject("callback_url", jSONObject.optString("callback_url"));
            Intent intent = new Intent();
            intent.putExtra("success", this.mPayGateObj.toString());
            intent.putExtra("isFriendPay", true);
            intent.putExtra("pass_flag", this.mPassFlag);
            intent.putExtra(StateEvent.ActionValue.STAGE_PASS, getPasswd());
            intent.putExtra("push_spwd_flag", this.mPayGateObj.optString("push_spwd_flag"));
            intent.putExtra("push_spwd_date", this.mPayGateObj.optString("push_spwd_date"));
            intent.putExtra("timestamp_old", (System.currentTimeMillis() / 1000) + this.mTimestamp);
            intent.putExtra("process_flag", getIntent().getStringExtra("process_flag"));
            setIntentData(intent);
            com.tencent.mobileqq.qwallet.pay.k.a(getContext(), intent);
            uploadFriendPayData("autofriendpay.pay.succ");
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_super_pay", true);
            this.chooseFriendCallback.send(0, bundle);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        } catch (Exception e17) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e17);
        }
    }

    private void putIntoPayGateObject(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.mPayGateObj.put(str, str2);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    private void showSixPassWord() {
        this.mNormalPasswdEdit.setVisibility(8);
        this.mSixPasswdEdit.setVisibility(0);
        this.mSixPasswdEdit.requestFocus();
        this.mConfirmPayBtn.setVisibility(8);
    }

    private void uploadFriendPayData(String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    private void validatePasswd() {
        HashMap hashMap = new HashMap();
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("p", getPasswd());
        hashMap.put("payer_uin", this.mPayerUin);
        hashMap.put("timestamp", this.mTimestamp + "");
        httpRequest(Cgi.URL_FRIEND_QPAY_SPFA_PAY, hashMap);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.mKeyboard.getVisibility() == 0) {
                this.mKeyboard.setVisibility(8);
                return true;
            }
            if (this.mPayAuthLayout.getVisibility() == 0) {
                finish();
                return true;
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    protected String getPasswd() {
        if (this.mPassFlag.equals("2")) {
            return this.mSixPasswdEdit.getInputText();
        }
        return this.mNormalPasswdEdit.getText().toString();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void gotoResetPassWord() {
        Intent intent = new Intent();
        intent.putExtra("forget_pass", true);
        intent.putExtra("pass_flag", this.mPassFlag);
        launchFragmentForResult(intent, ResetPassBridgeActivity.class, 1);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 == 1) {
                WalletGateData.getInstance().clear();
                this.mPassFlag = "2";
                showSixPassWord();
                clearPassword();
                return;
            }
            return;
        }
        if (i3 == 1) {
            clearPassword();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        uploadFriendPayData("autofriendpay.pay.fail");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.b7s) {
            validatePasswd();
        } else if (id5 == R.id.cja) {
            gotoResetPassWord();
        } else if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.az7) {
            if ((id5 == R.id.iwz || id5 == R.id.knc) && !this.mKeyboard.isShown()) {
                this.mKeyboard.setVisibility(0);
            }
        } else {
            QwLog.i("onClick id = " + id5);
            finish();
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
        getWindow().setSoftInputMode(19);
        View inflate = layoutInflater.inflate(R.layout.agi, viewGroup, false);
        initView(inflate);
        initData();
        uploadFriendPayData("autofriendpay.pay.verifyshow");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        clearPassword();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        processReceiveData(jSONObject);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
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
