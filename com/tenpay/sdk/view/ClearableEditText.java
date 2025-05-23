package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class ClearableEditText extends TenpayEditText {
    public String defaultValue;
    Drawable imgX;
    OnTextChangedListener mOnTextChangedListener;
    protected int mPaddingB;
    protected int mPaddingL;
    protected int mPaddingR;
    protected int mPaddingT;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnTextChangedListener {
        void onTextChanged();
    }

    public ClearableEditText(Context context) {
        super(context);
        this.defaultValue = "";
        init(context);
    }

    private void init(Context context) {
        this.mPaddingT = getPaddingTop();
        this.mPaddingB = getPaddingBottom();
        this.mPaddingL = getPaddingLeft();
        this.mPaddingR = getPaddingRight();
        setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.view.ClearableEditText.1
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                InputMethodManager inputMethodManager;
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    i3 = 6;
                }
                if (i3 == 6 && (inputMethodManager = (InputMethodManager) ClearableEditText.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
                    inputMethodManager.hideSoftInputFromWindow(ClearableEditText.this.getWindowToken(), 0);
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return false;
            }
        });
        Drawable drawable = getResources().getDrawable(R.drawable.dw_);
        this.imgX = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.imgX.getIntrinsicHeight());
        setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.view.ClearableEditText.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z16) {
                if (!z16) {
                    ClearableEditText.this.removeClearButton();
                } else if (!ClearableEditText.this.getText().toString().equals("")) {
                    ClearableEditText.this.addClearButton();
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tenpay.sdk.view.ClearableEditText.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ClearableEditText clearableEditText = ClearableEditText.this;
                if (clearableEditText.getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > (clearableEditText.getWidth() - clearableEditText.getPaddingRight()) - ClearableEditText.this.imgX.getIntrinsicWidth()) {
                    clearableEditText.setText("");
                    ClearableEditText.this.removeClearButton();
                }
                return false;
            }
        });
        addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.view.ClearableEditText.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                OnTextChangedListener onTextChangedListener = ClearableEditText.this.mOnTextChangedListener;
                if (onTextChangedListener != null) {
                    onTextChangedListener.onTextChanged();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                if (ClearableEditText.this.isFocused()) {
                    ClearableEditText.this.manageClearButton();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
    }

    public void addClearButton() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.imgX, getCompoundDrawables()[3]);
        setCompoundDrawablePadding(5);
        setPadding(this.mPaddingL, this.mPaddingT, this.mPaddingR + 15, this.mPaddingB);
    }

    public void manageClearButton() {
        if (getText().toString().equals("")) {
            removeClearButton();
        } else {
            addClearButton();
        }
    }

    public void removeClearButton() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        setPadding(this.mPaddingL, this.mPaddingT, this.mPaddingR, this.mPaddingB);
    }

    public void setOnTextChangedListener(OnTextChangedListener onTextChangedListener) {
        this.mOnTextChangedListener = onTextChangedListener;
    }

    public ClearableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.defaultValue = "";
        init(context);
    }

    public ClearableEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.defaultValue = "";
        init(context);
    }
}
