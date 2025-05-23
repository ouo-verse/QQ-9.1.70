package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stCollection;
import UserGrowth.stDrama;
import UserGrowth.stDramaFall;
import UserGrowth.stDramaInfo;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class WSVerticalForRecommendPresenter extends b {
    public WSVerticalForRecommendPresenter(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    private void m2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.m0(O0.Ec());
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.d(j2(arrayList));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean N1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        x.f("WSVerticalForRecommendPresenter", "WSVerticalForRecommendPresenter onPageSelected: " + i3);
        E1(viewHolder, i3);
        P1(i3, 2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void a0() {
        super.a0();
        m2();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.d
    public void destroy() {
        super.destroy();
        com.tencent.biz.pubaccount.weishi.report.f.d();
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.m0("");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public Map<String, String> h0() {
        stSimpleMetaFeed e16;
        String str;
        stDrama stdrama;
        String str2;
        HashMap hashMap = new HashMap();
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j J0 = J0(this.I);
        if (J0 != null && (e16 = J0.e()) != null) {
            if (com.tencent.biz.pubaccount.weishi.util.r.r(e16.poster.followStatus)) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("focus_status", str);
            stCollection stcollection = e16.collection;
            if (stcollection != null && !TextUtils.isEmpty(stcollection.cid)) {
                hashMap.put("collection_id", stcollection.cid);
                hashMap.put("collection_type", String.valueOf(stcollection.collectionType));
            }
            stDramaFall stdramafall = e16.dramaInfo;
            if (stdramafall != null && (stdrama = stdramafall.dramaInfo) != null) {
                stDramaInfo stdramainfo = stdrama.dramaInfo;
                String str3 = "";
                if (stdramainfo == null) {
                    str2 = "";
                } else {
                    str2 = stdramainfo.f25116id;
                }
                hashMap.put("micro_drama_id", str2);
                if (stdramainfo != null) {
                    str3 = String.valueOf(stdramainfo.curPublishedFeedNum);
                }
                hashMap.put("micro_drama_num", str3);
            }
        }
        return hashMap;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        if (bundle != null) {
            int i3 = bundle.getInt("key_fall_list_index");
            String string = bundle.getString("key_fall_list_feed_id");
            String string2 = bundle.getString("key_page_session");
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l0(i3);
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.k0(string);
            com.tencent.biz.pubaccount.weishi.report.f.l(string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.f adapter;
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList;
        x.j("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] saveFeed and cache");
        if (l2()) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 != null && (adapter = O0.getAdapter()) != null && (dataList = adapter.getDataList()) != null && dataList.size() > 0) {
            stSimpleMetaFeed M0 = M0();
            List<stSimpleMetaFeed> g16 = com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.g(dataList);
            g16.remove(M0);
            WeiShiCacheManager.O().q(g16, M0, g16.size(), com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(O0().getFrom()));
            return;
        }
        x.i("WSVerticalForRecommendPresenter", "[doOnPause][cacheRecommendFeed] view == null");
    }

    protected int k2() {
        return 2;
    }

    protected boolean l2() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void s0() {
        String Ec;
        super.s0();
        com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            Ec = "";
        } else {
            Ec = O0.Ec();
        }
        yz.i.f451583a.n(new yz.h(k2(), Ec));
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(final boolean z16, final boolean z17, String str) {
        final com.tencent.biz.pubaccount.weishi.verticalvideo.h O0 = O0();
        if (O0 == null) {
            return false;
        }
        if (z17) {
            q10.a aVar = q10.a.f428181a;
            if (aVar.b(str)) {
                aVar.c(this);
                return true;
            }
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.WSVerticalForRecommendPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                WSVerticalDataManager.j().g(new com.tencent.biz.pubaccount.weishi.verticalvideo.data.k(WSVerticalForRecommendPresenter.this.k2(), z16, z17).n(O0.Ec()).k(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.j(z17, O0.T9())).o(com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.l(z17, O0.T9())), WSVerticalForRecommendPresenter.this);
            }
        });
        return true;
    }

    private ArrayList j2(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0 && (arrayList.get(0) instanceof stSimpleMetaFeed)) {
            stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) arrayList.get(0);
            ArrayList<stImgReplacement> arrayList2 = stsimplemetafeed.imgReplacements;
            if (arrayList2 != null && arrayList2.size() > 1) {
                stsimplemetafeed.imgReplacements.get(1).img = stsimplemetafeed.imgReplacements.get(0).img;
            }
            ArrayList<stMetaUgcImage> arrayList3 = stsimplemetafeed.images;
            if (arrayList3 != null && arrayList3.size() > 1) {
                stsimplemetafeed.images.get(1).url = stsimplemetafeed.images.get(0).url;
            }
        }
        return arrayList;
    }
}
