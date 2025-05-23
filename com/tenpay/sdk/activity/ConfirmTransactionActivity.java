package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.api.TenpayInterface;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.view.Switch;
import com.tenpay.util.Utils;
import cooperation.qwallet.open.data.PayInfo;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ConfirmTransactionActivity extends NetBaseActivity implements View.OnClickListener {
    public static final String KEY_QPAY_GATE = "pay_gate";
    public static final String KEY_TOKEN_ID = "token_id";
    public static int ShiMing_RESULT_CODE = 1002;
    private static final int TO_PAY_ACTIVITY_REQUEST_CODE = 101;
    protected LinearLayout mAutoPayContractLayout;
    protected String mAutoPayContractLink;
    protected TextView mAutoPayContractLinkTxt;
    protected TextView mAutoPayDescTxt;
    protected LinearLayout mAutoPayLayout;
    protected Switch mAutoPaySwitchBtn;
    private String mBankType;
    protected TextView mBusyNameText;
    protected TextView mCancelBtn;
    protected Button mConfirmBtn;
    private String mCurPromoObj;
    protected TextView mCutFee;
    private String mDefaultCardInfo;
    protected TextView mGoodsNameText;
    protected boolean mIsBackKeyPressed;
    private int mIsCallback;
    protected JSONObject mPayGateObj;
    private PayInfo mPayInfo;
    private int mProcessFlag;
    protected LinearLayout mRootLayout;
    protected JSONObject mSelectAutoPro;
    private JSONObject mSelectBankObj;
    private int mSelectedPayBankIndex;
    String mTokenId;
    protected TextView mTotalFeeText;
    private String promoTxt;
    TextView tv_tenpay_real_fee;
    protected JSONObject mAutoPayJson = null;
    protected String mTrustPayOpen = "";
    private boolean mFpUpdated = false;
    private int mSelectedPayType = -1;
    private final AtomicBoolean mIsNoCard = new AtomicBoolean(false);

    private void afterPayGatePromotionLogic() {
        this.mTotalFee = this.mPayGateObj.optString("real_fee");
        this.mPromotionFlag = this.mPayGateObj.optString("promotion_flag");
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("promotion_info");
        String defaultPayTpye = getDefaultPayTpye();
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("recommend_pay");
            if (!Utils.isEmpty(optString)) {
                defaultPayTpye = optString;
            }
        }
        resolvePromotionInfo(getThePromotionObject(this.mPayGateObj, defaultPayTpye));
    }

    private boolean checkAutoPay(List<JSONObject> list) {
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                JSONObject jSONObject = list.get(i3);
                if (jSONObject.optInt("disable") == 0) {
                    String str = jSONObject.optString(QWSoterConstans.CGI_KEY_BUSI_TYPE) + jSONObject.optString("uin");
                    String str2 = this.mDefaultCardInfo;
                    if (str2 != null && str2.equals(str)) {
                        break;
                    }
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            return false;
        }
        this.mSelectAutoPro = list.get(i3);
        this.mSelectedPayType = 5;
        this.mSelectedPayBankIndex = i3;
        return true;
    }

    private String checkCardPay(List<JSONObject> list) {
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                JSONObject jSONObject = list.get(i3);
                if (jSONObject.optInt("disable") == 0) {
                    String str = jSONObject.optString("bank_type") + jSONObject.optString("card_tail");
                    String str2 = this.mDefaultCardInfo;
                    if (str2 != null) {
                        if (str2.equals(str) || Cgi.CTPAY_BANK_TYPE.equals(this.mDefaultCardInfo)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            return list.get(i3).optString("bank_type");
        }
        return null;
    }

    private String getDefaultPayTpye() {
        boolean z16;
        int i3;
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(this.mPayGateObj, "bind_banks", "cardtype");
        List<JSONObject> findAllCanUseAutoPay = NetUtil.findAllCanUseAutoPay(this.mPayGateObj);
        int optInt = this.mPayGateObj.optInt("pay_types", 63);
        boolean z17 = !Utils.compareString(this.mTotalFee, this.mPayGateObj.optString("balance"));
        String optString = this.mPayGateObj.optString("pay_types_seq");
        if ("11".equals(optString)) {
            if ((optInt & 1) == 1 && z17) {
                return "0";
            }
        } else if (!"22".equals(optString)) {
            this.mDefaultCardInfo = "";
        }
        if (!TextUtils.isEmpty(optString)) {
            z16 = optString.startsWith("1");
        } else {
            z16 = false;
        }
        if (this.mSelectedPayType >= 0) {
            i3 = this.mSelectedPayBankIndex;
        } else {
            int size = findBindedBanks.size();
            if (size > 0) {
                for (int i16 = 0; i16 < size; i16++) {
                    JSONObject jSONObject = findBindedBanks.get(i16);
                    if (jSONObject.optInt("disable") == 0) {
                        if (jSONObject.optInt("is_creditpay") == 1) {
                            String optString2 = jSONObject.optString("available_amount");
                            if (jSONObject.optInt("card_status") == 2 && (!Utils.compareString(this.mTotalFee, optString2))) {
                                this.mSelectedPayType = 3;
                            }
                        }
                        i3 = i16;
                        break;
                    }
                }
            }
            i3 = -1;
        }
        if (z16) {
            if ((optInt & 1) == 1 && z17) {
                QwLog.i("\u5141\u8bb8\u4f59\u989d\u652f\u4ed8");
                return "0";
            }
            if (checkAutoPay(findAllCanUseAutoPay)) {
                return this.mSelectAutoPro.optString(QWSoterConstans.CGI_KEY_BUSI_TYPE);
            }
            if (i3 == -1) {
                return null;
            }
            QwLog.i("---\u9009\u62e9\u7b2c\u4e00\u5f20\u53ef\u7528\u7684\u5df2\u7ed1\u94f6\u884c\u5361, \u5e8f\u53f7 = " + i3);
            JSONObject jSONObject2 = findBindedBanks.get(i3);
            this.mSelectBankObj = jSONObject2;
            return jSONObject2.optString("bank_type");
        }
        if (i3 != -1) {
            QwLog.i("---\u9009\u62e9\u7b2c\u4e00\u5f20\u53ef\u7528\u7684\u5df2\u7ed1\u94f6\u884c\u5361, \u5e8f\u53f7 = " + i3);
            JSONObject jSONObject3 = findBindedBanks.get(i3);
            this.mSelectBankObj = jSONObject3;
            return jSONObject3.optString("bank_type");
        }
        QwLog.i("---\u65e0\u53ef\u7528\u5df2\u7ed1\u5feb\u6377\uff0c\u9009\u62e9\u4f59\u989d\u652f\u4ed8---");
        if ((optInt & 1) == 1 && z17) {
            QwLog.i("\u5141\u8bb8\u4f59\u989d\u652f\u4ed8");
            return "0";
        }
        if (!checkAutoPay(findAllCanUseAutoPay)) {
            return null;
        }
        return this.mSelectAutoPro.optString(QWSoterConstans.CGI_KEY_BUSI_TYPE);
    }

    private void getPromoInfoFromPayAct(Intent intent) {
        this.mSelectedPayType = intent.getIntExtra("select_pay_type", -1);
        this.mSelectedPayBankIndex = intent.getIntExtra("select_bank_index", -1);
        this.mCurPromoObj = intent.getStringExtra("cur_promo_json");
        this.promoTxt = intent.getStringExtra("promo_txt");
        this.mBankType = intent.getStringExtra("bank_type");
    }

    private JSONObject getThePromotionObject(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("promotion_info");
        if (optJSONObject2 == null) {
            return null;
        }
        if (!Utils.isEmpty(str)) {
            optJSONArray = Utils.joinJSONArray(optJSONObject2.optJSONArray(str), optJSONObject2.optJSONArray("comm"));
            if (optJSONArray != null && optJSONArray.length() > 0) {
                optJSONObject = optJSONArray.optJSONObject(0);
            }
            optJSONArray = null;
            optJSONObject = null;
        } else {
            optJSONArray = optJSONObject2.optJSONArray("comm");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                optJSONObject = optJSONArray.optJSONObject(0);
            }
            optJSONArray = null;
            optJSONObject = null;
        }
        if (str != null && str.equals("0") && optJSONArray != null && optJSONArray.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                if (!optJSONArray.optJSONObject(i3).optString("balance_flag").equals("0")) {
                    jSONArray.mo162put(optJSONArray.opt(i3));
                }
            }
            if (jSONArray.length() <= 0) {
                return null;
            }
            return jSONArray.optJSONObject(0);
        }
        return optJSONObject;
    }

    private String getWebankBanlance() {
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(this.mPayGateObj, "bind_banks", "cardtype");
        if (findBindedBanks.size() > 0) {
            for (JSONObject jSONObject : findBindedBanks) {
                int optInt = jSONObject.optInt("is_creditpay");
                int optInt2 = jSONObject.optInt("card_status");
                if (optInt == 1 && optInt2 == 2) {
                    String optString = jSONObject.optString("available_amount");
                    this.mSelectBankObj = jSONObject;
                    return optString;
                }
            }
            return null;
        }
        return null;
    }

    private void goToPayActivity() {
        String str;
        Class<? extends QWalletBaseFragment> cls;
        Intent intent = new Intent();
        intent.putExtra("is_from_confirm_trans", true);
        intent.putExtra("trustpay_open_flag", this.mTrustPayOpen);
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag)) {
            intent.putExtra("is_callback", this.mIsCallback);
        } else {
            try {
                this.mPayGateObj.put("token_id", this.mTokenId);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            intent.putExtra("pay_gate", this.mPayGateObj.toString());
        }
        intent.putExtra("token_id", this.mTokenId);
        if (!Utils.isEmpty(this.mBankType)) {
            intent.putExtra("select_pay_type", this.mSelectedPayType);
            intent.putExtra("select_bank_index", this.mSelectedPayBankIndex);
            intent.putExtra("bank_type", this.mBankType);
            intent.putExtra("cur_promo_json", this.mCurPromoObj);
        }
        if (this.mPayInfo != null) {
            intent.putExtra(PayInfo.class.getName(), this.mPayInfo);
        }
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("busi_switch");
        String optString = this.mPayGateObj.optString("pay_scene");
        if (optJSONObject != null) {
            str = optJSONObject.optString(HiAnalyticsConstant.BI_KEY_SDK_VER);
        } else {
            str = "V1";
        }
        if ("business".equals(optString) && "V2".equals(str)) {
            cls = BusinessPayActivity.class;
        } else {
            cls = PayActivity.class;
        }
        launchFragmentForResult(intent, cls, 101);
    }

    private void initPayGateData() {
        JSONObject jSONObject = this.mPayGateObj;
        if (jSONObject == null) {
            return;
        }
        this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
        this.mBargainorName = this.mPayGateObj.optString("bargainor_true_name");
        this.mGoodsName = this.mPayGateObj.optString("desc");
        this.mCardType = this.mPayGateObj.optString("creditcard_type");
        this.mCardID = this.mPayGateObj.optString("creditcard_id");
        this.mTrueName = this.mPayGateObj.optString("purchaser_true_name");
        this.mUserAttr = this.mPayGateObj.optInt("user_attr");
        this.mCacheVer = this.mPayGateObj.optString("interf_cache_ver");
        this.mUserCertType = this.mPayGateObj.optInt("cert_user");
        this.mBargainorId = this.mPayGateObj.optString("bargainor_id");
        afterPayGatePromotionLogic();
        this.mTouchidState = this.mPayGateObj.optInt("touchid_state");
        this.mTouchidStateInfo = this.mPayGateObj.optString("touchid_state_info");
        this.mTouchidRetryMaxCount = this.mPayGateObj.optInt("touchid_retry_count");
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("trustpay_param");
        this.mAutoPayJson = optJSONObject;
        if (optJSONObject == null) {
            this.mAutoPayLayout.setVisibility(8);
            this.mConfirmBtn.setText(R.string.eao);
        } else {
            this.mAutoPayLayout.setVisibility(0);
            String optString = this.mAutoPayJson.optString("select_flag");
            if ("1".equals(optString)) {
                this.mConfirmBtn.setText(R.string.eas);
                this.mAutoPaySwitchBtn.setChecked(true);
                this.mAutoPaySwitchBtn.setVisibility(0);
                this.mAutoPayContractLayout.setVisibility(0);
            } else if ("2".equals(optString)) {
                this.mConfirmBtn.setText(R.string.eas);
                this.mAutoPaySwitchBtn.setChecked(true);
                this.mAutoPaySwitchBtn.setVisibility(8);
                this.mAutoPayContractLayout.setVisibility(0);
            } else {
                this.mConfirmBtn.setText(R.string.eao);
                this.mAutoPaySwitchBtn.setChecked(false);
                this.mAutoPaySwitchBtn.setVisibility(0);
                this.mAutoPayContractLayout.setVisibility(8);
            }
            this.mAutoPayDescTxt.setText(this.mAutoPayJson.optString("trustpay_text"));
            this.mAutoPayContractLink = this.mAutoPayJson.optString("trustpay_url");
            this.mProcessFlag = 170;
            com.tencent.mobileqq.qwallet.c.c("trade.deduction.show", 170);
        }
        String optString2 = this.mPayGateObj.optString("domain_name");
        if (!TextUtils.isEmpty(optString2)) {
            setServerAddr(optString2);
        }
        String optString3 = this.mPayGateObj.optString("trade_state_desc");
        String optString4 = this.mPayGateObj.optString("trade_state");
        TextView textView = (TextView) this.mRootLayout.findViewById(R.id.kcs);
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag)) {
            ((TextView) this.mRootLayout.findViewById(R.id.f166493fk4)).setText(getString(R.string.eea));
        }
        if (optString4.equals("SUCCESS")) {
            this.mConfirmBtn.setEnabled(false);
            textView.setVisibility(0);
            if (!TextUtils.isEmpty(optString3)) {
                textView.setText(optString3);
            }
            this.mCutFee.setTextColor(getContext().getResources().getColor(R.color.f157686wr));
        } else {
            this.mConfirmBtn.setEnabled(true);
            textView.setVisibility(8);
            this.mCutFee.setTextColor(getContext().getResources().getColor(R.color.f157654vt));
        }
        this.mGoodsNameText.setText(this.mGoodsName);
        this.mBusyNameText.setText(this.mBargainorName);
        this.mTotalFeeText.setText(Utils.transformToMoney(this.mTotalFee, 0));
        this.mRootLayout.setVisibility(0);
        showPromotionInfo();
    }

    private void initView(View view) {
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.b_1);
        this.mGoodsNameText = (TextView) view.findViewById(R.id.fzs);
        this.mTotalFeeText = (TextView) view.findViewById(R.id.f166540fz1);
        this.mBusyNameText = (TextView) view.findViewById(R.id.f164582a63);
        this.tv_tenpay_real_fee = (TextView) this.mRootLayout.findViewById(R.id.jeq);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mCancelBtn = textView;
        textView.setText(R.string.e2i);
        this.mCancelBtn.setVisibility(0);
        this.mCancelBtn.setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setVisibility(8);
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.e_o);
        this.mCutFee = (TextView) view.findViewById(R.id.jdt);
        Button button = (Button) view.findViewById(R.id.b7p);
        this.mConfirmBtn = button;
        button.setOnClickListener(this);
        this.mAutoPayLayout = (LinearLayout) view.findViewById(R.id.a1u);
        this.mAutoPayDescTxt = (TextView) view.findViewById(R.id.a1t);
        Switch r06 = (Switch) view.findViewById(R.id.a1v);
        this.mAutoPaySwitchBtn = r06;
        r06.setSwitchNoSkin();
        this.mAutoPaySwitchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tenpay.sdk.activity.ConfirmTransactionActivity.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                ConfirmTransactionActivity confirmTransactionActivity = ConfirmTransactionActivity.this;
                if (confirmTransactionActivity.mAutoPayContractLayout != null) {
                    if (z16) {
                        confirmTransactionActivity.mConfirmBtn.setText(R.string.eas);
                        ConfirmTransactionActivity.this.mAutoPayContractLayout.setVisibility(0);
                        ConfirmTransactionActivity confirmTransactionActivity2 = ConfirmTransactionActivity.this;
                        confirmTransactionActivity2.mTrustPayOpen = "1";
                        com.tencent.mobileqq.qwallet.c.c("trade.deduction.open", Integer.valueOf(confirmTransactionActivity2.mProcessFlag));
                    } else {
                        confirmTransactionActivity.mConfirmBtn.setText(R.string.eao);
                        ConfirmTransactionActivity.this.mAutoPayContractLayout.setVisibility(8);
                        ConfirmTransactionActivity confirmTransactionActivity3 = ConfirmTransactionActivity.this;
                        confirmTransactionActivity3.mTrustPayOpen = "0";
                        com.tencent.mobileqq.qwallet.c.c("trade.deduction.close", Integer.valueOf(confirmTransactionActivity3.mProcessFlag));
                    }
                }
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        });
        this.mAutoPayContractLayout = (LinearLayout) view.findViewById(R.id.a1r);
        TextView textView2 = (TextView) view.findViewById(R.id.a1s);
        this.mAutoPayContractLinkTxt = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ConfirmTransactionActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (!TextUtils.isEmpty(ConfirmTransactionActivity.this.mAutoPayContractLink)) {
                    com.tencent.mobileqq.qwallet.c.c("trade.deduction.agreement", Integer.valueOf(ConfirmTransactionActivity.this.mProcessFlag));
                    ConfirmTransactionActivity confirmTransactionActivity = ConfirmTransactionActivity.this;
                    confirmTransactionActivity.gotoH5(confirmTransactionActivity.mAutoPayContractLink);
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }

    private void notHavePromotion() {
        JSONObject jSONObject = this.mPayGateObj;
        if (jSONObject != null) {
            String optString = jSONObject.optString("total_fee");
            this.mTotalFee = optString;
            this.mTotalFeeText.setText(Utils.transformToMoney(optString, 0));
        }
        this.mCutFee.setVisibility(8);
        this.tv_tenpay_real_fee.setVisibility(8);
    }

    private void resolvePromotionInfo(JSONObject jSONObject) {
        boolean z16;
        if (jSONObject == null) {
            return;
        }
        this.mPromotionFee = jSONObject.optString("promotion_fee");
        this.mDiscountType = jSONObject.optString("discount_type");
        this.mPromotionName = jSONObject.optString("promotion_name");
        this.mPromotionType = jSONObject.optString("promotion_type");
        this.mPromotionId = jSONObject.optString("promotion_id");
        this.mPromotionShowTxt = jSONObject.optString("promotion_show");
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1") && !TextUtils.isEmpty(this.mPromotionType) && this.mPromotionType.equals("1") && !TextUtils.isEmpty(this.mDiscountType) && this.mDiscountType.equals("2")) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsRandomCut = z16;
        if ("0".equals(this.mPromotionFlag)) {
            this.mTotalFee = this.mPayGateObj.optString("total_fee");
            this.mOriginalTotal = this.mPayGateObj.optString("total_fee");
        } else if (this.mIsRandomCut) {
            this.mTotalFee = this.mPayGateObj.optString("total_fee");
            this.mOriginalTotal = this.mPayGateObj.optString("total_fee");
        } else {
            this.mOriginalTotal = this.mPayGateObj.optString("total_fee");
            this.mTotalFee = jSONObject.optString("real_fee");
        }
    }

    private void sendPayGateRequest() {
        int indexOf;
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        getSharedPreferences(SharedHelper.QB_TENPAY_FP_ + this.mUin, 0);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        String str = null;
        try {
            String stringExtra = intent.getStringExtra("extra_data");
            if (!TextUtils.isEmpty(stringExtra) && (indexOf = (str = new JSONObject(stringExtra).optString("h5_url")).indexOf(63)) > 0) {
                str = str.substring(0, indexOf);
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("h5_url", str);
        }
        hashMap.put("come_from", this.mComeFrom + "");
        PayInfo payInfo = this.mPayInfo;
        if (payInfo != null) {
            if (payInfo.o()) {
                hashMap.putAll(this.mPayInfo.t());
            } else {
                hashMap.putAll(this.mPayInfo.s());
                hashMap.put("sdk_channel", String.valueOf(intent.getIntExtra("sdk_channel", 0)));
            }
        } else {
            hashMap.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            hashMap.put("sdk_data", getIntent().getStringExtra("sdk_data"));
            hashMap.put("token_id", this.mTokenId);
        }
        httpRequest(Cgi.URI_PAY_GATE, hashMap);
    }

    private void setTransferView() {
        Intent intent = getIntent();
        this.mIsCallback = intent.getIntExtra("is_callback", 0);
        String stringExtra = intent.getStringExtra("transfer_seller_uin");
        String stringExtra2 = intent.getStringExtra("transfer_seller_name");
        String stringExtra3 = intent.getStringExtra("transfer_reward_name");
        intent.getStringExtra("transfer_total_fee");
        this.mGoodsNameText.setText(stringExtra3);
        if (TextUtils.isEmpty(stringExtra2)) {
            this.mBusyNameText.setText(stringExtra);
        } else {
            this.mBusyNameText.setText(stringExtra2 + "(" + stringExtra + ")");
        }
        this.mTotalFeeText.setText(Utils.transformToMoney(this.mTotalFee, 0));
        this.mRootLayout.findViewById(R.id.kcs).setVisibility(8);
        ((TextView) this.mRootLayout.findViewById(R.id.f166493fk4)).setText(R.string.eea);
        this.mAutoPayLayout.setVisibility(8);
        this.mRootLayout.setVisibility(0);
        com.tencent.mobileqq.qwallet.c.c("trade.check.show", Integer.valueOf(this.mProcessFlag));
    }

    private void updatePromoInfo(Intent intent) {
        getPromoInfoFromPayAct(intent);
        try {
            if (Utils.isEmpty(this.mCurPromoObj)) {
                notHavePromotion();
            } else {
                resolvePromotionInfo(new JSONObject(this.mCurPromoObj));
                showPromotionInfo();
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mIsBackKeyPressed = true;
            this.mCancelBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            if (i3 == ShiMing_RESULT_CODE) {
                sendPayGateRequest();
                return;
            } else {
                if (i3 == 101) {
                    updatePromoInfo(intent);
                    return;
                }
                return;
            }
        }
        if (i16 == 0) {
            if (i3 == ShiMing_RESULT_CODE) {
                finish();
            } else if (i3 == 101 && intent != null) {
                this.mIsNoCard.set(intent.getBooleanExtra(PayActivity.KEY_IS_NO_CARD_TYPE, false));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightText) {
            QUIProxy.createCustomDialog(getContext(), 230, null, "\u662f\u5426\u653e\u5f03\u672c\u6b21\u652f\u4ed8\uff1f", "\u7ee7\u7eed\u652f\u4ed8", "\u653e\u5f03", new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ConfirmTransactionActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ConfirmTransactionActivity confirmTransactionActivity = ConfirmTransactionActivity.this;
                    if (confirmTransactionActivity.mIsBackKeyPressed) {
                        com.tencent.mobileqq.qwallet.c.c("trade.check.keyback", Integer.valueOf(confirmTransactionActivity.mProcessFlag));
                    } else {
                        com.tencent.mobileqq.qwallet.c.c("trade.check.back", Integer.valueOf(confirmTransactionActivity.mProcessFlag));
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(ConfirmTransactionActivity.this.mPayGateObj.optString("sdk_auth_data"))) {
                            jSONObject.put("sdk_auth_data", ConfirmTransactionActivity.this.mPayGateObj.optString("sdk_auth_data"));
                        }
                    } catch (Exception unused) {
                    }
                    ConfirmTransactionActivity.this.setRetCodeMsgAndGetBundle(-1, jSONObject.toString());
                    ConfirmTransactionActivity.this.finish();
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ConfirmTransactionActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                }
            });
        } else if (id5 == R.id.b7p) {
            if (!TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag)) {
                if (this.mPayGateObj != null) {
                    if ("1".equals(this.mTrustPayOpen)) {
                        com.tencent.mobileqq.qwallet.c.c("trade.deduction.go", Integer.valueOf(this.mProcessFlag));
                    } else {
                        com.tencent.mobileqq.qwallet.c.c("trade.check.go", Integer.valueOf(this.mProcessFlag));
                    }
                }
            }
            goToPayActivity();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.adl, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsNoCard.compareAndSet(true, false) && ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_CONFIRM_TRANS_RELOAD, true)) {
            sendPayGateRequest();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (!isFinishing() && Cgi.URI_PAY_GATE.equals(str)) {
            this.mPayGateObj = jSONObject;
            initPayGateData();
            com.tencent.mobileqq.qwallet.c.c("trade.check.show", Integer.valueOf(this.mProcessFlag));
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mEnterType = Cgi.ENTER_FROM_PAY;
        Intent intent = getIntent();
        PayInfo payInfo = (PayInfo) intent.getParcelableExtra(PayInfo.class.getName());
        this.mPayInfo = payInfo;
        if (payInfo != null) {
            this.mTokenId = payInfo.getPrepayId();
        } else {
            this.mTokenId = intent.getStringExtra("token_id");
        }
        String stringExtra = intent.getStringExtra("uin");
        this.mUin = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.mUin = getAppRuntime().getCurrentAccountUin();
        }
        initView(view);
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag)) {
            this.mProcessFlag = 180;
            setTransferView();
            return;
        }
        this.mComeFrom = intent.getIntExtra("come_from", 0);
        this.mAppInfo = intent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0);
        this.mProcessFlag = 11;
        String stringExtra2 = intent.getStringExtra("pay_gate");
        if (TextUtils.isEmpty(stringExtra2)) {
            sendPayGateRequest();
            return;
        }
        try {
            this.mPayGateObj = new JSONObject(stringExtra2);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            finish();
        }
        if (this.mPayGateObj == null) {
            finish();
        }
        com.tencent.mobileqq.qwallet.c.c("trade.check.show", Integer.valueOf(this.mProcessFlag));
        initPayGateData();
    }

    public void showPromotionInfo() {
        String str;
        String string;
        String format;
        String string2;
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("busi_switch");
        String optString = this.mPayGateObj.optString("pay_scene");
        if (optJSONObject != null) {
            str = optJSONObject.optString(HiAnalyticsConstant.BI_KEY_SDK_VER);
        } else {
            str = "V1";
        }
        if ("business".equals(optString) && "V2".equals(str)) {
            String optString2 = this.mPayGateObj.optString("marketing_content");
            if (!TextUtils.isEmpty(optString2)) {
                this.mCutFee.setVisibility(0);
                this.mCutFee.setText(optString2);
            }
            this.mTotalFeeText.setText(Utils.transformToMoney(this.mPayGateObj.optString("total_fee"), 0));
            return;
        }
        if (this.mIsRandomCut) {
            this.mCutFee.setVisibility(0);
            if (!TextUtils.isEmpty(this.mPromotionShowTxt)) {
                string2 = this.mPromotionShowTxt;
            } else {
                string2 = getString(R.string.edc);
            }
            this.mCutFee.setText(string2);
            this.tv_tenpay_real_fee.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1") && !TextUtils.isEmpty(this.mPromotionFee) && Double.parseDouble(this.mPromotionFee) > 0.0d) {
            this.mCutFee.setVisibility(0);
            this.tv_tenpay_real_fee.setVisibility(0);
            if (!TextUtils.isEmpty(this.mPromotionShowTxt)) {
                format = this.mPromotionShowTxt;
            } else {
                if (!TextUtils.isEmpty(this.mPromotionType) && this.mPromotionType.equals("1")) {
                    string = getString(R.string.ecb);
                } else {
                    string = getString(R.string.eca);
                }
                format = String.format(string, Utils.fen2Yuan(this.mPromotionFee));
            }
            this.mCutFee.setText(format);
            this.tv_tenpay_real_fee.setText(Utils.transformToMoney(this.mOriginalTotal, 0) + getString(R.string.ehr));
            this.tv_tenpay_real_fee.getPaint().setFlags(16);
            this.mTotalFeeText.setText(Utils.transformToMoney(this.mTotalFee, 0));
            return;
        }
        this.mCutFee.setVisibility(8);
        this.tv_tenpay_real_fee.setVisibility(8);
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
