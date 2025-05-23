package com.tencent.mobileqq.ark;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkHorizontalListView extends HorizontalListView {

    /* renamed from: d, reason: collision with root package name */
    private boolean f198862d;

    /* renamed from: e, reason: collision with root package name */
    private int f198863e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<a> f198864f;

    /* renamed from: h, reason: collision with root package name */
    private float f198865h;

    /* renamed from: i, reason: collision with root package name */
    private int f198866i;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(ArkHorizontalListView arkHorizontalListView);
    }

    public ArkHorizontalListView(Context context) {
        super(context);
        this.f198865h = 0.08f;
        this.f198866i = 3;
        this.f198863e = (BaseChatItemLayout.h() * 2) + MessageForArkApp.dp2px(40.0f) + context.getResources().getDimensionPixelSize(R.dimen.f158202a7);
        setStayDisplayOffsetZero(true);
        j();
    }

    @Override // com.tencent.widget.HorizontalListView
    protected boolean checkScrollToChild() {
        int i3;
        int i16;
        int left;
        boolean z16;
        int i17;
        boolean z17 = false;
        if (!this.mStayDisplayOffsetZero) {
            return false;
        }
        int i18 = f.f199484d;
        int i19 = 0;
        while (true) {
            if (i19 <= getChildCount()) {
                View childAt = getChildAt(i19);
                if (childAt != null && (childAt instanceof LinearLayout)) {
                    i3 = childAt.getRight() - childAt.getLeft();
                    break;
                }
                i19++;
            } else {
                i3 = 0;
                break;
            }
        }
        if (this.f198862d) {
            i16 = (f.f199484d - this.f198863e) - (i3 / 2);
        } else {
            i16 = this.f198863e + (i3 / 2);
        }
        QLog.d("ArkHorizontalListView", 2, "---start find card mNextX=", Integer.valueOf(this.mNextX), ",scrollStartX=", Integer.valueOf(this.mScroller.getStartX()), ",sRealDisplayWith=", Integer.valueOf(f.f199484d), ",priovtX=", Integer.valueOf(i16), ",mIsSend=", Boolean.valueOf(this.f198862d));
        View view = null;
        int i26 = 0;
        for (int i27 = 0; i27 <= getChildCount(); i27++) {
            View childAt2 = getChildAt(i27);
            if (childAt2 != null && (childAt2 instanceof LinearLayout)) {
                int left2 = (childAt2.getLeft() + childAt2.getRight()) / 2;
                int i28 = left2 - i16;
                int abs = Math.abs(i28);
                if (QLog.isColorLevel()) {
                    QLog.d("ArkHorizontalListView", 2, "view index=", Integer.valueOf(i27), " view pos(", Integer.valueOf(childAt2.getLeft()), ",", Integer.valueOf(childAt2.getRight()), "),viewCenter=", Integer.valueOf(left2), ",curDistance=", Integer.valueOf(abs), ",delta=", Integer.valueOf(i28));
                }
                if (abs <= i18) {
                    i26 = i27;
                    i18 = abs;
                    view = childAt2;
                }
            }
        }
        if (view != null) {
            int i29 = this.mNextX;
            if (this.f198862d) {
                left = view.getRight();
            } else {
                left = view.getLeft();
            }
            boolean z18 = this.f198862d;
            if (!z18 ? left < 0 : left > f.f199484d) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z18) {
                int i36 = f.f199484d;
                if (z16) {
                    left -= i36;
                } else {
                    left = i36 - left;
                }
            } else if (z16) {
                left = -left;
            }
            if (z18) {
                int i37 = this.f198863e;
                if (z16) {
                    i17 = -(left + i37);
                } else {
                    i17 = left - i37;
                }
            } else {
                int i38 = this.f198863e;
                if (z16) {
                    i17 = left + i38;
                } else {
                    i17 = i38 - left;
                }
            }
            int i39 = i29 - i17;
            if (QLog.isColorLevel()) {
                QLog.d("ArkHorizontalListView", 2, "---end find card mNextX=", Integer.valueOf(this.mNextX), ", newNextX=", Integer.valueOf(i39), ", mIsSend=", Boolean.valueOf(this.f198862d), ",targetIndex=", Integer.valueOf(i26));
            }
            if (this.mScroller.springBack(this.mNextX + getScrollX(), 0, i39, i39, 0, 0, 1000)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArkHorizontalListView", 2, "checkScrollToChild springBack return true");
                }
                invalidate();
                z17 = true;
            }
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.ark.ArkHorizontalListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (ArkHorizontalListView.this.f198864f != null && ArkHorizontalListView.this.f198864f.get() != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ArkHorizontalListView", 2, "checkScrollToChild updateHeadBorder");
                    }
                    ((a) ArkHorizontalListView.this.f198864f.get()).a(ArkHorizontalListView.this);
                }
            }
        });
        return z17;
    }

    @Override // com.tencent.widget.HorizontalListView
    protected int getFlingVelocity(int i3) {
        return i3 / this.f198866i;
    }

    @Override // com.tencent.widget.HorizontalListView
    protected float getScrollerFriction() {
        return this.f198865h;
    }

    @Override // com.tencent.widget.HorizontalListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            ViewParent parent = getParent();
            while (!(parent instanceof ListView)) {
                parent = parent.getParent();
            }
            ViewParent parent2 = parent.getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        }
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.widget.HorizontalListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        WeakReference<a> weakReference = this.f198864f;
        if (weakReference != null && weakReference.get() != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkHorizontalListView", 2, "onTouchEvent updateHeadBorder action=" + (motionEvent.getAction() & 255));
            }
            this.f198864f.get().a(this);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIsSend(boolean z16) {
        this.f198862d = z16;
    }

    public void setRefreshCallback(a aVar) {
        this.f198864f = new WeakReference<>(aVar);
    }

    public ArkHorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f198865h = 0.08f;
        this.f198866i = 3;
        this.f198863e = (BaseChatItemLayout.h() * 2) + MessageForArkApp.dp2px(40.0f) + context.getResources().getDimensionPixelSize(R.dimen.f158202a7);
        setStayDisplayOffsetZero(true);
        j();
    }

    private void j() {
    }
}
