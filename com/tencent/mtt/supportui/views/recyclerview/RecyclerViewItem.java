package com.tencent.mtt.supportui.views.recyclerview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class RecyclerViewItem extends FrameLayout {
    public static int ITEM_VIEW_DEFAULT_HEIGHT = 360;

    /* renamed from: id, reason: collision with root package name */
    public int f337740id;
    boolean mBlockRequestLayout;
    public View mContentView;
    public RecyclerView.ViewHolderWrapper mHolder;
    ViewTreeObserver.OnPreDrawListener mLayoutListener;
    boolean mLayoutListenerPosted;
    protected RecyclerViewBase mParentRecyclerView;
    boolean mTouchEnabled;

    public RecyclerViewItem(Context context, RecyclerViewBase recyclerViewBase) {
        super(context);
        this.mTouchEnabled = true;
        this.mBlockRequestLayout = false;
        this.mParentRecyclerView = recyclerViewBase;
    }

    public void addContentView(View view, boolean z16) {
        if (view != null) {
            this.mContentView = view;
            this.mContentView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.mContentView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mTouchEnabled) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public View getContentView() {
        return this.mContentView;
    }

    public final boolean isPointInView(float f16, float f17) {
        if (f16 >= 0.0f && f16 < getRight() - getLeft() && f17 >= 0.0f && f17 < getBottom() - getTop()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        } catch (NullPointerException unused) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.mBlockRequestLayout = true;
        super.onLayout(z16, i3, i16, i17, i18);
        this.mBlockRequestLayout = false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        this.mTouchEnabled = z16;
    }

    public void setParentRecyclerView(RecyclerViewBase recyclerViewBase) {
        this.mParentRecyclerView = recyclerViewBase;
    }

    public void onStartAnimate(int i3) {
    }

    public void onPostAnimate(int i3, boolean z16) {
    }

    public void onAnimate(float f16, int i3, boolean z16) {
    }

    public void onPreAnimate(int i3, boolean z16, boolean z17) {
    }
}
