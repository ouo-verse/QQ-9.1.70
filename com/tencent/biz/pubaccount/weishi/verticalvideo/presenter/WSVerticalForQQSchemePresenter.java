package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class WSVerticalForQQSchemePresenter extends b {
    private static final int V = ScreenUtil.dip2px(42.0f);
    private stSimpleMetaFeed S;
    private String T;
    private int U;

    public WSVerticalForQQSchemePresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public HashSet<rz.a> C(QBaseActivity qBaseActivity) {
        HashSet<rz.a> hashSet = new HashSet<>();
        hashSet.add(new WSTeenModePart(qBaseActivity, com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0().getFrom())));
        return hashSet;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        x.f("WSVerticalForQQSchemePresenter", "[onPageSelected] currentPosition:" + i3);
        if (O0() == null) {
            return;
        }
        E1(viewHolder, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected String W1() {
        return this.T;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected Map<String, Integer> X1() {
        HashMap hashMap = new HashMap();
        hashMap.put(this.T, Integer.valueOf(this.U));
        return hashMap;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void c() {
        super.c();
        ry.a.g();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int c0() {
        return V;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.c
    public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        D1(list, z17, z16, this.T);
        super.d0(list, z16, true, obj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        super.doOnPause();
        if (com.tencent.biz.pubaccount.weishi.config.experiment.b.h().N()) {
            ry.a.h(M0(), com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0().getFrom()) + "-" + O0().getFrom());
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

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(final boolean z16, final boolean z17, String str) {
        x.f("WSVerticalForQQSchemePresenter", "[fetchFeedData] isRefresh:" + z16 + " isFirst:" + z17 + " from:" + str);
        final com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return false;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForQQSchemePresenter.1
            @Override // java.lang.Runnable
            public void run() {
                WSVerticalDataManager.j().g(new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(14, z16, z17).k(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.j(z17, O0.T9())).o(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.l(z17, O0.T9())), WSVerticalForQQSchemePresenter.this);
            }
        });
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.get(0) instanceof stSimpleMetaFeed) {
                stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) arrayList.get(0);
                this.S = stsimplemetafeed;
                this.T = stsimplemetafeed.f25129id;
                this.U = stsimplemetafeed.video_type;
            }
            return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.d(arrayList);
        }
        return Collections.emptyList();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean O1(boolean z16, boolean z17, List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, Object obj) {
        return z17 && z1();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean d2(boolean z16) {
        return z16 && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().J();
    }
}
