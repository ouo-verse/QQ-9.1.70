package com.tencent.richframework.widget.scroll;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class OverScrollDecorator implements View.OnTouchListener, View.OnAttachStateChangeListener {
    protected BounceBackState mBounceBackState;
    protected IDecoratorState mCurrentState;
    protected boolean mEnableDown;
    protected boolean mEnableLeft;
    protected boolean mEnableRight;
    protected boolean mEnableUp;
    protected float mFirstX;
    protected float mFirstY;
    protected IdleState mIdleState;
    protected OverScrollingState mOverScrollingState;
    protected final RecyclerView mRecyclerView;
    protected float mVelocity;
    protected IOverScrollDecor mOverScrollDecor = new LinearScrollViewOverScrollDecor();
    protected final OverScrollStartAttributes mStartAttr = new OverScrollStartAttributes();

    public OverScrollDecorator(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        recyclerView.addOnAttachStateChangeListener(this);
        init();
    }

    public void attach() {
        this.mRecyclerView.setOnTouchListener(this);
        this.mRecyclerView.setOverScrollMode(2);
    }

    public void detach() {
        this.mRecyclerView.setOnTouchListener(null);
        this.mRecyclerView.setOverScrollMode(0);
    }

    public View getView() {
        return this.mRecyclerView;
    }

    public void init() {
        this.mBounceBackState = new BounceBackState(this, -2.0f);
        this.mOverScrollingState = new OverScrollingState(this, 3.0f, 1.0f);
        IdleState idleState = new IdleState(this);
        this.mIdleState = idleState;
        this.mCurrentState = idleState;
        attach();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void issueStateTransition(IDecoratorState iDecoratorState) {
        IDecoratorState iDecoratorState2 = this.mCurrentState;
        this.mCurrentState = iDecoratorState;
        iDecoratorState.handleEntryTransition(iDecoratorState2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view instanceof RecyclerView) {
            setOrientationFromLayoutManager(((RecyclerView) view).getLayoutManager());
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    if ((this.mEnableRight || this.mEnableLeft) && this.mOverScrollDecor.getOrientation() == 0) {
                        if (!this.mEnableLeft && motionEvent.getX() - this.mFirstX < 0.0f) {
                            return false;
                        }
                        if (!this.mEnableRight && motionEvent.getX() - this.mFirstX > 0.0f) {
                            return false;
                        }
                        return this.mCurrentState.handleMoveTouchEvent(motionEvent);
                    }
                    if (!this.mEnableDown && motionEvent.getY() - this.mFirstY > 0.0f) {
                        return false;
                    }
                    if (!this.mEnableUp && motionEvent.getY() - this.mFirstY < 0.0f) {
                        return false;
                    }
                    return this.mCurrentState.handleMoveTouchEvent(motionEvent);
                }
            }
            return this.mCurrentState.handleUpOrCancelTouchEvent(motionEvent);
        }
        this.mFirstX = motionEvent.getX();
        this.mFirstY = motionEvent.getY();
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        attach();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        detach();
    }

    public void serHorizontalOverScrollEnable(boolean z16, boolean z17) {
        this.mEnableLeft = z16;
        this.mEnableRight = z17;
    }

    public void setOrientationFromLayoutManager(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            this.mOverScrollDecor.setOrientation(((LinearLayoutManager) layoutManager).getOrientation());
        } else {
            this.mOverScrollDecor.setOrientation(1);
        }
    }

    public void setVerticalOverScrollEnable(boolean z16, boolean z17) {
        this.mEnableDown = z16;
        this.mEnableUp = z17;
    }
}
