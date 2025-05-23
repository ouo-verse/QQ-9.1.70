package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends AbsWSVerticalForDramaPresenter {
    public h(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void C1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        int n26;
        super.C1(list, z16, z17, obj);
        if (!z17 || (n26 = n2(this.T, B0())) == -1 || O0() == null || O0().x() == null) {
            return;
        }
        O0().x().scrollToPosition(n26);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        return null;
    }

    private int n2(String str, com.tencent.biz.pubaccount.weishi.verticalvideo.f fVar) {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList;
        stSimpleMetaFeed e16;
        if (str == null || (dataList = fVar.getDataList()) == null) {
            return -1;
        }
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = dataList.get(i3);
            if (jVar != null && (e16 = jVar.e()) != null && str.equals(e16.f25129id)) {
                return i3;
            }
        }
        return -1;
    }
}
