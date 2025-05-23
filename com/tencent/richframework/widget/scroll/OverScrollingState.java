package com.tencent.richframework.widget.scroll;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class OverScrollingState implements IDecoratorState {
    protected int mCurrDragState;
    protected final OverScrollDecorator mManager;
    protected final MotionAttributes mMoveAttr = new MotionAttributes();
    protected float mTouchDragRatioBck;
    protected float mTouchDragRatioFwd;

    public OverScrollingState(OverScrollDecorator overScrollDecorator, float f16, float f17) {
        this.mManager = overScrollDecorator;
        this.mTouchDragRatioFwd = f16;
        this.mTouchDragRatioBck = f17;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public void handleEntryTransition(IDecoratorState iDecoratorState) {
        int i3;
        if (this.mManager.mStartAttr.mDir) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        this.mCurrDragState = i3;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
        float f16;
        OverScrollStartAttributes overScrollStartAttributes = this.mManager.mStartAttr;
        if (overScrollStartAttributes.mPointerId != motionEvent.getPointerId(0)) {
            OverScrollDecorator overScrollDecorator = this.mManager;
            overScrollDecorator.issueStateTransition(overScrollDecorator.mBounceBackState);
            return true;
        }
        View view = this.mManager.getView();
        IOverScrollDecor iOverScrollDecor = this.mManager.mOverScrollDecor;
        if (!iOverScrollDecor.initMotionAttributes(view, this.mMoveAttr, motionEvent)) {
            return true;
        }
        MotionAttributes motionAttributes = this.mMoveAttr;
        float f17 = motionAttributes.mDeltaOffset;
        boolean z16 = motionAttributes.mDir;
        boolean z17 = overScrollStartAttributes.mDir;
        if (z16 == z17) {
            f16 = this.mTouchDragRatioFwd;
        } else {
            f16 = this.mTouchDragRatioBck;
        }
        float f18 = f17 / f16;
        float f19 = motionAttributes.mAbsOffset + f18;
        if ((z17 && !z16 && f19 <= overScrollStartAttributes.mAbsOffset) || (!z17 && z16 && f19 >= overScrollStartAttributes.mAbsOffset)) {
            iOverScrollDecor.translateViewAndEvent(view, overScrollStartAttributes.mAbsOffset, motionEvent);
            OverScrollDecorator overScrollDecorator2 = this.mManager;
            overScrollDecorator2.issueStateTransition(overScrollDecorator2.mIdleState);
            return true;
        }
        if (view.getParent() != null) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        }
        long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
        if (eventTime > 0) {
            this.mManager.mVelocity = f18 / ((float) eventTime);
        }
        iOverScrollDecor.translateView(view, f19);
        return true;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
        OverScrollDecorator overScrollDecorator = this.mManager;
        overScrollDecorator.issueStateTransition(overScrollDecorator.mBounceBackState);
        return false;
    }
}
