package com.qzone.widget;

import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.widget.EmoEditPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;

/* loaded from: classes37.dex */
public class EditPositionBag implements EmoEditPanel.ak {

    /* renamed from: s, reason: collision with root package name */
    private static EditPositionBag f60215s;

    /* renamed from: t, reason: collision with root package name */
    private static int f60216t = (int) (u5.a.a() * 8.0f);

    /* renamed from: u, reason: collision with root package name */
    private static SparseArray<EditPositionBag> f60217u;

    /* renamed from: a, reason: collision with root package name */
    private int f60218a;

    /* renamed from: b, reason: collision with root package name */
    private int f60219b;

    /* renamed from: c, reason: collision with root package name */
    private int f60220c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f60221d = new Handler();

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<ListView> f60222e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference<QZonePullToRefreshListView> f60223f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f60224g;

    /* renamed from: h, reason: collision with root package name */
    private int f60225h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f60226i;

    /* renamed from: j, reason: collision with root package name */
    public int f60227j;

    /* renamed from: k, reason: collision with root package name */
    public int f60228k;

    /* renamed from: l, reason: collision with root package name */
    public int f60229l;

    /* renamed from: m, reason: collision with root package name */
    public int f60230m;

    /* renamed from: n, reason: collision with root package name */
    public int f60231n;

    /* renamed from: o, reason: collision with root package name */
    public int f60232o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f60233p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f60234q;

    /* renamed from: r, reason: collision with root package name */
    private int f60235r;

    public static EditPositionBag g() {
        return new EditPositionBag();
    }

    public static EditPositionBag h(int i3) {
        EditPositionBag editPositionBag;
        if (f60217u == null) {
            f60217u = new SparseArray<>();
        }
        if (f60217u.get(i3) == null) {
            try {
                editPositionBag = g();
            } catch (Exception e16) {
                e16.printStackTrace();
                editPositionBag = null;
            }
            if (editPositionBag != null) {
                f60217u.put(i3, editPositionBag);
            }
        }
        return f60217u.get(i3);
    }

    private ListView k() {
        WeakReference<ListView> weakReference = this.f60222e;
        if (weakReference == null) {
            QLog.e("EditPositionBag", 1, "getListView  mListView == null");
            return null;
        }
        return weakReference.get();
    }

