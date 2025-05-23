package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.ErrorCode;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UnbindBankActivity extends NetBaseActivity implements View.OnClickListener {
    protected String mBankSerial;
    protected String mBankType;
    protected TextView mCancelBtn;
    protected boolean mIsBackKeyPressed;
    protected boolean mIsSixPasswdUser;
    protected MyKeyboardWindow mKeyboard;
    protected EditText mNormalPasswdEdit;
    protected String mPass;
    protected ProgressBar mProgressBar;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.UnbindBankActivity.1
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (UnbindBankActivity.this.mNormalPasswdEdit.getText().toString().trim().length() > 5) {
                if (!UnbindBankActivity.this.mUnbindBtn.isEnabled()) {
                    UnbindBankActivity.this.mUnbindBtn.setClickable(true);
                    UnbindBankActivity.this.mUnbindBtn.setEnabled(true);
                    com.tencent.mobileqq.qwallet.c.c("unbind.pwd.enable", 103);
                    return;
                }
                return;
            }
            if (UnbindBankActivity.this.mUnbindBtn.isEnabled()) {
                UnbindBankActivity.this.mUnbindBtn.setClickable(false);
                UnbindBankActivity.this.mUnbindBtn.setEnabled(false);
                com.tencent.mobileqq.qwallet.c.c("unbind.pwd.disable", 103);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    protected Button mUnbindBtn;

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            if (this.mKeyboard.getVisibility() == 0) {
                this.mKeyboard.setVisibility(8);
                return true;
            }
            this.mIsBackKeyPressed = true;
            this.mCancelBtn.performClick();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        String optString = jSONObject.optString("retcode");
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(optString)) {
            this.mSixPasswdEdit.setInputText("");
        }
        if (Cgi.URI_UNBIND_BANKCARD.equals(str) && ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(optString) && this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mNormalPasswdEdit.setText("");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightText) {
            if (this.mIsBackKeyPressed) {
                com.tencent.mobileqq.qwallet.c.c("unbind.pwd.keyback", 103);
            } else {
                com.tencent.mobileqq.qwallet.c.c("unbind.pwd.cancel", 103);
            }
            finish();
            getActivity().overridePendingTransition(0, R.anim.f154878es);
        } else if (id5 == R.id.jew) {
            com.tencent.mobileqq.qwallet.c.c("unbind.pwd.go", 103);
            if (this.mIsSixPasswdUser) {
                obj = this.mSixPasswdEdit.getInputText();
            } else {
                obj = this.mNormalPasswdEdit.getText().toString();
            }
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("uin", this.mUin);
                hashMap.put("bank_type", this.mBankType);
                hashMap.put("bind_serial", this.mBankSerial);
                hashMap.put("p", obj);
                hashMap.put("timestamp", this.mTimestamp + "");
            } catch (Exception unused) {
            }
            httpRequest(Cgi.URI_UNBIND_BANKCARD, hashMap);
        } else if (id5 == R.id.iwz && !this.mKeyboard.isShown()) {
            this.mKeyboard.setVisibility(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(8192);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.agm, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (ErrorCode.ERR_PAY_PASSWORD.equals(jSONObject.optString("retcode"))) {
            setResult(0);
            finish();
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
        ProgressBar progressBar = this.mProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (Cgi.URI_UNBIND_BANKCARD.equals(str)) {
            WalletGateData.getInstance().clear();
            com.tencent.mobileqq.qwallet.c.c("extra.unbind.ok", 103);
            this.mKeyboard.setVisibility(8);
            showOkTips(getApplicationContext().getString(R.string.e2n), new DialogInterface.OnDismissListener() { // from class: com.tenpay.sdk.activity.UnbindBankActivity.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    UnbindBankActivity.this.finish();
                }
            });
            com.tencent.mobileqq.qwallet.utils.g.l("qwallet_bindcard_refresh", true);
            Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
            retCodeAndGetBundle.putInt("result", 1);
            retCodeAndGetBundle.putString("retmsg", "");
            setResult(-1);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mCancelBtn = textView;
        textView.setText(R.string.e2i);
        this.mCancelBtn.setVisibility(0);
        this.mCancelBtn.setOnClickListener(this);
        view.findViewById(R.id.ivTitleBtnLeft).setVisibility(8);
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.e2m);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.je7);
        Button button = (Button) view.findViewById(R.id.jew);
        this.mUnbindBtn = button;
        button.setOnClickListener(this);
        this.mUnbindBtn.setEnabled(false);
        this.mUnbindBtn.setClickable(false);
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        EditText editText = (EditText) view.findViewById(R.id.fai);
        this.mNormalPasswdEdit = editText;
        editText.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.UnbindBankActivity.2
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public void onTextChange() {
                if (UnbindBankActivity.this.mSixPasswdEdit.getInputText().length() > 5) {
                    UnbindBankActivity.this.mUnbindBtn.setEnabled(true);
                    UnbindBankActivity.this.mUnbindBtn.setClickable(true);
                } else {
                    UnbindBankActivity.this.mUnbindBtn.setClickable(false);
                    UnbindBankActivity.this.mUnbindBtn.setEnabled(false);
                }
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.UnbindBankActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                if (UnbindBankActivity.this.mSixPasswdEdit.isFocused()) {
                    UnbindBankActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.UnbindBankActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            UnbindBankActivity.this.mKeyboard.setVisibility(0);
                            UnbindBankActivity unbindBankActivity = UnbindBankActivity.this;
                            unbindBankActivity.mKeyboard.setInputEditText(unbindBankActivity.mSixPasswdEdit);
                            UnbindBankActivity.this.mKeyboard.setXMode(3);
                        }
                    }, 300L);
                }
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.UnbindBankActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                boolean z16;
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    if (UnbindBankActivity.this.mSixPasswdEdit.getInputText() != null && UnbindBankActivity.this.mSixPasswdEdit.getInputText().length() > 5) {
                        UnbindBankActivity.this.mUnbindBtn.performClick();
                    }
                    z16 = true;
                } else {
                    z16 = false;
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return z16;
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            this.mBankType = intent.getStringExtra("bank_type");
            this.mBankSerial = intent.getStringExtra("bind_serial");
            this.mIsSixPasswdUser = "2".equals(intent.getStringExtra("pass_flag"));
        }
        if (this.mIsSixPasswdUser) {
            this.mNormalPasswdEdit.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mNormalPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.setVisibility(8);
            this.mNormalPasswdEdit.requestFocus();
            this.mNormalPasswdEdit.setClickable(true);
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        com.tencent.mobileqq.qwallet.c.c("unbind.pwd.show", 103);
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
