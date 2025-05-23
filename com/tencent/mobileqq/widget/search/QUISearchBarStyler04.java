package com.tencent.mobileqq.widget.search;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUISearchBarStyler04 extends AbsQUISearchBarStyler {
    /* JADX INFO: Access modifiers changed from: protected */
    public QUISearchBarStyler04(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public int getQUIStyleId() {
        return 4;
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public void updateLayout() {
        changeInputWidthConstraint(0);
        this.mEtInput.setFocusable(true);
        this.mEtInput.setFocusableInTouchMode(true);
        if (this.mSBBar.isAutoFocusable()) {
            this.mEtInput.requestFocus();
        }
        this.mSBBar.setPadding(0, 0, ViewUtils.dpToPx(6.0f), 0);
        updateViewVisibility(this.mTvCancel, 8);
        updateViewVisibility(this.mIvBack, 8);
        updateViewVisibility(this.mVInputBg, 4);
    }
}
