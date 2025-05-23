package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends a {
    private static final int U = ScreenUtil.dip2px(63.0f);
    private String R;
    private String S;
    private final com.tencent.biz.pubaccount.weishi.verticalvideo.data.b T;

    public g(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
        this.T = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.b();
    }

    private Map<String, String> d2() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("collection_id", this.R);
        hashMap.put("ref_feedid", f2());
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j D0 = D0();
        if (D0 != null && D0.e() != null) {
            if (com.tencent.biz.pubaccount.weishi.util.r.r(D0.e().poster.followStatus)) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("focus_status", str);
        }
        stCollection i3 = com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.i(J0(0));
        if (i3 == null) {
            return hashMap;
        }
        hashMap.put("collection_id", i3.cid);
        hashMap.put("collection_type", String.valueOf(i3.collectionType));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public void C1(List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> list, boolean z16, boolean z17, Object obj) {
        int g26;
        super.C1(list, z16, z17, obj);
        if (!z17 || (g26 = g2(this.S, B0())) == -1 || O0() == null || O0().x() == null) {
            return;
        }
        O0().x().scrollToPosition(g26);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        return null;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean N1() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public Map<String, String> U1(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        Map<String, String> U1 = super.U1(jVar);
        U1.put("cover_feedid", jVar.e().f25129id);
        return U1;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public String W1() {
        if (O0() == null || O0().getAdapter() == null || B0().getItem(0) == null) {
            return "";
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item = O0().getAdapter().getItem(0);
        if (item.b() == null) {
            return "";
        }
        return item.b().name;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public boolean a2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.b bVar = this.T;
        return bVar == null || bVar.f81968c;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a
    public boolean b2() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.b bVar = this.T;
        return bVar == null || bVar.f81967b;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void c() {
        super.c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public int c0() {
        return U;
    }

    public String f2() {
        return this.S;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public Map<String, String> h0() {
        Map<String, String> h06 = super.h0();
        h06.putAll(d2());
        return h06;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.a, com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void handleIntent(Bundle bundle) {
        super.handleIntent(bundle);
        if (bundle == null) {
            return;
        }
        this.R = bundle.getString("key_collection_id", "");
        this.S = bundle.getString("key_feed_id", "");
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    public boolean y0(boolean z16, boolean z17, String str) {
        String e26 = e2(B0().getItemCount() - 1);
        if (TextUtils.isEmpty(this.R)) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.c cVar = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.c();
        cVar.f81980d = z16;
        cVar.f81979c = z17;
        cVar.f81983g = 0;
        cVar.f81981e = this.R;
        cVar.f81982f = e26;
        return this.T.a(cVar, this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter
    protected boolean z0(String str) {
        String e26 = e2(0);
        if (TextUtils.isEmpty(this.R)) {
            return false;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.c cVar = new com.tencent.biz.pubaccount.weishi.verticalvideo.data.c();
        cVar.f81983g = 1;
        cVar.f81981e = this.R;
        cVar.f81979c = false;
        cVar.f81980d = true;
        cVar.f81982f = e26;
        return this.T.a(cVar, this);
    }

    private String e2(int i3) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j item;
        if (i3 >= 0 && B0() != null && (item = B0().getItem(i3)) != null) {
            return item.e().f25129id;
        }
        return this.S;
    }

    private int g2(String str, com.tencent.biz.pubaccount.weishi.verticalvideo.f fVar) {
        List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> dataList;
        stSimpleMetaFeed e16;
        if (str == null || (dataList = fVar.getDataList()) == null) {
            return -1;
        }
        for (int i3 = 0; i3 < dataList.size(); i3++) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = dataList.get(i3);
            if (jVar != null && (e16 = jVar.e()) != null && str.equals(e16.f25129id)) {
                jVar.setChecked(true);
                return i3;
            }
        }
        return -1;
    }
}
