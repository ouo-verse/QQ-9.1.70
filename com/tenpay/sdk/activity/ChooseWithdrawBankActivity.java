package com.tenpay.sdk.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletDebugApi;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.bank.BindBankModule;
import com.tenpay.bank.DisableBankInfo;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.view.MaxHeightScrollView;
import com.tenpay.sdk.view.PayTypeCard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ChooseWithdrawBankActivity extends TenpayUtilActivity implements View.OnClickListener {
    private static final int RESULT_CODE_BIND_BANK = 1001;
    public static boolean mFromDeposit = false;
    public static boolean mIsFingerPayDeposit = false;
    protected ImageView mBackBtn;
    protected boolean mBackKeyPressed;
    protected int mBankIndex;
    protected String mBanksString;
    protected ImageButton mCloseBtn;
    protected String mDepositBankInfo;
    protected String mDepositCount;
    protected LinearLayout mListLayout;
    protected int mPassFlag;
    protected LinearLayout mRootLayout;
    protected MaxHeightScrollView mScrollView;
    protected String mWithdrawCount;

    @NonNull
    protected List<JSONObject> mBindedBankList = new ArrayList();
    private HashMap<String, DisableBankInfo> mDisableBankInfos = new HashMap<>();
    protected int processFlag = 113;
    protected boolean mSetBackgroundGray = false;

    private void addNewCard(LinearLayout.LayoutParams layoutParams) {
        PayTypeCard payTypeCard = new PayTypeCard(getContext());
        payTypeCard.setLogoId(R.drawable.n9_);
        payTypeCard.setTitle(getString(R.string.e4b));
        payTypeCard.showArrow();
        this.mListLayout.addView(payTypeCard, layoutParams);
        payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseWithdrawBankActivity.this.lambda$addNewCard$0(view);
            }
        });
    }

    private void adjustListLayout() {
        updateCardBg();
    }

    private void cancelChooseBank() {
        setResult(0);
        finish();
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
    public void go2DepositActivity(int i3) {
        Intent intent = new Intent();
        intent.putExtra("bank_index", i3);
        intent.putExtra("banks_info", this.mDepositBankInfo);
        intent.putExtra("deposit_count", this.mDepositCount);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go2WithdrawActivity(int i3) {
        Intent intent = new Intent();
        intent.putExtra("banks_info", this.mBanksString);
        intent.putExtra("bank_index", i3);
        intent.putExtra(WithdrawActivity.WITHDRAW_COUNT, this.mWithdrawCount);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addNewCard$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.qwallet.c.c("cash.changecard.other", Integer.valueOf(this.processFlag));
        Intent intent = new Intent();
        intent.putExtra("pass_flag", this.mPassFlag);
        intent.putExtra("from_choose_pay_type_small", true);
        if (mFromDeposit) {
            intent.putExtra(DepositStartActivity.DESPOSIT_COUNT, this.mDepositCount);
            intent.putExtra(DepositStartActivity.FROM_DESPOSIT, true);
            if (mIsFingerPayDeposit) {
                intent.putExtra("from_finger_deposit", true);
            }
            BindBankModule.INSTANCE.startWithSwitchForResult(this, intent, 1001, 6);
        } else {
            intent.putExtra(WithdrawActivity.WITHDRAW_COUNT, this.mWithdrawCount);
            intent.putExtra(WithdrawActivity.FROM_WITHDRAW, true);
            BindBankModule.INSTANCE.startWithSwitchForResult(this, intent, 1001, 5);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void playAnim() {
        this.mRootLayout.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154875ep));
    }

    private void updateCardBg() {
        int childCount = this.mListLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((PayTypeCard) this.mListLayout.getChildAt(i3)).updateBgRound(i3, childCount);
        }
    }

    private boolean updateDisableBank(DisableBankInfo disableBankInfo, PayTypeCard payTypeCard) {
        if (disableBankInfo != null && payTypeCard != null) {
            payTypeCard.setSubTitle(true, disableBankInfo.getDisableComment(), disableBankInfo.getDisableTitle(), disableBankInfo.getDisableUrl());
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mBackKeyPressed = true;
            this.mCloseBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 1001) {
            if (i16 == -1) {
                new Intent().putExtra("afterBindNewCard", true);
                setResult(-1);
                finish();
            } else if (i16 == 0) {
                QLog.d(((TenpayUtilActivity) this).TAG, 4, "cancel");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.a47 || id5 == R.id.az7) {
            if (this.mBackKeyPressed) {
                com.tencent.mobileqq.qwallet.c.c("cash.changecard.keyback", Integer.valueOf(this.processFlag));
            } else {
                com.tencent.mobileqq.qwallet.c.c("cash.changecard.back", Integer.valueOf(this.processFlag));
            }
            cancelChooseBank();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.adf, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.qwallet.c.c("pay.choose.show", 2);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        boolean z16;
        boolean equals;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        super.onViewCreated(view, bundle);
        this.mBackBtn = (ImageView) view.findViewById(R.id.a47);
        this.mCloseBtn = (ImageButton) view.findViewById(R.id.az7);
        this.mBackBtn.setOnClickListener(this);
        this.mCloseBtn.setOnClickListener(this);
        this.mBackBtn.setVisibility(0);
        this.mCloseBtn.setVisibility(8);
        view.findViewById(R.id.title_txt).setVisibility(8);
        view.findViewById(R.id.f166539fz0).setVisibility(8);
        view.findViewById(R.id.fyy).setVisibility(8);
        this.mRootLayout = (LinearLayout) view.findViewById(R.id.root_layout);
        this.mScrollView = (MaxHeightScrollView) view.findViewById(R.id.iig);
        this.mScrollView.setMaxHeight((int) (com.tencent.mobileqq.util.x.f(getContext()).a() * ((IQWalletDebugApi) QRoute.api(IQWalletDebugApi.class)).getPayChannelHeightRate(0.9d)));
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mFromDeposit = intent.getBooleanExtra("FromDepositActivity", false);
        this.mSetBackgroundGray = intent.getBooleanExtra("setBackgroundGray", false);
        mIsFingerPayDeposit = intent.getBooleanExtra("isFingerPayDeposit", false);
        HashMap hashMap = (HashMap) intent.getSerializableExtra("disableBankInfos");
        if (hashMap != null) {
            this.mDisableBankInfos.putAll(hashMap);
        }
        TextView textView = (TextView) view.findViewById(R.id.fjh);
        if (mFromDeposit) {
            textView.setText(R.string.e_4);
        } else {
            textView.setText(R.string.f171371eh1);
        }
        if (mFromDeposit) {
            if (mIsFingerPayDeposit) {
                this.processFlag = 139;
            }
            this.mPassFlag = intent.getIntExtra("pass_flag", 0);
            this.mDepositCount = intent.getStringExtra("deposit_count");
            String stringExtra = intent.getStringExtra("banks_info");
            this.mDepositBankInfo = stringExtra;
            try {
                JSONArray jSONArray = new JSONArray(stringExtra);
                if (jSONArray.length() > 0) {
                    this.mBindedBankList = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        this.mBindedBankList.add(jSONArray.optJSONObject(i3));
                    }
                }
            } catch (JSONException e16) {
                QLog.e(((TenpayUtilActivity) this).TAG, 1, "", e16);
            }
        } else {
            this.processFlag = intent.getIntExtra(WithdrawActivity.WITHDRAW_PROCESS_FLAG, 113);
            this.mBanksString = intent.getStringExtra("banks_info");
            this.mWithdrawCount = intent.getStringExtra(WithdrawActivity.WITHDRAW_COUNT);
            if (this.mBanksString == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.mBanksString);
                this.mPassFlag = jSONObject.optInt("pass_flag");
                JSONArray optJSONArray = jSONObject.optJSONArray("banks");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.mBindedBankList = new ArrayList();
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        this.mBindedBankList.add(optJSONArray.optJSONObject(i16));
                    }
                }
            } catch (JSONException e17) {
                QLog.e(((TenpayUtilActivity) this).TAG, 1, "", e17);
            }
        }
        this.mBankIndex = intent.getIntExtra("bank_index", 0);
        this.mListLayout = (LinearLayout) view.findViewById(R.id.jel);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int size = this.mBindedBankList.size();
        for (final int i17 = 0; i17 < size; i17++) {
            JSONObject jSONObject2 = this.mBindedBankList.get(i17);
            String optString = jSONObject2.optString("image_id");
            final PayTypeCard payTypeCard = new PayTypeCard(getContext());
            if (i17 == this.mBankIndex) {
                z16 = true;
            } else {
                z16 = false;
            }
            payTypeCard.setSelected(z16);
            StringBuilder sb5 = new StringBuilder();
            if (mFromDeposit) {
                equals = Cgi.CTPAY_BANK_TYPE.equals(jSONObject2.optString("code"));
                sb5.append(jSONObject2.optString("name"));
            } else {
                equals = Cgi.CTPAY_BANK_TYPE.equals(jSONObject2.optString("bank_type"));
                sb5.append(jSONObject2.optString("bank_name"));
            }
            if (!TextUtils.isEmpty(jSONObject2.optString("card_tail")) && !equals) {
                sb5.append("(");
                sb5.append(jSONObject2.optString("card_tail"));
                sb5.append(")");
            }
            payTypeCard.setTitle(sb5.toString());
            if (mIsFingerPayDeposit && ("DEBIT".equals(jSONObject2.optString("type")) || "CREDIT".equals(jSONObject2.optString("type")))) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (mFromDeposit) {
                if (jSONObject2.optString(TransFileControllerImpl.VALUE_USE_PRE_CONN).contains("CHARGE") && jSONObject2.optInt("disable") == 0) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                if (z27 && !z17) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            } else {
                z18 = !jSONObject2.optString("draw_flag").equals("0");
            }
            DisableBankInfo disableBankInfo = this.mDisableBankInfos.get(jSONObject2.optString("bind_serial"));
            if (disableBankInfo != null) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z18 && !z19) {
                z26 = false;
            } else {
                z26 = true;
            }
            payTypeCard.setLogoId(optString, z26);
            if (z19) {
                updateDisableBank(disableBankInfo, payTypeCard);
            } else if (z18) {
                payTypeCard.setEnabled(true);
                payTypeCard.setClickable(true);
                payTypeCard.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChooseWithdrawBankActivity.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        EventCollector.getInstance().onViewClickedBefore(view2);
                        ChooseWithdrawBankActivity.this.changeSelectStatus(payTypeCard);
                        if (ChooseWithdrawBankActivity.mFromDeposit) {
                            ChooseWithdrawBankActivity.this.go2DepositActivity(i17);
                        } else {
                            ChooseWithdrawBankActivity.this.go2WithdrawActivity(i17);
                        }
                        EventCollector.getInstance().onViewClicked(view2);
                    }
                });
            } else {
                payTypeCard.setEnabled(false);
                payTypeCard.setClickable(false);
                if (equals) {
                    String optString2 = jSONObject2.optString("bank_coment");
                    if (!TextUtils.isEmpty(optString2)) {
                        payTypeCard.setSubTitle(optString2);
                    }
                } else {
                    String optString3 = jSONObject2.optString("disable_comment");
                    if (!TextUtils.isEmpty(optString3)) {
                        payTypeCard.setSubTitle(optString3);
                    } else {
                        if (mFromDeposit) {
                            payTypeCard.setSubTitle(R.string.e57);
                        } else {
                            payTypeCard.setSubTitle(R.string.egm);
                        }
                        payTypeCard.setSubTitle(R.string.egm);
                    }
                }
            }
            ViewCompat.setAccessibilityDelegate(payTypeCard, new AccessibilityDelegateCompat() { // from class: com.tenpay.sdk.activity.ChooseWithdrawBankActivity.2
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setSelected(payTypeCard.isSelected());
                }
            });
            this.mListLayout.addView(payTypeCard, layoutParams);
            payTypeCard.setPadding(0, 0, 0, 0);
        }
        addNewCard(layoutParams);
        com.tencent.mobileqq.qwallet.c.c("cash.changecard.show", Integer.valueOf(this.processFlag));
        adjustListLayout();
        if (this.mSetBackgroundGray) {
            ((RelativeLayout) this.mRootLayout.getParent()).setBackgroundColor(Color.parseColor("#66000000"));
            playAnim();
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
