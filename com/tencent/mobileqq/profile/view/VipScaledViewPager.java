package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes16.dex */
public class VipScaledViewPager extends ViewPager {
    static IPatchRedirector $redirector_;
    private ViewGroup C;
    private int D;
    private int E;
    private int F;
    private boolean G;
    private AtomicBoolean H;
    private HashMap<Integer, Integer> I;

    /* renamed from: d, reason: collision with root package name */
    private int f260510d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f260511e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f260512f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f260513h;

    /* renamed from: i, reason: collision with root package name */
    private float f260514i;

    /* renamed from: m, reason: collision with root package name */
    private int f260515m;

    public VipScaledViewPager(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f260511e = new Rect();
        this.f260512f = new Rect();
        this.f260513h = new Rect();
        this.C = null;
        this.D = -1;
        this.E = -1;
        this.H = new AtomicBoolean(false);
        this.I = new HashMap<>();
        setStaticTransformationsEnabled(true);
    }

    private static void a(Point point, Point point2) {
        int i3 = point2.x;
        if (i3 >= 0 && point.x > i3) {
            point.x = i3;
        }
        int i16 = point2.y;
        if (i16 >= 0 && point.y > i16) {
            point.y = i16;
        }
    }

    private int c() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private int g(View view) {
        view.getGlobalVisibleRect(this.f260511e);
        view.getLocalVisibleRect(this.f260512f);
        Rect rect = this.f260513h;
        Rect rect2 = this.f260511e;
        int i3 = rect2.left;
        Rect rect3 = this.f260512f;
        rect.left = (i3 + rect3.left) / 2;
        int i16 = (rect2.right + rect3.right) / 2;
        rect.right = i16;
        return (Math.abs(i16) / 2) - this.f260513h.left;
    }

    private void i(Context context, AttributeSet attributeSet) {
        setClipChildren(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VipScaledViewPager);
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.VipScaledViewPager_android_maxWidth, -1));
        setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.VipScaledViewPager_android_maxHeight, -1));
        setMatchChildWidth(obtainStyledAttributes.getResourceId(R.styleable.VipScaledViewPager_matchChildId, 0));
        obtainStyledAttributes.recycle();
    }

    private void o(View view, Transformation transformation) {
        Matrix matrix = transformation.getMatrix();
        float h16 = h(view);
        matrix.setScale(h16, h16);
        int height = view.getHeight();
        matrix.preTranslate(-r2, -r1);
        matrix.postTranslate(view.getWidth() / 2, height / 2);
        transformation.setAlpha(b(view));
    }

    public float b(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this, (Object) view)).floatValue();
        }
        int g16 = this.f260510d - g(view);
        if (g16 <= 0) {
            g16 = 0;
        }
        float width = (getWidth() - (g16 * 1.6f)) / getWidth();
        if (width < 0.3f) {
            return 0.3f;
        }
        return width;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) transformation)).booleanValue();
        }
        int hashCode = view.hashCode();
        o(view, transformation);
        if (this.H.get()) {
            view.invalidate();
        } else if (this.I.containsKey(Integer.valueOf(hashCode))) {
            if (this.I.get(Integer.valueOf(hashCode)).intValue() < 1) {
                this.I.put(Integer.valueOf(hashCode), 1);
                view.invalidate();
            }
        } else {
            this.I.put(Integer.valueOf(hashCode), 0);
        }
        return true;
    }

    public float h(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this, (Object) view)).floatValue();
        }
        int g16 = this.f260510d - g(view);
        if (g16 <= 0) {
            g16 = 0;
        }
        float width = (getWidth() - g16) / getWidth();
        float f16 = this.f260514i;
        if (width < f16) {
            return f16;
        }
        return width;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            this.I.put(Integer.valueOf(childAt.hashCode()), 0);
            childAt.invalidate();
        }
    }

    protected void l(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (!this.G) {
            return;
        }
        if (this.F == 0) {
            this.G = false;
            return;
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            childAt.measure(i3, i16);
            int measuredWidth = childAt.getMeasuredWidth();
            View findViewById = childAt.findViewById(this.F);
            if (findViewById != null) {
                int measuredWidth2 = findViewById.getMeasuredWidth();
                if (measuredWidth2 > 0) {
                    this.G = false;
                    setPageMargin(-((int) (((measuredWidth - measuredWidth2) + (((1.0f - this.f260514i) * measuredWidth2) * 0.5f)) - this.f260515m)));
                    setOffscreenPageLimit(((int) Math.ceil(measuredWidth / r7)) + 1);
                    requestLayout();
                    return;
                }
                return;
            }
            throw new NullPointerException("MatchWithChildResId did not find that ID in the first fragment of the ViewPager; is that view defined in the child view's layout? Note that MultiViewPager only measures the child for index 0.");
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipScaledViewPager", 2, "startScroll");
        }
        this.H.set(true);
        k();
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipScaledViewPager", 2, "stopScroll");
        }
        this.H.set(false);
        k();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("VipScaledViewPager", 2, NodeProps.ON_INTERCEPT_TOUCH_EVENT);
        }
        ViewGroup viewGroup = this.C;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Point point = new Point(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
        if (this.D >= 0 || this.E >= 0) {
            a(point, new Point(this.D, this.E));
            i3 = View.MeasureSpec.makeMeasureSpec(point.x, 1073741824);
            i16 = View.MeasureSpec.makeMeasureSpec(point.y, 1073741824);
        }
        super.onMeasure(i3, i16);
        l(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f260510d = c();
        super.onSizeChanged(i3, i16, i17, i18);
        this.G = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) motionEvent)).booleanValue();
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setGap(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f260515m = i3;
        }
    }

    public void setMatchChildWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else if (this.F != i3) {
            this.F = i3;
            this.G = true;
        }
    }

    public void setMaxHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.E = i3;
        }
    }

    public void setMaxWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.D = i3;
        }
    }

    public void setParentView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) viewGroup);
        } else {
            this.C = viewGroup;
        }
    }

    public void setScale(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
        } else {
            this.f260514i = f16;
        }
    }

    public VipScaledViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f260511e = new Rect();
        this.f260512f = new Rect();
        this.f260513h = new Rect();
        this.C = null;
        this.D = -1;
        this.E = -1;
        this.H = new AtomicBoolean(false);
        this.I = new HashMap<>();
        setStaticTransformationsEnabled(true);
        i(context, attributeSet);
    }
}
