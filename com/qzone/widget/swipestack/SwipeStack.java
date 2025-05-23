package com.qzone.widget.swipestack;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Adapter;
import android.widget.Scroller;
import com.tencent.mobileqq.R;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SwipeStack extends ViewGroup implements Handler.Callback {
    private GestureDetector C;
    private ArrayList<View> D;
    private Adapter E;
    private int F;
    private boolean G;
    private boolean H;
    private View I;
    private DataSetObserver J;
    private d K;
    private ArrayList<View> L;
    private ArrayList<View> M;
    private int N;
    ViewGroup P;
    int Q;

    /* renamed from: d, reason: collision with root package name */
    private float f61046d;

    /* renamed from: e, reason: collision with root package name */
    private float f61047e;

    /* renamed from: f, reason: collision with root package name */
    private e f61048f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f61049h;

    /* renamed from: i, reason: collision with root package name */
    private int f61050i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<View> f61051m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            SwipeStack.this.invalidate();
            SwipeStack.this.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        int f61056a;

        /* renamed from: b, reason: collision with root package name */
        int f61057b;

        /* renamed from: c, reason: collision with root package name */
        int f61058c;

        /* renamed from: d, reason: collision with root package name */
        int f61059d;

        /* renamed from: e, reason: collision with root package name */
        Scroller f61060e;

        /* renamed from: f, reason: collision with root package name */
        e f61061f;

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface d {
        void a(int i3, View view);

        void b(int i3, View view);

        void c();
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        private View f61062a;

        /* renamed from: b, reason: collision with root package name */
        float f61063b;

        /* renamed from: c, reason: collision with root package name */
        float f61064c;

        /* renamed from: d, reason: collision with root package name */
        float f61065d;

        /* renamed from: e, reason: collision with root package name */
        int f61066e;

        /* renamed from: f, reason: collision with root package name */
        int f61067f;

        /* renamed from: g, reason: collision with root package name */
        int f61068g = 0;

        /* renamed from: h, reason: collision with root package name */
        Rect f61069h;

        /* renamed from: i, reason: collision with root package name */
        PointF f61070i;

        public e() {
        }

        e c(MotionEvent motionEvent) {
            if (!SwipeStack.this.s(1)) {
                SwipeStack.this.setGestureFlag(1);
                int[] iArr = new int[2];
                SwipeStack.this.I.getLocationOnScreen(iArr);
                SwipeStack swipeStack = SwipeStack.this;
                c r16 = swipeStack.r(swipeStack.I);
                this.f61068g = (int) Math.hypot(SwipeStack.this.I.getWidth(), SwipeStack.this.I.getHeight());
                int i3 = this.f61068g;
                this.f61069h = new Rect(-i3, -i3, (int) (SwipeStack.this.f61046d + this.f61068g), (int) (SwipeStack.this.f61047e + this.f61068g));
                this.f61064c = r16.f61058c;
                this.f61065d = r16.f61059d;
                float atan2 = (float) Math.atan2(motionEvent.getRawY() - this.f61065d, motionEvent.getRawX() - this.f61064c);
                this.f61063b = atan2;
                if (atan2 < 0.0f) {
                    this.f61063b = (float) (atan2 + 6.283185307179586d);
                }
                this.f61070i = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
                this.f61067f = r16.f61056a;
                this.f61066e = r16.f61057b;
                r16.f61061f = this;
                SwipeStack.this.I.setPivotY(motionEvent.getY() - this.f61066e);
                SwipeStack.this.I.setPivotX(motionEvent.getX() - this.f61067f);
                SwipeStack.this.I.animate().cancel();
                SwipeStack.this.I.clearAnimation();
                SwipeStack swipeStack2 = SwipeStack.this;
                swipeStack2.removeView(swipeStack2.I);
                if (SwipeStack.this.I.getParent() != null) {
                    ViewParent parent = SwipeStack.this.I.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(SwipeStack.this.I);
                    }
                    QZLog.w("SwipeStack", 1, "\u5220\u9664view\u5931\u8d25\uff0c\u91cd\u8bd5\u4e00\u6b21");
                }
                if (SwipeStack.this.I.getParent() != null) {
                    QZLog.e("SwipeStack", 1, "\u5220\u9664view\u5931\u8d25\uff0c\u6b64\u6b21\u6ed1\u52a8\u4e0d\u6267\u884c");
                    return null;
                }
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(SwipeStack.this.I.getWidth(), SwipeStack.this.I.getHeight());
                SwipeStack swipeStack3 = SwipeStack.this;
                swipeStack3.P.addView(swipeStack3.I, -1, layoutParams);
                SwipeStack swipeStack4 = SwipeStack.this;
                swipeStack4.Q++;
                swipeStack4.I.setX(iArr[0]);
                SwipeStack.this.I.setY(iArr[1]);
                int i16 = iArr[0];
                this.f61067f = i16;
                int i17 = iArr[1];
                this.f61066e = i17;
                r16.f61056a = i16;
                r16.f61057b = i17;
                this.f61062a = SwipeStack.this.I;
                if (QZLog.isColorLevel()) {
                    QZLog.d("SwipeStack", 2, String.format("initFirstScroll rootview add scrollingView=%s,TouchDownAttribute:%s", String.valueOf(this.f61062a), String.valueOf(this)));
                }
            }
            return this;
        }
    }

    public SwipeStack(Context context) {
        this(context, null);
    }

    private View A() {
        if (this.f61051m.size() > 0) {
            return this.f61051m.remove(0);
        }
        return null;
    }

    private void m() {
        if (this.F >= this.E.getCount()) {
            if (!this.f61049h) {
                return;
            } else {
                this.F = 0;
            }
        }
        View A = A();
        View view = this.E.getView(this.F, A, this);
        view.setTag(R.id.f166939j94, Integer.valueOf(this.F));
        view.setTag(R.id.f166936j91, Boolean.TRUE);
        if (!this.G) {
            view.setLayerType(2, null);
        }
        measureChildWithMargins(view, getWidth() | 1073741824, 0, getWidth() | 1073741824, 0);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        if (A == view) {
            attachViewToParent(view, 0, layoutParams);
        } else {
            w(A);
            addViewInLayout(view, 0, layoutParams, true);
        }
        int i3 = this.F + 1;
        this.F = i3;
        if (!this.f61049h || i3 < this.E.getCount()) {
            return;
        }
        this.F = 0;
    }

    private void o() {
        if (this.D.size() > 0) {
            Iterator<View> it = this.D.iterator();
            while (it.hasNext()) {
                View next = it.next();
                next.clearAnimation();
                x(next);
            }
            this.D.clear();
        }
        if (this.L.size() > 0) {
            Iterator<View> it5 = this.L.iterator();
            while (it5.hasNext()) {
                View next2 = it5.next();
                next2.clearAnimation();
                x(next2);
            }
            this.L.clear();
        }
        if (this.f61051m.size() > 0) {
            Iterator<View> it6 = this.f61051m.iterator();
            while (it6.hasNext()) {
                removeDetachedView(it6.next(), false);
            }
            this.f61051m.clear();
        }
    }

    private void q(View view) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.25f, 1.0f), Keyframe.ofFloat(0.5f, -1.0f), Keyframe.ofFloat(0.75f, 1.0f), Keyframe.ofFloat(1.0f, 0.0f)));
        ofPropertyValuesHolder.setDuration(664L);
        ofPropertyValuesHolder.start();
    }

    private void v(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SwipeStack);
        try {
            this.G = obtainStyledAttributes.getBoolean(3, true);
            this.f61049h = obtainStyledAttributes.getBoolean(0, false);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view) {
        d dVar;
        d dVar2;
        if (QZLog.isColorLevel()) {
            QZLog.d("SwipeStack", 2, String.format("removeScrollingView rootview remove scrollingView=%s", String.valueOf(view)));
        }
        if (view != null) {
            view.animate().setListener(null);
            view.clearAnimation();
            Integer num = (Integer) view.getTag(R.id.f166939j94);
            if (num != null && (dVar2 = this.K) != null) {
                dVar2.b(num.intValue(), view);
            }
            if (this.P.indexOfChild(view) >= 0) {
                this.Q--;
                this.P.removeViewInLayout(view);
            }
        }
        if (getChildCount() != 0 || (dVar = this.K) == null) {
            return;
        }
        dVar.c();
    }

    @Override // android.view.View
    public void computeScroll() {
        Rect rect;
        super.computeScroll();
        if (this.D.size() > 0) {
            Iterator<View> it = this.D.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next == null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.e("SwipeStack", "computeScroll view=null;");
                    }
                } else {
                    c r16 = r(next);
                    Scroller scroller = r16.f61060e;
                    if (scroller == null) {
                        if (QZLog.isColorLevel()) {
                            QZLog.e("SwipeStack", String.format("view=%s computeScroll scroller=null;", String.valueOf(next)));
                        }
                        this.L.add(next);
                    } else if (scroller.computeScrollOffset()) {
                        e eVar = r16.f61061f;
                        int currX = scroller.getCurrX();
                        int currY = scroller.getCurrY();
                        if (eVar != null && (rect = eVar.f61069h) != null && rect.contains(currX, currY)) {
                            PointF pointF = eVar.f61070i;
                            float f16 = (currX - pointF.x) + eVar.f61067f;
                            float f17 = (currY - pointF.y) + eVar.f61066e;
                            float x16 = f16 - next.getX();
                            e eVar2 = r16.f61061f;
                            eVar2.f61064c = eVar2.f61064c - x16;
                            float atan2 = (float) Math.atan2(r6 - eVar2.f61065d, r5 - r9);
                            next.setX(f16);
                            next.setY(f17);
                            next.setRotation((float) Math.toDegrees(atan2 - eVar.f61063b));
                            invalidate();
                        } else {
                            scroller.abortAnimation();
                            invalidate();
                        }
                    } else {
                        this.L.add(next);
                        r16.f61060e = null;
                    }
                }
            }
        }
        if (this.L.size() > 0) {
            post(new Runnable() { // from class: com.qzone.widget.swipestack.SwipeStack.3
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it5 = SwipeStack.this.L.iterator();
                    while (it5.hasNext()) {
                        View view = (View) it5.next();
                        SwipeStack.this.x(view);
                        SwipeStack.this.M.add(view);
                    }
                    SwipeStack.this.D.removeAll(SwipeStack.this.L);
                    SwipeStack.this.L.removeAll(SwipeStack.this.M);
                    SwipeStack.this.M.clear();
                }
            });
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.P = (ViewGroup) getRootView().findViewById(R.id.nhi);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (motionEvent.getAction() == 0) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
            this.C.onTouchEvent(motionEvent);
            return false;
        }
        if (2 == motionEvent.getAction()) {
            return this.C.onTouchEvent(motionEvent);
        }
        if ((3 == motionEvent.getAction() || 1 == motionEvent.getAction()) && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        Adapter adapter = this.E;
        if (adapter != null && !adapter.isEmpty()) {
            for (int childCount = getChildCount(); childCount < 3 && childCount < this.E.getCount(); childCount++) {
                m();
            }
            y();
            this.H = false;
            return;
        }
        this.F = 0;
        removeAllViewsInLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        if (2 == motionEvent.getAction()) {
            this.C.onTouchEvent(motionEvent);
        } else if (1 == motionEvent.getAction() || 3 == motionEvent.getAction()) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
            if (!this.C.onTouchEvent(motionEvent) && !u()) {
                setGestureFlag(-1);
                e eVar = this.f61048f;
                if (eVar != null) {
                    n(eVar.f61062a, motionEvent);
                    this.f61048f.f61062a = null;
                }
            }
        }
        return true;
    }

    public boolean s(int i3) {
        return !u() && (this.N & i3) == i3;
    }

    public void setAdapter(Adapter adapter) {
        Adapter adapter2 = this.E;
        if (adapter2 != null) {
            adapter2.unregisterDataSetObserver(this.J);
        }
        this.E = adapter;
        adapter.registerDataSetObserver(this.J);
    }

    public void setmListener(d dVar) {
        this.K = dVar;
    }

    public void setmLoop(boolean z16) {
        this.f61049h = z16;
    }

    public boolean u() {
        return this.N == -1;
    }

    public SwipeStack(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void t() {
        setClipToPadding(false);
        setClipChildren(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f61046d = displayMetrics.widthPixels;
        this.f61047e = displayMetrics.heightPixels;
        this.J = new a();
        this.C = new GestureDetector(getContext(), new b());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public void z() {
        this.H = true;
        this.F = 0;
        removeAllViewsInLayout();
        requestLayout();
    }

    public SwipeStack(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f61051m = new ArrayList<>();
        this.D = new ArrayList<>();
        this.H = true;
        this.L = new ArrayList<>();
        this.M = new ArrayList<>();
        this.Q = 0;
        v(attributeSet);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p(MotionEvent motionEvent, float f16, float f17) {
        float abs;
        float atan2 = (float) Math.atan2(f17, f16);
        float f18 = this.f61048f.f61064c;
        float sin = ((float) Math.sin(atan2 + 1.5707963267948966d)) * f16;
        if (f16 > 0.0f) {
            abs = -Math.abs(sin);
        } else {
            abs = Math.abs(sin);
        }
        this.f61048f.f61064c = f18 + abs;
        return (float) Math.toDegrees(((float) Math.atan2(motionEvent.getRawY() - this.f61048f.f61065d, motionEvent.getRawX() - this.f61048f.f61064c)) - this.f61048f.f61063b);
    }

    private void y() {
        this.f61050i = getChildCount() - 1;
        int paddingLeft = getPaddingLeft();
        int right = (getRight() - getLeft()) - getPaddingRight();
        int paddingTop = getPaddingTop();
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        char c16 = 0;
        final int i3 = 0;
        while (i3 < getChildCount()) {
            final View childAt = getChildAt(i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i16 = (((((right - paddingLeft) - measuredWidth) / 2) + paddingLeft) + marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            int i17 = (((((bottom - paddingTop) - measuredHeight) / 2) + paddingTop) + marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
            int i18 = measuredWidth + i16;
            int i19 = measuredHeight + i17;
            childAt.layout(i16, i17, i18, i19);
            childAt.layout(i16, i17, i18, i19);
            childAt.setTranslationZ(i3);
            if (Boolean.TRUE.equals((Boolean) childAt.getTag(R.id.f166936j91))) {
                childAt.setY(i17);
                childAt.setX(i16);
                childAt.setScaleY(0.95f);
                childAt.setScaleX(0.95f);
                childAt.setRotation(-1.5f);
                childAt.setTag(R.id.f166936j91, Boolean.FALSE);
            }
            if (i3 == this.f61050i) {
                c r16 = r(childAt);
                this.I = childAt;
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                float width = iArr[c16] + (this.I.getWidth() / 2);
                float f16 = iArr[1];
                r16.f61058c = (int) width;
                r16.f61059d = (int) f16;
                r16.f61056a = i16;
                r16.f61057b = i17;
                if (this.K != null) {
                    Integer num = (Integer) this.I.getTag(R.id.f166939j94);
                    if (num == null) {
                        QZLog.e("SwipeStack", "reorderItems  pos==null");
                    } else {
                        this.K.a(num.intValue(), this.I);
                    }
                }
            }
            if (!this.H) {
                postDelayed(new Runnable() { // from class: com.qzone.widget.swipestack.SwipeStack.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i3 == SwipeStack.this.f61050i) {
                            childAt.animate().scaleX(1.0f).scaleY(1.0f).rotation(0.0f).setDuration(208L);
                        } else if (SwipeStack.this.f61050i - i3 == 1) {
                            childAt.animate().rotation(3.0f).setDuration(208L);
                        }
                    }
                }, 166L);
            } else {
                int i26 = this.f61050i;
                if (i3 == i26) {
                    childAt.setRotation(0.0f);
                    childAt.setScaleY(1.0f);
                    childAt.setScaleX(1.0f);
                    q(childAt);
                } else if (i26 - i3 == 1) {
                    childAt.setRotation(3.0f);
                } else if (i26 - i3 == 2) {
                    childAt.setRotation(-1.5f);
                }
            }
            i3++;
            c16 = 0;
        }
    }

    c r(View view) {
        c cVar = (c) view.getTag(R.id.f166937j92);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        view.setTag(R.id.f166937j92, cVar2);
        return cVar2;
    }

    public void setParams(View view, c cVar) {
        view.setTag(R.id.f166937j92, cVar);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        if (i3 == 8) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements GestureDetector.OnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            float x16 = SwipeStack.this.I.getX();
            float y16 = SwipeStack.this.I.getY();
            if (!new RectF(x16, y16, SwipeStack.this.I.getWidth() + x16, SwipeStack.this.I.getHeight() + y16).contains(motionEvent.getX(), motionEvent.getY())) {
                SwipeStack.this.setGestureFlag(-1);
            } else {
                SwipeStack.this.setGestureFlag(0);
                SwipeStack swipeStack = SwipeStack.this;
                swipeStack.f61048f = new e();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (SwipeStack.this.f61048f == null) {
                QZLog.e("SwipeStack", 1, "onScroll touchDownAttribute==null");
                return false;
            }
            if (SwipeStack.this.u()) {
                QZLog.w("SwipeStack", 2, "onScroll gestureEnd");
                if (SwipeStack.this.f61048f != null) {
                    SwipeStack swipeStack = SwipeStack.this;
                    swipeStack.n(swipeStack.f61048f.f61062a, motionEvent2);
                }
                return false;
            }
            SwipeStack swipeStack2 = SwipeStack.this;
            swipeStack2.f61048f = swipeStack2.f61048f.c(motionEvent);
            if (SwipeStack.this.f61048f != null) {
                View view = SwipeStack.this.f61048f.f61062a;
                if (view == null) {
                    QZLog.e("SwipeStack", "onScroll scrollingView==null");
                    return false;
                }
                float x16 = view.getX() - f16;
                float y16 = view.getY() - f17;
                view.setX(x16);
                view.setY(y16);
                view.setRotation(SwipeStack.this.p(motionEvent2, f16, f17));
                return true;
            }
            QZLog.e("SwipeStack", 1, "\u521d\u59cb\u5316TouchDownAttribute\u5931\u8d25\uff0c\u6b64\u6b21\u4e92\u52a8\u64cd\u4f5c\u4e0d\u6267\u884c");
            SwipeStack.this.setGestureFlag(-1);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            SwipeStack.this.setGestureFlag(-1);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            int i3;
            int rawX;
            int i16;
            int rawY;
            SwipeStack.this.setGestureFlag(-1);
            if (SwipeStack.this.f61048f != null) {
                View view = SwipeStack.this.f61048f.f61062a;
                if (view == null) {
                    QZLog.e("SwipeStack", 1, "onFling scrollingView==null");
                    return false;
                }
                if (((float) Math.hypot(f16, f17)) < 1000.0f) {
                    SwipeStack.this.n(view, motionEvent2);
                    SwipeStack.this.f61048f.f61062a = null;
                } else {
                    int i17 = SwipeStack.this.f61048f.f61068g;
                    Scroller scroller = new Scroller(SwipeStack.this.getContext());
                    int rawX2 = (int) motionEvent2.getRawX();
                    int rawY2 = (int) motionEvent2.getRawY();
                    int i18 = (int) f16;
                    int i19 = (int) f17;
                    if (i18 > 0) {
                        rawX = (int) (SwipeStack.this.f61046d + i17);
                        i3 = (int) motionEvent2.getRawX();
                    } else {
                        i3 = -i17;
                        rawX = (int) motionEvent2.getRawX();
                    }
                    if (i19 > 0) {
                        rawY = (int) (SwipeStack.this.f61047e + i17);
                        i16 = (int) motionEvent2.getRawY();
                    } else {
                        i16 = -i17;
                        rawY = (int) motionEvent2.getRawY();
                    }
                    if (QZLog.isColorLevel()) {
                        QZLog.e("SwipeStack", 2, "onFling Start Fling");
                    }
                    scroller.setFriction(0.01f);
                    scroller.fling(rawX2, rawY2, i18, i19, i3, rawX, i16, rawY);
                    SwipeStack.this.D.add(view);
                    SwipeStack.this.r(view).f61060e = scroller;
                    SwipeStack.this.f61048f.f61062a = null;
                    SwipeStack.this.invalidate();
                }
                return true;
            }
            QZLog.e("SwipeStack", 1, "onFling touchDownAttribute==null");
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(View view, MotionEvent motionEvent) {
        int i3;
        int i16;
        int rawY;
        double d16;
        double tan;
        int rawX;
        double tan2;
        int rawX2;
        double tan3;
        int i17;
        int i18;
        if (view == null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("SwipeStack", 2, "checkViewPosition: v==null");
                return;
            }
            return;
        }
        float x16 = view.getX() - this.f61048f.f61067f;
        Scroller scroller = new Scroller(getContext());
        int i19 = this.f61048f.f61068g;
        int rawX3 = (int) motionEvent.getRawX();
        int rawY2 = (int) motionEvent.getRawY();
        PointF pointF = this.f61048f.f61070i;
        float f16 = pointF.x;
        float f17 = pointF.y;
        float atan2 = (float) Math.atan2(motionEvent.getRawY() - f17, motionEvent.getRawX() - f16);
        if (atan2 < 0.0f) {
            atan2 = (float) (atan2 + 6.283185307179586d);
        }
        double d17 = atan2;
        if (d17 >= 4.71238898038469d) {
            float atan22 = (float) Math.atan2(-f17, this.f61046d - f16);
            if (atan22 < 0.0f) {
                atan22 = (float) (atan22 + 6.283185307179586d);
            }
            if (atan2 > atan22) {
                rawX2 = (int) ((i19 + this.f61046d) - motionEvent.getRawX());
                tan3 = 0 / Math.tan(d17);
                i18 = (int) tan3;
            } else {
                rawX = (int) ((-i19) - motionEvent.getRawY());
                tan2 = rawX * Math.tan(d17);
                int i26 = rawX;
                rawX2 = (int) tan2;
                i18 = i26;
            }
        } else {
            if (d17 >= 3.141592653589793d) {
                float atan23 = (float) Math.atan2(-f17, -f16);
                if (atan23 < 0.0f) {
                    atan23 = (float) (atan23 + 6.283185307179586d);
                }
                if (atan2 > atan23) {
                    rawY = (int) ((-i19) - motionEvent.getRawY());
                    d16 = rawY;
                    tan = Math.tan(d17);
                } else {
                    int rawX4 = (int) ((-i19) - motionEvent.getRawX());
                    rawY = (int) (rawX4 * Math.tan(d17));
                    i17 = rawX4;
                    i3 = i17;
                    i16 = rawY;
                    scroller.startScroll(rawX3, rawY2, i3, i16, 1000);
                    this.D.add(view);
                    r(view).f61060e = scroller;
                    if (QZLog.isColorLevel()) {
                        QZLog.d("SwipeStack", 2, String.format("checkViewPosition v=%s", String.valueOf(view)));
                    }
                    invalidate();
                }
            } else if (d17 >= 1.5707963267948966d) {
                float atan24 = (float) Math.atan2(this.f61047e - f17, -f16);
                if (atan24 < 0.0f) {
                    atan24 = (float) (atan24 + 6.283185307179586d);
                }
                if (atan2 > atan24) {
                    rawX2 = (int) ((-i19) - motionEvent.getRawX());
                    tan3 = rawX2 * Math.tan(d17);
                    i18 = (int) tan3;
                } else {
                    rawX = (int) ((i19 + this.f61047e) - motionEvent.getRawX());
                    tan2 = rawX / Math.tan(d17);
                    int i262 = rawX;
                    rawX2 = (int) tan2;
                    i18 = i262;
                }
            } else {
                if (atan2 >= 0.0f) {
                    float atan25 = (float) Math.atan2(this.f61047e - f17, this.f61046d - f16);
                    if (atan25 < 0.0f) {
                        atan25 = (float) (atan25 + 6.283185307179586d);
                    }
                    if (atan2 > atan25) {
                        rawY = (int) ((this.f61047e + i19) - motionEvent.getRawY());
                        d16 = rawY;
                        tan = Math.tan(d17);
                    } else {
                        int rawX5 = (int) ((this.f61046d + i19) - motionEvent.getRawX());
                        i16 = (int) (x16 * Math.tan(d17));
                        i3 = rawX5;
                    }
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                scroller.startScroll(rawX3, rawY2, i3, i16, 1000);
                this.D.add(view);
                r(view).f61060e = scroller;
                if (QZLog.isColorLevel()) {
                }
                invalidate();
            }
            i17 = (int) (d16 / tan);
            i3 = i17;
            i16 = rawY;
            scroller.startScroll(rawX3, rawY2, i3, i16, 1000);
            this.D.add(view);
            r(view).f61060e = scroller;
            if (QZLog.isColorLevel()) {
            }
            invalidate();
        }
        i16 = i18;
        i3 = rawX2;
        scroller.startScroll(rawX3, rawY2, i3, i16, 1000);
        this.D.add(view);
        r(view).f61060e = scroller;
        if (QZLog.isColorLevel()) {
        }
        invalidate();
    }

    private void w(View view) {
        if (view == null) {
            return;
        }
        view.setTag(R.id.f166936j91, Boolean.FALSE);
        this.f61051m.add(view);
    }

    public void setGestureFlag(int i3) {
        if (i3 != 0 && i3 != -1) {
            this.N = (this.N & (~i3)) | i3;
        } else {
            this.N = i3;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("SwipeStack", String.format("setGestureFlag  flag:%d,  mGestureFlag:%d", Integer.valueOf(i3), Integer.valueOf(this.N)));
        }
    }
}
