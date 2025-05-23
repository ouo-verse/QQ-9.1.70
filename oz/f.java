package oz;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi.view.WSXRecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class f extends rz.b implements oz.b, IGuardInterface, wz.c {
    private LinearLayout C;
    private ImageView D;
    private WSDramaPageFragment E;
    private oz.a F;
    private g G;
    private mz.d H;
    private String I;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f424543h;

    /* renamed from: i, reason: collision with root package name */
    private WSDragLayout f424544i;

    /* renamed from: m, reason: collision with root package name */
    private WSXRecyclerView f424545m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!f.this.f424544i.k()) {
                f.this.f424544i.i(300);
            } else {
                f.this.f424544i.d(300);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.f424544i.k()) {
                return;
            }
            f.this.f424544i.i(300);
        }
    }

    public f(ViewStub viewStub, WSDramaPageFragment wSDramaPageFragment) {
        super(wSDramaPageFragment.getActivity(), viewStub);
        this.G = new g(this);
        this.E = wSDramaPageFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        this.f424543h.setClickable(true);
        this.D.setImageResource(R.drawable.odj);
        I(0);
        J();
        oz.a aVar = this.F;
        if (aVar != null) {
            aVar.s(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        this.f424543h.setClickable(false);
        this.D.setImageResource(R.drawable.odk);
        I(1);
        oz.a aVar = this.F;
        if (aVar != null) {
            aVar.s(true);
        }
    }

    private void E() {
        wz.b.b().d(this);
        this.G.j(new jz.a(true, true));
    }

    private void F() {
        LoadingMoreHelper loadMoreLayoutHelper = this.f424545m.getLoadMoreLayoutHelper();
        if (loadMoreLayoutHelper != null) {
            loadMoreLayoutHelper.setPreLoaderCount(12);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f432974d, 3);
        this.F = new oz.a(this.f432974d, this.E);
        this.f424545m.setRefreshEnable(false);
        RecyclerViewWithHeaderFooter recyclerView = this.f424545m.getRecyclerView();
        recyclerView.setAdapter(this.F);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new com.tencent.biz.pubaccount.weishi.view.b(3, ba.f81730e));
        this.f424545m.setRefreshCallback(new d());
    }

    private void G() {
        this.f424543h = (RelativeLayout) this.f432976f.findViewById(R.id.f75453z0);
        this.f424544i = (WSDragLayout) this.f432976f.findViewById(R.id.ulj);
        this.f424545m = (WSXRecyclerView) this.f432976f.findViewById(R.id.f789248d);
        this.C = (LinearLayout) this.f432976f.findViewById(R.id.mb7);
        this.D = (ImageView) this.f432976f.findViewById(R.id.y_7);
        this.f424544i.setControlLitTongue(true);
        this.f424544i.setMode(1);
        this.f424544i.setDisableMinScrollY(true);
        this.f424544i.setContentView(this.f424545m.getRecyclerView());
        this.f424544i.i(0);
        this.f424544i.setTouchListener(new a());
        this.C.setOnClickListener(new b());
        this.f424543h.setOnClickListener(new c());
    }

    private void I(int i3) {
        if (this.H == null) {
            return;
        }
        oz.a aVar = this.F;
        tz.a.j(this.H.f(), this.H.j(), this.H.d(), this.H.a(), this.I, i3, (aVar == null || aVar.getDataList().size() <= 0) ? 0 : 1);
    }

    private void J() {
        if (this.H == null || this.f424544i.k()) {
            return;
        }
        int h16 = ba.h(this.f424545m.getRecyclerView());
        int k3 = ba.k(this.f424545m.getRecyclerView());
        x.b("WSDramaHistoryPart", "reportPanelItemExposure fistVisible:" + h16 + ", lastVisible:" + k3);
        pz.a Bd = this.E.Bd();
        while (h16 <= k3) {
            if (h16 < this.F.getDataList().size()) {
                tz.a.i(vz.a.f(Bd), vz.a.g(Bd), vz.a.d(Bd), vz.a.c(Bd), this.F.getDataList().get(h16), this.E.getFrom(), h16);
            }
            h16++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(float f16) {
        this.f424543h.getBackground().mutate().setAlpha((int) ((1.0f - f16) * 255.0f));
    }

    public static f z(ViewStub viewStub, WSDramaPageFragment wSDramaPageFragment, String str) {
        f fVar = new f(viewStub, wSDramaPageFragment);
        fVar.K(str);
        return fVar;
    }

    public void H(pz.a aVar, int i3) {
        this.H = aVar.f428078f;
    }

    public void K(String str) {
        this.I = str;
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSDramaVideoPlayEvent) {
            WSDramaVideoPlayEvent wSDramaVideoPlayEvent = (WSDramaVideoPlayEvent) wSSimpleBaseEvent;
            if (wSDramaVideoPlayEvent.getDramaInfo() == null || wSDramaVideoPlayEvent.getDramaInfo().dramaInfo == null) {
                return;
            }
            stDrama i3 = this.G.i(wSDramaVideoPlayEvent.getDramaInfo());
            int episodeNum = wSDramaVideoPlayEvent.getEpisodeNum();
            stDramaInfo stdramainfo = i3.dramaInfo;
            if (episodeNum > stdramainfo.curWatchedFeedNum) {
                stdramainfo.curWatchedFeedNum = wSDramaVideoPlayEvent.getEpisodeNum();
                i3.dramaInfo.curWatchedFeedID = wSDramaVideoPlayEvent.getEpisodeId();
            }
            x.b("WSDramaHistoryPart", "[onReceiveEvent] \u63a5\u6536\u5230\u64ad\u653e\u4e8b\u4ef6\uff1a" + i3.dramaInfo.name + ", isDramaPreviewPage:" + wSDramaVideoPlayEvent.isDramaPreviewPage() + ", \u96c6\u6570:" + i3.dramaInfo.curWatchedFeedNum);
            this.G.l(i3, wSDramaVideoPlayEvent.isDramaPreviewPage());
        }
    }

    @Override // oz.b
    public List<oz.c> f() {
        oz.a aVar = this.F;
        if (aVar != null) {
            return aVar.getDataList();
        }
        return new ArrayList();
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSDramaVideoPlayEvent.class);
        return arrayList;
    }

    @Override // rz.b, rz.a
    public void j() {
        super.j();
        G();
        F();
        E();
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(this);
        }
    }

    @Override // rz.b, rz.a
    public void k() {
        super.k();
        wz.b.b().f(this);
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(this);
        }
    }

    @Override // oz.b
    public void l(List<oz.c> list, boolean z16) {
        oz.a aVar = this.F;
        if (aVar != null) {
            aVar.fillList(list);
            this.f424545m.backToTopAtOnce();
        }
        this.f424545m.loadMoreComplete(true, z16);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        if (this.f424544i.k()) {
            this.G.j(new jz.a(true, true));
        }
    }

    @Override // rz.b
    protected int q() {
        return R.layout.fw8;
    }

    @Override // oz.b
    public void g(List<oz.c> list, boolean z16, boolean z17) {
        if (z16) {
            this.F.fillList(list);
            this.f424545m.backToTopAtOnce();
        } else {
            this.F.appendList(list);
        }
        this.f424545m.loadMoreComplete(true, z17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements XRecyclerView.RefreshCallback {
        d() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startLoadMore(XRecyclerView xRecyclerView, int i3) {
            f.this.G.j(new jz.a(false, false));
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void endOfRefresh() {
        }

        @Override // com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback
        public void startTopRefresh(XRecyclerView xRecyclerView, boolean z16) {
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements WSDragLayout.c {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
        public void b(int i3) {
            f.this.B();
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
        public void e(float f16) {
            f.this.y((float) ((f16 * 0.3d) + 0.7d));
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
        public boolean g() {
            return false;
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
        public void scrollToTop() {
            f.this.A();
        }

        @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
        public void a(boolean z16) {
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
    }

    @Override // oz.b
    public void i(boolean z16, int i3, String str) {
    }
}
