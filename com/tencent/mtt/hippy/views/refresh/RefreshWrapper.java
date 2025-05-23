package com.tencent.mtt.hippy.views.refresh;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RefreshWrapper extends HippyViewGroup {
    int mBounceTime;
    View mContentView;
    private long mLastScrollEventTimeStamp;
    RefreshWrapperItemView mRefreshWrapperItemView;
    protected boolean mScrollEventEnable;
    protected int mScrollEventThrottle;
    float mStartDownY;
    float mStartTransY;
    float mStartX;
    float mStartY;
    RefreshState mState;
    float mTansY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public enum RefreshState {
        Init,
        Loading
    }

    public RefreshWrapper(Context context) {
        super(context);
        this.mTansY = -1.0f;
        this.mStartTransY = 0.0f;
        this.mStartY = 0.0f;
        this.mStartDownY = -1.0f;
        this.mStartX = 0.0f;
        this.mState = RefreshState.Init;
        this.mBounceTime = 300;
        this.mScrollEventEnable = true;
        this.mScrollEventThrottle = 400;
        this.mLastScrollEventTimeStamp = -1L;
    }

    private HippyMap generateScrollEvent(float f16) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushDouble(HippyTKDListViewAdapter.X, PixelUtil.px2dp(0.0f));
        hippyMap.pushDouble("y", PixelUtil.px2dp(f16));
        HippyMap hippyMap2 = new HippyMap();
        hippyMap2.pushMap("contentOffset", hippyMap);
        return hippyMap2;
    }

    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroup, android.view.ViewGroup
    public void addView(View view, int i3) {
        if (view instanceof RefreshWrapperItemView) {
            this.mRefreshWrapperItemView = (RefreshWrapperItemView) view;
        } else {
            this.mContentView = view;
        }
        super.addView(view, i3);
    }

    void bounceToHead(float f16) {
        View view = this.mContentView;
        if (view != null && this.mRefreshWrapperItemView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationY", view.getTranslationY(), f16);
            ofFloat.setDuration(this.mBounceTime);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            RefreshWrapperItemView refreshWrapperItemView = this.mRefreshWrapperItemView;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(refreshWrapperItemView, "TranslationY", refreshWrapperItemView.getTranslationY(), f16);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.setDuration(this.mBounceTime);
            ofFloat.start();
            ofFloat2.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
    
        if (java.lang.Math.abs(r1 - r7.mStartX) < java.lang.Math.abs(r0 - r7.mStartY)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0107, code lost:
    
        sendCancelEvent(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00da, code lost:
    
        if (java.lang.Math.abs(r1 - r7.mStartX) < java.lang.Math.abs(r0 - r7.mStartY)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0105, code lost:
    
        if (java.lang.Math.abs(r1 - r7.mStartX) < java.lang.Math.abs(r0 - r7.mStartY)) goto L51;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float rawY = motionEvent.getRawY();
        float rawX = motionEvent.getRawX();
        if (this.mContentView != null && this.mRefreshWrapperItemView != null) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float f16 = this.mStartY;
                        if (rawY - f16 > 0.0f) {
                            if (getCompactScrollY() == 0.0f) {
                                float f17 = this.mStartDownY;
                                if (f17 == -1.0f) {
                                    this.mStartDownY = rawY;
                                } else {
                                    float f18 = (rawY - f17) / 3.0f;
                                    this.mTansY = f18;
                                    setSTranslationY(f18 + this.mStartTransY);
                                    sendOnScrollEvent(-this.mTansY);
                                }
                                if (Math.abs(rawX - this.mStartX) < Math.abs(rawY - this.mStartY)) {
                                    return true;
                                }
                            }
                        } else if (this.mState == RefreshState.Loading) {
                            float f19 = rawY - f16;
                            if (this.mRefreshWrapperItemView.getTranslationY() > 0.0f) {
                                setSTranslationY(this.mStartTransY + f19);
                                if (Math.abs(rawX - this.mStartX) < Math.abs(f19)) {
                                    return true;
                                }
                            }
                        }
                    }
                } else {
                    RefreshState refreshState = this.mState;
                    if (refreshState == RefreshState.Init) {
                        if (this.mTansY < this.mRefreshWrapperItemView.getHeight() && this.mRefreshWrapperItemView.getTranslationY() > 0.0f) {
                            bounceToHead(0.0f);
                        } else {
                            if (this.mTansY > this.mRefreshWrapperItemView.getHeight()) {
                                startRefresh();
                            }
                            this.mStartDownY = -1.0f;
                        }
                    } else {
                        if (refreshState == RefreshState.Loading && this.mRefreshWrapperItemView.getTranslationY() > this.mRefreshWrapperItemView.getHeight()) {
                            startRefresh();
                        }
                        this.mStartDownY = -1.0f;
                    }
                }
            } else {
                this.mStartY = motionEvent.getRawY();
                this.mStartX = motionEvent.getRawX();
                this.mStartTransY = this.mRefreshWrapperItemView.getTranslationY();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    float getCompactScrollY() {
        int scrollY;
        View view = this.mContentView;
        if (view instanceof RecyclerViewBase) {
            scrollY = ((RecyclerViewBase) view).getOffsetY();
        } else if (view instanceof HippyRecyclerViewWrapper) {
            scrollY = ((HippyRecyclerViewWrapper) view).computeVerticalScrollOffset();
        } else {
            scrollY = view.getScrollY();
        }
        return scrollY;
    }

    public void refreshComplected() {
        bounceToHead(0.0f);
        this.mState = RefreshState.Init;
    }

    public void sendCancelEvent(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        this.mContentView.dispatchTouchEvent(obtain);
    }

    public void sendOnScrollEvent(float f16) {
        if (this.mScrollEventEnable) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastScrollEventTimeStamp < this.mScrollEventThrottle) {
                return;
            }
            new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL).send(this, generateScrollEvent(f16));
            this.mLastScrollEventTimeStamp = currentTimeMillis;
        }
    }

    public void setOnScrollEventEnable(boolean z16) {
        this.mScrollEventEnable = z16;
    }

    void setSTranslationY(float f16) {
        float f17;
        RefreshWrapperItemView refreshWrapperItemView = this.mRefreshWrapperItemView;
        if (refreshWrapperItemView != null) {
            if (f16 > 0.0f) {
                f17 = f16;
            } else {
                f17 = 0.0f;
            }
            refreshWrapperItemView.setTranslationY(f17);
        }
        View view = this.mContentView;
        if (view != null) {
            if (f16 <= 0.0f) {
                f16 = 0.0f;
            }
            view.setTranslationY(f16);
        }
    }

    public void setScrollEventThrottle(int i3) {
        this.mScrollEventThrottle = i3;
    }

    public void setTime(int i3) {
        this.mBounceTime = i3;
    }

    public void startRefresh() {
        this.mTansY = -1.0f;
        bounceToHead(this.mRefreshWrapperItemView.getHeight());
        this.mState = RefreshState.Loading;
        new HippyViewEvent(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH).send(this, null);
    }
}
