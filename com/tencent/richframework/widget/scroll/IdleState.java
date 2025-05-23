package com.tencent.richframework.widget.scroll;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes25.dex */
public class IdleState implements IDecoratorState {
    protected final OverScrollDecorator mManager;
    protected final MotionAttributes mMoveAttr = new MotionAttributes();

    public IdleState(OverScrollDecorator overScrollDecorator) {
        this.mManager = overScrollDecorator;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public boolean handleMoveTouchEvent(MotionEvent motionEvent) {
        View view = this.mManager.getView();
        IOverScrollDecor iOverScrollDecor = this.mManager.mOverScrollDecor;
        if (!iOverScrollDecor.initMotionAttributes(view, this.mMoveAttr, motionEvent)) {
            return false;
        }
        OverScrollStartAttributes overScrollStartAttributes = this.mManager.mStartAttr;
        if ((!iOverScrollDecor.isInAbsoluteStart(view) || !this.mMoveAttr.mDir) && (!iOverScrollDecor.isInAbsoluteEnd(view) || this.mMoveAttr.mDir)) {
            return false;
        }
        overScrollStartAttributes.mPointerId = motionEvent.getPointerId(0);
        MotionAttributes motionAttributes = this.mMoveAttr;
        overScrollStartAttributes.mAbsOffset = motionAttributes.mAbsOffset;
        overScrollStartAttributes.mDir = motionAttributes.mDir;
        OverScrollDecorator overScrollDecorator = this.mManager;
        overScrollDecorator.issueStateTransition(overScrollDecorator.mOverScrollingState);
        return this.mManager.mOverScrollingState.handleMoveTouchEvent(motionEvent);
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public boolean handleUpOrCancelTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.richframework.widget.scroll.IDecoratorState
    public void handleEntryTransition(IDecoratorState iDecoratorState) {
    }
}
