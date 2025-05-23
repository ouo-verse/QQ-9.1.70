package com.tencent.mobileqq.widget.search;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class AbsQUISearchBarStyler {
    protected QuickPinyinEditText mEtInput;
    protected FrameLayout mFlSearchExt;
    protected ImageView mIvBack;
    protected ImageView mIvClear;
    protected AutoHintLayout mLlAutoHint;
    protected QUISearchBar mSBBar;
    protected TextView mTvCancel;
    protected View mVInputBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsQUISearchBarStyler(@NonNull QUISearchBar qUISearchBar) {
        this.mSBBar = qUISearchBar;
        this.mVInputBg = qUISearchBar.mVInputBg;
        this.mIvBack = qUISearchBar.mIvBack;
        this.mIvClear = qUISearchBar.mIvClear;
        this.mTvCancel = qUISearchBar.mTvCancel;
        this.mLlAutoHint = qUISearchBar.mLlAutoHint;
        this.mEtInput = qUISearchBar.mEtInput;
        this.mFlSearchExt = qUISearchBar.mFlSearchExt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeInputWidthConstraint(int i3) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mSBBar);
        constraintSet.constrainWidth(this.mLlAutoHint.getId(), i3);
        constraintSet.applyTo(this.mSBBar);
    }

    public SparseArray<SearchAnimProp> getAnimViewPropList() {
        return null;
    }

    protected Context getContext() {
        return this.mSBBar.getContext();
    }

    @NonNull
    public QUISearchBarResource getCustomTheme() {
        return this.mSBBar.getCustomResource();
    }

    public abstract int getQUIStyleId();

    public abstract void updateLayout();

    public void updateOnlyThemeWithColorType(int i3, int i16) {
        this.mSBBar.setBackground(getCustomTheme().getBackground(this.mSBBar));
        this.mVInputBg.setBackground(getCustomTheme().getInputBackground(this.mSBBar));
    }

    public void updateTheme(int i3, int i16) {
        updateOnlyThemeWithColorType(i3, i16);
        this.mIvClear.setImageDrawable(getCustomTheme().getClearIcon(this.mSBBar));
        this.mIvBack.setImageDrawable(getCustomTheme().getBackIcon(this.mSBBar));
        this.mTvCancel.setTextColor(getCustomTheme().getCancelColor(this.mSBBar));
        this.mEtInput.setTextColor(getCustomTheme().getTextColor(this.mSBBar));
        this.mEtInput.setHintTextColor(getCustomTheme().getHintTextColor(this.mSBBar));
        this.mEtInput.setHighlightColor(getCustomTheme().getHighlightColor(this.mSBBar));
        if (Build.VERSION.SDK_INT > 28) {
            this.mEtInput.setTextCursorDrawable(getCustomTheme().getCursorDrawable(this.mSBBar));
        }
        this.mLlAutoHint.x(i3, i16, this.mSBBar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateViewVisibility(View view, int i3) {
        if (view.getVisibility() == i3) {
            return;
        }
        view.setVisibility(i3);
    }
}
