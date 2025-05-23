package com.qzone.reborn.feedx.itemview.qcircleshare;

import android.content.Context;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bk;
import com.qzone.reborn.feedx.presenter.bo;
import com.qzone.reborn.feedx.presenter.bu;
import com.qzone.reborn.feedx.presenter.ca;
import com.qzone.reborn.feedx.presenter.i;
import com.qzone.reborn.feedx.presenter.v;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.R;
import gf.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vg.a;
import vg.b;
import vg.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneQCircleShareFeedSingleVideoItemView extends QZoneBaseFeedItemView implements r {
    public QZoneQCircleShareFeedSingleVideoItemView(Context context) {
        super(context);
    }

    @Override // gf.r
    public void a() {
        b bVar = this.f54810e;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).a();
            }
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        b bVar = this.f54810e;
        if (bVar != null && bVar.g() != null) {
            Iterator<a> it = this.f54810e.g().iterator();
            while (it.hasNext()) {
                c cVar = (a) it.next();
                if (cVar instanceof r) {
                    return ((r) cVar).d();
                }
            }
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfa;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneQCircleShareFeedSingleVideoItemView";
    }

    @Override // gf.r
    public void pause() {
        b bVar = this.f54810e;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).pause();
            }
        }
    }

    @Override // gf.r
    public void play() {
        b bVar = this.f54810e;
        if (bVar == null || bVar.g() == null) {
            return;
        }
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).play();
            }
        }
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(aj.class);
        arrayList.add(bu.class);
        arrayList.add(ca.class);
        arrayList.add(bk.class);
        arrayList.add(bo.class);
        arrayList.add(i.class);
        arrayList.add(bd.class);
        arrayList.add(QZoneFeedGuideBarContentPresenter.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        VideoInfo videoInfo = businessFeedData == null ? null : businessFeedData.getVideoInfo();
        if (videoInfo != null) {
            videoInfo.playType = (byte) (videoInfo.playType | 1);
        }
        super.bindData(businessFeedData, i3);
    }
}
