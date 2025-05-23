package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class TenpayPluginSelectBankTypeActivity extends TenpayUtilActivity implements View.OnClickListener {
    public BankData data = new BankData();
    public int mProgressType;
    private JSONObject selectBankInfo;

    /* loaded from: classes27.dex */
    public static class BankData {
        public JSONObject credit;
        public JSONObject debit;
    }

    protected void addTraceData(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mIsMidas) {
            stringBuffer.append("tenpay.choose.bank.");
        } else {
            stringBuffer.append("bind.type.");
        }
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(this.mProgressType));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            setResult(0, new Intent());
            addTraceData("keyback");
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            addTraceData("back");
            finish();
        } else if (id5 == R.id.ivTitleBtnRightText) {
            if (this.selectBankInfo == null) {
                QQToast.makeText(getContext(), "\u8bf7\u9009\u62e9\u94f6\u884c\u5361\u7c7b\u578b", 0).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("bank", this.selectBankInfo.toString());
                if (this.mIsMidas) {
                    addTraceData(this.selectBankInfo.optString("code"));
                } else {
                    addTraceData("get");
                }
                setResult(1, intent);
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168575ad2, viewGroup, false);
        Intent intent = getIntent();
        if (intent != null) {
            this.mProgressType = intent.getIntExtra("process_flag", -1);
            String stringExtra = intent.getStringExtra("credit");
            String stringExtra2 = intent.getStringExtra("debit");
            if (stringExtra != null) {
                try {
                    this.data.credit = new JSONObject(stringExtra);
                } catch (JSONException e16) {
                    QLog.e(((TenpayUtilActivity) this).TAG, 1, "", e16);
                }
            }
            if (stringExtra2 != null) {
                this.data.debit = new JSONObject(stringExtra2);
            }
        }
        ((LinearLayout) inflate.findViewById(R.id.f166816if4)).setBackgroundColor(-1);
        ((TextView) inflate.findViewById(R.id.ivTitleName)).setText(R.string.e_3);
        ((TextView) inflate.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleBtnRightText);
        textView.setVisibility(0);
        textView.setText("\u5b8c\u6210");
        textView.setOnClickListener(this);
        View findViewById = inflate.findViewById(R.id.a4y);
        TextView textView2 = (TextView) inflate.findViewById(R.id.f164569a52);
        TextView textView3 = (TextView) inflate.findViewById(R.id.f164567a50);
        TextView textView4 = (TextView) inflate.findViewById(R.id.a4z);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.f164568a51);
        TextView textView5 = (TextView) inflate.findViewById(R.id.f164570a53);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.a4s);
        TextView textView6 = (TextView) inflate.findViewById(R.id.a4w);
        TextView textView7 = (TextView) inflate.findViewById(R.id.a4u);
        TextView textView8 = (TextView) inflate.findViewById(R.id.a4t);
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.a4v);
        TextView textView9 = (TextView) inflate.findViewById(R.id.a4x);
        JSONObject jSONObject = this.data.debit;
        if (jSONObject != null && (jSONObject.optInt("disabled") <= 0 || !"".equals(this.data.debit.optString("card_tail")))) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.TenpayPluginSelectBankTypeActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    TenpayPluginSelectBankTypeActivity tenpayPluginSelectBankTypeActivity = TenpayPluginSelectBankTypeActivity.this;
                    tenpayPluginSelectBankTypeActivity.selectBankInfo = tenpayPluginSelectBankTypeActivity.data.debit;
                    imageView.setVisibility(0);
                    imageView2.setVisibility(8);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            textView2.setVisibility(0);
            textView3.setVisibility(8);
            textView5.setVisibility(8);
            textView4.setVisibility(8);
        } else {
            findViewById.setClickable(false);
            textView2.setVisibility(8);
            textView3.setVisibility(0);
            textView5.setVisibility(0);
            textView4.setVisibility(8);
            imageView.setVisibility(8);
        }
        JSONObject jSONObject2 = this.data.credit;
        if (jSONObject2 != null && (jSONObject2.optInt("disabled") <= 0 || !"".equals(this.data.credit.optString("card_tail")))) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.TenpayPluginSelectBankTypeActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    TenpayPluginSelectBankTypeActivity tenpayPluginSelectBankTypeActivity = TenpayPluginSelectBankTypeActivity.this;
                    tenpayPluginSelectBankTypeActivity.selectBankInfo = tenpayPluginSelectBankTypeActivity.data.credit;
                    imageView2.setVisibility(0);
                    imageView.setVisibility(8);
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
            textView6.setVisibility(0);
            textView7.setVisibility(8);
            textView9.setVisibility(8);
            textView8.setVisibility(8);
        } else {
            linearLayout.setClickable(false);
            textView6.setVisibility(8);
            textView7.setVisibility(0);
            textView9.setVisibility(0);
            textView8.setVisibility(8);
            imageView2.setVisibility(8);
        }
        addTraceData("show");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
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
