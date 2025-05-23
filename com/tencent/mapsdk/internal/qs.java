package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.ew;
import com.tencent.mapsdk.internal.qt;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qs extends eu implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, qt.a {

    /* renamed from: k, reason: collision with root package name */
    private static final String f149899k = "VIEW_TAG_HEADER";

    /* renamed from: l, reason: collision with root package name */
    private static final String f149900l = "VIEW_TAG_FOOTER";

    /* renamed from: m, reason: collision with root package name */
    private static final float f149901m = 2.7f;

    /* renamed from: n, reason: collision with root package name */
    private static final float f149902n = 44.0f;

    /* renamed from: o, reason: collision with root package name */
    private static final float f149903o = 13.0f;

    /* renamed from: p, reason: collision with root package name */
    private static final float f149904p = 26.0f;

    /* renamed from: q, reason: collision with root package name */
    private static final float f149905q = 9.5f;

    /* renamed from: r, reason: collision with root package name */
    private static final float f149906r = 37.0f;

    /* renamed from: s, reason: collision with root package name */
    private static final float f149907s = 4.0f;

    /* renamed from: t, reason: collision with root package name */
    private static final float f149908t = 45.0f;

    /* renamed from: u, reason: collision with root package name */
    private static final float f149909u = 15.0f;

    /* renamed from: w, reason: collision with root package name */
    private static final int f149910w = -1;

    /* renamed from: y, reason: collision with root package name */
    private static final int f149912y = -1;
    private a A;
    private final Context B;
    private IndoorBuilding E;
    private String F;
    private boolean H;
    private qo I;
    private qo J;

    /* renamed from: a, reason: collision with root package name */
    public qq f149914a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f149915b;

    /* renamed from: d, reason: collision with root package name */
    public ac f149917d;

    /* renamed from: e, reason: collision with root package name */
    public final tr f149918e;

    /* renamed from: f, reason: collision with root package name */
    public int f149919f;

    /* renamed from: g, reason: collision with root package name */
    public int f149920g;

    /* renamed from: h, reason: collision with root package name */
    private qt f149921h;

    /* renamed from: i, reason: collision with root package name */
    private qp f149922i;

    /* renamed from: x, reason: collision with root package name */
    private static final int f149911x = Color.parseColor("#333333");

    /* renamed from: z, reason: collision with root package name */
    private static final int f149913z = Color.parseColor("#979797");

    /* renamed from: j, reason: collision with root package name */
    private float f149923j = 1.0f;

    /* renamed from: v, reason: collision with root package name */
    private int f149924v = 0;
    private int C = -1;
    private int D = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f149916c = false;
    private boolean G = false;
    private a.C7041a K = null;

    /* compiled from: P */
    /* renamed from: com.tencent.mapsdk.internal.qs$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) qs.this.f149914a.getLayoutParams();
            marginLayoutParams.bottomMargin = qs.this.f149919f;
            qs.this.f149914a.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends BaseAdapter {

        /* renamed from: b, reason: collision with root package name */
        private Context f149929b;

        /* renamed from: c, reason: collision with root package name */
        private List<IndoorLevel> f149930c;

        /* compiled from: P */
        /* renamed from: com.tencent.mapsdk.internal.qs$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C7041a {

            /* renamed from: a, reason: collision with root package name */
            public TextView f149931a;

            /* renamed from: b, reason: collision with root package name */
            public View f149932b;

            public C7041a(TextView textView, View view) {
                this.f149931a = textView;
                this.f149932b = view;
            }
        }

        public a(Context context, List<IndoorLevel> list) {
            this.f149929b = context;
            this.f149930c = list;
        }

        public final void a(List<IndoorLevel> list) {
            this.f149930c = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            List<IndoorLevel> list = this.f149930c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i3) {
            List<IndoorLevel> list = this.f149930c;
            if (list == null) {
                return null;
            }
            return list.get(i3);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        @NonNull
        public final View getView(int i3, @Nullable View view, @NonNull ViewGroup viewGroup) {
            View view2;
            TextView textView;
            View view3;
            List<IndoorLevel> list = this.f149930c;
            if (list != null && list.size() != 0) {
                if (view != null) {
                    C7041a c7041a = (C7041a) view.getTag();
                    TextView textView2 = c7041a.f149931a;
                    view3 = c7041a.f149932b;
                    textView = textView2;
                    view2 = view;
                } else {
                    FrameLayout frameLayout = new FrameLayout(this.f149929b);
                    View view4 = new View(this.f149929b);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (qs.this.f149923j * 26.5d), (int) (qs.this.f149923j * 26.5d));
                    if (qs.this.f149922i == null) {
                        qs.this.f149922i = new qp();
                        qs.this.f149922i.setBounds(0, 0, layoutParams.width, layoutParams.height);
                    }
                    view4.setBackground(qs.this.f149922i);
                    layoutParams.gravity = 17;
                    frameLayout.addView(view4, layoutParams);
                    textView = new TextView(this.f149929b);
                    textView.setIncludeFontPadding(false);
                    textView.setSingleLine();
                    textView.setGravity(17);
                    textView.setTextSize(2, qs.f149903o);
                    int i16 = (int) (qs.this.f149923j * 10.0d);
                    textView.setPadding(0, i16, 0, i16);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, (int) (qs.this.f149923j * 37.5f));
                    layoutParams2.gravity = 17;
                    frameLayout.addView(textView, layoutParams2);
                    frameLayout.setTag(new C7041a(textView, view4));
                    view2 = frameLayout;
                    view3 = view4;
                }
                textView.setText(this.f149930c.get(i3).getName());
                if (i3 == qs.this.C) {
                    boolean unused = qs.this.H;
                    textView.setTextColor(-1);
                    view3.setVisibility(0);
                } else {
                    textView.setTextColor(qs.this.H ? qs.f149913z : qs.f149911x);
                    view3.setVisibility(4);
                }
            } else {
                view2 = null;
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public qs(bf bfVar) {
        this.f149915b = false;
        this.f149918e = (tr) bfVar.b();
        this.H = bfVar.m();
        this.B = bfVar.getContext().getApplicationContext();
        this.f149915b = true;
    }

    private boolean j() {
        return this.f149915b;
    }

    private void k() {
        boolean m3 = this.f149918e.aC.m();
        LogUtil.b(ky.f149101g, "updateIndoorStyle isDark: cur[" + m3 + "]|old[" + this.H + "]");
        if (m3 != this.H) {
            this.f149914a.setDarkStyle(m3);
            this.I.setDarkStyle(m3);
            this.J.setDarkStyle(m3);
            this.A.notifyDataSetChanged();
            this.H = m3;
        }
    }

    private void l() {
        IndoorBuilding indoorBuilding = this.E;
        if (indoorBuilding == null) {
            return;
        }
        int activeLevelIndex = indoorBuilding.getActiveLevelIndex();
        List<IndoorLevel> levels = this.E.getLevels();
        if (levels == null || activeLevelIndex >= levels.size() || activeLevelIndex == -1 || levels.get(activeLevelIndex) == null) {
            return;
        }
        String str = this.F;
        if (str != null && this.f149916c && str.equals(this.E.getBuidlingId())) {
            this.f149921h.setItemChecked(activeLevelIndex, true);
            this.f149916c = false;
        } else {
            this.f149921h.setSelectionFromTop(activeLevelIndex, ((int) ((this.f149923j * f149906r) + 0.5d)) * 2);
        }
        this.C = activeLevelIndex;
        this.F = this.E.getBuidlingId();
    }

    private void m() {
        qt qtVar = this.f149921h;
        if (qtVar != null) {
            qtVar.getLayoutParams().width = a(this.A);
            this.f149921h.requestLayout();
        }
    }

    private void n() {
        ViewGroup ab5 = this.f149918e.ab();
        if (ab5 != null && this.f149914a != null) {
            int i3 = (this.f149919f * 2) + ((int) (this.f149923j * 16.700000762939453d));
            if (tf.f150436c.equals("wechat") && ab5.getMeasuredHeight() > this.f149920g) {
                int measuredHeight = ab5.getMeasuredHeight() - this.f149920g;
                int i16 = this.f149919f;
                i3 = ((int) (this.f149923j * 16.700000762939453d)) + i16 + (measuredHeight - i16);
            }
            if (this.D >= 4.0f) {
                this.f149924v = (int) (this.f149923j * 148.5d);
                if (ab5.getMeasuredHeight() > this.f149924v + i3) {
                    this.G = false;
                    return;
                }
                this.f149924v = (int) (this.f149923j * 111.5d);
                if (ab5.getMeasuredHeight() > i3 + this.f149924v) {
                    this.G = false;
                    return;
                }
            } else {
                this.f149924v = (int) (((r2 * f149906r) + 0.5d) * this.f149923j);
                if (ab5.getMeasuredHeight() > i3 + this.f149924v) {
                    this.G = false;
                    return;
                }
            }
            this.G = true;
        }
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void a(ew.b bVar) {
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final void c() {
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final ew.b d() {
        return null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        M m3 = this.f149918e.e_;
        if (m3 != 0) {
            a.C7041a c7041a = this.K;
            if (c7041a != null) {
                c7041a.f149931a.setTextColor(-16777216);
                this.K.f149932b.setVisibility(4);
            }
            a.C7041a c7041a2 = (a.C7041a) view.getTag();
            c7041a2.f149931a.setTextColor(-1);
            c7041a2.f149932b.setVisibility(0);
            this.K = c7041a2;
            this.C = i3;
            this.f149916c = true;
            m3.setIndoorFloor(i3);
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        qq qqVar = this.f149914a;
        if (qqVar == null) {
            return;
        }
        qo qoVar = (qo) qqVar.findViewWithTag(f149899k);
        qo qoVar2 = (qo) this.f149914a.findViewWithTag(f149900l);
        if (qoVar != null && qoVar2 != null) {
            if (i16 == i17) {
                qoVar.setActivate(false);
            } else {
                if (i3 == 0) {
                    qoVar.setActivate(false);
                } else {
                    qoVar.setActivate(true);
                }
                if (i3 + i16 < i17) {
                    qoVar2.setActivate(true);
                    return;
                }
            }
            qoVar2.setActivate(false);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i3) {
        EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
    }

    private void b(Context context) {
        this.f149914a = new qq(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 83;
        layoutParams.leftMargin = (int) (this.f149923j * 15.0f);
        layoutParams.bottomMargin = this.f149919f;
        this.f149914a.setDarkStyle(this.H);
        this.f149914a.setLayoutParams(layoutParams);
        this.f149914a.setWillNotDraw(false);
        this.f149914a.setOrientation(1);
        this.f149914a.setGravity(1);
        this.f149914a.setVisibility(8);
    }

    public final void e() {
        if (this.f149914a == null) {
            this.A = new a(this.B, new ArrayList());
            a(this.B);
            this.f149919f = (int) (this.f149923j * 45.0f);
            a(this.B, this.A);
            tr trVar = this.f149918e;
            if (trVar != null) {
                this.f149917d = trVar.f151058o;
            }
        }
    }

    public final void f() {
        n();
        qq qqVar = this.f149914a;
        if (qqVar == null || this.f149921h == null) {
            return;
        }
        if (this.f149915b && !this.G && this.D > 0) {
            qqVar.post(new Runnable() { // from class: com.tencent.mapsdk.internal.qs.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (qs.this.f149914a != null && qs.this.f149921h != null) {
                        ViewGroup.LayoutParams layoutParams = qs.this.f149921h.getLayoutParams();
                        if (layoutParams.height != qs.this.f149924v) {
                            layoutParams.height = qs.this.f149924v;
                            qs.this.f149921h.setLayoutParams(layoutParams);
                        }
                        if (qs.this.f149914a.getVisibility() != 0) {
                            qs.this.f149914a.setVisibility(0);
                        }
                    }
                }
            });
        } else {
            qqVar.post(new Runnable() { // from class: com.tencent.mapsdk.internal.qs.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (qs.this.f149914a != null && qs.this.f149914a.getVisibility() == 0) {
                        qs.this.f149914a.setVisibility(8);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mapsdk.internal.qt.a
    public final void g() {
        m();
        IndoorBuilding indoorBuilding = this.E;
        if (indoorBuilding != null) {
            int activeLevelIndex = indoorBuilding.getActiveLevelIndex();
            List<IndoorLevel> levels = this.E.getLevels();
            if (levels == null || activeLevelIndex >= levels.size() || activeLevelIndex == -1 || levels.get(activeLevelIndex) == null) {
                return;
            }
            String str = this.F;
            if (str != null && this.f149916c && str.equals(this.E.getBuidlingId())) {
                this.f149921h.setItemChecked(activeLevelIndex, true);
                this.f149916c = false;
            } else {
                this.f149921h.setSelectionFromTop(activeLevelIndex, ((int) ((this.f149923j * f149906r) + 0.5d)) * 2);
            }
            this.C = activeLevelIndex;
            this.F = this.E.getBuidlingId();
        }
    }

    private void c(Context context) {
        qo qoVar = new qo(context);
        this.I = qoVar;
        qoVar.setDarkStyle(this.H);
        this.I.setTag(f149899k);
        int i3 = (int) (this.f149923j * 5.900000095367432d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, (int) (this.f149923j * 3.200000047683716d));
        layoutParams.setMargins(0, i3, 0, i3);
        this.I.setLayoutParams(layoutParams);
        this.f149914a.addView(this.I);
    }

    private void d(Context context) {
        qo qoVar = new qo(context);
        this.J = qoVar;
        qoVar.setDarkStyle(this.H);
        this.J.setTag(f149900l);
        this.J.setRotation(180.0f);
        int i3 = (int) (this.f149923j * 5.900000095367432d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, (int) (this.f149923j * 3.200000047683716d));
        layoutParams.setMargins(0, i3, 0, i3);
        this.J.setLayoutParams(layoutParams);
        this.f149914a.addView(this.J);
    }

    private void a(Context context) {
        this.f149923j = context.getApplicationContext().getResources().getDisplayMetrics().density;
    }

    private void a(boolean z16) {
        ac acVar;
        tr trVar = this.f149918e;
        if (trVar == null) {
            return;
        }
        if (z16) {
            this.f149915b = true;
        } else {
            this.f149915b = false;
        }
        boolean z17 = this.f149915b;
        if (trVar != null) {
            if (this.f149914a == null) {
                if (!z17) {
                    return;
                } else {
                    e();
                }
            }
            VectorMap vectorMap = (VectorMap) this.f149918e.e_;
            if (this.f149915b && z17 && (acVar = this.f149917d) != null && acVar.f147693f) {
                a(vectorMap.f151353q.u());
                return;
            }
            a((IndoorBuilding) null);
            if (this.f149914a.getVisibility() != 8) {
                this.f149914a.setVisibility(8);
            }
        }
    }

    private void b(Context context, a aVar) {
        this.f149921h = new qt(context);
        this.f149921h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f149921h.setChoiceMode(1);
        this.f149921h.setAdapter((ListAdapter) aVar);
        this.f149921h.setOnItemClickListener(this);
        this.f149921h.setVerticalScrollBarEnabled(false);
        this.f149921h.setHorizontalScrollBarEnabled(false);
        this.f149921h.setOverScrollMode(2);
        this.f149921h.setDivider(null);
        this.f149921h.setDividerHeight(0);
        this.f149921h.setOnDataChangedListener(this);
        this.f149914a.addView(this.f149921h);
        this.f149921h.setOnScrollListener(this);
    }

    public final void a(IndoorBuilding indoorBuilding) {
        if (indoorBuilding == null) {
            this.E = indoorBuilding;
            this.D = 0;
            f();
            return;
        }
        if (this.f149914a == null) {
            e();
        }
        IndoorBuilding indoorBuilding2 = this.E;
        if (indoorBuilding2 != null && indoorBuilding2.getBuidlingId().equals(indoorBuilding.getBuidlingId()) && this.E.getActiveLevelIndex() == indoorBuilding.getActiveLevelIndex()) {
            return;
        }
        this.E = indoorBuilding;
        this.D = indoorBuilding.getLevels().size();
        a(indoorBuilding.getLevels());
    }

    @Override // com.tencent.mapsdk.internal.fp
    public final void b(int i3, int i16) {
        if (this.f149914a == null || this.f149921h == null) {
            return;
        }
        f();
    }

    @Override // com.tencent.mapsdk.internal.eu
    public final View[] b() {
        return new View[]{this.f149914a};
    }

    private void b(boolean z16) {
        ac acVar;
        if (this.f149918e == null) {
            return;
        }
        if (this.f149914a == null) {
            if (!z16) {
                return;
            } else {
                e();
            }
        }
        VectorMap vectorMap = (VectorMap) this.f149918e.e_;
        if (this.f149915b && z16 && (acVar = this.f149917d) != null && acVar.f147693f) {
            a(vectorMap.f151353q.u());
            return;
        }
        a((IndoorBuilding) null);
        if (this.f149914a.getVisibility() != 8) {
            this.f149914a.setVisibility(8);
        }
    }

    private void a(Context context, a aVar) {
        b(context);
        c(context);
        b(context, aVar);
        d(context);
        a(this.f149918e.ab(), (Bundle) null);
        this.f149914a.setVisibility(8);
    }

    @Override // com.tencent.mapsdk.internal.ew
    public final boolean a(ViewGroup viewGroup, Bundle bundle) {
        qq qqVar = this.f149914a;
        if (qqVar == null || viewGroup == null) {
            return false;
        }
        if (viewGroup.indexOfChild(qqVar) < 0) {
            viewGroup.addView(this.f149914a);
        }
        k();
        m();
        return true;
    }

    private void a(int i3) {
        this.f149919f = i3;
        qq qqVar = this.f149914a;
        if (qqVar != null) {
            qqVar.post(new AnonymousClass1());
        }
        ViewGroup ab5 = this.f149918e.ab();
        if (ab5 != null) {
            this.f149920g = ab5.getMeasuredHeight();
        }
        M m3 = this.f149918e.e_;
        if (m3 == 0 || ((VectorMap) m3).f151351o.f149410w == null || ((VectorMap) m3).f151351o.f149410w.f151268q == null) {
            return;
        }
        this.f149920g = (((int) ((VectorMap) m3).f151351o.f149410w.f151268q.f148384b) - i3) * 2;
        f();
    }

    private void a(List<IndoorLevel> list) {
        if (this.f149918e.ab() == null) {
            return;
        }
        f();
        a aVar = this.A;
        if (aVar != null) {
            aVar.a(list);
        }
    }

    private int a(Adapter adapter) {
        int i3 = (int) (this.f149923j * 44.5d);
        int count = adapter.getCount();
        View view = null;
        for (int i16 = 0; i16 < count; i16++) {
            view = adapter.getView(i16, view, this.f149921h);
            view.measure(0, 0);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }
}
