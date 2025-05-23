package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.bank.BindBankModule;
import com.tenpay.idverify.IdVerifyModule;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.WalletGateData;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PsdMgrActivity extends NetBaseActivity {
    protected boolean isGoReset;
    protected TextView mBackBtn;
    protected Button mChangeBtn;
    protected String mMobile;
    protected int mPassFlag;
    protected ProgressBar mProgressBar;
    protected Button mResetBtn;
    protected TextView mTitle;
    protected JSONObject mWalletGateObj;
    private HashMap<String, String> walletRequest;

    protected void addTraceData(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("wallet.manage.");
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), 111);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.DEFAULT;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i16 == -1) {
            WalletGateData.getInstance().clear();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.mEnterType = 1;
        View inflate = layoutInflater.inflate(R.layout.afq, viewGroup, false);
        this.mProgressBar = (ProgressBar) inflate.findViewById(R.id.je7);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.PsdMgrActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                PsdMgrActivity.this.addTraceData("back");
                PsdMgrActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleName);
        this.mTitle = textView2;
        textView2.setText(R.string.e_d);
        Button button = (Button) inflate.findViewById(R.id.at8);
        this.mChangeBtn = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.PsdMgrActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (PsdMgrActivity.this.mProgressBar.getVisibility() != 0) {
                    PsdMgrActivity.this.addTraceData("changepwd");
                    HashMap hashMap = new HashMap();
                    try {
                        hashMap.put("uin", PsdMgrActivity.this.mUin);
                    } catch (Exception unused) {
                    }
                    PsdMgrActivity.this.httpRequest(Cgi.URI_QUERY_USER, hashMap);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        Button button2 = (Button) inflate.findViewById(R.id.i8g);
        this.mResetBtn = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.PsdMgrActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                PsdMgrActivity.this.addTraceData("resetpwd");
                PsdMgrActivity.this.isGoReset = true;
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("uin", PsdMgrActivity.this.mUin);
                    hashMap.put("reset_pwd_flag", "1");
                    StringBuffer stringBuffer = new StringBuffer();
                    int i3 = 0;
                    while (true) {
                        byte[] bArr = PsdMgrActivity.this.mGuid;
                        if (i3 >= bArr.length) {
                            break;
                        }
                        String hexString = Integer.toHexString(bArr[i3] & 255);
                        if (hexString.length() == 1) {
                            stringBuffer.append("0");
                        }
                        stringBuffer.append(hexString.toUpperCase());
                        i3++;
                    }
                    hashMap.put("qq_guid", stringBuffer.toString());
                    hashMap.put("qq_appid", PsdMgrActivity.this.mAppid);
                    hashMap.put("qq_appname", "com.tencent.mobileqq");
                } catch (Exception unused) {
                }
                PsdMgrActivity.this.httpRequest(Cgi.URI_QUERY_USER, hashMap);
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        HashMap<String, String> hashMap = new HashMap<>();
        this.walletRequest = hashMap;
        hashMap.put("uin", this.mUin);
        JSONObject data = WalletGateData.getInstance().getData();
        if (data != null) {
            this.mTimestamp = WalletGateData.getInstance().getSysTimeStamp();
            this.mBargainorName = data.optString("bargainor_true_name");
            this.mGoodsName = data.optString("desc");
            this.mTotalFee = data.optString("total_fee");
            this.mCardType = data.optString("creditcard_type");
            this.mCardID = data.optString("creditcard_id");
            this.mTrueName = data.optString("purchaser_true_name");
            this.mUserAttr = data.optInt("user_attr");
            this.mCacheVer = data.optString("interf_cache_ver");
            this.mUserCertType = data.optInt("cert_user");
            this.mMobile = data.optString(DeviceType.DeviceCategory.MOBILE);
            this.mPassFlag = data.optInt("pass_flag");
            String optString = data.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
            }
        } else {
            httpRequestNoLoading(Cgi.URL_WALLET_GATE, this.walletRequest);
            this.mProgressBar.setVisibility(0);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retmsg");
        if (28027203 == jSONObject.optInt("retcode")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Cgi.RETURN_MSG_JSON_ERROR_KEY, optString);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            setRetCodeAndGetBundle(ErrorCode.ERR_ACCOUNT_DONGJIE).putString(Cgi.RETURN_MSG_KEY, jSONObject2.toString());
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        addTraceData("show");
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        this.mProgressBar.setVisibility(8);
        if (Cgi.URL_WALLET_GATE.equals(str)) {
            this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
            this.mBargainorName = jSONObject.optString("bargainor_true_name");
            this.mGoodsName = jSONObject.optString("desc");
            this.mTotalFee = jSONObject.optString("total_fee");
            this.mCardType = jSONObject.optString("creditcard_type");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            this.mUserAttr = jSONObject.optInt("user_attr");
            this.mCacheVer = jSONObject.optString("interf_cache_ver");
            this.mUserCertType = jSONObject.optInt("cert_user");
            this.mMobile = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
            this.mPassFlag = jSONObject.optInt("pass_flag");
            String optString = jSONObject.optString("domain_name");
            if (!TextUtils.isEmpty(optString)) {
                setServerAddr(optString);
                return;
            }
            return;
        }
        if (Cgi.URI_QUERY_USER.equals(str)) {
            this.mCardType = jSONObject.optString("creditcard_type");
            this.mCardID = jSONObject.optString("creditcard_id");
            this.mTrueName = jSONObject.optString("purchaser_true_name");
            this.mPassFlag = jSONObject.optInt("pass_flag");
            if (this.isGoReset) {
                this.isGoReset = false;
                if (jSONObject.optInt("allow_reset_pwd") == 1) {
                    int optInt = jSONObject.optInt("reset_type", 2);
                    if (optInt == 2) {
                        Intent intent = new Intent();
                        intent.putExtra("forget_pass", true);
                        BindBankModule.INSTANCE.startVerifyForResult(this, intent, 20);
                        return;
                    } else {
                        if (optInt == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("forget_pass", true);
                            IdVerifyModule.startFromForgetPwd(this, intent2, 30);
                            return;
                        }
                        return;
                    }
                }
                String optString2 = jSONObject.optString("reset_pwd_info");
                if ("".equals(optString2)) {
                    optString2 = getString(R.string.e39);
                }
                QUIProxy.createCustomDialog(getContext(), 230, null, optString2, getString(R.string.e3_), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.PsdMgrActivity.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                    }
                });
                return;
            }
            Intent intent3 = new Intent();
            intent3.putExtra(DeviceType.DeviceCategory.MOBILE, this.mMobile);
            intent3.putExtra("pass_flag", this.mPassFlag);
            launchFragmentForResult(intent3, ChangePassActivity.class, 10);
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

    protected void addTraceData(int i3, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(i3));
    }
}
