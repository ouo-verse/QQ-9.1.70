package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class QAVPtvTemplateAdapter extends BaseAdapter {
    public static int N;
    public static int P;
    public static int Q;
    AppInterface C;
    protected volatile int D;
    protected int E;
    iw.a F;
    iw.b G;
    public boolean H;
    float I;
    private View J;
    long K;
    private QavListItemBase.a L;
    private QavListItemBase.b M;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<QavListItemBase.c> f74996d;

    /* renamed from: e, reason: collision with root package name */
    public Context f74997e;

    /* renamed from: f, reason: collision with root package name */
    private Resources f74998f;

    /* renamed from: h, reason: collision with root package name */
    boolean f74999h;

    /* renamed from: i, reason: collision with root package name */
    HorizontalListView f75000i;

    /* renamed from: m, reason: collision with root package name */
    boolean f75001m;

    /* loaded from: classes3.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            if (i18 - i16 != i28 - i26) {
                QAVPtvTemplateAdapter.this.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements HorizontalListView.OnScrollStateChangedListener {
        b() {
        }

        @Override // com.tencent.widget.HorizontalListView.OnScrollStateChangedListener
        public void onScrollStateChanged(int i3) {
            iw.a aVar;
            if (i3 == 4097 && (aVar = QAVPtvTemplateAdapter.this.F) != null) {
                aVar.c(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends AccessibilityDelegateCompat {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f75009e;

        c(int i3) {
            this.f75009e = i3;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            boolean z16 = true;
            accessibilityNodeInfoCompat.setCheckable(true);
            if (this.f75009e != QAVPtvTemplateAdapter.this.D) {
                z16 = false;
            }
            accessibilityNodeInfoCompat.setChecked(z16);
        }
    }

    /* loaded from: classes3.dex */
    class d implements QavListItemBase.a {
        d() {
        }

        @Override // com.tencent.av.ui.QavListItemBase.a
        public void a(long j3, int i3, QavListItemBase qavListItemBase) {
            boolean z16;
            if (System.currentTimeMillis() - QAVPtvTemplateAdapter.this.K < 500 && i3 > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.w("QAVPtvTemplateAdapter", 1, "onItemClicked begin, position[" + i3 + "], mCurSelectedPosition[" + QAVPtvTemplateAdapter.this.D + "], ignore[" + z16 + "], seq[" + j3 + "]");
            }
            if (z16) {
                return;
            }
            QLog.w("QAVPtvTemplateAdapter", 1, "onItemClicked valid, position[" + i3 + "], mCurSelectedPosition[" + QAVPtvTemplateAdapter.this.D + "], seq[" + j3 + "]");
            QAVPtvTemplateAdapter.this.K = System.currentTimeMillis();
            int i16 = QAVPtvTemplateAdapter.this.D;
            QAVPtvTemplateAdapter.this.D = i3;
            QAVPtvTemplateAdapter qAVPtvTemplateAdapter = QAVPtvTemplateAdapter.this;
            qAVPtvTemplateAdapter.E = i3;
            qAVPtvTemplateAdapter.l(i16, qAVPtvTemplateAdapter.D);
            QAVPtvTemplateAdapter qAVPtvTemplateAdapter2 = QAVPtvTemplateAdapter.this;
            qAVPtvTemplateAdapter2.a(qAVPtvTemplateAdapter2.D);
            QAVPtvTemplateAdapter qAVPtvTemplateAdapter3 = QAVPtvTemplateAdapter.this;
            qAVPtvTemplateAdapter3.b(j3, qAVPtvTemplateAdapter3.D);
            QAVPtvTemplateAdapter qAVPtvTemplateAdapter4 = QAVPtvTemplateAdapter.this;
            if (qAVPtvTemplateAdapter4.F != null) {
                QAVPtvTemplateAdapter.this.F.d(qAVPtvTemplateAdapter4.f74996d.get(i3));
            }
        }
    }

    /* loaded from: classes3.dex */
    class e implements QavListItemBase.b {
        e() {
        }

        @Override // com.tencent.av.ui.QavListItemBase.b
        public void s(long j3, String str, boolean z16) {
            QAVPtvTemplateAdapter.this.g(j3, str, z16);
        }
    }

    public QAVPtvTemplateAdapter(AppInterface appInterface, Context context, ArrayList<QavListItemBase.c> arrayList, HorizontalListView horizontalListView) {
        this(appInterface, context, arrayList, horizontalListView, 6.25f);
    }

    public static int d(Resources resources, float f16) {
        return (int) ((resources.getDisplayMetrics().widthPixels / f16) + 0.5f);
    }

    public static int e(Resources resources, float f16, float f17) {
        return (int) (((resources.getDisplayMetrics().widthPixels / f16) * f17) + 0.5f);
    }

    void a(int i3) {
        int i16;
        if (this.f75000i.getFirstVisiblePosition() >= i3) {
            this.f75000i.smoothScrollToPositionFromLeftOrRight(i3, 0, 200);
            return;
        }
        if (this.f75000i.getLastVisiblePosition() <= i3) {
            View child = this.f75000i.getChild(i3);
            if (child == null || child.getRight() > this.f75000i.getRight()) {
                if (i3 == getCount() - 1) {
                    i16 = this.f74998f.getDisplayMetrics().widthPixels - N;
                } else {
                    i16 = N * 5;
                }
                this.f75000i.smoothScrollToPositionFromLeftOrRight(i3, -i16, 200);
            }
        }
    }

    protected void b(long j3, int i3) {
        if (i3 >= 0 && this.f74996d.size() > i3) {
            QavListItemBase.c cVar = this.f74996d.get(i3);
            if (!TextUtils.isEmpty(cVar.f75024a) && !cVar.f75024a.equals("0")) {
                if (cVar.f75027d) {
                    i(j3, cVar);
                    return;
                }
                if (!cVar.f75028e && !TextUtils.isEmpty(cVar.f75024a)) {
                    iw.b bVar = this.G;
                    if (bVar != null) {
                        bVar.startDownloadTemplate(this.C, j3, cVar, this.M);
                        cVar.f75028e = true;
                        return;
                    }
                    throw new IllegalArgumentException("mIItemDownloadMgr is null, pealse call setItemDownloadMgr");
                }
                return;
            }
            i(j3, cVar);
        }
    }

    public float c() {
        return this.I;
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public QavListItemBase.c getItem(int i3) {
        if (i3 >= 0 && i3 < this.f74996d.size()) {
            return this.f74996d.get(i3);
        }
        return null;
    }

    public void g(final long j3, final String str, final boolean z16) {
        this.f75000i.post(new Runnable() { // from class: com.tencent.av.ui.QAVPtvTemplateAdapter.6
            @Override // java.lang.Runnable
            public void run() {
                QavListItemBase.c cVar;
                int i3;
                int firstVisiblePosition = QAVPtvTemplateAdapter.this.f75000i.getFirstVisiblePosition();
                int lastVisiblePosition = QAVPtvTemplateAdapter.this.f75000i.getLastVisiblePosition();
                int i16 = 0;
                while (true) {
                    if (i16 < QAVPtvTemplateAdapter.this.f74996d.size()) {
                        QavListItemBase.c cVar2 = QAVPtvTemplateAdapter.this.f74996d.get(i16);
                        if (cVar2 != null && cVar2.f75024a.equals(str)) {
                            cVar2.f75028e = false;
                            cVar2.f75027d = z16;
                            if (i16 >= firstVisiblePosition && i16 <= lastVisiblePosition) {
                                View childAt = QAVPtvTemplateAdapter.this.f75000i.getChildAt(i16 - firstVisiblePosition);
                                if ((childAt instanceof QavListItemBase) && QAVPtvTemplateAdapter.this.f75000i.getAdapter().equals(QAVPtvTemplateAdapter.this)) {
                                    QavListItemBase qavListItemBase = (QavListItemBase) childAt;
                                    if (z16) {
                                        i3 = 1000;
                                    } else {
                                        i3 = -1;
                                    }
                                    qavListItemBase.f(i3);
                                }
                            }
                        } else {
                            i16++;
                        }
                    } else {
                        i16 = -1;
                        break;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("QAVPtvTemplateAdapter", 2, "onDownloadFinish, seq[" + j3 + "], id[" + str + "], suc[" + z16 + "], sel[" + QAVPtvTemplateAdapter.this.D + "]");
                }
                if (z16) {
                    if (QAVPtvTemplateAdapter.this.D == i16 && i16 != -1) {
                        cVar = QAVPtvTemplateAdapter.this.f74996d.get(i16);
                    } else {
                        cVar = null;
                    }
                    if (cVar != null) {
                        QAVPtvTemplateAdapter.this.i(j3, cVar);
                    }
                }
            }
        });
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f74996d.isEmpty()) {
            return 0;
        }
        return this.f74996d.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        QavListItemBase qavListItemBase;
        boolean z16;
        boolean z17;
        QavListItemBase qavListItemBase2;
        View view2;
        View view3;
        QavListItemBase.c item = getItem(i3);
        View view4 = null;
        view4 = null;
        if (item == null) {
            p(view, null, i3);
            view3 = view;
        } else if ("-1".equals(item.f75024a)) {
            if (view != null && view.getId() == Integer.valueOf(item.f75024a).intValue()) {
                view4 = view;
            }
            if (view4 == null && (view2 = this.J) != null) {
                view4 = view2;
            }
            if (view4 == null) {
                view4 = new View(this.f74997e);
                view4.setId(Integer.valueOf(item.f75024a).intValue());
                view4.setLayoutParams(new AbsListView.LayoutParams(P, -1));
                this.J = view4;
            }
            view3 = view4;
            if (com.tencent.av.utils.e.e(0) == 1) {
                view4.setBackgroundColor(-256);
                view3 = view4;
            }
        } else {
            if (!(view instanceof QavListItemBase)) {
                if (item.f75029f == 2) {
                    qavListItemBase2 = new VoiceChangeItemView2(this.f74997e);
                } else {
                    QavPtvTemplateItemView qavPtvTemplateItemView = new QavPtvTemplateItemView(this.f74997e);
                    qavPtvTemplateItemView.F = this.H;
                    qavListItemBase2 = qavPtvTemplateItemView;
                    if (this.I < 6.0f) {
                        View findViewById = qavPtvTemplateItemView.findViewById(R.id.f166586gb3);
                        qavListItemBase2 = qavPtvTemplateItemView;
                        if (findViewById instanceof LinearLayout) {
                            ((LinearLayout) findViewById).setGravity(49);
                            qavListItemBase2 = qavPtvTemplateItemView;
                        }
                    }
                }
                qavListItemBase2.e(N, Q);
                qavListItemBase = qavListItemBase2;
            } else {
                qavListItemBase = (QavListItemBase) view;
            }
            QavListItemBase qavListItemBase3 = qavListItemBase;
            if (com.tencent.av.utils.e.e(0) == 1) {
                qavListItemBase3.c(item, i3);
                this.f75000i.setBackgroundColor(-1);
                QLog.w("QAVPtvTemplateAdapter", 1, "getView, itemView[" + qavListItemBase3.hashCode() + "], mListView[" + this.f75000i.hashCode() + "], position[" + i3 + "], getPosition[" + qavListItemBase3.d() + "], mFullItemWidth[" + N + "], mListViewHeight[" + Q + "], mListView.Height[" + this.f75000i.getMeasuredHeight() + "|" + this.f75000i.getHeight() + "], itemView.Height[" + qavListItemBase3.getMeasuredHeight() + "|" + qavListItemBase3.getHeight() + "], info[" + item + "]");
            }
            qavListItemBase3.g(N, Q);
            if (i3 == this.D) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this.f74999h && z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            QavListItemBase qavListItemBase4 = qavListItemBase3;
            qavListItemBase4.b(i3, z17, this.f75001m, item, this.L);
            p(qavListItemBase3, item, i3);
            view3 = qavListItemBase4;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view3;
    }

    public void h(String str, int i3) {
        q(str, i3);
    }

    void i(long j3, QavListItemBase.c cVar) {
        if (this.F == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.f75024a) || cVar.f75024a.equals("0") || cVar.f75027d) {
            this.F.b(j3, cVar);
        }
    }

    public void j(iw.a aVar) {
        this.F = aVar;
    }

    public void k(iw.b bVar) {
        this.G = bVar;
    }

    void l(int i3, int i16) {
        if (this.f74999h) {
            View child = this.f75000i.getChild(i3);
            View child2 = this.f75000i.getChild(i16);
            if (i16 != i3 && child != null && (child instanceof QavListItemBase)) {
                ((QavListItemBase) child).setHighlight(false);
            }
            if (child2 != null && (child2 instanceof QavListItemBase)) {
                ((QavListItemBase) child2).setHighlight(true);
            }
        }
    }

    public void m(boolean z16) {
        this.f74999h = z16;
    }

    public void n(boolean z16) {
        this.f75001m = z16;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.J = null;
        super.notifyDataSetChanged();
    }

    public boolean o(int i3) {
        boolean z16;
        int i16 = this.D;
        int size = this.f74996d.size();
        if (this.D != i3 && i3 >= 0 && i3 < size) {
            this.D = i3;
            notifyDataSetChanged();
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.w("QAVPtvTemplateAdapter", 1, "setSelectedIndex, ret[" + z16 + "], index[" + i3 + "], mCurSelectedPosition[" + i16 + "->" + this.D + "], size[" + size + "]");
        return z16;
    }

    void p(View view, QavListItemBase.c cVar, int i3) {
        View findViewById;
        String str;
        if (view != null && (findViewById = view.findViewById(R.id.f166567g81)) != null && cVar != null) {
            if (TextUtils.equals("0", cVar.f75024a)) {
                findViewById.setContentDescription(cVar.f75034k);
            } else {
                if (cVar.f75027d) {
                    str = "\u5df2\u4e0b\u8f7d";
                } else {
                    str = "\u672a\u4e0b\u8f7d";
                }
                findViewById.setContentDescription(str + cVar.f75034k);
            }
            ViewCompat.setAccessibilityDelegate(findViewById, new c(i3));
        }
    }

    public void q(final String str, final int i3) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.ui.QAVPtvTemplateAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                QAVPtvTemplateAdapter.this.r(str, i3);
            }
        });
    }

    void r(String str, int i3) {
        QavListItemBase.c cVar;
        QavListItemBase qavListItemBase;
        int firstVisiblePosition = this.f75000i.getFirstVisiblePosition();
        int lastVisiblePosition = this.f75000i.getLastVisiblePosition();
        int i16 = firstVisiblePosition;
        while (true) {
            cVar = null;
            r3 = null;
            QavListItemBase qavListItemBase2 = null;
            if (i16 > lastVisiblePosition) {
                break;
            }
            if (i16 >= 0) {
                if (i16 >= this.f74996d.size()) {
                    break;
                }
                QavListItemBase.c cVar2 = this.f74996d.get(i16);
                if (cVar2 != null && cVar2.f75024a.equals(str)) {
                    View childAt = this.f75000i.getChildAt(i16 - firstVisiblePosition);
                    if ((childAt instanceof QavListItemBase) && this.f75000i.getAdapter().equals(this)) {
                        qavListItemBase2 = (QavListItemBase) childAt;
                    }
                    qavListItemBase = qavListItemBase2;
                    cVar = cVar2;
                }
            }
            i16++;
        }
        qavListItemBase = null;
        if (cVar == null && i3 == 101) {
            int size = this.f74996d.size();
            int i17 = 0;
            while (true) {
                if (i17 >= firstVisiblePosition || i17 >= size) {
                    break;
                }
                QavListItemBase.c cVar3 = this.f74996d.get(i17);
                if (cVar3 != null && cVar3.f75024a.equals(str)) {
                    i16 = i17;
                    cVar = cVar3;
                    break;
                }
                i17++;
            }
            if (cVar == null) {
                int i18 = lastVisiblePosition + 1;
                while (true) {
                    if (i18 < size) {
                        QavListItemBase.c cVar4 = this.f74996d.get(i18);
                        if (cVar4 != null && cVar4.f75024a.equals(str)) {
                            cVar = cVar4;
                            i16 = i18;
                            break;
                        }
                        i18++;
                    } else {
                        break;
                    }
                }
            }
        }
        if (cVar != null) {
            if (QLog.isColorLevel()) {
                QLog.i("PtvTemplateManager", 2, String.format("onProgressUpdate, index[%s], [%s][%s], progress[%s]", Integer.valueOf(i16), cVar.f75024a, cVar.f75026c, Integer.valueOf(i3)));
            }
            if (i3 == -1) {
                cVar.f75028e = false;
            } else if (i3 == 101) {
                cVar.f75028e = false;
                cVar.f75027d = true;
            } else {
                if (i3 == 100) {
                    i3 = 99;
                }
                cVar.f75028e = true;
            }
            if (qavListItemBase != null) {
                qavListItemBase.f(i3);
            }
        }
    }

    public void s(ArrayList<QavListItemBase.c> arrayList) {
        this.f74996d.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f74996d.addAll(arrayList);
        }
    }

    public QAVPtvTemplateAdapter(AppInterface appInterface, Context context, ArrayList<QavListItemBase.c> arrayList, HorizontalListView horizontalListView, float f16) {
        this.f74996d = new ArrayList<>();
        this.f74999h = false;
        this.f75001m = true;
        this.D = -1;
        this.E = -1;
        this.H = false;
        this.J = null;
        this.K = 0L;
        this.L = new d();
        this.M = new e();
        this.C = appInterface;
        this.f74997e = context;
        this.f74998f = context.getResources();
        this.f75000i = horizontalListView;
        this.I = f16;
        s(arrayList);
        N = d(this.f74998f, c());
        P = e(this.f74998f, c(), 0.16666667f);
        Q = N + BaseAIOUtils.f(30.0f, this.f74998f);
        if (this.I < 6.0f) {
            Q = this.f74998f.getDimensionPixelSize(R.dimen.b9o);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QAVPtvTemplateAdapter", 4, "init, w[" + N + "], h[" + Q + "], half[" + P + "]");
        }
        this.f75000i.addOnLayoutChangeListener(new a());
        this.f75000i.setOnScrollStateChangedListener(new b());
        ViewGroup.LayoutParams layoutParams = this.f75000i.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = Q;
        this.f75000i.setLayoutParams(layoutParams);
    }
}
