package com.qzone.reborn.feedx.itemview.normal;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.aw;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bk;
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
import jo.h;
import vg.a;
import vg.c;

/* loaded from: classes37.dex */
public class QZoneMixPicVideoFeedItemView extends QZoneBaseFeedItemView implements r {
    public QZoneMixPicVideoFeedItemView(Context context) {
        super(context);
    }

    @Override // gf.r
    public void a() {
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
        Iterator<a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            c cVar = (a) it.next();
            if (cVar instanceof r) {
                return ((r) cVar).d();
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
        return "QZonePicMixVideoFeedItemView";
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public void initView() {
        h hVar = h.f410717a;
        hVar.b("QZonePicMixVideoFeedItemView#initView");
        super.initView();
        hVar.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.widget.QZoneBaseWidgetView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        h hVar = h.f410717a;
        hVar.b("QZonePicMixVideoFeedItemView#onMeasure");
        super.onMeasure(i3, i16);
        hVar.d();
    }

    @Override // gf.r
    public void pause() {
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
        arrayList.add(aw.class);
        arrayList.add(i.class);
        arrayList.add(bd.class);
        arrayList.add(QZoneFeedGuideBarContentPresenter.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }
}
