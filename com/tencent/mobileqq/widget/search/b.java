package com.tencent.mobileqq.widget.search;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends AbsQUISearchBarStyler {
    /* JADX INFO: Access modifiers changed from: protected */
    public b(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public int getQUIStyleId() {
        return 5;
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public void updateLayout() {
        changeInputWidthConstraint(0);
        this.mEtInput.setFocusable(true);
        this.mEtInput.setFocusableInTouchMode(true);
        if (this.mSBBar.isAutoFocusable()) {
            this.mEtInput.requestFocus();
        }
        this.mSBBar.setPadding(0, 0, 0, 0);
        updateViewVisibility(this.mTvCancel, 8);
        updateViewVisibility(this.mIvBack, 8);
        updateViewVisibility(this.mVInputBg, 0);
        ViewGroup.LayoutParams layoutParams = this.mVInputBg.getLayoutParams();
        layoutParams.height = -1;
        this.mVInputBg.setLayoutParams(layoutParams);
    }
}
