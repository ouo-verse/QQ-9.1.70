package com.qzone.reborn.feedx.itemview.ad.tianshu;

import android.content.Context;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView;
import com.qzone.reborn.feedx.widget.i;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ih.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import og.b;
import og.c;
import vg.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0004H\u0014J\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedx/itemview/ad/tianshu/QZoneAdTianshuBaseFeedItemView;", "Lcom/qzone/reborn/feedx/itemview/QZoneBaseFeedItemView;", "", "getLayoutId", "", "Ljava/lang/Class;", "Lvg/a;", "s0", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "i", "", "n0", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneAdTianshuBaseFeedItemView extends QZoneBaseFeedItemView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneAdTianshuBaseFeedItemView(Context context) {
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
    }

    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView, android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            BusinessFeedData businessFeedData = this.C;
            QZoneAdTianshuFeedData tianshuData = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
            if (tianshuData != null) {
                e.f407623a.k(tianshuData, i.c(this));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.itemview.QZoneBaseFeedItemView
    public List<Class<? extends a>> s0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(b.class);
        arrayList.add(og.a.class);
        arrayList.add(c.class);
        return arrayList;
    }
}
