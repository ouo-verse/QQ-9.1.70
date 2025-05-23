package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DragSortListView extends ListView {
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    public float A0;
    public boolean B0;
    public int C;
    public boolean C0;
    public int D;
    public int E;
    public int F;
    public DragListener G;
    public DropListener H;
    public RemoveListener I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public View[] P;
    public DragScroller Q;
    public float R;
    public float S;
    public int T;
    public int U;
    public float V;
    public float W;

    /* renamed from: a, reason: collision with root package name */
    public View f153869a;

    /* renamed from: a0, reason: collision with root package name */
    public float f153870a0;

    /* renamed from: b, reason: collision with root package name */
    public Point f153871b;

    /* renamed from: b0, reason: collision with root package name */
    public float f153872b0;

    /* renamed from: c, reason: collision with root package name */
    public Point f153873c;

    /* renamed from: c0, reason: collision with root package name */
    public float f153874c0;

    /* renamed from: d, reason: collision with root package name */
    public int f153875d;

    /* renamed from: d0, reason: collision with root package name */
    public DragScrollProfile f153876d0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f153877e;

    /* renamed from: e0, reason: collision with root package name */
    public int f153878e0;

    /* renamed from: f, reason: collision with root package name */
    public DataSetObserver f153879f;

    /* renamed from: f0, reason: collision with root package name */
    public int f153880f0;

    /* renamed from: g, reason: collision with root package name */
    public float f153881g;

    /* renamed from: g0, reason: collision with root package name */
    public int f153882g0;

    /* renamed from: h, reason: collision with root package name */
    public float f153883h;

    /* renamed from: h0, reason: collision with root package name */
    public int f153884h0;

    /* renamed from: i, reason: collision with root package name */
    public int f153885i;

    /* renamed from: i0, reason: collision with root package name */
    public int f153886i0;

    /* renamed from: j, reason: collision with root package name */
    public int f153887j;

    /* renamed from: j0, reason: collision with root package name */
    public int f153888j0;

    /* renamed from: k, reason: collision with root package name */
    public int f153889k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f153890k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f153891l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f153892l0;

    /* renamed from: m, reason: collision with root package name */
    public int f153893m;

    /* renamed from: m0, reason: collision with root package name */
    public FloatViewManager f153894m0;

    /* renamed from: n0, reason: collision with root package name */
    public MotionEvent f153895n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f153896o0;

    /* renamed from: p0, reason: collision with root package name */
    public float f153897p0;

    /* renamed from: q0, reason: collision with root package name */
    public float f153898q0;

    /* renamed from: r0, reason: collision with root package name */
    public AdapterWrapper f153899r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f153900s0;

    /* renamed from: t0, reason: collision with root package name */
    public DragSortTracker f153901t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f153902u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f153903v0;

    /* renamed from: w0, reason: collision with root package name */
    public HeightCache f153904w0;

    /* renamed from: x0, reason: collision with root package name */
    public RemoveAnimator f153905x0;

    /* renamed from: y0, reason: collision with root package name */
    public DropAnimator f153906y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f153907z0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class AdapterWrapper extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public ListAdapter f153911a;

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.f153911a.areAllItemsEnabled();
        }

        public ListAdapter getAdapter() {
            return this.f153911a;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f153911a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f153911a.getItem(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return this.f153911a.getItemId(i3);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            return this.f153911a.getItemViewType(i3);
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            DragSortItemView dragSortItemView;
            DragSortItemView dragSortItemView2;
            if (view != null && (view instanceof DragSortItemView)) {
                dragSortItemView2 = (DragSortItemView) view;
                View childAt = dragSortItemView2.getChildAt(0);
                View view2 = this.f153911a.getView(i3, childAt, DragSortListView.this);
                if (view2 != childAt) {
                    if (childAt != null) {
                        dragSortItemView2.removeViewAt(0);
                    }
                    dragSortItemView2.addView(view2);
                }
            } else {
                View view3 = this.f153911a.getView(i3, null, DragSortListView.this);
                if (view3 instanceof Checkable) {
                    dragSortItemView = new DragSortItemViewCheckable(DragSortListView.this.getContext());
                } else {
                    dragSortItemView = new DragSortItemView(DragSortListView.this.getContext());
                }
                dragSortItemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                dragSortItemView.addView(view3);
                dragSortItemView2 = dragSortItemView;
            }
            DragSortListView dragSortListView = DragSortListView.this;
            dragSortListView.a(i3 + dragSortListView.getHeaderViewsCount(), (View) dragSortItemView2, true);
            return dragSortItemView2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.f153911a.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.f153911a.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.f153911a.isEmpty();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            return this.f153911a.isEnabled(i3);
        }

        AdapterWrapper(ListAdapter listAdapter) {
            this.f153911a = listAdapter;
            listAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.tencent.mm.ui.widget.sortlist.DragSortListView.AdapterWrapper.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    AdapterWrapper.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    AdapterWrapper.this.notifyDataSetInvalidated();
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface DragListener {
        void drag(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface DragScrollProfile {
        float getSpeed(float f16, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class DragScroller implements Runnable {
        public static final int DOWN = 1;
        public static final int STOP = -1;
        public static final int UP = 0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f153915a;

        /* renamed from: b, reason: collision with root package name */
        public long f153916b;

        /* renamed from: c, reason: collision with root package name */
        public long f153917c;

        /* renamed from: d, reason: collision with root package name */
        public int f153918d;

        /* renamed from: e, reason: collision with root package name */
        public float f153919e;

        /* renamed from: f, reason: collision with root package name */
        public long f153920f;

        /* renamed from: g, reason: collision with root package name */
        public int f153921g;

        /* renamed from: h, reason: collision with root package name */
        public float f153922h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f153923i = false;

        public DragScroller() {
        }

        public int getScrollDir() {
            if (this.f153923i) {
                return this.f153921g;
            }
            return -1;
        }

        public boolean isScrolling() {
            return this.f153923i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f153915a) {
                this.f153923i = false;
                return;
            }
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.f153880f0, DragSortListView.this.f153875d + DragSortListView.this.N);
            int max = Math.max(DragSortListView.this.f153880f0, DragSortListView.this.f153875d - DragSortListView.this.N);
            if (this.f153921g == 0) {
                View childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.f153923i = false;
                    return;
                } else {
                    if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                        this.f153923i = false;
                        return;
                    }
                    this.f153922h = DragSortListView.this.f153876d0.getSpeed((DragSortListView.this.W - max) / DragSortListView.this.f153870a0, this.f153916b);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.f153923i = false;
                    return;
                } else {
                    if (lastVisiblePosition == count - 1 && childAt2.getBottom() <= height + paddingTop) {
                        this.f153923i = false;
                        return;
                    }
                    this.f153922h = -DragSortListView.this.f153876d0.getSpeed((min - DragSortListView.this.V) / DragSortListView.this.f153872b0, this.f153916b);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            this.f153917c = uptimeMillis;
            float f16 = (float) (uptimeMillis - this.f153916b);
            this.f153919e = f16;
            int round = Math.round(this.f153922h * f16);
            this.f153918d = round;
            if (round >= 0) {
                this.f153918d = Math.min(height, round);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.f153918d = Math.max(-height, round);
            }
            View childAt3 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            int top = childAt3.getTop() + this.f153918d;
            if (lastVisiblePosition == 0 && top > paddingTop) {
                top = paddingTop;
            }
            DragSortListView.this.f153902u0 = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, top - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.f153902u0 = false;
            DragSortListView.this.c(lastVisiblePosition, childAt3, false);
            this.f153916b = this.f153917c;
            DragSortListView.this.post(this);
        }

        public void startScrolling(int i3) {
            if (!this.f153923i) {
                this.f153915a = false;
                this.f153923i = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f153920f = uptimeMillis;
                this.f153916b = uptimeMillis;
                this.f153921g = i3;
                DragSortListView.this.post(this);
            }
        }

        public void stopScrolling(boolean z16) {
            if (z16) {
                DragSortListView.this.removeCallbacks(this);
                this.f153923i = false;
            } else {
                this.f153915a = true;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface DragSortListener extends DropListener, DragListener, RemoveListener {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class DragSortTracker {

        /* renamed from: b, reason: collision with root package name */
        public File f153926b;

        /* renamed from: a, reason: collision with root package name */
        public StringBuilder f153925a = new StringBuilder();

        /* renamed from: c, reason: collision with root package name */
        public int f153927c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f153928d = 0;

        /* renamed from: e, reason: collision with root package name */
        public boolean f153929e = false;

        public DragSortTracker() {
            File file = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.f153926b = file;
            if (!file.exists()) {
                try {
                    if (!this.f153926b.createNewFile()) {
                        n.b("mobeta", "creat file fail!! file already exist", new Object[0]);
                    }
                    n.a("mobeta", "file created", new Object[0]);
                } catch (IOException e16) {
                    n.e("mobeta", "Could not create dslv_state.txt", new Object[0]);
                    n.a("mobeta", e16.getMessage(), new Object[0]);
                }
            }
        }

        public void appendState() {
            if (!this.f153929e) {
                return;
            }
            this.f153925a.append("<DSLVState>\n");
            int childCount = DragSortListView.this.getChildCount();
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            this.f153925a.append("    <Positions>");
            for (int i3 = 0; i3 < childCount; i3++) {
                StringBuilder sb5 = this.f153925a;
                sb5.append(firstVisiblePosition + i3);
                sb5.append(",");
            }
            this.f153925a.append("</Positions>\n");
            this.f153925a.append("    <Tops>");
            for (int i16 = 0; i16 < childCount; i16++) {
                StringBuilder sb6 = this.f153925a;
                sb6.append(DragSortListView.this.getChildAt(i16).getTop());
                sb6.append(",");
            }
            this.f153925a.append("</Tops>\n");
            this.f153925a.append("    <Bottoms>");
            for (int i17 = 0; i17 < childCount; i17++) {
                StringBuilder sb7 = this.f153925a;
                sb7.append(DragSortListView.this.getChildAt(i17).getBottom());
                sb7.append(",");
            }
            this.f153925a.append("</Bottoms>\n");
            StringBuilder sb8 = this.f153925a;
            sb8.append("    <FirstExpPos>");
            sb8.append(DragSortListView.this.f153887j);
            sb8.append("</FirstExpPos>\n");
            StringBuilder sb9 = this.f153925a;
            sb9.append("    <FirstExpBlankHeight>");
            DragSortListView dragSortListView = DragSortListView.this;
            int c16 = dragSortListView.c(dragSortListView.f153887j);
            DragSortListView dragSortListView2 = DragSortListView.this;
            sb9.append(c16 - dragSortListView2.b(dragSortListView2.f153887j));
            sb9.append("</FirstExpBlankHeight>\n");
            StringBuilder sb10 = this.f153925a;
            sb10.append("    <SecondExpPos>");
            sb10.append(DragSortListView.this.f153889k);
            sb10.append("</SecondExpPos>\n");
            StringBuilder sb11 = this.f153925a;
            sb11.append("    <SecondExpBlankHeight>");
            DragSortListView dragSortListView3 = DragSortListView.this;
            int c17 = dragSortListView3.c(dragSortListView3.f153889k);
            DragSortListView dragSortListView4 = DragSortListView.this;
            sb11.append(c17 - dragSortListView4.b(dragSortListView4.f153889k));
            sb11.append("</SecondExpBlankHeight>\n");
            StringBuilder sb12 = this.f153925a;
            sb12.append("    <SrcPos>");
            sb12.append(DragSortListView.this.f153893m);
            sb12.append("</SrcPos>\n");
            StringBuilder sb13 = this.f153925a;
            sb13.append("    <SrcHeight>");
            sb13.append(DragSortListView.this.M + DragSortListView.this.getDividerHeight());
            sb13.append("</SrcHeight>\n");
            StringBuilder sb14 = this.f153925a;
            sb14.append("    <ViewHeight>");
            sb14.append(DragSortListView.this.getHeight());
            sb14.append("</ViewHeight>\n");
            StringBuilder sb15 = this.f153925a;
            sb15.append("    <LastY>");
            sb15.append(DragSortListView.this.f153884h0);
            sb15.append("</LastY>\n");
            StringBuilder sb16 = this.f153925a;
            sb16.append("    <FloatY>");
            sb16.append(DragSortListView.this.f153875d);
            sb16.append("</FloatY>\n");
            this.f153925a.append("    <ShuffleEdges>");
            for (int i18 = 0; i18 < childCount; i18++) {
                StringBuilder sb17 = this.f153925a;
                DragSortListView dragSortListView5 = DragSortListView.this;
                sb17.append(dragSortListView5.c(firstVisiblePosition + i18, dragSortListView5.getChildAt(i18).getTop()));
                sb17.append(",");
            }
            this.f153925a.append("</ShuffleEdges>\n");
            this.f153925a.append("</DSLVState>\n");
            int i19 = this.f153927c + 1;
            this.f153927c = i19;
            if (i19 > 1000) {
                flush();
                this.f153927c = 0;
            }
        }

        public void flush() {
            boolean z16;
            if (!this.f153929e) {
                return;
            }
            BufferedWriter bufferedWriter = null;
            try {
                if (this.f153928d == 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f153926b, z16), "UTF-8"));
                try {
                    bufferedWriter2.write(this.f153925a.toString());
                    StringBuilder sb5 = this.f153925a;
                    sb5.delete(0, sb5.length());
                    bufferedWriter2.flush();
                    this.f153928d++;
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e16) {
                        n.a("DragSortListView", e16, "IOException", new Object[0]);
                    }
                } catch (IOException unused) {
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e17) {
                            n.a("DragSortListView", e17, "IOException", new Object[0]);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e18) {
                            n.a("DragSortListView", e18, "IOException", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th6) {
                th = th6;
            }
        }

        public void startTracking() {
            this.f153925a.append("<DSLVStates>\n");
            this.f153928d = 0;
            this.f153929e = true;
        }

        public void stopTracking() {
            if (this.f153929e) {
                this.f153925a.append("</DSLVStates>\n");
                flush();
                this.f153929e = false;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class DropAnimator extends SmoothAnimator {

        /* renamed from: j, reason: collision with root package name */
        public int f153931j;

        /* renamed from: k, reason: collision with root package name */
        public int f153932k;

        /* renamed from: l, reason: collision with root package name */
        public float f153933l;

        /* renamed from: m, reason: collision with root package name */
        public float f153934m;

        public final int a() {
            int bottom;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int dividerHeight = (DragSortListView.this.L + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.f153931j - firstVisiblePosition);
            if (childAt != null) {
                int i3 = this.f153931j;
                int i16 = this.f153932k;
                if (i3 == i16) {
                    return childAt.getTop();
                }
                if (i3 < i16) {
                    bottom = childAt.getTop();
                } else {
                    bottom = childAt.getBottom() + dividerHeight;
                    dividerHeight = DragSortListView.this.M;
                }
                return bottom - dividerHeight;
            }
            cancel();
            return -1;
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onStart() {
            this.f153931j = DragSortListView.this.f153885i;
            this.f153932k = DragSortListView.this.f153893m;
            DragSortListView.this.K = 2;
            this.f153933l = DragSortListView.this.f153871b.y - a();
            this.f153934m = DragSortListView.this.f153871b.x - DragSortListView.this.getPaddingLeft();
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onStop() {
            DragSortListView.this.g();
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onUpdate(float f16, float f17) {
            int a16 = a();
            int paddingLeft = DragSortListView.this.getPaddingLeft();
            float f18 = DragSortListView.this.f153871b.y - a16;
            float f19 = DragSortListView.this.f153871b.x - paddingLeft;
            float f26 = 1.0f - f17;
            if (f26 < Math.abs(f18 / this.f153933l) || f26 < Math.abs(f19 / this.f153934m)) {
                DragSortListView.this.f153871b.y = a16 + ((int) (this.f153933l * f26));
                DragSortListView.this.f153871b.x = DragSortListView.this.getPaddingLeft() + ((int) (this.f153934m * f26));
                DragSortListView.this.a(true);
            }
        }

        DropAnimator(float f16, int i3) {
            super(f16, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface DropListener {
        void drop(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface FloatViewManager {
        View onCreateFloatView(int i3);

        void onDestroyFloatView(View view);

        void onDragFloatView(View view, Point point, Point point2);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class HeightCache {

        /* renamed from: a, reason: collision with root package name */
        public SparseIntArray f153935a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f153936b;

        /* renamed from: c, reason: collision with root package name */
        public int f153937c;

        public void add(int i3, int i16) {
            int i17 = this.f153935a.get(i3, -1);
            if (i17 != i16) {
                if (i17 == -1) {
                    if (this.f153935a.size() == this.f153937c) {
                        this.f153935a.delete(((Integer) this.f153936b.remove(0)).intValue());
                    }
                } else {
                    this.f153936b.remove(Integer.valueOf(i3));
                }
                this.f153935a.put(i3, i16);
                this.f153936b.add(Integer.valueOf(i3));
            }
        }

        public void clear() {
            this.f153935a.clear();
            this.f153936b.clear();
        }

        public int get(int i3) {
            return this.f153935a.get(i3, -1);
        }

        HeightCache(int i3) {
            this.f153935a = new SparseIntArray(i3);
            this.f153936b = new ArrayList(i3);
            this.f153937c = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class LiftAnimator extends SmoothAnimator {

        /* renamed from: j, reason: collision with root package name */
        public float f153939j;

        /* renamed from: k, reason: collision with root package name */
        public float f153940k;

        LiftAnimator(float f16, int i3) {
            super(f16, i3);
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onStart() {
            this.f153939j = DragSortListView.this.D;
            this.f153940k = DragSortListView.this.N;
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onUpdate(float f16, float f17) {
            if (DragSortListView.this.K != 4) {
                cancel();
                return;
            }
            DragSortListView.this.D = (int) ((this.f153940k * f17) + ((1.0f - f17) * this.f153939j));
            DragSortListView.this.f153871b.y = DragSortListView.this.f153880f0 - DragSortListView.this.D;
            DragSortListView.this.a(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class RemoveAnimator extends SmoothAnimator {
        public int C;
        public int D;
        public int E;

        /* renamed from: j, reason: collision with root package name */
        public float f153942j;

        /* renamed from: k, reason: collision with root package name */
        public float f153943k;

        /* renamed from: l, reason: collision with root package name */
        public float f153944l;

        /* renamed from: m, reason: collision with root package name */
        public int f153945m;

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onStart() {
            int i3 = -1;
            this.f153945m = -1;
            this.C = -1;
            this.D = DragSortListView.this.f153887j;
            this.E = DragSortListView.this.f153889k;
            DragSortListView.this.K = 1;
            this.f153942j = DragSortListView.this.f153871b.x;
            if (!DragSortListView.this.f153907z0) {
                DragSortListView.this.d();
                return;
            }
            float width = DragSortListView.this.getWidth() * 2.0f;
            if (DragSortListView.this.A0 == 0.0f) {
                DragSortListView dragSortListView = DragSortListView.this;
                if (this.f153942j >= 0.0f) {
                    i3 = 1;
                }
                dragSortListView.A0 = i3 * width;
                return;
            }
            float f16 = width * 2.0f;
            if (DragSortListView.this.A0 < 0.0f) {
                float f17 = -f16;
                if (DragSortListView.this.A0 > f17) {
                    DragSortListView.this.A0 = f17;
                    return;
                }
            }
            if (DragSortListView.this.A0 > 0.0f && DragSortListView.this.A0 < f16) {
                DragSortListView.this.A0 = f16;
            }
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onStop() {
            DragSortListView.this.f();
        }

        @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.SmoothAnimator
        public void onUpdate(float f16, float f17) {
            View childAt;
            int i3;
            float f18 = 1.0f - f17;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt2 = DragSortListView.this.getChildAt(this.D - firstVisiblePosition);
            if (DragSortListView.this.f153907z0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f153946a)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    return;
                }
                float f19 = DragSortListView.this.A0 * uptimeMillis;
                int width = DragSortListView.this.getWidth();
                DragSortListView dragSortListView = DragSortListView.this;
                if (dragSortListView.A0 > 0.0f) {
                    i3 = 1;
                } else {
                    i3 = -1;
                }
                float f26 = i3 * uptimeMillis;
                float f27 = width;
                DragSortListView.b(dragSortListView, f26 * f27);
                this.f153942j += f19;
                Point point = DragSortListView.this.f153871b;
                float f28 = this.f153942j;
                point.x = (int) f28;
                if (f28 < f27 && f28 > (-width)) {
                    this.f153946a = SystemClock.uptimeMillis();
                    DragSortListView.this.a(true);
                    return;
                }
            }
            if (childAt2 != null) {
                if (this.f153945m == -1) {
                    this.f153945m = DragSortListView.this.d(this.D, childAt2, false);
                    this.f153943k = childAt2.getHeight() - this.f153945m;
                }
                int max = Math.max((int) (this.f153943k * f18), 1);
                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                layoutParams.height = this.f153945m + max;
                childAt2.setLayoutParams(layoutParams);
            }
            int i16 = this.E;
            if (i16 != this.D && (childAt = DragSortListView.this.getChildAt(i16 - firstVisiblePosition)) != null) {
                if (this.C == -1) {
                    this.C = DragSortListView.this.d(this.E, childAt, false);
                    this.f153944l = childAt.getHeight() - this.C;
                }
                int max2 = Math.max((int) (f18 * this.f153944l), 1);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.height = this.C + max2;
                childAt.setLayoutParams(layoutParams2);
            }
        }

        RemoveAnimator(float f16, int i3) {
            super(f16, i3);
            this.f153945m = -1;
            this.C = -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface RemoveListener {
        void remove(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class SmoothAnimator implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public long f153946a;

        /* renamed from: b, reason: collision with root package name */
        public float f153947b;

        /* renamed from: c, reason: collision with root package name */
        public float f153948c;

        /* renamed from: d, reason: collision with root package name */
        public float f153949d;

        /* renamed from: e, reason: collision with root package name */
        public float f153950e;

        /* renamed from: f, reason: collision with root package name */
        public float f153951f;

        /* renamed from: g, reason: collision with root package name */
        public float f153952g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f153953h;

        public void cancel() {
            this.f153953h = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f153953h) {
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f153946a)) / this.f153947b;
            if (uptimeMillis >= 1.0f) {
                onUpdate(1.0f, 1.0f);
                onStop();
            } else {
                onUpdate(uptimeMillis, transform(uptimeMillis));
                DragSortListView.this.post(this);
            }
        }

        public void start() {
            this.f153946a = SystemClock.uptimeMillis();
            this.f153953h = false;
            onStart();
            DragSortListView.this.post(this);
        }

        public float transform(float f16) {
            float f17 = this.f153948c;
            if (f16 < f17) {
                return this.f153949d * f16 * f16;
            }
            if (f16 < 1.0f - f17) {
                return this.f153950e + (this.f153951f * f16);
            }
            float f18 = f16 - 1.0f;
            return 1.0f - ((this.f153952g * f18) * f18);
        }

        SmoothAnimator(float f16, int i3) {
            this.f153948c = f16;
            this.f153947b = i3;
            float f17 = 1.0f - f16;
            float f18 = 1.0f / ((f16 * 2.0f) * f17);
            this.f153952g = f18;
            this.f153949d = f18;
            this.f153950e = f16 / ((f16 - 1.0f) * 2.0f);
            this.f153951f = 1.0f / f17;
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public void onUpdate(float f16, float f17) {
        }
    }

    public DragSortListView(Context context) {
        super(context);
        this.f153871b = new Point();
        this.f153873c = new Point();
        this.f153877e = false;
        this.f153881g = 1.0f;
        this.f153883h = 1.0f;
        this.f153891l = false;
        this.J = true;
        this.K = 0;
        this.L = 1;
        this.O = 0;
        this.P = new View[1];
        this.R = 0.33333334f;
        this.S = 0.33333334f;
        float f16 = 0.5f;
        this.f153874c0 = 0.5f;
        this.f153876d0 = new DragScrollProfile() { // from class: com.tencent.mm.ui.widget.sortlist.DragSortListView.1
            @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.DragScrollProfile
            public float getSpeed(float f17, long j3) {
                return DragSortListView.this.f153874c0 * f17;
            }
        };
        this.f153888j0 = 0;
        this.f153890k0 = false;
        this.f153892l0 = false;
        this.f153894m0 = null;
        this.f153896o0 = 0;
        this.f153897p0 = 0.25f;
        this.f153898q0 = 0.0f;
        this.f153900s0 = false;
        this.f153902u0 = false;
        this.f153903v0 = false;
        this.f153904w0 = new HeightCache(3);
        this.A0 = 0.0f;
        this.B0 = false;
        this.C0 = false;
        this.Q = new DragScroller();
        int i3 = 150;
        this.f153905x0 = new RemoveAnimator(f16, i3);
        this.f153906y0 = new DropAnimator(f16, i3);
        this.f153895n0 = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f153879f = new DataSetObserver() { // from class: com.tencent.mm.ui.widget.sortlist.DragSortListView.2
            public final void a() {
                if (DragSortListView.this.K == 4) {
                    DragSortListView.this.cancelDrag();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                a();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                a();
            }
        };
    }

    public static int a(int i3, int i16, int i17, int i18) {
        int i19 = i18 - i17;
        int i26 = i3 + i16;
        return i26 < i17 ? i26 + i19 : i26 >= i18 ? i26 - i19 : i26;
    }

    public void cancelDrag() {
        if (this.K == 4) {
            this.Q.stopScrolling(true);
            d();
            c();
            a();
            if (this.f153892l0) {
                this.K = 3;
            } else {
                this.K = 0;
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f16;
        super.dispatchDraw(canvas);
        if (this.K != 0) {
            int i3 = this.f153887j;
            if (i3 != this.f153893m) {
                a(i3, canvas);
            }
            int i16 = this.f153889k;
            if (i16 != this.f153887j && i16 != this.f153893m) {
                a(i16, canvas);
            }
        }
        View view = this.f153869a;
        if (view != null) {
            int width = view.getWidth();
            int height = this.f153869a.getHeight();
            int i17 = this.f153871b.x;
            int width2 = getWidth();
            if (i17 < 0) {
                i17 = -i17;
            }
            if (i17 < width2) {
                float f17 = (width2 - i17) / width2;
                f16 = f17 * f17;
            } else {
                f16 = 0.0f;
            }
            int i18 = (int) (this.f153883h * 255.0f * f16);
            canvas.save();
            Point point = this.f153871b;
            canvas.translate(point.x, point.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, width, height, i18, 31);
            this.f153869a.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    public float getFloatAlpha() {
        return this.f153883h;
    }

    public ListAdapter getInputAdapter() {
        AdapterWrapper adapterWrapper = this.f153899r0;
        if (adapterWrapper == null) {
            return null;
        }
        return adapterWrapper.getAdapter();
    }

    public boolean isDragEnabled() {
        return this.J;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        super.layoutChildren();
        View view = this.f153869a;
        if (view != null) {
            if (view.isLayoutRequested() && !this.f153877e) {
                h();
            }
            View view2 = this.f153869a;
            view2.layout(0, 0, view2.getMeasuredWidth(), this.f153869a.getMeasuredHeight());
            this.f153877e = false;
        }
    }

    public boolean listViewIntercepted() {
        return this.B0;
    }

    public void moveCheckState(int i3, int i16) {
        int i17;
        int i18;
        SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
        if (checkedItemPositions == null) {
            return;
        }
        if (i16 < i3) {
            i18 = i3;
            i17 = i16;
        } else {
            i17 = i3;
            i18 = i16;
        }
        int i19 = i18 + 1;
        int[] iArr = new int[checkedItemPositions.size()];
        int[] iArr2 = new int[checkedItemPositions.size()];
        int a16 = a(checkedItemPositions, i17, i19, iArr, iArr2);
        if (a16 == 1 && iArr[0] == iArr2[0]) {
            return;
        }
        if (i3 < i16) {
            for (int i26 = 0; i26 != a16; i26++) {
                setItemChecked(a(iArr[i26], -1, i17, i19), true);
                setItemChecked(a(iArr2[i26], -1, i17, i19), false);
            }
            return;
        }
        for (int i27 = 0; i27 != a16; i27++) {
            setItemChecked(iArr[i27], false);
            setItemChecked(iArr2[i27], true);
        }
    }

    public void moveItem(int i3, int i16) {
        int count;
        if (this.H != null) {
            if (getInputAdapter() == null) {
                count = 0;
            } else {
                count = getInputAdapter().getCount();
            }
            if (i3 >= 0 && i3 < count && i16 >= 0 && i16 < count) {
                this.H.drop(i3, i16);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f153900s0) {
            this.f153901t0.appendState();
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        if (!this.J) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        this.f153890k0 = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.K != 0) {
                this.f153903v0 = true;
                return true;
            }
            this.f153892l0 = true;
        }
        if (this.f153869a != null) {
            z16 = true;
        } else {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.B0 = true;
                z16 = true;
            } else {
                z16 = false;
            }
            if (action != 1 && action != 3) {
                if (z16) {
                    this.f153896o0 = 1;
                } else {
                    this.f153896o0 = 2;
                }
            } else {
                e();
            }
        }
        if (action == 1 || action == 3) {
            this.f153892l0 = false;
        }
        return z16;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        View view = this.f153869a;
        if (view != null) {
            if (view.isLayoutRequested()) {
                h();
            }
            this.f153877e = true;
        }
        this.O = i3;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        k();
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16 = false;
        if (this.f153903v0) {
            this.f153903v0 = false;
            return false;
        }
        if (!this.J) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z17 = this.f153890k0;
        this.f153890k0 = false;
        if (!z17) {
            b(motionEvent);
        }
        int i3 = this.K;
        if (i3 == 4) {
            a(motionEvent);
            return true;
        }
        if (i3 == 0 && super.onTouchEvent(motionEvent)) {
            z16 = true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 1 && action != 3) {
            if (z16) {
                this.f153896o0 = 1;
            }
        } else {
            e();
        }
        return z16;
    }

    public void removeCheckState(int i3) {
        int i16;
        SparseBooleanArray checkedItemPositions = getCheckedItemPositions();
        if (checkedItemPositions != null && checkedItemPositions.size() != 0) {
            int[] iArr = new int[checkedItemPositions.size()];
            int[] iArr2 = new int[checkedItemPositions.size()];
            int keyAt = checkedItemPositions.keyAt(checkedItemPositions.size() - 1) + 1;
            int a16 = a(checkedItemPositions, i3, keyAt, iArr, iArr2);
            for (int i17 = 0; i17 != a16; i17++) {
                int i18 = iArr[i17];
                if (i18 != i3 && ((i16 = iArr2[i17]) >= i18 || i16 <= i3)) {
                    setItemChecked(a(i18, -1, i3, keyAt), true);
                }
                setItemChecked(a(iArr2[i17], -1, i3, keyAt), false);
            }
        }
    }

    public void removeItem(int i3) {
        this.f153907z0 = false;
        removeItem(i3, 0.0f);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f153902u0) {
            super.requestLayout();
        }
    }

    public void setDragEnabled(boolean z16) {
        this.J = z16;
    }

    public void setDragListener(DragListener dragListener) {
        this.G = dragListener;
    }

    public void setDragScrollProfile(DragScrollProfile dragScrollProfile) {
        if (dragScrollProfile != null) {
            this.f153876d0 = dragScrollProfile;
        }
    }

    public void setDragScrollStart(float f16) {
        setDragScrollStarts(f16, f16);
    }

    public void setDragScrollStarts(float f16, float f17) {
        if (f17 > 0.5f) {
            this.S = 0.5f;
        } else {
            this.S = f17;
        }
        if (f16 > 0.5f) {
            this.R = 0.5f;
        } else {
            this.R = f16;
        }
        if (getHeight() != 0) {
            k();
        }
    }

    public void setDragSortListener(DragSortListener dragSortListener) {
        setDropListener(dragSortListener);
        setDragListener(dragSortListener);
        setRemoveListener(dragSortListener);
    }

    public void setDropListener(DropListener dropListener) {
        this.H = dropListener;
    }

    public void setFloatAlpha(float f16) {
        this.f153883h = f16;
    }

    public void setFloatViewManager(FloatViewManager floatViewManager) {
        this.f153894m0 = floatViewManager;
    }

    public void setMaxScrollSpeed(float f16) {
        this.f153874c0 = f16;
    }

    public void setRemoveListener(RemoveListener removeListener) {
        this.I = removeListener;
    }

    public boolean startDrag(int i3, int i16, int i17, int i18) {
        FloatViewManager floatViewManager;
        View onCreateFloatView;
        if (!this.f153892l0 || (floatViewManager = this.f153894m0) == null || (onCreateFloatView = floatViewManager.onCreateFloatView(i3)) == null) {
            return false;
        }
        return startDrag(i3, onCreateFloatView, i16, i17, i18);
    }

    public boolean stopDrag(boolean z16) {
        this.f153907z0 = false;
        return stopDrag(z16, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean z16, float f16) {
        this.f153907z0 = true;
        return stopDrag(z16, f16);
    }

    public static /* synthetic */ float b(DragSortListView dragSortListView, float f16) {
        float f17 = dragSortListView.A0 + f16;
        dragSortListView.A0 = f17;
        return f17;
    }

    public final void e() {
        this.f153896o0 = 0;
        this.f153892l0 = false;
        if (this.K == 3) {
            this.K = 0;
        }
        this.f153883h = this.f153881g;
        this.B0 = false;
        this.f153904w0.clear();
    }

    public final void f() {
        a(this.f153893m - getHeaderViewsCount());
    }

    public final void g() {
        int i3;
        this.K = 2;
        if (this.H != null && (i3 = this.f153885i) >= 0 && i3 < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.H.drop(this.f153893m - headerViewsCount, this.f153885i - headerViewsCount);
        }
        d();
        b();
        c();
        a();
        if (this.f153892l0) {
            this.K = 3;
        } else {
            this.K = 0;
        }
    }

    public final void h() {
        View view = this.f153869a;
        if (view != null) {
            a(view);
            int measuredHeight = this.f153869a.getMeasuredHeight();
            this.M = measuredHeight;
            this.N = measuredHeight / 2;
        }
    }

    public final void i() {
        int i3;
        int i16;
        if (this.f153894m0 != null) {
            this.f153873c.set(this.f153878e0, this.f153880f0);
            this.f153894m0.onDragFloatView(this.f153869a, this.f153871b, this.f153873c);
        }
        Point point = this.f153871b;
        int i17 = point.x;
        int i18 = point.y;
        int paddingLeft = getPaddingLeft();
        int i19 = this.f153888j0;
        if ((i19 & 1) == 0 && i17 > paddingLeft) {
            this.f153871b.x = paddingLeft;
        } else if ((i19 & 2) == 0 && i17 < paddingLeft) {
            this.f153871b.x = paddingLeft;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int paddingTop = getPaddingTop();
        if (firstVisiblePosition < headerViewsCount) {
            paddingTop = getChildAt((headerViewsCount - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.f153888j0 & 8) == 0 && firstVisiblePosition <= (i16 = this.f153893m)) {
            paddingTop = Math.max(getChildAt(i16 - firstVisiblePosition).getTop(), paddingTop);
        }
        int height = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            height = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.f153888j0 & 4) == 0 && lastVisiblePosition >= (i3 = this.f153893m)) {
            height = Math.min(getChildAt(i3 - firstVisiblePosition).getBottom(), height);
        }
        if (i18 < paddingTop) {
            this.f153871b.y = paddingTop;
        } else {
            int i26 = this.M;
            if (i18 + i26 > height) {
                this.f153871b.y = height - i26;
            }
        }
        this.f153875d = this.f153871b.y + this.N;
    }

    public final boolean j() {
        int i3;
        int firstVisiblePosition = getFirstVisiblePosition();
        int i16 = this.f153887j;
        View childAt = getChildAt(i16 - firstVisiblePosition);
        if (childAt == null) {
            i16 = (getChildCount() / 2) + firstVisiblePosition;
            childAt = getChildAt(i16 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int c16 = c(i16, top);
        int dividerHeight = getDividerHeight();
        if (this.f153875d < c16) {
            while (i16 >= 0) {
                i16--;
                int c17 = c(i16);
                if (i16 == 0) {
                    i3 = (top - dividerHeight) - c17;
                    break;
                }
                top -= c17 + dividerHeight;
                int c18 = c(i16, top);
                if (this.f153875d >= c18) {
                    i3 = c18;
                    break;
                }
                c16 = c18;
            }
            i3 = c16;
        } else {
            int count = getCount();
            while (i16 < count) {
                if (i16 == count - 1) {
                    i3 = top + dividerHeight + height;
                    break;
                }
                top += height + dividerHeight;
                int i17 = i16 + 1;
                int c19 = c(i17);
                int c26 = c(i17, top);
                if (this.f153875d < c26) {
                    i3 = c26;
                    break;
                }
                i16 = i17;
                height = c19;
                c16 = c26;
            }
            i3 = c16;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int i18 = this.f153887j;
        int i19 = this.f153889k;
        float f16 = this.f153898q0;
        if (this.f153891l) {
            int abs = Math.abs(i3 - c16);
            int i26 = this.f153875d;
            if (i26 >= i3) {
                int i27 = c16;
                c16 = i3;
                i3 = i27;
            }
            int i28 = (int) (this.f153897p0 * 0.5f * abs);
            float f17 = i28;
            int i29 = c16 + i28;
            int i36 = i3 - i28;
            if (i26 < i29) {
                this.f153887j = i16 - 1;
                this.f153889k = i16;
                this.f153898q0 = ((i29 - i26) * 0.5f) / f17;
            } else if (i26 < i36) {
                this.f153887j = i16;
                this.f153889k = i16;
            } else {
                this.f153887j = i16;
                this.f153889k = i16 + 1;
                this.f153898q0 = (((i3 - i26) / f17) + 1.0f) * 0.5f;
            }
        } else {
            this.f153887j = i16;
            this.f153889k = i16;
        }
        if (this.f153887j < headerViewsCount) {
            this.f153887j = headerViewsCount;
            this.f153889k = headerViewsCount;
            i16 = headerViewsCount;
        } else if (this.f153889k >= getCount() - footerViewsCount) {
            i16 = (getCount() - footerViewsCount) - 1;
            this.f153887j = i16;
            this.f153889k = i16;
        }
        boolean z16 = (this.f153887j == i18 && this.f153889k == i19 && Math.abs(this.f153898q0 - f16) <= 0.0f) ? false : true;
        int i37 = this.f153885i;
        if (i16 == i37) {
            return z16;
        }
        DragListener dragListener = this.G;
        if (dragListener != null) {
            dragListener.drag(i37 - headerViewsCount, i16 - headerViewsCount);
        }
        this.f153885i = i16;
        return true;
    }

    public final void k() {
        int paddingTop = getPaddingTop();
        float height = (getHeight() - paddingTop) - getPaddingBottom();
        float f16 = paddingTop;
        float f17 = (this.R * height) + f16;
        this.W = f17;
        float f18 = ((1.0f - this.S) * height) + f16;
        this.V = f18;
        this.T = (int) f17;
        this.U = (int) f18;
        this.f153870a0 = f17 - f16;
        this.f153872b0 = (paddingTop + r1) - f18;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.f153899r0 = new AdapterWrapper(listAdapter);
            listAdapter.registerDataSetObserver(this.f153879f);
            if (listAdapter instanceof DropListener) {
                setDropListener((DropListener) listAdapter);
            }
            if (listAdapter instanceof DragListener) {
                setDragListener((DragListener) listAdapter);
            }
            if (listAdapter instanceof RemoveListener) {
                setRemoveListener((RemoveListener) listAdapter);
            }
        } else {
            this.f153899r0 = null;
        }
        super.setAdapter((ListAdapter) this.f153899r0);
    }

    public final int d(int i3, View view, boolean z16) {
        int i16;
        if (i3 == this.f153893m) {
            return 0;
        }
        if (i3 >= getHeaderViewsCount() && i3 < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (i16 = layoutParams.height) > 0) {
            return i16;
        }
        int height = view.getHeight();
        if (height != 0 && !z16) {
            return height;
        }
        a(view);
        return view.getMeasuredHeight();
    }

    public void removeItem(int i3, float f16) {
        int i16 = this.K;
        if (i16 == 0 || i16 == 4) {
            if (i16 == 0) {
                int headerViewsCount = getHeaderViewsCount() + i3;
                this.f153893m = headerViewsCount;
                this.f153887j = headerViewsCount;
                this.f153889k = headerViewsCount;
                this.f153885i = headerViewsCount;
                View childAt = getChildAt(headerViewsCount - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.K = 1;
            this.A0 = f16;
            if (this.f153892l0) {
                int i17 = this.f153896o0;
                if (i17 == 1) {
                    super.onTouchEvent(this.f153895n0);
                } else if (i17 == 2) {
                    super.onInterceptTouchEvent(this.f153895n0);
                }
            }
            RemoveAnimator removeAnimator = this.f153905x0;
            if (removeAnimator != null) {
                removeAnimator.start();
            } else {
                a(i3);
            }
        }
    }

    public boolean stopDrag(boolean z16, float f16) {
        if (this.f153869a == null) {
            return false;
        }
        this.Q.stopScrolling(true);
        if (z16) {
            removeItem(this.f153893m - getHeaderViewsCount(), f16);
        } else {
            DropAnimator dropAnimator = this.f153906y0;
            if (dropAnimator != null) {
                dropAnimator.start();
            } else {
                g();
            }
        }
        if (this.f153900s0) {
            this.f153901t0.stopTracking();
        }
        return true;
    }

    public final int c(int i3) {
        View childAt = getChildAt(i3 - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return a(i3, b(i3));
    }

    public boolean startDrag(int i3, View view, int i16, int i17, int i18) {
        if (this.K != 0 || !this.f153892l0 || this.f153869a != null || view == null || !this.J) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = i3 + getHeaderViewsCount();
        this.f153887j = headerViewsCount;
        this.f153889k = headerViewsCount;
        this.f153893m = headerViewsCount;
        this.f153885i = headerViewsCount;
        this.K = 4;
        this.f153888j0 = i16 | 0;
        this.f153869a = view;
        h();
        this.C = i17;
        this.D = i18;
        int i19 = this.f153880f0;
        this.f153886i0 = i19;
        Point point = this.f153871b;
        point.x = this.f153878e0 - i17;
        point.y = i19 - i18;
        View childAt = getChildAt(this.f153893m - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.f153900s0) {
            this.f153901t0.startTracking();
        }
        int i26 = this.f153896o0;
        if (i26 == 1) {
            super.onTouchEvent(this.f153895n0);
        } else if (i26 == 2) {
            super.onInterceptTouchEvent(this.f153895n0);
        }
        requestLayout();
        return true;
    }

    public final void b() {
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.f153893m < firstVisiblePosition) {
            View childAt = getChildAt(0);
            setSelectionFromTop(firstVisiblePosition - 1, (childAt != null ? childAt.getTop() : 0) - getPaddingTop());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r8 <= r5) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(int i3, int i16) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i3 <= headerViewsCount || i3 >= getCount() - footerViewsCount) {
            return i16;
        }
        int dividerHeight = getDividerHeight();
        int i17 = this.M - this.L;
        int b16 = b(i3);
        int c16 = c(i3);
        int i18 = this.f153889k;
        int i19 = this.f153893m;
        if (i18 <= i19) {
            if (i3 != i18 || this.f153887j == i18) {
                if (i3 > i18) {
                }
            } else if (i3 == i19) {
                i16 += c16;
                i17 = this.M;
            } else {
                i16 += c16 - b16;
            }
            i16 -= i17;
        } else if (i3 > i19 && i3 <= this.f153887j) {
            i16 += i17;
        } else if (i3 == i18 && this.f153887j != i18) {
            i16 += c16 - b16;
        }
        if (i3 <= i19) {
            return i16 + (((this.M - dividerHeight) - b(i3 - 1)) / 2);
        }
        return i16 + (((b16 - dividerHeight) - this.M) / 2);
    }

    public static int a(SparseBooleanArray sparseBooleanArray, int i3, int i16, int[] iArr, int[] iArr2) {
        int keyAt;
        int a16 = a(sparseBooleanArray, i3, i16);
        if (a16 == -1) {
            return 0;
        }
        int keyAt2 = sparseBooleanArray.keyAt(a16);
        int i17 = keyAt2 + 1;
        int i18 = 0;
        for (int i19 = a16 + 1; i19 < sparseBooleanArray.size() && (keyAt = sparseBooleanArray.keyAt(i19)) < i16; i19++) {
            if (sparseBooleanArray.valueAt(i19)) {
                if (keyAt == i17) {
                    i17++;
                } else {
                    iArr[i18] = keyAt2;
                    iArr2[i18] = i17;
                    i18++;
                    i17 = keyAt + 1;
                    keyAt2 = keyAt;
                }
            }
        }
        if (i17 == i16) {
            i17 = i3;
        }
        iArr[i18] = keyAt2;
        iArr2[i18] = i17;
        int i26 = i18 + 1;
        if (i26 <= 1 || iArr[0] != i3) {
            return i26;
        }
        int i27 = i26 - 1;
        if (iArr2[i27] != i3) {
            return i26;
        }
        iArr[0] = iArr[i27];
        return i26 - 1;
    }

    public final void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.f153882g0 = this.f153878e0;
            this.f153884h0 = this.f153880f0;
        }
        this.f153878e0 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        this.f153880f0 = y16;
        if (action == 0) {
            this.f153882g0 = this.f153878e0;
            this.f153884h0 = y16;
        }
        this.E = ((int) motionEvent.getRawX()) - this.f153878e0;
        this.F = ((int) motionEvent.getRawY()) - this.f153880f0;
    }

    public final void d() {
        View view = this.f153869a;
        if (view != null) {
            view.setVisibility(8);
            FloatViewManager floatViewManager = this.f153894m0;
            if (floatViewManager != null) {
                floatViewManager.onDestroyFloatView(this.f153869a);
            }
            this.f153869a = null;
            invalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r2.keyAt(r3) < r4) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(SparseBooleanArray sparseBooleanArray, int i3, int i16) {
        int size = sparseBooleanArray.size();
        int a16 = a(sparseBooleanArray, i3);
        while (a16 < size && sparseBooleanArray.keyAt(a16) < i16 && !sparseBooleanArray.valueAt(a16)) {
            a16++;
        }
        return -1;
    }

    public final void b(int i3, int i16) {
        Point point = this.f153871b;
        point.x = i3 - this.C;
        point.y = i16 - this.D;
        a(true);
        int min = Math.min(i16, this.f153875d + this.N);
        int max = Math.max(i16, this.f153875d - this.N);
        int scrollDir = this.Q.getScrollDir();
        int i17 = this.f153884h0;
        if (min > i17 && min > this.U && scrollDir != 1) {
            if (scrollDir != -1) {
                this.Q.stopScrolling(true);
            }
            this.Q.startScrolling(1);
        } else if (max < i17 && max < this.T && scrollDir != 0) {
            if (scrollDir != -1) {
                this.Q.stopScrolling(true);
            }
            this.Q.startScrolling(0);
        } else {
            if (max < this.T || min > this.U || !this.Q.isScrolling()) {
                return;
            }
            this.Q.stopScrolling(true);
        }
    }

    public final void c() {
        this.f153893m = -1;
        this.f153887j = -1;
        this.f153889k = -1;
        this.f153885i = -1;
    }

    public static int a(SparseBooleanArray sparseBooleanArray, int i3) {
        int size = sparseBooleanArray.size();
        int i16 = 0;
        while (size - i16 > 0) {
            int i17 = (i16 + size) >> 1;
            if (sparseBooleanArray.keyAt(i17) < i3) {
                i16 = i17 + 1;
            } else {
                size = i17;
            }
        }
        return i16;
    }

    public final void a(int i3, Canvas canvas) {
        ViewGroup viewGroup;
        int i16;
        int i17;
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider == null || dividerHeight == 0 || (viewGroup = (ViewGroup) getChildAt(i3 - getFirstVisiblePosition())) == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = viewGroup.getChildAt(0).getHeight();
        if (i3 > this.f153893m) {
            i17 = viewGroup.getTop() + height;
            i16 = dividerHeight + i17;
        } else {
            int bottom = viewGroup.getBottom() - height;
            int i18 = bottom - dividerHeight;
            i16 = bottom;
            i17 = i18;
        }
        canvas.save();
        canvas.clipRect(paddingLeft, i17, width, i16);
        divider.setBounds(paddingLeft, i17, width, i16);
        divider.draw(canvas);
        canvas.restore();
    }

    public final void c(int i3, View view, boolean z16) {
        this.f153902u0 = true;
        i();
        int i16 = this.f153887j;
        int i17 = this.f153889k;
        boolean j3 = j();
        if (j3) {
            a();
            setSelectionFromTop(i3, (view.getTop() + a(i3, view, i16, i17)) - getPaddingTop());
            layoutChildren();
        }
        if (j3 || z16) {
            invalidate();
        }
        this.f153902u0 = false;
    }

    public final int b(int i3) {
        View view;
        if (i3 == this.f153893m) {
            return 0;
        }
        View childAt = getChildAt(i3 - getFirstVisiblePosition());
        if (childAt != null) {
            return d(i3, childAt, false);
        }
        int i16 = this.f153904w0.get(i3);
        if (i16 != -1) {
            return i16;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i3);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.P.length) {
            this.P = new View[viewTypeCount];
        }
        if (itemViewType >= 0) {
            View view2 = this.P[itemViewType];
            if (view2 == null) {
                view = adapter.getView(i3, null, this);
                this.P[itemViewType] = view;
            } else {
                view = adapter.getView(i3, view2, this);
            }
        } else {
            view = adapter.getView(i3, null, this);
        }
        int d16 = d(i3, view, true);
        this.f153904w0.add(i3, d16);
        return d16;
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        float f16;
        this.f153871b = new Point();
        this.f153873c = new Point();
        this.f153877e = false;
        this.f153881g = 1.0f;
        this.f153883h = 1.0f;
        this.f153891l = false;
        this.J = true;
        this.K = 0;
        this.L = 1;
        this.O = 0;
        this.P = new View[1];
        this.R = 0.33333334f;
        this.S = 0.33333334f;
        this.f153874c0 = 0.5f;
        this.f153876d0 = new DragScrollProfile() { // from class: com.tencent.mm.ui.widget.sortlist.DragSortListView.1
            @Override // com.tencent.mm.ui.widget.sortlist.DragSortListView.DragScrollProfile
            public float getSpeed(float f17, long j3) {
                return DragSortListView.this.f153874c0 * f17;
            }
        };
        this.f153888j0 = 0;
        this.f153890k0 = false;
        this.f153892l0 = false;
        this.f153894m0 = null;
        this.f153896o0 = 0;
        this.f153897p0 = 0.25f;
        this.f153898q0 = 0.0f;
        this.f153900s0 = false;
        this.f153902u0 = false;
        this.f153903v0 = false;
        this.f153904w0 = new HeightCache(3);
        this.A0 = 0.0f;
        this.B0 = false;
        this.C0 = false;
        int i16 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.DragSortListView, 0, 0);
            this.L = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(R.styleable.DragSortListView_collapsed_height, 1));
            boolean z16 = obtainStyledAttributes.getBoolean(R.styleable.DragSortListView_track_drag_sort, false);
            this.f153900s0 = z16;
            if (z16) {
                this.f153901t0 = new DragSortTracker();
            }
            float f17 = obtainStyledAttributes.getFloat(R.styleable.DragSortListView_float_alpha, this.f153881g);
            this.f153881g = f17;
            this.f153883h = f17;
            this.J = obtainStyledAttributes.getBoolean(R.styleable.DragSortListView_drag_enabled, this.J);
            float max = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(R.styleable.DragSortListView_slide_shuffle_speed, 0.75f)));
            this.f153897p0 = max;
            this.f153891l = max > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(R.styleable.DragSortListView_drag_scroll_start, this.R));
            this.f153874c0 = obtainStyledAttributes.getFloat(R.styleable.DragSortListView_max_drag_scroll_speed, this.f153874c0);
            int i17 = obtainStyledAttributes.getInt(R.styleable.DragSortListView_remove_animation_duration, 150);
            i3 = obtainStyledAttributes.getInt(R.styleable.DragSortListView_drop_animation_duration, 150);
            if (obtainStyledAttributes.getBoolean(R.styleable.DragSortListView_use_default_controller, true)) {
                boolean z17 = obtainStyledAttributes.getBoolean(R.styleable.DragSortListView_remove_enabled, false);
                int i18 = obtainStyledAttributes.getInt(R.styleable.DragSortListView_remove_mode, 1);
                boolean z18 = obtainStyledAttributes.getBoolean(R.styleable.DragSortListView_sort_enabled, true);
                int i19 = obtainStyledAttributes.getInt(R.styleable.DragSortListView_drag_start_mode, 0);
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.DragSortListView_drag_handle_id, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.DragSortListView_fling_handle_id, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.DragSortListView_click_remove_id, 0);
                int color = obtainStyledAttributes.getColor(R.styleable.DragSortListView_float_background_color, -16777216);
                DragSortController dragSortController = new DragSortController(this, resourceId, i19, i18, resourceId3, resourceId2);
                dragSortController.setRemoveEnabled(z17);
                dragSortController.setSortEnabled(z18);
                dragSortController.setBackgroundColor(color);
                this.f153894m0 = dragSortController;
                setOnTouchListener(dragSortController);
            }
            obtainStyledAttributes.recycle();
            i16 = i17;
        } else {
            i3 = 150;
        }
        this.Q = new DragScroller();
        if (i16 > 0) {
            f16 = 0.5f;
            this.f153905x0 = new RemoveAnimator(f16, i16);
        } else {
            f16 = 0.5f;
        }
        if (i3 > 0) {
            this.f153906y0 = new DropAnimator(f16, i3);
        }
        this.f153895n0 = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.f153879f = new DataSetObserver() { // from class: com.tencent.mm.ui.widget.sortlist.DragSortListView.3
            public final void a() {
                if (DragSortListView.this.K == 4) {
                    DragSortListView.this.cancelDrag();
                }
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                a();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                a();
            }
        };
    }

    public final void a(int i3) {
        this.K = 1;
        RemoveListener removeListener = this.I;
        if (removeListener != null) {
            removeListener.remove(i3);
        }
        d();
        b();
        c();
        if (this.f153892l0) {
            this.K = 3;
        } else {
            this.K = 0;
        }
    }

    public final void a() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int min = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= min; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    public final int b(int i3, View view, boolean z16) {
        return a(i3, d(i3, view, z16));
    }

    public final void a(int i3, View view, boolean z16) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int b16 = (i3 == this.f153893m || i3 == this.f153887j || i3 == this.f153889k) ? b(i3, view, z16) : -2;
        if (b16 != layoutParams.height) {
            layoutParams.height = b16;
            view.setLayoutParams(layoutParams);
        }
        if (i3 == this.f153887j || i3 == this.f153889k) {
            int i16 = this.f153893m;
            if (i3 < i16) {
                ((DragSortItemView) view).setGravity(80);
            } else if (i3 > i16) {
                ((DragSortItemView) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        int i17 = (i3 != this.f153893m || this.f153869a == null) ? 0 : 4;
        if (i17 != visibility) {
            view.setVisibility(i17);
        }
    }

    public final int a(int i3, int i16) {
        boolean z16 = this.f153891l && this.f153887j != this.f153889k;
        int i17 = this.M;
        int i18 = this.L;
        int i19 = i17 - i18;
        int i26 = (int) (this.f153898q0 * i19);
        int i27 = this.f153893m;
        return i3 == i27 ? i27 == this.f153887j ? z16 ? i26 + i18 : i17 : i27 == this.f153889k ? i17 - i26 : i18 : i3 == this.f153887j ? z16 ? i16 + i26 : i16 + i19 : i3 == this.f153889k ? (i16 + i19) - i26 : i16;
    }

    public final int a(int i3, View view, int i16, int i17) {
        int i18;
        int i19;
        int b16 = b(i3);
        int height = view.getHeight();
        int a16 = a(i3, b16);
        int i26 = this.f153893m;
        if (i3 != i26) {
            i18 = height - b16;
            i19 = a16 - b16;
        } else {
            i18 = height;
            i19 = a16;
        }
        int i27 = this.M;
        int i28 = this.f153887j;
        if (i26 != i28 && i26 != this.f153889k) {
            i27 -= this.L;
        }
        if (i3 <= i16) {
            if (i3 > i28) {
                return 0 + (i27 - i19);
            }
            return 0;
        }
        if (i3 == i17) {
            if (i3 <= i28) {
                i18 -= i27;
            } else if (i3 == this.f153889k) {
                return 0 + (height - a16);
            }
            return 0 + i18;
        }
        if (i3 <= i28) {
            return 0 - i27;
        }
        if (i3 == this.f153889k) {
            return 0 - i19;
        }
        return 0;
    }

    public final void a(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.O, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    public boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1) {
            if (this.K == 4) {
                stopDrag(false);
            }
            e();
        } else if (action == 2) {
            b((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 3) {
            if (this.K == 4) {
                cancelDrag();
            }
            e();
        }
        return true;
    }

    public final void a(boolean z16) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            return;
        }
        c(firstVisiblePosition, childAt, z16);
    }
}
