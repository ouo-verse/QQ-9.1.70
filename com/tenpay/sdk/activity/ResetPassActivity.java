package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ResetPassActivity extends NetBaseActivity implements View.OnClickListener {
    public static String BROADCAST_INTENT_ACTION_RESET_PWD_SUCCESS = "com.tenpay.sdk.pwd.reset";
    protected static final int ONE_MINUTE = 59;
    protected static int mLeftTime = 59;
    protected Button mActivate2Btn;
    protected LinearLayout mActivateLayout;
    protected TextView mBackBtn;
    protected MyKeyboardWindow mKeyboardWindow;
    protected Button mNextBtn;
    protected SixPasswdDialogEditText mPassAgainEdit;
    protected SixPasswdDialogEditText mPassEdit;
    protected HashMap<String, String> mPreData;
    protected RelativeLayout mRepeatLayout;
    protected EditText mThirdEdit;
    protected LinearLayout mThirdLayout;
    protected TextView mThirdPhoneTextView;
    protected Button mThirdResendBtn;
    protected Timer mTimer;
    protected String mYzm;
    private boolean mIsFromIdVerify = false;
    private View.OnClickListener mSixOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ResetPassActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ResetPassActivity.this.mKeyboardWindow.setVisibility(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.ResetPassActivity.2
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (ResetPassActivity.this.mThirdLayout.getVisibility() == 0) {
                if (ResetPassActivity.this.mThirdEdit.getText().toString().trim().length() > 5) {
                    if (!ResetPassActivity.this.mNextBtn.isEnabled()) {
                        ResetPassActivity resetPassActivity = ResetPassActivity.this;
                        if (!resetPassActivity.mIsMidas) {
                            resetPassActivity.addTraceData("enable");
                        }
                    }
                    ResetPassActivity.this.mNextBtn.setClickable(true);
                    ResetPassActivity.this.mNextBtn.setEnabled(true);
                    return;
                }
                if (ResetPassActivity.this.mNextBtn.isEnabled()) {
                    ResetPassActivity resetPassActivity2 = ResetPassActivity.this;
                    if (!resetPassActivity2.mIsMidas) {
                        resetPassActivity2.addTraceData("disable");
                    }
                }
                ResetPassActivity.this.mNextBtn.setClickable(false);
                ResetPassActivity.this.mNextBtn.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    protected OnPasswdInputListener mOnPasswdInputListener = new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.ResetPassActivity.3
        @Override // com.tenpay.sdk.view.OnPasswdInputListener
        public void onTextChange() {
            if (ResetPassActivity.this.mActivateLayout.getVisibility() == 0) {
                if (ResetPassActivity.this.mPassEdit.getInputText().trim().length() > 5) {
                    ResetPassActivity resetPassActivity = ResetPassActivity.this;
                    if (resetPassActivity.mIsMidas) {
                        resetPassActivity.addTraceData("autojump");
                    } else {
                        resetPassActivity.addTraceData("pagesecond");
                    }
                    ResetPassActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ResetPassActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ResetPassActivity.this.mActivateLayout.setVisibility(8);
                            ResetPassActivity.this.mRepeatLayout.setVisibility(0);
                            ResetPassActivity resetPassActivity2 = ResetPassActivity.this;
                            if (!resetPassActivity2.mIsMidas) {
                                resetPassActivity2.addTraceData("show");
                            }
                            ResetPassActivity.this.mPassAgainEdit.requestFocus();
                            ResetPassActivity resetPassActivity3 = ResetPassActivity.this;
                            resetPassActivity3.mKeyboardWindow.setInputEditText(resetPassActivity3.mPassAgainEdit);
                            ResetPassActivity.this.mKeyboardWindow.setXMode(3);
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            if (ResetPassActivity.this.mRepeatLayout.getVisibility() == 0) {
                if (ResetPassActivity.this.mPassAgainEdit.getInputText().trim().length() > 5) {
                    if (!ResetPassActivity.this.mActivate2Btn.isEnabled()) {
                        ResetPassActivity resetPassActivity2 = ResetPassActivity.this;
                        if (!resetPassActivity2.mIsMidas) {
                            resetPassActivity2.addTraceData("enable");
                        }
                    }
                    ResetPassActivity.this.mActivate2Btn.setClickable(true);
                    ResetPassActivity.this.mActivate2Btn.setEnabled(true);
                    return;
                }
                if (ResetPassActivity.this.mActivate2Btn.isEnabled()) {
                    ResetPassActivity resetPassActivity3 = ResetPassActivity.this;
                    if (!resetPassActivity3.mIsMidas) {
                        resetPassActivity3.addTraceData("disable");
                    }
                }
                ResetPassActivity.this.mActivate2Btn.setClickable(false);
                ResetPassActivity.this.mActivate2Btn.setEnabled(false);
            }
        }
    };
    protected HashMap<String, String> mBankData = new HashMap<>();
    protected final Handler mTimeHandler = new Handler() { // from class: com.tenpay.sdk.activity.ResetPassActivity.6
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ResetPassActivity.mLeftTime--;
            String string = ResetPassActivity.this.getString(R.string.ede);
            if (ResetPassActivity.mLeftTime > 0) {
                string = string + "(" + ResetPassActivity.mLeftTime + ")";
                ResetPassActivity.this.mThirdResendBtn.setClickable(false);
            } else {
                ResetPassActivity.this.mThirdResendBtn.setClickable(true);
                ResetPassActivity.this.mTimer.cancel();
                ResetPassActivity.mLeftTime = 59;
            }
            ResetPassActivity.this.mThirdResendBtn.setText(string);
        }
    };

    private void back() {
        if (this.mRepeatLayout.getVisibility() == 0) {
            this.mActivateLayout.setVisibility(0);
            this.mRepeatLayout.setVisibility(8);
            if (!this.mIsMidas) {
                addTraceData("show");
            }
            this.mPassEdit.setInputText("");
            this.mPassAgainEdit.setInputText("");
            this.mPassEdit.requestFocus();
            this.mKeyboardWindow.setInputEditText(this.mPassEdit);
            this.mKeyboardWindow.setXMode(0);
            return;
        }
        finish();
    }

    protected void addTraceData(String str) {
        String str2;
        int i3;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mIsMidas) {
            stringBuffer.append("tenpay.resetwd.");
            stringBuffer.append(str);
            TenpayUtil.addMidasUploadData(10, stringBuffer.toString());
            return;
        }
        if (this.mRepeatLayout.getVisibility() == 0) {
            str2 = "setpwd.second.";
        } else if (this.mThirdLayout.getVisibility() == 0) {
            str2 = "bigpay.sms.";
        } else {
            str2 = "setpwd.first.";
        }
        stringBuffer.append(str2);
        stringBuffer.append(str);
        if (this.mEnterType == 1) {
            i3 = 107;
        } else {
            i3 = 7;
        }
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(i3));
    }

    protected void closeTime() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mLeftTime = 59;
        this.mThirdResendBtn.setText(getString(R.string.ede));
        this.mThirdResendBtn.setEnabled(true);
        this.mThirdResendBtn.setClickable(true);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            MyKeyboardWindow myKeyboardWindow = this.mKeyboardWindow;
            if (myKeyboardWindow != null && myKeyboardWindow.getVisibility() == 0) {
                this.mKeyboardWindow.setVisibility(8);
                return true;
            }
            addTraceData("keyback");
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initTimer() {
        String str = getString(R.string.ede) + "(" + mLeftTime + ")";
        this.mThirdResendBtn.setClickable(false);
        this.mThirdResendBtn.setText(str);
        TimerTask timerTask = new TimerTask() { // from class: com.tenpay.sdk.activity.ResetPassActivity.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ResetPassActivity.this.mTimeHandler.sendMessage(new Message());
            }
        };
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.mTimer = baseTimer;
        baseTimer.schedule(timerTask, 1000L, 1000L);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        if (str.equals(Cgi.URI_RESET_PASS)) {
            String optString = jSONObject.optString("retcode");
            if (ErrorCode.ERR_REGISTER_TIME_OUT.equals(optString)) {
                this.mActivateLayout.setVisibility(8);
                this.mRepeatLayout.setVisibility(8);
                this.mThirdLayout.setVisibility(0);
                addTraceData("show");
                QwLog.i("\u7eaf\u7ed1\u5361");
                httpRequest(Cgi.URI_CFT_USER_AUTHEN, this.mBankData);
                this.mThirdEdit.requestFocus();
                this.mKeyboardWindow.setXMode(3);
                this.mKeyboardWindow.setInputEditText(this.mThirdEdit);
                return;
            }
            if (ErrorCode.ERR_PAYPASS_TIMEOUT.equals(optString)) {
                httpRequest(Cgi.URI_GET_PASS_TIME, new HashMap());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            addTraceData("back");
            back();
        } else if (id5 == R.id.jdq) {
            if (this.mIsMidas) {
                addTraceData("sure");
            } else {
                addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
            }
            String inputText = this.mPassEdit.getInputText();
            String inputText2 = this.mPassAgainEdit.getInputText();
            if (!Utils.isEmpty(inputText) && !Utils.isEmpty(inputText2)) {
                if (!inputText.equals(inputText2)) {
                    QQToast.makeText(getContext(), R.string.efx, 0).show();
                    if (!this.mIsMidas) {
                        addTraceData("errorback");
                    }
                    this.mActivateLayout.setVisibility(0);
                    this.mRepeatLayout.setVisibility(8);
                    if (!this.mIsMidas) {
                        addTraceData("show");
                    }
                    this.mPassEdit.setInputText("");
                    this.mPassAgainEdit.setInputText("");
                    this.mPassEdit.requestFocus();
                    this.mKeyboardWindow.setInputEditText(this.mPassEdit);
                    this.mKeyboardWindow.setXMode(0);
                } else if (this.mIsFromIdVerify) {
                    HashMap hashMap = new HashMap(this.mPreData);
                    hashMap.put("uin", this.mUin);
                    hashMap.put("p", this.mPassEdit.getInputText().trim());
                    hashMap.put("timestamp", this.mTimestamp + "");
                    httpRequest(Cgi.URI_QWallet_AUTH_RESET_PASSWD, hashMap);
                } else {
                    HashMap hashMap2 = new HashMap(this.mBankData);
                    hashMap2.put("uin", this.mUin);
                    hashMap2.put("p", this.mPassEdit.getInputText().trim());
                    hashMap2.put("timestamp", this.mTimestamp + "");
                    hashMap2.put("wap_token", this.mPreData.get("wap_token"));
                    hashMap2.put("verify_code", this.mYzm);
                    httpRequest(Cgi.URI_RESET_PASS, hashMap2);
                }
            } else {
                QQToast.makeText(getContext(), R.string.efw, 0).show();
            }
        } else if (id5 == R.id.f166961jf2) {
            if (!this.mIsMidas) {
                addTraceData("reacquire");
            }
            QwLog.i("\u7eaf\u7ed1\u5361");
            this.mBankData.put("is_reentry", "1");
            httpRequest(Cgi.URI_CFT_USER_AUTHEN, this.mBankData);
        } else if (id5 == R.id.jez) {
            addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
            String trim = this.mThirdEdit.getText().toString().trim();
            if (Utils.isEmpty(trim)) {
                QQToast.makeText(getContext(), R.string.efz, 0).show();
            } else {
                this.mYzm = trim;
                HashMap<String, String> hashMap3 = this.mBankData;
                hashMap3.put("uin", this.mUin);
                hashMap3.put("p", this.mPassEdit.getInputText().trim());
                hashMap3.put("timestamp", this.mTimestamp + "");
                hashMap3.put("wap_token", this.mPreData.get("wap_token"));
                hashMap3.put("verify_code", this.mYzm);
                hashMap3.put("reset_pwd_flag", "1");
                httpRequest(Cgi.URI_RESET_PASS, hashMap3);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(8192);
        Intent intent = getIntent();
        if (intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("from_id_verify", false);
            this.mIsFromIdVerify = booleanExtra;
            if (booleanExtra) {
                this.mPreData = (HashMap) intent.getSerializableExtra("data");
                return;
            }
            this.mPreData = (HashMap) intent.getSerializableExtra("data");
            if (intent.hasExtra("bink_data")) {
                Serializable serializableExtra = intent.getSerializableExtra("bink_data");
                if (serializableExtra instanceof HashMap) {
                    this.mBankData = (HashMap) serializableExtra;
                }
            }
            this.mYzm = intent.getStringExtra("yzm");
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168574ad1, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mTimeHandler.removeCallbacksAndMessages(null);
        closeTime();
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (Cgi.URI_RESET_PASS.equals(str)) {
            this.mKeyboardWindow.setVisibility(8);
            sendBroadcast(new Intent(BROADCAST_INTENT_ACTION_RESET_PWD_SUCCESS));
            IdVerifyHintModule.startCommonSuccessHint(this, getString(R.string.e1l));
            setResult(-1);
            return;
        }
        if (Cgi.URI_CFT_USER_AUTHEN.equals(str)) {
            this.mPreData = Utils.jsonToMap(jSONObject.toString());
            initTimer();
            return;
        }
        if (str.equals(Cgi.URI_GET_PASS_TIME)) {
            String optString = jSONObject.optString(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP);
            if (optString.length() == 20) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < optString.length(); i3++) {
                    if (i3 % 2 == 1) {
                        stringBuffer.append(optString.charAt(i3));
                    }
                }
                this.mTimestamp = Long.parseLong(stringBuffer.toString()) - (System.currentTimeMillis() / 1000);
                return;
            }
            this.mTimestamp = Long.parseLong(optString) - (System.currentTimeMillis() / 1000);
            return;
        }
        if (str.equals(Cgi.URI_QWallet_AUTH_RESET_PASSWD)) {
            this.mKeyboardWindow.setVisibility(8);
            sendBroadcast(new Intent(BROADCAST_INTENT_ACTION_RESET_PWD_SUCCESS));
            IdVerifyHintModule.startCommonSuccessHint(this, getString(R.string.e1l));
            setResult(-1);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        this.mActivateLayout = (LinearLayout) view.findViewById(R.id.jdj);
        ((TextView) view.findViewById(R.id.jed)).setText(R.string.eck);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.jeb);
        this.mPassEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setOnClickListener(this.mSixOnClickListener);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView;
        textView.setOnClickListener(this);
        this.mPassEdit.setOnPasswdInputListener(this.mOnPasswdInputListener);
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mKeyboardWindow = myKeyboardWindow;
        myKeyboardWindow.setVisibility(0);
        this.mKeyboardWindow.setInputEditText(this.mPassEdit);
        this.mKeyboardWindow.setXMode(0);
        this.mRepeatLayout = (RelativeLayout) view.findViewById(R.id.jdi);
        SixPasswdDialogEditText sixPasswdDialogEditText2 = (SixPasswdDialogEditText) view.findViewById(R.id.jec);
        this.mPassAgainEdit = sixPasswdDialogEditText2;
        sixPasswdDialogEditText2.setOnClickListener(this.mSixOnClickListener);
        this.mPassAgainEdit.setOnPasswdInputListener(this.mOnPasswdInputListener);
        this.mPassAgainEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ResetPassActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    ResetPassActivity.this.mActivate2Btn.performClick();
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return false;
            }
        });
        Button button = (Button) view.findViewById(R.id.jdq);
        this.mActivate2Btn = button;
        button.setOnClickListener(this);
        this.mActivate2Btn.setEnabled(false);
        this.mActivate2Btn.setClickable(false);
        this.mThirdLayout = (LinearLayout) view.findViewById(R.id.f166962jf3);
        EditText editText = (EditText) view.findViewById(R.id.f166959jf0);
        this.mThirdEdit = editText;
        QWalletUtils.hideSysKeyBorad(editText);
        this.mThirdEdit.addTextChangedListener(this.mTextWatcher);
        this.mThirdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ResetPassActivity.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    ResetPassActivity.this.mNextBtn.performClick();
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return false;
            }
        });
        Button button2 = (Button) view.findViewById(R.id.f166961jf2);
        this.mThirdResendBtn = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) view.findViewById(R.id.jez);
        this.mNextBtn = button3;
        button3.setOnClickListener(this);
        this.mNextBtn.setEnabled(false);
        this.mNextBtn.setClickable(false);
        this.mThirdPhoneTextView = (TextView) view.findViewById(R.id.f166960jf1);
        if (!this.mIsFromIdVerify) {
            String str2 = this.mBankData.get(DeviceType.DeviceCategory.MOBILE);
            if (!TextUtils.isEmpty(str2) && str2.length() == 11) {
                str = (str2.substring(0, 3) + "******") + str2.substring(9, 11);
            } else {
                str = "";
            }
            this.mThirdPhoneTextView.setText(str);
        }
        addTraceData("show");
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
