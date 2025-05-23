package com.qzone.reborn.feedx.itemview.ad;

import android.content.Context;
import com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedBrokenWindowPresenter;
import com.qzone.reborn.feedx.presenter.ad.QZoneAdGdtFeedVideoPresenter;
import com.qzone.reborn.feedx.presenter.ad.QZoneAdRecommendAdPresenter;
import com.qzone.reborn.feedx.presenter.ad.i;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import gf.r;
import java.util.Iterator;
import java.util.List;
import vg.a;
import vg.b;
import vg.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneAdVideoFeedItemView extends QZoneAdBaseFeedItemView implements r {
    public QZoneAdVideoFeedItemView(Context context) {
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

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneAdVideoFeedItemView";
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.ad.QZoneAdBaseFeedItemView, com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        List<Class<? extends a>> s06 = super.s0();
        s06.add(QZoneAdRecommendAdPresenter.class);
        s06.add(i.class);
        s06.add(QZoneAdGdtFeedVideoPresenter.class);
        s06.add(QZoneAdFeedBrokenWindowPresenter.class);
        return s06;
    }
}
