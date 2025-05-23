package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.a;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends AbsWSVerticalPagePresenter {
    private static final int T = ScreenUtil.dip2px(42.0f);
    private List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> P;
    private stSimpleMetaFeed Q;
    private String R;
    private boolean S;

    public e(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
        this.P = new ArrayList();
    }

    private String V1(Object obj) {
        if (obj instanceof a.b) {
            return ((a.b) obj).f81960b;
        }
        return "";
    }

    private boolean X1(Object obj) {
        if (obj instanceof a.b) {
            a.b bVar = (a.b) obj;
            r1 = !TextUtils.isEmpty(this.R) && TextUtils.equals(bVar.f81959a, this.R);
            x.j("WSVerticalForArkCardPresenter", "[isIntentFeedVideoInvalid] isInvalid:" + r1 + ", mIntentFeedId:" + this.R + ", params.mFeedId:" + bVar.f81959a);
        }
        return r1;
    }

    private void Z1(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        if (hVar instanceof WSVerticalPageFragment) {
            ((WSVerticalPageFragment) hVar).vi();
        }
    }

    private void b2(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        au z16;
        stSimpleMetaFeed e16;
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (jVar == null || O0 == null || (adapter = O0.getAdapter()) == null || (z16 = adapter.z()) == null) {
            return;
        }
        x.f("terry_ark", "WSVerticalForArkCardPresenter onSuccess getItemCount: " + adapter.getItemCount());
        Object obj = z16.f82127d;
        if (obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) {
            ((com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj).o(jVar);
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item = adapter.getItem(0);
        if (item == null || (e16 = jVar.e()) == null) {
            return;
        }
        stFloatingLayerCardStyle stfloatinglayercardstyle = e16.floatingLayerCardStyle;
        if (stfloatinglayercardstyle != null) {
            stfloatinglayercardstyle.cardType = 3;
        }
        item.p(e16);
        com.tencent.biz.pubaccount.weishi.player.e eVar = z16.f82114h;
        if (eVar != null) {
            eVar.f81127c = x10.a.a(e16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public HashSet<rz.a> C(QBaseActivity qBaseActivity) {
        HashSet<rz.a> hashSet = new HashSet<>();
        hashSet.add(new WSTeenModePart(qBaseActivity, com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0().getFrom())));
        return hashSet;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean O1(boolean z16, boolean z17, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, Object obj) {
        if (X1(obj)) {
            return false;
        }
        return W1(z17, list);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        x.f("WSVerticalForArkCardPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + i3);
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        E1(viewHolder, i3);
        T1(i3, O0);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void c() {
        super.c();
        ry.a.g();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int c0() {
        return T;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.c
    public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        if (z17) {
            boolean X1 = X1(obj);
            this.S = X1;
            if (X1) {
                super.d0(list, z16, true, obj);
                a2(O0, V1(obj));
                return;
            }
        }
        if (W1(z17, list)) {
            super.d0(list, z16, true, obj);
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j U1 = z17 ? U1(list) : null;
        super.d0(list, z16, z17, obj);
        b2(U1);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        super.doOnPause();
        if (com.tencent.biz.pubaccount.weishi.config.experiment.b.h().N()) {
            ry.a.h(M0(), com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0().getFrom()) + "-" + O0().getFrom());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void s0() {
        super.s0();
        stSimpleMetaFeed stsimplemetafeed = this.Q;
        if (stsimplemetafeed != null) {
            yz.i.f451583a.n(new yz.c(stsimplemetafeed.poster_id));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean u1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean v1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void y(BaseViewHolder<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> baseViewHolder, int i3) {
        super.y(baseViewHolder, i3);
        if (i3 == 1 && this.S) {
            Z1(O0());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean z16, boolean z17, String str) {
        x.f("terry_ark", "WSVerticalForArkCardPresenter fetchFeedData isRefresh: " + z16 + " isFirst = " + z17 + " from = " + str);
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null || this.Q == null) {
            return false;
        }
        if (z17) {
            this.P = O0.T9();
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.a.e().b(this.Q.poster_id, 10007, z16, z17, this.P, this);
        return true;
    }

    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.j U1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        stSimpleMetaFeed e16;
        for (int i3 = 0; i3 < list.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = list.get(i3);
            if (jVar != null && (e16 = jVar.e()) != null && !TextUtils.isEmpty(e16.f25129id) && e16.f25129id.equals(this.R)) {
                return list.remove(i3);
            }
        }
        return null;
    }

    private boolean Y1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = list.get(0);
        if (jVar == null || this.Q == null || !(jVar.e() instanceof stSimpleMetaFeed)) {
            return false;
        }
        stSimpleMetaFeed e16 = jVar.e();
        boolean equals = TextUtils.equals(e16.video_url, this.Q.video_url);
        x.f("WSVerticalForArkCardPresenter", "[isSameUrlForArkAndFirstFeed] isSame:" + equals + ", intentUrl:" + this.Q.video_url + ", firstUrl:" + e16.video_url);
        return equals;
    }

    private boolean W1(boolean z16, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list) {
        if (!z16 || Y1(list)) {
            return false;
        }
        return z1();
    }

    private void a2(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar, String str) {
        if (hVar == null || hVar.isFinishing() || TextUtils.isEmpty(str)) {
            return;
        }
        QQToast makeText = QQToast.makeText(BaseApplication.getContext(), str, 1);
        makeText.setType(4);
        makeText.setToastIcon(QQToast.getIconRes(4));
        makeText.show();
        x.j("WSVerticalForArkCardPresenter", "[WSVerticalForArkCardPresenter.java][showToast] toastTips:" + str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.get(0) instanceof stSimpleMetaFeed) {
                stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) arrayList.get(0);
                this.Q = stsimplemetafeed;
                this.R = stsimplemetafeed.f25129id;
            }
            return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.d(arrayList);
        }
        return Collections.emptyList();
    }

    private void T1(int i3, com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        if (i3 == 1 && this.S && (adapter = hVar.getAdapter()) != null) {
            this.S = false;
            adapter.removeItem((com.tencent.biz.pubaccount.weishi.verticalvideo.f) adapter.getDataList().get(0));
        }
    }
}
