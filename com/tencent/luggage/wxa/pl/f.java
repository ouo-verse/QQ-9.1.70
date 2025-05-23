package com.tencent.luggage.wxa.pl;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
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
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.mobileqq.R;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f {
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public Context f137664a;

    /* renamed from: b, reason: collision with root package name */
    public PopupWindow f137665b;

    /* renamed from: c, reason: collision with root package name */
    public ListAdapter f137666c;

    /* renamed from: d, reason: collision with root package name */
    public c f137667d;

    /* renamed from: g, reason: collision with root package name */
    public int f137670g;

    /* renamed from: h, reason: collision with root package name */
    public int f137671h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f137672i;

    /* renamed from: m, reason: collision with root package name */
    public View f137676m;

    /* renamed from: o, reason: collision with root package name */
    public DataSetObserver f137678o;

    /* renamed from: p, reason: collision with root package name */
    public View f137679p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f137680q;

    /* renamed from: r, reason: collision with root package name */
    public AdapterView.OnItemClickListener f137681r;

    /* renamed from: s, reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f137682s;

    /* renamed from: t, reason: collision with root package name */
    public final h f137683t;

    /* renamed from: u, reason: collision with root package name */
    public final g f137684u;

    /* renamed from: v, reason: collision with root package name */
    public final C6610f f137685v;

    /* renamed from: w, reason: collision with root package name */
    public final d f137686w;

    /* renamed from: x, reason: collision with root package name */
    public Runnable f137687x;

    /* renamed from: e, reason: collision with root package name */
    public int f137668e = -2;

    /* renamed from: f, reason: collision with root package name */
    public int f137669f = -2;

    /* renamed from: j, reason: collision with root package name */
    public boolean f137673j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f137674k = false;

    /* renamed from: l, reason: collision with root package name */
    public int f137675l = Integer.MAX_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public int f137677n = 0;

    /* renamed from: y, reason: collision with root package name */
    public b0 f137688y = new b0();

    /* renamed from: z, reason: collision with root package name */
    public Rect f137689z = new Rect();
    public boolean B = false;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View d16 = f.this.d();
            if (d16 != null && d16.getWindowToken() != null) {
                f.this.k();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public boolean f137692a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f137693b;

        public c(Context context, boolean z16) {
            super(context, null, R.attr.f155566ad0);
            this.f137693b = z16;
            setCacheColorHint(0);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            if (!this.f137693b && !super.hasFocus()) {
                return false;
            }
            return true;
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            if (!this.f137693b && !super.hasWindowFocus()) {
                return false;
            }
            return true;
        }

        @Override // android.view.View
        public boolean isFocused() {
            if (!this.f137693b && !super.isFocused()) {
                return false;
            }
            return true;
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            if ((this.f137693b && this.f137692a) || super.isInTouchMode()) {
                return true;
            }
            return false;
        }

        public final int a(int i3, int i16, int i17, int i18, int i19) {
            int makeMeasureSpec;
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            getListPaddingLeft();
            getListPaddingRight();
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
                int i36 = view.getLayoutParams().height;
                if (i36 > 0) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i36, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i3, makeMeasureSpec);
                if (i27 > 0) {
                    i26 += dividerHeight;
                }
                i26 += view.getMeasuredHeight();
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
            f.this.b();
        }

        public /* synthetic */ d(f fVar, a aVar) {
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
            if (f.this.i()) {
                f.this.k();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f.this.c();
        }

        public /* synthetic */ e(f fVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.pl.f$f, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6610f implements AbsListView.OnScrollListener {
        public C6610f() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            if (f.this.f137667d != null && f.this.f137676m != null && f.this.f137666c != null && f.this.f137667d != null) {
                if (f.this.f137667d.getLastVisiblePosition() == f.this.f137666c.getCount() - 1 && f.this.f137667d.getChildAt(f.this.f137667d.getChildCount() - 1) != null && f.this.f137667d.getChildAt(f.this.f137667d.getChildCount() - 1).getBottom() <= f.this.f137667d.getHeight()) {
                    f.this.f137676m.setVisibility(8);
                } else {
                    f.this.f137676m.setVisibility(0);
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 == 1 && !f.this.h() && f.this.f137665b.getContentView() != null) {
                f.this.f137688y.b(f.this.f137683t);
                f.this.f137683t.run();
            }
        }

        public /* synthetic */ C6610f(f fVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class g implements View.OnTouchListener {
        public g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (action == 0 && f.this.f137665b != null && f.this.f137665b.isShowing() && x16 >= 0 && x16 < f.this.f137665b.getWidth() && y16 >= 0 && y16 < f.this.f137665b.getHeight()) {
                f.this.f137688y.a(f.this.f137683t, 250L);
                return false;
            }
            if (action == 1) {
                f.this.f137688y.b(f.this.f137683t);
                return false;
            }
            return false;
        }

        public /* synthetic */ g(f fVar, a aVar) {
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
            if (f.this.f137667d != null && f.this.f137667d.getCount() > f.this.f137667d.getChildCount()) {
                int childCount = f.this.f137667d.getChildCount();
                f fVar = f.this;
                if (childCount <= fVar.f137675l) {
                    fVar.f137665b.setInputMethodMode(2);
                    f.this.k();
                }
            }
        }

        public /* synthetic */ h(f fVar, a aVar) {
            this();
        }
    }

    public f(Context context, AttributeSet attributeSet, int i3) {
        a aVar = null;
        this.f137683t = new h(this, aVar);
        this.f137684u = new g(this, aVar);
        this.f137685v = new C6610f(this, aVar);
        this.f137686w = new d(this, aVar);
        this.f137664a = context;
        PopupWindow popupWindow = new PopupWindow(context);
        this.f137665b = popupWindow;
        popupWindow.setInputMethodMode(1);
        Locale locale = this.f137664a.getResources().getConfiguration().locale;
    }

    public int g() {
        return this.f137669f;
    }

    public boolean h() {
        if (this.f137665b.getInputMethodMode() == 2) {
            return true;
        }
        return false;
    }

    public boolean i() {
        return this.f137665b.isShowing();
    }

    public final void j() {
        View view = this.f137676m;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f137676m);
            }
        }
    }

    public void k() {
        int i3;
        int i16;
        int i17;
        int a16 = a();
        boolean h16 = h();
        boolean z16 = true;
        int i18 = -1;
        if (this.f137665b.isShowing()) {
            int i19 = this.f137669f;
            if (i19 == -1) {
                i19 = -1;
            } else if (i19 == -2) {
                i19 = d().getWidth();
            }
            int i26 = this.f137668e;
            if (i26 == -1) {
                if (!h16) {
                    a16 = -1;
                }
                if (h16) {
                    PopupWindow popupWindow = this.f137665b;
                    if (this.f137669f != -1) {
                        i18 = 0;
                    }
                    popupWindow.setWindowLayoutMode(i18, 0);
                } else {
                    PopupWindow popupWindow2 = this.f137665b;
                    if (this.f137669f == -1) {
                        i17 = -1;
                    } else {
                        i17 = 0;
                    }
                    popupWindow2.setWindowLayoutMode(i17, -1);
                }
            } else if (i26 != -2) {
                a16 = i26;
            }
            this.f137665b.update(i19, a16);
            PopupWindow popupWindow3 = this.f137665b;
            if (this.f137674k || this.f137673j) {
                z16 = false;
            }
            popupWindow3.setOutsideTouchable(z16);
            if (this.B) {
                this.f137665b.showAtLocation(d(), 17, 0, 0);
                return;
            } else {
                this.f137665b.update(d(), this.f137670g, this.f137671h, this.f137665b.getWidth(), this.f137665b.getHeight());
                return;
            }
        }
        int i27 = this.f137669f;
        if (i27 == -1) {
            i3 = -1;
        } else {
            if (i27 == -2) {
                this.f137665b.setWidth(d().getWidth());
            } else {
                this.f137665b.setWidth(i27);
            }
            i3 = 0;
        }
        int i28 = this.f137668e;
        if (i28 == -1) {
            i16 = -1;
        } else {
            if (i28 == -2) {
                this.f137665b.setHeight(a16);
            } else {
                this.f137665b.setHeight(i28);
            }
            i16 = 0;
        }
        this.f137665b.setWindowLayoutMode(i3, i16);
        PopupWindow popupWindow4 = this.f137665b;
        if (this.f137674k || this.f137673j) {
            z16 = false;
        }
        popupWindow4.setOutsideTouchable(z16);
        this.f137665b.setTouchInterceptor(this.f137684u);
        if (this.B) {
            this.f137665b.showAtLocation(d(), 17, 0, 0);
        } else {
            this.f137665b.showAsDropDown(d(), this.f137670g, this.f137671h, 53);
        }
        this.f137667d.setSelection(-1);
        if (!this.A || this.f137667d.isInTouchMode()) {
            b();
        }
        if (!this.A) {
            this.f137688y.a((Runnable) this.f137686w);
        }
    }

    public void a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f137678o;
        if (dataSetObserver == null) {
            this.f137678o = new e(this, null);
        } else {
            ListAdapter listAdapter2 = this.f137666c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f137666c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f137678o);
        }
        c cVar = this.f137667d;
        if (cVar != null) {
            cVar.setAdapter(this.f137666c);
        }
    }

    public void b(boolean z16) {
        this.f137674k = z16;
    }

    public void c(boolean z16) {
        this.A = true;
        this.f137665b.setFocusable(z16);
    }

    public View d() {
        return this.f137679p;
    }

    public void e(int i3) {
        this.f137671h = i3;
        this.f137672i = true;
    }

    public int f() {
        if (this.f137672i) {
            return this.f137671h;
        }
        return 0;
    }

    public void b(int i3) {
        this.f137668e = i3;
    }

    public void d(int i3) {
        this.f137665b.setInputMethodMode(i3);
    }

    public void b() {
        c cVar = this.f137667d;
        if (cVar != null) {
            cVar.f137692a = true;
            cVar.requestLayout();
        }
    }

    public void c(int i3) {
        this.f137670g = i3;
    }

    public ListView e() {
        return this.f137667d;
    }

    public void f(int i3) {
        this.f137669f = i3;
    }

    public void c() {
        this.f137665b.dismiss();
        j();
        this.f137665b.setContentView(null);
        this.f137667d = null;
        this.f137688y.b(this.f137683t);
    }

    public void a(boolean z16) {
        this.f137673j = z16;
    }

    public void a(Drawable drawable) {
        this.f137665b.setBackgroundDrawable(drawable);
    }

    public void a(int i3) {
        this.f137665b.setAnimationStyle(i3);
    }

    public void a(View view) {
        this.f137679p = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f137665b.setOnDismissListener(onDismissListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a() {
        int measuredHeight;
        Drawable background;
        int i3;
        int a16;
        int makeMeasureSpec;
        if (this.f137667d == null) {
            Context context = this.f137664a;
            this.f137687x = new a();
            c cVar = new c(context, !this.A);
            this.f137667d = cVar;
            Drawable drawable = this.f137680q;
            if (drawable != null) {
                cVar.setSelector(drawable);
            }
            this.f137667d.setAdapter(this.f137666c);
            this.f137667d.setOnItemClickListener(this.f137681r);
            this.f137667d.setFocusable(true);
            this.f137667d.setFocusableInTouchMode(true);
            this.f137667d.setDivider(null);
            this.f137667d.setDividerHeight(0);
            this.f137667d.setOnItemSelectedListener(new b());
            this.f137667d.setOnScrollListener(this.f137685v);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f137682s;
            if (onItemSelectedListener != null) {
                this.f137667d.setOnItemSelectedListener(onItemSelectedListener);
            }
            View view = this.f137667d;
            View view2 = this.f137676m;
            if (view2 != null) {
                j();
                ViewGroup frameLayout = new FrameLayout(context);
                ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                int i16 = this.f137677n;
                if (i16 == 0) {
                    layoutParams2.gravity = 48;
                    frameLayout.addView(view, layoutParams);
                    frameLayout.addView(view2, layoutParams2);
                } else if (i16 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f137677n);
                } else {
                    layoutParams2.gravity = 80;
                    frameLayout.addView(view, layoutParams);
                    frameLayout.addView(view2, layoutParams2);
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(this.f137669f, Integer.MIN_VALUE), 0);
                view = frameLayout;
            }
            this.f137665b.setContentView(view);
        } else {
            View view3 = this.f137676m;
            if (view3 != null) {
                measuredHeight = view3.getMeasuredHeight();
                background = this.f137665b.getBackground();
                if (background == null) {
                    background.getPadding(this.f137689z);
                    Rect rect = this.f137689z;
                    int i17 = rect.top;
                    i3 = rect.bottom + i17;
                    if (!this.f137672i) {
                        this.f137671h = -i17;
                    }
                } else {
                    this.f137689z.setEmpty();
                    i3 = 0;
                }
                a16 = a(d(), this.f137671h, this.f137665b.getInputMethodMode() == 2);
                if (!this.f137673j || this.f137668e == -1) {
                    return a16 + i3;
                }
                int i18 = this.f137669f;
                if (i18 == -2) {
                    int i19 = this.f137664a.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.f137689z;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i19 - (rect2.left + rect2.right), Integer.MIN_VALUE);
                } else if (i18 != -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                } else {
                    int i26 = this.f137664a.getResources().getDisplayMetrics().widthPixels;
                    Rect rect3 = this.f137689z;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i26 - (rect3.left + rect3.right), 1073741824);
                }
                int a17 = this.f137667d.a(makeMeasureSpec, 0, -1, a16 - measuredHeight, -1);
                if (a17 > 0) {
                    measuredHeight += i3;
                }
                return a17 + measuredHeight;
            }
        }
        measuredHeight = 0;
        background = this.f137665b.getBackground();
        if (background == null) {
        }
        a16 = a(d(), this.f137671h, this.f137665b.getInputMethodMode() == 2);
        if (this.f137673j) {
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
            if (i3 != -1 && (cVar = f.this.f137667d) != null) {
                cVar.f137692a = false;
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
            i16 = view.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int i17 = i16 - i3;
        if (this.f137665b.getBackground() == null) {
            return i17;
        }
        this.f137665b.getBackground().getPadding(this.f137689z);
        Rect rect2 = this.f137689z;
        return i17 - (rect2.top + rect2.bottom);
    }
}
