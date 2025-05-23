package com.tenpay.sdk.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.TenpayEditText;
import com.tenpay.util.Utils;

/* loaded from: classes27.dex */
public class ChangePhoneNumActivity extends NetBaseActivity implements View.OnClickListener {
    protected TextView mBackBtn;
    protected boolean mBackKeyPressed;
    private TenpayEditText mBinInputBankCvv;
    private LinearLayout mBinInputBankCvvLayout;
    private ClearableEditText mBinInputPhone;
    private MyKeyboardWindow mBinKeyBoard;
    private Button mBinNext;
    private int mProcessType;
    private String phoneNum;
    private String mShowCvv = "";
    public View.OnFocusChangeListener keyOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(final View view, boolean z16) {
            if (z16) {
                if (view instanceof ClearableEditText) {
                    ((ClearableEditText) view).manageClearButton();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) ChangePhoneNumActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                if (ChangePhoneNumActivity.this.mBinInputBankCvv.hasFocus()) {
                    Drawable drawable = ChangePhoneNumActivity.this.getResources().getDrawable(R.drawable.dw5);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    ChangePhoneNumActivity.this.mBinInputBankCvv.setCompoundDrawables(ChangePhoneNumActivity.this.mBinInputBankCvv.getCompoundDrawables()[0], ChangePhoneNumActivity.this.mBinInputBankCvv.getCompoundDrawables()[1], drawable, ChangePhoneNumActivity.this.mBinInputBankCvv.getCompoundDrawables()[3]);
                    ChangePhoneNumActivity.this.mBinInputBankCvv.setCompoundDrawablePadding(3);
                } else {
                    ChangePhoneNumActivity.this.mBinInputBankCvv.setCompoundDrawables(ChangePhoneNumActivity.this.mBinInputBankCvv.getCompoundDrawables()[0], ChangePhoneNumActivity.this.mBinInputBankCvv.getCompoundDrawables()[1], null, ChangePhoneNumActivity.this.mBinInputBankCvv.getCompoundDrawables()[3]);
                }
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangePhoneNumActivity.this.mBinKeyBoard.setXMode(3);
                        ChangePhoneNumActivity.this.mBinKeyBoard.setVisibility(0);
                        ChangePhoneNumActivity.this.mBinKeyBoard.setInputEditText((EditText) view);
                    }
                }, 200L);
                return;
            }
            if (view instanceof ClearableEditText) {
                ((ClearableEditText) view).removeClearButton();
            }
            if (!ChangePhoneNumActivity.this.mBinInputPhone.isFocused() && !ChangePhoneNumActivity.this.mBinInputBankCvv.isFocused()) {
                ChangePhoneNumActivity.this.mBinKeyBoard.setVisibility(8);
            }
        }
    };
    public View.OnClickListener keyOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ChangePhoneNumActivity.this.mBinKeyBoard.getVisibility() == 8) {
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangePhoneNumActivity.this.mBinKeyBoard.setVisibility(0);
                        ChangePhoneNumActivity.this.mBinKeyBoard.setXMode(3);
                        ChangePhoneNumActivity.this.mBinKeyBoard.setInputEditText((EditText) view);
                    }
                }, 200L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    private void go2PayActivity() {
        Intent intent = new Intent();
        intent.putExtra("PhoneNum", this.mBinInputPhone.getText().toString());
        intent.putExtra("CVV", this.mBinInputBankCvv.getText().toString());
        setResult(-1, intent);
        finish();
    }

    private void initInfo() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mShowCvv = intent.getStringExtra("showCvv");
        this.mProcessType = intent.getIntExtra("processtype", 0);
        this.phoneNum = intent.getStringExtra("phone");
    }

    private void initView(View view) {
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setVisibility(8);
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mBackBtn = textView;
        textView.setText(R.string.e2i);
        this.mBackBtn.setVisibility(0);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                ChangePhoneNumActivity.this.setResult(0, null);
                ChangePhoneNumActivity.this.finish();
                ChangePhoneNumActivity changePhoneNumActivity = ChangePhoneNumActivity.this;
                if (changePhoneNumActivity.mBackKeyPressed) {
                    com.tencent.mobileqq.qwallet.c.c("change.phone.keyback", Integer.valueOf(changePhoneNumActivity.mProcessType));
                } else {
                    com.tencent.mobileqq.qwallet.c.c("change.phone.cancel", Integer.valueOf(changePhoneNumActivity.mProcessType));
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.efc);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.a9u);
        this.mBinInputPhone = clearableEditText;
        clearableEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66 && ChangePhoneNumActivity.this.mBinInputPhone.getText().toString().length() >= 11) {
                    ChangePhoneNumActivity.this.mBinNext.performClick();
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return false;
            }
        });
        this.mBinInputPhone.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ChangePhoneNumActivity.this.mBinInputPhone.getText().toString().length() < 11) {
                    if (ChangePhoneNumActivity.this.mBinNext.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("change.phone.disable", Integer.valueOf(ChangePhoneNumActivity.this.mProcessType));
                        ChangePhoneNumActivity.this.mBinInputPhone.requestFocus();
                        ChangePhoneNumActivity.this.mBinNext.setEnabled(false);
                        return;
                    }
                    return;
                }
                if (ChangePhoneNumActivity.this.mBinInputBankCvv.getVisibility() == 0 && ChangePhoneNumActivity.this.mBinInputBankCvv.getText().toString().length() == 0 && !TextUtils.isEmpty(ChangePhoneNumActivity.this.mShowCvv) && ChangePhoneNumActivity.this.mShowCvv.compareTo("1") == 0) {
                    ChangePhoneNumActivity.this.mBinInputBankCvv.requestFocus();
                }
                if (!TextUtils.isEmpty(ChangePhoneNumActivity.this.mShowCvv) && ChangePhoneNumActivity.this.mShowCvv.compareTo("1") == 0) {
                    if (ChangePhoneNumActivity.this.mBinInputBankCvv.getText().length() == 3 && !ChangePhoneNumActivity.this.mBinNext.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("change.phone.enable", Integer.valueOf(ChangePhoneNumActivity.this.mProcessType));
                        ChangePhoneNumActivity.this.mBinNext.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (!ChangePhoneNumActivity.this.mBinNext.isEnabled()) {
                    com.tencent.mobileqq.qwallet.c.c("change.phone.enable", Integer.valueOf(ChangePhoneNumActivity.this.mProcessType));
                    ChangePhoneNumActivity.this.mBinNext.setEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mBinInputPhone.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputPhone.setOnClickListener(this.keyOnClickListener);
        this.mBinInputBankCvvLayout = (LinearLayout) view.findViewById(R.id.a9g);
        TenpayEditText tenpayEditText = (TenpayEditText) view.findViewById(R.id.a9e);
        this.mBinInputBankCvv = tenpayEditText;
        tenpayEditText.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.ChangePhoneNumActivity.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 3 && ChangePhoneNumActivity.this.mBinInputPhone.getText().length() == 11) {
                    if (!ChangePhoneNumActivity.this.mBinNext.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("change.phone.enable", Integer.valueOf(ChangePhoneNumActivity.this.mProcessType));
                        ChangePhoneNumActivity.this.mBinNext.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (ChangePhoneNumActivity.this.mBinNext.isEnabled()) {
                    com.tencent.mobileqq.qwallet.c.c("change.phone.disable", Integer.valueOf(ChangePhoneNumActivity.this.mProcessType));
                    ChangePhoneNumActivity.this.mBinNext.setEnabled(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.a9f);
        if (!TextUtils.isEmpty(this.mShowCvv) && this.mShowCvv.compareTo("1") == 0) {
            this.mBinInputBankCvvLayout.setVisibility(0);
            textView2.setVisibility(0);
        } else {
            this.mBinInputBankCvvLayout.setVisibility(8);
            textView2.setVisibility(8);
        }
        this.mBinInputBankCvv.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputBankCvv.setOnClickListener(this.keyOnClickListener);
        Button button = (Button) view.findViewById(R.id.a9b);
        this.mBinNext = button;
        if (button != null) {
            button.setOnClickListener(this);
            this.mBinNext.setEnabled(false);
            if (!Utils.isEmpty(this.phoneNum)) {
                this.mBinInputPhone.setText(this.phoneNum);
                this.mBinNext.setEnabled(true);
            }
        }
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mBinKeyBoard = myKeyboardWindow;
        myKeyboardWindow.setVisibility(0);
        this.mBinKeyBoard.setInputEditText(this.mBinInputPhone);
        this.mBinKeyBoard.setXMode(0);
        QWalletUtils.hideSysKeyBorad(this.mBinInputPhone);
        QWalletUtils.hideSysKeyBorad(this.mBinInputBankCvv);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mBackKeyPressed = true;
            this.mBackBtn.performClick();
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.a9b) {
            com.tencent.mobileqq.qwallet.c.c("change.phone.go", Integer.valueOf(this.mProcessType));
            go2PayActivity();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initInfo();
        View inflate = layoutInflater.inflate(R.layout.adb, viewGroup, false);
        initView(inflate);
        com.tencent.mobileqq.qwallet.c.c("change.phone.show", Integer.valueOf(this.mProcessType));
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
