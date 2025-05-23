package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ark.ark;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.payment.QWalletWearPayBean;
import com.tenpay.sdk.view.Switch;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class WearPaySettingActivity extends NetBaseActivity implements View.OnClickListener {
    private String devName;
    private TextView devNameText;
    private CompoundButton.OnCheckedChangeListener mSwichOnCheckListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tenpay.sdk.activity.WearPaySettingActivity.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (!z16) {
                WearPaySettingActivity.this.addTraceData("paycode.authorize.", "close");
                WearPaySettingActivity.this.clearAuthorInfo();
                WearPaySettingActivity wearPaySettingActivity = WearPaySettingActivity.this;
                wearPaySettingActivity.showOkTips(wearPaySettingActivity.getString(R.string.f171429ex4), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.WearPaySettingActivity.1.1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                    }
                });
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("macAddress", WearPaySettingActivity.this.macAddress);
                    jSONObject.put("devName", WearPaySettingActivity.this.devName);
                } catch (JSONException e16) {
                    QLog.e(((NetBaseActivity) WearPaySettingActivity.this).TAG, 1, "", e16);
                }
                Intent intent = new Intent();
                intent.putExtra(ark.ARKMETADATA_JSON, jSONObject.toString());
                WearPaySettingActivity.this.launchFragment(intent, WearVerifyActivity.class);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    };
    private Switch mSwitchBtn;
    private TextView mTitle;
    private String macAddress;

    /* JADX INFO: Access modifiers changed from: private */
    public void addTraceData(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(getProcessType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthorInfo() {
        com.tencent.mobileqq.qwallet.utils.g.s("qwallet_pay_code_wear_pay_bean_" + this.mUin);
    }

    private boolean isExistWearDev() {
        String auth;
        String str = null;
        QWalletWearPayBean qWalletWearPayBean = (QWalletWearPayBean) com.tencent.mobileqq.qwallet.utils.g.h("qwallet_pay_code_wear_pay_bean_" + this.mUin, QWalletWearPayBean.class, null);
        if (qWalletWearPayBean == null) {
            auth = null;
        } else {
            auth = qWalletWearPayBean.getAuth();
        }
        if (TextUtils.isEmpty(auth)) {
            return false;
        }
        String[] split = new String(Base64.decode(auth, 0)).split(",");
        if (split.length > 1) {
            this.macAddress = split[1];
        }
        if (qWalletWearPayBean != null) {
            str = qWalletWearPayBean.getDevName();
        }
        this.devName = str;
        return true;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.agp, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleName);
        this.mTitle = textView;
        textView.setText(R.string.ex7);
        Switch r36 = (Switch) inflate.findViewById(R.id.gju);
        this.mSwitchBtn = r36;
        r36.setSwitchNoSkin();
        this.devNameText = (TextView) inflate.findViewById(R.id.gjt);
        ((TextView) inflate.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mSwitchBtn.setOnCheckedChangeListener(null);
        if (isExistWearDev()) {
            this.mSwitchBtn.setChecked(true);
            this.devNameText.setText(R.string.ex6);
            this.devNameText.setText(((Object) this.devNameText.getText()) + this.devName);
        } else {
            this.mSwitchBtn.setChecked(false);
        }
        this.mSwitchBtn.setOnCheckedChangeListener(this.mSwichOnCheckListener);
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
