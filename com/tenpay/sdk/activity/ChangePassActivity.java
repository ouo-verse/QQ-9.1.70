package com.tenpay.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.ChangePassActivity;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ChangePassActivity extends NetBaseActivity implements View.OnClickListener {
    public static String BROADCAST_INTENT_ACTION_CHANGE_PWD_SUCCESS = "com.tenpay.sdk.pwd.change";
    protected static final int ONE_MINUTE = 59;
    protected Button mActivate2Btn;
    protected LinearLayout mActivateLayout;
    protected TextView mBackBtn;
    protected TextView mCancelBtn;
    private boolean mFromH5;
    private boolean mFromSixPassGuide;
    private TextView mHintAginLayout;
    private TextView mHintLayout;
    protected MyKeyboardWindow mKeyboardWindow;
    protected Object mMobile;
    protected boolean mNeedMobile;
    protected Button mNextBtn;
    protected Button mOldActivateBtn;
    protected LinearLayout mOldLayout;
    protected ClearableEditText mOldPassEdit;
    protected SixPasswdDialogEditText mOldPassEditSix;
    protected SixPasswdDialogEditText mPassAgainEdit;
    protected String mPassCache;
    protected SixPasswdDialogEditText mPassEdit;
    protected int mPassFlag;
    private LinearLayout mPassLayout;
    protected Button mPhoneActivateBtn;
    protected EditText mPhoneEdit;
    protected LinearLayout mPhoneLayout;
    protected ProgressBar mProgressBar;
    protected LinearLayout mRepeatLayout;
    private boolean mResend;
    private LinearLayout mRootLayout;
    protected EditText mThirdEdit;
    protected LinearLayout mThirdLayout;
    protected TextView mThirdPhoneTextView;
    protected Button mThirdResendBtn;
    protected Timer mTimer;
    protected TextView mTitle;
    int mViewIndex;
    private boolean entry_mark_resetpwd = false;
    private final BroadcastReceiver mResetPwdSuccessReceiver = new BroadcastReceiver() { // from class: com.tenpay.sdk.activity.ChangePassActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ResetPassActivity.BROADCAST_INTENT_ACTION_RESET_PWD_SUCCESS.equals(intent.getAction())) {
                ChangePassActivity.this.finish();
            }
        }
    };
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.ChangePassActivity.2
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (ChangePassActivity.this.mPhoneLayout.getVisibility() == 0) {
                if (ChangePassActivity.this.mPhoneEdit.getText().toString().trim().length() > 10) {
                    if (!ChangePassActivity.this.mPhoneActivateBtn.isEnabled()) {
                        ChangePassActivity.this.addTraceData("enable");
                    }
                    ChangePassActivity.this.mPhoneActivateBtn.setClickable(true);
                    ChangePassActivity.this.mPhoneActivateBtn.setEnabled(true);
                    return;
                }
                if (ChangePassActivity.this.mPhoneActivateBtn.isEnabled()) {
                    ChangePassActivity.this.addTraceData("disable");
                }
                ChangePassActivity.this.mPhoneActivateBtn.setClickable(false);
                ChangePassActivity.this.mPhoneActivateBtn.setEnabled(false);
                return;
            }
            if (ChangePassActivity.this.mThirdLayout.getVisibility() == 0) {
                if (ChangePassActivity.this.mThirdEdit.getText().toString().trim().length() > 5) {
                    if (!ChangePassActivity.this.mNextBtn.isEnabled()) {
                        ChangePassActivity.this.addTraceData("enable");
                    }
                    ChangePassActivity.this.mNextBtn.setClickable(true);
                    ChangePassActivity.this.mNextBtn.setEnabled(true);
                    return;
                }
                if (ChangePassActivity.this.mNextBtn.isEnabled()) {
                    ChangePassActivity.this.addTraceData("disable");
                }
                ChangePassActivity.this.mNextBtn.setClickable(false);
                ChangePassActivity.this.mNextBtn.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    protected OnPasswdInputListener mOnPasswdInputListener = new AnonymousClass3();
    private View.OnClickListener mSixOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChangePassActivity.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ChangePassActivity.this.mKeyboardWindow.setVisibility(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    protected int mLeftTime = 59;
    protected final Handler mTimeHandler = new Handler() { // from class: com.tenpay.sdk.activity.ChangePassActivity.5
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChangePassActivity changePassActivity = ChangePassActivity.this;
            changePassActivity.mLeftTime--;
            String string = changePassActivity.getString(R.string.ede);
            ChangePassActivity changePassActivity2 = ChangePassActivity.this;
            if (changePassActivity2.mLeftTime > 0) {
                string = string + "(" + ChangePassActivity.this.mLeftTime + ")";
                ChangePassActivity.this.mThirdResendBtn.setClickable(false);
                ChangePassActivity.this.mThirdResendBtn.setEnabled(false);
            } else {
                changePassActivity2.mThirdResendBtn.setClickable(true);
                ChangePassActivity.this.mThirdResendBtn.setEnabled(true);
                ChangePassActivity.this.mTimer.cancel();
                ChangePassActivity.this.mLeftTime = 59;
            }
            ChangePassActivity.this.mThirdResendBtn.setText(string);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tenpay.sdk.activity.ChangePassActivity$3, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass3 implements OnPasswdInputListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChange$0() {
            ChangePassActivity.this.addTraceData(138, "setpwd.second.show");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTextChange$1() {
            ChangePassActivity changePassActivity = ChangePassActivity.this;
            changePassActivity.mViewIndex++;
            changePassActivity.manageView();
        }

        @Override // com.tenpay.sdk.view.OnPasswdInputListener
        public void onTextChange() {
            if (ChangePassActivity.this.mPassLayout.getVisibility() == 0) {
                String trim = ChangePassActivity.this.mPassEdit.getInputText().trim();
                if (trim.length() > 5) {
                    ChangePassActivity changePassActivity = ChangePassActivity.this;
                    String str = changePassActivity.mPassCache;
                    if (str == null) {
                        changePassActivity.mPassCache = trim;
                        changePassActivity.addTraceData("pagesecond");
                        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
                        translateAnimation.setDuration(200L);
                        ChangePassActivity.this.mHintLayout.startAnimation(translateAnimation);
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                        translateAnimation2.setDuration(200L);
                        ChangePassActivity.this.mHintAginLayout.setVisibility(0);
                        ChangePassActivity.this.mHintAginLayout.startAnimation(translateAnimation2);
                        ChangePassActivity.this.mHintLayout.setVisibility(8);
                        ChangePassActivity.this.mPassEdit.setInputText("");
                        ChangePassActivity.this.mTimeHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.x
                            @Override // java.lang.Runnable
                            public final void run() {
                                ChangePassActivity.AnonymousClass3.this.lambda$onTextChange$0();
                            }
                        }, 400L);
                        return;
                    }
                    if (!str.equals(trim)) {
                        QUIProxy.createCustomDialog(ChangePassActivity.this.getContext(), 230, null, "\u4e24\u6b21\u8f93\u5165\u7684\u5bc6\u7801\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165", ChangePassActivity.this.getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ChangePassActivity.3.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                TranslateAnimation translateAnimation3 = new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
                                translateAnimation3.setDuration(200L);
                                ChangePassActivity.this.mHintLayout.startAnimation(translateAnimation3);
                                TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
                                translateAnimation4.setDuration(200L);
                                ChangePassActivity.this.mHintAginLayout.setVisibility(8);
                                ChangePassActivity.this.mHintAginLayout.startAnimation(translateAnimation4);
                                ChangePassActivity.this.mHintLayout.setVisibility(0);
                                dialogInterface.dismiss();
                                ChangePassActivity.this.mPassEdit.setInputText("");
                            }
                        });
                        ChangePassActivity.this.mPassCache = null;
                        return;
                    } else {
                        ChangePassActivity.this.mActivate2Btn.performClick();
                        return;
                    }
                }
                return;
            }
            if (ChangePassActivity.this.mOldLayout.getVisibility() == 0) {
                String trim2 = ChangePassActivity.this.mOldPassEditSix.getInputText().trim();
                if (trim2.length() > 5) {
                    ChangePassActivity.this.validatePayPass(trim2);
                    return;
                }
                return;
            }
            if (ChangePassActivity.this.mActivateLayout.getVisibility() == 0) {
                if (ChangePassActivity.this.mPassEdit.getInputText().trim().length() > 5) {
                    ChangePassActivity.this.addTraceData("pagesecond");
                    ChangePassActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.y
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChangePassActivity.AnonymousClass3.this.lambda$onTextChange$1();
                        }
                    }, 500L);
                    return;
                }
                return;
            }
            if (ChangePassActivity.this.mRepeatLayout.getVisibility() == 0) {
                if (ChangePassActivity.this.mPassAgainEdit.getInputText().trim().length() > 5) {
                    if (!ChangePassActivity.this.mActivate2Btn.isEnabled()) {
                        ChangePassActivity.this.addTraceData("enable");
                    }
                    ChangePassActivity.this.mActivate2Btn.setClickable(true);
                    ChangePassActivity.this.mActivate2Btn.setEnabled(true);
                    return;
                }
                if (ChangePassActivity.this.mActivate2Btn.isEnabled()) {
                    ChangePassActivity.this.addTraceData("disable");
                }
                ChangePassActivity.this.mActivate2Btn.setClickable(false);
                ChangePassActivity.this.mActivate2Btn.setEnabled(false);
            }
        }
    }

    private void back() {
        if (3 == this.mViewIndex && this.entry_mark_resetpwd) {
            finish();
            return;
        }
        QwLog.i("mFromSixPassGuide" + this.mFromSixPassGuide);
        if (this.mFromSixPassGuide) {
            finish();
            return;
        }
        int i3 = this.mViewIndex;
        if (i3 == 0) {
            setRetCodeAndErrorMsg(-1, "");
            TenUtils.notifyToExit(getContext(), this.mProssesID);
            finish();
        } else if (i3 != 3 && i3 != 1) {
            this.mViewIndex = i3 - 1;
            manageView();
        } else {
            finish();
        }
    }

    private void changePwdRequest() {
        addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
        if (!this.mFromSixPassGuide && !checkResetPwdRight()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        if (this.mFromSixPassGuide) {
            hashMap.put("timestamp_old", getIntent().getStringExtra("timestamp_old"));
        }
        hashMap.put("p", getOldPasswd());
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("n_p", TenUtils.getEncWithMacPasswd(getContext(), this.mPassEdit.getInputText(), this.mTimestamp));
        httpRequest(Cgi.URI_CHANGE_PWD, hashMap);
    }

    private boolean checkResetPwdRight() {
        String inputText = this.mPassEdit.getInputText();
        String inputText2 = this.mPassAgainEdit.getInputText();
        if (!Utils.isEmpty(inputText) && !Utils.isEmpty(inputText2)) {
            if (inputText.equals(inputText2)) {
                return true;
            }
            addTraceData("errorback");
            this.mViewIndex--;
            manageView();
            QQToast.makeText(getContext(), R.string.efx, 0).show();
            return false;
        }
        QQToast.makeText(getContext(), R.string.efw, 0).show();
        return false;
    }

    private String getOldPasswd() {
        if (this.mFromSixPassGuide) {
            return getIntent().getStringExtra(StateEvent.ActionValue.STAGE_PASS);
        }
        if (this.mOldPassEdit.getVisibility() == 0) {
            return this.mOldPassEdit.getText().toString().trim();
        }
        return this.mOldPassEditSix.getInputText().trim();
    }

    private void initView(Intent intent) {
        if (this.mFromSixPassGuide && intent != null) {
            int i3 = 1;
            if (intent.getIntExtra("bind_mobile_flag", 0) == 1) {
                i3 = 3;
            }
            this.mViewIndex = i3;
            manageView();
        } else if (!this.mFromH5) {
            if (this.mPassFlag == 2) {
                this.mOldPassEditSix.setVisibility(0);
                this.mOldActivateBtn.setVisibility(8);
                this.mOldPassEdit.setVisibility(8);
                this.mOldPassEditSix.requestFocus();
                this.mKeyboardWindow.setVisibility(0);
                this.mKeyboardWindow.setInputEditText(this.mOldPassEditSix);
                this.mKeyboardWindow.setXMode(0);
            } else {
                this.mOldPassEditSix.setVisibility(8);
                this.mOldActivateBtn.setVisibility(0);
                this.mOldPassEdit.setVisibility(0);
                this.mOldPassEdit.requestFocus();
                this.mKeyboardWindow.setVisibility(8);
                Utils.touchEditText(this.mHandler, this.mOldPassEdit);
            }
            addTraceData("show");
        }
        if (this.entry_mark_resetpwd) {
            this.mViewIndex = 3;
            manageView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0() {
        this.mOldActivateBtn.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$1(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 66) {
            this.mPhoneActivateBtn.performClick();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onCreateView$2(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 66) {
            this.mNextBtn.performClick();
            return false;
        }
        return false;
    }

    private void observerResetPwdSuccess() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ResetPassActivity.BROADCAST_INTENT_ACTION_RESET_PWD_SUCCESS);
        registerReceiver(this.mResetPwdSuccessReceiver, intentFilter);
    }

    private void resetPwdRequest() {
        if (!checkResetPwdRight()) {
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("tokenid");
        String stringExtra2 = intent.getStringExtra("verify_code");
        String stringExtra3 = intent.getStringExtra("idkey");
        String stringExtra4 = intent.getStringExtra("busi_info");
        HashMap hashMap = new HashMap();
        hashMap.put("tokenid", stringExtra);
        hashMap.put("verify_code", stringExtra2);
        hashMap.put("uin", this.mUin);
        hashMap.put("p", this.mPassEdit.getInputText());
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("idkey", stringExtra3);
        hashMap.put("busi_info", stringExtra4);
        httpRequest(Cgi.URI_RESET_PWD, hashMap);
    }

    private void sendQueryUserIfNoResetPwd() {
        if (this.entry_mark_resetpwd) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        httpRequest(Cgi.URI_QUERY_USER, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validatePayPass(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("purchaser_id", this.mUin);
        hashMap.put("p", str);
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("check_cft_bindmobile", "1");
        httpRequest(Cgi.URI_VALIDATE_PAY_PASS, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r1 != 4) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void addTraceData(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = this.mViewIndex;
        String str2 = "changepwd.old.";
        if (i3 != 0) {
            if (i3 == 1) {
                str2 = "changepwd.tel.";
            } else if (i3 == 2) {
                str2 = "bigpay.sms.";
            } else if (i3 == 3) {
                if (!"disable".equals(str)) {
                    str2 = "setpwd.first.";
                }
                str2 = "setpwd.second.";
            }
        }
        stringBuffer.append(str2);
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(getProcessType()));
    }

    protected void closeTime() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mLeftTime = 59;
        this.mThirdResendBtn.setText(getString(R.string.ede));
        this.mThirdResendBtn.setEnabled(true);
        this.mThirdResendBtn.setClickable(true);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        if (this.mFromSixPassGuide) {
            return 138;
        }
        if (this.mNeedMobile) {
            return 106;
        }
        return 105;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initTimer() {
        String str = getString(R.string.ede) + "(" + this.mLeftTime + ")";
        this.mThirdResendBtn.setClickable(false);
        this.mThirdResendBtn.setEnabled(false);
        this.mThirdResendBtn.setText(str);
        TimerTask timerTask = new TimerTask() { // from class: com.tenpay.sdk.activity.ChangePassActivity.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ChangePassActivity.this.mTimeHandler.sendMessage(new Message());
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

    void manageView() {
        QwLog.i("mViewIndex = " + this.mViewIndex);
        if (this.entry_mark_resetpwd) {
            this.mRootLayout.setVisibility(0);
        }
        int i3 = this.mViewIndex;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.mBackBtn.setVisibility(0);
                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                            if (inputMethodManager != null) {
                                inputMethodManager.hideSoftInputFromWindow(this.mOldPassEditSix.getWindowToken(), 0);
                            }
                            this.mTitle.setText("");
                            this.mOldLayout.setVisibility(8);
                            this.mPhoneLayout.setVisibility(8);
                            this.mThirdLayout.setVisibility(8);
                            this.mActivateLayout.setVisibility(8);
                            this.mRepeatLayout.setVisibility(0);
                            this.mPassAgainEdit.requestFocus();
                            this.mKeyboardWindow.setVisibility(0);
                            this.mKeyboardWindow.setInputEditText(this.mPassAgainEdit);
                            this.mKeyboardWindow.setXMode(0);
                        }
                    } else {
                        this.mBackBtn.setVisibility(0);
                        InputMethodManager inputMethodManager2 = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                        if (inputMethodManager2 != null) {
                            inputMethodManager2.hideSoftInputFromWindow(this.mOldPassEditSix.getWindowToken(), 0);
                        }
                        this.mTitle.setText("");
                        this.mPassAgainEdit.setInputText("");
                        this.mOldLayout.setVisibility(8);
                        this.mPhoneLayout.setVisibility(8);
                        this.mThirdLayout.setVisibility(8);
                        this.mActivateLayout.setVisibility(0);
                        this.mRepeatLayout.setVisibility(8);
                        this.mPassEdit.requestFocus();
                        this.mKeyboardWindow.setVisibility(0);
                        this.mKeyboardWindow.setInputEditText(this.mPassEdit);
                        this.mKeyboardWindow.setXMode(0);
                        this.mPassEdit.setInputText("");
                    }
                } else {
                    InputMethodManager inputMethodManager3 = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (inputMethodManager3 != null) {
                        inputMethodManager3.hideSoftInputFromWindow(this.mOldPassEditSix.getWindowToken(), 0);
                    }
                    this.mBackBtn.setVisibility(0);
                    this.mTitle.setText(R.string.e9w);
                    this.mOldLayout.setVisibility(8);
                    this.mPhoneLayout.setVisibility(8);
                    this.mThirdLayout.setVisibility(0);
                    this.mActivateLayout.setVisibility(8);
                    this.mRepeatLayout.setVisibility(8);
                    this.mKeyboardWindow.setVisibility(0);
                    this.mKeyboardWindow.setInputEditText(this.mThirdEdit);
                    this.mThirdEdit.requestFocus();
                    this.mKeyboardWindow.setXMode(3);
                }
            } else {
                InputMethodManager inputMethodManager4 = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager4 != null) {
                    inputMethodManager4.hideSoftInputFromWindow(this.mOldPassEditSix.getWindowToken(), 0);
                }
                this.mBackBtn.setVisibility(0);
                this.mTitle.setText(R.string.e_k);
                this.mOldLayout.setVisibility(8);
                this.mPhoneLayout.setVisibility(0);
                this.mThirdLayout.setVisibility(8);
                this.mActivateLayout.setVisibility(8);
                this.mRepeatLayout.setVisibility(8);
                this.mPhoneEdit.requestFocus();
                this.mKeyboardWindow.setVisibility(0);
                this.mKeyboardWindow.setInputEditText(this.mPhoneEdit);
                this.mKeyboardWindow.setXMode(3);
            }
        } else {
            this.mBackBtn.setVisibility(0);
            this.mTitle.setText("");
            this.mOldLayout.setVisibility(0);
            this.mPhoneLayout.setVisibility(8);
            this.mThirdLayout.setVisibility(8);
            this.mActivateLayout.setVisibility(8);
            this.mRepeatLayout.setVisibility(8);
            if (this.mOldPassEdit.getVisibility() == 0) {
                this.mOldPassEdit.requestFocus();
                this.mKeyboardWindow.setVisibility(8);
            } else {
                InputMethodManager inputMethodManager5 = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager5 != null) {
                    inputMethodManager5.hideSoftInputFromWindow(this.mOldPassEditSix.getWindowToken(), 0);
                }
                this.mOldPassEditSix.requestFocus();
                this.mKeyboardWindow.setVisibility(0);
                this.mKeyboardWindow.setInputEditText(this.mOldPassEditSix);
                this.mKeyboardWindow.setXMode(0);
            }
        }
        addTraceData("show");
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1) {
            WalletGateData.getInstance().clear();
            if (i3 == 20) {
                this.mPassFlag = 2;
                addTraceData(107, "extra.resetpwd.ok");
                if (this.mFromH5) {
                    setRetCodeAndGetBundle(0);
                    finish();
                }
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        String optString = jSONObject.optString("retcode");
        jSONObject.optString("retmsg");
        if (optString.equals("21620102")) {
            this.mOldPassEditSix.setInputText("");
        } else if (ErrorCode.ERR_PAY_PASSWORD.equals(optString)) {
            this.mOldPassEditSix.setInputText("");
        } else if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(optString)) {
            this.mOldPassEditSix.setInputText("");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.je_) {
            if (this.mProgressBar.getVisibility() != 0 && this.mMobile != null) {
                addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
                String oldPasswd = getOldPasswd();
                if (Utils.isEmpty(oldPasswd)) {
                    QQToast.makeText(getContext(), R.string.efw, 0).show();
                } else {
                    validatePayPass(oldPasswd);
                }
            }
        } else if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.ivTitleBtnRightText && id5 != R.id.az7) {
            if (id5 == R.id.jen) {
                addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
                String oldPasswd2 = getOldPasswd();
                String trim = this.mPhoneEdit.getText().toString().trim();
                if (trim.length() < 11) {
                    QQToast.makeText(getContext(), R.string.f171356ec1, 0).show();
                    this.mPhoneEdit.requestFocus();
                } else {
                    if (trim.length() != 11) {
                        str = "";
                    } else {
                        str = (trim.substring(0, 3) + "******") + trim.substring(9, 11);
                    }
                    this.mThirdPhoneTextView.setText(str);
                    HashMap hashMap = new HashMap();
                    hashMap.put(DeviceType.DeviceCategory.MOBILE, trim);
                    hashMap.put("p", oldPasswd2);
                    hashMap.put("timestamp", this.mTimestamp + "");
                    httpRequest(Cgi.URI_PHONE_PRE, hashMap);
                }
            } else if (id5 == R.id.jdq) {
                if (this.entry_mark_resetpwd) {
                    resetPwdRequest();
                } else {
                    changePwdRequest();
                }
            } else if (id5 == R.id.f166961jf2) {
                addTraceData("reacquire");
                this.mResend = true;
                String oldPasswd3 = getOldPasswd();
                String trim2 = this.mPhoneEdit.getText().toString().trim();
                HashMap hashMap2 = new HashMap();
                hashMap2.put(DeviceType.DeviceCategory.MOBILE, trim2);
                hashMap2.put("p", oldPasswd3);
                hashMap2.put("bak_port", "1");
                hashMap2.put("timestamp", this.mTimestamp + "");
                hashMap2.put("is_reentry", "1");
                httpRequest(Cgi.URI_PHONE_PRE, hashMap2);
            } else if (id5 == R.id.jez) {
                addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
                String trim3 = this.mThirdEdit.getText().toString().trim();
                if (Utils.isEmpty(trim3)) {
                    QQToast.makeText(getContext(), R.string.efz, 0).show();
                } else {
                    String oldPasswd4 = getOldPasswd();
                    String trim4 = this.mPhoneEdit.getText().toString().trim();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(DeviceType.DeviceCategory.MOBILE, trim4);
                    hashMap3.put("p", oldPasswd4);
                    hashMap3.put("verify_code", trim3);
                    hashMap3.put("timestamp", this.mTimestamp + "");
                    httpRequest(Cgi.URI_PHONE_VERIFY, hashMap3);
                }
            }
        } else {
            if (this.mFromSixPassGuide) {
                addTraceData(138, "leadtoshortpwd.window.cancel");
            } else if (id5 == R.id.ivTitleBtnLeft) {
                addTraceData("back");
            } else {
                addTraceData("cancel");
            }
            back();
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
        View inflate = layoutInflater.inflate(R.layout.adc, viewGroup, false);
        this.mEnterType = 1;
        this.mRootLayout = (LinearLayout) inflate.findViewById(R.id.root_layout);
        this.mPassLayout = (LinearLayout) inflate.findViewById(R.id.fiq);
        this.mHintLayout = (TextView) inflate.findViewById(R.id.jed);
        this.mHintAginLayout = (TextView) inflate.findViewById(R.id.title_txt);
        TextView textView = (TextView) inflate.findViewById(R.id.az7);
        textView.setClickable(true);
        textView.setOnClickListener(this);
        this.mProgressBar = (ProgressBar) inflate.findViewById(R.id.je7);
        this.mKeyboardWindow = (MyKeyboardWindow) inflate.findViewById(R.id.je9);
        this.mTitle = (TextView) inflate.findViewById(R.id.ivTitleName);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView2;
        textView2.setOnClickListener(this);
        this.mBackBtn.setVisibility(0);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ivTitleBtnRightText);
        this.mCancelBtn = textView3;
        textView3.setVisibility(8);
        this.mCancelBtn.setOnClickListener(this);
        this.mOldLayout = (LinearLayout) inflate.findViewById(R.id.jea);
        ClearableEditText clearableEditText = (ClearableEditText) inflate.findViewById(R.id.jef);
        this.mOldPassEdit = clearableEditText;
        clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.u
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                ChangePassActivity.this.lambda$onCreateView$0();
            }
        });
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) inflate.findViewById(R.id.jeg);
        this.mOldPassEditSix = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setOnClickListener(this.mSixOnClickListener);
        this.mOldPassEditSix.setOnPasswdInputListener(this.mOnPasswdInputListener);
        Intent intent = getIntent();
        if (intent != null) {
            this.mFromSixPassGuide = intent.getBooleanExtra("from_six_pass_guide", false);
            this.entry_mark_resetpwd = intent.getBooleanExtra("entry_mark_resetpwd", false);
            boolean booleanExtra = intent.getBooleanExtra("fromH5", false);
            this.mFromH5 = booleanExtra;
            if (booleanExtra) {
                JSONObject data = WalletGateData.getInstance().getData();
                if (data != null) {
                    this.mTimestamp = WalletGateData.getInstance().getSysTimeStamp();
                    this.mBargainorName = data.optString("bargainor_true_name");
                    this.mGoodsName = data.optString("desc");
                    this.mTotalFee = data.optString("total_fee");
                    this.mCardType = data.optString("creditcard_type");
                    this.mCardID = data.optString("creditcard_id");
                    this.mTrueName = data.optString("purchaser_true_name");
                    this.mUserAttr = data.optInt("user_attr");
                    this.mCacheVer = data.optString("interf_cache_ver");
                    this.mUserCertType = data.optInt("cert_user");
                    this.mMobile = data.optString(DeviceType.DeviceCategory.MOBILE);
                    this.mPassFlag = data.optInt("pass_flag");
                    String optString = data.optString("domain_name");
                    if (!TextUtils.isEmpty(optString)) {
                        setServerAddr(optString);
                    }
                    sendQueryUserIfNoResetPwd();
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uin", this.mUin);
                    httpRequest(Cgi.URL_WALLET_GATE, hashMap);
                    this.mProgressBar.setVisibility(0);
                }
            } else {
                if (this.mFromSixPassGuide) {
                    this.mRootLayout.setVisibility(8);
                    this.mPassLayout.setVisibility(0);
                } else {
                    this.mRootLayout.setVisibility(0);
                    this.mPassLayout.setVisibility(8);
                }
                this.mPassFlag = intent.getIntExtra("pass_flag", 0);
                this.mMobile = intent.getStringExtra(DeviceType.DeviceCategory.MOBILE);
            }
        }
        Button button = (Button) inflate.findViewById(R.id.je_);
        this.mOldActivateBtn = button;
        button.setOnClickListener(this);
        this.mOldActivateBtn.setEnabled(false);
        this.mActivateLayout = (LinearLayout) inflate.findViewById(R.id.jdj);
        this.mPassEdit = (SixPasswdDialogEditText) inflate.findViewById(R.id.jeb);
        if (this.mFromSixPassGuide) {
            this.mPassEdit = (SixPasswdDialogEditText) inflate.findViewById(R.id.iwz);
        }
        this.mPassEdit.setOnClickListener(this.mSixOnClickListener);
        this.mPassEdit.setOnPasswdInputListener(this.mOnPasswdInputListener);
        this.mRepeatLayout = (LinearLayout) inflate.findViewById(R.id.jdi);
        SixPasswdDialogEditText sixPasswdDialogEditText2 = (SixPasswdDialogEditText) inflate.findViewById(R.id.jec);
        this.mPassAgainEdit = sixPasswdDialogEditText2;
        sixPasswdDialogEditText2.setOnClickListener(this.mSixOnClickListener);
        this.mPassAgainEdit.setOnPasswdInputListener(this.mOnPasswdInputListener);
        Button button2 = (Button) inflate.findViewById(R.id.jdq);
        this.mActivate2Btn = button2;
        button2.setOnClickListener(this);
        this.mActivate2Btn.setEnabled(false);
        this.mActivate2Btn.setClickable(false);
        this.mPhoneLayout = (LinearLayout) inflate.findViewById(R.id.jeo);
        EditText editText = (EditText) inflate.findViewById(R.id.jem);
        this.mPhoneEdit = editText;
        editText.addTextChangedListener(this.mTextWatcher);
        this.mPhoneEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.v
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView4, int i3, KeyEvent keyEvent) {
                boolean lambda$onCreateView$1;
                lambda$onCreateView$1 = ChangePassActivity.this.lambda$onCreateView$1(textView4, i3, keyEvent);
                return lambda$onCreateView$1;
            }
        });
        Button button3 = (Button) inflate.findViewById(R.id.jen);
        this.mPhoneActivateBtn = button3;
        button3.setOnClickListener(this);
        this.mPhoneActivateBtn.setEnabled(false);
        this.mPhoneActivateBtn.setClickable(false);
        this.mThirdLayout = (LinearLayout) inflate.findViewById(R.id.f166962jf3);
        EditText editText2 = (EditText) inflate.findViewById(R.id.f166959jf0);
        this.mThirdEdit = editText2;
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.w
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView4, int i3, KeyEvent keyEvent) {
                boolean lambda$onCreateView$2;
                lambda$onCreateView$2 = ChangePassActivity.this.lambda$onCreateView$2(textView4, i3, keyEvent);
                return lambda$onCreateView$2;
            }
        });
        Button button4 = (Button) inflate.findViewById(R.id.f166961jf2);
        this.mThirdResendBtn = button4;
        button4.setOnClickListener(this);
        Button button5 = (Button) inflate.findViewById(R.id.jez);
        this.mNextBtn = button5;
        button5.setOnClickListener(this);
        this.mNextBtn.setEnabled(false);
        this.mNextBtn.setClickable(false);
        this.mThirdEdit.addTextChangedListener(this.mTextWatcher);
        this.mThirdPhoneTextView = (TextView) inflate.findViewById(R.id.f166960jf1);
        QWalletUtils.hideSysKeyBorad(this.mPhoneEdit);
        QWalletUtils.hideSysKeyBorad(this.mThirdEdit);
        initView(intent);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mTimeHandler.removeCallbacksAndMessages(null);
        closeTime();
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterReceiver(this.mResetPwdSuccessReceiver);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (Cgi.URL_WALLET_GATE.equals(str) || str.equals(Cgi.URI_QUERY_USER)) {
            setRetCodeAndGetBundle(-1).putInt("time_out", 1);
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
        super.onSuccess(str, jSONObject);
        this.mProgressBar.setVisibility(8);
        if (str.equals(Cgi.URL_WALLET_GATE)) {
            WalletGateData.getInstance().setData(this.mUin, jSONObject, System.currentTimeMillis());
            this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mBargainorName = jSONObject.optString("bargainor_true_name");
            this.mGoodsName = jSONObject.optString("desc");
            this.mTotalFee = jSONObject.optString("total_fee");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            this.mUserAttr = jSONObject.optInt("user_attr");
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            this.mUserCertType = jSONObject.optInt("cert_user");
            this.mMobile = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
            this.mPassFlag = jSONObject.optInt("pass_flag");
            String optString = jSONObject.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            sendQueryUserIfNoResetPwd();
            return;
        }
        boolean z16 = false;
        if (str.equals(Cgi.URI_QUERY_USER)) {
            this.mRootLayout.setVisibility(0);
            int optInt = jSONObject.optInt("pass_flag");
            this.mPassFlag = optInt;
            if (optInt == 2) {
                this.mOldPassEditSix.setVisibility(0);
                this.mOldActivateBtn.setVisibility(8);
                this.mOldPassEdit.setVisibility(8);
                this.mOldPassEditSix.requestFocus();
                this.mKeyboardWindow.setVisibility(0);
                this.mKeyboardWindow.setInputEditText(this.mOldPassEditSix);
                this.mKeyboardWindow.setXMode(3);
                return;
            }
            this.mOldPassEditSix.setVisibility(8);
            this.mOldActivateBtn.setVisibility(0);
            this.mOldPassEdit.setVisibility(0);
            this.mOldPassEdit.requestFocus();
            this.mKeyboardWindow.setVisibility(8);
            Utils.touchEditText(this.mHandler, this.mOldPassEdit);
            return;
        }
        if (str.equals(Cgi.URI_PHONE_PRE)) {
            if (!this.mResend) {
                this.mViewIndex++;
                manageView();
            }
            this.mResend = false;
            initTimer();
            return;
        }
        if (str.equals(Cgi.URI_PHONE_VERIFY)) {
            this.mViewIndex++;
            manageView();
            return;
        }
        if (str.equals(Cgi.URI_CHANGE_PWD)) {
            this.mPassFlag = 2;
            if (this.mFromSixPassGuide) {
                addTraceData(138, "extra.changepwd.ok");
            } else {
                addTraceData(106, "extra.changepwd.ok");
            }
            this.mKeyboardWindow.setVisibility(8);
            QLog.i(((NetBaseActivity) this).TAG, 1, "send sendBroadcast:" + BROADCAST_INTENT_ACTION_CHANGE_PWD_SUCCESS);
            sendBroadcast(new Intent(BROADCAST_INTENT_ACTION_CHANGE_PWD_SUCCESS));
            IdVerifyHintModule.startCommonSuccessHint(this, getString(R.string.e1l));
            return;
        }
        if (str.equals(Cgi.URI_VALIDATE_PAY_PASS)) {
            if (jSONObject.optInt("bind_mobile_flag") == 0) {
                z16 = true;
            }
            this.mNeedMobile = z16;
            if (!z16) {
                this.mViewIndex = 3;
            } else {
                this.mViewIndex++;
            }
            manageView();
            return;
        }
        if (str.equals(Cgi.URI_RESET_PWD)) {
            callBackFromNet(Utils.jsonToMap(jSONObject));
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        observerResetPwdSuccess();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    protected void addTraceData(int i3, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(i3));
    }
}
