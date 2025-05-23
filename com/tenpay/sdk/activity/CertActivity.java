package com.tenpay.sdk.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.QWalletUtils;
import com.tenpay.ndk.CertUtil;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CertActivity extends NetBaseActivity implements View.OnClickListener {
    public static String FROM_CERT = "from_cert";
    protected static final int ONE_MINUTE = 59;
    private static final String TAG = "CertActivity";
    protected static final int VIEW_INPUT_PASSWD = 0;
    public static final int WINDOW_STYLE_BIG = 1;
    public static final int WINDOW_STYLE_SMALL = 0;
    protected static int mLeftTime = 59;
    protected TextView mBackBtn;
    protected ImageButton mCloseBtn;
    protected Button mForgetPassBtn;
    protected TextView mInputNoteTxt;
    protected MyKeyboardWindow mKeyboard;
    protected String mMobile;
    private boolean mNoPayType;
    protected EditText mNormalPasswdEdit;
    private LinearLayout mPassLayout;
    protected ScrollView mPayAuthLayout;
    protected Button mPayConfirmBtn;
    protected JSONObject mQpayCert;
    private boolean mRefresh;
    protected View mRootLayout;
    private String mSavedPsword;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    protected TextView mSubTitle;
    protected String mSysTimeStamp;
    protected Timer mTimer;
    protected TextView mTitle;
    protected EditText mVerifyCodeEdit;
    protected Button mVerifyConfirmBtn;
    protected ScrollView mVerifyLayout;
    protected TextView mVerifyMobileTxt;
    protected Button mVerifyResendBtn;
    protected int mNavType = 0;
    protected boolean mIsSixPasswdUser = true;
    protected int mSendFlag = 0;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.CertActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (CertActivity.this.mPayAuthLayout.getVisibility() == 0) {
                if (CertActivity.this.getPasswd().length() > 5) {
                    if (!CertActivity.this.mPayConfirmBtn.isEnabled()) {
                        CertActivity.this.mPayConfirmBtn.setEnabled(true);
                        CertActivity.this.mPayConfirmBtn.setClickable(true);
                        CertActivity.this.addTraceData("check.psw.enable");
                        return;
                    }
                    return;
                }
                if (CertActivity.this.mPayConfirmBtn.isEnabled()) {
                    CertActivity.this.mPayConfirmBtn.setClickable(false);
                    CertActivity.this.mPayConfirmBtn.setEnabled(false);
                    CertActivity.this.addTraceData("check.psw.disable");
                    return;
                }
                return;
            }
            if (CertActivity.this.mVerifyLayout.getVisibility() == 0) {
                if (CertActivity.this.mVerifyCodeEdit.getText().toString().length() < 6) {
                    if (CertActivity.this.mVerifyConfirmBtn.isEnabled()) {
                        CertActivity.this.mVerifyConfirmBtn.setClickable(false);
                        CertActivity.this.mVerifyConfirmBtn.setEnabled(false);
                        return;
                    }
                    return;
                }
                if (!CertActivity.this.mVerifyConfirmBtn.isEnabled()) {
                    CertActivity.this.mVerifyConfirmBtn.setClickable(true);
                    CertActivity.this.mVerifyConfirmBtn.setEnabled(true);
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

    private void certActivate() {
        QwLog.i("certActivate");
        QwLog.i("mUin=" + this.mUin);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("cn", this.mQpayCert.optString("cn"));
        hashMap.put("guid", com.tencent.mobileqq.base.b.d());
        hashMap.put("device_id", QFuncProxy.getDeviceId(getContext()));
        httpRequest(Cgi.URI_CERT_ACTIVATE, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void certApply() {
        QwLog.i("certApply");
        QwLog.i("mUin=" + this.mUin);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        String passwd = getPasswd();
        this.mSavedPsword = passwd;
        hashMap.put("p", passwd);
        hashMap.put("timestamp", this.mTimestamp + "");
        httpRequest(Cgi.URI_CERT_APPLY, hashMap);
    }

    private void certConfirm() {
        QwLog.i("certConfirm");
        this.mVerifyConfirmBtn.setEnabled(false);
        this.mVerifyConfirmBtn.setClickable(false);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.CertActivity.6
            @Override // java.lang.Runnable
            public void run() {
                CertActivity.this.mVerifyConfirmBtn.setEnabled(true);
                CertActivity.this.mVerifyConfirmBtn.setClickable(true);
            }
        }, 1000L);
        QwLog.i("mUin=" + this.mUin);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("csr", CertUtil.getInstance(getContext()).getCertApplyCSR(this.mUin));
        hashMap.put("guid", com.tencent.mobileqq.base.b.d());
        hashMap.put("device_id", QFuncProxy.getDeviceId(getContext()));
        if (this.mSendFlag == 1) {
            String obj = this.mVerifyCodeEdit.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                hashMap.put("verify_code", obj);
            }
        } else {
            hashMap.put("p", this.mSavedPsword);
        }
        hashMap.put("timestamp", this.mTimestamp + "");
        httpRequest(Cgi.URI_CERT_CONFIRM, hashMap);
    }

    private void clearPassword() {
        if (this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mNormalPasswdEdit.setText("");
        }
        this.mPayConfirmBtn.setClickable(false);
        this.mPayConfirmBtn.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBack(int i3, String str) {
        QwLog.i("doBack : " + i3);
        finish();
        setRetCodeAndErrorMsg(i3, str);
        TenUtils.notifyToExit(getContext(), this.mProssesID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forgetPass() {
        Intent intent = new Intent(getIntent());
        intent.putExtra("forget_pass", true);
        intent.putExtra(FROM_CERT, true);
        launchFragment(intent, ResetPassBridgeActivity.class);
    }

    private void gotoSmsVerifyPage() {
        this.mPayAuthLayout.setVisibility(8);
        this.mVerifyLayout.setVisibility(0);
        this.mTitle.setText(R.string.e_q);
        this.mVerifyMobileTxt.setText(this.mMobile);
        initTimer();
        this.mVerifyCodeEdit.requestFocus();
        this.mKeyboard.setVisibility(0);
        this.mKeyboard.setInputEditText(this.mVerifyCodeEdit);
    }

    public static void handleCertWithPaySuc(JSONObject jSONObject, Context context, String str, String str2, long j3) {
        JSONObject optJSONObject = jSONObject.optJSONObject("qpay_cert");
        if (optJSONObject == null) {
            return;
        }
        Log.v("TENPAY", "handleCertWithPaySuc");
        if (isQuietInstallCert(optJSONObject)) {
            qpayCertApplyQuiet(context, str, str2, j3);
        }
    }

    public static boolean isQuietInstallCert(JSONObject jSONObject) {
        String optString = jSONObject.optString("flag");
        if (optString != null && "1".equals(optString)) {
            return true;
        }
        return false;
    }

    public static void qpayCertApplyQuiet(final Context context, final String str, String str2, long j3) {
        QwLog.i("qpayCertApplyQuiet");
        QwLog.i("uin=" + str);
        final TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new Net.NetAdapter(null) { // from class: com.tenpay.sdk.activity.CertActivity.10
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(String str3, JSONObject jSONObject) {
                QwLog.i("CertActivity onSuccess");
                if (str3.equals(Cgi.URI_CERT_CONFIRM_QUIET)) {
                    try {
                        String optString = jSONObject.optString("crt");
                        String optString2 = new JSONObject(jSONObject.optString("qpay_cert")).optString("cn");
                        if (CertUtil.getInstance(context).importCert(optString2, optString)) {
                            CertUtil.addCert(context, str, optString2);
                            HashMap hashMap = new HashMap();
                            hashMap.put("uin", str);
                            hashMap.put("cn", optString2);
                            hashMap.put("guid", com.tencent.mobileqq.base.b.d());
                            hashMap.put("device_id", QFuncProxy.getDeviceId(context));
                            tenpayBL.doTask(context, Cgi.URI_CERT_ACTIVATE, hashMap, "", "0", str, true);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.e(CertActivity.TAG, 1, "", e16);
                        return;
                    }
                }
                if (str3.equals(Cgi.URI_CERT_ACTIVATE)) {
                    QwLog.i("ID_CERT_ACTIVATE OK");
                }
            }
        });
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("uin", str);
            hashMap.put("csr", CertUtil.getInstance(context).getCertApplyCSR(str));
            hashMap.put("guid", com.tencent.mobileqq.base.b.d());
            hashMap.put("device_id", QFuncProxy.getDeviceId(context));
            hashMap.put("p", str2);
            hashMap.put("timestamp", j3 + "");
            tenpayBL.doTask(context, Cgi.URI_CERT_CONFIRM_QUIET, hashMap, "", "0", str, true);
        } catch (Exception unused) {
        }
    }

    private void showSixPasswordView() {
        this.mNormalPasswdEdit.setVisibility(8);
        this.mSixPasswdEdit.setVisibility(0);
        this.mIsSixPasswdUser = true;
        this.mSixPasswdEdit.requestFocus();
        this.mPayConfirmBtn.setVisibility(8);
    }

    protected void closeTime() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mLeftTime = 59;
        Button button = this.mVerifyResendBtn;
        if (button != null) {
            button.setText(getString(R.string.ede));
            this.mVerifyResendBtn.setEnabled(true);
            this.mVerifyResendBtn.setClickable(true);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.mKeyboard.getVisibility() == 0) {
                this.mKeyboard.setVisibility(8);
                return true;
            }
            addTraceData("check.psw.keyback");
            finish();
            TenUtils.notifyToExit(getContext(), this.mProssesID);
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        super.finish();
        getActivity().overridePendingTransition(0, R.anim.f154880eu);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.DEFAULT;
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

    protected void initTimer() {
        String str = getString(R.string.ede) + "(" + mLeftTime + ")";
        this.mVerifyResendBtn.setClickable(false);
        this.mVerifyResendBtn.setEnabled(false);
        this.mVerifyResendBtn.setText(str);
        TimerTask timerTask = new TimerTask() { // from class: com.tenpay.sdk.activity.CertActivity.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = CertActivity.this.mHandler;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.CertActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CertActivity.mLeftTime--;
                            String string = CertActivity.this.getString(R.string.ede);
                            if (CertActivity.mLeftTime > 0) {
                                string = string + "(" + CertActivity.mLeftTime + ")";
                                CertActivity.this.mVerifyResendBtn.setClickable(false);
                                CertActivity.this.mVerifyResendBtn.setEnabled(false);
                            } else {
                                CertActivity.this.mVerifyResendBtn.setClickable(true);
                                CertActivity.this.mVerifyResendBtn.setEnabled(true);
                                CertActivity.this.mTimer.cancel();
                                CertActivity.mLeftTime = 59;
                            }
                            CertActivity.this.mVerifyResendBtn.setText(string);
                        }
                    });
                }
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

    protected void initView(View view) {
        this.mRootLayout = view.findViewById(R.id.root_layout);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitle = textView;
        textView.setText(R.string.eam);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView2;
        textView2.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.az7);
        this.mCloseBtn = imageButton;
        imageButton.setOnClickListener(this);
        this.mSubTitle = (TextView) view.findViewById(R.id.f166931j64);
        this.mPayAuthLayout = (ScrollView) view.findViewById(R.id.a16);
        this.mPassLayout = (LinearLayout) view.findViewById(R.id.fiq);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.CertActivity.2
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public void onTextChange() {
                if (CertActivity.this.mSixPasswdEdit.getInputText().length() > 5) {
                    CertActivity.this.addTraceData("check.psw.go");
                    CertActivity.this.certApply();
                }
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.CertActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                Handler handler;
                if (!CertActivity.this.mSixPasswdEdit.isFocused() || (handler = CertActivity.this.mHandler) == null) {
                    return;
                }
                handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.CertActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CertActivity.this.mKeyboard.setVisibility(0);
                        CertActivity certActivity = CertActivity.this;
                        certActivity.mKeyboard.setInputEditText(certActivity.mSixPasswdEdit);
                    }
                });
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.CertActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent.getKeyCode() == 66) {
                    if (CertActivity.this.getPasswd().length() > 5) {
                        CertActivity.this.mPayConfirmBtn.performClick();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView3, i3, keyEvent);
                return z16;
            }
        });
        this.mInputNoteTxt = (TextView) view.findViewById(R.id.input_note_txt);
        Button button = (Button) view.findViewById(R.id.cja);
        this.mForgetPassBtn = button;
        button.setOnClickListener(this);
        Button button2 = (Button) view.findViewById(R.id.b7s);
        this.mPayConfirmBtn = button2;
        button2.setOnClickListener(this);
        this.mPayConfirmBtn.setEnabled(false);
        this.mPayConfirmBtn.setClickable(false);
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        if (this.mIsSixPasswdUser) {
            showSixPasswordView();
        } else {
            this.mNormalPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.setVisibility(8);
            this.mNormalPasswdEdit.requestFocus();
            this.mPayConfirmBtn.setVisibility(0);
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        this.mVerifyLayout = (ScrollView) view.findViewById(R.id.knk);
        this.mVerifyMobileTxt = (TextView) view.findViewById(R.id.fmv);
        EditText editText2 = (EditText) view.findViewById(R.id.knc);
        this.mVerifyCodeEdit = editText2;
        editText2.addTextChangedListener(this.mTextWatcher);
        this.mVerifyCodeEdit.setOnClickListener(this);
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
        Button button3 = (Button) view.findViewById(R.id.i8e);
        this.mVerifyResendBtn = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) view.findViewById(R.id.b7u);
        this.mVerifyConfirmBtn = button4;
        button4.setOnClickListener(this);
        this.mVerifyConfirmBtn.setClickable(false);
        this.mVerifyConfirmBtn.setEnabled(false);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1 && i3 != 10 && i3 == 20) {
            this.mPassFlag = "2";
            showSixPasswordView();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(jSONObject.optString("retcode"))) {
            clearPassword();
            QUIProxy.createCustomDialog(getContext(), 230, null, jSONObject.optString("retmsg"), getString(R.string.edi), getString(R.string.e5v), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.CertActivity.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    CertActivity.this.forgetPass();
                    CertActivity.this.addTraceData("psw.err.forget");
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.CertActivity.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    CertActivity.this.addTraceData("psw.err.retry");
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (isValidClick(id5)) {
            if (id5 == R.id.b7s) {
                addTraceData("check.psw.go");
                certApply();
            } else if (id5 == R.id.b7u) {
                certConfirm();
            } else if (id5 == R.id.i8e) {
                initTimer();
                certApply();
            } else if (id5 == R.id.cja) {
                addTraceData("check.psw.forgot");
                forgetPass();
            } else if (id5 != R.id.ivTitleBtnLeft && id5 != R.id.az7) {
                if ((id5 == R.id.iwz || id5 == R.id.knc) && !this.mKeyboard.isShown()) {
                    this.mKeyboard.setVisibility(0);
                }
            } else {
                addTraceData("check.psw.close");
                finish();
                TenUtils.notifyToExit(getContext(), this.mProssesID);
            }
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
        QwLog.i("CertActivity onCreate");
        getWindow().setSoftInputMode(19);
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("extra_data"));
            QwLog.i("extra_data = " + jSONObject.toString());
            String optString = jSONObject.optString("pass_flag");
            this.mPassFlag = optString;
            this.mIsSixPasswdUser = "2".equals(optString);
            QwLog.i("mPassFlag = " + this.mPassFlag);
            QwLog.i("mIsSixPasswdUser = " + this.mIsSixPasswdUser);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        View inflate = layoutInflater.inflate(R.layout.ada, viewGroup, false);
        initView(inflate);
        addTraceData("check.psw.show");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        closeTime();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        if (Cgi.URI_CERT_CONFIRM.equals(str)) {
            this.mSixPasswdEdit.setInputText("");
        }
        if (ErrorCode.ERR_PAY_PASSWORD.equals(optString)) {
            setRetCodeAndGetBundle(-6);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        QwLog.i("CertActivity onSuccess");
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URI_CERT_APPLY)) {
            int optInt = jSONObject.optInt("send_flag");
            this.mSendFlag = optInt;
            if (optInt == 1) {
                this.mMobile = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
                gotoSmsVerifyPage();
                return;
            } else {
                certConfirm();
                return;
            }
        }
        if (str.equals(Cgi.URI_CERT_CONFIRM)) {
            try {
                String optString = jSONObject.optString("crt");
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString("qpay_cert"));
                this.mQpayCert = jSONObject2;
                String optString2 = jSONObject2.optString("cn");
                if (CertUtil.getInstance(getContext()).importCert(optString2, optString)) {
                    CertUtil.addCert(getContext(), this.mUin, optString2);
                    certActivate();
                } else {
                    doBack(-105, "cert import error!");
                }
                return;
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "", e16);
                doBack(-105, "cert import error! " + e16.getMessage());
                return;
            }
        }
        if (str.equals(Cgi.URI_CERT_ACTIVATE)) {
            QwLog.i("showOkTips");
            showOkTips(getString(R.string.e3q), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.CertActivity.9
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    CertActivity.this.doBack(0, "");
                }
            });
        }
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

    protected void addTraceData(String str) {
    }
}
