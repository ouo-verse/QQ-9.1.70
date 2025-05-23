package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;

/* loaded from: classes20.dex */
public class PagingScrollView extends ScrollView {
    private boolean mCanScroll;
    protected GestureDetector mGestureDetector;
    boolean mIsOnSpecialView;
    protected b mScrollChangedListener;
    protected ArrayList<View> pagingViews;

    /* loaded from: classes20.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action;
            if (PagingScrollView.this.mIsOnSpecialView && ((action = motionEvent.getAction()) == 1 || action == 3)) {
                PagingScrollView pagingScrollView = PagingScrollView.this;
                pagingScrollView.mIsOnSpecialView = false;
                pagingScrollView.getParent().requestDisallowInterceptTouchEvent(false);
                if (QLog.isDevelopLevel()) {
                    QLog.i("PageScrollView", 4, "C.TE ACT_UP or CANCEL");
                }
            }
            return false;
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        protected c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (PagingScrollView.this.mCanScroll) {
                PagingScrollView.this.mCanScroll = false;
                float abs = Math.abs(f16);
                float abs2 = Math.abs(f17);
                if (abs2 > abs) {
                    if (abs < 0.01f) {
                        PagingScrollView.this.mCanScroll = true;
                    } else if (abs2 / abs > 1.73205f) {
                        PagingScrollView.this.mCanScroll = true;
                    }
                }
            }
            return PagingScrollView.this.mCanScroll;
        }
    }

    public PagingScrollView(Context context) {
        super(context);
        this.mIsOnSpecialView = false;
        this.mCanScroll = true;
        init(context);
    }

    public void addPagingView(View view) {
        if (view == null) {
            return;
        }
        if (this.pagingViews == null) {
            this.pagingViews = new ArrayList<>();
        }
        this.pagingViews.add(view);
        view.setOnTouchListener(new a());
    }

    public void clearPagingViews() {
        if (this.pagingViews != null) {
            for (int i3 = 0; i3 < this.pagingViews.size(); i3++) {
                this.pagingViews.get(i3).setOnTouchListener(null);
            }
            this.pagingViews.clear();
        }
    }

    protected void init(Context context) {
        setOverScrollMode(0);
        setFadingEdgeLength(0);
        this.mGestureDetector = new GestureDetector(context, new c());
    }

    protected boolean isOnView(View view, float f16, float f17) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int height = view.getHeight() + i3;
        int i16 = iArr[0];
        int width = view.getWidth() + i16;
        if (f17 >= i3 && f17 < height && f16 > i16 && f16 < width) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (action == 0) {
            if (this.pagingViews != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.pagingViews.size()) {
                        break;
                    }
                    if (isOnView(this.pagingViews.get(i3), rawX, rawY)) {
                        this.mIsOnSpecialView = true;
                        break;
                    }
                    i3++;
                }
            }
            if (this.mIsOnSpecialView) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (QLog.isDevelopLevel()) {
                    QLog.i("PageScrollView", 4, "P.ITE ACT_DOWNE onSpecialView");
                }
            }
        }
        if (this.mIsOnSpecialView && (action == 1 || action == 3)) {
            this.mIsOnSpecialView = false;
            getParent().requestDisallowInterceptTouchEvent(false);
            this.mCanScroll = true;
            if (QLog.isDevelopLevel()) {
                QLog.i("PageScrollView", 4, "P.ITE ACT_UP or CANCEL");
            }
        }
        try {
            if (this.mIsOnSpecialView) {
                super.onInterceptTouchEvent(motionEvent);
                return this.mGestureDetector.onTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ScrollView, android.view.View
    public void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
    }

    @Override // com.tencent.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action;
        if (this.mIsOnSpecialView && ((action = motionEvent.getAction()) == 1 || action == 3)) {
            this.mIsOnSpecialView = false;
            getParent().requestDisallowInterceptTouchEvent(false);
            if (QLog.isDevelopLevel()) {
                QLog.i("PageScrollView", 4, "P.TE ACT_UP or CANCEL");
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void removePagingView(View view) {
        ArrayList<View> arrayList = this.pagingViews;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (this.pagingViews.get(size) == view) {
                    this.pagingViews.get(size).setOnTouchListener(null);
                    this.pagingViews.remove(size);
                }
            }
        }
    }

    public PagingScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsOnSpecialView = false;
        this.mCanScroll = true;
        init(context);
    }

    public void setOnScrollChangedListener(b bVar) {
    }
}
