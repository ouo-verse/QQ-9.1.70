package com.qzone.reborn.feedpro.itemview.ad;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView;
import com.qzone.reborn.feedx.widget.i;
import com.tencent.gdtad.util.e;
import com.tencent.gdtad.util.j;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import g6.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.b;
import me.d;
import me.f;
import me.k;
import ne.a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004H\u0014J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\"\u0010\u001a\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/feedpro/itemview/ad/QZoneAdBaseFeedProItemView;", "Lcom/qzone/reborn/feedpro/itemview/QzoneBaseFeedProItemView;", "", "getLayoutId", "", "Ljava/lang/Class;", "Lne/a;", "r0", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "i", "", "n0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "E", "I", "getMPosition", "()I", "setMPosition", "(I)V", "mPosition", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneAdBaseFeedProItemView extends QzoneBaseFeedProItemView {

    /* renamed from: E, reason: from kotlin metadata */
    private int mPosition;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdBaseFeedProItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f129967h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(CommonFeed feedData, int i3) {
        super.bindData(feedData, i3);
        this.mPosition = i3;
    }

    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            c.f401419a.g(i.c(this), v3, xd.c.h(getData()), FeedElement.NOTHING, 1000, this.mPosition, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedpro.itemview.QzoneBaseFeedProItemView
    public List<Class<? extends a>> r0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f.class);
        arrayList.add(b.class);
        arrayList.add(me.a.class);
        arrayList.add(d.class);
        arrayList.add(k.class);
        return arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            e.b(j.f109555a.c(), yd.b.l(xd.c.h(getData())), new j.Location((int) event.getX(), (int) event.getY()));
        } else if (valueOf != null && valueOf.intValue() == 1) {
            e.b(j.f109555a.d(), yd.b.l(xd.c.h(getData())), new j.Location((int) event.getX(), (int) event.getY()));
        }
        return super.dispatchTouchEvent(event);
    }
}
