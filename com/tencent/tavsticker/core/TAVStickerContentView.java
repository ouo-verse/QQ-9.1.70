package com.tencent.tavsticker.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerContentView extends FrameLayout {
    private static final String TAG = "TAVStickerContentView";
    protected DispatchTouchEventListener dispatchTouchEventListener;
    private TAVStickerEditView stickerEditView;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface DispatchTouchEventListener {
        boolean onDispatchTouchEvent(MotionEvent motionEvent);

        boolean onHackedTouchEvent(MotionEvent motionEvent);

        void setInterceptEvent(Boolean bool);
    }

    public TAVStickerContentView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        if (view instanceof TAVStickerEditView) {
            this.stickerEditView = (TAVStickerEditView) view;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        DispatchTouchEventListener dispatchTouchEventListener = this.dispatchTouchEventListener;
        if (dispatchTouchEventListener != null) {
            return dispatchTouchEventListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void initStickerView() {
        TAVStickerEditView tAVStickerEditView = this.stickerEditView;
        if (tAVStickerEditView != null && tAVStickerEditView.isNeedInitLocation()) {
            this.stickerEditView.initLocation(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        initStickerView();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDispatchTouchEventListener(DispatchTouchEventListener dispatchTouchEventListener) {
        this.dispatchTouchEventListener = dispatchTouchEventListener;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        setNeedInitLocation();
    }

    protected void setNeedInitLocation() {
        TAVStickerEditView tAVStickerEditView = this.stickerEditView;
        if (tAVStickerEditView != null) {
            tAVStickerEditView.needInitLocation();
        }
    }

    public TAVStickerContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TAVStickerContentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.dispatchTouchEventListener = null;
        this.stickerEditView = null;
    }
}
