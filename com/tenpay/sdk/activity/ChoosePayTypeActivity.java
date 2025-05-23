package com.tenpay.sdk.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletDebugApi;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.bank.BindBankModule;
import com.tenpay.bank.DisableBankInfo;
import com.tenpay.impl.ApiInterfaceImpl;
import com.tenpay.pay.ChoosePayTypeFragment;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.api.IRealNameSourceReportApi;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.sdk.helper.WechatPayHelper;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.view.MaxHeightScrollView;
import com.tenpay.sdk.view.PayTypeCard;
import com.tenpay.util.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ChoosePayTypeActivity extends NetBaseActivity implements View.OnClickListener {
    public static int CHOOSE_PRICECUT_RESULT_CODE = 2017;
    public static final int REQ_CODE_BIND_BANK = 102;
    public static final int REQ_OPEN_CREDIT_PAY = 101;
    protected String commPromoStr;
    boolean disable;
    private List<PayTypeCard> disabledAutoPayList;
    private List<PayTypeCard> disabledList;
    private boolean isFriendPay;
    protected boolean isNoPayType;
    protected List<JSONObject> mAllAutoPayList;
    protected ImageView mBackBtn;
    protected boolean mBackKeyPressed;
    protected String mBalance;
    protected List<JSONObject> mBindedBankList;
    protected ImageButton mCloseBtn;
    private TextView mCutFee;
    protected boolean mIsBalanceEnough;
    private boolean mIsFromFingerPay;
    private boolean mIsInner;
    protected boolean mIsYueLimited;
    protected LinearLayout mListLayout;
    private PayTypeCard mOpenCtPayCard;
    protected int mPassFlag;
    protected String mPayGateString;
    private ImageView mPriceCutArrow;
    private TextView mPriceTxt;
    private int mProcessType;
    protected LinearLayout mRootLayout;
    protected MaxHeightScrollView mScrollView;
    protected int mSelectedPayBankIndex;
    protected int mSelectedPayType;
    private RelativeLayout priceCutLayout;
    private LinearLayout title_layout;
    private WechatPayHelper mWechatPayHelper = new WechatPayHelper();
    private String mTrustPayOpen = "";
    private boolean mHasOpenCtPay = false;
    private HashMap<String, DisableBankInfo> mDisableBankInfos = new HashMap<>();

    /* loaded from: classes27.dex */
    static class ChooseFriendReceiver extends ResultReceiver {
        private static final String TAG = "ChoosePayTypeActivity.ChooseFriendReceiver";
        private final WeakReference<ChoosePayTypeActivity> mActivityRef;

        public ChooseFriendReceiver(ChoosePayTypeActivity choosePayTypeActivity) {
            super(ThreadManagerV2.getUIHandlerV2());
            this.mActivityRef = new WeakReference<>(choosePayTypeActivity);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            ChoosePayTypeActivity choosePayTypeActivity = this.mActivityRef.get();
            if (choosePayTypeActivity != null && !choosePayTypeActivity.isFinishing()) {
                QLog.i(TAG, 1, "onReceiveResult, resultCode=" + i3 + ", " + bundle);
                if (i3 == 1) {
                    Bundle retCodeAndGetBundle = choosePayTypeActivity.setRetCodeAndGetBundle(ErrorCode.ERR_FRIENDPAY_SUCCESS);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("err_msg", choosePayTypeActivity.getString(R.string.f171340e71));
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "", e16);
                    }
                    retCodeAndGetBundle.putString("retmsg", jSONObject.toString());
                    TenUtils.notifyToExit(choosePayTypeActivity.getContext(), choosePayTypeActivity.mProssesID);
                    return;
                }
                if (i3 == 0) {
                    if (bundle != null) {
                        try {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList("choose_friend_uins");
                            String string = bundle.getString("choose_friend_feedback");
                            ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable("callback");
                            if (stringArrayList != null) {
                                new ApiInterfaceImpl().sendFriendPayRequest(choosePayTypeActivity.getContext(), choosePayTypeActivity.mPayTokenId, choosePayTypeActivity.mUin, stringArrayList, string, resultReceiver);
                                return;
                            }
                            return;
                        } catch (Exception e17) {
                            QLog.e(TAG, 1, "", e17);
                            return;
                        }
                    }
                    return;
                }
                if (i3 == 2 && bundle != null) {
                    try {
                        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("choose_friend_uins");
                        if (stringArrayList2 != null && stringArrayList2.size() != 0) {
                            ResultReceiver resultReceiver2 = (ResultReceiver) bundle.getParcelable("callback");
                            Intent intent = new Intent();
                            intent.putExtra("pay_gate", choosePayTypeActivity.mPayGateString);
                            intent.putExtra("process_flag", choosePayTypeActivity.getProcessType());
                            intent.putExtra("payer_uin", stringArrayList2.get(0));
                            intent.putExtra("choose_friend_callback", resultReceiver2);
                            choosePayTypeActivity.launchFragment(intent, SuperFriendPayActivity.class);
                            return;
                        }
                        return;
                    } catch (Exception e18) {
                        QLog.e(TAG, 1, "", e18);
                        return;
                    }
                }
                return;
            }
            QLog.w(TAG, 1, "onReceiveResult but activity finish!");
        }
    }

    private void addAutoPayList(JSONObject jSONObject, LinearLayout.LayoutParams layoutParams) {
        JSONArray optJSONArray;
        boolean z16;
        this.mAllAutoPayList = new ArrayList();
        this.disabledAutoPayList = new ArrayList();
        if (jSONObject == null) {
            optJSONArray = null;
        } else {
            optJSONArray = jSONObject.optJSONArray("spfa_info");
        }
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                this.mAllAutoPayList.add(optJSONArray.optJSONObject(i3));
            }
        }
        for (final int i16 = 0; i16 < this.mAllAutoPayList.size(); i16++) {
            final JSONObject jSONObject2 = this.mAllAutoPayList.get(i16);
            final String optString = jSONObject2.optString("uin");
            String optString2 = jSONObject2.optString("image_id");
            int optInt = jSONObject2.optInt("disable");
            final PayTypeCard payTypeCard = new PayTypeCard(getContext());
            if (optInt != 0) {
                QWalletNickNameServer.b(null, optString, new Function1() { // from class: com.tenpay.sdk.activity.ad
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$addAutoPayList$0;
                        lambda$addAutoPayList$0 = ChoosePayTypeActivity.this.lambda$addAutoPayList$0(optString, jSONObject2, payTypeCard, (String) obj);
                        return lambda$addAutoPayList$0;
                    }
                });
                payTypeCard.setEnabled(false);
                payTypeCard.setLogoId(optString2, true);
                if (!TextUtils.isEmpty(jSONObject2.optString("disable_comment"))) {
                    if (!updatePayItem(jSONObject2, payTypeCard)) {
                        payTypeCard.setSubTitle(R.string.f171354eb4);
                    }
                } else {
                    payTypeCard.setSubTitle(R.string.f171354eb4);
                }
                this.disabledAutoPayList.add(payTypeCard);
            } else {
                payTypeCard.setEnabled(true);
                payTypeCard.setLogoId(optString2, false);
                if (this.mSelectedPayType == 5 && i16 == this.mSelectedPayBankIndex) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                payTypeCard.setSelected(z16);
                Bundle bundle = new Bundle();
                bundle.putString(WadlProxyConsts.CHANNEL, "");
                bundle.putString("uin", optString);
                bundle.putString("group_id", "");
                QWalletNickNameServer.b(null, optString, new Function1() { // from class: com.tenpay.sdk.activity.ae
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$addAutoPayList$1;
                        lambda$addAutoPayList$1 = ChoosePayTypeActivity.this.lambda$addAutoPayList$1(optString, jSONObject2, payTypeCard, (String) obj);
                        return lambda$addAutoPayList$1;
                    }
                });
                payTypeCard.setSubTitle(String.format(getContext().getString(R.string.f1796639z), Utils.transformToMoney(jSONObject2.optString("spfa_balance"), 0)));
                payTypeCard.setSubTitleColor(-16777216);
                payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChoosePayTypeActivity.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        ChoosePayTypeActivity.this.changeSelectStatus(payTypeCard);
                        Intent intent = new Intent();
                        intent.putExtra("pay_gate", ChoosePayTypeActivity.this.mPayGateString);
                        intent.putExtra("pay_by", 5);
                        intent.putExtra("bank_index", i16);
                        intent.putExtra("bank_type", jSONObject2.optString(QWSoterConstans.CGI_KEY_BUSI_TYPE));
                        intent.putExtra("height", ChoosePayTypeActivity.this.mRootLayout.getHeight());
                        ChoosePayTypeActivity.this.setResult(-1, intent);
                        ChoosePayTypeActivity.this.finish();
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                this.mListLayout.addView(payTypeCard, layoutParams);
            }
        }
    }

    private void addBankCardList(LinearLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        int i3;
        boolean z16;
        String str;
        List<JSONObject> list = this.mBindedBankList;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        this.disabledList = new LinkedList();
        for (int i16 = 0; i16 < i3; i16++) {
            final JSONObject jSONObject2 = this.mBindedBankList.get(i16);
            String optString = jSONObject2.optString("image_id");
            int optInt = jSONObject2.optInt("disable");
            final PayTypeCard payTypeCard = new PayTypeCard(getContext());
            String optString2 = jSONObject2.optString("disable_comment");
            StringBuilder sb5 = new StringBuilder();
            boolean z17 = true;
            if (Cgi.CTPAY_BANK_TYPE.equals(jSONObject2.optString("bank_type")) && jSONObject != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String optString3 = jSONObject.optString("ctpay_title");
                if (!TextUtils.isEmpty(optString3)) {
                    sb5.append(optString3);
                } else {
                    sb5.append(jSONObject2.optString("bank_name"));
                }
                str = jSONObject.optString("ctpay_text");
            } else {
                sb5.append(jSONObject2.optString("bank_name"));
                if (!TextUtils.isEmpty(jSONObject2.optString("card_tail"))) {
                    str = jSONObject2.optString("card_tail");
                } else {
                    str = "";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                sb5.append("(");
                sb5.append(str);
                sb5.append(")");
            }
            payTypeCard.setTitle(sb5.toString());
            DisableBankInfo disableBankInfo = this.mDisableBankInfos.get(jSONObject2.optString("bind_serial"));
            if (disableBankInfo != null) {
                payTypeCard.setLogoId(optString, true);
                updateDisableBank(disableBankInfo, payTypeCard);
                this.disabledList.add(payTypeCard);
            } else if (optInt != 0) {
                payTypeCard.setEnabled(false);
                payTypeCard.setLogoId(optString, true);
                if (z16) {
                    String optString4 = jSONObject.optString("ctpay_coment");
                    if (!TextUtils.isEmpty(optString4)) {
                        payTypeCard.setSubTitle(optString4);
                    }
                } else if (!TextUtils.isEmpty(optString2)) {
                    if (!updatePayItem(jSONObject2, payTypeCard)) {
                        payTypeCard.setSubTitle(R.string.f171354eb4);
                    }
                } else {
                    payTypeCard.setSubTitle(R.string.f171354eb4);
                }
                this.disabledList.add(payTypeCard);
            } else {
                payTypeCard.setEnabled(true);
                payTypeCard.setLogoId(optString, false);
                int i17 = this.mSelectedPayType;
                if (i17 == 1 || i17 == 2) {
                    if (i16 != this.mSelectedPayBankIndex) {
                        z17 = false;
                    }
                    payTypeCard.setSelected(z17);
                }
                final boolean z18 = z16;
                final int i18 = i16;
                payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChoosePayTypeActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        ChoosePayTypeActivity.this.changeSelectStatus(payTypeCard);
                        if (z18) {
                            com.tencent.mobileqq.qwallet.c.c("pay.choose.creditpay", 403);
                        } else {
                            com.tencent.mobileqq.qwallet.c.c("pay.choose.get", Integer.valueOf(ChoosePayTypeActivity.this.getProcessType()));
                        }
                        Intent intent = new Intent();
                        intent.putExtra("pay_gate", ChoosePayTypeActivity.this.mPayGateString);
                        int i19 = 1;
                        if (payTypeCard.getIsCreditPay() == 1) {
                            if (payTypeCard.getWebankStatus() != 1) {
                                if (payTypeCard.getWebankStatus() == 2) {
                                    ChoosePayTypeActivity choosePayTypeActivity = ChoosePayTypeActivity.this;
                                    choosePayTypeActivity.mIsBalanceEnough = true ^ Utils.compareString(choosePayTypeActivity.mTotalFee, payTypeCard.getAvailable_amount());
                                    if (ChoosePayTypeActivity.this.mIsBalanceEnough) {
                                        i19 = 3;
                                    }
                                } else {
                                    payTypeCard.getWebankStatus();
                                }
                            }
                            EventCollector.getInstance().onViewClicked(view);
                        }
                        intent.putExtra("pay_by", i19);
                        intent.putExtra("bank_index", i18);
                        intent.putExtra("bank_type", jSONObject2.optString("bank_type"));
                        intent.putExtra("height", ChoosePayTypeActivity.this.mRootLayout.getHeight());
                        ChoosePayTypeActivity.this.setResult(-1, intent);
                        ChoosePayTypeActivity.this.finish();
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                this.mListLayout.addView(payTypeCard, layoutParams);
            }
        }
    }

    private void addBanlanceCard(JSONObject jSONObject, LinearLayout.LayoutParams layoutParams) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this.mUserAttr != 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("balance_info");
            if ((jSONObject.optInt("pay_types", 63) & 1) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.disable = z16;
            final PayTypeCard payTypeCard = new PayTypeCard(getContext());
            payTypeCard.setTitle(getString(R.string.f2180562o) + "(" + Utils.transformToMoney(this.mBalance, 0) + getString(R.string.ehr) + ")");
            if (optJSONObject != null && optJSONObject.optInt("disable", 0) != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!this.disable && !z17) {
                if (this.mIsYueLimited) {
                    payTypeCard.setEnabled(false);
                    payTypeCard.setSubTitle(R.string.eby);
                    payTypeCard.setLogoId(R.drawable.n8s);
                } else {
                    payTypeCard.setEnabled(true);
                    if (this.mSelectedPayType == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    payTypeCard.setSelected(z19);
                    payTypeCard.setSubTitleGone(true);
                    payTypeCard.setLogoId(R.drawable.dvp);
                    payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChoosePayTypeActivity.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            com.tencent.mobileqq.qwallet.c.c("pay.choose.get", 1);
                            ChoosePayTypeActivity.this.changeSelectStatus(payTypeCard);
                            Intent intent = new Intent();
                            intent.putExtra("pay_gate", ChoosePayTypeActivity.this.mPayGateString);
                            intent.putExtra("pay_by", 0);
                            intent.putExtra("bank_type", "0");
                            intent.putExtra("height", ChoosePayTypeActivity.this.mRootLayout.getHeight());
                            ChoosePayTypeActivity.this.setResult(-1, intent);
                            ChoosePayTypeActivity.this.finish();
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                }
            } else {
                if (optJSONObject != null) {
                    z18 = updatePayItem(optJSONObject, payTypeCard);
                } else {
                    z18 = false;
                }
                if (!z18) {
                    payTypeCard.setSubTitle(R.string.f171354eb4);
                }
                payTypeCard.setEnabled(false);
                payTypeCard.setLogoId(R.drawable.n8s);
            }
            if (!this.disable && !z17) {
                this.mListLayout.addView(payTypeCard, 0, layoutParams);
            } else {
                this.mListLayout.addView(payTypeCard, layoutParams);
            }
            processWeChatEntry(optJSONObject, payTypeCard);
        }
    }

    @Nullable
    private JSONObject addCtPayCard(JSONObject jSONObject, LinearLayout.LayoutParams layoutParams) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject("ctpay_param");
        } else {
            jSONObject2 = null;
        }
        if (jSONObject2 != null && !this.mIsMidas) {
            this.mHasOpenCtPay = true;
            this.mOpenCtPayCard = new PayTypeCard(getContext());
            if ("0".equals(jSONObject2.optString("bind_state"))) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(jSONObject2.optString("ctpay_title"));
                if (!TextUtils.isEmpty(jSONObject2.optString("ctpay_text"))) {
                    sb5.append("(");
                    sb5.append(jSONObject2.opt("ctpay_text"));
                    sb5.append(")");
                }
                this.mOpenCtPayCard.setTitle(sb5.toString());
                this.mOpenCtPayCard.setLogoId(jSONObject2.optString("ctpay_image_id"), false);
                if (!TextUtils.isEmpty(jSONObject2.optString("ctpay_coment"))) {
                    this.mOpenCtPayCard.setSubTitle(jSONObject2.optString("ctpay_coment"));
                }
                if ("1".equals(jSONObject2.optString("gray_flag"))) {
                    this.mOpenCtPayCard.setEnabled(false);
                } else {
                    this.mOpenCtPayCard.setEnabled(true);
                    this.mOpenCtPayCard.showArrow();
                    this.mOpenCtPayCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChoosePayTypeActivity.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            com.tencent.mobileqq.qwallet.c.c("pay.choose.creditpay", 400);
                            Intent intent = new Intent();
                            ChoosePayTypeActivity.this.mRootLayout.setVisibility(8);
                            ChoosePayTypeActivity.this.launchFragmentForResult(intent, CreditPayGuideActivity.class, 101);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                }
                this.mListLayout.addView(this.mOpenCtPayCard, layoutParams);
            }
        }
        return jSONObject2;
    }

    private void addFriendPayCard(JSONObject jSONObject, LinearLayout.LayoutParams layoutParams) {
        final JSONObject optJSONObject;
        boolean z16;
        if (jSONObject == null) {
            optJSONObject = null;
        } else {
            optJSONObject = jSONObject.optJSONObject("pfa_param");
        }
        if (optJSONObject != null) {
            if (optJSONObject.optInt("flag", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int optInt = optJSONObject.optInt("show_pos");
            final String optString = jSONObject.optString("desc");
            String optString2 = optJSONObject.optString("pfa_logo_id");
            if ((optInt & 1) == 1) {
                PayTypeCard payTypeCard = new PayTypeCard(getContext());
                payTypeCard.showArrow();
                if (!z16) {
                    payTypeCard.setEnabled(false);
                    payTypeCard.setSubTitle(optJSONObject.optString("reason"));
                    payTypeCard.setLogoId(optString2, true);
                } else {
                    payTypeCard.setEnabled(true);
                    payTypeCard.setLogoId(optString2, false);
                }
                payTypeCard.setTitle(R.string.e6s);
                payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChoosePayTypeActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        com.tencent.mobileqq.qwallet.c.c("smallpay.choose.friendpay", Integer.valueOf(ChoosePayTypeActivity.this.getProcessType()));
                        int i3 = 1;
                        if (optJSONObject.optInt("allow_multi_flag") == 1) {
                            i3 = optJSONObject.optInt("allow_multi_counts", 1);
                        }
                        int intExtra = ChoosePayTypeActivity.this.getIntent().getIntExtra("iPayFrom", -1);
                        ApiUtil.chooseFriends(ChoosePayTypeActivity.this.getOutActivity(), ChoosePayTypeActivity.this.getString(R.string.e6r), Utils.transformToMoney(ChoosePayTypeActivity.this.mTotalFee, 0), optString, ChoosePayTypeActivity.this.mTotalFee, intExtra, i3, new ChooseFriendReceiver(ChoosePayTypeActivity.this));
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
                this.mListLayout.addView(payTypeCard, layoutParams);
            }
        }
    }

    private void addNewCard(JSONObject jSONObject, LinearLayout.LayoutParams layoutParams) {
        PayTypeCard payTypeCard = new PayTypeCard(getContext());
        PayChannelBean.AddMore create = PayChannelBean.AddMore.create(jSONObject, R.drawable.n9_, getString(R.string.e4b), this.mPayTokenId);
        if (create.getDisable()) {
            return;
        }
        payTypeCard.setLogoId(create.getLogoResId());
        payTypeCard.setTitle(create.getTitle());
        payTypeCard.showArrow();
        this.mListLayout.addView(payTypeCard, layoutParams);
        payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChoosePayTypeActivity.this.lambda$addNewCard$2(view);
            }
        });
    }

    private void adjustListLayout() {
        updateCardBg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeSelectStatus(PayTypeCard payTypeCard) {
        for (int i3 = 0; i3 < this.mListLayout.getChildCount(); i3++) {
            View childAt = this.mListLayout.getChildAt(i3);
            if (childAt instanceof PayTypeCard) {
                ((PayTypeCard) childAt).setSelected(false);
            }
        }
        payTypeCard.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void close(boolean z16) {
        int i3;
        if (!z16) {
            try {
                if (this.mBackKeyPressed) {
                    com.tencent.mobileqq.qwallet.c.c("pay.choose.keyback", Integer.valueOf(getProcessType()));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("pay.choose.cancel", Integer.valueOf(getProcessType()));
                }
            } catch (Throwable th5) {
                QwLog.e(th5.toString());
                return;
            }
        }
        if (!this.mIsInner && this.isNoPayType && (i3 = this.mComeFrom) != 4 && i3 != 3) {
            TenUtils.notifyToExit(getContext(), this.mProssesID);
        }
        finish();
    }

    private void dealWithBackData(Intent intent) {
        String stringExtra = intent.getStringExtra("promo_obj");
        if (Utils.isEmpty(stringExtra)) {
            return;
        }
        try {
            resolvePromotionInfo(new JSONObject(stringExtra));
            showPromotionInfo();
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        this.mIsInner = intent.getBooleanExtra("isInner", false);
        this.mTrustPayOpen = intent.getStringExtra("trustpay_open_flag");
        this.isFriendPay = intent.getBooleanExtra("isFriendPay", false);
        this.mPayGateString = intent.getStringExtra("pay_gate");
        this.mProcessType = intent.getIntExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, 2);
        this.isNoPayType = intent.getBooleanExtra("need_callback", false);
        this.mIsYueLimited = intent.getBooleanExtra("yue_limited", false);
        this.mSelectedPayType = intent.getIntExtra("selected_pay_by", -1);
        this.mSelectedPayBankIndex = intent.getIntExtra("selected_pay_bank_index", -1);
        this.mIsFromFingerPay = intent.getBooleanExtra(PayActivity.FROM_FINGER_PAY, false);
        HashMap hashMap = (HashMap) intent.getSerializableExtra("disableBankInfos");
        if (hashMap != null) {
            this.mDisableBankInfos.putAll(hashMap);
        }
    }

    private void initTitle(JSONObject jSONObject, View view) {
        String optString;
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.az7);
        this.mCloseBtn = imageButton;
        imageButton.setOnClickListener(this);
        ImageView imageView = (ImageView) view.findViewById(R.id.a47);
        this.mBackBtn = imageView;
        imageView.setOnClickListener(this);
        TextView textView = (TextView) view.findViewById(R.id.fjh);
        textView.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        TextView textView3 = (TextView) view.findViewById(R.id.f166540fz1);
        this.mPriceTxt = textView3;
        textView3.setOnClickListener(this);
        this.mCutFee = (TextView) view.findViewById(R.id.fyz);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fyy);
        this.priceCutLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.fyx);
        this.mPriceCutArrow = imageView2;
        imageView2.setVisibility(8);
        if (this.isNoPayType) {
            this.commPromoStr = getIntent().getStringExtra("comm_promotion");
            textView.setVisibility(8);
            textView2.setVisibility(0);
            ((View) this.mPriceTxt.getParent()).setVisibility(0);
            if (jSONObject == null) {
                optString = null;
            } else {
                optString = jSONObject.optString("desc");
            }
            textView2.setText(optString);
            showPromotionInfo();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.title_layout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, Utils.dp2Px(getContext(), 20.0f));
            this.title_layout.setLayoutParams(layoutParams);
        } else {
            textView.setVisibility(0);
            view.findViewById(R.id.f166539fz0).setVisibility(8);
            view.findViewById(R.id.fyy).setVisibility(8);
            textView2.setVisibility(8);
            textView.setText(R.string.e_4);
        }
        if (this.isNoPayType) {
            this.mCloseBtn.setVisibility(0);
            this.mBackBtn.setVisibility(8);
            ((RelativeLayout) this.mRootLayout.getParent()).setBackgroundColor(Color.parseColor("#66000000"));
        } else {
            this.mCloseBtn.setVisibility(8);
            this.mBackBtn.setVisibility(0);
        }
    }

    private void initView(View view) {
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_layout);
        this.mScrollView = (MaxHeightScrollView) view.findViewById(R.id.iig);
        this.mScrollView.setMaxHeight((int) (com.tencent.mobileqq.util.x.f(getContext()).a() * ((IQWalletDebugApi) QRoute.api(IQWalletDebugApi.class)).getPayChannelHeightRate(0.9d)));
        this.title_layout = (LinearLayout) view.findViewById(R.id.jp7);
        this.mListLayout = (LinearLayout) view.findViewById(R.id.jel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$addAutoPayList$0(String str, JSONObject jSONObject, PayTypeCard payTypeCard, String str2) {
        if (getContext() != null && !isFinishing()) {
            if (!Utils.isEmpty(str2)) {
                str = str2;
            }
            payTypeCard.setTitle(Utils.cutTextByPix(getContext(), str + "-" + jSONObject.optString("busi_name"), Utils.px2Dp(getContext(), (Utils.getScreenWidth(getContext()) * 3) / 4), payTypeCard.getTitleTextView().getPaint()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$addAutoPayList$1(String str, JSONObject jSONObject, PayTypeCard payTypeCard, String str2) {
        if (getContext() != null && !isFinishing()) {
            if (!Utils.isEmpty(str2)) {
                str = str2;
            }
            payTypeCard.setTitle(Utils.cutTextByPix(getContext(), str + "-" + jSONObject.optString("busi_name"), Utils.px2Dp(getContext(), payTypeCard.getMaxTitleViewLen()), payTypeCard.getTitleTextView().getPaint()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$addNewCard$2(View view) {
        String optString;
        RealNameSource realNameSource;
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.qwallet.c.c("pay.choose.other", Integer.valueOf(getProcessType()));
        Intent intent = new Intent();
        intent.putExtra("token_id", this.mPayTokenId);
        intent.putExtra("pass_flag", this.mPassFlag);
        intent.putExtra("trustpay_open_flag", this.mTrustPayOpen);
        if (this.mIsFromFingerPay) {
            intent.putExtra(PayActivity.FROM_FINGER_PAY, true);
            intent.putExtra(ChoosePayTypeFragment.KEY_PROCESS_TYPE, this.mProcessType);
        }
        if (this.isFriendPay) {
            com.tencent.mobileqq.qwallet.c.c("friendpay.sdk.addcard", Integer.valueOf(getProcessType()));
        }
        intent.putExtra("from_choose_pay_type_small", true);
        if (!TextUtils.isEmpty(this.mPayGateString)) {
            try {
                optString = new JSONObject(this.mPayGateString).optString("pay_scene");
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, e16, new Object[0]);
            }
            if (!"social".equals(optString)) {
                realNameSource = ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).getCurrentNameSource();
            } else {
                realNameSource = new RealNameSource("19");
            }
            intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
            BindBankModule.INSTANCE.startVerifyForResult(this, intent, 102);
            EventCollector.getInstance().onViewClicked(view);
        }
        optString = null;
        if (!"social".equals(optString)) {
        }
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
        BindBankModule.INSTANCE.startVerifyForResult(this, intent, 102);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void playAnim() {
        this.mRootLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154875ep));
    }

    private void processWeChatEntry(JSONObject jSONObject, PayTypeCard payTypeCard) {
        JSONObject optJSONObject;
        try {
            payTypeCard.processWeChatEntry(false, "", "", null);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("miniapp")) != null) {
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("logo_id");
                final String optString3 = optJSONObject.optString("url");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    payTypeCard.processWeChatEntry(true, optString, optString2, new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChoosePayTypeActivity.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            EventCollector.getInstance().onViewClickedBefore(view);
                            com.tencent.mobileqq.qwallet.utils.k.h((Activity) ChoosePayTypeActivity.this.getContext(), optString3);
                            com.tencent.mobileqq.qwallet.c.e("paysdk.wx2qq.click", "" + ChoosePayTypeActivity.this.mBalance, "" + ChoosePayTypeActivity.this.mTotalFee, "", "");
                            ChoosePayTypeActivity.this.close(true);
                            EventCollector.getInstance().onViewClicked(view);
                        }
                    });
                    com.tencent.mobileqq.qwallet.c.e("paysdk.wx2qq.show", "" + this.mBalance, "" + this.mTotalFee, "", "");
                }
            }
            QwLog.i("processWeChatEntry...balanceInfo:" + jSONObject);
        } catch (Throwable th5) {
            QwLog.e(th5.getMessage());
        }
    }

    private void resolvePromotionInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        boolean z16 = true;
        try {
            JSONObject jSONObject2 = new JSONObject(this.mPayGateString);
            this.mPromotionFee = jSONObject.optString("promotion_fee");
            this.mDiscountType = jSONObject.optString("discount_type");
            this.mPromotionName = jSONObject.optString("promotion_name");
            this.mPromotionType = jSONObject.optString("promotion_type");
            this.mPromotionId = jSONObject.optString("promotion_id");
            this.mPromotionShowTxt = jSONObject.optString("promotion_show");
            if (TextUtils.isEmpty(this.mPromotionFlag) || !this.mPromotionFlag.equals("1") || TextUtils.isEmpty(this.mPromotionType) || !this.mPromotionType.equals("1") || TextUtils.isEmpty(this.mDiscountType) || !this.mDiscountType.equals("2")) {
                z16 = false;
            }
            this.mIsRandomCut = z16;
            if ("0".equals(this.mPromotionFlag)) {
                this.mTotalFee = jSONObject2.optString("total_fee");
                this.mOriginalTotal = jSONObject2.optString("total_fee");
            } else if (this.mIsRandomCut) {
                this.mTotalFee = jSONObject2.optString("total_fee");
                this.mOriginalTotal = jSONObject2.optString("total_fee");
            } else {
                this.mOriginalTotal = jSONObject2.optString("total_fee");
                this.mTotalFee = jSONObject.optString("real_fee");
            }
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void restartPayIfNeed() {
        Bundle bundleExtra;
        Intent intent = getIntent();
        if (intent == null || (bundleExtra = intent.getBundleExtra(PayActivity.KEY_RESTART_BUNDLE)) == null) {
            return;
        }
        if (bundleExtra.containsKey("pay_gate")) {
            bundleExtra.remove("pay_gate");
        }
        Intent intent2 = new Intent();
        intent2.putExtras(bundleExtra);
        launchFragment(intent2, PayActivity.class);
    }

    private void updateCardBg() {
        int childCount = this.mListLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((PayTypeCard) this.mListLayout.getChildAt(i3)).updateBgRound(i3, childCount);
        }
    }

    private boolean updateDisableBank(DisableBankInfo disableBankInfo, PayTypeCard payTypeCard) {
        if (disableBankInfo != null && payTypeCard != null) {
            try {
                payTypeCard.setSubTitle(true, disableBankInfo.getDisableComment(), disableBankInfo.getDisableTitle(), disableBankInfo.getDisableUrl());
                return true;
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mBackKeyPressed = true;
            close(false);
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootLayout, "translationY", 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        super.finish();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        return this.mProcessType;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        Object extras;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestCode =");
        sb5.append(i3);
        sb5.append(", resultCode=");
        sb5.append(i16);
        sb5.append(", data=");
        if (intent == null) {
            extras = "null";
        } else {
            extras = intent.getExtras();
        }
        sb5.append(extras);
        QwLog.i(sb5.toString());
        if (-1 == i16) {
            if (i3 == 101) {
                Intent intent2 = new Intent();
                intent2.putExtra("pay_gate", this.mPayGateString);
                intent2.putExtra("pay_by", 4);
                intent2.putExtra("bank_type", Cgi.CTPAY_BANK_TYPE);
                setResult(-1, intent2);
                finish();
                return;
            }
            if (i3 == CHOOSE_PRICECUT_RESULT_CODE) {
                dealWithBackData(intent);
                return;
            } else {
                if (i3 == 102) {
                    restartPayIfNeed();
                    setResult(-1, intent);
                    finish();
                    return;
                }
                return;
            }
        }
        if (i3 == 101) {
            this.mRootLayout.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.a47 && id5 != R.id.az7) {
            if (id5 == R.id.fyy) {
                Intent intent = new Intent();
                if (!Utils.isEmpty(this.commPromoStr)) {
                    intent.putExtra("promotion_list", this.commPromoStr);
                }
                intent.putExtra("height", this.mScrollView.getHeight() + Utils.dp2Px(getContext(), 130.0f));
                intent.putExtra("pay_gate", this.mPayGateString);
                intent.putExtra("where", ChoosePayTypeActivity.class.getSimpleName());
                launchFragmentForResult(intent, ChooseOnePriceCut.class, CHOOSE_PRICECUT_RESULT_CODE);
            }
        } else {
            close(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QwLog.i("ChoosePayType...");
        if (getIntent() == null) {
            return;
        }
        initData();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getWindow().setSoftInputMode(19);
        View inflate = layoutInflater.inflate(R.layout.adf, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mWechatPayHelper.release();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.qwallet.c.c("pay.choose.show", Integer.valueOf(getProcessType()));
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        if (this.isNoPayType) {
            com.tencent.mobileqq.qwallet.c.c("extra.cantpay.record", 5);
            com.tencent.mobileqq.qwallet.c.c("extra.delaymonitor.cantpayload", 5);
        }
        JSONObject tryNewJson = Utils.tryNewJson(this.mPayGateString);
        if (tryNewJson == null) {
            QwLog.i("qpay_gate is null...");
            return;
        }
        String optString = tryNewJson.optString("balance");
        this.mBalance = optString;
        if (TextUtils.isEmpty(optString)) {
            this.mBalance = "0";
        }
        this.mPassFlag = tryNewJson.optInt("pass_flag");
        JSONArray optJSONArray = tryNewJson.optJSONArray("bind_banks");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            this.mBindedBankList = new ArrayList();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                this.mBindedBankList.add(optJSONArray.optJSONObject(i3));
            }
        }
        QwLog.i("isNoPayType=" + this.isNoPayType);
        QwLog.i("mPromotionType=" + this.mPromotionType);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        JSONObject addCtPayCard = addCtPayCard(tryNewJson, layoutParams);
        addAutoPayList(tryNewJson, layoutParams);
        addBankCardList(layoutParams, addCtPayCard);
        addFriendPayCard(tryNewJson, layoutParams);
        addBanlanceCard(tryNewJson, layoutParams);
        for (int i16 = 0; i16 < this.disabledAutoPayList.size(); i16++) {
            this.mListLayout.addView(this.disabledAutoPayList.get(i16), layoutParams);
        }
        for (int i17 = 0; i17 < this.disabledList.size(); i17++) {
            this.mListLayout.addView(this.disabledList.get(i17), layoutParams);
        }
        addNewCard(tryNewJson, layoutParams);
        initTitle(tryNewJson, view);
        adjustListLayout();
        if (this.isNoPayType) {
            playAnim();
        }
    }

    public void showPromotionInfo() {
        String string;
        String format;
        String string2;
        this.mCutFee.setVisibility(0);
        this.mPriceTxt.setText(Utils.transformToMoney(this.mTotalFee, 0));
        if (this.mIsRandomCut) {
            this.mCutFee.setVisibility(0);
            if (!TextUtils.isEmpty(this.mPromotionShowTxt)) {
                string2 = this.mPromotionShowTxt;
            } else {
                string2 = getString(R.string.edc);
            }
            this.mCutFee.setText(string2);
        } else if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1") && !TextUtils.isEmpty(this.mPromotionFee) && Double.parseDouble(this.mPromotionFee) > 0.0d) {
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
        } else {
            this.mCutFee.setVisibility(8);
        }
        if (!Utils.isEmpty(this.commPromoStr)) {
            try {
                if (new JSONArray(this.commPromoStr).length() > 1) {
                    this.mPriceCutArrow.setVisibility(0);
                    this.priceCutLayout.setClickable(true);
                } else {
                    this.priceCutLayout.setClickable(false);
                }
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    public boolean updatePayItem(JSONObject jSONObject, PayTypeCard payTypeCard) {
        if (jSONObject != null && payTypeCard != null) {
            try {
                payTypeCard.setSubTitle(true, jSONObject.optString("disable_comment"), jSONObject.optString("disable_title"), jSONObject.optString("disable_url"));
                return true;
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        return false;
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
