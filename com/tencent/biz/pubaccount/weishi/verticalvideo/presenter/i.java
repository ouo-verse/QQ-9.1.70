package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.ah;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class i extends AbsWSVerticalForDramaPresenter {
    private Intent V;

    public i(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n2() {
        au L0 = L0();
        WSDramaVideoExposureEvent wSDramaVideoExposureEvent = new WSDramaVideoExposureEvent();
        wSDramaVideoExposureEvent.setCurrentEpisodeNum(o2());
        wSDramaVideoExposureEvent.setFeedInfo(K0((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) L0.f82129f));
        wz.b.b().a(wSDramaVideoExposureEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int o2() {
        au L0 = L0();
        if (L0 == null) {
            return 0;
        }
        return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.m((com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) L0.f82129f);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean A1() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean L() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j a16 = com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.a(kz.c.d().e());
        ArrayList arrayList2 = new ArrayList();
        if (a16 != null) {
            arrayList2.add(a16);
        }
        x.i("WSVerticalForDramaPreviewPresenterLog", "convertIntentFeedList() feed id = " + com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.o(a16) + ", episodeNum = " + com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.m(a16));
        return arrayList2;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalForDramaPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        if (this.V == null) {
            this.V = new Intent();
        }
        this.V.putExtra("current_episode_num", o2());
        this.V.putExtra("key_feed_position", i3);
        this.V.putExtra("key_from", O0.getFrom());
        this.V.putExtra("key_play_scene", O0.getPlayScene());
        O0.qb(8194, this.V);
        n2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean V() {
        WSPlayerManager U0;
        com.tencent.biz.pubaccount.weishi.player.e n06;
        boolean V = super.V();
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null && (U0 = O0.U0()) != null && (n06 = U0.n0()) != null) {
            n06.f81136l = null;
            n06.f81125a = null;
            kz.c.d().j(n06);
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.data.j) L0().f82129f;
            x.f("WSVerticalForDramaPreviewPresenterLog", "[WSVerticalForDramaPreviewPresenter.java][handleOnBackEvent] mCurrentPosition:" + this.I + ", title:" + p2(jVar));
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.t(kz.c.d().e(), jVar);
        }
        return V;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalForDramaPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (this.H && O0 != null) {
            x.b("WSVerticalForDramaPreviewPresenterLog", "[WSVerticalForDramaPresenter.java][doOnPause] back to drama page!");
            q2(O0.getAdapter().z());
            com.tencent.biz.pubaccount.weishi.player.b.d().f(false);
            return;
        }
        super.doOnPause();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void l() {
        super.l();
        kz.c.d().j(null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public com.tencent.biz.pubaccount.weishi.player.e w() {
        return kz.c.d().f();
    }

    private String p2(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        if (jVar != null && jVar.e() != null) {
            return jVar.e().feed_desc;
        }
        return "";
    }

    private void q2(au auVar) {
        if (auVar != null) {
            Object obj = auVar.f82127d;
            if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b bVar = (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj;
                if (bVar.i() instanceof ah) {
                    ((ah) bVar.i()).w(0, 100);
                }
            }
        }
    }
}
