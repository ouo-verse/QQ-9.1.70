package com.tenpay.sdk.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.util.Utils;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class CreditPayGuideActivity extends NetBaseActivity {
    protected ImageView imageView;
    protected ImageView mBackBtn;
    protected Button mConfirmBtn;
    protected TextView mContractTxt;
    protected ImageView mHelpBtn;
    private String mHelpUrl;
    protected TextView mOutlineTxt;
    protected RelativeLayout mRootLayout;

    private void initView(View view) {
        this.mRootLayout = (RelativeLayout) view.findViewById(R.id.root_layout);
        ((TextView) view.findViewById(R.id.fjh)).setText(R.string.f171351ea4);
        ImageView imageView = (ImageView) view.findViewById(R.id.a47);
        this.mBackBtn = imageView;
        imageView.setVisibility(0);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.CreditPayGuideActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                com.tencent.mobileqq.qwallet.c.c("creditpay.smallopen.back", Integer.valueOf(CreditPayGuideActivity.this.getProcessType()));
                CreditPayGuideActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.imageView = (ImageView) view.findViewById(R.id.dce);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.az7);
        this.mHelpBtn = imageView2;
        imageView2.setImageResource(R.drawable.dw9);
        this.mHelpBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.CreditPayGuideActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (!TextUtils.isEmpty(CreditPayGuideActivity.this.mHelpUrl)) {
                    CreditPayGuideActivity creditPayGuideActivity = CreditPayGuideActivity.this;
                    creditPayGuideActivity.gotoH5(creditPayGuideActivity.mHelpUrl);
                    com.tencent.mobileqq.qwallet.c.c("creditpay.smallopen.why", Integer.valueOf(CreditPayGuideActivity.this.getProcessType()));
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mOutlineTxt = (TextView) view.findViewById(R.id.bce);
        TextView textView = (TextView) view.findViewById(R.id.bcc);
        this.mContractTxt = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.CreditPayGuideActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                CreditPayGuideActivity.this.gotoH5(Cgi.URI_CTPAY_CONTRACT);
                com.tencent.mobileqq.qwallet.c.c("creditpay.smallopen.protocol", Integer.valueOf(CreditPayGuideActivity.this.getProcessType()));
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        Button button = (Button) view.findViewById(R.id.bcb);
        this.mConfirmBtn = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.CreditPayGuideActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                com.tencent.mobileqq.qwallet.c.c("creditpay.smallopen.go", Integer.valueOf(CreditPayGuideActivity.this.getProcessType()));
                CreditPayGuideActivity.this.setResult(-1);
                CreditPayGuideActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }

    private void processData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TenUtils.saveOpenCtPayRedPointShown(getContext(), this.mUin);
        this.mOutlineTxt.setText(jSONObject.optString("outline_doc"));
        this.mContractTxt.setText(jSONObject.optString("contract_s1"));
        this.mConfirmBtn.setText(jSONObject.optString("button_doc"));
        String optString = jSONObject.optString("help_url");
        this.mHelpUrl = optString;
        if (TextUtils.isEmpty(optString)) {
            this.mHelpUrl = Cgi.URI_CTPAY_HELP;
        }
        this.mRootLayout.setVisibility(0);
        this.imageView.setVisibility(0);
        this.mConfirmBtn.setVisibility(0);
        com.tencent.mobileqq.qwallet.c.c("creditpay.smallopen.go", Integer.valueOf(getProcessType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQueryCtPayGuide(int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        httpRequestWithQQPayLoading(Cgi.URI_CTPAY_GUIDE, hashMap, i3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            finish();
            com.tencent.mobileqq.qwallet.c.c("creditpay.smallopen.keyback", Integer.valueOf(getProcessType()));
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        return 400;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.adm, viewGroup, false);
        initView(inflate);
        this.mRootLayout.post(new Runnable() { // from class: com.tenpay.sdk.activity.CreditPayGuideActivity.1
            @Override // java.lang.Runnable
            public void run() {
                CreditPayGuideActivity creditPayGuideActivity = CreditPayGuideActivity.this;
                creditPayGuideActivity.sendQueryCtPayGuide(creditPayGuideActivity.mRootLayout.getHeight() - Utils.dp2Px(CreditPayGuideActivity.this.getContext(), 45.0f));
            }
        });
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        finish();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (Cgi.URI_CTPAY_GUIDE.equals(str)) {
            processData(jSONObject);
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
