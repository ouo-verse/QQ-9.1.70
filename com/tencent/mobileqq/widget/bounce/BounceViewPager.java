package com.tencent.mobileqq.widget.bounce;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.Transformation;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes20.dex */
public class BounceViewPager extends ViewPager {
    private GestureDetector C;
    private final com.tencent.mobileqq.widget.bounce.a D;
    private Camera E;
    private List<b> F;

    /* renamed from: d, reason: collision with root package name */
    private float f316763d;

    /* renamed from: e, reason: collision with root package name */
    private int f316764e;

    /* renamed from: f, reason: collision with root package name */
    protected int f316765f;

    /* renamed from: h, reason: collision with root package name */
    private float f316766h;

    /* renamed from: i, reason: collision with root package name */
    private int f316767i;

    /* renamed from: m, reason: collision with root package name */
    private float f316768m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
            if (i3 == 0) {
                BounceViewPager.this.f316766h = 0.0f;
            }
            Iterator it = BounceViewPager.this.F.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onPageScrollStateChanged(i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
            BounceViewPager bounceViewPager = BounceViewPager.this;
            bounceViewPager.f316765f = i3;
            bounceViewPager.f316766h = f16;
            BounceViewPager.this.c();
            Iterator it = BounceViewPager.this.F.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onPageScrolled(i3, f16, i16);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            Iterator it = BounceViewPager.this.F.iterator();
            while (it.hasNext()) {
                ((b) it.next()).onPageSelected(i3);
            }
        }
    }

    /* loaded from: classes20.dex */
    public interface b {
        void onPageScrollStateChanged(int i3);

        void onPageScrolled(int i3, float f16, int i16);

        void onPageSelected(int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (Math.abs(f16) > Math.abs(f17)) {
                return true;
            }
            return false;
        }
    }

    public BounceViewPager(Context context) {
        super(context);
        this.D = new com.tencent.mobileqq.widget.bounce.a(this);
        this.E = new Camera();
        this.F = new ArrayList();
        init();
    }

    private void init() {
        setStaticTransformationsEnabled(true);
        setOnPageChangeListener(new a());
        this.C = new GestureDetector(getContext(), new c());
        this.f316767i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
        ((WindowManager) BaseApplication.getContext().getSystemService("window")).getDefaultDisplay().getSize(new Point());
        this.f316768m = r1.x / 2;
        z43.a aVar = new z43.a(getContext());
        aVar.a(850);
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this, aVar);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).invalidate();
        }
    }

    public void g(b bVar) {
        if (!this.F.contains(bVar)) {
            this.F.add(bVar);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        boolean z16;
        float max;
        if (view.getWidth() == 0) {
            return false;
        }
        int left = view.getLeft() / view.getWidth();
        if (left != 0 && left != getAdapter().getCount() - 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!this.D.a() || !z16) {
            return false;
        }
        transformation.clear();
        transformation.setTransformationType(2);
        float width = getWidth() / 2;
        int height = getHeight() / 2;
        transformation.getMatrix().reset();
        float f16 = this.f316768m;
        float f17 = this.D.f316771a;
        if (f17 > 0.0f) {
            max = Math.min(f17, 1.0f);
        } else {
            max = Math.max(f17, -1.0f);
        }
        this.E.save();
        this.E.translate(-(f16 * max), 0.0f, 0.0f);
        this.E.getMatrix(transformation.getMatrix());
        transformation.getMatrix().preTranslate(-width, -height);
        transformation.getMatrix().postTranslate(width, height);
        this.E.restore();
        invalidate();
        return true;
    }

    public void h(b bVar) {
        if (this.F.contains(bVar)) {
            this.F.remove(bVar);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.f316763d = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.f316764e = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                }
            } else {
                this.f316763d = motionEvent.getX();
                this.f316764e = MotionEventCompat.getPointerId(motionEvent, 0);
            }
            if (this.C.onTouchEvent(motionEvent)) {
                super.onInterceptTouchEvent(motionEvent);
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        try {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action == 6) {
                                    int action2 = (motionEvent.getAction() & 65280) >> 8;
                                    if (MotionEventCompat.getPointerId(motionEvent, action2) == this.f316764e) {
                                        if (action2 == 0) {
                                            i3 = 1;
                                        } else {
                                            i3 = 0;
                                        }
                                        this.f316763d = motionEvent.getX(i3);
                                        this.f316764e = MotionEventCompat.getPointerId(motionEvent, i3);
                                    }
                                }
                            } else {
                                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                this.f316763d = MotionEventCompat.getX(motionEvent, actionIndex);
                                this.f316764e = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            }
                        }
                    } else {
                        int i16 = this.f316764e;
                        if (i16 != -1) {
                            float x16 = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i16));
                            float f16 = this.f316763d - x16;
                            float scrollX = getScrollX();
                            int width = getWidth();
                            int pageMargin = (getPageMargin() + width) - (getPaddingLeft() + getPaddingRight());
                            int count = getAdapter().getCount() - 1;
                            int currentItem = getCurrentItem();
                            float max = Math.max(0, (currentItem - 1) * pageMargin);
                            float min = Math.min(currentItem + 1, count) * pageMargin;
                            float f17 = scrollX + f16;
                            if (this.f316766h == 0.0f) {
                                if (f17 < max) {
                                    if (max == 0.0f) {
                                        this.D.c((f16 + this.f316767i) / width);
                                    }
                                } else if (f17 > min && min == count * pageMargin) {
                                    this.D.c(((f17 - min) - this.f316767i) / width);
                                }
                            } else {
                                this.f316763d = x16;
                            }
                        } else {
                            this.D.b();
                        }
                    }
                    z16 = false;
                    if (!this.D.a() && !z16) {
                        return true;
                    }
                    if (!super.onTouchEvent(motionEvent)) {
                        return true;
                    }
                    return false;
                }
                this.f316764e = -1;
                this.D.b();
            } else {
                this.f316763d = motionEvent.getX();
                this.f316764e = MotionEventCompat.getPointerId(motionEvent, 0);
            }
            z16 = true;
            if (!this.D.a()) {
            }
            if (!super.onTouchEvent(motionEvent)) {
            }
        } catch (Exception e16) {
            QLog.e("BounceViewPager", 1, "onTouchEvent", e16);
            return true;
        }
    }

    public void setPull(float f16) {
        this.D.c(f16);
    }

    public BounceViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new com.tencent.mobileqq.widget.bounce.a(this);
        this.E = new Camera();
        this.F = new ArrayList();
        init();
    }
}
