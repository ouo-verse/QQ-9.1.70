package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class QFSViewPager extends ViewPagerCompat {

    /* renamed from: d, reason: collision with root package name */
    private boolean f90489d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f90490e;

    /* renamed from: f, reason: collision with root package name */
    private int f90491f;

    /* renamed from: h, reason: collision with root package name */
    private int f90492h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f90493i;

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(boolean z16, int i3, int i16, int i17);
    }

    public QFSViewPager(Context context) {
        super(context);
        this.f90489d = true;
        this.f90490e = true;
        this.f90493i = false;
        init();
    }

    private void init() {
        nb0.a aVar = new nb0.a(getContext());
        aVar.a(400);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, aVar);
        } catch (Exception e16) {
            QLog.e("QFSViewPager", 1, "initViewPager error:", e16);
        }
        this.f90491f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f90492h = ImmersiveUtils.getScreenWidth();
        addOnPageChangeListener(new a());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        ViewParent viewParent;
        try {
            super.addView(view, i3, layoutParams);
        } catch (Exception e16) {
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            QLog.e("QFSViewPager", 1, "addView error childView=" + view + ",parent=" + viewParent + ",index=" + i3, e16);
            if (!RFWApplication.isDebug()) {
            } else {
                throw e16;
            }
        }
    }

    public boolean c() {
        return this.f90493i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.ViewPager
    public boolean canScroll(View view, boolean z16, int i3, int i16, int i17) {
        if (view != this && (view instanceof QFSViewPager)) {
            QFSViewPager qFSViewPager = (QFSViewPager) view;
            if (!qFSViewPager.getScrollable()) {
                return qFSViewPager.canScroll(view, false, i3, i16, i17);
            }
        } else if ((view instanceof b) && ((b) view).a(z16, i3, i16, i17)) {
            return false;
        }
        return super.canScroll(view, z16, i3, i16, i17);
    }

    @Override // com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i3) {
        super.setCurrentItem(i3, this.f90490e);
    }

    public void setScrollWithAnim(boolean z16) {
        this.f90490e = z16;
    }

    public QFSViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f90489d = true;
        this.f90490e = true;
        this.f90493i = false;
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0) {
                QFSViewPager.this.f90493i = false;
            } else if (i3 == 1) {
                QFSViewPager.this.f90493i = true;
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    public void setEnableSlideRightAction(boolean z16) {
    }
}
