package com.qzone.homepage.ui.component.newpanel;

import NS_MOBILE_MAIN_PAGE.s_tab_list;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f implements IQZoneServiceListener {
    private TextView C;
    private ImageView D;
    private TextView E;
    private ImageView F;
    private TextView G;
    private TextView H;
    private x6.a I;
    private PanelPopupAdapter J;
    private PanelPopupAdapter K;
    private ArrayList<HomePanelItem> L;
    private ArrayList<HomePanelItem> M;
    private ArrayList<HomePanelItem> N;
    private ArrayList<HomePanelItem> P;
    private ListView Q;
    private ListView R;
    private ScrollView S;
    private boolean T = false;
    private com.qzone.homepage.ui.component.newpanel.i U = new a();

    /* renamed from: d, reason: collision with root package name */
    private long f47764d;

    /* renamed from: e, reason: collision with root package name */
    private long f47765e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f47766f;

    /* renamed from: h, reason: collision with root package name */
    private QUSHalfScreenFloatingView f47767h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f47768i;

    /* renamed from: m, reason: collision with root package name */
    private View f47769m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements j {
        b() {
        }

        @Override // com.qzone.homepage.ui.component.newpanel.j
        public void a(PanelPopupAdapter panelPopupAdapter, int i3, int i16) {
            f.this.v(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements j {
        c() {
        }

        @Override // com.qzone.homepage.ui.component.newpanel.j
        public void a(PanelPopupAdapter panelPopupAdapter, int i3, int i16) {
            f.this.u(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f.this.o();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (f.this.T) {
                LpReportInfo_pf00064.allReport(128, 2, 2);
            } else {
                LpReportInfo_pf00064.allReport(127, 8, 2);
            }
            if (f.this.T) {
                f.this.n();
            } else {
                f.this.T = !r0.T;
                f fVar = f.this;
                fVar.D(fVar.T, true);
                f.this.f47766f = false;
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qzone.homepage.ui.component.newpanel.f$f, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public class ViewOnClickListenerC0395f implements View.OnClickListener {
        ViewOnClickListenerC0395f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            f.this.n();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g extends com.tencent.mobileqq.widget.qus.e {
        g() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF52508d() {
            return f.this.f47769m;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h extends HdAsyncAction {
        h(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i extends HdAsyncAction {
        i(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            boolean z16;
            if (f.this.L == null && f.this.M == null) {
                z16 = false;
            } else {
                s_tab_list s_tab_listVar = new s_tab_list(com.qzone.homepage.ui.component.newpanel.c.a(f.this.L), com.qzone.homepage.ui.component.newpanel.c.a(f.this.M));
                f fVar = f.this;
                fVar.y(fVar.f47765e, s_tab_listVar, f.this);
                z16 = true;
            }
            return doNext(true, Boolean.valueOf(z16));
        }
    }

    public f(Activity activity, long j3, ArrayList<HomePanelItem> arrayList, ArrayList<HomePanelItem> arrayList2) {
        this.f47768i = activity;
        this.f47764d = j3;
        s();
        A(arrayList, arrayList2, true);
        r(activity);
        q(activity);
    }

    private void C(boolean z16) {
        this.C.setVisibility(z16 ? 0 : 8);
        this.E.setVisibility(z16 ? 0 : 8);
        this.F.setVisibility(!z16 ? 0 : 8);
        this.D.setVisibility(z16 ? 8 : 0);
    }

    private void E() {
        PanelPopupAdapter panelPopupAdapter = this.K;
        if (panelPopupAdapter != null && panelPopupAdapter.getCount() != 0) {
            this.H.setVisibility(8);
        } else {
            this.H.setVisibility(0);
        }
        PanelPopupAdapter panelPopupAdapter2 = this.J;
        if (panelPopupAdapter2 != null && panelPopupAdapter2.getCount() != 0) {
            this.G.setVisibility(8);
        } else {
            this.G.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.T) {
            if (this.f47766f) {
                this.f47766f = false;
                this.L = this.N;
                this.M = this.P;
                x();
            }
            this.T = false;
            D(false, true);
            return;
        }
        n();
    }

    private void p() {
        this.f47767h.setQUSDragFloatController(new g());
        this.f47767h.setIsHeightWrapContent(true);
    }

    private void q(Context context) {
        this.S.setSmoothScrollingEnabled(true);
        this.S.smoothScrollTo(0, 0);
        this.J = new PanelPopupAdapter(this.f47768i, this.L, this.f47765e, true);
        this.K = new PanelPopupAdapter(this.f47768i, this.M, this.f47765e, true);
        this.J.o(this.U);
        this.K.o(this.U);
        this.J.p(new b());
        this.K.p(new c());
        this.Q.setAdapter((ListAdapter) this.J);
        this.R.setAdapter((ListAdapter) this.K);
        this.E.setOnClickListener(new d());
        e eVar = new e();
        this.F.setOnClickListener(eVar);
        this.C.setOnClickListener(eVar);
        this.D.setOnClickListener(new ViewOnClickListenerC0395f());
    }

    private void r(Activity activity) {
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.bg6, (ViewGroup) null);
        this.f47769m = inflate;
        this.S = (ScrollView) inflate.findViewById(R.id.h9t);
        this.f47767h = new QUSHalfScreenFloatingView(activity);
        this.Q = (ListView) this.f47769m.findViewById(R.id.kkw);
        this.R = (ListView) this.f47769m.findViewById(R.id.ffv);
        this.H = (TextView) this.f47769m.findViewById(R.id.x5x);
        this.G = (TextView) this.f47769m.findViewById(R.id.x5y);
        this.F = (ImageView) this.f47769m.findViewById(R.id.xe7);
        this.C = (TextView) this.f47769m.findViewById(R.id.jg_);
        this.D = (ImageView) this.f47769m.findViewById(R.id.xdi);
        this.E = (TextView) this.f47769m.findViewById(R.id.f95185ea);
        this.f47767h.J();
        if (this.f47767h.x() != null) {
            this.f47767h.x().setBackground(activity.getResources().getDrawable(R.drawable.f162254le4));
        }
        p();
        this.f47767h.setVisibility(8);
        if (activity.getWindow() == null || activity.getWindow().getDecorView() == null || !(activity.getWindow().getDecorView() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) activity.getWindow().getDecorView()).addView(this.f47767h, new ViewGroup.LayoutParams(-1, -1));
    }

    private void s() {
        this.f47765e = LoginData.getInstance().getUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3) {
        w(i3, this.P, this.N, this.K, this.J);
        this.f47766f = true;
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i3) {
        w(i3, this.N, this.P, this.J, this.K);
        this.f47766f = true;
        E();
    }

    private void x() {
        HdAsync.with(this).then(new i(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.BackGroundThread))).then(new h(Looper.getMainLooper())).call();
    }

    public void n() {
        if (this.T) {
            this.T = false;
            D(false, true);
        }
        this.f47767h.t();
    }

    public boolean t() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.f47767h;
        return qUSHalfScreenFloatingView != null && qUSHalfScreenFloatingView.isShown();
    }

    public void z() {
        ArrayList<HomePanelItem> arrayList = this.M;
        if (arrayList != null && arrayList.size() != 0) {
            E();
            C(this.T);
        } else {
            this.T = true;
            D(true, true);
        }
        this.f47767h.P(1);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements com.qzone.homepage.ui.component.newpanel.i {
        a() {
        }

        @Override // com.qzone.homepage.ui.component.newpanel.i
        public void a(PanelPopupAdapter panelPopupAdapter, int i3, int i16) {
            HomePanelItem homePanelItem;
            if (panelPopupAdapter == null || panelPopupAdapter.getCount() <= i3 || (homePanelItem = (HomePanelItem) panelPopupAdapter.getItem(i3)) == null) {
                return;
            }
            k.b(f.this.f47768i, f.this.f47764d, homePanelItem, f.this.I, 1);
            panelPopupAdapter.d(i3);
        }
    }

    public void A(ArrayList<HomePanelItem> arrayList, ArrayList<HomePanelItem> arrayList2, boolean z16) {
        if (arrayList != null) {
            this.L = (ArrayList) arrayList.clone();
        } else {
            this.L = arrayList;
        }
        if (arrayList2 != null) {
            this.M = (ArrayList) arrayList2.clone();
        } else {
            this.M = arrayList2;
        }
        PanelPopupAdapter panelPopupAdapter = this.J;
        if (panelPopupAdapter != null) {
            panelPopupAdapter.t(this.L);
            if (z16) {
                this.J.notifyDataSetChanged();
            }
        }
        PanelPopupAdapter panelPopupAdapter2 = this.K;
        if (panelPopupAdapter2 != null) {
            panelPopupAdapter2.t(this.M);
            if (z16) {
                this.K.notifyDataSetChanged();
            }
        }
    }

    public void B(x6.a aVar) {
        if (aVar == null || aVar.mPanelShowList == null) {
            return;
        }
        this.I = aVar;
        PanelPopupAdapter panelPopupAdapter = this.J;
        if (panelPopupAdapter != null) {
            panelPopupAdapter.s(aVar);
        }
        PanelPopupAdapter panelPopupAdapter2 = this.K;
        if (panelPopupAdapter2 != null) {
            panelPopupAdapter2.s(aVar);
        }
        A(aVar.mPanelShowList, aVar.mPanelHideList, true);
    }

    public void D(boolean z16, boolean z17) {
        if (z16) {
            ArrayList<HomePanelItem> arrayList = this.L;
            if (arrayList != null) {
                this.N = (ArrayList) arrayList.clone();
            } else {
                this.N = new ArrayList<>();
            }
            ArrayList<HomePanelItem> arrayList2 = this.M;
            if (arrayList2 != null) {
                this.P = (ArrayList) arrayList2.clone();
            } else {
                this.P = new ArrayList<>();
            }
            PanelPopupAdapter panelPopupAdapter = this.J;
            if (panelPopupAdapter != null) {
                panelPopupAdapter.t(this.N);
                this.J.q(3);
                if (z17) {
                    this.J.notifyDataSetChanged();
                }
            }
            PanelPopupAdapter panelPopupAdapter2 = this.K;
            if (panelPopupAdapter2 != null) {
                panelPopupAdapter2.t(this.P);
                this.K.q(2);
                if (z17) {
                    this.K.notifyDataSetChanged();
                }
            }
        } else {
            LpReportInfo_pf00064.allReport(128, 1);
            this.F.setVisibility(0);
            PanelPopupAdapter panelPopupAdapter3 = this.J;
            if (panelPopupAdapter3 != null) {
                panelPopupAdapter3.t(this.L);
                this.J.q(1);
                if (z17) {
                    this.J.notifyDataSetChanged();
                }
            }
            PanelPopupAdapter panelPopupAdapter4 = this.K;
            if (panelPopupAdapter4 != null) {
                panelPopupAdapter4.t(this.M);
                this.K.q(1);
                if (z17) {
                    this.K.notifyDataSetChanged();
                }
            }
        }
        E();
        C(this.T);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        Activity activity;
        if (qZoneTask == null || (activity = this.f47768i) == null || activity.isFinishing() || qZoneTask.mType != 0) {
            return;
        }
        if (qZoneTask.getResult(0).getSucceed()) {
            QQToast.makeText(this.f47768i, 2, com.qzone.util.l.a(R.string.oz6), 0).show();
            x6.a aVar = this.I;
            if (aVar != null) {
                aVar.mPanelShowList = this.L;
                aVar.mPanelHideList = this.M;
            }
            HomePanelList homePanelList = new HomePanelList(this.f47764d, this.L, this.M);
            com.qzone.homepage.ui.component.newpanel.e.b().e(this.f47764d, homePanelList);
            EventCenter.getInstance().post("WriteOperation", 75, homePanelList);
            return;
        }
        QQToast.makeText(this.f47768i, 1, com.qzone.util.l.a(R.string.oz5) + qZoneTask.getResult(0).getMessage(), 0).show();
    }

    public void y(long j3, s_tab_list s_tab_listVar, IQZoneServiceListener iQZoneServiceListener) {
        if (s_tab_listVar != null) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new SetTabListRequest(j3, s_tab_listVar), new Handler(), iQZoneServiceListener, 0));
        } else {
            QZLog.e("PanelPopupWindow", "jinqianli@setHomePanelList s_tab_list is null\uff0ccmd=setTableList");
        }
    }

    public void w(int i3, ArrayList<HomePanelItem> arrayList, ArrayList<HomePanelItem> arrayList2, PanelPopupAdapter panelPopupAdapter, PanelPopupAdapter panelPopupAdapter2) {
        HomePanelItem homePanelItem;
        if (i3 < 0 || arrayList == null || arrayList2 == null || panelPopupAdapter == null || panelPopupAdapter2 == null || i3 >= arrayList.size() || (homePanelItem = arrayList.get(i3)) == null) {
            return;
        }
        if (!homePanelItem.canEdit) {
            QQToast.makeText(this.f47768i, com.qzone.util.l.a(R.string.oz7), 0).show();
            return;
        }
        arrayList.remove(i3);
        panelPopupAdapter.t(arrayList);
        panelPopupAdapter.notifyDataSetChanged();
        arrayList2.add(homePanelItem);
        panelPopupAdapter2.t(arrayList2);
        panelPopupAdapter2.notifyDataSetChanged();
    }
}
