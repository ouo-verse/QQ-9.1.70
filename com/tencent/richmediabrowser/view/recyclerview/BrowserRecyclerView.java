package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserRecyclerView extends RecyclerView {
    private static final int FLING_MAX_VELOCITY = 600;
    private static final String TAG = "BrowserRecyclerView";
    private boolean isIntercept;
    public LinearLayoutManager linearLayoutManager;
    public PagerSnapHelper linearSnapHelper;
    private float mLastX;
    private float mLastY;
    private MainBrowserPresenter mMainBrowserPresenter;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        boolean b(MotionEvent motionEvent);

        boolean e(MotionEvent motionEvent);
    }

    public BrowserRecyclerView(Context context) {
        super(context, null, 0);
        this.isIntercept = false;
    }

    private a getTouchEventConsumer() {
        MainBrowserScene mainBrowserScene;
        MainBrowserPresenter mainBrowserPresenter = this.mMainBrowserPresenter;
        if (mainBrowserPresenter != null && (mainBrowserScene = mainBrowserPresenter.browserScene) != null) {
            return mainBrowserScene.brvTouchEventConsumer;
        }
        return null;
    }

    private int solveVelocity(int i3) {
        if (i3 > 0) {
            return Math.min(i3, 600);
        }
        return Math.max(i3, LightConstants.ErrorCode.HEAD_INSET_RESOURCE_NOT_SUPPORT);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 5) {
                this.isIntercept = true;
            }
        } else {
            this.isIntercept = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i3, int i16) {
        return super.fling(solveVelocity(i3), solveVelocity(i16));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MainBrowserPresenter mainBrowserPresenter;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 5) {
                        MainBrowserPresenter mainBrowserPresenter2 = this.mMainBrowserPresenter;
                        if (mainBrowserPresenter2 != null) {
                            mainBrowserPresenter2.requestDisallowInterceptDragEvent(true);
                        }
                        this.isIntercept = true;
                    }
                } else {
                    MainBrowserPresenter mainBrowserPresenter3 = this.mMainBrowserPresenter;
                    if (mainBrowserPresenter3 != null) {
                        mainBrowserPresenter3.requestDisallowInterceptDragEvent(true);
                    }
                    MainBrowserPresenter mainBrowserPresenter4 = this.mMainBrowserPresenter;
                    if (mainBrowserPresenter4 != null && mainBrowserPresenter4.isNeedDisallowInterceptEvent(motionEvent)) {
                        requestDisallowInterceptTouchEvent(true);
                        return false;
                    }
                    float f16 = x16 - this.mLastX;
                    float f17 = y16 - this.mLastY;
                    if (f17 > 0.0f && Math.abs(f17) / Math.abs(f16) >= 6.0f && Math.abs(f16) < 10.0f && (mainBrowserPresenter = this.mMainBrowserPresenter) != null) {
                        mainBrowserPresenter.requestDisallowInterceptDragEvent(false);
                    }
                    this.mLastX = x16;
                    this.mLastY = y16;
                }
            } else {
                this.isIntercept = false;
            }
        } else {
            MainBrowserPresenter mainBrowserPresenter5 = this.mMainBrowserPresenter;
            if (mainBrowserPresenter5 != null) {
                mainBrowserPresenter5.requestDisallowInterceptDragEvent(true);
            }
            this.mLastX = 0.0f;
            this.mLastY = 0.0f;
        }
        if (this.isIntercept) {
            return false;
        }
        a touchEventConsumer = getTouchEventConsumer();
        if (touchEventConsumer != null && touchEventConsumer.e(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a touchEventConsumer = getTouchEventConsumer();
        if (touchEventConsumer != null && touchEventConsumer.b(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager) {
        this.linearLayoutManager = linearLayoutManager;
    }

    public void setMainBrowserPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.mMainBrowserPresenter = mainBrowserPresenter;
    }

    public void setPageSnapHelper(PagerSnapHelper pagerSnapHelper) {
        this.linearSnapHelper = pagerSnapHelper;
    }

    public BrowserRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.isIntercept = false;
    }

    public BrowserRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.isIntercept = false;
    }
}
