package com.qzone.reborn.feedx.itemview;

import android.content.Context;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import gf.r;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneBaseVideoFeedItemView extends QZoneBaseFeedItemView implements r {
    public QZoneBaseVideoFeedItemView(Context context) {
        super(context);
    }

    @Override // gf.r
    public void a() {
        Iterator<vg.a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            vg.c cVar = (vg.a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).a();
            }
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        Iterator<vg.a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            vg.c cVar = (vg.a) it.next();
            if (cVar instanceof r) {
                return ((r) cVar).d();
            }
        }
        return null;
    }

    @Override // gf.r
    public void pause() {
        Iterator<vg.a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            vg.c cVar = (vg.a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).pause();
            }
        }
    }

    @Override // gf.r
    public void play() {
        Iterator<vg.a> it = this.f54810e.g().iterator();
        while (it.hasNext()) {
            vg.c cVar = (vg.a) it.next();
            if (cVar instanceof r) {
                ((r) cVar).play();
            }
        }
    }
}
