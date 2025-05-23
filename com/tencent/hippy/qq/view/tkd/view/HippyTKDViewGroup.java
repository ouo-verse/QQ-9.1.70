package com.tencent.hippy.qq.view.tkd.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.mtt.hippy.views.viewpager.HippyViewPager;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyTKDViewGroup extends HippyViewGroup implements HippyTKDCommonBorderHandler.HippyQBCommonBorder, HippyTKDSkinHandler.HippyQBCommonSkin {
    private int disableExternalScoll;
    HippyTKDSkinHandler mHippyTKDSkinHandler;
    private OnSizeChangeListener mOnSizeChangeListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface OnSizeChangeListener {
        void onHippyViewGroupSizeChanged(int i3, int i16, int i17, int i18);
    }

    public HippyTKDViewGroup(Context context) {
        super(context);
        this.disableExternalScoll = 0;
        this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
    }

    public void changeExternalScrollEnabled(boolean z16) {
        int i3 = 0;
        for (ViewParent parent = getParent(); parent != null && i3 < this.disableExternalScoll; parent = parent.getParent()) {
            if (parent instanceof HippyScrollView) {
                ((HippyScrollView) parent).setScrollEnabled(z16);
            } else if (parent instanceof HippyListView) {
                ((HippyListView) parent).setScrollEnable(z16);
            } else if (parent instanceof HippyViewPager) {
                ((HippyViewPager) parent).setScrollEnabled(z16);
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        HippyExceptionHandlerAdapter exceptionHandler;
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError unused) {
            Context context = getContext();
            if ((context instanceof HippyInstanceContext) && (exceptionHandler = ((HippyInstanceContext) context).getEngineContext().getGlobalConfigs().getExceptionHandler()) != null) {
                exceptionHandler.handleNativeException(new RuntimeException("HippyViewGroup StackOverflowError"), true);
            }
        }
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDSkinHandler.HippyQBCommonSkin
    public void hippySwitchSkin() {
        this.mHippyTKDSkinHandler.switchSkin(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        OnSizeChangeListener onSizeChangeListener = this.mOnSizeChangeListener;
        if (onSizeChangeListener != null) {
            onSizeChangeListener.onHippyViewGroupSizeChanged(i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, com.tencent.mtt.hippy.views.image.HippyImageView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.disableExternalScoll > 0) {
            if (motionEvent.getAction() == 0) {
                changeExternalScrollEnabled(false);
            } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                changeExternalScrollEnabled(true);
            }
        }
        return onTouchEvent;
    }

    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.views.list.HippyRecycler
    public void resetProps() {
        super.resetProps();
        this.mHippyTKDSkinHandler = new HippyTKDSkinHandler();
        this.mOnSizeChangeListener = null;
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBackgroundColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBackgroundColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderBottomColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderBottomColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderLeftColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderLeftColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderRightColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderRightColors(this, hippyArray);
    }

    @Override // com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler.HippyQBCommonBorder
    public void setBorderTopColors(HippyArray hippyArray) {
        this.mHippyTKDSkinHandler.setBorderTopColors(this, hippyArray);
    }

    public void setDisableExternalScroll(int i3) {
        this.disableExternalScoll = i3;
    }

    public void setOnSizeChangedListener(OnSizeChangeListener onSizeChangeListener) {
        this.mOnSizeChangeListener = onSizeChangeListener;
    }
}
