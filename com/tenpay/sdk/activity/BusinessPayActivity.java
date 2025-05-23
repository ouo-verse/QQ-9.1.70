package com.tenpay.sdk.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_task.InitializeParam;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.QWalletUtils;
import com.tenpay.bank.BindBankModule;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.impl.ApiInterfaceImpl;
import com.tenpay.ndk.CertUtil;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.adapter.BusinessPayTypeExpandableAdapter;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.model.MarketModel;
import com.tenpay.sdk.model.PayTypeModel;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.QwLog4Soter;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* loaded from: classes27.dex */
public class BusinessPayActivity extends BasePayActivity implements View.OnClickListener {
    public static final int ANIM_DOWN = 2;
    public static final int ANIM_UP = 1;
    public static int OPEN_WEBANK_RESULT_CODE = 1001;
    public static final int PAY_BY_AUTOPAY = 5;
    public static final int PAY_BY_BALANCE = 0;
    public static final int PAY_BY_BANK = 1;
    public static final int PAY_BY_NEWBANK = 2;
    public static final int PAY_BY_OPEN_CTPAY = 4;
    protected ImageView back_btn;
    private LinearLayout bottom_view;
    private boolean isClickRetry;
    private boolean isHasCheckedPayType;
    private boolean isShowingPassInput;
    private int lastBottomHeight;
    private long mActualMoney;
    private RelativeLayout mAnimLayout;
    private PayTypeModel mBalanceModel;
    protected JSONObject mBindedFastObj;
    private BusinessPayTypeExpandableAdapter mBusinessAdapter;
    private Button mCancelPayButton;
    protected Button mChangePhoneNumBtn;
    protected ImageButton mCloseBtn;
    private ExpandableListView mConfirmContentView;
    private Button mConfirmPayButton;
    protected JSONObject mCtPayAuthObj;
    protected ImageView mCtPayHelpImg;
    private PayTypeModel mDefaultSelectModel;
    protected TextView mFingerErrorTips;
    private LinearLayout mFingerLayout;
    private boolean mHasStaticPromotion;
    protected boolean mIsAccountUpgrade;
    protected Boolean mIsCreditCard;
    protected Boolean mIsReentry;
    private boolean mIsStartedWithFingerPay;
    protected MyKeyboardWindow mKeyboard;
    private List<MarketModel> mMarketModels;
    private TextView mMarketingMoneyView;
    private Button mNormalPayConfirmBtn;
    private String mOldPhoneNum;
    private LinearLayout mPassEditLayout;
    private LinearLayout mPassLayout;
    private String mPassword;
    private LinearLayout mPayConfirmLayout;
    protected HashMap<String, String> mPayGateRequest;
    private TextView mPayRiskInfo;
    private List<PayTypeModel> mPayTypeModels;
    private String mPayTypeTitle;
    private String mPayerUin;
    protected TextView mPriceTxt;
    protected TextView mProductTxt;
    private String mPromotionTips;
    private String mPromotionTitle;
    protected RelativeLayout mRootView;
    protected PayTypeModel mSelectPayTypeModel;
    private Boolean mShowPhoneChangeBtn;
    private int mSixPassLenth;
    protected TextWatcher mTextWatcher;
    private long mTotalMarketingFee;
    private String mValidDate;
    private ImageView mVerifyBackBtn;
    protected EditText mVerifyCodeEdit;
    protected MyKeyboardWindow mVerifyKeyboard;
    protected LinearLayout mVerifyLayout;
    protected TextView mVerifyMobileTxt;
    protected Button mVerifyResendBtn;
    private LinearLayout normal_passwd_layout;
    private ImageView pass_back_btn;
    private TextView pay_error;
    private LinearLayout pay_head_layout;
    private TextView use_password;

    public BusinessPayActivity() {
        Boolean bool = Boolean.FALSE;
        this.mShowPhoneChangeBtn = bool;
        this.mIsCreditCard = Boolean.TRUE;
        this.mPassword = null;
        this.mIsReentry = bool;
        this.mIsAccountUpgrade = false;
        this.mIsStartedWithFingerPay = false;
        this.isHasCheckedPayType = false;
        this.mTotalMarketingFee = 0L;
        this.mPromotionTips = "";
        this.isClickRetry = true;
        this.mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                if (businessPayActivity.mWindowStyle == 0 && !businessPayActivity.isShowingVerifyCodeView) {
                    if (businessPayActivity.getPasswd().length() > 5) {
                        if (!BusinessPayActivity.this.mNormalPayConfirmBtn.isEnabled()) {
                            BusinessPayActivity.this.mNormalPayConfirmBtn.setEnabled(true);
                            BusinessPayActivity.this.mNormalPayConfirmBtn.setClickable(true);
                            return;
                        }
                        return;
                    }
                    if (BusinessPayActivity.this.mNormalPayConfirmBtn.isEnabled()) {
                        BusinessPayActivity.this.mNormalPayConfirmBtn.setClickable(false);
                        BusinessPayActivity.this.mNormalPayConfirmBtn.setEnabled(false);
                        return;
                    }
                    return;
                }
                if (businessPayActivity.isShowingVerifyCodeView && businessPayActivity.mVerifyCodeEdit.getText().toString().length() > 5) {
                    BusinessPayActivity.this.pay_excute();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        };
        this.lastBottomHeight = 0;
    }

