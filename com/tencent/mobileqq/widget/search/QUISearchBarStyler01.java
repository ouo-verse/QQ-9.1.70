package com.tencent.mobileqq.widget.search;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUISearchBarStyler01 extends AbsQUISearchBarStyler {
    /* JADX INFO: Access modifiers changed from: protected */
    public QUISearchBarStyler01(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public SparseArray<SearchAnimProp> getAnimViewPropList() {
        int width = this.mSBBar.getWidth();
        int height = this.mSBBar.getHeight();
        SparseArray<SearchAnimProp> sparseArray = new SparseArray<>();
        SearchAnimProp visible = new SearchAnimProp().setId(this.mTvCancel.getId()).setX(width).setY(0).setWidth(height).setHeight(height).setVisible(false);
        sparseArray.put(visible.vId, visible);
        SearchAnimProp visible2 = new SearchAnimProp().setId(this.mIvBack.getId()).setX(ViewUtils.dpToPx(-36.0f)).setY(0).setWidth(ViewUtils.dpToPx(36.0f)).setHeight(height).setVisible(false);
        sparseArray.put(visible2.vId, visible2);
        SearchAnimProp visible3 = new SearchAnimProp().setId(this.mVInputBg.getId()).setX(ViewUtils.dpToPx(16.0f)).setY(ViewUtils.dpToPx(12.0f)).setWidth(width - ViewUtils.dpToPx(32.0f)).setHeight(height - ViewUtils.dpToPx(24.0f)).setVisible(true);
        sparseArray.put(visible3.vId, visible3);
        SearchAnimProp visible4 = new SearchAnimProp().setId(this.mFlSearchExt.getId()).setY(0).setWidth(this.mSBBar.getExtWidth()).setX(((width - this.mSBBar.getExtWidth()) - ViewUtils.dpToPx(50.0f)) / 2).setHeight(height).setVisible(true);
        sparseArray.put(visible4.vId, visible4);
        SearchAnimProp visible5 = new SearchAnimProp().setId(this.mLlAutoHint.getId()).setX(visible4.f317275x + visible4.width + ViewUtils.dpToPx(5.0f)).setY(ViewUtils.dpToPx(12.0f)).setWidth(-1).setHeight(-1).setVisible(true);
        sparseArray.put(visible5.vId, visible5);
        return sparseArray;
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public int getQUIStyleId() {
        return 1;
    }

    @Override // com.tencent.mobileqq.widget.search.AbsQUISearchBarStyler
    public void updateLayout() {
        int dpToPx = ViewUtils.dpToPx(16.0f);
        updateViewVisibility(this.mTvCancel, 8);
        changeInputWidthConstraint(-2);
        this.mSBBar.setPadding(dpToPx, 0, dpToPx, 0);
        this.mEtInput.setText("");
        this.mEtInput.clearFocus();
        updateViewVisibility(this.mIvBack, 8);
        updateViewVisibility(this.mVInputBg, 0);
    }
}
