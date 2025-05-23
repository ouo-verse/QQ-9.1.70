package com.tenpay.sdk.activity;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessNoExtResult;
import com.tencent.soter.wrapper.wrap_task.InitializeParam;
import com.tencent.webbundle.sdk.WebBundleConstants;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.BankImageUtil;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.QWalletUtils;
import com.tenpay.api.TenpayInterface;
import com.tenpay.bank.BindBankModule;
import com.tenpay.bank.DisableBankInfo;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.impl.ApiInterfaceImpl;
import com.tenpay.ndk.CertUtil;
import com.tenpay.pay.ChoosePayTypeFragment;
import com.tenpay.pay.FriendPayController;
import com.tenpay.pay.PayChannelUtils;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.pay.model.SelectedPayChannelBean;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.api.IRealNameSourceReportApi;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.FingerNet.GetSupportSoterNet;
import com.tenpay.sdk.IResult;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.helper.WechatPayHelper;
import com.tenpay.sdk.net.NetParams;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.QwLog4Soter;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PayActivity extends BasePayActivity implements View.OnClickListener {
    public static final int ANIM_DOWN = 2;
    public static final int ANIM_UP = 1;
    public static final String FROM_FINGER_PAY = "from_finger_pay";
    public static final String KEY_IS_NO_CARD_TYPE = "key_is_no_card_type";
    public static final String KEY_QPAY_GATE_RSP = "pay_gate";
    public static final String KEY_RESTART_BUNDLE = "key_restart_bundle";
    public static final String KEY_SAVE_WINDOWS_STYLE = "key_save_windows_style";
    public static int OPEN_WEBANK_RESULT_CODE = 1001;
    protected static final int PAY_BANK_DEFAULT_INDEX = -1;
    public static final int PAY_BY_AUTOPAY = 5;
    public static final int PAY_BY_BALANCE = 0;
    public static final int PAY_BY_BANK = 1;
    public static final int PAY_BY_DEFAULT = -1;
    public static final int PAY_BY_NEWBANK = 2;
    public static final int PAY_BY_OPEN_CTPAY = 4;
    public static final int PAY_BY_WEBANK = 3;
    protected ImageView backBtn;
    protected JSONArray commPromoArr;
    protected Button confirmPayBtn;
    private int direct_pfa;
    private boolean isClickRetry;
    private RelativeLayout mAnimLayout;
    protected JSONObject mBindedFastObj;
    protected ImageView mChangePayBankIconFinger;
    protected ImageView mChangePayBankIconPassWd;
    private TextView mChangePayBankTailFinger;
    private TextView mChangePayBankTailPassWd;
    protected TextView mChangePayBankTxtFinger;
    protected TextView mChangePayBankTxtPassWd;
    protected LinearLayout mChangePayTypeBtnFinger;
    protected LinearLayout mChangePayTypeBtnPassWd;
    protected Button mChangePhoneNumBtn;
    protected ImageButton mCloseBtn;
    protected JSONObject mCtPayAuthObj;
    protected Dialog mCtPayGuideDlg;
    protected ImageView mCtPayHelpImg;
    protected JSONObject mCtPayParaObj;
    protected ImageView mCtPayRedPointFinger;
    protected ImageView mCtPayRedPointPassWd;
    protected JSONObject mCurPayPromoObj;
    protected String mDefaultCardInfo;
    private final HashMap<String, DisableBankInfo> mDisableBankMap;
    protected TextView mFingerErrorTips;
    private boolean mFingerStatus;
    private JSONObject mFriendPayObj;
    private boolean mIsActiveToChangePayType;
    protected Boolean mIsCreditCard;
    protected Boolean mIsReentry;
    private boolean mIsStartedWithFingerPay;
    private boolean mJumpFromFakeLeft;
    protected MyKeyboardWindow mKeyboard;
    protected Button mNoPassBtn;
    private int mOtherPayHeight;
    private LinearLayout mOtherPayView;
    private LinearLayout mPassView;
    private String mPassword;
    private Button mPayConfirmBtn;
    protected HashMap<String, String> mPayGateRequest;
    private LinearLayout mPayHeadLayout;
    private PayInfo mPayInfo;
    private String mPayerUin;
    protected ImageView mPriceCutArrow;
    private RelativeLayout mPriceCutLayout;
    protected TextView mPriceCutTxt;
    private RelativeLayout mPriceLayout;
    protected TextView mPriceTxt;
    protected TextView mProductTxt;
    private String mPromotionBankShow;
    private int mPwdPayPayHeight;
    protected RelativeLayout mRootView;
    protected JSONArray mSelBankPromoArr;
    protected JSONObject mSelectAutoPro;
    protected JSONObject mSelectBankObj;
    protected String mSelectBankType;
    private Boolean mShowPhoneChangeBtn;
    private int mSixPassLength;
    protected TextWatcher mTextWatcher;
    protected TextView mTitleRightTxt;
    protected TextView mTitleTxt;
    protected EditText mVerifyCodeEdit;
    protected MyKeyboardWindow mVerifyKeyboard;
    protected TextView mVerifyMobileTxt;
    protected Button mVerifyResendBtn;
    protected LinearLayout mVerifyView;
    private final WechatPayHelper mWechatPayHelper;
    protected LinearLayout mWx2QQLayoutFinger;
    protected LinearLayout mWx2QQLayoutPassword;
    protected String mWx2QQUrl;
    private LinearLayout normalPasswdLayout;
    private ImageView vipSkinHeader;
    protected String webankBalance;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes27.dex */
    public static class SoterCallback implements SoterProcessCallback<SoterProcessNoExtResult> {
        private WeakReference<PayActivity> activityWeak;

        SoterCallback(PayActivity payActivity) {
            this.activityWeak = new WeakReference<>(payActivity);
        }

        @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
        public void onResult(SoterProcessNoExtResult soterProcessNoExtResult) {
            PayActivity payActivity = this.activityWeak.get();
            if (payActivity != null) {
                payActivity.onResult(soterProcessNoExtResult);
            }
        }
    }

    public PayActivity() {
        Boolean bool = Boolean.FALSE;
        this.mShowPhoneChangeBtn = bool;
        this.mIsCreditCard = Boolean.TRUE;
        this.mPassword = null;
        this.mIsReentry = bool;
        this.mIsStartedWithFingerPay = false;
        this.mIsActiveToChangePayType = false;
        this.mWechatPayHelper = new WechatPayHelper();
        this.isClickRetry = false;
        this.mJumpFromFakeLeft = false;
        this.mDisableBankMap = new HashMap<>();
        this.mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.PayActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                PayActivity payActivity = PayActivity.this;
                if (payActivity.mWindowStyle == 0 && !payActivity.isShowingVerifyCodeView) {
                    if (payActivity.getPasswd().length() > 5) {
                        if (!PayActivity.this.mPayConfirmBtn.isEnabled()) {
                            PayActivity.this.mPayConfirmBtn.setEnabled(true);
                            PayActivity.this.mPayConfirmBtn.setClickable(true);
                            PayActivity.this.uploadData("smallpay.pwd.enable");
                            return;
                        }
                        return;
                    }
                    if (PayActivity.this.mPayConfirmBtn.isEnabled()) {
                        PayActivity.this.mPayConfirmBtn.setClickable(false);
                        PayActivity.this.mPayConfirmBtn.setEnabled(false);
                        PayActivity.this.uploadData("smallpay.pwd.disable");
                        return;
                    }
                    return;
                }
                if (payActivity.isShowingVerifyCodeView && payActivity.mVerifyCodeEdit.getText().toString().length() > 5) {
                    PayActivity.this.pay_excute();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        };
        this.direct_pfa = 0;
    }

    private void afterPayGatePromotionLogic() {
        String str;
        this.mTotalFee = this.mPayGateObj.optString("total_fee");
        this.mOriginalTotal = this.mPayGateObj.optString("total_fee");
        this.mPromotionFlag = this.mPayGateObj.optString("promotion_flag");
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("promotion_info");
        if (optJSONObject != null) {
            this.mPromotionBankShow = optJSONObject.optString("promotion_bank_show");
            str = optJSONObject.optString("recommend_pay");
        } else {
            str = null;
        }
        if (!Utils.isEmpty(getIntent().getStringExtra("bank_type"))) {
            resolvePromoFromConfirmTrans();
        } else {
            dealWithPromotionMechanism(this.mPayGateObj, str, true);
        }
    }

    private void back() {
        int i3;
        if (!this.isShowingVerifyCodeView) {
            if (this.mWindowStyle == 1) {
                uploadData("fingerprint.confirm.cancel");
                releaseFp();
            }
            if (this.mCloseBtn != null) {
                if (this.mIsMidas) {
                    if (this.mSelectedPayType == 0) {
                        uploadData("tenpay.yue.keyback");
                    } else {
                        uploadData("tenpay.kj.keyback");
                    }
                } else if (this.mUserAttr == 3) {
                    uploadData("identify.indenx.keyback");
                } else {
                    uploadData("smallpay.pwd.keyback");
                }
                closeCtPayRedPointShown();
                if (this.mIsFromConFirmTrans) {
                    backResultToConfirmTrans();
                }
                finish();
                if (!this.isInner && !this.isFriendPay && (this.mIsStartedWithFingerPay || (i3 = this.mComeFrom) == 1 || i3 == 2 || i3 == 9 || i3 == 5)) {
                    Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(-1);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (!TextUtils.isEmpty(this.mPayGateObj.optString("sdk_auth_data"))) {
                            jSONObject.put("sdk_auth_data", this.mPayGateObj.optString("sdk_auth_data"));
                        }
                    } catch (Exception e16) {
                        QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                    }
                    retCodeAndGetBundle.putString("retmsg", jSONObject.toString());
                }
            } else {
                if (this.mIsMidas) {
                    if (this.mSelectedPayType == 0) {
                        TenpayUtil.addMidasUploadData(getProcessType(), "tenpay.yuebig.keyback");
                    } else {
                        TenpayUtil.addMidasUploadData(getProcessType(), "tenpay.kjbig.keyback");
                    }
                }
                finish();
            }
            if (this.callback_when_cancel_pay) {
                callBackReceiver();
                return;
            }
            return;
        }
        goneVerfyView();
        if (this.mWindowStyle == 0) {
            showPassPayView();
        } else {
            showOtherPayView();
        }
        this.isShowingVerifyCodeView = false;
        uploadData("enpay.kjmsg.keyback");
    }

    private void backResultToConfirmTrans() {
        Intent intent = new Intent();
        intent.putExtra("select_pay_type", this.mSelectedPayType);
        intent.putExtra("select_bank_index", this.mSelectedPayBankIndex);
        intent.putExtra("bank_type", this.mSelectBankType);
        intent.putExtra("promo_txt", this.mPriceCutTxt.getText().toString());
        JSONObject jSONObject = this.mCurPayPromoObj;
        if (jSONObject != null) {
            intent.putExtra("cur_promo_json", jSONObject.toString());
        }
        setResult(-1, intent);
    }

    private boolean checkAutoPay(List<JSONObject> list) {
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                JSONObject jSONObject = list.get(i3);
                if (jSONObject.optInt("disable") == 0) {
                    jSONObject.optString(QWSoterConstans.CGI_KEY_BUSI_TYPE);
                    jSONObject.optString("uin");
                    break;
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
        setPayTypeAutoPay();
        this.mSelectedPayType = 5;
        this.mSelectedPayBankIndex = i3;
        return true;
    }

    private boolean checkCardPay(List<JSONObject> list) {
        JSONObject jSONObject;
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (i3 < list.size()) {
                JSONObject jSONObject2 = list.get(i3);
                if (jSONObject2.optInt("disable") == 0) {
                    String str = jSONObject2.optString("bank_type") + jSONObject2.optString("card_tail");
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
        if (i3 < 0) {
            return false;
        }
        JSONObject jSONObject3 = list.get(i3);
        this.mSelectBankObj = jSONObject3;
        String optString = jSONObject3.optString("bank_name");
        String optString2 = this.mSelectBankObj.optString("card_tail");
        String optString3 = this.mSelectBankObj.optString("image_id");
        if (Cgi.CTPAY_BANK_TYPE.equals(this.mSelectBankObj.optString("bank_type")) && (jSONObject = this.mCtPayParaObj) != null) {
            optString2 = jSONObject.optString("ctpay_text");
            optString3 = this.mCtPayParaObj.optString("ctpay_image_id");
            z16 = true;
        }
        setPayType(optString, optString2, optString3, z16);
        setChangeValidDateFlag();
        this.mSelectedPayType = 1;
        this.mSelectedPayBankIndex = i3;
        this.mSelectBankType = this.mSelectBankObj.optString("bank_type");
        return true;
    }

    private void clearPassword() {
        this.mSixPasswdEdit.setInputText("");
        this.mSixPasswdEdit.requestFocus();
        this.mNormalPasswdEdit.setText("");
        this.mNormalPasswdEdit.requestFocus();
    }

    private void clearPromotionInfo() {
        this.mCurPayPromoObj = null;
        this.mPromotionFlag = "0";
        this.mIsRandomCut = false;
    }

    private void closeCtPayRedPointShown() {
        JSONObject jSONObject = this.mCtPayParaObj;
        if (jSONObject != null && "1".equals(jSONObject.optString("bind_state"))) {
            if (this.mCtPayRedPointPassWd.getVisibility() == 0 || this.mCtPayRedPointFinger.getVisibility() == 0) {
                TenUtils.saveCtPayRedPointShown(getContext(), this.mUin);
            }
        }
    }

    private void dealWithPromoTxtShow(Intent intent) {
        String stringExtra = intent.getStringExtra("promo_obj");
        if (!Utils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.mCurPayPromoObj = jSONObject;
                resolvePromotionInfo(jSONObject);
                showPromotionInfo();
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealWithPromotionMechanism(JSONObject jSONObject, String str, boolean z16) {
        JSONArray jSONArray;
        this.mSelBankPromoArr = null;
        this.mCurPayPromoObj = null;
        this.commPromoArr = null;
        this.mPromotionFlag = this.mPayGateObj.optString("promotion_flag");
        JSONObject optJSONObject = jSONObject.optJSONObject("promotion_info");
        if (optJSONObject == null) {
            return;
        }
        if (z16) {
            findPayTypeAndPayBankIndex(str);
        }
        if (!Utils.isEmpty(str)) {
            this.mSelectBankType = str;
            JSONArray optJSONArray = optJSONObject.optJSONArray(str);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("comm");
            this.commPromoArr = optJSONArray2;
            JSONArray joinJSONArray = Utils.joinJSONArray(optJSONArray, optJSONArray2);
            if (joinJSONArray != null && joinJSONArray.length() > 0) {
                JSONObject optJSONObject2 = joinJSONArray.optJSONObject(0);
                resolvePromotionInfo(optJSONObject2);
                this.mSelBankPromoArr = joinJSONArray;
                this.mCurPayPromoObj = optJSONObject2;
            }
        } else {
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("comm");
            this.commPromoArr = optJSONArray3;
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                JSONObject optJSONObject3 = this.commPromoArr.optJSONObject(0);
                resolvePromotionInfo(optJSONObject3);
                this.mSelBankPromoArr = this.commPromoArr;
                this.mCurPayPromoObj = optJSONObject3;
            }
        }
        if (!Utils.isEmpty(this.mSelectBankType) && this.mSelectBankType.equals("0") && (jSONArray = this.mSelBankPromoArr) != null && jSONArray.length() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < this.mSelBankPromoArr.length(); i3++) {
                if (!this.mSelBankPromoArr.optJSONObject(i3).optString("balance_flag").equals("0")) {
                    jSONArray2.mo162put(this.mSelBankPromoArr.opt(i3));
                }
            }
            this.mSelBankPromoArr = jSONArray2;
            JSONObject optJSONObject4 = jSONArray2.optJSONObject(0);
            this.mCurPayPromoObj = optJSONObject4;
            resolvePromotionInfo(optJSONObject4);
        }
        JSONArray jSONArray3 = this.mSelBankPromoArr;
        if (jSONArray3 == null || jSONArray3.length() < 1) {
            clearPromotionInfo();
        }
    }

    private void findPayTypeAndPayBankIndex(String str) {
        if (Utils.isEmpty(str)) {
            return;
        }
        if (str.equals("0")) {
            this.mSelectedPayType = 0;
            this.mSelectedPayBankIndex = -1;
            return;
        }
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(this.mPayGateObj, "bind_banks", "cardtype");
        for (int i3 = 0; i3 < findBindedBanks.size(); i3++) {
            if (str.equals(Cgi.CTPAY_BANK_TYPE) && str.equals(findBindedBanks.get(i3).optString("bank_type"))) {
                this.mSelectedPayType = 4;
                this.mSelectedPayBankIndex = -1;
                return;
            } else {
                if (str.equals(findBindedBanks.get(i3).optString("bank_type"))) {
                    this.mSelectedPayType = 1;
                    this.mSelectedPayBankIndex = i3;
                    return;
                }
            }
        }
    }

    private int getMidasProcessType() {
        if (this.mWindowStyle == 1) {
            return 137;
        }
        if (this.mChangePhoneNum.booleanValue()) {
            return 12;
        }
        if (this.mChangeValidDate.booleanValue()) {
            return 13;
        }
        JSONObject jSONObject = this.mPayGateObj;
        if (jSONObject == null) {
            return 0;
        }
        if (this.mSelectedPayType == 0) {
            return 1;
        }
        if (this.mWindowStyle == 2 && jSONObject.optInt("nopwdnosms_flag") == 1) {
            return 11;
        }
        if (this.mPayGateObj.optInt("full_check", 1) == 1) {
            return 5;
        }
        return 8;
    }

    private void getSelectPay(List<JSONObject> list, int i3) {
        JSONObject jSONObject;
        QwLog.i("---\u9009\u62e9\u7b2c\u4e00\u5f20\u53ef\u7528\u7684\u5df2\u7ed1\u94f6\u884c\u5361, \u5e8f\u53f7 = " + i3);
        JSONObject jSONObject2 = list.get(i3);
        this.mSelectBankObj = jSONObject2;
        boolean z16 = false;
        if (jSONObject2.optInt("is_creditpay") == 1 && this.mSelectBankObj.optInt("card_status") == 2) {
            this.webankBalance = getWebankBanlance();
            setPayType(this.mSelectBankObj.optString("bank_name"), this.webankBalance, this.mSelectBankObj.optString("image_id"), false);
            this.mSelectedPayType = 3;
            this.mSelectedPayBankIndex = i3;
            this.mSelectBankType = this.mSelectBankObj.optString("bank_type");
            return;
        }
        String optString = this.mSelectBankObj.optString("bank_name");
        String optString2 = this.mSelectBankObj.optString("card_tail");
        String optString3 = this.mSelectBankObj.optString("image_id");
        if (Cgi.CTPAY_BANK_TYPE.equals(this.mSelectBankObj.optString("bank_type")) && (jSONObject = this.mCtPayParaObj) != null) {
            optString2 = jSONObject.optString("ctpay_text");
            optString3 = this.mCtPayParaObj.optString("ctpay_image_id");
            z16 = true;
        }
        setPayType(optString, optString2, optString3, z16);
        setChangeValidDateFlag();
        this.mSelectedPayType = 1;
        this.mSelectedPayBankIndex = i3;
        this.mSelectBankType = this.mSelectBankObj.optString("bank_type");
    }

    private String getWebankBanlance() {
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(this.mPayGateObj, "bind_banks", "cardtype");
        if (findBindedBanks.size() == 0) {
            return null;
        }
        for (JSONObject jSONObject : findBindedBanks) {
            if (jSONObject.optInt("is_creditpay") == 1 && jSONObject.optInt("card_status") == 2) {
                return jSONObject.optString("available_amount");
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go2ChangeValidDateActivity() {
        Intent intent = new Intent();
        intent.putExtra("update_card_str", String.format(getString(R.string.ef_), this.mSelectBankObj.optString("card_tail"), this.mSelectBankObj.optString("bank_name")));
        intent.putExtra("showCvv", this.mShowCvv);
        if (this.mWindowStyle == 1) {
            intent.putExtra("processtype", getProcessType());
        } else {
            intent.putExtra("processtype", 15);
        }
        launchFragmentForResult(intent, ChangeValidDateActivity.class, BasePayActivity.ChangeValidDate_RESULT_CODE);
    }

    private void goAutoPay() {
        HashMap hashMap = new HashMap();
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("p", getPasswd());
        hashMap.put("payer_uin", this.mPayerUin);
        hashMap.put("timestamp", this.mTimestamp + "");
        fingerParamFill(hashMap);
        httpRequest(Cgi.URL_FRIEND_QPAY_SPFA_PAY, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goneVerfyView() {
        if (this.isShowingVerifyCodeView) {
            this.mProductTxt.setVisibility(0);
            this.mPriceLayout.setVisibility(0);
            this.mPriceCutLayout.setVisibility(0);
            this.backBtn.setVisibility(8);
            this.mVerifyView.setVisibility(4);
            this.isShowingVerifyCodeView = false;
        }
    }

    private void gotoChoosePriceCutActivity() {
        Intent intent = new Intent();
        JSONArray jSONArray = this.mSelBankPromoArr;
        if (jSONArray != null) {
            intent.putExtra("promotion_list", jSONArray.toString());
        }
        if (this.mWindowStyle == 0) {
            intent.putExtra("height", this.mPassView.getHeight());
            this.mPassView.setVisibility(4);
        } else {
            intent.putExtra("height", this.mOtherPayView.getHeight());
            this.mOtherPayView.setVisibility(4);
        }
        intent.putExtra("pay_gate", this.mPayGateObj.toString());
        launchFragmentForResult(intent, ChooseOnePriceCut.class, BasePayActivity.CHOOSE_PRICECUT_RESULT_CODE);
    }

    private void gotoFriendChoose() {
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("pfa_param");
        int i3 = 1;
        if (optJSONObject != null && optJSONObject.optInt("allow_multi_flag") == 1) {
            i3 = optJSONObject.optInt("allow_multi_counts", 1);
        }
        ApiUtil.chooseFriends(getOutActivity(), getString(R.string.e6r), Utils.transformToMoney(this.mTotalFee, 0), this.mPayGateObj.optString("desc"), this.mTotalFee, this.iPayFrom, i3, new ResultReceiver(this.mHandler) { // from class: com.tenpay.sdk.activity.PayActivity.12
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i16, Bundle bundle) {
                super.onReceiveResult(i16, bundle);
                if (i16 == 1) {
                    Bundle retCodeAndGetBundle = PayActivity.this.setRetCodeAndGetBundle(ErrorCode.ERR_FRIENDPAY_SUCCESS);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("err_msg", PayActivity.this.getString(R.string.f171340e71));
                    } catch (Exception e16) {
                        QLog.e(((NetBaseActivity) PayActivity.this).TAG, 1, "", e16);
                    }
                    retCodeAndGetBundle.putString("retmsg", jSONObject.toString());
                    TenUtils.notifyToExit(PayActivity.this.getContext(), PayActivity.this.mProssesID);
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
                                Context context = PayActivity.this.getContext();
                                PayActivity payActivity = PayActivity.this;
                                apiInterfaceImpl.sendFriendPayRequest(context, payActivity.mPayTokenId, payActivity.mUin, stringArrayList, string, resultReceiver);
                                return;
                            }
                            return;
                        } catch (Exception e17) {
                            QLog.e(((NetBaseActivity) PayActivity.this).TAG, 1, "", e17);
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
                            intent.putExtra("pay_gate", PayActivity.this.mPayGateObj.toString());
                            intent.putExtra("process_flag", PayActivity.this.getProcessType());
                            intent.putExtra("payer_uin", stringArrayList2.get(0));
                            intent.putExtra("choose_friend_callback", resultReceiver2);
                            PayActivity.this.launchFragment(intent, SuperFriendPayActivity.class);
                        }
                    } catch (Exception e18) {
                        QLog.e(((NetBaseActivity) PayActivity.this).TAG, 1, "", e18);
                    }
                }
            }
        });
    }

    private void initSixPasswdEdit(View view) {
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.cf
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public final void onTextChange() {
                PayActivity.this.lambda$initSixPasswdEdit$1();
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.cg
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                PayActivity.this.lambda$initSixPasswdEdit$2(view2, z16);
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ch
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean lambda$initSixPasswdEdit$3;
                lambda$initSixPasswdEdit$3 = PayActivity.this.lambda$initSixPasswdEdit$3(textView, i3, keyEvent);
                return lambda$initSixPasswdEdit$3;
            }
        });
    }

    private void initVerifyCodeEdit(View view) {
        EditText editText = (EditText) view.findViewById(R.id.knc);
        this.mVerifyCodeEdit = editText;
        editText.addTextChangedListener(this.mTextWatcher);
        this.mVerifyCodeEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ce
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                boolean lambda$initVerifyCodeEdit$4;
                lambda$initVerifyCodeEdit$4 = PayActivity.this.lambda$initVerifyCodeEdit$4(textView, i3, keyEvent);
                return lambda$initVerifyCodeEdit$4;
            }
        });
        this.mVerifyCodeEdit.setOnClickListener(this);
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
    }

    private boolean isWebank(JSONObject jSONObject) {
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(jSONObject, "bind_banks", "cardtype");
        if (findBindedBanks.size() == 0) {
            return false;
        }
        for (int i3 = 0; i3 < findBindedBanks.size(); i3++) {
            JSONObject jSONObject2 = findBindedBanks.get(i3);
            if (TextUtils.isEmpty(this.mSelectBankSerial) && this.mSelectedPayType == 3) {
                if (jSONObject2.optInt("is_creditpay") == 1) {
                    if (jSONObject2.optInt("card_status") == 2) {
                        this.mSelectedPayType = 3;
                        this.mSelectedPayBankIndex = i3;
                        return true;
                    }
                    this.mSelectedPayType = -1;
                    this.mSelectedPayBankIndex = -1;
                    return false;
                }
                if (i3 == findBindedBanks.size() - 1) {
                    this.mSelectedPayType = -1;
                    this.mSelectedPayBankIndex = -1;
                }
            }
            if (jSONObject2.optString("bind_serial").equals(this.mSelectBankSerial) && jSONObject2.optInt("is_creditpay") == 1 && jSONObject2.optInt("card_status") == 2) {
                this.mSelectedPayType = 3;
                this.mSelectedPayBankIndex = i3;
                return true;
            }
        }
        return false;
    }

    private boolean isWxPay() {
        PayInfo payInfo = this.mPayInfo;
        if ((payInfo != null && payInfo.o()) || this.mComeFrom == 11) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$gotoNewChangePayType$14(ChoosePayTypeFragment choosePayTypeFragment, boolean z16, String str, Bundle bundle) {
        String str2;
        PayChannelBean payChannelBean = (PayChannelBean) bundle.getParcelable("ret_channel");
        boolean z17 = bundle.getBoolean(ChoosePayTypeFragment.RET_KEY_NEW_BALANCE, false);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPayChannelResult: ");
        sb5.append(str);
        sb5.append(", ");
        SelectedPayChannelBean selectedPayChannelBean = null;
        String str3 = null;
        if (payChannelBean != null) {
            str2 = payChannelBean.toString();
        } else {
            str2 = null;
        }
        sb5.append(str2);
        sb5.append(", isNewBalance=");
        sb5.append(z17);
        QwLog.i(sb5.toString());
        if (payChannelBean instanceof PayChannelBean.AddMore) {
            startBindBank((PayChannelBean.AddMore) payChannelBean);
            clearPassword();
            return;
        }
        if (payChannelBean instanceof PayChannelBean.FriendPay) {
            FriendPayController.FriendPayResult payResult = ((PayChannelBean.FriendPay) payChannelBean).getPayResult();
            StringBuilder sb6 = new StringBuilder();
            sb6.append("FriendPayResult: ");
            if (payResult != null) {
                str3 = payResult.toString();
            }
            sb6.append(str3);
            QwLog.i(sb6.toString());
            if (payResult != null && payResult.getRetCode() == -11012) {
                choosePayTypeFragment.dismissAllowingStateLoss();
                setRetCodeAndErrorMsg(payResult.getRetCode(), payResult.getRetMsg());
                TenUtils.notifyToExit(getContext(), this.mProssesID);
            }
            clearPassword();
            return;
        }
        choosePayTypeFragment.getParentFragmentManager().clearFragmentResultListener("select_hb_channel_finish");
        if (z17) {
            reloadBindBanks();
            choosePayTypeFragment.dismissAllowingStateLoss();
            clearPassword();
            return;
        }
        if (z16) {
            Intent intent = new Intent();
            intent.putExtra(KEY_IS_NO_CARD_TYPE, true);
            setResult(0, intent);
            finish();
            return;
        }
        if (payChannelBean instanceof PayChannelBean.Balance) {
            selectedPayChannelBean = new SelectedPayChannelBean(0, null, null, null, 0);
        } else if (payChannelBean instanceof PayChannelBean.Bank) {
            selectedPayChannelBean = SelectedPayChannelBean.fromBank((PayChannelBean.Bank) payChannelBean);
        } else if (payChannelBean instanceof PayChannelBean.AutoPayCard) {
            selectedPayChannelBean = SelectedPayChannelBean.fromAutoPay((PayChannelBean.AutoPayCard) payChannelBean);
        }
        if (selectedPayChannelBean != null) {
            this.mAnimLayout.setVisibility(0);
            this.mSelectedPayType = selectedPayChannelBean.getPayType();
            this.mSelectedPayBankIndex = selectedPayChannelBean.getBankIndex();
            this.mSelectBankType = selectedPayChannelBean.getBankType();
            choosePayTypeFragment.dismissAllowingStateLoss();
            fillViewWithData(this.mPayGateObj, this.mSelectedPayType, this.mSelectedPayBankIndex);
            clearPassword();
        } else {
            QwLog.i("no selected pay channel callback");
        }
        goneVerfyView();
        playAnimInFromChoosePayTypeActivity();
        this.mIsActiveToChangePayType = false;
        this.isNeedRestartFingerPay = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSixPasswdEdit$1() {
        int length = this.mSixPasswdEdit.getInputText().length();
        HashMap<String, Integer> hashMap = this.mMusicIds;
        if (hashMap != null && hashMap.size() == 6 && length >= 1 && length <= 6 && this.mSixPassLength < length) {
            playMusic("30" + length);
        }
        if (length > 5 && this.mWindowStyle == 0) {
            pay();
            uploadData("smallpay.pwd.go");
        }
        this.mSixPassLength = length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initSixPasswdEdit$2(View view, boolean z16) {
        if (this.mSixPasswdEdit.isFocused()) {
            this.mKeyboard.setVisibility(0);
            this.mKeyboard.setInputEditText(this.mSixPasswdEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initSixPasswdEdit$3(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 66) {
            if (getPasswd().length() > 5) {
                pay();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initVerifyCodeEdit$4(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        if (this.mVerifyCodeEdit.getText().toString().length() > 5) {
            pay_excute();
        } else {
            QQToast.makeText(getContext(), R.string.efz, 0).show();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QUIProxy.createCustomDialog(getContext(), 230, null, getString(R.string.e4y), getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
            }
        });
        uploadData("smallpay.sms.why");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAnimation$6() {
        this.mOtherPayView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playAnimation$7() {
        this.mOtherPayHeight = this.mOtherPayView.getHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(r0 + this.mPayHeadLayout.getHeight()));
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ck
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.lambda$playAnimation$6();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playFingerErrorAnim$15() {
        this.mFingerErrorTips.setText(R.string.e6i);
        this.mFingerErrorTips.setTextColor(Color.parseColor("#E8A741"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setPayTypeAutoPay$5(String str) {
        if (Utils.isEmpty(str)) {
            str = this.mPayerUin;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Utils.cutTextByPix(getContext(), str, 130.0f, this.mChangePayBankTailPassWd.getPaint()));
        sb5.append("-");
        this.mChangePayBankTxtPassWd.setText(sb5.toString());
        this.mChangePayBankTxtFinger.setText(sb5.toString());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassPayView$10() {
        this.mPassView.setVisibility(0);
        this.mOtherPayView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassPayView$11() {
        this.mPwdPayPayHeight = this.mPassView.getHeight();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(r0 + this.mPayHeadLayout.getHeight() + this.vipSkinHeader.getHeight()));
        ofFloat.setDuration(this.mPassAnimDuration);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ci
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.lambda$showPassPayView$10();
            }
        }, this.mPassAnimDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassPayView$8() {
        int screenHeight = Utils.getScreenHeight(getContext());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        layoutParams.height = (screenHeight * 2) + this.vipSkinHeader.getHeight();
        this.mRootView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mAnimLayout.getLayoutParams();
        layoutParams2.height = screenHeight + this.vipSkinHeader.getHeight();
        this.mAnimLayout.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassPayView$9() {
        this.mSixPasswdEdit.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVeryfyCodeView$12() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(this.mVerifyView.getHeight() + this.mPayHeadLayout.getHeight() + this.vipSkinHeader.getHeight()));
        ofFloat.setDuration(250L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVeryfyCodeView$13() {
        this.mVerifyView.setVisibility(0);
    }

    private int loadSavedWindowStyle() {
        int e16 = com.tencent.mobileqq.qwallet.utils.g.e(KEY_SAVE_WINDOWS_STYLE, 0);
        if (e16 == 1 && !this.isSoterOpened) {
            return 0;
        }
        return e16;
    }

    private void logBankInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            QLog.d(((NetBaseActivity) this).TAG, 1, "logBankInfo null");
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("bind_banks");
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needShowRedPoint() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        boolean z16;
        if (this.mIsMidas || (jSONObject = this.mCtPayParaObj) == null) {
            return false;
        }
        String optString = jSONObject.optString("bind_state");
        if ("0".equals(optString)) {
            return !TenUtils.readOpenCtPayRedPointShown(getContext(), this.mUin);
        }
        if (!"1".equals(optString) || (jSONObject2 = this.mPayGateObj) == null) {
            return false;
        }
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(jSONObject2, "bind_banks", "cardtype");
        int i3 = 0;
        while (true) {
            if (i3 < findBindedBanks.size()) {
                if (Cgi.CTPAY_BANK_TYPE.equals(findBindedBanks.get(i3).optString("bank_type"))) {
                    if (findBindedBanks.get(i3).optInt("disable") != 0) {
                        return false;
                    }
                    z16 = true;
                } else {
                    i3++;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            return false;
        }
        return !TenUtils.readCtPayRedPointShown(getContext(), this.mUin);
    }

    private void onBindCardSuccess(int i3, Intent intent) {
        if (i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("bind_serial");
            if (!TextUtils.isEmpty(stringExtra) && !isFinishing()) {
                Fragment findFragmentByTag = getActivity().getSupportFragmentManager().findFragmentByTag(ChoosePayTypeFragment.TAG);
                if (findFragmentByTag instanceof ChoosePayTypeFragment) {
                    ((ChoosePayTypeFragment) findFragmentByTag).dismissAllowingStateLoss();
                }
                QwLog.i("bind card success: " + stringExtra);
                this.mSelectedPayType = 1;
                this.mSelectedPayBankIndex = -1;
                this.mSelectBankSerial = stringExtra;
                reloadBindBanks();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult(SoterProcessNoExtResult soterProcessNoExtResult) {
        if (getContext() != null && !isFinishing()) {
            QwLog.i("\u521d\u59cb\u5316: " + soterProcessNoExtResult.toString());
            if (this.mWindowStyle == -1) {
                if ((soterProcessNoExtResult.isSuccess() || soterProcessNoExtResult.errCode == 1028) && SoterWrapperApi.isSupportSoter()) {
                    this.mWindowStyle = 1;
                    this.mIsStartedWithFingerPay = true;
                } else {
                    this.mWindowStyle = 0;
                }
            }
            setViewData(this.mPayGateObj);
        }
    }

    private boolean openWebankSuccOrNot() {
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(this.mPayGateObj, "bind_banks", "cardtype");
        if (findBindedBanks.size() == 0) {
            return false;
        }
        for (int i3 = 0; i3 < findBindedBanks.size(); i3++) {
            JSONObject jSONObject = findBindedBanks.get(i3);
            if (jSONObject.optInt("is_creditpay") == 1 && jSONObject.optInt("card_status") == 2) {
                this.mSelectedPayType = 3;
                this.mSelectedPayBankIndex = i3;
                return true;
            }
        }
        return false;
    }

    private void playAnimForPasswordView(int i3) {
        int i16;
        if (i3 == 2) {
            i16 = this.mPwdPayPayHeight + this.mPayHeadLayout.getHeight() + this.vipSkinHeader.getHeight();
        } else if (i3 == 1) {
            i16 = -(this.mPwdPayPayHeight + this.mPayHeadLayout.getHeight() + this.vipSkinHeader.getHeight());
        } else {
            i16 = 0;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", i16);
        ofFloat.setDuration(this.mPassAnimDuration);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnimInFromChoosePayTypeActivity() {
        int i3;
        int i16;
        int height;
        this.mAnimLayout.setVisibility(0);
        LinearLayout linearLayout = this.mPassView;
        int i17 = 4;
        if (this.mWindowStyle == 0) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        linearLayout.setVisibility(i3);
        LinearLayout linearLayout2 = this.mOtherPayView;
        if (this.mWindowStyle != 0) {
            i17 = 0;
        }
        linearLayout2.setVisibility(i17);
        this.mPayHeadLayout.setVisibility(0);
        if (this.mWindowStyle == 0) {
            i16 = this.mPwdPayPayHeight;
            height = this.mPayHeadLayout.getHeight();
        } else {
            i16 = this.mOtherPayHeight;
            height = this.mPayHeadLayout.getHeight();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", (-(i16 + height)) - this.vipSkinHeader.getHeight());
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    private void playHideAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", r0.getHeight());
        ofFloat.setDuration(300L);
        ofFloat.start();
        int i3 = this.mWindowStyle;
        if (i3 == 0) {
            this.mPassView.setVisibility(4);
        } else if (i3 == 1) {
            this.mOtherPayView.setVisibility(4);
        }
        this.mPayHeadLayout.setVisibility(4);
    }

    private void putParamToMap(@NonNull Map<String, String> map) {
        map.put("is_ydt", "0");
        map.put("bank_type", this.mSelectBankObj.optString("bank_type"));
        map.put("token_id", this.mPayTokenId);
        map.put("verify_code", this.mVerifyCodeEdit.getText().toString().trim());
        map.put("p", getPasswd());
        map.put("token", this.mBindedFastObj.optString("token"));
        map.put(CommonCode.MapKey.TRANSACTION_ID, this.mBindedFastObj.optString(CommonCode.MapKey.TRANSACTION_ID));
        map.put("business_type", this.mBindedFastObj.optString("business_type"));
        map.put("auth_params", this.mBindedFastObj.optString("auth_params"));
        map.put(DeviceType.DeviceCategory.MOBILE, this.mBindedFastObj.optString(DeviceType.DeviceCategory.MOBILE));
        map.put("purchaser_id", this.mBindedFastObj.optString("purchaser_id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadBindBanks() {
        sendPayGateRequest();
    }

    private void resolvePromoFromConfirmTrans() {
        JSONArray jSONArray;
        Intent intent = getIntent();
        this.mSelBankPromoArr = null;
        this.mCurPayPromoObj = null;
        this.mSelectedPayType = intent.getIntExtra("select_pay_type", this.mSelectedPayType);
        this.mSelectedPayBankIndex = intent.getIntExtra("select_bank_index", this.mSelectedPayBankIndex);
        this.mSelectBankType = intent.getStringExtra("bank_type");
        try {
            String stringExtra = intent.getStringExtra("cur_promo_json");
            if (!Utils.isEmpty(stringExtra)) {
                this.mCurPayPromoObj = new JSONObject(stringExtra);
            }
            resolvePromotionInfo(this.mCurPayPromoObj);
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        JSONObject optJSONObject = this.mPayGateObj.optJSONObject("promotion_info");
        if (optJSONObject == null) {
            return;
        }
        if (!Utils.isEmpty(this.mSelectBankType)) {
            JSONArray optJSONArray = optJSONObject.optJSONArray(this.mSelectBankType);
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("comm");
            this.commPromoArr = optJSONArray2;
            JSONArray joinJSONArray = Utils.joinJSONArray(optJSONArray, optJSONArray2);
            if (joinJSONArray != null && joinJSONArray.length() > 0) {
                this.mSelBankPromoArr = joinJSONArray;
            }
        } else {
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("comm");
            this.commPromoArr = optJSONArray3;
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                this.mSelBankPromoArr = this.commPromoArr;
            }
        }
        if (!Utils.isEmpty(this.mSelectBankType) && this.mSelectBankType.equals("0") && (jSONArray = this.mSelBankPromoArr) != null && jSONArray.length() > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < this.mSelBankPromoArr.length(); i3++) {
                if (!this.mSelBankPromoArr.optJSONObject(i3).optString("balance_flag").equals("0")) {
                    jSONArray2.mo162put(this.mSelBankPromoArr.opt(i3));
                }
            }
            this.mSelBankPromoArr = jSONArray2;
        }
        JSONArray jSONArray3 = this.mSelBankPromoArr;
        if (jSONArray3 == null || jSONArray3.length() < 1) {
            clearPromotionInfo();
        }
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
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
            hashMap.put("promotion_id", this.mPromotionId);
            hashMap.put("promotion_fee", this.mPromotionFee);
            hashMap.put("promotion_type", this.mPromotionType);
        }
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
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
            hashMap.put("promotion_id", this.mPromotionId);
            hashMap.put("promotion_fee", this.mPromotionFee);
            hashMap.put("promotion_type", this.mPromotionType);
        }
        httpRequest(Cgi.URI_CTPAY_VERIFY, hashMap);
    }

    private void sendPayGateRequest() {
        int indexOf;
        QwLog.i("PAY init START");
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        TenpayUtil.markBeginTime();
        PayInfo payInfo = this.mPayInfo;
        if (payInfo != null) {
            if (payInfo.getPrepayId() != null) {
                this.mPayTokenId = this.mPayInfo.getPrepayId();
            }
            if (this.mPayInfo.getBase().getUin() != null) {
                this.mUin = this.mPayInfo.getBase().getUin();
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        this.mPayGateRequest = hashMap;
        hashMap.put("uin", this.mUin);
        this.mPayGateRequest.put("come_from", this.mComeFrom + "");
        this.mPayGateRequest.put(com.tencent.mobileqq.msf.core.c0.j.T0, intent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0));
        this.mPayGateRequest.put("sdk_channel", String.valueOf(intent.getIntExtra("sdk_channel", 0)));
        PayInfo payInfo2 = this.mPayInfo;
        if (payInfo2 != null) {
            if (payInfo2.o()) {
                this.mPayGateRequest.putAll(this.mPayInfo.t());
            } else {
                this.mPayGateRequest.putAll(this.mPayInfo.s());
            }
        } else {
            this.mPayGateRequest.put(com.tencent.mobileqq.msf.core.c0.j.T0, intent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0));
            this.mPayGateRequest.put("sdk_data", intent.getStringExtra("sdk_data"));
            this.mPayGateRequest.put("token_id", this.mPayTokenId);
        }
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
            this.mPayGateRequest.put("h5_url", str);
        }
        httpRequest(Cgi.URI_PAY_GATE, this.mPayGateRequest);
    }

    private void setChangeValidDateFlag() {
        JSONObject jSONObject = this.mSelectBankObj;
        if (jSONObject != null) {
            this.mShowCvv = jSONObject.optString("needcvv");
            this.mIsCreditCard = Boolean.valueOf(this.mSelectBankObj.optString("cardtype").equals("CREDIT"));
        }
    }

    private void setPayType(String str, String str2, String str3, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("(");
            if (this.mSelectedPayType == 3) {
                if (!TextUtils.isEmpty(this.webankBalance)) {
                    sb5.append(Utils.fen2Yuan(this.webankBalance));
                    sb5.append(getString(R.string.ehr));
                }
            } else {
                sb5.append(str2);
            }
            sb5.append(")");
        }
        if (z16) {
            if (!TenUtils.readCtPayRedPointShown(getContext(), this.mUin)) {
                TenUtils.saveCtPayRedPointShown(getContext(), this.mUin);
            }
            this.mCtPayRedPointFinger.setVisibility(8);
            this.mCtPayRedPointPassWd.setVisibility(8);
        }
        QwLog.i("\u56fe\u7247\u7684\u8d44\u6e90id:" + str3 + ",\u662f\u5426\u4fe1\u7528\u4ed8:" + z16);
        if (!Utils.isEmpty(str3)) {
            BankImageUtil.getInstance(getContext()).setBankImage(str3, this.mChangePayBankIconPassWd);
            BankImageUtil.getInstance(getContext()).setBankImage(str3, this.mChangePayBankIconFinger);
        }
        this.mChangePayBankTxtPassWd.setText(str);
        this.mChangePayBankTxtFinger.setText(str);
        this.mChangePayBankTailPassWd.setText(sb5.toString());
        this.mChangePayBankTailFinger.setText(sb5.toString());
    }

    private void setPayTypeAutoPay() {
        String optString = this.mSelectAutoPro.optString("busi_name");
        String optString2 = this.mSelectAutoPro.optString("image_id");
        this.mPayerUin = this.mSelectAutoPro.optString("uin");
        Bundle bundle = new Bundle();
        bundle.putString(WadlProxyConsts.CHANNEL, "");
        bundle.putString("uin", this.mPayerUin);
        bundle.putString("group_id", "");
        QWalletNickNameServer.b(null, this.mPayerUin, new Function1() { // from class: com.tenpay.sdk.activity.cj
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$setPayTypeAutoPay$5;
                lambda$setPayTypeAutoPay$5 = PayActivity.this.lambda$setPayTypeAutoPay$5((String) obj);
                return lambda$setPayTypeAutoPay$5;
            }
        });
        if (!Utils.isEmpty(optString2)) {
            BankImageUtil.getInstance(getContext()).setBankImage(optString2, this.mChangePayBankIconPassWd);
            BankImageUtil.getInstance(getContext()).setBankImage(optString2, this.mChangePayBankIconFinger);
        }
        this.mChangePayBankTailPassWd.setText(optString);
        this.mChangePayBankTailFinger.setText(optString);
    }

    private void setPayTypeBalance() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        sb5.append(Utils.transformToMoney(this.mBalance + "", 0));
        sb5.append(getString(R.string.ehr));
        sb5.append(")");
        this.mChangePayBankTxtPassWd.setText(R.string.f2180562o);
        this.mChangePayBankTxtFinger.setText(R.string.f2180562o);
        this.mChangePayBankTailPassWd.setText(sb5.toString());
        this.mChangePayBankTailFinger.setText(sb5.toString());
        this.mSelectedPayType = 0;
        this.mSelectedPayBankIndex = -1;
        this.mSelectBankType = "0";
        this.mChangePayBankIconPassWd.setBackgroundResource(R.drawable.dvp);
        this.mChangePayBankIconFinger.setBackgroundResource(R.drawable.dvp);
    }

    private void setPayTypeOpenCtPay() {
        try {
            JSONObject jSONObject = this.mPayGateObj.getJSONObject("ctpay_param");
            String optString = jSONObject.optString("ctpay_title");
            String optString2 = jSONObject.optString("ctpay_text");
            if (!TextUtils.isEmpty(optString2)) {
                this.mChangePayBankTailPassWd.setText("(" + optString2 + ")");
                this.mChangePayBankTailFinger.setText("(" + optString2 + ")");
            }
            this.mChangePayBankTxtPassWd.setText(optString);
            this.mChangePayBankTxtFinger.setText(optString);
            String optString3 = this.mCtPayParaObj.optString("ctpay_image_id");
            QwLog.i("\u8bbe\u7f6e\u4fe1\u7528\u4ed8\uff0c\u56fe\u7247\u7684\u8d44\u6e90id:" + optString3);
            if (!Utils.isEmpty(optString3)) {
                BankImageUtil.getInstance(getContext()).setBankImage(optString3, this.mChangePayBankIconPassWd);
                BankImageUtil.getInstance(getContext()).setBankImage(optString3, this.mChangePayBankIconFinger);
            }
            this.mSelectedPayType = 4;
            this.mSelectedPayBankIndex = -1;
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setViewData(JSONObject jSONObject) {
        uploadData("smallpay.pwd.show", getProcessType());
        if (this.mIsMidas) {
            fillViewWithData(jSONObject, this.mSelectedPayType, this.mSelectedPayBankIndex);
            return;
        }
        int i3 = this.mSelectedPayType;
        if (i3 >= 0) {
            fillViewWithData(jSONObject, i3, this.mSelectedPayBankIndex);
        } else {
            fillViewWithData(jSONObject, -1, -1);
        }
    }

    private void showPassPayView() {
        this.mIsSixPasswdUser = "2".equals(this.mPassFlag);
        this.mWindowStyle = 0;
        this.mAnimLayout.setVisibility(0);
        this.mPayHeadLayout.setVisibility(0);
        this.mTitleTxt.setText("\u8f93\u5165\u652f\u4ed8\u5bc6\u7801");
        if (this.mFingerStatus) {
            this.mTitleRightTxt.setText(QWSoterConstans.getNameByBusiType(SharedHelper.getCurSoterBusiType(this.mUin)) + "\u652f\u4ed8");
            this.mTitleRightTxt.setVisibility(0);
        } else {
            this.mTitleRightTxt.setVisibility(8);
        }
        this.confirmPayBtn.setVisibility(8);
        this.mCloseBtn.setVisibility(0);
        if (this.mIsSixPasswdUser) {
            this.mKeyboard.setVisibility(0);
            List<Bitmap> list = this.passIconBp;
            if (list != null && this.isPaySkinCanUse && list.size() == 6) {
                try {
                    this.mSixPasswdEdit.setVipStyle(this.passIconBp, Utils.reSizeBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dyf), Utils.dp2Px(getContext(), 34.0f), Utils.dp2Px(getContext(), 3.0f)));
                    if (this.headPath != null && Utils.getScreenWidth(getContext()) > 500 && this.vipSkinHeader.getVisibility() == 8) {
                        this.vipSkinHeader.setImageBitmap(BitmapFactory.decodeFile(this.headPath));
                        this.vipSkinHeader.setVisibility(0);
                        this.mAnimLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.cp
                            @Override // java.lang.Runnable
                            public final void run() {
                                PayActivity.this.lambda$showPassPayView$8();
                            }
                        });
                    }
                } catch (Exception | OutOfMemoryError e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                }
            }
            this.normalPasswdLayout.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.setFocusable(true);
            this.mSixPasswdEdit.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.cq
                @Override // java.lang.Runnable
                public final void run() {
                    PayActivity.this.lambda$showPassPayView$9();
                }
            }, 500L);
        } else {
            this.mSixPasswdEdit.setVisibility(8);
            this.normalPasswdLayout.setVisibility(0);
            this.mKeyboard.setVisibility(8);
            if (this.mWindowStyle == 0) {
                this.mPayConfirmBtn.setVisibility(0);
            }
            this.normalPasswdLayout.setVisibility(0);
            if (this.mNormalPasswdEdit.getText().toString().length() > 5) {
                this.mPayConfirmBtn.setEnabled(true);
                this.mPayConfirmBtn.setClickable(true);
            } else {
                this.mPayConfirmBtn.setEnabled(false);
                this.mPayConfirmBtn.setClickable(false);
            }
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        this.mPassView.post(new Runnable() { // from class: com.tenpay.sdk.activity.cr
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.lambda$showPassPayView$11();
            }
        });
    }

    private void startBindBank(PayChannelBean.AddMore addMore) {
        int i3;
        RealNameSource realNameSource;
        Intent intent = new Intent();
        intent.putExtra("token_id", this.mPayTokenId);
        try {
            i3 = Integer.parseInt(this.mPassFlag);
        } catch (NumberFormatException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, e16, new Object[0]);
            i3 = 0;
        }
        intent.putExtra("pass_flag", i3);
        intent.putExtra("trustpay_open_flag", this.mTrustPayOpen);
        if (1 == this.mWindowStyle) {
            intent.putExtra(FROM_FINGER_PAY, true);
            intent.putExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, getProcessType());
        }
        intent.putExtra("from_choose_pay_type_small", true);
        if ("social".equals(addMore.getPayScene())) {
            realNameSource = ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).getCurrentNameSource();
        } else {
            realNameSource = new RealNameSource("19");
        }
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
        BindBankModule.INSTANCE.startWithSwitchForResult(this, intent, BasePayActivity.REQUEST_CODE_BIND_BANK, 0);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void changePayTypeInFakeUrl() {
        boolean z16;
        if (this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
            this.mPayConfirmBtn.setClickable(false);
            this.mPayConfirmBtn.setEnabled(false);
        } else {
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.requestFocus();
        }
        if (this.mSelectedPayType == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        gotoChangePayType(false, z16);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void fillViewWithData(JSONObject jSONObject, int i3, int i16) {
        boolean z16;
        int i17;
        int i18;
        int i19;
        boolean z17;
        JSONObject optJSONObject;
        this.mAnimLayout.setVisibility(0);
        QwLog.i("fillViewWithData begin" + System.currentTimeMillis());
        QwLog.i("payType = " + i3);
        QwLog.i("bankIndex = " + i16);
        this.mPayGateObj = jSONObject;
        String str = this.mPassFlag;
        if (str == null || !str.equals("2")) {
            this.mPassFlag = this.mPayGateObj.optString("pass_flag");
        }
        this.mSelectedPayType = i3;
        this.mSelectedPayBankIndex = i16;
        this.mPriceTxt.setText(Utils.transformToMoney(this.mTotalFee, 0));
        this.mProductTxt.setText(this.mPayGateObj.optString("desc"));
        QwLog.i("desc = " + this.mPayGateObj.optString("desc"));
        if (needShowRedPoint()) {
            this.mCtPayRedPointPassWd.setVisibility(0);
            this.mCtPayRedPointFinger.setVisibility(0);
        } else {
            this.mCtPayRedPointPassWd.setVisibility(8);
            this.mCtPayRedPointFinger.setVisibility(8);
        }
        showPromotionInfo();
        if (this.mUserAttr == 0) {
            QwLog.i("---\u65b0\u7528\u6237, \u53bb\u9009\u62e9\u652f\u4ed8\u65b9\u5f0f---");
            gotoChangePayType(true, false);
            return;
        }
        JSONObject optJSONObject2 = this.mPayGateObj.optJSONObject("balance_info");
        this.mWx2QQLayoutPassword.setVisibility(8);
        this.mWx2QQLayoutFinger.setVisibility(8);
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("miniapp")) != null) {
            String optString = optJSONObject.optString("sdk_content");
            this.mWx2QQUrl = optJSONObject.optString("sdk_url");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(this.mWx2QQUrl)) {
                ((TextView) this.mPassView.findViewById(R.id.f122157d7)).setText(optString);
                this.mWx2QQLayoutPassword.setVisibility(0);
                ((TextView) this.mOtherPayView.findViewById(R.id.f122157d7)).setText(optString);
                this.mWx2QQLayoutFinger.setVisibility(0);
            }
        }
        boolean z18 = optJSONObject2 != null && optJSONObject2.optInt("disable", 0) == 0 && (this.mPayGateObj.optInt("pay_types", 63) & 1) == 1;
        List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(this.mPayGateObj, "bind_banks", "cardtype");
        List<JSONObject> findAllCanUseAutoPay = NetUtil.findAllCanUseAutoPay(this.mPayGateObj);
        QwLog.i("mSelectedPayType = " + this.mSelectedPayType);
        int i26 = this.mSelectedPayType;
        if (i26 == 0) {
            QwLog.i("---\u7528\u6237\u9009\u62e9\u4f59\u989d\u652f\u4ed8\u65b9\u5f0f---");
            if (z18) {
                setPayTypeBalance();
            } else {
                setRetCodeAndGetBundle(-200);
            }
        } else if (i26 == 1) {
            QwLog.i("---\u7528\u6237\u9009\u62e9\u5feb\u6377\u652f\u4ed8\u65b9\u5f0f---");
            QwLog.i("mSelectedPayBankIndex = " + this.mSelectedPayBankIndex);
            QwLog.i("mSelectBankSerial = " + this.mSelectBankSerial);
            if (this.mSelectedPayBankIndex == -1) {
                int i27 = 0;
                i18 = -1;
                while (true) {
                    if (i27 >= findBindedBanks.size()) {
                        break;
                    }
                    JSONObject jSONObject2 = findBindedBanks.get(i27);
                    if (jSONObject2.optInt("disable") == 0) {
                        if (i18 == -1) {
                            i18 = i27;
                        }
                        String str2 = this.mSelectBankSerial;
                        if (str2 != null && str2.equals(jSONObject2.optString("bind_serial"))) {
                            this.mSelectedPayBankIndex = i27;
                            break;
                        }
                    }
                    i27++;
                }
            } else {
                i18 = -1;
            }
            QwLog.i("firstEnableIndex = " + i18);
            if (this.mSelectedPayBankIndex == -1) {
                if (i18 != -1) {
                    this.mSelectedPayBankIndex = i18;
                } else {
                    this.mSelectedPayBankIndex = 0;
                }
            }
            QwLog.i("after adjust, mSelectedPayBankIndex = " + this.mSelectedPayBankIndex);
            QwLog.i("bank size is" + findBindedBanks.size());
            if (this.mSelectedPayBankIndex < findBindedBanks.size() && (i19 = this.mSelectedPayBankIndex) >= 0) {
                JSONObject jSONObject3 = findBindedBanks.get(i19);
                if (jSONObject3.optInt("disable") == 0) {
                    this.mSelectBankObj = jSONObject3;
                    String optString2 = jSONObject3.optString("bank_name");
                    String optString3 = this.mSelectBankObj.optString("card_tail");
                    String optString4 = this.mSelectBankObj.optString("image_id");
                    if (Cgi.CTPAY_BANK_TYPE.equals(this.mSelectBankObj.optString("bank_type"))) {
                        JSONObject jSONObject4 = this.mCtPayParaObj;
                        if (jSONObject4 != null) {
                            String optString5 = jSONObject4.optString("ctpay_text");
                            z17 = true;
                            optString3 = optString5;
                            optString4 = this.mCtPayParaObj.optString("ctpay_image_id");
                        } else {
                            z17 = false;
                        }
                        this.mCtPayRedPointPassWd.setVisibility(8);
                        this.mCtPayRedPointFinger.setVisibility(8);
                    } else {
                        z17 = false;
                    }
                    setPayType(optString2, optString3, optString4, z17);
                    setChangeValidDateFlag();
                } else {
                    if (this.mIsMidas) {
                        setRetCodeAndGetBundle(-200);
                    }
                    finish();
                }
            } else if (this.mIsMidas) {
                setRetCodeAndGetBundle(-200);
                return;
            } else {
                QwLog.i("---HERE");
                finish();
                return;
            }
        } else if (i26 != 3) {
            if (i26 == 4) {
                this.mCtPayRedPointPassWd.setVisibility(8);
                this.mCtPayRedPointFinger.setVisibility(8);
                setPayTypeOpenCtPay();
            } else {
                if (i26 != 5) {
                    SelectedPayChannelBean recommendPayChannel = PayChannelUtils.INSTANCE.getRecommendPayChannel(this.mPayGateObj, null);
                    if (recommendPayChannel == null) {
                        QwLog.i("---\u8001\u7528\u6237\uff0c\u4f46\u6ca1\u7ed1\u5361\uff0c\u5e76\u4f59\u989d\u4e0d\u8db3\u6216\u4e0d\u53ef\u7528---");
                        gotoChangePayType(true, true);
                        return;
                    }
                    if (recommendPayChannel.getPayType() == 0) {
                        setPayTypeBalance();
                    } else if (recommendPayChannel.getPayType() == 5) {
                        this.mSelectAutoPro = findAllCanUseAutoPay.get(recommendPayChannel.getBankIndex());
                        setPayTypeAutoPay();
                        this.mSelectedPayType = 5;
                        this.mSelectedPayBankIndex = recommendPayChannel.getBankIndex();
                    } else if (recommendPayChannel.getPayType() == 1) {
                        getSelectPay(findBindedBanks, recommendPayChannel.getBankIndex());
                    }
                    com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.payload", Integer.valueOf(getProcessType()));
                    z16 = true;
                    if (z16) {
                        dealWithPromotionMechanism(this.mPayGateObj, this.mSelectBankType, false);
                        showPromotionInfo();
                    }
                    i17 = this.mSelectedPayType;
                    if (i17 != 3) {
                        this.isOpenWebank = false;
                        this.mSelectBankObj = findBindedBanks.get(this.mSelectedPayBankIndex);
                        QwLog.i("pay by webank");
                        if (this.mSelectBankObj.optInt("no_passwd") == 1) {
                            QwLog.i("pay by webank no password");
                            this.mWindowStyle = 2;
                            showOtherPayView();
                            return;
                        }
                        showPassPayView();
                        return;
                    }
                    if (i17 == 1 && this.mPayGateObj.optInt("nopwdnosms_flag", 0) == 1) {
                        this.mWindowStyle = 2;
                        showOtherPayView();
                        return;
                    } else if (this.mSelectedPayType == 0 && this.mUserAttr == 3) {
                        this.mWindowStyle = 2;
                        showOtherPayView();
                        return;
                    } else if (this.mWindowStyle == 1) {
                        showOtherPayView();
                        return;
                    } else {
                        showPassPayView();
                        return;
                    }
                }
                int i28 = this.mSelectedPayBankIndex;
                if (i28 >= 0) {
                    this.mSelectAutoPro = findAllCanUseAutoPay.get(i28);
                    setPayTypeAutoPay();
                }
            }
        } else if (this.mSelectedPayBankIndex >= 0) {
            this.webankBalance = getWebankBanlance();
            JSONObject jSONObject5 = findBindedBanks.get(this.mSelectedPayBankIndex);
            this.mSelectBankObj = jSONObject5;
            setPayType(jSONObject5.optString("bank_name"), this.webankBalance, this.mSelectBankObj.optString("image_id"), false);
        }
        z16 = false;
        if (z16) {
        }
        i17 = this.mSelectedPayType;
        if (i17 != 3) {
        }
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
                SoterWrapperApi.init(getContext().getApplicationContext(), new SoterCallback(this), new InitializeParam.InitializeParamBuilder().setGetSupportNetWrapper(new GetSupportSoterNet(getContext(), this.mUin, this.mPayGateObj)).setScenes(Cgi.scene_FingerPay).setDistinguishSalt(this.mUin).setSoterLogger(QwLog4Soter.getInstance()).build());
                return true;
            }
            if (optInt != 1 && optInt != 0 && optInt != 7) {
                if (getFingerPayExceedAmountNoticed() && this.mTouchidState == 4) {
                    return false;
                }
                QUIProxy.createCustomDialog(getContext(), 230, null, this.mTouchidStateInfo, getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.13
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i16) {
                        PayActivity payActivity = PayActivity.this;
                        if (payActivity.mTouchidState == 4) {
                            payActivity.setFingerPayExceedAmountNoticed(true);
                        }
                        PayActivity payActivity2 = PayActivity.this;
                        payActivity2.mWindowStyle = 0;
                        payActivity2.setViewData(payActivity2.mPayGateObj);
                    }
                });
                return true;
            }
        }
        return false;
    }

    protected int getLoadingHeight() {
        if (this.isShowingVerifyCodeView) {
            return this.mVerifyView.getHeight();
        }
        if (this.mWindowStyle == 0) {
            return this.mPassView.getHeight();
        }
        return this.mOtherPayView.getHeight();
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
        JSONObject jSONObject;
        if (this.mIsMidas) {
            return getMidasProcessType();
        }
        if (this.mWindowStyle == 1) {
            return 137;
        }
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag)) {
            return 180;
        }
        if (this.mUserAttr == 3) {
            if (Utils.compareString(this.mTotalFee, this.mBalance + "")) {
                return 20;
            }
            if (this.mPayGateObj.optInt("allow_ban_free_pwd", 0) == 1) {
                return 18;
            }
            return 19;
        }
        int i3 = this.mSelectedPayType;
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 4) {
            return 400;
        }
        if (i3 == 1 && (jSONObject = this.mSelectBankObj) != null && Cgi.CTPAY_BANK_TYPE.equals(jSONObject.optString("bank_type")) && this.mCtPayParaObj != null) {
            return 403;
        }
        if (this.mWindowStyle == 2 && this.mPayGateObj.optInt("nopwdnosms_flag") == 1) {
            return 12;
        }
        if (!this.mVerifyView.isShown()) {
            return 2;
        }
        if (this.mChangePhoneNum.booleanValue()) {
            return 16;
        }
        if (!this.mChangeValidDate.booleanValue()) {
            return 3;
        }
        return 15;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void go2PWDAuth() {
        QwLog.i("go2 PWDAuth...");
        releaseFp();
        showPassPayView();
        com.tencent.mobileqq.qwallet.c.c("fingerprint.number-exceed-error.go", Integer.valueOf(getProcessType()));
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void goneViewForPaySuccess() {
        this.mOtherPayView.setVisibility(4);
        this.mPassView.setVisibility(4);
        this.mVerifyView.setVisibility(4);
        this.mPayHeadLayout.setVisibility(4);
        if (this.mWindowStyle == 0) {
            this.mKeyboard.setVisibility(8);
        } else if (this.isShowingVerifyCodeView) {
            this.mVerifyKeyboard.setVisibility(8);
        }
    }

    protected void gotoChangePayType(boolean z16, boolean z17) {
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_REVERT_TO_OLD_PAY_CHANNEL, false)) {
            gotoOldChangePayType(z16, z17);
        } else {
            gotoNewChangePayType(z16, z17);
        }
    }

    protected void gotoNewChangePayType(final boolean z16, boolean z17) {
        if (this.normalPasswdLayout.getVisibility() == 0) {
            ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.mNormalPasswdEdit.getWindowToken(), 0);
        }
        Bundle bundle = new Bundle();
        bundle.putInt(ChoosePayTypeFragment.KEY_SELECTED_PAY_TYPE, this.mSelectedPayType);
        bundle.putInt(ChoosePayTypeFragment.KEY_SELECTED_PAY_INDEX, this.mSelectedPayBankIndex);
        bundle.putString("qpay_gate", this.mPayGateObj.toString());
        bundle.putInt(ChoosePayTypeFragment.KEY_FIREND_PAY_FROM, this.iPayFrom);
        bundle.putString(ChoosePayTypeFragment.KEY_FIREND_PAY_TOKEN_ID, this.mPayTokenId);
        bundle.putInt(ChoosePayTypeFragment.KEY_FIREND_PROCESS_FLAG, getProcessType());
        if (1 == this.mWindowStyle) {
            bundle.putBoolean(FROM_FINGER_PAY, true);
            if (this.mIsActiveToChangePayType) {
                bundle.putInt(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 137);
            } else {
                bundle.putInt(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 138);
            }
        } else {
            bundle.putInt(ChoosePayTypeFragment.KEY_PROCESS_TYPE, getProcessType());
        }
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(ChoosePayTypeFragment.TAG);
        final ChoosePayTypeFragment choosePayTypeFragment = null;
        if (findFragmentByTag instanceof ChoosePayTypeFragment) {
            ChoosePayTypeFragment choosePayTypeFragment2 = (ChoosePayTypeFragment) findFragmentByTag;
            if (choosePayTypeFragment2.isVisible()) {
                choosePayTypeFragment2.renderView(this.mPayGateObj);
                choosePayTypeFragment = choosePayTypeFragment2;
            } else {
                choosePayTypeFragment2.dismissAllowingStateLoss();
                QLog.w(((NetBaseActivity) this).TAG, 1, "choosePayTypeFragment is invalid, dismiss it!");
            }
        }
        if (choosePayTypeFragment == null) {
            choosePayTypeFragment = new ChoosePayTypeFragment();
            choosePayTypeFragment.setArguments(bundle);
            choosePayTypeFragment.show(supportFragmentManager, ChoosePayTypeFragment.TAG);
        }
        choosePayTypeFragment.getParentFragmentManager().clearFragmentResult("select_hb_channel_finish");
        choosePayTypeFragment.getParentFragmentManager().setFragmentResultListener("select_hb_channel_finish", getViewLifecycleOwner(), new FragmentResultListener() { // from class: com.tenpay.sdk.activity.cs
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                PayActivity.this.lambda$gotoNewChangePayType$14(choosePayTypeFragment, z16, str, bundle2);
            }
        });
        playHideAnimation();
    }

    protected void gotoOldChangePayType(boolean z16, boolean z17) {
        if (this.normalPasswdLayout.getVisibility() == 0) {
            ((InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.mNormalPasswdEdit.getWindowToken(), 0);
        }
        Intent intent = new Intent();
        intent.putExtra("isFriendPay", this.isFriendPay);
        intent.putExtra("pay_gate", this.mPayGateObj.toString());
        intent.putExtra("promotion_bank_show", this.mPromotionBankShow);
        intent.putExtra("isInner", this.isInner);
        intent.putExtra("iPayFrom", this.iPayFrom);
        if (z16) {
            intent.putExtra("need_callback", true);
            JSONArray jSONArray = this.commPromoArr;
            if (jSONArray != null) {
                intent.putExtra("comm_promotion", jSONArray.toString());
            }
        }
        if (z17) {
            intent.putExtra("yue_limited", true);
        }
        if (1 == this.mWindowStyle) {
            intent.putExtra(FROM_FINGER_PAY, true);
            if (this.mIsActiveToChangePayType) {
                intent.putExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 137);
            } else {
                intent.putExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 138);
            }
        } else {
            intent.putExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, getProcessType());
        }
        intent.putExtra("trustpay_open_flag", this.mTrustPayOpen);
        this.mPayGateObj.optJSONArray("bind_banks").length();
        try {
            this.mPayGateObj.optJSONObject("ctpay_param").optInt("bind_state");
        } catch (Exception unused) {
            QwLog.i("exception error : " + this.mPayGateObj);
        }
        intent.putExtra("selected_pay_by", this.mSelectedPayType);
        intent.putExtra("selected_pay_bank_index", this.mSelectedPayBankIndex);
        intent.putExtra("disableBankInfos", this.mDisableBankMap);
        if (z16 && getIntent() != null) {
            Bundle bundle = new Bundle();
            bundle.putAll(getIntent().getExtras());
            intent.putExtra(KEY_RESTART_BUNDLE, bundle);
        }
        startActivityForResult(intent, ChoosePayTypeActivity.class, new IResult() { // from class: com.tenpay.sdk.activity.PayActivity.3
            @Override // com.tenpay.sdk.IResult
            public void back(int i3, Intent intent2) {
                QwLog.i("onResult, retCode = " + i3);
                if (i3 == -1) {
                    String stringExtra = intent2.getStringExtra("bind_serial");
                    QwLog.i("onResult, data = " + intent2.getExtras().toString());
                    if (!TextUtils.isEmpty(stringExtra)) {
                        PayActivity payActivity = PayActivity.this;
                        payActivity.mSelectedPayType = 1;
                        payActivity.mSelectBankSerial = stringExtra;
                        payActivity.reloadBindBanks();
                        return;
                    }
                    PayActivity payActivity2 = PayActivity.this;
                    if (payActivity2.mCtPayGuideDlg != null) {
                        payActivity2.mCtPayGuideDlg = null;
                    }
                    payActivity2.mAnimLayout.setVisibility(0);
                    PayActivity.this.mSelectedPayType = intent2.getIntExtra("pay_by", -1);
                    PayActivity.this.mSelectedPayBankIndex = intent2.getIntExtra("bank_index", -1);
                    PayActivity.this.mIsActiveToChangePayType = false;
                    PayActivity.this.mSelectBankType = intent2.getStringExtra("bank_type");
                    PayActivity payActivity3 = PayActivity.this;
                    payActivity3.dealWithPromotionMechanism(payActivity3.mPayGateObj, payActivity3.mSelectBankType, false);
                    String stringExtra2 = intent2.getStringExtra("pay_gate");
                    try {
                        PayActivity.this.goneVerfyView();
                        PayActivity payActivity4 = PayActivity.this;
                        payActivity4.mPassAnimDuration = 150;
                        JSONObject jSONObject = new JSONObject(stringExtra2);
                        PayActivity payActivity5 = PayActivity.this;
                        payActivity4.fillViewWithData(jSONObject, payActivity5.mSelectedPayType, payActivity5.mSelectedPayBankIndex);
                        PayActivity.this.isNeedRestartFingerPay = false;
                        return;
                    } catch (Exception e16) {
                        QLog.e(((NetBaseActivity) PayActivity.this).TAG, 1, "", e16);
                        return;
                    }
                }
                if (i3 == 0) {
                    PayActivity payActivity6 = PayActivity.this;
                    Dialog dialog = payActivity6.mCtPayGuideDlg;
                    if (dialog == null) {
                        payActivity6.goneVerfyView();
                        if (PayActivity.this.needShowRedPoint()) {
                            PayActivity.this.mCtPayRedPointFinger.setVisibility(0);
                            PayActivity.this.mCtPayRedPointPassWd.setVisibility(0);
                        } else {
                            PayActivity.this.mCtPayRedPointFinger.setVisibility(8);
                            PayActivity.this.mCtPayRedPointPassWd.setVisibility(8);
                        }
                        PayActivity.this.playAnimInFromChoosePayTypeActivity();
                        PayActivity.this.mIsActiveToChangePayType = false;
                        PayActivity.this.isNeedRestartFingerPay = true;
                        return;
                    }
                    dialog.show();
                }
            }
        });
        if (!z16) {
            getActivity().overridePendingTransition(R.anim.f154877er, 0);
            playHideAnimation();
        } else {
            Intent intent2 = new Intent();
            intent2.putExtra(KEY_IS_NO_CARD_TYPE, true);
            setResult(0, intent2);
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void initValue(Intent intent) {
        super.initValue(intent);
        this.mPayInfo = (PayInfo) intent.getParcelableExtra(PayInfo.class.getName());
    }

    protected void initView(View view) {
        this.mRootView = (RelativeLayout) view.findViewById(R.id.root_layout);
        this.mOtherPayView = (LinearLayout) view.findViewById(R.id.f166474fg0);
        this.mPassView = (LinearLayout) view.findViewById(R.id.fio);
        this.mPayHeadLayout = (LinearLayout) view.findViewById(R.id.fjg);
        this.mVerifyView = (LinearLayout) view.findViewById(R.id.knd);
        this.mAnimLayout = (RelativeLayout) view.findViewById(R.id.f164327rz);
        this.mTitleTxt = (TextView) view.findViewById(R.id.fjh);
        TextView textView = (TextView) view.findViewById(R.id.f30560oo);
        this.mTitleRightTxt = textView;
        textView.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.b7s);
        this.confirmPayBtn = button;
        button.setOnClickListener(this);
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mKeyboard = myKeyboardWindow;
        myKeyboardWindow.setXMode(0);
        this.normalPasswdLayout = (LinearLayout) view.findViewById(R.id.faj);
        Button button2 = (Button) view.findViewById(R.id.fah);
        this.mPayConfirmBtn = button2;
        button2.setOnClickListener(this);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.az7);
        this.mCloseBtn = imageButton;
        imageButton.setOnClickListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.a47);
        this.backBtn = imageView;
        imageView.setOnClickListener(this);
        this.vipSkinHeader = (ImageView) view.findViewById(R.id.f167114kz2);
        this.mProductTxt = (TextView) view.findViewById(R.id.title_txt);
        this.mPriceTxt = (TextView) view.findViewById(R.id.f166540fz1);
        Typeface c16 = com.qwallet.utils.QWalletUtils.c(getContext());
        if (c16 != null) {
            this.mPriceTxt.setTypeface(c16);
        }
        this.mPriceCutTxt = (TextView) view.findViewById(R.id.fyz);
        this.mPriceLayout = (RelativeLayout) view.findViewById(R.id.f166539fz0);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fyy);
        this.mPriceCutLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.fyx);
        this.mPriceCutArrow = imageView2;
        imageView2.setVisibility(8);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        initSixPasswdEdit(view);
        this.mFingerErrorTips = (TextView) view.findViewById(R.id.caq);
        this.mVerifyKeyboard = (MyKeyboardWindow) view.findViewById(R.id.kn7);
        this.mVerifyMobileTxt = (TextView) view.findViewById(R.id.fmv);
        initVerifyCodeEdit(view);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.bcd);
        this.mCtPayHelpImg = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.co
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PayActivity.this.lambda$initView$0(view2);
            }
        });
        Button button3 = (Button) view.findViewById(R.id.i8e);
        this.mVerifyResendBtn = button3;
        button3.setOnClickListener(this);
        Button button4 = (Button) view.findViewById(R.id.change_phone_num_btn);
        this.mChangePhoneNumBtn = button4;
        button4.setOnClickListener(this);
        this.mChangePhoneNumBtn.setEnabled(true);
        this.mChangePhoneNumBtn.setClickable(true);
        this.mChangePhoneNumBtn.setVisibility(8);
        Button button5 = (Button) view.findViewById(R.id.f_x);
        this.mNoPassBtn = button5;
        button5.setOnClickListener(this);
        this.mCtPayRedPointPassWd = (ImageView) this.mPassView.findViewById(R.id.bcf);
        this.mCtPayRedPointFinger = (ImageView) this.mOtherPayView.findViewById(R.id.bcf);
        this.mChangePayBankTxtPassWd = (TextView) this.mPassView.findViewById(R.id.at5);
        this.mChangePayBankTxtFinger = (TextView) this.mOtherPayView.findViewById(R.id.at5);
        this.mChangePayBankTailPassWd = (TextView) this.mPassView.findViewById(R.id.f164766at4);
        this.mChangePayBankTailFinger = (TextView) this.mOtherPayView.findViewById(R.id.f164766at4);
        LinearLayout linearLayout = (LinearLayout) this.mPassView.findViewById(R.id.ggt);
        this.mChangePayTypeBtnPassWd = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.mOtherPayView.findViewById(R.id.ggt);
        this.mChangePayTypeBtnFinger = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.mChangePayBankIconPassWd = (ImageView) this.mPassView.findViewById(R.id.ggs);
        this.mChangePayBankIconFinger = (ImageView) this.mOtherPayView.findViewById(R.id.ggs);
        LinearLayout linearLayout3 = (LinearLayout) this.mPassView.findViewById(R.id.f30580oq);
        this.mWx2QQLayoutPassword = linearLayout3;
        linearLayout3.setVisibility(8);
        this.mWx2QQLayoutPassword.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) this.mOtherPayView.findViewById(R.id.f30580oq);
        this.mWx2QQLayoutFinger = linearLayout4;
        linearLayout4.setVisibility(8);
        this.mWx2QQLayoutFinger.setOnClickListener(this);
    }

    protected boolean isGotoBusinessPayActivity() {
        String str;
        JSONObject jSONObject = this.busi_switch;
        if (jSONObject != null) {
            str = jSONObject.optString(HiAnalyticsConstant.BI_KEY_SDK_VER);
        } else {
            str = "V1";
        }
        if ("business".equals(this.pay_scene) && "V2".equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("pay_gate", this.mPayGateObj.toString());
            launchFragment(intent, BusinessPayActivity.class);
            finish();
            return true;
        }
        return false;
    }

    protected boolean isGotoFriendPay() {
        JSONObject jSONObject = this.busi_switch;
        if (jSONObject == null) {
            return false;
        }
        this.direct_pfa = jSONObject.optInt("direct_pfa", 0);
        QwLog.i("direct_pfa = " + this.direct_pfa);
        if (this.direct_pfa == 0) {
            return false;
        }
        gotoFriendChoose();
        return true;
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
            if (i3 == BasePayActivity.OpenCTPay_RESULT_CODE) {
                if (this.mCtPayGuideDlg != null) {
                    this.mCtPayGuideDlg = null;
                }
                this.mAnimLayout.setVisibility(0);
                if (this.mWindowStyle == 0) {
                    this.mRootView.setVisibility(0);
                    if (this.mPassFlag.equals("2")) {
                        this.mKeyboard.setVisibility(0);
                    } else {
                        this.mKeyboard.setVisibility(8);
                    }
                }
                this.mSelectedPayType = 4;
                this.mSelectedPayBankIndex = -1;
                this.mIsActiveToChangePayType = false;
                fillViewWithData(this.mPayGateObj, 4, -1);
                return;
            }
            if (i3 == BasePayActivity.ShiMing_RESULT_CODE) {
                if (this.mPayGateRequest == null) {
                    finish();
                    return;
                } else {
                    sendPayGateRequest();
                    return;
                }
            }
            if (i3 == BasePayActivity.ResetPass_RESULT_CODE) {
                this.mPassFlag = "2";
                showPassPayView();
                uploadData("pwd.reset.success");
                return;
            } else {
                if (i3 == BasePayActivity.CHOOSE_PRICECUT_RESULT_CODE) {
                    if (this.mWindowStyle == 0) {
                        this.mPassView.setVisibility(0);
                    } else {
                        this.mOtherPayView.setVisibility(0);
                    }
                    dealWithPromoTxtShow(intent);
                    return;
                }
                if (i3 == BasePayActivity.REQUEST_CODE_BIND_BANK) {
                    onBindCardSuccess(i16, intent);
                    return;
                }
                return;
            }
        }
        if (i16 == 0) {
            if (1 == this.direct_pfa) {
                finish();
                return;
            }
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
            }
            if (i3 == BasePayActivity.OpenCTPay_RESULT_CODE) {
                playAnimInFromChoosePayTypeActivity();
                Dialog dialog = this.mCtPayGuideDlg;
                if (dialog != null) {
                    dialog.show();
                    return;
                }
                return;
            }
            if (i3 != BasePayActivity.ResetPass_RESULT_CODE && i3 != BasePayActivity.ResetPassBridge_RESULT_CODE) {
                if (i3 == BasePayActivity.CHOOSE_PRICECUT_RESULT_CODE) {
                    if (this.mWindowStyle == 0) {
                        this.mPassView.setVisibility(0);
                        return;
                    } else {
                        this.mOtherPayView.setVisibility(0);
                        return;
                    }
                }
                return;
            }
            resetPassUI();
            return;
        }
        if (i16 == OPEN_WEBANK_RESULT_CODE) {
            this.isOpenWebank = true;
            reloadBindBanks();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        DisableBankInfo createByRetUrl;
        String str2;
        String str3;
        JSONObject jSONObject2;
        super.onBlError(str, jSONObject);
        final String optString = jSONObject.optString("retcode");
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
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            retCodeAndGetBundle.putString("retmsg", jSONObject3.toString());
            TenUtils.notifyToExit(getContext(), this.mProssesID);
            return;
        }
        if (str.equals(Cgi.URI_TRANSFER_PAY_CONFIRM) && (jSONObject2 = this.mPaySuccessObj) != null) {
            gotoPaySuccess(jSONObject2, str);
        }
        if (ErrorCode.ERR_PAY_IVR.equals(optString)) {
            uploadData("pay.hold-up.show");
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e2i), getString(R.string.e2l), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uin", PayActivity.this.mUin);
                    hashMap.put("token_id", PayActivity.this.mPayTokenId);
                    PayActivity.this.httpRequest(Cgi.URI_CODE_IVR_CONFIRM, hashMap);
                    com.tencent.mobileqq.qwallet.c.c("pay.hold-up.go", Integer.valueOf(PayActivity.this.getProcessType()));
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    com.tencent.mobileqq.qwallet.c.c("pay.hold-up.cancel", Integer.valueOf(PayActivity.this.getProcessType()));
                }
            });
            return;
        }
        if (ErrorCode.ERR_SHIMING.equals(optString)) {
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e2i), getString(R.string.f171344e80), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    com.tencent.mobileqq.qwallet.c.c("condition.error.go", Integer.valueOf(PayActivity.this.getProcessType()));
                    Intent intent = new Intent();
                    intent.putExtra("IsShiMing", true);
                    BindBankModule.INSTANCE.startVerifyForResult(PayActivity.this, intent, BasePayActivity.ShiMing_RESULT_CODE);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    PayActivity payActivity = PayActivity.this;
                    if (!payActivity.mIsMidas) {
                        com.tencent.mobileqq.qwallet.c.c("condition.error.close", Integer.valueOf(payActivity.getProcessType()));
                    }
                    dialogInterface.dismiss();
                }
            });
            uploadData("condition.error.show");
            return;
        }
        if (ErrorCode.ERR_YDT_CREDITCARD_EXPIRE.equals(optString)) {
            QUIProxy.createCustomDialog(getContext(), 230, null, optString2, "\u53d6\u6d88", "\u66f4\u65b0\u6709\u6548\u671f", new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    PayActivity.this.go2ChangeValidDateActivity();
                    com.tencent.mobileqq.qwallet.c.c("creditdatechange.error.change", 15);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    com.tencent.mobileqq.qwallet.c.c("creditdatechange.error.cancel", 15);
                }
            });
            com.tencent.mobileqq.qwallet.c.c("creditdatechange.error.show", 15);
            return;
        }
        if (!ErrorCode.ERR_GUIDE_TO_CTPAY_FOR_NOT_CTUSER.equals(optString) && !ErrorCode.ERR_GUIDE_TO_CTPAY_FOR_CTUSER.equals(optString)) {
            if (this.isFriendPay && "SUCCESS".equals(jSONObject.optString("trade_state"))) {
                setResult(-1);
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
                        this.mPayConfirmBtn.setClickable(false);
                        this.mPayConfirmBtn.setEnabled(false);
                    } else {
                        this.mNormalPasswdEdit.setText("");
                        this.mNormalPasswdEdit.requestFocus();
                    }
                }
            } else {
                this.mVerifyCodeEdit.setText("");
                this.mVerifyCodeEdit.requestFocus();
            }
            JSONObject jSONObject4 = this.mPayGateObj;
            if (jSONObject4 != null && jSONObject4.optInt("nopwdnosms_flag") == 1) {
                this.mPayConfirmBtn.setEnabled(true);
                this.mPayConfirmBtn.setClickable(true);
            }
            if (Cgi.URI_FAST_PREPAY.equals(str)) {
                String optString3 = jSONObject.optString("returl");
                if (TextUtils.isEmpty(optString3)) {
                    return;
                }
                try {
                    Uri parse = Uri.parse(optString3);
                    if ("changeSelectCard".equals(parse.getHost()) && (createByRetUrl = DisableBankInfo.INSTANCE.createByRetUrl(parse)) != null) {
                        this.mDisableBankMap.put(createByRetUrl.getSerial(), createByRetUrl);
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, e17, new Object[0]);
                    return;
                }
            }
            return;
        }
        this.mCtPayGuideDlg = QUIProxy.createVerticalThreeBtnDialog(getContext(), 0, null, optString2, getString(R.string.e4x), getString(R.string.e3w), getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                boolean z16 = true;
                if (ErrorCode.ERR_GUIDE_TO_CTPAY_FOR_NOT_CTUSER.equals(optString)) {
                    PayActivity.this.uploadData("creditpay.errorlead.go", 401);
                    PayActivity.this.mAnimLayout.setVisibility(0);
                    Intent intent = new Intent();
                    PayActivity.this.launchFragmentForResult(intent, CreditPayGuideActivity.class, BasePayActivity.OpenCTPay_RESULT_CODE);
                    PayActivity.this.getActivity().overridePendingTransition(R.anim.f154877er, 0);
                    intent.putExtra("from_pay_err_dlg", true);
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(PayActivity.this.mAnimLayout, "translationY", -Utils.dp2Px(PayActivity.this.getContext(), 399.0f));
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                    return;
                }
                Dialog dialog = PayActivity.this.mCtPayGuideDlg;
                if (dialog != null && dialog.isShowing()) {
                    PayActivity.this.mCtPayGuideDlg.dismiss();
                    PayActivity.this.mCtPayGuideDlg = null;
                }
                PayActivity.this.mAnimLayout.setVisibility(0);
                JSONObject jSONObject5 = PayActivity.this.mPayGateObj;
                if (jSONObject5 != null) {
                    List<JSONObject> findBindedBanks = NetUtil.findBindedBanks(jSONObject5, "bind_banks", "cardtype");
                    int i16 = 0;
                    while (true) {
                        if (i16 < findBindedBanks.size()) {
                            if (Cgi.CTPAY_BANK_TYPE.equals(findBindedBanks.get(i16).optString("bank_type"))) {
                                PayActivity payActivity = PayActivity.this;
                                payActivity.mSelectedPayType = 1;
                                payActivity.mSelectedPayBankIndex = i16;
                                break;
                            }
                            i16++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (z16) {
                        PayActivity payActivity2 = PayActivity.this;
                        if (payActivity2.mCtPayParaObj != null) {
                            payActivity2.fillViewWithData(payActivity2.mPayGateObj, payActivity2.mSelectedPayType, payActivity2.mSelectedPayBankIndex);
                        }
                    }
                }
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PayActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                PayActivity.this.uploadData("creditpay.errorlead.change", 401);
                PayActivity.this.gotoChangePayType(false, false);
            }
        });
        if (this.mWindowStyle == 0) {
            if (this.mIsSixPasswdUser) {
                this.mSixPasswdEdit.setInputText("");
            } else {
                this.mNormalPasswdEdit.setText("");
            }
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        if (i3 == 0) {
            if (fakeInfo.reqUrl.equals(Cgi.URI_BALANCE_GET_CODE) || fakeInfo.reqUrl.equals(Cgi.URI_FAST_PREPAY) || fakeInfo.reqUrl.equals(Cgi.URL_FRIEND_QPAY_SPFA_PAY)) {
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
            this.mJumpFromFakeLeft = true;
        }
        return super.onBlHandleFakeurl(fakeInfo, i3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (isValidClick(id5)) {
            if (id5 != R.id.fah && id5 != R.id.f_x) {
                if (id5 == R.id.fjf) {
                    Intent intent = new Intent();
                    intent.putExtra("token_id", this.mPayTokenId);
                    intent.putExtra("forget_pass", true);
                    intent.putExtra("pass_flag", this.mPayGateObj.optInt("pass_flag"));
                    launchFragmentForResult(intent, ResetPassBridgeActivity.class, BasePayActivity.ResetPass_RESULT_CODE);
                    uploadData("smallpay.pwd.forgot");
                } else if (id5 == R.id.kkq) {
                    go2PWDAuth();
                    uploadData("fingerprint.confirm.pwd");
                } else if (id5 != R.id.a47 && id5 != R.id.az7) {
                    if (id5 != this.mChangePayTypeBtnFinger.getId() && id5 != this.mChangePayTypeBtnPassWd.getId()) {
                        if (id5 == R.id.i8e) {
                            this.mIsReentry = Boolean.TRUE;
                            pay();
                            uploadData("smallpay.sms.reacquire");
                        } else if (id5 != R.id.iwz && id5 != R.id.knc) {
                            if (id5 == R.id.change_phone_num_btn) {
                                go2ChangePhoneNumActivity();
                                uploadData("smallpay.sms.change");
                            } else if (id5 == R.id.fyy) {
                                gotoChoosePriceCutActivity();
                            } else if (id5 == R.id.f30560oo) {
                                int i3 = this.mWindowStyle;
                                if (i3 == 0) {
                                    this.mWindowStyle = 1;
                                    showOtherPayView();
                                } else if (i3 == 1) {
                                    showPassPayView();
                                }
                            } else if (id5 == R.id.f30580oq) {
                                com.tencent.mobileqq.qwallet.utils.k.h(getContext(), this.mWx2QQUrl);
                            } else if (id5 == R.id.b7s) {
                                if (SoterWrapperApi.isSupportSoter() && this.mSoterBiometricCanceller == null) {
                                    QwLog.i("\u8c03\u7528\u5fae\u4fe1SDK\u5f00\u542f\u6307\u7eb9\u670d\u52a1");
                                    startFingerprintAuthentication();
                                }
                                uploadData("fingerprint.confirm.go");
                            }
                        } else if (!this.mKeyboard.isShown()) {
                            this.mKeyboard.setVisibility(0);
                        }
                    } else {
                        if (this.mIsMidas) {
                            if (this.mSelectedPayType == 0) {
                                TenpayUtil.addMidasUploadData(getProcessType(), "tenpay.yue.change");
                            } else {
                                TenpayUtil.addMidasUploadData(getProcessType(), "tenpay.kj.change");
                            }
                        } else if (this.mWindowStyle == 1) {
                            uploadData("fingerprint.confirm.change-payment");
                        } else {
                            uploadData("smallpay.pwd.change");
                        }
                        if (this.mIsMidas) {
                            setRetCodeAndGetBundle(-200);
                        } else {
                            this.mIsActiveToChangePayType = true;
                            gotoChangePayType(false, false);
                        }
                    }
                } else {
                    back();
                }
            } else {
                pay();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(19);
        getWindow().addFlags(8192);
        this.mEnterType = Cgi.ENTER_FROM_PAY;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.aff, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QwLog.i(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        closeTime(this.mVerifyResendBtn);
        this.mWechatPayHelper.release();
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onFingerAuthenticationSucceed() {
        TextView textView = this.mFingerErrorTips;
        if (textView != null) {
            textView.setText(R.string.f171338e64);
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onFingerLocked() {
        if (!isFinishing()) {
            go2PWDAuth();
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        if (ErrorCode.ERR_PAY_NOT_ENOUGH.equals(optString)) {
            if (this.mIsMidas) {
                setRetCodeAndGetBundle(-200);
            } else {
                gotoChangePayType(false, false);
            }
        }
        if ((str.equals(Cgi.URI_BALANCE_GET_CODE) || str.equals(Cgi.URI_FAST_PREPAY) || str.equals(Cgi.URL_FRIEND_QPAY_SPFA_PAY)) && ErrorCode.ERR_WRONG_PASSWORD.equals(optString)) {
            playAnimForPasswordView(1);
        }
        if (Cgi.URI_PAY_GATE.equals(str) && !QWalletFakeUrl.hasQWalletFakeProtocal(jSONObject)) {
            finish();
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
            return;
        }
        boolean b16 = com.tencent.mobileqq.qwallet.utils.g.b("qwallet_bindcard_refresh");
        if (this.mJumpFromFakeLeft && b16) {
            this.mSelectedPayType = -1;
            sendPayGateRequest();
            this.mJumpFromFakeLeft = false;
            com.tencent.mobileqq.qwallet.utils.g.s("qwallet_bindcard_refresh");
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void onStartFingerAuthentication() {
        TextView textView = this.mFingerErrorTips;
        if (textView != null) {
            textView.setText(R.string.e6i);
            this.mFingerErrorTips.setTextColor(Color.parseColor("#E8A741"));
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        String str2;
        String str3;
        if (getContext() == null) {
            return;
        }
        getWindow().getDecorView().post(new Runnable() { // from class: com.tenpay.sdk.activity.cd
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.dismissQQPayLoading();
            }
        });
        onNetLogicPros(str, jSONObject);
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
            logBankInfo(jSONObject);
            this.mPayGateObj = jSONObject;
            if (TextUtils.isEmpty(this.mPayTokenId)) {
                this.mPayTokenId = jSONObject.optString("token_id");
            }
            initPayGateData();
            if (isGotoFriendPay()) {
                return;
            }
            if (this.mPayGateObj.optJSONObject("trustpay_param") != null) {
                Intent intent = new Intent();
                intent.putExtra("pay_gate", this.mPayGateObj.toString());
                launchFragment(intent, ConfirmTransactionActivity.class);
                finish();
                return;
            }
            JSONObject optJSONObject = this.mPayGateObj.optJSONObject("dynamic_qrcode_info");
            if (optJSONObject != null) {
                Intent intent2 = new Intent();
                intent2.putExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA, getIntent().getBundleExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA));
                intent2.putExtra("dynamic_qrcode_info", optJSONObject.toString());
                launchFragment(intent2, QrcodeOverPayActivity.class);
                finish();
                return;
            }
            isWebank(this.mPayGateObj);
            QwLog.i("onblcallback isOpenWebank=" + this.isOpenWebank);
            if (this.isOpenWebank) {
                boolean openWebankSuccOrNot = openWebankSuccOrNot();
                QwLog.i("onblcallback isSucc=" + openWebankSuccOrNot);
                if (!openWebankSuccOrNot) {
                    this.mSelectedPayType = -1;
                    this.mSelectedPayBankIndex = -1;
                }
            }
            this.mCtPayParaObj = this.mPayGateObj.optJSONObject("ctpay_param");
            afterPayGatePromotionLogic();
            if (this.mIsMidas) {
                setRetCodeAndGetBundle(-300);
            }
            if (this.mSelectedPayType == 2) {
                Intent intent3 = new Intent();
                intent3.putExtra("token_id", this.mPayTokenId);
                intent3.putExtra("trustpay_open_flag", this.mTrustPayOpen);
                BindBankModule.INSTANCE.startVerify(this, intent3);
                finish();
                return;
            }
            if (isGotoBusinessPayActivity()) {
                return;
            }
            boolean fingerPayStatus = getFingerPayStatus();
            this.mFingerStatus = fingerPayStatus;
            if (fingerPayStatus) {
                return;
            }
            setViewData(this.mPayGateObj);
            return;
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
                this.mPayType = getString(R.string.eax);
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

    @Override // com.tenpay.sdk.activity.BasePayActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        resetLayout();
        this.mAnimLayout.setVisibility(8);
        checkFP();
        this.mWindowStyle = loadSavedWindowStyle();
        Intent intent = getIntent();
        initValue(intent);
        String stringExtra = intent.getStringExtra("pay_gate");
        if (TextUtils.isEmpty(stringExtra)) {
            sendPayGateRequest();
            return;
        }
        try {
            this.mPayGateObj = new JSONObject(stringExtra);
            initPayGateData();
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            finish();
        }
        if (isGotoBusinessPayActivity()) {
            return;
        }
        this.mCtPayParaObj = this.mPayGateObj.optJSONObject("ctpay_param");
        boolean fingerPayStatus = getFingerPayStatus();
        this.mFingerStatus = fingerPayStatus;
        if (!fingerPayStatus) {
            afterPayGatePromotionLogic();
            setViewData(this.mPayGateObj);
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void pay() {
        int i3 = this.mSelectedPayType;
        if (i3 == 0) {
            QwLog.i("---\u53d1\u8d77\u4f59\u989d\u652f\u4ed8---");
            this.mPayType = getString(R.string.eay);
            sendBalancePay(0);
            return;
        }
        if (i3 == 5) {
            goAutoPay();
            return;
        }
        if (i3 == 4) {
            QwLog.i("---\u53d1\u8d77\u4fe1\u7528\u652f\u4ed8---");
            this.mPayType = getString(R.string.eax);
            sendCtPayAuthen();
            return;
        }
        if (i3 == 1) {
            QwLog.i("---\u53d1\u8d77\u5feb\u6377\u652f\u4ed8---" + this.mSelectBankObj);
            JSONObject jSONObject = this.mSelectBankObj;
            if (jSONObject != null) {
                if (Cgi.CTPAY_BANK_TYPE.equals(jSONObject.optString("bank_type"))) {
                    this.mPayType = getString(R.string.eax);
                } else {
                    String optString = this.mSelectBankObj.optString("bank_name");
                    String optString2 = this.mSelectBankObj.optString("card_tail");
                    if (!TextUtils.isEmpty(optString2)) {
                        optString = optString + "(\u5c3e\u53f7" + optString2 + ")";
                    }
                    this.mPayType = optString;
                }
                String optString3 = this.mSelectBankObj.optString(DefaultTVKDataProvider.KEY_PAY_TYPE);
                HashMap hashMap = new HashMap();
                hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
                hashMap.put("token_id", this.mPayTokenId);
                hashMap.put("p", getPasswd());
                hashMap.put("bank_type", this.mSelectBankObj.optString("bank_type"));
                hashMap.put("timestamp", this.mTimestamp + "");
                if (isWxPay()) {
                    hashMap.put("route_version", "wx");
                }
                if (this.mIsReentry.booleanValue()) {
                    this.mIsReentry = Boolean.FALSE;
                    hashMap.put("is_reentry", "1");
                } else {
                    hashMap.put("is_reentry", "0");
                }
                if (this.mChangeValidDate.booleanValue()) {
                    hashMap.put("newcthru", this.mValidDate);
                    String str = this.mValidDateCVV;
                    if (str != null && !TextUtils.isEmpty(str)) {
                        hashMap.put("newcvv", this.mValidDateCVV);
                    }
                }
                if (this.mChangePhoneNum.booleanValue()) {
                    hashMap.put("newmobile", this.mNewPhoneNum);
                    String str2 = this.mPhoneNumCVV;
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        hashMap.put("newcvv", this.mPhoneNumCVV);
                    }
                }
                if (this.mPayGateObj.optInt("nopwdnosms_flag") == 1 && this.mWindowStyle == 2) {
                    hashMap.put("nopwdnosms_flag", "1");
                    hashMap.put("purchaser_id", this.mUin);
                } else {
                    hashMap.put("nopwdnosms_flag", "0");
                }
                String optString4 = this.mSelectBankObj.optString("bind_serial");
                if (!TextUtils.isEmpty(optString4)) {
                    hashMap.put("bind_serial", optString4);
                }
                hashMap.put("trustpay_open_flag", this.mTrustPayOpen);
                fingerParamFill(hashMap);
                QwLog.i("pay_type = " + optString3);
                if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
                    hashMap.put("promotion_id", this.mPromotionId);
                    hashMap.put("promotion_fee", this.mPromotionFee);
                    hashMap.put("promotion_type", this.mPromotionType);
                }
                if (NetParams.FAST_CARD.equals(optString3)) {
                    this.mCurrentTime = System.currentTimeMillis();
                    hashMap.put("verify_flag", "2");
                    httpRequestWithQQPayLoading(Cgi.URI_FAST_PREPAY, hashMap, getLoadingHeight());
                }
            }
        }
    }

    protected void pay_excute() {
        JSONObject jSONObject;
        int i3 = this.mSelectedPayType;
        if (i3 == 0) {
            sendBalancePay(1);
            this.mPayType = getString(R.string.eay);
            return;
        }
        if (i3 == 4) {
            this.mPayType = getString(R.string.eax);
            sendCtPayVerify();
            return;
        }
        if (i3 == 1 && (jSONObject = this.mSelectBankObj) != null) {
            String optString = jSONObject.optString("bank_name");
            String optString2 = this.mSelectBankObj.optString("card_tail");
            if (!Utils.isEmpty(optString2)) {
                optString = optString + "(\u5c3e\u53f7" + optString2 + ")";
            }
            this.mPayType = optString;
            String optString3 = this.mSelectBankObj.optString(DefaultTVKDataProvider.KEY_PAY_TYPE);
            HashMap hashMap = new HashMap();
            if (NetParams.FAST_CARD.equals(optString3)) {
                putParamToMap(hashMap);
            }
            hashMap.put("timestamp", this.mTimestamp + "");
            fingerParamFill(hashMap);
            if (isWxPay()) {
                hashMap.put("route_version", "wx");
            }
            this.mCurrentTime = System.currentTimeMillis();
            hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
            httpRequestWithQQPayLoading(Cgi.URI_FAST_EXCUTEPAY, hashMap, getLoadingHeight());
        }
    }

    protected void playAnimation() {
        this.mOtherPayView.post(new Runnable() { // from class: com.tenpay.sdk.activity.ct
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.lambda$playAnimation$7();
            }
        });
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void playFingerErrorAnim(String str) {
        this.mFingerErrorTips.setText(str);
        this.mFingerErrorTips.setTextColor(getResources().getColor(R.color.f157595u6));
        this.mFingerErrorTips.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154873en));
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.cl
                @Override // java.lang.Runnable
                public final void run() {
                    PayActivity.this.lambda$playFingerErrorAnim$15();
                }
            }, 700L);
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    public void resetLayout() {
        super.resetLayout();
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
        SixPasswdDialogEditText sixPasswdDialogEditText = this.mSixPasswdEdit;
        if (sixPasswdDialogEditText != null) {
            sixPasswdDialogEditText.postInvalidate();
        }
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected boolean resetPassUI() {
        if (super.resetPassUI()) {
            return true;
        }
        if (this.mIsSixPasswdUser) {
            QwLog.i("six pwd user in pay...");
            this.mPayConfirmBtn.setClickable(false);
            this.mPayConfirmBtn.setEnabled(false);
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.BasePayActivity
    protected void saveDefaultPayType() {
        SelectedPayChannelBean selectedPayChannelBean = new SelectedPayChannelBean();
        int i3 = this.mSelectedPayType;
        if (i3 == 4) {
            selectedPayChannelBean.setPayType(1);
            JSONObject jSONObject = this.mCtPayParaObj;
            if (jSONObject != null) {
                selectedPayChannelBean.setBankType(jSONObject.optString("bank_type"));
            }
        } else if (i3 == 5) {
            selectedPayChannelBean.setPayType(i3);
            selectedPayChannelBean.setBankType(this.mSelectAutoPro.optString(QWSoterConstans.CGI_KEY_BUSI_TYPE));
            selectedPayChannelBean.setCardTail(this.mSelectAutoPro.optString("uin"));
        } else {
            selectedPayChannelBean.setPayType(i3);
            if (this.mSelectedPayType > 0) {
                selectedPayChannelBean.setBankType(this.mSelectBankObj.optString("bank_type"));
                selectedPayChannelBean.setCardTail(this.mSelectBankObj.optString("card_tail"));
            }
        }
        selectedPayChannelBean.save();
        com.tencent.mobileqq.qwallet.utils.g.n(KEY_SAVE_WINDOWS_STYLE, this.mWindowStyle);
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
        sendBalancePay(hashMap, getLoadingHeight());
    }

    protected void showOtherPayView() {
        this.mTitleTxt.setText("\u652f\u4ed8");
        this.mPassView.setVisibility(4);
        this.mCloseBtn.setVisibility(0);
        this.mAnimLayout.setVisibility(0);
        this.mPayHeadLayout.setVisibility(0);
        int i3 = this.mWindowStyle;
        if (i3 == 2) {
            this.mNoPassBtn.setVisibility(0);
            this.mFingerErrorTips.setVisibility(8);
            this.mTitleRightTxt.setVisibility(8);
        } else if (i3 == 1) {
            this.mNoPassBtn.setVisibility(8);
            if (this.mSoterBiometricCanceller != null) {
                QwLog.i("last canceller is not null. should not happen because we will set it to null every time we finished the process");
            }
            this.mTitleRightTxt.setText("\u5bc6\u7801\u652f\u4ed8");
            this.mTitleRightTxt.setVisibility(0);
            this.confirmPayBtn.setVisibility(0);
        }
        playAnimation();
    }

    public void showPromotionInfo() {
        String string;
        String format;
        String string2;
        this.mPriceTxt.setText(Utils.transformToMoney(this.mTotalFee, 0));
        if (this.mIsRandomCut) {
            this.mPriceCutTxt.setVisibility(0);
            if (!TextUtils.isEmpty(this.mPromotionShowTxt)) {
                string2 = this.mPromotionShowTxt;
            } else {
                string2 = getString(R.string.edc);
            }
            this.mPriceCutTxt.setText(string2);
        } else if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1") && !TextUtils.isEmpty(this.mPromotionFee) && Double.parseDouble(this.mPromotionFee) > 0.0d) {
            this.mPriceCutTxt.setVisibility(0);
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
            this.mPriceCutTxt.setText(format);
        } else {
            String optString = this.mPayGateObj.optString("total_fee");
            this.mTotalFee = optString;
            this.mPriceTxt.setText(Utils.transformToMoney(optString, 0));
            this.mPriceCutTxt.setVisibility(8);
            this.mPriceCutArrow.setVisibility(8);
        }
        if (this.mPriceCutTxt.getVisibility() == 0) {
            JSONArray jSONArray = this.mSelBankPromoArr;
            if (jSONArray != null && jSONArray.length() > 1) {
                this.mPriceCutArrow.setVisibility(0);
                this.mPriceCutLayout.setClickable(true);
                return;
            } else {
                this.mPriceCutArrow.setVisibility(8);
                this.mPriceCutLayout.setClickable(false);
                return;
            }
        }
        this.mPriceCutArrow.setVisibility(8);
        this.mPriceCutLayout.setClickable(false);
    }

    protected void showVeryfyCodeView() {
        JSONObject jSONObject;
        boolean z16 = true;
        this.isShowingVerifyCodeView = true;
        this.mVerifyCodeEdit.setText("");
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
        if (this.mWindowStyle == 0) {
            if (this.mSelectedPayType != 1 || (jSONObject = this.mSelectBankObj) == null || !Cgi.CTPAY_BANK_TYPE.equals(jSONObject.optString("bank_type"))) {
                z16 = false;
            }
            if (this.mSelectedPayType == 4 || z16) {
                this.mCtPayHelpImg.setVisibility(0);
                this.mShowPhoneChangeBtn = Boolean.FALSE;
            }
        }
        initTimer(this.mVerifyResendBtn);
        this.mVerifyCodeEdit.requestFocus();
        this.mVerifyKeyboard.setInputEditText(this.mVerifyCodeEdit);
        if (this.mShowPhoneChangeBtn.booleanValue()) {
            this.mChangePhoneNumBtn.setVisibility(0);
        }
        this.mTitleTxt.setText(R.string.fz6);
        this.mPassView.setVisibility(4);
        this.mOtherPayView.setVisibility(4);
        this.mProductTxt.setVisibility(8);
        this.mPriceLayout.setVisibility(8);
        this.mPriceCutLayout.setVisibility(8);
        this.mCloseBtn.setVisibility(8);
        this.backBtn.setVisibility(0);
        this.mVerifyView.post(new Runnable() { // from class: com.tenpay.sdk.activity.cm
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.lambda$showVeryfyCodeView$12();
            }
        });
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.cn
            @Override // java.lang.Runnable
            public final void run() {
                PayActivity.this.lambda$showVeryfyCodeView$13();
            }
        }, 250L);
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
    protected void sendBalancePay(Map<String, String> map, int i3) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("p", getPasswd());
        hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
        hashMap.put("trustpay_open_flag", this.mTrustPayOpen);
        fingerParamFill(hashMap);
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
            hashMap.put("promotion_id", this.mPromotionId);
            hashMap.put("promotion_fee", this.mPromotionFee);
            hashMap.put("promotion_type", this.mPromotionType);
        }
        if (isWxPay()) {
            hashMap.put("route_version", "wx");
        }
        this.mCurrentTime = System.currentTimeMillis();
        httpRequestWithQQPayLoading(Cgi.URI_BALANCE_GET_CODE, hashMap, i3);
    }
}
