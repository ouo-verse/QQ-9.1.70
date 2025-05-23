package com.tencent.biz.pubaccount.weishi.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.report.WSReportDc00898;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ah;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends BaseAdapter<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j, BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> {
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private au f82035d;

    /* renamed from: e, reason: collision with root package name */
    private au f82036e;

    /* renamed from: f, reason: collision with root package name */
    private LinkedList<au> f82037f;

    /* renamed from: h, reason: collision with root package name */
    private WSPlayerManager f82038h;

    /* renamed from: i, reason: collision with root package name */
    private WSVerticalPageFragment f82039i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.e f82040m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements WSVideoPreDownloadManager.b {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public List<WSVideoPreDownloadManager.c> a(int i3, boolean z16) {
            return com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.o(f.this.getDataList(), i3, z16);
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public boolean b() {
            return AppNetConnInfo.isWifiConn();
        }
    }

    public f(Context context, WSVerticalPageFragment wSVerticalPageFragment) {
        super(context);
        this.f82037f = new LinkedList<>();
        this.f82039i = wSVerticalPageFragment;
    }

    private ah B(au auVar) {
        Object obj = auVar.f82127d;
        if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
            com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> i3 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).i();
            if (i3 instanceof ah) {
                return (ah) i3;
            }
        }
        return null;
    }

    private void E(int i3, au auVar, stSimpleMetaFeed stsimplemetafeed) {
        if (!this.G) {
            this.f82039i.pi(i3, auVar.f82114h);
            R(auVar);
            return;
        }
        this.G = false;
        ah B = B(auVar);
        if (B == null) {
            return;
        }
        WSPlayerManager wSPlayerManager = this.f82038h;
        if (wSPlayerManager != null && wSPlayerManager.p0().equals(stsimplemetafeed.f25129id)) {
            B.w(8, 0);
        } else {
            B.w(0, 0);
        }
    }

    private void F(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder) {
        if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) {
            ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) baseViewHolder).w(this.E);
        }
    }

    private void G() {
        WSVideoPreDownloadManager wSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.getApplication().getApplicationContext());
        wSVideoPreDownloadManager.x(new a());
        this.f82038h.U0(wSVideoPreDownloadManager);
    }

    private boolean K() {
        return this.f82039i.ji();
    }

    private boolean M(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        WSPlayerWrapper x16 = x(eVar);
        if (x16 != null) {
            return x16.b0() || x16.a0();
        }
        return false;
    }

    private void N(au auVar) {
        WSPlayerWrapper wSPlayerWrapper;
        com.tencent.biz.pubaccount.weishi.player.e eVar = auVar.f82114h;
        if (eVar != null) {
            if (eVar.f81133i || !((wSPlayerWrapper = eVar.f81129e) == null || wSPlayerWrapper.B() == 0)) {
                eVar.f81133i = false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R(au auVar) {
        this.f82038h.Y0();
        this.f82035d = auVar;
        this.f82038h.L0(auVar.f82114h, false);
        this.f82038h.T0(((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).g());
        u10.b.c(((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).g(), 1, this.f82039i.getFrom(), this.f82039i.getPlayScene(), ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).e());
        this.C = Math.max(this.C, this.f82035d.getLayoutPosition());
        x.i("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][playVideo] mNotPlayedFirstPosition:" + this.C + ", currentPosition():" + this.f82035d.getLayoutPosition() + ", speed:" + ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).g());
    }

    private void U(int i3, stSimpleMetaFeed stsimplemetafeed, com.tencent.biz.pubaccount.weishi.player.e eVar, String str) {
        com.tencent.biz.pubaccount.weishi.player.e eVar2;
        com.tencent.biz.pubaccount.weishi.player.wrapper.h hVar;
        WSPlayerWrapper wSPlayerWrapper;
        if (K()) {
            com.tencent.biz.pubaccount.weishi.player.e u16 = u();
            this.f82040m = u16;
            if (!L(i3, stsimplemetafeed, u16) || (hVar = (eVar2 = this.f82040m).f81126b) == null || (wSPlayerWrapper = eVar2.f81129e) == null) {
                return;
            }
            eVar.f81129e = wSPlayerWrapper;
            eVar.f81126b = hVar;
            eVar.f81137m = eVar2.f81137m;
            wSPlayerWrapper.u0(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X(au auVar) {
        x.b("WSVerticalPageAdapterLog", "[WSVerticalPageAdapter.java][switchPlayerVideoViewLayout] holder: " + auVar);
        this.f82035d = auVar;
        WSReportDc00898.r(auVar.f82114h, false);
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.i0(this.f82039i.getFrom(), this.f82039i.getPlayScene(), this.f82035d.f82114h, this.D, this.f82039i.getPresenter().h0());
        this.f82038h.a1(this.f82035d.f82114h, true);
        this.f82038h.S0(false);
        this.f82038h.T0(((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).g());
        u10.b.c(((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).g(), 1, this.f82039i.getFrom(), this.f82039i.getPlayScene(), ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f).e());
    }

    private void q(au auVar, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar, int i3, String str) {
        stSimpleMetaFeed s16 = s(jVar);
        com.tencent.biz.pubaccount.weishi.player.e eVar = auVar.f82114h;
        if (eVar == null) {
            eVar = new com.tencent.biz.pubaccount.weishi.player.e();
        }
        eVar.f81127c = x10.a.a(s16);
        eVar.f81125a = auVar.c();
        com.tencent.biz.pubaccount.weishi.player.a aVar = auVar.f82115i;
        if (aVar == null) {
            aVar = new l();
        }
        ((l) aVar).z(auVar);
        auVar.f82115i = aVar;
        eVar.f81136l = aVar;
        eVar.f81130f = auVar.n(s16);
        eVar.f81132h = 0L;
        eVar.f81134j = true;
        eVar.f81131g = i3;
        eVar.f81135k = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.j(str);
        U(i3, s16, eVar, str);
        auVar.f82114h = eVar;
    }

    private com.tencent.biz.pubaccount.weishi.player.e u() {
        return this.f82039i.Wh();
    }

    public au A() {
        return this.f82036e;
    }

    public LinkedList<au> C() {
        return this.f82037f;
    }

    public void H(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList = getDataList();
        if (dataList != null && dataList.addAll(0, list)) {
            notifyItemRangeInserted(0, list.size());
        }
    }

    public boolean I() {
        Object obj;
        au auVar = this.f82035d;
        if (auVar == null || (obj = auVar.f82127d) == null || !(obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b)) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> k3 = ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).k();
        return (k3 instanceof WSVerticalItemVideoProgressController) && ((WSVerticalItemVideoProgressController) k3).G();
    }

    public boolean J() {
        return this.D == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void P(RecyclerView.ViewHolder viewHolder, int i3) {
        x.i("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onPageSelected] currentPosition:" + i3 + ", viewHolder:" + viewHolder);
        this.D = i3;
        if (viewHolder instanceof au) {
            au auVar = (au) viewHolder;
            stSimpleMetaFeed s16 = s((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) auVar.f82129f);
            if (K() && L(i3, s16, this.f82040m)) {
                X(auVar);
                this.f82039i.qi();
            } else {
                E(i3, auVar, s16);
            }
            this.f82040m = null;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder) {
        super.onViewDetachedFromWindow(baseViewHolder);
        baseViewHolder.onViewDetachedFromWindow();
    }

    public void S(boolean z16) {
        this.F = z16;
    }

    public void T(int i3) {
        this.C = i3;
    }

    public void V(WSPlayerManager wSPlayerManager) {
        this.f82038h = wSPlayerManager;
        b bVar = new b(wSPlayerManager);
        bVar.l(this.f82039i);
        this.f82038h.X(bVar);
        G();
    }

    public void W(boolean z16) {
        this.E = z16;
    }

    public void a0(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar2;
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList = getDataList();
        if (dataList == null || jVar == null || jVar.e() == null || this.D < 0) {
            return;
        }
        x.c("WSVerticalPageAdapterLog", "[updateDateToNext] itemData:" + jVar.e().f25129id + ",desc:" + jVar.e().feed_desc);
        int i3 = this.D + 1;
        if (i3 >= dataList.size() || (jVar2 = dataList.get(i3)) == null || jVar2.e() == null) {
            return;
        }
        if (jVar2.e().video_type == 2) {
            Z(dataList, i3, jVar);
        } else {
            dataList.set(i3, jVar);
            notifyItemChanged(i3, jVar);
        }
    }

    @Override // com.tencent.widget.pull2refresh.BaseAdapter
    public int getCustomItemViewType(int i3) {
        return com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.e(getItem(i3));
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public void onBindCustomViewHolder(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder, int i3) {
        com.tencent.biz.pubaccount.weishi.baseui.c<T> cVar;
        x.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][onBindCustomViewHolder] position: " + i3 + ", holder:" + baseViewHolder);
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item = getItem(i3);
        if (item != null) {
            this.f82039i.mi(item, i3);
            baseViewHolder.bindData(item);
            if ((baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e) && (cVar = ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e) baseViewHolder).f82127d) != 0) {
                cVar.setPosition(i3);
            }
            if (baseViewHolder instanceof au) {
                au auVar = (au) baseViewHolder;
                N(auVar);
                q(auVar, item, i3, this.f82039i.getFrom());
                if (i3 > 0) {
                    Y(auVar);
                }
            }
            g presenter = this.f82039i.getPresenter();
            if (presenter != null) {
                presenter.y(baseViewHolder, i3);
            }
            if (baseViewHolder instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) {
                ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) baseViewHolder).x(this.F);
            }
        }
    }

    @Override // com.tencent.widget.pull2refresh.HeaderAndFooterAdapter
    public BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> onCreateCustomViewHolder(ViewGroup viewGroup, int i3) {
        BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> a16 = com.tencent.biz.pubaccount.weishi.verticalvideo.holder.g.a(viewGroup, i3, this.f82039i);
        this.f82037f.addLast((au) a16);
        F(a16);
        return a16;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e eVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.e) recyclerView.getChildViewHolder(recyclerView.getChildAt(i3));
            if (eVar != null) {
                eVar.f82127d.recycle();
            }
        }
    }

    public void p(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList = getDataList();
        if (dataList == null || !dataList.addAll(list)) {
            return;
        }
        notifyItemRangeChanged(dataList.size() - list.size(), list.size());
    }

    public int t() {
        return this.C;
    }

    public com.tencent.biz.pubaccount.weishi.verticalvideo.data.j v() {
        int i3 = this.C;
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList = getDataList();
        if (dataList == null || dataList.size() <= i3) {
            return null;
        }
        return dataList.get(i3);
    }

    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> w() {
        int i3 = this.C;
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList = getDataList();
        if (dataList == null || dataList.size() <= i3) {
            return null;
        }
        return dataList.subList(i3, dataList.size());
    }

    public WSPlayerManager y() {
        return this.f82038h;
    }

    public au z() {
        return this.f82035d;
    }

    public void O() {
        this.G = true;
        notifyDataSetChanged();
    }

    private String D(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        com.tencent.biz.pubaccount.weishi.player.l lVar;
        if (eVar != null && (lVar = eVar.f81127c) != null) {
            return lVar.f81166a;
        }
        return "";
    }

    private boolean L(int i3, stSimpleMetaFeed stsimplemetafeed, com.tencent.biz.pubaccount.weishi.player.e eVar) {
        String str;
        if (stsimplemetafeed != null) {
            str = stsimplemetafeed.f25129id;
        } else {
            str = "";
        }
        String D = D(eVar);
        WSVerticalPageFragment wSVerticalPageFragment = this.f82039i;
        return wSVerticalPageFragment != null && wSVerticalPageFragment.Vh() == i3 + 1 && !TextUtils.isEmpty(D) && TextUtils.equals(str, D) && M(eVar);
    }

    private void Y(au auVar) {
        au auVar2;
        com.tencent.biz.pubaccount.weishi.player.e eVar;
        WSPlayerWrapper wSPlayerWrapper;
        if (auVar == null || auVar == (auVar2 = this.f82035d)) {
            return;
        }
        this.f82036e = auVar;
        if (auVar2 == null || (eVar = auVar2.f82114h) == null || (wSPlayerWrapper = eVar.f81129e) == null) {
            return;
        }
        int B = wSPlayerWrapper.B();
        x.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] state:" + B + ", prePlayVideoHolder:" + auVar);
        if (B == 0 || B == 1 || B == 2) {
            return;
        }
        x.b("WS_VIDEO_SCROLL", "[WSVerticalPageAdapter.java][tryPrePlayVideo] prePlayVideoHolder:" + auVar);
        this.f82038h.M0(auVar.f82114h);
    }

    private int Z(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, int i3, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar2;
        int i16 = i3 + 1;
        if (i16 >= list.size() || (jVar2 = list.get(i16)) == null || jVar2.e() == null) {
            return 0;
        }
        list.set(i16, jVar);
        notifyItemChanged(i16, jVar);
        return i16;
    }

    private stSimpleMetaFeed s(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        if (jVar != null) {
            return jVar.e();
        }
        return null;
    }

    private WSPlayerWrapper x(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        if (eVar != null) {
            return eVar.f81129e;
        }
        return null;
    }

    public stSimpleMetaFeed r(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item;
        if (i3 >= 0 && (item = getItem(i3)) != null) {
            return item.e();
        }
        return null;
    }
}
