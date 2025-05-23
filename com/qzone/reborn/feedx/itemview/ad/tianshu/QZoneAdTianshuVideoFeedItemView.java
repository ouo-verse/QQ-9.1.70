package com.qzone.reborn.feedx.itemview.ad.tianshu;

import android.content.Context;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import gf.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import og.e;
import vg.a;
import vg.b;
import vg.c;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0001\fB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0016\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0005H\u0014J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuVideoFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuBaseFeedItemView;", "Lgf/r;", "", "getLogTag", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "", "play", "pause", "a", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "d", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdTianshuVideoFeedItemView extends QZoneAdTianshuBaseFeedItemView implements r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdTianshuVideoFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
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
        return "QZoneAdTianshuVideoFeedItemView";
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
    @Override // com.qzone.reborn.feedx.itemview.ad.tianshu.QZoneAdTianshuBaseFeedItemView, com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        List<Class<? extends a>> s06 = super.s0();
        s06.add(e.class);
        return s06;
    }
}