    private void VerifyCodeBack() {
        this.isShowingVerifyCodeView = false;
        if (this.mWindowStyle == 0) {
            this.mPassLayout.setVisibility(0);
            this.mPayConfirmLayout.setVisibility(8);
            this.mVerifyLayout.setVisibility(8);
            this.mVerifyLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154880eu));
            this.mPassLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154876eq));
            return;
        }
        this.mPassLayout.setVisibility(8);
        this.mPayConfirmLayout.setVisibility(0);
        this.mVerifyLayout.setVisibility(8);
        this.mAnimLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.24
            @Override // java.lang.Runnable
            public void run() {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(BusinessPayActivity.this.mAnimLayout, "translationY", -BusinessPayActivity.this.mPayConfirmLayout.getHeight());
                ofFloat.setDuration(300L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        });
        this.mPayConfirmLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154876eq));
        if (this.mWindowStyle == 1 && this.mSoterBiometricCanceller != null) {
            this.mSoterBiometricCanceller = null;
            QwLog.i("last canceller is not null. should not happen because we will set it to null every time we finished the process");
        }
    }

    private void back() {
        int i3;
        if (this.isShowingVerifyCodeView) {
            VerifyCodeBack();
            return;
        }
        if (this.isShowingPassInput) {
            passBack();
            return;
        }
        if (this.mWindowStyle == 1) {
            uploadData("fingerprint.confirm.cancel");
            releaseFp();
        }
        uploadData("discount.info.cancel");
        finish();
        if (!this.isInner && !this.isFriendPay) {
            if (this.mIsStartedWithFingerPay || (i3 = this.mComeFrom) == 1 || i3 == 2 || i3 == 9 || i3 == 5) {
                Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(-1);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sdk_auth_data", this.mPayGateObj.optString("sdk_auth_data"));
                } catch (Exception unused) {
                }
                retCodeAndGetBundle.putString("retmsg", jSONObject.toString());
            }
        }
    }

    private void changePayType() {
        if (this.mWindowStyle != 1) {
            passBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go2ChangeValidDateActivity() {
        PayTypeModel payTypeModel = this.mSelectPayTypeModel;
        if (payTypeModel != null && payTypeModel.channel_info != null) {
            Intent intent = new Intent();
            intent.putExtra("update_card_str", String.format(getString(R.string.ef_), this.mSelectPayTypeModel.channel_info.optString("card_tail"), this.mSelectPayTypeModel.channel_info.optString("bank_name")));
            intent.putExtra("showCvv", this.mShowCvv);
            if (this.mWindowStyle == 1) {
                intent.putExtra("processtype", getProcessType());
            } else {
                intent.putExtra("processtype", 15);
            }
            launchFragmentForResult(intent, ChangeValidDateActivity.class, BasePayActivity.ChangeValidDate_RESULT_CODE);
        }
    }

    private void goAutoPay() {
        HashMap hashMap = new HashMap();
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("p", getPasswd());
        hashMap.put("payer_uin", this.mPayerUin);
        hashMap.put("timestamp", this.mTimestamp + "");
        fingerParamFill(hashMap);
        setPromotionInfo(hashMap);
        httpRequest(Cgi.URL_FRIEND_QPAY_SPFA_PAY, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoBindBankActivity() {
        Intent intent = new Intent();
        intent.putExtra("token_id", this.mPayTokenId);
        intent.putExtra("pass_flag", this.mPassFlag);
        intent.putExtra("trustpay_open_flag", this.mTrustPayOpen);
        BusinessPayTypeExpandableAdapter businessPayTypeExpandableAdapter = this.mBusinessAdapter;
        if (businessPayTypeExpandableAdapter != null) {
            JSONArray pointListInfo = businessPayTypeExpandableAdapter.getPointListInfo();
            if (pointListInfo != null) {
                intent.putExtra("point_list", pointListInfo.toString());
            }
            JSONArray promotionListInfo = this.mBusinessAdapter.getPromotionListInfo();
            if (promotionListInfo != null) {
                intent.putExtra("promotion_list", promotionListInfo.toString());
            }
        }
        BindBankModule.INSTANCE.startVerify(this, intent);
        uploadData("pay.choose.other");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoChooseFriendPay(JSONObject jSONObject) {
        uploadData("smallpay.pwd.friendpay");
        int i3 = 1;
        if (jSONObject != null && jSONObject.optInt("allow_multi_flag") == 1) {
            i3 = jSONObject.optInt("allow_multi_counts", 1);
        }
        ApiUtil.chooseFriends(getOutActivity(), getString(R.string.e6r), Utils.transformToMoney(this.mTotalFee, 0), this.mPayGateObj.optString("desc"), this.mTotalFee, this.iPayFrom, i3, new ResultReceiver(this.mHandler) { // from class: com.tenpay.sdk.activity.BusinessPayActivity.11
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                super.onReceiveResult(i16, bundle);
                if (i16 == 1) {
                    Bundle retCodeAndGetBundle = BusinessPayActivity.this.setRetCodeAndGetBundle(ErrorCode.ERR_FRIENDPAY_SUCCESS);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("err_msg", BusinessPayActivity.this.getString(R.string.f171340e71));
                    } catch (Exception unused) {
                    }
                    retCodeAndGetBundle.putString("retmsg", jSONObject2.toString());
                    TenUtils.notifyToExit(BusinessPayActivity.this.getContext(), BusinessPayActivity.this.mProssesID);
                    return;
                }
                if (i16 == 0) {
                    if (bundle != null) {
                        try {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList("choose_friend_uins");
                            String string = bundle.getString("choose_friend_feedback");
                            ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("callback");
                            if (stringArrayList != null) {
                                ApiInterfaceImpl apiInterfaceImpl = new ApiInterfaceImpl();
                                Context context = BusinessPayActivity.this.getContext();
                                BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                                apiInterfaceImpl.sendFriendPayRequest(context, businessPayActivity.mPayTokenId, businessPayActivity.mUin, stringArrayList, string, resultReceiver);
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e(((NetBaseActivity) BusinessPayActivity.this).TAG, 1, "", e16);
                            return;
                        }
                    }
                    return;
                }
                if (i16 == 2 && bundle != null) {
                    try {
                        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("choose_friend_uins");
                        if (stringArrayList2 != null && stringArrayList2.size() != 0) {
                            ResultReceiver resultReceiver2 = (ResultReceiver) bundle.getParcelable("callback");
                            Intent intent = new Intent();
                            intent.putExtra("pay_gate", BusinessPayActivity.this.mPayGateObj.toString());
                            intent.putExtra("process_flag", BusinessPayActivity.this.getProcessType());
                            intent.putExtra("payer_uin", stringArrayList2.get(0));
                            intent.putExtra("choose_friend_callback", resultReceiver2);
                            BusinessPayActivity.this.launchFragment(intent, SuperFriendPayActivity.class);
                        }
                    } catch (Exception e17) {
                        QLog.e(((NetBaseActivity) BusinessPayActivity.this).TAG, 1, "", e17);
                    }
                }
            }
        });
    }

    private void initExpandableListView() {
        BusinessPayTypeExpandableAdapter businessPayTypeExpandableAdapter = new BusinessPayTypeExpandableAdapter(getContext(), this.mUin, this.mMarketModels, this.mPayTypeModels, getProcessType());
        this.mBusinessAdapter = businessPayTypeExpandableAdapter;
        businessPayTypeExpandableAdapter.mPayTypeTitle = this.mPayTypeTitle;
        businessPayTypeExpandableAdapter.mPromotionTitle = this.mPromotionTitle;
        businessPayTypeExpandableAdapter.setLastSelectedPosition(this.mSelectedPayBankIndex);
        this.mBusinessAdapter.setDefaultTotalMarketingFee(this.mTotalMarketingFee);
        int groupCount = this.mBusinessAdapter.getGroupCount();
        this.mConfirmContentView.setAdapter(this.mBusinessAdapter);
        for (int i3 = 0; i3 < groupCount; i3++) {
            this.mConfirmContentView.expandGroup(i3);
        }
        this.mConfirmContentView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.8
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i16, long j3) {
                return true;
            }
        });
        this.mBusinessAdapter.setOnItemClickListener(new BusinessPayTypeExpandableAdapter.OnItemClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.9
            @Override // com.tenpay.sdk.adapter.BusinessPayTypeExpandableAdapter.OnItemClickListener
            public void onPayTypeItemClick(PayTypeModel payTypeModel, long j3) {
                if ("pfa_pay".equals(payTypeModel.pay_channel)) {
                    BusinessPayActivity.this.gotoChooseFriendPay(payTypeModel.channel_info);
                    return;
                }
                if ("new_bind".equals(payTypeModel.pay_channel)) {
                    BusinessPayActivity.this.gotoBindBankActivity();
                    return;
                }
                if ("balance".equals(payTypeModel.pay_channel)) {
                    BusinessPayActivity.this.isHasCheckedPayType = true;
                    BusinessPayActivity.this.mTotalMarketingFee = j3;
                    BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                    businessPayActivity.mSelectPayTypeModel = payTypeModel;
                    businessPayActivity.mSelectedPayType = 0;
                    businessPayActivity.isNOPassPay(payTypeModel);
                    BusinessPayActivity.this.setMarketingData();
                    return;
                }
                if ("fast_pay".equals(payTypeModel.pay_channel)) {
                    BusinessPayActivity.this.isHasCheckedPayType = true;
                    BusinessPayActivity.this.mTotalMarketingFee = j3;
                    BusinessPayActivity businessPayActivity2 = BusinessPayActivity.this;
                    businessPayActivity2.mSelectPayTypeModel = payTypeModel;
                    businessPayActivity2.mSelectedPayType = 1;
                    businessPayActivity2.isNOPassPay(payTypeModel);
                    BusinessPayActivity.this.setMarketingData();
                    BusinessPayActivity.this.setChangeValidDateFlag();
                    return;
                }
                if ("spfa_pay".equals(payTypeModel.pay_channel)) {
                    BusinessPayActivity.this.isHasCheckedPayType = true;
                    BusinessPayActivity businessPayActivity3 = BusinessPayActivity.this;
                    businessPayActivity3.mSelectPayTypeModel = payTypeModel;
                    businessPayActivity3.mTotalMarketingFee = j3;
                    BusinessPayActivity.this.setMarketingData();
                    BusinessPayActivity businessPayActivity4 = BusinessPayActivity.this;
                    businessPayActivity4.mSelectedPayType = 5;
                    businessPayActivity4.mPayerUin = payTypeModel.channel_info.optString("uin");
                }
            }

            @Override // com.tenpay.sdk.adapter.BusinessPayTypeExpandableAdapter.OnItemClickListener
            public void onPromotionItemClick(long j3) {
                BusinessPayActivity.this.mTotalMarketingFee = j3;
                BusinessPayActivity.this.setMarketingData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isNOPassPay(PayTypeModel payTypeModel) {
        if ("balance".equals(payTypeModel.pay_channel) && this.mUserAttr == 3) {
            this.mWindowStyle = 2;
        } else if ("fast_pay".equals(payTypeModel.pay_channel) && this.mPayGateObj.optInt("nopwdnosms_flag", 0) == 1) {
            this.mWindowStyle = 2;
        }
    }

    private void parsePayTypeData() {
        JSONObject jSONObject;
        PayTypeModel payTypeModel;
        String optString;
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = this.mPayGateObj.optJSONObject("pay_channel_list");
        if (optJSONObject2 != null) {
            this.mPayTypeTitle = optJSONObject2.optString("title");
            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("content");
            this.mPayTypeModels = new ArrayList();
            JSONObject optJSONObject3 = this.mPayGateObj.optJSONObject("marketing");
            if (optJSONObject3 != null) {
                jSONObject = optJSONObject3.optJSONObject("promotion_info");
            } else {
                jSONObject = null;
            }
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i3);
                if (optJSONObject4 != null) {
                    PayTypeModel payTypeModel2 = new PayTypeModel(optJSONObject4);
                    if ("pfa_pay".equals(payTypeModel2.pay_channel)) {
                        String optString2 = payTypeModel2.channel_info.optString("buyer_uin");
                        this.buyer_uin = optString2;
                        if (!TextUtils.isEmpty(optString2)) {
                            this.order_type = 1;
                        }
                    }
                    if ("balance".equals(payTypeModel2.pay_channel)) {
                        this.mBalanceModel = payTypeModel2;
                        optString = "0";
                    } else {
                        optString = payTypeModel2.channel_info.optString("bank_type");
                    }
                    if (!TextUtils.isEmpty(optString) && jSONObject != null && (optJSONArray = jSONObject.optJSONArray(optString)) != null && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                        payTypeModel2.isHasPromotion = true;
                        payTypeModel2.promotion_id = optJSONObject.optInt("promotion_id");
                        long optInt = optJSONObject.optInt("promotion_fee");
                        payTypeModel2.promotion_fee = optInt;
                        if (optInt > 0) {
                            this.mHasStaticPromotion = true;
                        }
                    }
                    int i16 = this.mSelectedPayType;
                    if (i16 >= 0 && this.mIsMidas && payTypeModel2.disable == 0) {
                        if (i16 == 0 && "balance".equals(payTypeModel2.pay_channel)) {
                            payTypeModel2.isCheck = true;
                            this.mSelectPayTypeModel = payTypeModel2;
                            this.isHasCheckedPayType = true;
                            this.mSelectedPayBankIndex = i3;
                        } else if (this.mSelectedPayType == 1 && "fast_pay".equals(payTypeModel2.pay_channel)) {
                            String optString3 = payTypeModel2.channel_info.optString("bind_serial");
                            if (!TextUtils.isEmpty(optString3) && optString3.equals(this.mSelectBankSerial)) {
                                this.isHasCheckedPayType = true;
                                this.mSelectPayTypeModel = payTypeModel2;
                                payTypeModel2.isCheck = true;
                                this.mSelectedPayBankIndex = i3;
                            }
                        }
                    }
                    int optInt2 = optJSONObject2.optInt("default_choose_index");
                    QwLog.i("default_choose_index : " + optInt2 + " i : " + i3);
                    if (optInt2 == i3) {
                        this.mSelectedPayBankIndex = i3;
                        this.mDefaultSelectModel = payTypeModel2;
                    }
                    setDefaultPayTypeChecked(payTypeModel2);
                    this.mPayTypeModels.add(payTypeModel2);
                }
            }
            if (!this.isHasCheckedPayType && (payTypeModel = this.mDefaultSelectModel) != null && !"new_bind".equals(payTypeModel.pay_channel) && !"pfa_pay".equals(this.mDefaultSelectModel.pay_channel)) {
                PayTypeModel payTypeModel3 = this.mDefaultSelectModel;
                payTypeModel3.isCheck = true;
                this.mSelectPayTypeModel = payTypeModel3;
                this.isHasCheckedPayType = true;
                setDefaultPayTypeChecked(payTypeModel3);
                isNOPassPay(this.mSelectPayTypeModel);
            }
        }
    }

    private void parsePromotionData() {
        JSONArray optJSONArray;
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("marketing");
        this.mMarketModels = new ArrayList();
        if (optJSONObject != null) {
            this.mPromotionTitle = optJSONObject.optString("title");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("point_info");
            if (optJSONObject2 != null) {
                MarketModel marketModel = new MarketModel(optJSONObject2, true);
                marketModel.isPointModel = true;
                int i3 = marketModel.disable;
                if (i3 == 0 && marketModel.isCheck) {
                    long j3 = marketModel.fee;
                    if (j3 > 0) {
                        this.mTotalMarketingFee += j3;
                    }
                }
                if (i3 == 0 && marketModel.fee > 0) {
                    this.mHasStaticPromotion = true;
                }
                this.mMarketModels.add(marketModel);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("promotion_info");
            if (optJSONObject3 != null && (optJSONArray = optJSONObject3.optJSONArray("comm")) != null) {
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.opt(i16);
                    if (jSONObject != null) {
                        MarketModel marketModel2 = new MarketModel(jSONObject, false);
                        boolean z16 = marketModel2.isCheck;
                        if (z16) {
                            long j16 = marketModel2.fee;
                            if (j16 > 0) {
                                this.mTotalMarketingFee += j16;
                            }
                        }
                        if (marketModel2.fee > 0) {
                            this.mHasStaticPromotion = true;
                        }
                        if (marketModel2.hide == 0) {
                            this.mMarketModels.add(marketModel2);
                        } else if (z16) {
                            this.mPromotionTips += marketModel2.show_msg + Marker.ANY_NON_NULL_MARKER;
                        }
                    }
                }
            }
        }
    }

    private void passBack() {
        if (!this.mIsSixPasswdUser) {
            TenUtils.closeSoftKeyBoard(getActivity());
        }
        this.isShowingPassInput = false;
        this.mPassLayout.setVisibility(8);
        this.mPayConfirmLayout.setVisibility(0);
        this.mVerifyLayout.setVisibility(8);
        this.mAnimLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.23
            @Override // java.lang.Runnable
            public void run() {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(BusinessPayActivity.this.mAnimLayout, "translationY", -BusinessPayActivity.this.mPayConfirmLayout.getHeight());
                ofFloat.setDuration(300L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        });
        this.mPayConfirmLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154876eq));
    }

    private void playAnimForPasswordView(int i3) {
        int i16;
        if (i3 == 2) {
            i16 = this.mPassLayout.getHeight();
        } else if (i3 == 1) {
            i16 = -this.mPassLayout.getHeight();
        } else {
            i16 = 0;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", i16);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    private void reloadBindBanks() {
        Intent intent = getIntent();
        TenpayUtil.markBeginTime();
        this.mPayGateRequest = null;
        HashMap<String, String> hashMap = new HashMap<>();
        this.mPayGateRequest = hashMap;
        hashMap.put("uin", this.mUin);
        this.mPayGateRequest.put("token_id", this.mPayTokenId);
        this.mPayGateRequest.put("come_from", this.mComeFrom + "");
        this.mPayGateRequest.put(com.tencent.mobileqq.msf.core.c0.j.T0, intent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0));
        httpRequest(Cgi.URI_PAY_GATE, this.mPayGateRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPayView() {
        int screenHeight = Utils.getScreenHeight(getContext()) - ImmersiveUtils.getStatusBarHeight(getContext());
        int groupCount = this.mBusinessAdapter.getGroupCount();
        int i3 = 0;
        for (int i16 = 0; i16 < groupCount; i16++) {
            i3 += this.mBusinessAdapter.getChildrenCount(i16);
        }
        int height = this.pay_head_layout.getHeight();
        int height2 = this.bottom_view.getHeight();
        if (height2 == 0) {
            height2 = this.lastBottomHeight;
        }
        this.lastBottomHeight = height2;
        int dp2Px = ((screenHeight - height) - height2) - Utils.dp2Px(getContext(), 20.0f);
        int dp2Px2 = Utils.dp2Px(getContext(), (groupCount * 30) + (i3 * 55));
        QwLog.i(" screenHeight:" + screenHeight + " headHeight:" + height + " bottomHeight:" + height2 + " maxHeight : " + dp2Px + " height : " + dp2Px2);
        if (dp2Px2 <= dp2Px) {
            dp2Px = dp2Px2;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mConfirmContentView.getLayoutParams();
        layoutParams.height = dp2Px;
        this.mConfirmContentView.setLayoutParams(layoutParams);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(height2 + height + dp2Px));
        ofFloat.setDuration(this.mPassAnimDuration);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    private void resetRootLayout() {
        int screenHeight = Utils.getScreenHeight(getContext());
        if (QFuncProxy.isSupporImmersive() != 1) {
            screenHeight -= ImmersiveUtils.getStatusBarHeight(getContext());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        layoutParams.height = screenHeight * 2;
        this.mRootView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mAnimLayout.getLayoutParams();
        layoutParams2.height = screenHeight;
        this.mAnimLayout.setLayoutParams(layoutParams2);
    }

    private void riskTipUIUpdate(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("pay_risk_info");
        if (optJSONObject == null) {
            return;
        }
        try {
            String format = String.format(String.format(optJSONObject.optString("risk_info"), "<strong>%s</strong>"), optJSONObject.optString("risk_sp_name"));
            QwLog.i("finalTip = " + format);
            this.mPayRiskInfo.setText(Html.fromHtml(format));
            this.mPayRiskInfo.setVisibility(0);
            this.mCancelPayButton.setVisibility(0);
            QwLog.i("risk ui set...");
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void sendCtPayAuthen() {
        HashMap hashMap = new HashMap();
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("qq_guid", com.tencent.mobileqq.base.b.d());
        hashMap.put("qq_appid", com.tencent.mobileqq.base.b.b());
        hashMap.put("qq_appname", "com.tencent.mobileqq");
        if (this.mIsReentry.booleanValue()) {
            this.mIsReentry = Boolean.FALSE;
            hashMap.put("is_reentry", "1");
        } else {
            hashMap.put("is_reentry", "0");
        }
        hashMap.put("trustpay_open_flag", this.mTrustPayOpen);
        setPromotionInfo(hashMap);
        hashMap.put("check_type", "0");
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("pay_passwd", getPasswd());
        httpRequest(Cgi.URI_CTPAY_AUTHEN, hashMap);
    }

    private void sendCtPayVerify() {
        HashMap hashMap = new HashMap();
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("bank_type", Cgi.CTPAY_BANK_TYPE);
        hashMap.put("verify_code", this.mVerifyCodeEdit.getText().toString());
        hashMap.put("pay_passwd", getPasswd());
        hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mCtPayAuthObj.optString(DeviceType.DeviceCategory.MOBILE));
        hashMap.put("business_type", this.mCtPayAuthObj.optString("business_type"));
        hashMap.put("trustpay_open_flag", this.mTrustPayOpen);
        setPromotionInfo(hashMap);
        httpRequest(Cgi.URI_CTPAY_VERIFY, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeValidDateFlag() {
        JSONObject jSONObject;
        PayTypeModel payTypeModel = this.mSelectPayTypeModel;
        if (payTypeModel != null && (jSONObject = payTypeModel.channel_info) != null) {
            this.mShowCvv = jSONObject.optString("needcvv");
            this.mIsCreditCard = Boolean.valueOf(this.mSelectPayTypeModel.channel_info.optString("cardtype").equals("CREDIT"));
        }
    }

    private void setDefaultPayTypeChecked(PayTypeModel payTypeModel) {
        if (payTypeModel.isCheck) {
            this.mSelectPayTypeModel = payTypeModel;
            this.isHasCheckedPayType = true;
            if (payTypeModel.isHasPromotion) {
                long j3 = payTypeModel.promotion_fee;
                if (j3 > 0) {
                    this.mTotalMarketingFee += j3;
                }
            }
            if ("balance".equals(payTypeModel.pay_channel)) {
                this.mSelectedPayType = 0;
                return;
            }
            if ("fast_pay".equals(payTypeModel.pay_channel)) {
                this.mSelectedPayType = 1;
                setChangeValidDateFlag();
            } else if ("spfa_pay".equals(payTypeModel.pay_channel)) {
                this.mSelectedPayType = 5;
                this.mPayerUin = payTypeModel.channel_info.optString("uin");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMarketingData() {
        String str;
        int i3;
        BusinessPayTypeExpandableAdapter businessPayTypeExpandableAdapter = this.mBusinessAdapter;
        if (businessPayTypeExpandableAdapter != null) {
            businessPayTypeExpandableAdapter.setDefaultTotalMarketingFee(this.mTotalMarketingFee);
        }
        long optLong = this.mPayGateObj.optLong("total_fee");
        this.mActualMoney = optLong - this.mTotalMarketingFee;
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(this.mPromotionTips)) {
            try {
                if (this.mPromotionTips.endsWith(Marker.ANY_NON_NULL_MARKER)) {
                    String str2 = this.mPromotionTips;
                    this.mPromotionTips = str2.substring(0, str2.length() - 1);
                }
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        if (this.mActualMoney > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u5df2\u4f18\u60e0");
            sb5.append(Utils.fen2Yuan(this.mTotalMarketingFee + ""));
            sb5.append("\u5143");
            stringBuffer.append(sb5.toString());
            if (!TextUtils.isEmpty(this.mPromotionTips)) {
                stringBuffer.append("(\u542b");
                stringBuffer.append(this.mPromotionTips);
                stringBuffer.append(")");
            }
            if (this.mWindowStyle == 1) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(", \u9700\u652f\u4ed8");
                sb6.append(Utils.fen2Yuan(this.mActualMoney + ""));
                sb6.append("\u5143");
                stringBuffer.append(sb6.toString());
            }
            this.mMarketingMoneyView.setClickable(false);
            this.mMarketingMoneyView.setCompoundDrawables(null, null, null, null);
        } else {
            this.mActualMoney = 1L;
            this.mMarketingMoneyView.setClickable(true);
            Drawable drawable = getResources().getDrawable(R.drawable.dyj);
            drawable.setBounds(0, 0, Utils.dp2Px(getContext(), 14.0f), Utils.dp2Px(getContext(), 14.0f));
            this.mMarketingMoneyView.setCompoundDrawables(null, null, drawable, null);
            this.mMarketingMoneyView.setCompoundDrawablePadding(Utils.dp2Px(getContext(), 5.0f));
            this.mMarketingMoneyView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    QUIProxy.createCustomDialog(BusinessPayActivity.this.getContext(), 230, null, BusinessPayActivity.this.getString(R.string.f171322e33), null, BusinessPayActivity.this.getString(R.string.ead), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.10.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i16) {
                        }
                    }, null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            StringBuilder sb7 = new StringBuilder();
            sb7.append("\u5df2\u4f18\u60e0");
            sb7.append(Utils.fen2Yuan((optLong - 1) + ""));
            sb7.append("\u5143");
            stringBuffer.append(sb7.toString());
            if (!TextUtils.isEmpty(this.mPromotionTips)) {
                stringBuffer.append("(");
                stringBuffer.append(this.mPromotionTips);
                stringBuffer.append(")");
            }
            if (this.mWindowStyle == 1) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(", \u9700\u652f\u4ed8");
                sb8.append(Utils.fen2Yuan(this.mActualMoney + ""));
                sb8.append("\u5143");
                stringBuffer.append(sb8.toString());
            }
        }
        this.mMarketingMoneyView.setText(stringBuffer.toString());
        if (this.mWindowStyle == 2) {
            str = "\u514d\u5bc6\u652f\u4ed8";
        } else {
            str = "\u652f\u4ed8";
        }
        Button button = this.mConfirmPayButton;
        StringBuilder sb9 = new StringBuilder();
        sb9.append(str);
        sb9.append(Utils.fen2Yuan(this.mActualMoney + ""));
        sb9.append("\u5143");
        button.setText(sb9.toString());
        PayTypeModel payTypeModel = this.mBalanceModel;
        if (payTypeModel != null && ((i3 = payTypeModel.disable) == 0 || i3 == 1024)) {
            long j3 = this.mActualMoney;
            if (payTypeModel.isHasPromotion) {
                long j16 = payTypeModel.promotion_fee;
                if (j16 > 0) {
                    j3 -= j16;
                }
            }
            PayTypeModel payTypeModel2 = this.mSelectPayTypeModel;
            if (payTypeModel2 != null && payTypeModel2.isHasPromotion && payTypeModel.promotion_fee > 0) {
                j3 += payTypeModel2.promotion_fee;
            }
            if (j3 <= this.mBalance) {
                payTypeModel.disable = 0;
                if (payTypeModel.isCheck) {
                    this.isHasCheckedPayType = true;
                }
            } else {
                payTypeModel.disable = 1024;
                payTypeModel.disable_comment = getString(R.string.efv);
                if (this.mBalanceModel.isCheck) {
                    this.isHasCheckedPayType = false;
                }
            }
            BusinessPayTypeExpandableAdapter businessPayTypeExpandableAdapter2 = this.mBusinessAdapter;
            if (businessPayTypeExpandableAdapter2 != null) {
                businessPayTypeExpandableAdapter2.notifyDataSetChanged();
            }
        }
        if (this.isHasCheckedPayType) {
            this.mConfirmPayButton.setEnabled(true);
        } else {
            this.mConfirmPayButton.setEnabled(false);
        }
    }

    private void setPromotionInfo(Map<String, String> map) {
        JSONArray jSONArray;
        if (map != null) {
            BusinessPayTypeExpandableAdapter businessPayTypeExpandableAdapter = this.mBusinessAdapter;
            if (businessPayTypeExpandableAdapter != null) {
                JSONArray pointListInfo = businessPayTypeExpandableAdapter.getPointListInfo();
                if (pointListInfo != null) {
                    map.put("point_list", pointListInfo.toString());
                }
                jSONArray = this.mBusinessAdapter.getPromotionListInfo();
            } else {
                jSONArray = null;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            PayTypeModel payTypeModel = this.mSelectPayTypeModel;
            if (payTypeModel != null && payTypeModel.isHasPromotion) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.mSelectPayTypeModel.promotion_id + "");
                    jSONObject.put("fee", this.mSelectPayTypeModel.promotion_fee + "");
                } catch (JSONException e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                }
                jSONArray.mo162put(jSONObject);
            }
            if (jSONArray.length() > 0) {
                map.put("promotion_list", jSONArray.toString());
            }
        }
    }

    private void showNoCheckedTips() {
        QwLog.i("\u5f53\u524d\u6ca1\u6709\u53ef\u7528\u7684\u652f\u4ed8\u65b9\u5f0f");
        QUIProxy.createCustomDialog(getContext(), 230, null, "\u8bf7\u9009\u62e9\u652f\u4ed8\u65b9\u5f0f", null, getString(R.string.ead), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                int i16 = BusinessPayActivity.this.mWindowStyle;
            }
        }, null);
    }

    private void showPassPayView() {
        this.isShowingPassInput = true;
        this.mWindowStyle = 0;
        boolean equals = "2".equals(this.mPassFlag);
        this.mIsSixPasswdUser = equals;
        if (equals) {
            List<Bitmap> list = this.passIconBp;
            if (list != null && this.isPaySkinCanUse && list.size() == 6) {
                try {
                    this.mSixPasswdEdit.setVipStyle(this.passIconBp, Utils.reSizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dyf), Utils.dp2Px(getContext(), 34.0f), Utils.dp2Px(getContext(), 3.0f)));
                    this.mPassEditLayout.setBackgroundDrawable(null);
                } catch (Throwable th5) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", th5);
                }
            }
            this.normal_passwd_layout.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(0);
            this.mKeyboard.setVisibility(0);
            this.mSixPasswdEdit.setFocusable(true);
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mSixPasswdEdit.setVisibility(8);
            this.normal_passwd_layout.setVisibility(0);
            this.mKeyboard.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(8);
            this.normal_passwd_layout.setVisibility(0);
            if (this.mNormalPasswdEdit.getText().toString().length() > 5) {
                this.mNormalPayConfirmBtn.setEnabled(true);
                this.mNormalPayConfirmBtn.setClickable(true);
            } else {
                this.mNormalPayConfirmBtn.setEnabled(false);
                this.mNormalPayConfirmBtn.setClickable(false);
            }
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        this.mPassLayout.setVisibility(0);
        this.mPayConfirmLayout.setVisibility(8);
        this.mVerifyLayout.setVisibility(8);
        this.mPassLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.12
            @Override // java.lang.Runnable
            public void run() {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(BusinessPayActivity.this.mAnimLayout, "translationY", -BusinessPayActivity.this.mPassLayout.getHeight());
                ofFloat.setDuration(300L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
            }
        });
        this.mPassLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154877er));
        uploadData("smallpay.pwd.show");
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void changePayTypeInFakeUrl() {
        if (this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.requestFocus();
        }
        changePayType();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected boolean getFingerPayStatus() {
        JSONObject jSONObject = this.mPayGateObj;
        if (jSONObject == null) {
            return false;
        }
        this.soter_open_flag = jSONObject.optInt("soter_open_flag");
        this.soter_open_text = this.mPayGateObj.optString("soter_open_text");
        this.mTouchidRetryMaxCount = this.mPayGateObj.optInt("soter_retry_count");
        this.mTouchidStateInfo = this.mPayGateObj.optString("soter_state_info");
        long optLong = this.mPayGateObj.optLong("soter_open_push_period");
        int i3 = this.soter_open_flag;
        if (i3 == 1) {
            com.tencent.mobileqq.qwallet.utils.g.o("soter_noticed_time_" + this.mUin, (System.currentTimeMillis() / 1000) + optLong);
            com.tencent.mobileqq.qwallet.utils.g.l("soter_is_noticed_" + this.mUin, false);
            com.tencent.mobileqq.qwallet.utils.g.q("soter_open_text_" + this.mUin, this.soter_open_text);
        } else if (2 == i3) {
            new ApiFingerImpl().closeFingerPay(getContext(), this.mUin);
            return false;
        }
        if (this.isSoterOpened) {
            int optInt = this.mPayGateObj.optInt("soter_state");
            this.mTouchidState = optInt;
            if (optInt == 3) {
                SoterWrapperApi.init(getContext().getApplicationContext(), new SoterProcessCallback<SoterProcessNoExtResult>() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.25
                    @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
                    public void onResult(SoterProcessNoExtResult soterProcessNoExtResult) {
                        QwLog.i("\u521d\u59cb\u5316: " + soterProcessNoExtResult.toString());
                        if ((soterProcessNoExtResult.isSuccess() || soterProcessNoExtResult.errCode == 1028) && SoterWrapperApi.isSupportSoter()) {
                            BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                            businessPayActivity.mWindowStyle = 1;
                            businessPayActivity.mIsStartedWithFingerPay = true;
                            BusinessPayActivity.this.setViewData();
                            return;
                        }
                        BusinessPayActivity businessPayActivity2 = BusinessPayActivity.this;
                        businessPayActivity2.mWindowStyle = 0;
                        businessPayActivity2.setViewData();
                    }
                }, new InitializeParam.InitializeParamBuilder().setGetSupportNetWrapper(new GetSupportSoterNet(getContext(), this.mUin, this.mPayGateObj)).setScenes(Cgi.scene_FingerPay).setDistinguishSalt(this.mUin).setSoterLogger(QwLog4Soter.getInstance()).build());
                return true;
            }
            if (optInt != 1 && optInt != 0 && optInt != 7) {
                if (getFingerPayExceedAmountNoticed() && this.mTouchidState == 4) {
                    return false;
                }
                QUIProxy.createCustomDialog(getContext(), 230, null, this.mTouchidStateInfo, getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.26
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                        if (businessPayActivity.mTouchidState == 4) {
                            businessPayActivity.setFingerPayExceedAmountNoticed(true);
                        }
                        BusinessPayActivity businessPayActivity2 = BusinessPayActivity.this;
                        businessPayActivity2.mWindowStyle = 0;
                        businessPayActivity2.setViewData();
                    }
                });
                return true;
            }
        }
        return false;
    }

    protected int getLoadingHeight() {
        int height;
        int dp2Px;
        if (this.isShowingVerifyCodeView) {
            height = this.mVerifyLayout.getHeight();
            dp2Px = Utils.dp2Px(getContext(), 45.0f);
        } else if (this.isShowingPassInput && this.mIsSixPasswdUser) {
            height = this.mPassLayout.getHeight();
            dp2Px = Utils.dp2Px(getContext(), 45.0f);
        } else {
            return 0;
        }
        return height - dp2Px;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected String getPasswd() {
        String obj;
        if (this.mIsSixPasswdUser) {
            obj = this.mSixPasswdEdit.getInputText();
        } else {
            obj = this.mNormalPasswdEdit.getText().toString();
        }
        this.mPassword = obj;
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        if (this.mIsFromConFirmTrans) {
            return 71;
        }
        if (this.mWindowStyle == 1) {
            return 72;
        }
        return 70;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void go2PWDAuth() {
        QwLog.i("go2 PWDAuth...");
        this.mWindowStyle = 0;
        releaseFp();
        this.mFingerLayout.setVisibility(8);
        this.mConfirmPayButton.setVisibility(0);
        setMarketingData();
        showPassPayView();
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void goneViewForPaySuccess() {
        this.mPayConfirmLayout.setVisibility(8);
        this.mPassLayout.setVisibility(8);
        this.mVerifyLayout.setVisibility(8);
    }

    protected void initView(View view) {
        this.mRootView = (RelativeLayout) view.findViewById(R.id.root_layout);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.az7);
        this.mCloseBtn = imageButton;
        imageButton.setOnClickListener(this);
        this.mAnimLayout = (RelativeLayout) view.findViewById(R.id.f164327rz);
        this.mPassLayout = (LinearLayout) view.findViewById(R.id.fin);
        this.mPayConfirmLayout = (LinearLayout) view.findViewById(R.id.fj_);
        this.mVerifyLayout = (LinearLayout) view.findViewById(R.id.knd);
        view.findViewById(R.id.fjh).setVisibility(8);
        this.mProductTxt = (TextView) view.findViewById(R.id.title_txt);
        this.mPriceTxt = (TextView) view.findViewById(R.id.f166540fz1);
        Button button = (Button) view.findViewById(R.id.b7t);
        this.mConfirmPayButton = button;
        button.setOnClickListener(this);
        this.mCancelPayButton = (Button) view.findViewById(R.id.aox);
        this.mPayRiskInfo = (TextView) view.findViewById(R.id.fjk);
        this.mConfirmContentView = (ExpandableListView) view.findViewById(R.id.b7q);
        this.mMarketingMoneyView = (TextView) view.findViewById(R.id.juy);
        this.mFingerLayout = (LinearLayout) view.findViewById(R.id.car);
        TextView textView = (TextView) view.findViewById(R.id.caq);
        this.mFingerErrorTips = textView;
        textView.setOnClickListener(this);
        this.mFingerErrorTips.setText(QWSoterConstans.getNameByBusiType(SharedHelper.getCurSoterBusiType(this.mUin)) + "\u652f\u4ed8");
        TextView textView2 = (TextView) view.findViewById(R.id.kkq);
        this.use_password = textView2;
        textView2.setOnClickListener(this);
        this.bottom_view = (LinearLayout) view.findViewById(R.id.adk);
        this.pay_head_layout = (LinearLayout) view.findViewById(R.id.fjg);
        this.mPassEditLayout = (LinearLayout) view.findViewById(R.id.fiq);
        this.normal_passwd_layout = (LinearLayout) view.findViewById(R.id.faj);
        Button button2 = (Button) view.findViewById(R.id.fah);
        this.mNormalPayConfirmBtn = button2;
        button2.setOnClickListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.fim);
        this.pass_back_btn = imageView;
        imageView.setOnClickListener(this);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        TextView textView3 = (TextView) view.findViewById(R.id.fjf);
        this.pay_error = textView3;
        textView3.setOnClickListener(this);
        view.findViewById(R.id.aox).setOnClickListener(this);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.2
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public void onTextChange() {
                int length = BusinessPayActivity.this.mSixPasswdEdit.getInputText().length();
                HashMap<String, Integer> hashMap = BusinessPayActivity.this.mMusicIds;
                if (hashMap != null && hashMap.size() == 6 && length >= 1 && length <= 6 && BusinessPayActivity.this.mSixPassLenth < length) {
                    BusinessPayActivity.this.playMusic("30" + length);
                }
                if (length > 5 && BusinessPayActivity.this.mWindowStyle == 0) {
                    TenpayUtil.markBeginTime();
                    BusinessPayActivity.this.pay();
                }
                BusinessPayActivity.this.mSixPassLenth = length;
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                if (z16) {
                    BusinessPayActivity.this.mKeyboard.setVisibility(0);
                    BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                    businessPayActivity.mKeyboard.setInputEditText(businessPayActivity.mSixPasswdEdit);
                }
            }
        });
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView4, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    if (BusinessPayActivity.this.getPasswd().length() > 5) {
                        BusinessPayActivity.this.pay();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView4, i3, keyEvent);
                return z16;
            }
        });
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.kn9);
        this.mVerifyBackBtn = imageView2;
        imageView2.setOnClickListener(this);
        this.mVerifyKeyboard = (MyKeyboardWindow) view.findViewById(R.id.kn7);
        this.mVerifyMobileTxt = (TextView) view.findViewById(R.id.fmv);
        EditText editText2 = (EditText) view.findViewById(R.id.knc);
        this.mVerifyCodeEdit = editText2;
        editText2.addTextChangedListener(this.mTextWatcher);
        this.mVerifyCodeEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView4, int i3, KeyEvent keyEvent) {
                boolean z16 = false;
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    if (BusinessPayActivity.this.mVerifyCodeEdit.getText().toString().length() > 5) {
                        BusinessPayActivity.this.pay_excute();
                    } else {
                        QQToast.makeText(BusinessPayActivity.this.getContext(), R.string.efz, 0).show();
                    }
                    z16 = true;
                }
                EventCollector.getInstance().onEditorAction(textView4, i3, keyEvent);
                return z16;
            }
        });
        this.mVerifyCodeEdit.setOnClickListener(this);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.bcd);
        this.mCtPayHelpImg = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                QUIProxy.createCustomDialog(BusinessPayActivity.this.getContext(), 230, null, BusinessPayActivity.this.getString(R.string.e4y), BusinessPayActivity.this.getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.6.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                    }
                });
                BusinessPayActivity.this.uploadData("smallpay.sms.why");
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
        Button button3 = (Button) view.findViewById(R.id.i8e);
        this.mVerifyResendBtn = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) view.findViewById(R.id.change_phone_num_btn);
        this.mChangePhoneNumBtn = button4;
        button4.setOnClickListener(this);
        this.mChangePhoneNumBtn.setEnabled(true);
        this.mChangePhoneNumBtn.setClickable(true);
        this.mChangePhoneNumBtn.setVisibility(8);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        super.onActivityResult(i3, i16, intent);
        QwLog.i("z\u6267\u884c\u4e86onActivityResult---resultCode:" + i16 + "--requestCode:" + i3);
        if (i16 == -1) {
            if (i3 == BasePayActivity.ChangePhoneNum_RESULT_CODE) {
                if (intent == null) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                this.mChangePhoneNum = bool;
                this.mNewPhoneNum = intent.getStringExtra("PhoneNum");
                this.mPhoneNumCVV = intent.getStringExtra("CVV");
                this.mIsReentry = bool;
                if (this.mNewPhoneNum.length() == 11) {
                    str = (this.mNewPhoneNum.substring(0, 3) + "*****") + this.mNewPhoneNum.substring(9, 11);
                } else {
                    str = "";
                }
                this.mVerifyMobileTxt.setText(getString(R.string.edo) + str);
                if (!TextUtils.isEmpty(this.mNewPhoneNum)) {
                    pay();
                    return;
                }
                return;
            }
            if (i3 == BasePayActivity.ChangeValidDate_RESULT_CODE) {
                if (intent == null) {
                    return;
                }
                Boolean bool2 = Boolean.TRUE;
                this.mChangeValidDate = bool2;
                this.mIsReentry = bool2;
                this.mValidDate = intent.getStringExtra("ValidDate");
                this.mValidDateCVV = intent.getStringExtra("CVV");
                if (!TextUtils.isEmpty(this.mValidDate)) {
                    pay();
                    return;
                }
                return;
            }
            if (i3 == BasePayActivity.ShiMing_RESULT_CODE) {
                HashMap<String, String> hashMap = this.mPayGateRequest;
                if (hashMap == null) {
                    finish();
                    return;
                } else {
                    httpRequest(Cgi.URI_PAY_GATE, hashMap);
                    return;
                }
            }
            if (i3 == BasePayActivity.ResetPass_RESULT_CODE) {
                this.mPassFlag = "2";
                showPassPayView();
                uploadData("pwd.reset.success");
                return;
            }
            return;
        }
        if (i16 == 0) {
            if (i3 == BasePayActivity.ChangePhoneNum_RESULT_CODE) {
                this.mChangePhoneNum = Boolean.FALSE;
                return;
            }
            if (i3 == BasePayActivity.ChangeValidDate_RESULT_CODE) {
                this.mChangeValidDate = Boolean.FALSE;
                return;
            }
            if (i3 == BasePayActivity.ShiMing_RESULT_CODE) {
                finish();
                return;
            } else {
                if (i3 == BasePayActivity.ResetPass_RESULT_CODE || i3 == BasePayActivity.ResetPassBridge_RESULT_CODE) {
                    resetPassUI();
                    return;
                }
                return;
            }
        }
        if (i16 == OPEN_WEBANK_RESULT_CODE) {
            this.isOpenWebank = true;
            reloadBindBanks();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        JSONObject jSONObject2;
        super.onBlError(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        String optString2 = jSONObject.optString("retmsg");
        QwLog.e("requestUrl:" + str + ",\u652f\u4ed8\u8bf7\u6c42\u7684\u56de\u8c03\uff0c\u9519\u8bef\u7801\uff1a" + optString);
        if (str.equals(Cgi.URI_PAY_GATE)) {
            return;
        }
        if ((str.equals(Cgi.URI_BALANCE_GET_CODE) || str.equals(Cgi.URI_FAST_PREPAY) || str.equals(Cgi.URL_FRIEND_QPAY_SPFA_PAY)) && ErrorCode.ERR_WRONG_PASSWORD.equals(optString)) {
            resetPassUI();
            playAnimForPasswordView(2);
            return;
        }
        if (str.equals(Cgi.URI_QWALLET_QPAY_REWARD_CALLBACK)) {
            Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(Integer.parseInt(optString));
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("err_msg", optString2);
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "onBlError: ", e16);
            }
            retCodeAndGetBundle.putString("retmsg", jSONObject3.toString());
            finish();
            TenUtils.notifyToExit(getContext(), this.mProssesID);
            return;
        }
        if (str.equals(Cgi.URI_TRANSFER_PAY_CONFIRM) && (jSONObject2 = this.mPaySuccessObj) != null) {
            gotoPaySuccess(jSONObject2, str);
        }
        if (ErrorCode.ERR_PAY_IVR.equals(optString)) {
            uploadData("pay.hold-up.show");
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e2i), getString(R.string.e2l), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uin", BusinessPayActivity.this.mUin);
                    hashMap.put("token_id", BusinessPayActivity.this.mPayTokenId);
                    BusinessPayActivity.this.httpRequest(Cgi.URI_CODE_IVR_CONFIRM, hashMap);
                    com.tencent.mobileqq.qwallet.c.c("pay.hold-up.go", Integer.valueOf(BusinessPayActivity.this.getProcessType()));
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.16
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    com.tencent.mobileqq.qwallet.c.c("pay.hold-up.cancel", Integer.valueOf(BusinessPayActivity.this.getProcessType()));
                }
            });
            return;
        }
        if (ErrorCode.ERR_SHIMING.equals(optString)) {
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e2i), getString(R.string.f171344e80), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.17
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    com.tencent.mobileqq.qwallet.c.c("condition.error.go", Integer.valueOf(BusinessPayActivity.this.getProcessType()));
                    Intent intent = new Intent();
                    intent.putExtra("IsShiMing", true);
                    BindBankModule.INSTANCE.startVerifyForResult(BusinessPayActivity.this, intent, BasePayActivity.ShiMing_RESULT_CODE);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.18
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    BusinessPayActivity businessPayActivity = BusinessPayActivity.this;
                    if (!businessPayActivity.mIsMidas) {
                        com.tencent.mobileqq.qwallet.c.c("condition.error.close", Integer.valueOf(businessPayActivity.getProcessType()));
                    }
                    dialogInterface.dismiss();
                }
            });
            uploadData("condition.error.show");
            return;
        }
        if (ErrorCode.ERR_YDT_CREDITCARD_EXPIRE.equals(optString)) {
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, "\u53d6\u6d88", "\u66f4\u65b0\u6709\u6548\u671f", new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.19
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    BusinessPayActivity.this.go2ChangeValidDateActivity();
                    com.tencent.mobileqq.qwallet.c.c("creditdatechange.error.change", 15);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.20
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    com.tencent.mobileqq.qwallet.c.c("creditdatechange.error.cancel", 15);
                }
            });
            com.tencent.mobileqq.qwallet.c.c("creditdatechange.error.show", 15);
            return;
        }
        if (this.mChangePhoneNum.booleanValue() && (str2 = this.mOldPhoneNum) != null && !str2.equals(this.mNewPhoneNum)) {
            if (this.mOldPhoneNum.length() != 11) {
                str3 = "";
            } else {
                str3 = (this.mOldPhoneNum.substring(0, 3) + "*****") + this.mOldPhoneNum.substring(9, 11);
            }
            this.mVerifyMobileTxt.setText(getString(R.string.edo) + str3);
        }
        if (!this.isShowingVerifyCodeView) {
            if (this.mWindowStyle == 0) {
                if (this.mIsSixPasswdUser) {
                    this.mSixPasswdEdit.setInputText("");
                    this.mSixPasswdEdit.requestFocus();
                    return;
                } else {
                    this.mNormalPasswdEdit.setText("");
                    this.mNormalPasswdEdit.requestFocus();
                    return;
                }
            }
            return;
        }
        this.mVerifyCodeEdit.setText("");
        this.mVerifyCodeEdit.requestFocus();
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        if (i3 == 0 && (fakeInfo.reqUrl.equals(Cgi.URI_BALANCE_GET_CODE) || fakeInfo.reqUrl.equals(Cgi.URI_FAST_PREPAY) || fakeInfo.reqUrl.equals(Cgi.URL_FRIEND_QPAY_SPFA_PAY))) {
            try {
                if (ErrorCode.ERR_WRONG_PASSWORD.equals(fakeInfo.data.getString("retcode"))) {
                    String c16 = com.tencent.mobileqq.base.a.c();
                    if (FakeUrlUtils.isUseNewFakeUrl()) {
                        new QWalletFakeUrlHandler(getActivity(), c16).dispatch(fakeInfo.leftUrl);
                    } else {
                        new QWalletFakeUrl(getActivity(), c16).gotoFakeUrl(fakeInfo.leftUrl);
                    }
                    this.isClickRetry = true;
                    return true;
                }
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        return super.onBlHandleFakeurl(fakeInfo, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (isValidClick(id5)) {
            if (id5 == R.id.aox) {
                QwLog.i("cancel click show dialog...");
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.21
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        BusinessPayActivity.this.setRetCodeAndErrorMsg(-1, "");
                        BusinessPayActivity.this.finish();
                    }
                };
                QUIProxy.createCustomDialog(getContext(), 230, null, "\u786e\u8ba4\u53d6\u6d88\u6b64\u7b14\u652f\u4ed8\uff1f", "\u786e\u8ba4\u53d6\u6d88", "\u7ee7\u7eed\u652f\u4ed8", new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.22
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                    }
                }, onClickListener);
            } else if (id5 == R.id.b7t) {
                if (this.mWindowStyle == 0) {
                    showPassPayView();
                } else {
                    pay();
                }
            } else if (id5 == R.id.fah) {
                pay();
            } else if (id5 != R.id.fim && id5 != R.id.kn9 && id5 != R.id.az7) {
                if (id5 == R.id.i8e) {
                    this.mIsReentry = Boolean.TRUE;
                    pay();
                    uploadData("smallpay.sms.reacquire");
                } else if (id5 == R.id.change_phone_num_btn) {
                    go2ChangePhoneNumActivity();
                    uploadData("smallpay.sms.change");
                } else if (id5 == R.id.fjf) {
                    Intent intent = new Intent();
                    intent.putExtra("token_id", this.mPayTokenId);
                    intent.putExtra("forget_pass", true);
                    intent.putExtra("pass_flag", this.mPassFlag);
                    launchFragmentForResult(intent, ResetPassBridgeActivity.class, BasePayActivity.ResetPass_RESULT_CODE);
                    uploadData("smallpay.pwd.forgot");
                } else if (id5 == R.id.kkq) {
                    go2PWDAuth();
                    uploadData("fingerprint.confirm.pwd");
                } else if (id5 == R.id.caq) {
                    if (SoterWrapperApi.isSupportSoter() && this.mSoterBiometricCanceller == null) {
                        QwLog.i("\u8c03\u7528\u5fae\u4fe1SDK\u5f00\u542f\u6307\u7eb9\u670d\u52a1");
                        startFingerprintAuthentication();
                    }
                    uploadData("fingerprint.confirm.go");
                }
            } else {
                back();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int indexOf;
        getWindow().setSoftInputMode(19);
        this.mEnterType = Cgi.ENTER_FROM_PAY;
        Intent intent = getIntent();
        View inflate = layoutInflater.inflate(R.layout.ad6, viewGroup, false);
        checkFP();
        initView(inflate);
        resetRootLayout();
        initValue(intent);
        String stringExtra = intent.getStringExtra("pay_gate");
        if (TextUtils.isEmpty(stringExtra)) {
            TenpayUtil.markBeginTime();
            HashMap<String, String> hashMap = new HashMap<>();
            this.mPayGateRequest = hashMap;
            hashMap.put("uin", this.mUin);
            this.mPayGateRequest.put("token_id", this.mPayTokenId);
            this.mPayGateRequest.put("come_from", this.mComeFrom + "");
            this.mPayGateRequest.put(com.tencent.mobileqq.msf.core.c0.j.T0, intent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0));
            this.mPayGateRequest.put("sdk_channel", getIntent().getStringExtra("sdk_channel"));
            this.mPayGateRequest.put("sdk_data", getIntent().getStringExtra("sdk_data"));
            String str = null;
            try {
                String stringExtra2 = getIntent().getStringExtra("extra_data");
                if (!TextUtils.isEmpty(stringExtra2) && (indexOf = (str = new JSONObject(stringExtra2).optString("h5_url")).indexOf(63)) > 0) {
                    str = str.substring(0, indexOf);
                }
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            if (!TextUtils.isEmpty(str)) {
                this.mPayGateRequest.put("h5_url", str);
            }
            httpRequest(Cgi.URI_PAY_GATE, this.mPayGateRequest);
        } else {
            try {
                this.mPayGateObj = new JSONObject(stringExtra);
                initPayGateData();
                riskTipUIUpdate(this.mPayGateObj);
            } catch (JSONException e17) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e17);
                finish();
            }
            if (!getFingerPayStatus()) {
                this.mWindowStyle = 0;
                setViewData();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QwLog.i(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        closeTime(this.mVerifyResendBtn);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onFingerLocked() {
        this.mWindowStyle = 0;
        setViewData();
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        if (ErrorCode.ERR_PAY_NOT_ENOUGH.equals(optString)) {
            changePayType();
        }
        if ((str.equals(Cgi.URI_BALANCE_GET_CODE) || str.equals(Cgi.URI_FAST_PREPAY) || str.equals(Cgi.URL_FRIEND_QPAY_SPFA_PAY)) && ErrorCode.ERR_WRONG_PASSWORD.equals(optString)) {
            playAnimForPasswordView(1);
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onPwdChange() {
        super.onPwdChange();
        this.mPassFlag = "2";
        showPassPayView();
        QLog.i(((NetBaseActivity) this).TAG, 1, "receive onPwdChange.");
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isClickRetry) {
            playAnimForPasswordView(1);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URI_TRANSFER_PAY_CONFIRM)) {
            gotoPaySuccess(jSONObject, str);
            return;
        }
        if (str.equals(Cgi.URI_QWALLET_QPAY_REWARD_CALLBACK)) {
            gotoPaySuccess(jSONObject, str);
            return;
        }
        prosSotorBackParams(jSONObject);
        if (str.equals(Cgi.URI_PAY_GATE)) {
            riskTipUIUpdate(jSONObject);
            this.mPayGateObj = jSONObject;
            initPayGateData();
            if (this.mPayGateObj.optJSONObject("trustpay_param") != null) {
                Intent intent = new Intent();
                intent.putExtra("pay_gate", this.mPayGateObj.toString());
                launchFragment(intent, ConfirmTransactionActivity.class);
                finish();
                return;
            }
            if (this.mIsMidas) {
                setRetCodeAndGetBundle(-300);
            }
            if (this.mSelectedPayType == 2) {
                gotoBindBankActivity();
                finish();
                return;
            } else {
                if (!getFingerPayStatus()) {
                    setViewData();
                    return;
                }
                return;
            }
        }
        if (str.equals(Cgi.URI_BALANCE_GET_CODE)) {
            QwLog.i("---ID_BALANCE_PAY call back---");
            CertActivity.handleCertWithPaySuc(jSONObject, getContext(), this.mUin, this.mPassword, this.mTimestamp);
            if ("1".equals(jSONObject.optString("send_flag"))) {
                String optString = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
                this.mVerifyMobileTxt.setText(getString(R.string.edo) + optString);
                this.mShowPhoneChangeBtn = Boolean.FALSE;
                showVeryfyCodeView();
                com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.pswmsg", Integer.valueOf(getProcessType()));
                return;
            }
            gotoPaySuccess(jSONObject, str);
            com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.pswpay", Integer.valueOf(getProcessType()));
            return;
        }
        if (str.equals(Cgi.URI_FAST_PREPAY)) {
            QwLog.i("---ID_FASTPAY_PREPAY call back---");
            CertActivity.handleCertWithPaySuc(jSONObject, getContext(), this.mUin, this.mPassword, this.mTimestamp);
            if ("0".equals(jSONObject.optString("send_flag"))) {
                gotoPaySuccess(jSONObject, str);
                com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.pswpay", Integer.valueOf(getProcessType()));
                return;
            }
            this.mBindedFastObj = jSONObject;
            String optString2 = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
            this.mOldPhoneNum = optString2;
            if (optString2.length() != 11) {
                str3 = "";
            } else {
                str3 = (optString2.substring(0, 3) + "*****") + optString2.substring(9, 11);
            }
            this.mVerifyMobileTxt.setText(getString(R.string.edo) + str3);
            this.mShowPhoneChangeBtn = Boolean.TRUE;
            showVeryfyCodeView();
            com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.pswmsg", Integer.valueOf(getProcessType()));
            return;
        }
        if (str.equals(Cgi.URI_FAST_EXCUTEPAY)) {
            QwLog.i("---URI_FAST_EXCUTEPAY call back---");
            CertActivity.handleCertWithPaySuc(jSONObject, getContext(), this.mUin, this.mPassword, this.mTimestamp);
            gotoPaySuccess(jSONObject, str);
            com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.submitmsg", Integer.valueOf(getProcessType()));
            return;
        }
        if (str.equals(Cgi.URI_VALIDATE_PAY_PASS)) {
            go2ChangeValidDateActivity();
            return;
        }
        if (str.equals(Cgi.URI_CODE_IVR_CONFIRM)) {
            try {
                jSONObject.put("is_ivr_succ", true);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            gotoPaySuccess(jSONObject, str);
            return;
        }
        if (str.equals(Cgi.URI_CTPAY_AUTHEN)) {
            this.mCtPayAuthObj = jSONObject;
            if ("0".equals(jSONObject.optString("send_flag"))) {
                sendCtPayVerify();
                return;
            }
            String optString3 = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
            this.mOldPhoneNum = optString3;
            if (optString3.length() != 11) {
                str2 = "";
            } else {
                str2 = (optString3.substring(0, 3) + "*****") + optString3.substring(9, 11);
            }
            this.mVerifyMobileTxt.setText(getString(R.string.edo) + str2);
            this.mShowPhoneChangeBtn = Boolean.FALSE;
            showVeryfyCodeView();
            return;
        }
        if (str.equals(Cgi.URI_CTPAY_VERIFY)) {
            TenUtils.saveCtPayRedPointShown(getContext(), this.mUin);
            gotoPaySuccess(jSONObject, str);
        } else if (str.equals(Cgi.URL_FRIEND_QPAY_SPFA_PAY)) {
            gotoPaySuccess(jSONObject, str);
            com.tencent.mobileqq.qwallet.c.c("autofriendpay.pay.succ", Integer.valueOf(getProcessType()));
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void pay() {
        if (!this.isHasCheckedPayType) {
            showNoCheckedTips();
            return;
        }
        int i3 = this.mSelectedPayType;
        if (i3 == 0) {
            QwLog.i("---\u53d1\u8d77\u4f59\u989d\u652f\u4ed8---");
            sendBalancePay(0);
            uploadData("pay.enter.balance");
            return;
        }
        if (i3 == 5) {
            goAutoPay();
            uploadData("pay.enter.friendpay");
            return;
        }
        if (i3 == 4) {
            QwLog.i("---\u53d1\u8d77\u5f00\u901a\u4fe1\u7528\u652f\u4ed8---");
            sendCtPayAuthen();
            return;
        }
        if (i3 == 1) {
            uploadData("pay.enter.bank");
            QwLog.i("---\u53d1\u8d77\u5feb\u6377\u652f\u4ed8---");
            PayTypeModel payTypeModel = this.mSelectPayTypeModel;
            if (payTypeModel != null && payTypeModel.channel_info != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
                hashMap.put("token_id", this.mPayTokenId);
                hashMap.put("p", getPasswd());
                hashMap.put("bank_type", this.mSelectPayTypeModel.channel_info.optString("bank_type"));
                hashMap.put("timestamp", this.mTimestamp + "");
                if (this.mIsReentry.booleanValue()) {
                    this.mIsReentry = Boolean.FALSE;
                    hashMap.put("is_reentry", "1");
                } else {
                    hashMap.put("is_reentry", "0");
                }
                if (this.mChangeValidDate.booleanValue()) {
                    hashMap.put("newcthru", this.mValidDate);
                    if (!TextUtils.isEmpty(this.mValidDateCVV)) {
                        hashMap.put("newcvv", this.mValidDateCVV);
                    }
                }
                if (this.mChangePhoneNum.booleanValue()) {
                    hashMap.put("newmobile", this.mNewPhoneNum);
                    if (!TextUtils.isEmpty(this.mPhoneNumCVV)) {
                        hashMap.put("newcvv", this.mPhoneNumCVV);
                    }
                }
                if (this.mPayGateObj.optInt("nopwdnosms_flag") == 1 && this.mWindowStyle == 2) {
                    hashMap.put("nopwdnosms_flag", "1");
                    hashMap.put("purchaser_id", this.mUin);
                } else {
                    hashMap.put("nopwdnosms_flag", "0");
                }
                hashMap.put("bind_serial", this.mSelectPayTypeModel.channel_info.optString("bind_serial"));
                hashMap.put("trustpay_open_flag", this.mTrustPayOpen);
                fingerParamFill(hashMap);
                setPromotionInfo(hashMap);
                this.mCurrentTime = System.currentTimeMillis();
                hashMap.put("verify_flag", "2");
                httpRequestWithQQPayLoading(Cgi.URI_FAST_PREPAY, hashMap, getLoadingHeight());
            }
        }
    }

    protected void pay_excute() {
        PayTypeModel payTypeModel;
        int i3 = this.mSelectedPayType;
        if (i3 == 0) {
            sendBalancePay(1);
            return;
        }
        if (i3 == 4) {
            sendCtPayVerify();
            return;
        }
        if (i3 == 1 && (payTypeModel = this.mSelectPayTypeModel) != null && payTypeModel.channel_info != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("is_ydt", "0");
            hashMap.put("bank_type", this.mSelectPayTypeModel.channel_info.optString("bank_type"));
            hashMap.put("token_id", this.mPayTokenId);
            hashMap.put("verify_code", this.mVerifyCodeEdit.getText().toString().trim());
            hashMap.put("p", getPasswd());
            hashMap.put("token", this.mBindedFastObj.optString("token"));
            hashMap.put(CommonCode.MapKey.TRANSACTION_ID, this.mBindedFastObj.optString(CommonCode.MapKey.TRANSACTION_ID));
            hashMap.put("business_type", this.mBindedFastObj.optString("business_type"));
            hashMap.put("auth_params", this.mBindedFastObj.optString("auth_params"));
            hashMap.put(DeviceType.DeviceCategory.MOBILE, this.mBindedFastObj.optString(DeviceType.DeviceCategory.MOBILE));
            hashMap.put("purchaser_id", this.mBindedFastObj.optString("purchaser_id"));
            hashMap.put("timestamp", this.mTimestamp + "");
            fingerParamFill(hashMap);
            this.mCurrentTime = System.currentTimeMillis();
            hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
            httpRequestWithQQPayLoading(Cgi.URI_FAST_EXCUTEPAY, hashMap, getLoadingHeight());
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    public void resetLayout() {
        super.resetLayout();
        resetRootLayout();
        if (this.mPayConfirmLayout.getVisibility() == 0) {
            resetPayView();
        }
    }

    protected void sendBalancePay(int i3) {
        HashMap hashMap = new HashMap();
        if (i3 == 1) {
            hashMap.put("verify_code", this.mVerifyCodeEdit.getText().toString());
        }
        if (this.mIsReentry.booleanValue()) {
            this.mIsReentry = Boolean.FALSE;
            hashMap.put("is_reentry", "1");
        } else {
            hashMap.put("is_reentry", "0");
        }
        if (this.mIsAccountUpgrade) {
            this.mIsAccountUpgrade = false;
            hashMap.put("accountUpgrade", "1");
        }
        setPromotionInfo(hashMap);
        super.sendBalancePay(hashMap, getLoadingHeight());
    }

    protected void setViewData() {
        this.mPriceTxt.setText(Utils.transformToMoney(this.mTotalFee, 0));
        this.mProductTxt.setText(this.mGoodsName);
        final long currentTicks = Utils.getCurrentTicks();
        parsePromotionData();
        parsePayTypeData();
        setMarketingData();
        initExpandableListView();
        if (this.mHasStaticPromotion) {
            this.mMarketingMoneyView.setVisibility(0);
        } else {
            this.mMarketingMoneyView.setVisibility(8);
        }
        if (this.mWindowStyle == 1 && this.isHasCheckedPayType) {
            showFingerPayView();
        }
        QwLog.i("" + Utils.ticksToNowInMs(currentTicks));
        this.mAnimLayout.setVisibility(0);
        this.mAnimLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.7
            @Override // java.lang.Runnable
            public void run() {
                QwLog.i("" + Utils.ticksToNowInMs(currentTicks));
                BusinessPayActivity.this.resetPayView();
            }
        });
        uploadData("discount.info.show");
    }

    protected void showFingerPayView() {
        QwLog.i("showFingerPayView");
        this.mWindowStyle = 1;
        this.mFingerLayout.setVisibility(0);
        this.mConfirmPayButton.setVisibility(8);
        this.mCancelPayButton.setVisibility(8);
    }

    protected void showVeryfyCodeView() {
        PayTypeModel payTypeModel;
        JSONObject jSONObject;
        boolean z16 = true;
        this.isShowingVerifyCodeView = true;
        this.mVerifyCodeEdit.setText("");
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
        if (this.mSelectedPayType != 1 || (payTypeModel = this.mSelectPayTypeModel) == null || (jSONObject = payTypeModel.channel_info) == null || !Cgi.CTPAY_BANK_TYPE.equals(jSONObject.optString("bank_type"))) {
            z16 = false;
        }
        if (this.mSelectedPayType == 4 || z16) {
            this.mCtPayHelpImg.setVisibility(0);
            this.mShowPhoneChangeBtn = Boolean.FALSE;
        }
        initTimer(this.mVerifyResendBtn);
        this.mVerifyCodeEdit.requestFocus();
        this.mVerifyKeyboard.setInputEditText(this.mVerifyCodeEdit);
        if (this.mShowPhoneChangeBtn.booleanValue()) {
            this.mChangePhoneNumBtn.setVisibility(0);
        }
        this.mPassLayout.setVisibility(8);
        this.mPayConfirmLayout.setVisibility(8);
        this.mVerifyLayout.setVisibility(0);
        this.mVerifyLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154877er));
        if (this.mWindowStyle == 0) {
            this.mPassLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154879et));
        } else {
            this.mVerifyLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.BusinessPayActivity.13
                @Override // java.lang.Runnable
                public void run() {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(BusinessPayActivity.this.mAnimLayout, "translationY", -BusinessPayActivity.this.mVerifyLayout.getHeight());
                    ofFloat.setDuration(300L);
                    ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                    ofFloat.start();
                }
            });
        }
        uploadData("smallpay.sms.show");
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onFingerAuthenticationSucceed() {
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onStartFingerAuthentication() {
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void saveDefaultPayType() {
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void playFingerErrorAnim(String str) {
    }
}
