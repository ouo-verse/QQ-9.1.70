package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class PhoneInputActivity extends NetBaseActivity implements View.OnClickListener {
    public static final String INTENT_KEY_PHONE = "phone";
    public static final String INTENT_KEY_TOKEN = "token";
    private String mPhoneNum;
    private EditText mPhoneNumEt;
    private CountDownTimer mTimer;
    private Button mVerifyBtn;
    private EditText mVerifyCodeEt;
    private Button mVerifySendBtn;

    private void checkMsgCodeFromServer(String str) {
        String obj = this.mPhoneNumEt.getText().toString();
        String str2 = this.mPhoneNum;
        if (str2 != null && str2.equals(obj)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", this.mUin);
            hashMap.put(DeviceType.DeviceCategory.MOBILE, obj);
            hashMap.put("verify_code", str);
            hashMap.put("type", "1");
            httpRequest(Cgi.URL_SHIMING_CHECK_MSG, hashMap);
            return;
        }
        QQToast.makeText(getContext(), "\u53f7\u7801\u53d1\u751f\u53d8\u5316\uff0c\u8bf7\u4ece\u65b0\u83b7\u53d6\u9a8c\u8bc1\u7801", 0).show();
    }

    private void initView(View view) {
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        this.mPhoneNumEt = (EditText) view.findViewById(R.id.a7r);
        this.mVerifyCodeEt = (EditText) view.findViewById(R.id.f166959jf0);
        this.mVerifySendBtn = (Button) view.findViewById(R.id.f166961jf2);
        Button button = (Button) view.findViewById(R.id.jez);
        this.mVerifyBtn = button;
        button.setOnClickListener(this);
        this.mVerifySendBtn.setOnClickListener(this);
        this.mPhoneNumEt.addTextChangedListener(new x05.b() { // from class: com.tenpay.sdk.activity.PhoneInputActivity.1
            @Override // x05.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (PhoneInputActivity.this.isMobileNumber(editable.toString())) {
                    if (PhoneInputActivity.this.mTimer == null) {
                        PhoneInputActivity.this.addUploadData("guardian.phone.enable");
                        PhoneInputActivity.this.mVerifySendBtn.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (PhoneInputActivity.this.mVerifySendBtn.isEnabled()) {
                    PhoneInputActivity.this.addUploadData("guardian.phone.disable");
                    PhoneInputActivity.this.mVerifySendBtn.setEnabled(false);
                }
            }
        });
        this.mVerifyCodeEt.addTextChangedListener(new x05.b() { // from class: com.tenpay.sdk.activity.PhoneInputActivity.2
            @Override // x05.b, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.toString().trim().length() >= 6) {
                    PhoneInputActivity.this.mVerifyBtn.setEnabled(true);
                    PhoneInputActivity.this.addUploadData("guardian.sms.enable");
                } else if (PhoneInputActivity.this.mVerifyBtn.isEnabled()) {
                    PhoneInputActivity.this.addUploadData("guardian.sms.disable");
                    PhoneInputActivity.this.mVerifyBtn.setEnabled(false);
                }
            }
        });
        this.mPhoneNumEt.requestFocus();
    }

    private void startSendMsgToServer() {
        String obj = this.mPhoneNumEt.getText().toString();
        if (!isMobileNumber(obj)) {
            QQToast.makeText(getContext(), "\u7535\u8bdd\u53f7\u7801\u9519\u8bef", 0).show();
            return;
        }
        this.mPhoneNum = obj;
        this.mVerifyCodeEt.requestFocus();
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put(DeviceType.DeviceCategory.MOBILE, obj);
        hashMap.put("type", "1");
        httpRequest(Cgi.URL_SHIMING_SEND_MSG, hashMap);
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

    public boolean isMobileNumber(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 11) {
            return str.startsWith("1");
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        QQToast.makeText(getApplicationContext(), jSONObject.optString("retmsg"), 0).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.jez) {
            com.tencent.mobileqq.qwallet.c.e("realname.phonenumber.checkconfirm", "", "", "", "");
            checkMsgCodeFromServer(this.mVerifyCodeEt.getText().toString().trim());
            addUploadData("guardian.sms.go");
        } else if (view.getId() == R.id.ivTitleBtnLeft) {
            com.tencent.mobileqq.qwallet.c.e("realname.phonenumber.checkback", "", "", "", "");
            doOnBackPressed();
        } else if (view.getId() == R.id.f166961jf2) {
            com.tencent.mobileqq.qwallet.c.e("realname.phonenumber.checkobtain", "", "", "", "");
            addUploadData("guardian.sms.regain");
            startSendMsgToServer();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        com.tencent.mobileqq.qwallet.c.e("realname.phonenumber.checkshow", "", "", "", "");
        View inflate = layoutInflater.inflate(R.layout.aak, viewGroup, false);
        initView(inflate);
        addUploadData("guardian.phone.show");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URL_SHIMING_SEND_MSG)) {
            CountDownTimer countDownTimer = this.mTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.mTimer = null;
            }
            CountDownTimer countDownTimer2 = new CountDownTimer(60000L, 1000L) { // from class: com.tenpay.sdk.activity.PhoneInputActivity.3
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    QwLog.i("time finished...");
                    PhoneInputActivity phoneInputActivity = PhoneInputActivity.this;
                    if (phoneInputActivity.isMobileNumber(phoneInputActivity.mPhoneNumEt.getText().toString())) {
                        PhoneInputActivity.this.mVerifySendBtn.setEnabled(true);
                        PhoneInputActivity.this.mVerifySendBtn.setText("\u91cd\u65b0\u83b7\u53d6");
                    } else {
                        PhoneInputActivity.this.mVerifySendBtn.setEnabled(false);
                        PhoneInputActivity.this.mVerifySendBtn.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
                    }
                    PhoneInputActivity.this.mTimer = null;
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    QwLog.i("time: " + j3);
                    PhoneInputActivity.this.mVerifySendBtn.setEnabled(false);
                    PhoneInputActivity.this.mVerifySendBtn.setText("\u5df2\u53d1\u9001 (" + (j3 / 1000) + ")");
                }
            };
            this.mTimer = countDownTimer2;
            countDownTimer2.start();
            return;
        }
        if (str.equals(Cgi.URL_SHIMING_CHECK_MSG)) {
            Intent intent = new Intent();
            intent.putExtra("phone", this.mPhoneNum);
            intent.putExtra("token", jSONObject.optString("token"));
            setResult(-1, intent);
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
