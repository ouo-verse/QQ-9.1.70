package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class Workspace extends FrameLayout {
    protected static final double T = Math.tan(Math.toRadians(30.0d));
    protected int C;
    protected int D;
    protected Scroller E;
    private VelocityTracker F;
    protected float G;
    protected float H;
    protected int I;
    private View.OnLongClickListener J;
    private int[] K;
    protected boolean L;
    protected int M;
    private boolean N;
    final Rect P;
    final Rect Q;
    private boolean R;
    private Rect S;

    /* renamed from: d, reason: collision with root package name */
    protected int f316591d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f316592e;

    /* renamed from: f, reason: collision with root package name */
    private int f316593f;

    /* renamed from: h, reason: collision with root package name */
    private float f316594h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f316595i;

    /* renamed from: m, reason: collision with root package name */
    protected int f316596m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public Workspace(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e() {
        this.E = new Scroller(getContext());
        this.f316596m = this.f316591d;
        Paint paint = new Paint();
        this.f316592e = paint;
        paint.setDither(false);
        this.M = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void f() {
        int width = getWidth();
        g((getScrollX() + (width / 2)) / width);
    }

    @Override // android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i3) {
        getChildAt(this.f316596m).addFocusables(arrayList, i3);
        if (i3 == 17) {
            int i16 = this.f316596m;
            if (i16 > 0) {
                getChildAt(i16 - 1).addFocusables(arrayList, i3);
                return;
            }
            return;
        }
        if (i3 == 66 && this.f316596m < getChildCount() - 1) {
            getChildAt(this.f316596m + 1).addFocusables(arrayList, i3);
        }
    }

    protected boolean c(View view, boolean z16, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof Workspace) {
                    Workspace workspace = (Workspace) childAt;
                    workspace.getGlobalVisibleRect(this.S);
                    if (!workspace.isShown() || !this.S.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        return false;
                    }
                    if (z16) {
                        if (workspace.d() > 0 || d() == 0) {
                            return true;
                        }
                        int i16 = workspace.C;
                        if (i16 != this.f316596m) {
                            workspace.setCurrentScreen(i16);
                        }
                    } else {
                        if (workspace.d() < workspace.getChildCount() - 1 || d() == getChildCount() - 1) {
                            return true;
                        }
                        int i17 = workspace.C;
                        if (i17 != this.f316596m) {
                            workspace.setCurrentScreen(i17);
                        }
                    }
                }
                if ((childAt instanceof ViewGroup) && c((ViewGroup) childAt, z16, motionEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.E.computeScrollOffset()) {
            scrollTo(this.E.getCurrX(), this.E.getCurrY());
            postInvalidate();
            return;
        }
        int i3 = this.D;
        if (i3 != -1) {
            int max = Math.max(0, Math.min(i3, getChildCount() - 1));
            this.f316596m = max;
            this.C = max;
            this.D = -1;
            a();
        }
    }

    public int d() {
        return this.f316596m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i3) {
        if (i3 == 17) {
            if (d() > 0) {
                g(d() - 1);
                return true;
            }
        } else if (i3 == 66 && d() < getChildCount() - 1) {
            g(d() + 1);
            return true;
        }
        return super.dispatchUnhandledMove(view, i3);
    }

    public void g(int i3) {
        b();
        boolean z16 = true;
        int max = Math.max(0, Math.min(i3, getChildCount() - 1));
        if (max == this.f316596m) {
            z16 = false;
        }
        if (this.C != max) {
            this.C = max;
        }
        this.D = max;
        View focusedChild = getFocusedChild();
        if (focusedChild != null && z16 && focusedChild == getChildAt(this.f316596m)) {
            focusedChild.clearFocus();
        }
        int width = (max * getWidth()) - getScrollX();
        this.E.startScroll(getScrollX(), 0, width, 0, Math.abs(width));
        invalidate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r0 != 3) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        byte b16;
        byte b17;
        boolean z16;
        if (motionEvent.getAction() == 2) {
            if (motionEvent.getX() - this.G > 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (c(getChildAt(this.C), z16, motionEvent)) {
                return false;
            }
        }
        int action = motionEvent.getAction();
        if (action == 2 && this.I != 0) {
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int abs = (int) Math.abs(x16 - this.G);
                    int abs2 = (int) Math.abs(y16 - this.H);
                    int i3 = this.M;
                    if (abs > i3) {
                        b16 = true;
                    } else {
                        b16 = false;
                    }
                    if (abs2 > i3) {
                        b17 = true;
                    } else {
                        b17 = false;
                    }
                    double d16 = abs2 / abs;
                    if ((b16 != false || b17 != false) && d16 < T) {
                        if (b16 != false) {
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            this.I = 1;
                            this.G = x16;
                            b();
                        }
                        if (this.L) {
                            this.L = false;
                            getChildAt(this.f316596m).cancelLongPress();
                        }
                    }
                }
            }
            a();
            this.I = 0;
            this.L = false;
        } else {
            this.G = x16;
            this.H = y16;
            this.L = true;
            this.I = !this.E.isFinished() ? 1 : 0;
        }
        View childAt = getChildAt(this.C);
        if (this.I == 0 || c(childAt, true, motionEvent) || c(childAt, false, motionEvent)) {
            return false;
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                if (!this.R || i26 == this.f316596m) {
                    childAt.layout(i19, 0, i19 + measuredWidth, childAt.getMeasuredHeight());
                }
                i19 += measuredWidth;
            }
        }
        this.R = false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        float f16;
        super.onMeasure(i3, i16);
        int size = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            getChildAt(i17).measure(i3, i16);
        }
        if (this.f316593f > size) {
            f16 = ((childCount * size) - r6) / ((childCount - 1) * size);
        } else {
            f16 = 1.0f;
        }
        this.f316594h = f16;
        if (this.f316595i) {
            scrollTo(this.f316596m * size, 0);
            this.f316595i = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        int i16 = this.D;
        if (i16 == -1) {
            i16 = this.f316596m;
        }
        if (i16 >= getChildCount()) {
            i16 = getChildCount() - 1;
        }
        if (getChildAt(i16) != null) {
            getChildAt(i16).requestFocus(i3, rect);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i3 = savedState.currentScreen;
        if (i3 != -1) {
            this.f316596m = i3;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentScreen = this.f316596m;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (i16 < i18 && i3 == i17) {
            this.R = true;
        } else {
            this.R = false;
        }
        if (!this.E.isFinished()) {
            this.E.forceFinished(true);
        }
        scrollTo(i3 * this.C, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3;
        if (getChildCount() < 0) {
            return true;
        }
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.I = 0;
                    }
                } else if (this.I == 1) {
                    int i16 = (int) (this.G - x16);
                    if (i16 > 0 && !this.N && this.f316596m == getChildCount() - 1) {
                        getChildCount();
                        throw null;
                    }
                    this.G = x16;
                    ViewParent parent = getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (i16 < 0) {
                        if (getScrollX() > 0) {
                            scrollBy(Math.max(-getScrollX(), i16), 0);
                        } else if (this.N) {
                            scrollBy(i16 / 3, 0);
                        }
                    } else if (i16 > 0) {
                        int right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth();
                        if (right > 0) {
                            scrollBy(Math.min(right, i16), 0);
                        } else if (this.N) {
                            scrollBy(i16 / 3, 0);
                        }
                    }
                }
            } else {
                if (this.I == 1) {
                    VelocityTracker velocityTracker = this.F;
                    velocityTracker.computeCurrentVelocity(1000);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (xVelocity > 350 && (i3 = this.f316596m) > 0) {
                        g(i3 - 1);
                    } else if (xVelocity < -350 && this.f316596m < getChildCount() - 1) {
                        g(this.f316596m + 1);
                    } else {
                        f();
                    }
                    VelocityTracker velocityTracker2 = this.F;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.F = null;
                    }
                }
                this.I = 0;
            }
        } else {
            if (!this.E.isFinished()) {
                this.E.abortAnimation();
            }
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
            this.G = x16;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        Rect rect = new Rect();
        view2.getDrawingRect(rect);
        view2.requestRectangleOnScreen(rect);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == this.f316596m && this.E.isFinished()) {
            return false;
        }
        g(indexOfChild);
        return true;
    }

    public void setAllowLongPress(boolean z16) {
        this.L = z16;
    }

    public void setAlloweffect(boolean z16) {
        this.N = z16;
    }

    public void setCurrentScreen(int i3) {
        int max = Math.max(0, Math.min(i3, getChildCount() - 1));
        this.f316596m = max;
        this.C = max;
        scrollTo(max * getWidth(), 0);
    }

    public void setDefaultScreen(int i3) {
        this.f316591d = i3;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.J = onLongClickListener;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).setOnLongClickListener(onLongClickListener);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int currentScreen;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.currentScreen = -1;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.currentScreen);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.currentScreen = -1;
            this.currentScreen = parcel.readInt();
        }
    }

    public Workspace(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316595i = true;
        this.D = -1;
        this.I = 0;
        this.K = new int[2];
        this.N = true;
        this.P = new Rect();
        this.Q = new Rect();
        this.S = new Rect();
        this.f316591d = 0;
        e();
        setDrawingCacheEnabled(true);
        setAlwaysDrawnWithCacheEnabled(true);
        setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_texture));
    }

    void a() {
    }

    void b() {
    }

    public void setOnScreenChangeListener(a aVar) {
    }
}
