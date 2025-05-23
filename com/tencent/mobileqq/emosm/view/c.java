package com.tencent.mobileqq.emosm.view;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes6.dex */
public class c extends d implements View.OnTouchListener, GestureDetector.OnGestureListener {
    private int C;
    int D;
    boolean E;
    boolean F;
    GestureDetector G;
    GestureDetector H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int[] M;
    private int N;
    private int P;
    int Q;
    int R;
    boolean S;
    private float T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    DragSortListView Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    float f204449a0;

    /* renamed from: b0, reason: collision with root package name */
    int f204450b0;

    /* renamed from: c0, reason: collision with root package name */
    private GestureDetector.OnGestureListener f204451c0;

    /* renamed from: i, reason: collision with root package name */
    private int f204452i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f204453m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            c cVar;
            int i3;
            if (!c.this.Y.isDragEnabled() && (i3 = (cVar = c.this).f204450b0) != -1) {
                cVar.Y.setTapPos(i3);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (!c.this.Y.isDragEnabled() && Math.abs(f16) > Math.abs(f17) && !c.this.Y.isScrolling() && !c.this.S) {
                float abs = Math.abs(f16);
                c cVar = c.this;
                if (abs <= cVar.f204449a0 || (f16 < 0.0f && cVar.D == 2)) {
                    return false;
                }
                if (f16 > 0.0f && cVar.D == 1) {
                    return false;
                }
                cVar.Y.setSrcPos(cVar.f204450b0);
                c.this.Y.showDelButton();
            }
            return false;
        }
    }

    public c(DragSortListView dragSortListView) {
        this(dragSortListView, 0, 0, 1);
    }

    public int b(MotionEvent motionEvent) {
        return n(motionEvent, this.U);
    }

    public int c(MotionEvent motionEvent) {
        return n(motionEvent, this.W);
    }

    public void d(int i3) {
        this.V = i3;
    }

    public void e(int i3) {
        this.U = i3;
    }

    public void f(int i3) {
        this.f204452i = i3;
    }

    public void g(boolean z16) {
        this.E = z16;
    }

    public void h(int i3) {
        this.C = i3;
    }

    public void i(int i3) {
        this.D = i3;
    }

    public void j(boolean z16) {
        this.f204453m = z16;
    }

    public boolean k(int i3, int i16, int i17) {
        int i18;
        if (this.f204453m && !this.F) {
            i18 = 12;
        } else {
            i18 = 0;
        }
        if (this.E && this.F) {
            i18 = i18 | 1 | 2;
        }
        DragSortListView dragSortListView = this.Y;
        boolean startDrag = dragSortListView.startDrag(i3 - dragSortListView.getHeaderViewsCount(), i18, i16, i17);
        this.S = startDrag;
        return startDrag;
    }

    public int l(MotionEvent motionEvent) {
        return b(motionEvent);
    }

    public int m(MotionEvent motionEvent) {
        if (this.C == 1) {
            return c(motionEvent);
        }
        return -1;
    }

    public int n(MotionEvent motionEvent, int i3) {
        View findViewById;
        int pointToPosition = this.Y.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.Y.getHeaderViewsCount();
        int footerViewsCount = this.Y.getFooterViewsCount();
        int count = this.Y.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.Y;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (i3 == 0) {
                findViewById = childAt;
            } else {
                findViewById = childAt.findViewById(i3);
            }
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.M);
                int[] iArr = this.M;
                int i16 = iArr[0];
                if (rawX > i16 && rawY > iArr[1] && rawX < i16 + findViewById.getWidth() && rawY < this.M[1] + findViewById.getHeight()) {
                    this.N = childAt.getLeft();
                    this.P = childAt.getTop();
                    return pointToPosition;
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.E && this.C == 0) {
            this.L = n(motionEvent, this.V);
        }
        this.f204450b0 = this.Y.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int l3 = l(motionEvent);
        this.J = l3;
        if (l3 != -1 && this.f204452i == 0) {
            k(l3, ((int) motionEvent.getX()) - this.N, ((int) motionEvent.getY()) - this.P);
        }
        this.F = false;
        this.X = true;
        this.Z = 0;
        this.K = m(motionEvent);
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.view.DragSortListView.i
    public void onDragFloatView(View view, Point point, Point point2) {
        if (this.E && this.F) {
            this.Z = point.x;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.J != -1 && this.f204452i == 2) {
            this.Y.performHapticFeedback(0);
            k(this.J, this.Q - this.N, this.R - this.P);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        int i3;
        if (motionEvent != null && motionEvent2 != null) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int x17 = (int) motionEvent2.getX();
            int y17 = (int) motionEvent2.getY();
            int i16 = x17 - this.N;
            int i17 = y17 - this.P;
            if (this.X && !this.S && ((i3 = this.J) != -1 || this.K != -1)) {
                if (i3 != -1) {
                    if (this.f204452i == 1 && Math.abs(y17 - y16) > this.I && this.f204453m) {
                        k(this.J, i16, i17);
                    } else if (this.f204452i != 0 && Math.abs(x17 - x16) > this.I && this.E) {
                        this.F = true;
                        k(this.K, i16, i17);
                    }
                } else if (this.K != -1) {
                    if (Math.abs(x17 - x16) > this.I && this.E) {
                        this.F = true;
                        k(this.K, i16, i17);
                    } else if (Math.abs(y17 - y16) > this.I) {
                        this.X = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i3;
        if (this.E && this.C == 0 && (i3 = this.L) != -1) {
            DragSortListView dragSortListView = this.Y;
            dragSortListView.removeItem(i3 - dragSortListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r3 != 3) goto L27;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.Y.isDragEnabled() && !this.Y.listViewIntercepted()) {
            this.G.onTouchEvent(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action == 1) {
                    if (this.E && this.F) {
                        int i3 = this.Z;
                        if (i3 < 0) {
                            i3 = -i3;
                        }
                        if (i3 > this.Y.getWidth() / 2) {
                            this.Y.stopDragWithVelocity(false, 0.0f);
                        }
                    }
                }
                this.F = false;
                this.S = false;
            } else {
                this.Q = (int) motionEvent.getX();
                this.R = (int) motionEvent.getY();
            }
            return false;
        }
        if (this.Y.isDragEnabled()) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f204450b0 = this.Y.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        return this.H.onTouchEvent(motionEvent);
    }

    public c(DragSortListView dragSortListView, int i3, int i16, int i17) {
        this(dragSortListView, i3, i16, i17, 0);
    }

    public c(DragSortListView dragSortListView, int i3, int i16, int i17, int i18) {
        this(dragSortListView, i3, i16, i17, i18, 0);
    }

    public c(DragSortListView dragSortListView, int i3, int i16, int i17, int i18, int i19) {
        super(dragSortListView);
        this.f204452i = 0;
        this.f204453m = true;
        this.E = false;
        this.F = false;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.M = new int[2];
        this.S = false;
        this.T = 500.0f;
        this.f204449a0 = ViewConfiguration.getTouchSlop() + 2;
        this.f204451c0 = new a();
        this.Y = dragSortListView;
        this.G = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), this.f204451c0);
        this.H = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.I = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.U = i3;
        this.V = i18;
        this.W = i19;
        h(i17);
        f(i16);
        this.D = 3;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
