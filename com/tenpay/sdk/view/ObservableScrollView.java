package com.tenpay.sdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.PagingScrollView;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ObservableScrollView extends PagingScrollView {
    private OnScrollChangedListener onScrollChangedListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnScrollChangedListener {
        void onScrollChanged(int i3, int i16, int i17, int i18);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.widget.PagingScrollView, com.tencent.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.PagingScrollView, com.tencent.widget.ScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        OnScrollChangedListener onScrollChangedListener = this.onScrollChangedListener;
        if (onScrollChangedListener != null) {
            onScrollChangedListener.onScrollChanged(i3, i16, i17, i18);
        }
    }

    public void setOnScrollListener(OnScrollChangedListener onScrollChangedListener) {
        this.onScrollChangedListener = onScrollChangedListener;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
