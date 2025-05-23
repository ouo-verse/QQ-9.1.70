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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.sdk.util.ConfigUtil;
import com.tenpay.sdk.util.JSONConstant;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.FiTConnectionView;
import com.tenpay.sdk.view.NameValueText;
import com.tenpay.util.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WithdrawSuccessActivity extends NetBaseActivity implements View.OnClickListener {
    protected int process_flag = 113;
    private int mIsPayFee = 0;

    private void handleBalance(String str) {
        JSONObject data = WalletGateData.getInstance().getData();
        if (data != null) {
            String optString = data.optString("balance");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    data.put("balance", String.valueOf(Long.parseLong(optString) - Long.parseLong(str)));
                } catch (JSONException e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                }
            }
        }
    }

    private void initWidget(Intent intent, View view) {
        long j3;
        String str;
        long j16;
        long j17;
        this.mIsPayFee = intent.getIntExtra(JSONConstant.KEY_PAY_FEE_FLAG, 0);
        String stringExtra = intent.getStringExtra(JSONConstant.KEY_CHARGE_FEE);
        String stringExtra2 = intent.getStringExtra("amount");
        if (!TextUtils.isEmpty(stringExtra2)) {
            j3 = Long.parseLong(stringExtra2);
        } else {
            j3 = 0;
        }
        if (this.mIsPayFee == 1) {
            if (!TextUtils.isEmpty(stringExtra)) {
                j17 = Long.valueOf(stringExtra).longValue();
            } else {
                j17 = 0;
            }
            j16 = j3 + j17;
            str = String.valueOf(j16);
        } else {
            str = stringExtra2;
            j16 = j3;
            j17 = 0;
        }
        NameValueText nameValueText = (NameValueText) view.findViewById(R.id.jeu);
        String string = getOutActivity().getResources().getString(R.string.ehr);
        if (!Utils.isEmpty(stringExtra2) && j3 != 0) {
            nameValueText.setValueText(Utils.transformToMoney(stringExtra2, 0) + string);
        } else {
            nameValueText.setValueText("0" + string);
        }
        NameValueText nameValueText2 = (NameValueText) view.findViewById(R.id.jet);
        if (this.mIsPayFee == 1) {
            if (!Utils.isEmpty(stringExtra) && j17 != 0) {
                nameValueText2.setValueText(Utils.transformToMoney(stringExtra, 0) + string);
            } else {
                nameValueText2.setValueText("0" + string);
            }
        } else {
            nameValueText2.setVisibility(8);
        }
        NameValueText nameValueText3 = (NameValueText) view.findViewById(R.id.fj8);
        if (!Utils.isEmpty(str) && j16 != 0) {
            nameValueText3.setValueText(Utils.fen2Yuan(str) + string);
            handleBalance(str);
        } else {
            nameValueText3.setValueText("0" + string);
        }
        NameValueText nameValueText4 = (NameValueText) view.findViewById(R.id.l4d);
        String stringExtra3 = intent.getStringExtra("bank_name");
        String stringExtra4 = intent.getStringExtra("card_tail");
        if (!Utils.isEmpty(stringExtra3) && !Utils.isEmpty(stringExtra4)) {
            nameValueText4.setValueText(stringExtra3 + "(" + stringExtra4 + ")");
        }
        NameValueText nameValueText5 = (NameValueText) view.findViewById(R.id.gi6);
        String stringExtra5 = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
        if (!Utils.isEmpty(stringExtra5)) {
            nameValueText5.setValueText(stringExtra5);
        }
        saveUserChoice(stringExtra3, stringExtra4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveUserChoice$0(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bank_name", str);
            jSONObject.put("card_tail", str2);
            ConfigUtil.saveWithDrawBank(this.mUin, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    private void saveUserChoice(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.activity.da
            @Override // java.lang.Runnable
            public final void run() {
                WithdrawSuccessActivity.this.lambda$saveUserChoice$0(str, str2);
            }
        }, 64, null, false);
    }

    private void setTopTitle(View view) {
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setVisibility(8);
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.egn);
        TextView textView = (TextView) view.findViewById(R.id.dt_);
        textView.setOnClickListener(this);
        textView.setVisibility(0);
        textView.setText(R.string.e5o);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    protected int defRetCode() {
        return 0;
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
        Intent intent = getIntent();
        ((LinearLayout) view.findViewById(R.id.gfw)).setVisibility(8);
        ((LinearLayout) view.findViewById(R.id.j85)).setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.l4i);
        TextView textView2 = (TextView) view.findViewById(R.id.l4j);
        TextView textView3 = (TextView) view.findViewById(R.id.l4b);
        TextView textView4 = (TextView) view.findViewById(R.id.l4c);
        TextView textView5 = (TextView) view.findViewById(R.id.l4n);
        TextView textView6 = (TextView) view.findViewById(R.id.l4o);
        ((FiTConnectionView) view.findViewById(R.id.cbl)).setUrl("https://kf.qq.com/touch/mobileqq/qq_commen_problem.html");
        String stringExtra = getIntent().getStringExtra("draw_succ_desc");
        QwLog.e("draw_succ_desc is " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                textView2.setText(jSONObject.optString("start_text"));
                textView.setText(jSONObject.optString("start_time"));
                textView4.setText(jSONObject.optString("process_text"));
                textView3.setText(jSONObject.optString("process_time"));
                textView6.setText(jSONObject.optString("end_text"));
                textView5.setText(jSONObject.optString("end_time"));
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
        setTopTitle(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ghh);
        LayoutInflater.from(getContext()).inflate(R.layout.agg, (ViewGroup) linearLayout, true);
        linearLayout.setBackgroundColor(-1);
        int dp2Px = Utils.dp2Px(getContext(), 15.0f);
        if (Utils.getScreenWidth(getContext()) < 640) {
            dp2Px = Utils.dp2Px(getContext(), 10.0f);
        }
        QwLog.i("\u6210\u529f\u9875padding:" + dp2Px);
        linearLayout.setPadding(dp2Px, 0, dp2Px, 0);
        initWidget(intent, view);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.dt_) {
            com.tencent.mobileqq.qwallet.c.c("cash.success.close", Integer.valueOf(this.process_flag));
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.process_flag = getIntent().getIntExtra(WithdrawActivity.WITHDRAW_PROCESS_FLAG, 113);
        View inflate = layoutInflater.inflate(R.layout.agd, viewGroup, false);
        initView(inflate);
        com.tencent.mobileqq.qwallet.c.c("cash.success.show", Integer.valueOf(this.process_flag));
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
