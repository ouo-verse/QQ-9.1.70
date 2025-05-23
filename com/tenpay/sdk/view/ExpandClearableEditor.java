package com.tenpay.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.util.Utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ExpandClearableEditor extends ClearableEditText implements View.OnTouchListener {
    private OnEditorButtonClickListener mBtnClickListener;
    private Context mContext;
    protected Drawable mDefaultImgRight;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnEditorButtonClickListener {
        void onDefaultRightButtonClicked();
    }

    public ExpandClearableEditor(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        if (context == null) {
            return;
        }
        Drawable drawable = getResources().getDrawable(R.drawable.f161516dz3);
        this.mDefaultImgRight = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mDefaultImgRight.getIntrinsicHeight());
        addTextChangedListener(new TextWatcher() { // from class: com.tenpay.sdk.view.ExpandClearableEditor.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ClearableEditText.OnTextChangedListener onTextChangedListener = ExpandClearableEditor.this.mOnTextChangedListener;
                if (onTextChangedListener != null) {
                    onTextChangedListener.onTextChanged();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                if (ExpandClearableEditor.this.isFocused()) {
                    ExpandClearableEditor.this.manageClearButton();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        setOnTouchListener(this);
        removeClearButton();
    }

    @Override // com.tenpay.sdk.view.ClearableEditText
    public void manageClearButton() {
        if (getText().toString().equals("")) {
            removeClearButton();
        } else {
            addClearButton();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null && motionEvent.getAction() == 1 && motionEvent.getX() > (getWidth() - getPaddingRight()) - this.imgX.getIntrinsicWidth()) {
            if (TextUtils.isEmpty(getText().toString())) {
                OnEditorButtonClickListener onEditorButtonClickListener = this.mBtnClickListener;
                if (onEditorButtonClickListener != null) {
                    onEditorButtonClickListener.onDefaultRightButtonClicked();
                }
            } else {
                setText("");
                removeClearButton();
            }
        }
        return false;
    }

    @Override // com.tenpay.sdk.view.ClearableEditText
    public void removeClearButton() {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mDefaultImgRight, getCompoundDrawables()[3]);
        setPadding(this.mPaddingL, this.mPaddingT, this.mPaddingR, this.mPaddingB);
    }

    public void setDefaultImgRight(Drawable drawable) {
        this.mDefaultImgRight = drawable;
        drawable.setBounds(0, 0, Utils.dp2Px(this.mContext, 24.0f), Utils.dp2Px(this.mContext, 24.0f));
        removeClearButton();
    }

    public void setEditorButtonClickListener(OnEditorButtonClickListener onEditorButtonClickListener) {
        this.mBtnClickListener = onEditorButtonClickListener;
    }

    public ExpandClearableEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ExpandClearableEditor(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        init(context);
    }
}
