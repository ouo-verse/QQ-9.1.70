package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ark.ark;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.bank.BindBankModule;
import com.tenpay.payment.QWalletWearPayBean;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.apilogic.RequestWatch;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WearVerifyActivity extends NetBaseActivity implements View.OnClickListener {
    public static final int REQUEST_PASS_VERIFY = 10;
    public static int ResetPass_RESULT_CODE = 1003;
    protected Button btVerify;
    private String devName;
    private ImageView image_logo;
    protected TextView ivTitleBtnLeft;
    private String localImageCachePath;
    protected TextView mCancelBtn;
    private float mDesity;
    protected Button mForgetPassBt;
    protected MyKeyboardWindow mKeyboardWindow;
    protected TextView mLeftBackBtn;
    private EditText mNormalPasswdEdit;
    protected SixPasswdDialogEditText mPassEditSix;
    protected LinearLayout mPassInputRoot;
    private Button mPassNextBtn;
    protected TextView mTitle;
    private String macAddress;
    protected RelativeLayout verifyRoot;
    private HashMap<String, String> walletRequest;
    private boolean isVerifyPassword = false;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WearVerifyActivity.this.mNormalPasswdEdit.getText().toString().trim().length() > 5) {
                if (!WearVerifyActivity.this.mPassNextBtn.isEnabled()) {
                    WearVerifyActivity.this.mPassNextBtn.setClickable(true);
                }
                WearVerifyActivity.this.mPassNextBtn.setEnabled(true);
            } else {
                if (WearVerifyActivity.this.mPassNextBtn.isEnabled() && WearVerifyActivity.this.mPassInputRoot.getVisibility() == 0) {
                    WearVerifyActivity.this.mPassNextBtn.setClickable(false);
                }
                WearVerifyActivity.this.mPassNextBtn.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    protected OnPasswdInputListener mOnPasswdInputListener = new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.2
        @Override // com.tenpay.sdk.view.OnPasswdInputListener
        public void onTextChange() {
            WearVerifyActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (WearVerifyActivity.this.mPassEditSix.getInputText().length() > 5) {
                        if (!WearVerifyActivity.this.mPassNextBtn.isEnabled()) {
                            WearVerifyActivity.this.mPassNextBtn.setClickable(true);
                            WearVerifyActivity.this.mPassNextBtn.setEnabled(true);
                            WearVerifyActivity.this.mPassNextBtn.performClick();
                            return;
                        }
                        return;
                    }
                    WearVerifyActivity.this.mPassNextBtn.setClickable(false);
                    WearVerifyActivity.this.mPassNextBtn.setEnabled(false);
                }
            }, 500L);
        }
    };
    private View.OnClickListener mSixOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            WearVerifyActivity.this.mKeyboardWindow.setVisibility(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    private void addTraceData(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(getProcessType()));
    }

    private void doFinish() {
        Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.isVerifyPassword) {
                jSONObject.put("retcode", 0);
            } else {
                jSONObject.put("retcode", -1);
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        retCodeAndGetBundle.putString("retData", jSONObject.toString());
        retCodeAndGetBundle.putInt("businessType", 3);
        if (RequestWatch.getInstance().callback != null) {
            RequestWatch.getInstance().callback.send(0, retCodeAndGetBundle);
        }
        RequestWatch.getInstance().isAuthorView = false;
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.4
            @Override // java.lang.Runnable
            public void run() {
                WearVerifyActivity.this.finish();
            }
        }, 1100L);
    }

    private void initData() {
        RequestWatch.getInstance().isAuthorView = true;
        String stringExtra = getIntent().getStringExtra(ark.ARKMETADATA_JSON);
        try {
            if (!TextUtils.isEmpty(stringExtra)) {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.macAddress = jSONObject.optString("macAddress");
                this.devName = jSONObject.optString("devName");
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        this.localImageCachePath = getContext().getApplicationContext().getCacheDir().getAbsolutePath() + "/";
    }

    private void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.mLeftBackBtn = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitle = textView2;
        textView2.setText(R.string.ex9);
        this.mCancelBtn = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.image_logo = (ImageView) view.findViewById(R.id.de5);
        this.mDesity = Utils.getDensity(getContext());
        if (RequestWatch.getInstance().isImageExist(this.localImageCachePath)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(this.localImageCachePath + "qb_tenpay_wear_authorization.png");
            this.mDesity = Utils.getDensity(getContext());
            if (decodeFile != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.image_logo.getLayoutParams();
                layoutParams.width = ((int) (decodeFile.getWidth() * this.mDesity)) / 2;
                layoutParams.height = ((int) (decodeFile.getHeight() * this.mDesity)) / 2;
                this.image_logo.setImageBitmap(decodeFile);
            }
        }
        this.mCancelBtn.setOnClickListener(this);
        this.mCancelBtn.setText(R.string.f171324e35);
        this.mCancelBtn.setVisibility(0);
        this.mCancelBtn.setEnabled(true);
        this.mPassInputRoot = (LinearLayout) view.findViewById(R.id.jee);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mPassEditSix = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setOnClickListener(this.mSixOnClickListener);
        this.mPassEditSix.setOnPasswdInputListener(this.mOnPasswdInputListener);
        Button button = (Button) view.findViewById(R.id.cja);
        this.mForgetPassBt = button;
        button.setOnClickListener(this);
        this.mKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.je9);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        Button button2 = (Button) view.findViewById(R.id.jdr);
        this.mPassNextBtn = button2;
        button2.setOnClickListener(this);
        this.verifyRoot = (RelativeLayout) view.findViewById(R.id.knt);
        Button button3 = (Button) view.findViewById(R.id.aei);
        this.btVerify = button3;
        button3.setOnClickListener(this);
    }

    private void manageView() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mPassEditSix.getWindowToken(), 2);
            inputMethodManager.hideSoftInputFromWindow(this.mNormalPasswdEdit.getWindowToken(), 2);
        }
        this.mKeyboardWindow.setVisibility(0);
        this.mKeyboardWindow.setXMode(3);
    }

    private void saveAuthorInfo() {
        String str = new String(Base64.encode((this.mUin + "," + this.macAddress).getBytes(), 0));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qwallet_pay_code_wear_pay_bean_");
        sb5.append(this.mUin);
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) com.tencent.mobileqq.qwallet.utils.g.h(sb5.toString(), QWalletWearPayBean.class, null);
        if (qWalletWearPayBean == null) {
            qWalletWearPayBean = QWalletWearPayBean.create();
        }
        qWalletWearPayBean.setAuth(str);
        qWalletWearPayBean.setDevName(this.devName);
        com.tencent.mobileqq.qwallet.utils.g.p("qwallet_pay_code_wear_pay_bean_" + this.mUin, qWalletWearPayBean);
    }

    private void validatePayPass(String str) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("uni", this.mUin);
            hashMap.put("p", str);
            hashMap.put("timestamp", this.mTimestamp + "");
            hashMap.put("check_cft_bindmobile", "1");
        } catch (Exception unused) {
        }
        httpRequest(Cgi.URI_VALIDATE_PAY_PASS, hashMap);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void getWalletData() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.walletRequest = hashMap;
        hashMap.put("uin", this.mUin);
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
            this.mPassFlag = data.optString("pass_flag");
            String optString = data.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            switchPassType(this.mPassFlag);
            return;
        }
        httpRequest(Cgi.URL_WALLET_GATE, this.walletRequest);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1 && i3 == ResetPass_RESULT_CODE) {
            this.mNormalPasswdEdit.setVisibility(8);
            this.mPassEditSix.setVisibility(0);
            this.mPassEditSix.requestFocus();
            this.mPassEditSix.performClick();
            manageView();
            this.mPassNextBtn.setVisibility(8);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        String optString2 = jSONObject.optString("retmsg");
        if (ErrorCode.ERR_PAY_PASSWORD.equals(optString)) {
            if (this.mPassEditSix.getVisibility() == 0) {
                this.mPassEditSix.setInputText("");
                return;
            } else {
                this.mNormalPasswdEdit.setText("");
                return;
            }
        }
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(optString)) {
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            });
            if (this.mPassEditSix.getVisibility() == 0) {
                this.mPassEditSix.setInputText("");
            } else {
                this.mNormalPasswdEdit.setText("");
            }
        }
        if ("-1".equals(optString)) {
            str.equals(Cgi.URL_WALLET_GATE);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.aei) {
            getWalletData();
        } else if (id5 == R.id.jdr) {
            if (this.mPassEditSix.getVisibility() == 0) {
                obj = this.mPassEditSix.getInputText();
            } else {
                obj = this.mNormalPasswdEdit.getText().toString();
            }
            if (Utils.isEmpty(obj)) {
                QQToast.makeText(getContext(), R.string.efw, 0).show();
            } else {
                validatePayPass(obj);
            }
        } else if (id5 == R.id.ivTitleBtnRightText) {
            doFinish();
        } else if (id5 == R.id.cja) {
            Intent intent = new Intent();
            intent.putExtra("forget_pass", true);
            intent.putExtra("pass_flag", this.mPassFlag);
            BindBankModule.INSTANCE.startVerifyForResult(this, intent, ResetPass_RESULT_CODE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getIntent();
        getWindow().addFlags(8192);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ago, viewGroup, false);
        initData();
        initView(inflate);
        addTraceData("paycode.authorize.", "show");
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
        if (str.equals(Cgi.URI_VALIDATE_PAY_PASS)) {
            saveAuthorInfo();
            this.isVerifyPassword = true;
            addTraceData("paycode.authorize.", "success");
            showOkTips(getString(R.string.f171428ex3), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.WearVerifyActivity.6
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            });
            doFinish();
            return;
        }
        if (Cgi.URL_WALLET_GATE.equals(str)) {
            this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mBargainorName = jSONObject.optString("bargainor_true_name");
            this.mGoodsName = jSONObject.optString("desc");
            this.mTotalFee = jSONObject.optString("total_fee");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            this.mUserAttr = jSONObject.optInt("user_attr");
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            this.mUserCertType = jSONObject.optInt("cert_user");
            this.mPassFlag = jSONObject.optString("pass_flag");
            String optString = jSONObject.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            switchPassType(this.mPassFlag);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    public void switchPassType(String str) {
        this.mTitle.setText(R.string.ect);
        if ("2".equals(str)) {
            this.verifyRoot.setVisibility(8);
            this.mPassInputRoot.setVisibility(0);
            this.mPassEditSix.setVisibility(0);
            this.mPassEditSix.requestFocus();
            this.mPassEditSix.performClick();
            this.mPassNextBtn.setVisibility(4);
            manageView();
            this.mKeyboardWindow.setInputEditText(this.mPassEditSix);
            return;
        }
        this.verifyRoot.setVisibility(8);
        this.mPassInputRoot.setVisibility(0);
        this.mKeyboardWindow.setVisibility(8);
        this.mPassEditSix.setVisibility(8);
        this.mNormalPasswdEdit.setVisibility(0);
        this.mNormalPasswdEdit.requestFocus();
        Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
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
