package com.qzone.reborn.feedx.itemview.ad;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.presenter.ad.QZoneAdFeedTimeLinePresenter;
import com.qzone.reborn.feedx.presenter.ad.b;
import com.qzone.reborn.feedx.presenter.ad.d;
import com.qzone.reborn.feedx.presenter.ad.f;
import com.qzone.reborn.feedx.presenter.ad.m;
import com.qzone.reborn.feedx.presenter.ad.o;
import com.qzone.reborn.feedx.presenter.ad.q;
import com.qzone.reborn.feedx.presenter.ad.s;
import com.qzone.reborn.feedx.presenter.ad.u;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.reborn.feedx.widget.i;
import com.tencent.gdtad.util.e;
import com.tencent.gdtad.util.j;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vg.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004H\u0014J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\"\u0010\u001b\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/QZoneAdBaseFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/QZoneBaseFeedItemView;", "", "getLayoutId", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "i", "", "n0", "z0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "E", "I", "getMPosition", "()I", "setMPosition", "(I)V", "mPosition", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneAdBaseFeedItemView extends QZoneBaseFeedItemView {

    /* renamed from: E, reason: from kotlin metadata */
    private int mPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdBaseFeedItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.cf7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(BusinessFeedData feedData, int i3) {
        super.bindData(feedData, i3);
        this.mPosition = i3;
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
            Activity c16 = i.c(this);
            Intrinsics.checkNotNullExpressionValue(c16, "getActivityFromView(this)");
            BusinessFeedData data = getData();
            Intrinsics.checkNotNullExpressionValue(data, "data");
            qZoneAdFeedUtils.H(c16, v3, data, FeedElement.NOTHING, 1000, this.mPosition, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(u.class);
        arrayList.add(b.class);
        arrayList.add(com.qzone.reborn.feedx.presenter.ad.a.class);
        arrayList.add(s.class);
        arrayList.add(f.class);
        arrayList.add(q.class);
        arrayList.add(QZoneAdFeedTimeLinePresenter.class);
        arrayList.add(d.class);
        arrayList.add(mg.b.class);
        return arrayList;
    }

    public void z0() {
        Object firstOrNull;
        Object firstOrNull2;
        ArrayList<a> g16 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g16, "mPresenterManager.presenterList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : g16) {
            if (obj instanceof o) {
                arrayList.add(obj);
            }
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        o oVar = (o) firstOrNull;
        if (oVar != null) {
            oVar.Q();
        }
        ArrayList<a> g17 = this.f54810e.g();
        Intrinsics.checkNotNullExpressionValue(g17, "mPresenterManager.presenterList");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : g17) {
            if (obj2 instanceof m) {
                arrayList2.add(obj2);
            }
        }
        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        m mVar = (m) firstOrNull2;
        if (mVar != null) {
            mVar.r0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            e.b(j.f109555a.c(), QZoneAdFeedDataExtKt.getTraceId(getData()), new j.Location((int) event.getX(), (int) event.getY()));
        } else if (valueOf != null && valueOf.intValue() == 1) {
            e.b(j.f109555a.d(), QZoneAdFeedDataExtKt.getTraceId(getData()), new j.Location((int) event.getX(), (int) event.getY()));
        }
        return super.dispatchTouchEvent(event);
    }
}
