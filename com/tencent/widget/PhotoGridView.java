package com.tencent.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes27.dex */
public class PhotoGridView extends RecyclerView {
    static IPatchRedirector $redirector_ = null;
    public static final float HORIZONTAL_SLIDE_RATIO = 1.73f;
    GridLayoutManager gridLayoutManager;
    int mBeginSelectPosition;
    AtomicBoolean mEnableSelectMode;
    int mEndSelectPosition;
    AtomicBoolean mIsBegined;
    AtomicBoolean mIsBeingInSelectMode;
    boolean mIsScrolling;
    boolean mIsScrollingFromTop;
    float mLastMotionX;
    float mLastMotionY;
    OnSelectListener mOnSelectChangedListener;
    int mTouchSlop;
    LinearSmoothScroller smoothScroller;

    /* loaded from: classes27.dex */
    class MyScrollListener extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        MyScrollListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoGridView.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            PhotoGridView photoGridView = PhotoGridView.this;
            if (photoGridView.mIsScrolling) {
                if (photoGridView.mIsScrollingFromTop) {
                    photoGridView.mEndSelectPosition = photoGridView.gridLayoutManager.findLastVisibleItemPosition();
                } else {
                    photoGridView.mEndSelectPosition = photoGridView.gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                }
                PhotoGridView photoGridView2 = PhotoGridView.this;
                photoGridView2.mOnSelectChangedListener.onSelectChanged(photoGridView2.mBeginSelectPosition, photoGridView2.mEndSelectPosition);
            }
        }
    }

    /* loaded from: classes27.dex */
    public interface OnSelectListener {
        void onSelectBegin(int i3);

        void onSelectChanged(int i3, int i16);

        void onSelectEnd();
    }

    public PhotoGridView(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void handleMove(float f16, float f17) {
        if (!this.mIsBeingInSelectMode.get()) {
            float abs = Math.abs(f16 - this.mLastMotionX);
            if (abs > Math.abs(f17 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                this.mIsBeingInSelectMode.set(true);
                this.mLastMotionX = f16;
                this.mLastMotionY = f17;
            }
        }
        if (this.mIsBeingInSelectMode.get()) {
            if (this.mIsScrolling) {
                handleMoveScrolling(f17);
            } else {
                handleMoveNoScrolling(f17);
            }
        }
        handleScroll((int) f16, (int) f17);
    }

    private void handleMoveNoScrolling(float f16) {
        if (f16 < 0.0f || f16 > getHeight()) {
            this.mIsScrolling = true;
            int i3 = 0;
            if (f16 < 0.0f) {
                this.mIsScrollingFromTop = false;
            } else if (f16 > getHeight()) {
                i3 = getAdapter().getItemCount();
                this.mIsScrollingFromTop = true;
            }
            this.smoothScroller.setTargetPosition(i3);
            this.gridLayoutManager.startSmoothScroll(this.smoothScroller);
        }
    }

    private void handleMoveScrolling(float f16) {
        if (f16 > 0.0f && f16 < getHeight()) {
            stopScroll();
            this.mIsScrolling = false;
        }
    }

    private void handleScroll(int i3, int i16) {
        int i17;
        if (this.mIsBeingInSelectMode.get()) {
            int i18 = -1;
            if (!this.mIsBegined.get() && (i17 = this.mBeginSelectPosition) != -1) {
                OnSelectListener onSelectListener = this.mOnSelectChangedListener;
                if (onSelectListener != null) {
                    onSelectListener.onSelectBegin(i17);
                }
                this.mIsBegined.set(true);
            }
            View findChildViewUnder = findChildViewUnder(i3, i16);
            if (findChildViewUnder != null) {
                i18 = getChildAdapterPosition(findChildViewUnder);
            }
            handleScrollSelectState(i18);
        }
    }

    private void handleScrollSelectState(int i3) {
        OnSelectListener onSelectListener;
        if (i3 != -1) {
            if (!this.mIsBegined.get()) {
                this.mEndSelectPosition = i3;
                this.mBeginSelectPosition = i3;
                OnSelectListener onSelectListener2 = this.mOnSelectChangedListener;
                if (onSelectListener2 != null) {
                    onSelectListener2.onSelectBegin(i3);
                }
                this.mIsBegined.set(true);
                return;
            }
            if (this.mEndSelectPosition != i3) {
                this.mEndSelectPosition = i3;
                if (!this.mIsScrolling && (onSelectListener = this.mOnSelectChangedListener) != null) {
                    onSelectListener.onSelectChanged(this.mBeginSelectPosition, i3);
                }
            }
        }
    }

    private boolean handleUp() {
        OnSelectListener onSelectListener;
        if (this.mIsScrolling) {
            stopScroll();
            this.mIsScrolling = false;
        }
        boolean z16 = this.mIsBeingInSelectMode.get();
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        this.mIsBeingInSelectMode.set(false);
        this.mIsBegined.set(false);
        if (z16 && (onSelectListener = this.mOnSelectChangedListener) != null) {
            onSelectListener.onSelectEnd();
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        if (r7 != 3) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean processEvent(MotionEvent motionEvent, int i3) {
        int i16;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i17 = i3 & 255;
        if (i17 != 0) {
            if (i17 != 1) {
                if (i17 == 2) {
                    float abs = Math.abs(x16 - this.mLastMotionX);
                    if (abs > Math.abs(y16 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                        this.mIsBeingInSelectMode.set(true);
                        this.mLastMotionX = x16;
                        this.mLastMotionY = y16;
                    }
                }
            }
            boolean z16 = this.mIsBeingInSelectMode.get();
            this.mIsBeingInSelectMode.set(false);
            this.mBeginSelectPosition = -1;
            this.mEndSelectPosition = -1;
            this.mIsBegined.set(false);
            if (z16) {
                return true;
            }
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
            View findChildViewUnder = findChildViewUnder((int) x16, (int) y16);
            if (findChildViewUnder != null) {
                i16 = getChildAdapterPosition(findChildViewUnder);
            } else {
                i16 = -1;
            }
            if (i16 != -1) {
                this.mEndSelectPosition = i16;
                this.mBeginSelectPosition = i16;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (r0 != 3) goto L25;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mEnableSelectMode.get()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    handleMove(x16, y16);
                }
            }
            if (handleUp()) {
                return true;
            }
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
        }
        if (this.mIsBeingInSelectMode.get()) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mEnableSelectMode.get()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if ((action == 2 && this.mIsBeingInSelectMode.get()) || processEvent(motionEvent, action) || this.mIsBeingInSelectMode.get()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setLayoutManager(@Nullable GridLayoutManager gridLayoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) gridLayoutManager);
        } else {
            super.setLayoutManager((RecyclerView.LayoutManager) gridLayoutManager);
            this.gridLayoutManager = gridLayoutManager;
        }
    }

    public void setOnIndexChangedListener(OnSelectListener onSelectListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onSelectListener);
        } else {
            this.mOnSelectChangedListener = onSelectListener;
        }
    }

    public PhotoGridView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PhotoGridView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        this.mIsBeingInSelectMode = new AtomicBoolean(false);
        this.mIsBegined = new AtomicBoolean(false);
        this.mEnableSelectMode = new AtomicBoolean(true);
        this.mIsScrolling = false;
        this.mIsScrollingFromTop = true;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 15;
        addOnScrollListener(new MyScrollListener());
        this.smoothScroller = new LinearSmoothScroller(context) { // from class: com.tencent.widget.PhotoGridView.1
            static IPatchRedirector $redirector_;

            {
                super(context);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoGridView.this, (Object) context);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Float) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) displayMetrics)).floatValue();
                }
                return 500.0f / displayMetrics.densityDpi;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public PointF computeScrollVectorForPosition(int i16) {
                int i17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    return (PointF) iPatchRedirector2.redirect((short) 3, (Object) this, i16);
                }
                GridLayoutManager gridLayoutManager = PhotoGridView.this.gridLayoutManager;
                if (gridLayoutManager != null && gridLayoutManager.getChildCount() != 0 && PhotoGridView.this.gridLayoutManager.getChildAt(0) != null) {
                    GridLayoutManager gridLayoutManager2 = PhotoGridView.this.gridLayoutManager;
                    if (i16 < gridLayoutManager2.getPosition(gridLayoutManager2.getChildAt(0))) {
                        i17 = -1;
                    } else {
                        i17 = 1;
                    }
                    return new PointF(0.0f, i17);
                }
                return null;
            }
        };
    }
}
