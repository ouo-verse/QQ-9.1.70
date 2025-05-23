package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.FiTConnectionView;
import com.tenpay.sdk.view.NameValueText;
import com.tenpay.util.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DepositSuccessActivity extends NetBaseActivity implements View.OnClickListener {
    protected int process_flag = 113;

    private void handleBalance(String str) {
        JSONObject data = WalletGateData.getInstance().getData();
        if (data != null) {
            String optString = data.optString("balance");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    data.put("balance", String.valueOf(Long.parseLong(optString) + Long.parseLong(str)));
                } catch (JSONException e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                }
            }
        }
    }

    private void initView(View view) {
        Intent intent = getIntent();
        ((TextView) view.findViewById(R.id.gfy)).setText(R.string.f171332e54);
        ((TextView) view.findViewById(R.id.gfx)).setText(R.string.f171333e55);
        setTopTitle(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ghh);
        LayoutInflater.from(getContext()).inflate(R.layout.age, (ViewGroup) linearLayout, true);
        linearLayout.setBackgroundColor(-1);
        int dp2Px = Utils.dp2Px(getContext(), 15.0f);
        if (Utils.getScreenWidth(getContext()) < 640) {
            dp2Px = Utils.dp2Px(getContext(), 10.0f);
        }
        QwLog.i("\u6210\u529f\u9875padding:" + dp2Px);
        linearLayout.setPadding(dp2Px, 0, dp2Px, 0);
        initWidget(intent, view);
        ((FiTConnectionView) view.findViewById(R.id.cbl)).setUrl("https://kf.qq.com/touch/mobileqq/qq_commen_problem.html");
    }

    private void initWidget(Intent intent, View view) {
        NameValueText nameValueText = (NameValueText) view.findViewById(R.id.jdu);
        String stringExtra = intent.getStringExtra("deposit_count");
        if (!Utils.isEmpty(stringExtra)) {
            nameValueText.setValueText(Utils.transformToMoney(stringExtra, 0) + getString(R.string.ehr));
            handleBalance(stringExtra);
        }
        NameValueText nameValueText2 = (NameValueText) view.findViewById(R.id.deposit_bank);
        String stringExtra2 = intent.getStringExtra("bank_info");
        if (!Utils.isEmpty(stringExtra2)) {
            nameValueText2.setValueText(stringExtra2);
        }
        NameValueText nameValueText3 = (NameValueText) view.findViewById(R.id.f166597gg4);
        String stringExtra3 = intent.getStringExtra("pay_time");
        if (!Utils.isEmpty(stringExtra3)) {
            nameValueText3.setValueText(stringExtra3);
        }
        NameValueText nameValueText4 = (NameValueText) view.findViewById(R.id.f166596gg3);
        String stringExtra4 = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
        if (!Utils.isEmpty(stringExtra4)) {
            nameValueText4.setValueText(stringExtra4);
        }
    }

    private void setTopTitle(View view) {
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setVisibility(8);
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.e5_);
        TextView textView = (TextView) view.findViewById(R.id.dt_);
        textView.setOnClickListener(this);
        textView.setVisibility(0);
        textView.setText(R.string.e5o);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dt_) {
            com.tencent.mobileqq.qwallet.c.c("charge.success.close", Integer.valueOf(this.process_flag));
            TenUtils.notifyToExit(getContext(), this.mProssesID);
            WalletGateData.getInstance().clear();
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.process_flag = getIntent().getIntExtra("process_flag", 113);
        View inflate = layoutInflater.inflate(R.layout.agd, viewGroup, false);
        initView(inflate);
        com.tencent.mobileqq.qwallet.c.c("charge.success.show", Integer.valueOf(this.process_flag));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
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
