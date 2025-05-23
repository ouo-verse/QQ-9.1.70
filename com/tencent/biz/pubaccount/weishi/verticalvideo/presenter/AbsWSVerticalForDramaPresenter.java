package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes32.dex */
public abstract class AbsWSVerticalForDramaPresenter extends a {
    private String R;
    protected String S;
    protected String T;
    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.f U;

    /* loaded from: classes32.dex */
    public @interface WatchRecordReportScene {
    }

    public AbsWSVerticalForDramaPresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
        this.S = "";
        this.T = "";
        this.U = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.f();
    }

    private void d2(com.tencent.biz.pubaccount.weishi.verticalvideo.data.g gVar, String str) {
        WSDramaVideoPlayEvent wSDramaVideoPlayEvent = new WSDramaVideoPlayEvent();
        wSDramaVideoPlayEvent.setDramaId(gVar.a());
        wSDramaVideoPlayEvent.setEpisodeNum(gVar.d());
        wSDramaVideoPlayEvent.setEpisodeId(str);
        wSDramaVideoPlayEvent.setDramaInfo(gVar.b());
        wSDramaVideoPlayEvent.setDramaPreviewPage(false);
        wz.b.b().a(wSDramaVideoPlayEvent);
        x.j("WSVerticalForDramaPresenterLog", "[WSVerticalForDramaPresenter.java][dispatchEventForDramaVideoPlay] event:" + wSDramaVideoPlayEvent);
    }

    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.g e2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || O0.getAdapter() == null || O0.getAdapter().getItemCount() <= 0) {
            return null;
        }
        return O0.getAdapter().getItem(0).d();
    }

    private void h2() {
        if (O0() == null || D0() == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.B(O0().getFrom(), O0().getPlayScene(), D0().e(), h0());
    }

    private void i2(int i3) {
        x.i("WSVerticalForDramaPresenterLog", "reportDramaWatchRecord() scene = " + i3);
        if (this.I < 0 || B0().getDataList() == null || this.I >= B0().getDataList().size()) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item = B0().getItem(this.I);
        kz.k.b(this.S, com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.o(item), com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.m(item), (int) (B0().y().j0() / 1000));
    }

    private void j2(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.g d16;
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter = O0().getAdapter();
        if (adapter == null) {
            return;
        }
        for (int i16 = 0; i16 < adapter.getDataList().size(); i16++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = adapter.getDataList().get(i16);
            if (jVar != null && (d16 = jVar.d()) != null && d16.b() != null) {
                d16.b().dramaInfo.isFollowed = i3 == 1;
            }
        }
    }

    private void k2() {
        VideoFeedsRecyclerView x16;
        if (O0() == null || (x16 = O0().x()) == null) {
            return;
        }
        for (int i3 = 0; i3 < x16.getChildCount(); i3++) {
            RecyclerView.ViewHolder childViewHolder = x16.getChildViewHolder(x16.getChildAt(i3));
            if (childViewHolder instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.f) {
                ((au) childViewHolder).f82127d.e(3);
            }
        }
    }

    private void l2(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        TextView Qc;
        String str;
        if (O0() == null || (Qc = O0().Qc()) == null || jVar == null) {
            return;
        }
        if (jVar.h()) {
            if (this.R == null) {
                this.R = Qc.getContext().getString(R.string.ztf);
            }
            str = this.R;
        } else {
            str = "";
        }
        Qc.setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar;
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.g d16;
        stSimpleMetaFeed e16;
        au L0 = L0();
        if (L0 == null || (jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) L0.f82129f) == null || (d16 = jVar.d()) == null || (e16 = jVar.e()) == null) {
            return;
        }
        d2(d16, e16.f25129id);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        E1(viewHolder, i3);
        l2(D0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public Map<String, String> U1(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        au L0 = L0();
        int i3 = L0 != null ? ((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) L0.f82129f).d().b().dramaInfo.curPublishedFeedNum : -1;
        Map<String, String> U1 = super.U1(jVar);
        U1.put("micro_drama_id", this.S);
        U1.put("micro_drama_num", String.valueOf(i3));
        U1.put("cover_drama_num", String.valueOf(jVar.d().d()));
        U1.put("cover_feedid", jVar.e().f25129id);
        return U1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public String V1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.g e26 = e2();
        if (e26 != null && e26.b() != null) {
            return vz.a.e(BaseApplication.getContext(), e26.b().dramaInfo);
        }
        return "";
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public String W1() {
        if (e2() == null) {
            return "";
        }
        return e2().c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void a0() {
        B0().S(com.tencent.biz.pubaccount.weishi.config.experiment.b.h().E());
        B0().W(true);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public boolean a2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.f fVar = this.U;
        return fVar == null || fVar.f81990b;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        super.b(wSSimpleBaseEvent);
        if (wSSimpleBaseEvent instanceof WSDramaFollowEvent) {
            j2(((WSDramaFollowEvent) wSSimpleBaseEvent).getStatus());
            k2();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public boolean b2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.f fVar = this.U;
        return fVar == null || fVar.f81989a;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        super.d(eVar);
        m2();
        i2(1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        super.doOnPause();
        i2(3);
    }

    public Map<String, String> f2(boolean z16) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("micro_drama_id", this.S);
        hashMap.put("micro_drama_num", com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.m(D0()) + "");
        String str2 = "1";
        if (z16) {
            if (this.J) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("is_clear", str);
        }
        hashMap.put("ref_feedid", g2());
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j D0 = D0();
        if (D0 != null && D0.e() != null) {
            if (!com.tencent.biz.pubaccount.weishi.util.r.r(D0.e().poster.followStatus)) {
                str2 = "2";
            }
            hashMap.put("focus_status", str2);
        }
        return hashMap;
    }

    public String g2() {
        return this.T;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public Map<String, String> h0() {
        Map<String, String> h06 = super.h0();
        h06.putAll(f2(true));
        return h06;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        this.S = bundle.getString("drama_id");
        this.T = bundle.getString("current_episode_id");
        x.i("WSVerticalForDramaPresenterLog", "mIntentDramaId = " + this.S + ", mIntentFeedId = " + this.T);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void j() {
        super.j();
        h2();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean m() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean z16, boolean z17, String str) {
        return this.U.a(new mz.c(z17, z16, this.S, this.T, true), this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean z0(String str) {
        return this.U.a(new mz.c(false, false, this.S, this.T, false), this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public Map<String, String> E() {
        return f2(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        i2(2);
    }
}
