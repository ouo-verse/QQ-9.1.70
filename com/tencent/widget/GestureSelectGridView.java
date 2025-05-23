package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.widget.AbsListView;
import com.xingin.xhssharesdk.XhsShareConstants$XhsShareNoteNewErrorCode;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes27.dex */
public class GestureSelectGridView extends GridView {
    static IPatchRedirector $redirector_ = null;
    public static final float HORIZONTAL_SLIDE_RATIO = 1.73f;
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
    AbsListView.OnScrollListener mSubOnScrollListener;
    int mTouchSlop;
    final int speed;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class MyScrollListener implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        MyScrollListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GestureSelectGridView.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            GestureSelectGridView gestureSelectGridView = GestureSelectGridView.this;
            if (gestureSelectGridView.mIsScrolling) {
                int i18 = i3 + i16;
                if (gestureSelectGridView.mIsScrollingFromTop && Math.abs(i18 - gestureSelectGridView.mEndSelectPosition) >= 3 && Math.abs(i18 - GestureSelectGridView.this.mEndSelectPosition) <= 5) {
                    GestureSelectGridView gestureSelectGridView2 = GestureSelectGridView.this;
                    int i19 = gestureSelectGridView2.mEndSelectPosition;
                    int i26 = i17 - 1;
                    if (i19 + 3 > i26) {
                        gestureSelectGridView2.mEndSelectPosition = i26;
                    } else {
                        gestureSelectGridView2.mEndSelectPosition = i19 + 3;
                    }
                    gestureSelectGridView2.mOnSelectChangedListener.onSelectChanged(gestureSelectGridView2.mBeginSelectPosition, gestureSelectGridView2.mEndSelectPosition);
                } else {
                    GestureSelectGridView gestureSelectGridView3 = GestureSelectGridView.this;
                    if (!gestureSelectGridView3.mIsScrollingFromTop && Math.abs(i3 - gestureSelectGridView3.mEndSelectPosition) >= 3 && Math.abs(i3 - GestureSelectGridView.this.mEndSelectPosition) <= 5) {
                        GestureSelectGridView gestureSelectGridView4 = GestureSelectGridView.this;
                        int i27 = gestureSelectGridView4.mEndSelectPosition;
                        if (i27 - 3 < 0) {
                            gestureSelectGridView4.mEndSelectPosition = 0;
                        } else {
                            gestureSelectGridView4.mEndSelectPosition = i27 - 3;
                        }
                        gestureSelectGridView4.mOnSelectChangedListener.onSelectChanged(gestureSelectGridView4.mBeginSelectPosition, gestureSelectGridView4.mEndSelectPosition);
                    }
                }
            }
            AbsListView.OnScrollListener onScrollListener = GestureSelectGridView.this.mSubOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScroll(absListView, i3, i16, i17);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) absListView, i3);
                return;
            }
            AbsListView.OnScrollListener onScrollListener = GestureSelectGridView.this.mSubOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(absListView, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnSelectListener {
        void onSelectBegin(int i3);

        void onSelectChanged(int i3, int i16);

        void onSelectEnd();
    }

    public GestureSelectGridView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r0 != 3) goto L35;
     */
    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mEnableSelectMode.get()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingInSelectMode.get()) {
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
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
            int pointToPosition = pointToPosition((int) x16, (int) y16);
            if (pointToPosition != -1) {
                this.mEndSelectPosition = pointToPosition;
                this.mBeginSelectPosition = pointToPosition;
            }
        }
        if (this.mIsBeingInSelectMode.get()) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        if (r0 != 3) goto L88;
     */
    @Override // com.tencent.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnSelectListener onSelectListener;
        OnSelectListener onSelectListener2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.mEnableSelectMode.get()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int i16 = action & 255;
        if (i16 != 0) {
            int i17 = 0;
            if (i16 != 1) {
                if (i16 == 2) {
                    if (!this.mIsBeingInSelectMode.get()) {
                        float abs = Math.abs(x16 - this.mLastMotionX);
                        if (abs > Math.abs(y16 - this.mLastMotionY) * 1.73f && abs > this.mTouchSlop) {
                            this.mIsBeingInSelectMode.set(true);
                            this.mLastMotionX = x16;
                            this.mLastMotionY = y16;
                        }
                    }
                    if (this.mIsBeingInSelectMode.get() && !this.mIsScrolling) {
                        if (y16 < 0.0f || y16 > getHeight()) {
                            this.mIsScrolling = true;
                            if (y16 < 0.0f) {
                                this.mIsScrollingFromTop = false;
                                i17 = XhsShareConstants$XhsShareNoteNewErrorCode.UNKNOWN;
                            } else if (y16 > getHeight()) {
                                this.mIsScrollingFromTop = true;
                                i17 = ThemeConstants.ZIP_VERSION;
                            }
                            smoothScrollBy(i17, 1000000);
                        }
                    } else if (this.mIsBeingInSelectMode.get() && this.mIsScrolling && y16 > 0.0f && y16 < getHeight()) {
                        abordFling();
                        this.mIsScrolling = false;
                    }
                    if (this.mIsBeingInSelectMode.get()) {
                        if (!this.mIsBegined.get() && (i3 = this.mBeginSelectPosition) != -1) {
                            OnSelectListener onSelectListener3 = this.mOnSelectChangedListener;
                            if (onSelectListener3 != null) {
                                onSelectListener3.onSelectBegin(i3);
                            }
                            this.mIsBegined.set(true);
                        }
                        int pointToPosition = pointToPosition((int) x16, (int) y16);
                        if (pointToPosition != -1) {
                            if (!this.mIsBegined.get()) {
                                this.mEndSelectPosition = pointToPosition;
                                this.mBeginSelectPosition = pointToPosition;
                                OnSelectListener onSelectListener4 = this.mOnSelectChangedListener;
                                if (onSelectListener4 != null) {
                                    onSelectListener4.onSelectBegin(pointToPosition);
                                }
                                this.mIsBegined.set(true);
                            } else if (this.mEndSelectPosition != pointToPosition) {
                                this.mEndSelectPosition = pointToPosition;
                                if (!this.mIsScrolling && (onSelectListener2 = this.mOnSelectChangedListener) != null) {
                                    onSelectListener2.onSelectChanged(this.mBeginSelectPosition, pointToPosition);
                                }
                            }
                        }
                    }
                }
            }
            if (this.mIsScrolling) {
                abordFling();
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
            if (z16) {
                return true;
            }
        } else {
            this.mLastMotionX = x16;
            this.mLastMotionY = y16;
        }
        if (this.mIsBeingInSelectMode.get()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnIndexChangedListener(OnSelectListener onSelectListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onSelectListener);
        } else {
            this.mOnSelectChangedListener = onSelectListener;
        }
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onScrollListener);
        } else {
            this.mSubOnScrollListener = onScrollListener;
        }
    }

    public void setSelectMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.mEnableSelectMode.set(z16);
        }
    }

    public void setTouchSlopRate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * i3;
        }
    }

    public GestureSelectGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mBeginSelectPosition = -1;
        this.mEndSelectPosition = -1;
        this.mIsBeingInSelectMode = new AtomicBoolean(false);
        this.mIsBegined = new AtomicBoolean(false);
        this.mEnableSelectMode = new AtomicBoolean(true);
        this.speed = ThemeConstants.ZIP_VERSION;
        this.mIsScrolling = false;
        this.mIsScrollingFromTop = true;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 15;
        super.setOnScrollListener(new MyScrollListener());
    }
}
