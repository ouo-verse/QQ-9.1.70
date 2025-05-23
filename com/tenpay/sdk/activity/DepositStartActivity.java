package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.soter.core.SoterCore;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_task.InitializeParam;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.bank.BindBankModule;
import com.tenpay.pay.ChoosePayTypeFragment;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.QwLog4Soter;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.HashMap;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DepositStartActivity extends NetBaseActivity implements View.OnClickListener {
    public static String DESPOSIT_COUNT = "deposit_count";
    public static String FROM_DESPOSIT = "from_Deposit";
    protected String banksString;
    protected TextView mBackBtn;
    protected String mChargeLimit;
    protected boolean mIsBackKeyPressed;
    protected MyKeyboardWindow mKeyboard;
    protected ProgressBar mProgressBar;
    protected TextView mTitleTV;
    protected ClearableEditText mWithdrawCountTxt;
    protected Button withdrawConfirmBtn;
    protected boolean hasBindBank = false;
    protected boolean hasInvalidCard = false;
    protected int process_flag = 0;
    protected String title = "";
    protected String url = "";
    private boolean needUpdateBankInfo = false;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.DepositStartActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (DepositStartActivity.this.mWithdrawCountTxt.getText().length() > 0) {
                DepositStartActivity depositStartActivity = DepositStartActivity.this;
                if (depositStartActivity.checkDepositCount(depositStartActivity.mWithdrawCountTxt.getText().toString(), DepositStartActivity.this.mChargeLimit)) {
                    if (!DepositStartActivity.this.withdrawConfirmBtn.isEnabled()) {
                        DepositStartActivity.this.withdrawConfirmBtn.setEnabled(true);
                        DepositStartActivity.this.withdrawConfirmBtn.setClickable(true);
                        com.tencent.mobileqq.qwallet.c.c("charge.index.enable", Integer.valueOf(DepositStartActivity.this.process_flag));
                        return;
                    }
                    return;
                }
            }
            if (DepositStartActivity.this.withdrawConfirmBtn.isEnabled()) {
                DepositStartActivity.this.withdrawConfirmBtn.setClickable(false);
                DepositStartActivity.this.withdrawConfirmBtn.setEnabled(false);
                com.tencent.mobileqq.qwallet.c.c("charge.index.disable", Integer.valueOf(DepositStartActivity.this.process_flag));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    public View.OnFocusChangeListener keyOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.DepositStartActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(final View view, boolean z16) {
            if (z16) {
                if (view instanceof ClearableEditText) {
                    ((ClearableEditText) view).manageClearButton();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) DepositStartActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.DepositStartActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DepositStartActivity.this.mKeyboard.setVisibility(0);
                        DepositStartActivity.this.mKeyboard.setInputEditText((EditText) view);
                        View view2 = view;
                        DepositStartActivity depositStartActivity = DepositStartActivity.this;
                        if (view2 == depositStartActivity.mWithdrawCountTxt) {
                            depositStartActivity.mKeyboard.setXMode(4);
                        }
                    }
                }, 200L);
                return;
            }
            if (view instanceof ClearableEditText) {
                ((ClearableEditText) view).removeClearButton();
            }
            if (!DepositStartActivity.this.mWithdrawCountTxt.isFocused()) {
                DepositStartActivity.this.mKeyboard.setVisibility(8);
            }
        }
    };
    public View.OnClickListener keyOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.DepositStartActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (DepositStartActivity.this.mKeyboard.getVisibility() == 8) {
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.DepositStartActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DepositStartActivity.this.mKeyboard.setVisibility(0);
                        DepositStartActivity.this.mKeyboard.setInputEditText((EditText) view);
                        DepositStartActivity.this.mKeyboard.setXMode(4);
                    }
                }, 200L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDepositCount(String str, String str2) {
        long parseLong;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "200000";
        }
        if (str.indexOf(46) >= 0 && str.indexOf(46) < str.length() - 3) {
            QQToast.makeText(getContext(), R.string.e5e, 0).show();
            return false;
        }
        try {
            parseLong = Long.parseLong(Utils.yuan2Fen(str));
        } catch (NumberFormatException unused) {
        }
        if (parseLong > Long.parseLong(str2)) {
            QQToast.makeText(getContext(), 1, String.format(getString(R.string.e5d), Utils.fen2Yuan(str2)), 0).show();
            return false;
        }
        if (parseLong <= 0) {
            return false;
        }
        return true;
    }

    private ColorStateList createColorStateList(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{Color.parseColor(str), Color.parseColor(str2)});
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        return null;
    }

    private boolean getFingerPayExceedAmountNoticed() {
        return getSharedPreferences(SharedHelper.QB_TENPAY_FP_ + this.mUin, 0).getBoolean("fp_exceed_amount_noticed", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getFingerPayStatus() {
        if (getContext() == null) {
            QLog.w(((NetBaseActivity) this).TAG, 1, "getFingerPayStatus but context is null");
            return false;
        }
        if (SharedHelper.soterOpen(this.mUin)) {
            int i3 = this.mTouchidState;
            if (i3 == 3) {
                goToDeposit(true);
                return true;
            }
            if (i3 != 1 && i3 != 0 && i3 != 7) {
                if (getFingerPayExceedAmountNoticed() && this.mTouchidState == 4) {
                    return false;
                }
                QUIProxy.createCustomDialog(getContext(), 230, null, this.mTouchidStateInfo, getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.DepositStartActivity.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        DepositStartActivity.this.goToDeposit(false);
                    }
                });
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToDeposit(boolean z16) {
        this.mKeyboard.setVisibility(8);
        initBankInfo(false);
        com.tencent.mobileqq.qwallet.c.c("charge.index.next", Integer.valueOf(this.process_flag));
        if (this.hasBindBank) {
            Intent intent = new Intent();
            intent.putExtra("banks_info", this.banksString);
            intent.putExtra(DESPOSIT_COUNT, Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
            if (z16) {
                intent.putExtra("isFingerDeposit", true);
            }
            if (!Utils.isEmpty(this.title) && !Utils.isEmpty(this.url)) {
                intent.putExtra("title", this.title);
                intent.putExtra("url", this.url);
            }
            launchFragment(intent, DepositActivity.class);
        } else if (this.hasInvalidCard) {
            gotoChangePayType(z16);
        } else {
            com.tencent.mobileqq.qwallet.c.c("cash.nocard.record", Integer.valueOf(this.process_flag));
            Intent intent2 = new Intent();
            intent2.putExtra("pass_flag", this.mPassFlag);
            intent2.putExtra(DESPOSIT_COUNT, Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
            intent2.putExtra(FROM_DESPOSIT, true);
            if (z16) {
                intent2.putExtra("from_finger_deposit", true);
                intent2.putExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 140);
            }
            BindBankModule.INSTANCE.startWithSwitch(this, intent2, 6);
        }
        this.needUpdateBankInfo = true;
    }

    private void gotoChangePayType(boolean z16) {
        Intent intent = new Intent();
        intent.putExtra("FromDepositActivity", true);
        intent.putExtra("setBackgroundGray", true);
        intent.putExtra("isFingerPayDeposit", z16);
        intent.putExtra("pass_flag", Integer.valueOf(this.mPassFlag));
        intent.putExtra("banks_info", this.banksString);
        intent.putExtra(DESPOSIT_COUNT, Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
        launchFragment(intent, ChooseWithdrawBankActivity.class);
    }

    private void initBankInfo(boolean z16) {
        this.hasBindBank = false;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("banks_info"))) {
            this.banksString = intent.getStringExtra("banks_info");
        }
        JSONObject data = WalletGateData.getInstance().getData();
        if (!TextUtils.isEmpty(intent.getStringExtra("charge_limit"))) {
            this.mChargeLimit = intent.getStringExtra("charge_limit");
        } else if (data != null) {
            this.mChargeLimit = data.optString("charge_limit");
            this.mPassFlag = data.optString("pass_flag");
        }
        if (!TextUtils.isEmpty(this.banksString) && !z16) {
            parseBankInfo();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        if (data != null) {
            initQWalletGateInfo(data);
            this.mTimestamp = WalletGateData.getInstance().getSysTimeStamp();
            queryUserBankInfo();
            return;
        }
        httpRequest(Cgi.URL_WALLET_GATE, hashMap);
    }

    private void initQWalletGateInfo(JSONObject jSONObject) {
        QwLog.i("initQWalletGateInfo");
        WalletGateData.getInstance().setData(this.mUin, jSONObject, System.currentTimeMillis());
        this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
        this.mBargainorName = jSONObject.optString("bargainor_true_name");
        this.mGoodsName = jSONObject.optString("desc");
        this.mTotalFee = jSONObject.optString("total_fee");
        this.mCardType = jSONObject.optString("creditcard_type");
        this.mCardID = jSONObject.optString("creditcard_id");
        this.mTrueName = jSONObject.optString("purchaser_true_name");
        this.mUserAttr = jSONObject.optInt("user_attr");
        this.mCacheVer = jSONObject.optString("interf_cache_ver");
        this.mUserCertType = jSONObject.optInt("cert_user");
        String optString = jSONObject.optString("domain_name");
        if (!TextUtils.isEmpty(optString)) {
            setServerAddr(optString);
        }
        this.mEnterType = 1;
        this.mPassFlag = jSONObject.optString("pass_flag");
        this.mChargeLimit = jSONObject.optString("charge_limit");
    }

    private void parseBankInfo() {
        boolean z16;
        boolean z17;
        try {
            JSONArray jSONArray = new JSONArray(this.banksString);
            if (jSONArray.length() > 0) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    boolean contains = jSONObject.optString(TransFileControllerImpl.VALUE_USE_PRE_CONN).contains("CHARGE");
                    if (contains && jSONObject.optInt("disable") == 6) {
                        this.hasInvalidCard = true;
                    }
                    if (contains && jSONObject.optInt("disable") == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (SharedHelper.soterOpen(this.mUin) && this.mTouchidState == 3) {
                        if (!"DEBIT".equals(jSONObject.optString("type")) && !"CREDIT".equals(jSONObject.optString("type"))) {
                            z17 = false;
                            if (!z16 && !z17) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                        }
                        z17 = true;
                        if (!z16) {
                        }
                        z16 = false;
                    }
                    if (z16) {
                        this.hasBindBank = true;
                    }
                    if (this.hasInvalidCard && this.hasBindBank) {
                        return;
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mIsBackKeyPressed = true;
            this.mBackBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.PULL_UP;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mBackBtn = textView;
        textView.setVisibility(0);
        this.mBackBtn.setText(R.string.e2i);
        this.mBackBtn.setOnClickListener(this);
        view.findViewById(R.id.ivTitleBtnLeft).setVisibility(8);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitleTV = textView2;
        textView2.setText(R.string.e59);
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.je7);
        this.mWithdrawCountTxt = (ClearableEditText) view.findViewById(R.id.l4f);
        String string = getString(R.string.e5a);
        if (TextUtils.isEmpty(this.mChargeLimit)) {
            this.mChargeLimit = "200000";
        }
        this.mWithdrawCountTxt.setHint(String.format(string, String.valueOf(Integer.parseInt(this.mChargeLimit) / 100)));
        this.mWithdrawCountTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.DepositStartActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                if (keyEvent != null) {
                    keyEvent.getKeyCode();
                }
                EventCollector.getInstance().onEditorAction(textView3, i3, keyEvent);
                return false;
            }
        });
        this.mWithdrawCountTxt.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mWithdrawCountTxt.setOnClickListener(this.keyOnClickListener);
        this.mWithdrawCountTxt.addTextChangedListener(this.mTextWatcher);
        QWalletUtils.hideSysKeyBorad(this.mWithdrawCountTxt);
        Button button = (Button) view.findViewById(R.id.l4e);
        this.withdrawConfirmBtn = button;
        button.setOnClickListener(this);
        this.withdrawConfirmBtn.setEnabled(false);
        this.withdrawConfirmBtn.setClickable(false);
        int i3 = this.mUserAttr;
        if (i3 != 0 && i3 != 3) {
            this.process_flag = 121;
        } else {
            this.process_flag = 120;
        }
        com.tencent.mobileqq.qwallet.c.c("charge.index.show", Integer.valueOf(this.process_flag));
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        super.onBlHandleFakeurl(fakeInfo, i3);
        if (i3 == 0) {
            return false;
        }
        if (!fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_REGENERATEASKEY) && !fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_REGENERATEAUTHKEY)) {
            return false;
        }
        goToDeposit(false);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightText) {
            if (this.mIsBackKeyPressed) {
                str = "charge.index.keyback";
            } else {
                str = "charge.index.back";
            }
            com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(this.process_flag));
            finish();
            getActivity().overridePendingTransition(0, R.anim.f154878es);
        } else if (id5 == R.id.l4e) {
            if (SharedHelper.soterOpen(this.mUin)) {
                HashMap hashMap = new HashMap();
                hashMap.put("uin", this.mUin);
                hashMap.put("timestamp", this.mTimestamp + "");
                hashMap.put("amount", Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
                hashMap.put("model_xml", SoterCore.generateRemoteCheckRequestParam());
                showQQPayLoading(0);
                SoterWrapperApi.init(getContext().getApplicationContext(), new SoterProcessCallback<SoterProcessNoExtResult>() { // from class: com.tenpay.sdk.activity.DepositStartActivity.5
                    @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
                    public void onResult(SoterProcessNoExtResult soterProcessNoExtResult) {
                        QwLog.i("get is support soter done. result: " + soterProcessNoExtResult.toString());
                        DepositStartActivity.this.dismissQQPayLoading();
                        if ((soterProcessNoExtResult.isSuccess() || soterProcessNoExtResult.errCode == 1028) && SoterWrapperApi.isSupportSoter()) {
                            if (DepositStartActivity.this.getFingerPayStatus()) {
                                return;
                            }
                            DepositStartActivity.this.goToDeposit(false);
                            return;
                        }
                        DepositStartActivity.this.goToDeposit(false);
                    }
                }, new InitializeParam.InitializeParamBuilder().setGetSupportNetWrapper(new GetSupportSoterNet(getContext(), hashMap, (WeakReference<Net.NetListener>) new WeakReference(this))).setScenes(Cgi.scene_FingerPay).setDistinguishSalt(this.mUin).setSoterLogger(QwLog4Soter.getInstance()).build());
            } else {
                goToDeposit(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.adq, viewGroup, false);
        initBankInfo(false);
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (SoterWrapperApi.isInitialized()) {
            SoterWrapperApi.release();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        TenUtils.notifyToExit(getContext(), this.mProssesID);
        commonBlErrorPros(jSONObject, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needUpdateBankInfo) {
            initBankInfo(true);
            this.needUpdateBankInfo = false;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        boolean z16;
        boolean z17;
        super.onSuccess(str, jSONObject);
        if (Cgi.URI_Soter_FINGER_PAY_CHECK.equals(str)) {
            this.mTouchidRetryMaxCount = jSONObject.optInt("retry_count");
            this.mTouchidState = jSONObject.optInt("soter_state");
            this.mTouchidStateInfo = jSONObject.optString("soter_state_info");
            return;
        }
        if (Cgi.URL_WALLET_GATE.equals(str)) {
            initQWalletGateInfo(jSONObject);
            queryUserBankInfo();
            return;
        }
        if (Cgi.URI_YDTBANK_QUERY.equals(str)) {
            if (getContext() == null) {
                QLog.w(((NetBaseActivity) this).TAG, 1, "onSuccess: " + Cgi.URI_YDTBANK_QUERY + " but context is null");
                return;
            }
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("miniapp");
                if (optJSONObject != null) {
                    this.title = optJSONObject.optString("sdk_content");
                    this.url = optJSONObject.optString("sdk_url");
                }
                JSONArray jSONArray = jSONObject.getJSONArray("banklist");
                JSONArray jSONArray2 = new JSONArray();
                int i3 = 0;
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i16);
                    if (optJSONObject2.optString(TransFileControllerImpl.VALUE_USE_PRE_CONN).contains("CHARGE") && optJSONObject2.optInt("disable") == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        jSONArray2.put(i3, optJSONObject2);
                        i3++;
                    }
                }
                for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                    JSONObject optJSONObject3 = jSONArray.optJSONObject(i17);
                    if (optJSONObject3.optString(TransFileControllerImpl.VALUE_USE_PRE_CONN).contains("CHARGE") && optJSONObject3.optInt("disable") == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        jSONArray2.put(i3, optJSONObject3);
                        i3++;
                    }
                }
                this.banksString = jSONArray2.toString();
                parseBankInfo();
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void queryUserBankInfo() {
        String str;
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra("token_id");
        }
        if (str == null) {
            str = "";
        }
        if (this.mBargainorId == null) {
            this.mBargainorId = "";
        }
        hashMap.put("bargainor_id", this.mBargainorId);
        hashMap.put("token_id", str);
        hashMap.put("user_info", this.mUserAttr + "");
        hashMap.put("query_type", "QPAY_CHARGE");
        hashMap.put("unbind_flag", "0");
        httpRequestNoEncript(Cgi.URI_YDTBANK_QUERY, hashMap);
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
