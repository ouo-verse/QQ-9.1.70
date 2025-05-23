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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.TenpayEditText;
import com.tenpay.sdk.view.ValidDateEdit;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ChangeValidDateActivity extends NetBaseActivity implements View.OnClickListener {
    private TextView mBackBtn;
    protected boolean mBackKeyPressed;
    private TenpayEditText mBinInputBankCvv;
    private LinearLayout mBinInputBankCvvLayout;
    private ValidDateEdit mBinInputCreditThru;
    private View mBinInputCreditThruLayout;
    private View mBinInputCreditThruLine;
    private MyKeyboardWindow mBinKeyBoard;
    private Button mBinNext;
    protected String mCardInfo;
    private int mProcessType;
    private TextView mShowCardInfoTV;
    private String mShowCvv = "";
    public View.OnFocusChangeListener keyOnFocusChangeListener = new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.4
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(final View view, boolean z16) {
            if (z16) {
                if (view instanceof ClearableEditText) {
                    ((ClearableEditText) view).manageClearButton();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) ChangeValidDateActivity.this.getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                if (ChangeValidDateActivity.this.mBinInputBankCvv.hasFocus()) {
                    Drawable drawable = ChangeValidDateActivity.this.getResources().getDrawable(R.drawable.dw5);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    ChangeValidDateActivity.this.mBinInputBankCvv.setCompoundDrawables(ChangeValidDateActivity.this.mBinInputBankCvv.getCompoundDrawables()[0], ChangeValidDateActivity.this.mBinInputBankCvv.getCompoundDrawables()[1], drawable, ChangeValidDateActivity.this.mBinInputBankCvv.getCompoundDrawables()[3]);
                    ChangeValidDateActivity.this.mBinInputBankCvv.setCompoundDrawablePadding(3);
                } else {
                    ChangeValidDateActivity.this.mBinInputBankCvv.setCompoundDrawables(ChangeValidDateActivity.this.mBinInputBankCvv.getCompoundDrawables()[0], ChangeValidDateActivity.this.mBinInputBankCvv.getCompoundDrawables()[1], null, ChangeValidDateActivity.this.mBinInputBankCvv.getCompoundDrawables()[3]);
                }
                if (ChangeValidDateActivity.this.mBinInputCreditThru.hasFocus()) {
                    Drawable drawable2 = ChangeValidDateActivity.this.getResources().getDrawable(R.drawable.e0p);
                    drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                    ChangeValidDateActivity.this.mBinInputCreditThru.setCompoundDrawables(ChangeValidDateActivity.this.mBinInputCreditThru.getCompoundDrawables()[0], ChangeValidDateActivity.this.mBinInputCreditThru.getCompoundDrawables()[1], drawable2, ChangeValidDateActivity.this.mBinInputCreditThru.getCompoundDrawables()[3]);
                    ChangeValidDateActivity.this.mBinInputCreditThru.setCompoundDrawablePadding(3);
                } else {
                    ChangeValidDateActivity.this.mBinInputCreditThru.setCompoundDrawables(ChangeValidDateActivity.this.mBinInputCreditThru.getCompoundDrawables()[0], ChangeValidDateActivity.this.mBinInputCreditThru.getCompoundDrawables()[1], null, ChangeValidDateActivity.this.mBinInputCreditThru.getCompoundDrawables()[3]);
                }
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangeValidDateActivity.this.mBinKeyBoard.setXMode(0);
                        ChangeValidDateActivity.this.mBinKeyBoard.setVisibility(0);
                        ChangeValidDateActivity.this.mBinKeyBoard.setInputEditText((EditText) view);
                    }
                }, 200L);
                return;
            }
            if (view instanceof ClearableEditText) {
                ((ClearableEditText) view).removeClearButton();
            }
            if (!ChangeValidDateActivity.this.mBinInputCreditThru.isFocused() && !ChangeValidDateActivity.this.mBinInputBankCvv.isFocused()) {
                ChangeValidDateActivity.this.mBinKeyBoard.setVisibility(8);
            }
        }
    };
    public View.OnClickListener keyOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ChangeValidDateActivity.this.mBinKeyBoard.getVisibility() == 8) {
                view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangeValidDateActivity.this.mBinKeyBoard.setVisibility(0);
                        ChangeValidDateActivity.this.mBinKeyBoard.setXMode(0);
                        ChangeValidDateActivity.this.mBinKeyBoard.setInputEditText((EditText) view);
                    }
                }, 200L);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    private void go2PayActivity() {
        Intent intent = new Intent();
        intent.putExtra("ValidDate", this.mBinInputCreditThru.getData());
        intent.putExtra("CVV", this.mBinInputBankCvv.getText().toString());
        setResult(-1, intent);
        finish();
    }

    private void initInfo() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mCardInfo = intent.getStringExtra("update_card_str");
        this.mShowCvv = intent.getStringExtra("showCvv");
        this.mProcessType = intent.getIntExtra("processtype", 0);
    }

    private void initView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.card_info_show);
        this.mShowCardInfoTV = textView;
        textView.setText(this.mCardInfo);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setVisibility(8);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        this.mBackBtn = textView2;
        textView2.setText(R.string.e2i);
        this.mBackBtn.setVisibility(0);
        this.mBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                ChangeValidDateActivity changeValidDateActivity = ChangeValidDateActivity.this;
                if (changeValidDateActivity.mBackKeyPressed) {
                    com.tencent.mobileqq.qwallet.c.c("change.date.keyback", Integer.valueOf(changeValidDateActivity.mProcessType));
                    ChangeValidDateActivity.this.setResult(0, null);
                } else {
                    com.tencent.mobileqq.qwallet.c.c("change.date.cancel", Integer.valueOf(changeValidDateActivity.mProcessType));
                }
                ChangeValidDateActivity.this.setResult(0, null);
                ChangeValidDateActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.efb);
        this.mBinInputCreditThruLayout = view.findViewById(R.id.a9s);
        this.mBinInputCreditThruLine = view.findViewById(R.id.a9t);
        ValidDateEdit validDateEdit = (ValidDateEdit) view.findViewById(R.id.a9r);
        this.mBinInputCreditThru = validDateEdit;
        validDateEdit.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 5) {
                    int isValid = ChangeValidDateActivity.this.mBinInputCreditThru.isValid(System.currentTimeMillis() + (ChangeValidDateActivity.this.mTimestamp * 1000));
                    if (isValid == 3) {
                        QQToast.makeText(ChangeValidDateActivity.this.getContext(), R.string.efl, 0).show();
                        ChangeValidDateActivity.this.mBinInputCreditThru.onError();
                        ChangeValidDateActivity.this.mBinInputCreditThru.requestFocus();
                        return;
                    }
                    if (isValid != 0) {
                        QQToast.makeText(ChangeValidDateActivity.this.getContext(), R.string.efk, 0).show();
                        ChangeValidDateActivity.this.mBinInputCreditThru.onError();
                        ChangeValidDateActivity.this.mBinInputCreditThru.requestFocus();
                        return;
                    }
                    ChangeValidDateActivity.this.mBinInputCreditThru.clearError();
                    if (ChangeValidDateActivity.this.mBinInputBankCvv.getVisibility() == 0 && ChangeValidDateActivity.this.mBinInputBankCvv.getText().toString().length() == 0 && !TextUtils.isEmpty(ChangeValidDateActivity.this.mShowCvv) && ChangeValidDateActivity.this.mShowCvv.compareTo("1") == 0) {
                        ChangeValidDateActivity.this.mBinInputBankCvv.requestFocus();
                    }
                    if (!TextUtils.isEmpty(ChangeValidDateActivity.this.mShowCvv) && ChangeValidDateActivity.this.mShowCvv.compareTo("1") == 0) {
                        if (ChangeValidDateActivity.this.mBinInputBankCvv.getText().length() == 3) {
                            if (!ChangeValidDateActivity.this.mBinNext.isEnabled()) {
                                com.tencent.mobileqq.qwallet.c.c("change.date.enable", Integer.valueOf(ChangeValidDateActivity.this.mProcessType));
                            }
                            ChangeValidDateActivity.this.mBinNext.setEnabled(true);
                            return;
                        }
                        return;
                    }
                    if (!ChangeValidDateActivity.this.mBinNext.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("change.date.enable", Integer.valueOf(ChangeValidDateActivity.this.mProcessType));
                        ChangeValidDateActivity.this.mBinNext.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (ChangeValidDateActivity.this.mBinNext.isEnabled()) {
                    com.tencent.mobileqq.qwallet.c.c("change.date.disable", Integer.valueOf(ChangeValidDateActivity.this.mProcessType));
                    ChangeValidDateActivity.this.mBinNext.setEnabled(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mBinInputBankCvvLayout = (LinearLayout) view.findViewById(R.id.a9g);
        TenpayEditText tenpayEditText = (TenpayEditText) view.findViewById(R.id.a9e);
        this.mBinInputBankCvv = tenpayEditText;
        tenpayEditText.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.activity.ChangeValidDateActivity.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 3 && ChangeValidDateActivity.this.mBinInputCreditThru.getText().length() == 5) {
                    if (!ChangeValidDateActivity.this.mBinNext.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("change.date.enable", Integer.valueOf(ChangeValidDateActivity.this.mProcessType));
                    }
                    ChangeValidDateActivity.this.mBinNext.setEnabled(true);
                } else {
                    if (ChangeValidDateActivity.this.mBinNext.isEnabled()) {
                        com.tencent.mobileqq.qwallet.c.c("change.date.disable", Integer.valueOf(ChangeValidDateActivity.this.mProcessType));
                    }
                    ChangeValidDateActivity.this.mBinNext.setEnabled(false);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        TextView textView3 = (TextView) view.findViewById(R.id.a9f);
        if (!TextUtils.isEmpty(this.mShowCvv) && this.mShowCvv.compareTo("1") == 0) {
            this.mBinInputBankCvvLayout.setVisibility(0);
            textView3.setVisibility(0);
        } else {
            this.mBinInputBankCvvLayout.setVisibility(8);
            textView3.setVisibility(8);
        }
        this.mBinInputCreditThru.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputCreditThru.setOnClickListener(this.keyOnClickListener);
        this.mBinInputBankCvv.setOnFocusChangeListener(this.keyOnFocusChangeListener);
        this.mBinInputBankCvv.setOnClickListener(this.keyOnClickListener);
        Button button = (Button) view.findViewById(R.id.a9b);
        this.mBinNext = button;
        if (button != null) {
            button.setOnClickListener(this);
            this.mBinNext.setEnabled(false);
        }
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mBinKeyBoard = myKeyboardWindow;
        myKeyboardWindow.setVisibility(0);
        this.mBinKeyBoard.setInputEditText(this.mBinInputCreditThru);
        this.mBinKeyBoard.setXMode(0);
        QWalletUtils.hideSysKeyBorad(this.mBinInputCreditThru);
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

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        super.finish();
        getActivity().overridePendingTransition(0, R.anim.f154878es);
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
            com.tencent.mobileqq.qwallet.c.c("change.date.go", Integer.valueOf(this.mProcessType));
            go2PayActivity();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initInfo();
        View inflate = layoutInflater.inflate(R.layout.add, viewGroup, false);
        initView(inflate);
        com.tencent.mobileqq.qwallet.c.c("change.date.show", Integer.valueOf(this.mProcessType));
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
