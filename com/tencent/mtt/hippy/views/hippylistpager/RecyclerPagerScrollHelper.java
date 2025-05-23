package com.tencent.mtt.hippy.views.hippylistpager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import java.lang.ref.WeakReference;

/* loaded from: classes20.dex */
public class RecyclerPagerScrollHelper {
    private static final String TAG = "RecyclerPagerScrollHelper";
    onPageChangeListener mOnPageChangeListener;
    private int orientation;
    private final WeakReference<HippyRecyclerView> recyclerViewRef;
    private ValueAnimator animator = null;
    private PagerOnFlingListener flingListener = new PagerOnFlingListener();
    private PagerOnScrollListener scrollListener = new PagerOnScrollListener();
    private PagerOnTouchListener touchListener = new PagerOnTouchListener();
    private int currentPageIndex = 0;
    private boolean firstTouch = true;
    private int flingAnimationState = 0;
    private int offsetY = 0;
    private int offsetX = 0;
    private int startY = 0;
    private int startX = 0;
    private int pageScrollDuration = 200;
    private int preCreateCount = 0;
    private float pageUpDownOffsetRatio = 0.5f;

    /* loaded from: classes20.dex */
    public class PagerOnFlingListener extends RecyclerView.OnFlingListener {
        public PagerOnFlingListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
        public boolean onFling(int i3, int i16) {
            int width;
            int i17;
            boolean z16;
            final HippyRecyclerView hippyRecyclerView = (HippyRecyclerView) RecyclerPagerScrollHelper.this.recyclerViewRef.get();
            if (hippyRecyclerView != null) {
                int i18 = RecyclerPagerScrollHelper.this.currentPageIndex;
                if (RecyclerPagerScrollHelper.this.currentPageIndex == hippyRecyclerView.getAdapter().getItemCountExceptHeaderAndFooter() - 1 && hippyRecyclerView.getAdapter().hasPullFooter()) {
                    if (hippyRecyclerView.getAdapter().getFooterVisibleHeight() <= 0) {
                        RecyclerPagerScrollHelper.this.offsetY = hippyRecyclerView.getContentOffsetY();
                        LogUtils.d(RecyclerPagerScrollHelper.TAG, "onFling: offsetY " + RecyclerPagerScrollHelper.this.offsetY + ", startY " + RecyclerPagerScrollHelper.this.startY);
                    } else {
                        return false;
                    }
                }
                if (RecyclerPagerScrollHelper.this.orientation == 1) {
                    i17 = RecyclerPagerScrollHelper.this.offsetY;
                    int abs = Math.abs(RecyclerPagerScrollHelper.this.offsetY - RecyclerPagerScrollHelper.this.startY);
                    if (abs > hippyRecyclerView.getHeight() * RecyclerPagerScrollHelper.this.pageUpDownOffsetRatio) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if ((RecyclerPagerScrollHelper.this.offsetY > RecyclerPagerScrollHelper.this.startY && i16 < 0) || (RecyclerPagerScrollHelper.this.offsetY < RecyclerPagerScrollHelper.this.startY && i16 > 0)) {
                        z16 = false;
                    }
                    LogUtils.d(RecyclerPagerScrollHelper.TAG, "onFling: offsetY " + RecyclerPagerScrollHelper.this.offsetY + ", pageIndex " + i18 + ", velocityY " + i16 + ", absY " + abs + ", move " + z16);
                    if (i16 < 0 && z16) {
                        i18--;
                    } else if (i16 > 0 && z16) {
                        i18++;
                    }
                    width = i18 * hippyRecyclerView.getHeight();
                } else {
                    int i19 = RecyclerPagerScrollHelper.this.offsetX;
                    if (i3 < 0) {
                        i18--;
                    } else if (i3 > 0) {
                        i18++;
                    }
                    width = i18 * hippyRecyclerView.getWidth();
                    i17 = i19;
                }
                if (width < 0) {
                    width = 0;
                }
                LogUtils.d(RecyclerPagerScrollHelper.TAG, "onFling: startPoint " + i17 + ", endPoint " + width);
                if (RecyclerPagerScrollHelper.this.animator == null) {
                    RecyclerPagerScrollHelper recyclerPagerScrollHelper = RecyclerPagerScrollHelper.this;
                    new ValueAnimator();
                    recyclerPagerScrollHelper.animator = ValueAnimator.ofInt(i17, width);
                    RecyclerPagerScrollHelper.this.animator.setDuration(RecyclerPagerScrollHelper.this.pageScrollDuration);
                    RecyclerPagerScrollHelper.this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mtt.hippy.views.hippylistpager.RecyclerPagerScrollHelper.PagerOnFlingListener.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            if (RecyclerPagerScrollHelper.this.orientation == 1) {
                                hippyRecyclerView.scrollBy(0, intValue - RecyclerPagerScrollHelper.this.offsetY);
                            } else {
                                hippyRecyclerView.scrollBy(intValue - RecyclerPagerScrollHelper.this.offsetX, 0);
                            }
                        }
                    });
                    RecyclerPagerScrollHelper.this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.mtt.hippy.views.hippylistpager.RecyclerPagerScrollHelper.PagerOnFlingListener.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            RecyclerPagerScrollHelper recyclerPagerScrollHelper2 = RecyclerPagerScrollHelper.this;
                            onPageChangeListener onpagechangelistener = recyclerPagerScrollHelper2.mOnPageChangeListener;
                            if (onpagechangelistener != null) {
                                onpagechangelistener.onPageChange(recyclerPagerScrollHelper2.currentPageIndex);
                            }
                            hippyRecyclerView.stopScroll();
                            RecyclerPagerScrollHelper recyclerPagerScrollHelper3 = RecyclerPagerScrollHelper.this;
                            recyclerPagerScrollHelper3.startY = recyclerPagerScrollHelper3.offsetY;
                            RecyclerPagerScrollHelper recyclerPagerScrollHelper4 = RecyclerPagerScrollHelper.this;
                            recyclerPagerScrollHelper4.startX = recyclerPagerScrollHelper4.offsetX;
                            RecyclerPagerScrollHelper.this.flingAnimationState = 0;
                            int pageIndex = RecyclerPagerScrollHelper.this.getPageIndex();
                            if (RecyclerPagerScrollHelper.this.currentPageIndex != pageIndex) {
                                RecyclerPagerScrollHelper.this.currentPageIndex = pageIndex;
                            }
                            LogUtils.d(RecyclerPagerScrollHelper.TAG, "onAnimationEnd: offsetY " + RecyclerPagerScrollHelper.this.offsetY + ", startY " + RecyclerPagerScrollHelper.this.startY + ", currentPageIndex " + RecyclerPagerScrollHelper.this.currentPageIndex);
                        }
                    });
                } else {
                    RecyclerPagerScrollHelper.this.animator.cancel();
                    RecyclerPagerScrollHelper.this.animator.setIntValues(i17, width);
                }
                RecyclerPagerScrollHelper.this.animator.start();
                RecyclerPagerScrollHelper.this.flingAnimationState = 1;
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes20.dex */
    public class PagerOnScrollListener extends RecyclerView.OnScrollListener {
        public PagerOnScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            LogUtils.d(RecyclerPagerScrollHelper.TAG, "onScrollStateChanged: newState " + i3);
            if (i3 == 0) {
                int i16 = -1000;
                boolean z16 = true;
                int i17 = 0;
                if (RecyclerPagerScrollHelper.this.orientation == 1) {
                    int abs = Math.abs(RecyclerPagerScrollHelper.this.offsetY - RecyclerPagerScrollHelper.this.startY);
                    LogUtils.d(RecyclerPagerScrollHelper.TAG, "onScrollStateChanged: offsetY " + RecyclerPagerScrollHelper.this.offsetY + ", startY " + RecyclerPagerScrollHelper.this.startY + ", absY " + abs);
                    if (abs <= recyclerView.getHeight() * RecyclerPagerScrollHelper.this.pageUpDownOffsetRatio) {
                        z16 = false;
                    }
                    if (z16) {
                        if (RecyclerPagerScrollHelper.this.offsetY - RecyclerPagerScrollHelper.this.startY >= 0) {
                            i16 = 1000;
                        }
                    } else {
                        i16 = 0;
                    }
                    i17 = i16;
                    i16 = 0;
                } else {
                    if (Math.abs(RecyclerPagerScrollHelper.this.offsetX - RecyclerPagerScrollHelper.this.startX) <= recyclerView.getWidth() / 2) {
                        z16 = false;
                    }
                    if (z16) {
                        if (RecyclerPagerScrollHelper.this.offsetX - RecyclerPagerScrollHelper.this.startX >= 0) {
                            i16 = 1000;
                        }
                    } else {
                        i16 = 0;
                    }
                }
                if (RecyclerPagerScrollHelper.this.flingAnimationState == 0) {
                    LogUtils.d(RecyclerPagerScrollHelper.TAG, "onScrollStateChanged: vY " + i17);
                    RecyclerPagerScrollHelper.this.flingListener.onFling(i16, i17);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            RecyclerPagerScrollHelper.access$312(RecyclerPagerScrollHelper.this, i16);
            RecyclerPagerScrollHelper.access$812(RecyclerPagerScrollHelper.this, i3);
        }
    }

    /* loaded from: classes20.dex */
    public class PagerOnTouchListener implements View.OnTouchListener {
        public PagerOnTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (RecyclerPagerScrollHelper.this.firstTouch) {
                RecyclerPagerScrollHelper.this.firstTouch = false;
                HippyRecyclerView hippyRecyclerView = (HippyRecyclerView) RecyclerPagerScrollHelper.this.recyclerViewRef.get();
                if (hippyRecyclerView != null) {
                    int pageIndex = RecyclerPagerScrollHelper.this.getPageIndex();
                    RecyclerPagerScrollHelper.this.offsetY = pageIndex * hippyRecyclerView.getHeight();
                }
                RecyclerPagerScrollHelper.this.offsetY = hippyRecyclerView.getContentOffsetY();
                RecyclerPagerScrollHelper recyclerPagerScrollHelper = RecyclerPagerScrollHelper.this;
                recyclerPagerScrollHelper.startY = recyclerPagerScrollHelper.currentPageIndex * hippyRecyclerView.getHeight();
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                RecyclerPagerScrollHelper.this.firstTouch = true;
            }
            return false;
        }
    }

    /* loaded from: classes20.dex */
    public interface onPageChangeListener {
        void onPageChange(int i3);
    }

    public RecyclerPagerScrollHelper(@NonNull HippyRecyclerView hippyRecyclerView) {
        this.recyclerViewRef = new WeakReference<>(hippyRecyclerView);
        hippyRecyclerView.setOnFlingListener(this.flingListener);
        hippyRecyclerView.addOnScrollListener(this.scrollListener);
        hippyRecyclerView.setOnTouchListener(this.touchListener);
    }

    static /* synthetic */ int access$312(RecyclerPagerScrollHelper recyclerPagerScrollHelper, int i3) {
        int i16 = recyclerPagerScrollHelper.offsetY + i3;
        recyclerPagerScrollHelper.offsetY = i16;
        return i16;
    }

    static /* synthetic */ int access$812(RecyclerPagerScrollHelper recyclerPagerScrollHelper, int i3) {
        int i16 = recyclerPagerScrollHelper.offsetX + i3;
        recyclerPagerScrollHelper.offsetX = i16;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageIndex() {
        int i3;
        int width;
        HippyRecyclerView hippyRecyclerView = this.recyclerViewRef.get();
        if (hippyRecyclerView != null && hippyRecyclerView.getHeight() != 0 && hippyRecyclerView.getWidth() != 0) {
            if (this.orientation == 1) {
                i3 = this.offsetY;
                width = hippyRecyclerView.getHeight();
            } else {
                i3 = this.offsetX;
                width = hippyRecyclerView.getWidth();
            }
            return i3 / width;
        }
        return 0;
    }

    private int getStartPageIndex() {
        int i3;
        int width;
        HippyRecyclerView hippyRecyclerView = this.recyclerViewRef.get();
        if (hippyRecyclerView != null && hippyRecyclerView.getHeight() != 0 && hippyRecyclerView.getWidth() != 0) {
            if (this.orientation == 1) {
                i3 = this.startY;
                width = hippyRecyclerView.getHeight();
            } else {
                i3 = this.startX;
                width = hippyRecyclerView.getWidth();
            }
            return i3 / width;
        }
        return 0;
    }

    public int getPreCreateRowsNumber() {
        return this.preCreateCount;
    }

    public void setAutoPageScrollDuration(int i3) {
        this.pageScrollDuration = i3;
    }

    public void setOnPageChangeListener(onPageChangeListener onpagechangelistener) {
        this.mOnPageChangeListener = onpagechangelistener;
    }

    public void setOrientation(int i3) {
        this.orientation = i3;
    }

    public void setPageUpDownOffsetRatio(float f16) {
        if (f16 > 0.0f) {
            this.pageUpDownOffsetRatio = f16;
        }
    }

    public void setPreCreateRowsNumber(int i3) {
        if (i3 > 0) {
            this.preCreateCount = i3;
        }
    }
}
