package com.tencent.mobileqq.widget.search;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUISearchBarStyler02 extends AbsQUISearchBarStyler {
    /* JADX INFO: Access modifiers changed from: protected */
    public QUISearchBarStyler02(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
    }

    private int getHorPadding() {
        return ViewUtils.dpToPx(16.0f);
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public SparseArray<SearchAnimProp> getAnimViewPropList() {
        int width = this.mSBBar.getWidth();
        int height = this.mSBBar.getHeight();
        SparseArray<SearchAnimProp> sparseArray = new SparseArray<>();
        SearchAnimProp visible = new SearchAnimProp().setId(this.mTvCancel.getId()).setX((width - height) - ViewUtils.dpToPx(2.0f)).setY(0).setWidth(height).setHeight(height).setVisible(true);
        sparseArray.put(visible.vId, visible);
        SearchAnimProp visible2 = new SearchAnimProp().setId(this.mIvBack.getId()).setX(ViewUtils.dpToPx(-36.0f)).setY(0).setWidth(ViewUtils.dpToPx(36.0f)).setHeight(height).setVisible(false);
        sparseArray.put(visible2.vId, visible2);
        SearchAnimProp visible3 = new SearchAnimProp().setId(this.mVInputBg.getId()).setX(getHorPadding()).setY(ViewUtils.dpToPx(12.0f)).setWidth(visible.f317275x - getHorPadding()).setHeight(height - ViewUtils.dpToPx(24.0f)).setVisible(true);
        sparseArray.put(visible3.vId, visible3);
        SearchAnimProp visible4 = new SearchAnimProp().setId(this.mFlSearchExt.getId()).setX(visible3.f317275x).setY(0).setWidth(this.mFlSearchExt.getWidth()).setHeight(height).setVisible(true);
        sparseArray.put(visible4.vId, visible4);
        SearchAnimProp visible5 = new SearchAnimProp().setId(this.mLlAutoHint.getId()).setX(visible4.f317275x + visible4.width + ViewUtils.dpToPx(5.0f)).setY(visible3.f317276y).setWidth(-1).setHeight(-1).setVisible(true);
        sparseArray.put(visible5.vId, visible5);
        return sparseArray;
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public int getQUIStyleId() {
        return 2;
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public void updateLayout() {
        int horPadding = getHorPadding();
        updateViewVisibility(this.mTvCancel, 0);
        changeInputWidthConstraint(0);
        this.mEtInput.setFocusable(true);
        this.mEtInput.setFocusableInTouchMode(true);
        if (this.mSBBar.isAutoFocusable()) {
            this.mEtInput.requestFocus();
        }
        this.mSBBar.setPadding(horPadding, 0, 0, 0);
        updateViewVisibility(this.mIvBack, 8);
        updateViewVisibility(this.mVInputBg, 0);
    }
}
