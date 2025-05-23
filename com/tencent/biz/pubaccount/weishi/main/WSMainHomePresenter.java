package com.tencent.biz.pubaccount.weishi.main;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi.h;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.app.QBaseFragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WSMainHomePresenter extends WSAbsMainPresenter {
    public WSMainHomePresenter(c cVar) {
        super(cVar);
        getView().Tb(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter
    protected List<QBaseFragment> createFragments() {
        ArrayList arrayList = new ArrayList();
        c view = getView();
        if (view != null) {
            arrayList.add(WSHomeFragment.Ph(view.Ra(), this));
            if (com.tencent.biz.pubaccount.weishi.home.c.j()) {
                arrayList.add(WSRightContainerFragment.qh());
            }
        }
        return arrayList;
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter, com.tencent.biz.pubaccount.weishi.main.b
    public void onRightLeftPageSelected(int i3) {
        h adapter;
        c view = getView();
        if (view == null || (adapter = view.getAdapter()) == null) {
            return;
        }
        WSRightContainerFragment wSRightContainerFragment = (WSRightContainerFragment) adapter.getItem(1);
        List<QBaseFragment> Th = ((WSHomeFragment) adapter.getItem(0)).Th();
        if (Th == null || Th.size() <= 0) {
            return;
        }
        WSVerticalPageFragment wSVerticalPageFragment = (WSVerticalPageFragment) Th.get(1);
        if (i3 == 0) {
            wSVerticalPageFragment.Cb();
            wSRightContainerFragment.sh();
        } else {
            wSVerticalPageFragment.Y0();
            wSRightContainerFragment.rh(view.v6());
            if (!view.v6()) {
                reportAvatarClick(wSVerticalPageFragment, wSVerticalPageFragment.Th());
            }
        }
        view.G9(false);
    }

    @Override // com.tencent.biz.pubaccount.weishi.main.WSAbsMainPresenter, com.tencent.biz.pubaccount.weishi.main.b
    public void handleIntent(Bundle bundle) {
    }
}
