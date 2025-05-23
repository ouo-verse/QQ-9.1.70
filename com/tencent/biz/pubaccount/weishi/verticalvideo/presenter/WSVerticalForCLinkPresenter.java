package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WSVerticalForCLinkPresenter extends WSVerticalForRecommendPresenter {
    protected long S;

    public WSVerticalForCLinkPresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> o2(boolean z16) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (z16) {
            String q16 = com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.q();
            if (!TextUtils.isEmpty(q16)) {
                arrayList.add(q16);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean B1() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        return O0 != null && O0.D();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public boolean J() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean N1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, jz.c
    public void d0(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        D1(list, z17, z16, com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.p(list));
        super.d0(list, z16, z17, obj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter
    protected int k2() {
        return 15;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(final boolean z16, final boolean z17, String str) {
        if (O0() == null) {
            return false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForCLinkPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                WSVerticalForCLinkPresenter.this.S = System.currentTimeMillis();
                WSVerticalDataManager.j().h(z17, WSVerticalForCLinkPresenter.this);
                WSVerticalDataManager.j().g(new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(WSVerticalForCLinkPresenter.this.k2(), z16, z17).m(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.h()).k(WSVerticalForCLinkPresenter.this.o2(z17)).o(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.k(z17)), WSVerticalForCLinkPresenter.this);
            }
        }, 128, null, true);
        return true;
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
