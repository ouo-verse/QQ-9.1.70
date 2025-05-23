package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class Container extends ViewGroup implements IContainer, IView {
    private static final String TAG = "Container_TMTEST";
    protected ViewBase mView;
    private final Map<String, ViewBase> mViewIdMapping;

    public Container(Context context) {
        super(context);
        this.mViewIdMapping = new HashMap();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public void attachViews() {
        attachViews(this.mView);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void comLayout(int i3, int i16, int i17, int i18) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            viewBase.comLayout(0, 0, i17 - i3, i18 - i16);
            layout(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public void destroy() {
        this.mView.destroy();
        this.mView = null;
    }

    public void detachViews() {
        this.mViewIdMapping.clear();
        removeAllViews();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        return layoutParams;
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

    public Map<String, ViewBase> getViewIdMapping() {
        return this.mViewIdMapping;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public ViewBase getVirtualView() {
        return this.mView;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void measureComponent(int i3, int i16) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            viewBase.measureComponent(i3, i16);
            setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            viewBase.onComLayout(z16, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        ViewBase viewBase = this.mView;
        if (viewBase != null) {
            viewBase.onComMeasure(i3, i16);
            setMeasuredDimension(this.mView.getComMeasuredWidth(), this.mView.getComMeasuredHeight());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        ViewBase viewBase = this.mView;
        if (viewBase != null && viewBase.shouldDraw()) {
            this.mView.comDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        onComLayout(z16, 0, 0, i17 - i3, i18 - i16);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        onComMeasure(i3, i16);
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

    protected void attachViews(ViewBase viewBase) {
        if (viewBase == null) {
            return;
        }
        if (viewBase instanceof Layout) {
            if (viewBase.getNativeView() != null) {
                View nativeView = viewBase.getNativeView();
                if (nativeView != null) {
                    addView(nativeView, new ViewGroup.LayoutParams(viewBase.getComLayoutParams().mLayoutWidth, viewBase.getComLayoutParams().mLayoutHeight));
                    return;
                }
                return;
            }
            List<ViewBase> subViews = ((Layout) viewBase).getSubViews();
            if (subViews != null) {
                Iterator<ViewBase> it = subViews.iterator();
                while (it.hasNext()) {
                    attachViews(it.next());
                }
                return;
            }
            return;
        }
        View nativeView2 = viewBase.getNativeView();
        if (nativeView2 != null) {
            addView(nativeView2, new ViewGroup.LayoutParams(viewBase.getComLayoutParams().mLayoutWidth, viewBase.getComLayoutParams().mLayoutHeight));
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer
    public View getHolderView() {
        return this;
    }
}
