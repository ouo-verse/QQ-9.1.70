package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.api.BankImageUtil;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.WalletGateData;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UnBindRemindActivity extends NetBaseActivity implements View.OnClickListener {
    private int UNBIND_FAIL = -1;
    private TextView mBackBtn;
    private ImageView mBankIcon;
    private String mBankSerial;
    private TextView mBankText;
    private String mBankType;
    private Button mCancelBtn;
    private TextView mCardNoText;
    private ImageView mSheildBackImg;
    private ImageView mSheildIcon;
    private boolean mSkipConfirm;
    private View mSkipView;
    private Button mUnbindBtn;
    private HashMap<String, String> walletRequest;

    private void afterInitQwalletData() {
        if (this.mSkipConfirm) {
            autoJumpUnBind();
        }
    }

    private void autoJumpUnBind() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("uin", this.mUin);
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        httpRequest(Cgi.URI_QUERY_USER, hashMap);
    }

    private void init(View view) {
        this.mUnbindBtn = (Button) view.findViewById(R.id.ght);
        this.mCancelBtn = (Button) view.findViewById(R.id.ghr);
        this.mBankText = (TextView) view.findViewById(R.id.ghw);
        this.mCardNoText = (TextView) view.findViewById(R.id.ghx);
        this.mBankIcon = (ImageView) view.findViewById(R.id.ghv);
        this.mSheildIcon = (ImageView) view.findViewById(R.id.f166599gi1);
        this.mSheildBackImg = (ImageView) view.findViewById(R.id.f166598gi0);
        this.mSkipView = view.findViewById(R.id.f30570op);
        initTitleBar(view);
        initParam();
    }

    private void initParam() {
        Intent intent = getIntent();
        int i3 = 0;
        if (intent != null) {
            this.mUin = intent.getStringExtra("uin");
            String stringExtra = intent.getStringExtra("bank");
            String stringExtra2 = intent.getStringExtra("cardTail");
            this.mBankType = intent.getStringExtra("bankType");
            this.mBankSerial = intent.getStringExtra("bankSerial");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.mBankText.setText(stringExtra);
            }
            StringBuffer stringBuffer = new StringBuffer("**** **** **** ");
            if (!TextUtils.isEmpty(stringExtra2)) {
                stringBuffer.append(stringExtra2);
            } else {
                stringBuffer.append("****");
            }
            this.mCardNoText.setText(stringBuffer.toString());
            BankImageUtil.getInstance(getContext()).setBankImage(intent.getStringExtra("bankIconId"), this.mBankIcon);
            this.mSkipConfirm = intent.getBooleanExtra("skipConfirm", false);
            QwLog.i("is_inner: " + intent.getBooleanExtra("is_inner", false));
            if (intent.getBooleanExtra("is_inner", false)) {
                this.hasTopCallback = true;
            }
        }
        View view = this.mSkipView;
        if (!this.mSkipConfirm) {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.UnBindRemindActivity.1
            @Override // java.lang.Runnable
            public void run() {
                UnBindRemindActivity.this.initSheildAnim();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSheildAnim() {
        this.mSheildBackImg.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154884ey));
    }

    private void initTitleBar(View view) {
        View findViewById = view.findViewById(R.id.rlCommenTitle);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        findViewById.setBackgroundColor(getResources().getColor(R.color.f157644vj));
        textView.setTextColor(getResources().getColorStateList(R.color.a4o));
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
        this.mBackBtn = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
        textView2.setTextColor(-1);
        textView2.setText(R.string.ef7);
        this.mUnbindBtn.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
        this.mBackBtn.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected int getStatusBarColor() {
        return getResources().getColor(R.color.f157644vj);
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
            this.mTrueName = data.optString("purchaser_true_name");
            this.mUserAttr = data.optInt("user_attr");
            this.mCacheVer = data.optString("interf_cache_ver");
            this.mUserCertType = data.optInt("cert_user");
            String optString = data.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            afterInitQwalletData();
            return;
        }
        httpRequest(Cgi.URL_WALLET_GATE, this.walletRequest);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i16 == -1) {
            setRetCodeAndGetBundle(0).putInt("result", 1);
            getActivity().overridePendingTransition(0, R.anim.f154880eu);
            setResult(-1);
            finish();
            return;
        }
        if (this.mSkipConfirm) {
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        this.mSkipView.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ght) {
            com.tencent.mobileqq.qwallet.c.c("extra.unbind.yes", 103);
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("uin", this.mUin);
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            httpRequest(Cgi.URI_QUERY_USER, hashMap);
        } else if (id5 == R.id.ghr) {
            com.tencent.mobileqq.qwallet.c.c("extra.unbind.no", 103);
            setRetCodeMsgAndGetBundle(0, "\u7528\u6237\u70b9\u53d6\u6d88").putInt("result", this.UNBIND_FAIL);
            finish();
            getActivity().overridePendingTransition(0, R.anim.f154880eu);
        } else if (id5 == R.id.ivTitleBtnLeft) {
            com.tencent.mobileqq.qwallet.c.c("extra.unbind.no", 103);
            finish();
            getActivity().overridePendingTransition(0, R.anim.f154880eu);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.agn, viewGroup, false);
        init(inflate);
        getWalletData();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        super.onError(str, jSONObject);
        this.mSkipView.setVisibility(8);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (Cgi.URI_QUERY_USER.equals(str)) {
            Intent intent = new Intent();
            intent.putExtra("bank_type", this.mBankType);
            intent.putExtra("bind_serial", this.mBankSerial);
            intent.putExtra("pass_flag", jSONObject.optString("pass_flag"));
            launchFragmentForResult(intent, UnbindBankActivity.class, 0);
            getActivity().overridePendingTransition(R.anim.f154875ep, R.anim.f154878es);
        }
        if (Cgi.URL_WALLET_GATE.equals(str)) {
            WalletGateData.getInstance().setData(this.mUin, jSONObject, System.currentTimeMillis());
            this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mCardType = jSONObject.optString("creditcard_type");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mUserAttr = jSONObject.optInt("user_attr");
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            this.mUserCertType = jSONObject.optInt("cert_user");
            String optString = jSONObject.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
            afterInitQwalletData();
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
}