    private QZonePullToRefreshListView m() {
        WeakReference<QZonePullToRefreshListView> weakReference = this.f60223f;
        if (weakReference == null) {
            QLog.e("EditPositionBag", 1, "QZonePullToRefreshListView  mRefreshListView == null");
            return null;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = weakReference.get();
        QLog.i("EditPositionBag", 1, "QZonePullToRefreshListView  refreshListView = " + qZonePullToRefreshListView);
        return qZonePullToRefreshListView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ListView k3 = k();
        if (k3 == null) {
            return;
        }
        if (!this.f60233p) {
            k3.smoothScrollToPositionFromTop(this.f60218a, this.f60219b);
        } else {
            k3.setSelectionFromTop(this.f60218a, this.f60219b);
        }
    }

    public static void q(int i3) {
        SparseArray<EditPositionBag> sparseArray = f60217u;
        if (sparseArray == null) {
            return;
        }
        if (i3 <= 0) {
            sparseArray.clear();
        } else {
            sparseArray.remove(i3);
        }
    }

    @Override // com.qzone.widget.EmoEditPanel.ak
    public void a(int i3) {
        if (k() == null || f60215s != this) {
            return;
        }
        final int i16 = i3 - this.f60230m;
        Handler handler = this.f60221d;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.qzone.widget.EditPositionBag.1
                @Override // java.lang.Runnable
                public void run() {
                    EditPositionBag.this.p(i16);
                }
            });
        } else {
            p(i16);
        }
    }

    public void e(int i3, View view, int i16, int i17) {
        int n3;
        int i18;
        f60215s = this;
        this.f60218a = i3;
        this.f60231n = i16;
        this.f60232o = i17;
        QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) l(view);
        int i19 = 0;
        this.f60233p = false;
        this.f60226i = false;
        if (i16 == 0) {
            n3 = n(view) + view.getHeight();
            int cellCommentViewBottom = com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().getCellCommentViewBottom(view);
            if (cellCommentViewBottom != 0) {
                n3 = n(view) + cellCommentViewBottom;
            }
            View i26 = i(view);
            if (i26 != null) {
                i18 = i26.getTop();
                this.f60225h = i26.getHeight();
            } else {
                i18 = 0;
            }
            if (qZonePullToRefreshListView != null) {
                Object parent = qZonePullToRefreshListView.getParent();
                if (parent != null && (parent instanceof View)) {
                    i19 = ((View) parent).getTop();
                }
                this.f60229l = qZonePullToRefreshListView.getTop() + i19;
            }
        } else if (i16 == 1) {
            View i27 = i(view);
            if (i27 != null) {
                n3 = i27.getHeight() - f60216t;
                i18 = i27.getTop();
                this.f60225h = i27.getHeight();
            } else {
                n3 = 0;
                i18 = 0;
            }
            if (qZonePullToRefreshListView != null) {
                Object parent2 = qZonePullToRefreshListView.getParent();
                if (parent2 != null && (parent2 instanceof View)) {
                    i19 = ((View) parent2).getTop();
                }
                this.f60229l = qZonePullToRefreshListView.getTop() + i19;
            }
        } else if (i16 == 2) {
            View i28 = i(view);
            if (i28 != null) {
                n3 = i28.getHeight() - f60216t;
                i18 = i28.getTop();
                this.f60225h = i28.getHeight();
            } else {
                n3 = 0;
                i18 = 0;
            }
            if (qZonePullToRefreshListView != null) {
                Object parent3 = qZonePullToRefreshListView.getParent();
                if (parent3 != null && (parent3 instanceof View)) {
                    i19 = ((View) parent3).getTop();
                }
                this.f60229l = (qZonePullToRefreshListView.getTop() + i19) - ((int) (u5.a.a() * 43.0f));
            }
        } else {
            n3 = 0;
            this.f60219b = i19;
            this.f60220c = n3;
        }
        i19 = i18;
        this.f60219b = i19;
        this.f60220c = n3;
    }

    public void f() {
        if (this.f60231n == 0) {
            this.f60219b = (u5.a.c() / 2) - this.f60225h;
            this.f60226i = true;
        }
    }

    public int j() {
        int indexOfValue;
        SparseArray<EditPositionBag> sparseArray = f60217u;
        if (sparseArray != null && (indexOfValue = sparseArray.indexOfValue(this)) >= 0 && indexOfValue < f60217u.size()) {
            return f60217u.keyAt(indexOfValue);
        }
        return 0;
    }

    @Override // com.qzone.widget.EmoEditPanel.ak
    public void onHide() {
        if (f60215s != this) {
            return;
        }
        QZonePullToRefreshListView m3 = m();
        if (m3 != null && this.f60224g) {
            m3.scrollTo(0, 0);
        }
        this.f60224g = false;
        f60215s = null;
        if (k() == null || !this.f60226i) {
            return;
        }
        Handler handler = this.f60221d;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.qzone.widget.EditPositionBag.2
                @Override // java.lang.Runnable
                public void run() {
                    EditPositionBag.this.o();
                }
            });
        } else {
            o();
        }
        this.f60226i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        this.f60224g = false;
        this.f60234q = false;
        this.f60235r = (((i3 - this.f60220c) - this.f60228k) - this.f60229l) + this.f60232o;
        ListView k3 = k();
        if (k3 != null) {
            k3.setSelectionFromTop(this.f60218a, this.f60235r);
        }
        this.f60234q = true;
    }

    public void d(int i3, View view, int i16) {
        e(i3, view, i16, 0);
    }

    private View i(View view) {
        if (view == null) {
            return null;
        }
        while (!(view instanceof QZonePullToRefreshListView)) {
            if (this.f60227j == 0 && (view instanceof AbsFeedView)) {
                return view;
            }
            Object parent = view.getParent();
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    private View l(View view) {
        if (view == null) {
            return null;
        }
        while (!(view instanceof QZonePullToRefreshListView)) {
            Object parent = view.getParent();
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return view;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0020, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int n(View view) {
        int i3 = 0;
        if (view == null) {
            return 0;
        }
        while (true) {
            if (this.f60227j == 0 && (view instanceof AbsFeedView)) {
                return i3;
            }
            i3 += view.getTop();
            Object parent = view.getParent();
            if (parent == null || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
    }
}
