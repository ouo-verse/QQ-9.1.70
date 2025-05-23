package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.teenmode.WSTeenModePart;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi.x;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class WSVerticalForAioRedPresenter extends WSVerticalForRecommendPresenter {
    public WSVerticalForAioRedPresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    private void n2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return;
        }
        O0.n2(WSPublicAccReport.SOP_NAME_VIDEO_PLAY);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public HashSet<rz.a> C(QBaseActivity qBaseActivity) {
        HashSet<rz.a> hashSet = new HashSet<>();
        hashSet.add(new WSTeenModePart(qBaseActivity, com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0().getFrom())));
        return hashSet;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean N1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void V0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        super.V0(list, z16, z17, obj);
        if (z17 && x.e()) {
            wz.b.b().a(new WSUserAuthEvent());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected String W1() {
        WSRedDotPushMsg z16 = bb.z();
        if (z16 == null) {
            return "";
        }
        return z16.mFeedIds;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected Map<String, Integer> X1() {
        return Collections.emptyMap();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        super.b(wSSimpleBaseEvent);
        if (wSSimpleBaseEvent instanceof WSUserAuthEvent) {
            n2();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.c
    public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        D1(list, z17, z16, com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.p(list));
        super.d0(list, z16, z17, obj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void doOnPause() {
        super.doOnPause();
        i2();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter
    protected int k2() {
        return 2;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean u1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean v1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(final boolean z16, final boolean z17, String str) {
        if (O0() == null) {
            return false;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForAioRedPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                WSVerticalDataManager.j().h(z17, WSVerticalForAioRedPresenter.this);
                WSVerticalDataManager.j().g(new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(WSVerticalForAioRedPresenter.this.k2(), z16, z17).m(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.h()), WSVerticalForAioRedPresenter.this);
            }
        });
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean d2(boolean z16) {
        return z16 && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().J();
    }
}
