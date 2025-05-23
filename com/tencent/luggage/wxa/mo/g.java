package com.tencent.luggage.wxa.mo;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public final h f134791a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewOnTouchListenerC6486g f134792b;

    /* renamed from: c, reason: collision with root package name */
    public final f f134793c;

    /* renamed from: d, reason: collision with root package name */
    public final d f134794d;

    /* renamed from: f, reason: collision with root package name */
    public Context f134796f;

    /* renamed from: g, reason: collision with root package name */
    public x f134797g;

    /* renamed from: h, reason: collision with root package name */
    public ListAdapter f134798h;

    /* renamed from: i, reason: collision with root package name */
    public c f134799i;

    /* renamed from: l, reason: collision with root package name */
    public int f134802l;

    /* renamed from: m, reason: collision with root package name */
    public int f134803m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f134804n;

    /* renamed from: q, reason: collision with root package name */
    public View f134807q;

    /* renamed from: s, reason: collision with root package name */
    public DataSetObserver f134809s;

    /* renamed from: t, reason: collision with root package name */
    public View f134810t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f134811u;

    /* renamed from: v, reason: collision with root package name */
    public AdapterView.OnItemClickListener f134812v;

    /* renamed from: w, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f134813w;

    /* renamed from: x, reason: collision with root package name */
    public Runnable f134814x;

    /* renamed from: e, reason: collision with root package name */
    public int f134795e = Integer.MAX_VALUE;

    /* renamed from: j, reason: collision with root package name */
    public int f134800j = -2;

    /* renamed from: k, reason: collision with root package name */
    public int f134801k = -2;

    /* renamed from: o, reason: collision with root package name */
    public boolean f134805o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f134806p = false;

    /* renamed from: r, reason: collision with root package name */
    public int f134808r = 0;

    /* renamed from: y, reason: collision with root package name */
    public Handler f134815y = new Handler();

    /* renamed from: z, reason: collision with root package name */
    public Rect f134816z = new Rect();
    public boolean B = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View d16 = g.this.d();
            if (d16 != null && d16.getWindowToken() != null) {
                g.this.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public boolean f134819a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f134820b;

        public /* synthetic */ c(Context context, boolean z16, a aVar) {
            this(context, z16);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            if (!this.f134820b && !super.hasFocus()) {
                return false;
            }
            return true;
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            if (!this.f134820b && !super.hasWindowFocus()) {
                return false;
            }
            return true;
        }

        @Override // android.view.View
        public boolean isFocused() {
            if (!this.f134820b && !super.isFocused()) {
                return false;
            }
            return true;
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            if ((this.f134820b && this.f134819a) || super.isInTouchMode()) {
                return true;
            }
            return false;
        }

        public c(Context context, boolean z16) {
            super(context, null, R.attr.f155566ad0);
            this.f134820b = z16;
            setCacheColorHint(0);
        }

        public final int a(int i3, int i16, int i17, int i18, int i19) {
            int makeMeasureSpec;
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            int i26 = listPaddingTop + listPaddingBottom;
            if (adapter == null) {
                return i26;
            }
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            View view = null;
            while (i27 < count) {
                int itemViewType = adapter.getItemViewType(i27);
                if (itemViewType != i28) {
                    view = null;
                    i28 = itemViewType;
                }
                view = adapter.getView(i27, view, this);
                int i36 = view == null ? 0 : view.getLayoutParams().height;
                if (i36 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i36, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                if (view != null) {
                    view.measure(i3, makeMeasureSpec);
                }
                if (i27 > 0) {
                    i26 += dividerHeight;
                }
                if (view != null) {
                    i26 += view.getMeasuredHeight();
                }
                if (i26 >= i18) {
                    return (i19 < 0 || i27 <= i19 || i29 <= 0 || i26 == i18) ? i18 : i29;
                }
                if (i19 >= 0 && i27 >= i19) {
                    i29 = i26;
                }
                i27++;
            }
            return i26;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.b();
        }

        public /* synthetic */ d(g gVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (g.this.g()) {
                g.this.i();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            g.this.c();
        }

        public /* synthetic */ e(g gVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class f implements AbsListView.OnScrollListener {
        public f() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (g.this.f134799i != null && g.this.f134807q != null && g.this.f134798h != null && g.this.f134799i != null) {
                if (g.this.f134799i.getLastVisiblePosition() == g.this.f134798h.getCount() - 1 && g.this.f134799i.getChildAt(g.this.f134799i.getChildCount() - 1) != null && g.this.f134799i.getChildAt(g.this.f134799i.getChildCount() - 1).getBottom() <= g.this.f134799i.getHeight()) {
                    g.this.f134807q.setVisibility(8);
                } else {
                    g.this.f134807q.setVisibility(0);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 1 && !g.this.f() && g.this.f134797g.getContentView() != null) {
                g.this.f134815y.removeCallbacks(g.this.f134791a);
                g.this.f134791a.run();
            }
        }

        public /* synthetic */ f(g gVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mo.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class ViewOnTouchListenerC6486g implements View.OnTouchListener {
        public ViewOnTouchListenerC6486g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (action == 0 && g.this.f134797g != null && g.this.f134797g.isShowing() && x16 >= 0 && x16 < g.this.f134797g.getWidth() && y16 >= 0 && y16 < g.this.f134797g.getHeight()) {
                g.this.f134815y.postDelayed(g.this.f134791a, 250L);
                return false;
            }
            if (action == 1) {
                g.this.f134815y.removeCallbacks(g.this.f134791a);
                return false;
            }
            return false;
        }

        public /* synthetic */ ViewOnTouchListenerC6486g(g gVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f134799i != null && g.this.f134799i.getCount() > g.this.f134799i.getChildCount()) {
                int childCount = g.this.f134799i.getChildCount();
                g gVar = g.this;
                if (childCount <= gVar.f134795e) {
                    gVar.f134797g.setInputMethodMode(2);
                    g.this.i();
                }
            }
        }

        public /* synthetic */ h(g gVar, a aVar) {
            this();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i3) {
        a aVar = null;
        this.f134791a = new h(this, aVar);
        this.f134792b = new ViewOnTouchListenerC6486g(this, aVar);
        this.f134793c = new f(this, aVar);
        this.f134794d = new d(this, aVar);
        this.f134796f = context;
        x xVar = new x(context);
        this.f134797g = xVar;
        xVar.setInputMethodMode(1);
    }

    public void g(int i3) {
        this.f134801k = i3;
    }

    public final void h() {
        View view = this.f134807q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f134807q);
            }
        }
    }

    public void i() {
        int i3;
        int i16;
        int i17;
        int a16 = a();
        boolean f16 = f();
        boolean z16 = true;
        int i18 = -1;
        if (this.f134797g.isShowing()) {
            int i19 = this.f134801k;
            if (i19 == -1) {
                i19 = -1;
            } else if (i19 == -2) {
                i19 = d().getWidth();
            }
            int i26 = this.f134800j;
            if (i26 == -1) {
                if (!f16) {
                    a16 = -1;
                }
                if (f16) {
                    x xVar = this.f134797g;
                    if (this.f134801k != -1) {
                        i18 = 0;
                    }
                    xVar.setWindowLayoutMode(i18, 0);
                } else {
                    x xVar2 = this.f134797g;
                    if (this.f134801k == -1) {
                        i17 = -1;
                    } else {
                        i17 = 0;
                    }
                    xVar2.setWindowLayoutMode(i17, -1);
                }
            } else if (i26 != -2) {
                a16 = i26;
            }
            this.f134797g.update(i19, a16);
            x xVar3 = this.f134797g;
            if (this.f134806p || this.f134805o) {
                z16 = false;
            }
            xVar3.setOutsideTouchable(z16);
            if (this.B) {
                this.f134797g.showAtLocation(d(), 17, 0, 0);
                return;
            } else {
                this.f134797g.showAtLocation(d(), 53, this.f134802l, this.f134803m);
                return;
            }
        }
        int i27 = this.f134801k;
        if (i27 == -1) {
            i3 = -1;
        } else {
            if (i27 == -2) {
                this.f134797g.setWidth(d().getWidth());
            } else {
                this.f134797g.setWidth(i27);
            }
            i3 = 0;
        }
        int i28 = this.f134800j;
        if (i28 == -1) {
            i16 = -1;
        } else {
            if (i28 == -2) {
                this.f134797g.setHeight(a16);
            } else {
                this.f134797g.setHeight(i28);
            }
            i16 = 0;
        }
        this.f134797g.setWindowLayoutMode(i3, i16);
        x xVar4 = this.f134797g;
        if (this.f134806p || this.f134805o) {
            z16 = false;
        }
        xVar4.setOutsideTouchable(z16);
        this.f134797g.setTouchInterceptor(this.f134792b);
        if (this.B) {
            this.f134797g.showAtLocation(d(), 17, 0, 0);
        } else {
            this.f134797g.showAtLocation(d(), 53, this.f134802l, this.f134803m);
        }
        this.f134799i.setSelection(-1);
        if (!this.A || this.f134799i.isInTouchMode()) {
            b();
        }
        if (!this.A) {
            this.f134815y.post(this.f134794d);
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f134809s;
        if (dataSetObserver == null) {
            this.f134809s = new e(this, null);
        } else {
            ListAdapter listAdapter2 = this.f134798h;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f134798h = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f134809s);
        }
        c cVar = this.f134799i;
        if (cVar != null) {
            cVar.setAdapter(this.f134798h);
        }
    }

    public void b(boolean z16) {
        this.A = z16;
        this.f134797g.setFocusable(z16);
    }

    public void c(int i3) {
        this.f134800j = i3;
    }

    public View d() {
        return this.f134810t;
    }

    public void e(int i3) {
        this.f134797g.setInputMethodMode(i3);
    }

    public void f(int i3) {
        this.f134803m = i3;
        this.f134804n = true;
    }

    public boolean g() {
        return this.f134797g.isShowing();
    }

    public void c() {
        this.f134797g.dismiss();
        h();
        this.f134797g.setContentView(null);
        this.f134799i = null;
        this.f134815y.removeCallbacks(this.f134791a);
    }

    public void d(int i3) {
        this.f134802l = i3;
    }

    public ListView e() {
        return this.f134799i;
    }

    public void b(int i3) {
        Drawable background = this.f134797g.getBackground();
        if (background != null) {
            background.getPadding(this.f134816z);
            Rect rect = this.f134816z;
            this.f134801k = rect.left + rect.right + i3;
            return;
        }
        g(i3);
    }

    public boolean f() {
        return this.f134797g.getInputMethodMode() == 2;
    }

    public void b() {
        c cVar = this.f134799i;
        if (cVar != null) {
            cVar.f134819a = true;
            cVar.requestLayout();
        }
    }

    public void a(boolean z16) {
        this.f134806p = z16;
    }

    public void a(Drawable drawable) {
        this.f134797g.setBackgroundDrawable(drawable);
    }

    public void a(int i3) {
        this.f134797g.setAnimationStyle(i3);
    }

    public void a(View view) {
        this.f134810t = view;
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f134812v = onItemClickListener;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f134797g.setOnDismissListener(onDismissListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a() {
        int measuredHeight;
        Drawable background;
        int i3;
        int a16;
        int makeMeasureSpec;
        if (this.f134799i == null) {
            Context context = this.f134796f;
            this.f134814x = new a();
            c cVar = new c(context, !this.A, null);
            this.f134799i = cVar;
            Drawable drawable = this.f134811u;
            if (drawable != null) {
                cVar.setSelector(drawable);
            }
            this.f134799i.setAdapter(this.f134798h);
            this.f134799i.setOnItemClickListener(this.f134812v);
            this.f134799i.setFocusable(true);
            this.f134799i.setFocusableInTouchMode(true);
            this.f134799i.setDivider(null);
            this.f134799i.setDividerHeight(0);
            this.f134799i.setOnItemSelectedListener(new b());
            this.f134799i.setOnScrollListener(this.f134793c);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f134813w;
            if (onItemSelectedListener != null) {
                this.f134799i.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f134799i;
            View view2 = this.f134807q;
            if (view2 != null) {
                h();
                ViewGroup frameLayout = new FrameLayout(context);
                ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                int i16 = this.f134808r;
                if (i16 == 0) {
                    layoutParams2.gravity = 48;
                    frameLayout.addView(view, layoutParams);
                    frameLayout.addView(view2, layoutParams2);
                } else if (i16 != 1) {
                    com.tencent.luggage.wxa.lo.n.b("ListPopupWindow", "Invalid hint position " + this.f134808r, new Object[0]);
                } else {
                    layoutParams2.gravity = 80;
                    frameLayout.addView(view, layoutParams);
                    frameLayout.addView(view2, layoutParams2);
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(this.f134801k, Integer.MIN_VALUE), 0);
                view = frameLayout;
            }
            this.f134797g.setContentView(view);
        } else {
            View view3 = this.f134807q;
            if (view3 != null) {
                measuredHeight = view3.getMeasuredHeight();
                background = this.f134797g.getBackground();
                if (background == null) {
                    background.getPadding(this.f134816z);
                    Rect rect = this.f134816z;
                    int i17 = rect.top;
                    i3 = rect.bottom + i17;
                    if (!this.f134804n) {
                        this.f134803m = -i17;
                    }
                } else {
                    this.f134816z.setEmpty();
                    i3 = 0;
                }
                a16 = a(d(), this.f134803m, this.f134797g.getInputMethodMode() == 2);
                if (!this.f134805o || this.f134800j == -1) {
                    return a16 + i3;
                }
                int i18 = this.f134801k;
                if (i18 == -2) {
                    int i19 = this.f134796f.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.f134816z;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - (rect2.left + rect2.right), Integer.MIN_VALUE);
                } else if (i18 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                } else {
                    int i26 = this.f134796f.getResources().getDisplayMetrics().widthPixels;
                    Rect rect3 = this.f134816z;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i26 - (rect3.left + rect3.right), 1073741824);
                }
                int a17 = this.f134799i.a(makeMeasureSpec, 0, -1, a16 - measuredHeight, -1);
                if (a17 > 0) {
                    measuredHeight += i3;
                }
                return a17 + measuredHeight;
            }
        }
        measuredHeight = 0;
        background = this.f134797g.getBackground();
        if (background == null) {
        }
        a16 = a(d(), this.f134803m, this.f134797g.getInputMethodMode() == 2);
        if (this.f134805o) {
        }
        return a16 + i3;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i3, long j3) {
            c cVar;
            if (i3 != -1 && (cVar = g.this.f134799i) != null) {
                cVar.f134819a = false;
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public int a(View view, int i3, boolean z16) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        view.getLocationOnScreen(new int[2]);
        int i16 = rect.bottom;
        if (z16) {
            view.getContext().getResources();
            Point a16 = com.tencent.luggage.wxa.lo.r.a(view.getContext());
            if (a16 != null) {
                i16 = a16.y;
            }
        }
        int i17 = i16 - i3;
        if (this.f134797g.getBackground() == null) {
            return i17;
        }
        this.f134797g.getBackground().getPadding(this.f134816z);
        Rect rect2 = this.f134816z;
        return i17 - (rect2.top + rect2.bottom);
    }
}
