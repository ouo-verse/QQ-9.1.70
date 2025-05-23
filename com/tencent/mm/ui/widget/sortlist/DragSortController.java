package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DragSortController extends SimpleFloatViewManager implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static final int CLICK_REMOVE = 0;
    public static final int FLING_REMOVE = 1;
    public static final int MISS = -1;
    public static final int ON_DOWN = 0;
    public static final int ON_DRAG = 1;
    public static final int ON_LONG_PRESS = 2;
    public DragSortListView A;
    public int B;
    public GestureDetector.OnGestureListener C;

    /* renamed from: e, reason: collision with root package name */
    public int f153845e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f153846f;

    /* renamed from: g, reason: collision with root package name */
    public int f153847g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f153848h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f153849i;

    /* renamed from: j, reason: collision with root package name */
    public GestureDetector f153850j;

    /* renamed from: k, reason: collision with root package name */
    public GestureDetector f153851k;

    /* renamed from: l, reason: collision with root package name */
    public int f153852l;

    /* renamed from: m, reason: collision with root package name */
    public int f153853m;

    /* renamed from: n, reason: collision with root package name */
    public int f153854n;

    /* renamed from: o, reason: collision with root package name */
    public int f153855o;

    /* renamed from: p, reason: collision with root package name */
    public int[] f153856p;

    /* renamed from: q, reason: collision with root package name */
    public int f153857q;

    /* renamed from: r, reason: collision with root package name */
    public int f153858r;

    /* renamed from: s, reason: collision with root package name */
    public int f153859s;

    /* renamed from: t, reason: collision with root package name */
    public int f153860t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f153861u;

    /* renamed from: v, reason: collision with root package name */
    public float f153862v;

    /* renamed from: w, reason: collision with root package name */
    public int f153863w;

    /* renamed from: x, reason: collision with root package name */
    public int f153864x;

    /* renamed from: y, reason: collision with root package name */
    public int f153865y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f153866z;

    public DragSortController(DragSortListView dragSortListView) {
        this(dragSortListView, 0, 0, 1);
    }

    public int dragHandleHitPosition(MotionEvent motionEvent) {
        return viewIdHitPosition(motionEvent, this.f153863w);
    }

    public int flingHandleHitPosition(MotionEvent motionEvent) {
        return viewIdHitPosition(motionEvent, this.f153865y);
    }

    public int getDragInitMode() {
        return this.f153845e;
    }

    public int getRemoveMode() {
        return this.f153847g;
    }

    public boolean isRemoveEnabled() {
        return this.f153848h;
    }

    public boolean isSortEnabled() {
        return this.f153846f;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.f153848h && this.f153847g == 0) {
            this.f153855o = viewIdHitPosition(motionEvent, this.f153864x);
        }
        int startDragPosition = startDragPosition(motionEvent);
        this.f153853m = startDragPosition;
        if (startDragPosition != -1 && this.f153845e == 0) {
            startDrag(startDragPosition, ((int) motionEvent.getX()) - this.f153857q, ((int) motionEvent.getY()) - this.f153858r);
        }
        this.f153849i = false;
        this.f153866z = true;
        this.B = 0;
        this.f153854n = startFlingPosition(motionEvent);
        return true;
    }

    @Override // com.tencent.mm.ui.widget.sortlist.SimpleFloatViewManager, com.tencent.mm.ui.widget.sortlist.DragSortListView.FloatViewManager
    public void onDragFloatView(View view, Point point, Point point2) {
        if (this.f153848h && this.f153849i) {
            this.B = point.x;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.f153853m != -1 && this.f153845e == 2) {
            this.A.performHapticFeedback(0);
            startDrag(this.f153853m, this.f153859s - this.f153857q, this.f153860t - this.f153858r);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        int i3;
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int x17 = (int) motionEvent2.getX();
        int y17 = (int) motionEvent2.getY();
        int i16 = x17 - this.f153857q;
        int i17 = y17 - this.f153858r;
        if (this.f153866z && !this.f153861u && ((i3 = this.f153853m) != -1 || this.f153854n != -1)) {
            if (i3 != -1) {
                if (this.f153845e == 1 && Math.abs(y17 - y16) > this.f153852l && this.f153846f) {
                    startDrag(this.f153853m, i16, i17);
                } else if (this.f153845e != 0 && Math.abs(x17 - x16) > this.f153852l && this.f153848h) {
                    this.f153849i = true;
                    startDrag(this.f153854n, i16, i17);
                }
            } else if (this.f153854n != -1) {
                if (Math.abs(x17 - x16) > this.f153852l && this.f153848h) {
                    this.f153849i = true;
                    startDrag(this.f153854n, i16, i17);
                } else if (Math.abs(y17 - y16) > this.f153852l) {
                    this.f153866z = false;
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i3;
        if (this.f153848h && this.f153847g == 0 && (i3 = this.f153855o) != -1) {
            DragSortListView dragSortListView = this.A;
            dragSortListView.removeItem(i3 - dragSortListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.A.isDragEnabled() && !this.A.listViewIntercepted()) {
            this.f153850j.onTouchEvent(motionEvent);
            if (this.f153848h && this.f153861u && this.f153847g == 1) {
                this.f153851k.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        this.f153849i = false;
                        this.f153861u = false;
                    }
                } else if (this.f153848h && this.f153849i) {
                    int i3 = this.B;
                    if (i3 < 0) {
                        i3 = -i3;
                    }
                    if (i3 > this.A.getWidth() / 2) {
                        this.A.stopDragWithVelocity(true, 0.0f);
                    }
                }
            } else {
                this.f153859s = (int) motionEvent.getX();
                this.f153860t = (int) motionEvent.getY();
            }
        }
        return false;
    }

    public void setClickRemoveId(int i3) {
        this.f153864x = i3;
    }

    public void setDragHandleId(int i3) {
        this.f153863w = i3;
    }

    public void setDragInitMode(int i3) {
        this.f153845e = i3;
    }

    public void setFlingHandleId(int i3) {
        this.f153865y = i3;
    }

    public void setRemoveEnabled(boolean z16) {
        this.f153848h = z16;
    }

    public void setRemoveMode(int i3) {
        this.f153847g = i3;
    }

    public void setSortEnabled(boolean z16) {
        this.f153846f = z16;
    }

    public boolean startDrag(int i3, int i16, int i17) {
        int i18;
        if (this.f153846f && !this.f153849i) {
            i18 = 12;
        } else {
            i18 = 0;
        }
        if (this.f153848h && this.f153849i) {
            i18 = i18 | 1 | 2;
        }
        DragSortListView dragSortListView = this.A;
        boolean startDrag = dragSortListView.startDrag(i3 - dragSortListView.getHeaderViewsCount(), i18, i16, i17);
        this.f153861u = startDrag;
        return startDrag;
    }

    public int startDragPosition(MotionEvent motionEvent) {
        return dragHandleHitPosition(motionEvent);
    }

    public int startFlingPosition(MotionEvent motionEvent) {
        if (this.f153847g == 1) {
            return flingHandleHitPosition(motionEvent);
        }
        return -1;
    }

    public int viewIdHitPosition(MotionEvent motionEvent, int i3) {
        View findViewById;
        int pointToPosition = this.A.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.A.getHeaderViewsCount();
        int footerViewsCount = this.A.getFooterViewsCount();
        int count = this.A.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.A;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (i3 == 0) {
                findViewById = childAt;
            } else {
                findViewById = childAt.findViewById(i3);
            }
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.f153856p);
                int[] iArr = this.f153856p;
                int i16 = iArr[0];
                if (rawX > i16 && rawY > iArr[1] && rawX < i16 + findViewById.getWidth() && rawY < this.f153856p[1] + findViewById.getHeight()) {
                    this.f153857q = childAt.getLeft();
                    this.f153858r = childAt.getTop();
                    return pointToPosition;
                }
            }
        }
        return -1;
    }

    public DragSortController(DragSortListView dragSortListView, int i3, int i16, int i17) {
        this(dragSortListView, i3, i16, i17, 0);
    }

    public DragSortController(DragSortListView dragSortListView, int i3, int i16, int i17, int i18) {
        this(dragSortListView, i3, i16, i17, i18, 0);
    }

    public DragSortController(DragSortListView dragSortListView, int i3, int i16, int i17, int i18, int i19) {
        super(dragSortListView);
        this.f153845e = 0;
        this.f153846f = true;
        this.f153848h = false;
        this.f153849i = false;
        this.f153853m = -1;
        this.f153854n = -1;
        this.f153855o = -1;
        this.f153856p = new int[2];
        this.f153861u = false;
        this.f153862v = 500.0f;
        this.C = new GestureDetector.SimpleOnGestureListener() { // from class: com.tencent.mm.ui.widget.sortlist.DragSortController.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                if (DragSortController.this.f153848h && DragSortController.this.f153849i) {
                    int width = DragSortController.this.A.getWidth() / 5;
                    if (f16 > DragSortController.this.f153862v) {
                        if (DragSortController.this.B > (-width)) {
                            DragSortController.this.A.stopDragWithVelocity(true, f16);
                        }
                    } else if (f16 < (-DragSortController.this.f153862v) && DragSortController.this.B < width) {
                        DragSortController.this.A.stopDragWithVelocity(true, f16);
                    }
                    DragSortController.this.f153849i = false;
                }
                return false;
            }
        };
        this.A = dragSortListView;
        this.f153850j = new GestureDetector(dragSortListView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(dragSortListView.getContext(), this.C);
        this.f153851k = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f153852l = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.f153863w = i3;
        this.f153864x = i18;
        this.f153865y = i19;
        setRemoveMode(i17);
        setDragInitMode(i16);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
