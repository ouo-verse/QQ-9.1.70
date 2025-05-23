package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.event.WSFriendFeedExposureEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m extends AbsWSVerticalPagePresenter {
    private int P;

    public m(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<a00.b> it = WeiShiCacheManager.O().J().iterator();
        while (it.hasNext()) {
            arrayList2.addAll(it.next().a());
        }
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> c16 = com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.c(arrayList2);
        if (c16 != null) {
            this.P = c16.size();
        }
        return c16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        List<a00.b> J = WeiShiCacheManager.O().J();
        if (O0() != null) {
            int i16 = this.P;
            if (i3 >= i16) {
                i3 = i16 - 1;
            }
            for (int i17 = 0; i17 < J.size(); i17++) {
                a00.b bVar = J.get(i17);
                if (bVar.e() <= i3 && bVar.e() + bVar.d() > i3) {
                    bVar.i(true);
                    wz.b.b().a(new WSFriendFeedExposureEvent(G0(i3), i17));
                    return;
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
        super.destroy();
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.h.c().e();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean z16, boolean z17, String str) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.h.c().b(z17, z16, this);
        return true;
    }
}
