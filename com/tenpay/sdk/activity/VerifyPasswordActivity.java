package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class VerifyPasswordActivity extends NetBaseActivity implements View.OnClickListener {
    private Button confirmBtn;
    protected MyKeyboardWindow mKeyboard;
    protected ClearableEditText mLongPwdEdit;
    protected SixPasswdDialogEditText mSixPasswdEdit;

    private String getPassword() {
        String inputText;
        if (this.mLongPwdEdit.getVisibility() == 0) {
            inputText = this.mLongPwdEdit.getText().toString();
        } else {
            inputText = this.mSixPasswdEdit.getInputText();
        }
        return inputText.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        this.confirmBtn.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        String inputText = this.mSixPasswdEdit.getInputText();
        if (inputText.length() > 5) {
            validatePayPass(inputText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(View view, boolean z16) {
        if (this.mSixPasswdEdit.isFocused()) {
            this.mKeyboard.setVisibility(0);
            this.mKeyboard.setInputEditText(this.mSixPasswdEdit);
        }
    }

    private void validatePayPass(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("purchaser_id", this.mUin);
        hashMap.put("p", str);
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("check_cft_bindmobile", "1");
        httpRequest(Cgi.URI_VALIDATE_PAY_PASS, hashMap);
    }

    protected void clearPassWord() {
        if (this.mSixPasswdEdit.getVisibility() == 0) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
        } else if (this.mLongPwdEdit.getVisibility() == 0) {
            this.mLongPwdEdit.setText("");
            this.mLongPwdEdit.setFocusable(true);
            this.mLongPwdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mLongPwdEdit);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            MyKeyboardWindow myKeyboardWindow = this.mKeyboard;
            if (myKeyboardWindow != null && myKeyboardWindow.getVisibility() == 0) {
                this.mKeyboard.setVisibility(8);
                return true;
            }
            finish();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
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
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        textView.setOnClickListener(this);
        textView.setVisibility(0);
        view.findViewById(R.id.ivTitleBtnRightText).setVisibility(8);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.yuu);
        this.mLongPwdEdit = clearableEditText;
        clearableEditText.setOnTextChangedListener(new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.cx
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public final void onTextChanged() {
                VerifyPasswordActivity.this.lambda$initView$0();
            }
        });
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.cy
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public final void onTextChange() {
                VerifyPasswordActivity.this.lambda$initView$1();
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.cz
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                VerifyPasswordActivity.this.lambda$initView$2(view2, z16);
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.b7p);
        this.confirmBtn = button;
        button.setOnClickListener(this);
        this.confirmBtn.setEnabled(false);
        if (getIntent().getIntExtra("pass_flag", 0) == 2) {
            QLog.i(((NetBaseActivity) this).TAG, 1, "six pwd user...");
            this.mLongPwdEdit.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.requestFocus();
            this.confirmBtn.setVisibility(8);
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.mSixPasswdEdit.getWindowToken(), 0);
            }
            this.mKeyboard.setVisibility(0);
            this.mKeyboard.setInputEditText(this.mSixPasswdEdit);
            this.mKeyboard.setXMode(0);
            return;
        }
        QLog.i(((NetBaseActivity) this).TAG, 1, "not six pwd user...");
        this.mSixPasswdEdit.setVisibility(8);
        this.mKeyboard.setVisibility(8);
        this.mLongPwdEdit.setVisibility(0);
        this.mLongPwdEdit.requestFocus();
        Utils.touchEditText(this.mHandler, this.mLongPwdEdit);
        this.confirmBtn.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            finish();
        } else if (id5 == R.id.b7p) {
            String password = getPassword();
            if (Utils.isEmpty(password)) {
                QQToast.makeText(getContext(), R.string.efw, 0).show();
            } else {
                validatePayPass(password);
            }
        } else if (id5 == R.id.iwz && this.mKeyboard.getVisibility() == 8) {
            view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.VerifyPasswordActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    VerifyPasswordActivity.this.mKeyboard.setVisibility(0);
                    VerifyPasswordActivity.this.mKeyboard.setXMode(3);
                    VerifyPasswordActivity.this.mKeyboard.setInputEditText((EditText) view);
                }
            }, 200L);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(8192);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fz9, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(jSONObject.optString("retcode"))) {
            clearPassWord();
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
        if (str.equals(Cgi.URI_VALIDATE_PAY_PASS)) {
            String password = getPassword();
            Intent intent = new Intent();
            intent.putExtra("verify_success_password", password);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
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
