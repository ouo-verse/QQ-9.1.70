package com.qzone.reborn.feedx.itemview.friendplaying;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.R;
import gf.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import vg.a;
import vg.b;
import vg.c;

/* loaded from: classes37.dex */
public class QZoneFriendPlayingBigCardFeedItemView extends QZoneBaseFeedItemView implements r {
    public QZoneFriendPlayingBigCardFeedItemView(Context context) {
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
        return R.layout.f167267c30;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneFriendPlayingBigCardFeedItemView";
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
        arrayList.add(com.qzone.reborn.feedx.presenter.friendplaying.a.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }
}
