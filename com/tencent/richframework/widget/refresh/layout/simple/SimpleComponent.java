package com.tencent.richframework.widget.refresh.layout.simple;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SimpleComponent extends RelativeLayout implements IRefreshComponent {
    protected SpinnerStyle mSpinnerStyle;
    protected IRefreshComponent mWrappedInternal;
    protected View mWrappedView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleComponent(@NonNull View view) {
        this(view, view instanceof IRefreshComponent ? (IRefreshComponent) view : null);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int i3, float f16, boolean z16) {
        return false;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if ((obj instanceof IRefreshComponent) && getView() == ((IRefreshComponent) obj).getView()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NonNull
    public SpinnerStyle getSpinnerStyle() {
        int i3;
        SpinnerStyle spinnerStyle = this.mSpinnerStyle;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            return iRefreshComponent.getSpinnerStyle();
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                SpinnerStyle spinnerStyle2 = ((SmartRefreshLayout.LayoutParams) layoutParams).spinnerStyle;
                this.mSpinnerStyle = spinnerStyle2;
                if (spinnerStyle2 != null) {
                    return spinnerStyle2;
                }
            }
            if (layoutParams != null && ((i3 = layoutParams.height) == 0 || i3 == -1)) {
                for (SpinnerStyle spinnerStyle3 : SpinnerStyle.values) {
                    if (spinnerStyle3.scale) {
                        this.mSpinnerStyle = spinnerStyle3;
                        return spinnerStyle3;
                    }
                }
            }
        }
        SpinnerStyle spinnerStyle4 = SpinnerStyle.Translate;
        this.mSpinnerStyle = spinnerStyle4;
        return spinnerStyle4;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NonNull
    public View getView() {
        View view = this.mWrappedView;
        if (view == null) {
            return this;
        }
        return view;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this && iRefreshComponent.isSupportHorizontalDrag()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(@NonNull IRefreshLayout iRefreshLayout, boolean z16) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            return iRefreshComponent.onFinish(iRefreshLayout, z16);
        }
        return 0;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onHorizontalDrag(float f16, int i3, int i16) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            iRefreshComponent.onHorizontalDrag(f16, i3, i16);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onInitialized(@NonNull IRefreshKernel iRefreshKernel, int i3, int i16) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            iRefreshComponent.onInitialized(iRefreshKernel, i3, i16);
            return;
        }
        View view = this.mWrappedView;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                iRefreshKernel.requestDrawBackgroundFor(this, ((SmartRefreshLayout.LayoutParams) layoutParams).backgroundColor);
            }
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean z16, float f16, int i3, int i16, int i17) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            iRefreshComponent.onMoving(z16, f16, i3, i16, i17);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onReleased(@NonNull IRefreshLayout iRefreshLayout, int i3, int i16) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            iRefreshComponent.onReleased(iRefreshLayout, i3, i16);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(@NonNull IRefreshLayout iRefreshLayout, int i3, int i16) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            iRefreshComponent.onStartAnimator(iRefreshLayout, i3, i16);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NonNull IRefreshLayout iRefreshLayout, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            if ((this instanceof IRefreshFooter) && (iRefreshComponent instanceof IRefreshHeader)) {
                if (refreshState.isFooter) {
                    refreshState = refreshState.toHeader();
                }
                if (refreshState2.isFooter) {
                    refreshState2 = refreshState2.toHeader();
                }
            } else if ((this instanceof IRefreshHeader) && (iRefreshComponent instanceof IRefreshFooter)) {
                if (refreshState.isHeader) {
                    refreshState = refreshState.toFooter();
                }
                if (refreshState2.isHeader) {
                    refreshState2 = refreshState2.toFooter();
                }
            }
            IRefreshComponent iRefreshComponent2 = this.mWrappedInternal;
            if (iRefreshComponent2 != null) {
                iRefreshComponent2.onStateChanged(iRefreshLayout, refreshState, refreshState2);
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean z16) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if ((iRefreshComponent instanceof IRefreshFooter) && ((IRefreshFooter) iRefreshComponent).setNoMoreData(z16)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(@ColorInt int... iArr) {
        IRefreshComponent iRefreshComponent = this.mWrappedInternal;
        if (iRefreshComponent != null && iRefreshComponent != this) {
            iRefreshComponent.setPrimaryColors(iArr);
        }
    }

    protected SimpleComponent(@NonNull View view, @Nullable IRefreshComponent iRefreshComponent) {
        super(view.getContext(), null, 0);
        this.mWrappedView = view;
        this.mWrappedInternal = iRefreshComponent;
        if ((this instanceof IRefreshFooter) && (iRefreshComponent instanceof IRefreshHeader) && iRefreshComponent.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
            iRefreshComponent.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof IRefreshHeader) {
            IRefreshComponent iRefreshComponent2 = this.mWrappedInternal;
            if ((iRefreshComponent2 instanceof IRefreshFooter) && iRefreshComponent2.getSpinnerStyle() == SpinnerStyle.MatchLayout) {
                iRefreshComponent.getView().setScaleY(-1.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleComponent(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
