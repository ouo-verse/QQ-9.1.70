package com.tencent.biz.pubaccount.weishi.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class q extends b {
    private String S;
    private int T;

    public q(com.tencent.biz.pubaccount.weishi.verticalvideo.h hVar) {
        super(hVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.AbsWSVerticalPagePresenter, com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public void T0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.T0(viewHolder, i3);
        x.f("WSVerticalForMiniAppPresenter", "WSVerticalForMiniAppPresenter onPageSelected: " + i3);
        E1(viewHolder, i3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected String W1() {
        return this.S;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected Map<String, Integer> X1() {
        HashMap hashMap = new HashMap();
        hashMap.put(this.S, Integer.valueOf(this.T));
        return hashMap;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected int Y1() {
        return 0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean c2() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean d2(boolean z16) {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.presenter.b
    protected boolean e2() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.g
    public List<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> N(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            if (arrayList.get(0) instanceof stSimpleMetaFeed) {
                stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) arrayList.get(0);
                this.S = stsimplemetafeed.f25129id;
                this.T = stsimplemetafeed.video_type;
            }
            return com.tencent.biz.pubaccount.weishi.verticalvideo.data.i.d(arrayList);
        }
        return Collections.emptyList();
    }
}
