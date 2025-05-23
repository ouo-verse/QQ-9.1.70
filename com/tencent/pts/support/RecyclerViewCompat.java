package com.tencent.pts.support;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class RecyclerViewCompat extends RecyclerView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "RecyclerViewCompat";
    private boolean mIsInterruptedFling;
    private boolean mIsInterruptedPreFling;
    private OnFlingListener mOnFlingListener;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface OnFlingListener {
        boolean onFling(float f16, float f17);
    }

    public RecyclerViewCompat(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16))).booleanValue();
        }
        if (this.mIsInterruptedFling) {
            this.mIsInterruptedFling = false;
            return false;
        }
        return super.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }
        if (this.mIsInterruptedPreFling) {
            this.mIsInterruptedPreFling = false;
            return false;
        }
        return super.dispatchNestedPreFling(f16, f17);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (this.mOnFlingListener != null) {
            if (getLayoutManager() == null || isLayoutFrozen()) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = layoutManager.canScrollVertically();
            if (!canScrollHorizontally || Math.abs(i3) < getMinFlingVelocity()) {
                i3 = 0;
            }
            if (!canScrollVertically || Math.abs(i16) < getMinFlingVelocity()) {
                i16 = 0;
            }
            if (i3 == 0 && i16 == 0) {
                return false;
            }
            float f16 = i3;
            float f17 = i16;
            if (!dispatchNestedPreFling(f16, f17)) {
                if (canScrollHorizontally || canScrollVertically) {
                    z16 = true;
                }
                dispatchNestedFling(f16, f17, z16);
                OnFlingListener onFlingListener = this.mOnFlingListener;
                if (onFlingListener != null && onFlingListener.onFling(f16, f17)) {
                    return true;
                }
                this.mIsInterruptedPreFling = true;
                this.mIsInterruptedFling = true;
                return super.fling(i3, i16);
            }
        }
        return super.fling(i3, i16);
    }

    public OnFlingListener getOnFlingListenerCompat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (OnFlingListener) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mOnFlingListener;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) adapter);
        } else {
            super.setAdapter(adapter);
        }
    }

    public void setOnFlingListenerCompat(OnFlingListener onFlingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onFlingListener);
        } else {
            this.mOnFlingListener = onFlingListener;
        }
    }

    public RecyclerViewCompat(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public RecyclerViewCompat(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mIsInterruptedPreFling = false;
            this.mIsInterruptedFling = false;
        }
    }
}
