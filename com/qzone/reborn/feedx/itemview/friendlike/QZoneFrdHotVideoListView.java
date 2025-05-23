package com.qzone.reborn.feedx.itemview.friendlike;

import android.content.Context;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.QZoneFeedFrdHotVideoListPresenter;
import com.qzone.reborn.feedx.presenter.y;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import gf.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u000fB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\tH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoListView;", "Lcom/qzone/reborn/feedx/itemview/QZoneBaseFeedItemView;", "Lgf/r;", "", "getLayoutId", "", "getLogTag", "", "z0", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "play", "pause", "a", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "d", "", "v0", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFrdHotVideoListView extends QZoneBaseFeedItemView implements r {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFrdHotVideoListView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        VideoReport.setPageId(this, "pg_discover_feeds_page");
    }

    @Override // gf.r
    public void a() {
        ArrayList<vg.a> g16 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mPresenterManager.presenterList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (obj instanceof r) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a();
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        Object firstOrNull;
        ArrayList<vg.a> g16 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mPresenterManager.presenterList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (obj instanceof r) {
                arrayList.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        r rVar = (r) firstOrNull;
        if (rVar != null) {
            return rVar.d();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cfe;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    /* renamed from: getLogTag */
    protected String getTAG() {
        return "QZoneFrdHotVideoListView";
    }

    @Override // gf.r
    public void pause() {
        ArrayList<vg.a> g16 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mPresenterManager.presenterList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (obj instanceof r) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((r) it.next()).pause();
        }
    }

    @Override // gf.r
    public void play() {
        ArrayList<vg.a> g16 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mPresenterManager.presenterList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (obj instanceof r) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((r) it.next()).play();
        }
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public boolean v0() {
        return false;
    }

    public final void z0() {
        Object firstOrNull;
        ArrayList<vg.a> g16 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mPresenterManager.presenterList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (obj instanceof QZoneFeedFrdHotVideoListPresenter) {
                arrayList.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        QZoneFeedFrdHotVideoListPresenter qZoneFeedFrdHotVideoListPresenter = (QZoneFeedFrdHotVideoListPresenter) firstOrNull;
        if (qZoneFeedFrdHotVideoListPresenter != null) {
            qZoneFeedFrdHotVideoListPresenter.J();
        }
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    protected List<Class<? extends vg.a>> s0() {
        List<Class<? extends vg.a>> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(y.class, QZoneFeedFrdHotVideoListPresenter.class);
        return mutableListOf;
    }
}
