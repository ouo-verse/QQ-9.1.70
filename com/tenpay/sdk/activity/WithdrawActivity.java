package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.api.BankImageUtil;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.QWalletUtils;
import com.tenpay.bank.BindBankModule;
import com.tenpay.bank.DisableBankInfo;
import com.tenpay.proxy.DataProxy;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.sdk.util.JSONConstant;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.ClearableEditLayout;
import com.tenpay.sdk.view.TenpayEditText;
import com.tenpay.util.Utils;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import cooperation.qwallet.plugin.FakeUrl;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WithdrawActivity extends NetBaseActivity implements View.OnClickListener {
    private static int BANK_RESULT_CODE = 1002;
    private static int BIND_BANK_RESULT_CODE = 1003;
    public static String FROM_WITHDRAW = "from_withdraw";
    private static int RESULT_CODE = 1001;
    public static String WITHDRAW_COUNT = "withdraw_count";
    public static String WITHDRAW_PROCESS_FLAG = "withdraw_process_flag";
    private long mAmount;
    private String mAmountFromServer;
    private TextView mBackBtn;
    private long mBalance;
    private TextView mBalanceTV;
    private ImageView mBankImageView;
    private int mBankIndex;
    private LinearLayout mBankLayout;
    private TextView mBankNameTV;
    private String mBank_name;
    private String mBank_true_name;
    private String mBank_type;
    private String mBankimageId;
    private LinearLayout mBankinfoLayout;
    private String mBanksShowInfo;
    private String mBind_serial;
    private String mCard_tail;
    private String mDraw_desc;
    private String mDraw_idFromServer;
    private String mDraw_type;
    private boolean mIsBackKeyPressed;
    private MyKeyboardWindow mKeyboard;
    private String mLastBalanceStr;
    private ProgressBar mProgressBar;
    private ImageView mQuestionIcon;
    private TextView mTitleTV;
    private Button mWithdrawAllBtn;
    private JSONObject mWithdrawBankObj;
    private TenpayEditText mWithdrawCountTxt;
    private TextView mWithdrawDescTV;
    private String mcharge_feeFromServer;
    private String pass_flag;
    private String time_channel;
    private Button withdrawConfirmBtn;
    private boolean hasBindBank = false;
    private int process_flag = 113;
    private boolean mBankBind = false;
    private boolean mBindNewCard = false;
    private long mWithdrawFee = 0;
    private long mWithdrawSum = 0;
    private long mMinFee = 0;
    private long mFreeLeftAmounts = 0;
    private long mFullDrawAmount = 0;
    private long mFullDrawFee = 0;
    private int mFeeRate = 0;
    private long mInputMoney = -1;
    private String mFee_desc_url = null;
    private int mIsPayFee = 0;
    private boolean mIsFeelacks = false;
    private int mContinue_flag = 0;
    private String mStrNoFee = null;
    private String mStrFormatBalance = null;
    private String mStrFormatFee = null;
    private boolean mWithdrawAllFlag = false;
    private boolean mJumpFromFakeLeft = false;
    private final HashMap<String, DisableBankInfo> mDisableBankMap = new HashMap<>();
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.WithdrawActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (WithdrawActivity.this.isFinishing()) {
                return;
            }
            String obj = WithdrawActivity.this.mWithdrawCountTxt.getText().toString();
            if (obj.length() > 0 && (!obj.startsWith(".") || !obj.endsWith("."))) {
                if (WithdrawActivity.this.checkWithdrawCount(obj, WithdrawActivity.this.mBalance + "")) {
                    if (!WithdrawActivity.this.withdrawConfirmBtn.isEnabled()) {
                        WithdrawActivity.this.withdrawConfirmBtn.setEnabled(true);
                        if (WithdrawActivity.this.hasBindBank) {
                            com.tencent.mobileqq.qwallet.c.c("cash.index.enable", Integer.valueOf(WithdrawActivity.this.process_flag));
                        } else {
                            com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.enable", Integer.valueOf(WithdrawActivity.this.process_flag));
                        }
                    }
                    WithdrawActivity.this.countFee();
                    WithdrawActivity.this.displayFeeInfo();
                }
            }
            if (WithdrawActivity.this.withdrawConfirmBtn.isEnabled()) {
                WithdrawActivity.this.withdrawConfirmBtn.setEnabled(false);
                if (WithdrawActivity.this.hasBindBank) {
                    com.tencent.mobileqq.qwallet.c.c("cash.index.disable", Integer.valueOf(WithdrawActivity.this.process_flag));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.disable", Integer.valueOf(WithdrawActivity.this.process_flag));
                }
            }
            WithdrawActivity.this.mInputMoney = -1L;
            WithdrawActivity.this.countFee();
            WithdrawActivity.this.displayFeeInfo();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    public View.OnFocusChangeListener keyOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.WithdrawActivity.2
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(final View view, boolean z16) {
            if (z16) {
                InputMethodManager inputMethodManager = (InputMethodManager) WithdrawActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.WithdrawActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WithdrawActivity.this.mKeyboard.setVisibility(0);
                        WithdrawActivity.this.mKeyboard.setInputEditText((EditText) view);
                        if (view == WithdrawActivity.this.mWithdrawCountTxt) {
                            WithdrawActivity.this.mKeyboard.setXMode(4);
                        }
                    }
                }, 200L);
                return;
            }
            if (!WithdrawActivity.this.mWithdrawCountTxt.isFocused()) {
                WithdrawActivity.this.mKeyboard.setVisibility(8);
            }
        }
    };
    public View.OnClickListener keyOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.WithdrawActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (WithdrawActivity.this.mKeyboard.getVisibility() == 8) {
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.WithdrawActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WithdrawActivity.this.mKeyboard.setVisibility(0);
                        WithdrawActivity.this.mKeyboard.setInputEditText((EditText) view);
                        WithdrawActivity.this.mKeyboard.setXMode(4);
                    }
                }, 200L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkWithdrawCount(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.indexOf(46) >= 0 && str.indexOf(46) < str.length() - 3) {
                QQToast.makeText(getContext(), 1, getString(R.string.e3y), 0).show();
                return false;
            }
            try {
                long parseLong = Long.parseLong(Utils.yuan2Fen(str));
                long parseLong2 = Long.parseLong(str2);
                this.mInputMoney = parseLong;
                if (parseLong < 1) {
                    return false;
                }
                if (parseLong <= parseLong2) {
                    return true;
                }
                QQToast.makeText(getContext(), 1, getString(R.string.ehf), 0).show();
                return false;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countFee() {
        this.mIsFeelacks = false;
        long j3 = this.mInputMoney;
        if (j3 >= 0 && this.hasBindBank) {
            if (this.mIsPayFee != 1) {
                this.mWithdrawFee = -1L;
                this.mWithdrawSum = j3;
                this.mWithdrawAllFlag = false;
                return;
            }
            if (this.mWithdrawAllFlag) {
                this.mWithdrawAllFlag = false;
                long j16 = this.mFullDrawFee;
                this.mWithdrawFee = j16;
                this.mWithdrawSum = this.mFullDrawAmount + j16;
                return;
            }
            if (this.mBalance <= this.mMinFee) {
                this.mWithdrawFee = 0L;
                this.mWithdrawSum = j3;
                return;
            }
            long j17 = this.mFreeLeftAmounts;
            if (j17 >= j3) {
                this.mWithdrawFee = 0L;
                this.mWithdrawSum = j3;
                return;
            }
            long j18 = this.mFullDrawAmount;
            if (j3 < j18) {
                try {
                    long divToLong = Utils.divToLong((j3 - j17) * this.mFeeRate, 10000, 0);
                    long j19 = this.mMinFee;
                    if (divToLong < j19) {
                        divToLong = j19;
                    }
                    this.mWithdrawFee = divToLong;
                } catch (Exception unused) {
                    this.mWithdrawFee = 0L;
                }
                long j26 = this.mWithdrawFee + j3;
                this.mWithdrawSum = j26;
                if (j26 > this.mBalance) {
                    long j27 = this.mFullDrawFee;
                    this.mWithdrawFee = j27;
                    this.mWithdrawSum = this.mFullDrawAmount + j27;
                    return;
                }
                return;
            }
            if (j3 == j18) {
                long j28 = this.mFullDrawFee;
                this.mWithdrawFee = j28;
                this.mWithdrawSum = j18 + j28;
                return;
            } else {
                long j29 = this.mFullDrawFee;
                this.mWithdrawFee = j29;
                this.mWithdrawSum = j18 + j29;
                this.mIsFeelacks = true;
                return;
            }
        }
        this.mWithdrawFee = -1L;
        this.mWithdrawSum = 0L;
        this.mWithdrawAllFlag = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayFeeInfo() {
        if (this.mWithdrawFee >= 0) {
            this.mWithdrawAllBtn.setVisibility(8);
            if (!TextUtils.isEmpty(this.mFee_desc_url)) {
                this.mQuestionIcon.setVisibility(0);
            }
            if (this.mWithdrawFee == 0) {
                if (this.mStrNoFee == null) {
                    this.mStrNoFee = getString(R.string.ehe);
                }
                this.mBalanceTV.setText(this.mStrNoFee);
                return;
            } else {
                if (this.mStrFormatFee == null) {
                    this.mStrFormatFee = getString(R.string.eh9);
                }
                this.mBalanceTV.setText(Html.fromHtml(String.format(this.mStrFormatFee, Utils.fen2Yuan(String.valueOf(this.mWithdrawFee)), Utils.fen2Yuan(String.valueOf(this.mWithdrawSum)))));
                return;
            }
        }
        this.mWithdrawAllBtn.setVisibility(0);
        this.mQuestionIcon.setVisibility(4);
        if (this.mStrFormatBalance == null) {
            this.mStrFormatBalance = getString(R.string.egw);
        }
        this.mBalanceTV.setText(Html.fromHtml(String.format(this.mStrFormatBalance, Utils.fen2Yuan(this.mBalance + ""))));
    }

    private void displayFeeTips() {
        if (ConfigUtil.readIsChargeTips(this.mUin)) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.tenpay.sdk.activity.WithdrawActivity.7
            @Override // java.lang.Runnable
            public void run() {
                if (WithdrawActivity.this.mUin == null) {
                    return;
                }
                JSONObject serverConfig = TenUtils.getServerConfig(DataProxy.getTenpayInternalPath() + WithdrawActivity.this.mUin + "/hbThemeConfig.cfg");
                if (serverConfig == null) {
                    return;
                }
                try {
                    JSONObject optJSONObject = serverConfig.optJSONObject("withdraw_fee_tips");
                    if (optJSONObject == null) {
                        return;
                    }
                    String optString = optJSONObject.optString(QCircleLpReportDc05502.KEY_BEGIN_TIME);
                    String optString2 = optJSONObject.optString("end_time");
                    String optString3 = optJSONObject.optString("title", null);
                    String optString4 = optJSONObject.optString("tips_text");
                    String optString5 = optJSONObject.optString("btn_text", null);
                    if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        long time = simpleDateFormat.parse(optString).getTime();
                        long time2 = simpleDateFormat.parse(optString2).getTime();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis >= time && currentTimeMillis <= time2) {
                            if (optString5 == null) {
                                optString5 = WithdrawActivity.this.getString(R.string.e9i);
                            }
                            QUIProxy.createCustomDialog(WithdrawActivity.this.getContext(), 230, optString3, optString4, optString5, null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.WithdrawActivity.7.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i3) {
                                    ConfigUtil.saveIsChargeTips(WithdrawActivity.this.mUin, true);
                                }
                            });
                        }
                    }
                } catch (Exception e16) {
                    QLog.e(((NetBaseActivity) WithdrawActivity.this).TAG, 1, "", e16);
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:11:0x0036, B:13:0x003c, B:17:0x0056, B:19:0x0064, B:21:0x006a, B:23:0x0070), top: B:10:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getRecommendBankIndex(@NonNull JSONArray jSONArray) {
        String str;
        String str2;
        JSONObject jSONObject;
        int i3;
        try {
            String readWithDrawBank = ConfigUtil.readWithDrawBank(this.mUin);
            if (TextUtils.isEmpty(readWithDrawBank)) {
                str = "";
                str2 = str;
            } else {
                JSONObject jSONObject2 = new JSONObject(readWithDrawBank);
                str = jSONObject2.optString("bank_name");
                try {
                    str2 = jSONObject2.optString("card_tail");
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e);
                    str2 = "";
                    int i16 = -1;
                    jSONObject = null;
                    i3 = 0;
                    int i17 = -1;
                    while (true) {
                        try {
                            if (i3 >= jSONArray.length()) {
                            }
                            i3++;
                        } catch (Exception e17) {
                            e = e17;
                        }
                    }
                    if (i3 != -1) {
                    }
                    if (jSONObject != null) {
                    }
                }
            }
        } catch (Exception e18) {
            e = e18;
            str = "";
        }
        int i162 = -1;
        jSONObject = null;
        i3 = 0;
        int i172 = -1;
        while (true) {
            if (i3 >= jSONArray.length()) {
                JSONObject jSONObject3 = (JSONObject) jSONArray.opt(i3);
                if (!jSONObject3.optString("draw_flag").equals("0")) {
                    if (jSONObject == null) {
                        i172 = i3;
                        jSONObject = jSONObject3;
                    }
                    String optString = jSONObject3.optString("bank_name");
                    String optString2 = jSONObject3.optString("card_tail");
                    if (!TextUtils.isEmpty(optString) && optString.equals(str) && !TextUtils.isEmpty(optString2) && optString2.equals(str2)) {
                        break;
                    }
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            try {
                if (!this.mBindNewCard) {
                    return i3;
                }
            } catch (Exception e19) {
                e = e19;
                i162 = i3;
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e);
                return i162;
            }
        }
        if (jSONObject != null) {
            return 0;
        }
        return i172;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go2ChooseWithdrawBankActivity() {
        Intent intent = new Intent();
        intent.putExtra("banks_info", this.mWithdrawBankObj.toString());
        intent.putExtra(WITHDRAW_COUNT, Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
        intent.putExtra(WITHDRAW_PROCESS_FLAG, this.process_flag);
        intent.putExtra("bank_index", this.mBankIndex);
        intent.putExtra("disableBankInfos", this.mDisableBankMap);
        launchFragmentForResult(intent, ChooseWithdrawBankActivity.class, BANK_RESULT_CODE);
    }

    private void go2WithdrawConfirmActivity(JSONObject jSONObject, String str) {
        Intent intent = new Intent();
        intent.putExtra("withdraw_info", jSONObject.toString());
        intent.putExtra(JSONConstant.KEY_CHARGE_FEE, str);
        intent.putExtra("pass_flag", this.pass_flag);
        intent.putExtra(WITHDRAW_PROCESS_FLAG, this.process_flag);
        launchFragmentForResult(intent, WithdrawConfirmActivity.class, RESULT_CODE);
    }

    private void initBankInfo() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("banks_info");
        this.mLastBalanceStr = intent.getStringExtra(WITHDRAW_COUNT);
        this.mPassFlag = intent.getStringExtra("pass_flag");
        this.mBankIndex = intent.getIntExtra("bank_index", -1);
        this.mBankBind = intent.getBooleanExtra("bing_withdraw_flag", false);
        this.mBindNewCard = intent.getBooleanExtra("bind_new_card", false);
        if (!TextUtils.isEmpty(stringExtra)) {
            parseBankinfo(stringExtra, this.mBankIndex);
            updateView();
            return;
        }
        JSONObject data = WalletGateData.getInstance().getData();
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        if (data != null) {
            initQWalletGateInfo(data);
            this.mTimestamp = WalletGateData.getInstance().getSysTimeStamp();
            sendWithdrawBankInfoRequest();
            return;
        }
        httpRequest(Cgi.URL_WALLET_GATE, hashMap);
    }

    private void initQWalletGateInfo(JSONObject jSONObject) {
        WalletGateData.getInstance().setData(this.mUin, jSONObject, System.currentTimeMillis());
        QwLog.i("initQWalletGateInfo");
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
    }

    private void logBankInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.d(((NetBaseActivity) this).TAG, 1, "logBankInfo null");
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("banks");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                sb5.append(optJSONArray.optJSONObject(i3).optString("card_tail"));
                sb5.append(",");
            }
            QLog.d(((NetBaseActivity) this).TAG, 1, "logBankInfo size=" + optJSONArray.length() + " tail=" + ((Object) sb5));
            return;
        }
        QLog.d(((NetBaseActivity) this).TAG, 1, "logBankInfo banks is empty");
    }

    private void parseBankinfo(String str, int i3) {
        JSONObject jSONObject;
        try {
            this.mWithdrawBankObj = new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        JSONObject jSONObject2 = this.mWithdrawBankObj;
        if (jSONObject2 != null) {
            JSONObject jSONObject3 = (JSONObject) jSONObject2.opt("account");
            if (jSONObject3 != null) {
                this.mBalance = jSONObject3.optInt("balance");
                this.mFreeLeftAmounts = jSONObject3.optLong(JSONConstant.KEY_FREE_QUOTA, 0L);
                this.mMinFee = jSONObject3.optLong(JSONConstant.KEY_MIN_CHARGE_FEE, 0L);
                this.pass_flag = jSONObject3.optString("pass_flag");
                this.mBank_true_name = jSONObject3.optString("true_name");
            }
            try {
                JSONArray jSONArray = this.mWithdrawBankObj.getJSONArray("banks");
                if (jSONArray.length() == 0) {
                    this.hasBindBank = false;
                } else if (i3 >= 0) {
                    setChoosedBankInfo((JSONObject) jSONArray.opt(i3));
                    this.hasBindBank = true;
                } else {
                    int recommendBankIndex = getRecommendBankIndex(jSONArray);
                    this.mBankIndex = recommendBankIndex;
                    if (recommendBankIndex > -1 && (jSONObject = jSONArray.getJSONObject(recommendBankIndex)) != null) {
                        setChoosedBankInfo(jSONObject);
                        this.hasBindBank = true;
                    }
                }
                if (this.mUserAttr == 3) {
                    this.process_flag = 127;
                } else {
                    if (!this.mBankBind && this.hasBindBank) {
                        this.process_flag = 112;
                    }
                    this.process_flag = 113;
                }
            } catch (JSONException e17) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e17);
            }
            this.mFeeRate = this.mWithdrawBankObj.optInt(JSONConstant.KEY_FEE_RATE, 0);
            this.mIsPayFee = this.mWithdrawBankObj.optInt(JSONConstant.KEY_PAY_FEE_FLAG, 0);
            JSONObject optJSONObject = this.mWithdrawBankObj.optJSONObject(JSONConstant.KEY_FULL_DRAW_PARAM);
            this.mFullDrawAmount = this.mBalance;
            this.mFullDrawFee = 0L;
            if (optJSONObject != null) {
                this.mFullDrawAmount = optJSONObject.optLong("amount", 0L);
                this.mFullDrawFee = optJSONObject.optLong(JSONConstant.KEY_CHARGE_FEE, 0L);
            }
            this.mFee_desc_url = this.mWithdrawBankObj.optString(JSONConstant.KEY_FEE_DESC_URL, null);
            countFee();
        }
    }

    private void setChoosedBankInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mBankimageId = jSONObject.optString("image_id");
        this.mBank_name = jSONObject.optString("bank_name");
        this.mBank_type = jSONObject.optString("bank_type");
        this.mCard_tail = jSONObject.optString("card_tail");
        this.mBind_serial = jSONObject.optString("bind_serial");
        this.mDraw_type = jSONObject.optString("draw_flag");
        this.mDraw_desc = jSONObject.optString("draw_desc");
        this.time_channel = jSONObject.optString("time_channel");
        if (!this.mDraw_type.equals("0")) {
            this.mBanksShowInfo = this.mBank_name + "(" + this.mCard_tail + ")";
            return;
        }
        this.mBanksShowInfo = this.mBank_name + "(" + this.mCard_tail + ") " + getString(R.string.f171370eh0);
    }

    private void updateView() {
        if (!TextUtils.isEmpty(this.mLastBalanceStr)) {
            this.mWithdrawCountTxt.setText(Utils.fen2Yuan(this.mLastBalanceStr));
            Editable text = this.mWithdrawCountTxt.getText();
            if (text instanceof Spannable) {
                Selection.setSelection(text, text.length());
            }
        }
        if (!TextUtils.isEmpty(this.mBanksShowInfo)) {
            this.mBankNameTV.setText(this.mBanksShowInfo);
        }
        if (this.hasBindBank) {
            if (this.mBankimageId != null && this.mBankImageView != null) {
                BankImageUtil.getInstance(getContext()).setBankImage(this.mBankimageId, this.mBankImageView);
            }
            if (!TextUtils.isEmpty(this.mDraw_desc)) {
                this.mWithdrawDescTV.setText(String.format(getString(R.string.eh6), this.mDraw_desc));
                this.mWithdrawDescTV.setVisibility(0);
            }
            this.mBankinfoLayout.setVisibility(0);
        } else {
            this.mBankinfoLayout.setVisibility(8);
            this.mWithdrawDescTV.setVisibility(8);
        }
        if (this.hasBindBank) {
            com.tencent.mobileqq.qwallet.c.c("cash.index.show", Integer.valueOf(this.process_flag));
        } else {
            com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.show", Integer.valueOf(this.process_flag));
        }
        displayFeeInfo();
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
        Button button = (Button) view.findViewById(R.id.l49);
        this.mWithdrawAllBtn = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.WithdrawActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (WithdrawActivity.this.hasBindBank) {
                    WithdrawActivity.this.mWithdrawAllFlag = true;
                    WithdrawActivity.this.mWithdrawCountTxt.setText(Utils.fen2Yuan(String.valueOf(WithdrawActivity.this.mFullDrawAmount)));
                    WithdrawActivity.this.mWithdrawAllFlag = false;
                } else {
                    WithdrawActivity.this.mWithdrawCountTxt.setText(Utils.fen2Yuan(String.valueOf(WithdrawActivity.this.mBalance)));
                }
                Editable text = WithdrawActivity.this.mWithdrawCountTxt.getText();
                if (text instanceof Spannable) {
                    Selection.setSelection(text, text.length());
                }
                if (WithdrawActivity.this.hasBindBank) {
                    com.tencent.mobileqq.qwallet.c.c("cash.index.allcash", Integer.valueOf(WithdrawActivity.this.process_flag));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.allcash", Integer.valueOf(WithdrawActivity.this.process_flag));
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mWithdrawDescTV = (TextView) view.findViewById(R.id.l4k);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.a57);
        this.mBankinfoLayout = linearLayout;
        if (!this.hasBindBank) {
            linearLayout.setVisibility(8);
            this.mWithdrawDescTV.setVisibility(8);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
        this.mTitleTV = textView2;
        textView2.setText(R.string.egr);
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.je7);
        this.mBalanceTV = (TextView) view.findViewById(R.id.a4q);
        ImageView imageView = (ImageView) view.findViewById(R.id.a_2);
        this.mQuestionIcon = imageView;
        imageView.setOnClickListener(this);
        ClearableEditLayout.DelegateEditText innerEditText = ((ClearableEditLayout) view.findViewById(R.id.l4f)).getInnerEditText();
        this.mWithdrawCountTxt = innerEditText;
        innerEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.WithdrawActivity.5
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
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.f164572a55);
        this.mBankLayout = linearLayout2;
        linearLayout2.setClickable(true);
        this.mBankLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.WithdrawActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                com.tencent.mobileqq.qwallet.c.c("cash.index.changecard", Integer.valueOf(WithdrawActivity.this.process_flag));
                WithdrawActivity.this.go2ChooseWithdrawBankActivity();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mBankImageView = (ImageView) view.findViewById(R.id.f164571a54);
        this.mBankNameTV = (TextView) view.findViewById(R.id.a56);
        Button button2 = (Button) view.findViewById(R.id.l4e);
        this.withdrawConfirmBtn = button2;
        button2.setOnClickListener(this);
        this.withdrawConfirmBtn.setEnabled(false);
        displayFeeTips();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == RESULT_CODE) {
            if (i16 == -1) {
                finish();
                return;
            }
            return;
        }
        if (i3 == BANK_RESULT_CODE) {
            if (i16 == -1) {
                if (intent == null) {
                    finish();
                    return;
                }
                String stringExtra = intent.getStringExtra("banks_info");
                this.mLastBalanceStr = intent.getStringExtra(WITHDRAW_COUNT);
                this.mBankIndex = intent.getIntExtra("bank_index", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    parseBankinfo(stringExtra, this.mBankIndex);
                    updateView();
                    return;
                } else {
                    sendWithdrawBankInfoRequest();
                    return;
                }
            }
            return;
        }
        if (i3 == BIND_BANK_RESULT_CODE && i16 != 0 && i16 == -1) {
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        DisableBankInfo createByRetUrl;
        super.onBlError(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (!Cgi.URI_QWallet_REQUEST_WITHDRAW.equals(str) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("returl");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            Uri parse = Uri.parse(optString);
            if ("changeSelectCard".equals(parse.getHost()) && (createByRetUrl = DisableBankInfo.INSTANCE.createByRetUrl(parse)) != null) {
                this.mDisableBankMap.put(createByRetUrl.getSerial(), createByRetUrl);
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        if (i3 == 0) {
            this.mJumpFromFakeLeft = true;
            return false;
        }
        if ("changeSelectCard".equals(fakeInfo.host)) {
            go2ChooseWithdrawBankActivity();
            return true;
        }
        if (fakeInfo.host.equals("continueWithdraw")) {
            this.mDraw_idFromServer = fakeInfo.uri.getQueryParameter(JSONConstant.KEY_DRAW_ID);
            this.mcharge_feeFromServer = fakeInfo.uri.getQueryParameter(JSONConstant.KEY_CHARGE_FEE);
            this.mAmountFromServer = fakeInfo.uri.getQueryParameter("amount");
            String queryParameter = fakeInfo.uri.getQueryParameter(JSONConstant.KEY_FEE_RATE);
            if (!TextUtils.isEmpty(queryParameter)) {
                this.mFeeRate = Integer.parseInt(queryParameter);
            }
            this.mContinue_flag = 1;
            sendWithdrawApplyRequest();
            return true;
        }
        return super.onBlHandleFakeurl(fakeInfo, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightText) {
            if (this.mIsBackKeyPressed) {
                if (this.hasBindBank) {
                    com.tencent.mobileqq.qwallet.c.c("cash.index.keyback", Integer.valueOf(this.process_flag));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.keyback", Integer.valueOf(this.process_flag));
                }
            } else if (this.hasBindBank) {
                com.tencent.mobileqq.qwallet.c.c("cash.index.back", Integer.valueOf(this.process_flag));
            } else {
                com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.back", Integer.valueOf(this.process_flag));
            }
            finish();
            getActivity().overridePendingTransition(0, R.anim.f154878es);
        } else if (id5 == R.id.l4e) {
            if (this.hasBindBank) {
                com.tencent.mobileqq.qwallet.c.c("cash.index.next", Integer.valueOf(this.process_flag));
            } else {
                com.tencent.mobileqq.qwallet.c.c("cash.nocardindex.next", Integer.valueOf(this.process_flag));
            }
            if (this.hasBindBank) {
                if (!this.mDraw_type.equals("0")) {
                    sendWithdrawApplyRequest();
                } else {
                    QQToast.makeText(getContext(), 0, getString(R.string.e38), 0).show();
                }
            } else {
                com.tencent.mobileqq.qwallet.c.c("cash.nocard.record", Integer.valueOf(this.process_flag));
                Intent intent = new Intent();
                intent.putExtra("pass_flag", this.mPassFlag);
                intent.putExtra(WITHDRAW_COUNT, Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
                intent.putExtra(FROM_WITHDRAW, true);
                BindBankModule.INSTANCE.startWithSwitchForResult(this, intent, BIND_BANK_RESULT_CODE, 4);
            }
            if (this.mKeyboard.isShown()) {
                this.mKeyboard.setVisibility(8);
            }
        } else if (view == this.mQuestionIcon && !TextUtils.isEmpty(this.mFee_desc_url)) {
            QFuncProxy.gotoH5(getOutActivity(), this.mFee_desc_url, true, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            this.mAmount = new JSONObject(getIntent().getStringExtra("extra_data")).optLong("amount", 0L);
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        View inflate = layoutInflater.inflate(R.layout.agr, viewGroup, false);
        initView(inflate);
        initBankInfo();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retmsg");
        String optString2 = jSONObject.optString("retcode");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Cgi.RETURN_MSG_JSON_ERROR_KEY, optString);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        setRetCodeMsgAndGetBundle(Integer.parseInt(optString2), jSONObject2.toString());
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        boolean b16 = com.tencent.mobileqq.qwallet.utils.g.b("qwallet_bindcard_refresh");
        if (this.mJumpFromFakeLeft && b16) {
            sendWithdrawBankInfoRequest();
            this.mJumpFromFakeLeft = false;
            com.tencent.mobileqq.qwallet.utils.g.s("qwallet_bindcard_refresh");
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (isFinishing()) {
            return;
        }
        this.mProgressBar.setVisibility(8);
        if (str.equals(Cgi.URI_QWallet_WITHDRAW_BANK)) {
            logBankInfo(jSONObject);
            this.mWithdrawBankObj = jSONObject;
            parseBankinfo(jSONObject.toString(), -1);
            updateView();
            try {
                long j3 = this.mBalance;
                if (j3 != -1) {
                    long j16 = this.mAmount;
                    if (j16 > 0 && j16 <= j3) {
                        this.mWithdrawCountTxt.setText(Utils.fen2Yuan(Long.toString(j16)));
                        Editable text = this.mWithdrawCountTxt.getText();
                        if (text instanceof Spannable) {
                            Selection.setSelection(text, text.length());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (str.equals(Cgi.URI_QWallet_REQUEST_WITHDRAW)) {
            String optString = jSONObject.optString(JSONConstant.KEY_CHARGE_FEE);
            JSONObject jSONObject2 = new JSONObject();
            try {
                String optString2 = jSONObject.optString("amount");
                if (TextUtils.isEmpty(optString2)) {
                    jSONObject2.put("amount", Utils.yuan2Fen(this.mWithdrawCountTxt.getText().toString()));
                } else {
                    jSONObject2.put("amount", optString2);
                }
                jSONObject2.put("bank_type", this.mBank_type);
                jSONObject2.put("card_tail", this.mCard_tail);
                jSONObject2.put("bank_name", this.mBank_name);
                jSONObject2.put("bind_serial", this.mBind_serial);
                jSONObject2.put("bank_true_name", this.mBank_true_name);
                jSONObject2.put(JSONConstant.KEY_DRAW_ID, jSONObject.optString(JSONConstant.KEY_DRAW_ID));
                jSONObject2.put(WadlProxyConsts.CHANNEL, "1");
                jSONObject2.put("draw_type", this.mDraw_type);
                jSONObject2.put("free_type", "1");
                jSONObject2.put("desc", this.mDraw_desc);
                jSONObject2.put(JSONConstant.KEY_FEE_RATE, this.mFeeRate);
                jSONObject2.put(JSONConstant.KEY_PAY_FEE_FLAG, this.mIsPayFee);
                com.tencent.mobileqq.qwallet.c.c("cash.apply.ok", Integer.valueOf(this.process_flag));
                go2WithdrawConfirmActivity(jSONObject2, optString);
                return;
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "onSuccess: ", e16);
                return;
            }
        }
        if (str.equals(Cgi.URL_WALLET_GATE)) {
            initQWalletGateInfo(jSONObject);
            sendWithdrawBankInfoRequest();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void sendWithdrawApplyRequest() {
        HashMap hashMap = new HashMap();
        hashMap.put("amount", this.mInputMoney + "");
        hashMap.put("bank_type", this.mBank_type);
        hashMap.put("card_tail", this.mCard_tail);
        hashMap.put("bind_serial", this.mBind_serial);
        hashMap.put(WadlProxyConsts.CHANNEL, "1");
        hashMap.put("time_channel", this.time_channel);
        if (!this.mIsFeelacks && this.mWithdrawFee >= 0) {
            hashMap.put(JSONConstant.KEY_CHARGE_FEE, this.mWithdrawFee + "");
        } else {
            hashMap.put(JSONConstant.KEY_CHARGE_FEE, "0");
        }
        hashMap.put(JSONConstant.KEY_FEE_RATE, this.mFeeRate + "");
        if (this.mContinue_flag == 1) {
            hashMap.put(JSONConstant.KEY_CONTINUE_FLAG, this.mContinue_flag + "");
            hashMap.put(JSONConstant.KEY_CHARGE_FEE, this.mcharge_feeFromServer);
            hashMap.put(JSONConstant.KEY_DRAW_ID, this.mDraw_idFromServer);
            hashMap.put("amount", this.mAmountFromServer);
            this.mcharge_feeFromServer = null;
            this.mAmountFromServer = null;
            this.mDraw_idFromServer = null;
            this.mContinue_flag = 0;
        }
        httpRequest(Cgi.URI_QWallet_REQUEST_WITHDRAW, hashMap);
    }

    protected void sendWithdrawBankInfoRequest() {
        httpRequest(Cgi.URI_QWallet_WITHDRAW_BANK, new HashMap());
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
