package com.tencent.biz.pubaccount.weishi.drama;

import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.weishi.drama.gallery.WSDramaGalleryAdapter;
import com.tencent.biz.pubaccount.weishi.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WSDramaMiddlePart extends rz.b implements nz.b, wz.c {
    public static final int N = (ba.o() / 2) - (ScreenUtil.dip2px(51.5f) / 2);
    private TextView C;
    private RecyclerView D;
    private RecyclerView E;
    private nz.d F;
    private WSDramaGalleryAdapter G;
    private d H;
    private Bundle I;
    private String J;
    private String K;
    private int L;
    private boolean M;

    /* renamed from: h, reason: collision with root package name */
    private final WSDramaPageFragment f80662h;

    /* renamed from: i, reason: collision with root package name */
    private final sz.b f80663i;

    /* renamed from: m, reason: collision with root package name */
    private LottieAnimationView f80664m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WSDramaMiddlePart.this.g0(vz.a.f443763a);
            mz.d dVar = (mz.d) WSDramaMiddlePart.this.G.getItem(WSDramaMiddlePart.this.G.p());
            tz.a.g(dVar.f(), dVar.j(), dVar.d(), dVar.a(), WSDramaMiddlePart.this.getFrom());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements lz.b<mz.d> {
        c() {
        }

        @Override // lz.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void l(mz.d dVar, int i3) {
            WSDramaMiddlePart.this.d0(1);
            WSDramaMiddlePart.this.b0(dVar, i3);
        }

        @Override // lz.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(mz.d dVar, int i3) {
            tz.a.k(dVar, i3, 1, true, WSDramaMiddlePart.this.getFrom());
            WSDramaMiddlePart.this.g0(vz.a.f443764b);
        }
    }

    /* loaded from: classes32.dex */
    public interface d {
        void V6(nz.f fVar, int i3);

        void fd(mz.d dVar, int i3);

        void uf(stDramaFeed stdramafeed);

        void x3(stDramaFeed stdramafeed);
    }

    public WSDramaMiddlePart(WSDramaPageFragment wSDramaPageFragment, ViewStub viewStub) {
        super(wSDramaPageFragment.getActivity(), viewStub);
        this.L = -1;
        this.M = true;
        this.f80662h = wSDramaPageFragment;
        this.f80663i = new sz.b(this);
    }

    public static WSDramaMiddlePart B(WSDramaPageFragment wSDramaPageFragment, ViewStub viewStub, Bundle bundle) {
        WSDramaMiddlePart wSDramaMiddlePart = new WSDramaMiddlePart(wSDramaPageFragment, viewStub);
        wSDramaMiddlePart.f0(bundle);
        return wSDramaMiddlePart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String G() {
        nz.d dVar = this.F;
        nz.f fVar = (nz.f) dVar.getItem(dVar.p());
        if (fVar != null) {
            return fVar.a();
        }
        return "";
    }

    private sz.b I() {
        return this.f80663i;
    }

    private void J(WSDramaFollowEvent wSDramaFollowEvent) {
        WSDramaGalleryAdapter wSDramaGalleryAdapter = this.G;
        if (wSDramaGalleryAdapter == null) {
            return;
        }
        List<M> dataList = wSDramaGalleryAdapter.getDataList();
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            mz.d dVar = (mz.d) dataList.get(i3);
            if (dVar != null && TextUtils.equals(dVar.d(), wSDramaFollowEvent.getDramaId())) {
                dVar.e().dramaInfo.isFollowed = wSDramaFollowEvent.getStatus() == 1;
            }
        }
    }

    private void K() {
        Bundle H = H();
        if (H == null) {
            return;
        }
        this.J = H.getString("drama_id");
        this.K = H.getString("from");
    }

    private void L() {
        WSDramaGalleryAdapter wSDramaGalleryAdapter = new WSDramaGalleryAdapter(this, this.E);
        this.G = wSDramaGalleryAdapter;
        O(this.E, wSDramaGalleryAdapter, new com.tencent.biz.pubaccount.weishi.drama.gallery.b(), com.tencent.biz.pubaccount.weishi.drama.gallery.b.f80700e);
        this.G.t(new c());
    }

    private void M() {
        this.f80664m.setRepeatCount(-1);
        this.f80664m.setRepeatMode(1);
        this.f80664m.setAnimation("wsdrama_enter/data.json");
        this.f80664m.setImageAssetsFolder("wsdrama_enter/images");
        this.f80664m.setOnClickListener(new a());
    }

    private void N() {
        nz.d dVar = new nz.d(this.f432974d, this.D);
        this.F = dVar;
        O(this.D, dVar, new nz.g(), nz.g.f421614d);
        this.F.t(new b());
    }

    private <M extends lz.a, H extends BaseViewHolder<M>> void O(RecyclerView recyclerView, lz.d<M, H> dVar, RecyclerView.ItemDecoration itemDecoration, int i3) {
        recyclerView.setAdapter(dVar);
        recyclerView.addItemDecoration(itemDecoration);
        nz.a aVar = new nz.a(this.f432974d, i3);
        aVar.setOrientation(0);
        recyclerView.setLayoutManager(aVar);
        dVar.s(aVar);
    }

    private void Q(boolean z16, String str, String str2, int i3) {
        x.i("WSDramaMiddlePartnel-log", "[WSDramaMiddlePart.java][loadDramaData] dramaId:" + str + ", episodeId:" + str2 + ", episodeNum:" + i3);
        R(str);
        U(z16, str2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(int i3) {
        if (i3 >= this.F.getItemCount()) {
            return;
        }
        this.F.r(i3);
        ((nz.a) this.D.getLayoutManager()).scrollToPositionWithOffset(Math.max(0, i3), N);
        d0(0);
        tz.a.n((nz.f) this.F.getItem(i3), F(), getFrom());
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0(mz.d dVar, int i3) {
        this.J = dVar.d();
        x.f("WSDramaMiddlePartnel-log", "[WSDramaMiddlePart.java][dramaChecked] mDramaId:" + this.J);
        d dVar2 = this.H;
        if (dVar2 != null) {
            dVar2.fd(dVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(nz.f fVar, int i3) {
        d dVar = this.H;
        if (dVar != null) {
            dVar.V6(fVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(int i3) {
        this.L = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(String str) {
        vz.a.o(this.f80662h, k0(), G(), str);
    }

    private void h0(String str, int i3, int i16) {
        this.E.getLayoutManager().smoothScrollToPosition(this.E, new RecyclerView.State(), i3);
        this.C.setText(str);
    }

    @Override // nz.b
    public void Df(stDramaFeed stdramafeed) {
        d dVar = this.H;
        if (dVar != null) {
            dVar.uf(stdramafeed);
        }
    }

    public void E(List<mz.d> list) {
        this.f80664m.setVisibility(0);
        this.f80664m.playAnimation();
        this.G.fillList(list);
    }

    public int F() {
        return this.L;
    }

    public Bundle H() {
        return this.I;
    }

    public void R(String str) {
        x.i("WSDramaMiddlePartnel-log", "[WSDramaMiddlePart.java][loadDramaFeedIds] dramaId:" + str);
        this.J = str;
        I().O();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void S() {
        int p16 = this.F.p() + 1;
        if (p16 >= this.F.getItemCount()) {
            return;
        }
        nz.f fVar = (nz.f) this.F.getItem(p16);
        I().R(fVar.a(), fVar.b());
    }

    public void U(boolean z16, String str, int i3) {
        x.i("WSDramaMiddlePartnel-log", "[WSDramaMiddlePart.java][loadDramaFeeds] episodeId:" + str + ", episodeNum:" + i3);
        I().P(z16, str, i3);
    }

    @Override // nz.b
    public void Uc(List<nz.f> list, stDramaInfo stdramainfo) {
        String str;
        final int i3;
        this.F.fillList(list);
        if (stdramainfo != null) {
            str = stdramainfo.name;
            i3 = stdramainfo.curWatchedFeedNum - 1;
        } else {
            str = "";
            i3 = 0;
        }
        this.C.setText(str);
        this.D.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.drama.WSDramaMiddlePart.4
            @Override // java.lang.Runnable
            public void run() {
                ((nz.a) WSDramaMiddlePart.this.D.getLayoutManager()).scrollToPositionWithOffset(i3, WSDramaMiddlePart.N);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void V(pz.a aVar, int i3) {
        if (F() != 0 && F() != 1) {
            d0(2);
        }
        mz.d dVar = aVar.f428078f;
        this.J = dVar.d();
        int i16 = dVar.e().dramaInfo.curWatchedFeedNum;
        int i17 = i16 - 1;
        nz.f fVar = (nz.f) this.F.getItem(Math.max(0, i17));
        if (!this.M) {
            tz.a.m(fVar, this.F.w(), this.F.x(), getFrom());
            tz.a.n(fVar, F(), getFrom());
            tz.a.k(dVar, i3, F(), false, getFrom());
        }
        W();
        this.M = false;
        this.G.r(i3);
        Q(false, dVar.d(), dVar.e().dramaInfo.curWatchedFeedID, i16);
        h0(dVar.e().dramaInfo.name, i3, Math.max(0, i17));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a0() {
        int p16 = this.F.p() + 1;
        if (p16 > this.F.getItemCount() - 1) {
            Z();
            return;
        }
        nz.f fVar = (nz.f) this.F.getItem(p16);
        Y(p16);
        U(false, fVar.a(), p16 + 1);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if (wSSimpleBaseEvent instanceof WSDramaVideoExposureEvent) {
            Y(((WSDramaVideoExposureEvent) wSSimpleBaseEvent).getCurrentEpisodeNum() - 1);
        } else if (wSSimpleBaseEvent instanceof WSDramaFollowEvent) {
            J((WSDramaFollowEvent) wSSimpleBaseEvent);
        }
    }

    @Override // rz.b, rz.a
    public void e() {
        super.e();
        if (this.f80664m.getVisibility() == 0) {
            this.f80664m.playAnimation();
        }
    }

    public void e0(d dVar) {
        this.H = dVar;
    }

    public void f0(Bundle bundle) {
        this.I = bundle;
    }

    @Override // wz.c
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(WSDramaVideoExposureEvent.class);
        arrayList.add(WSDramaFollowEvent.class);
        return arrayList;
    }

    public String getFrom() {
        return this.K;
    }

    @Override // rz.b, rz.a
    public void j() {
        super.j();
        K();
        P();
        L();
        N();
        M();
        wz.b.b().d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rz.b, rz.a
    public void k() {
        super.k();
        wz.b.b().f(this);
        nz.d dVar = this.F;
        tz.a.m((nz.f) dVar.getItem(dVar.p()), this.F.w(), this.F.x(), getFrom());
    }

    @Override // nz.b
    public String k0() {
        return this.J;
    }

    @Override // nz.b
    public void l6(stDramaFeed stdramafeed) {
        d dVar = this.H;
        if (dVar != null) {
            dVar.x3(stdramafeed);
        }
    }

    @Override // rz.b, rz.a
    public void onPagePause() {
        super.onPagePause();
        this.f80664m.clearAnimation();
    }

    @Override // rz.b
    protected int q() {
        return R.layout.fw9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        d0(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z() {
        d0(0);
        int p16 = this.G.p() + 1;
        if (p16 > this.G.getItemCount() - 1) {
            return;
        }
        b0((mz.d) this.G.getItem(p16), p16);
    }

    protected void P() {
        this.f80664m = (LottieAnimationView) m(R.id.ulq);
        this.C = (TextView) m(R.id.ulz);
        this.D = (RecyclerView) m(R.id.ulr);
        this.E = (RecyclerView) m(R.id.ulp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements lz.b<nz.f> {
        b() {
        }

        @Override // lz.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void l(nz.f fVar, int i3) {
            WSDramaMiddlePart.this.d0(1);
            tz.a.n(fVar, WSDramaMiddlePart.this.F(), WSDramaMiddlePart.this.getFrom());
            WSDramaMiddlePart.this.W();
            WSDramaMiddlePart.this.c0(fVar, i3);
            x.j("WSDramaMiddlePartnel-log", "[WSDramaMiddlePart.java][episodeChecked] mDramaId:" + WSDramaMiddlePart.this.J);
            WSDramaMiddlePart.this.U(false, fVar.a(), fVar.b());
            WSDramaMiddlePart.this.D.getLayoutManager().smoothScrollToPosition(WSDramaMiddlePart.this.D, new RecyclerView.State(), i3);
        }

        @Override // lz.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(nz.f fVar, int i3) {
        }
    }

    @Override // nz.b
    public void O0(int i3, String str) {
    }
}
