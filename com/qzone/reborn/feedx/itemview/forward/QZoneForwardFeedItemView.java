package com.qzone.reborn.feedx.itemview.forward;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.itemview.QZoneFeedType;
import com.qzone.reborn.feedx.presenter.QZoneFeedGuideBarContentPresenter;
import com.qzone.reborn.feedx.presenter.aj;
import com.qzone.reborn.feedx.presenter.ao;
import com.qzone.reborn.feedx.presenter.aw;
import com.qzone.reborn.feedx.presenter.bd;
import com.qzone.reborn.feedx.presenter.bk;
import com.qzone.reborn.feedx.presenter.bo;
import com.qzone.reborn.feedx.presenter.ca;
import com.qzone.reborn.feedx.presenter.i;
import com.qzone.reborn.feedx.presenter.s;
import com.qzone.reborn.feedx.presenter.v;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.R;
import gf.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vg.a;
import vg.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneForwardFeedItemView extends QZoneBaseFeedItemView implements r {
    public QZoneForwardFeedItemView(Context context) {
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
        return R.layout.cfc;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected String getLogTag() {
        return "QZoneForwardFeedItemView";
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
        arrayList.add(ca.class);
        arrayList.add(bk.class);
        arrayList.add(s.class);
        int i3 = this.mViewType;
        if (i3 == QZoneFeedType.UNIQUE_TYPE_FORWARD_SINGLE_VIDEO_FEED.mViewType) {
            arrayList.add(bo.class);
        } else if (i3 == QZoneFeedType.UNIQUE_TYPE_FORWARD_MIX_PIC_VIDEO_FEED.mViewType) {
            arrayList.add(aw.class);
        }
        arrayList.add(i.class);
        arrayList.add(bd.class);
        arrayList.add(QZoneFeedGuideBarContentPresenter.class);
        arrayList.addAll(x.f55790a.a(q0()));
        arrayList.add(ao.class);
        arrayList.add(v.class);
        return arrayList;
    }
}
