package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeLayoutImpl extends ViewGroup implements IContainer, IView {
    private static final String TAG = "NativeLayoutImpl";
    private int mBackgroundColor;
    private Paint mBackgroundPaint;
    private int mBorderBottomLeftRadius;
    private int mBorderBottomRightRadius;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderTopLeftRadius;
    private int mBorderTopRightRadius;
    private int mBorderWidth;
    protected ViewBase mView;

    public NativeLayoutImpl(Context context) {
        super(context);
        this.mBackgroundColor = 0;
        this.mBorderTopLeftRadius = 0;
        this.mBorderTopRightRadius = 0;
        this.mBorderBottomLeftRadius = 0;
        this.mBorderBottomRightRadius = 0;
        this.mBorderWidth = 0;
        this.mBorderColor = -16777216;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public void attachViews() {
        attachViews(this.mView);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void comLayout(int i3, int i16, int i17, int i18) {
        if (this.mView != null) {
            layout(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public void destroy() {
        this.mView.destroy();
        this.mView = null;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        return layoutParams;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            return viewBase.getComMeasuredHeight();
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            return viewBase.getComMeasuredWidth();
        }
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public int getType() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public ViewBase getVirtualView() {
        return this.mView;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void measureComponent(int i3, int i16) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            setMeasuredDimension(viewBase.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            setMeasuredDimension(viewBase.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mBackgroundColor != 0) {
            if (this.mBackgroundPaint == null) {
                Paint paint = new Paint();
                this.mBackgroundPaint = paint;
                paint.setAntiAlias(true);
            }
            this.mBackgroundPaint.setColor(this.mBackgroundColor);
            VirtualViewUtils.drawBackground(canvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
        super.onDraw(canvas);
        if (this.mBorderWidth > 0) {
            if (this.mBorderPaint == null) {
                Paint paint2 = new Paint();
                this.mBorderPaint = paint2;
                paint2.setStyle(Paint.Style.STROKE);
                this.mBorderPaint.setAntiAlias(true);
            }
            this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
            this.mBorderPaint.setColor(this.mBorderColor);
            VirtualViewUtils.drawBorder(canvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.mBackgroundColor = i3;
    }

    public void setBorderBottomLeftRadius(int i3) {
        this.mBorderBottomLeftRadius = i3;
    }

    public void setBorderBottomRightRadius(int i3) {
        this.mBorderBottomRightRadius = i3;
    }

    public void setBorderColor(int i3) {
        this.mBorderColor = i3;
    }

    public void setBorderTopLeftRadius(int i3) {
        this.mBorderTopLeftRadius = i3;
    }

    public void setBorderTopRightRadius(int i3) {
        this.mBorderTopRightRadius = i3;
    }

    public void setBorderWidth(int i3) {
        this.mBorderWidth = i3;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public void setVirtualView(ViewBase viewBase) {
        if (viewBase != null) {
            this.mView = viewBase;
            viewBase.setHoldView(this);
            if (this.mView.shouldDraw()) {
                setWillNotDraw(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachViews(ViewBase viewBase) {
        if (LogUtils.shouldLog()) {
            LogUtils.d(TAG, "[attachViews] for [" + this.mView.getClass().getSimpleName() + ", " + this.mView.getName() + "]");
        }
        if (viewBase == null) {
            if (LogUtils.shouldLog()) {
                LogUtils.d(TAG, "[attachViews] did not attach since view is null");
                return;
            }
            return;
        }
        if (LogUtils.shouldLog()) {
            LogUtils.d(TAG, "[attachViews] try to attach [" + viewBase.getClass().getSimpleName() + ", " + viewBase.getName() + "]");
        }
        if (viewBase instanceof Layout) {
            if (viewBase.getNativeView() != null) {
                View nativeView = viewBase.getNativeView();
                if (nativeView != null) {
                    if (LogUtils.shouldLog()) {
                        LogUtils.d(TAG, "[attachViews] try to add native view of [" + viewBase.getClass().getSimpleName() + ", " + viewBase.getName() + "]");
                    }
                    addView(nativeView, new ViewGroup.LayoutParams(viewBase.getComLayoutParams().mLayoutWidth, viewBase.getComLayoutParams().mLayoutHeight));
                    if (LogUtils.shouldLog()) {
                        LogUtils.d(TAG, "[attachViews] child count after add native view: " + getChildCount());
                    }
                } else if (LogUtils.shouldLog()) {
                    LogUtils.d(TAG, "[attachViews] child native view is null");
                }
            } else {
                if (LogUtils.shouldLog()) {
                    LogUtils.d(TAG, "[attachViews] native view is null, attach subviews");
                }
                List<ViewBase> subViews = ((Layout) viewBase).getSubViews();
                if (subViews != null) {
                    Iterator<ViewBase> it = subViews.iterator();
                    while (it.hasNext()) {
                        attachViews(it.next());
                    }
                } else if (LogUtils.shouldLog()) {
                    LogUtils.d(TAG, "[attachViews] subViews is null");
                }
            }
        } else {
            View nativeView2 = viewBase.getNativeView();
            if (nativeView2 != null) {
                if (LogUtils.shouldLog()) {
                    LogUtils.d(TAG, "[attachViews] try to add native view of [" + viewBase.getClass().getSimpleName() + ", " + viewBase.getName() + "]");
                }
                addView(nativeView2, new ViewGroup.LayoutParams(viewBase.getComLayoutParams().mLayoutWidth, viewBase.getComLayoutParams().mLayoutHeight));
                if (LogUtils.shouldLog()) {
                    LogUtils.d(TAG, "[attachViews] child count after add native view: " + getChildCount());
                }
            } else if (LogUtils.shouldLog()) {
                LogUtils.d(TAG, "[attachViews] " + viewBase.getName() + " native view is null");
            }
        }
        if (LogUtils.shouldLog()) {
            LogUtils.d(TAG, "[attachViews] childCount after [" + this.mView.getClass().getSimpleName() + ", " + this.mView.getName() + "] attach children: " + getChildCount());
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public View getHolderView() {
        return this;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
    }
}
