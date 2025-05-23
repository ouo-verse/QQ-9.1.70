package n60;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.personal.bean.v;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSPrivateProdsTabReadEvent;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSUserResetEvent;
import com.tencent.biz.qqcircle.immersive.personal.fragment.QFSPersonalDetailsFragment;
import com.tencent.biz.qqcircle.immersive.personal.model.QFSPersonalTabIndexManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r extends n60.b implements SimpleEventReceiver {
    private com.tencent.biz.qqcircle.immersive.personal.widget.o C;
    private com.tencent.biz.qqcircle.immersive.personal.widget.o D;
    private ViewPager2 E;
    private View F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private final n60.a N;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f418464f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.widget.o f418465h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.widget.o f418466i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.immersive.personal.widget.o f418467m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            r.this.E.setCurrentItem(r.this.H);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e extends ViewPager2.OnPageChangeCallback {
        e() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            r.this.G = i3;
            r.this.Q();
            r.this.L();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class f extends v.a {
        f() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("update_version_extend_feed", "update_version_op_mask", "key_version_extend_base_info");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        @SuppressLint({"SetTextI18n"})
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
            r.this.S(wVar);
        }
    }

    public r(@NonNull n60.a aVar) {
        super(aVar);
        this.G = 0;
        this.H = 0;
        this.I = 1;
        this.J = 2;
        this.K = 3;
        this.L = -1;
        this.N = aVar;
    }

    private String C(com.tencent.biz.qqcircle.immersive.personal.data.w wVar, boolean z16, long j3) {
        if (!wVar.y() || QCirclePluginUtil.isRequestSecurityHit(wVar.q()) || z16) {
            return "";
        }
        return com.tencent.biz.qqcircle.immersive.utils.r.f(j3);
    }

    private void D() {
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar = this.f418466i;
        if (oVar != null) {
            oVar.c(false);
        }
    }

    private void E(QFSUserResetEvent qFSUserResetEvent) {
        if (qFSUserResetEvent.getUnique() != c().hashCode()) {
            return;
        }
        M();
    }

    private void F() {
        H();
        M();
    }

    private void G() {
        this.E.registerOnPageChangeCallback(new e());
    }

    private void H() {
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar = new com.tencent.biz.qqcircle.immersive.personal.widget.o(b());
        this.f418465h = oVar;
        oVar.e(new a());
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar2 = new com.tencent.biz.qqcircle.immersive.personal.widget.o(b());
        this.f418467m = oVar2;
        oVar2.e(new b());
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar3 = new com.tencent.biz.qqcircle.immersive.personal.widget.o(b());
        this.C = oVar3;
        oVar3.d(R.id.f509526s);
        this.C.e(new c());
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar4 = new com.tencent.biz.qqcircle.immersive.personal.widget.o(b());
        this.D = oVar4;
        oVar4.e(new d());
    }

    private boolean I() {
        n60.a aVar = this.N;
        if (aVar != null && aVar.getFragment() != null && (this.N.getFragment() instanceof QFSPersonalDetailsFragment)) {
            return ((QFSPersonalDetailsFragment) this.N.getFragment()).Zh();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J() {
        com.tencent.biz.qqcircle.immersive.personal.model.a.f88731a.g();
        QLog.i("QFSPersonalFeedTabViewCompact", 1, "saveTipsBubbleShowRecord");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        int i3;
        View view = this.F;
        if (this.G == this.H) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        View view;
        String str;
        int i3;
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (g() != null) {
            buildElementParams.put("xsj_custom_pgid", g().getDtPageId());
        }
        int i16 = this.G;
        if (i16 == this.H) {
            view = this.f418465h.a();
            str = QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PRODUCT_TAB;
        } else if (i16 == this.L && (oVar = this.f418466i) != null) {
            view = oVar.a();
            str = QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PRIVATE_TAB;
        } else if (i16 == this.I) {
            view = this.f418467m.a();
            str = QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PRAISE_TAB;
        } else if (i16 == this.J) {
            view = this.C.a();
            com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.mUserViewModel;
            if (tVar != null && tVar.N1() != null) {
                com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.mUserViewModel.N1();
                if (N1 != null) {
                    int i17 = 1;
                    if (N1.a().fuelRedPointCount.get() > 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_HOTNUM_ENTER_IF_REDDOT, Integer.valueOf(i3));
                    if (!com.tencent.biz.qqcircle.immersive.utils.r.b0() || N1.e().pushBoxInfo.unopendPushBoxCount.get() <= 0) {
                        i17 = 0;
                    }
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_PUSHED_TAB_IF_REDDOT, Integer.valueOf(i17));
                }
                str = QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_PUSH_TAB;
            } else {
                return;
            }
        } else if (i16 == this.K) {
            view = this.D.a();
            str = QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_COLLECT_TAB;
        } else {
            view = null;
            str = null;
        }
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, buildElementParams);
    }

    private void M() {
        LinearLayout linearLayout = this.f418464f;
        if (linearLayout != null && this.f418465h != null && this.C != null && this.f418467m != null && this.D != null) {
            this.M = false;
            linearLayout.removeAllViews();
            this.f418465h.f(true);
            this.G = 0;
            this.H = 0;
            this.f418465h.f(true);
            this.f418465h.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19308499));
            this.f418464f.addView(this.f418465h.a());
            if (!com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
                return;
            }
            this.I = 1;
            this.J = 2;
            this.K = 3;
            this.C.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f1930949_));
            this.f418467m.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497));
            this.D.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19305496));
            this.C.h(true);
            this.f418467m.h(true);
            this.D.h(true);
            this.C.f(false);
            this.f418467m.f(false);
            this.D.f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.f418466i == null) {
            return;
        }
        QUIDefaultBubbleTip.r(b()).S(this.f418466i.a()).o0(com.tencent.biz.qqcircle.utils.h.a(R.string.f1932749r)).k0(0).R(0).m0(3).f(new a.b() { // from class: n60.q
            @Override // com.tencent.mobileqq.widget.tip.a.b
            public /* synthetic */ void onClick(View view) {
                l53.d.a(this, view);
            }

            @Override // com.tencent.mobileqq.widget.tip.a.b
            public /* synthetic */ void onDismiss() {
                l53.d.b(this);
            }

            @Override // com.tencent.mobileqq.widget.tip.a.b
            public final void onShow() {
                r.J();
            }
        });
    }

    private void O() {
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar = this.f418466i;
        if (oVar == null) {
            return;
        }
        oVar.c(false);
        com.tencent.biz.qqcircle.immersive.personal.model.a.f88731a.f();
        SimpleEventBus.getInstance().dispatchEvent(new QFSPrivateProdsTabReadEvent());
    }

    private void P() {
        if (this.f418466i == null) {
            return;
        }
        com.tencent.biz.qqcircle.immersive.personal.model.a aVar = com.tencent.biz.qqcircle.immersive.personal.model.a.f88731a;
        if (aVar.a()) {
            this.f418466i.c(true);
        }
        if (!I() && aVar.b()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: n60.o
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.N();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this.F != null) {
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: n60.p
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.K();
                }
            }, 500L);
        }
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar = this.f418465h;
        boolean z26 = true;
        if (this.G == this.H) {
            z16 = true;
        } else {
            z16 = false;
        }
        oVar.f(z16);
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar2 = this.f418467m;
        if (this.G == this.I) {
            z17 = true;
        } else {
            z17 = false;
        }
        oVar2.f(z17);
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar3 = this.C;
        if (this.G == this.J) {
            z18 = true;
        } else {
            z18 = false;
        }
        oVar3.f(z18);
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar4 = this.D;
        if (this.G == this.K) {
            z19 = true;
        } else {
            z19 = false;
        }
        oVar4.f(z19);
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar5 = this.f418466i;
        if (oVar5 != null) {
            if (this.G != this.L) {
                z26 = false;
            }
            oVar5.f(z26);
            if (this.G == this.L) {
                O();
            }
        }
        if (this.J == this.G && com.tencent.biz.qqcircle.immersive.utils.r.b0()) {
            com.tencent.biz.qqcircle.immersive.utils.r.b1(System.currentTimeMillis());
            this.C.i(false);
        }
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = this.mUserViewModel;
        if (tVar != null && tVar.N1() != null) {
            com.tencent.biz.qqcircle.immersive.personal.data.w N1 = this.mUserViewModel.N1();
            this.f418467m.h(N1.u(6));
            this.C.h(N1.u(8));
            this.D.h(N1.u(19));
        }
    }

    private void R() {
        QFSPersonalTabIndexManager qFSPersonalTabIndexManager = QFSPersonalTabIndexManager.f88726a;
        if (qFSPersonalTabIndexManager.h() && this.f418466i != null) {
            this.H = 0;
            this.L = qFSPersonalTabIndexManager.e();
            this.I = qFSPersonalTabIndexManager.d();
            this.J = qFSPersonalTabIndexManager.f();
            this.K = qFSPersonalTabIndexManager.b();
            return;
        }
        this.H = 0;
        this.I = 1;
        this.J = 2;
        this.K = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        String C;
        String C2;
        boolean u16 = wVar.u(6);
        boolean u17 = wVar.u(8);
        boolean u18 = wVar.u(19);
        this.f418467m.h(u16);
        this.C.h(u17);
        this.D.h(u18);
        if (!com.tencent.biz.qqcircle.manager.i.a("qfs_personal_entrance_show")) {
            this.f418464f.removeAllViews();
            if (wVar.z()) {
                this.H = -1;
                this.J = -1;
                this.I = 0;
                this.K = 1;
                this.f418467m.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497));
                this.D.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19305496));
                return;
            }
            this.H = 0;
            this.J = -1;
            this.I = -1;
            this.K = -1;
            String C3 = C(wVar, false, wVar.d().b());
            this.f418465h.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19308499) + C3);
            this.f418464f.addView(this.f418465h.a());
            return;
        }
        if (wVar.x()) {
            return;
        }
        List<Integer> e16 = wVar.d().e();
        if (e16 == null) {
            this.f418465h.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19308499));
            this.f418467m.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497));
            this.C.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f1930949_));
            this.D.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19305496));
        } else {
            boolean contains = e16.contains(1);
            String C4 = C(wVar, false, wVar.d().b());
            String str = "";
            if (u17) {
                C = "";
            } else {
                C = C(wVar, contains, wVar.d().f());
            }
            if (u16) {
                C2 = "";
            } else {
                C2 = C(wVar, contains, wVar.d().c());
            }
            if (!u18) {
                str = C(wVar, contains, wVar.d().a());
            }
            this.f418465h.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19308499) + C4);
            this.f418467m.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19306497) + C2);
            this.C.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f1930949_) + C);
            this.D.g(com.tencent.biz.qqcircle.utils.h.a(R.string.f19305496) + str);
        }
        if (this.M) {
            return;
        }
        this.M = true;
        this.f418464f.removeAllViews();
        if (wVar.z()) {
            this.f418464f.addView(this.f418465h.a());
            QFSPersonalTabIndexManager qFSPersonalTabIndexManager = QFSPersonalTabIndexManager.f88726a;
            if (qFSPersonalTabIndexManager.h()) {
                P();
            }
            R();
            qFSPersonalTabIndexManager.a();
            QCircleInitBean initBean = getMParentView().getInitBean();
            if (initBean != null && initBean.getExtraTypeInfo() != null) {
                int i3 = initBean.getExtraTypeInfo().sourceType;
                if (i3 == 20109 || i3 == 20108 || i3 == 20110) {
                    this.G = this.K;
                    return;
                }
                return;
            }
            return;
        }
        this.f418464f.addView(this.f418465h.a());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSUserResetEvent.class);
        arrayList.add(QFSPrivateProdsTabReadEvent.class);
        return arrayList;
    }

    @Override // n60.b
    public void j(QFSBaseFragment qFSBaseFragment) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.t tVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.t) qFSBaseFragment.getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.t.class);
        this.mUserViewModel = tVar;
        tVar.O1().c(qFSBaseFragment, new f());
        this.mUserViewModel.O1().c(qFSBaseFragment, new g());
    }

    @Override // n60.b
    public void l() {
        super.l();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // n60.b
    public void n() {
        super.n();
        com.tencent.biz.qqcircle.immersive.personal.widget.o oVar = this.C;
        if (oVar != null) {
            oVar.b();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // n60.b
    public void o() {
        this.f418464f = (LinearLayout) a(R.id.f46021tg);
        F();
        this.E = (ViewPager2) a(R.id.f57372n5);
        G();
        this.F = a(R.id.yy8);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSUserResetEvent) {
            E((QFSUserResetEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSPrivateProdsTabReadEvent) {
            D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class g extends v.a {
        g() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public List<String> a() {
            return Arrays.asList("key_update_version_main_basic_base_rsp");
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.bean.v.a
        public void d(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar) {
        }
    }
}
