package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qwallet.common.QWalletNickNameServer;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.Cgi;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TransferOrderActivity extends NetBaseActivity {
    private JSONObject mExtraDataJson;
    protected volatile boolean mIsActivityExit = false;
    private boolean mIsCallBackCalled = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void callRewardCGI(Intent intent, String str) {
        synchronized (this) {
            if (this.mIsCallBackCalled) {
                return;
            }
            this.mIsCallBackCalled = true;
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("uin", this.mUin);
                hashMap.put("payer_name", this.mUserNick);
                hashMap.put("seller_name", str);
                hashMap.put("seller_uin", this.mExtraDataJson.optString("seller_uin"));
                hashMap.put("total_fee", this.mExtraDataJson.optString("total_fee"));
                hashMap.put("memo", this.mExtraDataJson.optString("memo"));
                hashMap.put("scene", this.mExtraDataJson.optString("scene"));
                hashMap.put(PublicAccountMessageUtilImpl.META_NAME, this.mExtraDataJson.optString(PublicAccountMessageUtilImpl.META_NAME));
                hashMap.put("reward_name", this.mExtraDataJson.optString("reward_name"));
                hashMap.put("auth_key", this.mExtraDataJson.optString("auth_key"));
                httpRequest(Cgi.URI_QWALLET_QPAY_REWARD_ORDER, hashMap);
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    private void goToPayActivity(JSONObject jSONObject) {
        Class<? extends QWalletBaseFragment> cls;
        Intent intent = new Intent();
        int optInt = jSONObject.optInt("is_confirm", 0);
        int optInt2 = jSONObject.optInt("is_callback", 0);
        if (optInt == 1) {
            intent.putExtra("transfer_payer_uin", jSONObject.optString("payer_uin"));
            intent.putExtra("transfer_payer_name", jSONObject.optString("payer_name"));
            intent.putExtra("transfer_seller_uin", jSONObject.optString("seller_uin"));
            intent.putExtra("transfer_seller_name", jSONObject.optString("seller_name"));
            intent.putExtra("transfer_reward_name", jSONObject.optString("reward_name"));
            intent.putExtra("transfer_total_fee", jSONObject.optString("total_fee"));
            cls = ConfirmTransactionActivity.class;
        } else {
            cls = PayActivity.class;
        }
        intent.putExtra("is_callback", optInt2);
        launchFragment(intent, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCreate$0(String str, String str2) {
        if (str.equals(str2)) {
            str2 = "";
        }
        callRewardCGI(getIntent(), str2);
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mIsActivityExit = true;
            return super.doOnKeyDown(i3, keyEvent);
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        final String str;
        super.onCreate(bundle);
        this.mEnterType = Cgi.ENTER_FROM_PAY;
        try {
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("extra_data"));
            this.mExtraDataJson = jSONObject;
            str = jSONObject.optString("seller_uin");
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            str = "";
        }
        QWalletNickNameServer.b(null, str, new Function1() { // from class: com.tenpay.sdk.activity.cw
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit lambda$onCreate$0;
                lambda$onCreate$0 = TransferOrderActivity.this.lambda$onCreate$0(str, (String) obj);
                return lambda$onCreate$0;
            }
        });
        getContext().getString(R.string.e9u);
        showQQPayLoading(0);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.TransferOrderActivity.1
            @Override // java.lang.Runnable
            public void run() {
                TransferOrderActivity transferOrderActivity = TransferOrderActivity.this;
                transferOrderActivity.callRewardCGI(transferOrderActivity.getIntent(), "");
            }
        }, 5000L);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (str.equals(Cgi.URI_QWALLET_QPAY_REWARD_ORDER)) {
            commonBlErrorPros(jSONObject, true);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URI_QWALLET_QPAY_REWARD_ORDER)) {
            this.mPayTokenId = jSONObject.optString("token_id");
            goToPayActivity(jSONObject);
            com.tencent.mobileqq.qwallet.c.c("otherapp.order.show", 11);
            finish();
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
