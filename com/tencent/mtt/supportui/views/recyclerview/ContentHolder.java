package com.tencent.mtt.supportui.views.recyclerview;

import android.view.View;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ContentHolder {
    public View mContentView;
    public Object mParentViewHolder;
    public int mContentLeftPadding = 0;
    public int mItemPaddingLeft = 0;
    public int mItemPaddingRight = 0;
    public boolean mFocusable = true;
    public boolean mForceBind = false;

    public void setEnable(boolean z16) {
        View view = this.mContentView;
        if (view != null && view.getParent() != null) {
            ((View) this.mContentView.getParent()).setEnabled(z16);
        }
    }

    public void inTraversals(int i3, int i16, RecyclerViewBase recyclerViewBase) {
    }
}
